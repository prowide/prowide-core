/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
package com.prowidesoftware.swift.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.WifeException;
import com.prowidesoftware.swift.model.field.CurrencyContainer;
import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.mt.AbstractMT;

/**
 * Utility methods that provide higher level access to {@link SwiftMessage}
 *
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class SwiftMessageUtils {
	private static final Logger log = Logger.getLogger(SwiftMessageUtils.class.getName());
	private final SwiftMessage msg;

	public SwiftMessageUtils() {
		this(null);
	}

	public SwiftMessageUtils(final SwiftMessage m) {
		this.msg = m;
	}

	public List<String> currencyStrings() {
		return SwiftMessageUtils.currencyStrings(msg);
	}

	/**
	 * Mirrors logic on {@link CurrencyContainer#currencyStrings()} including all fields
	 * @param m
	 * @return an empty list if none found
	 */
	public static List<String> currencyStrings(final SwiftMessage m) {
		if (m != null) {
			final SwiftBlock4 b4 = m.getBlock4();
			if (b4 != null && !b4.isEmpty()) {
				final ArrayList<String> curs = new ArrayList<String>();
				for(final Tag t: b4.getTags()) {
					final Field f = t.getField();
					if (f instanceof CurrencyContainer) {
						final CurrencyContainer cc = (CurrencyContainer) f;
						curs.addAll(cc.currencyStrings());
					}
				}
				return curs;
			}
		}
		return Collections.emptyList();
	}

	/**
	 * @see #valueDate(SwiftMessage)
	 */
	public Calendar valueDate() {
		return SwiftMessageUtils.valueDate(msg);
	}

	/**
	 * Iterates through the parameter tags and removes all inner blocks enclosed between
	 * sequences boundary fields 16R and 16S
	 * <br />
	 * This method requires a sequence starting with 16R and ending with 16S, so first
	 * and last tags must be those. Due to this constraint, null, empty and sequences with less 
	 * than 3 tags will be returned without any modification.
	 *
	 * @param sequence a block with a sequence to filter
	 * @return a new block containing all tags that are outside a 16R/S block, the only 16R/S tags returned are the first and last delimiters.
	 * @throws IllegalArgumentException if the starting tag is not 16R or the ending tag is not the matching 16S
	 * @since 7.8.1
	 */
	public static SwiftTagListBlock removeInnerSequences(final SwiftTagListBlock sequence) {
		if (sequence == null || sequence.size() < 3) {
			return sequence;
		}
		final Tag start = sequence.getTag(0);
		final Tag end = sequence.getTag(sequence.size()-1);
		if (!StringUtils.equals("16R", start.getName())) {
				throw new IllegalArgumentException("Starting tag of sequence must be 16R (and was "+start.getName()+")");
		}
		if (!StringUtils.equals("16S", end.getName())) {
			throw new IllegalArgumentException("Ending tag of sequence must be 16S (and was "+end.getName()+")");
		}
		if (!StringUtils.equals(start.getValue(), end.getValue())) {
			throw new IllegalArgumentException("Qualifier of last 16S ("+end.getValue()+") must match the qualifier of the starting ("+start.getValue()+") 16R tag");
		}
		final SwiftTagListBlock result = new SwiftTagListBlock();
		String qualifier = null;
		for (int i=0; i<sequence.getTags().size(); i++) {
			final Tag t = sequence.getTags().get(i);
			if (i > 0 && qualifier == null && StringUtils.equals(t.getName(), "16R")) {
				/*
				 * found sequence start
				 */
				qualifier = t.getValue();
			} else if (qualifier != null && StringUtils.equals(t.getName(), "16S") && StringUtils.equals(t.getValue(), qualifier)) {
				/*
				 * found sequence end
				 */
				qualifier = null;
			} else if (qualifier == null) {
				result.append(t);
			}
		}
		return result;
	}

	/**
	 * Gets the value date of a message.<br /><br />
	 *
	 * The value date is meaningful and defined by the standard only for a subset of message types.
	 * In most of the cases it is contained in the date subfield of field 32A (for example MT103)
	 * or field 30 (for example MT101).<br />
	 *
	 * Notice a lot of messages do not define a value date.<br />
	 *
	 * Also a few define several fields as value date, or the value date can be repeated.
	 * for those messages the first one is returned as follows:<br />
	 * <ul>
	 * <li>For MT450 returns the first value date occurrence of field 32A</li>
	 * <li>For MT455 returns the value date from field 32A (not from 33[C,D])</li>
	 * <li>For MT456 returns the first value date occurrence of field 33D</li>
	 * <li>For MT564 returns the value date from Cash Movements Field 98a with qualifier PAYD (not qualifier VALU)</li>
	 * </ul>
	 *
	 * @param m the message where the value date is to be found
	 * @return found date or <code>null</code> if the message does not defines a value date, or if the defined value date field is not present in the message
	 * @since 7.7
	 */
	public static Calendar valueDate(final SwiftMessage m) {
		if (m != null) {
			final SwiftBlock4 b4 = m.getBlock4();
			if (b4 != null && !b4.isEmpty()) {
				Tag t = null;
				Field f = null;
				if (m.isType(101, 104, 107, 201, 203, 204, 207, 210)) {
					t = b4.getTagByName("30");
				} else if (m.isType(102, 103, 200, 202, 205, 400, 450, 455, 800, 802, 900, 910)) {
					t = b4.getTagByName("32A");
				} else if (m.isType(456)) {
					t = b4.getTagByName("33D");
				} else if (m.isType(513)) {
					final SwiftTagListBlock seq = b4.getSubBlock("ORDRDET");
					if (seq != null) {
						f = seq.getFieldByNumber(98, "SETT");
					}
				} else if (m.isType(514, 515, 518)) {
					final SwiftTagListBlock seq = b4.getSubBlock("CONFDET");
					if (seq != null) {
						f = seq.getFieldByNumber(98, "SETT");
					}
				} else if (m.isType(541, 543, 545, 547)) {
					final SwiftTagListBlock seq = b4.getSubBlock("TRADDET");
					if (seq != null) {
						f = seq.getFieldByNumber(98, "SETT");
					}
				} else if (m.isType(564)) {
					final SwiftTagListBlock seq = b4.getSubBlock("CASHMOVE");
					if (seq != null) {
						f = seq.getFieldByNumber(98, "PAYD");
					}
				} else if (m.isType(566)) {
					final SwiftTagListBlock seq = b4.getSubBlock("CASHMOVE");
					if (seq != null) {
						f = seq.getFieldByNumber(98, "POST");
					}
				} else if (m.isType(730, 768, 769)) {
					t = b4.getTagByName("32D");
				} else if (m.isType(734, 752, 756)) {
					t = b4.getTagByName("33A");
				} else if (m.isType(742, 754)) {
					t = b4.getTagByName("34A");
				}
				if (t != null) {
					f = t.getField();
				}
				if (f != null && f instanceof DateContainer) {
					return ((DateContainer) f).dates().get(0);
				}
			}
		}
		return null;
	}

	/**
	 * Proprietary checksum for message integrity verification.
	 * Please notice this is not the SWIFT trailer CHK field.
	 * @param model
	 * @return always null (this method is not yet implemented)
	 */
	public static String calculateChecksum(final SwiftMessage model) {
		//TODO missing implementation
		return null;
	}

	/**
	 * Split the given message by the field 15, returning the letter option in the field 15 as the key in the map.
	 * @see #splitByField15(SwiftTagListBlock)
	 */
	public static Map<String, SwiftTagListBlock> splitByField15(final SwiftMessage msg) {
		if (msg != null && msg.getBlock4() != null) {
			return splitByField15(msg.getBlock4());
		} else {
			return new HashMap<String, SwiftTagListBlock>();
		}
	}

	/**
	 * Split the given block content by the field 15, returning the letter option in the field 15 as the key in the map
	 *
	 * @param block the content to split
	 * @return a map with letter options as keys, and blocks as value
	 * @since 7.7
	 */
	public static Map<String, SwiftTagListBlock> splitByField15(final SwiftTagListBlock block) {
		final Map<String, SwiftTagListBlock> result = new HashMap<String, SwiftTagListBlock>();
		if (block != null) {
			SwiftTagListBlock currentList = null;
			for (final Tag t : block.getTags()) {
				if (t.getNumber() == 15) {
					final String letter = t.getLetterOption();
					if (letter != null && letter.length() == 1) {
						final SwiftTagListBlock thisList = new SwiftTagListBlock();
						result.put(letter, thisList);
						currentList = thisList;
					}
				}
				if (currentList != null) {
					currentList.append(t);
				}
			}
		}
		return result;
	}

	/**
	 * Helper method to retrieve all sequences starting with 15X where X is the letterOption parameter
	 * @since 7.7
	 * @see #splitByField15(SwiftTagListBlock, String)
	 */
	public static List<SwiftTagListBlock> splitByField15(final SwiftMessage msg, final String letterOption) {
		if (msg != null && msg.getBlock4() != null) {
			return splitByField15(msg.getBlock4(), letterOption);
		} else {
			return Collections.emptyList();
		}
	}

	/**
	 * Helper method to retrieve all sequences starting with 15X where X is the letterOption parameter.
	 * Field 15a is used as a boundary for sequences, so the letter option correspond to a subsequence name.
	 * @param block the content to split into subsequences
	 * @param letterOption a letter option for the field boundary
	 * @return found subsequences or an empty list if field 15 is not found
	 * @since 7.7
	 */
	public static List<SwiftTagListBlock> splitByField15(final SwiftTagListBlock block, final String letterOption) {
		Validate.notNull(letterOption);
		Validate.isTrue(StringUtils.length(letterOption) == 1, "letter option must be only one character");
		final List<SwiftTagListBlock> result = new ArrayList<SwiftTagListBlock>();
		if (block != null) {
			SwiftTagListBlock currentList = null;
			for (final Tag t : block.getTags()) {
				if (t.getNumber() == 15) {
					final String letter = t.getLetterOption();
					if (letter != null && letter.length() == 1) {
						if (letter.equals(letterOption)) {
							final SwiftTagListBlock thisList = new SwiftTagListBlock();
							result.add(thisList);
							currentList = thisList;
						} else {
							currentList = null;
						}
					}
				}
				if (currentList != null) {
					currentList.append(t);
				}
			}
		}
		return result;
	}

	/**
	 * Gets the message reference from field 20 (if present) 
	 * or from field 20C if message category is 5.
	 * @param m the message where the reference is to be found
	 * @return found reference or <code>null</code> if the message does not defines a reference, or if the defined reference field is not present in the message
	 * @since 7.8
	 */
	public static String reference(final SwiftMessage m) {
		if (m != null) {
			final SwiftBlock4 b4 = m.getBlock4();
			if (b4 != null && !b4.isEmpty()) {
				final Tag t = b4.getTagByName("20");
				if (t != null) {
					return t.getValue();
				}
				if (m.getType() != null && m.getType().startsWith("5")) {
					final Field f = b4.getFieldByNumber(20, "SEME");
					if (f != null) {
						return f.getComponent(2);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Joins all the given sequences in one single list.
	 *  
	 * @param sequences the sequences to be joined. Can be <code>null</code> or empty, in which case this method returns {@link SwiftTagListBlock#EMPTY_LIST}
	 * @return a single {@link SwiftTagListBlock} containing all elements in order of each of the given sequences or {@link SwiftTagListBlock#EMPTY_LIST} if sequences is null or empty
	 * @since 7.8
	 */
	public static SwiftTagListBlock join(final List<? extends SwiftTagListBlock> sequences) {
		if (sequences == null || sequences.isEmpty())
			return SwiftTagListBlock.EMPTY_LIST;
		
		
		final SwiftTagListBlock result = new SwiftTagListBlock();
		for (final SwiftTagListBlock b : sequences) {
			result.getTags().addAll(b.getTags());
		}
		return result;
	}
	

	/**
	 * Creates a sequence  and all it's containing parents.
	 * This method is mainly useful for writing test cases. Instead of writing:
	 * <pre><code>
	 * MT535.SequenceB.newInstance(
	 * 		MT535.SequenceB1b.newInstance(
	 * 			MT535.SequenceB1b.newInstance(
	 * 				MT535.SequenceB1b1.newInstance(
	 * 					tags
	 * 				)
	 * 			)
	 * 		)
	 * );
	 * </code></pre>
	 * This method is the same with a much cleaner code literature:
	 * <pre><code>
	 * 	SwiftMessageUtils.createSequenceWithParents(MT535.class, "B1b1", tags);
	 * </code></pre>
	 * 
	 * <em>Note:</em><br>
	 * Using  
	 * <pre><code>
	 * 	SwiftMessageUtils.createSequenceWithParents(MT535.class, "B", tags);
	 * </code></pre>
	 * Is virtually the same as:
	 * <pre><code>
	 * 	MT535.SequenceB.newInstance(tags);
	 * </code></pre>
	 * 
	 * @param mt the MT class for which the sequence is to be created
	 * @param sequenceName name of the sequence
	 * @param tags the content to put in the sequence
	 * @return the SwiftTagListBlock containing all parent sequences, the sequence requested and the contents
	 * @since 7.8
	 */
	public static final SwiftTagListBlock createSubsequenceWithParents(final Class<? extends AbstractMT> mt, final String sequenceName, final Tag ... tags ) {
		log.finer("Create sequence "+sequenceName);
		final SwiftTagListBlock result = new SwiftTagListBlock();
		result.append(tags);
		
		for (int i=sequenceName.length();i>=1;i--) {
			final String sn = StringUtils.substring(sequenceName, 0, i);
			final SwiftTagListBlock newresult = createSequenceSingle(mt, sn, result.asTagArray());
			log.finer(sn+" => "+newresult);
			result.setTags(newresult.getTags());
		}
		return result;
		
	}

	public static SwiftTagListBlock createSequenceSingle(final Class<? extends AbstractMT> mt, final String sequenceName, final Tag... tags) {
		final String cn = mt.getName() + "$Sequence" + sequenceName;
		try {
			final Class<?> subSequenceClass = Class.forName(cn);
			final Method method = subSequenceClass.getMethod("newInstance", Tag[].class);
			return (SwiftTagListBlock) method.invoke(null, new Object[]{tags});
		} catch (Exception e) {
			log.log(Level.WARNING, "Reflection error: mt="+mt.getName()+", sequenceName="+sequenceName+", tags="+tags+" - "+e, e);
			throw new WifeException("Reflection error: mt="+mt.getName()+", sequenceName="+sequenceName+", tags="+tags+" - "+e);
		}
	}
}

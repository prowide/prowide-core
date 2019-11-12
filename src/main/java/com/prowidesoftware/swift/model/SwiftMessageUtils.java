/*
 * Copyright 2006-2018 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prowidesoftware.swift.model;

import com.prowidesoftware.ProwideException;
import com.prowidesoftware.swift.io.writer.SwiftWriter;
import com.prowidesoftware.swift.model.field.CurrencyContainer;
import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.field.Field30T;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.io.StringWriter;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	 * @param m the message instance
	 * @return an empty list if none found
	 */
	public static List<String> currencyStrings(final SwiftMessage m) {
		if (m != null) {
			final SwiftBlock4 b4 = m.getBlock4();
			if (b4 != null && !b4.isEmpty()) {
				final ArrayList<String> curs = new ArrayList<>();
				for(final Tag t: b4.getTags()) {
					final Field f = t.asField();
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
	 * Gets the message value date
	 * @see #valueDate(SwiftMessage)
	 */
	public Calendar valueDate() {
		return SwiftMessageUtils.valueDate(msg);
	}

	/**
	 * Iterates through the parameter tags and removes all inner blocks enclosed between
	 * sequences boundary fields 16R and 16S
	 * <br>
	 * This method requires a sequence starting with 16R and ending with 16S, so first
	 * and last tags must be those. Due to this constraint, null, empty and sequences with less 
	 * than 3 tags will be returned without any modification.
	 *
	 * @param sequence a block with a sequence to filter
	 * @return a new block containing all tags that are outside a 16R/S block, the only 16R/S tags returned are the first and last delimiters.
	 * @throws IllegalArgumentException if the starting tag is not 16R or the ending tag is not the matching 16S
	 * @since 7.8.1
	 */
	public static SwiftTagListBlock removeInnerSequences(final SwiftTagListBlock sequence) throws IllegalArgumentException {
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
			throw new IllegalArgumentException("The qualifier of the starting block "+start+" must match the qualifier of the ending block "+end);
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
	 * Gets the value date of a message.
	 *
	 * <p>The value date is meaningful and defined by the standard only for a subset of message types.
	 * In most of the cases it is contained in the date subfield of field 32A (for example MT103)
	 * or field 30 (for example MT101).
	 *
	 * <p>Notice a lot of messages do not define a value date.
	 *
	 * <p>Also a few define several fields as value date, or the value date can be repeated.
	 * for those messages the first one is returned as follows:<br>
	 * <ul>
	 * <li>For MT450 returns the first value date occurrence of field 32A</li>
	 * <li>For MT455 returns the value date from field 32A (not from 33[C,D])</li>
	 * <li>For MT456 returns the first value date occurrence of field 33D</li>
	 * <li>For MT564 returns the value date from Cash Movements Field 98a with qualifier PAYD (not qualifier VALU)</li>
	 * </ul>
	 *
	 * @param m the message where the value date is to be found
	 * @return found date or null if the message does not defines a value date, or if the defined value date field is not present in the message
	 * @since 7.7
	 */
	public static Calendar valueDate(final SwiftMessage m) {
		if (m != null) {
			final SwiftBlock4 b4 = m.getBlock4();
			if (b4 != null && !b4.isEmpty()) {
				Tag t = null;
				Field f = null;
				if (m.isType(101, 104, 107, 201, 203, 204, 207, 210, 604,605)) {
					t = b4.getTagByName("30");
				} else if (m.isType(102, 103, 200, 202, 205, 400, 450, 455, 800, 802, 900, 910)) {
					t = b4.getTagByName("32A");
				} else if (m.isType(300, 304, 320, 330, 350, 620)) {
					t = b4.getTagByName("30V");
                } else if (m.isType(370)) {
                    final SwiftTagListBlock seq = b4.getSubBlock("NETPOS");
                    if (seq != null) {
                        f = seq.getFieldByNumber(98, "NETT");
                    }
                } else if (m.isType(456)) {
					t = b4.getTagByName("33D");
				} else if (m.isType(502)) {
                    final SwiftTagListBlock seq = b4.getSubBlock("AMT");
                    if (seq != null) {
                        f = seq.getFieldByNumber(98, "VALU");
                    }
                } else if (m.isType(509)) {
                    final SwiftTagListBlock seq = b4.getSubBlock("TRADE");
                    if (seq != null) {
                        f = seq.getFieldByNumber(98, "SETT");
                    }
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
				} else if (m.isType(540, 541, 542, 543, 544, 545, 546, 547, 586)) {
					final SwiftTagListBlock seq = b4.getSubBlock("TRADDET");
					if (seq != null) {
						f = seq.getFieldByNumber(98, "SETT");
					} else {
                        final SwiftTagListBlock seq2 = b4.getSubBlock("AMT");
                        if (seq2 != null) {
                            f = seq2.getFieldByNumber(98, "VALU");
                        }
                    }
				} else if (m.isType(537)) {
                    final SwiftTagListBlock seq = b4.getSubBlock("TRANSDET");
                    if (seq != null) {
                        f = seq.getFieldByNumber(98, "EXSE");
                    }
                } else if (m.isType(548)) {
                    final SwiftTagListBlock seq = b4.getSubBlock("SETTRAN");
                    if (seq != null) {
                        f = seq.getFieldByNumber(70, "SPRO");
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
				} else if (m.isType(942, 950, 970, 972)){
					t = b4.getTagByName("61");
				}
				if (t != null) {
					f = t.asField();
				}
				if (f != null && f instanceof DateContainer) {
					return ((DateContainer) f).dates().get(0);
				}
			}
		}
		return null;
	}

	/**
	 * Gets the trade date of a message.
	 *
	 * <p>The implementation tries first to get the trade date from field 30T (present in many
	 * category 3 messages) and if not found it tries to get the trade date from field 98a::TRAD
	 * (present in many category 5 messages).
	 *
	 * <p>Notice a lot of messages do not define a trade date.
	 *
	 * @param m the message where the value date is to be found
	 * @return found date or null if the message does not defines a trade date, or if the defined trade date field is not present in the message
	 * @since 7.10.4
	 */
	public static Calendar tradeDate(final SwiftMessage m) {
		if (m != null) {
			final SwiftBlock4 b4 = m.getBlock4();
			if (b4 != null && !b4.isEmpty()) {

				Field f = m.getBlock4().getFieldByName(Field30T.NAME);
				if (f == null) {
					f = m.getBlock4().getFieldByNumber(98, "TRAD");
				}
				if (f != null && f instanceof DateContainer) {
					return ((DateContainer) f).dates().get(0);
				}
			}
		}
		return null;
	}

	/**
	 * Proprietary checksum for message integrity verification or duplicates detection.
	 * <p>Please notice <strong>this is not the SWIFT trailer CHK field</strong>.
	 * <p>The implementation computes an MD5 on the complete message in FIN format. The result hash
	 * is a 32 character string, you may consider encoding it with base64 on top to have the same 
	 * information stored in 22 characters.
	 *
	 * @param model the message
	 * @return computed hash or null if errors occurred during computation or the message is null
	 */
	public static String calculateChecksum(final SwiftMessage model) {
		if (model != null) {
			final StringWriter writer = new StringWriter();
			SwiftWriter.writeMessage(model, writer, true);
			final String fin = writer.getBuffer().toString();
			return md5(fin);
		} else {
			return null;
		}
	}

	/**
	 * Proprietary checksum for message text block (block 4) integrity verification or duplicates detection
	 * <p>Please notice <strong>this is not the SWIFT trailer CHK field</strong>.
	 * <p>The implementation computes an MD5 on the complete message in FIN format. The result hash
	 * is a 32 character string, you may consider encoding it with base64 on top to have the same 
	 * information stored in 22 characters.
	 *
	 * @param b4 the message text block
	 * @return computed hash or null if errors occurred during computation or the block is null
	 * @since 7.9.5
	 */
	public static String calculateChecksum(final SwiftBlock4 b4) {
		if (b4 != null) {
			final StringWriter writer = new StringWriter();
			SwiftWriter.writeBlock4(b4, writer);
			final String fin = writer.getBuffer().toString();
			return md5(fin);
		} else {
			return null;
		}
	}
	
	/**
	 * Computes an MD5 hash on the parameter text
	 * @param text the text to hash
	 * @return computed hash or null if exceptions are thrown reading bytes or processing the digest
	 * @since 7.9.5
	 */
	//TODO add base 64 encoding on top when upgraded to Java 8
	private static String md5(final String text) {
		try {
			byte[] bytesOfMessage = text.getBytes(StandardCharsets.UTF_8);
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);

			//Converting the bytes to a Hex string
			StringBuilder buff = new StringBuilder();
			for (byte b : thedigest) {
				String conversion = Integer.toString(b & 0xFF,16);
				while (conversion.length() < 2) {
					conversion = "0" + conversion;
				}
				buff.append(conversion);
			}

			return buff.toString();
		} catch (NoSuchAlgorithmException e) {
			log.log(Level.FINEST, e.getMessage(), e);
		}
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
			return new HashMap<>();
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
		final Map<String, SwiftTagListBlock> result = new HashMap<>();
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
		final List<SwiftTagListBlock> result = new ArrayList<>();
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
	 * Gets the message reference from field 20 (if present) or from field 20C:SEME if message category is 5.
	 * If no Field20 or 20C are found and MUR is present, returns the MUR value (field 108 from block 3).
	 * @param m the message where the reference is to be found
	 * @return found reference or null if the message does not defines a reference, or if the defined reference field is not present in the message
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
				final Tag mur = b4.getTagByName("108");
				if (mur != null) {
					return mur.getValue();
				}
				
			}
		}
		return null;
	}
	
	/**
	 * Gets the message reference
	 * @see #reference(SwiftMessage)
	 * @since 7.8.8
	 */
	public final String reference() {
		return SwiftMessageUtils.reference(msg);
	}

	/**
	 * Joins all the given sequences in one single list.
	 *  
	 * @param sequences the sequences to be joined. Can be null or empty, in which case this method returns {@link SwiftTagListBlock#EMPTY_LIST}
	 * @return a single {@link SwiftTagListBlock} containing all elements in order of each of the given sequences or {@link SwiftTagListBlock#EMPTY_LIST} if sequences is null or empty
	 * @since 7.8
	 */
	public static SwiftTagListBlock join(final List<? extends SwiftTagListBlock> sequences) {
		if (sequences == null || sequences.isEmpty()) {
			return SwiftTagListBlock.EMPTY_LIST;
		}
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
	public static SwiftTagListBlock createSubsequenceWithParents(final Class<? extends AbstractMT> mt, final String sequenceName, final Tag ... tags ) {
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
			String message = "Reflection error: mt="+mt.getName()+", sequenceName="+sequenceName+", tags="+ Arrays.toString(tags) +" - " + e.getMessage();
			log.log(Level.WARNING, message, e);
			throw new ProwideException(message);
		}
	}
	
	/**
	 * Gets the message main amount
	 * @see #money(SwiftMessage)
	 * @since 8.0.1
	 */
	protected Money money() {
		return money(msg);
	}
	
	/**
	 * Gets the message main amount
	 *
	 * <p>The amount is meaningful and defined by the standard only for a subset of message types.
	 * In most of the cases it is contained in the currency and amount subfields of fields 32a 
	 * in payments messages and 19A in securities.
	 *
	 * This implementation is a work in progress and the interpretation of which field is consider
	 * the main amount for each message type may change from time to time adding more cases or 
	 * even changing the used field.
	 * 
	 * @param m a message with some amount field
	 * @return the currency and amount object extracted from the message or null if non is present or cannot be created from its fields
	 * @since 8.0.1
	 */
	/*
	 * Do not use API from MTs and Field classes here to avoid cyclic dependency in code generation.
	 * Keep in sync special case for 104 and 107 with MT104 and MT107 getSequenceC logic.
	 */
	public static Money money(final SwiftMessage m) {
		if (m == null || m.isServiceMessage21()) {
			return null;
		}
		final SwiftBlock4 b4 = m.getBlock4();
		if (b4 == null || b4.isEmpty()) {
			return null;
		}
		if (m.isType(102, 103, 200, 202, 205, 256, 450, 455, 643, 644, 646, 734, 802, 900, 910)) {
			return Money.of(b4.getFieldByName("32A"));
		} else if (m.isType(191, 291, 300, 304, 305, 320, 391, 491, 591, 691, 791, 891, 991, 340, 341, 350, 360, 361, 364, 365, 620, 700, 705, 710, 720, 732, 740, 742, 756)) {
			return Money.of(b4.getFieldByName("32B"));
		} else if (m.isType(321, 370, 508, 509, 535, 536, 537, 540, 541, 542, 543, 544, 545, 546, 547, 548, 558, 559, 569, 574, 575, 576, 578, 586)) {
			return Money.of(b4.getFieldByName("19A"));
		} else if (m.isType(330, 362)) {
			return Money.of(b4.getFieldByName("32H"));
		} else if (m.isType(306, 581, 707, 747)) {
			return Money.of(b4.getFieldByName("34B"));
		} else if (m.isType(380, 381, 505, 564, 566, 567)) {
			return Money.of(b4.getFieldByName("19B"));
		} else if (m.isType(800)) {
			return Money.of(b4.getFieldByName("33B"));
		} else if (m.isType(941)) {
			return Money.of(b4.getFieldByName("62F"));

		} else if (m.isType(600, 601)) {
			return Money.ofAny(b4, "34P", "34R");
		} else if (m.isType(609)) {
			return Money.ofAny(b4, "68B", "68C");
		} else if (m.isType(111, 112, 516, 649) || m.isType(754)) {
			return Money.ofAny(b4, "32A", "32B");
		} else if (m.isType(190, 290, 390, 490, 590, 690, 790, 890, 990)) {
			return Money.ofAny(b4, "32C", "32D");
		} else if (m.isType(730) || m.isType(768)) {
			return Money.ofAny(b4, "32B", "32D");
		} else if (m.isType(400, 410)) {
			return Money.ofAny(b4, "32A", "32B", "32K");
		} else if (m.isType(430)) {
			return Money.ofAny(b4, "33A", "33K", "32A", "32K");
		} else if (m.isType(750)) {
			return Money.ofAny(b4, "34B", "32B");
		} else if (m.isType(752)) {
			return Money.ofAny(b4, "33A", "33B", "32B");
		} else if (m.isType(769)) {
			return Money.ofAny(b4, "32B", "32D", "33B", "34B");
		} else if (m.isType(940, 950, 970)) {
			return Money.ofAny(b4, "62F", "62M");
		} else if (m.isType(101, 201, 203, 204, 207, 210)) {
			return Money.ofSum(b4.getFieldsByName("32B"));
		} else if (m.isType(110, 416, 420, 422, 456)) {
			return Money.ofSum(b4.getFieldsByName("32a"));
		} else if (m.isType(509)) {
			return Money.ofSum(b4.getFieldsByName("19A"));
		} else if (m.isType(112)) {
			return Money.ofSum(b4.getFieldsByName("32A"));
		} else if (m.isType(801)) {
			return Money.ofSum(b4.getFieldsByName("33B"));
		} else if (m.isType(824)) {
			return Money.ofSum(b4.getFieldsByName("68A"));
			
		} else if (m.isType(104, 107)) {
			// we pick field 32B from sequence C
			// find last mandatory tag of mandatory sequence B
			int last59 = b4.indexOfAnyLast("59", "59A");
			if (last59 >= 0) {
				int startIndexOfC = b4.indexOfAnyFirstAfterIndex(last59, "32B");
				if (startIndexOfC >= 0) {
					Tag t = b4.getTags().get(startIndexOfC);
					if (t != null) {
						return Money.of(t.asField());
					}
				}
			}
			
		} else if (m.isType(502, 513)) {
			/*
			 * we pick the first available 19A from the order detail
			 * for MT513 will be only one
			 */
			SwiftTagListBlock seq = b4.getSubBlock("ORDRDET");
			if (seq != null) {
				return Money.of(seq.getFieldByName("19A"));
			}
		
		} else if (m.isType(514, 515, 518)) {
			/*
			 * we pick the first available 19A from the confirmation detail
			 * for 515 and 518 will be only one
			 */
			SwiftTagListBlock seq = b4.getSubBlock("CONFDET");
			if (seq != null) {
				return Money.of(seq.getFieldByName("19A"));
			}
			
		} else if (m.isType(503, 504, 506)) {
			/*
			 * we pick the first available 19B from the summary
			 */
			SwiftTagListBlock seq = b4.getSubBlock("SUMM");
			if (seq != null) {
				return Money.of(seq.getFieldByName("19B"));
			}
			
		} else if (m.isType(527)) {
			/*
			 * we pick the first available 19A from the deal transaction details
			 */
			SwiftTagListBlock seq = b4.getSubBlock("DEALTRAN");
			if (seq != null) {
				return Money.of(seq.getFieldByName("19A"));
			}
		}
		
		return null;
	}

}

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
package com.prowidesoftware.swift.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.UnhandledException;
import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;

/**
 * A message comparator that compares all values from block 1 2 3 and 4.
 * This comparator compares all values in given blocks except session and sequence number (in block1), 
 * <em>NOTE:</em> This comparator is useful to find a message 'almost equal' to another one
 * and is not intended to sort messages, since it does not provide ordering information of any kind.
 * NOTE: when both blocks being compared are null they are considered equals, even when they're actually empty
 * 
 * @author www.prowidesoftware.com
 */
public class AckMessageComparator implements Comparator<SwiftMessage> {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(AckMessageComparator.class.getName());
	/**
	 * Flag to enable different type of EOLs in multi-line values
	 */
	private boolean ignoreEolsInMultiline = false;
	/**
	 * List of tagnames to ignore in comparison.
	 * tagnames will be matched using tag.getName()
	 */
	private List<String> tagnamesToIgnore = new ArrayList<String>();
	
	public int compare(final SwiftMessage m1, final SwiftMessage m2) {
		Validate.notNull(m1);
		Validate.notNull(m2);
		final boolean b1 = compareB1(m1.getBlock1(), m2.getBlock1());
		final boolean b2 = compareB2(m1.getBlock2(), m2.getBlock2());
		final boolean b3 = compareTagListBlock(m1.getBlock3(), m2.getBlock3());
		final boolean b4 = compareTagListBlock(m1.getBlock4(), m2.getBlock4());
		log.fine("b1="+b1+", b2="+b2+", b3="+b3+", b4="+b4);
		return (b1 && b2 && b3 && b4) ? 0 : 1;
	}

	/**
	 * Compares all elements of block2
	 * both blocks null will return true
	 * @param o1
	 * @param o2
	 * @return <code>true</code> if both blocks are null or equal (from ACK point of view) or false in any other case
	 */
	public boolean compareB2(final SwiftBlock2 o1, final SwiftBlock2 o2) {
		if (o1==null && o2==null) {
	        return true;
        }
		if (o1==null||o2==null) {
	        return false;
        }
		if (!o1.getClass().equals(o2.getClass())) {
			return false;
		}
		return StringUtils.equals(o1.getMessagePriority(), o2.getMessagePriority())
			&& StringUtils.equals(o2.getMessageType(), o2.getMessageType());
	}

	/**
	 * Compare all tags in taglist from both given blocks.
	 * 
	 * Tag.equals is used for comparison.
	 * NOTE if both are null this method returns <code>true</code>
	 * 
	 * @param o1 first block to compare
	 * @param o2 second block to compare
	 * @return true if both blocks are equal (from ACK point of view) and false in any other case
	 */
	public boolean compareTagListBlock(final SwiftTagListBlock o1, final SwiftTagListBlock o2) {
		if (o1==null&&o2==null) {
	        return true;
        }
		if (o1==null||o2==null) {
	        return true;
        }
		if (o1.isEmpty() || o2.isEmpty()) {
	        return false;
        }
		if (o1.size() != o2.size()) {
	        return false;
        }

		int count = 0;
		for (int i=0;i<o1.size();i++) {
			final Tag t1 = o1.getTag(i);
			final Tag t2 = o2.getTag(i);
			
			if (tagNameIgnored(t1.getName(), t2.getName())) {
				log.finer("Tag ignored: "+t1.getName()+" - "+t2.getName());
			} else {
				if ( ! (
						StringUtils.equals(t1.getName(), t2.getName()) &&
						valuesAreEqual(t1.getValue(), t2.getValue())
				)
				) {
					count++;
				}
			}
		}
		if (count>0) {
	        return false;
        }
		
		return true;
	}

	
	/**
	 * Compare two tag values considering internal settings.
	 * if {@link #ignoreEolsInMultiline} is true, then multi-line tags are compared line by 
	 * line, ignoring which eol is used in each case. lines are determined by java api readline
	 *  
	 * @param value1
	 * @param value2
	 * @return true if equals accordign to internal settings, false otherwise
	 */
	private boolean valuesAreEqual(final String value1, final String value2) {
		if (value1 == null && value2 == null) {
			return true;
		}
		if (value1 == null || value2 == null) {
			return false;
		}
		// both values are non-null here
		if (this.ignoreEolsInMultiline) {
			final BufferedReader br1 = new BufferedReader(new StringReader(value1));
			final BufferedReader br2 = new BufferedReader(new StringReader(value2));
			
			while (true) {
				try {
					final String l1 = br1.readLine();
					final String l2 = br2.readLine();
					
					if (!StringUtils.equals(l1, l2)) {
						return false;
					}
					if (l1 == null && l2==null) {
						/*
						 * If both end of streams are reached and no differences were 
						 * reported previously then return true
						 */
						return true;
					}
				} catch (final IOException e) {
					throw new UnhandledException(e);
				}
			}
		} else {
			return StringUtils.equals(value1, value2);
		}
	}
	
	private boolean tagNameIgnored(final String name1, final String name2) {
		if ( this.tagnamesToIgnore != null && !this.tagnamesToIgnore.isEmpty()) {
			for (final Iterator<String> it = this.tagnamesToIgnore.iterator() ; it.hasNext() ; ) {
				final String name = (String) it.next();
				if (StringUtils.equals(name, name1) || StringUtils.equals(name, name2)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return true if o1 and o2 are equals in all values except session and sequence number and false in any other case (incluing one of them null)
	 * If both parameters (o1 and o2) are null it returns false, since there is nothing to compare.
	 * 
	 * @param b1 block to compare
	 * @param b2 block to compare
	 * @return true if b1 equals b2 (except mentioned fields) and none is <code>null</code> false in any other case
	 */
	public boolean compareB1(final SwiftBlock1 b1, final SwiftBlock1 b2) {
		if (b1 == null && b2 == null) {
	        return true;
        }
		if (b1 == null || b2 == null) {
	        return false;
        }
		return StringUtils.equals(b1.getApplicationId(), b2.getApplicationId())
			&& StringUtils.equals(b1.getLogicalTerminal(), b2.getLogicalTerminal())
			&& StringUtils.equals(b1.getServiceId(), b2.getServiceId());
			
			
	}

	/**
	 * @return boolean value of ignoreEolsInMultiline property
	 */
	public boolean isIgnoreEolsInMultiline() {
		return ignoreEolsInMultiline;
	}

	/**
	 * @param ignoreEolsInMultiline
	 */
	public void setIgnoreEolsInMultiline(final boolean ignoreEolsInMultiline) {
		this.ignoreEolsInMultiline = ignoreEolsInMultiline;
	}

	/**
	 * @return tags to ignore list
	 */
	public List<String> getTagnamesToIgnore() {
		return tagnamesToIgnore;
	}

	/**
	 * @param tagnamesToIgnore
	 */
	public void setTagnamesToIgnore(final List<String> tagnamesToIgnore) {
		this.tagnamesToIgnore = tagnamesToIgnore;
	}

	/**
	 * @param o tag to add
	 * @return true if tag was added
	 */
	public boolean addTagnameToIgnore(final String o) {
		return tagnamesToIgnore.add(o);
	}

}

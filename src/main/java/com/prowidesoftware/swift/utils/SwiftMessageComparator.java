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
package com.prowidesoftware.swift.utils;

import com.prowidesoftware.ProwideException;
import com.prowidesoftware.swift.model.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * An MT message comparator that compares all values from block 1 2 3, 4 and 5.
 * 
 * <p>By default the messages must be an exact match in order to be considered equal.
 * This can be tailored for example to ignore EOLS in multiline fiels, to ignore
 * header sequence and session numbers or to ignore the trailer block. Specific
 * text block fields can also indicated to be ignore when comparing the messages.
 * 
 * <p>This implementation can be overwritten to add special compare implementations
 * for each of the blocks or to setup the parameters in different ways.
 * 
 * <p>Despite implementing the Comparator interface this class is useful to find a 
 * message 'almost equal' to another one but it is not intended to <strong>sort</strong>
 * messages, since it does not provide ordering information of any kind.
 * 
 * <p>NOTE: when both blocks being compared are null they are considered equals, even when they're actually empty.
 * 
 * @author sebastian
 * @since 7.8.8
 */
public class SwiftMessageComparator implements Comparator<SwiftMessage> {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftMessageComparator.class.getName());
	/**
	 * Flag to enable different type of EOLs in multi-line values
	 */
	protected boolean ignoreEolsInMultiline = false;
	
	protected boolean ignoreHeaderSession = false;
	
	protected boolean ignoreTrailer = false;
	
	/**
	 * List of tagnames to ignore in comparison.
	 * tagnames will be matched using tag.getName()
	 */
	private List<String> tagnamesToIgnore = new ArrayList<>();
	
	/**
	 * Compare the two given messages. Message parameters cannot be null.
	 * 
	 * <p>This implementation calls the specific comparator methods for
	 * blocks 1 and 2, and the generic tag list block comparator for other
	 * blocks
	 *
	 * @see #compareB1(SwiftBlock1, SwiftBlock1)
	 * @see #compareB2(SwiftBlock2, SwiftBlock2)
	 * @see #compareTagListBlock(SwiftTagListBlock, SwiftTagListBlock) 
	 */
	public int compare(final SwiftMessage m1, final SwiftMessage m2) {
		Validate.notNull(m1);
		Validate.notNull(m2);
		final boolean b1 = compareB1(m1.getBlock1(), m2.getBlock1());
		final boolean b2 = compareB2(m1.getBlock2(), m2.getBlock2());
		final boolean b3 = compareTagListBlock(m1.getBlock3(), m2.getBlock3());
		final boolean b4 = compareTagListBlock(m1.getBlock4(), m2.getBlock4());
		final boolean b5 = this.ignoreTrailer || compareTagListBlock(m1.getBlock5(), m2.getBlock5());
		log.finest("b1="+b1+", b2="+b2+", b3="+b3+", b4="+b4+", b5="+b5);
		return (b1 && b2 && b3 && b4 && b5) ? 0 : 1;
	}

	/**
	 * Compares all elements of block2.
	 * <br>
	 * If both blocks null will return <code>true</code> and one null and the other one not null will return <code>false</code>
	 * 
	 * @param o1
	 * @param o2
	 * @return <code>true</code> if both blocks are null or equal (from ACK point of view) or false in any other case
	 */
	public boolean compareB2(final SwiftBlock2 o1, final SwiftBlock2 o2) {
		if (o1==null && o2==null) {
			/*
			 * both are null
			 */
	        return true;
        }
		if (o1==null || o2==null) {
			/*
			 * return false because the other one is not null
			 */
	        return false;
        }
		if (!o1.getClass().equals(o2.getClass())) {
			return false;
		}
		return StringUtils.equals(o1.getValue(), o2.getValue());
	}

	/**
	 * Compare all tags in taglist from both given blocks.
	 * 
	 * <p>This implementation uses {@link Tag#equals(Object)} for fields comparison.
	 * 
	 * <p>NOTE a null or empty block is considered a blank block; then if both are blank this method returns <code>true</code>
	 * and if one of the blocks is blank and the other is not this method returns <code>false</code>
	 * 
	 * @param o1 first block to compare
	 * @param o2 second block to compare
	 * @return true if both blocks are equal (or blank) and false in any other case
	 */
	public boolean compareTagListBlock(final SwiftTagListBlock o1, final SwiftTagListBlock o2) {
		if (isBlank(o1) && isBlank(o2)) {
			/*
			 * both are null or empty
			 */
	        return true;
        }
		if (isBlank(o1) || isBlank(o2)) {
			/*
			 * return false because the other one is not blank
			 */
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
	 * @return true if block is null or empty
	 */
	private static boolean isBlank(final SwiftTagListBlock b) {
		return b == null || b.isEmpty();
	}
	
	/**
	 * Compare two tag values considering internal settings.
	 * if {@link #ignoreEolsInMultiline} is true, then multi-line tags are compared line by 
	 * line, ignoring which eol is used in each case. lines are determined by java api readline
	 *  
	 * @param value1
	 * @param value2
	 * @return true if equals according to internal settings, false otherwise
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
					throw new ProwideException(e);
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
	 * Return true if blocks are equals in all values except session and sequence number and false in any other case (including one of them being null)
	 * If both parameters are null it returns <code>true</code>, since there is nothing to compare.
	 * 
	 * @param b1 block to compare
	 * @param b2 block to compare
	 * @return true if b1 equals b2 (except mentioned fields) and none is null false in any other case
	 */
	public boolean compareB1(final SwiftBlock1 b1, final SwiftBlock1 b2) {
		if (b1 == null && b2 == null) {
	        return true;
        }
		if (b1 == null || b2 == null) {
	        return false;
        }
		boolean session = this.ignoreHeaderSession || StringUtils.equals(b1.getSessionNumber(), b2.getSessionNumber());
		boolean sequence = this.ignoreHeaderSession || StringUtils.equals(b1.getSequenceNumber(), b2.getSequenceNumber());
		return session && sequence &&
			StringUtils.equals(b1.getApplicationId(), b2.getApplicationId()) &&
			StringUtils.equals(b1.getLogicalTerminal(), b2.getLogicalTerminal()) &&
			StringUtils.equals(b1.getServiceId(), b2.getServiceId());
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

	public boolean isIgnoreHeaderSession() {
		return ignoreHeaderSession;
	}

	public void setIgnoreHeaderSession(boolean ignoreHeaderSession) {
		this.ignoreHeaderSession = ignoreHeaderSession;
	}

	public boolean isIgnoreTrailer() {
		return ignoreTrailer;
	}

	public void setIgnoreTrailer(boolean ignoreTrailer) {
		this.ignoreTrailer = ignoreTrailer;
	}
	
}

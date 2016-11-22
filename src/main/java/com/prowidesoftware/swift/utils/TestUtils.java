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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;

/**
 * Utility methods for test cases
 *
 * @author www.prowidesoftware.com
 */
public class TestUtils {


	public static SwiftMessage createMT(final int type) {
		final SwiftMessage result = new SwiftMessage(true);
		final SwiftBlock2Input b2 = new SwiftBlock2Input();
		b2.setMessageType(""+type);
		b2.setInput(true);
		b2.setMessagePriority("N");
		b2.setDeliveryMonitoring("2");
		b2.setObsolescencePeriod("020");
		b2.setReceiverAddress("12345612XXXX");
		result.setBlock2(b2);
		return result;
	}

	/**
	 * create a message of given type, initialize blocks and add in order tags param in block 4
	 *
	 * @deprecated use new MTxxx instead of this
	 */
	@Deprecated
	public static SwiftMessage createMT(final int i, final Tag ... tags ) {
		final com.prowidesoftware.swift.model.SwiftMessage result = createMT(i);
		if (tags != null && tags.length>0) {
			for (final Tag t:tags) {
				result.getBlock4().append(t);
			}
		}
		return result;
	}

	/**
	 * @deprecated use new MTxxx instead of this
	 */
	@Deprecated
	public static SwiftMessage createMT(final int i, final com.prowidesoftware.swift.model.SwiftTagListBlock ... blocks ) {
		final SwiftMessage result = createMT(i);

		if (blocks != null && blocks.length>0) {
			for (final com.prowidesoftware.swift.model.SwiftTagListBlock b:blocks) {
				result.getBlock4().getTags().addAll(b.getTags());
			}
		}
		return result;
	}

	/**
	 * Adds the given tags in the message, surrounded with sequence boundaries for given sequence name.
	 */
	public static SwiftMessage addSeq(final SwiftMessage msg, final String sequenceIdentifier, final Tag ... tags) {
		msg.getBlock4().append(new Tag("16R", sequenceIdentifier));
		if (tags != null && tags.length>0) {
			for (final Tag t:tags) {
				msg.getBlock4().append(t);
			}
		}
		msg.getBlock4().append(new Tag("16S", sequenceIdentifier));
		return msg;
	}

	/**
	 * enclose tags in B4 with the given 16R/S tags.
	 * additional tags, if any, are added right after the first 16R:sequenceIdentifier
	 */
	public static SwiftMessage enclose(final SwiftMessage msg, final String sequenceIdentifier, final Tag ... tags) {
		final List<Tag> block4 = msg.getBlock4().getTags();
		block4.add(0, new Tag("16R", sequenceIdentifier));
		if (tags != null && tags.length>0) {
			for (int i=tags.length-1;i>=0;i--) {
				block4.add(1, tags[i]);
			}
		}
		block4.add(new Tag("16S", sequenceIdentifier));
		return msg;
	}

	public static SwiftMessage createMTwithEmptyTags(final int i, final String ... tags) {
		final SwiftMessage r = createMT(i, (Tag[])null);
		if (tags != null && tags.length>0) {
			for (final String n : tags) {
				r.getBlock4().append(new Tag(n, "ignored"));
			}
		}
		return r;
	}

	public static void setSTP(final SwiftMessage m) {
		if (m.getBlock3() == null) {
			m.addBlock(new SwiftBlock3());
		}
		final SwiftBlock3 b3 = m.getBlock3();
		if (b3.containsTag("119")) {
			b3.getTagByName("119").setValue("STP");
		} else {
			b3.append(new Tag("119", "STP"));
		}
	}
	
	public static void setREMIT(final SwiftMessage m) {
		if (m.getBlock3() == null) {
			m.addBlock(new SwiftBlock3());
		}
		final SwiftBlock3 b3 = m.getBlock3();
		if (b3.containsTag("119")) {
			b3.getTagByName("119").setValue("REMIT");
		} else {
			b3.append(new Tag("119", "REMIT"));
		}
	}

	/**
	 * Returns the array of tags enclosed in 16RS with the given qualifier
	 * @param startEnd16rs qualifier for 16RS tag
	 * @param tags tags to include
	 * @return the created array of tags
	 * @deprecated use directly MTXXX.SequenceX.newInstance(Tag ...)
	 */
	@Deprecated
	public static Tag[] newSeq(final String startEnd16rs, final Tag ... tags ) {
		final ArrayList<Tag> result = new ArrayList<Tag>();
		result.add(new Tag("16R", startEnd16rs));
		if (tags != null && tags.length>0) {
			for (final Tag t : tags) {
				result.add(t);
			}
		}
		result.add(new Tag("16S", startEnd16rs));
		return (Tag[]) result.toArray(new Tag[result.size()]);
	}

	/**
	 * Returns an array of empty value tags enclosed in 16RS with the given qualifier
	 * @param startEnd16rs qualifier for 16RS tag
	 * @param tagnames tag names to create
	 * @return the created array of tag objects
	 */
	public static Tag[] newSeq(final String startEnd16rs, final String ... tagnames ) {
		final ArrayList<Tag> result = new ArrayList<Tag>();
		result.add(new Tag("16R", startEnd16rs));
		if (tagnames != null && tagnames.length>0) {
			for (final String name : tagnames) {
				result.add(new Tag(name, ""));
			}
		}
		result.add(new Tag("16S", startEnd16rs));
		return (Tag[]) result.toArray(new Tag[result.size()]);
	}
	
	/**
	 * Appends block to the block4 of the given message.
	 * @param m the message that will be appended the block
	 * @param block block to append
	 * @throws  java.lang.IllegalArgumentException if m or block is null
	 */
	public static void append(final SwiftMessage m, final SwiftTagListBlock block) {
		Validate.notNull(m, "message must not be null");
		Validate.notNull(block, "block must not be null");
		m.getBlock4().append(block);
	}
	public static void readFile(final String string) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Patches a simple XPath to make it work in XMLUnit asserts 
	 */
	public static String patch(final String xpath) {
		StringBuilder result = new StringBuilder();
		for (String s : StringUtils.split(xpath, "/")) {
			result.append("/*[local-name()='"+ s + "']");
		}
		return result.toString();
	}
}

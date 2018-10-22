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

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility methods for test cases
 *
 * @author www.prowidesoftware.com
 */
public class TestUtils {

	// Suppress default constructor for noninstantiability
	private TestUtils() {
		throw new AssertionError();
	}

	public static SwiftMessage createMT(final int type) {
		final SwiftMessage result = new SwiftMessage(true);
		final SwiftBlock2Input b2 = new SwiftBlock2Input();
		b2.setMessageType(Integer.toString(type));
		b2.setInput(true);
		b2.setMessagePriority("N");
		b2.setDeliveryMonitoring("2");
		b2.setObsolescencePeriod("020");
		b2.setReceiverAddress("12345612XXXX");
		result.setBlock2(b2);
		return result;
	}

	private static final String MTXXXMESSAGE = "Use new MTxxx plus the append methods instead.";

	/**
	 * create a message of given type, initialize blocks and add in order tags param in block 4
	 *
	 * @deprecated use new MTxxx instead of this
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear._2019)
	public static SwiftMessage createMT(final int i, final Tag ... tags ) {
		DeprecationUtils.phase3(TestUtils.class, "createMT(int, Tag...)", MTXXXMESSAGE);
		final SwiftMessage result = createMT(i);
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
	@ProwideDeprecated(phase4=TargetYear._2019)
	public static SwiftMessage createMT(final int i, final SwiftTagListBlock ... blocks ) {
		DeprecationUtils.phase3(TestUtils.class, "createMT(int, SwiftTagListBlock...)", MTXXXMESSAGE);
		final SwiftMessage result = createMT(i);

		if (blocks != null && blocks.length>0) {
			for (final SwiftTagListBlock b:blocks) {
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

	/**
	 * @deprecated use new MTnnn instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear._2019)
	public static SwiftMessage createMTwithEmptyTags(final int i, final String ... tags) {
		DeprecationUtils.phase3(TestUtils.class, "createMTwithEmptyTags(int, String...)", MTXXXMESSAGE);
		final SwiftMessage r = createMT(i, (Tag[])null);
		if (tags != null && tags.length>0) {
			for (final String n : tags) {
				r.getBlock4().append(new Tag(n, "ignored"));
			}
		}
		return r;
	}

	/**
	 * Returns the array of tags enclosed in 16RS with the given qualifier
	 * @param startEnd16rs qualifier for 16RS tag
	 * @param tags tags to include
	 * @return the created array of tags
	 * @deprecated use directly MTXXX.SequenceX.newInstance(Tag ...)
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear._2019)
	public static Tag[] newSeq(final String startEnd16rs, final Tag ... tags ) {
		DeprecationUtils.phase3(TestUtils.class, "newSeq(String, Tag...)", MTXXXMESSAGE);
		final ArrayList<Tag> result = new ArrayList<>();
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
	 * @deprecated use directly MTXXX.SequenceX.newInstance(Tag ...)
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear._2019)
	public static Tag[] newSeq(final String startEnd16rs, final String ... tagnames ) {
		DeprecationUtils.phase3(TestUtils.class, "newSeq(String, String...)", MTXXXMESSAGE);
		final ArrayList<Tag> result = new ArrayList<>();
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

/*
 * Copyright 2006-2023 Prowide
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

import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * Utility methods for test cases
 *
 * @author sebastian
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

    /**
     * Adds the given tags in the message, surrounded with sequence boundaries for given sequence name.
     */
    public static SwiftMessage addSeq(final SwiftMessage msg, final String sequenceIdentifier, final Tag... tags) {
        msg.getBlock4().append(new Tag("16R", sequenceIdentifier));
        if (tags != null && tags.length > 0) {
            for (final Tag t : tags) {
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
    public static SwiftMessage enclose(final SwiftMessage msg, final String sequenceIdentifier, final Tag... tags) {
        final List<Tag> block4 = msg.getBlock4().getTags();
        block4.add(0, new Tag("16R", sequenceIdentifier));
        if (tags != null && tags.length > 0) {
            for (int i = tags.length - 1; i >= 0; i--) {
                block4.add(1, tags[i]);
            }
        }
        block4.add(new Tag("16S", sequenceIdentifier));
        return msg;
    }

    /**
     * Appends block to the block4 of the given message.
     *
     * @param m     the message that will be appended the block
     * @param block block to append
     * @throws java.lang.IllegalArgumentException if m or block is null
     */
    public static void append(final SwiftMessage m, final SwiftTagListBlock block) {
        Objects.requireNonNull(m, "message must not be null");
        Objects.requireNonNull(block, "block must not be null");
        m.getBlock4().append(block);
    }

    /**
     * Patches a simple XPath to make it work in XMLUnit asserts
     */
    public static String patch(final String xpath) {
        StringBuilder result = new StringBuilder();
        for (String s : StringUtils.split(xpath, "/")) {
            String localName = s;
            String predicate = null;
            if (s.indexOf('[') >= 0 && s.indexOf(']') >= 0) {
                // preserve predicate
                predicate = StringUtils.substringBetween(s, "[", "]");
                localName = s.substring(0, s.indexOf('['));
            }
            result.append("/*[local-name()='").append(localName).append("']");
            if (predicate != null) {
                result.append('[').append(predicate).append(']');
            }
        }
        return result.toString();
    }
}

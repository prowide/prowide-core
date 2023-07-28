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

import com.prowidesoftware.ProwideException;
import com.prowidesoftware.swift.model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * An MT message comparator that compares all values from block 1 2 3, 4 and 5.
 *
 * <p>By default the messages must be an exact match in order to be considered equal. This can be tailored for example
 * to ignore EOLS in multiline fields, to ignore header sequence and session numbers or to ignore the trailer block.
 * Specific text block fields can also indicated to be ignore when comparing the messages.
 *
 * <p>This implementation can be overwritten to add special compare implementations for each of the blocks or to
 * setup the parameters in different ways.
 *
 * <p>Despite implementing the Comparator interface this class is useful to find a message 'almost equal' to another
 * one but it is not intended to <strong>sort</strong> messages, since it does not provide ordering information of any
 * kind.
 *
 * <p>NOTE: when both blocks being compared are null they are considered equals, even when they're actually empty.
 *
 * @since 7.8.8
 */
public class SwiftMessageComparator implements Comparator<SwiftMessage> {
    private static final transient java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(SwiftMessageComparator.class.getName());
    /**
     * Flag to enable different type of EOLs in multi-line values
     */
    protected boolean ignoreEolsInMultiline = false;

    protected boolean ignoreHeaderSession = false;

    protected boolean ignoreTrailer = false;

    /**
     * @since 8.0.3
     */
    protected boolean ignoreBlock2OptionalFields = false;

    /**
     * @since 9.1.3
     */
    protected boolean ignoreLT = false;

    /**
     * @since 9.1.3
     */
    protected boolean ignoreLocationFlag = false;

    /**
     * @since 9.1.6
     */
    protected boolean ignoreBlock3 = false;

    /**
     * @since 9.1.6
     */
    protected boolean ignorePriority = false;

    /**
     * List of tagnames to ignore in comparison.
     * tagnames will be matched using tag.getName()
     */
    private List<String> tagnamesToIgnore = new ArrayList<>();

    /**
     * @return true if block is null or empty
     */
    private static boolean isBlank(final SwiftTagListBlock b) {
        return b == null || b.isEmpty();
    }

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
    @Override
    public int compare(final SwiftMessage left, final SwiftMessage right) {
        Objects.requireNonNull(left);
        Objects.requireNonNull(right);
        final boolean b1 = compareB1(left.getBlock1(), right.getBlock1());
        final boolean b2 = compareB2(left.getBlock2(), right.getBlock2());
        final boolean b3 = ignoreBlock3 || compareTagListBlock(left.getBlock3(), right.getBlock3());
        final boolean b4 = compareTagListBlock(left.getBlock4(), right.getBlock4());
        final boolean b5 = this.ignoreTrailer || compareTagListBlock(left.getBlock5(), right.getBlock5());
        log.finest("b1=" + b1 + ", b2=" + b2 + ", b3=" + b3 + ", b4=" + b4 + ", b5=" + b5);
        return b1 && b2 && b3 && b4 && b5 ? 0 : 1;
    }

    /**
     * Return true if blocks are equals in all values but the ones with the ignore flag. Fields that can be ignored
     * are the optional fields, the BIC LT identifier and the BIC location flag.
     * <br>
     * If both blocks null will return <code>true</code> and one null and the other one not null will return <code>false</code>
     *
     * @param left  first block to compare
     * @param right second block to compare
     * @return true if both blocks are equal or null, false otherwise
     */
    public boolean compareB2(final SwiftBlock2 left, final SwiftBlock2 right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (!left.getClass().equals(right.getClass())) {
            return false;
        }
        if (left.isInput() && right.isInput()) {
            return compareB2Input((SwiftBlock2Input) left, (SwiftBlock2Input) right);
        } else if (left.isOutput() && right.isOutput()) {
            return compareB2Output((SwiftBlock2Output) left, (SwiftBlock2Output) right);
        }
        throw new IllegalStateException();
    }

    private boolean compareB2Input(final SwiftBlock2Input left, final SwiftBlock2Input right) {
        boolean sameType = StringUtils.equals(left.getMessageType(), right.getMessageType());
        boolean sameReceiverAddress = compareLTAddress(left.getReceiverAddress(), right.getReceiverAddress());
        boolean sameDeliveryMonitoring = ignoreBlock2OptionalFields
                || StringUtils.equals(left.getDeliveryMonitoring(), right.getDeliveryMonitoring());
        boolean sameObsolescencePeriod = ignoreBlock2OptionalFields
                || StringUtils.equals(left.getObsolescencePeriod(), right.getObsolescencePeriod());
        boolean samePriority =
                ignorePriority || StringUtils.equals(left.getMessagePriority(), right.getMessagePriority());
        return sameType && sameReceiverAddress && sameDeliveryMonitoring && sameObsolescencePeriod && samePriority;
    }

    private boolean compareB2Output(final SwiftBlock2Output left, final SwiftBlock2Output right) {
        boolean sameType = StringUtils.equals(left.getMessageType(), right.getMessageType());
        boolean sameSenderInputTime = StringUtils.equals(left.getSenderInputTime(), right.getSenderInputTime());
        boolean sameMIRDate = StringUtils.equals(left.getMIRDate(), right.getMIRDate());
        boolean sameMIRLogicalTerminal = compareLTAddress(left.getMIRLogicalTerminal(), right.getMIRLogicalTerminal());
        boolean sameMIRSessionNumber = StringUtils.equals(left.getMIRSessionNumber(), right.getMIRSessionNumber());
        boolean sameMIRSequenceNumber = StringUtils.equals(left.getMIRSequenceNumber(), right.getMIRSequenceNumber());
        boolean sameReceiverOutputDate =
                StringUtils.equals(left.getReceiverOutputDate(), right.getReceiverOutputDate());
        boolean sameReceiverOutputTime =
                StringUtils.equals(left.getReceiverOutputTime(), right.getReceiverOutputTime());
        boolean samePriority =
                ignorePriority || StringUtils.equals(left.getMessagePriority(), right.getMessagePriority());
        return sameType
                && sameSenderInputTime
                && sameMIRDate
                && sameMIRLogicalTerminal
                && sameMIRSessionNumber
                && sameMIRSequenceNumber
                && sameReceiverOutputDate
                && sameReceiverOutputTime
                && samePriority;
    }

    /**
     * Compare all tags in taglist from both given blocks.
     *
     * <p>This implementation uses {@link Tag#equals(Object)} for fields comparison.
     *
     * <p>NOTE a null or empty block is considered a blank block; then if both are blank this method returns <code>true</code>
     * and if one of the blocks is blank and the other is not this method returns <code>false</code>
     *
     * @param left  first block to compare
     * @param right second block to compare
     * @return true if both blocks are equal (or blank) and false in any other case
     */
    public boolean compareTagListBlock(final SwiftTagListBlock left, final SwiftTagListBlock right) {
        if (isBlank(left) && isBlank(right)) {
            /*
             * both are null or empty
             */
            return true;
        }
        if (isBlank(left) || isBlank(right)) {
            /*
             * return false because the other one is not blank
             */
            return false;
        }
        if (left.size() != right.size()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < left.size(); i++) {
            final Tag t1 = left.getTag(i);
            final Tag t2 = right.getTag(i);

            if (tagNameIgnored(t1.getName(), t2.getName())) {
                log.finer("Tag ignored: " + t1.getName() + " - " + t2.getName());
            } else {
                if (!(StringUtils.equals(t1.getName(), t2.getName()) && valuesAreEqual(t1.getValue(), t2.getValue()))) {
                    count++;
                }
            }
        }
        return count <= 0;
    }

    /**
     * Compare two tag values considering internal settings.
     * if {@link #ignoreEolsInMultiline} is true, then multi-line tags are compared line by
     * line, ignoring which eol is used in each case. lines are determined by java api readline
     *
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
                    if (l1 == null && l2 == null) {
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
        if (this.tagnamesToIgnore != null) {
            for (final String name : this.tagnamesToIgnore) {
                if (StringUtils.equals(name, name1) || StringUtils.equals(name, name2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Return true if blocks are equals in all values but the ones with the ignore flag. Fields that can be ignored
     * are the session and sequence numbers, the BIC LT identifier and the BIC location flag.
     * If both parameters are null it returns <code>true</code>, since there is nothing to compare.
     *
     * @param left  block to compare
     * @param right block to compare
     * @return true if left equals right (except mentioned fields) or both null, false otherwise
     */
    public boolean compareB1(final SwiftBlock1 left, final SwiftBlock1 right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean sameApplicationId = StringUtils.equals(left.getApplicationId(), right.getApplicationId());
        boolean sameServiceId = StringUtils.equals(left.getServiceId(), right.getServiceId());
        boolean sameSession =
                this.ignoreHeaderSession || StringUtils.equals(left.getSessionNumber(), right.getSessionNumber());
        boolean sameSequence =
                this.ignoreHeaderSession || StringUtils.equals(left.getSequenceNumber(), right.getSequenceNumber());
        boolean sameLTAddress = compareLTAddress(left.getLogicalTerminal(), right.getLogicalTerminal());
        return sameApplicationId && sameServiceId && sameSequence && sameSession && sameLTAddress;
    }

    private boolean compareLTAddress(String logicalTerminalLeft, String logicalTerminalRight) {
        LogicalTerminalAddress leftLTAddress = new LogicalTerminalAddress(logicalTerminalLeft);
        LogicalTerminalAddress rightLTAddress = new LogicalTerminalAddress(logicalTerminalRight);
        String left = String.valueOf(leftLTAddress.getLTIdentifier());
        String right = String.valueOf(rightLTAddress.getLTIdentifier());
        boolean sameLTIdentifier = this.ignoreLT || StringUtils.equals(left, right);
        boolean sameBic11 = compareBic(leftLTAddress, rightLTAddress);
        return sameLTIdentifier && sameBic11;
    }

    private boolean compareBic(BIC left, BIC right) {
        if (this.ignoreLocationFlag) {
            return StringUtils.equals(
                    left.asTestBic().getBic11(), right.asTestBic().getBic11());
        } else {
            return StringUtils.equals(left.getBic11(), right.getBic11());
        }
    }

    /**
     * @return boolean value of ignoreEolsInMultiline property
     * @see #setIgnoreEolsInMultiline(boolean)
     */
    public boolean isIgnoreEolsInMultiline() {
        return ignoreEolsInMultiline;
    }

    /**
     * When this is set to true, different end of lines characters LF or CRLF will be considered the same.
     *
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
     * Sets a new list of tags in the block 4 that will be ignored in the comparison.
     *
     */
    public void setTagnamesToIgnore(final List<String> tagnamesToIgnore) {
        this.tagnamesToIgnore = tagnamesToIgnore;
    }

    /**
     * Adds a tag in the block4 that will be ignore in the comparison.
     *
     * @param tagName tag to add
     * @return true if tag was added
     */
    public boolean addTagnameToIgnore(final String tagName) {
        return tagnamesToIgnore.add(tagName);
    }

    /**
     * @see #setIgnoreHeaderSession(boolean)
     */
    public boolean isIgnoreHeaderSession() {
        return ignoreHeaderSession;
    }

    /**
     * When this is set to true, the block 1 session and sequence numbers will be ignored in the comparison.
     * Defaults to false.
     */
    public void setIgnoreHeaderSession(boolean ignoreHeaderSession) {
        this.ignoreHeaderSession = ignoreHeaderSession;
    }

    /**
     * @see #setIgnoreTrailer(boolean)
     */
    public boolean isIgnoreTrailer() {
        return ignoreTrailer;
    }

    /**
     * When this is set to true, the block 5 will be ignored in the comparison. Defaults to false.
     */
    public void setIgnoreTrailer(boolean ignoreTrailer) {
        this.ignoreTrailer = ignoreTrailer;
    }

    /**
     * @see #setIgnoreBlock2OptionalFields(boolean)
     * @since 8.0.3
     */
    public boolean isIgnoreBlock2OptionalFields() {
        return ignoreBlock2OptionalFields;
    }

    /**
     * When this is set to true, the Delivery Monitoring and Obsolescence Period of block 2 Input will be ignored in the
     * comparison. Meaning different values for this optional fields in the compared blocks will return true as
     * comparison result. Defaults to false.
     *
     * @since 8.0.3
     */
    public void setIgnoreBlock2OptionalFields(boolean ignoreBlock2OptionalFields) {
        this.ignoreBlock2OptionalFields = ignoreBlock2OptionalFields;
    }

    /**
     * @see #setIgnoreLT(boolean)
     * @since 9.1.3
     */
    public boolean isIgnoreLT() {
        return ignoreLT;
    }

    /**
     * If this is set to true, when comparing block 1 and block 2, the Logical Terminal identifier will be ignored in
     * the comparison. Meaning different values for the LT identifier such as FFFFUS33AXXX and FFFFUS33BXXX in the
     * headers of the compared blocks will return true as comparison result. Defaults to false.
     *
     * @since 9.1.3
     */
    public void setIgnoreLT(boolean ignoreLT) {
        this.ignoreLT = ignoreLT;
    }

    /**
     * @see #setIgnoreLocationFlag(boolean)
     * @since 9.1.3
     */
    public boolean isIgnoreLocationFlag() {
        return ignoreLocationFlag;
    }

    /**
     * If this is set to true, when comparing block 1 and block 2, the second digit of the location code (character at
     * 8th position of the logical terminal addresses) will be ignored in the comparison.
     * Meaning for example FFFFUS30AXXX and FFFFUS33AXXX in the headers of the compared blocks will return true as
     * comparison result. Defaults to false.
     *
     * @since 9.1.3
     */
    public void setIgnoreLocationFlag(boolean ignoreLocationFlag) {
        this.ignoreLocationFlag = ignoreLocationFlag;
    }

    /**
     * @see #setIgnoreBlock3(boolean)
     * @since 9.1.6
     */
    public boolean isIgnoreBlock3() {
        return ignoreBlock3;
    }

    /**
     * If this is set to true, the whole block 3 will be ignored in the headers comparison. Meaning a message with a
     * with block 3 will match a message without it. Also messages with different fields or field values in their
     * block 3 will also match. Defaults to false, meaning if block 3 is present in a message all fields in the block
     * must match.
     *
     * @since 9.1.3
     */
    public void setIgnoreBlock3(boolean ignoreBlock3) {
        this.ignoreBlock3 = ignoreBlock3;
    }

    /**
     * @see #setIgnorePriority(boolean)
     * @since 9.1.6
     */
    public boolean isIgnorePriority() {
        return ignorePriority;
    }

    /**
     * If this is set to true, the priority flag in block 2 will be ignored int the comparison. Meaning a message with
     * a normal priority will match a message with an urgent priority and so forth. Any combination of priorities in the
     * messages will still produce a match. Defaults to false, meaning both message must have the same priority.
     *
     * @since 9.1.3
     */
    public void setIgnorePriority(boolean ignorePriority) {
        this.ignorePriority = ignorePriority;
    }
}

/*
 * Copyright 2006-2021 Prowide
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.Validate;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Base class for SWIFT <b>User "ad-hoc" Blocks</b> (blocks with number other than 1-5 or names).<br>
 * <br>
 * The assumption is that these User Defined Blocks are used and defined as tag blocks (meaning
 * that these blocks behave like a block 3 or 5).<br>
 * <br>
 * <b>NOTE:</b> this is not part of SWIFT standard, but seems to be common practice for
 * users to append some locally defined blocks to annotate messages in a semi-compatible
 * way (for example: add block 9 for some local information or block "S" for system reference).<br>
 * <br>
 *
 * @author sebastian
 * @since 5.0
 */
public class SwiftBlockUser extends SwiftTagListBlock implements Serializable {
    private static final long serialVersionUID = -6506492203870561424L;
    private static final String MESSAGE_VALIDATOR = "parameter 'blockNumber' cannot be null";

    /**
     * Indicates the position of this user block in a message when persisted.
     * This value is used to remember the positions of the blocks inside
     * a message when persisted. This value may not be set when persistence
     * is not used and should not be used by clients.
     */
    protected Integer sortKey;

    /**
     * Block name. For integer numbered blocks, this will be the block number
     * converted to string. For other blocks (for example: "S"), this will be
     * the block real identifier and block number (if requested) will be -1.
     *
     * @since 5.0
     */
    protected String blockName;

    /**
     * Default constructor
     *
     * @since 5.0
     */
    public SwiftBlockUser() {
        this.setBlockName("0");
    }

    /**
     * Constructor for empty numbered user block
     *
     * @param blockNumber the block number to initialize
     * @throws IllegalArgumentException if parameter blockNumber is null
     * @throws IllegalArgumentException if parameter blockNumber is not a valid User Defined Block number (values 6..9)
     * @since 5.0
     */
    public SwiftBlockUser(Integer blockNumber) {
        // sanity check
        Validate.notNull(blockNumber, MESSAGE_VALIDATOR);
        Validate.isTrue(SwiftBlockUser.isValidName(blockNumber).booleanValue(), "'blockNumber' is not a valid User Defined Block number");

        this.setBlockNumber(blockNumber);
    }

    /**
     * Constructor for numbered user block with tag initialization
     *
     * @param blockNumber the block number to initialize
     * @param tags        the list of tags to initialize
     * @throws IllegalArgumentException if parameter blockNumber or tags are null
     * @throws IllegalArgumentException if parameter blockNumber is not a valid User Defined Block number (values 6..9)
     * @throws IllegalArgumentException if parameter tags is not composed of Strings
     * @since 5.0
     */
    public SwiftBlockUser(Integer blockNumber, List<Tag> tags) {
        // sanity check
        Validate.notNull(blockNumber, MESSAGE_VALIDATOR);
        Validate.isTrue(SwiftBlockUser.isValidName(blockNumber).booleanValue(), "'blockNumber' is not a valid User Defined Block number");

        this.setBlockNumber(blockNumber);
        this.addTags(tags);
    }

    /**
     * Constructor for named user block
     *
     * @param blockName the block name to initialize
     * @throws IllegalArgumentException if parameter blockName is null
     * @throws IllegalArgumentException if parameter blockName is not a valid User Defined Block name (single letter)
     * @since 5.0
     */
    public SwiftBlockUser(String blockName) {
        // sanity check
        Validate.notNull(blockName, "parameter 'blockName' cannot be null");
        Validate.isTrue(SwiftBlockUser.isValidName(blockName).booleanValue(), "'blockName' is not a valid User Defined Block name");

        this.setBlockName(blockName);
    }

    /**
     * Constructor for named user block with tag initialization
     *
     * @param blockName the block name to initialize
     * @param tags      the list of tags to initialize
     * @throws IllegalArgumentException if parameter blockName or tags are null
     * @throws IllegalArgumentException if parameter blockName is not a valid User Defined Block name (single letter)
     * @throws IllegalArgumentException if parameter tags is not composed of Strings
     * @since 5.0
     */
    public SwiftBlockUser(String blockName, List<Tag> tags) {
        // sanity check
        Validate.notNull(blockName, "parameter 'blockName' cannot be null");
        Validate.isTrue(SwiftBlockUser.isValidName(blockName).booleanValue(), "'blockName' is not a valid User Defined Block name");

        this.setBlockName(blockName);
        this.addTags(tags);
    }

    /**
     * Checks if the block name and are valid for a user defined block.
     *
     * @param blockName   the block name
     * @param blockNumber the block number
     * @return true if the block name and number are valid
     * @since 5.0
     */
    static public Boolean isValidName(String blockName, Integer blockNumber) {
        return Boolean.valueOf(SwiftBlockUser.isValidName(blockName).booleanValue() && SwiftBlockUser.isValidName(blockNumber).booleanValue());
    }

    /**
     * Checks if the block name is valid for a user defined block.
     *
     * @param blockName the block name
     * @return true if the block name and number are valid
     * @since 5.0
     */
    static public Boolean isValidName(String blockName) {
        // name and number must be defined
        if (blockName == null)
            return (Boolean.FALSE);

        // try as a number
        try {
            Integer num = Integer.decode(blockName);
            if (!SwiftBlockUser.isValidName(num).booleanValue())
                return (Boolean.FALSE);
        } catch (NumberFormatException nfe) {
            // do nothing (it was not a number)
        }

        // for named blocks, the name must be only one letter
        if (blockName.length() != 1)
            return (Boolean.FALSE);

        // only upper or lower case letters
        char c = Character.toLowerCase(blockName.charAt(0));
        if (!(('0' <= c && c <= '9') || ('a' <= c && c <= 'z')))
            return (Boolean.FALSE);

        return (Boolean.TRUE);
    }

    /**
     * Checks if the block number is valid for a user defined block.
     * Invalid blocks are blocks null or values 1-5 inclusive, all other values are considered valid.
     *
     * @param blockNumber the block number
     * @return true if the block name and number are valid
     * @since 5.0
     */
    static public Boolean isValidName(Integer blockNumber) {
        // name and number must be defined
        if (blockNumber == null)
            return (Boolean.FALSE);

        // block number must not be 1-5
        if (blockNumber.intValue() != -1) {
            if (1 <= blockNumber.intValue() && blockNumber.intValue() <= 5)
                return (Boolean.FALSE);
        }

        return (Boolean.TRUE);
    }

    /**
     * This method deserializes the JSON data into an user block object.
     *
     * @see #toJson()
     * @since 7.9.8
     */
    public static SwiftBlockUser fromJson(String json) {
        final Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, SwiftBlockUser.class);
    }

    /**
     * Returns the block number (if it can be converted to an integer, -1 otherwise).
     *
     * @return Integer containing the block's name as an integer or -1 if the block name is not numeric
     */
    public Integer getNumber() {
        // assume -1 (not numeric) and try to convert
        Integer blockNumber = new Integer(-1);
        try {
            blockNumber = Integer.decode(blockName);
        } catch (NumberFormatException ignored) {
        }
        return (blockNumber);
    }

    /**
     * @see #getBlockName()
     */
    public String getName() {
        return (this.getBlockName());
    }

    /**
     * The block name.
     *
     * @return the block name
     * @since 5.0
     */
    public String getBlockName() {
        return (this.blockName);
    }

    /**
     * Sets the block name.
     *
     * @param blockName the block name to set
     * @throws IllegalArgumentException if parameter blockName is null
     * @throws IllegalArgumentException if parameter blockName is not a valid User Defined Block name (single letter)
     * @since 5.0
     */
    protected void setBlockName(String blockName) {
        // sanity check
        Validate.notNull(blockName, "parameter 'blockName' cannot be null");
        Validate.isTrue(SwiftBlockUser.isValidName(blockName).booleanValue(), "'" + blockName + "' is not a valid User Defined Block name");

        // store the new name
        this.blockName = blockName;
    }

    /**
     * Sets the block number. This really sets <code>{@link #blockName}</code>
     *
     * @param blockNumber the block number to set
     * @throws IllegalArgumentException if parameter blockNumber is null
     * @throws IllegalArgumentException if parameter blockNumber is not a valid User Defined Block number (values 6..9)
     * @since 5.0
     */
    protected void setBlockNumber(Integer blockNumber) {
        // sanity check
        Validate.notNull(blockNumber, MESSAGE_VALIDATOR);
        Validate.isTrue(SwiftBlockUser.isValidName(blockNumber).booleanValue(), "'" + blockNumber + "' is not a valid User Defined Block number");

        this.blockName = blockNumber != null ? blockNumber.toString() : null;
    }

    /**
     * Checks if the block name (and or number) is valid for a user defined block.
     * The block name is considered valid if its numeric value is other than 1-5 and
     * if its named identification value is a one char string, for example "S".
     *
     * @return true if the block name and number are valid
     * @since 5.0
     */
    protected Boolean isValidName() {
        return (SwiftBlockUser.isValidName(this.getName(), this.getNumber()));
    }

    /**
     * get the sortkey of this user block when persisted
     *
     * @return an integer with the current sortkey
     * @see #sortKey
     */
    public Integer getSortKey() {
        return (sortKey);
    }

    /**
     * Set the sortkey of this user block when persisted.
     * This value may be changed by clients when persistence is used and the order of the user blocks in a message are being modified.
     *
     * @param sortKey the new sortkey
     */
    public void setSortKey(Integer sortKey) {
        this.sortKey = sortKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SwiftBlockUser tags = (SwiftBlockUser) o;
        return Objects.equals(sortKey, tags.sortKey) &&
                Objects.equals(blockName, tags.blockName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sortKey, blockName);
    }
}

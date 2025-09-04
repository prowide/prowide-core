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
package com.prowidesoftware.swift.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.field.Field108;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.Validate;

/**
 * Base class for SWIFT <b>User Header Block (block 3)</b>.
 * <p>This block is optional, and contains special processing instructions.
 *
 * @since 4.0
 */
public class SwiftBlock3 extends SwiftTagListBlock implements Serializable {
    private static final long serialVersionUID = 4377884587811023149L;
    private static final transient java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(SwiftBlock3.class.getName());

    /**
     * Default constructor
     */
    public SwiftBlock3() {}

    /**
     * Constructor with tag initialization
     *
     * @param tags the list of tags to initialize
     * @since 5.0
     */
    public SwiftBlock3(final List<Tag> tags) {
        this();
        this.addTags(tags);
    }

    /**
     * This method deserializes the JSON data into an block 3 object.
     *
     * @see #toJson()
     * @since 7.9.8
     */
    public static SwiftBlock3 fromJson(String json) {
        final Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, SwiftBlock3.class);
    }

    /**
     * Sets the block number. Will cause an exception unless setting block number to 3.
     *
     * @param blockNumber the block number to set
     * @throws IllegalArgumentException if parameter blockName is not the integer 3
     * @since 5.0
     */
    @Override
    protected void setBlockNumber(final Integer blockNumber) {
        // sanity check
        Objects.requireNonNull(blockNumber, "parameter 'blockNumber' cannot be null");
        Validate.isTrue(blockNumber == 3, "blockNumber must be 3");
    }

    /**
     * Sets the block name. Will cause an exception unless setting block number to "3".
     *
     * @param blockName the block name to set
     * @throws IllegalArgumentException if parameter blockName is not the string "3"
     * @since 5.0
     */
    @Override
    protected void setBlockName(final String blockName) {
        // sanity check
        Objects.requireNonNull(blockName, "parameter 'blockName' cannot be null");
        Validate.isTrue(blockName.compareTo("3") == 0, "blockName must be string '3'");
    }

    /**
     * Returns the block number (the value 3 as an integer)
     *
     * @return Integer containing the block's number
     */
    @Override
    public Integer getNumber() {
        return 3;
    }

    /**
     * Returns the block name (the value 3 as a string)
     *
     * @return block name
     * st
     * @since 5.0
     */
    @Override
    public String getName() {
        return "3";
    }

    /**
     * Indicates if the message is a Straight Through Processing (STP)
     *
     * @return true if the message is STP
     */
    public Boolean isSTP() {
        if (containsTag("119") && "STP".equalsIgnoreCase(getTagValue("119"))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * This method will generate a MUR field (tag 108) with a timestamp using
     * current time formatted as yyMMddHHmmssSSSS
     *
     * @param overwriteIfExist when true and field 108 already exist, its value will be overwriten with the generated timestamp
     * @since 7.8.8
     */
    public void generateMUR(boolean overwriteIfExist) {
        final String MUR = new SimpleDateFormat("yyMMddHHmmssSSSS")
                .format(Calendar.getInstance().getTime());
        Tag t = getTagByName("108");
        if (t == null) {
            builder().setField108(new Field108(MUR));
        } else if (overwriteIfExist) {
            log.fine("block 3 MUR value " + t.getValue() + " overwritten with generated MUR " + MUR);
            t.setValue(MUR);
        }
    }

    /**
     * @return a decorated block3 with helper methods to set only expected fields and in proper order
     * @since 7.10.0
     */
    public SwiftBlock3Builder builder() {
        return new SwiftBlock3Builder(this);
    }

    /**
     * Add the given field in order the list, sorted by field name.
     * The Field components are serialized into a plain value usign the getValue implementation
     * of the Field object, and this created value is use for the internal Tag actually set into
     * the block.
     *
     * @param field the field to add, must not be null
     * @return <code>this</code>
     * @throws IllegalArgumentException if field is null
     * @since 7.7
     */
    @Override
    public SwiftTagListBlock append(final Field field) {
        super.append(field);
        List<Tag> tags = super.getTags();
        tags.sort((t1, t2) -> {
            String n1 = (t1 != null) ? t1.getName() : null;
            String n2 = (t2 != null) ? t2.getName() : null;
            if (n1 == n2) return 0;
            if (n1 == null) return 1;
            if (n2 == null) return -1;
            return n1.compareToIgnoreCase(n2);
        });
        super.setTags(tags);
        return this;
    }
}

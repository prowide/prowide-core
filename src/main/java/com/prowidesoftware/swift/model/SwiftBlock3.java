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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prowidesoftware.swift.model.field.Field108;
import org.apache.commons.lang3.Validate;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Base class for SWIFT <b>User Header Block (block 3)</b>.
 * <p>This block is optional, and contains special processing instructions.
 * 
 * @since 4.0
 */
public class SwiftBlock3 extends SwiftTagListBlock implements Serializable {
	private static final long serialVersionUID = 4377884587811023149L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftBlock3.class.getName());

	/**
	 * Default constructor
	 */
	public SwiftBlock3() {
		super();
	}

	/**
	 * Constructor with tag initialization
	 * @param tags the list of tags to initialize
	 * 
	 * @since 5.0
	 */
	public SwiftBlock3(final List<Tag> tags) {
		this();
		this.addTags(tags);
	}

	/**
	 * Sets the block number. Will cause an exception unless setting block number to 3.
	 * @param blockNumber the block number to set
	 * @throws IllegalArgumentException if parameter blockName is not the integer 3
	 * @since 5.0
	 */
	protected void setBlockNumber(final Integer blockNumber) {
		// sanity check
		Validate.notNull(blockNumber, "parameter 'blockNumber' cannot be null");
		Validate.isTrue(blockNumber.intValue() == 3, "blockNumber must be 3");
	}

	/**
	 * Sets the block name. Will cause an exception unless setting block number to "3".
	 * @param blockName the block name to set
	 * @throws IllegalArgumentException if parameter blockName is not the string "3"
	 * @since 5.0
	 */
	protected void setBlockName(final String blockName) {
		// sanity check
		Validate.notNull(blockName, "parameter 'blockName' cannot be null");
		Validate.isTrue(blockName.compareTo("3") == 0, "blockName must be string '3'");
	}

	/**
	 * Returns the block number (the value 3 as an integer)
	 * @return Integer containing the block's number
	 */
	public Integer getNumber() {
		return Integer.valueOf(3);
	}

	/**
	 * Returns the block name (the value 3 as a string)
	 * @return block name
	 * st
	 * @since 5.0
	 */
	public String getName() {
		return "3";
	}

	/**
	 * Indicates if the message is a Straight Through Processing (STP)
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
	 * @param overwriteIfExist when true and field 108 already exist, its value will be overwriten with the generated timestamp
	 * @since 7.8.8
	 */
	public void generateMUR(boolean overwriteIfExist) {
		final String MUR = (new SimpleDateFormat("yyMMddHHmmssSSSS").format(Calendar.getInstance().getTime()));
		Tag t = getTagByName("108");
		if (t == null) {
			builder().setField108(new Field108(MUR));
		} else if (overwriteIfExist) {
			log.fine("block 3 MUR value "+t.getValue()+" overwritten with generated MUR "+MUR);
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
	 * This method deserializes the JSON data into an block 3 object.
	 * @see #toJson()
	 * @since 7.9.8
	 */
	public static SwiftBlock3 fromJson(String json){
		final Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, SwiftBlock3.class);
	}

}
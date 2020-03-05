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

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Base class for SWIFT <b>Trailer Block (block 5)</b>.
 *
 * <p>Each SWIFT message has one or more trailers as required by
 * the message exchange and security requirements. 
 * System trailers, if applicable, follow user trailers.<br>
 * 
 * @since 4.0
 */
public class SwiftBlock5 extends SwiftTagListBlock implements Serializable {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftBlock5.class.getName());
	private static final long serialVersionUID = 3114133378482486859L;

	/**
	 * Default constructor
	 */
	public SwiftBlock5() {
		super();
	}

	/**
	 * Constructor with tag initialization
	 * @param tags the list of tags to initialize
	 * @throws IllegalArgumentException if parameter tags is null
	 * @throws IllegalArgumentException if parameter tags is not composed of Strings
	 * @since 5.0
	 */
	public SwiftBlock5(final List<Tag> tags) {
		// sanity check
		Validate.notNull(tags, "parameter 'tags' cannot be null");

		this.addTags(tags);
	}

	/**
	 * Sets the block number. Will cause an exception unless setting block number to 5.
	 * @param blockNumber the block number to set
	 * @throws IllegalArgumentException if parameter blockName is not the integer 5
	 * @since 5.0
	 */
	protected void setBlockNumber(final Integer blockNumber) {
		// sanity check
		Validate.notNull(blockNumber, "parameter 'blockNumber' cannot be null");
		Validate.isTrue(blockNumber.intValue() == 5, "blockNumber must be 5");
	}

	/**
	 * Sets the block name. Will cause an exception unless setting block number to "5".
	 * @param blockName the block name to set
	 * @throws IllegalArgumentException if parameter blockName is not the string "5"
	 * @since 5.0
	 */
	protected void setBlockName(final String blockName) {
		// sanity check
		Validate.notNull(blockName, "parameter 'blockName' cannot be null");
		Validate.isTrue(blockName.compareTo("5") == 0, "blockName must be string '5'");
	}

	/**
	 * Returns the block number (the value 5 as an integer)
	 * @return Integer containing the block's number
	 */
	public Integer getNumber() {
		return Integer.valueOf(5);
	}

	/**
	 * Returns the block name (the value 5 as a string)
	 * @return block name
	 * 
	 * @since 5.0
	 */
	public String getName() {
		return "5";
	}

	/**
	 * This method deserializes the JSON data into a block 5 object.
	 * @see #toJson()
	 * @since 7.9.8
	 */
	public static SwiftBlock5 fromJson(String json){
		final Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, SwiftBlock5.class);
	}

	/**
	 * Sets a specific field in the trailer.
	 * If the field exists, its value will be overwritten.
	 * @param field the specific field to set or update
	 * @param value optional field value, could be a time, a MIR, or any other value for the field; null is also accepted when the field should hold no value
	 * @since 8.0.2
	 */
	public SwiftBlock5 setTag(SwiftBlock5Field field, String value) {
		String notNullValue = StringUtils.trimToEmpty(value);
		Tag t = getTagByName(field.name());
		if (t != null) {
			// update existing
			t.setValue(notNullValue);
		} else {
			// add new field
			append(new Tag(field.name(), notNullValue));
		}
		return this;
	}

	/**
	 * Gets a specific field from the trailer.
	 * @param field the specific field to get
	 * @return the found field
	 * @since 8.0.2
	 */
	public Optional<Tag> getTag(SwiftBlock5Field field) {
		return Optional.ofNullable(getTagByName(field.name()));
	}

	/**
	 * Sets the Possible Duplicate Emission tag with no value.
	 * If the field exists, its value will be overwritten.
	 * @since 8.0.2
	 */
	public SwiftBlock5 setPDE() {
		return setTag(SwiftBlock5Field.PDE, null);
	}

}
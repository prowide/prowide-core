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
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Base class for SWIFT <b>Body Block (block 4)</b>.<br>
 * This block is where the actual message content is specified 
 * and is what most users see. Generally the other blocks are 
 * stripped off before presentation. It mainly contains a list of
 * tags and its format representation, which is variable 
 * length and requires use of CRLF as a field delimiter.<br>
 * 
 * @author www.prowidesoftware.com
 * @since 4.0
 */
public class SwiftBlock4 extends SwiftTagListBlock implements Serializable {
	private static final long serialVersionUID = -623730182521597955L;

	/**
	 * Default constructor
	 */
	public SwiftBlock4() {
		super();
	}

	/**
	 * Constructor with tag initialization
	 * @param tags the list of tags to initialize
	 * @throws IllegalArgumentException if parameter tags is null
	 * @throws IllegalArgumentException if parameter tags is not composed of Strings
	 * @since 5.0
	 */
	public SwiftBlock4(List<Tag> tags) {
		// sanity check
		Validate.notNull(tags, "parameter 'tags' cannot be null");

		this.addTags(tags);
	}

	/**
	 * Sets the block number. Will cause an exception unless setting block number to 4.
	 * @param blockNumber the block number to set
	 * @throws IllegalArgumentException if parameter blockName is not the integer 4
	 * @since 5.0
	 */
	protected void setBlockNumber(Integer blockNumber) {
		// sanity check
		Validate.notNull(blockNumber, "parameter 'blockNumber' cannot be null");
		Validate.isTrue(blockNumber.intValue() == 4, "blockNumber must be 4");
	}

	/**
	 * Sets the block name. Will cause an exception unless setting block number to "4".
	 * @param blockName the block name to set
	 * @throws IllegalArgumentException if parameter blockName is not the string "4"
	 * @since 5.0
	 */
	protected void setBlockName(String blockName) {
		// sanity check
		Validate.notNull(blockName, "parameter 'blockName' cannot be null");
		Validate.isTrue(blockName.compareTo("4") == 0, "blockName must be string '4'");
	}

	/**
	 * Returns the block number (the value 4 as an integer)
	 * @return Integer containing the block's number
	 */
	public Integer getNumber() {
		return Integer.valueOf(4);
	}

	/**
	 * Returns the block name (the value 4 as a string)
	 * @return block name
	 * 
	 * @since 5.0
	 */
	public String getName() {
		return("4");
	}

	/**
	 * Creates a new block with all empty sequences removed.
	 * <br>
	 * <p>The implementation uses as sequence boundaries the fields: 16R, 16S and 15a.
	 * Two consecutive 16R (start of sequence) and 16S (end of sequence) with the same qualifier 
	 * are considered an empty sequence so both boundary fields 16R and 16S will be dropped. 
	 * For field 15a (start of sequence) there is no end of sequence boundary so if two consecutive
	 * 15a are found, the first one will be dropped. Also a 15a at the end of the block will be 
	 * considered and empty sequence.
	 *
	 * @param b4 a block with sequences to filter
	 * @return a new block containing all tags that are outside a empty 16R/S or 15a sub-block, or null if the parameter block is null
	 * @since 7.8.8
	 */
	public static SwiftBlock4 removeEmptySequences(final SwiftBlock4 b4) {
		if (b4 == null) {
			return null;
		}
		final Stack<Tag> stack = new Stack<Tag>();
		for (Tag t : b4.getTags()) {
			if (!stack.isEmpty() &&
				StringUtils.equals(t.getName(), "16S") &&
				StringUtils.equals(stack.peek().getName(), "16R") && 
				StringUtils.equals(stack.peek().getValue(), t.getValue())) {
				/*
				 * found an empty 16R 16S pair
				 */
				stack.pop();
			} else if (t.isNumber(15) && !stack.isEmpty() && stack.peek().isNumber(15)) {
				/*
				 * found two consecutive 15a
				 */
				stack.pop(); //remove the previous seq start
				stack.push(t); //keep this new sequence for the moment
			} else {
				stack.push(t);
			}
		}
		if (!stack.isEmpty() && stack.peek().isNumber(15)) {
			/*
			 * if last field is 15a remove it because it is starting
			 * a sequence with no tags.
			 */
			stack.pop();
		}
        return new SwiftBlock4(new ArrayList<>(stack));
	}

	/**
	 * This method deserializes the JSON data into an block 4 object.
	 * @see #toJson()
	 * @since 7.9.8
	 */
	public static SwiftBlock4 fromJson(String json){
		final Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, SwiftBlock4.class);
	}

}
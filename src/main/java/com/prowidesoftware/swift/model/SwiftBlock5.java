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
package com.prowidesoftware.swift.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.Validate;

/**
 * Base class for SWIFT <b>Trailer Block (block 5)</b>.<br>
 * Each SWIFT message has one or more trailers as required by 
 * the message exchange and security requirements. 
 * System trailers, if applicable, follow user trailers.<br>
 * 
 * @author www.prowidesoftware.com
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

	}

	/**
	 * Constructor with tag initialization
	 * @param tags the list of tags to initialize
	 * @throws IllegalArgumentException if parameter tags is <code>null</code>
	 * @throws IllegalArgumentException if parameter tags is not composed of Strings
	 * @since 5.0
	 */
	public SwiftBlock5(final List<Tag> tags) {
		// sanity check
		Validate.notNull(tags, "parameter 'tags' cannot be null");
		Validate.allElementsOfType(tags, Tag.class, "parameter 'tags' may only have Tag elements");

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
		return new Integer(5);
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
}

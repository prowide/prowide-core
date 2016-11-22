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
 * Base class for SWIFT <b>User Header Block (block 3)</b>.<br>
 * This block is optional, and contains special processing instructions.<br>
 * 
 * @author www.prowidesoftware.com
 * @since 4.0
 */
public class SwiftBlock3 extends SwiftTagListBlock implements Serializable {
	private static final long serialVersionUID = 4377884587811023149L;
	@SuppressWarnings("unused")
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
		return new Integer(3);
	}

	/**
	 * Returns the block name (the value 3 as a string)
	 * @return block name
	 * 
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
		if (containsTag("119") && getTagValue(("119")).toLowerCase().equals("stp")) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}

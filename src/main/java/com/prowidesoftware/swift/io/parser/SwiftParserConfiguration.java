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
package com.prowidesoftware.swift.io.parser;

/**
 * Container class for MT parser parameters.
 * This can be passed to the parser to control fine grain details of the process.
 *
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
public class SwiftParserConfiguration {
	private boolean lenient = false;
	private boolean parseTextBlock = true;
	private boolean parseTrailerBlock = true;
	private boolean parseUserBlock = true;

	/**
	 * Indicates whether the parser is permissive or not.
	 * Has particular impact on parsing the headers blocks 1 and 2.
	 * Defaults to false.
	 */
	public boolean isLenient() {
		return lenient;
	}

	public void setLenient(final boolean lenient) {
		this.lenient = lenient;
	}

	/**
	 * Defines if the text block (block 4) will be parsed.
	 * Defaults to true.
	 */
	public boolean isParseTextBlock() {
		return parseTextBlock;
	}

	public void setParseTextBlock(final boolean parseTextBlock) {
		this.parseTextBlock = parseTextBlock;
	}

	/**
	 * Defines if the trailer block (block 5) will be parsed.
	 * Defaults to true.
	 */
	public boolean isParseTrailerBlock() {
		return parseTrailerBlock;
	}

	public void setParseTrailerBlock(final boolean parseTrailerBlock) {
		this.parseTrailerBlock = parseTrailerBlock;
	}

	/**
	 * Defines if the optional user block will be parsed.
	 * Defaults to true.
	 */
	public boolean isParseUserBlock() {
		return parseUserBlock;
	}

	public void setParseUserBlock(final boolean parseUserBlock) {
		this.parseUserBlock = parseUserBlock;
	}
}

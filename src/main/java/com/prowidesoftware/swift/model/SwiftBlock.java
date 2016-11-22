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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Base class for a generic SWIFT block.<br> 
 * This is an <b>abstract</b> class so specific block classes for each block (block 1, 2, 3, etc...)
 * should be instantiated.<br />
 * <br />
 * Instances of this class may have a list of unparsed texts (UnparsedTextList).
 * For easy access, methods have been created that first ensure the lists exists (the
 * real object is created and then call the base method).<br />
 * However, not all the base list methods have been implemented. If you need to use not
 * exposed functionality, retrieve the underlying list with (see getUnparsedTexts method)<br />
 *
 * @author www.prowidesoftware.com
 */
//TODO: add parameter checks (Validate.*) and complete javadocs 
public abstract class SwiftBlock implements Serializable {
	private static final long serialVersionUID = -6993261477630953757L;

	/**
	 * Unique identifier of the swift block.
	 * Mainly used for persistence services.
	 */
	protected Long id;

	/**
	 * List of unparsed texts. For performance reasons, this will be null until really needed.
	 */
	protected UnparsedTextList unparsedTexts = null;

	/**
	 * Only valid for block2, only when using hibernate for persistence
	 */
	protected Boolean input;
	/**
	 * Only valid for block2, only when using hibernate for persistence
	 */
	protected Boolean output;

	/**
	 * helper for hibernate mapping
	 */
	protected String blockType;
	
	/**
	 * @return a string identifying block type or <code>null</code> if not implemented
	 */
	public String getBlockType() {
		return blockType;
	}

	/**
	 * should not be normally called
	 * @param blockType
	 */
	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}

	/**
	 * Default constructor, shouldn't be used normally.
	 * <b>DO NOT USE</b>: present only for subclasses
	 */
	public SwiftBlock() {

	}

	/**
	 * Constructor for an unparsed text list
	 * @param unparsedText the list of unparsed texts
	 */
	public SwiftBlock(final UnparsedTextList unparsedText) {

		// set the unparsed text list
		this.unparsedTexts = unparsedText;
	}

	/**
	 * Sets the block number (this method is to be overwrite for derived classes).
	 * @param blockNumber the block number to set
	 * 
	 * @since 5.0
	 */
	protected abstract void setBlockNumber(Integer blockNumber);

	/**
	 * Sets the block name (this method is to be overwrite for derived classes).
	 * @param blockName the block name to set
	 * 
	 * @since 5.0
	 */
	protected abstract void setBlockName(String blockName);

	/**
	 * Returns the block number (this method is to be overwritten for derived classes).
	 * @return Integer containing the block's number
	 */
	public abstract Integer getNumber();

	/**
	 * Returns the block name (this method is to be overwritten for derived classes).
	 * @return block name
	 * 
	 * @since 5.0
	 */
	public abstract String getName();

	/**
	 * Get the unique identifier of this block or <code>null</code> if it is not set
	 * @return the unique identifier 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of this block
	 * @param id the unique identifier to set.
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * Tell if this block is a block that contains a list of tags (3-5) or is a block with fixed length value (1-2)
	 * @return <code>true</code> if this object contains a list of tags (which may be empty or <code>null</code>
	 */
	public boolean isTagBlock() {
		return this instanceof SwiftTagListBlock;
	}

	/**
	 * verifies that the unparsed text list exists
	 */
	protected void unparsedTextVerify() {
		if (this.unparsedTexts == null) {
			this.unparsedTexts = new UnparsedTextList();
		}
	}

	/**
	 * Returns the unparsed text list attached to the Block.
	 * @return the unparsed texts attached to the block
	 */
	public UnparsedTextList getUnparsedTexts() {
		// create the list if needed
		unparsedTextVerify();
		return this.unparsedTexts;
	}

	/**
	 * sets the list of unparsed texts
	 * @param texts the new list of unparsed texts (may be null)
	 */
	public void setUnparsedTexts(final UnparsedTextList texts) {
		this.unparsedTexts = texts;
	}

	/**
	 * returns the size of the unparsed text list
	 * @return the count of unparsed test attached to the block
	 */
	public Integer getUnparsedTextsSize() {
		// no list => size is zero...
		if (this.unparsedTexts == null) {
			return new Integer(0);
		}
		return this.unparsedTexts.size();
	}

	/**
	 * decides if a specific text (by index) is likely a SWIFT FIN message. Exceptions are inherited from
	 * base implementation methods.
	 * @param index the unparsed text number
	 * @throws IllegalArgumentException if parameter index is <code>null</code>
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 * @return true if the unparsed text at position index is a full SWIFT Message
	 */
	public Boolean unparsedTextIsMessage(final Integer index) {
		// create the list if needed
		unparsedTextVerify();
		return this.unparsedTexts.isMessage(index);
	}

	/**
	 * get an unparsed text
	 * @param index the unparsed text number
	 * @return the requested text
	 * @throws IllegalArgumentException if parameter index is <code>null</code>
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public String unparsedTextGetText(final Integer index) {
		// create the list if needed
		unparsedTextVerify();
		return this.unparsedTexts.getText(index);
	}

	/**
	 * get an unparsed text as a parsed swift message
	 * @param index the unparsed text number
	 * @throws IllegalArgumentException if parameter index is <code>null</code> 
	 * @return the blocks unparsed text at position index, parsed into a SwiftMessage object
	 */
	public SwiftMessage unparsedTextGetAsMessage(final Integer index) {
		// create the list if needed
		unparsedTextVerify();
		return this.unparsedTexts.getTextAsMessage(index);
	}

	/**
	 * adds a new unparsed text
	 * @param text the unparsed text to append
	 * @throws IllegalArgumentException if parameter text is <code>null</code> 
	 */
	public void unparsedTextAddText(final String text) {
		// create the list if needed
		unparsedTextVerify();
		this.unparsedTexts.addText(text);
	}

	/**
	 * adds a new unparsed text from a message
	 * @param message the message to be appended
	 * @throws IllegalArgumentException if parameter message is <code>null</code> 
	 */
	public void unparsedTextAddText(final SwiftMessage message) {
		// create the list if needed
		unparsedTextVerify();
		this.unparsedTexts.addText(message);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unparsedTexts == null) ? 0 : unparsedTexts.hashCode());
		return result;
	}

	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SwiftBlock other = (SwiftBlock) obj;
		if (unparsedTexts == null) {
			if (other.unparsedTexts != null) {
				return false;
			}
		} else if (!unparsedTexts.equals(other.unparsedTexts)) {
			return false;
		}
		return true;
	}

	/**
	 * Only valid for block2, only when using hibernate for persistence
	 * @return true if the message block type is <code>2I</code>
	 * @deprecated use {@link #getBlockType()}
	 */
	public Boolean getInput() {
		return new Boolean(StringUtils.equals(getBlockType(), "2I"));
	}

	/**
	 * Only valid for block2, only when using hibernate for persistence
	 * @param input the is input parameter
	 */
	public void setInput(Boolean input) {
		this.input = input;
	}

	/**
	 * Only valid for block2, only when using hibernate for persistence
	 * @return <code>true</code> if message block type is <code>2O</code>
	 * @deprecated use {@link #getBlockType()}
	 */
	public Boolean getOutput() {
		return new Boolean(StringUtils.equals(getBlockType(), "2O"));
	}

	/**
	 * Only valid for block2, only when using hibernate for persistence
	 * @param output the is output parameter
	 */
	public void setOutput(Boolean output) {
		this.output = output;
	}
}

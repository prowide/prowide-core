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

import java.io.Serializable;
import java.util.Objects;

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Base class for a generic SWIFT block.<br> 
 * This is an <b>abstract</b> class so specific block classes for each block (block 1, 2, 3, etc...)
 * should be instantiated.<br>
 * <br>
 * Instances of this class may have a list of unparsed texts (UnparsedTextList).
 * For easy access, methods have been created that first ensure the lists exists (the
 * real object is created and then call the base method).<br>
 * However, not all the base list methods have been implemented. If you need to use not
 * exposed functionality, retrieve the underlying list with (see getUnparsedTexts method)<br>
 *
 * @author www.prowidesoftware.com
 */
//TODO: add parameter checks (Validate.*) and complete javadocs 
public abstract class SwiftBlock implements Serializable {
	private static final long serialVersionUID = -6993261477630953757L;

	/**
	 * Unique identifier of the swift block.
	 * Mainly used for persistence services.
	 * @deprecated use persistence mapping in the AbstractSwiftMessage model instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SwiftBlock that = (SwiftBlock) o;
		return Objects.equals(unparsedTexts, that.unparsedTexts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(unparsedTexts);
	}

	/**
	 * helper for hibernate mapping
	 */
	protected String blockType;
	
	/**
	 * @return a string identifying block type or null if not implemented
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
	 * Get the unique identifier of this block or null if it is not set
	 * @return the unique identifier 
	 * @deprecated use persistence mapping in the AbstractSwiftMessage model instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public Long getId() {
		DeprecationUtils.phase2(getClass(), "getId()", "The SwiftMessage model is no more intended for persistence, use the more effective JPA annotated model in AbstractSwiftMessage instead");
		return id;
	}

	/**
	 * Sets the unique identifier of this block
	 * @param id the unique identifier to set.
	 * @deprecated use persistence mapping in the AbstractSwiftMessage model instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public void setId(final Long id) {
		DeprecationUtils.phase2(getClass(), "setId(Long)", "The SwiftMessage model is no more intended for persistence, use the more effective JPA annotated model in AbstractSwiftMessage instead");
		this.id = id;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * Tell if this block is a block that contains a list of tags (3-5) or is a block with fixed length value (1-2)
	 * @return <code>true</code> if this object contains a list of tags (which may be empty or null
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
			return Integer.valueOf(0);
		}
		return this.unparsedTexts.size();
	}

	/**
	 * decides if a specific text (by index) is likely a SWIFT FIN message. Exceptions are inherited from
	 * base implementation methods.
	 * @param index the unparsed text number
	 * @throws IllegalArgumentException if parameter index is null
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
	 * @throws IllegalArgumentException if parameter index is null
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
	 * @throws IllegalArgumentException if parameter index is null
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
	 * @throws IllegalArgumentException if parameter text is null
	 */
	public void unparsedTextAddText(final String text) {
		// create the list if needed
		unparsedTextVerify();
		this.unparsedTexts.addText(text);
	}

	/**
	 * adds a new unparsed text from a message
	 * @param message the message to be appended
	 * @throws IllegalArgumentException if parameter message is null
	 */
	public void unparsedTextAddText(final SwiftMessage message) {
		// create the list if needed
		unparsedTextVerify();
		this.unparsedTexts.addText(message);
	}

	/**
	 * Only valid for block2, only when using hibernate for persistence
	 * @return true if the message block type is <code>2I</code>
	 * @deprecated use {@link #getBlockType()}
	 */
	public Boolean getInput() {
		return Boolean.valueOf(StringUtils.equals(getBlockType(), "2I"));
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
		return Boolean.valueOf(StringUtils.equals(getBlockType(), "2O"));
	}

	/**
	 * Only valid for block2, only when using hibernate for persistence
	 * @param output the is output parameter
	 */
	public void setOutput(Boolean output) {
		this.output = output;
	}	
}

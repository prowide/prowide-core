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
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;

/**
 * Base class for SWIFT <b>Application Header Block (block 2)</b>
 *
 * <p>The Application Header contains information about the
 * message type and the destination of the message.
 * 
 * <p>There are two types of application headers: Input and Output.
 * Both, input and output block 2 flavors are fixed-length and continuous with no field delimiters. 
 * The fields that conform the blocks's value are represented in the subclasses
 * as individual attributes for easier management.
 * 
 * <p>This is an <b>abstract</b> class so specific block 2 subclasses should be instantiated.
 *
 * @since 4.0
 */
public abstract class SwiftBlock2 extends SwiftValueBlock implements Serializable {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftBlock2.class.getName());
	private static final long serialVersionUID = 7994472954593732477L;

	/** 
	 * String of 1 character containing the message priority as follows:<br>
	 * S = System<br>
	 * N = Normal<br>
	 * U = Urgent
	 */
	protected String messagePriority = "N";

	/**
	 * String of 3 character containing the Message Type (MT) as classified and
	 * numbered by SWIFT. Three-digit FIN message type, example 103.
	 */
	protected String messageType = null;

	/**
	 * Default Constructor
	 */
	public SwiftBlock2() {
		super();
	}

	/**
	 * Sets the block number. Will cause an exception unless setting block number to 2.
	 * @param blockNumber the block number to set
	 * @throws IllegalArgumentException if parameter blockName is not the integer 2
	 * @since 5.0
	 */
	protected void setBlockNumber(final Integer blockNumber) {
		// sanity check
		Validate.notNull(blockNumber, "parameter 'blockNumber' cannot be null");
		Validate.isTrue(blockNumber == 2, "blockNumber must be 2");
	}

	/**
	 * Sets the block name. Will cause an exception unless setting block number to "2".
	 * @param blockName the block name to set
	 * @throws IllegalArgumentException if parameter blockName is not the string "2"
	 * @since 5.0
	 */
	protected void setBlockName(final String blockName) {
		// sanity check
		Validate.notNull(blockName, "parameter 'blockName' cannot be null");
		Validate.isTrue(blockName.compareTo("2") == 0, "blockName must be string '2'");
	}

	/**
	 * Returns the block number (the value 2 as an integer)
	 * @return Integer containing the block's number
	 */
	public Integer getNumber() {
		return 2;
	}

	/**
	 * Returns the block name (the value 2 as a string)
	 * @return block name
	 * 
	 * @since 5.0
	 */
	public String getName() {
		return "2";
	}

	/**
	 * convert this to string
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * Sets the Message Type (MT) as classified and numbered by SWIFT.
	 * Three-digit FIN message type, example 103.
	 * 
	 * @param messageType String of 3 character
	 */
	public void setMessageType(final String messageType) {
		this.messageType = messageType;
	}

	/**
	 * Gets the Message Type (MT) as classified and numbered by SWIFT.
	 * @return messageType String of 3 character
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * Set the message priority 
	 * @param messagePriority the message priority
	 */
	public void setMessagePriority(final String messagePriority) {
		this.messagePriority = messagePriority;
	}

	/**
	 * Gets the message priority
	 * @return message priority
	 */
	public String getMessagePriority() {
		return messagePriority;
	}
	
	/**
	 * Gets the message priority as enum
	 * @return message priority enum value or null if the priority is not set or contains an invalid value
	 * @since 7.8.4
	 */
	public MessagePriority getMessagePriorityType() {
		if (this.messagePriority != null) {
			try {
				return MessagePriority.valueOf(this.messagePriority);
			} catch (Exception e) {
				final String text = "Block2 messagePriority contains an invalid value ["+ this.messagePriority +"]. The expected values are "+ Arrays.toString(MessagePriority.values());
				log.warning(text);
				log.log(Level.FINEST, text, e);
			}
		}
		return null;
	}

	/**
	 * Returns <code>true</code> if this block 2 is an input block 2.
	 * @return <code>true</code> if block 2 is input, of <code>false</code> in other case
	 */
	public boolean isInput() {
		return this instanceof SwiftBlock2Input;
	}

	/**
	 * Returns <code>true</code> if this block 2 is an output block 2.
	 * @return <code>true</code> if block 2 is output, of <code>false</code> in other case
	 */
	public boolean isOutput() {
		return this instanceof SwiftBlock2Output;
	}
	
	/**
	 * Sets all attributes to null
	 * @since 6.4
	 */
	public void clean() {
		messagePriority = null;
		messageType = null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		SwiftBlock2 that = (SwiftBlock2) o;
		return Objects.equals(messagePriority, that.messagePriority) &&
				Objects.equals(messageType, that.messageType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), messagePriority, messageType);
	}

	/**
	 * Specific serialization is provided for block 2 input and output
	 *
	 * @since 7.9.8 current block 2 implementation, based on Gson (method signature with null implementation is available since 7.5)
	 */
	public String toJson(){
		final Gson gson = new GsonBuilder()
			.registerTypeAdapter(SwiftBlock2.class, new SwiftBlock2Adapter())
			.setPrettyPrinting()
			.create();
		return gson.toJson(this,SwiftBlock2.class);
	}

	/**
	 * Generic getter for block attributes based on qualified names from {@link SwiftBlock2Field}
	 * @param field field to get
	 * @return field value or null if attribute is not set
	 * @since 7.7
	 */
	public String field(SwiftBlock2Field field) {
		switch (field) {
			case MessageType:
				return getMessageType();
			case MessagePriority:
				return getMessagePriority();
			default:
				return null;
		}
	}
	
	/**
	 * Generic setter for block attributes based on qualified names from {@link SwiftBlock2Field}
	 * @param field field to set
	 * @param value content to set
	 * @since 7.8
	 */
	public void setField(SwiftBlock2Field field, final String value) {
		switch (field) {
			case MessageType:
				setMessageType(value);
				break;
			case MessagePriority:
				setMessagePriority(value);
				break;
			default:break;
		}
	}
	
	/**
	 * Message priority values
	 * @since 7.8.4
	 */
	public enum MessagePriority {
		S("System"),
		N("Normal"),
		U("Urgent");
		
		private String label;
		
		MessagePriority(final String label) {
			this.label = label;
		}
		
		public String getLabel() {
			return this.label;
		}
	}
}

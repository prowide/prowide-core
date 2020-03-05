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

/**
 * Base class for hierarchy of specific MT and MX classes. 

 * @author sebastian
 *
 */
public abstract class AbstractMessage {
	
	MessageStandardType type = null;
	
	/*
	 * necessary for jaxb in MX
	 */
	protected AbstractMessage() {
		super();
	}
	
	protected AbstractMessage(MessageStandardType type) {
		super();
		this.type = type;
	}

	/**
	 * Serializa this message into its raw SWIFT format: FIN for MT and XML for MX
	 * @return the message content
	 * @since 8.0.2
	 */
	public abstract String message();

	/**
	 * True if the message is an MT, false otherwise
	 */
	public boolean isMT() {
		return this.type == MessageStandardType.MT;
	}

	/**
	 * True if the message is an MX, false otherwise
	 */
	public boolean isMX() {
		return this.type == MessageStandardType.MX;
	}
	
	/**
	 * Returns the standard enumeration value corresponding to this message
	 */
	public MessageStandardType getMessageStandardType() {
		return this.type;
	}
}

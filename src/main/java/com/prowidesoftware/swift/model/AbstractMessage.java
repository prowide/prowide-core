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

/**
 * Base class for hierarchy of specific MT and MX classes. 

 * @author sebastian
 *
 */
public class AbstractMessage {
	
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

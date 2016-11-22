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
package com.prowidesoftware.swift.io;

import com.prowidesoftware.swift.model.SwiftMessage;

/**
 * This interface provides a general conversion service between three different formats:
 * <ul>
 * 	<li><b>FIN</b>: SWIFT message format as used by SWIFTNet (ISO 15022 compliance).</li>
 *  <li><b>XML</b>: WIFE's XML representation of SWIFT messages.</li>
 *  <li><b>SwiftMessage</b>: WIFE's java object model of SWIFT messages.</li>
 * </ul>
 *  
 * @author www.prowidesoftware.com
 */
public interface IConversionService {
	
	/**
	 * Gets a String containing the FIN message from the msg object 
	 * argument, using FIN writer.
	 * 
	 * @param msg an object containing the message to convert
	 * @return a string with the FIN format representation of the message
	 * 
	 * @throws IllegalArgumentException if msg is <code>null</code>
	 */
	public abstract String getFIN(SwiftMessage msg);

	/**
	 * Gets a String containing the FIN message from the XML representation
	 * passed as a String argument.
	 * 
	 * @param xml the string with the internal XML message to read
	 * @return a string with the FIN format representation of the message
	 * 
	 * @throws IllegalArgumentException if XML is <code>null</code>
	 */
	public abstract String getFIN(String xml);

	/**
	 * Gets a String containing the XML internal representation of the message 
	 * from the msg object argument.
	 * 
	 * @param msg an object containing the message to convert
	 * @return a string with the internal XML representation of the message
	 * 
	 * @throws IllegalArgumentException if msg is <code>null</code>
	 */
	public abstract String getXml(SwiftMessage msg);

	/**
	 * Gets a String containing the XML internal representation of the message 
	 * from the FIN string message passed as argument.
	 * 
	 * @param fin a string containing the FIN message to convert
	 * @return a string with the internal XML representation of the message
	 * 
	 * @throws IllegalArgumentException if fin is <code>null</code>
	 */
	public abstract String getXml(String fin);

	/**
	 * Gets a message object containing the message data 
	 * from the FIN string message passed as argument.
	 * 
	 * @param fin a string containing the FIN message to convert
	 * @return a swift object containing the message data
	 * 
	 * @throws IllegalArgumentException if fin is <code>null</code>
	 */
	public abstract SwiftMessage getMessageFromFIN(String fin);

	/**
	 * Gets a message object containing the message data 
	 * from the XML representation passed as a String argument.
	 * 
	 * @param xml the string with the internal XML message to read
	 * @return a swift object containing the message data
	 * 
	 * @throws IllegalArgumentException if XML is <code>null</code>
	 */
	public abstract SwiftMessage getMessageFromXML(String xml);

}
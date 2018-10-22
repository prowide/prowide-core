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
	 * @throws IllegalArgumentException if msg is null
	 */
	public abstract String getFIN(SwiftMessage msg);

	/**
	 * Gets a String containing the FIN message from the XML representation
	 * passed as a String argument.
	 * 
	 * @param xml the string with the internal XML message to read
	 * @return a string with the FIN format representation of the message
	 * 
	 * @throws IllegalArgumentException if XML is null
	 */
	public abstract String getFIN(String xml);

	/**
	 * Gets a String containing the XML internal representation of the message 
	 * from the msg object argument.
	 * 
	 * @param msg an object containing the message to convert
	 * @return a string with the internal XML representation of the message
	 * 
	 * @throws IllegalArgumentException if msg is null
	 */
	public abstract String getXml(SwiftMessage msg);

	/**
	 * Gets a String containing the XML internal representation of the message 
	 * from the FIN string message passed as argument.
	 * 
	 * @param fin a string containing the FIN message to convert
	 * @return a string with the internal XML representation of the message
	 * 
	 * @throws IllegalArgumentException if fin is null
	 */
	public abstract String getXml(String fin);

	/**
	 * Gets a message object containing the message data 
	 * from the FIN string message passed as argument.
	 * 
	 * @param fin a string containing the FIN message to convert
	 * @return a swift object containing the message data
	 * 
	 * @throws IllegalArgumentException if fin is null
	 */
	public abstract SwiftMessage getMessageFromFIN(String fin);

	/**
	 * Gets a message object containing the message data 
	 * from the XML representation passed as a String argument.
	 * 
	 * @param xml the string with the internal XML message to read
	 * @return a swift object containing the message data
	 * 
	 * @throws IllegalArgumentException if XML is null
	 */
	public abstract SwiftMessage getMessageFromXML(String xml);

}
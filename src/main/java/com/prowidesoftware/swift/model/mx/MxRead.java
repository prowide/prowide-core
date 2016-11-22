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
package com.prowidesoftware.swift.model.mx;

import com.prowidesoftware.swift.model.MxId;

/**
 * Interface to plug in code that reads XML strings into MX message objects
 *
 * @since 7.6
 */
public interface MxRead {

	/**
	 * Read <code>xml</code> into a message object
	 *
	 * @param targetClass class of the message to be read
	 * @param xml the string with the message
	 * @param classes classes for the context
	 * @return parsed message or null if string content could not be parsed into an Mx
	 * 
	 * @since 7.6
	 */
	AbstractMX read(Class<? extends AbstractMX> targetClass, final String xml, Class<? extends Object>[] classes);

	/**
	 * Read <code>xml</code> into a message object
	 * 
	 * @param xml the string with the message
	 * @param id optional parameter to indicate the specific MX type to create; autodetected from namespace if null.
	 * @return parsed message or null if string content could not be parsed into an Mx
	 * 
	 * @since 7.8.4
	 */
	public AbstractMX read(final String xml, MxId id);
}

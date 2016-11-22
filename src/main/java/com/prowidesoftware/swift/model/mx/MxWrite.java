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

import com.prowidesoftware.swift.DeleteSchedule;

/**
 * Interface to plug in code that serializes MX message objects to XML string
 *
 * @since 7.6
 */
public interface MxWrite {
	
	/**
	 * Converts obj into a xml string
	 * 
	 * @param namespace the namespace for the target message
	 * @param obj the object containing the message to be serialized
	 * @param classes array of all classes used or referenced by message class  
	 * @return the message content serialized to XML
	 * @since 7.6
	 * 
	 * @deprecated use {@link #message(String, AbstractMX, Class[], String, boolean)} instead
	 */
	@SuppressWarnings("rawtypes")
	@Deprecated
	@DeleteSchedule(2017)
	String message(String namespace, AbstractMX obj, Class[]classes);

	/**
	 * Converts obj into a xml string
	 * 
	 * @param namespace the namespace for the target message
	 * @param obj the object containing the message to be serialized
	 * @param classes array of all classes used or referenced by message class  
 	 * @param prefix optional prefix for ns ("Doc" by default)
	 * @param includeXMLDeclaration true to include the xml declaration (true by default)
	 * @return the message content serialized to XML
	 * @since 7.8
	 */
	@SuppressWarnings("rawtypes")
	String message(String namespace, AbstractMX obj, Class[]classes, final String prefix, boolean includeXMLDeclaration);

}

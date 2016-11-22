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
package com.prowidesoftware.swift.io.writer;


/**
 * @deprecated user {@link SwiftWriter}
 * 
 * @author www.prowidesoftware.com
 */
public class TextWriter 
{
    //private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger( TextWriter.class );

    /**
     * Creates a string with  a swift message for the given object.
     * The message type is selected in the template, which must point to a resource found in classapath.
     * 
     * @param template a valid path to the resource 
     * @param env the object to use to render the message
     * @return the string containing the encoded message
     * @throws IllegalArgumentException if template is <code>null</code> or the the template resource is not found in classpath
     */
    public String buildMessage( String template, Object env )
    {
    	throw new UnsupportedOperationException("Use SwiftWriter");
    }
}

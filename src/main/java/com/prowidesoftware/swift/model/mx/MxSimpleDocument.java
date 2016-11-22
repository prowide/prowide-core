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

/**
 * Document handler for MX messages for prowide CORE.
 * In CORE the document is only stored as an XML string.
 * For ease of use mutliple accessor methods are added
 * 
 * @author miguel@prowidesoftware.com
 *
 * @since 7.7
 */
public class MxSimpleDocument implements IDocument {
	private String xml;
	
	// TODO agregar get de xmlnode y algun otro elemento java de libs de 1.5
}

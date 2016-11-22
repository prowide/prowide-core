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
package com.prowidesoftware.swift.model.field;

import java.util.List;

import com.prowidesoftware.swift.model.BIC;

/**
 * Interface to mark fields whose definition contain a BIC.
 * Note that if a field has a BIC and it is optional, and the actual 
 * field has not set the optional BIC/s then
 * the call bics() will return an empty list
 * 
 * @author www.prowidesoftware.com
 * @since 6.1
 * @version $Revision: 1.1 $
 */
public interface BICContainer {

	/**
	 * Get a list of strings of BICs present in this field
	 * @return a list, with zero or more BICs in this field.
	 */
	List<String> bicStrings();
	
	/**
	 * Utility method that creates a BIC for every string returned by {@link #bicStrings()}
	 * 
	 */
	List<BIC> bics();
}

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
package com.prowidesoftware.swift.model.mt;

/**
 * Official variants for MT messages (not including closed user groups version of messages)
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
public enum MTVariant {
	STP(true),
	REMIT(true),
	COV(true),
	IRSLST(false),
	W8BENO(false);
	
	boolean validationFlag = false;
	
	MTVariant(boolean validationFlag) {
		this.validationFlag = validationFlag;
	}
	
	/**
	 * returns true if the variant is also a validation flag used in the user header block
	 */
	public boolean isValidationFlag() {
		return this.validationFlag;
	}
}

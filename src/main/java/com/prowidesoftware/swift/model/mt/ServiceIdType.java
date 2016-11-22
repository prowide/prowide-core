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
 * Available service identification values in MT header block 1.
 * 
 * @since 7.8.3
 */
public enum ServiceIdType {
	_01("GPA/FIN Message (system and user-to-user)"),
	_02("GPA Login"),
	_03("GPA Select"),
	_05("FIN Quit"),
	_06("GPA Logout"),
	_12("GPA System Remove AP Request"),
	_13("GPA System Abort AP Confirmation"),
	_14("GPA System Remove LT Request"),
	_15("GPA System Abort LT Confirmation"),
	_21("GPA/FIN Message (ACK/NAK/UAK/UNK)"),
	_22("GPA Login ACK (LAK)"),
	_23("GPA Select ACK (SAK)"),
	_25("FIN Quit ACK"),
	_26("GPA Logout ACK"),
	_33("GPA User Abort AP Request"),
	_35("GPA User Abort LT Request"),
	_42("GPA Login NAK (LNK)"),
	_43("GPA Select NAK (SNK)");
	
	private String description;
	
	ServiceIdType(final String description) {
		this.description = description;
	}
	
	/**
	 * Returns the service number and description, for example:
	 * 01 - GPA/FIN Message (system and user-to-user)
	 */
	public String description() {
		return this.name().substring(1) + " - " + this.description;
	}
}

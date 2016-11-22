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
 * Enumeration of messages standard types.
 * 
 * @author www.prowidesoftware.com
 * @since 7.8.3
 */
public enum MessageStandardType {
	MT,
	MX;

	public boolean isMT() {
		return this == MT;
	}
	public boolean isMX() {
		return this == MX;
	}
}

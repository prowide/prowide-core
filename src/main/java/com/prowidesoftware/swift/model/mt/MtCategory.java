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
 * Enumeration for MT messages categories.
 * <br />
 * The category is also included in the message type, as the first digit. For example
 * for an MT103 the corresponding category is 1. 
 * 
 * @author sebastian
 * @since 7.8.8
 */
public enum MtCategory {
	_0("System Messages"),
	_1("Customer Payments and Cheques"),
	_2("Financial Institution Transfers"),
	_3("Foreign exchange, Money Markets and Derivatives"),
	_4("Collections and Cash Letters"),
	_5("Securities Markets"),
	_6("Commodities and Syndications"),
	_7("Documentary Credits and Guarantees"),
	_8("Travellers Cheques"),
	_9("Cash Management and Customer Status");

	private String description;
	
	MtCategory(final String description) {
		this.description = description;
	}
	
	/**
	 * Convenient factory method to create a category enum value from an int
	 * @param cat a category number between 0 and 9
	 * @return the created category value or <code>null</code> if the parameter in is not a valid category number
	 */
	public static final MtCategory valueOf(int cat) {
		if (cat >=0 && cat <=9) {
			return valueOf("_"+cat);
		} else {
			return null;
		}
	}
	
	/**
	 * Returns the service number and description, for example:
	 * 01 - GPA/FIN Message (system and user-to-user)
	 */
	public final String description() {
		return number().substring(1) + " - " + this.description;
	}
	
	/**
	 * Returns this service id type number
	 * @since 7.8.8
	 */
	public final String number() {
		return this.name().substring(1);
	}
		
}

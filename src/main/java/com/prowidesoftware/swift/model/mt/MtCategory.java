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
package com.prowidesoftware.swift.model.mt;

/**
 * Enumeration for MT messages categories.
 * <br>
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
	 * @return the created category value or null if the parameter in is not a valid category number
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

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

import org.apache.commons.lang3.StringUtils;

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
		return number() + " - " + this.description;
	}
	
	/**
	 * Returns this service id type number
	 * @since 7.8.8
	 */
	public final String number() {
		return this.name().substring(1);
	}
	
	/**
	 * Returns true if the parameter number is a valid service id. 
	 * This method is null-safe.
	 * 
	 * @param number the service id number to test, may be null
	 * @return <code>true</code> if the parameter number is a valid service id
	 * @since 7.8.8
	 */
	public static final boolean valid(String number) {
		if (StringUtils.isNotEmpty(number)) {
			try {
				valueOf("_"+number);
				return true;
			} catch (Exception unused) {
				return false;
			}
		}
		return false;
	}

}

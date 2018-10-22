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
package com.prowidesoftware.swift.model;


/**
 * This class models and parses the Message Output Reference (MOR).
 * 
 * @author www.prowidesoftware.com
 * @since 7.4
 * @see MIR
 */
public class MOR extends MIR {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MOR.class.getName());
	
	public MOR(String date, String logicalTerminal, String sessionNumber, String sequenceNumber) {
		super(date, logicalTerminal, sessionNumber, sequenceNumber);
	}
		
	public MOR(String value) {
		super(value);
	}
	
	public MOR() {
		super();
	}
	
	/**
	 * @see #getMIR() 
	 */
	public String getMOR() {
		return getMIR();
	}
}

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

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * Enumeration of messages flow types.
 * 
 * @author www.prowidesoftware.com
 * @since 7.0
 */
public enum MessageIOType {
	/**
	 * Message coming to the institution from SWIFT network
	 */
	incoming,
	/**
	 * Message produced in the institution to be introduced (or already did) in the SWIFT network
	 */
	outgoing,
	/**
	 * Messages coming from and going to the swift network
	 */
	both;

	public static boolean isValid(String ioType) {
		Validate.notNull(ioType, "ioType can not be null");
		for (MessageIOType t: values()) {
			if (StringUtils.equals(ioType.trim(), t.name()))
				return true;
		}
		return false;
	}
	
	public boolean isIncoming() {
		return this == MessageIOType.incoming;
	}
	public boolean isOutgoing() {
		return this == MessageIOType.outgoing;
	}
	public boolean isBoth() {
		return this == MessageIOType.both;
	}
}

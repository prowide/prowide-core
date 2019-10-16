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
package com.prowidesoftware.swift;

import com.prowidesoftware.ProwideException;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

/**
 * Thrown if a message cannot be identified.
 *
 * @deprecated no longer used
 */
@Deprecated
@ProwideDeprecated(phase3=TargetYear.SRU2020)
public class UnknownMTException extends ProwideException {
	private static final long serialVersionUID = 6708923821228731L;

	/**
	 * Default constructor
	 */
	public UnknownMTException() {
		super();
	}

	/**
	 * Constructor with given text message and cause
	 * @param message
	 * @param cause
	 */
	public UnknownMTException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with given text message, it takes a default cause.
	 * @param message
	 */
	public UnknownMTException(String message) {
		super(message);
	}

	/**
	 * Constructor with given cause, it takes a default message.
	 * @param cause
	 */
	public UnknownMTException(Throwable cause) {
		super(cause);
	}

}

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

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

/**
 * Base class for exceptions.
 * 
 * @author www.prowidesoftware.com
 * @deprecated this has been replaced by {@link com.prowidesoftware.ProwideException}
 */
@Deprecated
@ProwideDeprecated(phase4=TargetYear._2019)
public class WifeException extends RuntimeException {
	private static final long serialVersionUID = -5598159933338062109L;

	/**
	 * @see RuntimeException#RuntimeException()
	 */
	public WifeException() {
		super();
	}

	/**
	 * @see RuntimeException#RuntimeException(String, Throwable)
	 */
	public WifeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @see RuntimeException#RuntimeException(String)
	 */
	public WifeException(String message) {
		super(message);
	}

	/**
	 * @see RuntimeException#RuntimeException(Throwable)
	 */
	public WifeException(Throwable cause) {
		super(cause);
	}

}

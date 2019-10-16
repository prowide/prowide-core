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

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.utils.IsoUtils;

/**
 * Helper class to validate ISO Currency codes
 * 
 * @deprecated use Java Currency instead
 * @see IsoUtils#isValidISOCurrency(String)
 *
 * @since 3.3
 */
@Deprecated
@ProwideDeprecated(phase4=TargetYear.SRU2020)
public class ISOCurrencies extends PropertyResource {
	private static final ISOCurrencies instance = new ISOCurrencies();
	
	/**
	 * Default constructor
	 */
	protected ISOCurrencies() {
		super();
	}
	
	/**
	 * Get the unique instance of this object
	 * @return the object instance
	 */
	public static ISOCurrencies getInstance() {
		return instance;
	}
	protected String getResourceName() {
		return "currencies.properties";
	}

}

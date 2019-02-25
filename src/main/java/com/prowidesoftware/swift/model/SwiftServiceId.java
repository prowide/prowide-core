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

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.model.mt.ServiceIdType;

/**
 * Class to hold valid service id values.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 * @deprecated use {@link ServiceIdType instead}
 */
@ProwideDeprecated(phase4=TargetYear._2019)
@Deprecated
public class SwiftServiceId {
	private static final long serialVersionUID = 3435194171796145884L;

	/**
	 * Constant for Service ID 01
	 */
	public static final SwiftServiceId _01 = new SwiftServiceId("01");
	/**
	 * Constant for Service ID 02
	 */
	public static final SwiftServiceId _02 = new SwiftServiceId("02");
	/**
	 * Constant for Service ID 03
	 */
	public static final SwiftServiceId _03 = new SwiftServiceId("03");
	/**
	 * Constant for Service ID 05
	 */
	public static final SwiftServiceId _05 = new SwiftServiceId("05");
	/**
	 * Constant for Service ID 06
	 */
	public static final SwiftServiceId _06 = new SwiftServiceId("06");
	/**
	 * Constant for Service ID 12
	 */
	public static final SwiftServiceId _12 = new SwiftServiceId("12");
	/**
	 * Constant for Service ID 13
	 */
	public static final SwiftServiceId _13 = new SwiftServiceId("13");
	/**
	 * Constant for Service ID 14
	 */
	public static final SwiftServiceId _14 = new SwiftServiceId("14");
	/**
	 * Constant for Service ID 15
	 */
	public static final SwiftServiceId _15 = new SwiftServiceId("15");
	/**
	 * Constant for Service ID 21
	 */
	public static final SwiftServiceId _21 = new SwiftServiceId("21");
	/**
	 * Constant for Service ID 22
	 */
	public static final SwiftServiceId _22 = new SwiftServiceId("22");
	/**
	 * Constant for Service ID 23
	 */
	public static final SwiftServiceId _23 = new SwiftServiceId("23");
	/**
	 * Constant for Service ID 25
	 */
	public static final SwiftServiceId _25 = new SwiftServiceId("25");
	/**
	 * Constant for Service ID 26
	 */
	public static final SwiftServiceId _26 = new SwiftServiceId("26");
	/**
	 * Constant for Service ID 33
	 */
	public static final SwiftServiceId _33 = new SwiftServiceId("33");
	/**
	 * Constant for Service ID 35
	 */
	public static final SwiftServiceId _35 = new SwiftServiceId("35");
	/**
	 * Constant for Service ID 42
	 */
	public static final SwiftServiceId _42 = new SwiftServiceId("42");
	/**
	 * Constant for Service ID 43
	 */
	public static final SwiftServiceId _43 = new SwiftServiceId("43");

	/**
	 * @param name
	 */
	protected SwiftServiceId(String name) {
		DeprecationUtils.phase3(getClass(), null, "Use the enumeration ServiceIdType instead.");
	}

	/**
	 * Tell if name is a valid service id, true if it is, and false in any other
	 * case. This method is null-safe.
	 * 
	 * @param name
	 *            the name to test as service id, may be null
	 * @return <code>true</code> if the parameter name is a valid service id
	 * @since 6.0
	 * @deprecated use {@link ServiceIdType#valid(String)} instead
	 */
	@ProwideDeprecated(phase4=TargetYear._2019)
	public static boolean contains(String name) {
		DeprecationUtils.phase3(SwiftServiceId.class, "contains(String)", "Use the enumeration ServiceIdType instead.");
		return false;
	}

}

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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Used to mark classes / methods or fields that are deprecated and will eventually be removed. 
 * @since 7.6
 * @deprecated this has been strongly improved and replaced by {@link ProwideDeprecated}
 */
@Retention(RetentionPolicy.SOURCE)
@Deprecated
@ProwideDeprecated(phase4=TargetYear._2019)
public @interface DeleteSchedule {

	/**
	 * Year by which it is scheduled to be removed.
	 * It may not be specified.
	 * This is intended for cases where replacing the code to be deleted do not have trivial replacement
	 */
	int value() default 0;
	/**
	 * Month (1-12) of the year by which it is scheduled to be removed.
	 * If not specified January
	 */
	int month() default 1;
	
	/**
	 * Optional URL with explanation or sample code 
	 */
	String url() default "";
}

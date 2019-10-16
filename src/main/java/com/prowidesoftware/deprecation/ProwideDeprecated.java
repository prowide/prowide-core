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
package com.prowidesoftware.deprecation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Main annotation to track prowide deprecated items.
 * 
 * See <a href="http://www.prowidesoftware.com/resources/deprecation-policy">Deprecation Policy</a>
 * for more details.
 * 
 * <p>This annotation is intended for internal use of Prowide and 
 * source code administration. It may suffer incompatible changes 
 * without prior notice.
 * 
 * @author miguel
 * @since 7.8.1
 */
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface ProwideDeprecated {

	String comment() default "";
	
	/**
	 * Scheduled year for entering phase 2 of deprecation
	 */
	TargetYear phase2() default TargetYear.SRU2020;
	/**
	 * Scheduled year for entering phase 3 of deprecation
	 */
	TargetYear phase3() default TargetYear.SRU2021;
	/**
	 * Scheduled year for entering phase 4 of deprecation
	 */
	TargetYear phase4() default TargetYear.SRU2022;
	
}

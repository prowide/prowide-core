/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
package com.prowidesoftware.deprecation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Main annotation to track prowide deprecated items.
 * 
 * See <a href="http://www.prowidesoftware.com/deprecation-policy.jsp">http://www.prowidesoftware.com/deprecation-policy.jsp</a>
 * for more details.
 * 
 * <em>This annotation is intended for internal use of Prowide and 
 * source code administration. It may suffer incompatible changes 
 * without prior notice.
 * </em>
 * 
 * @author miguel@prowidesoftware.com
 * @since 7.8.1
 */
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface ProwideDeprecated {

	String comment() default "";
	
	/**
	 * Scheduled year for entering phase 2 of deprecation
	 */
	TargetYear phase2() default TargetYear._2017;
	/**
	 * Scheduled year for entering phase 3 of deprecation
	 */
	TargetYear phase3() default TargetYear._2018;
	/**
	 * Scheduled year for entering phase 4 of deprecation
	 */
	TargetYear phase4() default TargetYear._2019;
	
}

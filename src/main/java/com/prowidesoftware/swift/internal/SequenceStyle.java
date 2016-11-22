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
package com.prowidesoftware.swift.internal;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Mark detecting sequences strategy used.
 * <em>Internal use</em> 
 * <ol>
 * 		<li> <code>Type.GENERATED_16RS</code> </li>
 * 		<li> <code>Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL</code> </li>
 * 		<li> <code>Type.GENERATED_SLICE</code> </li>
 * 		<li> <code>Type.SPLIT_BY_15</code> </li>
 * </ol>
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface SequenceStyle {
	public enum Type {
		GENERATED_16RS,
		GENERATED_FIXED_WITH_OPTIONAL_TAIL,
		GENERATED_SLICE,
		SPLIT_BY_15,
		CUSTOM
	}
	
	Type value();
}

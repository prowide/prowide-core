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
package com.prowidesoftware.swift.model;

import java.util.Locale;

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.utils.IsoUtils;

/**
 * Helper class to validate ISO Country codes
 * 
 * @deprecated: use Java {@link Locale#getISOCountries()} instead
 * @see IsoUtils#isValidISOCountry(String)
 * 
 * @author www.prowidesoftware.com
 * @since 3.3
 */
@Deprecated
@ProwideDeprecated(phase2=TargetYear._2018)
public class ISOCountries extends PropertyResource {
	private static final ISOCountries instance = new ISOCountries();
	
	/**
	 * Default constructor
	 */
	protected ISOCountries() {
		super();
	}
	
	/**
	 * Get the unique instance of this object
	 * @return the object instance
	 */
	public static ISOCountries getInstance() {
		return instance;
	}
	
	protected String getResourceName() {
		return "countries.properties";
	}

}

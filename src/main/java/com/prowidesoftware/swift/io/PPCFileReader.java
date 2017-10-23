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
package com.prowidesoftware.swift.io;

import java.io.File;
import java.io.FileNotFoundException;

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

/**
 * @deprecated use {@link PPCReader} instead
 * @author www@prowidesoftware.com
 */
@Deprecated
@ProwideDeprecated(phase3=TargetYear._2018)
public class PPCFileReader extends PPCReader {
	
	public PPCFileReader(final File file) throws FileNotFoundException {
		super(file);
		DeprecationUtils.phase2(getClass(), null, "Use PPCReader instead.");
	}
	
}

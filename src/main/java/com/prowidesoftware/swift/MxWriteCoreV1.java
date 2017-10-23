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
package com.prowidesoftware.swift;

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.model.MxNode;
import com.prowidesoftware.swift.model.mx.AbstractMX;
import com.prowidesoftware.swift.model.mx.BusinessHeader;
import com.prowidesoftware.swift.model.mx.MxWrite;

/**
 * For the moment this is only available in the Prowide Integrator version.
 * 
 * To create the XML from the generic structure check {@link MxNode} and {@link BusinessHeader}
 */
public class MxWriteCoreV1 implements MxWrite {

	/**
	 * @deprecated use {@link #message(String, AbstractMX, Class[], String, boolean)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3=TargetYear._2018)
	public String message(String namespace, AbstractMX obj, @SuppressWarnings("rawtypes") Class[] classes) {
		DeprecationUtils.phase2(getClass(), "message(String, AbstractMX, Class[])", "Use message(String, AbstractMX, Class[], String, boolean) instead.");
		throw new UnsupportedOperationException("For the moment this is only available in the integrator version");
	}

	public String message(String namespace, AbstractMX obj, @SuppressWarnings("rawtypes") Class[] classes, String prefix, boolean includeXMLDeclaration) {
		throw new UnsupportedOperationException("For the moment this is only available in the integrator version");
	}

}

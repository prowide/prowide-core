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

import com.prowidesoftware.swift.model.MxNode;
import com.prowidesoftware.swift.model.mx.AbstractMX;
import com.prowidesoftware.swift.model.mx.BusinessHeader;
import com.prowidesoftware.swift.model.mx.MxWrite;

/**
 * For the moment this is only available in the Prowide Integrator version.
 * 
 * To create the XML from the generic structure check {@linkplain MxNode} and {@linkplain BusinessHeader}
 */
public class MxWriteCoreV1 implements MxWrite {

	public String message(String namespace, AbstractMX obj, @SuppressWarnings("rawtypes") Class[] classes) {
		throw new UnsupportedOperationException("For the moment this is only available in the integrator version");
	}

	public String message(String namespace, AbstractMX obj, @SuppressWarnings("rawtypes") Class[] classes, String prefix, boolean includeXMLDeclaration) {
		throw new UnsupportedOperationException("For the moment this is only available in the integrator version");
	}

}

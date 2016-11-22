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

import com.prowidesoftware.swift.io.parser.MxParser;
import com.prowidesoftware.swift.model.MxId;
import com.prowidesoftware.swift.model.mx.AbstractMX;
import com.prowidesoftware.swift.model.mx.MxRead;

/**
 * For the moment this is only available in the Prowide Integrator version.
 * 
 * To parse XML into the generic MxNode structure, or to parse business headers check {@linkplain MxParser}
 */
/*
 * 2015.03 miguel
 * This interface is not going to make much sense since MxParser will support directly MxNode,
 * which was supposed to be here initially
 */
public class MxReadCoreV1 implements MxRead {

	/**
	 * For the moment this is only available in the Prowide Integrator version
	 */
	public AbstractMX read(final Class<? extends AbstractMX> targetClass, final String xml, final Class<? extends Object>[] classes) {
		throw new UnsupportedOperationException("For the moment this is only available in the integrator version");
	}

	/**
	 * For the moment this is only available in the Prowide Integrator version
	 */
	public AbstractMX read(String xml, MxId id) {
		throw new UnsupportedOperationException("For the moment this is only available in the integrator version");
	}

}

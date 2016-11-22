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

import com.prowidesoftware.swift.model.mx.MxRead;
import com.prowidesoftware.swift.model.mx.MxWrite;

/**
 * Helper class to find implementation of interfaces
 *
 * @since 7.6
 */
public class Resolver {

	private Resolver() {}
	
	/**
	 * Returns the available implementation of the MxWrite interface depending if the runtime is Prowide Core or Prowide Integrator.
	 * @return a specific implementation of the MxWrite interface
	 */
	public static MxWrite mxWrite() {
		try {
			return (MxWrite) Class.forName("com.prowidesoftware.swift.model.mx.MxWriteIntegartorV1").newInstance();
		} catch (Exception ignored) {
			return new MxWriteCoreV1();
		}
	}

	/**
	 * Returns the available implementation of the MxRead interface depending if the runtime is Prowide Core or Prowide Integrator.
	 * @return a specific implementation of the MxRead interface
	 */
	public static MxRead mxRead() {
		try {
			return (MxRead) Class.forName("com.prowidesoftware.swift.model.mx.MxReadIntegratorV1").newInstance();
		} catch (Exception ignored) {
			return new MxReadCoreV1();
		}
	}
}

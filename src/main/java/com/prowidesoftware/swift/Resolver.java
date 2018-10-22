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

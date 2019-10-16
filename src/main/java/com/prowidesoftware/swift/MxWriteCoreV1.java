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

	public String message(String namespace, AbstractMX obj, @SuppressWarnings("rawtypes") Class[] classes, String prefix, boolean includeXMLDeclaration) {
		throw new UnsupportedOperationException("For the moment this is only available in the integrator version");
	}

}

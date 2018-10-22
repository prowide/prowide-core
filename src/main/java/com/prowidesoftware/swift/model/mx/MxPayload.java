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
package com.prowidesoftware.swift.model.mx;

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

/**
 * <b>This class will be deleted and will not be available in 2017.
 * Business header may be used from AbstractMX</b>
 * @deprecated 
 */
@Deprecated
@ProwideDeprecated(phase4=TargetYear._2019)
public class MxPayload {
	private BusinessHeader header;
	private IDocument document;

	public BusinessHeader getHeader() {
		return header;
	}

	public void setHeader(final BusinessHeader header) {
		this.header = header;
	}

	public IDocument getDocument() {
		return document;
	}
	public void setDocument(final IDocument document) {
		this.document = document;
	}

}

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
package com.prowidesoftware.swift.model.mx;

import com.prowidesoftware.swift.DeleteSchedule;

/**
 * <b>This class will be deleted and will not be available in 2017.
 * Business header may be used from AbstractMX</b>
 * @deprecated 
 */
@Deprecated
@DeleteSchedule(2017)
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

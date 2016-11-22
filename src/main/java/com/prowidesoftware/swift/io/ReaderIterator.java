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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.prowidesoftware.swift.DeleteSchedule;

/**
 * @deprecated us {@linkplain RJEReader} instead 
 * @author www.prowidesoftware.com
 */
@Deprecated
@DeleteSchedule(2017)
public class ReaderIterator extends RJEReader {
	
	public ReaderIterator(Reader r) {
		super(r);
	}
	
	public static ReaderIterator fromResource(String string) {
		//InputStream s = Thread.currentThread().getContextClassLoader().getResourceAsStream(string);
		InputStream s = ReaderIterator.class.getClassLoader().getResourceAsStream(string);
		if (s!=null) {
			return new ReaderIterator(new InputStreamReader(s));
		}
		return null;
	}
}

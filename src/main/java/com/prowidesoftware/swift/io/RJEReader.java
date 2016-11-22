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
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Logger;

/**
 * Helper class to read RJE files.
 * <br />
 * File content is splitted, and the iterator returns the raw message content of
 * each SWIFT message found in the file. API is also provided to read each message 
 * parsed into an MT..
 * <br /> 
 * The reader can be initialized with a File, Stream or String.
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
public class RJEReader extends AbstractReader {
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(RJEReader.class.getName());
	static char SPLITCHAR = '$'; 
	
	/**
	 * Constructs a RJEReader to read messages from a given Reader instance
	 */
	public RJEReader(Reader r) {
		super(r);
	}

	/**
	 * Constructs a RJEReader to read messages from a string
	 */
	public RJEReader(final String string) {
		super(string);
	}

	/**
	 * Constructs a RJEReader to read messages from a stream
	 */
	public RJEReader(final InputStream stream) {
		super(stream);
	}

	/**
	 * Constructs a RJEReader to read messages from a file
	 */
	public RJEReader(final File file) throws FileNotFoundException {
		super(file);
	}

	/**
	 * Returns true if the iterator has more messages
	 */
	/*
	 * sebastian abr 2016
	 * si el contenido es blank porque hay un separador al final del file
	 * esto devuelve true, cuando seria deseable que devuelva false
	 */
	public boolean hasNext() {
		try {
			return reader.ready();
		} catch (IOException unused) {
			return false;
		}
	}

	/**
	 * Returns the next message in the iterator in its raw format
	 */
	@Override
	public String next() {
		if (reader!=null) {
			int c;
			StringBuilder sb = new StringBuilder();
			try {
				while ((c=reader.read())!=-1 && (c!=SPLITCHAR)) {
					sb.append((char)c);
				}
				if (c==-1) {
					reader.close();
				}
			} catch (IOException unused) {
				return null;
			}
			return sb.toString();
		}
		return null;
	}
}

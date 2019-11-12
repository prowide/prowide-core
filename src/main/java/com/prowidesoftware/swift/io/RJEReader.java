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
package com.prowidesoftware.swift.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Helper class to read RJE files.
 * <br>
 * File content is splitted, and the iterator returns the raw message content of
 * each SWIFT message found in the file. API is also provided to read each message 
 * parsed into an MT..
 * <br>
 * The reader can be initialized with a File, Stream or String.
 * 
 * @since 7.8
 */
public class RJEReader extends AbstractReader {
	public static final char SPLITCHAR = '$';

	private char splitChar = SPLITCHAR;
	
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
	 * Constructs a RJEReader to read messages from a stream using the default encoding
	 *
	 * <p>If you need to read the stream with a different encoding you can use
	 * {@link com.prowidesoftware.swift.utils.Lib#readStream(InputStream, String)}
	 * with the constructor receiving the String content
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
				while ((c=reader.read())!=-1 && (c!= splitChar)) {
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

	/**
	 * Overwrites the default standard split char {@link #SPLITCHAR}
	 * @param c a character to use as message separator
	 * @since 7.9.7
	 */
	public void setSplitChar(final char c) {
		this.splitChar = c;
	}

}
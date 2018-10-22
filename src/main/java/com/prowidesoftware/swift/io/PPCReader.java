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
import java.util.logging.Logger;

/**
 * Helper class to read DOS-PCC files.
 * <br>
 * File content is splitted, and the iterator returns the raw message content of
 * each SWIFT message found in the file. API is also provided to read each message 
 * parsed into an MT.
 * <br>
 * The reader can be initialized with a File, Stream or String.
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
/*
 * sebastian ago 2016: 
 * According to documentation all messages must be precede with its ack.
 * TODO: Remove the ack and parse the unparsed text here to return the actual MT
 */
public class PPCReader extends AbstractReader {
	private static final Logger log = Logger.getLogger(PPCReader.class.getName());

	static final int BEGIN = 0x01;
	static final int END = 0x03;
	static final int NULL = 0x00;
	static final int EMPTY = 0x20;
	
	private int curChar = 0;

	/**
	 * Constructs a PPCReader to read messages from a given Reader instance
	 */
	public PPCReader(Reader r) {
		super(r);
	}
	
	/**
	 * Constructs a PPCReader to read messages from a string
	 */
	public PPCReader(final String string) {
		super(string);
	}

	/**
	 * Constructs a PPCReader to read messages from a stream
	 */
	public PPCReader(final InputStream stream) {
		super(stream);
	}

	/**
	 * Constructs a PPCReader to read messages from a file
	 */
	public PPCReader(final File file) throws FileNotFoundException {
		super(file);
	}

	/**
	 * Returns true if the iterator has more messages
	 */
	public boolean hasNext() {
		if (this.reader == null) {
			throw new IllegalStateException("reader is null");
		}
		while (curChar != -1 && curChar != BEGIN) {
			try {
				curChar = this.reader.read();
			} catch (final IOException e) {
				log.severe("IOException while reading: " + e);
				return false;
			}
		}
		return curChar == BEGIN;
	}

	/**
	 * Returns the next message in the iterator in its raw format
	 */
	@Override
	public String next() {
		if (curChar == BEGIN) {
			final StringBuilder sb = new StringBuilder();

			boolean done = false;
			do {
				try {
					curChar = this.reader.read();
				} catch (final IOException e) {
					log.severe("error reading: " + e);
					return sb.toString();
				}
				if (curChar == -1 || curChar == END) {
					done = true;
				} else {
					sb.append((char) curChar);
				}
			} while (!done);
			return sb.toString();
		} else {
			throw new IllegalStateException("hasNext did not return true but this method was called");
		}
	}
}

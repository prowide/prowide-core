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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.AbstractMT;

/**
 * Base class for message reader iterators.
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
public abstract class AbstractReader implements Iterator<String>, Iterable<String> {
	private static final Logger log = Logger.getLogger(AbstractReader.class.getName());
	protected Reader reader = null;
	
	/**
	 * Constructs a reader to read messages from a given Reader instance
	 */
	public AbstractReader(Reader r) {
		this.reader = r;
	}
	
	/**
	 * Constructs a reader to read messages from a string
	 * @throws IllegalArgumentException if string is <code>null</code>
	 */
	public AbstractReader(final String string) {
		Validate.notNull(string, "string must not be null");
		this.reader = new StringReader(string);
	}

	/**
	 * Constructs a reader to read messages from a stream
	 * @throws IllegalArgumentException if stream is <code>null</code>
	 */
	public AbstractReader(final InputStream stream) {
		Validate.notNull(stream, "stream must not be null");
		this.reader = new InputStreamReader(stream);
	}

	/**
	 * Constructs a reader to read messages from a file
	 * @throws IllegalArgumentException if file is <code>null</code>
	 */
	public AbstractReader(final File file) throws FileNotFoundException {
		Validate.notNull(file, "file must not be null");
		Validate.isTrue(file.exists(), "Non existent file: "+file.getAbsolutePath());
		this.reader = new FileReader(file);
	}
	
	public Iterator<String> iterator() {
		return this;
	}

	public abstract String next();

	public void remove() {
		throw new UnsupportedOperationException("remove not avaiable in this implementation");
	}
	
	/**
	 * Reads the next raw content from the iterator and returns the message parsed into an MT.
	 * <br /><br />
	 * Important Note: Since MTnnn model clases are implemented only for user messages 
	 * (categories 1 to 9) if an ACK/NAK (F21) message is found, the MT following the system 
	 * message is returned (not the ACK/NAK).
	 * <br />
	 * For FIN and system messages support use {@link #nextSwiftMessage()} 
	 * 
	 * @return parsed message or null if content is blank
	 * @throws IOException if the message content cannot be parsed into an MT
	 */
	public AbstractMT nextMT() throws IOException {
		SwiftMessage candidate = nextSwiftMessage();
		if (candidate != null) {
			if (candidate.isSystemMessage()) {
				final String fin = candidate.getUnparsedTexts().getAsFINString();
				SwiftParser parser = new SwiftParser(new ByteArrayInputStream(fin.getBytes()));
				return parser.message().toMT();
			} else {
				return candidate.toMT();
			}
		}
		return null;
	}
	
	/**
	 * Reads the next raw content from the iterator and returns the message parsed as a generic SwiftMessage.
	 * 
	 * @return parsed message or null if content is blank
	 * @throws IOException if the message content cannot be parsed into an SwiftMessage
	 * @since 7.8.3
	 */
	public SwiftMessage nextSwiftMessage() throws IOException {
		final String msg = next();
		if (StringUtils.isNotBlank(msg)) {
			SwiftParser parser = new SwiftParser(new ByteArrayInputStream(msg.getBytes()));
			return parser.message();
		}
		log.warning("Message content cannot be parsed as MT");
		return null;
	}

}

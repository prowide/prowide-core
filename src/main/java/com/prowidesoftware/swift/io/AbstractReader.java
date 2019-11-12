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

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.io.*;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Base class for message reader iterators.
 * 
 * @since 7.8
 */
public abstract class AbstractReader implements Iterator<String>, Iterable<String> {
	private static final Logger log = Logger.getLogger(AbstractReader.class.getName());
	protected Reader reader;
	private boolean usedAsIterable = false;
	
	/**
	 * Constructs a reader to read messages from a given Reader instance
	 */
	public AbstractReader(Reader r) {
		this.reader = r;
	}
	
	/**
	 * Constructs a reader to read messages from a string
	 * @throws IllegalArgumentException if string is null
	 */
	public AbstractReader(final String string) {
		Validate.notNull(string, "string must not be null");
		this.reader = new StringReader(string);
	}

	/**
	 * Constructs a reader to read messages from a stream
	 * @throws IllegalArgumentException if stream is null
	 */
	public AbstractReader(final InputStream stream) {
		Validate.notNull(stream, "stream must not be null");
		this.reader = new InputStreamReader(stream);
	}

	/**
	 * Constructs a reader to read messages from a file
	 * @throws IllegalArgumentException if file is null
	 */
	public AbstractReader(final File file) throws FileNotFoundException {
		Validate.notNull(file, "file must not be null");
		Validate.isTrue(file.exists(), "Non existent file: "+file.getAbsolutePath());
		this.reader = new FileReader(file);
	}

	/**
	 * @return this object as an Iterator
	 * @throws IllegalArgumentException if the iteration is attempted more than once
	 * @deprecated the use of this object as Iterator is discourage because its internal reader can be iterated just once, use it as Iterable instead
	 */
	@Deprecated
	@ProwideDeprecated(phase2 = TargetYear.SRU2020)
	public Iterator<String> iterator() throws IllegalArgumentException {
		if (usedAsIterable) {
			throw new IllegalStateException("This reader has already been used as iterator and the implementation does not support multiple iterations, create another reader instead");
		}
		usedAsIterable = true;
		return this;
	}

	public abstract String next();

	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove() not available in this implementation");
	}
	
	/**
	 * Reads the next raw content from the iterator and returns the message parsed into an MT.
	 * <p>IMPORTANT:<br>
	 * Since MTnnn model classes are implemented only for system and user-to-user messages 
	 * (categories 0 to 9) if an ACK/NAK (service id 21) message is found, the MT following 
	 * the system message is returned (not the ACK/NAK).<br>
	 * For other service messages (login, select, quit) this method will return null because 
	 * there is no MT representation to create.<br>
	 * If you need to deal with all type of messages (including service, system and user-to-user)
	 * you can use {@link #nextSwiftMessage()} instead.
	 * 
	 * @return parsed message or null if content is blank
	 * @throws IOException if the message content cannot be parsed into an MT
	 */
	public AbstractMT nextMT() throws IOException {
		SwiftMessage candidate = nextSwiftMessage();
		if (candidate != null) {
			if (candidate.isServiceMessage21()) {
				/*
				 * message is an ACK/NACK, we parse the appended original message instead
				 */
				final String fin = candidate.getUnparsedTexts().getAsFINString();
				return AbstractMT.parse(fin);
			} else if (candidate.isServiceMessage()) {
				log.warning("nextMT in "+getClass().getName()+" is not intended for service messages, use nextSwiftMessage() instead");
				return null;
			} else {
				return candidate.toMT();
			}
		}
		return null;
	}
	
	/**
	 * Reads the next raw content from the iterator and returns the message parsed as a generic SwiftMessage.
	 * This method is convenient where the RJE content can include any type of message including
	 * service messages, system messages and user-to-user messages.
	 * 
	 * @return parsed message or null if content is blank
	 * @throws IOException if the message content cannot be parsed into a SwiftMessage
	 * @since 7.8.3
	 */
	public SwiftMessage nextSwiftMessage() throws IOException {
		final String msg = next();
		if (StringUtils.isNotBlank(msg)) {
			return SwiftMessage.parse(msg);
		}
		log.warning("Ignoring blank message");
		return null;
	}

}

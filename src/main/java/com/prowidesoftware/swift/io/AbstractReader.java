/*
 * Copyright 2006-2023 Prowide
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

import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Objects;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * Base class for message reader iterators.
 *
 * @since 7.8
 */
public abstract class AbstractReader implements Iterator<String>, Iterable<String> {
    private static final Logger LOGGER = Logger.getLogger(AbstractReader.class.getName());
    /** The wrapped reader instance. */
    protected Reader reader;

    private boolean usedAsIterable;

    /**
     * Constructs a reader to read messages from a given Reader instance
     * @param r reader instance
     */
    protected AbstractReader(Reader r) {
        this.reader = r;
    }

    /**
     * Constructs a reader to read messages from a string
     * @param string  String providing the character stream.
     * @throws IllegalArgumentException if string is null
     */
    protected AbstractReader(final String string) {
        Objects.requireNonNull(string, "string must not be null");
        this.reader = new StringReader(string);
    }

    /**
     * Constructs a reader to read messages from a stream
     *
     * @param stream input stream
     * @throws IllegalArgumentException if stream is null
     */
    protected AbstractReader(final InputStream stream) {
        this(stream, null);
    }

    protected AbstractReader(final InputStream _stream, final Charset _charset) {
        Objects.requireNonNull(_stream, "stream must not be null");
        this.reader = new InputStreamReader(_stream, _charset != null ? _charset : StandardCharsets.UTF_8);
    }

    /**
     * Constructs a reader to read messages from a file
     *
     * @param file file
     * @throws FileNotFoundException if the file does not exist, is a directory or cannot be opened
     * @throws IllegalArgumentException if file is null
     */
    protected AbstractReader(final File file) throws FileNotFoundException {
        this(file, null);
    }

    protected AbstractReader(final File inputFile, Charset inputCharset) throws FileNotFoundException {
        Objects.requireNonNull(inputFile, "file must not be null");
        Validate.isTrue(inputFile.exists(), "Non existent file: " + inputFile.getAbsolutePath());
        this.reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(inputFile), inputCharset != null ? inputCharset : StandardCharsets.UTF_8));
    }

    @Override
    public abstract String next();

    @Override
    public abstract boolean hasNext();

    /**
     * @return this object as an Iterator
     * @throws IllegalArgumentException if the iteration is attempted more than once
     */
    @Override
    public Iterator<String> iterator() throws IllegalArgumentException {
        if (usedAsIterable) {
            throw new IllegalStateException("This reader has already been used as Iterator and the implementation does "
                    + "not support multiple iterations, create another reader instance instead");
        }
        usedAsIterable = true;
        return this;
    }

    /**
     * Reads the next raw content from the iterator and returns the message parsed into an MT.
     *
     * <p>IMPORTANT:<br>
     * Since MTnnn model classes are implemented only for system and user-to-user messages (categories 0 to 9) if an
     * ACK/NAK (service id 21) message is found, the MT following the system message is returned (not the ACK/NAK).<br>
     * For other service messages (login, select, quit) this method will return null because there is no MT
     * representation to create.<br>
     * If you need to deal with all type of messages (including service, system and user-to-user) you can use
     * {@link #nextSwiftMessage()} instead.
     *
     * @return parsed message or null if content is blank
     * @throws IOException if the message content cannot be parsed into an MT
     */
    public AbstractMT nextMT() throws IOException {
        SwiftMessage candidate = nextSwiftMessage();
        if (candidate != null) {
            if (candidate.isServiceMessage21()) {
                // message is an ACK/NACK, we parse the appended original message instead
                final String fin = candidate.getUnparsedTexts().getAsFINString();
                return AbstractMT.parse(fin);
            } else if (candidate.isServiceMessage()) {
                LOGGER.warning("nextMT in " + getClass().getName()
                        + " is not intended for service messages, use nextSwiftMessage() instead");
                return null;
            } else {
                return candidate.toMT();
            }
        }
        return null;
    }

    /**
     * Reads the next raw content from the iterator and returns the message parsed as a generic SwiftMessage.
     * This method is convenient where the RJE content can include any type of message including service messages,
     * system messages and user-to-user messages.
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
        LOGGER.warning("Ignoring blank message");
        return null;
    }
}

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

import java.io.*;
import java.nio.charset.Charset;
import java.util.logging.Logger;

/**
 * Helper class to read the legacy DOS-PCC files.
 * <p>
 * File content is split, and the iterator returns the raw message content of each SWIFT message found in the file.
 * API is also provided to read each message parsed into an MT.
 * <p>
 * The reader can be created from a String but also from a Reader, File or Stream; thus when used as an iterator you
 * can iterate it just once, it is not re-entrant.
 *
 * @since 7.8
 */
public class PPCReader extends AbstractReader {
    static final int BEGIN = 0x01;
    static final int END = 0x03;
    static final int EMPTY = 0x20;
    private static final Logger log = Logger.getLogger(PPCReader.class.getName());
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

    public PPCReader(final InputStream stream) {
        super(stream, null);
    }

    /**
     * Constructs a PPCReader to read messages from an input stream using the specified charset.
     *
     * @param _stream stream to read
     * @param _charset charset
     */
    public PPCReader(final InputStream _stream, final Charset _charset) {
        super(_stream, _charset);
    }

    public PPCReader(final File file) throws FileNotFoundException {
        super(file, null);
    }

    /**
     * Constructs a PPCReader to read messages from a file using the specified charset.
     *
     * @param _file file to read
     * @param _charset charset
     * @throws FileNotFoundException if file does not exist
     */
    public PPCReader(final File _file, final Charset _charset) throws FileNotFoundException {
        super(_file, _charset);
    }

    /**
     * Returns true if the iterator has more messages
     */
    @Override
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
            return sb.toString().trim();
        } else {
            throw new IllegalStateException("hasNext did not return true but this method was called");
        }
    }
}

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

/**
 * Helper class to read RJE files.
 *
 * <p>
 * File content is splitted, and the iterator returns the raw message content of each SWIFT message found in the file.
 * API is also provided to read each message parsed into an MT..
 *
 * <p>
 * The reader can be created from a String but also from a Reader, File or Stream; thus when used as an iterator you
 * can iterate it just once, it is not re-entrant.
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

    public RJEReader(final InputStream stream) {
        super(stream, null);
    }

    /**
     * Constructs a {@link RJEReader} to read messages from an input stream using the specified charset.
     * @param _stream stream to read
     * @param _charset charset
     */
    public RJEReader(final InputStream _stream, final Charset _charset) {
        super(_stream, _charset);
    }

    public RJEReader(final File file) throws FileNotFoundException {
        super(file, null);
    }

    /**
     * Constructs a {@link RJEReader} to read messages from a file using the specified charset.
     *
     * @param _file file to read
     * @param _charset charset
     * @throws FileNotFoundException if file does not exist
     */
    public RJEReader(final File _file, final Charset _charset) throws FileNotFoundException {
        super(_file, _charset);
    }

    /**
     * Returns true if the iterator has more messages.
     * If the RJE file ends with a separator, this will return true, meaning the iteration will return a blank message
     * at the end.
     */
    @Override
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
        if (reader != null) {
            int c;
            StringBuilder sb = new StringBuilder();
            try {
                while ((c = reader.read()) != -1 && c != splitChar) {
                    sb.append((char) c);
                }
                if (c == -1) {
                    reader.close();
                }
            } catch (IOException unused) {
                return null;
            }
            return sb.toString().trim();
        }
        return null;
    }

    /**
     * Overwrites the default standard split char {@link #SPLITCHAR}
     *
     * @param c a character to use as message separator
     * @since 7.9.7
     */
    public void setSplitChar(final char c) {
        this.splitChar = c;
    }
}

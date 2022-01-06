/*
 * Copyright 2006-2021 Prowide
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

/**
 * Base implementation for message writers.
 * <br>
 * Messages are converted into its FIN representation and written
 * into the output file with proper delimiters and length.
 * <br>
 * The writer can be used in two different ways:
 * <ul>
 * <li>Writing messages directly into given Writer object, using the
 * static write call method.</li>
 * <li>Instantiating the writer for a particular File or stream, calling
 * the write methods and closing the writer when all messages has been written</li>
 * </ul>
 *
 * @author sebastian
 * @since 7.8
 */
public abstract class AbstractWriter {
    protected Writer writer;

    /**
     * Constructs a writer to write content into a given Writer instance.
     *
     */
    public AbstractWriter(final Writer writer) {
        this.writer = writer;
    }

    /**
     * Constructs a writer to write content into a file.
     *
     */
    public AbstractWriter(final File file) throws FileNotFoundException {
        this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
    }

    /**
     * Constructs a writer to write content into a file.
     *
     * @param filename file to create
     */
    public AbstractWriter(final String filename) throws FileNotFoundException {
        this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
    }

    /**
     * Constructs a writer to write content into a given stream.
     *
     */
    public AbstractWriter(final OutputStream stream) {
        this.writer = new BufferedWriter(new OutputStreamWriter(stream));
    }

    /**
     * Close the stream.
     *
     * @throws IOException if an I/O error occurs
     */
    public void close() throws IOException {
        if (this.writer != null) {
            this.writer.close();
        }
    }

    /**
     * Flush the stream.
     *
     * @throws IOException if an I/O error occurs
     */
    public void flush() throws IOException {
        if (this.writer != null) {
            this.writer.flush();
        }
    }

}

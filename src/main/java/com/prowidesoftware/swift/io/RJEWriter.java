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

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * Helper API to write MT messages into RJE files.
 *
 * @see AbstractWriter
 * @since 7.8
 */
public class RJEWriter extends AbstractWriter {

    private static final String MESSAGE_TO_WRITE_CONDITION = "message to write cannot be null";
    private static final String WRITER_MESSAGE = "writer has not been initialized";
    private int count = 0;
    private char splitChar = RJEReader.SPLITCHAR;

    /**
     * Constructs a RJEWriter to write content into a given Writer instance.
     *
     */
    public RJEWriter(final Writer writer) {
        super(writer);
    }

    public RJEWriter(final File file) throws FileNotFoundException {
        super(file);
    }

    public RJEWriter(final String filename) throws FileNotFoundException {
        super(filename);
    }

    /**
     * Constructs a {@link RJEWriter} to write content into a file using the specified charset.
     *
     * @param _file file to write to
     * @param _charset charset
     */
    public RJEWriter(final File _file, final Charset _charset) throws FileNotFoundException {
        super(_file, _charset);
    }

    public RJEWriter(final OutputStream stream) {
        super(stream);
    }

    /**
     * Constructs a {@link RJEWriter} to write content to the specified output stream using the specified charset.
     *
     * @param _stream stream to write to
     * @param _charset charset
     */
    public RJEWriter(final OutputStream _stream, final Charset _charset) {
        super(_stream, _charset);
    }

    /**
     * @param msg    message to write
     * @throws IOException if an I/O error occurs
     * @see #write(String, Writer)
     */
    public static void write(final AbstractMT msg, final Writer writer) throws IOException {
        Objects.requireNonNull(msg, MESSAGE_TO_WRITE_CONDITION);
        write(msg.message(), writer);
    }

    /**
     * Static implementation to write the message content into the parameter writer in RJE format.
     *
     * <p>IMPORTANT: this method will always append a trailing CRLF and $ at the end which
     * in some platforms can be rejected as an invalid RJE file. For a more compliant version
     * use the non static implementation of the write calls, to ensure the split separator
     * is present only between messages but not after the last one. Also notice this method
     * implementation cannot use custom split separator chars.
     *
     * @param msg    SWIFT MT content to write
     * @throws IOException if an I/O error occurs
     */
    public static void write(final String msg, final Writer writer) throws IOException {
        Objects.requireNonNull(writer, WRITER_MESSAGE);
        Objects.requireNonNull(msg, MESSAGE_TO_WRITE_CONDITION);
        writer.write(msg);
        writer.write(FINWriterVisitor.SWIFT_EOL);
        writer.write(RJEReader.SPLITCHAR);
        writer.write(FINWriterVisitor.SWIFT_EOL);
    }

    /**
     * Writes the message content into the internal writer in RJE format.
     *
     * @param msg SWIFT MT content to write
     * @throws IOException if an I/O error occurs
     */
    public void write(final String msg) throws IOException {
        _write(msg, super.writer);
    }

    /**
     * Writes the message into the internal writer in RJE format
     *
     * @param msg message to write
     * @throws IOException if an I/O error occurs
     */
    public void write(final AbstractMT msg) throws IOException {
        _write(msg.message(), this.writer);
    }

    private void _write(final String msg, final Writer writer) throws IOException {
        Objects.requireNonNull(writer, WRITER_MESSAGE);
        Objects.requireNonNull(msg, MESSAGE_TO_WRITE_CONDITION);
        if (count > 0) {
            writer.write(FINWriterVisitor.SWIFT_EOL);
            writer.write(splitChar);
            writer.write(FINWriterVisitor.SWIFT_EOL);
        }
        writer.write(msg);
        count++;
    }

    /**
     * Overwrites the default standard split char {@link RJEReader#SPLITCHAR}
     *
     * @param c a character to use as message separator
     * @since 7.9.7
     */
    public void setSplitChar(final char c) {
        this.splitChar = c;
    }
}

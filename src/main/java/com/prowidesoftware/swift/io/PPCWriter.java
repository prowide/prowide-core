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

import com.prowidesoftware.swift.model.mt.AbstractMT;
import org.apache.commons.lang3.Validate;

import java.io.*;

/**
 * Helper API to write MT messages into DOS-PCC files.
 *
 * @author sebastian
 * @see AbstractWriter
 * @since 7.8
 */
/*
 * sebastian ago 2016:
 * According to documentation all messages must be precede with its ack.
 * TODO: Use SwiftMessageFactory to create and prepend the ACK here
 */
public class PPCWriter extends AbstractWriter {
    private static final int SECTOR = 512;

    /**
     * Constructs a PPCWriter to write content into a given Writer instance.
     *
     */
    public PPCWriter(final Writer writer) {
        super(writer);
    }

    /**
     * Constructs a PPCWriter to write content into a file.
     *
     */
    public PPCWriter(final File file) throws FileNotFoundException {
        super(file);
    }

    /**
     * Constructs a PPCWriter to write content into a file.
     *
     * @param filename file to create
     */
    public PPCWriter(final String filename) throws FileNotFoundException {
        super(filename);
    }

    /**
     * Constructs a PPCWriter to write content into a given stream.
     *
     */
    public PPCWriter(final OutputStream stream) {
        super(stream);
    }

    /**
     * Writes the message into the writer in DOS-PPC format
     *
     * @param msg    message to write
     * @throws IOException if an I/O error occurs
     */
    public static void write(final AbstractMT msg, final Writer writer) throws IOException {
        Validate.notNull(msg, "message to write cannot be null");
        write(msg.message(), writer);
    }

    /**
     * Writes the message content into the writer in DOS-PPC format
     *
     * @param msg    SWIFT MT content to write
     * @throws IOException if an I/O error occurs
     */
    /*
     * According to the specification content should be written in 8-bit ASCII
     * We use Java default, UTF-8, that is compatible for SWIFT message content.
     */
    public static void write(final String msg, final Writer writer) throws IOException {
        Validate.notNull(writer, "writer has not been initialized");
        Validate.notNull(msg, "message to write cannot be null");
        writer.write(PPCReader.BEGIN);
        writer.write(msg);
        writer.write(PPCReader.END);

        // pad to fill sector length
        int length = msg.length() + 2;
        int pad = requiredPadding(length);
        for (int i = 0; i < pad; i++) {
            writer.write(PPCReader.EMPTY);
        }
    }

    /**
     * Computes the padding to match the sector multiple
     * Thanks https://github.com/safet-habibija for the fix
     *
     * @param length current message length
     * @return number of empty characters to append as padding
     */
    private static int requiredPadding(int length) {
        return (SECTOR - (length % SECTOR)) % SECTOR;
    }

    /**
     * Writes the message content into the internal writer in DOS-PPC format.
     *
     * @param msg SWIFT MT content to write
     * @throws IOException if an I/O error occurs
     */
    public void write(final String msg) throws IOException {
        write(msg, super.writer);
    }

    /**
     * Writes the message into the internal writer in DOS-PPC format
     *
     * @param msg message to write
     * @throws IOException if an I/O error occurs
     */
    public void write(final AbstractMT msg) throws IOException {
        write(msg, this.writer);
    }

}

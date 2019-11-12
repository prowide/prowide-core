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

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import org.apache.commons.lang3.Validate;

import java.io.*;

/**
 * Helper API to write MT messages into RJE files.
 * @see AbstractWriter
 * 
 * @since 7.8
 */
public class RJEWriter extends AbstractWriter {

	private int count = 0;

	private char splitChar = RJEReader.SPLITCHAR;

	private static final String MESSAGE_TO_WRITE_CONDITION = "message to write cannot be null";
	private static final String WRITER_MESSAGE = "writer has not been initialized";


	/**
	 * Constructs a RJEWriter to write content into a given Writer instance.
	 * @param writer
	 */
	public RJEWriter(final Writer writer) {
		super(writer); 
	}

	/**
	 * Constructs a RJEWriter to write content into a file.
	 * @param file
	 * @throws FileNotFoundException 
	 */
	public RJEWriter(final File file) throws FileNotFoundException {
		super(file); 
	}
	
	/**
	 * Constructs a RJEWriter to write content into a file.
	 * @param filename file to create
	 * @throws FileNotFoundException 
	 */
	public RJEWriter(final String filename) throws FileNotFoundException {
		super(filename); 
	}
	
	/**
	 * Constructs a RJEWriter to write content into a given stream.
	 * @param stream
	 */
	public RJEWriter(final OutputStream stream) {
		super(stream);
	}
	
	/**
	 * Writes the message content into the internal writer in RJE format.
	 * @param msg SWIFT MT content to write
	 * @throws IOException if an I/O error occurs
	 */	
    public void write(final String msg) throws IOException {
    	_write(msg, super.writer);
    }
    
    /**
     * Writes the message into the internal writer in RJE format
     * @param msg message to write
     * @throws IOException if an I/O error occurs
     */
    public void write(final AbstractMT msg) throws IOException {
    	_write(msg.message(), this.writer);
    }

    private void _write(final String msg, final Writer writer) throws IOException {
    	Validate.notNull(writer, WRITER_MESSAGE);
    	Validate.notNull(msg, MESSAGE_TO_WRITE_CONDITION);
    	if (count > 0) {
        	writer.write(FINWriterVisitor.SWIFT_EOL);
        	writer.write(splitChar);
        	writer.write(FINWriterVisitor.SWIFT_EOL);
    	}
    	writer.write(msg);
    	count++;
    }
    
    /**
     * @see #write(String, Writer)
     * @param msg message to write
     * @param writer
     * @throws IOException if an I/O error occurs
     */
    public static void write(final AbstractMT msg, final Writer writer) throws IOException {
    	Validate.notNull(msg, MESSAGE_TO_WRITE_CONDITION);
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
	 * @param msg SWIFT MT content to write
	 * @param writer
	 * @throws IOException if an I/O error occurs
	 */
    public static void write(final String msg, final Writer writer) throws IOException {
    	Validate.notNull(writer, WRITER_MESSAGE);
    	Validate.notNull(msg, MESSAGE_TO_WRITE_CONDITION);
    	writer.write(msg);
    	writer.write(FINWriterVisitor.SWIFT_EOL);
    	writer.write(RJEReader.SPLITCHAR);
    	writer.write(FINWriterVisitor.SWIFT_EOL);
    }

	/**
	 * Overwrites the default standard split char {@link RJEReader#SPLITCHAR}
	 * @param c a character to use as message separator
	 * @since 7.9.7
	 */
	public void setSplitChar(final char c) {
		this.splitChar = c;
	}

}

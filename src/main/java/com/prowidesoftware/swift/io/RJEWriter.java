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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.model.mt.AbstractMT;

/**
 * Helper API to write MT messages into RJE files.
 * @see AbstractWriter
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
public class RJEWriter extends AbstractWriter {

	private int count = 0;

	private char splitChar = RJEReader.SPLITCHAR;

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
    	Validate.notNull(writer, "writer has not been initialized");
    	Validate.notNull(msg, "message to write cannot be null");
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
    	Validate.notNull(msg, "message to write cannot be null");
    	write(msg.message(), writer);
    }
    
	/**
	 * Static implementation to write the message content into the parameter writer in RJE format.
	 * 
	 * <p>IMPORTANT: this method will always append a trailing CRLF and $ at the end which
	 * in some platforms can be rejected as an invalid RJE file. For a more compliant version
	 * use the non static implementation of the write calls, to ensure the split separator
	 * is present only between messages but not after the last one. Also notice this method
	 * implementation cannot use custom split separator chars.</p>
	 * 
	 * @param msg SWIFT MT content to write
	 * @param writer
	 * @throws IOException if an I/O error occurs
	 */
    public static void write(final String msg, final Writer writer) throws IOException {
    	Validate.notNull(writer, "writer has not been initialized");
    	Validate.notNull(msg, "message to write cannot be null");
    	writer.write(msg);
    	writer.write(FINWriterVisitor.SWIFT_EOL);
    	writer.write(RJEReader.SPLITCHAR);
    	writer.write(FINWriterVisitor.SWIFT_EOL);
    }

	/**
	 * Ovewrites the default standard split char {@link RJEReader#SPLITCHAR}
	 * @param c a character to use as message separator
	 * @since 7.9.7
	 */
	public void setSplitChar(final char c) {
		this.splitChar = splitChar;
	}

}

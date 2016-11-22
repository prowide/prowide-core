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
    	write(msg, super.writer);
    }
    
    /**
     * Writes the message into the internal writer in RJE format
     * @param msg message to write
     * @throws IOException if an I/O error occurs
     */
    public void write(final AbstractMT msg) throws IOException {
    	write(msg, this.writer);
    }
    
    /**
     * Writes the message into the writer in RJE format
     * @param msg message to write
     * @param writer
     * @throws IOException if an I/O error occurs
     */
    public static void write(final AbstractMT msg, final Writer writer) throws IOException {
    	Validate.notNull(msg, "message to write cannot be null");
    	write(msg.message(), writer);
    }
    
	/**
	 * Writes the message content into the writer in RJE format
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

}

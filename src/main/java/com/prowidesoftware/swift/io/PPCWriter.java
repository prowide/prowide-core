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

import com.prowidesoftware.swift.model.mt.AbstractMT;

/**
 * Helper API to write MT messages into DOS-PCC files.
 * @see AbstractWriter
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
/*
 * sebastian ago 2016: 
 * According to documentation all messages must be precede with its ack.
 * TODO: Use SwiftMessageFactory to create and prepend the ACK here
 */
public class PPCWriter extends AbstractWriter {

	/**
	 * Constructs a PPCWriter to write content into a given Writer instance.
	 * @param writer
	 */
	public PPCWriter(final Writer writer) {
		super(writer); 
	}

	/**
	 * Constructs a PPCWriter to write content into a file.
	 * @param file
	 * @throws FileNotFoundException 
	 */
	public PPCWriter(final File file) throws FileNotFoundException {
		super(file); 
	}
	
	/**
	 * Constructs a PPCWriter to write content into a file.
	 * @param filename file to create
	 * @throws FileNotFoundException 
	 */
	public PPCWriter(final String filename) throws FileNotFoundException {
		super(filename); 
	}
	
	/**
	 * Constructs a PPCWriter to write content into a given stream.
	 * @param stream
	 */
	public PPCWriter(final OutputStream stream) {
		super(stream);
	}
	
	/**
	 * Writes the message content into the internal writer in DOS-PPC format.
	 * @param msg SWIFT MT content to write
	 * @throws IOException if an I/O error occurs
	 */	
    public void write(final String msg) throws IOException {
    	write(msg, super.writer);
    }
    
    /**
     * Writes the message into the internal writer in DOS-PPC format
     * @param msg message to write
     * @throws IOException if an I/O error occurs
     */
    public void write(final AbstractMT msg) throws IOException {
    	write(msg, this.writer);
    }
    
    /**
     * Writes the message into the writer in DOS-PPC format
     * @param msg message to write
     * @param writer
     * @throws IOException if an I/O error occurs
     */
    public static void write(final AbstractMT msg, final Writer writer) throws IOException {
    	Validate.notNull(msg, "message to write cannot be null");
    	write(msg.message(), writer);
    }
    
	/**
	 * Writes the message content into the writer in DOS-PPC format
	 * @param msg SWIFT MT content to write
	 * @param writer
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
    	/*
    	 * pad to fill sector length
    	 */
    	int length = msg.length() + 2; 
    	int pad = length > 512? length % 512 : 512 - length;
    	for (int i=0; i<pad; i++) {
    		writer.write(PPCReader.EMPTY);
    	}  
    }

}

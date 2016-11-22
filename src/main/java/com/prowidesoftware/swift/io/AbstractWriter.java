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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Base implementation for message writers.
 * <br />
 * Messages are converted into its FIN representation and written
 * into the output file with proper delimiters and length.
 * <br />
 * The writer can be used in two different ways:
 * <ul>
 * <li>Writing messages directly into given Writer object, using the
 * static write call method.</li>
 * <li>Instantiating the writer for a particular File or stream, calling
 * the write methods and closing the writer when all messages has been written</li>
 * </ul>
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
public abstract class AbstractWriter {
	protected Writer writer = null;

	/**
	 * Constructs a writer to write content into a given Writer instance.
	 * @param writer
	 */
	public AbstractWriter(final Writer writer) {
		this.writer = writer;
	}
	
	/**
	 * Constructs a writer to write content into a file.
	 * @param file
	 * @throws FileNotFoundException 
	 */
	public AbstractWriter(final File file) throws FileNotFoundException {
		this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))); 
	}
	
	/**
	 * Constructs a writer to write content into a file.
	 * @param filename file to create
	 * @throws FileNotFoundException 
	 */
	public AbstractWriter(final String filename) throws FileNotFoundException {
		this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename))); 
	}
	
	/**
	 * Constructs a writer to write content into a given stream.
	 * @param stream
	 */
	public AbstractWriter(final OutputStream stream) {
		this.writer = new BufferedWriter(new OutputStreamWriter(stream));
	}
    
    /**
     * Close the stream.
     * @throws IOException if an I/O error occurs
     */
    public void close() throws IOException {
    	if (this.writer != null) {
    		this.writer.close();
    	}
    }
    
    /**
     * Flush the stream.
     * @throws IOException if an I/O error occurs
     */
    public void flush() throws IOException {
    	if (this.writer != null) {
    		this.writer.flush();
    	}
    }
    
}

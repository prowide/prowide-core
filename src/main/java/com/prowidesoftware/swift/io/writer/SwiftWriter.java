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
package com.prowidesoftware.swift.io.writer;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftMessage;

/**
 * Helper API to write MT message content into native SWIFT format.
 * 
 * <p>This class handles writing swift messages exclusively, 
 * all validation and consistency checks must be done
 * previous to using the writer.</p>
 * 
 * @author www.prowidesoftware.com
 */
public class SwiftWriter {
    //private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftWriter.class.getName());

    /**
     * Write the given message to writer in its native SWIFT format
     * 
     * @param msg the message to write
     * @param writer the writer that will actually receive all the write operations
     * @throws IllegalArgumentException if msg or writer are <code>null</code>
     */
    public static void writeMessage(SwiftMessage msg, Writer writer) {
    	Validate.notNull(msg , "msg cannot be null");
    	Validate.notNull(writer, "writer cannot be null");
    	FINWriterVisitor v = new FINWriterVisitor(writer);
    	msg.visit(v);
    }
    
    /**
     * Get a string with the internal xml representation of a message.
     * @param msg the message to write 
     * @return a string with an internal xml representation of the message
     * @throws IllegalArgumentException if msg is <code>null</code>
     */
    public static String getInternalXml(SwiftMessage msg) {
    	Validate.notNull(msg , "msg cannot be null");
    	StringWriter w = new StringWriter();
    	XMLWriterVisitor visitor = new XMLWriterVisitor(w);
    	msg.visit(visitor);
    	return w.toString();
    }

    /**
     * Write the given block to writer in its native SWIFT format
     * 
     * @param b1 a not null block 1
     * @param writer
     * @since 7.8.6
     */
    public static void writeBlock1(SwiftBlock1 b1, Writer writer) {
    	Validate.notNull(b1, "b1 cannot be null");
    	Validate.notNull(writer, "writer cannot be null");
    	FINWriterVisitor visitor = new FINWriterVisitor(writer);
		visitor.startBlock1(b1);
		visitor.value(b1, b1.getValue());
		visitor.endBlock1(b1);
    }
    
    /**
     * Returns the given block content in its native SWIFT format
     * 
     * @param b1 a not null block 1
     * @since 7.8.6
     */
    public static String writeBlock1(SwiftBlock1 b1) {
    	StringWriter w = new StringWriter();
    	writeBlock1(b1, w);
    	return w.toString();
    }

    /**
     * Write the given block to writer in its native SWIFT format
     * 
     * @param b2 a not null block 2
     * @param writer
     * @since 7.8.6
     */
    public static void writeBlock2(SwiftBlock2 b2, Writer writer) {
    	Validate.notNull(b2, "b2 cannot be null");
    	Validate.notNull(writer, "writer cannot be null");
    	FINWriterVisitor visitor = new FINWriterVisitor(writer);
		visitor.startBlock2(b2);
		visitor.value(b2, b2.getValue());
		visitor.endBlock2(b2);
    }

    /**
     * Returns the given block content in its native SWIFT format
     * 
     * @param b2 a not null block 2
     * @since 7.8.6
     */
    public static String writeBlock2(SwiftBlock2 b2) {
    	StringWriter w = new StringWriter();
    	writeBlock2(b2, w);
    	return w.toString();
    }

    /**
     * Write the given block to writer in its native SWIFT format
     * 
     * @param b1 a not null block 3
     * @param writer
     * @since 7.8.6
     */
    public static void writeBlock3(SwiftBlock3 b3, Writer writer) {
    	Validate.notNull(b3, "b3 cannot be null");
    	Validate.notNull(writer, "writer cannot be null");
    	FINWriterVisitor visitor = new FINWriterVisitor(writer);
		visitor.startBlock3(b3);
		SwiftMessage.visit(b3, visitor);
		visitor.endBlock3(b3);
    }
    
    /**
     * Returns the given block content in its native SWIFT format
     * 
     * @param b3 a not null block 3
     * @since 7.8.6
     */
    public static String writeBlock3(SwiftBlock3 b3) {
    	StringWriter w = new StringWriter();
    	writeBlock3(b3, w);
    	return w.toString();
    }

    /**
     * Write the given block to writer in its native SWIFT format
     * 
     * @param b4 a not null block 4
     * @param writer
     * @since 7.8.6
     */
    public static void writeBlock4(SwiftBlock4 b4, Writer writer) {
    	Validate.notNull(b4, "b4 cannot be null");
    	Validate.notNull(writer, "writer cannot be null");
    	FINWriterVisitor visitor = new FINWriterVisitor(writer);
		visitor.startBlock4(b4);
		SwiftMessage.visit(b4, visitor);
		visitor.endBlock4(b4);
    }
    
    /**
     * Returns the given block content in its native SWIFT format
     * 
     * @param b4 a not null block 4
     * @since 7.8.6
     */
    public static String writeBlock4(SwiftBlock4 b4) {
    	StringWriter w = new StringWriter();
    	writeBlock4(b4, w);
    	return w.toString();
    }

    /**
     * Write the given block to writer in its native SWIFT format
     * 
     * @param b5 a not null block 5
     * @param writer
     * @since 7.8.6
     */
    public static void writeBlock5(SwiftBlock5 b5, Writer writer) {
    	Validate.notNull(b5, "b5 cannot be null");
    	Validate.notNull(writer, "writer cannot be null");
    	FINWriterVisitor visitor = new FINWriterVisitor(writer);
		visitor.startBlock5(b5);
		SwiftMessage.visit(b5, visitor);
		visitor.endBlock5(b5);
    }
    
    /**
     * Returns the given block content in its native SWIFT format
     * 
     * @param b5 a not null block 5
     * @since 7.8.6
     */
    public static String writeBlock5(SwiftBlock5 b5) {
    	StringWriter w = new StringWriter();
    	writeBlock5(b5, w);
    	return w.toString();
    }    
}

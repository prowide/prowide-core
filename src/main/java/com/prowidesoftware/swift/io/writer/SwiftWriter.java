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
package com.prowidesoftware.swift.io.writer;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.lang3.Validate;

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
 * previous to using the writer.
 */
public class SwiftWriter {
    //private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftWriter.class.getName());

	private static final String WRITER_MESSAGE = "writer cannot be null";

    /**
     * Write the given message to writer in its native SWIFT format
     * 
     * @param msg the message to write
     * @param writer the writer that will actually receive all the write operations
     * @throws IllegalArgumentException if msg or writer are null
     */
    public static void writeMessage(SwiftMessage msg, Writer writer) {
    	Validate.notNull(msg , "msg cannot be null");
    	Validate.notNull(writer, WRITER_MESSAGE);
    	FINWriterVisitor v = new FINWriterVisitor(writer);
    	msg.visit(v);
    }
    
    /**
     * Get a string with the internal xml representation of a message.
     * @param msg the message to write 
     * @return a string with an internal xml representation of the message
     * @throws IllegalArgumentException if msg is null
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
    	Validate.notNull(writer, WRITER_MESSAGE);
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
    	Validate.notNull(writer, WRITER_MESSAGE);
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
     * @param b3 a not null block 3
     * @param writer
     * @since 7.8.6
     */
    public static void writeBlock3(SwiftBlock3 b3, Writer writer) {
    	Validate.notNull(b3, "b3 cannot be null");
    	Validate.notNull(writer, WRITER_MESSAGE);
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
    	Validate.notNull(writer, WRITER_MESSAGE);
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
    	Validate.notNull(writer, WRITER_MESSAGE);
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

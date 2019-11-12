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

import java.io.BufferedReader;
import java.io.StringReader;
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
 * Writes MT messages content into FIN format (raw SWIFT format for MT messages).
 */
public class SwiftWriter {
    private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftWriter.class.getName());

	private static final String WRITER_MESSAGE = "writer cannot be null";

	/**
	 * Writes the given message content to writer in its FIN format (raw SWIFT format for MT messages).
	 *
	 * <p>This method call will preserve and write empty blocks present in the message parameter, and also any
	 * starting or trailing spaces in the field values. For a fine-grain control on how to handle empty blocks and
	 * spaces in field values use {@link #writeMessage(SwiftMessage, Writer, boolean, boolean)}.
	 *
	 * <p>As for the EOL characters, they are written as found in the message content. You can always write into String
	 * and use {@link #ensureEols(String)} on the result if you need to ensure compliance with SWIFT.
	 *
	 * @param msg the message to write
	 * @param writer the writer that will actually receive all the write operations
	 * @throws IllegalArgumentException if msg or writer are null
	 */
    public static void writeMessage(SwiftMessage msg, Writer writer) {
    	writeMessage(msg, writer, false);
	}

	/**
	 * Writes the given message content to writer in its FIN format (raw SWIFT format for MT messages), controlling how
	 * to handle empty blocks.
	 *
	 * <p>Starting and trailing spaces in field values will be preserve. For a fine-grain control on how to handle
	 * spaces in field values use {@link #writeMessage(SwiftMessage, Writer, boolean, boolean)}.
	 *
	 * <p>As for the EOL characters, they are written as found in the message content. You can always write into String
	 * and use {@link #ensureEols(String)} on the result if you need to ensure compliance with SWIFT.
	 *
	 * @param msg the message to write
	 * @param writer the writer that will actually receive all the write operations
	 * @param ignoreEmptyBlocks if true, empty blocks will not be written
	 * @throws IllegalArgumentException if msg or writer are null
	 * @since 8.0.1
	 */
	public static void writeMessage(SwiftMessage msg, Writer writer, boolean ignoreEmptyBlocks) {
		writeMessage(msg, writer, ignoreEmptyBlocks, false);
	}

	/**
	 * Writes the given message content to writer in its FIN format (raw SWIFT format for MT messages), controlling how
	 * to handle empty blocks and spaces in field values.
	 *
	 * @param msg the message to write
	 * @param writer the writer that will actually receive all the write operations
	 * @param ignoreEmptyBlocks if true, empty blocks will not be written
	 * @param trimTagValues if true, starting and trailing spaces in field values will be trimmed.
	 * @throws IllegalArgumentException if msg or writer are null
	 * @since 8.0.2
	 */
	public static void writeMessage(SwiftMessage msg, Writer writer, boolean ignoreEmptyBlocks, boolean trimTagValues) {
		Validate.notNull(msg , "msg cannot be null");
    	Validate.notNull(writer, WRITER_MESSAGE);
		FINWriterVisitor v = new FINWriterVisitor(writer);
		v.setTrimTagValues(trimTagValues);

    	if (ignoreEmptyBlocks) {
			// copy the blocks to a new message container
			SwiftMessage copy = new SwiftMessage();
			copy.setBlock1(msg.getBlock1());
			copy.setBlock2(msg.getBlock2());
			copy.setBlock3(msg.getBlock3());
			copy.setBlock4(msg.getBlock4());
			copy.setBlock5(msg.getBlock5());
			copy.setUnparsedTexts(msg.getUnparsedTexts());
			if (msg.getUserBlocks() != null) {
				copy.setUserBlocks(msg.getUserBlocks());
			}

			// remove empty blocks from copy
			copy.removeEmptyBlocks();

			// serialize copy
			copy.visit(v);

		} else {
    		// serialize message parameter as is
			msg.visit(v);
		}
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

	/**
	 * Makes sure all EOLs are swift compatible by replacing any line break in the parameter String with CRLF
	 *
	 * @param content the complete or partial FIN text to process
	 * @return the source parameter with CRLF for all line breaks or an empty or incomplete string if an error occurs
	 * @since 7.10.4
	 */
	public static String ensureEols(final String content) {
		final StringBuilder buf = new StringBuilder();
		try {
			final BufferedReader r = new BufferedReader(new StringReader(content));
			String l;
			while ((l=r.readLine()) != null) {
				buf.append(l).append(FINWriterVisitor.SWIFT_EOL);
			}
		} catch (final Exception e) {
			log.severe("Error in EOL correction: "+e);
		}
		if (buf.length() > 0) {
			//remove the last EOL inserted
			return buf.substring(0, buf.length()-FINWriterVisitor.SWIFT_EOL.length());
		} else {
			return "";
		}
	}

}

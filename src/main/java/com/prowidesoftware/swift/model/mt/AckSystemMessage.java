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
package com.prowidesoftware.swift.model.mt;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.model.MtSwiftMessage;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.utils.Lib;

/**
 * Generic MT representation for <strong>service messages</strong> with service id 21 = GPA/FIN Message (ACK/NAK/UAK/UNK).
 * It can hold both a positive or negative acknowledge.
 * <br />
 * For system messages, category 0, see the MT0xx classes.
 * 
 * @since 7.8
 */
public class AckSystemMessage extends AbstractMT {

	/**
	 * @param aMessage
	 * @throws runtime exception if the message is not a service message with service id 21 (meaning positive or negative acknowledge)
	 */
	public AckSystemMessage(final SwiftMessage aMessage) {
		super(aMessage);
		Validate.isTrue(aMessage.isServiceMessage21());
	}

	/**
	 * @param swiftMessage
	 * @throws runtime exception if the message is not a service message with service id 21 (meaning positive or negative acknowledge)
	 */
	public static AbstractMT newInstance(final SwiftMessage swiftMessage) {
		return new AckSystemMessage(swiftMessage);
	}
	
	/**
	 * Creates an AckSystemMessage initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the AckSystemMessage content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #AckSystemMessage(String)
	 * @since 7.8.9
	 */
	public static AckSystemMessage parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new AckSystemMessage(m.message());
	}
	
    /**
	 * Creates a new AckSystemMessage by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.8.9
	 */
	public AckSystemMessage(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new AckSystemMessage by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of AckSystemMessage or null if stream is null or the message cannot be parsed 
	 * @since 7.8.9
	 */
	public static AckSystemMessage parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new AckSystemMessage(stream);
    }
    
    /**
	 * Creates a new AckSystemMessage by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.8.9
	 */
	public AckSystemMessage(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new AckSystemMessage by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of AckSystemMessage or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.8.9
	 */
	public static AckSystemMessage parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new AckSystemMessage(file);
    }
    
	/**
	 * Creates a new AckSystemMessage by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
 	 * @throws runtime exception if the message is not a service message with service id 21 (meaning positive or negative acknowledge)
	 * @since 7.8.9
	 */
	public AckSystemMessage(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
				Validate.isTrue(parsed.isServiceMessage21());
			}
		}
    }

	/**
	 * Creates a new AckSystemMessage by parsing a String with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @return a new instance of AckSystemMessage or null if; fin is null or the message cannot be parsed
 	 * @throws runtime exception if the message is not a service message with service id 21 (meaning positive or negative acknowledge)
	 * @since 7.8.9
	 */
	public static AckSystemMessage parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new AckSystemMessage(fin);
	}
	
	/**
	 * Will always return null because service messages do not contain a message type.
	 */
	@Override
	public String getMessageType() {
		return null;
	}

    /**
     * Returns true if this message is an ACK (positive acknowledge).
     * This is determined by testing if the value of field 451 is 0.
	 * If Field 451 is not present, returns false.
     * 
     * @since 7.8.8
     */
	public final boolean isAck() {
		return this.m.isAck();
	}

	/**
	 * Returns true if this message is an NACK (negative acknowledge).
	 * This is determined by testing if the value of field 451 is 1.
	 * If Field 451 is not present, returns false.
	 * 
	 * @since 7.8.8
	 */
	public final boolean isNack() {
		return this.m.isNack();
	}
	
	/**
	 * Returns the error code present in NAK messages in field 405
	 * @return error code found or null if the error code field is not present
	 */
	public String getErrorCode() {
		final Tag t = super.m.getBlock4().getTagByName("405");
		if (t == null) {
			return null;
		}
		return t.asField().getComponent(1);
	}
	
	/**
	 * Returns the error line present in NAK messages in field 405
	 * @return error code found or null if the error code field is not present
	 */
	public String getErrorLine() {
		final Tag t = super.m.getBlock4().getTagByName("405");
		if (t == null)
			return null;
		return t.asField().getComponent(2);
	}
	
}

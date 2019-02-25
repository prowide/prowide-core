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
package com.prowidesoftware.swift.model.mt;

import com.prowidesoftware.swift.model.MtSwiftMessage;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.utils.Lib;
import org.apache.commons.lang3.Validate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Generic MT representation for <strong>service messages</strong> with service id 21 = GPA/FIN Message (ACK/NAK/UAK/UNK).
 * It can hold both a positive or negative acknowledge.
 * <br>
 * For system messages, category 0, see the MT0xx classes.
 * 
 * @since 7.10.4
 */
public class ServiceMessage21 extends AbstractMT {

	/**
	 * @param aMessage
	 * @throws RuntimeException if the message is not a service message with service id 21 (meaning positive or negative acknowledge)
	 */
	public ServiceMessage21(final SwiftMessage aMessage) {
		super(aMessage);
		Validate.isTrue(aMessage.isServiceMessage21());
	}

    /**
	 * Creates a new ServiceMessage21 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 */
	public ServiceMessage21(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }

    /**
	 * Creates a new ServiceMessage21 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 */
	public ServiceMessage21(final File file) throws IOException {
		this(Lib.readFile(file));
    }

	/**
	 * Creates a new ServiceMessage21 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
 	 * @throws RuntimeException if the message is not a service message with service id 21 (meaning positive or negative acknowledge)
	 */
	public ServiceMessage21(final String fin) {
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
	 * @param swiftMessage
	 * @throws RuntimeException if the message is not a service message with service id 21 (meaning positive or negative acknowledge)
	 */
	public static AbstractMT newInstance(final SwiftMessage swiftMessage) {
		return new ServiceMessage21(swiftMessage);
	}

	/**
	 * Creates an ServiceMessage21 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the ServiceMessage21 content
	 * @return the created object or null if the parameter is null
	 * @see #ServiceMessage21(String)
	 */
	public static ServiceMessage21 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new ServiceMessage21(m.message());
	}

    /**
	 * Creates a new ServiceMessage21 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of ServiceMessage21 or null if stream is null or the message cannot be parsed
	 */
	public static ServiceMessage21 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new ServiceMessage21(stream);
    }

    /**
	 * Creates a new ServiceMessage21 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of ServiceMessage21 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 */
	public static ServiceMessage21 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new ServiceMessage21(file);
    }

	/**
	 * Creates a new ServiceMessage21 by parsing a String with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @return a new instance of ServiceMessage21 or null if; fin is null or the message cannot be parsed
 	 * @throws RuntimeException if the message is not a service message with service id 21 (meaning positive or negative acknowledge)
	 */
	public static ServiceMessage21 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new ServiceMessage21(fin);
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
     */
	public final boolean isAck() {
		return this.m.isAck();
	}

	/**
	 * Returns true if this message is an NACK (negative acknowledge).
	 * This is determined by testing if the value of field 451 is 1.
	 * If Field 451 is not present, returns false.
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
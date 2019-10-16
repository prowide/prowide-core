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

import com.prowidesoftware.ProwideException;
import com.prowidesoftware.swift.io.parser.XMLParser;
import com.prowidesoftware.swift.io.writer.SwiftWriter;
import com.prowidesoftware.swift.io.writer.XMLWriterVisitor;
import com.prowidesoftware.swift.model.SwiftMessage;
import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.io.StringWriter;


/**
 * This interface provides a general conversion service between three different formats:
 * <ul>
 * 	<li><b>FIN</b>: SWIFT raw format for MT messages (ISO 15022).</li>
 *  <li><b>XML</b>: A proprietary XML representation of SWIFT MT messages.</li>
 *  <li><b>SwiftMessage</b>: Java model of SWIFT MT messages.</li>
 * </ul>
 * <p>This class may be used as a serializer.
 * <p>All methods in this class are <b>threadsafe</b>.
 */
public class ConversionService implements IConversionService {

	/**
	 * Given a SwiftMessage object returns a String containing its SWIFT message representation.
	 * <p>The implementation ensures all line breaks use CRLF, and ignores all empty blocks.
	 *
	 * @see com.prowidesoftware.swift.io.IConversionService#getFIN(com.prowidesoftware.swift.model.SwiftMessage)
	 */
	public String getFIN(final SwiftMessage msg) {
		Validate.notNull(msg);

		final StringWriter writer = new StringWriter();
		SwiftWriter.writeMessage(msg, writer, true);
		final String fin = writer.getBuffer().toString();

		// ensure EOLs in the result
		return SwiftWriter.ensureEols(fin);
	}

	/**
	 * Given a String containing a message in its Wife XML internal representation, returns a String
	 * containing its SWIFT message representation.
	 *
	 * @see com.prowidesoftware.swift.io.IConversionService#getFIN(java.lang.String)
	 */
	public String getFIN(final String xml) {
		Validate.notNull(xml);
		final SwiftMessage msg = getMessageFromXML(xml);
		if (msg == null) {
			throw new ProwideException("parsed SwiftMessage from XML is null");
		}
		return getFIN(msg);
	}

	/**
	 * Given a SwiftMessage objects returns a String containing WIFE internal XML representation of the message.
	 *
	 * @see com.prowidesoftware.swift.io.IConversionService#getXml(com.prowidesoftware.swift.model.SwiftMessage)
	 */
	public String getXml(final SwiftMessage msg) {
		return getXml(msg, false);
	}
	
	/**
	 * Given a SwiftMessage objects returns a String containing WIFE internal XML representation of the message.
	 * @since 7.6
	 */
	public String getXml(final SwiftMessage msg, final boolean useField) {
		Validate.notNull(msg);
		final StringWriter w = new StringWriter();
		msg.visit(new XMLWriterVisitor(w, useField));
		return w.getBuffer().toString();
	}

	/**
	 * Given a Swift message String returns a String containing WIFE internal XML representation of the message.
	 *
	 * @see com.prowidesoftware.swift.io.IConversionService#getXml(java.lang.String)
	 */
	public String getXml(final String fin) {
		return getXml(fin, false);
	}
	
	/**
	 * Given a Swift message String returns a String containing WIFE internal XML representation of the message, use field (true) or tag (false) depending on the value of useField 
	 *
	 * @see #getXml(String)
	 * @since 7.6
	 */
	public String getXml(final String fin, final boolean useField) {
		Validate.notNull(fin);
		final SwiftMessage msg = this.getMessageFromFIN(fin);
		return getXml(msg, useField);
	}

	/**
	 * Given a Swift message String returns a SwiftMessage object.
	 *
	 * @see com.prowidesoftware.swift.io.IConversionService#getMessageFromFIN(java.lang.String)
	 */
	public SwiftMessage getMessageFromFIN(final String fin) {
		Validate.notNull(fin);
		try {
			return SwiftMessage.parse(fin);
		} catch (final IOException e) {
			throw new ProwideException(e+" during parse of message");
		}
	}

	/**
	 * Given a String containing a message in its WIFE internal XML representation, returns a SwiftMessage object.
	 *
	 * @see com.prowidesoftware.swift.io.IConversionService#getMessageFromXML(java.lang.String)
	 */
	public SwiftMessage getMessageFromXML(final String xml) {
		return new XMLParser().parse(xml);
	}
	
}

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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.WifeException;
import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.io.parser.XMLParser;
import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.io.writer.SwiftWriter;
import com.prowidesoftware.swift.model.SwiftMessage;


/**
 * This interface provides a general conversion service between three different formats:
 * <ul>
 * 	<li><b>FIN</b>: SWIFT message format as used by SWIFTNet (ISO 15022 compliance).</li>
 *  <li><b>XML</b>: WIFE's XML representation of SWIFT messages.</li>
 *  <li><b>SwiftMessage</b>: WIFE's java object model of SWIFT messages.</li>
 * </ul>
 * <p>This class may be used as a serializer.</p>
 * <p>All methods in this class are <b>threadsafe</b>.</p>
 *
 * @author www.prowidesoftware.com
 */
public class ConversionService implements IConversionService {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(ConversionService.class.getName());

	/**
	 * Given a SwiftMessage object returns a String containing its SWIFT message representation.
	 *
	 * @see com.prowidesoftware.swift.io.IConversionService#getFIN(com.prowidesoftware.swift.model.SwiftMessage)
	 */
	public String getFIN(final SwiftMessage msg) {
		Validate.notNull(msg);
		final SwiftWriter w = new SwiftWriter();
		final StringWriter writer = new StringWriter();
		w.writeMessage(msg, writer);
		final String fin = writer.getBuffer().toString();
		return ensureEols(fin);
	}

	/**
	 * Make sure all EOLs are swift compatible
	 * @return an empty or incomplete string if an error occurs
	 */
	private static String ensureEols(final String result) {
		final StringBuilder buf = new StringBuilder();
		try {
			final BufferedReader r = new BufferedReader(new StringReader(result));
			String l;
			while ((l=r.readLine()) != null) {
				buf.append(l).append(FINWriterVisitor.SWIFT_EOL);
			}
		} catch (final Exception e) {
			log.severe("Error in EOL correction: "+e);
		}
		// remove the last EOL inserted
		return buf.substring(0, buf.length()-FINWriterVisitor.SWIFT_EOL.length());
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
			throw new WifeException("parsed SwiftMessage from XML is null");
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
		return msg.toXml();
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
		final SwiftParser p = new SwiftParser(new ByteArrayInputStream(fin.getBytes()));
		try {
			return p.message();
		} catch (final IOException e) {
			throw new WifeException(e+" during parse of message");
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

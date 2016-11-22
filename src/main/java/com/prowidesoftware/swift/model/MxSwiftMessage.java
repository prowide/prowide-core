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
package com.prowidesoftware.swift.model;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.swift.DeleteSchedule;
import com.prowidesoftware.swift.io.parser.MxParser;
import com.prowidesoftware.swift.model.mx.AbstractMX;
import com.prowidesoftware.swift.model.mx.BusinessHeader;
import com.prowidesoftware.swift.model.mx.dic.ApplicationHeader;
import com.prowidesoftware.swift.utils.Lib;

/**
 * Container of raw representation of an MX (ISO 20022) SWIFT message, intended for message persistence.
 * The class holds the full xml content plus message identification metadata gathered from the application header.<br />
 * 
 * Notice, the scope of Prowide MX model is the message payload (the actual message or body data) which is the fundamental 
 * purpose of the transmission. The transmission wrappers (overhead data) are excluded and intentionally ignored if found.
 * 
 * <p>MMX messages are uniquely identify by their business process, message functionality, variant and version.<br />
 * Consider the following example: TREA.001.001.02
 * <ul>
 * <li>TREA refers to 'Treasury'</li>
 * <li>001 refers to 'NDF opening (notification)'</li>
 * <li>001 refers to the variant</li>
 * <li>02 refers to the version message format, in this case version 2 of 'NDF opening' type.</li>
 * </ul>
 * </p>
 * 
 * <p><em>businessProcess</em>: Alphabetic code in four positions (fixed length) identifying the Business Process</p>
 * <p><em>functionality</em>: Alphanumeric code in three positions (fixed length) identifying the Message Functionality</p>
 * <p><em>variant</em>: Numeric code in three positions (fixed length) identifying a particular flavor (variant) of Message Functionality</p>
 * <p><em>version</em>: Numeric code in two positions (fixed length) identifying the version.</p>
 * 
 * @author www.prowidesoftware.com
 * @since 7.0
 */
public class MxSwiftMessage extends AbstractSwiftMessage {
	private static final long serialVersionUID = -4394356007627575831L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MxSwiftMessage.class.getName());

	private MxBusinessProcess businessProcess;
	
	private String functionality;
	
	private String variant;
	
	private String version;

	public MxSwiftMessage() {
		super();
	}
	
	/**
	 * Creates a new message reading the message the content from a string. 
	 * Performs a fast parsing of the header to identify the message 
	 * and gather metadata information for the object attributes.<br />
	 * 
	 * If the string contains several messages, the whole passed content will be
	 * save in the message attribute but identification and metadata will be parser
	 * from the first one found only.
	 * 
	 * @see AbstractSwiftMessage#AbstractSwiftMessage(String)
	 */
	public MxSwiftMessage(final String xml) {
		super(xml);
	}
	
	/**
	 * Creates a new message reading the message the content from a string. 
	 * This is a static version of the constructor {@link #MxSwiftMessage(String)}
	 * 
	 * @since 7.7
	 */
	public static MxSwiftMessage parse(final String xml) {
		return new MxSwiftMessage(xml);
	}
	
	/**
	 * Creates a new message reading the message the content from an input stream.
	 * 
	 * @see #MxSwiftMessage(String)
	 * @see AbstractSwiftMessage#AbstractSwiftMessage(InputStream)
	 * @since 7.7
	 */
	public MxSwiftMessage(final InputStream stream) throws IOException {
		super(stream);
	}
	
	/**
	 * Creates a new message reading the message the content from an input stream. 
	 * This is a static version of the constructor {@link #MxSwiftMessage(InputStream)}
	 * 
	 * @since 7.7
	 */
	public static MxSwiftMessage parse(final InputStream stream) throws IOException {
		return new MxSwiftMessage(stream);
	}

	/**
	 * Creates a new message reading the message the content from a file.
	 *  
	 * @see #MxSwiftMessage(String)
	 * @see AbstractSwiftMessage#AbstractSwiftMessage(File)
	 * @since 7.7
	 */
	public MxSwiftMessage(final File file) throws IOException {
		super(file);
	}
	
	/**
	 * Creates a new message reading the message the content from a file. 
	 * This is a static version of the constructor {@link #MxSwiftMessage(File)}
	 * 
	 * @since 7.7
	 */
	public static MxSwiftMessage parse(final File file) throws IOException {
		return new MxSwiftMessage(file);
	}
	
	/**
	 * Creates a new message serializing to xml the parameter message object.
	 * <br />
	 * If the business header is present, the sender and receiver attributes will be set
	 * with content from the header; also the internal raw xml will include both
	 * AppHdr and Document under a root element tag "<message>", as returned by
	 * {@link AbstractMX#message(String)}
	 * <br />
	 * If the header is not present, sender and receiver will be left null and the raw internal
	 * xml will include just the Document element. 
	 * 
	 * @param mx
	 */
	public MxSwiftMessage(final AbstractMX mx) {
		super(mx.message("message"));
	}
	
	/**
	 * @see AbstractSwiftMessage#updateFromMessage()
	 * @since 7.7
	 */
	@Override
    protected void updateFromMessage() {
		_updateFromMessage(null);
	}
	
	private void _updateFromMessage(final MxId id) {
		if (message() != null && message().length() > 0) {
			/*
			 * update sender, receiver and reference
			 * from business header or group header
			 */
			MxParser parser = new MxParser(this.message());
			BusinessHeader h = parser.parseBusinessHeader();
			if (!_update(h)) {
				_update(parser.parse());
			}
			/*
			 * update identifier and namespace
			 */
			if (id != null) {
				_update(id);
			} else {
				_update(parser.detectMessage());
			}
		}
	}
	
	/**
	 * Updates the the attributes with the raw message and its metadata from the given raw (XML) message content.
	 * Wrapper around AppHdr/Document, if present, are preserved and ignored.
	 *
	 * @param xml the XML content of an MX message containing the Document and optional AppHdr elements
	 * @see #updateFromMessage()
	 * @since 7.8.4
	 */
	public void updateFromXML(final String xml) {
		updateFromXML(xml, null);
	}

	/**
	 * Similar to {@link #updateFromXML(String)} but providing the corresponding MxId 
	 * to skip automatic detection for specific Mx type from content.
	 * @param xml the XML content of an MX message containing the Document and optional AppHdr elements
	 * @param id the specific Mx type identification
	 * @since 7.8.4
	 */
	public void updateFromXML(final String xml, final MxId id) {
		Validate.notNull(xml, "the xml message parameter cannot be null");
		setMessage(xml);
		setFileFormat(FileFormat.MX);
		_updateFromMessage(id);
	}
	
	/**
	 * Updates the the attributes with the raw message and its metadata from the given raw (XML) message content.
	 *
	 * @param mx the new message content
	 * @see #updateFromMessage()
	 * @since 7.8.4
	 */
	public void updateFromModel(final AbstractMX mx) {
		Validate.notNull(mx, "the mx parameter cannot be null");
		setMessage(mx.message("message", true));
		setFileFormat(FileFormat.MX);
		/*
		 * update sender, receiver and reference
		 * from business header or group header
		 */
		if (!_update(mx.getBusinessHeader())) {
			MxParser parser = new MxParser(this.message());
			_update(parser.parse());
		}
		/*
		 * update identifier and namespace
		 */
		_update(mx.getMxId());
	}
	
	/**
	 * Updates identifier and namespace related attributes from the given id object
	 * @param id
	 * @return true if at least some property was updated
	 */
	private boolean _update(MxId id) {
		if (id != null) {
			this.identifier = id.id();
			this.businessProcess = id.getBusinessProcess();
			this.functionality = id.getFunctionality();
			this.variant = id.getVariant();
			this.version = id.getVersion();
			return true;
		}
		return false;
	}
	
	/**
	 * Updates sender, receiver and reference from parameter header
	 * @param h
	 * @return true if at least some property was updated
	 */
	private boolean _update(BusinessHeader h) {
		boolean updated = false;
		if (h != null) {
			final String from = h.from();
			if (from != null) {
				super.sender = StringUtils.substring(from, 0, 8);
				updated = true;
			}
			
			final String to = h.to();
			if (to != null) {
				super.receiver = StringUtils.substring(to, 0, 8);
				updated = true;
			}
			
			final String reference = h.reference();
			if (reference != null) {
				setReference(h.reference());
				updated = true;
			}
		}
		return updated;
	}
	
	/**
	 * Updates sender, receiver and reference from the group header element (only present in a subset of Mx messages)
	 * @return true if at least some property was updated
	 */
	private boolean _update(MxNode n) {
		boolean updated = false;
		final MxNode groupHeader = n.findFirstByName("GrpHdr");
		if (groupHeader != null) {
			MxNode senderBic = groupHeader.findFirst("./InstgAgt/FinInstnId/BIC");
			if (senderBic != null) {
				sender = StringUtils.substring(senderBic.getValue(), 0, 8);;
				updated = true;
			}
			MxNode receiverBic = groupHeader.findFirst("./InstdAgt/FinInstnId/BIC");
			if (receiverBic != null) {
				receiver = StringUtils.substring(receiverBic.getValue(), 0, 8);;
				updated = true;
			}
			MxNode reference = groupHeader.findFirst("./MsgId");
			if (reference != null) {
				setReference(reference.getValue());
				updated = true;
			}
		}
		return updated;
	}
	
	public MxBusinessProcess getBusinessProcess() {
		return businessProcess;
	}

	public void setBusinessProcess(MxBusinessProcess businessProcess) {
		this.businessProcess = businessProcess;
	}

	public String getFunctionality() {
		return functionality;
	}

	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((businessProcess == null) ? 0 : businessProcess.hashCode());
		result = prime * result
				+ ((functionality == null) ? 0 : functionality.hashCode());
		result = prime * result + ((variant == null) ? 0 : variant.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MxSwiftMessage other = (MxSwiftMessage) obj;
		if (businessProcess != other.businessProcess)
			return false;
		if (functionality == null) {
			if (other.functionality != null)
				return false;
		} else if (!functionality.equals(other.functionality))
			return false;
		if (variant == null) {
			if (other.variant != null)
				return false;
		} else if (!variant.equals(other.variant))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

    /**
     * @deprecated use the constructor {@link #MxSwiftMessage(File)} instead
     */
	@DeleteSchedule(2016)
	@Deprecated
    public MxSwiftMessage readFile(File file) throws IOException {
        MxSwiftMessage result = new MxSwiftMessage();
        result.setMessage(Lib.readFile(file));
        result.setFilename(file.getAbsolutePath());
        return result;
    }
	
	@ProwideDeprecated()
	protected void setDataFromNamespace(String namespace) {
		Validate.notNull(namespace, "namespace can not be null");
		final String[] tokens = StringUtils.split(namespace, '.');
		if (tokens == null || tokens.length<4) {
			throw new IllegalArgumentException("Expected at least 4 tokens in namespace '"+namespace+"'");
		}
		// always last 4 tokens
		final String bp = tokens[tokens.length-4]; 
		final String func = tokens[tokens.length-3]; 
		final String var = tokens[tokens.length-2]; 
		final String ver = tokens[tokens.length-1];
		
		final MxBusinessProcess bpEnum;
		try {
			bpEnum = MxBusinessProcess.valueOf(bp);
		} catch (Exception e) {
			throw new IllegalArgumentException("Unknown business process '"+bp+"'", e);
		}
		setBusinessProcess(bpEnum);
		setFunctionality(func);
		setVariant(var);
		setVersion(ver);
	}

	/**
	 * If present in the message content, returns the business header (SWIFT or ISO version)
	 * Notice this header is optional and may not be present.
	 * @see MxParser#parseBusinessHeader()
	 * @return found header or null if not present or cannot be parsed into a header object
	 * @since 7.8.4
	 */
	public BusinessHeader getBusinessHeader() {
		MxParser parser = new MxParser(this.message());
		return parser.parseBusinessHeader();
	}
	
	/**
	 * This method has been deprecated because Mx message support two kind of headers,
	 * the one from SWIFT and the one from ISO. The Application Header returned here
	 * is the SWIFT version, currently deprecated and replaced by the ISO version.
	 * @see #getBusinessHeader()
	 * @deprecated use #getBusinessHeader() instead 
	 */
	@Deprecated
	public ApplicationHeader getApplicationHeader() {
		MxParser parser = new MxParser(this.message());
		BusinessHeader h = parser.parseBusinessHeader();
		if (h != null && h.getApplicationHeader() != null) {
			return h.getApplicationHeader();
		}
		return null;
	}

	/**
	 * The application header is no longer stored as class attribute
	 * @see #getApplicationHeader()
	 * @deprecated @see #getApplicationHeader()
	 */
	@Deprecated
	public void setApplicationHeader(ApplicationHeader applicationHeader) {
		log.warning("Obsolete API call. The application header is no longer stored as class attribute in "+getClass().getName());
	}
	
	/**
	 * copies attributes from this object to the given object
	 * non inherited copied attributes:
	 * <ul>
	 * 		<li>functionality</li>
	 * 		<li>variant</li>
	 * 		<li>version</li>
	 * </ul>
	 * @param msg
	 * @since 7.7
	 * @see AbstractSwiftMessage#copyTo(AbstractSwiftMessage)
	 */
	public void copyTo(MxSwiftMessage msg) {
	    super.copyTo((AbstractSwiftMessage)msg);
	    msg.setFunctionality(getFunctionality());
	    msg.setVariant(getVariant());
	    msg.setVersion(getVersion());
	}
}

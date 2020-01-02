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
package com.prowidesoftware.swift.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.io.parser.MxParser;
import com.prowidesoftware.swift.model.mx.AbstractMX;
import com.prowidesoftware.swift.model.mx.BusinessHeader;
import com.prowidesoftware.swift.model.mx.dic.ApplicationHeader;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * Container of raw representation of an MX (ISO 20022) SWIFT message, intended for message persistence.
 * <p>
 * The class holds the full xml content plus message identification metadata gathered from the application header.
 * 
 * <p>
 * Notice, the scope of Prowide MX model is the message payload (the actual message or body data) which is the fundamental
 * purpose of the transmission. The transmission wrappers (overhead data) are excluded and intentionally ignored if found.
 * 
 * <p>
 * MX messages are uniquely identify by their business process, message functionality, variant and version.<br>
 * Consider the following example: trea.001.001.02
 * <ul>
 * <li>trea refers to 'Treasury'</li>
 * <li>001 refers to 'NDF opening (notification)'</li>
 * <li>001 refers to the variant</li>
 * <li>02 refers to the version message format, in this case version 2 of 'NDF opening' type.</li>
 * </ul>
 * 
 * <p>
 * <em>businessProcess</em>: Alphabetic code in four positions (fixed length) identifying the Business Process
 * <br>
 * <em>functionality</em>: Alphanumeric code in three positions (fixed length) identifying the Message Functionality
 * <br>
 * <em>variant</em>: Numeric code in three positions (fixed length) identifying a particular flavor (variant) of Message Functionality
 * <br>
 * <em>version</em>: Numeric code in two positions (fixed length) identifying the version.
 * 
 * @author www.prowidesoftware.com
 * @since 7.0
 */
@Entity(name = "mx")
@DiscriminatorValue("mx")
public class MxSwiftMessage extends AbstractSwiftMessage {
	private static final long serialVersionUID = -4394356007627575831L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MxSwiftMessage.class.getName());

	@Enumerated(EnumType.STRING)
	@Column(length = 4, name = "business_process")
	private MxBusinessProcess businessProcess;

	@Column(length = 3)
	private String functionality;

	@Column(length = 3)
	private String variant;

	@Column(length = 2)
	private String version;

	public MxSwiftMessage() {
		super();
	}
	
	/**
	 * Creates a new message reading the message the content from a string. 
	 * Performs a fast parsing of the header to identify the message 
	 * and gather metadata information for the object attributes.<br>
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
	 *
	 * <p>If the business header is present, the sender and receiver attributes will be set with content from the
	 * header; also the internal raw XML will include both 'AppHdr' and 'Document' under a default root element tag
	 * as returned by {@link AbstractMX#message()}
	 * <br>If the header is not present, sender and receiver will be left null and the raw internal XML will include
	 * just the 'Document' element.
	 * 
	 * @param mx a message object
	 */
	public MxSwiftMessage(final AbstractMX mx) {
		super(mx.message());
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
		setMessage(mx.message());
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
				super.sender = bic11(from);
				updated = true;
			}
			
			final String to = h.to();
			if (to != null) {
				super.receiver = bic11(to);
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
		final MxNode groupHeader = n != null? n.findFirstByName("GrpHdr") : null;
		if (groupHeader != null) {
			MxNode senderBic = groupHeader.findFirst("./InstgAgt/FinInstnId/BIC");
			if (senderBic != null) {
				sender = bic11(senderBic.getValue());
				updated = true;
			}
			MxNode receiverBic = groupHeader.findFirst("./InstdAgt/FinInstnId/BIC");
			if (receiverBic != null) {
				receiver = bic11(receiverBic.getValue());
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		MxSwiftMessage that = (MxSwiftMessage) o;
		return businessProcess == that.businessProcess &&
				Objects.equals(functionality, that.functionality) &&
				Objects.equals(variant, that.variant) &&
				Objects.equals(version, that.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), businessProcess, functionality, variant, version);
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
	@ProwideDeprecated(phase3=TargetYear.SRU2020)
	public ApplicationHeader getApplicationHeader() {
		DeprecationUtils.phase2(getClass(), "getApplicationHeader()", "use getBusinessHeader() instead");
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
	@ProwideDeprecated(phase3=TargetYear.SRU2020)
	public void setApplicationHeader(ApplicationHeader applicationHeader) {
		String message = "Obsolete API call. The application header is no longer stored as class attribute in "+getClass().getName();
		DeprecationUtils.phase2(getClass(), "setApplicationHeader(ApplicationHeader)", message);
	}
	
	/**
	 * Creates a full copy of the current message object into another message.
	 * @param msg target message
	 * @since 7.7
	 * @see AbstractSwiftMessage#copyTo(AbstractSwiftMessage)
	 */
	public void copyTo(MxSwiftMessage msg) {
	    super.copyTo(msg);
	    msg.setBusinessProcess(getBusinessProcess());
	    msg.setFunctionality(getFunctionality());
	    msg.setVariant(getVariant());
	    msg.setVersion(getVersion());
	}

	/**
	 * @since 7.8.6
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("MxSwiftMessage id=").append(getId()).append(" message=").append(getMessage());
		return sb.toString();
	}

	/**
	 * This method deserializes the JSON data into an MX message object.
	 * @see #toJson()
	 * @since 7.10.3
	 */
	public static MxSwiftMessage fromJson(String json){
		final Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, MxSwiftMessage.class);
	}

	/**
	 * Returns this message MX identification
	 * @return the identification object for this message
	 * @since 7.10.4
	 */
	public MxId getMxId() {
		return new MxId(this.businessProcess, this.functionality, this.variant, this.version);
	}

}

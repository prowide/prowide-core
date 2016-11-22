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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.logging.Level;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.DeleteSchedule;
import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.io.parser.SwiftParserConfiguration;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;


/**
 * Container of raw representations of an MT (ISO 15022) SWIFT message, intended for message persistence.
 * The class holds the full FIN message content plus minimal message identification metadata.<br />
 *
 * @author www.prowidesoftware.com
 * @since 7.0
 */
public class MtSwiftMessage extends AbstractSwiftMessage {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MtSwiftMessage.class.getName());
	private static final long serialVersionUID = -5972656648349958815L;

	/**
	 * Possible Duplicate Emission.
	 */
	private String pde;

	/**
	 * Possible Duplicate Message.
	 */
	private String pdm;

	/**
	 * Message Input Reference
	 */
	private String mir;

	/**
	 * The MUR is a free-format field in which users may specify their own reference
	 * of up to 16 characters of the permitted character set, and it is contained
	 * in a 108 field at the message user header (block 3).
	 */
	private String mur;

	/**
	 * User Unique Message Identifier
	 */
	private String uuid;

	public MtSwiftMessage() {
		super();
	}

	/**
	 * Creates a new message reading the message the content from a string.
	 * Performs a fast parsing of the header and trailer blocks to identify the message
	 * and gather metadata information for the object attributes.<br />
	 *
	 * If the string contains several messages, the whole passed content will be
	 * save in the message attribute but identification and metadata will be parser
	 * from the first one found only.
	 * Notice that if an ACK/NAK followed by the original
	 * message is passed, this object will represent the ACK/NAK.
	 * <br />
	 * File format is set to {@link FileFormat#FIN}
	 *
	 * @see AbstractSwiftMessage#AbstractSwiftMessage(String)
	 */
	public MtSwiftMessage(final String fin) {
		super(fin, FileFormat.FIN);
	}

	/**
	 * Creates a new message reading the message the content from a string.
	 * This is a static version of the constructor {@link #MtSwiftMessage(String)}
	 *
	 * @since 7.7
	 */
	public static MtSwiftMessage parse(final String fin) {
		return new MtSwiftMessage(fin);
	}

	/**
	 * Creates a new message reading the message the content from an input stream.
	 * <br />
	 * File format is set to {@link FileFormat#FIN}
	 *
	 * @see #MtSwiftMessage(String)
	 * @see AbstractSwiftMessage#AbstractSwiftMessage(InputStream)
	 * @since 7.7
	 */
	public MtSwiftMessage(final InputStream stream) throws IOException {
		super(stream, FileFormat.FIN);
	}

	/**
	 * Creates a new message reading the message the content from an input stream.
	 * This is a static version of the constructor {@link #MtSwiftMessage(InputStream)}
	 *
	 * @since 7.7
	 */
	public static MtSwiftMessage parse(final InputStream stream) throws IOException {
		return new MtSwiftMessage(stream);
	}

	/**
	 * Creates a new message reading the message the content from a file.
	 * <br />
	 * File format is set to {@link FileFormat#FIN}
	 *
	 * @see #MtSwiftMessage(String)
	 * @see AbstractSwiftMessage#AbstractSwiftMessage(File)
	 * @since 7.7
	 */
	public MtSwiftMessage(final File file) throws IOException {
		super(file, FileFormat.FIN);
	}

	/**
	 * Creates a new message reading the message the content from a file.
	 * This is a static version of the constructor {@link #MtSwiftMessage(File)}
	 *
	 * @since 7.7
	 */
	public static MtSwiftMessage parse(final File file) throws IOException {
		return new MtSwiftMessage(file);
	}

	/**
	 * @see AbstractSwiftMessage#updateFromMessage()
	 * @since 7.7
	 * @throws IllegalArgumentException if the source format is not {@link FileFormat#FIN} or if the message cannot be parsed into a {@link MtSwiftMessage} object
	 */
	@Override
	protected void updateFromMessage() throws IllegalArgumentException {
		if (getFileFormat() != FileFormat.FIN) {
			throw new IllegalArgumentException("expected source format "+FileFormat.FIN+" and found "+getFileFormat());
		}
		Validate.notNull(getMessage(), "the raw message attribute cannot be null");
		final SwiftParser parser = new SwiftParser(getMessage());
		final SwiftParserConfiguration config = new SwiftParserConfiguration();
		config.setLenient(true);
		parser.setConfiguration(config);
		SwiftMessage model = null;
		try {
			model = parser.message();
		} catch (final IOException e) {
			log.log(Level.SEVERE, "the raw message parameter could not be parsed into a SwiftMessage", e);
		}
		if (model == null) {
			throw new IllegalArgumentException("the raw message parameter could not be parsed into a SwiftMessage");
		} else {
			updateAttributes(model, getMessage());
		}
	}
	
	private void updateAttributes(final SwiftMessage model, final String fin) {
		setFileFormat(FileFormat.FIN);
		if (model.isSystemMessage()) {
			/*
			 * sebastian agosto 2016
			 *  esto ahora queda redundante con la factory, sacar o dejar por las dudas
			 *  para uso en core sin sdk? no jode dejarlo, pero es codigo redundante 
			 */
			if (model.isAck()) {
				super.identifier = "ACK";
			} else if (model.isNack()) {
				super.identifier = "NAK";
			}
			setDirection(MessageIOType.incoming);
		} else {
			super.identifier = model.getMtId().id();
			super.sender = StringUtils.substring(model.getSender(), 0, 8);
			super.receiver = StringUtils.substring(model.getReceiver(), 0, 8);
			setDirection(model.getDirection());
		}
		setChecksum(SwiftMessageUtils.calculateChecksum(model));
		setPde(model.getPDE());
		setPdm(model.getPDM());
		setMir(model.getMIR());
		setMur(model.getMUR());
		setUuid(model.getUUID());
		setReference(SwiftMessageUtils.reference(model));
		setLastModified(Calendar.getInstance());
	}

	/**
	 * Creates an MtSwiftMessage from a SwiftMessage.
	 * @see #updateFromModel()
	 */
	public MtSwiftMessage(final SwiftMessage model) {
		super();
		updateFromModel(model);
	}

	/**
	 * Updates the the attributes with the raw message and its metadata from the given raw (FIN) message content.
	 *
	 * @param fin the new message content
	 * @see #updateFromMessage()
	 */
	public void updateFromFIN(final String fin) {
		Validate.notNull(fin, "the raw message parameter cannot be null");
		setMessage(fin);
		setFileFormat(FileFormat.FIN);
		updateFromMessage();
	}

	/**
	 * Updates the derived attributes from the current raw (FIN) message attribute.
	 * This is similar to create a new message instance from string content.
	 */
	public void updateFromFIN() {
		updateFromMessage();
	}

	/**
	 * The SwiftMessage is serialized to its FIN raw format to set the internal raw message attribute.
	 * And the header attributes are set with data from the parameter SwiftMessage.
	 * Notice that the SwiftMessage is not stored as internal attribute.
	 */
	public void updateFromModel(final SwiftMessage model) {
		Validate.notNull(model, "the model message cannot be null");
		final String fin = (new ConversionService()).getFIN(model);
		Validate.notNull(fin, "the raw message could not be created from the SwiftMessage parameter");
		setMessage(fin);
		updateAttributes(model, fin);
	}

	/**
	 * The AbstractMT is serialized to its FIN raw format to set the internal raw message attribute.
	 * And the header attributes are set with data from the parameter AbstractMT.
	 * Notice that the AbstractMT is not stored as internal attribute.
	 * 
	 * @since 7.8.4
	 */
	public void updateFromModel(final AbstractMT mt) {
		Validate.notNull(mt, "the model message cannot be null");
		updateFromModel(mt.getSwiftMessage());
	}
	
	/**
	 * @deprecated use update from string or constructor from String, File or InputStream instead,
	 * the internal model message is no longer user to avoid inconsistencies
	 * between the raw format and the parsed data.
	 */
	@Deprecated
	@DeleteSchedule(2016)
	public void updateFromModel() {
	}

	/**
	 * @deprecated the internal model message is no longer user to avoid inconsistencies
	 * between the raw format and the parsed data.
	 */
	@Deprecated
	@DeleteSchedule(2016)
	public SwiftMessage getModelMessage() {
		if (getMessage() != null) {
			final SwiftParser parser = new SwiftParser(getMessage());
			parser.getConfiguration().setLenient(true);
			try {
				return parser.message();
			} catch (IOException e) {
				log.log(Level.WARNING, "error converting FIN text to model: "+e.getMessage(), e);
			}
		}
		return null;
	}

	/**
	 * @deprecated the internal model message is no longer user to avoid inconsistencies
	 * between the raw format and the parsed data.
	 * 
	 * use {@link #updateFromModel()}
	 */
	@Deprecated
	@DeleteSchedule(2016)
	public void setModelMessage(final SwiftMessage modelMessage) {
		updateFromModel(modelMessage);
	}

	/**
	 * Get the message type.<br /> 
	 * For MTs this is the MT type number present in the identifier attribute. For example for fin.103.STP returns 103
	 * For MX returns the same as #getIdentifier()
	 */
	public String getMessageType() {
		if (this.identifier != null && isMT()) {
			return this.identifier.replaceAll("\\D+","");
		} else {
			return getIdentifier();
		}
	}

	/**
	 * Get the integer value of the {@link #getMessageType()}
	 * or null if the identifier attribute is not set or not a number
	 */
	public Integer getMessageTypeInt() {
		final String number = getMessageType();
		if (number != null && StringUtils.isNumeric(number)) {
			return Integer.parseInt(number);
		} else {
			return null;
		}
	}

	/**
	 * Get the value of the property under the {@link #PROPERTY_NAME} key or the result of {@link #getMessageType()}
	 * @return the set message name or message type
	 */
	@Override
	public String getMessageName() {
		final String name = super.getMessageName();
		if (name != null) {
			return name;
		} else {
			return getMessageType();
		}
	}

	/**
	 * Tell if this message is any of the given types.
	 *
	 * @param type a variable list of integers for testing to match as the current message type
	 * @return <code>true</code> if the current message type is any of the integers given as parameters, and <code>false</code> in any other case
	 */
	public boolean isType(final Integer ... type) {
		for (final Integer integer : type) {
			if (isType(integer.intValue())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Test if this message is a given specific type.
	 *
	 * @param type the message type given as int, to test
	 * @return <code>true</code> if this message type is the <code>type</code> given, or <code>false</code> in any other case
	 */
	public boolean isType(final int type) {
		String compare;
		if (type<10) {
			compare = "00"+type;
		} else if (type<100) {
			compare = "0"+type;
		} else {
			compare = StringUtils.EMPTY+type;
		}
		return StringUtils.equals(compare, getMessageType());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("MtSwiftMessage id=").append(getId()).append(" message=").append(getMessage());
		return sb.toString();
	}

	public String getPde() {
		return pde;
	}

	public void setPde(final String pde) {
		this.pde = pde;
	}

	public String getPdm() {
		return pdm;
	}

	public void setPdm(final String pdm) {
		this.pde = pdm;
	}

	public String getMir() {
		return mir;
	}

	public void setMir(final String mir) {
		this.mir = mir;
	}

	public String getMur() {
		return mur;
	}

	public void setMur(final String mur) {
		this.mur = mur;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mir == null) ? 0 : mir.hashCode());
		result = prime * result + ((mur == null) ? 0 : mur.hashCode());
		result = prime * result + ((pde == null) ? 0 : pde.hashCode());
		result = prime * result + ((pdm == null) ? 0 : pdm.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		MtSwiftMessage other = (MtSwiftMessage) obj;
		if (mir == null) {
			if (other.mir != null)
				return false;
		} else if (!mir.equals(other.mir))
			return false;
		if (mur == null) {
			if (other.mur != null)
				return false;
		} else if (!mur.equals(other.mur))
			return false;
		if (pde == null) {
			if (other.pde != null)
				return false;
		} else if (!pde.equals(other.pde))
			return false;
		if (pdm == null) {
			if (other.pdm != null)
				return false;
		} else if (!pdm.equals(other.pdm))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	/**
	 * @deprecated use the constructor {@link #MtSwiftMessage(File)} instead
	 */
	@Deprecated
	@DeleteSchedule(2016)
	public MtSwiftMessage readFile(final File file) throws IOException {
		final MtSwiftMessage result = new MtSwiftMessage();
		result.setModelMessage(new SwiftParser(new FileInputStream(file)).message());
		result.setMessage(Lib.readFile(file));
		return result;
	}

	/**
	 * copies attributes from this object to the given object
	 * non inherited copied attributes:
	 * <ul>
	 * 		<li>mir</li>
	 * 		<li>modelMessage</li>
	 * 		<li>mur</li>
	 * 		<li>pde</li>
	 * 		<li>pdm</li>
	 * 		<li>uuid</li>
	 * </ul>
	 * @param msg
	 * @since 7.7
	 * @see AbstractSwiftMessage#copyTo(AbstractSwiftMessage)
	 */
	public void copyTo(final MtSwiftMessage msg) {
		super.copyTo((AbstractSwiftMessage) msg);
		// TODO Auto-generated method stub
		msg.setMir(getMir());
		msg.setModelMessage(getModelMessage()); // FIXME revisar vigencia de este atributo
		msg.setMur(getMur());
		msg.setPde(getPde());
		msg.setPdm(getPdm());
		msg.setUuid(getUuid());
	}
}

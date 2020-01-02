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
import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.model.mt.MTVariant;
import com.prowidesoftware.swift.model.mt.ServiceIdType;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Objects;
import java.util.logging.Level;


/**
 * Container of raw representations of an MT (ISO 15022) SWIFT message, intended for message persistence.
 * The class holds the full FIN message content plus minimal message identification metadata.<br>
 * @since 7.0
 */
@Entity(name = "mt")
@DiscriminatorValue("mt")
public class MtSwiftMessage extends AbstractSwiftMessage {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MtSwiftMessage.class.getName());
	private static final long serialVersionUID = -5972656648349958815L;

	@Column(length = 35)
	private String pde;

	@Column(length = 35)
	private String pdm;

	@Column(length = 28, name = "mir")
	private String mir;

	@Column(length = 16, name = "mur")
	private String mur;

	@Column(length = 31, name = "uuid")
	private String uuid;

	public MtSwiftMessage() {
		super();
	}

	/**
	 * Creates a new message reading the message the content from a string.
	 * Performs a fast parsing of the header and trailer blocks to identify the message
	 * and gather metadata information for the object attributes.
	 *
	 * <p>If the string contains several messages, the whole passed content will be
	 * save in the message attribute but identification and metadata will be parser
	 * from the first one found only.
	 * 
	 * <p>Notice that if an ACK/NAK followed by the original
	 * message is passed, this object will represent the ACK/NAK.
	 * 
	 * <p>File format is set to {@link FileFormat#FIN}
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
	 * <br>
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
	 * <br>
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
		SwiftMessage model = null;
		try {
			model = SwiftMessage.parse(getMessage());
		} catch (final IOException e) {
			log.log(Level.SEVERE, "the raw message parameter could not be parsed into a SwiftMessage", e);
		}
		if (model == null) {
			throw new IllegalArgumentException("the raw message parameter could not be parsed into a SwiftMessage");
		} else {
			updateAttributes(model);
		}
	}
	
	private void updateAttributes(final SwiftMessage model) {
		setFileFormat(FileFormat.FIN);
		if (model.isServiceMessage21()) {
			/*
			 * set identifier for system aknowledge
			 */
			if (model.isAck()) {
				super.identifier = IDENTIFIER_ACK;
			} else if (model.isNack()) {
				super.identifier = IDENTIFIER_NAK;
			}
			if (model.getUnparsedTextsSize() > 0) {
				/*
				 * try to parse the appended original message (if any)
				 * to gather receiver and reference information
				 */
				final SwiftMessage original = model.getUnparsedTexts().getTextAsMessage(0);
				if (original != null) {
					super.receiver = bic11(original.getReceiver());
					setDirection(original.getDirection());
					setReference(SwiftMessageUtils.reference(original));
				}
			}
		} else if (model.getBlock1() != null && model.getBlock1().getServiceIdType() == ServiceIdType._01) {
			setIdentifier(model.getMtId().id());
			setReceiver(bic11(model.getReceiver()));
			setDirection(model.getDirection());
			setReference(SwiftMessageUtils.reference(model));
			Money money = SwiftMessageUtils.money(model);
			if (money != null) {
				setCurrency(money.getCurrency());
				setAmount(money.getAmount());
			}
			setValueDate(SwiftMessageUtils.valueDate(model));
			setTradeDate(SwiftMessageUtils.tradeDate(model));
		}
		setSender(bic11(model.getSender()));
		setChecksum(SwiftMessageUtils.calculateChecksum(model));
		setChecksumBody(SwiftMessageUtils.calculateChecksum(model.getBlock4()));
		setPde(model.getPDE());
		setPdm(model.getPDM());
		setMir(model.getMIR());
		setMur(model.getMUR());
		setUuid(model.getUUID());
		setLastModified(Calendar.getInstance());
	}

	/**
	 * Creates an MtSwiftMessage from a subclass of {@link AbstractMT}.
	 * @see #MtSwiftMessage(SwiftMessage)
	 * @since 8.0.2
	 */
	public MtSwiftMessage(final AbstractMT mt) {
		super();
		Validate.notNull(mt, "the mt message cannot be null");
		updateFromModel(mt.getSwiftMessage());
	}

	/**
	 * Creates an MtSwiftMessage from a SwiftMessage.
	 * @see #updateFromModel(SwiftMessage)
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
		updateAttributes(model);
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
	 * Parses the raw message content into a {@link SwiftMessage} object.
	 * @return the parsed message or null if the raw content is not set or cannot be parsed
	 * @since 7.8.9
	 */
	public SwiftMessage modelMessage() {
		if (getMessage() != null) {
			try {
				return SwiftMessage.parse(message());
			} catch (IOException e) {
				log.log(Level.WARNING, "error converting FIN text to model: "+e.getMessage(), e);
			}
		}
		return null;
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
		Integer typeInt = getMessageTypeInt();
		if (typeInt != null) {
			return typeInt == type;
		}
		return false;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("MtSwiftMessage id=").append(getId()).append(" message=").append(getMessage());
		return sb.toString();
	}

	/**
	 * Gets PDE (Possible Duplicate Emission) flag from the trailer block or null if the trailer or the PDE field is not present
	 * @return the PDE flag or null
	 */
	public String getPde() {
		return pde;
	}
	
	/**
	 * Sets the PDE attribute.
	 * This field is automatically updated on message update from FIN or model
	 * @see #updateFromFIN(String)
	 * @see #updateFromModel(AbstractMT)
	 * @see #updateFromModel(SwiftMessage)
	 * @param pde the PDE flag to set
	 */
	public void setPde(final String pde) {
		this.pde = pde;
	}

	/**
 	 * Gets PDM from the trailer block or null if the trailer or the PDM field is not present
	 * @return PDM flag or null
	 */
	public String getPdm() {
		return pdm;
	}

	/**
	 * Sets the PDM attribute.
	 * This field is automatically updated on message update from FIN or model
	 * @see #updateFromFIN(String)
	 * @see #updateFromModel(AbstractMT)
	 * @see #updateFromModel(SwiftMessage)
	 * @param pdm the PDM flag to set
	 */
	public void setPdm(final String pdm) {
		this.pde = pdm;
	}

	/**
	 * Gets the MIR (Message Input Reference)
	 * @see SwiftMessage#getMIR()
	 */
	public String getMir() {
		return mir;
	}

	/**
	 * Sets the MIR attribute.
	 * This field is automatically updated on message update from FIN or model
	 * @see #updateFromFIN(String)
	 * @see #updateFromModel(AbstractMT)
	 * @see #updateFromModel(SwiftMessage)
	 * @param mir the MIR to set
	 */
	public void setMir(final String mir) {
		this.mir = mir;
	}

	/**
	 * Gets the MUR (Message User Reference) from block 3
	 * @see SwiftMessage#getMUR()
	 * @return the MUR or null if not present in the message
	 */
	public String getMur() {
		return mur;
	}

	/**
	 * Sets the MUR attribute.
	 * This field is automatically updated on message update from FIN or model
	 * @see #updateFromFIN(String)
	 * @see #updateFromModel(AbstractMT)
	 * @see #updateFromModel(SwiftMessage)
	 * @param mur the MUR to set
	 */
	public void setMur(final String mur) {
		this.mur = mur;
	}

	/**
	 * Gets a UUID (User Unique Identifier)
	 * @see SwiftMessage#getUUID()
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Sets a UUID
 	 * This field is automatically updated on message update from FIN or model
	 * @see #updateFromFIN(String)
	 * @see #updateFromModel(AbstractMT)
	 * @see #updateFromModel(SwiftMessage)

	 * @param uuid
	 */
	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		MtSwiftMessage that = (MtSwiftMessage) o;
		return Objects.equals(pde, that.pde) &&
				Objects.equals(pdm, that.pdm) &&
				Objects.equals(mir, that.mir) &&
				Objects.equals(mur, that.mur) &&
				Objects.equals(uuid, that.uuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), pde, pdm, mir, mur, uuid);
	}

	/**
	 * Creates a full copy of the current message object into another message.
	 * @param msg target message
	 * @since 7.7
	 * @see AbstractSwiftMessage#copyTo(AbstractSwiftMessage)
	 */
	public void copyTo(final MtSwiftMessage msg) {
		super.copyTo(msg);
		msg.setMir(getMir());
		msg.setMur(getMur());
		msg.setPde(getPde());
		msg.setPdm(getPdm());
		msg.setUuid(getUuid());
	}

	/**
	 * This method deserializes the JSON data into an MT message object.
	 *
	 * @since 7.10.3
	 */
	public static MtSwiftMessage fromJson(String json){
		final Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, MtSwiftMessage.class);
	}

	/**
	 * Returns the message type variant
	 * @return the variant or null if the message has no variant
	 * @since 7.10.4
	 */
	public MTVariant getVariant() {
		String s = StringUtils.substringAfterLast(this.identifier, ".");
		if (EnumUtils.isValidEnum(MTVariant.class, s)) {
			return MTVariant.valueOf(s);
		}
		return null;
	}

	/**
	 * Returns this message MT identification
	 * @return the identification object for this message
	 * @since 7.10.4
	 */
	public MtId getMtId() {
		return new MtId(getMessageType(), getVariant());
	}

}

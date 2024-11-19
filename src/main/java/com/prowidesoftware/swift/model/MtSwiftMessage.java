/*
 * Copyright 2006-2023 Prowide
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
import com.prowidesoftware.swift.model.mt.DefaultMtMetadataStrategy;
import com.prowidesoftware.swift.model.mt.MTVariant;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * MT messages entity for JPA persistence.
 *
 * <p>Contains the raw FIN message content plus metadata shared by all MT types.
 *
 * @since 7.0
 */
@Entity(name = "mt")
@DiscriminatorValue("mt")
public class MtSwiftMessage extends AbstractSwiftMessage {
    private static final transient java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(MtSwiftMessage.class.getName());
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

    public MtSwiftMessage() {}

    /**
     * Calls {@link #MtSwiftMessage(String, MessageMetadataStrategy)} with the {@link DefaultMtMetadataStrategy}
     *
     * @param fin the plain FIN message content
     */
    public MtSwiftMessage(final String fin) {
        this(fin, new DefaultMtMetadataStrategy());
    }

    /**
     * Creates a new MT entity reading the message content from the plain message content.
     *
     * <p>If the FIN content contains several messages (because it is an RJE batch file for example) then the whole
     * content will be stored in the message attribute but the metadata (such as the message type) will be extracted
     * from the first message only.
     *
     * <p>Notice that if an ACK/NAK message is used as parameter, this object will represent the ACK/NAK.
     * Even if the original message is attached after the service 21 messages.
     *
     * <p>File format is set to {@link FileFormat#FIN}
     *
     * @param fin              the plain FIN message content
     * @param metadataStrategy a strategy for metadata extraction
     * @since 9.1.4
     */
    public MtSwiftMessage(final String fin, final MessageMetadataStrategy metadataStrategy) {
        super(fin, FileFormat.FIN, metadataStrategy);
    }

    /**
     * Calls {@link #MtSwiftMessage(InputStream, MessageMetadataStrategy)} with the {@link DefaultMtMetadataStrategy}
     *
     * @param stream input stream to read
     * @throws IOException on error during file reading
     */
    public MtSwiftMessage(final InputStream stream) throws IOException {
        this(stream, new DefaultMtMetadataStrategy());
    }

    /**
     * Creates a new message reading the message the content from an input stream.
     * <br>
     * File format is set to {@link FileFormat#FIN}.
     *
     * @param stream           input stream to read
     * @param metadataStrategy a strategy for metadata extraction
     * @throws IOException on error during file reading
     * @since 9.1.4
     */
    public MtSwiftMessage(final InputStream stream, final MessageMetadataStrategy metadataStrategy) throws IOException {
        super(stream, FileFormat.FIN, metadataStrategy);
    }

    /**
     * Calls {@link #MtSwiftMessage(File, MessageMetadataStrategy)} with the {@link DefaultMtMetadataStrategy}
     *
     * @param file file holding message content
     * @throws IOException on error during file reading
     */
    public MtSwiftMessage(final File file) throws IOException {
        this(file, new DefaultMtMetadataStrategy());
    }

    /**
     * Creates a new message reading the message the content from a file.
     * <br>
     * File format is set to {@link FileFormat#FIN}
     *
     * @param file             file holding message content
     * @param metadataStrategy a strategy for metadata extraction
     * @throws IOException on error during file reading
     * @since 9.1.4
     */
    public MtSwiftMessage(final File file, final MessageMetadataStrategy metadataStrategy) throws IOException {
        super(file, FileFormat.FIN, metadataStrategy);
    }

    /**
     * Calls {@link #MtSwiftMessage(AbstractMT, MessageMetadataStrategy)} with the {@link DefaultMtMetadataStrategy}
     *
     * @since 8.0.2
     */
    public MtSwiftMessage(final AbstractMT mt) {
        this(mt, new DefaultMtMetadataStrategy());
    }

    /**
     * Creates an MtSwiftMessage from a subclass of {@link AbstractMT}.
     *
     * @param mt               the MT message to create this entity from
     * @param metadataStrategy a strategy for metadata extraction
     * @since 9.1.4
     */
    public MtSwiftMessage(final AbstractMT mt, final MessageMetadataStrategy metadataStrategy) {
        Objects.requireNonNull(mt, "the mt message cannot be null");
        Objects.requireNonNull(metadataStrategy, "the strategy for metadata extraction cannot be null");
        updateFromModel(mt.getSwiftMessage(), metadataStrategy);
    }

    /**
     * Calls {@link #MtSwiftMessage(SwiftMessage, MessageMetadataStrategy)} with the {@link DefaultMtMetadataStrategy}
     */
    public MtSwiftMessage(final SwiftMessage model) {
        this(model, new DefaultMtMetadataStrategy());
    }

    /**
     * Creates an MtSwiftMessage from a SwiftMessage.
     *
     * @param model            the MT message to create this entity from
     * @param metadataStrategy a strategy for metadata extraction
     * @since 9.1.4
     */
    public MtSwiftMessage(final SwiftMessage model, final MessageMetadataStrategy metadataStrategy) {
        Objects.requireNonNull(model, "the message model cannot be null");
        Objects.requireNonNull(metadataStrategy, "the strategy for metadata extraction cannot be null");
        updateFromModel(model, metadataStrategy);
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
     * This is a static version of the constructor {@link #MtSwiftMessage(InputStream)}
     *
     * @since 7.7
     */
    public static MtSwiftMessage parse(final InputStream stream) throws IOException {
        return new MtSwiftMessage(stream);
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
     * This method deserializes the JSON data into an MT message object.
     *
     * @param json JSON representation
     * @return message object
     * @since 7.10.3
     */
    public static MtSwiftMessage fromJson(String json) {
        final Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, MtSwiftMessage.class);
    }

    /**
     * Calls {@link #updateFromMessage(MessageMetadataStrategy)} with {@link DefaultMtMetadataStrategy}
     *
     * @since 7.7
     */
    @Override
    protected void updateFromMessage() throws IllegalArgumentException {
        updateFromMessage(new DefaultMtMetadataStrategy());
    }

    /**
     * @throws IllegalArgumentException if the source format is not {@link FileFormat#FIN} or if the message cannot be parsed into a {@link MtSwiftMessage} object
     * @see AbstractSwiftMessage#updateFromMessage(MessageMetadataStrategy)
     * @since 9.1.4
     */
    @Override
    protected void updateFromMessage(MessageMetadataStrategy metadataStrategy) throws IllegalArgumentException {
        Objects.requireNonNull(metadataStrategy, "the strategy for metadata extraction cannot be null");
        Objects.requireNonNull(getMessage(), "the raw message attribute cannot be null");
        if (getFileFormat() != FileFormat.FIN) {
            throw new IllegalArgumentException(
                    "expected source format " + FileFormat.FIN + " and found " + getFileFormat());
        }
        SwiftMessage model = null;
        try {
            model = SwiftMessage.parse(getMessage());
        } catch (final IOException e) {
            log.log(Level.SEVERE, "the raw message parameter could not be parsed into a SwiftMessage", e);
        }
        if (model == null) {
            throw new IllegalArgumentException("the raw message parameter could not be parsed into a SwiftMessage");
        } else {
            updateAttributes(model, metadataStrategy);
        }
    }

    private void updateAttributes(final SwiftMessage model, final MessageMetadataStrategy metadataStrategy) {
        if (model.isServiceMessage21()) {
            // for service messages, we attempt to set the metadata from the original attached message, if present
            if (model.getUnparsedTextsSize() > 0) {
                final SwiftMessage original = model.getUnparsedTexts().getTextAsMessage(0);
                if (original != null) {
                    extractMetadata(original, metadataStrategy);
                }
            }
            // then we overwrite the identifier form the actual service message
            if (model.isAck()) {
                setIdentifier(IDENTIFIER_ACK);
            } else if (model.isNack()) {
                setIdentifier(IDENTIFIER_NAK);
            }

        } else {
            // any other case we just update the metadata from the received message
            extractMetadata(model, metadataStrategy);
            Optional<String> identifier = metadataStrategy.identifier(model.toMT());
            identifier.ifPresent(this::setIdentifier);
        }

        setFileFormat(FileFormat.FIN);

        Optional<String> sender = metadataStrategy.sender(model.toMT());
        sender.ifPresent(s -> setSender(bic11(s)));

        setChecksum(SwiftMessageUtils.calculateChecksum(model));
        setChecksumBody(SwiftMessageUtils.calculateChecksum(model.getBlock4()));
        setLastModified(Calendar.getInstance());
        setMur(model.getMUR());
    }

    private void extractMetadata(final SwiftMessage model, final MessageMetadataStrategy metadataStrategy) {

        Optional<String> receiver = metadataStrategy.receiver(model.toMT());
        receiver.ifPresent(r -> setReceiver(bic11(r)));
        setDirection(model.getDirection());

        setPde(model.getPDE());
        setPdm(model.getPDM());
        setMir(model.getMIR());

        if (model.getBlock2() != null) {
            setUuid(model.getUUID());
        }

        // we extract metadata with the default strategy
        // specific strategy can be applied on top with the #updateMetadata method
        applyStrategy(model, metadataStrategy);
    }

    private void applyStrategy(SwiftMessage model, MessageMetadataStrategy strategy) {
        AbstractMT mt = model.toMT();

        if (mt == null) {
            // prevent NPE
            return;
        }

        String reference = strategy.reference(mt).orElse(null);
        if (StringUtils.isNotBlank(reference)) {
            setReference(reference);
        }

        Optional<Money> money = strategy.amount(mt);
        if (money.isPresent()) {
            setCurrency(money.get().getCurrency());
            setAmount(money.get().getAmount());
        }

        strategy.valueDate(mt).ifPresent(this::setValueDate);

        strategy.tradeDate(mt).ifPresent(this::setTradeDate);
    }

    /**
     * Calls {@link #updateFromFIN(String, MessageMetadataStrategy)} with the {@link DefaultMtMetadataStrategy}
     *
     * @param fin raw (FIN) message content to update from
     */
    public void updateFromFIN(final String fin) {
        updateFromFIN(fin, new DefaultMtMetadataStrategy());
    }

    /**
     * Updates the the attributes with the raw message and its metadata from the given raw (FIN) message content.
     *
     * @param fin              the new message content
     * @param metadataStrategy a strategy implementation to extract the metadata from the FIN content
     * @since 9.1.4
     */
    public void updateFromFIN(final String fin, final MessageMetadataStrategy metadataStrategy) {
        Objects.requireNonNull(fin, "the raw message parameter cannot be null");
        Objects.requireNonNull(metadataStrategy, "the strategy for metadata extraction cannot be null");
        setMessage(fin);
        setFileFormat(FileFormat.FIN);
        updateFromMessage(metadataStrategy);
    }

    /**
     * Calls {@link #updateFromModel(SwiftMessage, MessageMetadataStrategy)} with the {@link DefaultMtMetadataStrategy}
     *
     * @param model model to update from
     */
    public void updateFromModel(final SwiftMessage model) {
        updateFromModel(model, new DefaultMtMetadataStrategy());
    }

    /**
     * The SwiftMessage is serialized to its FIN raw format to set the internal raw message attribute.
     * And the header attributes are set with data from the parameter SwiftMessage.
     * Notice that the SwiftMessage is not stored as internal attribute.
     *
     * @param model            the new message content
     * @param metadataStrategy a strategy implementation to extract the metadata from the model
     * @since 9.1.4
     */
    public void updateFromModel(final SwiftMessage model, final MessageMetadataStrategy metadataStrategy) {
        Objects.requireNonNull(model, "the model message cannot be null");
        Objects.requireNonNull(metadataStrategy, "the metadata strategy cannot be null");
        final String fin = new ConversionService().getFIN(model);
        Objects.requireNonNull(fin, "the raw message could not be created from the SwiftMessage parameter");
        setMessage(fin);
        updateAttributes(model, metadataStrategy);
    }

    /**
     * Calls {@link #updateFromModel(AbstractMT, MessageMetadataStrategy)} with the {@link DefaultMtMetadataStrategy}
     *
     * @param mt message to update from
     * @since 7.8.4
     */
    public void updateFromModel(final AbstractMT mt) {
        updateFromModel(mt, new DefaultMtMetadataStrategy());
    }

    /**
     * The AbstractMT is serialized to its FIN raw format to set the internal raw message attribute.
     * And the header attributes are set with data from the parameter AbstractMT.
     * Notice that the AbstractMT is not stored as internal attribute.
     *
     * @param mt               the new message content to set
     * @param metadataStrategy a strategy implementation to extract the metadata from the model
     * @since 9.1.4
     */
    public void updateFromModel(final AbstractMT mt, final MessageMetadataStrategy metadataStrategy) {
        Objects.requireNonNull(mt, "the model message cannot be null");
        Objects.requireNonNull(metadataStrategy, "the metadata strategy cannot be null");
        updateFromModel(mt.getSwiftMessage(), metadataStrategy);
    }

    /**
     * Parses the raw message content into a {@link SwiftMessage} object.
     *
     * @return the parsed message or null if the raw content is not set or cannot be parsed
     * @since 7.8.9
     */
    public SwiftMessage modelMessage() {
        if (getMessage() != null) {
            try {
                return SwiftMessage.parse(message());
            } catch (IOException e) {
                log.log(Level.WARNING, "error converting FIN text to model: " + e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * Get the integer value of the {@link #getMessageType()}
     * or null if the identifier attribute is not set or not a number.
     *
     * @return message type as integer
     */
    public Integer getMessageTypeInt() {
        final String number = getMessageType();
        if (StringUtils.isNumeric(number)) {
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                log.log(Level.WARNING, "error parsing message type as number: " + e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * Get the value of the property under the {@link #PROPERTY_NAME} key or the result of {@link #getMessageType()}
     *
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
    public boolean isType(final Integer... type) {
        for (final Integer integer : type) {
            if (isType(integer)) {
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
        return "MtSwiftMessage id=" + getId() + " message=" + getMessage();
    }

    /**
     * Gets PDE (Possible Duplicate Emission) flag from the trailer block or null if the trailer or the PDE field is not present
     *
     * @return the PDE flag or null
     */
    public String getPde() {
        return pde;
    }

    /**
     * Sets the PDE attribute.
     * This field is automatically updated on message update from FIN or model
     *
     * @param pde the PDE flag to set
     * @see #updateFromFIN(String)
     * @see #updateFromModel(AbstractMT)
     * @see #updateFromModel(SwiftMessage)
     */
    public void setPde(final String pde) {
        this.pde = pde;
    }

    /**
     * Gets PDM from the trailer block or null if the trailer or the PDM field is not present
     *
     * @return PDM flag or null
     */
    public String getPdm() {
        return pdm;
    }

    /**
     * Sets the PDM attribute.
     * This field is automatically updated on message update from FIN or model
     *
     * @param pdm the PDM flag to set
     * @see #updateFromFIN(String)
     * @see #updateFromModel(AbstractMT)
     * @see #updateFromModel(SwiftMessage)
     */
    public void setPdm(final String pdm) {
        this.pdm = pdm;
    }

    /**
     * Gets the MIR (Message Input Reference)
     *
     * @return MIR
     * @see SwiftMessage#getMIR()
     */
    public String getMir() {
        return mir;
    }

    /**
     * Sets the MIR attribute.
     * This field is automatically updated on message update from FIN or model
     *
     * @param mir the MIR to set
     * @see #updateFromFIN(String)
     * @see #updateFromModel(AbstractMT)
     * @see #updateFromModel(SwiftMessage)
     */
    public void setMir(final String mir) {
        this.mir = mir;
    }

    /**
     * Gets the MUR (Message User Reference) from block 3
     *
     * @return the MUR or null if not present in the message
     * @see SwiftMessage#getMUR()
     */
    public String getMur() {
        return mur;
    }

    /**
     * Sets the MUR attribute.
     * This field is automatically updated on message update from FIN or model
     *
     * @param mur the MUR to set
     * @see #updateFromFIN(String)
     * @see #updateFromModel(AbstractMT)
     * @see #updateFromModel(SwiftMessage)
     */
    public void setMur(final String mur) {
        this.mur = mur;
    }

    /**
     * Gets a UUID (User Unique Identifier).
     *
     * @return UUID
     * @see SwiftMessage#getUUID()
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets a UUID.
     * This field is automatically updated on message update from FIN or model.
     *
     * @param uuid UUID to set
     * @see #updateFromFIN(String)
     * @see #updateFromModel(AbstractMT)
     * @see #updateFromModel(SwiftMessage)
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
        return Objects.equals(pde, that.pde)
                && Objects.equals(pdm, that.pdm)
                && Objects.equals(mir, that.mir)
                && Objects.equals(mur, that.mur)
                && Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pde, pdm, mir, mur, uuid);
    }

    /**
     * Creates a full copy of the current message object into another message.
     *
     * @param msg target message
     * @see AbstractSwiftMessage#copyTo(AbstractSwiftMessage)
     * @since 7.7
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
     * Returns the message type variant
     *
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
     *
     * @return the identification object for this message
     * @since 7.10.4
     */
    public MtId getMtId() {
        return new MtId(getMessageType(), getVariant());
    }

    /**
     * For MT messages returns the category number and for MX messages return the business process.
     * For example for MT103 returns 1 and for pacs.004.001.06 returns pacs
     *
     * @return a string with the category or empty if the identifier is invalid or not present
     * @since 7.10.4
     */
    @Override
    public String getCategory() {
        if (!StringUtils.isBlank(this.identifier)) {
            return new MtId(this.identifier).category();
        }
        return "";
    }

    /**
     * Enables injecting your own implementation for the entity metadata extraction, to set the generic properties
     * shared by all message types: main reference, main amount and currency, value date, trade date.
     *
     * @param strategy meta data strategy
     * @since 9.1.4
     */
    public void updateMetadata(MessageMetadataStrategy strategy) {
        Objects.requireNonNull(strategy, "the strategy for metadata extraction cannot be null");
        applyStrategy(modelMessage(), strategy);
    }
}

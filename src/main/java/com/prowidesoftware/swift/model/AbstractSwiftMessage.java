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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prowidesoftware.JsonSerializable;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.utils.Lib;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlTransient;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

/**
 * Base class for common attributes of MT and MX SWIFT messages intended for messages persistence.<br />
 * 
 * This class hierarchy is designed as a container of the raw message contents (xml for MX and FIN for MT)
 * plus minimal message metadata. The extra data contains several common attributes for all messages, and
 * the subclasses add additional information mainly to identify the specific message type.<br />
 * 
 * This minimal abstraction make this model optimal for an ORM mapping (ex: for Hibernate) to store
 * all messages in a single and simple table.
 * 
 * @author www.prowidesoftware.com
 * @since 7.0
 */
public abstract class AbstractSwiftMessage implements Serializable, JsonSerializable {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(AbstractSwiftMessage.class.getName());
	private static final long serialVersionUID = 3769865560736793606L;
	
	/**
	 * Identifier constant for acknowledge service messages
	 * @since 7.8.8
	 */
	protected final static String IDENTIFIER_ACK = "ACK";
	
	/**
	 * Identifier constant for non-acknowledge service messages
	 * @since 7.8.8
	 */
	protected final static String IDENTIFIER_NAK = "NAK";

	/**
	 * Unique identifier (used for ORM mapped to the table record id)
	 */
	private Long id;
	private String message;
	protected String identifier;
	protected String sender;
	protected String receiver;
	private MessageIOType direction;
	private String checksum;
	private String checksumBody;
	private Calendar lastModified = Calendar.getInstance();
	private Calendar creationDate = Calendar.getInstance();
	private List<SwiftMessageStatusInfo> statusTrail = new ArrayList<SwiftMessageStatusInfo>();
	private String status;
	private List<SwiftMessageNote> notes = new ArrayList<SwiftMessageNote>();
	private Map<String, String> properties = new HashMap<String, String>();
	private String filename;
	private FileFormat fileFormat;
	private String reference;
	private String currency;
	private BigDecimal amount;
	private List<SwiftMessageRevision> revisions = new ArrayList<SwiftMessageRevision>();

	/**
	 * Empty constructor provided for ORM persistence.
	 * On most situations this objects are constructed with message data as parameter.
	 * @since 7.7
	 */
	public AbstractSwiftMessage() {
		super();
	}
	
	/**
	 * Creates a new message reading the message the content from a string. 
	 * Uses abstract method @link {{@link #updateFromMessage()}} to fill the specific metadata attributes.<br />
	 * 
	 * The complete string content will be read and set as raw message content, but if the stringt contains 
	 * multiple messages, only the first one will be used for metadata and message identification.
	 * 
	 * @param content a swift message content
	 * @since 7.7
	 */
	protected AbstractSwiftMessage(final String content) {
		super();
		this.message = content;
	    updateFromMessage();
	}
	
	/**
	 * @see AbstractSwiftMessage#AbstractSwiftMessage(String)
	 * @since 7.8.4
	 * @param content
	 * @param fileFormat
	 */
	protected AbstractSwiftMessage(final String content, final FileFormat fileFormat) {
		super();
		this.message = content;
		this.fileFormat = fileFormat;
	    updateFromMessage();
	}
	
	/**
	 * Creates a new message reading the message the content from an input stream, using UTF-8 as encoding.
	 * Uses abstract method {{@link #updateFromMessage()}} to fill the specific metadata attributes.<br />
	 * 
	 * The complete stream content will be read and set as raw message content, but if the stream contains 
	 * multiple messages, only the first one will be used for metadata and message identification.
	 *  
	 * @param stream
	 * @since 7.7
	 */
	protected AbstractSwiftMessage(final InputStream stream) throws IOException {
		super();
	    this.message = Lib.readStream(stream);
	    updateFromMessage();
	}
	
	/**
	 * @see #AbstractSwiftMessage(InputStream) 
	 * @param stream
	 * @param fileFormat
	 * @throws IOException
	 * @since 7.8.4
	 */
	protected AbstractSwiftMessage(final InputStream stream, final FileFormat fileFormat) throws IOException {
		super();
	    this.message = Lib.readStream(stream);
		this.fileFormat = fileFormat;
	    updateFromMessage();
	}
	
	/**
	 * Creates a new message reading the message the content from a file. 
	 * Uses abstract method {{@link #updateFromMessage()}} to fill the specific metadata attributes.<br />
	 * 
	 * The complete file content will be read and set as raw message content, but if the file contains 
	 * multiple messages, only the first one will be used for metadata and message identification.
	 * 
	 * @param file an existing file name containing only one message.
	 * @since 7.7
	 */
	protected AbstractSwiftMessage(final File file) throws IOException {
		super();
	    this.message = Lib.readFile(file);
	    this.filename = file.getAbsolutePath();
	    updateFromMessage();
	}
	
	/**
	 * @see #AbstractSwiftMessage(File)
	 * @param file
	 * @param fileFormat
	 * @throws IOException
	 * @since 7.8.4
	 */
	protected AbstractSwiftMessage(final File file, final FileFormat fileFormat) throws IOException {
		super();
	    this.message = Lib.readFile(file);
	    this.filename = file.getAbsolutePath();
		this.fileFormat = fileFormat;
	    updateFromMessage();
	}
	
	/**
	 * Updates the object attributes with metadata parsed from the message raw content:
	 * identifier, sender, receiver, direction and specific data for the implementing subclass.<br/>
	 * 
	 * @since 7.7
	 */
    protected abstract void updateFromMessage();
	
    /**
     * Returns the persisted message unique identifier.
     */
	public Long getId() {
		return id;
	}
	
    /**
     * Used by the ORM to set the database unique identifier.
     */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Raw message content. FIN for MTS, and XML for MX.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns the internal swift message in its original raw format.
	 * Same as {@link #getMessage()}
	 * 
	 * @return raw content of the message
	 * @since 7.7
	 */
	public String message() {
		return message;
	}

    /**
     * Set the raw content of the message.
     * <p>
     * IMPORTANT: this will not automatically update the metadata attributes.
     * Consider using one of the specific subclass <strong>update</strong> methods.
     * @see MtSwiftMessage#updateFromFIN(String)}
     * @see MtSwiftMessage#updateFromModel(com.prowidesoftware.swift.model.mt.AbstractMT)}
     * @see MtSwiftMessage#updateFromModel(SwiftMessage)} 
     * @see MxSwiftMessage#updateFromXML(String)}
     * @see MxSwiftMessage#updateFromModel(com.prowidesoftware.swift.model.mx.AbstractMX)
     * </p>
     * 
     * @param message raw content of the message
     */
    public void setMessage(String message) {
		this.message = message;
	}
    
	/**
	 * Message type identification as specify by SWIFT.
	 * <ul>
	 * 	<li>For MT: fin.<msgtype>[.<mug|variant>] for example fin.103.STP, fin.103.REMIT, fin.202, fin.202.COV</li>
	 * 	<li>For MX: <bus.area>.<msgtype>.<variant>.<version> for example: camt.034.001.02, ifds.001.001.01</li>
	 * 	<li>For acknowledge service messages @see {@link AbstractSwiftMessage#IDENTIFIER_ACK}</li>
	 * 	<li>For non-acknowledge service messages @see {@link AbstractSwiftMessage#IDENTIFIER_NAK}</li>
	 * 	<li>For other service messages the identifier is left <code>null</code></li>
	 * </ul>
	 */
	public String getIdentifier() {
		return identifier;
	}
	
	/**
 	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param identifier
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	/**
	 * Proprietary checksum computed for the whole raw message content, helpful for integrity verification or duplicates detection.
	 * 
	 * <p>At the moment this is only implemented for MT messages</p>
	 * @see SwiftMessageUtils#calculateChecksum(SwiftMessage)
	 */
	//TODO implement the same for MX, computing hash on XSLT normalized version of the XML
	public String getChecksum() {
		return checksum;
	}
	
	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * <p>At the moment this is only implemented for MT messages</p>
	 * @see SwiftMessageUtils#calculateChecksum(SwiftMessage)
	 * @param checksum
	 */
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	
	/**
 	 * Gets the proprietary checksum calculated for the text block (block 4) only in MT or Document only in MX, helpful for integrity verification or duplicates detection.
 	 * 
 	 * <p>At the moment this is only implemented for MT messages</p>
	 * @see SwiftMessageUtils#calculateChecksum(SwiftBlock4)
	 * @since 7.9.5
	 */
	//TODO implement the same for MX, computing hash on XSLT normalized version of the XML
	public String getChecksumBody() {
		return checksumBody;
	}

	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param checksumBlock4 the checksum to set
	 * @since 7.9.5
	 */
	public void setChecksumBody(String checksumBody) {
		this.checksumBody = checksumBody;
	}
	
	/**
	 * Last modification date and time.
	 */
	@XmlTransient
	public Calendar getLastModified() {
		return lastModified;
	}
	
	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param lastModified
	 */
	public void setLastModified(Calendar lastModified) {
		this.lastModified = lastModified;
	}
	
	/**
	 * Creation date and time.
	 */
	@XmlTransient
	public Calendar getCreationDate() {
		return creationDate;
	}
	
	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param creationDate
	 */
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * User comments attached to this message.
	 */
	public List<SwiftMessageNote> getNotes() {
		return notes;
	}
	
	/**
	 * @see #addNote(SwiftMessageNote)
	 */
	public void setNotes(List<SwiftMessageNote> notes) {
		this.notes = notes;
	}
	
	/**
	 * Flexible property container to extend message metadata.
	 */
	@XmlTransient
	public Map<String, String> getProperties() {
		return properties;
	}
	
	/**
	 * @see #setProperty(Enum, String)
	 * @see #setProperty(String, String)
	 */
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	
	/**
	 * Status history for this message.
	 * current status is the last one in the list.
	 */
	public List<SwiftMessageStatusInfo> getStatusTrail() {
		return statusTrail;
	}
	
	/**
	 * @see #addStatus(SwiftMessageStatusInfo)
	 * @param statusTrail
	 */
	public void setStatusTrail(List<SwiftMessageStatusInfo> statusTrail) {
		this.statusTrail = statusTrail;
	}
	
	/**
	 * Get the name of the last status set to this message, or <code>null</code> if none is found.
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status attribute. Notice that this method does not update the status trail.
	 * @see #addStatus(SwiftMessageStatusInfo)
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Senders BIC11 code.<br />
	 * For MT messages this is the BIC11 portion of the sender logical terminal; for outgoing messages the LT at block 1 
	 * is used, and for incoming messages it is the LT at the MIR of block 2.
	 * For MX messages this is the (capitalized) BIC information in the "From" tag of the Application Header.
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * Receivers BIC11 code.<br />
	 * For MT messages this is the BIC11 portion of the receiver logical terminal; for outgoing messages the LT at 
	 * block 2 is used, and for incoming messages it is the LT at block 1.
	 * For MX messages this is the (capitalized) BIC information in the "To" tag of the Application Header.
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param receiver
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * Direction from application perspective;
	 * message is sent to SWIFT are outgoing and
	 * messages received from SWIFT are incoming.
	 */
	public MessageIOType getDirection() {
		return direction;
	}

	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param direction
	 */
	public void setDirection(MessageIOType direction) {
		this.direction = direction;
	}
	
	/**
	 * Original filename if applies.
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public static final transient String PROPERTY_NAME = "name";
	
	/**
	 * Get the value of the property under the {@link #PROPERTY_NAME} key or <code>null</code> if not found
	 */
	public String getMessageName() {
		Map<String, String> p = getProperties();
		if (p!=null && p.containsKey(PROPERTY_NAME) && StringUtils.isNotBlank(p.get(PROPERTY_NAME))) {
			return p.get(PROPERTY_NAME);
		}
		return null;
	}
	
	/**
	 * Adds a status to the message's status trail and current status attribute, initializing the statuses trail list if necessary.
	 * @param status the status to add
	 */
	public void addStatus(SwiftMessageStatusInfo status) {
		if (status != null) {
			if (this.getStatusTrail() == null) {
				this.setStatusTrail(new ArrayList<SwiftMessageStatusInfo>());
			}
			this.statusTrail.add(status);
			setStatus(status.getName());
		}
	}
		
	/**
	 * @return true if the message is outgoing (sent to SWIFT), false other case; using the direction attribute.
	 */
	public boolean isOutgoing() {
		return this.direction == MessageIOType.outgoing;
	}
	
	/**
	 * @see #isOutgoing()
	 */
	public boolean isInput() {
		return isOutgoing();
	}

	/**
	 * @return true if the message is incoming (received from SWIFT), false other case; using the direction attribute.
	 */
	public Boolean isIncoming() {
		return this.direction == MessageIOType.incoming;
	}

	/**
	 * @see #isIncoming()
	 */
	public Boolean isOutput() {
		return isIncoming();
	}
	
	/**
	 * @see #addStatus(SwiftMessageStatusInfo)
	 */
	public void setStatus(SwiftMessageStatusInfo status) {
		addStatus(status);
	}
		
	/**
	 * Returns true if the current status is equals to the parameter status
	 * @param status
	 */
	public boolean isStatus(String status) {
		return StringUtils.equals(status, getStatus());
	}

	/**
	 * Returns true if the current status is equals to the parameter status
	 * @param status
	 */
	@SuppressWarnings("rawtypes")
	public boolean isStatus(Enum status) {
		if (status != null) {
			return isStatus(status.name());
		} else {
			return false;
		}
	}

	/**
	 * Retrieves from the status trail, the current status info; or <code>null</code> if none is found.
	 */
	public SwiftMessageStatusInfo getStatusInfo() {
		List<SwiftMessageStatusInfo> l = getStatusTrail();
		if ((l!=null) && !l.isEmpty()) {
			return l.get(l.size()-1);
		}
		return null;
	}

	/**
	 * Retrieves from the status trail, the status info before the current one; or <code>null</code> if none is found.
	 */
	public SwiftMessageStatusInfo getPreviousStatusInfo() {
		List<SwiftMessageStatusInfo> l = getStatusTrail();
		if ((l!=null) && !l.isEmpty()) {
			return l.get(l.size() -2);
		}
		return null;
	}
	
	/**
	 * Tell if this message has any of the given statuses in his status <b>trail</b>
	 * @param statuses a list of statuses to check in the status trail
	 */
	@SuppressWarnings("rawtypes")
	public boolean contains(Enum ... statuses) {
		boolean result = false;
		List<SwiftMessageStatusInfo> l = getStatusTrail();
		if (l != null && !l.isEmpty()) {
			for (SwiftMessageStatusInfo s : getStatusTrail()) {
				for (Enum e : statuses) {
					if (e != null && StringUtils.equals(s.getName(), e.name())) {
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * Tell if this message has any of the given statuses in his status <b>trail</b>
	 * @param statuses a list of statuses to check in the status trail
	 */
	public boolean contains(String ... statuses) {
		boolean result = false;
		List<SwiftMessageStatusInfo> l = getStatusTrail();
		if (l != null && !l.isEmpty()) {
			for (SwiftMessageStatusInfo s : getStatusTrail()) {
				for (String e : statuses) {
					if (e != null && StringUtils.equals(s.getName(), e)) {
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * Tell if this message has any of the given statuses as <b>current</b> status
	 * @param statuses
	 */
	public boolean isStatus(String ... statuses) {
		for (String s : statuses) {
			if (isStatus(s)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Tell if this message has any of the given statuses as <b>current</b> status
	 * @param statuses
	 */
	@SuppressWarnings("rawtypes")
	public boolean isStatus(Enum ... statuses) {
		for (Enum e : statuses) {
			if (e != null && isStatus(e.name())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get the last saved status data of this message or empty string if not found
	 * @param statuses an array of statuses to check data into, if <code>null</code> all message statuses are checked for data
	 * @return the most recent (last) status data found
	 */
	public String getLastData(String ...statuses) {
		List<SwiftMessageStatusInfo> l = getStatusTrail();
		if (l != null && !l.isEmpty()) {
			for (int i=l.size()-1; i>=0 ;i--) {
				String d = l.get(i).getData();
				if (d != null && (statuses == null || ArrayUtils.contains(statuses, l.get(i).getName()))) {
					return d;
				}
			}
		}
		return "";
	}
	
	/**
	 * Same as {@link #getLastData(String...)} passing a null array parameter
	 */
	public String getLastData() {
		return getLastData((String[])null);
	}

	/**
	 * Finds the first status info from the status trail, with a name matching any of the given status names, or returns <code>null</code> if not found
	 * This method is similar to {@link #findStatusInfoLast(String...)} but checks the status trail in ascending order from oldest to latest.
	 * @since 7.8.8
	 */
	public SwiftMessageStatusInfo findStatusInfo(String ... statusNames) {
		List<SwiftMessageStatusInfo> l = getStatusTrail();
		if (l != null && !l.isEmpty()) {
			for (SwiftMessageStatusInfo sms : l) {
				if (ArrayUtils.contains(statusNames, sms.getName())) {
					return sms;
				}
			}
		}
		return null;
	}

	/**
	 * Finds the first status info from the status trail, with the given name or returns <code>null</code> if not found
	 * @see #findStatusInfo(String...)
	 */
	public SwiftMessageStatusInfo findStatusInfo(String statusName) {
		String[] statuses = { statusName };
		return findStatusInfo(statuses);
	}
	
	/**
	 * Finds the last status info from the status trail, with a name matching any of the given status names, or returns <code>null</code> if not found.
	 * This method is similar to {@link #findStatusInfo(String...)} but checks the status trail in descending order from latest to oldest.
	 * @since 7.8.8
	 */
	public SwiftMessageStatusInfo findStatusInfoLast(String ... statusNames) {
		final List<SwiftMessageStatusInfo> l = getStatusTrail();
		if (l != null && !l.isEmpty()) {
			for (int i=l.size()-1; i>=0 ;i--) {
				if (ArrayUtils.contains(statusNames, l.get(i).getName())) {
					return l.get(i);
				}
			}
		}
		return null;
	}

	/**
	 * Finds the last status info from the status trail, with the given name or returns <code>null</code> if not found
	 * @see #findStatusInfoLast(String...)
	 * @since 7.8.8
	 */
	public SwiftMessageStatusInfo findStatusInfoLast(String statusName) {
		String[] statuses = { statusName };
		return findStatusInfoLast(statuses);
	}

	/**
	 * Adds a new note to the messages, initializing the note list if necessary.
	 * @param n note to add
	 */
	public void addNote(SwiftMessageNote n) {
	    if (notes==null) {
	    	notes = new ArrayList<SwiftMessageNote>();
	    }
	    notes.add(n);
	}
	
	/**
	 * Iterate message properties and truncate all needed values issuing a log entry for each truncated one
	 */
	public void sanityCheckProperties() {
		try {
			final Map<String, String> p = getProperties();
			for (Map.Entry<String, String> entry : p.entrySet()) {
				final String v = entry.getValue();
				if (v != null && v.length() > 500) {
					log.severe("Value for key="+entry.getKey()+" too long, will be truncated. value="+v);
					p.put(entry.getKey(), v.substring(0, 500));
				}
				if (entry.getKey().length() > 200) {
					log.severe("Key too long: "+entry.getKey()+" will be truncated");
					p.remove(entry.getKey());
					p.put(entry.getKey().substring(0, 200), v);
				}
			}
		} catch (Exception e) {
			log.log(java.util.logging.Level.WARNING, "Error cheking properties", e);
		}
	}
		
	/**
	 * Get the value of the property under the given key or <code>null</code> if the key is not found or its value is empty
	 */
	public String getProperty(String key) {
		Map<String, String> p = getProperties();
		if (p != null && p.containsKey(key) && StringUtils.isNotBlank(p.get(key))) {
			return p.get(key);
		}
		return null;
	}
	
	/**
	 * @see #getProperty(String)
	 */
	@SuppressWarnings("rawtypes")
	public String getProperty(Enum key) {
		return getProperty(key.name());
	}

	/**
	 * Sets a property using the given key and value, if the key exists the value is overwritten.
	 */
	public void setProperty(String key, String value) {
		if (getProperties() == null) {
			setProperties(new HashMap<String, String>());
		}
		if (StringUtils.isNotBlank(value)) {
			getProperties().put(key, value);
		}
	}

	/**
	 * @see #setProperty(String, String)
	 */
	@SuppressWarnings("rawtypes")
	public void setProperty(Enum key, String value) {
		setProperty(key.name(), value);
	}
	
	/**
	 * Returns true if the message has a property with the given key name and value "true"
	 */
	public boolean getPropertyBoolean(final String key) {
		return StringUtils.equals("true", getProperty(key));
	}
	
	/**
	 * @see #getPropertyBoolean(String)
	 */
	@SuppressWarnings("rawtypes")
	public boolean getPropertyBoolean(final Enum key) {
		return getPropertyBoolean(key.name());
	}
	
	/**
	 * Returns the internal unique id as fixed length string, padded with zeros.
	 * @return string with 10 characters with this message identifier
	 */
	public String getPaddedId() {
		String id = this.id != null? this.id.toString() : "0";
		return StringUtils.leftPad(id, 10, "0");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((checksum == null) ? 0 : checksum.hashCode());
		result = prime * result + ((checksumBody == null) ? 0 : checksumBody.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((fileFormat == null) ? 0 : fileFormat.hashCode());
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((properties == null) ? 0 : properties.hashCode());
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((revisions == null) ? 0 : revisions.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((statusTrail == null) ? 0 : statusTrail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSwiftMessage other = (AbstractSwiftMessage) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (checksum == null) {
			if (other.checksum != null)
				return false;
		} else if (!checksum.equals(other.checksum))
			return false;
		if (checksumBody == null) {
			if (other.checksumBody != null)
				return false;
		} else if (!checksumBody.equals(other.checksumBody))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (direction != other.direction)
			return false;
		if (fileFormat != other.fileFormat)
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (revisions == null) {
			if (other.revisions != null)
				return false;
		} else if (!revisions.equals(other.revisions))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusTrail == null) {
			if (other.statusTrail != null)
				return false;
		} else if (!statusTrail.equals(other.statusTrail))
			return false;
		return true;
	}

	/**
	 * @deprecated use the constructor {@link #AbstractSwiftMessage(File)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear._2018)
    public abstract AbstractSwiftMessage readFile(File file) throws IOException;

	/**
	 * Creates a full copy of the current message object into another message.
	 * <p>The implementation works as a copy constructor. All attributes are replicated into
	 * new instances in the target message. The only fields that are not copied are the Long id
	 * because they are intended for ORM (persistence) autogeneration. Preexisting data in the
	 * target message will be overwritten.</p>
	 * @param msg target message
	 * @since 7.7
	 */
	public void copyTo(AbstractSwiftMessage msg) {
		msg.setMessage(getMessage());
		msg.setIdentifier(getIdentifier());
		msg.setSender(getSender());
		msg.setReceiver(getReceiver());
		msg.setDirection(getDirection());
		msg.setChecksum(getChecksum());
		msg.setChecksumBody(getChecksumBody());
		msg.setLastModified(getLastModified());
		msg.setCreationDate(getCreationDate());
		
		msg.setStatusTrail(null);
		for (SwiftMessageStatusInfo status : getStatusTrail()) {
			msg.addStatus(new SwiftMessageStatusInfo(status.getComments(), status.getCreationDate(), status.getCreationUser(), status.getName(), status.getData()));
		}
		msg.setStatus(getStatus());
		
		msg.setNotes(null);
		for (SwiftMessageNote note : getNotes()) {
			SwiftMessageNote copy = new SwiftMessageNote(note.getCreationUser(), note.getText());
			copy.setCreationDate(note.getCreationDate());
			msg.addNote(copy);
		}

		msg.setProperties(getProperties());
		msg.setFilename(getFilename());
		msg.setFileFormat(getFileFormat());
		msg.setReference(getReference());
		msg.setCurrency(getCurrency());
		msg.setAmount(getAmount());
		
		msg.setRevisions(null);
		for (SwiftMessageRevision rev : getRevisions()) {
			SwiftMessageRevision copy = new SwiftMessageRevision();
			copy.setCreationDate(rev.getCreationDate());
			copy.setCreationUser(rev.getCreationUser());
			copy.setMessage(rev.getMessage());
			copy.setJson(rev.getJson());
			msg.addRevision(copy);
		}
    }

	/**
	 * Snapshots of message content used to track its changes history
	 * @since 7.8
	 * @return this message revisions or empty list if none is set
	 */
	public List<SwiftMessageRevision> getRevisions() {
		return revisions;
	}

	/**
	 * @since 7.8
	 * @param revisions
	 */
	public void setRevisions(List<SwiftMessageRevision> revisions) {
		this.revisions = revisions;
	}

	/**
	 * Adds a new revision to the messages, initializing the revision list if necessary.
	 * @param revision revision to add
	 * @since 7.8
	 */
	public void addRevision(SwiftMessageRevision revision) {
		if (this.revisions == null) {
			this.revisions = new ArrayList<SwiftMessageRevision>();
		}
		this.revisions.add(revision);
	}

	/**
	 * Creates a new revision of the message and adds it to the revision list.
	 * @see SwiftMessageRevision#SwiftMessageRevision(AbstractSwiftMessage)
	 * @since 7.8
	 * @return the revision added
	 */
	public SwiftMessageRevision createRevision() {
		SwiftMessageRevision rev = new SwiftMessageRevision(this);
		addRevision(rev);
		return rev;
	}

	/**
	 * True if the message is an {@link MtSwiftMessage}, false otherwise
	 * @since 7.8
	 */
	public boolean isMT() {
		return this.getClass().getSimpleName().startsWith("Mt");
	}

	/**
	 * True if the message is an {@link MxSwiftMessage}, false otherwise
	 * @since 7.8
	 */
	public boolean isMX() {
		return this.getClass().getSimpleName().startsWith("Mx");
	}
	
	/**
	 * Returns the enumeration value corresponding to this message.
	 * @return standard enumeration value or null if messages cannot be identified as either standard
	 * @since 7.8.3
	 */
	public MessageStandardType messageStandardType() {
		if (isMT()) {
			return MessageStandardType.MT;
		} else if (isMX()) {
			return MessageStandardType.MX;
		}
		return null;
	}
	
	/**
	 * Original file format if applies. 
	 * @since 7.8.4
	 * @return this message file format if any is set
	 */
	public FileFormat getFileFormat() {
		return this.fileFormat;
	}

	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @since 7.8.4
	 * @param fileFormat
	 */
	public void setFileFormat(FileFormat fileFormat) {
		this.fileFormat = fileFormat;
	}

	/**
	 * Message reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	/**
	 * Main currency
	 * @return the main currency or <code>null</code> if non is present or does not apply for this message type
	 * @since 7.8.8
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Main amount
	 * @return the main amount or <code>null</code> if non is present or does not apply for this message type
	 * @since 7.8.8
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * This field is automatically set by the <strong>constructor</strong> or when the message is updated by using a specific subclass <strong>update</strong> method.
	 * @param amount
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Applies the parameter regex to the message identifier.
	 * <br>
	 * <p>
	 * Notice the identifier will contain:
	 * <ul>
	 * <li>For MT: fin.<msgtype>[.<mug|variant>] for example fin.103.STP, fin.103.REMIT, fin.202, fin.202.COV</li>
	 * <li>For MX: <bus.area>.<msgtype>.<variant>.<version> for example: camt.034.001.02, ifds.001.001.01</li>
	 * </ul>
	 * So for example <code>fin.*</code> matches all MT messages, <code>fin.*STP</code> matches all STP MT messages
	 * and <code>camt.*</code> matches all MX messages in the category camt. 
	 * </p>
	 * 
	 * @since 7.8.4
	 * @param regex to match
	 * @return true if regex match identifier, false otherwise
	 */
	public boolean match(final String regex) {
		return this.identifier != null && StringUtils.isNotBlank(regex) && this.identifier.matches(regex);
	}

	/**
	 * If the amount is set, returns its currency and value formatted using the default locale.
	 * @see #getAmount()
	 * @see #formattedAmount(Locale, boolean)
	 * @return formatted amount for example USD 123,456.78 or empty string if amount is not set
	 * @since 7.8.8
	 */
	public String formattedAmount() {
		return formattedAmount(null, true);
	}
	
	/**
	 * If the amount is set, returns its value formatted for the given locale.
	 * @see #getAmount()
	 * @param locale a specific locale to use or <code>null</code> to use the current default locale 
	 * @param includeCurrency if true and the currency is set, the formatted value will be prefixed by the currency symbol
	 * @return formatted amount for example USD 123,456.78 or empty string if amount is not set
	 * @since 7.8.8
	 */
	public String formattedAmount(final Locale locale, boolean includeCurrency) {
		StringBuilder result = new StringBuilder();
		if (this.amount != null) {
			if (includeCurrency && this.currency != null) {
				result.append(this.currency);
				result.append(" ");
			}
			NumberFormat formatter = locale != null? NumberFormat.getInstance(locale) : NumberFormat.getInstance();
			result.append(formatter.format(this.amount));
		}
		return result.toString();
	}
	
	/**
	 * Returns true if this message identifier is {@link #IDENTIFIER_ACK}
	 * 
	 * <p>The implementation does not check the inner content of the message.</p>
	 * 
	 * <p>It is safe to use this method to check if message is effectively 
	 * and acknowledge only when the API is used with the provided subclasses
	 * for MT and MX and when the identifier has not been altered by the accesor.</p>
	 *  
	 * @return true if the identifier is {@link #IDENTIFIER_ACK} false otherwise
	 * @since 7.8.8
	 */
	public boolean identifiedAsACK() {
		return StringUtils.equals(this.identifier, IDENTIFIER_ACK);
	}
	
	/**
	 * Returns true if this message identifier is {@link #IDENTIFIER_NAK}
	 * 
	 * <p>The implementation does not check the inner content of the message.</p>
	 * 
	 * <p>It is safe to use this method to check if message is effectively 
	 * and non-acknowledge only when the API is used with the provided subclasses
	 * for MT and MX and when the identifier has not been altered by the accesor.</p>
	 *  
	 * @return true if the identifier is {@link #IDENTIFIER_NAK} false otherwise
	 * @since 7.8.8
	 */
	public boolean identifiedAsNAK() {
		return StringUtils.equals(this.identifier, IDENTIFIER_NAK);
	}
	
	/**
	 * Creates a BIC11 from the given address. 
	 * If the address contains a logical terminal it wil be dropped.
	 * If the address does not contain a branch, the default XXX will be used
	 * @param address a BIC8, BIC11 or full logical terminal address (BIC12)
	 * @return
	 * @since 7.9.5
	 * @see BIC#getBic11()
	 */
	protected String bic11(String address) {
		if (address != null) {
			return (new BIC(address)).getBic11();
		}
		return null;
	}

	/**
	 * Returns the correspondent BIC code from the headers.<br />
	 * For an outgoing message, the BIC address identifies the receiver of the message. Where for an incoming message it identifies the sender of the message.
	 * @return the correspondent BIC code or null if headers are not properly set
	 * @since 7.9.5
	 */
	public BIC getCorrespondentBIC() {
		if (isOutgoing()) {
			final String receiver = getReceiver();
			if (receiver != null) {
				return new BIC(receiver);
			}
		}
		if (isIncoming()) {
			final String sender = getSender();
			if (sender != null) {
				return new BIC(sender);
			}
		}
		return null;
	}
	
	/**
	 * The year when the message was created, extracted from the {@link #getCreationDate()}
	 * Helper read-only property useful for faceting search
	 * @return the year in YYYY format
	 * @since 7.9.7
	 */
	public String getCreationYear() {
		return String.valueOf(creationDate.get(Calendar.YEAR));
	}
	
	/**
	 * The month when the message was created, extracted from the {@link #getCreationDate()}
	 * Helper read-only property useful for faceting search
	 * @return the month number, 1 based and padded with zero, such as 01, 02, 12
	 * @since 7.9.7
	 */
	public String getCreationMonth() {
		int imonth = creationDate.get(Calendar.MONTH) + 1;
		return (imonth < 10 ? "0" : "") + String.valueOf(imonth);
	}
	
	/**
	 * The day of month when the message was created, extracted from the {@link #getCreationDate()}
	 * Helper read-only property useful for faceting search
	 * @return the day of month, padded with zero, such as 01, 02, 31
	 * @since 7.9.7
	 */
	public String getCreationDayOfMonth() {
		int iday = creationDate.get(Calendar.DAY_OF_MONTH);
        return (iday < 10 ? "0" : "") + String.valueOf(iday);
	}

	/**
	 * Gets a JSON representation of this message.
     *
	 * @since 7.10.2
	 */
	@Override
	public String toJson() {
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();
		return gson.toJson(this);
	}
	
}

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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.DeleteSchedule;
import com.prowidesoftware.swift.utils.Lib;

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
public abstract class AbstractSwiftMessage implements Serializable {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(AbstractSwiftMessage.class.getName());
	private static final long serialVersionUID = 3769865560736793606L;

	/**
	 * Unique identifier (used for ORM mapped to the table record id)
	 */
	private Long id;
	/**
	 * Raw message content. FIN for MTS, and xml for MX.
	 */
	private String message;
	/**
	 * Message type identification as specify by SWIFT.<br />
	 * For MT: fin.<msgtype>[.<mug|variant>] for example fin.103.STP, fin.103.REMIT, fin.202, fin.202.COV
	 * <br />
	 * For MX: <bus.area>.<msgtype>.<variant>.<version> for example: camt.034.001.02, ifds.001.001.01
	 */
	protected String identifier;
	/**
	 * Senders BIC8 code.<br />
	 * For MT messages this is the BIC8 portion of the sender logical terminal; for outgoing messages the LT at block 1 
	 * is used, and for incoming messages it is the LT at the MIR of block 2.
	 * For MX messages this is the (capitalized) BIC information in the "From" tag of the Application Header.
	 */
	protected String sender;
	/**
	 * Receivers BIC8 code.<br />
	 * For MT messages this is the BIC8 portion of the receiver logical terminal; for outgoing messages the LT at 
	 * block 2 is used, and for incoming messages it is the LT at block 1.
	 * For MX messages this is the (capitalized) BIC information in the "To" tag of the Application Header.
	 */
	protected String receiver;
	/**
	 * Direction from application perspective;
	 * message is sent to SWIFT are outgoing and
	 * messages received from SWIFT are incoming.
	 */
	private MessageIOType direction;
	/**
	 * Proprietary checksum calculated with the raw message for integrity checks.
	 */
	private String checksum;
	/**
	 * Last modification date and time.
	 */
	private Calendar lastModified = Calendar.getInstance();
	/**
	 * Creation date and time.
	 */
	private Calendar creationDate = Calendar.getInstance();
	/**
	 * Status history for this message.
	 * current status is the last one in the list.
	 */
	private List<SwiftMessageStatusInfo> statusTrail = new ArrayList<SwiftMessageStatusInfo>();
	/**
	 * Current status name
	 */
	private String status;
	/**
	 * User notes history attached to this message.
	 */
	private List<SwiftMessageNote> notes = new ArrayList<SwiftMessageNote>();
	/**
	 * Flexible property container to extend message metadata.
	 */
	private Map<String, String> properties = new HashMap<String, String>();
	/**
	 * Original filename if applies.
	 */
	private String filename;
	/**
	 * Original file format if applies. 
	 */
	private FileFormat fileFormat;
	/**
	 * Message reference
	 */
	private String reference;

	/**
	 * Snapshots of message content used to track its changes history
	 * @since 7.8
	 */
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
	 * Same as {{@link #message()}}
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns the internal swift message in its original raw format.
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
     * Consider using one of the specific update methods from the specific subclass instead.
     * </p>
     * 
     * @param message raw content of the message
     */
    public void setMessage(String message) {
		this.message = message;
	}
    
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public String getChecksum() {
		return checksum;
	}
	
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	
	@XmlTransient
	public Calendar getLastModified() {
		return lastModified;
	}
	
	public void setLastModified(Calendar lastModified) {
		this.lastModified = lastModified;
	}
	
	@XmlTransient
	public Calendar getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}
	
	public List<SwiftMessageNote> getNotes() {
		return notes;
	}
	
	public void setNotes(List<SwiftMessageNote> notes) {
		this.notes = notes;
	}
	
	@XmlTransient
	public Map<String, String> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	
	public List<SwiftMessageStatusInfo> getStatusTrail() {
		return statusTrail;
	}
	
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
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public MessageIOType getDirection() {
		return direction;
	}

	public void setDirection(MessageIOType direction) {
		this.direction = direction;
	}
	
	public String getFilename() {
		return filename;
	}

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
			// 2015.07 M explicitamente llamar get y set interceptados por hib para evitar quilombo de sesion/coleccion si esto anda ok hay que replicar en los otros similars en esta clase, notes y revisions
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
	
	public String getLastData() {
		return getLastData((String[])null);
	}
	
	/**
	 * Finds the first status info from the status trail, with the given name or returns <code>null</code> if not found
	 */
	public SwiftMessageStatusInfo findStatusInfo(String statusName) {
		List<SwiftMessageStatusInfo> l = getStatusTrail();
		if (l != null && !l.isEmpty()) {
			for (SwiftMessageStatusInfo sms : l) {
				if (StringUtils.equals(statusName, sms.getName()))
					return sms;
			}
		}
		return null;
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
			for (String k : p.keySet()) {
				String v = p.get(k);
				if (v!=null && v.length()>500) {
					log.severe("Value for key="+k+" too long, will be truncated. value="+v);
					v = v.substring(0, 500);
					p.put(k, v);
				}
				if (k.length()>200) {
					log.severe("Key too long: "+k+" will be truncated");
					p.remove(k);
					p.put(k.substring(0, 200), v);
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
		if (p!=null && p.containsKey(key) && StringUtils.isNotBlank(p.get(key))) {
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
		result = prime * result + ((checksum == null) ? 0 : checksum.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((properties == null) ? 0 : properties.hashCode());
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
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
		if (checksum == null) {
			if (other.checksum != null)
				return false;
		} else if (!checksum.equals(other.checksum))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (direction != other.direction)
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
	@DeleteSchedule(2016)
    public abstract AbstractSwiftMessage readFile(File file) throws IOException;

	/**
	 * Copies attributes from the current object to msg.
	 * Attributes:
	 * <ul>
	 * 		<li>checksum</li>
	 * 		<li>creationDate</li>
	 * 		<li>direction</li>
	 * 		<li>filename</li>
	 * 		<li>id</li>
	 * 		<li>identifier</li>
	 * 		<li>lastModified</li>
	 * 		<li>message</li>
	 * 		<li>notes</li>
	 * 		<li>properties</li>
	 * 		<li>receiver</li>
	 * 		<li>sender</li>
	 * 		<li>status</li>
	 * 		<li>statusTrail</li>
	 * </ul>
	 * @param msg
	 * @since 7.7
	 */
	public void copyTo(AbstractSwiftMessage msg) {
		msg.setChecksum(getChecksum());
		msg.setCreationDate(getCreationDate());
		msg.setDirection(getDirection());
		msg.setFilename(getFilename());
		msg.setId(getId());
		msg.setIdentifier(getIdentifier());
		msg.setLastModified(getLastModified());
		msg.setMessage(getMessage());
		msg.setNotes(getNotes());
		msg.setProperties(getProperties());
		msg.setReceiver(getReceiver());
		msg.setSender(getSender());
		msg.setStatus(getStatus());
		msg.setStatusTrail(getStatusTrail());
    }

	/**
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
	 * @since 7.8.4
	 * @return this message file format if any is set
	 */
	public FileFormat getFileFormat() {
		return this.fileFormat;
	}

	/**
	 * This should mostly be set automatically by update API in implementing subclasses
	 * @since 7.8.4
	 * @param fileFormat
	 */
	public void setFileFormat(FileFormat fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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
}

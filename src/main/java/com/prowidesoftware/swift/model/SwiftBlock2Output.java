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
import org.apache.commons.lang3.Validate;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for SWIFT <b>Application Header Block (block 2)
 * for OUTPUT (from SWIFT)</b>.<br>
 * This block is used to construct messages that have been 
 * <i>output</i> from the SWIFT network. From the application point
 * of view, it correspond to the <i>RECEIVED</i> messages.<br><br>
 * 
 * <p>It's value is fixed-length and continuous with no field delimiters. 
 * This class contains its elements as individual attributes for 
 * easier management of the block value.
 * 
 * <p>For a received message, a message being output from SWIFT, the 
 * SwiftBlock2Output includes explicit information regarding the MIR. 
 * This is sometimes confusing because it is an output block with an 
 * input reference. The important thing to understand here is that the 
 * MIR information is related to the original sender of the message that 
 * has been received. The attributes of this header (block 2 output) are 
 * explicitly documented as MIR information by SWIFT.
 * 
 * <p>The MOR itself could be created combining information from block 1 
 * and 2 but it usually does not make sense.
 *
 * @since 4.0
 * @see MIR
 */
//TODO: add parameter checks (Validate.*) and complete javadocs 
public class SwiftBlock2Output extends SwiftBlock2 implements Serializable {
	private static final long serialVersionUID = 6067091531833134527L;
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftBlock2.class.getName());
	private static final String SEPARATOR = "\", \n";

	/** 
	 * String of 4 characters containing the input time with respect to the sender
	 */
	private String senderInputTime;

	/**
	 * Date part of the MIR in YYMMDD format.
	 */
	private String MIRDate;

	/**
	 * String of 12 characters containing the logical terminal field of the MIR
	 * (address of the sender of the message).
	 * 
	 */
	private String MIRLogicalTerminal;

	/**
	 * String of 4 characters containing the session number field of the MIR.
	 * 
	 */
	private String MIRSessionNumber;

	/**
	 * String of 6 characters containing the sequence number field of the MIR.
	 * 
	 */
	private String MIRSequenceNumber;

	/**
	 * String of 6 characters containing the Output date local 
	 * to the receiver, written in the following format: YYMMDD
	 */
	private String receiverOutputDate;

	/**
	 * String of 4 characters containing the Output time local 
	 * to the receiver, written in the following format: HHMM
	 */
	private String receiverOutputTime;

	/**
	 * Constructor for specific values
	 * 
	 * @param messageType the message type
	 * @param senderInputTime the input time
	 * @param MIRDate date
	 * @param MIRLogicalTerminal logical terminal
	 * @param MIRSessionNumber session number
	 * @param MIRSequenceNumber message sequence number
	 * @param receiverOutputDate receiver date
	 * @param receiverOutputTime receiver time
	 * @param messagePriority the message priority (S=system, U=urgent, N=normal)
	 */
	public SwiftBlock2Output(final String messageType, final String senderInputTime, final String MIRDate, final String MIRLogicalTerminal, final String MIRSessionNumber, final String MIRSequenceNumber, final String receiverOutputDate, final String receiverOutputTime, final String messagePriority) {
		super();
		this.output = true;
		this.messageType = messageType;
		this.senderInputTime = senderInputTime;
		this.MIRDate = MIRDate;
		this.MIRLogicalTerminal = MIRLogicalTerminal;
		this.MIRSessionNumber = MIRSessionNumber;
		this.MIRSequenceNumber = MIRSequenceNumber;
		this.receiverOutputDate = receiverOutputDate;
		this.receiverOutputTime = receiverOutputTime;
		this.messagePriority = messagePriority;
	}

	/**
	 * Creates the block with lenient false, meaning it expects a fixed length value.
	 * Example of supported values:<br> 
	 * "O1001200970103BANKBEBBAXXX22221234569701031201N" or "2:O1001200970103BANKBEBBAXXX22221234569701031201N"
	 * 
	 * @param value a fixed length string of 46 (starting with 'O') or 49 (starting with '2:O') characters containing the blocks value
	 * @throws IllegalArgumentException if parameter is not 47 or 49 characters 
	 * @see #SwiftBlock2Output(String, boolean)
	 */
	public SwiftBlock2Output(final String value) {
		this(value, false);
	}
	
	/**
 	 * Creates a block 2 output object setting attributes by parsing the string argument containing the blocks value. 
	 * This value can be in different flavors because some fields are optional.<br>
	 * 
	 * @param value string containing the entire blocks value
	 * @param lenient if true the value will be parsed with a best effort heuristic, if false it will throw a IllegalArgumentException if the value has an invalid total size
	 * @see #setValue(String, boolean)
	 * @since 7.7
	 */
	public SwiftBlock2Output(final String value, boolean lenient) {
		super();
		this.setValue(value, lenient);
	}

	/**
	 * Default Constructor
	 */
	public SwiftBlock2Output() {
		super();
	}

	/**
	 * Copy constructor
	 * @param block an existing block2 to copy
	 * @since 7.10.4
	 */
	public SwiftBlock2Output(SwiftBlock2Output block) {
		this(block.getMessageType(), block.getSenderInputTime(), block.getMIRDate(), block.getMIRLogicalTerminal(), block.getMIRSessionNumber(), block.getMIRSequenceNumber(), block.getReceiverOutputDate(), block.getReceiverOutputTime(), block.getMessagePriority());
	}

	/**
	 * Sets the input time with respect to the sender
	 * 
	 * @param senderInputTime 4 numbers HHMM
	 */
	public void setSenderInputTime(final String senderInputTime) {
		this.senderInputTime = senderInputTime;
	}

	/**
	 * Returns the input time with respect to the sender
	 * 
	 * @return 4 numbers HHMM
	 */
	public String getSenderInputTime() {
		return senderInputTime;
	}

	/**
	 * Sets the date the sender sent the message to SWIFT,
	 * from the MIR field
	 * 
	 * @param MIRDate 6 numbers with date in format YYMMDD
	 */
	public void setMIRDate(final String MIRDate) {
		this.MIRDate = MIRDate;
	}

	/**
	 * Gets the date the sender sent the message to SWIFT,
	 * from the MIR field, in the format YYMMDD
	 * 
	 * @return String with 6 numbers
	 */
	public String getMIRDate() {
		return this.MIRDate;
	}

	/**
	 * Sets the the full LT address of the sender of the message.
	 * 
	 * @param MIRLogicalTerminal 12 characters full LT address
	 */
	public void setMIRLogicalTerminal(final String MIRLogicalTerminal) {
		this.MIRLogicalTerminal = MIRLogicalTerminal;
	}
	
	/**
	 * Sets the the full LT address of the sender of the message.
	 * 
	 * @see LogicalTerminalAddress#getSenderLogicalTerminalAddress()
	 * @param MIRLogicalTerminal 12 characters full LT address
	 * @since 7.6
	 */
	public void setMIRLogicalTerminal(final LogicalTerminalAddress MIRLogicalTerminal) {
		this.MIRLogicalTerminal = MIRLogicalTerminal.getSenderLogicalTerminalAddress();
	}
	
	/**
	 * Creates a full LT address using the parameter BIC code and a default LT identifier,
	 * and sets the resulting address as MIR logical terminal address.
	 * 
	 * @see #setMIRLogicalTerminal(LogicalTerminalAddress)
	 * @param bic
	 * @since 7.6
	 */
	public void setSender(final BIC bic) {
		setMIRLogicalTerminal(new LogicalTerminalAddress(bic.getBic11()));
	}
	
	/**
	 * Completes if necessary and sets the LT address of the sender
	 * as MIR logical terminal address.<br>
 	 * The sender addresses will be filled with proper default LT identifier and branch codes if not provided.
	 * 
	 * @see #setMIRLogicalTerminal(LogicalTerminalAddress)
	 * @since 7.6
	 */
	public void setSender(final String sender) {
		setMIRLogicalTerminal(new LogicalTerminalAddress(sender));
	}
	
	/**
	 * Gets the the full LT address of the sender of the 
	 * message, from the MIR field, for example: BANKBEBBAXXX
	 * 
	 * @return LT address
	 */
	public String getMIRLogicalTerminal() {
		return this.MIRLogicalTerminal;
	}
	
	/**
	 * Gets the sender's BIC code.<br>
	 * For output message the sender address is contained in this block2
	 * and not in the header block 1 as for input messages.
	 * 
	 * @return sender BIC address
	 * @see BIC
	 * @since 7.6
	 */
	public BIC getSenderBIC() {
		return new BIC(this.MIRLogicalTerminal);
	}

	/**
	 * Sets the session number field of the MIR
	 * 
	 * @param MIRSessionNumber 4 numbers
	 */
	public void setMIRSessionNumber(final String MIRSessionNumber) {
		this.MIRSessionNumber = MIRSessionNumber;
	}

	/**
	 * Gets the date the sender session number,
	 * from the MIR field, in the format NNNN
	 * 
	 * @return 4 numbers
	 */
	public String getMIRSessionNumber() {
		return this.MIRSessionNumber;
	}

	/**
	 * Sets the sequence number field of the MIR
	 * 
	 * @param MIRSequenceNumber 6 numbers
	 */
	public void setMIRSequenceNumber(final String MIRSequenceNumber) {
		this.MIRSequenceNumber = MIRSequenceNumber;
	}

	/**
	 * Gets the date the sender sequence number,
	 * from the MIR field, in the format NNNNNN
	 * 	  
	 * @return 6 numbers
	 */
	public String getMIRSequenceNumber() {
		return MIRSequenceNumber;
	}

	/**
	 * Gets the full MIR (Message Input Reference) string of 28 
	 * characters containing the sender's date, LT address,
	 * session and sequence:<br>
	 * for example YYMMDDBANKBEBBAXXX2222123456<br>
	 * @return a String with MIR, returns null if all MIR components are null
	 */
	public String getMIR() {
		if (MIRDate == null && MIRLogicalTerminal == null && MIRSessionNumber == null && MIRSequenceNumber == null) {
			return null;
		}
		final StringBuilder v = new StringBuilder();
		if (MIRDate != null) {
			v.append(MIRDate);
		}
		if (MIRLogicalTerminal != null) {
			v.append(MIRLogicalTerminal);
		}
		if (MIRSessionNumber != null) {
			v.append(MIRSessionNumber);
		}
		if (MIRSequenceNumber != null) {
			v.append(MIRSequenceNumber);
		}
		return v.toString();
	}

	/**
	 * Sets the full MIR (Message Input Reference) from a fixed length (28 characters) string containing the complete MIR value.<br>
	 * 
	 * @param mir complete MIR string value, a fixed length (28 characters) string containing the MIR value
	 * @throws IllegalArgumentException if parameter has an invalid total size.
	 * @see #setMIR(String, boolean) 
	 */
	public void setMIR(final String mir) {
		setMIR(mir, false);
	}
	
	/**
	 * Sets the MIR (Message Input Reference) attributes by parsing the string argument containing the complete MIR value.<br>
	 * For example YYMMDDBANKBEBBAXXX2222123456<br>
	 * 
	 * @param mir complete MIR string
	 * @param lenient if true the value will be parsed with a best effort heuristic, if false it will throw a IllegalArgumentException if the value has an invalid total size
	 */
	public void setMIR(final String mir, boolean lenient) {
		if (!lenient) {
    		Validate.notNull(mir);
    		if (mir != null) {
				Validate.isTrue(mir.length() == 28, "expected a 28 characters string for MIR value and found a " + mir.length() + " string:" + mir);
			}
		}
		if (mir != null) {
    		int offset = 0;
    		int len;
    
    		len = 6;
    		this.setMIRDate(getValuePart(mir, offset, len));
    		offset += len;
    
    		len = 12;
    		this.setMIRLogicalTerminal(getValuePart(mir, offset, len));
    		offset += len;
    
    		len = 4;
    		this.setMIRSessionNumber(getValuePart(mir, offset, len));
    		offset += len;
    
    		if (lenient) {
        		//get all remaining text
    			this.setMIRSequenceNumber(getValuePart(mir, offset, mir.length()));
        	} else {
        		len = 6;
        		this.setMIRSequenceNumber(getValuePart(mir, offset, len));
        	}
		}
	}

	/**
	 * Sets the Output date local to the receiver, written in the following format: YYMMDD
	 * 
	 * @param receiverOutputDate 6 characters in format YYMMDD
	 */
	public void setReceiverOutputDate(final String receiverOutputDate) {
		this.receiverOutputDate = receiverOutputDate;
	}

	/**
	 * Gets the Output date local to the receiver
	 * 
	 * @return 6 characters in format YYMMDD
	 */
	public String getReceiverOutputDate() {
		return receiverOutputDate;
	}

	/**
	 * Sets the Output time local to the receiver, written in the following format: HHMM
	 * 
	 * @param receiverOutputTime String with 4 numbers
	 */
	public void setReceiverOutputTime(final String receiverOutputTime) {
		this.receiverOutputTime = receiverOutputTime;
	}

	/**
	 * Gets the Output time local to the receiver, written in the following format: HHMM
	 * 
	 * @return String with 4 numbers
	 */
	public String getReceiverOutputTime() {
		return receiverOutputTime;
	}

	/**
	 * Tell if this block is empty or not.
	 * This block is considered to be empty if all its attributes are set to null.
	 * @return <code>true</code> if all fields are null and false in other case
	 */
	public boolean isEmpty() {
		return messageType == null && senderInputTime == null && getMIR() == null && receiverOutputDate == null && receiverOutputTime == null && messagePriority == null;
	}

	/**
	 * Gets the fixed length block 2 value, as a result of
	 * concatenating its individual elements as follow:<br>
	 * Message Type +
	 * Sender Input Time +
	 * MIR +
	 * Receiver Output Date +
	 * Receiver Output Time +
	 * Message Priority.
	 */
	public String getValue() {
		if (isEmpty()) {
			return null;
		}
		final StringBuilder v = new StringBuilder("O");
		if (messageType != null) {
			v.append(messageType);
		}
		if (senderInputTime != null) {
			v.append(senderInputTime);
		}
		if (getMIR() != null) {
			v.append(getMIR());
		}
		if (receiverOutputDate != null) {
			v.append(receiverOutputDate);
		}
		if (receiverOutputTime != null) {
			v.append(receiverOutputTime);
		}
		if (messagePriority != null) {
			v.append(messagePriority);
		}
		return v.toString();
	}

	/**
	 * @see #getValue()
	 */
	public String getBlockValue() {
		return getValue();
	}

	/**
	 * Sets the block's attributes by parsing the fixed length string argument.<br>
	 * 
	 * @param value a fixed length (between 46 and 49) string containing the blocks' value
	 * @throws IllegalArgumentException if parameter has an invalid total size.
	 * @see #setValue(String, boolean) 
	 */
	public void setValue(final String value) {
		setValue(value, false);
	}
	
	/**
	 * Sets the block's attributes by parsing the string argument containing the blocks value.<br>
	 * This value can be in different flavors because some fields are optional.<br>
	 * Example of supported values:<br>
	 * <pre>
	 *   "O1001200970103BANKBEBBAXXX22221234569701031201" (46) or
	 *   "2:O1001200970103BANKBEBBAXXX22221234569701031201" (48)   // used for service/system messages
	 *   "O1001200970103BANKBEBBAXXX22221234569701031201N" (47) or
	 *   "2:O1001200970103BANKBEBBAXXX22221234569701031201N" (49)
	 * </pre><br>
	 * 
	 * @param value string containing the entire blocks value
	 * @param lenient if true the value will be parsed with a best effort heuristic, if false it will throw a IllegalArgumentException if the value has an invalid total size
	 */
	public void setValue(final String value, boolean lenient) {
		if (lenient) {
			//leave all attributes as null (cleaning defaults)
			clean();
		} else {
    		// check parameters
    		Validate.notNull(value, "value must not be null");
		}

		if (value != null) {

    		int slen = value.length();

    		if (!lenient) {
        		// check parameters
        		Validate.notNull(value, "value must not be null");
        		Validate.isTrue(slen == 46 || slen == 48 || slen == 47 || slen == 49, "expected a string value of 46 and up to 49 chars and obtained a " + slen + " chars string: '" + value + "'");
    		}
    		
    		// figure out the starting point and check the input value has proper optional
    		int offset = 0;
    		if (value.startsWith("2:")) { // accept 2:...
    			offset = 2;
    		} 
    		
    		slen -= offset;
    		if (!lenient) {
        		if (slen != 46 && slen != 47) {
        			throw new IllegalArgumentException("Value must match: O<mt><time><mir><date><time>[<pri>]");
        		}
        		if (Character.toUpperCase(value.charAt(offset)) != 'O') {
        			throw new IllegalArgumentException("Value must match: O<mt><time><mir><date><time>[<pri>]");
        		}
    		}
    		offset++; // skip the output mark

    		// separate value fragments
    		int len = 3;
    		this.setMessageType(this.getValuePart(value, offset, len));
    		offset += len;
    		
    		len = 4;
    		this.setSenderInputTime(this.getValuePart(value, offset, len));
    		offset += len;
    		
    		len = 28;
    		this.setMIR(this.getValuePart(value, offset, len), lenient);
    		offset += len;
    		
    		len = 6;
    		this.setReceiverOutputDate(this.getValuePart(value, offset, len));
    		offset += len;
    		
    		len = 4;
    		this.setReceiverOutputTime(this.getValuePart(value, offset, len));
    		offset += len;
        	
    		if (lenient) {
        		//get all remaining text
        		this.setMessagePriority(this.getValuePart(value, offset));
        	} else {
        		len = 1;
        		this.setMessagePriority(this.getValuePart(value, offset, len));
        	}
        	
		}
	}

	/**
	 * @see #setValue(String)
	 */
	public void setBlockValue(final String value) {
		setValue(value);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		SwiftBlock2Output that = (SwiftBlock2Output) o;
		return Objects.equals(senderInputTime, that.senderInputTime) &&
				Objects.equals(MIRDate, that.MIRDate) &&
				Objects.equals(MIRLogicalTerminal, that.MIRLogicalTerminal) &&
				Objects.equals(MIRSessionNumber, that.MIRSessionNumber) &&
				Objects.equals(MIRSequenceNumber, that.MIRSequenceNumber) &&
				Objects.equals(receiverOutputDate, that.receiverOutputDate) &&
				Objects.equals(receiverOutputTime, that.receiverOutputTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), senderInputTime, MIRDate, MIRLogicalTerminal, MIRSessionNumber, MIRSequenceNumber, receiverOutputDate, receiverOutputTime);
	}

	/**
	 * Legacy (version 1) json representation of this object.
	 *
	 * <p>This implementation has been replaced by version 2, based on Gson.
	 *
	 * @deprecated use {@link #toJson()} instead
	 * @since 7.9.8
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public String toJsonV1() {
		DeprecationUtils.phase2(getClass(), "toJsonV1()", "use toJson() instead");
		final StringBuilder sb = new StringBuilder();
		sb.append("{ \n");

		sb.append(" \"messageType\" : \"").append(messageType).append(SEPARATOR);
		sb.append(" \"senderInputTime\" : \"").append(senderInputTime).append(SEPARATOR);
		sb.append(" \"MIRDate\" : \"").append(MIRDate).append("\", \n");
		sb.append(" \"MIRLogicalTerminal\" : \"").append(MIRLogicalTerminal).append(SEPARATOR);
		sb.append(" \"MIRSessionNumber\" : \"").append(MIRSessionNumber).append(SEPARATOR);
		sb.append(" \"MIRSequenceNumber\" : \"").append(MIRSequenceNumber).append(SEPARATOR);
		sb.append(" \"receiverOutputDate\" : \"").append(receiverOutputDate).append(SEPARATOR);
		sb.append(" \"receiverOutputTime\" : \"").append(receiverOutputTime).append(SEPARATOR);
		sb.append(" \"messagePriority\" : \"").append(messagePriority).append(SEPARATOR);

		sb.append("} ");
		return sb.toString();
	}
	
	/**
	 * Generic getter for block attributes based on qualified names from {@link SwiftBlock2OutputField}
	 * @param field field to get
	 * @return field value or null if attribute is not set
	 * @since 7.7
	 */
	public String field(SwiftBlock2OutputField field) {
		switch (field) {
			case MessageType:
				return getMessageType();
			case MessagePriority:
				return getMessagePriority();
			case SenderInputTime:
				return getSenderInputTime();
			case MIRDate:
				return getMIRDate();
			case MIRLogicalTerminal:
				return getMIRLogicalTerminal();
			case MIRSessionNumber:
				return getMIRSessionNumber();
			case MIRSequenceNumber:
				return getMIRSequenceNumber();
			case ReceiverOutputDate:
				return getReceiverOutputDate();
			case ReceiverOutputTime:
				return getReceiverOutputTime();
			default:
				return null;

		}
	}
	
	/**
	 * Generic setter for block attributes based on qualified names from {@link SwiftBlock2OutputField}
	 * @param field field to get
	 * @param value content to set
	 * @since 7.8
	 */
	public void setField(SwiftBlock2OutputField field, final String value) {
		switch (field) {
			case MessageType:
				setMessageType(value);
				break;
			case MessagePriority:
				setMessagePriority(value);
				break;
			case SenderInputTime:
				setSenderInputTime(value);
				break;
			case MIRDate:
				setMIRDate(value);
				break;
			case MIRLogicalTerminal:
				setMIRLogicalTerminal(value);
				break;
			case MIRSessionNumber:
				setMIRSessionNumber(value);
				break;
			case MIRSequenceNumber:
				setMIRSequenceNumber(value);
				break;
			case ReceiverOutputDate:
				setReceiverOutputDate(value);
				break;
			case ReceiverOutputTime:
				setReceiverOutputTime(value);
				break;
			default:break;
		}
	}

	/**
	 * This method deserializes the JSON data into an incoming (output) block 2 object.
	 * @see #toJson()
	 * @since 7.9.8
	 */
	public static SwiftBlock2Output fromJson(String json){
		final Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, SwiftBlock2Output.class);
	}
}

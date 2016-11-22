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

import java.io.Serializable;

import org.apache.commons.lang.Validate;

/**
 * Base class for SWIFT <b>Application Header Block (block 2)
 * for OUTPUT (from SWIFT)</b>.<br>
 * This block is used to construct messages that have been 
 * <i>output</i> from the SWIFT network. From the application point
 * of view, it correspond to the <i>RECEIVED</i> messages.<br><br>
 * 
 * <p>It's value is fixed-length and continuous with no field delimiters. 
 * This class contains its elements as individual attributes for 
 * easier management of the block value.</p>
 * 
 * <p>For a received message, a message being output from SWIFT, the 
 * SwiftBlock2Output includes explicit information regarding the MIR. 
 * This is sometimes confusing because it is an output block with an 
 * input reference. The important thing to understand here is that the 
 * MIR information is related to the original sender of the message that 
 * has been received. The attributes of this header (block 2 output) are 
 * explicitly documented as MIR information by SWIFT.</p>
 * 
 * <p>The MOR itself could be created combining information from block 1 
 * and 2 but it usually does not make sense.</p>
 * 
 * @author www.prowidesoftware.com
 * @since 4.0
 * @see MIR
 */
//TODO: add parameter checks (Validate.*) and complete javadocs 
public class SwiftBlock2Output extends SwiftBlock2 implements Serializable {
	private static final long serialVersionUID = 6067091531833134527L;
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftBlock2.class.getName());

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
	 * as MIR logical terminal address.<br />
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
	 * Gets the sender's BIC code.<br />
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
	 * @return a String with MIR, returns <code>null</code> if all MIR components are <code>null</code> 
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
	 * Sets the MIR (Message Input Reference) attributes by parsing the string argument containing the complete MIR value.<br /> 
	 * For example YYMMDDBANKBEBBAXXX2222123456<br>
	 * 
	 * @param mir complete MIR string
	 * @param lenient if true the value will be parsed with a best effort heuristic, if false it will throw a IllegalArgumentException if the value has an invalid total size
	 */
	public void setMIR(final String mir, boolean lenient) {
		if (!lenient) {
    		Validate.notNull(mir);
    		Validate.isTrue(mir.length() == 28, "expected a 28 characters string for MIR value and found a " + mir.length() + " string:" + mir);
		}
		if (mir != null) {
    		final StringBuilder sb = new StringBuilder(mir);
    
    		int offset = 0;
    		int len;
    
    		len = 6;
    		this.setMIRDate(String.valueOf(sb.subSequence(offset, offset + len)));
    		offset += len;
    
    		len = 12;
    		this.setMIRLogicalTerminal(String.valueOf(sb.subSequence(offset, offset + len)));
    		offset += len;
    
    		len = 4;
    		this.setMIRSessionNumber(String.valueOf(sb.subSequence(offset, offset + len)));
    		offset += len;
    
    		if (lenient) {
        		//get all remaining text
    			this.setMIRSequenceNumber(String.valueOf(sb.subSequence(offset, mir.length())));
        	} else {
        		len = 6;
        		this.setMIRSequenceNumber(String.valueOf(sb.subSequence(offset, offset + len)));
        		offset += len;
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
	 * This block is considered to be empty if all its attributes are set to <code>null</code>.
	 * @return <code>true</code> if all fields are <code>null</code> and false in other case
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
	 * Sets the block's attributes by parsing the string argument containing the blocks value.<br /> 
	 * This value can be in different flavors because some fields are optional.<br />
	 * Example of supported values:<br />
	 * <pre>
	 *   "O1001200970103BANKBEBBAXXX22221234569701031201" (46) or
	 *   "2:O1001200970103BANKBEBBAXXX22221234569701031201" (48)   // used for service/system messages
	 *   "O1001200970103BANKBEBBAXXX22221234569701031201N" (47) or
	 *   "2:O1001200970103BANKBEBBAXXX22221234569701031201N" (49)
	 * </pre><br />
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
        		offset += len; // optional (system messages)
        	}
        	
		}
	}

	/**
	 * @see #setValue(String)
	 */
	public void setBlockValue(final String value) {
		setValue(value);
	}

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((MIRDate == null) ? 0 : MIRDate.hashCode());
		result = prime * result + ((MIRLogicalTerminal == null) ? 0 : MIRLogicalTerminal.hashCode());
		result = prime * result + ((MIRSequenceNumber == null) ? 0 : MIRSequenceNumber.hashCode());
		result = prime * result + ((MIRSessionNumber == null) ? 0 : MIRSessionNumber.hashCode());
		result = prime * result + ((messagePriority == null) ? 0 : messagePriority.hashCode());
		result = prime * result + ((messageType == null) ? 0 : messageType.hashCode());
		result = prime * result + ((receiverOutputDate == null) ? 0 : receiverOutputDate.hashCode());
		result = prime * result + ((receiverOutputTime == null) ? 0 : receiverOutputTime.hashCode());
		result = prime * result + ((senderInputTime == null) ? 0 : senderInputTime.hashCode());
		return result;
	}

	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SwiftBlock2Output other = (SwiftBlock2Output) obj;
		if (MIRDate == null) {
			if (other.MIRDate != null) {
				return false;
			}
		} else if (!MIRDate.equals(other.MIRDate)) {
			return false;
		}
		if (MIRLogicalTerminal == null) {
			if (other.MIRLogicalTerminal != null) {
				return false;
			}
		} else if (!MIRLogicalTerminal.equals(other.MIRLogicalTerminal)) {
			return false;
		}
		if (MIRSequenceNumber == null) {
			if (other.MIRSequenceNumber != null) {
				return false;
			}
		} else if (!MIRSequenceNumber.equals(other.MIRSequenceNumber)) {
			return false;
		}
		if (MIRSessionNumber == null) {
			if (other.MIRSessionNumber != null) {
				return false;
			}
		} else if (!MIRSessionNumber.equals(other.MIRSessionNumber)) {
			return false;
		}
		if (messagePriority == null) {
			if (other.messagePriority != null) {
				return false;
			}
		} else if (!messagePriority.equals(other.messagePriority)) {
			return false;
		}
		if (messageType == null) {
			if (other.messageType != null) {
				return false;
			}
		} else if (!messageType.equals(other.messageType)) {
			return false;
		}
		if (receiverOutputDate == null) {
			if (other.receiverOutputDate != null) {
				return false;
			}
		} else if (!receiverOutputDate.equals(other.receiverOutputDate)) {
			return false;
		}
		if (receiverOutputTime == null) {
			if (other.receiverOutputTime != null) {
				return false;
			}
		} else if (!receiverOutputTime.equals(other.receiverOutputTime)) {
			return false;
		}
		if (senderInputTime == null) {
			if (other.senderInputTime != null) {
				return false;
			}
		} else if (!senderInputTime.equals(other.senderInputTime)) {
			return false;
		}
		return true;
	}
	
	/**
	 * @since 7.5
	 */
	public String toJson() {
		final StringBuilder sb = new StringBuilder();
		sb.append("{ \n");

		sb.append(" \"messageType\" : \"").append(messageType).append("\", \n");
		sb.append(" \"senderInputTime\" : \"").append(senderInputTime).append("\", \n");
		sb.append(" \"MIRDate\" : \"").append(MIRDate).append("\", \n");
		sb.append(" \"MIRLogicalTerminal\" : \"").append(MIRLogicalTerminal).append("\", \n");
		sb.append(" \"MIRSessionNumber\" : \"").append(MIRSessionNumber).append("\", \n");
		sb.append(" \"MIRSequenceNumber\" : \"").append(MIRSequenceNumber).append("\", \n");
		sb.append(" \"receiverOutputDate\" : \"").append(receiverOutputDate).append("\", \n");
		sb.append(" \"receiverOutputTime\" : \"").append(receiverOutputTime).append("\", \n");
		sb.append(" \"messagePriority\" : \"").append(messagePriority).append("\" \n");

		sb.append("} ");
		return sb.toString();
	}
	
	/**
	 * Generic getter for block attributes based on qualified names from {@link SwiftBlock2OutputField}
	 * @param field field to get
	 * @return field value or <code>null</code> if attribute is not set
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
		}
		return null;
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
		}
	}
}

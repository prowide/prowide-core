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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import com.prowidesoftware.swift.utils.SwiftFormatUtils;

/**
 * This class models and parses the Message Input Reference (MIR), 
 * String of 28 characters, always local to the sender of the message.
 * It includes the date the sender sent the message to SWIFT,
 * followed by the full LT address of the sender of the 
 * message, and the sender's session and sequence to SWIFT.
 * YYMMDD BANKBEBBAXXX 2222 123456<br><br>
 * 
 * <p>MIR and MOR are messages unique identifiers containing the date, 
 * logical terminal (including branch code), session and sequence numbers. 
 * Nevertheless this identifiers can be confusing sometimes because they must 
 * be thought from SWIFT perspective.
 * 
 * <p>A message created by the sender user/application is considered an 
 * INPUT message, because it gets into the SWIFT network. When the message 
 * is delivered and gets out of the network it is considered an OUTPUT message. 
 * Therefore the headers of a sent message are not exactly the same as the 
 * headers of the received message at the destination party. Analogous the 
 * headers of a message that the receiving user/application gets from SWIFT 
 * are not exactly the same as the headers when the message was created and 
 * sent by the sending party.
 *  
 * <p>The usage of MIR and MOR are clear when analyzing system messages. 
 * A non delivery warning for example, includes the original MIR of the 
 * sent message, but not the MOR because the message was not delivered yet. 
 * But a delivery confirmation on the other hand, includes both, the sender’s MIR 
 * and the receiver’s MOR.<br>
 * System messages provide MIR/MOR information using fields 106 and 107 respectively.
 *
 * @since 6.0
 */
public class MIR {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MIR.class.getName());

	/**
	 * @param date
	 * @param logicalTerminal
	 * @param sessionNumber
	 * @param sequenceNumber
	 */
	public MIR(String date, String logicalTerminal, String sessionNumber, String sequenceNumber) {
		super();
		this.date = date;
		this.logicalTerminal = logicalTerminal;
		this.sessionNumber = sessionNumber;
		this.sequenceNumber = sequenceNumber;
	}
	
	/**
	 * Creates a MIR object parsing the literal string value. 
	 * If the value is incorrect (cannot be parsed) the object will not be initialized.
	 * @param value the MIR value, it is expected to 28 characters length
	 */
	public MIR(String value) {
		super();
		if (value != null && value.length() == 28) {
			final StringBuilder sb = new StringBuilder(value);
	
			int offset = 0;
			int len;
	
			len = 6;
			this.date = String.valueOf(sb.subSequence(offset, offset + len));
			offset += len;
	
			len = 12;
			this.logicalTerminal = String.valueOf(sb.subSequence(offset, offset + len));
			offset += len;
	
			len = 4;
			this.sessionNumber = String.valueOf(sb.subSequence(offset, offset + len));
			offset += len;
	
			len = 6;
			this.sequenceNumber = String.valueOf(sb.subSequence(offset, offset + len));
		} else {
			log.severe("invalid MIR value "+value);
		}
	}

	/**
	 * Default constructor
	 */
	public MIR() {
		super();
	}

	/**
	 * 6 characters string containing the date field of the MIR.
	 */
	private String date;

	/**
	 * String of 12 characters containing the logical terminal field of the MIR
	 * (address of the sender of the message).
	 * @see "MIR on the WIFE Wiki"
	 */
	private String logicalTerminal;

	/**
	 * String of 4 characters containing the session number field of the MIR.
	 * @see "MIR on the WIFE Wiki"
	 */
	private String sessionNumber;

	/**
	 * String of 6 characters containing the sequence number field of the MIR.
	 * @see "MIR on the WIFE Wiki"
	 */
	private String sequenceNumber;

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date a date formatted as YYMMDD
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Sets a date from a calendar, formatting it as YYMMDD
	 * @param date a date
	 * @since 7.10.4
	 */
	public void setDate(Calendar date) {
		this.date = SwiftFormatUtils.getDate2(date);
	}

	/**
	 * @return the logical terminal
	 */
	public String getLogicalTerminal() {
		return logicalTerminal;
	}

	/**
	 * @param logicalTerminal
	 */
	public void setLogicalTerminal(String logicalTerminal) {
		this.logicalTerminal = logicalTerminal;
	}

	/**
	 * @return the session number
	 */
	public String getSessionNumber() {
		return sessionNumber;
	}

	/**
	 * @param sessionNumber
	 */
	public void setSessionNumber(String sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	/**
	 * @return the sequence number
	 */
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * @param sequenceNumber
	 */
	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	
	/**
	 * Gets the full MIR (Message Input Reference) string of 28 
	 * characters containing the sender's date, LT address,
	 * session and sequence:<br>
	 * for example YYMMDDBANKBEBBAXXX2222123456<br>
	 * 
	 * @return a String with MIR, returns null if all MIR components are null
	 */
	public String getMIR() {
		if (date == null && logicalTerminal == null && sessionNumber == null && sequenceNumber == null) {
			return null;
		}
		final StringBuilder v = new StringBuilder();
		if (date != null) {
			v.append(date);
		}
		if (logicalTerminal != null) {
			v.append(logicalTerminal);
		}
		if (sessionNumber != null) {
			v.append(sessionNumber);
		}
		if (sequenceNumber != null) {
			v.append(sequenceNumber);
		}
		return v.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MIR mir = (MIR) o;
		return Objects.equals(date, mir.date) &&
				Objects.equals(logicalTerminal, mir.logicalTerminal) &&
				Objects.equals(sessionNumber, mir.sessionNumber) &&
				Objects.equals(sequenceNumber, mir.sequenceNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, logicalTerminal, sessionNumber, sequenceNumber);
	}

	/**
	 * Returns this MIR date as Calendar.
	 * This implementation uses {@link SwiftFormatUtils#getDate2(String)}
	 * @return the parsed date or null if MIR date is invalid or not set
	 * @since 7.8.8
	 */
	public final Calendar getDateAsCalendar() {
		return SwiftFormatUtils.getDate2(this.date);
	}
}
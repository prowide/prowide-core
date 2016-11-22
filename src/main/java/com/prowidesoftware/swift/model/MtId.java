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

import com.prowidesoftware.swift.model.mt.MTVariant;

/**
 * Class for identification of MT messages.
 * <br >
 * Composed by the business process, message type and variant or message user group (MUG).
 * <br />
 * The business process is currently set to a fixed value "fin", however it is kept as
 * class attribute because eventually could be used also for "apc".
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8.4
 */
public class MtId {
	private String businessProcess = "fin";
	private String messageType;
	private String variant;

	/**
	 * @param messageType the message type number
	 * @param variant An MT variant (STP, REMIT, COV), a MUG identifier or null if none applies
	 */
	public MtId(String messageType, String variant) {
		super();
		this.messageType = messageType;
		this.variant = variant;
	}

	/**
	 * @param messageType the message type number
	 * @param variant a message variant (STP, REMIT, COV) or null if none applies
	 */
	public MtId(String messageType, MTVariant variant) {
		this(messageType, variant != null? variant.name() : null);
	}
	
	public String getBusinessProcess() {
		return businessProcess;
	}
	
	public void setBusinessProcess(String businessProcess) {
		this.businessProcess = businessProcess;
	}
	
	public String getMessageType() {
		return messageType;
	}
	
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
	public String getVariant() {
		return variant;
	}
	
	public void setVariant(String variant) {
		this.variant = variant;
	}
	
	@Override
	public String toString() {
		return id();
	}
	
	/**
	 * Get a string in the form of businessprocess.messagetype.variant
	 * @return a string with the MT message type identification 
	 * @since 7.8.4
	 */
	public String id() {
		final StringBuilder sb = new StringBuilder();
		if (businessProcess != null) {
			sb.append(businessProcess);
		} else {
			return null;
		}
		if (messageType != null) {
			sb.append("." + messageType);
		} else {
			return null;
		}
		if (variant != null) {
			sb.append("." + variant);
		}
		return sb.toString();
	}
}

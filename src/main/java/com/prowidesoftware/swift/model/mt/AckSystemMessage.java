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
package com.prowidesoftware.swift.model.mt;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;

/**
 * 
 * <em>WARNING this class is preliminary and may be modified or removed without prior notice</em>
 * 
 * @author miguel@prowidesoftware.com
 * @since 7.8
 *
 */
public class AckSystemMessage extends SystemMessage {

	public AckSystemMessage(SwiftMessage swiftMessage) {
		super(swiftMessage);
		Validate.isTrue(swiftMessage.isAck() || swiftMessage.isNack());
	}

	public String getErrorCode() {
		final Tag t = super.m.getBlock4().getTagByName("405");
		if (t == null)
			return null;
		return StringUtils.substring(t.getValue(), 0, 3);
	}
	
	public String getErrorLine() {
		final Tag t = super.m.getBlock4().getTagByName("405");
		if (t == null)
			return null;
		return StringUtils.substring(t.getValue(), 3, 6);
	}

	public boolean isAck() {
		return super.m.isAck();
	}

	public boolean isNak() {
		return super.m.isNack();
	}
}

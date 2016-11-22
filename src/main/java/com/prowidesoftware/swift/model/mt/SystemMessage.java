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

import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.model.SwiftMessage;

/**
 * 
 * <em>WARNING this class is preliminary and may be modified or removed without prior notice</em>
 * 
 * @author miguel@prowidesoftware.com
 * @since 7.8
 *
 */
public class SystemMessage extends AbstractMT {
	
	public SystemMessage(final SwiftMessage aMessage) {
		super(aMessage);
		Validate.isTrue(aMessage.isSystemMessage());
	}
	
	public static AbstractMT newInstance(final SwiftMessage swiftMessage) {
		if (swiftMessage.isAck() || swiftMessage.isNack()) {
			return new AckSystemMessage(swiftMessage);
		}
		return new SystemMessage(swiftMessage);
	}

	@Override
	public String getMessageType() {
		// TODO Auto-generated method stub
		return null;
	}

}

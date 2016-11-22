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
package com.prowidesoftware.swift.utils;

import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftBlockUser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;

/**
 * Base class for a IMessageVisitor. This class does nothing, implements all
 * methods empty. All methods may be overwritten.
 * 
 * @author www.prowidesoftware.com
 */
//TODO: complete javadocs 
public class BaseMessageVisitor implements IMessageVisitor {

	public void startBlock1(SwiftBlock1 b) {
	}

	public void startBlock2(SwiftBlock2 b) {
	}

	public void startBlock3(SwiftBlock3 b) {
	}

	public void startBlock4(SwiftBlock4 b) {
	}

	public void startBlock5(SwiftBlock5 b) {
	}

	public void startBlockUser(SwiftBlockUser b) {
	}

	public void endBlock1(SwiftBlock1 b) {
	}

	public void endBlock2(SwiftBlock2 b) {
	}

	public void endBlock3(SwiftBlock3 b) {
	}

	public void endBlock4(SwiftBlock4 b) {
	}

	public void endBlock5(SwiftBlock5 b) {
	}

	public void endBlockUser(SwiftBlockUser b) {
	}

	public void tag(SwiftBlock3 b, Tag t) {
	}

	public void tag(SwiftBlock4 b, Tag t) {
	}

	public void tag(SwiftBlock5 b, Tag t) {
	}

	public void tag(SwiftBlockUser b, Tag t) {
	}

	public void value(SwiftBlock1 b, String v) {
	}

	public void value(SwiftBlock2 b, String v) {
	}

	public void endMessage(SwiftMessage m) {
	}

	public void startMessage(SwiftMessage m) {
	}

}

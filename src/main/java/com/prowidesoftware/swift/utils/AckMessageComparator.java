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

/**
 * A {@link SwiftMessageComparator} tailored for typical ACK matching.
 * 
 * <p>Compares all values from block 1 2 3 and 4, ignoring session and sequence number in block1.
 * The trailer block 5 if present in any of the messages is also ignored. Regarding multiline fields
 * the EOL must be an exact match (meaning CRLF is not the same as just LF)</p>
 * 
 * @author www.prowidesoftware.com
 */
//TODO nov 2016 sebastian: create message comparator for ack sysmessage to candidates using 108:MUR from ack and MOR from candidate
public class AckMessageComparator extends SwiftMessageComparator {

	public AckMessageComparator() {
		super();
		super.ignoreEolsInMultiline = false;
		super.ignoreTrailer = true;
		super.ignoreHeaderSession = true;
	}
}

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
 * Interface to be implemented by classes that will 'visit' a swift message.
 *
 * There method call sequence is as follows:
 *
 * <ol>
 * <li><code>startMessage</code></li>
 * <li><code>startBlock1 -> value -> endBlock1</code> (if block 1 exists)</li>
 * <li><code>startBlock2 -> value -> endBlock2</code> (if block 2 exists)</li>
 * <li><code>startBlock3 -> tag (for every tag) -> endBlock3</code> (if block 3 exists)</li>
 * <li><code>startBlock4 -> tag (for every tag) -> endBlock4</code> (if block 4 exists)</li>
 * <li><code>startBlock5 -> tag (for every tag) -> endBlock5</code> (if block 5 exists)</li>
 * <li><code>startBlockUser -> tag (for every tag) -> endBlockUser</code> (for every user defined block and every tag of that block)</li>
 * <li><code>endMessage</code></li>
 * </ol>
 *
 * <p>Notice that the <code>tag</code> and <code>value</code> methods are overloaded for every type of SwiftBlock
 * derived class.</p>
 * 
 * <p><b>NOTE</b>: this API has changed since 4.0 with SwiftBlocks 1-5 in each start/end 
 * method pairs.</p> 
 * 
 * @author www.prowidesoftware.com
 */
//TODO: complete javadocs
public interface IMessageVisitor {

	/**
	 * @param b block to visit
	 */
	void startBlock1(SwiftBlock1 b);
	
	/**
	 * @param b block to visit
	 */
	void startBlock2(SwiftBlock2 b);
	
	/**
	 * @param b block to visit
	 */
	void startBlock3(SwiftBlock3 b);
	
	/**
	 * @param b block to visit
	 */
	void startBlock4(SwiftBlock4 b);
	
	/**
	 * @param b block to visit
	 */
	void startBlock5(SwiftBlock5 b);
	
	/**
	 * @param b block to visit
	 */
	void startBlockUser(SwiftBlockUser b);

	/**
	 * @param b block to visit
	 */
	void endBlock1(SwiftBlock1 b);
	
	/**
	 * @param b block to visit
	 */
	void endBlock2(SwiftBlock2 b);
	
	/**
	 * @param b block to visit
	 */
	void endBlock3(SwiftBlock3 b);
	
	/**
	 * @param b block to visit
	 */
	void endBlock4(SwiftBlock4 b);
	
	/**
	 * @param b block to visit
	 */
	void endBlock5(SwiftBlock5 b);
	
	/**
	 * @param b block to visit
	 */
	void endBlockUser(SwiftBlockUser b);
	
	/**
	 * @param b
	 * @param t
	 */
	void tag(SwiftBlock3    b, Tag t);
	
	/**
	 * @param b
	 * @param t
	 */
	void tag(SwiftBlock4    b, Tag t);
	
	/**
	 * @param b
	 * @param t
	 */
	void tag(SwiftBlock5    b, Tag t);
	
	/**
	 * @param b
	 * @param t
	 */
	void tag(SwiftBlockUser b, Tag t);
	
	/**
	 * @param b
	 * @param v
	 */
	void value(SwiftBlock1  b, String v);
	
	/**
	 * @param b
	 * @param v
	 */
	void value(SwiftBlock2  b, String v);
	
	/**
	 * 
	 * @param m
	 */
	void startMessage(SwiftMessage m);
	
	/**
	 * 
	 * @param m
	 */
	void endMessage(SwiftMessage m);
}

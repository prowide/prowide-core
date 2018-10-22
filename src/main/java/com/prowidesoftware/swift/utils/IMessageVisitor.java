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
 * <li><code>startBlock1 -&gt; value -&gt; endBlock1</code> (if block 1 exists)</li>
 * <li><code>startBlock2 -&gt; value -&gt; endBlock2</code> (if block 2 exists)</li>
 * <li><code>startBlock3 -&gt; tag (for every tag) -&gt; endBlock3</code> (if block 3 exists)</li>
 * <li><code>startBlock4 -&gt; tag (for every tag) -&gt; endBlock4</code> (if block 4 exists)</li>
 * <li><code>startBlock5 -&gt; tag (for every tag) -&gt; endBlock5</code> (if block 5 exists)</li>
 * <li><code>startBlockUser -&gt; tag (for every tag) -&gt; endBlockUser</code> (for every user defined block and every tag of that block)</li>
 * <li><code>endMessage</code></li>
 * </ol>
 *
 * <p>Notice that the <code>tag</code> and <code>value</code> methods are overloaded for every type of SwiftBlock
 * derived class.
 * 
 * <p><b>NOTE</b>: this API has changed since 4.0 with SwiftBlocks 1-5 in each start/end 
 * method pairs.
 */
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

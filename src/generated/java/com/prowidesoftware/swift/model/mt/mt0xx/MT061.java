/*
 * Copyright 2006-2024 Prowide
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
package com.prowidesoftware.swift.model.mt.mt0xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * MT 061 - Select Status Report for FIN.
 *
 * <p>
 * SWIFT MT061 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="field">Field 202  (M)</li>
<li class="field">Field 203  (M)</li>
<li class="field">Field 206  (M)</li>
<li class="field">Field 348  (O)</li>
<li class="sequence">
Sequence _A - Logical terminal destination (O)<ul><li class="field">Field 305  (M)</li>
<li class="field">Field 337  (M)</li>
<li class="field">Field 208  (O)</li>
<li class="field">Field 338  (O)</li>
<li class="field">Field 116  (O)</li>
<li class="field">Field 118  (O)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2024</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT061 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT061.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "061";

	/**
	 * Creates an MT061 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT061 content
	 */
	public MT061(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT061 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT061 content, the parameter can not be null
	 * @see #MT061(String)
	 */
	public MT061(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT061 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT061 content
	 * @return the created object or null if the parameter is null
	 * @see #MT061(String)
	 * @since 7.7
	 */
	public static MT061 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT061(m);
	}
	
	/**
	 * Creates and initializes a new MT061 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT061() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT061 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT061(final String sender, final String receiver) {
		super(61, sender, receiver);
	}
	
	/**
	 * Creates a new MT061 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT061(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
				sanityCheck(parsed);
			}
		}
    }
    
    private void sanityCheck(final SwiftMessage param) {
    	if (param.isServiceMessage()) {
			log.warning("Creating an MT061 object from FIN content with a Service Message. Check if the MT061 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "061")) {
			log.warning("Creating an MT061 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT061 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT061 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT061 or null if fin is null 
	 * @since 7.7
	 */
	public static MT061 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT061(fin);
    }
    
    /**
	 * Creates a new MT061 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT061(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT061 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT061 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT061 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT061(stream);
    }
    
    /**
	 * Creates a new MT061 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT061(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT061 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT061 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT061 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT061(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "061";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT061 append(final SwiftTagListBlock block) {
		super.append(block);
		return this;
	}
	
	/**
	 * Add all tags to the end of the block4.
	 *
	 * @param tags to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT061 append(final Tag... tags) {
		super.append(tags);
		return this;
	}
	
	/**
	 * Add all the fields to the end of the block4.
	 *
	 * @param fields to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT061 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT061 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT061 message
	* @return a new instance of MT061
	* @since 7.10.3
	*/
	public static MT061 fromJson(final String json) {
		return (MT061) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 202, 
	 * or null if none is found.
	 * The first occurrence of field 202 at MT061 is expected to be the only one.
	 * 
	 * @return a Field202 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field202 getField202() {
		final Tag t = tag("202");
		if (t != null) {
			return new Field202(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 203, 
	 * or null if none is found.
	 * The first occurrence of field 203 at MT061 is expected to be the only one.
	 * 
	 * @return a Field203 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field203 getField203() {
		final Tag t = tag("203");
		if (t != null) {
			return new Field203(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 206, 
	 * or null if none is found.
	 * The first occurrence of field 206 at MT061 is expected to be the only one.
	 * 
	 * @return a Field206 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field206 getField206() {
		final Tag t = tag("206");
		if (t != null) {
			return new Field206(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 348, 
	 * or null if none is found.
	 * The first occurrence of field 348 at MT061 is expected to be the only one.
	 * 
	 * @return a Field348 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field348 getField348() {
		final Tag t = tag("348");
		if (t != null) {
			return new Field348(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 305, 
	 * or null if none is found.
	 * The first occurrence of field 305 at MT061 is expected to be the only one.
	 * 
	 * @return a Field305 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field305 getField305() {
		final Tag t = tag("305");
		if (t != null) {
			return new Field305(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 337, 
	 * or null if none is found.
	 * The first occurrence of field 337 at MT061 is expected to be the only one.
	 * 
	 * @return a Field337 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field337 getField337() {
		final Tag t = tag("337");
		if (t != null) {
			return new Field337(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 208, 
	 * or null if none is found.
	 * The first occurrence of field 208 at MT061 is expected to be the only one.
	 * 
	 * @return a Field208 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field208 getField208() {
		final Tag t = tag("208");
		if (t != null) {
			return new Field208(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 338, 
	 * or null if none is found.
	 * The first occurrence of field 338 at MT061 is expected to be the only one.
	 * 
	 * @return a Field338 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field338 getField338() {
		final Tag t = tag("338");
		if (t != null) {
			return new Field338(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 116, 
	 * or null if none is found.
	 * The first occurrence of field 116 at MT061 is expected to be the only one.
	 * 
	 * @return a Field116 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field116 getField116() {
		final Tag t = tag("116");
		if (t != null) {
			return new Field116(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 118, 
	 * or null if none is found.
	 * The first occurrence of field 118 at MT061 is expected to be the only one.
	 * 
	 * @return a Field118 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field118 getField118() {
		final Tag t = tag("118");
		if (t != null) {
			return new Field118(t.getValue());
		} else {
			return null;
		}
	}
	



}

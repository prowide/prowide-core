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
package com.prowidesoftware.swift.model.mt.mt5xx;



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
 * MT 581 - .
 *
 * <p>
 * SWIFT MT581 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="field">Field 20  (M)</li>
<li class="field">Field 21  (M)</li>
<li class="field">Field 23  (M)</li>
<li class="field">Field 30  (O)</li>
<li class="field">Field 35 H (M)</li>
<li class="field">Field 35 B (O)</li>
<li class="field">Field 80 C (M)</li>
<li class="field">Field 34 B (O)</li>
<li class="field">Field 72  (O)</li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2024</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT581 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT581.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "581";

	/**
	 * Creates an MT581 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT581 content
	 */
	public MT581(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT581 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT581 content, the parameter can not be null
	 * @see #MT581(String)
	 */
	public MT581(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT581 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT581 content
	 * @return the created object or null if the parameter is null
	 * @see #MT581(String)
	 * @since 7.7
	 */
	public static MT581 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT581(m);
	}
	
	/**
	 * Creates and initializes a new MT581 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT581() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT581 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT581(final String sender, final String receiver) {
		super(581, sender, receiver);
	}
	
	/**
	 * Creates a new MT581 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT581(final String fin) {
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
			log.warning("Creating an MT581 object from FIN content with a Service Message. Check if the MT581 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "581")) {
			log.warning("Creating an MT581 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT581 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT581 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT581 or null if fin is null 
	 * @since 7.7
	 */
	public static MT581 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT581(fin);
    }
    
    /**
	 * Creates a new MT581 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT581(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT581 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT581 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT581 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT581(stream);
    }
    
    /**
	 * Creates a new MT581 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT581(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT581 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT581 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT581 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT581(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "581";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT581 append(final SwiftTagListBlock block) {
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
	public MT581 append(final Tag... tags) {
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
	public MT581 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT581 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT581 message
	* @return a new instance of MT581
	* @since 7.10.3
	*/
	public static MT581 fromJson(final String json) {
		return (MT581) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.
	 * The first occurrence of field 20 at MT581 is expected to be the only one.
	 * 
	 * @return a Field20 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field20 getField20() {
		final Tag t = tag("20");
		if (t != null) {
			return new Field20(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21, 
	 * or null if none is found.
	 * The first occurrence of field 21 at MT581 is expected to be the only one.
	 * 
	 * @return a Field21 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21 getField21() {
		final Tag t = tag("21");
		if (t != null) {
			return new Field21(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23, 
	 * or null if none is found.
	 * The first occurrence of field 23 at MT581 is expected to be the only one.
	 * 
	 * @return a Field23 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23 getField23() {
		final Tag t = tag("23");
		if (t != null) {
			return new Field23(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or null if none is found.
	 * The first occurrence of field 30 at MT581 is expected to be the only one.
	 * 
	 * @return a Field30 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30 getField30() {
		final Tag t = tag("30");
		if (t != null) {
			return new Field30(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 35H, 
	 * or null if none is found.
	 * The first occurrence of field 35H at MT581 is expected to be the only one.
	 * 
	 * @return a Field35H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field35H getField35H() {
		final Tag t = tag("35H");
		if (t != null) {
			return new Field35H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 35B, 
	 * or null if none is found.
	 * The first occurrence of field 35B at MT581 is expected to be the only one.
	 * 
	 * @return a Field35B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field35B getField35B() {
		final Tag t = tag("35B");
		if (t != null) {
			return new Field35B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 80C, 
	 * or null if none is found.
	 * The first occurrence of field 80C at MT581 is expected to be the only one.
	 * 
	 * @return a Field80C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field80C getField80C() {
		final Tag t = tag("80C");
		if (t != null) {
			return new Field80C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 34B, 
	 * or null if none is found.
	 * The first occurrence of field 34B at MT581 is expected to be the only one.
	 * 
	 * @return a Field34B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field34B getField34B() {
		final Tag t = tag("34B");
		if (t != null) {
			return new Field34B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or null if none is found.
	 * The first occurrence of field 72 at MT581 is expected to be the only one.
	 * 
	 * @return a Field72 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field72 getField72() {
		final Tag t = tag("72");
		if (t != null) {
			return new Field72(t.getValue());
		} else {
			return null;
		}
	}
	



}

/*
 * Copyright 2006-2021 Prowide
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
 * MT 066 - Solicited Undelivered Message Report.
 *
 * <p>
 * SWIFT MT066 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="field">Field 202  (M)</li>
<li class="field">Field 203  (M)</li>
<li class="field">Field 171  (M)</li>
<li class="field">Field 175  (M)</li>
<li class="field">Field 301  (M)</li>
<li class="sequence">
Sequence _A -  (M)<ul><li class="sequence">
Sequence _A1 - Group 1 (O) (repetitive)<ul><li class="sequence">
Sequence _A1a - Group 1.1 (M)<ul><li class="field">Field 335  (M)</li>
<li class="field">Field 108  (O)</li>
</ul></li>
<li class="sequence">
Sequence _A1b - Group 1.2 (O)<ul><li class="field">Field 431  (M)</li>
<li class="field">Field 103  (M)</li>
</ul></li>
</ul></li>
<li class="sequence">
Sequence _A2 - Group 2 (O)<ul><li class="field">Field 461  (M)</li>
</ul></li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2021</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT066 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT066.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "066";

	/**
	 * Creates an MT066 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT066 content
	 */
	public MT066(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT066 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT066 content, the parameter can not be null
	 * @see #MT066(String)
	 */
	public MT066(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT066 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT066 content
	 * @return the created object or null if the parameter is null
	 * @see #MT066(String)
	 * @since 7.7
	 */
	public static MT066 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT066(m);
	}
	
	/**
	 * Creates and initializes a new MT066 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT066() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT066 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT066(final String sender, final String receiver) {
		super(66, sender, receiver);
	}
	
	/**
	 * Creates a new MT066 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT066(final String fin) {
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
			log.warning("Creating an MT066 object from FIN content with a Service Message. Check if the MT066 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "066")) {
			log.warning("Creating an MT066 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT066 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT066 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT066 or null if fin is null 
	 * @since 7.7
	 */
	public static MT066 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT066(fin);
    }
    
    /**
	 * Creates a new MT066 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT066(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT066 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT066 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT066 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT066(stream);
    }
    
    /**
	 * Creates a new MT066 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT066(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT066 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT066 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT066 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT066(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "066";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT066 append(final SwiftTagListBlock block) {
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
	public MT066 append(final Tag... tags) {
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
	public MT066 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT066 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT066 message
	* @return a new instance of MT066
	* @since 7.10.3
	*/
	public static MT066 fromJson(final String json) {
		return (MT066) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 202, 
	 * or null if none is found.
	 * The first occurrence of field 202 at MT066 is expected to be the only one.
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
	 * The first occurrence of field 203 at MT066 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 171, 
	 * or null if none is found.
	 * The first occurrence of field 171 at MT066 is expected to be the only one.
	 * 
	 * @return a Field171 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field171 getField171() {
		final Tag t = tag("171");
		if (t != null) {
			return new Field171(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 175, 
	 * or null if none is found.
	 * The first occurrence of field 175 at MT066 is expected to be the only one.
	 * 
	 * @return a Field175 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field175 getField175() {
		final Tag t = tag("175");
		if (t != null) {
			return new Field175(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 301, 
	 * or null if none is found.
	 * The first occurrence of field 301 at MT066 is expected to be the only one.
	 * 
	 * @return a Field301 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field301 getField301() {
		final Tag t = tag("301");
		if (t != null) {
			return new Field301(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 335, 
	 * or null if none is found.
	 * The first occurrence of field 335 at MT066 is expected to be the only one.
	 * 
	 * @return a Field335 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field335 getField335() {
		final Tag t = tag("335");
		if (t != null) {
			return new Field335(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 108, 
	 * or null if none is found.
	 * The first occurrence of field 108 at MT066 is expected to be the only one.
	 * 
	 * @return a Field108 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field108 getField108() {
		final Tag t = tag("108");
		if (t != null) {
			return new Field108(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 431, 
	 * or null if none is found.
	 * The first occurrence of field 431 at MT066 is expected to be the only one.
	 * 
	 * @return a Field431 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field431 getField431() {
		final Tag t = tag("431");
		if (t != null) {
			return new Field431(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 103, 
	 * or null if none is found.
	 * The first occurrence of field 103 at MT066 is expected to be the only one.
	 * 
	 * @return a Field103 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field103 getField103() {
		final Tag t = tag("103");
		if (t != null) {
			return new Field103(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 461, 
	 * or null if none is found.
	 * The first occurrence of field 461 at MT066 is expected to be the only one.
	 * 
	 * @return a Field461 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field461 getField461() {
		final Tag t = tag("461");
		if (t != null) {
			return new Field461(t.getValue());
		} else {
			return null;
		}
	}
	



}

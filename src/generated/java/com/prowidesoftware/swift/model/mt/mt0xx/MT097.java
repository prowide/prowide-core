/*
 * Copyright 2006-2019 Prowide
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
 * <strong>MT 097 - FINCopy Message Authorisation/Refusal Notification</strong>
 *
 * <p>
 * SWIFT MT097 (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="field">Field 103  (M)</li>
<li class="field">Field 109  (M)</li>
<li class="field">Field 451  (M)</li>
<li class="field">Field 432  (O)</li>
<li class="field">Field 114  (O)</li>
<li class="field">Field 115  (O)</li>
<li class="field">Field 165  (O)</li>
<li class="field">Field 433  (O)</li>
<li class="field">Field 422  (O)</li>
<li class="field">Field 425  (O)</li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT097 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT097.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "097";

	/**
	 * Creates an MT097 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT097 content
	 */
	public MT097(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT097 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT097 content, the parameter can not be null
	 * @see #MT097(String)
	 */
	public MT097(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT097 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT097 content
	 * @return the created object or null if the parameter is null
	 * @see #MT097(String)
	 * @since 7.7
	 */
	public static MT097 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT097(m);
	}
	
	/**
	 * Creates and initializes a new MT097 input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT097() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT097 input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT097(final String sender, final String receiver) {
		super(97, sender, receiver);
	}
	
	/**
	 * Creates a new MT097 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT097(final String fin) {
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
			log.warning("Creating an MT097 object from FIN content with a Service Message. Check if the MT097 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT097 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT097 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT097 will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT097 or null if fin is null 
	 * @since 7.7
	 */
	public static MT097 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT097(fin);
    }
    
    /**
	 * Creates a new MT097 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT097(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT097 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT097 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT097 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT097(stream);
    }
    
    /**
	 * Creates a new MT097 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT097(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT097 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT097 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT097 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT097(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "097";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT097 append(final SwiftTagListBlock block) {
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
	public MT097 append(final Tag ... tags) {
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
	public MT097 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT097 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT097 message
	 * @return a new instance of MT097
	 * @since 7.10.3
	 */
	public final static MT097 fromJson(String json) {
		return (MT097) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 103, 
	 * or null if none is found.<br>
	 * The first occurrence of field 103 at MT097 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 109, 
	 * or null if none is found.<br>
	 * The first occurrence of field 109 at MT097 is expected to be the only one.
	 * 
	 * @return a Field109 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field109 getField109() {
		final Tag t = tag("109");
		if (t != null) {
			return new Field109(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 451, 
	 * or null if none is found.<br>
	 * The first occurrence of field 451 at MT097 is expected to be the only one.
	 * 
	 * @return a Field451 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field451 getField451() {
		final Tag t = tag("451");
		if (t != null) {
			return new Field451(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 432, 
	 * or null if none is found.<br>
	 * The first occurrence of field 432 at MT097 is expected to be the only one.
	 * 
	 * @return a Field432 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field432 getField432() {
		final Tag t = tag("432");
		if (t != null) {
			return new Field432(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 114, 
	 * or null if none is found.<br>
	 * The first occurrence of field 114 at MT097 is expected to be the only one.
	 * 
	 * @return a Field114 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field114 getField114() {
		final Tag t = tag("114");
		if (t != null) {
			return new Field114(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 115, 
	 * or null if none is found.<br>
	 * The first occurrence of field 115 at MT097 is expected to be the only one.
	 * 
	 * @return a Field115 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field115 getField115() {
		final Tag t = tag("115");
		if (t != null) {
			return new Field115(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 165, 
	 * or null if none is found.<br>
	 * The first occurrence of field 165 at MT097 is expected to be the only one.
	 * 
	 * @return a Field165 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field165 getField165() {
		final Tag t = tag("165");
		if (t != null) {
			return new Field165(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 433, 
	 * or null if none is found.<br>
	 * The first occurrence of field 433 at MT097 is expected to be the only one.
	 * 
	 * @return a Field433 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field433 getField433() {
		final Tag t = tag("433");
		if (t != null) {
			return new Field433(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 422, 
	 * or null if none is found.<br>
	 * The first occurrence of field 422 at MT097 is expected to be the only one.
	 * 
	 * @return a Field422 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field422 getField422() {
		final Tag t = tag("422");
		if (t != null) {
			return new Field422(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 425, 
	 * or null if none is found.<br>
	 * The first occurrence of field 425 at MT097 is expected to be the only one.
	 * 
	 * @return a Field425 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field425 getField425() {
		final Tag t = tag("425");
		if (t != null) {
			return new Field425(t.getValue());
		} else {
			return null;
		}
	}
	



}

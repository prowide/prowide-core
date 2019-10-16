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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * <strong>MT 074 - Broadcast Request</strong>
 *
 * <p>
 * SWIFT MT074 (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="field">Field 128  (M)</li>
<li class="field">Field 304  (O) (repetitive)</li>
<li class="field">Field 307  (O)</li>
<li class="field">Field 129  (O)</li>
<li class="field">Field 130  (M)</li>
<li class="field">Field 132  (O) (repetitive)</li>
<li class="field">Field 133  (O) (repetitive)</li>
<li class="field">Field 134  (M)</li>
<li class="field">Field 312  (M)</li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT074 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT074.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "074";

	/**
	 * Creates an MT074 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT074 content
	 */
	public MT074(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT074 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT074 content, the parameter can not be null
	 * @see #MT074(String)
	 */
	public MT074(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT074 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT074 content
	 * @return the created object or null if the parameter is null
	 * @see #MT074(String)
	 * @since 7.7
	 */
	public static MT074 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT074(m);
	}
	
	/**
	 * Creates and initializes a new MT074 input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT074() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT074 input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT074(final String sender, final String receiver) {
		super(74, sender, receiver);
	}
	
	/**
	 * Creates a new MT074 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT074(final String fin) {
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
			log.warning("Creating an MT074 object from FIN content with a Service Message. Check if the MT074 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT074 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT074 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT074 will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT074 or null if fin is null 
	 * @since 7.7
	 */
	public static MT074 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT074(fin);
    }
    
    /**
	 * Creates a new MT074 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT074(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT074 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT074 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT074 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT074(stream);
    }
    
    /**
	 * Creates a new MT074 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT074(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT074 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT074 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT074 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT074(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "074";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT074 append(final SwiftTagListBlock block) {
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
	public MT074 append(final Tag ... tags) {
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
	public MT074 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT074 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT074 message
	 * @return a new instance of MT074
	 * @since 7.10.3
	 */
	public final static MT074 fromJson(String json) {
		return (MT074) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 128, 
	 * or null if none is found.<br>
	 * The first occurrence of field 128 at MT074 is expected to be the only one.
	 * 
	 * @return a Field128 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field128 getField128() {
		final Tag t = tag("128");
		if (t != null) {
			return new Field128(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 307, 
	 * or null if none is found.<br>
	 * The first occurrence of field 307 at MT074 is expected to be the only one.
	 * 
	 * @return a Field307 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field307 getField307() {
		final Tag t = tag("307");
		if (t != null) {
			return new Field307(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 129, 
	 * or null if none is found.<br>
	 * The first occurrence of field 129 at MT074 is expected to be the only one.
	 * 
	 * @return a Field129 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field129 getField129() {
		final Tag t = tag("129");
		if (t != null) {
			return new Field129(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 130, 
	 * or null if none is found.<br>
	 * The first occurrence of field 130 at MT074 is expected to be the only one.
	 * 
	 * @return a Field130 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field130 getField130() {
		final Tag t = tag("130");
		if (t != null) {
			return new Field130(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 134, 
	 * or null if none is found.<br>
	 * The first occurrence of field 134 at MT074 is expected to be the only one.
	 * 
	 * @return a Field134 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field134 getField134() {
		final Tag t = tag("134");
		if (t != null) {
			return new Field134(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 312, 
	 * or null if none is found.<br>
	 * The first occurrence of field 312 at MT074 is expected to be the only one.
	 * 
	 * @return a Field312 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field312 getField312() {
		final Tag t = tag("312");
		if (t != null) {
			return new Field312(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 304, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 304 at MT074 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field304 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field304> getField304() {
		final List<Field304> result = new ArrayList<>();
		final Tag[] tags = tags("304");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field304(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 132, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 132 at MT074 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field132 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field132> getField132() {
		final List<Field132> result = new ArrayList<>();
		final Tag[] tags = tags("132");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field132(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 133, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 133 at MT074 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field133 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field133> getField133() {
		final List<Field133> result = new ArrayList<>();
		final Tag[] tags = tags("133");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field133(tag.getValue()));
            }
		}
		return result;
	}
	



}

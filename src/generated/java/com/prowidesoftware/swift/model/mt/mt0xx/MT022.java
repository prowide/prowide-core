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
 * MT 022 - Retrieval Request (History).
 *
 * <p>
 * SWIFT MT022 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="field">Field 102  (M)</li>
<li class="sequence">
Sequence _A - GAP or FIN choices (O)<ul><li class="sequence">
Sequence _A1 - MIR (O)<ul><li class="field">Field 251  (M)</li>
</ul></li>
<li class="sequence">
Sequence _A2 - MIR range (O)<ul><li class="field">Field 252  (M)</li>
</ul></li>
<li class="sequence">
Sequence _A3 - MOR (O)<ul><li class="field">Field 253  (M)</li>
</ul></li>
<li class="sequence">
Sequence _A4 - MOR range (O)<ul><li class="field">Field 254  (M)</li>
</ul></li>
<li class="sequence">
Sequence _A5 - Message input type (O)<ul><li class="field">Field 255  (M)</li>
<li class="field">Field 152  (O)</li>
</ul></li>
<li class="sequence">
Sequence _A6 - Input time range (O)<ul><li class="field">Field 257  (M)</li>
<li class="field">Field 152  (O)</li>
</ul></li>
<li class="sequence">
Sequence _A7 - Message output type (O)<ul><li class="field">Field 258  (M)</li>
<li class="field">Field 153  (O)</li>
</ul></li>
<li class="sequence">
Sequence _A8 - Output time range (O)<ul><li class="field">Field 260  (M)</li>
<li class="field">Field 153  (O)</li>
</ul></li>
<li class="sequence">
Sequence _A9 - Category input type (O)<ul><li class="field">Field 256  (M)</li>
<li class="field">Field 152  (O)</li>
</ul></li>
<li class="sequence">
Sequence _A10 - Category output type (O)<ul><li class="field">Field 259  (M)</li>
<li class="field">Field 153  (O)</li>
</ul></li>
<li class="sequence">
Sequence _A11 - MUR input (O)<ul><li class="field">Field 263  (M)</li>
<li class="field">Field 108  (M)</li>
<li class="field">Field 152  (O)</li>
</ul></li>
<li class="sequence">
Sequence _A12 - MUR output (O)<ul><li class="field">Field 264  (M)</li>
<li class="field">Field 108  (M)</li>
<li class="field">Field 153  (O)</li>
</ul></li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2024</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT022 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT022.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "022";

	/**
	 * Creates an MT022 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT022 content
	 */
	public MT022(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT022 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT022 content, the parameter can not be null
	 * @see #MT022(String)
	 */
	public MT022(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT022 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT022 content
	 * @return the created object or null if the parameter is null
	 * @see #MT022(String)
	 * @since 7.7
	 */
	public static MT022 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT022(m);
	}
	
	/**
	 * Creates and initializes a new MT022 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT022() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT022 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT022(final String sender, final String receiver) {
		super(22, sender, receiver);
	}
	
	/**
	 * Creates a new MT022 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT022(final String fin) {
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
			log.warning("Creating an MT022 object from FIN content with a Service Message. Check if the MT022 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "022")) {
			log.warning("Creating an MT022 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT022 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT022 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT022 or null if fin is null 
	 * @since 7.7
	 */
	public static MT022 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT022(fin);
    }
    
    /**
	 * Creates a new MT022 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT022(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT022 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT022 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT022 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT022(stream);
    }
    
    /**
	 * Creates a new MT022 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT022(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT022 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT022 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT022 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT022(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "022";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT022 append(final SwiftTagListBlock block) {
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
	public MT022 append(final Tag... tags) {
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
	public MT022 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT022 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT022 message
	* @return a new instance of MT022
	* @since 7.10.3
	*/
	public static MT022 fromJson(final String json) {
		return (MT022) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 102, 
	 * or null if none is found.
	 * The first occurrence of field 102 at MT022 is expected to be the only one.
	 * 
	 * @return a Field102 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field102 getField102() {
		final Tag t = tag("102");
		if (t != null) {
			return new Field102(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 251, 
	 * or null if none is found.
	 * The first occurrence of field 251 at MT022 is expected to be the only one.
	 * 
	 * @return a Field251 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field251 getField251() {
		final Tag t = tag("251");
		if (t != null) {
			return new Field251(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 252, 
	 * or null if none is found.
	 * The first occurrence of field 252 at MT022 is expected to be the only one.
	 * 
	 * @return a Field252 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field252 getField252() {
		final Tag t = tag("252");
		if (t != null) {
			return new Field252(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 253, 
	 * or null if none is found.
	 * The first occurrence of field 253 at MT022 is expected to be the only one.
	 * 
	 * @return a Field253 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field253 getField253() {
		final Tag t = tag("253");
		if (t != null) {
			return new Field253(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 254, 
	 * or null if none is found.
	 * The first occurrence of field 254 at MT022 is expected to be the only one.
	 * 
	 * @return a Field254 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field254 getField254() {
		final Tag t = tag("254");
		if (t != null) {
			return new Field254(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 255, 
	 * or null if none is found.
	 * The first occurrence of field 255 at MT022 is expected to be the only one.
	 * 
	 * @return a Field255 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field255 getField255() {
		final Tag t = tag("255");
		if (t != null) {
			return new Field255(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 257, 
	 * or null if none is found.
	 * The first occurrence of field 257 at MT022 is expected to be the only one.
	 * 
	 * @return a Field257 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field257 getField257() {
		final Tag t = tag("257");
		if (t != null) {
			return new Field257(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 258, 
	 * or null if none is found.
	 * The first occurrence of field 258 at MT022 is expected to be the only one.
	 * 
	 * @return a Field258 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field258 getField258() {
		final Tag t = tag("258");
		if (t != null) {
			return new Field258(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 260, 
	 * or null if none is found.
	 * The first occurrence of field 260 at MT022 is expected to be the only one.
	 * 
	 * @return a Field260 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field260 getField260() {
		final Tag t = tag("260");
		if (t != null) {
			return new Field260(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 256, 
	 * or null if none is found.
	 * The first occurrence of field 256 at MT022 is expected to be the only one.
	 * 
	 * @return a Field256 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field256 getField256() {
		final Tag t = tag("256");
		if (t != null) {
			return new Field256(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 259, 
	 * or null if none is found.
	 * The first occurrence of field 259 at MT022 is expected to be the only one.
	 * 
	 * @return a Field259 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field259 getField259() {
		final Tag t = tag("259");
		if (t != null) {
			return new Field259(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 263, 
	 * or null if none is found.
	 * The first occurrence of field 263 at MT022 is expected to be the only one.
	 * 
	 * @return a Field263 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field263 getField263() {
		final Tag t = tag("263");
		if (t != null) {
			return new Field263(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 264, 
	 * or null if none is found.
	 * The first occurrence of field 264 at MT022 is expected to be the only one.
	 * 
	 * @return a Field264 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field264 getField264() {
		final Tag t = tag("264");
		if (t != null) {
			return new Field264(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 152, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 152 at MT022 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field152 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field152> getField152() {
		final List<Field152> result = new ArrayList<>();
		final Tag[] tags = tags("152");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field152(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 153, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 153 at MT022 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field153 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field153> getField153() {
		final List<Field153> result = new ArrayList<>();
		final Tag[] tags = tags("153");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field153(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 108, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 108 at MT022 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field108 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field108> getField108() {
		final List<Field108> result = new ArrayList<>();
		final Tag[] tags = tags("108");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field108(tag.getValue()));
            }
		}
		return result;
	}
	



}

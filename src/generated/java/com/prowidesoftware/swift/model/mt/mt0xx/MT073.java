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
 * <strong>MT 073 - Message Sample Request</strong>
 *
 * <p>
 * SWIFT MT073 (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="sequence">
Sequence _A - Message identifier (O)<ul><li class="field">Field 120  (M) (repetitive)</li>
</ul></li>
<li class="sequence">
Sequence _B - Message list (O)<ul><li class="field">Field 123  (M)</li>
<li class="field">Field 126  (M)</li>
<li class="field">Field 122  (M)</li>
</ul></li>
<li class="sequence">
Sequence _C - Message type (O)<ul><li class="field">Field 124  (M) (repetitive)</li>
<li class="field">Field 126  (M)</li>
<li class="field">Field 122  (M)</li>
</ul></li>
<li class="sequence">
Sequence _D - Message category (O)<ul><li class="field">Field 125  (M) (repetitive)</li>
<li class="field">Field 126  (M)</li>
<li class="field">Field 122  (M)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT073 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT073.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "073";

	/**
	 * Creates an MT073 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT073 content
	 */
	public MT073(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT073 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT073 content, the parameter can not be null
	 * @see #MT073(String)
	 */
	public MT073(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT073 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT073 content
	 * @return the created object or null if the parameter is null
	 * @see #MT073(String)
	 * @since 7.7
	 */
	public static MT073 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT073(m);
	}
	
	/**
	 * Creates and initializes a new MT073 input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT073() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT073 input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT073(final String sender, final String receiver) {
		super(73, sender, receiver);
	}
	
	/**
	 * Creates a new MT073 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT073(final String fin) {
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
			log.warning("Creating an MT073 object from FIN content with a Service Message. Check if the MT073 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT073 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT073 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT073 will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT073 or null if fin is null 
	 * @since 7.7
	 */
	public static MT073 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT073(fin);
    }
    
    /**
	 * Creates a new MT073 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT073(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT073 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT073 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT073 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT073(stream);
    }
    
    /**
	 * Creates a new MT073 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT073(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT073 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT073 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT073 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT073(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "073";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT073 append(final SwiftTagListBlock block) {
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
	public MT073 append(final Tag ... tags) {
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
	public MT073 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT073 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT073 message
	 * @return a new instance of MT073
	 * @since 7.10.3
	 */
	public final static MT073 fromJson(String json) {
		return (MT073) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 123, 
	 * or null if none is found.<br>
	 * The first occurrence of field 123 at MT073 is expected to be the only one.
	 * 
	 * @return a Field123 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field123 getField123() {
		final Tag t = tag("123");
		if (t != null) {
			return new Field123(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 120, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 120 at MT073 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field120 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field120> getField120() {
		final List<Field120> result = new ArrayList<>();
		final Tag[] tags = tags("120");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field120(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 124, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 124 at MT073 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field124 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field124> getField124() {
		final List<Field124> result = new ArrayList<>();
		final Tag[] tags = tags("124");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field124(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 126, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 126 at MT073 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field126 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field126> getField126() {
		final List<Field126> result = new ArrayList<>();
		final Tag[] tags = tags("126");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field126(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 122, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 122 at MT073 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field122 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field122> getField122() {
		final List<Field122> result = new ArrayList<>();
		final Tag[] tags = tags("122");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field122(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 125, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 125 at MT073 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field125 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field125> getField125() {
		final List<Field125> result = new ArrayList<>();
		final Tag[] tags = tags("125");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field125(tag.getValue()));
            }
		}
		return result;
	}
	



}

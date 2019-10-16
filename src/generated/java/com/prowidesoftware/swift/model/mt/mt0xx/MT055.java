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
 * <strong>MT 055 - Delivery Instructions Report</strong>
 *
 * <p>
 * SWIFT MT055 (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="field">Field 206  (M)</li>
<li class="field">Field 348  (O)</li>
<li class="sequence">
Sequence _A - Delivery details (M) (repetitive)<ul><li class="field">Field 339  (M)</li>
<li class="field">Field 349  (O)</li>
<li class="field">Field 344  (M) (repetitive)</li>
<li class="field">Field 345  (O) (repetitive)</li>
<li class="field">Field 346  (O) (repetitive)</li>
<li class="field">Field 347  (O) (repetitive)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT055 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT055.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "055";

	/**
	 * Creates an MT055 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT055 content
	 */
	public MT055(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT055 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT055 content, the parameter can not be null
	 * @see #MT055(String)
	 */
	public MT055(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT055 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT055 content
	 * @return the created object or null if the parameter is null
	 * @see #MT055(String)
	 * @since 7.7
	 */
	public static MT055 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT055(m);
	}
	
	/**
	 * Creates and initializes a new MT055 input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT055() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT055 input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT055(final String sender, final String receiver) {
		super(55, sender, receiver);
	}
	
	/**
	 * Creates a new MT055 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT055(final String fin) {
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
			log.warning("Creating an MT055 object from FIN content with a Service Message. Check if the MT055 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT055 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT055 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT055 will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT055 or null if fin is null 
	 * @since 7.7
	 */
	public static MT055 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT055(fin);
    }
    
    /**
	 * Creates a new MT055 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT055(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT055 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT055 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT055 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT055(stream);
    }
    
    /**
	 * Creates a new MT055 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT055(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT055 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT055 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT055 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT055(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "055";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT055 append(final SwiftTagListBlock block) {
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
	public MT055 append(final Tag ... tags) {
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
	public MT055 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT055 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT055 message
	 * @return a new instance of MT055
	 * @since 7.10.3
	 */
	public final static MT055 fromJson(String json) {
		return (MT055) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 206, 
	 * or null if none is found.<br>
	 * The first occurrence of field 206 at MT055 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 348 at MT055 is expected to be the only one.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 339, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 339 at MT055 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field339 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field339> getField339() {
		final List<Field339> result = new ArrayList<>();
		final Tag[] tags = tags("339");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field339(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 349, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 349 at MT055 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field349 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field349> getField349() {
		final List<Field349> result = new ArrayList<>();
		final Tag[] tags = tags("349");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field349(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 344, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 344 at MT055 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field344 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field344> getField344() {
		final List<Field344> result = new ArrayList<>();
		final Tag[] tags = tags("344");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field344(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 345, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 345 at MT055 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field345 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field345> getField345() {
		final List<Field345> result = new ArrayList<>();
		final Tag[] tags = tags("345");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field345(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 346, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 346 at MT055 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field346 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field346> getField346() {
		final List<Field346> result = new ArrayList<>();
		final Tag[] tags = tags("346");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field346(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 347, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 347 at MT055 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field347 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field347> getField347() {
		final List<Field347> result = new ArrayList<>();
		final Tag[] tags = tags("347");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field347(tag.getValue()));
            }
		}
		return result;
	}
	



}

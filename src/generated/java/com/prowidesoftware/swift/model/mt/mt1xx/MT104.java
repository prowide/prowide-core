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
package com.prowidesoftware.swift.model.mt.mt1xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.internal.*;
import com.prowidesoftware.swift.internal.SequenceStyle.Type;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * MT 104 - Direct Debit and Request for Debit Transfer Message.
 *
 * <p>
 * SWIFT MT104 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 20  (M)</li>
<li class="field">Field 21 R (O)</li>
<li class="field">Field 23 E (O)</li>
<li class="field">Field 21 E (O)</li>
<li class="field">Field 30  (M)</li>
<li class="field">Field 51 A (O)</li>
<li class="field">Field 50 C,L (O)</li>
<li class="field">Field 50 A,K (O)</li>
<li class="field">Field 52 A,C,D (O)</li>
<li class="field">Field 26 T (O)</li>
<li class="field">Field 77 B (O)</li>
<li class="field">Field 71 A (O)</li>
<li class="field">Field 72  (O)</li>
</ul></li>
<li class="sequence">
Sequence B (M) (repetitive)<ul><li class="field">Field 21  (M)</li>
<li class="field">Field 23 E (O)</li>
<li class="field">Field 21 C (O)</li>
<li class="field">Field 21 D (O)</li>
<li class="field">Field 21 E (O)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 50 C,L (O)</li>
<li class="field">Field 50 A,K (O)</li>
<li class="field">Field 52 A,C,D (O)</li>
<li class="field">Field 57 A,C,D (O)</li>
<li class="field">Field 59 A,NONE (M)</li>
<li class="field">Field 70  (O)</li>
<li class="field">Field 26 T (O)</li>
<li class="field">Field 77 B (O)</li>
<li class="field">Field 33 B (O)</li>
<li class="field">Field 71 A (O)</li>
<li class="field">Field 71 F (O)</li>
<li class="field">Field 71 G (O)</li>
<li class="field">Field 36  (O)</li>
</ul></li>
<li class="sequence">
Sequence C (O)<ul><li class="field">Field 32 B (M)</li>
<li class="field">Field 19  (O)</li>
<li class="field">Field 71 F (O)</li>
<li class="field">Field 71 G (O)</li>
<li class="field">Field 53 A,B (O)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2021</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT104 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT104.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "104";

	/**
	 * Creates an MT104 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT104 content
	 */
	public MT104(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT104 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT104 content, the parameter can not be null
	 * @see #MT104(String)
	 */
	public MT104(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT104 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT104 content
	 * @return the created object or null if the parameter is null
	 * @see #MT104(String)
	 * @since 7.7
	 */
	public static MT104 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT104(m);
	}
	
	/**
	 * Creates and initializes a new MT104 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT104() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT104 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT104(final String sender, final String receiver) {
		super(104, sender, receiver);
	}
	
	/**
	 * Creates a new MT104 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT104(final String fin) {
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
			log.warning("Creating an MT104 object from FIN content with a Service Message. Check if the MT104 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "104")) {
			log.warning("Creating an MT104 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT104 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT104 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT104 or null if fin is null 
	 * @since 7.7
	 */
	public static MT104 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT104(fin);
    }
    
    /**
	 * Creates a new MT104 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT104(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT104 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT104 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT104 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT104(stream);
    }
    
    /**
	 * Creates a new MT104 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT104(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT104 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT104 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT104 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT104(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "104";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT104 append(final SwiftTagListBlock block) {
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
	public MT104 append(final Tag... tags) {
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
	public MT104 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT104 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT104 message
	* @return a new instance of MT104
	* @since 7.10.3
	*/
	public static MT104 fromJson(final String json) {
		return (MT104) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.
	 * The first occurrence of field 20 at MT104 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 21R, 
	 * or null if none is found.
	 * The first occurrence of field 21R at MT104 is expected to be the only one.
	 * 
	 * @return a Field21R object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21R getField21R() {
		final Tag t = tag("21R");
		if (t != null) {
			return new Field21R(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or null if none is found.
	 * The first occurrence of field 30 at MT104 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 51A, 
	 * or null if none is found.
	 * The first occurrence of field 51A at MT104 is expected to be the only one.
	 * 
	 * @return a Field51A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field51A getField51A() {
		final Tag t = tag("51A");
		if (t != null) {
			return new Field51A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or null if none is found.
	 * The first occurrence of field 72 at MT104 is expected to be the only one.
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
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 19, 
	 * or null if none is found.
	 * The first occurrence of field 19 at MT104 is expected to be the only one.
	 * 
	 * @return a Field19 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field19 getField19() {
		final Tag t = tag("19");
		if (t != null) {
			return new Field19(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 53A, 
	 * or null if none is found.
	 * The first occurrence of field 53A at MT104 is expected to be the only one.
	 * 
	 * @return a Field53A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field53A getField53A() {
		final Tag t = tag("53A");
		if (t != null) {
			return new Field53A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 53B, 
	 * or null if none is found.
	 * The first occurrence of field 53B at MT104 is expected to be the only one.
	 * 
	 * @return a Field53B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field53B getField53B() {
		final Tag t = tag("53B");
		if (t != null) {
			return new Field53B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 21 at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21> getField21() {
		final List<Field21> result = new ArrayList<>();
		final Tag[] tags = tags("21");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field21(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 23E, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 23E at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field23E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field23E> getField23E() {
		final List<Field23E> result = new ArrayList<>();
		final Tag[] tags = tags("23E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field23E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21C, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 21C at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21C> getField21C() {
		final List<Field21C> result = new ArrayList<>();
		final Tag[] tags = tags("21C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field21C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 21D at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21D> getField21D() {
		final List<Field21D> result = new ArrayList<>();
		final Tag[] tags = tags("21D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field21D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21E, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 21E at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21E> getField21E() {
		final List<Field21E> result = new ArrayList<>();
		final Tag[] tags = tags("21E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field21E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32B at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32B> getField32B() {
		final List<Field32B> result = new ArrayList<>();
		final Tag[] tags = tags("32B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field32B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 50C, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 50C at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field50C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field50C> getField50C() {
		final List<Field50C> result = new ArrayList<>();
		final Tag[] tags = tags("50C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field50C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 50L, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 50L at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field50L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field50L> getField50L() {
		final List<Field50L> result = new ArrayList<>();
		final Tag[] tags = tags("50L");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field50L(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 50A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 50A at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field50A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field50A> getField50A() {
		final List<Field50A> result = new ArrayList<>();
		final Tag[] tags = tags("50A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field50A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 50K, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 50K at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field50K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field50K> getField50K() {
		final List<Field50K> result = new ArrayList<>();
		final Tag[] tags = tags("50K");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field50K(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 52A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 52A at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field52A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field52A> getField52A() {
		final List<Field52A> result = new ArrayList<>();
		final Tag[] tags = tags("52A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field52A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 52C, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 52C at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field52C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field52C> getField52C() {
		final List<Field52C> result = new ArrayList<>();
		final Tag[] tags = tags("52C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field52C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 52D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 52D at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field52D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field52D> getField52D() {
		final List<Field52D> result = new ArrayList<>();
		final Tag[] tags = tags("52D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field52D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 57A at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57A> getField57A() {
		final List<Field57A> result = new ArrayList<>();
		final Tag[] tags = tags("57A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field57A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57C, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 57C at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57C> getField57C() {
		final List<Field57C> result = new ArrayList<>();
		final Tag[] tags = tags("57C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field57C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 57D at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57D> getField57D() {
		final List<Field57D> result = new ArrayList<>();
		final Tag[] tags = tags("57D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field57D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 59A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 59A at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field59A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field59A> getField59A() {
		final List<Field59A> result = new ArrayList<>();
		final Tag[] tags = tags("59A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field59A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 59, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 59 at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field59 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field59> getField59() {
		final List<Field59> result = new ArrayList<>();
		final Tag[] tags = tags("59");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field59(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 70 at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70> getField70() {
		final List<Field70> result = new ArrayList<>();
		final Tag[] tags = tags("70");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field70(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 26T, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 26T at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field26T objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field26T> getField26T() {
		final List<Field26T> result = new ArrayList<>();
		final Tag[] tags = tags("26T");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field26T(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 77B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 77B at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field77B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field77B> getField77B() {
		final List<Field77B> result = new ArrayList<>();
		final Tag[] tags = tags("77B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field77B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 33B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 33B at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field33B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field33B> getField33B() {
		final List<Field33B> result = new ArrayList<>();
		final Tag[] tags = tags("33B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field33B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 71A at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71A> getField71A() {
		final List<Field71A> result = new ArrayList<>();
		final Tag[] tags = tags("71A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field71A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71F, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 71F at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71F> getField71F() {
		final List<Field71F> result = new ArrayList<>();
		final Tag[] tags = tags("71F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field71F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71G, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 71G at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71G> getField71G() {
		final List<Field71G> result = new ArrayList<>();
		final Tag[] tags = tags("71G");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field71G(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 36 at MT104 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field36 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field36> getField36() {
		final List<Field36> result = new ArrayList<>();
		final Tag[] tags = tags("36");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field36(tag.getValue()));
            }
		}
		return result;
	}
	

	/**
	 * Class to model Sequence "A" in MT 104.
	 */
	public static class SequenceA extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceA() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceA(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"20"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "20"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"30"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "30"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{ "51A", "50C", "50L", "50A", "50K", "52A", "52C", "52D", "26T", "77B", "71A", "72"   };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes.
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceA newInstance(final Tag... tags) {
			return newInstance(0, 0, tags);
		}

		/**
		 * Creates a sequence with starting and ending tags set to the indicated tags in from the
		 * {@link #START} and {@link #END} lists of mandatory fields, and with the content between
		 * the starting and ending tag initialized with the given optional tags.
		 *
		 * @param start a zero-based index within the list of mandatory starting tags in the sequence
		 * @param end a zero-based index within the list of mandatory ending tags in the sequence
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceA newInstance(final int start, final int end, final Tag... tags) {
			final SequenceA result = new SequenceA();
			result.append(new Tag(START[start], ""));
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(new Tag(END[end], ""));
			return result;
		}
	}
	/**
	 * Get the single occurrence of SequenceA delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * If block 4 is empty this method returns null.
	 *
	 * @return the found sequence or an empty sequence if none is found
	 * @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceA getSequenceA() {
		return getSequenceA(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceA delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * If block 4 is empty this method returns null.
	 *
	 * @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceA within it
	 * @return the found sequence or an empty sequence if none is found, or null if the parent sequence is null or empty
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceA getSequenceA(SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final SwiftTagListBlock content = parentSequence.getSubBlockDelimitedWithOptionalTail(SequenceA.START, SequenceA.END, SequenceA.TAIL);
			if (log.isLoggable(java.util.logging.Level.FINE)) {
				if (content == null) {
					log.fine("content for sequence SequenceA: is null");
				} else {
					log.fine("content for sequence SequenceA: "+content.tagNamesList());
				}
			}
			if (content == null) {
				return new SequenceA();
			} else {
				return new SequenceA(content);
			}
		}
		return null;
	}
 

	/**
	 * Class to model Sequence "B" in MT 104.
	 */
	public static class SequenceB extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceB() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"21"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "21"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"59A", "59"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "59A", "59"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{ "70", "26T", "77B", "33B", "71A", "71F", "71G", "36"   };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes.
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB newInstance(final Tag... tags) {
			return newInstance(0, 0, tags);
		}

		/**
		 * Creates a sequence with starting and ending tags set to the indicated tags in from the
		 * {@link #START} and {@link #END} lists of mandatory fields, and with the content between
		 * the starting and ending tag initialized with the given optional tags.
		 *
		 * @param start a zero-based index within the list of mandatory starting tags in the sequence
		 * @param end a zero-based index within the list of mandatory ending tags in the sequence
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB newInstance(final int start, final int end, final Tag... tags) {
			final SequenceB result = new SequenceB();
			result.append(new Tag(START[start], ""));
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(new Tag(END[end], ""));
			return result;
		}
	}
	/**
	 * Get the list of SequenceB delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceB> getSequenceBList() {
		return getSequenceBList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceB delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceB within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceB> getSequenceBList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceB.START, SequenceB.END, SequenceB.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceB(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "C" in MT 104.
	 */
	public static class SequenceC extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceC() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceC(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * The name of the first tag in the sequence which must be mandatory.
		 * May be null if we cannot determine this safely
		 */
		public static final String START_NAME =  "32B"  ;
	}



	/**
	 * Get the Sequence C of this message or an empty SequenceC object if not present
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.CUSTOM)
	public SequenceC getSequenceC() {
		if (super.m == null || super.m.getBlock4() == null) {
			return new SequenceC(SwiftTagListBlock.EMPTY_LIST);
		}
		final SwiftBlock4 b4 = super.m.getBlock4();
		// Find last mandatory tag of mandatory sequence B
		int last59 = b4.indexOfAnyLast("59", "59A");
		if (last59 >= 0) {
			int startIndexOfC = b4.indexOfAnyFirstAfterIndex(last59, "32B");
			if (startIndexOfC >= 0) {
				return new SequenceC(b4.sublist(startIndexOfC, b4.size()-1));
			}
		}
		return new SequenceC(SwiftTagListBlock.EMPTY_LIST);
	}

}

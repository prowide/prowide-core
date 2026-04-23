/*
 * Copyright 2006-2025 Prowide
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
package com.prowidesoftware.swift.model.mt.mt4xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.apache.commons.lang3.Strings;

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
 * MT 416 - Advice of Non-Payment/Non-Acceptance.
 *
 * <p>
 * SWIFT MT416 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A - General Information (M)<ul><li class="field">Field 20  (M)</li>
<li class="field">Field 21  (M)</li>
<li class="field">Field 23 E (O)</li>
<li class="field">Field 51 A (O)</li>
<li class="field">Field 53 A,B (O)</li>
<li class="field">Field 71 F (O)</li>
<li class="field">Field 77 A (O)</li>
</ul></li>
<li class="sequence">
Sequence B - Non-Payment/Non-Acceptance Details (M) (repetitive)<ul><li class="field">Field 21 A (M)</li>
<li class="field">Field 23 E (O)</li>
<li class="field">Field 21 C (O)</li>
<li class="field">Field 32 A,B,K (M)</li>
<li class="sequence">
Sequence B1 - Principal (O)<ul><li class="field">Field 50 N (M)</li>
<li class="field">Field 50 S (M)</li>
<li class="field">Field 50 T (M)</li>
<li class="field">Field 50 P (O)</li>
<li class="field">Field 50 R (M)</li>
</ul></li>
<li class="sequence">
Sequence B2 - Drawee (O)<ul><li class="field">Field 59 N (M)</li>
<li class="field">Field 59 S (M)</li>
<li class="field">Field 59 T (M)</li>
<li class="field">Field 59 P (O)</li>
<li class="field">Field 59 R (M)</li>
</ul></li>
<li class="field">Field 71 F (O)</li>
<li class="field">Field 77 A (O)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2026</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT416 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2026;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT416.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "416";

	/**
	 * Creates an MT416 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT416 content
	 */
	public MT416(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT416 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT416 content, the parameter can not be null
	 * @see #MT416(String)
	 */
	public MT416(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT416 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT416 content
	 * @return the created object or null if the parameter is null
	 * @see #MT416(String)
	 * @since 7.7
	 */
	public static MT416 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT416(m);
	}
	
	/**
	 * Creates and initializes a new MT416 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT416() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT416 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT416(final String sender, final String receiver) {
		super(416, sender, receiver);
	}
	
	/**
	 * Creates a new MT416 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT416(final String fin) {
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
			log.warning("Creating an MT416 object from FIN content with a Service Message. Check if the MT416 you are intended to read is prepended with and ACK.");
		} else if (!Strings.CS.equals(param.getType(), "416")) {
			log.warning("Creating an MT416 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT416 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT416 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT416 or null if fin is null 
	 * @since 7.7
	 */
	public static MT416 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT416(fin);
    }
    
    /**
	 * Creates a new MT416 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT416(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT416 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT416 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT416 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT416(stream);
    }
    
    /**
	 * Creates a new MT416 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT416(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT416 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT416 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT416 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT416(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "416";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT416 append(final SwiftTagListBlock block) {
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
	public MT416 append(final Tag... tags) {
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
	public MT416 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT416 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT416 message
	* @return a new instance of MT416
	* @since 7.10.3
	*/
	public static MT416 fromJson(final String json) {
		return (MT416) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.
	 * The first occurrence of field 20 at MT416 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT416 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 51A, 
	 * or null if none is found.
	 * The first occurrence of field 51A at MT416 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 53A, 
	 * or null if none is found.
	 * The first occurrence of field 53A at MT416 is expected to be the only one.
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
	 * The first occurrence of field 53B at MT416 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 50N, 
	 * or null if none is found.
	 * The first occurrence of field 50N at MT416 is expected to be the only one.
	 * 
	 * @return a Field50N object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50N getField50N() {
		final Tag t = tag("50N");
		if (t != null) {
			return new Field50N(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50S, 
	 * or null if none is found.
	 * The first occurrence of field 50S at MT416 is expected to be the only one.
	 * 
	 * @return a Field50S object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50S getField50S() {
		final Tag t = tag("50S");
		if (t != null) {
			return new Field50S(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50T, 
	 * or null if none is found.
	 * The first occurrence of field 50T at MT416 is expected to be the only one.
	 * 
	 * @return a Field50T object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50T getField50T() {
		final Tag t = tag("50T");
		if (t != null) {
			return new Field50T(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50P, 
	 * or null if none is found.
	 * The first occurrence of field 50P at MT416 is expected to be the only one.
	 * 
	 * @return a Field50P object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50P getField50P() {
		final Tag t = tag("50P");
		if (t != null) {
			return new Field50P(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50R, 
	 * or null if none is found.
	 * The first occurrence of field 50R at MT416 is expected to be the only one.
	 * 
	 * @return a Field50R object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50R getField50R() {
		final Tag t = tag("50R");
		if (t != null) {
			return new Field50R(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 59N, 
	 * or null if none is found.
	 * The first occurrence of field 59N at MT416 is expected to be the only one.
	 * 
	 * @return a Field59N object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59N getField59N() {
		final Tag t = tag("59N");
		if (t != null) {
			return new Field59N(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 59S, 
	 * or null if none is found.
	 * The first occurrence of field 59S at MT416 is expected to be the only one.
	 * 
	 * @return a Field59S object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59S getField59S() {
		final Tag t = tag("59S");
		if (t != null) {
			return new Field59S(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 59T, 
	 * or null if none is found.
	 * The first occurrence of field 59T at MT416 is expected to be the only one.
	 * 
	 * @return a Field59T object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59T getField59T() {
		final Tag t = tag("59T");
		if (t != null) {
			return new Field59T(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 59P, 
	 * or null if none is found.
	 * The first occurrence of field 59P at MT416 is expected to be the only one.
	 * 
	 * @return a Field59P object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59P getField59P() {
		final Tag t = tag("59P");
		if (t != null) {
			return new Field59P(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 59R, 
	 * or null if none is found.
	 * The first occurrence of field 59R at MT416 is expected to be the only one.
	 * 
	 * @return a Field59R object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59R getField59R() {
		final Tag t = tag("59R");
		if (t != null) {
			return new Field59R(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 21A at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21A> getField21A() {
		final List<Field21A> result = new ArrayList<>();
		final Tag[] tags = tags("21A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field21A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 23E, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 23E at MT416 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 21C at MT416 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32A at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32A> getField32A() {
		final List<Field32A> result = new ArrayList<>();
		final Tag[] tags = tags("32A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field32A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32B at MT416 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32K, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32K at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32K> getField32K() {
		final List<Field32K> result = new ArrayList<>();
		final Tag[] tags = tags("32K");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field32K(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71F, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 71F at MT416 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 77A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 77A at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field77A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field77A> getField77A() {
		final List<Field77A> result = new ArrayList<>();
		final Tag[] tags = tags("77A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field77A(tag.getValue()));
            }
		}
		return result;
	}
	

	/**
	 * Class to model Sequence "A" in MT 416.
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
		 * Last mandatory tag name of the sequence: <em>"21"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "21"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{ "23E", "51A", "53A", "53B", "71F", "77A"   };

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
	 * Class to model Sequence "B" in MT 416.
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
		 * First mandatory tag name of the sequence: <em>"21A"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "21A"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"32A", "32B", "32K"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "32A", "32B", "32K"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{ "71F", "77A"   };

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
	 * Class to model Sequence "B1" in MT 416.
	 */
	public static class SequenceB1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceB1() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"50N"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "50N"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"50R"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "50R"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{  };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes.
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB1 newInstance(final Tag... tags) {
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
		public static SequenceB1 newInstance(final int start, final int end, final Tag... tags) {
			final SequenceB1 result = new SequenceB1();
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
	 * Get the list of SequenceB1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceB1> getSequenceB1List() {
		return getSequenceB1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceB1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceB1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceB1> getSequenceB1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceB1.START, SequenceB1.END, SequenceB1.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceB1(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B2" in MT 416.
	 */
	public static class SequenceB2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceB2() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB2(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"59N"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "59N"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"59R"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "59R"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{  };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes.
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB2 newInstance(final Tag... tags) {
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
		public static SequenceB2 newInstance(final int start, final int end, final Tag... tags) {
			final SequenceB2 result = new SequenceB2();
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
	 * Get the list of SequenceB2 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceB2> getSequenceB2List() {
		return getSequenceB2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceB2 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceB2 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceB2> getSequenceB2List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceB2.START, SequenceB2.END, SequenceB2.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB2> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceB2(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 



}

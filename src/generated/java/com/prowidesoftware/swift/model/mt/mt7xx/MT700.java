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
package com.prowidesoftware.swift.model.mt.mt7xx;



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
 * MT 700 - Issue of a Documentary Credit.
 *
 * <p>
 * SWIFT MT700 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="field">Field 27  (M)</li>
<li class="field">Field 40 A (M)</li>
<li class="field">Field 20  (M)</li>
<li class="field">Field 23  (O)</li>
<li class="field">Field 31 C (M)</li>
<li class="field">Field 40 E (M)</li>
<li class="field">Field 31 D (M)</li>
<li class="field">Field 51 A,D (O)</li>
<li class="sequence">
Sequence A - Applicant (M)<ul><li class="field">Field 50 N (M)</li>
<li class="field">Field 50 S (M)</li>
<li class="field">Field 50 T (M)</li>
<li class="field">Field 50 P (O)</li>
<li class="field">Field 50 R (M)</li>
</ul></li>
<li class="sequence">
Sequence B - Beneficiary (M)<ul><li class="field">Field 59 N (M)</li>
<li class="field">Field 59 S (M)</li>
<li class="field">Field 59 T (M)</li>
<li class="field">Field 59 P (O)</li>
<li class="field">Field 59 R (M)</li>
</ul></li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 39 A (O)</li>
<li class="field">Field 39 C (O)</li>
<li class="field">Field 41 A,D (M)</li>
<li class="field">Field 42 C (O)</li>
<li class="field">Field 42 A,D (O)</li>
<li class="field">Field 42 M (O)</li>
<li class="field">Field 42 P (O)</li>
<li class="field">Field 43 P (O)</li>
<li class="field">Field 43 T (O)</li>
<li class="field">Field 44 A (O)</li>
<li class="field">Field 44 E (O)</li>
<li class="field">Field 44 F (O)</li>
<li class="field">Field 44 B (O)</li>
<li class="field">Field 44 C (O)</li>
<li class="field">Field 44 D (O)</li>
<li class="field">Field 44 I (O)</li>
<li class="field">Field 45 A (O)</li>
<li class="field">Field 46 A (O)</li>
<li class="field">Field 47 A (O)</li>
<li class="field">Field 45 H (O)</li>
<li class="field">Field 49 G (O)</li>
<li class="field">Field 49 H (O)</li>
<li class="field">Field 71 D (O)</li>
<li class="field">Field 48  (O)</li>
<li class="field">Field 49  (M)</li>
<li class="field">Field 58 A,D (O)</li>
<li class="field">Field 53 A,D (O)</li>
<li class="field">Field 78 K (O)</li>
<li class="field">Field 57 A,B,D (O)</li>
<li class="field">Field 72 Z (O)</li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2026</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT700 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2026;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT700.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "700";

	/**
	 * Creates an MT700 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT700 content
	 */
	public MT700(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT700 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT700 content, the parameter can not be null
	 * @see #MT700(String)
	 */
	public MT700(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT700 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT700 content
	 * @return the created object or null if the parameter is null
	 * @see #MT700(String)
	 * @since 7.7
	 */
	public static MT700 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT700(m);
	}
	
	/**
	 * Creates and initializes a new MT700 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT700() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT700 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT700(final String sender, final String receiver) {
		super(700, sender, receiver);
	}
	
	/**
	 * Creates a new MT700 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT700(final String fin) {
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
			log.warning("Creating an MT700 object from FIN content with a Service Message. Check if the MT700 you are intended to read is prepended with and ACK.");
		} else if (!Strings.CS.equals(param.getType(), "700")) {
			log.warning("Creating an MT700 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT700 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT700 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT700 or null if fin is null 
	 * @since 7.7
	 */
	public static MT700 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT700(fin);
    }
    
    /**
	 * Creates a new MT700 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT700(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT700 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT700 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT700 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT700(stream);
    }
    
    /**
	 * Creates a new MT700 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT700(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT700 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT700 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT700 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT700(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "700";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT700 append(final SwiftTagListBlock block) {
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
	public MT700 append(final Tag... tags) {
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
	public MT700 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT700 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT700 message
	* @return a new instance of MT700
	* @since 7.10.3
	*/
	public static MT700 fromJson(final String json) {
		return (MT700) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 27, 
	 * or null if none is found.
	 * The first occurrence of field 27 at MT700 is expected to be the only one.
	 * 
	 * @return a Field27 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field27 getField27() {
		final Tag t = tag("27");
		if (t != null) {
			return new Field27(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 40A, 
	 * or null if none is found.
	 * The first occurrence of field 40A at MT700 is expected to be the only one.
	 * 
	 * @return a Field40A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field40A getField40A() {
		final Tag t = tag("40A");
		if (t != null) {
			return new Field40A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.
	 * The first occurrence of field 20 at MT700 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 23, 
	 * or null if none is found.
	 * The first occurrence of field 23 at MT700 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 31C, 
	 * or null if none is found.
	 * The first occurrence of field 31C at MT700 is expected to be the only one.
	 * 
	 * @return a Field31C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31C getField31C() {
		final Tag t = tag("31C");
		if (t != null) {
			return new Field31C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 40E, 
	 * or null if none is found.
	 * The first occurrence of field 40E at MT700 is expected to be the only one.
	 * 
	 * @return a Field40E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field40E getField40E() {
		final Tag t = tag("40E");
		if (t != null) {
			return new Field40E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31D, 
	 * or null if none is found.
	 * The first occurrence of field 31D at MT700 is expected to be the only one.
	 * 
	 * @return a Field31D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31D getField31D() {
		final Tag t = tag("31D");
		if (t != null) {
			return new Field31D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 51A, 
	 * or null if none is found.
	 * The first occurrence of field 51A at MT700 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 51D, 
	 * or null if none is found.
	 * The first occurrence of field 51D at MT700 is expected to be the only one.
	 * 
	 * @return a Field51D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field51D getField51D() {
		final Tag t = tag("51D");
		if (t != null) {
			return new Field51D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50N, 
	 * or null if none is found.
	 * The first occurrence of field 50N at MT700 is expected to be the only one.
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
	 * The first occurrence of field 50S at MT700 is expected to be the only one.
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
	 * The first occurrence of field 50T at MT700 is expected to be the only one.
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
	 * The first occurrence of field 50P at MT700 is expected to be the only one.
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
	 * The first occurrence of field 50R at MT700 is expected to be the only one.
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
	 * The first occurrence of field 59N at MT700 is expected to be the only one.
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
	 * The first occurrence of field 59S at MT700 is expected to be the only one.
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
	 * The first occurrence of field 59T at MT700 is expected to be the only one.
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
	 * The first occurrence of field 59P at MT700 is expected to be the only one.
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
	 * The first occurrence of field 59R at MT700 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or null if none is found.
	 * The first occurrence of field 32B at MT700 is expected to be the only one.
	 * 
	 * @return a Field32B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field32B getField32B() {
		final Tag t = tag("32B");
		if (t != null) {
			return new Field32B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39A, 
	 * or null if none is found.
	 * The first occurrence of field 39A at MT700 is expected to be the only one.
	 * 
	 * @return a Field39A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39A getField39A() {
		final Tag t = tag("39A");
		if (t != null) {
			return new Field39A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39C, 
	 * or null if none is found.
	 * The first occurrence of field 39C at MT700 is expected to be the only one.
	 * 
	 * @return a Field39C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39C getField39C() {
		final Tag t = tag("39C");
		if (t != null) {
			return new Field39C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 41A, 
	 * or null if none is found.
	 * The first occurrence of field 41A at MT700 is expected to be the only one.
	 * 
	 * @return a Field41A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field41A getField41A() {
		final Tag t = tag("41A");
		if (t != null) {
			return new Field41A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 41D, 
	 * or null if none is found.
	 * The first occurrence of field 41D at MT700 is expected to be the only one.
	 * 
	 * @return a Field41D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field41D getField41D() {
		final Tag t = tag("41D");
		if (t != null) {
			return new Field41D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42C, 
	 * or null if none is found.
	 * The first occurrence of field 42C at MT700 is expected to be the only one.
	 * 
	 * @return a Field42C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42C getField42C() {
		final Tag t = tag("42C");
		if (t != null) {
			return new Field42C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42A, 
	 * or null if none is found.
	 * The first occurrence of field 42A at MT700 is expected to be the only one.
	 * 
	 * @return a Field42A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42A getField42A() {
		final Tag t = tag("42A");
		if (t != null) {
			return new Field42A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42D, 
	 * or null if none is found.
	 * The first occurrence of field 42D at MT700 is expected to be the only one.
	 * 
	 * @return a Field42D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42D getField42D() {
		final Tag t = tag("42D");
		if (t != null) {
			return new Field42D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42M, 
	 * or null if none is found.
	 * The first occurrence of field 42M at MT700 is expected to be the only one.
	 * 
	 * @return a Field42M object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42M getField42M() {
		final Tag t = tag("42M");
		if (t != null) {
			return new Field42M(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42P, 
	 * or null if none is found.
	 * The first occurrence of field 42P at MT700 is expected to be the only one.
	 * 
	 * @return a Field42P object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42P getField42P() {
		final Tag t = tag("42P");
		if (t != null) {
			return new Field42P(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 43P, 
	 * or null if none is found.
	 * The first occurrence of field 43P at MT700 is expected to be the only one.
	 * 
	 * @return a Field43P object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field43P getField43P() {
		final Tag t = tag("43P");
		if (t != null) {
			return new Field43P(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 43T, 
	 * or null if none is found.
	 * The first occurrence of field 43T at MT700 is expected to be the only one.
	 * 
	 * @return a Field43T object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field43T getField43T() {
		final Tag t = tag("43T");
		if (t != null) {
			return new Field43T(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44A, 
	 * or null if none is found.
	 * The first occurrence of field 44A at MT700 is expected to be the only one.
	 * 
	 * @return a Field44A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44A getField44A() {
		final Tag t = tag("44A");
		if (t != null) {
			return new Field44A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44E, 
	 * or null if none is found.
	 * The first occurrence of field 44E at MT700 is expected to be the only one.
	 * 
	 * @return a Field44E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44E getField44E() {
		final Tag t = tag("44E");
		if (t != null) {
			return new Field44E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44F, 
	 * or null if none is found.
	 * The first occurrence of field 44F at MT700 is expected to be the only one.
	 * 
	 * @return a Field44F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44F getField44F() {
		final Tag t = tag("44F");
		if (t != null) {
			return new Field44F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44B, 
	 * or null if none is found.
	 * The first occurrence of field 44B at MT700 is expected to be the only one.
	 * 
	 * @return a Field44B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44B getField44B() {
		final Tag t = tag("44B");
		if (t != null) {
			return new Field44B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44C, 
	 * or null if none is found.
	 * The first occurrence of field 44C at MT700 is expected to be the only one.
	 * 
	 * @return a Field44C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44C getField44C() {
		final Tag t = tag("44C");
		if (t != null) {
			return new Field44C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44D, 
	 * or null if none is found.
	 * The first occurrence of field 44D at MT700 is expected to be the only one.
	 * 
	 * @return a Field44D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44D getField44D() {
		final Tag t = tag("44D");
		if (t != null) {
			return new Field44D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44I, 
	 * or null if none is found.
	 * The first occurrence of field 44I at MT700 is expected to be the only one.
	 * 
	 * @return a Field44I object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44I getField44I() {
		final Tag t = tag("44I");
		if (t != null) {
			return new Field44I(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 45A, 
	 * or null if none is found.
	 * The first occurrence of field 45A at MT700 is expected to be the only one.
	 * 
	 * @return a Field45A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field45A getField45A() {
		final Tag t = tag("45A");
		if (t != null) {
			return new Field45A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 46A, 
	 * or null if none is found.
	 * The first occurrence of field 46A at MT700 is expected to be the only one.
	 * 
	 * @return a Field46A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field46A getField46A() {
		final Tag t = tag("46A");
		if (t != null) {
			return new Field46A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 47A, 
	 * or null if none is found.
	 * The first occurrence of field 47A at MT700 is expected to be the only one.
	 * 
	 * @return a Field47A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field47A getField47A() {
		final Tag t = tag("47A");
		if (t != null) {
			return new Field47A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 45H, 
	 * or null if none is found.
	 * The first occurrence of field 45H at MT700 is expected to be the only one.
	 * 
	 * @return a Field45H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field45H getField45H() {
		final Tag t = tag("45H");
		if (t != null) {
			return new Field45H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 49G, 
	 * or null if none is found.
	 * The first occurrence of field 49G at MT700 is expected to be the only one.
	 * 
	 * @return a Field49G object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field49G getField49G() {
		final Tag t = tag("49G");
		if (t != null) {
			return new Field49G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 49H, 
	 * or null if none is found.
	 * The first occurrence of field 49H at MT700 is expected to be the only one.
	 * 
	 * @return a Field49H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field49H getField49H() {
		final Tag t = tag("49H");
		if (t != null) {
			return new Field49H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71D, 
	 * or null if none is found.
	 * The first occurrence of field 71D at MT700 is expected to be the only one.
	 * 
	 * @return a Field71D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71D getField71D() {
		final Tag t = tag("71D");
		if (t != null) {
			return new Field71D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 48, 
	 * or null if none is found.
	 * The first occurrence of field 48 at MT700 is expected to be the only one.
	 * 
	 * @return a Field48 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field48 getField48() {
		final Tag t = tag("48");
		if (t != null) {
			return new Field48(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 49, 
	 * or null if none is found.
	 * The first occurrence of field 49 at MT700 is expected to be the only one.
	 * 
	 * @return a Field49 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field49 getField49() {
		final Tag t = tag("49");
		if (t != null) {
			return new Field49(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 58A, 
	 * or null if none is found.
	 * The first occurrence of field 58A at MT700 is expected to be the only one.
	 * 
	 * @return a Field58A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field58A getField58A() {
		final Tag t = tag("58A");
		if (t != null) {
			return new Field58A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 58D, 
	 * or null if none is found.
	 * The first occurrence of field 58D at MT700 is expected to be the only one.
	 * 
	 * @return a Field58D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field58D getField58D() {
		final Tag t = tag("58D");
		if (t != null) {
			return new Field58D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 53A, 
	 * or null if none is found.
	 * The first occurrence of field 53A at MT700 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 53D, 
	 * or null if none is found.
	 * The first occurrence of field 53D at MT700 is expected to be the only one.
	 * 
	 * @return a Field53D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field53D getField53D() {
		final Tag t = tag("53D");
		if (t != null) {
			return new Field53D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 78K, 
	 * or null if none is found.
	 * The first occurrence of field 78K at MT700 is expected to be the only one.
	 * 
	 * @return a Field78K object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field78K getField78K() {
		final Tag t = tag("78K");
		if (t != null) {
			return new Field78K(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57A, 
	 * or null if none is found.
	 * The first occurrence of field 57A at MT700 is expected to be the only one.
	 * 
	 * @return a Field57A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field57A getField57A() {
		final Tag t = tag("57A");
		if (t != null) {
			return new Field57A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57B, 
	 * or null if none is found.
	 * The first occurrence of field 57B at MT700 is expected to be the only one.
	 * 
	 * @return a Field57B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field57B getField57B() {
		final Tag t = tag("57B");
		if (t != null) {
			return new Field57B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57D, 
	 * or null if none is found.
	 * The first occurrence of field 57D at MT700 is expected to be the only one.
	 * 
	 * @return a Field57D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field57D getField57D() {
		final Tag t = tag("57D");
		if (t != null) {
			return new Field57D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72Z, 
	 * or null if none is found.
	 * The first occurrence of field 72Z at MT700 is expected to be the only one.
	 * 
	 * @return a Field72Z object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field72Z getField72Z() {
		final Tag t = tag("72Z");
		if (t != null) {
			return new Field72Z(t.getValue());
		} else {
			return null;
		}
	}
	

	/**
	 * Class to model Sequence "A" in MT 700.
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
	 * Class to model Sequence "B" in MT 700.
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
	 * Get the single occurrence of SequenceB delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * If block 4 is empty this method returns null.
	 *
	 * @return the found sequence or an empty sequence if none is found
	 * @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceB getSequenceB() {
		return getSequenceB(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceB delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * If block 4 is empty this method returns null.
	 *
	 * @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceB within it
	 * @return the found sequence or an empty sequence if none is found, or null if the parent sequence is null or empty
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceB getSequenceB(SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final SwiftTagListBlock content = parentSequence.getSubBlockDelimitedWithOptionalTail(SequenceB.START, SequenceB.END, SequenceB.TAIL);
			if (log.isLoggable(java.util.logging.Level.FINE)) {
				if (content == null) {
					log.fine("content for sequence SequenceB: is null");
				} else {
					log.fine("content for sequence SequenceB: "+content.tagNamesList());
				}
			}
			if (content == null) {
				return new SequenceB();
			} else {
				return new SequenceB(content);
			}
		}
		return null;
	}
 



}

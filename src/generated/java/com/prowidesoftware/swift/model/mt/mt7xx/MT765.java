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
 * MT 765 - Guarantee / Standby Letter of Credit Demand.
 *
 * <p>
 * SWIFT MT765 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="field">Field 20  (M)</li>
<li class="field">Field 21  (M)</li>
<li class="field">Field 23  (O)</li>
<li class="field">Field 52 A,D (M)</li>
<li class="sequence">
Sequence A - Beneficiary (O)<ul><li class="field">Field 59 N (M)</li>
<li class="field">Field 59 S (M)</li>
<li class="field">Field 59 T (M)</li>
<li class="field">Field 59 P (O)</li>
<li class="field">Field 59 R (M)</li>
</ul></li>
<li class="field">Field 59 E (O)</li>
<li class="field">Field 31 L (O)</li>
<li class="field">Field 22 G (M)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 78  (O)</li>
<li class="field">Field 71 D (O)</li>
<li class="field">Field 33 A,B (O)</li>
<li class="field">Field 49 A (O)</li>
<li class="field">Field 77  (O)</li>
<li class="field">Field 31 E (O)</li>
<li class="field">Field 31 R (O)</li>
<li class="field">Field 56 A,B,D (O)</li>
<li class="field">Field 57 A,B,D (O)</li>
<li class="field">Field 72 Z (O)</li>
<li class="field">Field 23 X (O)</li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2026</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT765 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2026;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT765.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "765";

	/**
	 * Creates an MT765 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT765 content
	 */
	public MT765(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT765 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT765 content, the parameter can not be null
	 * @see #MT765(String)
	 */
	public MT765(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT765 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT765 content
	 * @return the created object or null if the parameter is null
	 * @see #MT765(String)
	 * @since 7.7
	 */
	public static MT765 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT765(m);
	}
	
	/**
	 * Creates and initializes a new MT765 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT765() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT765 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT765(final String sender, final String receiver) {
		super(765, sender, receiver);
	}
	
	/**
	 * Creates a new MT765 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT765(final String fin) {
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
			log.warning("Creating an MT765 object from FIN content with a Service Message. Check if the MT765 you are intended to read is prepended with and ACK.");
		} else if (!Strings.CS.equals(param.getType(), "765")) {
			log.warning("Creating an MT765 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT765 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT765 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT765 or null if fin is null 
	 * @since 7.7
	 */
	public static MT765 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT765(fin);
    }
    
    /**
	 * Creates a new MT765 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT765(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT765 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT765 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT765 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT765(stream);
    }
    
    /**
	 * Creates a new MT765 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT765(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT765 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT765 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT765 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT765(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "765";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT765 append(final SwiftTagListBlock block) {
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
	public MT765 append(final Tag... tags) {
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
	public MT765 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT765 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT765 message
	* @return a new instance of MT765
	* @since 7.10.3
	*/
	public static MT765 fromJson(final String json) {
		return (MT765) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.
	 * The first occurrence of field 20 at MT765 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT765 is expected to be the only one.
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
	 * The first occurrence of field 23 at MT765 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 52A, 
	 * or null if none is found.
	 * The first occurrence of field 52A at MT765 is expected to be the only one.
	 * 
	 * @return a Field52A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field52A getField52A() {
		final Tag t = tag("52A");
		if (t != null) {
			return new Field52A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 52D, 
	 * or null if none is found.
	 * The first occurrence of field 52D at MT765 is expected to be the only one.
	 * 
	 * @return a Field52D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field52D getField52D() {
		final Tag t = tag("52D");
		if (t != null) {
			return new Field52D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 59N, 
	 * or null if none is found.
	 * The first occurrence of field 59N at MT765 is expected to be the only one.
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
	 * The first occurrence of field 59S at MT765 is expected to be the only one.
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
	 * The first occurrence of field 59T at MT765 is expected to be the only one.
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
	 * The first occurrence of field 59P at MT765 is expected to be the only one.
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
	 * The first occurrence of field 59R at MT765 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 59E, 
	 * or null if none is found.
	 * The first occurrence of field 59E at MT765 is expected to be the only one.
	 * 
	 * @return a Field59E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59E getField59E() {
		final Tag t = tag("59E");
		if (t != null) {
			return new Field59E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31L, 
	 * or null if none is found.
	 * The first occurrence of field 31L at MT765 is expected to be the only one.
	 * 
	 * @return a Field31L object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31L getField31L() {
		final Tag t = tag("31L");
		if (t != null) {
			return new Field31L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22G, 
	 * or null if none is found.
	 * The first occurrence of field 22G at MT765 is expected to be the only one.
	 * 
	 * @return a Field22G object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22G getField22G() {
		final Tag t = tag("22G");
		if (t != null) {
			return new Field22G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or null if none is found.
	 * The first occurrence of field 32B at MT765 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 78, 
	 * or null if none is found.
	 * The first occurrence of field 78 at MT765 is expected to be the only one.
	 * 
	 * @return a Field78 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field78 getField78() {
		final Tag t = tag("78");
		if (t != null) {
			return new Field78(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71D, 
	 * or null if none is found.
	 * The first occurrence of field 71D at MT765 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 33A, 
	 * or null if none is found.
	 * The first occurrence of field 33A at MT765 is expected to be the only one.
	 * 
	 * @return a Field33A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field33A getField33A() {
		final Tag t = tag("33A");
		if (t != null) {
			return new Field33A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33B, 
	 * or null if none is found.
	 * The first occurrence of field 33B at MT765 is expected to be the only one.
	 * 
	 * @return a Field33B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field33B getField33B() {
		final Tag t = tag("33B");
		if (t != null) {
			return new Field33B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 49A, 
	 * or null if none is found.
	 * The first occurrence of field 49A at MT765 is expected to be the only one.
	 * 
	 * @return a Field49A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field49A getField49A() {
		final Tag t = tag("49A");
		if (t != null) {
			return new Field49A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77, 
	 * or null if none is found.
	 * The first occurrence of field 77 at MT765 is expected to be the only one.
	 * 
	 * @return a Field77 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77 getField77() {
		final Tag t = tag("77");
		if (t != null) {
			return new Field77(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31E, 
	 * or null if none is found.
	 * The first occurrence of field 31E at MT765 is expected to be the only one.
	 * 
	 * @return a Field31E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31E getField31E() {
		final Tag t = tag("31E");
		if (t != null) {
			return new Field31E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31R, 
	 * or null if none is found.
	 * The first occurrence of field 31R at MT765 is expected to be the only one.
	 * 
	 * @return a Field31R object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31R getField31R() {
		final Tag t = tag("31R");
		if (t != null) {
			return new Field31R(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 56A, 
	 * or null if none is found.
	 * The first occurrence of field 56A at MT765 is expected to be the only one.
	 * 
	 * @return a Field56A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field56A getField56A() {
		final Tag t = tag("56A");
		if (t != null) {
			return new Field56A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 56B, 
	 * or null if none is found.
	 * The first occurrence of field 56B at MT765 is expected to be the only one.
	 * 
	 * @return a Field56B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field56B getField56B() {
		final Tag t = tag("56B");
		if (t != null) {
			return new Field56B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 56D, 
	 * or null if none is found.
	 * The first occurrence of field 56D at MT765 is expected to be the only one.
	 * 
	 * @return a Field56D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field56D getField56D() {
		final Tag t = tag("56D");
		if (t != null) {
			return new Field56D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57A, 
	 * or null if none is found.
	 * The first occurrence of field 57A at MT765 is expected to be the only one.
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
	 * The first occurrence of field 57B at MT765 is expected to be the only one.
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
	 * The first occurrence of field 57D at MT765 is expected to be the only one.
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
	 * The first occurrence of field 72Z at MT765 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 23X, 
	 * or null if none is found.
	 * The first occurrence of field 23X at MT765 is expected to be the only one.
	 * 
	 * @return a Field23X object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23X getField23X() {
		final Tag t = tag("23X");
		if (t != null) {
			return new Field23X(t.getValue());
		} else {
			return null;
		}
	}
	

	/**
	 * Class to model Sequence "A" in MT 765.
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
 



}

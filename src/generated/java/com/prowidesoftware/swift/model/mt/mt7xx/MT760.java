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
package com.prowidesoftware.swift.model.mt.mt7xx;



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
 * MT 760 - Issue of a Demand Guarantee / Standby Letter of Credit.
 *
 * <p>
 * SWIFT MT760 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A - General Information (M)<ul><li class="field">Field 15 A (M)</li>
<li class="field">Field 27  (M)</li>
<li class="field">Field 22 A (M)</li>
<li class="field">Field 72 Z (O)</li>
<li class="field">Field 23 X (O)</li>
</ul></li>
<li class="sequence">
Sequence B - Undertaking Details (M)<ul><li class="field">Field 15 B (M)</li>
<li class="field">Field 20  (M)</li>
<li class="field">Field 30  (M)</li>
<li class="field">Field 22 D (M)</li>
<li class="field">Field 40 C (M)</li>
<li class="field">Field 23 B (M)</li>
<li class="field">Field 31 E (O)</li>
<li class="field">Field 35 G (O)</li>
<li class="field">Field 50  (O)</li>
<li class="field">Field 51  (O)</li>
<li class="field">Field 52 A,D (M)</li>
<li class="field">Field 59 A,NONE (M)</li>
<li class="field">Field 56 A,D (O)</li>
<li class="field">Field 23  (O)</li>
<li class="field">Field 57 A,D (O)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 39 F (O)</li>
<li class="field">Field 41 F,G (O)</li>
<li class="field">Field 71 D (O)</li>
<li class="field">Field 45 C (O)</li>
<li class="field">Field 77 U (M)</li>
<li class="field">Field 49  (O)</li>
<li class="field">Field 58 A,D (O)</li>
<li class="field">Field 44 J (O)</li>
<li class="field">Field 23 F (O)</li>
<li class="field">Field 78  (O)</li>
<li class="field">Field 26 E (O)</li>
<li class="field">Field 31 S (O)</li>
<li class="field">Field 48 B (O)</li>
<li class="field">Field 48 D (O)</li>
<li class="field">Field 39 E (O)</li>
<li class="field">Field 45 L (O)</li>
<li class="field">Field 24 E (O)</li>
<li class="field">Field 24 G (O)</li>
</ul></li>
<li class="sequence">
Sequence C - Local Undertaking Details (O)<ul><li class="field">Field 15 C (M)</li>
<li class="field">Field 31 C (O)</li>
<li class="field">Field 22 D (M)</li>
<li class="field">Field 40 C (M)</li>
<li class="field">Field 22 K (O)</li>
<li class="field">Field 23 B (M)</li>
<li class="field">Field 31 E (O)</li>
<li class="field">Field 35 G (O)</li>
<li class="field">Field 50  (M)</li>
<li class="field">Field 51  (O)</li>
<li class="field">Field 52 A,D (O)</li>
<li class="field">Field 59  (M)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 39 F (O)</li>
<li class="field">Field 57 A,D (O)</li>
<li class="field">Field 41 F,G (O)</li>
<li class="field">Field 71 D (O)</li>
<li class="field">Field 45 C (O)</li>
<li class="field">Field 77 L (O)</li>
<li class="field">Field 22 Y (O)</li>
<li class="field">Field 40 D (O)</li>
<li class="field">Field 44 J (O)</li>
<li class="field">Field 23 F (O)</li>
<li class="field">Field 78  (O)</li>
<li class="field">Field 26 E (O)</li>
<li class="field">Field 31 S (O)</li>
<li class="field">Field 48 B (O)</li>
<li class="field">Field 48 D (O)</li>
<li class="field">Field 39 E (O)</li>
<li class="field">Field 45 L (M)</li>
<li class="field">Field 24 E (O)</li>
<li class="field">Field 24 G (O)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2024</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT760 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT760.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "760";

	/**
	 * Creates an MT760 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT760 content
	 */
	public MT760(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT760 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT760 content, the parameter can not be null
	 * @see #MT760(String)
	 */
	public MT760(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT760 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT760 content
	 * @return the created object or null if the parameter is null
	 * @see #MT760(String)
	 * @since 7.7
	 */
	public static MT760 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT760(m);
	}
	
	/**
	 * Creates and initializes a new MT760 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT760() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT760 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT760(final String sender, final String receiver) {
		super(760, sender, receiver);
	}
	
	/**
	 * Creates a new MT760 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT760(final String fin) {
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
			log.warning("Creating an MT760 object from FIN content with a Service Message. Check if the MT760 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "760")) {
			log.warning("Creating an MT760 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT760 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT760 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT760 or null if fin is null 
	 * @since 7.7
	 */
	public static MT760 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT760(fin);
    }
    
    /**
	 * Creates a new MT760 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT760(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT760 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT760 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT760 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT760(stream);
    }
    
    /**
	 * Creates a new MT760 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT760(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT760 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT760 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT760 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT760(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "760";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT760 append(final SwiftTagListBlock block) {
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
	public MT760 append(final Tag... tags) {
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
	public MT760 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT760 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT760 message
	* @return a new instance of MT760
	* @since 7.10.3
	*/
	public static MT760 fromJson(final String json) {
		return (MT760) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 15A, 
	 * or null if none is found.
	 * The first occurrence of field 15A at MT760 is expected to be the only one.
	 * 
	 * @return a Field15A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15A getField15A() {
		final Tag t = tag("15A");
		if (t != null) {
			return new Field15A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 27, 
	 * or null if none is found.
	 * The first occurrence of field 27 at MT760 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22A, 
	 * or null if none is found.
	 * The first occurrence of field 22A at MT760 is expected to be the only one.
	 * 
	 * @return a Field22A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22A getField22A() {
		final Tag t = tag("22A");
		if (t != null) {
			return new Field22A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72Z, 
	 * or null if none is found.
	 * The first occurrence of field 72Z at MT760 is expected to be the only one.
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
	 * The first occurrence of field 23X at MT760 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15B, 
	 * or null if none is found.
	 * The first occurrence of field 15B at MT760 is expected to be the only one.
	 * 
	 * @return a Field15B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15B getField15B() {
		final Tag t = tag("15B");
		if (t != null) {
			return new Field15B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.
	 * The first occurrence of field 20 at MT760 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or null if none is found.
	 * The first occurrence of field 30 at MT760 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 59A, 
	 * or null if none is found.
	 * The first occurrence of field 59A at MT760 is expected to be the only one.
	 * 
	 * @return a Field59A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59A getField59A() {
		final Tag t = tag("59A");
		if (t != null) {
			return new Field59A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 56A, 
	 * or null if none is found.
	 * The first occurrence of field 56A at MT760 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 56D, 
	 * or null if none is found.
	 * The first occurrence of field 56D at MT760 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 23, 
	 * or null if none is found.
	 * The first occurrence of field 23 at MT760 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 77U, 
	 * or null if none is found.
	 * The first occurrence of field 77U at MT760 is expected to be the only one.
	 * 
	 * @return a Field77U object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77U getField77U() {
		final Tag t = tag("77U");
		if (t != null) {
			return new Field77U(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 49, 
	 * or null if none is found.
	 * The first occurrence of field 49 at MT760 is expected to be the only one.
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
	 * The first occurrence of field 58A at MT760 is expected to be the only one.
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
	 * The first occurrence of field 58D at MT760 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15C, 
	 * or null if none is found.
	 * The first occurrence of field 15C at MT760 is expected to be the only one.
	 * 
	 * @return a Field15C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15C getField15C() {
		final Tag t = tag("15C");
		if (t != null) {
			return new Field15C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31C, 
	 * or null if none is found.
	 * The first occurrence of field 31C at MT760 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22K, 
	 * or null if none is found.
	 * The first occurrence of field 22K at MT760 is expected to be the only one.
	 * 
	 * @return a Field22K object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22K getField22K() {
		final Tag t = tag("22K");
		if (t != null) {
			return new Field22K(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77L, 
	 * or null if none is found.
	 * The first occurrence of field 77L at MT760 is expected to be the only one.
	 * 
	 * @return a Field77L object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77L getField77L() {
		final Tag t = tag("77L");
		if (t != null) {
			return new Field77L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22Y, 
	 * or null if none is found.
	 * The first occurrence of field 22Y at MT760 is expected to be the only one.
	 * 
	 * @return a Field22Y object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22Y getField22Y() {
		final Tag t = tag("22Y");
		if (t != null) {
			return new Field22Y(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 40D, 
	 * or null if none is found.
	 * The first occurrence of field 40D at MT760 is expected to be the only one.
	 * 
	 * @return a Field40D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field40D getField40D() {
		final Tag t = tag("40D");
		if (t != null) {
			return new Field40D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 22D at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22D> getField22D() {
		final List<Field22D> result = new ArrayList<>();
		final Tag[] tags = tags("22D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 40C, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 40C at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field40C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field40C> getField40C() {
		final List<Field40C> result = new ArrayList<>();
		final Tag[] tags = tags("40C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field40C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 23B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 23B at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field23B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field23B> getField23B() {
		final List<Field23B> result = new ArrayList<>();
		final Tag[] tags = tags("23B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field23B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 31E, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 31E at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field31E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field31E> getField31E() {
		final List<Field31E> result = new ArrayList<>();
		final Tag[] tags = tags("31E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field31E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 35G, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 35G at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field35G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field35G> getField35G() {
		final List<Field35G> result = new ArrayList<>();
		final Tag[] tags = tags("35G");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field35G(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 50, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 50 at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field50 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field50> getField50() {
		final List<Field50> result = new ArrayList<>();
		final Tag[] tags = tags("50");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field50(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 51, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 51 at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field51 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field51> getField51() {
		final List<Field51> result = new ArrayList<>();
		final Tag[] tags = tags("51");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field51(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 52A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 52A at MT760 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 52D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 52D at MT760 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 59, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 59 at MT760 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32B at MT760 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 39F, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 39F at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field39F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field39F> getField39F() {
		final List<Field39F> result = new ArrayList<>();
		final Tag[] tags = tags("39F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field39F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 57A at MT760 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 57D at MT760 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 41F, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 41F at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field41F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field41F> getField41F() {
		final List<Field41F> result = new ArrayList<>();
		final Tag[] tags = tags("41F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field41F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 41G, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 41G at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field41G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field41G> getField41G() {
		final List<Field41G> result = new ArrayList<>();
		final Tag[] tags = tags("41G");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field41G(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 71D at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71D> getField71D() {
		final List<Field71D> result = new ArrayList<>();
		final Tag[] tags = tags("71D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field71D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 45C, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 45C at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field45C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field45C> getField45C() {
		final List<Field45C> result = new ArrayList<>();
		final Tag[] tags = tags("45C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field45C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 44J, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 44J at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field44J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field44J> getField44J() {
		final List<Field44J> result = new ArrayList<>();
		final Tag[] tags = tags("44J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field44J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 23F, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 23F at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field23F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field23F> getField23F() {
		final List<Field23F> result = new ArrayList<>();
		final Tag[] tags = tags("23F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field23F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 78, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 78 at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field78 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field78> getField78() {
		final List<Field78> result = new ArrayList<>();
		final Tag[] tags = tags("78");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field78(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 26E, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 26E at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field26E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field26E> getField26E() {
		final List<Field26E> result = new ArrayList<>();
		final Tag[] tags = tags("26E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field26E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 31S, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 31S at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field31S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field31S> getField31S() {
		final List<Field31S> result = new ArrayList<>();
		final Tag[] tags = tags("31S");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field31S(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 48B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 48B at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field48B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field48B> getField48B() {
		final List<Field48B> result = new ArrayList<>();
		final Tag[] tags = tags("48B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field48B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 48D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 48D at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field48D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field48D> getField48D() {
		final List<Field48D> result = new ArrayList<>();
		final Tag[] tags = tags("48D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field48D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 39E, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 39E at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field39E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field39E> getField39E() {
		final List<Field39E> result = new ArrayList<>();
		final Tag[] tags = tags("39E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field39E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 45L, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 45L at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field45L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field45L> getField45L() {
		final List<Field45L> result = new ArrayList<>();
		final Tag[] tags = tags("45L");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field45L(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 24E, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 24E at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field24E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field24E> getField24E() {
		final List<Field24E> result = new ArrayList<>();
		final Tag[] tags = tags("24E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field24E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 24G, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 24G at MT760 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field24G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field24G> getField24G() {
		final List<Field24G> result = new ArrayList<>();
		final Tag[] tags = tags("24G");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field24G(tag.getValue()));
            }
		}
		return result;
	}
	

	/**
	 * Class to model Sequence "A" in MT 760.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
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

		public static final Tag START_TAG = Field15A.emptyTag();

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 * @since 7.7
		 */
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceA newInstance(final Tag... tags) {
			final SequenceA result = new SequenceA();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.7
		 */
		public static SequenceA newInstance() {
			final SequenceA result = new SequenceA();
			result.append(START_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.7
		 */
		public static SequenceA newInstance(final SwiftTagListBlock... sequences) {
			final SequenceA result = new SequenceA();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			return result;
		}

	}
	/**
	 * Get the single occurrence of SequenceA using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceA getSequenceA() {
		return getSequenceA(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceA using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceA within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceA getSequenceA(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("A")) {
			return new SequenceA(map.get("A"));
		}
		return new SequenceA();
	}


	/**
	 * Class to model Sequence "B" in MT 760.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
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

		public static final Tag START_TAG = Field15B.emptyTag();

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 * @since 7.7
		 */
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceB newInstance(final Tag... tags) {
			final SequenceB result = new SequenceB();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.7
		 */
		public static SequenceB newInstance() {
			final SequenceB result = new SequenceB();
			result.append(START_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.7
		 */
		public static SequenceB newInstance(final SwiftTagListBlock... sequences) {
			final SequenceB result = new SequenceB();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			return result;
		}

	}
	/**
	 * Get the single occurrence of SequenceB using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceB getSequenceB() {
		return getSequenceB(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceB using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceB within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceB getSequenceB(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("B")) {
			return new SequenceB(map.get("B"));
		}
		return new SequenceB();
	}


	/**
	 * Class to model Sequence "C" in MT 760.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
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

		public static final Tag START_TAG = Field15C.emptyTag();

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 * @since 7.7
		 */
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceC newInstance(final Tag... tags) {
			final SequenceC result = new SequenceC();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.7
		 */
		public static SequenceC newInstance() {
			final SequenceC result = new SequenceC();
			result.append(START_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.7
		 */
		public static SequenceC newInstance(final SwiftTagListBlock... sequences) {
			final SequenceC result = new SequenceC();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			return result;
		}

	}
	/**
	 * Get the single occurrence of SequenceC using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceC getSequenceC() {
		return getSequenceC(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceC using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceC within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceC getSequenceC(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("C")) {
			return new SequenceC(map.get("C"));
		}
		return new SequenceC();
	}




}

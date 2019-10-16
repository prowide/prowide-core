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
package com.prowidesoftware.swift.model.mt.mt7xx;



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
 * <strong>MT 707 - Amendment to a Documentary Credit</strong>
 *
 * <p>
 * SWIFT MT707 (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="field">Field 27  (M)</li>
<li class="field">Field 20  (M)</li>
<li class="field">Field 21  (M)</li>
<li class="field">Field 23  (M)</li>
<li class="field">Field 52 A,D (O)</li>
<li class="field">Field 50 B (O)</li>
<li class="field">Field 31 C (M)</li>
<li class="field">Field 26 E (M)</li>
<li class="field">Field 30  (M)</li>
<li class="field">Field 22 A (M)</li>
<li class="field">Field 23 S (O)</li>
<li class="field">Field 40 A (O)</li>
<li class="field">Field 40 E (O)</li>
<li class="field">Field 31 D (O)</li>
<li class="field">Field 50  (O)</li>
<li class="field">Field 59  (O)</li>
<li class="field">Field 32 B (O)</li>
<li class="field">Field 33 B (O)</li>
<li class="field">Field 39 A (O)</li>
<li class="field">Field 39 C (O)</li>
<li class="field">Field 41 A,D (O)</li>
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
<li class="field">Field 45 B (O)</li>
<li class="field">Field 46 B (O)</li>
<li class="field">Field 47 B (O)</li>
<li class="field">Field 49 M (O)</li>
<li class="field">Field 49 N (O)</li>
<li class="field">Field 71 D (O)</li>
<li class="field">Field 71 N (O)</li>
<li class="field">Field 48  (O)</li>
<li class="field">Field 49  (O)</li>
<li class="field">Field 58 A,D (O)</li>
<li class="field">Field 53 A,D (O)</li>
<li class="field">Field 78  (O)</li>
<li class="field">Field 57 A,B,D (O)</li>
<li class="field">Field 72 Z (O)</li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT707 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT707.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "707";

	/**
	 * Creates an MT707 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT707 content
	 */
	public MT707(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT707 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT707 content, the parameter can not be null
	 * @see #MT707(String)
	 */
	public MT707(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT707 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT707 content
	 * @return the created object or null if the parameter is null
	 * @see #MT707(String)
	 * @since 7.7
	 */
	public static MT707 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT707(m);
	}
	
	/**
	 * Creates and initializes a new MT707 input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT707() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT707 input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT707(final String sender, final String receiver) {
		super(707, sender, receiver);
	}
	
	/**
	 * Creates a new MT707 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT707(final String fin) {
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
			log.warning("Creating an MT707 object from FIN content with a Service Message. Check if the MT707 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT707 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT707 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT707 will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT707 or null if fin is null 
	 * @since 7.7
	 */
	public static MT707 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT707(fin);
    }
    
    /**
	 * Creates a new MT707 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT707(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT707 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT707 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT707 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT707(stream);
    }
    
    /**
	 * Creates a new MT707 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT707(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT707 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT707 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT707 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT707(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "707";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT707 append(final SwiftTagListBlock block) {
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
	public MT707 append(final Tag ... tags) {
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
	public MT707 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT707 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT707 message
	 * @return a new instance of MT707
	 * @since 7.10.3
	 */
	public final static MT707 fromJson(String json) {
		return (MT707) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 27, 
	 * or null if none is found.<br>
	 * The first occurrence of field 27 at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.<br>
	 * The first occurrence of field 20 at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 21 at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 23 at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 52A at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 52D at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 50B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 50B at MT707 is expected to be the only one.
	 * 
	 * @return a Field50B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50B getField50B() {
		final Tag t = tag("50B");
		if (t != null) {
			return new Field50B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 31C at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 26E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 26E at MT707 is expected to be the only one.
	 * 
	 * @return a Field26E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field26E getField26E() {
		final Tag t = tag("26E");
		if (t != null) {
			return new Field26E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30 at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22A at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 23S, 
	 * or null if none is found.<br>
	 * The first occurrence of field 23S at MT707 is expected to be the only one.
	 * 
	 * @return a Field23S object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23S getField23S() {
		final Tag t = tag("23S");
		if (t != null) {
			return new Field23S(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 40A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 40A at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 40E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 40E at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 31D at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 50, 
	 * or null if none is found.<br>
	 * The first occurrence of field 50 at MT707 is expected to be the only one.
	 * 
	 * @return a Field50 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50 getField50() {
		final Tag t = tag("50");
		if (t != null) {
			return new Field50(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 59, 
	 * or null if none is found.<br>
	 * The first occurrence of field 59 at MT707 is expected to be the only one.
	 * 
	 * @return a Field59 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59 getField59() {
		final Tag t = tag("59");
		if (t != null) {
			return new Field59(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 32B at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 33B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 33B at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 39A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 39A at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 39C at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 41A at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 41D at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 42C at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 42A at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 42D at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 42M at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 42P at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 43P at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 43T at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 44A at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 44E at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 44F at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 44B at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 44C at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 44D at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 45B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 45B at MT707 is expected to be the only one.
	 * 
	 * @return a Field45B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field45B getField45B() {
		final Tag t = tag("45B");
		if (t != null) {
			return new Field45B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 46B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 46B at MT707 is expected to be the only one.
	 * 
	 * @return a Field46B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field46B getField46B() {
		final Tag t = tag("46B");
		if (t != null) {
			return new Field46B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 47B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 47B at MT707 is expected to be the only one.
	 * 
	 * @return a Field47B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field47B getField47B() {
		final Tag t = tag("47B");
		if (t != null) {
			return new Field47B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 49M, 
	 * or null if none is found.<br>
	 * The first occurrence of field 49M at MT707 is expected to be the only one.
	 * 
	 * @return a Field49M object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field49M getField49M() {
		final Tag t = tag("49M");
		if (t != null) {
			return new Field49M(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 49N, 
	 * or null if none is found.<br>
	 * The first occurrence of field 49N at MT707 is expected to be the only one.
	 * 
	 * @return a Field49N object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field49N getField49N() {
		final Tag t = tag("49N");
		if (t != null) {
			return new Field49N(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 71D at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 71N, 
	 * or null if none is found.<br>
	 * The first occurrence of field 71N at MT707 is expected to be the only one.
	 * 
	 * @return a Field71N object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71N getField71N() {
		final Tag t = tag("71N");
		if (t != null) {
			return new Field71N(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 48, 
	 * or null if none is found.<br>
	 * The first occurrence of field 48 at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 49 at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 58A at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 58D at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 53A at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 53D at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 78, 
	 * or null if none is found.<br>
	 * The first occurrence of field 78 at MT707 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 57A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 57A at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 57B at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 57D at MT707 is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 72Z at MT707 is expected to be the only one.
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
	



}

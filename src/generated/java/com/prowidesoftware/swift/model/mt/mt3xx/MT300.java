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
package com.prowidesoftware.swift.model.mt.mt3xx;



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
 * <strong>MT 300 - Foreign Exchange Confirmation</strong>
 *
 * <p>
 * SWIFT MT300 (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 15 A (M)</li>
<li class="field">Field 20  (M)</li>
<li class="field">Field 21  (O)</li>
<li class="field">Field 22 A (M)</li>
<li class="field">Field 94 A (O)</li>
<li class="field">Field 22 C (M)</li>
<li class="field">Field 17 T (O)</li>
<li class="field">Field 17 U (O)</li>
<li class="field">Field 17 I (O)</li>
<li class="field">Field 82 A,J (M)</li>
<li class="field">Field 87 A,J (M)</li>
<li class="field">Field 83 A,J (O)</li>
<li class="field">Field 77 H (O)</li>
<li class="field">Field 77 D (O)</li>
<li class="field">Field 14 C (O)</li>
<li class="field">Field 17 F (O)</li>
<li class="field">Field 17 O (O)</li>
<li class="field">Field 32 E (O)</li>
<li class="field">Field 30 U (O)</li>
<li class="field">Field 14 S (O) (repetitive)</li>
<li class="field">Field 21 A (O)</li>
<li class="field">Field 14 E (O)</li>
</ul></li>
<li class="sequence">
Sequence B (M)<ul><li class="field">Field 15 B (M)</li>
<li class="field">Field 30 T (M)</li>
<li class="field">Field 30 V (M)</li>
<li class="field">Field 36  (M)</li>
<li class="field">Field 39 M (O)</li>
<li class="sequence">
Sequence B1 (M)<ul><li class="field">Field 32 B (M)</li>
<li class="field">Field 53 A,J (O)</li>
<li class="field">Field 56 A,J (O)</li>
<li class="field">Field 57 A,J (M)</li>
</ul></li>
<li class="sequence">
Sequence B2 (M)<ul><li class="field">Field 33 B (M)</li>
<li class="field">Field 53 A,J (O)</li>
<li class="field">Field 56 A,J (O)</li>
<li class="field">Field 57 A,J (M)</li>
<li class="field">Field 58 A,J (O)</li>
</ul></li>
</ul></li>
<li class="sequence">
Sequence C (O)<ul><li class="field">Field 15 C (M)</li>
<li class="field">Field 29 A (O)</li>
<li class="field">Field 24 D (O)</li>
<li class="field">Field 84 A,B,D,J (O)</li>
<li class="field">Field 85 A,B,D,J (O)</li>
<li class="field">Field 88 A,D,J (O)</li>
<li class="field">Field 71 F (O)</li>
<li class="field">Field 26 H (O)</li>
<li class="field">Field 21 G (O)</li>
<li class="field">Field 72  (O)</li>
</ul></li>
<li class="sequence">
Sequence D (O)<ul><li class="field">Field 15 D (M)</li>
<li class="sequence">
Sequence D1 (O) (repetitive)<ul><li class="field">Field 17 A (M)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (O)</li>
<li class="field">Field 58 A,D,J (O)</li>
</ul></li>
<li class="field">Field 16 A (M)</li>
</ul></li>
<li class="sequence">
Sequence E (O)<ul><li class="field">Field 15 E (M)</li>
<li class="sequence">
Sequence E1 (O) (repetitive)<ul><li class="field">Field 22 L (M)</li>
<li class="field">Field 91 A,D,J (O)</li>
<li class="sequence">
Sequence E1a (O) (repetitive)<ul><li class="field">Field 22 M (M)</li>
<li class="field">Field 22 N (M)</li>
<li class="sequence">
Sequence E1a1 (O) (repetitive)<ul><li class="field">Field 22 P (M)</li>
<li class="field">Field 22 R (M)</li>
</ul></li>
</ul></li>
</ul></li>
<li class="field">Field 81 A,D,J (O)</li>
<li class="field">Field 89 A,D,J (O)</li>
<li class="field">Field 96 A,D,J (O)</li>
<li class="field">Field 22 S (O) (repetitive)</li>
<li class="field">Field 22 T (O)</li>
<li class="field">Field 17 E (O)</li>
<li class="field">Field 22 U (O)</li>
<li class="field">Field 35 B (O)</li>
<li class="field">Field 17 H (O)</li>
<li class="field">Field 17 P (O)</li>
<li class="field">Field 22 V (O)</li>
<li class="field">Field 98 D (O)</li>
<li class="field">Field 17 W (O)</li>
<li class="field">Field 22 W (O)</li>
<li class="field">Field 17 Y (O)</li>
<li class="field">Field 17 Z (O)</li>
<li class="field">Field 22 Q (O)</li>
<li class="field">Field 17 L (O)</li>
<li class="field">Field 17 M (O)</li>
<li class="field">Field 17 Q (O)</li>
<li class="field">Field 17 S (O)</li>
<li class="field">Field 17 X (O)</li>
<li class="field">Field 98 G (O)</li>
<li class="field">Field 98 H (O)</li>
<li class="field">Field 34 C (O) (repetitive)</li>
<li class="field">Field 77 A (O)</li>
</ul></li>
<li class="sequence">
Sequence F (O)<ul><li class="field">Field 15 F (M)</li>
<li class="field">Field 21 H (M)</li>
<li class="field">Field 21 F (O)</li>
<li class="field">Field 30 F (O)</li>
<li class="field">Field 32 H (O)</li>
<li class="field">Field 33 E (O)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT300 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT300.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "300";

	/**
	 * Creates an MT300 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT300 content
	 */
	public MT300(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT300 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT300 content, the parameter can not be null
	 * @see #MT300(String)
	 */
	public MT300(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT300 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT300 content
	 * @return the created object or null if the parameter is null
	 * @see #MT300(String)
	 * @since 7.7
	 */
	public static MT300 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT300(m);
	}
	
	/**
	 * Creates and initializes a new MT300 input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT300() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT300 input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT300(final String sender, final String receiver) {
		super(300, sender, receiver);
	}
	
	/**
	 * Creates a new MT300 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT300(final String fin) {
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
			log.warning("Creating an MT300 object from FIN content with a Service Message. Check if the MT300 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT300 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT300 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT300 will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT300 or null if fin is null 
	 * @since 7.7
	 */
	public static MT300 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT300(fin);
    }
    
    /**
	 * Creates a new MT300 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT300(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT300 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT300 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT300 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT300(stream);
    }
    
    /**
	 * Creates a new MT300 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT300(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT300 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT300 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT300 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT300(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "300";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT300 append(final SwiftTagListBlock block) {
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
	public MT300 append(final Tag ... tags) {
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
	public MT300 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT300 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT300 message
	 * @return a new instance of MT300
	 * @since 7.10.3
	 */
	public final static MT300 fromJson(String json) {
		return (MT300) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 15A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15A at MT300 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.<br>
	 * The first occurrence of field 20 at MT300 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT300 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22A at MT300 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 94A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 94A at MT300 is expected to be the only one.
	 * 
	 * @return a Field94A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field94A getField94A() {
		final Tag t = tag("94A");
		if (t != null) {
			return new Field94A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22C at MT300 is expected to be the only one.
	 * 
	 * @return a Field22C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22C getField22C() {
		final Tag t = tag("22C");
		if (t != null) {
			return new Field22C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17T, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17T at MT300 is expected to be the only one.
	 * 
	 * @return a Field17T object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17T getField17T() {
		final Tag t = tag("17T");
		if (t != null) {
			return new Field17T(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17U, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17U at MT300 is expected to be the only one.
	 * 
	 * @return a Field17U object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17U getField17U() {
		final Tag t = tag("17U");
		if (t != null) {
			return new Field17U(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17I, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17I at MT300 is expected to be the only one.
	 * 
	 * @return a Field17I object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17I getField17I() {
		final Tag t = tag("17I");
		if (t != null) {
			return new Field17I(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 82A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 82A at MT300 is expected to be the only one.
	 * 
	 * @return a Field82A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field82A getField82A() {
		final Tag t = tag("82A");
		if (t != null) {
			return new Field82A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 82J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 82J at MT300 is expected to be the only one.
	 * 
	 * @return a Field82J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field82J getField82J() {
		final Tag t = tag("82J");
		if (t != null) {
			return new Field82J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 87A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 87A at MT300 is expected to be the only one.
	 * 
	 * @return a Field87A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field87A getField87A() {
		final Tag t = tag("87A");
		if (t != null) {
			return new Field87A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 87J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 87J at MT300 is expected to be the only one.
	 * 
	 * @return a Field87J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field87J getField87J() {
		final Tag t = tag("87J");
		if (t != null) {
			return new Field87J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 83A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 83A at MT300 is expected to be the only one.
	 * 
	 * @return a Field83A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field83A getField83A() {
		final Tag t = tag("83A");
		if (t != null) {
			return new Field83A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 83J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 83J at MT300 is expected to be the only one.
	 * 
	 * @return a Field83J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field83J getField83J() {
		final Tag t = tag("83J");
		if (t != null) {
			return new Field83J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77H, 
	 * or null if none is found.<br>
	 * The first occurrence of field 77H at MT300 is expected to be the only one.
	 * 
	 * @return a Field77H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77H getField77H() {
		final Tag t = tag("77H");
		if (t != null) {
			return new Field77H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 77D at MT300 is expected to be the only one.
	 * 
	 * @return a Field77D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77D getField77D() {
		final Tag t = tag("77D");
		if (t != null) {
			return new Field77D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 14C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 14C at MT300 is expected to be the only one.
	 * 
	 * @return a Field14C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field14C getField14C() {
		final Tag t = tag("14C");
		if (t != null) {
			return new Field14C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17F at MT300 is expected to be the only one.
	 * 
	 * @return a Field17F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17F getField17F() {
		final Tag t = tag("17F");
		if (t != null) {
			return new Field17F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17O, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17O at MT300 is expected to be the only one.
	 * 
	 * @return a Field17O object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17O getField17O() {
		final Tag t = tag("17O");
		if (t != null) {
			return new Field17O(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 32E at MT300 is expected to be the only one.
	 * 
	 * @return a Field32E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field32E getField32E() {
		final Tag t = tag("32E");
		if (t != null) {
			return new Field32E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30U, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30U at MT300 is expected to be the only one.
	 * 
	 * @return a Field30U object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30U getField30U() {
		final Tag t = tag("30U");
		if (t != null) {
			return new Field30U(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 21A at MT300 is expected to be the only one.
	 * 
	 * @return a Field21A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21A getField21A() {
		final Tag t = tag("21A");
		if (t != null) {
			return new Field21A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 14E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 14E at MT300 is expected to be the only one.
	 * 
	 * @return a Field14E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field14E getField14E() {
		final Tag t = tag("14E");
		if (t != null) {
			return new Field14E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15B at MT300 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30T, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30T at MT300 is expected to be the only one.
	 * 
	 * @return a Field30T object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30T getField30T() {
		final Tag t = tag("30T");
		if (t != null) {
			return new Field30T(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30V, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30V at MT300 is expected to be the only one.
	 * 
	 * @return a Field30V object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30V getField30V() {
		final Tag t = tag("30V");
		if (t != null) {
			return new Field30V(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 36, 
	 * or null if none is found.<br>
	 * The first occurrence of field 36 at MT300 is expected to be the only one.
	 * 
	 * @return a Field36 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field36 getField36() {
		final Tag t = tag("36");
		if (t != null) {
			return new Field36(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39M, 
	 * or null if none is found.<br>
	 * The first occurrence of field 39M at MT300 is expected to be the only one.
	 * 
	 * @return a Field39M object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39M getField39M() {
		final Tag t = tag("39M");
		if (t != null) {
			return new Field39M(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 33B at MT300 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15C at MT300 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 29A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 29A at MT300 is expected to be the only one.
	 * 
	 * @return a Field29A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29A getField29A() {
		final Tag t = tag("29A");
		if (t != null) {
			return new Field29A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 24D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 24D at MT300 is expected to be the only one.
	 * 
	 * @return a Field24D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field24D getField24D() {
		final Tag t = tag("24D");
		if (t != null) {
			return new Field24D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 84A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 84A at MT300 is expected to be the only one.
	 * 
	 * @return a Field84A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field84A getField84A() {
		final Tag t = tag("84A");
		if (t != null) {
			return new Field84A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 84B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 84B at MT300 is expected to be the only one.
	 * 
	 * @return a Field84B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field84B getField84B() {
		final Tag t = tag("84B");
		if (t != null) {
			return new Field84B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 84D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 84D at MT300 is expected to be the only one.
	 * 
	 * @return a Field84D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field84D getField84D() {
		final Tag t = tag("84D");
		if (t != null) {
			return new Field84D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 84J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 84J at MT300 is expected to be the only one.
	 * 
	 * @return a Field84J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field84J getField84J() {
		final Tag t = tag("84J");
		if (t != null) {
			return new Field84J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 85A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 85A at MT300 is expected to be the only one.
	 * 
	 * @return a Field85A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field85A getField85A() {
		final Tag t = tag("85A");
		if (t != null) {
			return new Field85A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 85B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 85B at MT300 is expected to be the only one.
	 * 
	 * @return a Field85B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field85B getField85B() {
		final Tag t = tag("85B");
		if (t != null) {
			return new Field85B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 85D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 85D at MT300 is expected to be the only one.
	 * 
	 * @return a Field85D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field85D getField85D() {
		final Tag t = tag("85D");
		if (t != null) {
			return new Field85D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 85J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 85J at MT300 is expected to be the only one.
	 * 
	 * @return a Field85J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field85J getField85J() {
		final Tag t = tag("85J");
		if (t != null) {
			return new Field85J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 88A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 88A at MT300 is expected to be the only one.
	 * 
	 * @return a Field88A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field88A getField88A() {
		final Tag t = tag("88A");
		if (t != null) {
			return new Field88A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 88D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 88D at MT300 is expected to be the only one.
	 * 
	 * @return a Field88D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field88D getField88D() {
		final Tag t = tag("88D");
		if (t != null) {
			return new Field88D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 88J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 88J at MT300 is expected to be the only one.
	 * 
	 * @return a Field88J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field88J getField88J() {
		final Tag t = tag("88J");
		if (t != null) {
			return new Field88J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 71F at MT300 is expected to be the only one.
	 * 
	 * @return a Field71F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71F getField71F() {
		final Tag t = tag("71F");
		if (t != null) {
			return new Field71F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 26H, 
	 * or null if none is found.<br>
	 * The first occurrence of field 26H at MT300 is expected to be the only one.
	 * 
	 * @return a Field26H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field26H getField26H() {
		final Tag t = tag("26H");
		if (t != null) {
			return new Field26H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21G, 
	 * or null if none is found.<br>
	 * The first occurrence of field 21G at MT300 is expected to be the only one.
	 * 
	 * @return a Field21G object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21G getField21G() {
		final Tag t = tag("21G");
		if (t != null) {
			return new Field21G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or null if none is found.<br>
	 * The first occurrence of field 72 at MT300 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15D at MT300 is expected to be the only one.
	 * 
	 * @return a Field15D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15D getField15D() {
		final Tag t = tag("15D");
		if (t != null) {
			return new Field15D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 16A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 16A at MT300 is expected to be the only one.
	 * 
	 * @return a Field16A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field16A getField16A() {
		final Tag t = tag("16A");
		if (t != null) {
			return new Field16A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15E at MT300 is expected to be the only one.
	 * 
	 * @return a Field15E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15E getField15E() {
		final Tag t = tag("15E");
		if (t != null) {
			return new Field15E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 81A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 81A at MT300 is expected to be the only one.
	 * 
	 * @return a Field81A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field81A getField81A() {
		final Tag t = tag("81A");
		if (t != null) {
			return new Field81A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 81D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 81D at MT300 is expected to be the only one.
	 * 
	 * @return a Field81D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field81D getField81D() {
		final Tag t = tag("81D");
		if (t != null) {
			return new Field81D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 81J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 81J at MT300 is expected to be the only one.
	 * 
	 * @return a Field81J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field81J getField81J() {
		final Tag t = tag("81J");
		if (t != null) {
			return new Field81J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 89A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 89A at MT300 is expected to be the only one.
	 * 
	 * @return a Field89A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field89A getField89A() {
		final Tag t = tag("89A");
		if (t != null) {
			return new Field89A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 89D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 89D at MT300 is expected to be the only one.
	 * 
	 * @return a Field89D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field89D getField89D() {
		final Tag t = tag("89D");
		if (t != null) {
			return new Field89D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 89J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 89J at MT300 is expected to be the only one.
	 * 
	 * @return a Field89J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field89J getField89J() {
		final Tag t = tag("89J");
		if (t != null) {
			return new Field89J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 96A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 96A at MT300 is expected to be the only one.
	 * 
	 * @return a Field96A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field96A getField96A() {
		final Tag t = tag("96A");
		if (t != null) {
			return new Field96A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 96D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 96D at MT300 is expected to be the only one.
	 * 
	 * @return a Field96D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field96D getField96D() {
		final Tag t = tag("96D");
		if (t != null) {
			return new Field96D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 96J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 96J at MT300 is expected to be the only one.
	 * 
	 * @return a Field96J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field96J getField96J() {
		final Tag t = tag("96J");
		if (t != null) {
			return new Field96J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22T, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22T at MT300 is expected to be the only one.
	 * 
	 * @return a Field22T object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22T getField22T() {
		final Tag t = tag("22T");
		if (t != null) {
			return new Field22T(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17E at MT300 is expected to be the only one.
	 * 
	 * @return a Field17E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17E getField17E() {
		final Tag t = tag("17E");
		if (t != null) {
			return new Field17E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22U, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22U at MT300 is expected to be the only one.
	 * 
	 * @return a Field22U object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22U getField22U() {
		final Tag t = tag("22U");
		if (t != null) {
			return new Field22U(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 35B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 35B at MT300 is expected to be the only one.
	 * 
	 * @return a Field35B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field35B getField35B() {
		final Tag t = tag("35B");
		if (t != null) {
			return new Field35B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17H, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17H at MT300 is expected to be the only one.
	 * 
	 * @return a Field17H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17H getField17H() {
		final Tag t = tag("17H");
		if (t != null) {
			return new Field17H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17P, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17P at MT300 is expected to be the only one.
	 * 
	 * @return a Field17P object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17P getField17P() {
		final Tag t = tag("17P");
		if (t != null) {
			return new Field17P(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22V, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22V at MT300 is expected to be the only one.
	 * 
	 * @return a Field22V object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22V getField22V() {
		final Tag t = tag("22V");
		if (t != null) {
			return new Field22V(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 98D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 98D at MT300 is expected to be the only one.
	 * 
	 * @return a Field98D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field98D getField98D() {
		final Tag t = tag("98D");
		if (t != null) {
			return new Field98D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17W, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17W at MT300 is expected to be the only one.
	 * 
	 * @return a Field17W object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17W getField17W() {
		final Tag t = tag("17W");
		if (t != null) {
			return new Field17W(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22W, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22W at MT300 is expected to be the only one.
	 * 
	 * @return a Field22W object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22W getField22W() {
		final Tag t = tag("22W");
		if (t != null) {
			return new Field22W(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17Y, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17Y at MT300 is expected to be the only one.
	 * 
	 * @return a Field17Y object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17Y getField17Y() {
		final Tag t = tag("17Y");
		if (t != null) {
			return new Field17Y(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17Z, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17Z at MT300 is expected to be the only one.
	 * 
	 * @return a Field17Z object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17Z getField17Z() {
		final Tag t = tag("17Z");
		if (t != null) {
			return new Field17Z(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22Q, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22Q at MT300 is expected to be the only one.
	 * 
	 * @return a Field22Q object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22Q getField22Q() {
		final Tag t = tag("22Q");
		if (t != null) {
			return new Field22Q(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17L, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17L at MT300 is expected to be the only one.
	 * 
	 * @return a Field17L object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17L getField17L() {
		final Tag t = tag("17L");
		if (t != null) {
			return new Field17L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17M, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17M at MT300 is expected to be the only one.
	 * 
	 * @return a Field17M object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17M getField17M() {
		final Tag t = tag("17M");
		if (t != null) {
			return new Field17M(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17Q, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17Q at MT300 is expected to be the only one.
	 * 
	 * @return a Field17Q object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17Q getField17Q() {
		final Tag t = tag("17Q");
		if (t != null) {
			return new Field17Q(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17S, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17S at MT300 is expected to be the only one.
	 * 
	 * @return a Field17S object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17S getField17S() {
		final Tag t = tag("17S");
		if (t != null) {
			return new Field17S(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17X, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17X at MT300 is expected to be the only one.
	 * 
	 * @return a Field17X object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17X getField17X() {
		final Tag t = tag("17X");
		if (t != null) {
			return new Field17X(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 98G, 
	 * or null if none is found.<br>
	 * The first occurrence of field 98G at MT300 is expected to be the only one.
	 * 
	 * @return a Field98G object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field98G getField98G() {
		final Tag t = tag("98G");
		if (t != null) {
			return new Field98G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 98H, 
	 * or null if none is found.<br>
	 * The first occurrence of field 98H at MT300 is expected to be the only one.
	 * 
	 * @return a Field98H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field98H getField98H() {
		final Tag t = tag("98H");
		if (t != null) {
			return new Field98H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 77A at MT300 is expected to be the only one.
	 * 
	 * @return a Field77A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77A getField77A() {
		final Tag t = tag("77A");
		if (t != null) {
			return new Field77A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15F at MT300 is expected to be the only one.
	 * 
	 * @return a Field15F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15F getField15F() {
		final Tag t = tag("15F");
		if (t != null) {
			return new Field15F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21H, 
	 * or null if none is found.<br>
	 * The first occurrence of field 21H at MT300 is expected to be the only one.
	 * 
	 * @return a Field21H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21H getField21H() {
		final Tag t = tag("21H");
		if (t != null) {
			return new Field21H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 21F at MT300 is expected to be the only one.
	 * 
	 * @return a Field21F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21F getField21F() {
		final Tag t = tag("21F");
		if (t != null) {
			return new Field21F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30F at MT300 is expected to be the only one.
	 * 
	 * @return a Field30F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30F getField30F() {
		final Tag t = tag("30F");
		if (t != null) {
			return new Field30F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32H, 
	 * or null if none is found.<br>
	 * The first occurrence of field 32H at MT300 is expected to be the only one.
	 * 
	 * @return a Field32H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field32H getField32H() {
		final Tag t = tag("32H");
		if (t != null) {
			return new Field32H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 33E at MT300 is expected to be the only one.
	 * 
	 * @return a Field33E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field33E getField33E() {
		final Tag t = tag("33E");
		if (t != null) {
			return new Field33E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 14S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 14S at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field14S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field14S> getField14S() {
		final List<Field14S> result = new ArrayList<>();
		final Tag[] tags = tags("14S");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field14S(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 53A at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53A> getField53A() {
		final List<Field53A> result = new ArrayList<>();
		final Tag[] tags = tags("53A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field53A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 53J at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53J> getField53J() {
		final List<Field53J> result = new ArrayList<>();
		final Tag[] tags = tags("53J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field53J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 56A at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56A> getField56A() {
		final List<Field56A> result = new ArrayList<>();
		final Tag[] tags = tags("56A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field56A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 56J at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56J> getField56J() {
		final List<Field56J> result = new ArrayList<>();
		final Tag[] tags = tags("56J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field56J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 57A at MT300 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 57J at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57J> getField57J() {
		final List<Field57J> result = new ArrayList<>();
		final Tag[] tags = tags("57J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field57J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 17A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 17A at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field17A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field17A> getField17A() {
		final List<Field17A> result = new ArrayList<>();
		final Tag[] tags = tags("17A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field17A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 32B at MT300 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 53D at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53D> getField53D() {
		final List<Field53D> result = new ArrayList<>();
		final Tag[] tags = tags("53D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field53D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 56D at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56D> getField56D() {
		final List<Field56D> result = new ArrayList<>();
		final Tag[] tags = tags("56D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field56D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 57D at MT300 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 58A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 58A at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field58A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field58A> getField58A() {
		final List<Field58A> result = new ArrayList<>();
		final Tag[] tags = tags("58A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field58A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 58D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 58D at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field58D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field58D> getField58D() {
		final List<Field58D> result = new ArrayList<>();
		final Tag[] tags = tags("58D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field58D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 58J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 58J at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field58J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field58J> getField58J() {
		final List<Field58J> result = new ArrayList<>();
		final Tag[] tags = tags("58J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field58J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22L at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22L> getField22L() {
		final List<Field22L> result = new ArrayList<>();
		final Tag[] tags = tags("22L");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22L(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 91A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 91A at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field91A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field91A> getField91A() {
		final List<Field91A> result = new ArrayList<>();
		final Tag[] tags = tags("91A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field91A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 91D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 91D at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field91D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field91D> getField91D() {
		final List<Field91D> result = new ArrayList<>();
		final Tag[] tags = tags("91D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field91D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 91J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 91J at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field91J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field91J> getField91J() {
		final List<Field91J> result = new ArrayList<>();
		final Tag[] tags = tags("91J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field91J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22M, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22M at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22M objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22M> getField22M() {
		final List<Field22M> result = new ArrayList<>();
		final Tag[] tags = tags("22M");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22M(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22N, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22N at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22N objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22N> getField22N() {
		final List<Field22N> result = new ArrayList<>();
		final Tag[] tags = tags("22N");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22N(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22P at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22P> getField22P() {
		final List<Field22P> result = new ArrayList<>();
		final Tag[] tags = tags("22P");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22P(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22R at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22R> getField22R() {
		final List<Field22R> result = new ArrayList<>();
		final Tag[] tags = tags("22R");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22R(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22S at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22S> getField22S() {
		final List<Field22S> result = new ArrayList<>();
		final Tag[] tags = tags("22S");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22S(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 34C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 34C at MT300 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field34C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field34C> getField34C() {
		final List<Field34C> result = new ArrayList<>();
		final Tag[] tags = tags("34C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field34C(tag.getValue()));
            }
		}
		return result;
	}
	

	/**
	 * Class to model Sequence "A" in MT 300
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceA extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceA() {
			super(new ArrayList<Tag>());
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
		public static SequenceA newInstance(final Tag ... tags) {
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
		public static SequenceA newInstance(final SwiftTagListBlock ... sequences) {
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
	 * Class to model Sequence "B" in MT 300
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceB extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceB() {
			super(new ArrayList<Tag>());
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
		public static SequenceB newInstance(final Tag ... tags) {
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
		public static SequenceB newInstance(final SwiftTagListBlock ... sequences) {
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
	 * Class to model Sequence "B1" in MT 300
	 */
	public static class SequenceB1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceB1() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"32B"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "32B"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"57A", "57J"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "57A", "57J"   };

		/**
		 * List of optional tags after the last mandatory tag
		 */
		protected static final String[] TAIL = new String[]{  };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB1 newInstance(final Tag ... tags) {
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
		public static SequenceB1 newInstance(final int start, final int end, final Tag ... tags) {
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
	 * Get the single occurrence of SequenceB1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * If block 4 is empty this method returns null.
	 *
	 * @return the found sequence or an empty sequence if none is found
	 * @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceB1 getSequenceB1() {
		return getSequenceB1(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceB1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * If block 4 is empty this method returns null.
	 *
	 * @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceB1 within it
	 * @return the found sequence or an empty sequence if none is found, or null if the parent sequence is null or empty
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceB1 getSequenceB1(SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final SwiftTagListBlock content = parentSequence.getSubBlockDelimitedWithOptionalTail(SequenceB1.START, SequenceB1.END, SequenceB1.TAIL);
			if (log.isLoggable(java.util.logging.Level.FINE)) {
				if (content == null) {
					log.fine("content for sequence SequenceB1: is null");
				} else {
					log.fine("content for sequence SequenceB1: "+content.tagNamesList());
				}
			}
			if (content == null) {
				return new SequenceB1();
			} else {
				return new SequenceB1(content);
			}
		}
		return null;
	}
 

	/**
	 * Class to model Sequence "B2" in MT 300
	 */
	public static class SequenceB2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceB2() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB2(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"33B"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "33B"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"57A", "57J"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "57A", "57J"   };

		/**
		 * List of optional tags after the last mandatory tag
		 */
		protected static final String[] TAIL = new String[]{ "58A", "58J"   };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB2 newInstance(final Tag ... tags) {
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
		public static SequenceB2 newInstance(final int start, final int end, final Tag ... tags) {
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
	 * Get the single occurrence of SequenceB2 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * If block 4 is empty this method returns null.
	 *
	 * @return the found sequence or an empty sequence if none is found
	 * @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceB2 getSequenceB2() {
		return getSequenceB2(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceB2 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * If block 4 is empty this method returns null.
	 *
	 * @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceB2 within it
	 * @return the found sequence or an empty sequence if none is found, or null if the parent sequence is null or empty
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceB2 getSequenceB2(SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final SwiftTagListBlock content = parentSequence.getSubBlockDelimitedWithOptionalTail(SequenceB2.START, SequenceB2.END, SequenceB2.TAIL);
			if (log.isLoggable(java.util.logging.Level.FINE)) {
				if (content == null) {
					log.fine("content for sequence SequenceB2: is null");
				} else {
					log.fine("content for sequence SequenceB2: "+content.tagNamesList());
				}
			}
			if (content == null) {
				return new SequenceB2();
			} else {
				return new SequenceB2(content);
			}
		}
		return null;
	}
 

	/**
	 * Class to model Sequence "C" in MT 300
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceC extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceC() {
			super(new ArrayList<Tag>());
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
		public static SequenceC newInstance(final Tag ... tags) {
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
		public static SequenceC newInstance(final SwiftTagListBlock ... sequences) {
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


	/**
	 * Class to model Sequence "D" in MT 300
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceD extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceD() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceD(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		public static final Tag START_TAG = Field15D.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @return a new instance of the sequence, initialized with the parameter tags
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceD newInstance(final Tag ... tags) {
			final SequenceD result = new SequenceD();
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
		public static SequenceD newInstance() {
			final SequenceD result = new SequenceD();
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
		public static SequenceD newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD result = new SequenceD();
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
	 * Get the single occurrence of SequenceD using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceD getSequenceD() {
		return getSequenceD(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceD using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceD within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceD getSequenceD(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("D")) {
			return new SequenceD(map.get("D"));
		}
		return new SequenceD();
	}


	/**
	 * Class to model Sequence "D1" in MT 300
	 */
	public static class SequenceD1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceD1() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceD1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"17A"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "17A"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"32B"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "32B"   };

		/**
		 * List of optional tags after the last mandatory tag
		 */
		protected static final String[] TAIL = new String[]{ "53A", "53D", "53J", "56A", "56D", "56J", "57A", "57D", "57J", "58A", "58D", "58J"   };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceD1 newInstance(final Tag ... tags) {
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
		public static SequenceD1 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceD1 result = new SequenceD1();
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
	 * Get the list of SequenceD1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceD1> getSequenceD1List() {
		return getSequenceD1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceD1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceD1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceD1> getSequenceD1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceD1.START, SequenceD1.END, SequenceD1.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceD1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceD1(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "E" in MT 300
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceE extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceE() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceE(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		public static final Tag START_TAG = Field15E.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @return a new instance of the sequence, initialized with the parameter tags
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceE newInstance(final Tag ... tags) {
			final SequenceE result = new SequenceE();
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
		public static SequenceE newInstance() {
			final SequenceE result = new SequenceE();
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
		public static SequenceE newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE result = new SequenceE();
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
	 * Get the single occurrence of SequenceE using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceE getSequenceE() {
		return getSequenceE(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceE using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceE within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceE getSequenceE(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("E")) {
			return new SequenceE(map.get("E"));
		}
		return new SequenceE();
	}


	/**
	 * Class to model Sequence "E1" in MT 300
	 */
	public static class SequenceE1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceE1() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceE1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * The name of the first tag in the sequence which must be mandatory.
		 * May be null if we cannot determine this safely
		 */
		public static final String START_NAME =  "22L"  ;
	}


	/**
	 * Class to model Sequence "E1a" in MT 300
	 */
	public static class SequenceE1a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceE1a() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceE1a(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"22M"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "22M"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"22N"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "22N"   };

		/**
		 * List of optional tags after the last mandatory tag
		 */
		protected static final String[] TAIL = new String[]{  };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceE1a newInstance(final Tag ... tags) {
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
		public static SequenceE1a newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceE1a result = new SequenceE1a();
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
	 * Get the list of SequenceE1a delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceE1a> getSequenceE1aList() {
		return getSequenceE1aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceE1a delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceE1a within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceE1a> getSequenceE1aList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceE1a.START, SequenceE1a.END, SequenceE1a.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceE1a> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceE1a(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "E1a1" in MT 300
	 */
	public static class SequenceE1a1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceE1a1() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceE1a1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"22P"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "22P"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"22R"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "22R"   };

		/**
		 * List of optional tags after the last mandatory tag
		 */
		protected static final String[] TAIL = new String[]{  };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceE1a1 newInstance(final Tag ... tags) {
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
		public static SequenceE1a1 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceE1a1 result = new SequenceE1a1();
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
	 * Get the list of SequenceE1a1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceE1a1> getSequenceE1a1List() {
		return getSequenceE1a1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceE1a1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceE1a1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceE1a1> getSequenceE1a1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceE1a1.START, SequenceE1a1.END, SequenceE1a1.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceE1a1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceE1a1(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "F" in MT 300
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceF extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceF() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceF(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		public static final Tag START_TAG = Field15F.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @return a new instance of the sequence, initialized with the parameter tags
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceF newInstance(final Tag ... tags) {
			final SequenceF result = new SequenceF();
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
		public static SequenceF newInstance() {
			final SequenceF result = new SequenceF();
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
		public static SequenceF newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceF result = new SequenceF();
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
	 * Get the single occurrence of SequenceF using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceF getSequenceF() {
		return getSequenceF(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceF using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceF within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceF getSequenceF(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("F")) {
			return new SequenceF(map.get("F"));
		}
		return new SequenceF();
	}



	/**
	 * Get the first occurrence of SequenceE1.
	 * @deprecated use {@link #getSequenceE1List()} instead
	 * @since 7.8.5
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 */
	@SequenceStyle(Type.CUSTOM)
	@Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2020)
	public SequenceE1 getSequenceE1() {
		return getSequenceE1(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the first occurrence of SequenceE1.
	 * @deprecated use {@link #getSequenceE1List(SwiftTagListBlock)} instead
	 * 
	 * @param parentSequence an optional parent sequence or null to find SequenceE1 within the complete message
	 * @since 7.8.5
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.CUSTOM)
	@Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2020)
	public SequenceE1 getSequenceE1(final SwiftTagListBlock parentSequence) {
		List<SequenceE1> all = getSequenceE1List(parentSequence);
		if (!all.isEmpty()) {
		    return all.get(0);
		}
		return new SequenceE1(SwiftTagListBlock.EMPTY_LIST);
	}

	/**
     * Get the list of SequenceE1a1 delimited by leading tag and end, with an optional tail.
     * The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * If message is empty or no sequences are found <em>an empty list</em> is returned.
     *
     * @return the found sequences or an empty list if none is found
     * @since 7.10.4
     */
    @SequenceStyle(Type.CUSTOM)
    public List<SequenceE1> getSequenceE1List() {
        return getSequenceE1List(super.getSwiftMessageNotNullOrException().getBlock4());
    }

    /**
     * Get the list of SequenceE1.
     * The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * If message is empty or nor sequences are found <em>an empty list</em> is returned.
     *
     * @param parentSequence an optional parent sequence or null to find SequenceE1 within the complete message
     * @return the found sequences or an empty list if none is found
     * @since 7.10.4
     */
    @SequenceStyle(Type.CUSTOM)
    public static List<SequenceE1> getSequenceE1List(final SwiftTagListBlock parentSequence) {
        if (parentSequence != null && !parentSequence.isEmpty()) {
            // first we do a split by 22L, the starting mandatory field in sequence E
            List<SwiftTagListBlock> candidates = parentSequence.splitByTagName(22, "L");

            final List<SequenceE1> result = new ArrayList<>();
            for (int i=0; i<candidates.size(); i++) {
                SwiftTagListBlock current = null;
                if (i == candidates.size()-1) {
                    // for the last candidate we must trim the optional tail
                    current = candidates.get(i).getSubBlockByTagNames(0, "22L", "91A", "91D", "91J", "22M", "22N", "22P", "22R");
                } else {
                    current = candidates.get(i);
                }
                result.add(new SequenceE1(current));
            }

            return result;
        }
        return Collections.emptyList();
    }
}

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
 * <strong>MT 306 - Foreign Currency Option Confirmation</strong>
 *
 * <p>
 * SWIFT MT306 (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 15 A (M)</li>
<li class="field">Field 20  (M)</li>
<li class="field">Field 21  (O)</li>
<li class="field">Field 22 A (M)</li>
<li class="field">Field 94 A (O)</li>
<li class="field">Field 22 C (M)</li>
<li class="field">Field 21 N (M)</li>
<li class="field">Field 21 B (O)</li>
<li class="field">Field 12 F (M)</li>
<li class="field">Field 12 E (M)</li>
<li class="field">Field 12 D (O)</li>
<li class="field">Field 17 A (M)</li>
<li class="field">Field 17 F (M)</li>
<li class="field">Field 22 K (M)</li>
<li class="field">Field 30 U (O)</li>
<li class="field">Field 29 H (O)</li>
<li class="field">Field 82 A,D,J (M)</li>
<li class="field">Field 87 A,D,J (M)</li>
<li class="field">Field 83 A,D,J (O)</li>
<li class="field">Field 77 H (M)</li>
<li class="field">Field 77 D (O)</li>
<li class="field">Field 14 C (O)</li>
</ul></li>
<li class="sequence">
Sequence B (M)<ul><li class="field">Field 15 B (M)</li>
<li class="field">Field 17 V (M)</li>
<li class="field">Field 30 T (M)</li>
<li class="field">Field 30 X (M)</li>
<li class="field">Field 29 E (M)</li>
<li class="field">Field 30 F,J (M)</li>
<li class="field">Field 14 S (O) (repetitive)</li>
<li class="field">Field 39 M (O)</li>
<li class="sequence">
Sequence B1 (O)<ul><li class="field">Field 37 K (O)</li>
<li class="field">Field 30 V (M)</li>
<li class="field">Field 34 B (M)</li>
</ul></li>
<li class="sequence">
Sequence B2 (M)<ul><li class="field">Field 84 A,B,D,J (M)</li>
</ul></li>
</ul></li>
<li class="sequence">
Sequence C (O)<ul><li class="field">Field 15 C (M)</li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 86 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (M)</li>
<li class="field">Field 58 A,D,J (O)</li>
</ul></li>
<li class="sequence">
Sequence D (O)<ul><li class="field">Field 15 D (M)</li>
<li class="field">Field 30 P (O)</li>
<li class="field">Field 30 Q (O) (repetitive)</li>
<li class="field">Field 26 F (M)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 36  (M)</li>
<li class="field">Field 33 B (M)</li>
</ul></li>
<li class="sequence">
Sequence E (O)<ul><li class="field">Field 15 E (M)</li>
<li class="field">Field 33 E (M)</li>
<li class="field">Field 30 H (O)</li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 86 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (M)</li>
<li class="field">Field 58 A,D,J (O)</li>
</ul></li>
<li class="sequence">
Sequence F (O)<ul><li class="field">Field 15 F (M)</li>
<li class="field">Field 22 G (M)</li>
<li class="field">Field 37 J (M)</li>
<li class="field">Field 37 L (O)</li>
<li class="sequence">
Sequence F1 (O) (repetitive)<ul><li class="field">Field 30 G (M)</li>
<li class="field">Field 29 J (M)</li>
<li class="field">Field 29 K (M)</li>
<li class="field">Field 14 S (O) (repetitive)</li>
</ul></li>
</ul></li>
<li class="sequence">
Sequence G (O) (repetitive)<ul><li class="field">Field 15 G (M)</li>
<li class="field">Field 22 J (M)</li>
<li class="field">Field 37 U (M)</li>
<li class="field">Field 37 P (O)</li>
<li class="field">Field 32 Q (M)</li>
<li class="field">Field 14 S (O) (repetitive)</li>
</ul></li>
<li class="sequence">
Sequence H (O)<ul><li class="field">Field 15 H (M)</li>
<li class="field">Field 14 S (M) (repetitive)</li>
<li class="field">Field 32 E (M)</li>
</ul></li>
<li class="sequence">
Sequence I (O)<ul><li class="field">Field 15 I (M)</li>
<li class="field">Field 12 G (M)</li>
<li class="field">Field 30 T (O)</li>
<li class="field">Field 22 Y (O)</li>
<li class="field">Field 85 A,D,J (O)</li>
<li class="field">Field 88 A,D,J (O)</li>
<li class="field">Field 84 A,B,D,J (M)</li>
<li class="field">Field 30 Y (O)</li>
<li class="field">Field 29 L (O)</li>
<li class="field">Field 29 E (O)</li>
<li class="field">Field 29 M (O)</li>
<li class="field">Field 17 I (O)</li>
<li class="field">Field 29 N (O)</li>
<li class="field">Field 30 Z (O)</li>
<li class="field">Field 14 S (O)</li>
</ul></li>
<li class="sequence">
Sequence J (O)<ul><li class="field">Field 15 J (M)</li>
<li class="field">Field 14 S (M)</li>
<li class="field">Field 14 B (O)</li>
<li class="field">Field 16 C (M)</li>
<li class="sequence">
Sequence J1 (O)<ul><li class="field">Field 18 B (M)</li>
<li class="sequence">
Sequence _J1a (O) (repetitive)<ul><li class="field">Field 30 M (M)</li>
<li class="field">Field 19 Y (M)</li>
</ul></li>
</ul></li>
<li class="sequence">
Sequence J2 (O)<ul><li class="field">Field 18 C (M)</li>
<li class="sequence">
Sequence _J2a (O) (repetitive)<ul><li class="field">Field 30 N (M)</li>
<li class="field">Field 19 Z (M)</li>
</ul></li>
</ul></li>
<li class="field">Field 19 C (O)</li>
<li class="field">Field 23 C (O)</li>
</ul></li>
<li class="sequence">
Sequence K (O)<ul><li class="field">Field 15 K (M)</li>
<li class="field">Field 29 A (O)</li>
<li class="field">Field 24 D (O)</li>
<li class="field">Field 88 A,D (O)</li>
<li class="field">Field 71 F (O)</li>
<li class="field">Field 21 G (O)</li>
<li class="field">Field 72  (O)</li>
</ul></li>
<li class="sequence">
Sequence L (O)<ul><li class="field">Field 15 L (M)</li>
<li class="field">Field 18 A (M)</li>
<li class="sequence">
Sequence _L1 (O) (repetitive)<ul><li class="field">Field 30 F (M)</li>
<li class="field">Field 32 H (M)</li>
</ul></li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 86 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (O)</li>
</ul></li>
<li class="sequence">
Sequence M (O)<ul><li class="field">Field 15 M (M)</li>
<li class="sequence">
Sequence M1 (O) (repetitive)<ul><li class="field">Field 22 L (M)</li>
<li class="field">Field 91 A,D,J (O)</li>
<li class="sequence">
Sequence M1a (O) (repetitive)<ul><li class="field">Field 22 M (M)</li>
<li class="field">Field 22 N (M)</li>
<li class="sequence">
Sequence M1a1 (O) (repetitive)<ul><li class="field">Field 22 P (M)</li>
<li class="field">Field 22 R (M)</li>
</ul></li>
</ul></li>
</ul></li>
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
<li class="field">Field 17 Y (O)</li>
<li class="field">Field 17 Z (O)</li>
<li class="field">Field 22 Q (O)</li>
<li class="field">Field 17 L (O)</li>
<li class="field">Field 17 M (O)</li>
<li class="field">Field 17 Q (O)</li>
<li class="field">Field 17 S (O)</li>
<li class="field">Field 17 X (O)</li>
<li class="field">Field 34 C (O) (repetitive)</li>
<li class="field">Field 77 A (O)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT306 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT306.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "306";

	/**
	 * Creates an MT306 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT306 content
	 */
	public MT306(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT306 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT306 content, the parameter can not be null
	 * @see #MT306(String)
	 */
	public MT306(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT306 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT306 content
	 * @return the created object or null if the parameter is null
	 * @see #MT306(String)
	 * @since 7.7
	 */
	public static MT306 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT306(m);
	}
	
	/**
	 * Creates and initializes a new MT306 input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT306() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT306 input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT306(final String sender, final String receiver) {
		super(306, sender, receiver);
	}
	
	/**
	 * Creates a new MT306 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT306(final String fin) {
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
			log.warning("Creating an MT306 object from FIN content with a Service Message. Check if the MT306 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT306 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT306 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT306 will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT306 or null if fin is null 
	 * @since 7.7
	 */
	public static MT306 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT306(fin);
    }
    
    /**
	 * Creates a new MT306 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT306(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT306 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT306 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT306 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT306(stream);
    }
    
    /**
	 * Creates a new MT306 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT306(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT306 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT306 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT306 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT306(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "306";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT306 append(final SwiftTagListBlock block) {
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
	public MT306 append(final Tag ... tags) {
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
	public MT306 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT306 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT306 message
	 * @return a new instance of MT306
	 * @since 7.10.3
	 */
	public final static MT306 fromJson(String json) {
		return (MT306) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 15A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15A at MT306 is expected to be the only one.
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
	 * The first occurrence of field 20 at MT306 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT306 is expected to be the only one.
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
	 * The first occurrence of field 22A at MT306 is expected to be the only one.
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
	 * The first occurrence of field 94A at MT306 is expected to be the only one.
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
	 * The first occurrence of field 22C at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 21N, 
	 * or null if none is found.<br>
	 * The first occurrence of field 21N at MT306 is expected to be the only one.
	 * 
	 * @return a Field21N object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21N getField21N() {
		final Tag t = tag("21N");
		if (t != null) {
			return new Field21N(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 21B at MT306 is expected to be the only one.
	 * 
	 * @return a Field21B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21B getField21B() {
		final Tag t = tag("21B");
		if (t != null) {
			return new Field21B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 12F at MT306 is expected to be the only one.
	 * 
	 * @return a Field12F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12F getField12F() {
		final Tag t = tag("12F");
		if (t != null) {
			return new Field12F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 12E at MT306 is expected to be the only one.
	 * 
	 * @return a Field12E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12E getField12E() {
		final Tag t = tag("12E");
		if (t != null) {
			return new Field12E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 12D at MT306 is expected to be the only one.
	 * 
	 * @return a Field12D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12D getField12D() {
		final Tag t = tag("12D");
		if (t != null) {
			return new Field12D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17A at MT306 is expected to be the only one.
	 * 
	 * @return a Field17A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17A getField17A() {
		final Tag t = tag("17A");
		if (t != null) {
			return new Field17A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17F at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22K, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22K at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30U, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30U at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 29H, 
	 * or null if none is found.<br>
	 * The first occurrence of field 29H at MT306 is expected to be the only one.
	 * 
	 * @return a Field29H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29H getField29H() {
		final Tag t = tag("29H");
		if (t != null) {
			return new Field29H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 82A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 82A at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 82D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 82D at MT306 is expected to be the only one.
	 * 
	 * @return a Field82D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field82D getField82D() {
		final Tag t = tag("82D");
		if (t != null) {
			return new Field82D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 82J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 82J at MT306 is expected to be the only one.
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
	 * The first occurrence of field 87A at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 87D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 87D at MT306 is expected to be the only one.
	 * 
	 * @return a Field87D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field87D getField87D() {
		final Tag t = tag("87D");
		if (t != null) {
			return new Field87D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 87J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 87J at MT306 is expected to be the only one.
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
	 * The first occurrence of field 83A at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 83D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 83D at MT306 is expected to be the only one.
	 * 
	 * @return a Field83D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field83D getField83D() {
		final Tag t = tag("83D");
		if (t != null) {
			return new Field83D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 83J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 83J at MT306 is expected to be the only one.
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
	 * The first occurrence of field 77H at MT306 is expected to be the only one.
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
	 * The first occurrence of field 77D at MT306 is expected to be the only one.
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
	 * The first occurrence of field 14C at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15B at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 17V, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17V at MT306 is expected to be the only one.
	 * 
	 * @return a Field17V object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17V getField17V() {
		final Tag t = tag("17V");
		if (t != null) {
			return new Field17V(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30X, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30X at MT306 is expected to be the only one.
	 * 
	 * @return a Field30X object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30X getField30X() {
		final Tag t = tag("30X");
		if (t != null) {
			return new Field30X(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30J at MT306 is expected to be the only one.
	 * 
	 * @return a Field30J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30J getField30J() {
		final Tag t = tag("30J");
		if (t != null) {
			return new Field30J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39M, 
	 * or null if none is found.<br>
	 * The first occurrence of field 39M at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 37K, 
	 * or null if none is found.<br>
	 * The first occurrence of field 37K at MT306 is expected to be the only one.
	 * 
	 * @return a Field37K object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37K getField37K() {
		final Tag t = tag("37K");
		if (t != null) {
			return new Field37K(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30V, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30V at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 34B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 34B at MT306 is expected to be the only one.
	 * 
	 * @return a Field34B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field34B getField34B() {
		final Tag t = tag("34B");
		if (t != null) {
			return new Field34B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15C at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15D at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30P, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30P at MT306 is expected to be the only one.
	 * 
	 * @return a Field30P object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30P getField30P() {
		final Tag t = tag("30P");
		if (t != null) {
			return new Field30P(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 26F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 26F at MT306 is expected to be the only one.
	 * 
	 * @return a Field26F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field26F getField26F() {
		final Tag t = tag("26F");
		if (t != null) {
			return new Field26F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 32B at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 36, 
	 * or null if none is found.<br>
	 * The first occurrence of field 36 at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 33B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 33B at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15E at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 33E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 33E at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30H, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30H at MT306 is expected to be the only one.
	 * 
	 * @return a Field30H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30H getField30H() {
		final Tag t = tag("30H");
		if (t != null) {
			return new Field30H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15F at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22G, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22G at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 37J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 37J at MT306 is expected to be the only one.
	 * 
	 * @return a Field37J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37J getField37J() {
		final Tag t = tag("37J");
		if (t != null) {
			return new Field37J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37L, 
	 * or null if none is found.<br>
	 * The first occurrence of field 37L at MT306 is expected to be the only one.
	 * 
	 * @return a Field37L object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37L getField37L() {
		final Tag t = tag("37L");
		if (t != null) {
			return new Field37L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15H, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15H at MT306 is expected to be the only one.
	 * 
	 * @return a Field15H object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15H getField15H() {
		final Tag t = tag("15H");
		if (t != null) {
			return new Field15H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 32E at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15I, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15I at MT306 is expected to be the only one.
	 * 
	 * @return a Field15I object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15I getField15I() {
		final Tag t = tag("15I");
		if (t != null) {
			return new Field15I(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12G, 
	 * or null if none is found.<br>
	 * The first occurrence of field 12G at MT306 is expected to be the only one.
	 * 
	 * @return a Field12G object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12G getField12G() {
		final Tag t = tag("12G");
		if (t != null) {
			return new Field12G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22Y, 
	 * or null if none is found.<br>
	 * The first occurrence of field 22Y at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 85A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 85A at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 85D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 85D at MT306 is expected to be the only one.
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
	 * The first occurrence of field 85J at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 88J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 88J at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30Y, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30Y at MT306 is expected to be the only one.
	 * 
	 * @return a Field30Y object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30Y getField30Y() {
		final Tag t = tag("30Y");
		if (t != null) {
			return new Field30Y(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29L, 
	 * or null if none is found.<br>
	 * The first occurrence of field 29L at MT306 is expected to be the only one.
	 * 
	 * @return a Field29L object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29L getField29L() {
		final Tag t = tag("29L");
		if (t != null) {
			return new Field29L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29M, 
	 * or null if none is found.<br>
	 * The first occurrence of field 29M at MT306 is expected to be the only one.
	 * 
	 * @return a Field29M object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29M getField29M() {
		final Tag t = tag("29M");
		if (t != null) {
			return new Field29M(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17I, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17I at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 29N, 
	 * or null if none is found.<br>
	 * The first occurrence of field 29N at MT306 is expected to be the only one.
	 * 
	 * @return a Field29N object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29N getField29N() {
		final Tag t = tag("29N");
		if (t != null) {
			return new Field29N(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30Z, 
	 * or null if none is found.<br>
	 * The first occurrence of field 30Z at MT306 is expected to be the only one.
	 * 
	 * @return a Field30Z object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30Z getField30Z() {
		final Tag t = tag("30Z");
		if (t != null) {
			return new Field30Z(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15J at MT306 is expected to be the only one.
	 * 
	 * @return a Field15J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15J getField15J() {
		final Tag t = tag("15J");
		if (t != null) {
			return new Field15J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 14B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 14B at MT306 is expected to be the only one.
	 * 
	 * @return a Field14B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field14B getField14B() {
		final Tag t = tag("14B");
		if (t != null) {
			return new Field14B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 16C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 16C at MT306 is expected to be the only one.
	 * 
	 * @return a Field16C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field16C getField16C() {
		final Tag t = tag("16C");
		if (t != null) {
			return new Field16C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 18B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 18B at MT306 is expected to be the only one.
	 * 
	 * @return a Field18B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field18B getField18B() {
		final Tag t = tag("18B");
		if (t != null) {
			return new Field18B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 18C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 18C at MT306 is expected to be the only one.
	 * 
	 * @return a Field18C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field18C getField18C() {
		final Tag t = tag("18C");
		if (t != null) {
			return new Field18C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 19C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 19C at MT306 is expected to be the only one.
	 * 
	 * @return a Field19C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field19C getField19C() {
		final Tag t = tag("19C");
		if (t != null) {
			return new Field19C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 23C at MT306 is expected to be the only one.
	 * 
	 * @return a Field23C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23C getField23C() {
		final Tag t = tag("23C");
		if (t != null) {
			return new Field23C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15K, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15K at MT306 is expected to be the only one.
	 * 
	 * @return a Field15K object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15K getField15K() {
		final Tag t = tag("15K");
		if (t != null) {
			return new Field15K(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 29A at MT306 is expected to be the only one.
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
	 * The first occurrence of field 24D at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 71F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 71F at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 21G, 
	 * or null if none is found.<br>
	 * The first occurrence of field 21G at MT306 is expected to be the only one.
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
	 * The first occurrence of field 72 at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15L, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15L at MT306 is expected to be the only one.
	 * 
	 * @return a Field15L object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15L getField15L() {
		final Tag t = tag("15L");
		if (t != null) {
			return new Field15L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 18A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 18A at MT306 is expected to be the only one.
	 * 
	 * @return a Field18A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field18A getField18A() {
		final Tag t = tag("18A");
		if (t != null) {
			return new Field18A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15M, 
	 * or null if none is found.<br>
	 * The first occurrence of field 15M at MT306 is expected to be the only one.
	 * 
	 * @return a Field15M object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15M getField15M() {
		final Tag t = tag("15M");
		if (t != null) {
			return new Field15M(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 96A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 96A at MT306 is expected to be the only one.
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
	 * The first occurrence of field 96D at MT306 is expected to be the only one.
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
	 * The first occurrence of field 96J at MT306 is expected to be the only one.
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
	 * The first occurrence of field 22T at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17E at MT306 is expected to be the only one.
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
	 * The first occurrence of field 22U at MT306 is expected to be the only one.
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
	 * The first occurrence of field 35B at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17H at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17P at MT306 is expected to be the only one.
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
	 * The first occurrence of field 22V at MT306 is expected to be the only one.
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
	 * The first occurrence of field 98D at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17W at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 17Y, 
	 * or null if none is found.<br>
	 * The first occurrence of field 17Y at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17Z at MT306 is expected to be the only one.
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
	 * The first occurrence of field 22Q at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17L at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17M at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17Q at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17S at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17X at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 77A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 77A at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 14S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 14S at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30Q, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 30Q at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30Q objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30Q> getField30Q() {
		final List<Field30Q> result = new ArrayList<>();
		final Tag[] tags = tags("30Q");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field30Q(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 53A at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 53D at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 53J at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 86A at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field86A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field86A> getField86A() {
		final List<Field86A> result = new ArrayList<>();
		final Tag[] tags = tags("86A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field86A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 86D at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field86D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field86D> getField86D() {
		final List<Field86D> result = new ArrayList<>();
		final Tag[] tags = tags("86D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field86D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 86J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field86J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field86J> getField86J() {
		final List<Field86J> result = new ArrayList<>();
		final Tag[] tags = tags("86J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field86J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 56A at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 56D at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 56J at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 57A at MT306 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 57D at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 57J at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 58A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 58A at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 58D at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 58J at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30G, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 30G at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30G> getField30G() {
		final List<Field30G> result = new ArrayList<>();
		final Tag[] tags = tags("30G");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field30G(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 29J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 29J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field29J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field29J> getField29J() {
		final List<Field29J> result = new ArrayList<>();
		final Tag[] tags = tags("29J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field29J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 29K, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 29K at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field29K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field29K> getField29K() {
		final List<Field29K> result = new ArrayList<>();
		final Tag[] tags = tags("29K");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field29K(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 15G, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 15G at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field15G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field15G> getField15G() {
		final List<Field15G> result = new ArrayList<>();
		final Tag[] tags = tags("15G");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field15G(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22J> getField22J() {
		final List<Field22J> result = new ArrayList<>();
		final Tag[] tags = tags("22J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37U, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 37U at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37U objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37U> getField37U() {
		final List<Field37U> result = new ArrayList<>();
		final Tag[] tags = tags("37U");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field37U(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 37P at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37P> getField37P() {
		final List<Field37P> result = new ArrayList<>();
		final Tag[] tags = tags("37P");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field37P(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32Q, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 32Q at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32Q objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32Q> getField32Q() {
		final List<Field32Q> result = new ArrayList<>();
		final Tag[] tags = tags("32Q");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field32Q(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30T, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 30T at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30T objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30T> getField30T() {
		final List<Field30T> result = new ArrayList<>();
		final Tag[] tags = tags("30T");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field30T(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 84A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 84A at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field84A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field84A> getField84A() {
		final List<Field84A> result = new ArrayList<>();
		final Tag[] tags = tags("84A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field84A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 84B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 84B at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field84B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field84B> getField84B() {
		final List<Field84B> result = new ArrayList<>();
		final Tag[] tags = tags("84B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field84B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 84D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 84D at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field84D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field84D> getField84D() {
		final List<Field84D> result = new ArrayList<>();
		final Tag[] tags = tags("84D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field84D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 84J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 84J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field84J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field84J> getField84J() {
		final List<Field84J> result = new ArrayList<>();
		final Tag[] tags = tags("84J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field84J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 29E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 29E at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field29E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field29E> getField29E() {
		final List<Field29E> result = new ArrayList<>();
		final Tag[] tags = tags("29E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field29E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30M, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 30M at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30M objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30M> getField30M() {
		final List<Field30M> result = new ArrayList<>();
		final Tag[] tags = tags("30M");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field30M(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19Y, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 19Y at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field19Y objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field19Y> getField19Y() {
		final List<Field19Y> result = new ArrayList<>();
		final Tag[] tags = tags("19Y");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field19Y(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30N, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 30N at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30N objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30N> getField30N() {
		final List<Field30N> result = new ArrayList<>();
		final Tag[] tags = tags("30N");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field30N(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19Z, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 19Z at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field19Z objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field19Z> getField19Z() {
		final List<Field19Z> result = new ArrayList<>();
		final Tag[] tags = tags("19Z");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field19Z(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 88A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 88A at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field88A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field88A> getField88A() {
		final List<Field88A> result = new ArrayList<>();
		final Tag[] tags = tags("88A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field88A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 88D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 88D at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field88D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field88D> getField88D() {
		final List<Field88D> result = new ArrayList<>();
		final Tag[] tags = tags("88D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field88D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 30F at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30F> getField30F() {
		final List<Field30F> result = new ArrayList<>();
		final Tag[] tags = tags("30F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field30F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 32H at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32H> getField32H() {
		final List<Field32H> result = new ArrayList<>();
		final Tag[] tags = tags("32H");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field32H(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22L at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 91A at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 91D at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 91J at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22M at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22N at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22P at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22R at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22S at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 34C at MT306 are expected at one sequence or across several sequences.
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
	 * Class to model Sequence "A" in MT 306
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
	 * Class to model Sequence "B" in MT 306
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
	 * Class to model Sequence "C" in MT 306
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
	 * Class to model Sequence "D" in MT 306
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
	 * Class to model Sequence "E" in MT 306
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
	 * Class to model Sequence "F" in MT 306
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
	 * Class to model Sequence "F1" in MT 306
	 */
	public static class SequenceF1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceF1() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceF1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"30G"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "30G"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"29K"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "29K"   };

		/**
		 * List of optional tags after the last mandatory tag
		 */
		protected static final String[] TAIL = new String[]{ "14S"   };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceF1 newInstance(final Tag ... tags) {
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
		public static SequenceF1 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceF1 result = new SequenceF1();
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
	 * Get the list of SequenceF1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceF1> getSequenceF1List() {
		return getSequenceF1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceF1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceF1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceF1> getSequenceF1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceF1.START, SequenceF1.END, SequenceF1.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceF1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceF1(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "G" in MT 306
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceG extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceG() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceG(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		public static final Tag START_TAG = Field15G.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @return a new instance of the sequence, initialized with the parameter tags
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceG newInstance(final Tag ... tags) {
			final SequenceG result = new SequenceG();
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
		public static SequenceG newInstance() {
			final SequenceG result = new SequenceG();
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
		public static SequenceG newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceG result = new SequenceG();
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
	 * Get the list of SequenceG using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public List<SequenceG> getSequenceGList() {
		return getSequenceGList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceG using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 *
	 * @param parentSequence a no null parent sequence to find SequenceG within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static List<SequenceG> getSequenceGList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = SwiftMessageUtils.splitByField15(parentSequence, "G");
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceG> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceG(b));
                }
                return result;
            }
        }
		return Collections.emptyList();
	}


	/**
	 * Class to model Sequence "H" in MT 306
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceH extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceH() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceH(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		public static final Tag START_TAG = Field15H.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @return a new instance of the sequence, initialized with the parameter tags
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceH newInstance(final Tag ... tags) {
			final SequenceH result = new SequenceH();
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
		public static SequenceH newInstance() {
			final SequenceH result = new SequenceH();
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
		public static SequenceH newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceH result = new SequenceH();
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
	 * Get the single occurrence of SequenceH using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceH getSequenceH() {
		return getSequenceH(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceH using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceH within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceH getSequenceH(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("H")) {
			return new SequenceH(map.get("H"));
		}
		return new SequenceH();
	}


	/**
	 * Class to model Sequence "I" in MT 306
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceI extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceI() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceI(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		public static final Tag START_TAG = Field15I.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @return a new instance of the sequence, initialized with the parameter tags
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceI newInstance(final Tag ... tags) {
			final SequenceI result = new SequenceI();
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
		public static SequenceI newInstance() {
			final SequenceI result = new SequenceI();
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
		public static SequenceI newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceI result = new SequenceI();
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
	 * Get the single occurrence of SequenceI using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceI getSequenceI() {
		return getSequenceI(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceI using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceI within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceI getSequenceI(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("I")) {
			return new SequenceI(map.get("I"));
		}
		return new SequenceI();
	}


	/**
	 * Class to model Sequence "J" in MT 306
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceJ extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceJ() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceJ(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		public static final Tag START_TAG = Field15J.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @return a new instance of the sequence, initialized with the parameter tags
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceJ newInstance(final Tag ... tags) {
			final SequenceJ result = new SequenceJ();
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
		public static SequenceJ newInstance() {
			final SequenceJ result = new SequenceJ();
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
		public static SequenceJ newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceJ result = new SequenceJ();
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
	 * Get the single occurrence of SequenceJ using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceJ getSequenceJ() {
		return getSequenceJ(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceJ using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceJ within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceJ getSequenceJ(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("J")) {
			return new SequenceJ(map.get("J"));
		}
		return new SequenceJ();
	}


	/**
	 * Class to model Sequence "K" in MT 306
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceK extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceK() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceK(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		public static final Tag START_TAG = Field15K.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @return a new instance of the sequence, initialized with the parameter tags
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceK newInstance(final Tag ... tags) {
			final SequenceK result = new SequenceK();
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
		public static SequenceK newInstance() {
			final SequenceK result = new SequenceK();
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
		public static SequenceK newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceK result = new SequenceK();
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
	 * Get the single occurrence of SequenceK using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceK getSequenceK() {
		return getSequenceK(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceK using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceK within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceK getSequenceK(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("K")) {
			return new SequenceK(map.get("K"));
		}
		return new SequenceK();
	}


	/**
	 * Class to model Sequence "L" in MT 306
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceL extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceL() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceL(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		public static final Tag START_TAG = Field15L.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @return a new instance of the sequence, initialized with the parameter tags
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceL newInstance(final Tag ... tags) {
			final SequenceL result = new SequenceL();
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
		public static SequenceL newInstance() {
			final SequenceL result = new SequenceL();
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
		public static SequenceL newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceL result = new SequenceL();
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
	 * Get the single occurrence of SequenceL using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceL getSequenceL() {
		return getSequenceL(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceL using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceL within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceL getSequenceL(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("L")) {
			return new SequenceL(map.get("L"));
		}
		return new SequenceL();
	}


	/**
	 * Class to model Sequence "M" in MT 306
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceM extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceM() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceM(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		public static final Tag START_TAG = Field15M.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @return a new instance of the sequence, initialized with the parameter tags
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceM newInstance(final Tag ... tags) {
			final SequenceM result = new SequenceM();
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
		public static SequenceM newInstance() {
			final SequenceM result = new SequenceM();
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
		public static SequenceM newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceM result = new SequenceM();
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
	 * Get the single occurrence of SequenceM using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceM getSequenceM() {
		return getSequenceM(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceM using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceM within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceM getSequenceM(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("M")) {
			return new SequenceM(map.get("M"));
		}
		return new SequenceM();
	}


	/**
	 * Class to model Sequence "M1" in MT 306
	 */
	public static class SequenceM1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceM1() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceM1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * The name of the first tag in the sequence which must be mandatory.
		 * May be null if we cannot determine this safely
		 */
		public static final String START_NAME =  "22L"  ;
	}


	/**
	 * Class to model Sequence "M1a" in MT 306
	 */
	public static class SequenceM1a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceM1a() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceM1a(final SwiftTagListBlock content) {
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
		public static SequenceM1a newInstance(final Tag ... tags) {
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
		public static SequenceM1a newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceM1a result = new SequenceM1a();
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
	 * Get the list of SequenceM1a delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceM1a> getSequenceM1aList() {
		return getSequenceM1aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceM1a delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceM1a within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceM1a> getSequenceM1aList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceM1a.START, SequenceM1a.END, SequenceM1a.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceM1a> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceM1a(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "M1a1" in MT 306
	 */
	public static class SequenceM1a1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceM1a1() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceM1a1(final SwiftTagListBlock content) {
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
		public static SequenceM1a1 newInstance(final Tag ... tags) {
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
		public static SequenceM1a1 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceM1a1 result = new SequenceM1a1();
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
	 * Get the list of SequenceM1a1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceM1a1> getSequenceM1a1List() {
		return getSequenceM1a1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceM1a1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceM1a1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceM1a1> getSequenceM1a1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceM1a1.START, SequenceM1a1.END, SequenceM1a1.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceM1a1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceM1a1(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 



}

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
 * MT 320 - Fixed Loan/Deposit Confirmation.
 *
 * <p>
 * SWIFT MT320 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 15 A (M)</li>
<li class="field">Field 20  (M)</li>
<li class="field">Field 21  (O)</li>
<li class="field">Field 22 A (M)</li>
<li class="field">Field 94 A (O)</li>
<li class="field">Field 22 B (M)</li>
<li class="field">Field 22 C (M)</li>
<li class="field">Field 21 N (O)</li>
<li class="field">Field 82 A,D,J (M)</li>
<li class="field">Field 87 A,D,J (M)</li>
<li class="field">Field 83 A,D,J (O)</li>
<li class="field">Field 77 D (O)</li>
</ul></li>
<li class="sequence">
Sequence B (M)<ul><li class="field">Field 15 B (M)</li>
<li class="field">Field 17 R (M)</li>
<li class="field">Field 30 T (M)</li>
<li class="field">Field 30 V (M)</li>
<li class="field">Field 30 P (M)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 32 H (O)</li>
<li class="field">Field 30 X (O)</li>
<li class="field">Field 34 E (M)</li>
<li class="field">Field 37 G (M)</li>
<li class="field">Field 14 D (M)</li>
<li class="field">Field 30 F (O)</li>
<li class="field">Field 38 J (O)</li>
<li class="field">Field 39 M (O)</li>
</ul></li>
<li class="sequence">
Sequence C (M)<ul><li class="field">Field 15 C (M)</li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 86 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (M)</li>
<li class="field">Field 58 A,D,J (O)</li>
</ul></li>
<li class="sequence">
Sequence D (M)<ul><li class="field">Field 15 D (M)</li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 86 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (M)</li>
<li class="field">Field 58 A,D,J (O)</li>
</ul></li>
<li class="sequence">
Sequence E (O)<ul><li class="field">Field 15 E (M)</li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 86 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (M)</li>
<li class="field">Field 58 A,D,J (O)</li>
</ul></li>
<li class="sequence">
Sequence F (O)<ul><li class="field">Field 15 F (M)</li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 86 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (M)</li>
<li class="field">Field 58 A,D,J (O)</li>
</ul></li>
<li class="sequence">
Sequence G (O)<ul><li class="field">Field 15 G (M)</li>
<li class="field">Field 37 L (M)</li>
<li class="field">Field 33 B (M)</li>
<li class="field">Field 36  (O)</li>
<li class="field">Field 33 E (O)</li>
</ul></li>
<li class="sequence">
Sequence H (O)<ul><li class="field">Field 15 H (M)</li>
<li class="field">Field 29 A (O)</li>
<li class="field">Field 24 D (O)</li>
<li class="field">Field 84 A,B,D,J (O)</li>
<li class="field">Field 85 A,B,D,J (O)</li>
<li class="field">Field 88 A,D,J (O)</li>
<li class="field">Field 71 F (O)</li>
<li class="field">Field 26 H (O)</li>
<li class="field">Field 21 G (O)</li>
<li class="field">Field 34 C (O) (repetitive)</li>
<li class="field">Field 72  (O)</li>
</ul></li>
<li class="sequence">
Sequence I (O)<ul><li class="field">Field 15 I (M)</li>
<li class="field">Field 18 A (M)</li>
<li class="sequence">
Sequence _I1 (O) (repetitive)<ul><li class="field">Field 30 F (M)</li>
<li class="field">Field 32 H (M)</li>
</ul></li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 86 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (M)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2021</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT320 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT320.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "320";

	/**
	 * Creates an MT320 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT320 content
	 */
	public MT320(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT320 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT320 content, the parameter can not be null
	 * @see #MT320(String)
	 */
	public MT320(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT320 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT320 content
	 * @return the created object or null if the parameter is null
	 * @see #MT320(String)
	 * @since 7.7
	 */
	public static MT320 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT320(m);
	}
	
	/**
	 * Creates and initializes a new MT320 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT320() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT320 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT320(final String sender, final String receiver) {
		super(320, sender, receiver);
	}
	
	/**
	 * Creates a new MT320 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT320(final String fin) {
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
			log.warning("Creating an MT320 object from FIN content with a Service Message. Check if the MT320 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "320")) {
			log.warning("Creating an MT320 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT320 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT320 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT320 or null if fin is null 
	 * @since 7.7
	 */
	public static MT320 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT320(fin);
    }
    
    /**
	 * Creates a new MT320 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT320(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT320 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT320 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT320 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT320(stream);
    }
    
    /**
	 * Creates a new MT320 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT320(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT320 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT320 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT320 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT320(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "320";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT320 append(final SwiftTagListBlock block) {
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
	public MT320 append(final Tag... tags) {
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
	public MT320 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT320 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT320 message
	* @return a new instance of MT320
	* @since 7.10.3
	*/
	public static MT320 fromJson(final String json) {
		return (MT320) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 15A, 
	 * or null if none is found.
	 * The first occurrence of field 15A at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 20 at MT320 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 22A at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 94A at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22B, 
	 * or null if none is found.
	 * The first occurrence of field 22B at MT320 is expected to be the only one.
	 * 
	 * @return a Field22B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22B getField22B() {
		final Tag t = tag("22B");
		if (t != null) {
			return new Field22B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22C, 
	 * or null if none is found.
	 * The first occurrence of field 22C at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 21N at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 82A, 
	 * or null if none is found.
	 * The first occurrence of field 82A at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 82D at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 82J at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 87A at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 87D at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 87J at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 83A at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 83D at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 83J at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 77D, 
	 * or null if none is found.
	 * The first occurrence of field 77D at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15B, 
	 * or null if none is found.
	 * The first occurrence of field 15B at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 17R, 
	 * or null if none is found.
	 * The first occurrence of field 17R at MT320 is expected to be the only one.
	 * 
	 * @return a Field17R object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17R getField17R() {
		final Tag t = tag("17R");
		if (t != null) {
			return new Field17R(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30T, 
	 * or null if none is found.
	 * The first occurrence of field 30T at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 30V at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30P, 
	 * or null if none is found.
	 * The first occurrence of field 30P at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or null if none is found.
	 * The first occurrence of field 32B at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30X, 
	 * or null if none is found.
	 * The first occurrence of field 30X at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 34E, 
	 * or null if none is found.
	 * The first occurrence of field 34E at MT320 is expected to be the only one.
	 * 
	 * @return a Field34E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field34E getField34E() {
		final Tag t = tag("34E");
		if (t != null) {
			return new Field34E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37G, 
	 * or null if none is found.
	 * The first occurrence of field 37G at MT320 is expected to be the only one.
	 * 
	 * @return a Field37G object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37G getField37G() {
		final Tag t = tag("37G");
		if (t != null) {
			return new Field37G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 14D, 
	 * or null if none is found.
	 * The first occurrence of field 14D at MT320 is expected to be the only one.
	 * 
	 * @return a Field14D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field14D getField14D() {
		final Tag t = tag("14D");
		if (t != null) {
			return new Field14D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 38J, 
	 * or null if none is found.
	 * The first occurrence of field 38J at MT320 is expected to be the only one.
	 * 
	 * @return a Field38J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field38J getField38J() {
		final Tag t = tag("38J");
		if (t != null) {
			return new Field38J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39M, 
	 * or null if none is found.
	 * The first occurrence of field 39M at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15C, 
	 * or null if none is found.
	 * The first occurrence of field 15C at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 15D at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15E, 
	 * or null if none is found.
	 * The first occurrence of field 15E at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15F, 
	 * or null if none is found.
	 * The first occurrence of field 15F at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15G, 
	 * or null if none is found.
	 * The first occurrence of field 15G at MT320 is expected to be the only one.
	 * 
	 * @return a Field15G object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15G getField15G() {
		final Tag t = tag("15G");
		if (t != null) {
			return new Field15G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37L, 
	 * or null if none is found.
	 * The first occurrence of field 37L at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 33B, 
	 * or null if none is found.
	 * The first occurrence of field 33B at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 36, 
	 * or null if none is found.
	 * The first occurrence of field 36 at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 33E, 
	 * or null if none is found.
	 * The first occurrence of field 33E at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15H, 
	 * or null if none is found.
	 * The first occurrence of field 15H at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 29A, 
	 * or null if none is found.
	 * The first occurrence of field 29A at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 24D at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 84A at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 84B at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 84D at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 84J at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 85A at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 85B at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 85D at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 85J at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 88A at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 88D at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 88J at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 71F at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 26H at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 21G at MT320 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 72 at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15I, 
	 * or null if none is found.
	 * The first occurrence of field 15I at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 18A, 
	 * or null if none is found.
	 * The first occurrence of field 18A at MT320 is expected to be the only one.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 53A at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 53D at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 53J at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 86A at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 86D at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 86J at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 56A at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 56D at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 56J at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 57A at MT320 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 57D at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 57J at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 58A at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 58D at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 58J at MT320 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 34C, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 34C at MT320 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30F, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 30F at MT320 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32H at MT320 are expected at one sequence or across several sequences.
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
	 * Class to model Sequence "A" in MT 320.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceA extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
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
	 * Class to model Sequence "B" in MT 320.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceB extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
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
	 * Class to model Sequence "C" in MT 320.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceC extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
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


	/**
	 * Class to model Sequence "D" in MT 320.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceD extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
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
		public static SequenceD newInstance(final Tag... tags) {
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
		public static SequenceD newInstance(final SwiftTagListBlock... sequences) {
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
	 * Class to model Sequence "E" in MT 320.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceE extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
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
		public static SequenceE newInstance(final Tag... tags) {
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
		public static SequenceE newInstance(final SwiftTagListBlock... sequences) {
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
	 * Class to model Sequence "F" in MT 320.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceF extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
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
		public static SequenceF newInstance(final Tag... tags) {
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
		public static SequenceF newInstance(final SwiftTagListBlock... sequences) {
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
	 * Class to model Sequence "G" in MT 320.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceG extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
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
		public static SequenceG newInstance(final Tag... tags) {
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
		public static SequenceG newInstance(final SwiftTagListBlock... sequences) {
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
	 * Get the single occurrence of SequenceG using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @since 7.7
	 * @return a new sequence that may be empty, <em>never returns null</em>
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceG getSequenceG() {
		return getSequenceG(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceG using field field 15 as sequence boundary.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 *
	 * @param parentSequence a not null parent sequence to find SequenceG within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceG getSequenceG(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("G")) {
			return new SequenceG(map.get("G"));
		}
		return new SequenceG();
	}


	/**
	 * Class to model Sequence "H" in MT 320.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceH extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
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
		public static SequenceH newInstance(final Tag... tags) {
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
		public static SequenceH newInstance(final SwiftTagListBlock... sequences) {
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
	 * Class to model Sequence "I" in MT 320.
	 */
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceI extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
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
		public static SequenceI newInstance(final Tag... tags) {
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
		public static SequenceI newInstance(final SwiftTagListBlock... sequences) {
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




}

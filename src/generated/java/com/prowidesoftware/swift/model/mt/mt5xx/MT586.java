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
package com.prowidesoftware.swift.model.mt.mt5xx;



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
 * <strong>MT 586 - Statement of Settlement Allegements</strong>
 *
 * <p>
 * SWIFT MT586 (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="sequence">
Sequence A - General Information (M)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 28 E (M)</li>
<li class="field">Field 13 A,J (O)</li>
<li class="field">Field 20 C (O)</li>
<li class="field">Field 23 G (M)</li>
<li class="fieldset">
Fieldset 98
 (M) (repetitive)<ul><li>FieldsetItem 98 A,C,E (O)</li><li>FieldsetItem 98 A,C (M)</li></ul></li><li class="fieldset">
Fieldset 22
 (O)<ul><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="sequence">
Sequence A1 - Linkages (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 13 A,B (O)</li>
<li class="field">Field 20 C (M)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="fieldset">
Fieldset 95
 (O)<ul><li>FieldsetItem 95 P,Q,R (O)</li><li>FieldsetItem 95 L (O)</li></ul></li><li class="field">Field 97 A,B (M)</li>
<li class="field">Field 17 B (M)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence B - Allegement Details (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="sequence">
Sequence B1 - Linkages (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 13 A,B (O)</li>
<li class="field">Field 20 C,U (M)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 25 D (O)</li>
<li class="fieldset">
Fieldset 94
 (O) (repetitive)<ul><li>FieldsetItem 94 H,L (O) (repetitive)</li><li>FieldsetItem 94 B,L (O) (repetitive)</li></ul></li><li class="fieldset">
Fieldset 98
 (M) (repetitive)<ul><li>FieldsetItem 98 A,B,C (M)</li><li>FieldsetItem 98 A,B,C (O)</li></ul></li><li class="field">Field 90 A,B (O)</li>
<li class="field">Field 99 A (O)</li>
<li class="field">Field 35 B (M)</li>
<li class="sequence">
Sequence B2 - Financial Instrument Attributes (O)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 94 B (O)</li>
<li class="fieldset">
Fieldset 22
 (O)<ul><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="fieldset">
Fieldset 12
 (O)<ul><li>FieldsetItem 12 A,C (O)</li><li>FieldsetItem 12 B (O)</li><li>FieldsetItem 12 B (O)</li></ul></li><li class="field">Field 11 A (O)</li>
<li class="fieldset">
Fieldset 98
 (O)<ul><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li></ul></li><li class="fieldset">
Fieldset 92
 (O)<ul><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li></ul></li><li class="fieldset">
Fieldset 13
 (O)<ul><li>FieldsetItem 13 A,B (O)</li><li>FieldsetItem 13 B (O)</li></ul></li><li class="fieldset">
Fieldset 17
 (O)<ul><li>FieldsetItem 17 B (O)</li><li>FieldsetItem 17 B (O)</li><li>FieldsetItem 17 B (O)</li></ul></li><li class="fieldset">
Fieldset 90
 (O)<ul><li>FieldsetItem 90 A,B (O)</li><li>FieldsetItem 90 A,B (O)</li></ul></li><li class="fieldset">
Fieldset 36
 (O)<ul><li>FieldsetItem 36 B (O)</li><li>FieldsetItem 36 B (O)</li></ul></li><li class="field">Field 70 E (O)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="fieldset">
Fieldset 22
 (M) (repetitive)<ul><li>FieldsetItem 22 H (M)</li><li>FieldsetItem 22 H (M)</li><li>FieldsetItem 22 F (O) (repetitive)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="sequence">
Sequence B3 - Financial Instrument/Account (M)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 36 B (M)</li>
<li class="field">Field 70 D (O)</li>
<li class="field">Field 97 A,E (O)</li>
<li class="field">Field 94 B,C,F,L (O) (repetitive)</li>
<li class="sequence">
Sequence B3a -  (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 13 B (O)</li>
<li class="field">Field 36 B (O)</li>
<li class="field">Field 98 A,C,E (O)</li>
<li class="field">Field 90 A,B (O)</li>
<li class="field">Field 22 F (O)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence B4 - Two Leg Transaction Details (O)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 98 A,B,C (O)</li>
<li class="fieldset">
Fieldset 22
 (O)<ul><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="fieldset">
Fieldset 20
 (O)<ul><li>FieldsetItem 20 C (O)</li><li>FieldsetItem 20 C (O)</li></ul></li><li class="fieldset">
Fieldset 92
 (O)<ul><li>FieldsetItem 92 C (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li></ul></li><li class="field">Field 99 B (O)</li>
<li class="fieldset">
Fieldset 19
 (O)<ul><li>FieldsetItem 19 A (O)</li><li>FieldsetItem 19 A (O)</li></ul></li><li class="field">Field 70 C (O)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence B5 - Settlement Details (M)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 22
 (M) (repetitive)<ul><li>FieldsetItem 22 F (M)</li><li>FieldsetItem 22 F (O) (repetitive)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="sequence">
Sequence B5a - Settlement Parties (M) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 95
 (M) (repetitive)<ul><li>FieldsetItem 95 P,Q,R,C (M)</li><li>FieldsetItem 95 L,S (O) (repetitive)</li></ul></li><li class="field">Field 97 A,B (O)</li>
<li class="field">Field 98 A,C (O)</li>
<li class="field">Field 20 C (O)</li>
<li class="fieldset">
Fieldset 70
 (O)<ul><li>FieldsetItem 70 E (O)</li><li>FieldsetItem 70 D (O)</li><li>FieldsetItem 70 C (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence B5b - Amounts (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 19
 (M) (repetitive)<ul><li>FieldsetItem 19 A (M)</li><li>FieldsetItem 19 A (O)</li></ul></li><li class="field">Field 98 A,C (O)</li>
<li class="field">Field 92 B (O)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence C - Additional Information (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 95
 (O) (repetitive)<ul><li>FieldsetItem 95 P,Q,R (O)</li><li>FieldsetItem 95 P,Q,R (O)</li><li>FieldsetItem 95 C,P,Q,R (O)</li><li>FieldsetItem 95 P,Q,R (O)</li><li>FieldsetItem 95 P,Q,R (O)</li><li>FieldsetItem 95 L,S (O) (repetitive)</li><li>FieldsetItem 95 P,Q,R (O)</li><li>FieldsetItem 95 P,Q,R (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT586 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT586.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "586";

	/**
	 * Creates an MT586 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT586 content
	 */
	public MT586(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT586 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT586 content, the parameter can not be null
	 * @see #MT586(String)
	 */
	public MT586(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT586 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT586 content
	 * @return the created object or null if the parameter is null
	 * @see #MT586(String)
	 * @since 7.7
	 */
	public static MT586 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT586(m);
	}
	
	/**
	 * Creates and initializes a new MT586 input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT586() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT586 input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT586(final String sender, final String receiver) {
		super(586, sender, receiver);
	}
	
	/**
	 * Creates a new MT586 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT586(final String fin) {
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
			log.warning("Creating an MT586 object from FIN content with a Service Message. Check if the MT586 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT586 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT586 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT586 will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT586 or null if fin is null 
	 * @since 7.7
	 */
	public static MT586 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT586(fin);
    }
    
    /**
	 * Creates a new MT586 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT586(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT586 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT586 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT586 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT586(stream);
    }
    
    /**
	 * Creates a new MT586 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT586(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT586 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT586 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT586 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT586(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "586";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT586 append(final SwiftTagListBlock block) {
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
	public MT586 append(final Tag ... tags) {
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
	public MT586 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT586 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT586 message
	 * @return a new instance of MT586
	 * @since 7.10.3
	 */
	public final static MT586 fromJson(String json) {
		return (MT586) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 28E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 28E at MT586 is expected to be the only one.
	 * 
	 * @return a Field28E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field28E getField28E() {
		final Tag t = tag("28E");
		if (t != null) {
			return new Field28E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 13J, 
	 * or null if none is found.<br>
	 * The first occurrence of field 13J at MT586 is expected to be the only one.
	 * 
	 * @return a Field13J object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field13J getField13J() {
		final Tag t = tag("13J");
		if (t != null) {
			return new Field13J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23G, 
	 * or null if none is found.<br>
	 * The first occurrence of field 23G at MT586 is expected to be the only one.
	 * 
	 * @return a Field23G object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23G getField23G() {
		final Tag t = tag("23G");
		if (t != null) {
			return new Field23G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 11A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 11A at MT586 is expected to be the only one.
	 * 
	 * @return a Field11A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field11A getField11A() {
		final Tag t = tag("11A");
		if (t != null) {
			return new Field11A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 97E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 97E at MT586 is expected to be the only one.
	 * 
	 * @return a Field97E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field97E getField97E() {
		final Tag t = tag("97E");
		if (t != null) {
			return new Field97E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 99B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 99B at MT586 is expected to be the only one.
	 * 
	 * @return a Field99B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field99B getField99B() {
		final Tag t = tag("99B");
		if (t != null) {
			return new Field99B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 98A at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98A> getField98A() {
		final List<Field98A> result = new ArrayList<>();
		final Tag[] tags = tags("98A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field98A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 98C at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98C> getField98C() {
		final List<Field98C> result = new ArrayList<>();
		final Tag[] tags = tags("98C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field98C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 98E at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98E> getField98E() {
		final List<Field98E> result = new ArrayList<>();
		final Tag[] tags = tags("98E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field98E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22F at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22F> getField22F() {
		final List<Field22F> result = new ArrayList<>();
		final Tag[] tags = tags("22F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 16R at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field16R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field16R> getField16R() {
		final List<Field16R> result = new ArrayList<>();
		final Tag[] tags = tags("16R");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field16R(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 13A at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field13A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field13A> getField13A() {
		final List<Field13A> result = new ArrayList<>();
		final Tag[] tags = tags("13A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field13A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 13B at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field13B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field13B> getField13B() {
		final List<Field13B> result = new ArrayList<>();
		final Tag[] tags = tags("13B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field13B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 20C at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field20C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field20C> getField20C() {
		final List<Field20C> result = new ArrayList<>();
		final Tag[] tags = tags("20C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field20C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 16S at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field16S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field16S> getField16S() {
		final List<Field16S> result = new ArrayList<>();
		final Tag[] tags = tags("16S");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field16S(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95P at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95P> getField95P() {
		final List<Field95P> result = new ArrayList<>();
		final Tag[] tags = tags("95P");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95P(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95Q, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95Q at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95Q objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95Q> getField95Q() {
		final List<Field95Q> result = new ArrayList<>();
		final Tag[] tags = tags("95Q");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95Q(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95R at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95R> getField95R() {
		final List<Field95R> result = new ArrayList<>();
		final Tag[] tags = tags("95R");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95R(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95L at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95L> getField95L() {
		final List<Field95L> result = new ArrayList<>();
		final Tag[] tags = tags("95L");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95L(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20U, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 20U at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field20U objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field20U> getField20U() {
		final List<Field20U> result = new ArrayList<>();
		final Tag[] tags = tags("20U");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field20U(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 25D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 25D at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field25D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field25D> getField25D() {
		final List<Field25D> result = new ArrayList<>();
		final Tag[] tags = tags("25D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field25D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 94B at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94B> getField94B() {
		final List<Field94B> result = new ArrayList<>();
		final Tag[] tags = tags("94B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field94B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 94H at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94H> getField94H() {
		final List<Field94H> result = new ArrayList<>();
		final Tag[] tags = tags("94H");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field94H(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 94L at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94L> getField94L() {
		final List<Field94L> result = new ArrayList<>();
		final Tag[] tags = tags("94L");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field94L(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 98B at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98B> getField98B() {
		final List<Field98B> result = new ArrayList<>();
		final Tag[] tags = tags("98B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field98B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 90A at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90A> getField90A() {
		final List<Field90A> result = new ArrayList<>();
		final Tag[] tags = tags("90A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field90A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 90B at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90B> getField90B() {
		final List<Field90B> result = new ArrayList<>();
		final Tag[] tags = tags("90B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field90B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 99A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 99A at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field99A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field99A> getField99A() {
		final List<Field99A> result = new ArrayList<>();
		final Tag[] tags = tags("99A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field99A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 35B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 35B at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field35B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field35B> getField35B() {
		final List<Field35B> result = new ArrayList<>();
		final Tag[] tags = tags("35B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field35B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 12A at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12A> getField12A() {
		final List<Field12A> result = new ArrayList<>();
		final Tag[] tags = tags("12A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field12A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 12C at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12C> getField12C() {
		final List<Field12C> result = new ArrayList<>();
		final Tag[] tags = tags("12C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field12C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 12B at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12B> getField12B() {
		final List<Field12B> result = new ArrayList<>();
		final Tag[] tags = tags("12B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field12B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92A at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92A> getField92A() {
		final List<Field92A> result = new ArrayList<>();
		final Tag[] tags = tags("92A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 17B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 17B at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field17B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field17B> getField17B() {
		final List<Field17B> result = new ArrayList<>();
		final Tag[] tags = tags("17B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field17B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 36B at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field36B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field36B> getField36B() {
		final List<Field36B> result = new ArrayList<>();
		final Tag[] tags = tags("36B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field36B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22H at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22H> getField22H() {
		final List<Field22H> result = new ArrayList<>();
		final Tag[] tags = tags("22H");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22H(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 97A at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97A> getField97A() {
		final List<Field97A> result = new ArrayList<>();
		final Tag[] tags = tags("97A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field97A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 94C at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94C> getField94C() {
		final List<Field94C> result = new ArrayList<>();
		final Tag[] tags = tags("94C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field94C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 94F at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94F> getField94F() {
		final List<Field94F> result = new ArrayList<>();
		final Tag[] tags = tags("94F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field94F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92C at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92C> getField92C() {
		final List<Field92C> result = new ArrayList<>();
		final Tag[] tags = tags("92C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 19A at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field19A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field19A> getField19A() {
		final List<Field19A> result = new ArrayList<>();
		final Tag[] tags = tags("19A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field19A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95C at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95C> getField95C() {
		final List<Field95C> result = new ArrayList<>();
		final Tag[] tags = tags("95C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95S at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95S> getField95S() {
		final List<Field95S> result = new ArrayList<>();
		final Tag[] tags = tags("95S");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95S(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 97B at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97B> getField97B() {
		final List<Field97B> result = new ArrayList<>();
		final Tag[] tags = tags("97B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field97B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 70C at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70C> getField70C() {
		final List<Field70C> result = new ArrayList<>();
		final Tag[] tags = tags("70C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field70C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 70D at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70D> getField70D() {
		final List<Field70D> result = new ArrayList<>();
		final Tag[] tags = tags("70D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field70D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 70E at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70E> getField70E() {
		final List<Field70E> result = new ArrayList<>();
		final Tag[] tags = tags("70E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field70E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92B at MT586 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92B> getField92B() {
		final List<Field92B> result = new ArrayList<>();
		final Tag[] tags = tags("92B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92B(tag.getValue()));
            }
		}
		return result;
	}
	

	/**
	 * Class to model Sequence "A" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
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

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>GENL</em>
		 */
		public static final String START_END_16RS = "GENL";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceA newInstance(final Tag ... tags) {
			final SequenceA result = new SequenceA();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceA newInstance() {
			final SequenceA result = new SequenceA();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceA newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceA result = new SequenceA();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceA(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}
	/**
	 * Get the single occurrence of SequenceA delimited by 16R/16S the value of SequenceA#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @return the found sequence or an empty sequence if none is found
	 * @see SequenceA#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceA getSequenceA() {
		return new SequenceA(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	 * Get the single occurrence of SequenceA delimited by 16R/16S the value of SequenceA#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @see SequenceA#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceA within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceA getSequenceA(SwiftTagListBlock parentSequence) {
		final SequenceA s = new SequenceA();
		if (parentSequence != null) {
		    s.setTags(parentSequence.getSubBlock(SequenceA.START_END_16RS).getTags());
		}
		return s;
	}
 

	/**
	 * Class to model Sequence "A1" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	@NonUniqueSeparator
	public static class SequenceA1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceA1() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceA1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>LINK</em>
		 */
		public static final String START_END_16RS = "LINK";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
	    @NonUniqueSeparator
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceA1 newInstance(final Tag ... tags) {
			final SequenceA1 result = new SequenceA1();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceA1 newInstance() {
			final SequenceA1 result = new SequenceA1();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceA1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceA1 result = new SequenceA1();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceA1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceA1 delimited by 16R/16S with value specified in {@link SequenceA1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
     * @return the found sequences or an empty list if none is found
	 * @see SequenceA1#START_END_16RS
	 */
	@NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceA1> getSequenceA1List() {
  	    /*
		 * The delimiter LINK is not unique across all sequences, in this MT.
		 * The usual generated API for accessing this can not be used for sequence A1.
		 * So we call a special method to resolve this situation until we find a better approach.
		 */
		if (this.getSwiftMessage() == null) {
			return null;
		}
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT586GetSequenceA1List_sru2019(this);
	}
	/**
	 * Get the list of SequenceA1 delimited by 16R/16S with value specified in {@link SequenceA1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	 * @see SequenceA1#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceA1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceA1> getSequenceA1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceA1.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceA1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceA1 s = new SequenceA1();
                    s.setTags(b.getSubBlock(SequenceA1.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
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

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>ALLDET</em>
		 */
		public static final String START_END_16RS = "ALLDET";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB newInstance(final Tag ... tags) {
			final SequenceB result = new SequenceB();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceB newInstance() {
			final SequenceB result = new SequenceB();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceB newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB result = new SequenceB();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB delimited by 16R/16S with value specified in {@link SequenceB#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB> getSequenceBList() {
		return getSequenceBList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceB delimited by 16R/16S with value specified in {@link SequenceB#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB> getSequenceBList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB s = new SequenceB();
                    s.setTags(b.getSubBlock(SequenceB.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B1" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	@NonUniqueSeparator
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>LINK</em>
		 */
		public static final String START_END_16RS = "LINK";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
	    @NonUniqueSeparator
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB1 newInstance(final Tag ... tags) {
			final SequenceB1 result = new SequenceB1();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceB1 newInstance() {
			final SequenceB1 result = new SequenceB1();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceB1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB1 result = new SequenceB1();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB1 delimited by 16R/16S with value specified in {@link SequenceB1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB1#START_END_16RS
	 */
	@NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB1> getSequenceB1List() {
  	    /*
		 * The delimiter LINK is not unique across all sequences, in this MT.
		 * The usual generated API for accessing this can not be used for sequence B1.
		 * So we call a special method to resolve this situation until we find a better approach.
		 */
		if (this.getSwiftMessage() == null) {
			return null;
		}
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT586GetSequenceB1List_sru2019(this);
	}
	/**
	 * Get the list of SequenceB1 delimited by 16R/16S with value specified in {@link SequenceB1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	 * @see SequenceB1#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB1> getSequenceB1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB1.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB1 s = new SequenceB1();
                    s.setTags(b.getSubBlock(SequenceB1.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B2" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>FIA</em>
		 */
		public static final String START_END_16RS = "FIA";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB2 newInstance(final Tag ... tags) {
			final SequenceB2 result = new SequenceB2();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceB2 newInstance() {
			final SequenceB2 result = new SequenceB2();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceB2 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB2 result = new SequenceB2();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB2(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB2 delimited by 16R/16S with value specified in {@link SequenceB2#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB2#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB2> getSequenceB2List() {
		return getSequenceB2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceB2 delimited by 16R/16S with value specified in {@link SequenceB2#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB2#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB2 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB2> getSequenceB2List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB2.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB2> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB2 s = new SequenceB2();
                    s.setTags(b.getSubBlock(SequenceB2.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B3" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB3 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceB3() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB3(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>FIAC</em>
		 */
		public static final String START_END_16RS = "FIAC";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB3 newInstance(final Tag ... tags) {
			final SequenceB3 result = new SequenceB3();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceB3 newInstance() {
			final SequenceB3 result = new SequenceB3();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceB3 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB3 result = new SequenceB3();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB3(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB3 delimited by 16R/16S with value specified in {@link SequenceB3#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB3#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB3> getSequenceB3List() {
		return getSequenceB3List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceB3 delimited by 16R/16S with value specified in {@link SequenceB3#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB3#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB3 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB3> getSequenceB3List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB3.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB3> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB3 s = new SequenceB3();
                    s.setTags(b.getSubBlock(SequenceB3.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B3a" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB3a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceB3a() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB3a(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>BREAK</em>
		 */
		public static final String START_END_16RS = "BREAK";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB3a newInstance(final Tag ... tags) {
			final SequenceB3a result = new SequenceB3a();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceB3a newInstance() {
			final SequenceB3a result = new SequenceB3a();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceB3a newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB3a result = new SequenceB3a();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB3a(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB3a delimited by 16R/16S with value specified in {@link SequenceB3a#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB3a#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB3a> getSequenceB3aList() {
		return getSequenceB3aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceB3a delimited by 16R/16S with value specified in {@link SequenceB3a#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB3a#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB3a within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB3a> getSequenceB3aList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB3a.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB3a> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB3a s = new SequenceB3a();
                    s.setTags(b.getSubBlock(SequenceB3a.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B4" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB4 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceB4() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB4(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>REPO</em>
		 */
		public static final String START_END_16RS = "REPO";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB4 newInstance(final Tag ... tags) {
			final SequenceB4 result = new SequenceB4();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceB4 newInstance() {
			final SequenceB4 result = new SequenceB4();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceB4 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB4 result = new SequenceB4();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB4(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB4 delimited by 16R/16S with value specified in {@link SequenceB4#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB4#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB4> getSequenceB4List() {
		return getSequenceB4List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceB4 delimited by 16R/16S with value specified in {@link SequenceB4#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB4#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB4 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB4> getSequenceB4List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB4.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB4> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB4 s = new SequenceB4();
                    s.setTags(b.getSubBlock(SequenceB4.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B5" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB5 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceB5() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB5(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SETDET</em>
		 */
		public static final String START_END_16RS = "SETDET";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB5 newInstance(final Tag ... tags) {
			final SequenceB5 result = new SequenceB5();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceB5 newInstance() {
			final SequenceB5 result = new SequenceB5();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceB5 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB5 result = new SequenceB5();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB5(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB5 delimited by 16R/16S with value specified in {@link SequenceB5#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB5#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB5> getSequenceB5List() {
		return getSequenceB5List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceB5 delimited by 16R/16S with value specified in {@link SequenceB5#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB5#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB5 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB5> getSequenceB5List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB5.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB5> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB5 s = new SequenceB5();
                    s.setTags(b.getSubBlock(SequenceB5.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B5a" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB5a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceB5a() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB5a(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SETPRTY</em>
		 */
		public static final String START_END_16RS = "SETPRTY";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB5a newInstance(final Tag ... tags) {
			final SequenceB5a result = new SequenceB5a();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceB5a newInstance() {
			final SequenceB5a result = new SequenceB5a();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceB5a newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB5a result = new SequenceB5a();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB5a(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB5a delimited by 16R/16S with value specified in {@link SequenceB5a#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB5a#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB5a> getSequenceB5aList() {
		return getSequenceB5aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceB5a delimited by 16R/16S with value specified in {@link SequenceB5a#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB5a#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB5a within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB5a> getSequenceB5aList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB5a.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB5a> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB5a s = new SequenceB5a();
                    s.setTags(b.getSubBlock(SequenceB5a.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B5b" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB5b extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceB5b() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB5b(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>AMT</em>
		 */
		public static final String START_END_16RS = "AMT";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB5b newInstance(final Tag ... tags) {
			final SequenceB5b result = new SequenceB5b();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceB5b newInstance() {
			final SequenceB5b result = new SequenceB5b();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceB5b newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB5b result = new SequenceB5b();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB5b(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB5b delimited by 16R/16S with value specified in {@link SequenceB5b#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB5b#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB5b> getSequenceB5bList() {
		return getSequenceB5bList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceB5b delimited by 16R/16S with value specified in {@link SequenceB5b#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB5b#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB5b within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB5b> getSequenceB5bList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB5b.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB5b> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB5b s = new SequenceB5b();
                    s.setTags(b.getSubBlock(SequenceB5b.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "C" in MT 586
	 */
	@SequenceStyle(Type.GENERATED_16RS)
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

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>ADDINFO</em>
		 */
		public static final String START_END_16RS = "ADDINFO";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC newInstance(final Tag ... tags) {
			final SequenceC result = new SequenceC();
			result.append(START_TAG);
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create an empty $sequenceClassname.
		 * This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceC newInstance() {
			final SequenceC result = new SequenceC();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceC newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceC result = new SequenceC();
			result.append(START_TAG);
			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}
			result.append(END_TAG);
			return result;
		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceC(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceC delimited by 16R/16S with value specified in {@link SequenceC#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceC#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC> getSequenceCList() {
		return getSequenceCList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceC delimited by 16R/16S with value specified in {@link SequenceC#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceC#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceC within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC> getSequenceCList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceC> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceC s = new SequenceC();
                    s.setTags(b.getSubBlock(SequenceC.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 



}

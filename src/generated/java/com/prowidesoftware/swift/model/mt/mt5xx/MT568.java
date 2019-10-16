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
 * <strong>MT 568 - Corporate Action Narrative</strong>
 *
 * <p>
 * SWIFT MT568 (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="sequence">
Sequence A - General Information (M)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 28 E (O)</li>
<li class="fieldset">
Fieldset 20
 (M) (repetitive)<ul><li>FieldsetItem 20 C (M)</li><li>FieldsetItem 20 C (M)</li><li>FieldsetItem 20 C (O)</li></ul></li><li class="field">Field 23 G (M)</li>
<li class="field">Field 22 F (M)</li>
<li class="field">Field 98 A,C (O)</li>
<li class="sequence">
Sequence A1 - Linkages (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 22 F (O)</li>
<li class="field">Field 13 A,B (O)</li>
<li class="field">Field 20 C (M)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence B - Underlying Securities (M)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 95 P,R (O)</li>
<li class="field">Field 97 A,C (M)</li>
<li class="field">Field 94 B,C,F (O)</li>
<li class="field">Field 35 B (O)</li>
<li class="sequence">
Sequence B1 - Financial Instrument Attributes (O)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 94 B (O)</li>
<li class="field">Field 22 F (O)</li>
<li class="field">Field 12 A,C (O)</li>
<li class="field">Field 11 A (O)</li>
<li class="fieldset">
Fieldset 98
 (O)<ul><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li></ul></li><li class="fieldset">
Fieldset 92
 (O)<ul><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li></ul></li><li class="fieldset">
Fieldset 36
 (O)<ul><li>FieldsetItem 36 B (O)</li><li>FieldsetItem 36 B (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
<li class="fieldset">
Fieldset 93
 (O) (repetitive)<ul><li>FieldsetItem 93 B (O) (repetitive)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O) (repetitive)</li><li>FieldsetItem 93 B,C (O) (repetitive)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence C - Additional Information (M)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 70
 (O) (repetitive)<ul><li>FieldsetItem 70 E,F (O) (repetitive)</li><li>FieldsetItem 70 E,F (O) (repetitive)</li><li>FieldsetItem 70 E,F (O) (repetitive)</li><li>FieldsetItem 70 E,F (O) (repetitive)</li><li>FieldsetItem 70 E (O) (repetitive)</li><li>FieldsetItem 70 E,F (O) (repetitive)</li><li>FieldsetItem 70 E,F (O) (repetitive)</li><li>FieldsetItem 70 E,F (O) (repetitive)</li><li>FieldsetItem 70 E,F (O) (repetitive)</li><li>FieldsetItem 70 E,F (O) (repetitive)</li></ul></li><li class="fieldset">
Fieldset 95
 (O) (repetitive)<ul><li>FieldsetItem 95 P,Q,R (O)</li><li>FieldsetItem 95 P,Q,R (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT568 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT568.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "568";

	/**
	 * Creates an MT568 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT568 content
	 */
	public MT568(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT568 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT568 content, the parameter can not be null
	 * @see #MT568(String)
	 */
	public MT568(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT568 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT568 content
	 * @return the created object or null if the parameter is null
	 * @see #MT568(String)
	 * @since 7.7
	 */
	public static MT568 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT568(m);
	}
	
	/**
	 * Creates and initializes a new MT568 input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT568() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT568 input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT568(final String sender, final String receiver) {
		super(568, sender, receiver);
	}
	
	/**
	 * Creates a new MT568 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT568(final String fin) {
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
			log.warning("Creating an MT568 object from FIN content with a Service Message. Check if the MT568 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT568 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT568 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT568 will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT568 or null if fin is null 
	 * @since 7.7
	 */
	public static MT568 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT568(fin);
    }
    
    /**
	 * Creates a new MT568 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT568(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT568 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT568 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT568 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT568(stream);
    }
    
    /**
	 * Creates a new MT568 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT568(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT568 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT568 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT568 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT568(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "568";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT568 append(final SwiftTagListBlock block) {
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
	public MT568 append(final Tag ... tags) {
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
	public MT568 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT568 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT568 message
	 * @return a new instance of MT568
	 * @since 7.10.3
	 */
	public final static MT568 fromJson(String json) {
		return (MT568) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 28E, 
	 * or null if none is found.<br>
	 * The first occurrence of field 28E at MT568 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 23G, 
	 * or null if none is found.<br>
	 * The first occurrence of field 23G at MT568 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 98C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 98C at MT568 is expected to be the only one.
	 * 
	 * @return a Field98C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field98C getField98C() {
		final Tag t = tag("98C");
		if (t != null) {
			return new Field98C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 97A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 97A at MT568 is expected to be the only one.
	 * 
	 * @return a Field97A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field97A getField97A() {
		final Tag t = tag("97A");
		if (t != null) {
			return new Field97A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 97C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 97C at MT568 is expected to be the only one.
	 * 
	 * @return a Field97C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field97C getField97C() {
		final Tag t = tag("97C");
		if (t != null) {
			return new Field97C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 94C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 94C at MT568 is expected to be the only one.
	 * 
	 * @return a Field94C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field94C getField94C() {
		final Tag t = tag("94C");
		if (t != null) {
			return new Field94C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 94F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 94F at MT568 is expected to be the only one.
	 * 
	 * @return a Field94F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field94F getField94F() {
		final Tag t = tag("94F");
		if (t != null) {
			return new Field94F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 35B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 35B at MT568 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 12A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 12A at MT568 is expected to be the only one.
	 * 
	 * @return a Field12A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12A getField12A() {
		final Tag t = tag("12A");
		if (t != null) {
			return new Field12A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 12C at MT568 is expected to be the only one.
	 * 
	 * @return a Field12C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12C getField12C() {
		final Tag t = tag("12C");
		if (t != null) {
			return new Field12C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 11A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 11A at MT568 is expected to be the only one.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 20C at MT568 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 16R at MT568 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22F at MT568 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 13A at MT568 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 13B at MT568 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 16S at MT568 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 94B at MT568 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 98A at MT568 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92A at MT568 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 36B at MT568 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 93B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 93B at MT568 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field93B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field93B> getField93B() {
		final List<Field93B> result = new ArrayList<>();
		final Tag[] tags = tags("93B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field93B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 93C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 93C at MT568 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field93C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field93C> getField93C() {
		final List<Field93C> result = new ArrayList<>();
		final Tag[] tags = tags("93C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field93C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 70E at MT568 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 70F at MT568 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70F> getField70F() {
		final List<Field70F> result = new ArrayList<>();
		final Tag[] tags = tags("70F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field70F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95P at MT568 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 95Q at MT568 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 95R at MT568 are expected at one sequence or across several sequences.
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
	 * Class to model Sequence "A" in MT 568
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
	 * Class to model Sequence "A1" in MT 568
	 */
	@SequenceStyle(Type.GENERATED_16RS)
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
     * @return the found sequences or an empty list if none is found
	 * @see SequenceA1#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceA1> getSequenceA1List() {
		return getSequenceA1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceA1 delimited by 16R/16S with value specified in {@link SequenceA1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
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
	 * Class to model Sequence "B" in MT 568
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>USECU</em>
		 */
		public static final String START_END_16RS = "USECU";
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
	 * Get the single occurrence of SequenceB delimited by 16R/16S the value of SequenceB#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @return the found sequence or an empty sequence if none is found
	 * @see SequenceB#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceB getSequenceB() {
		return new SequenceB(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	 * Get the single occurrence of SequenceB delimited by 16R/16S the value of SequenceB#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @see SequenceB#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceB getSequenceB(SwiftTagListBlock parentSequence) {
		final SequenceB s = new SequenceB();
		if (parentSequence != null) {
		    s.setTags(parentSequence.getSubBlock(SequenceB.START_END_16RS).getTags());
		}
		return s;
	}
 

	/**
	 * Class to model Sequence "B1" in MT 568
	 */
	@SequenceStyle(Type.GENERATED_16RS)
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
	 * Get the single occurrence of SequenceB1 delimited by 16R/16S the value of SequenceB1#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @return the found sequence or an empty sequence if none is found
	 * @see SequenceB1#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceB1 getSequenceB1() {
		return new SequenceB1(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	 * Get the single occurrence of SequenceB1 delimited by 16R/16S the value of SequenceB1#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @see SequenceB1#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB1 within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceB1 getSequenceB1(SwiftTagListBlock parentSequence) {
		final SequenceB1 s = new SequenceB1();
		if (parentSequence != null) {
		    s.setTags(parentSequence.getSubBlock(SequenceB1.START_END_16RS).getTags());
		}
		return s;
	}
 

	/**
	 * Class to model Sequence "C" in MT 568
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
	 * Get the single occurrence of SequenceC delimited by 16R/16S the value of SequenceC#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @return the found sequence or an empty sequence if none is found
	 * @see SequenceC#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceC getSequenceC() {
		return new SequenceC(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	 * Get the single occurrence of SequenceC delimited by 16R/16S the value of SequenceC#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @see SequenceC#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceC within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceC getSequenceC(SwiftTagListBlock parentSequence) {
		final SequenceC s = new SequenceC();
		if (parentSequence != null) {
		    s.setTags(parentSequence.getSubBlock(SequenceC.START_END_16RS).getTags());
		}
		return s;
	}
 



}

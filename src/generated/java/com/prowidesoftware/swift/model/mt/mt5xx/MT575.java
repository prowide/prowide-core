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
 * MT 575 - Report of Combined Activity.
 *
 * <p>
 * SWIFT MT575 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A - General Information (M)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 28 E (M)</li>
<li class="field">Field 13 A (O)</li>
<li class="field">Field 20 C (M)</li>
<li class="field">Field 23 G (M)</li>
<li class="field">Field 98 A,C (O)</li>
<li class="field">Field 69 A,B (M)</li>
<li class="fieldset">
Fieldset 22
 (O)<ul><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="sequence">
Sequence A1 - Linkages (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 13 A,B (O)</li>
<li class="field">Field 20 C (M)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="fieldset">
Fieldset 95
 (O)<ul><li>FieldsetItem 95 P,R (O)</li><li>FieldsetItem 95 L (O)</li></ul></li><li class="field">Field 97 A,B,D (O)</li>
<li class="field">Field 17 B (M)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence B - Cash Account Activity (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 95
 (O)<ul><li>FieldsetItem 95 P,R (O)</li><li>FieldsetItem 95 L (O)</li></ul></li><li class="field">Field 97 A,E (M)</li>
<li class="sequence">
Sequence B1 - Activity Information Per Currency (M) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 11 A (M)</li>
<li class="field">Field 17 B (M)</li>
<li class="fieldset">
Fieldset 93
 (M)<ul><li>FieldsetItem 93 D (M)</li><li>FieldsetItem 93 D (M)</li></ul></li><li class="sequence">
Sequence B1a - Activity Information Per Transaction (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="sequence">
Sequence B1a1 - Linkages (M) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 13 A,B (O)</li>
<li class="field">Field 20 C,U (M)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence B1a2 - Cash Only Movement Details (O)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 19 A (M)</li>
<li class="field">Field 36 B,D (O)</li>
<li class="field">Field 35 B (O)</li>
<li class="fieldset">
Fieldset 22
 (M) (repetitive)<ul><li>FieldsetItem 22 F (M)</li><li>FieldsetItem 22 H (M)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="field">Field 98 A,B,C (M)</li>
<li class="field">Field 70 E (O)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence B1a3 - Cash and Securities Movement Details (O)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 97 A,B,D (O)</li>
<li class="fieldset">
Fieldset 19
 (M) (repetitive)<ul><li>FieldsetItem 19 A (M)</li><li>FieldsetItem 19 A (O)</li><li>FieldsetItem 19 A (O)</li></ul></li><li class="field">Field 36 B,D (M)</li>
<li class="field">Field 99 A (O)</li>
<li class="field">Field 35 B (M)</li>
<li class="fieldset">
Fieldset 22
 (M) (repetitive)<ul><li>FieldsetItem 22 F (M)</li><li>FieldsetItem 22 H (M)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O) (repetitive)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="fieldset">
Fieldset 98
 (M) (repetitive)<ul><li>FieldsetItem 98 A,C (M)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li></ul></li><li class="field">Field 25 D (O)</li>
<li class="field">Field 70 E (O)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence B1a4 - Settlement Parties (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 95
 (M) (repetitive)<ul><li>FieldsetItem 95 P,Q,R,C (M)</li><li>FieldsetItem 95 L (O)</li></ul></li><li class="field">Field 97 A,B,D (O)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence C - Free Asset Activity (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="sequence">
Sequence C1 - Linkages (M) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 13 A,B (O)</li>
<li class="field">Field 20 C,U (M)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence C2 - Transaction Details (O)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 95
 (O)<ul><li>FieldsetItem 95 P,R (O)</li><li>FieldsetItem 95 L (O)</li></ul></li><li class="field">Field 97 A,B,D (O)</li>
<li class="field">Field 36 B,D (M)</li>
<li class="field">Field 99 A (O)</li>
<li class="field">Field 35 B (M)</li>
<li class="fieldset">
Fieldset 22
 (M) (repetitive)<ul><li>FieldsetItem 22 F (M)</li><li>FieldsetItem 22 H (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O) (repetitive)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="fieldset">
Fieldset 98
 (M) (repetitive)<ul><li>FieldsetItem 98 A,C (M)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li></ul></li><li class="field">Field 25 D (O)</li>
<li class="field">Field 70 E (O)</li>
<li class="sequence">
Sequence C2a - Settlement Parties (O)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 95
 (M) (repetitive)<ul><li>FieldsetItem 95 P,Q,R,C (M)</li><li>FieldsetItem 95 L (O)</li></ul></li><li class="field">Field 97 A,B,D (O)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence D - Additional Information (O)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 95
 (O) (repetitive)<ul><li>FieldsetItem 95 P,Q,R (O)</li><li>FieldsetItem 95 P,Q,R (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2024</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT575 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT575.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "575";

	/**
	 * Creates an MT575 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT575 content
	 */
	public MT575(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT575 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT575 content, the parameter can not be null
	 * @see #MT575(String)
	 */
	public MT575(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT575 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT575 content
	 * @return the created object or null if the parameter is null
	 * @see #MT575(String)
	 * @since 7.7
	 */
	public static MT575 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT575(m);
	}
	
	/**
	 * Creates and initializes a new MT575 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT575() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT575 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT575(final String sender, final String receiver) {
		super(575, sender, receiver);
	}
	
	/**
	 * Creates a new MT575 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT575(final String fin) {
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
			log.warning("Creating an MT575 object from FIN content with a Service Message. Check if the MT575 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "575")) {
			log.warning("Creating an MT575 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT575 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT575 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT575 or null if fin is null 
	 * @since 7.7
	 */
	public static MT575 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT575(fin);
    }
    
    /**
	 * Creates a new MT575 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT575(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT575 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT575 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT575 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT575(stream);
    }
    
    /**
	 * Creates a new MT575 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT575(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT575 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT575 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT575 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT575(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "575";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT575 append(final SwiftTagListBlock block) {
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
	public MT575 append(final Tag... tags) {
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
	public MT575 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT575 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT575 message
	* @return a new instance of MT575
	* @since 7.10.3
	*/
	public static MT575 fromJson(final String json) {
		return (MT575) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 28E, 
	 * or null if none is found.
	 * The first occurrence of field 28E at MT575 is expected to be the only one.
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
	 * or null if none is found.
	 * The first occurrence of field 23G at MT575 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 69A, 
	 * or null if none is found.
	 * The first occurrence of field 69A at MT575 is expected to be the only one.
	 * 
	 * @return a Field69A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field69A getField69A() {
		final Tag t = tag("69A");
		if (t != null) {
			return new Field69A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 69B, 
	 * or null if none is found.
	 * The first occurrence of field 69B at MT575 is expected to be the only one.
	 * 
	 * @return a Field69B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field69B getField69B() {
		final Tag t = tag("69B");
		if (t != null) {
			return new Field69B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22F, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 22F at MT575 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 16R at MT575 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 13A at MT575 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 13B at MT575 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 20C at MT575 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 16S at MT575 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 95P at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95R, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 95R at MT575 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 95L at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 97A at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97E, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 97E at MT575 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97E> getField97E() {
		final List<Field97E> result = new ArrayList<>();
		final Tag[] tags = tags("97E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field97E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 11A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 11A at MT575 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field11A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field11A> getField11A() {
		final List<Field11A> result = new ArrayList<>();
		final Tag[] tags = tags("11A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field11A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 17B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 17B at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 93D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 93D at MT575 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field93D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field93D> getField93D() {
		final List<Field93D> result = new ArrayList<>();
		final Tag[] tags = tags("93D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field93D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20U, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 20U at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22H, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 22H at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 98A at MT575 are expected at one sequence or across several sequences.
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
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 98C at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 97B at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 97D at MT575 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97D> getField97D() {
		final List<Field97D> result = new ArrayList<>();
		final Tag[] tags = tags("97D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field97D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 19A at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 36B at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 36D at MT575 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field36D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field36D> getField36D() {
		final List<Field36D> result = new ArrayList<>();
		final Tag[] tags = tags("36D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field36D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 35B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 35B at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 98B at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70E, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 70E at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95C, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 95C at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95Q, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 95Q at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 99A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 99A at MT575 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 25D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 25D at MT575 are expected at one sequence or across several sequences.
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
	 * Class to model Sequence "A" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>GENL</em>.
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
		public static SequenceA newInstance(final Tag... tags) {
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
		public static SequenceA newInstance(final SwiftTagListBlock... sequences) {
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
     * Same as getSequenceA using the sequence delimiter field qualifier
     * @see SequenceA#getSequenceA()
     * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
     * @since 9.2.18
     */
    public SequenceA getSequenceGENL() {
        return getSequenceA();
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
	 * Same as getSequenceA using the sequence delimiter field qualifier
	 * @see SequenceA#getSequenceA(SwiftTagListBlock)
	 * @param parentSequence a not null parent sequence to find SequenceA within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 9.2.18
	 */
	public static SequenceA getSequenceGENL(SwiftTagListBlock parentSequence) {
		return getSequenceA(parentSequence);
	}
 

	/**
	 * Class to model Sequence "A1" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	@NonUniqueSeparator
	public static class SequenceA1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceA1() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceA1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>LINK</em>.
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
		public static SequenceA1 newInstance(final Tag... tags) {
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
		public static SequenceA1 newInstance(final SwiftTagListBlock... sequences) {
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
	 * Get the list of SequenceA1 delimited by 16R/16S with value specified in {@link SequenceA1#START_END_16RS}.
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
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT575GetSequenceA1List_sru2024(this);
	}


	/**
	 * Get the list of SequenceA1 delimited by 16R/16S with value specified in {@link SequenceA1#START_END_16RS}.
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
	 * Class to model Sequence "B" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CASHACCT</em>.
		 */
		public static final String START_END_16RS = "CASHACCT";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB newInstance(final Tag... tags) {
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
		public static SequenceB newInstance(final SwiftTagListBlock... sequences) {
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
	 * Get the list of SequenceB delimited by 16R/16S with value specified in {@link SequenceB#START_END_16RS}.
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
     * Same as getSequenceBList using the sequence delimiter field qualifier
     * @see SequenceB#getSequenceBList()
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public List<SequenceB> getSequenceCASHACCTList() {
        return getSequenceBList();
     }

	/**
	 * Get the list of SequenceB delimited by 16R/16S with value specified in {@link SequenceB#START_END_16RS}.
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
     * Same as getSequenceBList using the sequence delimiter field qualifier
     * @see SequenceB#getSequenceBList(SwiftTagListBlock)
     * @param parentSequence a not null parent sequence to find SequenceB within it
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public static List<SequenceB> getSequenceCASHACCTList(final SwiftTagListBlock parentSequence) {
        return getSequenceBList(parentSequence);
    }
 

	/**
	 * Class to model Sequence "B1" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>ACTCURR</em>.
		 */
		public static final String START_END_16RS = "ACTCURR";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB1 newInstance(final Tag... tags) {
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
		public static SequenceB1 newInstance(final SwiftTagListBlock... sequences) {
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
	 * Get the list of SequenceB1 delimited by 16R/16S with value specified in {@link SequenceB1#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB1#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB1> getSequenceB1List() {
		return getSequenceB1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}

    /**
     * Same as getSequenceB1List using the sequence delimiter field qualifier
     * @see SequenceB1#getSequenceB1List()
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public List<SequenceB1> getSequenceACTCURRList() {
        return getSequenceB1List();
     }

	/**
	 * Get the list of SequenceB1 delimited by 16R/16S with value specified in {@link SequenceB1#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
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
     * Same as getSequenceB1List using the sequence delimiter field qualifier
     * @see SequenceB1#getSequenceB1List(SwiftTagListBlock)
     * @param parentSequence a not null parent sequence to find SequenceB1 within it
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public static List<SequenceB1> getSequenceACTCURRList(final SwiftTagListBlock parentSequence) {
        return getSequenceB1List(parentSequence);
    }
 

	/**
	 * Class to model Sequence "B1a" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB1a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceB1a() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB1a(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>ACTINFO</em>.
		 */
		public static final String START_END_16RS = "ACTINFO";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB1a newInstance(final Tag... tags) {
			final SequenceB1a result = new SequenceB1a();
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
		public static SequenceB1a newInstance() {
			final SequenceB1a result = new SequenceB1a();
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
		public static SequenceB1a newInstance(final SwiftTagListBlock... sequences) {
			final SequenceB1a result = new SequenceB1a();
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
		private SequenceB1a(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB1a delimited by 16R/16S with value specified in {@link SequenceB1a#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB1a#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB1a> getSequenceB1aList() {
		return getSequenceB1aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}

    /**
     * Same as getSequenceB1aList using the sequence delimiter field qualifier
     * @see SequenceB1a#getSequenceB1aList()
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public List<SequenceB1a> getSequenceACTINFOList() {
        return getSequenceB1aList();
     }

	/**
	 * Get the list of SequenceB1a delimited by 16R/16S with value specified in {@link SequenceB1a#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB1a#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB1a within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB1a> getSequenceB1aList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB1a.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB1a> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB1a s = new SequenceB1a();
                    s.setTags(b.getSubBlock(SequenceB1a.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}

    /**
     * Same as getSequenceB1aList using the sequence delimiter field qualifier
     * @see SequenceB1a#getSequenceB1aList(SwiftTagListBlock)
     * @param parentSequence a not null parent sequence to find SequenceB1a within it
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public static List<SequenceB1a> getSequenceACTINFOList(final SwiftTagListBlock parentSequence) {
        return getSequenceB1aList(parentSequence);
    }
 

	/**
	 * Class to model Sequence "B1a1" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	@NonUniqueSeparator
	public static class SequenceB1a1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceB1a1() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB1a1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>LINK</em>.
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
		public static SequenceB1a1 newInstance(final Tag... tags) {
			final SequenceB1a1 result = new SequenceB1a1();
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
		public static SequenceB1a1 newInstance() {
			final SequenceB1a1 result = new SequenceB1a1();
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
		public static SequenceB1a1 newInstance(final SwiftTagListBlock... sequences) {
			final SequenceB1a1 result = new SequenceB1a1();
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
		private SequenceB1a1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB1a1 delimited by 16R/16S with value specified in {@link SequenceB1a1#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB1a1#START_END_16RS
	 */
	@NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB1a1> getSequenceB1a1List() {
  	    /*
		 * The delimiter LINK is not unique across all sequences, in this MT.
		 * The usual generated API for accessing this can not be used for sequence B1a1.
		 * So we call a special method to resolve this situation until we find a better approach.
		 */
		if (this.getSwiftMessage() == null) {
			return null;
		}
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT575GetSequenceB1a1List_sru2024(this);
	}


	/**
	 * Get the list of SequenceB1a1 delimited by 16R/16S with value specified in {@link SequenceB1a1#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	 * @see SequenceB1a1#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB1a1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB1a1> getSequenceB1a1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB1a1.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB1a1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB1a1 s = new SequenceB1a1();
                    s.setTags(b.getSubBlock(SequenceB1a1.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}

 

	/**
	 * Class to model Sequence "B1a2" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB1a2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceB1a2() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB1a2(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CASHDET</em>.
		 */
		public static final String START_END_16RS = "CASHDET";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB1a2 newInstance(final Tag... tags) {
			final SequenceB1a2 result = new SequenceB1a2();
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
		public static SequenceB1a2 newInstance() {
			final SequenceB1a2 result = new SequenceB1a2();
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
		public static SequenceB1a2 newInstance(final SwiftTagListBlock... sequences) {
			final SequenceB1a2 result = new SequenceB1a2();
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
		private SequenceB1a2(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB1a2 delimited by 16R/16S with value specified in {@link SequenceB1a2#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB1a2#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB1a2> getSequenceB1a2List() {
		return getSequenceB1a2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}

    /**
     * Same as getSequenceB1a2List using the sequence delimiter field qualifier
     * @see SequenceB1a2#getSequenceB1a2List()
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public List<SequenceB1a2> getSequenceCASHDETList() {
        return getSequenceB1a2List();
     }

	/**
	 * Get the list of SequenceB1a2 delimited by 16R/16S with value specified in {@link SequenceB1a2#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB1a2#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB1a2 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB1a2> getSequenceB1a2List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB1a2.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB1a2> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB1a2 s = new SequenceB1a2();
                    s.setTags(b.getSubBlock(SequenceB1a2.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}

    /**
     * Same as getSequenceB1a2List using the sequence delimiter field qualifier
     * @see SequenceB1a2#getSequenceB1a2List(SwiftTagListBlock)
     * @param parentSequence a not null parent sequence to find SequenceB1a2 within it
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public static List<SequenceB1a2> getSequenceCASHDETList(final SwiftTagListBlock parentSequence) {
        return getSequenceB1a2List(parentSequence);
    }
 

	/**
	 * Class to model Sequence "B1a3" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB1a3 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceB1a3() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB1a3(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CASHSECDET</em>.
		 */
		public static final String START_END_16RS = "CASHSECDET";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB1a3 newInstance(final Tag... tags) {
			final SequenceB1a3 result = new SequenceB1a3();
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
		public static SequenceB1a3 newInstance() {
			final SequenceB1a3 result = new SequenceB1a3();
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
		public static SequenceB1a3 newInstance(final SwiftTagListBlock... sequences) {
			final SequenceB1a3 result = new SequenceB1a3();
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
		private SequenceB1a3(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB1a3 delimited by 16R/16S with value specified in {@link SequenceB1a3#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB1a3#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB1a3> getSequenceB1a3List() {
		return getSequenceB1a3List(super.getSwiftMessageNotNullOrException().getBlock4());
	}

    /**
     * Same as getSequenceB1a3List using the sequence delimiter field qualifier
     * @see SequenceB1a3#getSequenceB1a3List()
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public List<SequenceB1a3> getSequenceCASHSECDETList() {
        return getSequenceB1a3List();
     }

	/**
	 * Get the list of SequenceB1a3 delimited by 16R/16S with value specified in {@link SequenceB1a3#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceB1a3#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB1a3 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB1a3> getSequenceB1a3List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB1a3.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB1a3> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB1a3 s = new SequenceB1a3();
                    s.setTags(b.getSubBlock(SequenceB1a3.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}

    /**
     * Same as getSequenceB1a3List using the sequence delimiter field qualifier
     * @see SequenceB1a3#getSequenceB1a3List(SwiftTagListBlock)
     * @param parentSequence a not null parent sequence to find SequenceB1a3 within it
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public static List<SequenceB1a3> getSequenceCASHSECDETList(final SwiftTagListBlock parentSequence) {
        return getSequenceB1a3List(parentSequence);
    }
 

	/**
	 * Class to model Sequence "B1a4" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	@NonUniqueSeparator
	public static class SequenceB1a4 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceB1a4() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB1a4(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SETPRTY</em>.
		 */
		public static final String START_END_16RS = "SETPRTY";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
	    @NonUniqueSeparator
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB1a4 newInstance(final Tag... tags) {
			final SequenceB1a4 result = new SequenceB1a4();
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
		public static SequenceB1a4 newInstance() {
			final SequenceB1a4 result = new SequenceB1a4();
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
		public static SequenceB1a4 newInstance(final SwiftTagListBlock... sequences) {
			final SequenceB1a4 result = new SequenceB1a4();
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
		private SequenceB1a4(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceB1a4 delimited by 16R/16S with value specified in {@link SequenceB1a4#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB1a4#START_END_16RS
	 */
	@NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB1a4> getSequenceB1a4List() {
  	    /*
		 * The delimiter SETPRTY is not unique across all sequences, in this MT.
		 * The usual generated API for accessing this can not be used for sequence B1a4.
		 * So we call a special method to resolve this situation until we find a better approach.
		 */
		if (this.getSwiftMessage() == null) {
			return null;
		}
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT575GetSequenceB1a4List_sru2024(this);
	}


	/**
	 * Get the list of SequenceB1a4 delimited by 16R/16S with value specified in {@link SequenceB1a4#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	 * @see SequenceB1a4#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB1a4 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB1a4> getSequenceB1a4List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB1a4.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB1a4> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB1a4 s = new SequenceB1a4();
                    s.setTags(b.getSubBlock(SequenceB1a4.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}

 

	/**
	 * Class to model Sequence "C" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
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

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>FREEASS</em>.
		 */
		public static final String START_END_16RS = "FREEASS";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC newInstance(final Tag... tags) {
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
		public static SequenceC newInstance(final SwiftTagListBlock... sequences) {
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
	 * Get the list of SequenceC delimited by 16R/16S with value specified in {@link SequenceC#START_END_16RS}.
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
     * Same as getSequenceCList using the sequence delimiter field qualifier
     * @see SequenceC#getSequenceCList()
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public List<SequenceC> getSequenceFREEASSList() {
        return getSequenceCList();
     }

	/**
	 * Get the list of SequenceC delimited by 16R/16S with value specified in {@link SequenceC#START_END_16RS}.
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

    /**
     * Same as getSequenceCList using the sequence delimiter field qualifier
     * @see SequenceC#getSequenceCList(SwiftTagListBlock)
     * @param parentSequence a not null parent sequence to find SequenceC within it
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public static List<SequenceC> getSequenceFREEASSList(final SwiftTagListBlock parentSequence) {
        return getSequenceCList(parentSequence);
    }
 

	/**
	 * Class to model Sequence "C1" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	@NonUniqueSeparator
	public static class SequenceC1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceC1() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceC1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>LINK</em>.
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
		public static SequenceC1 newInstance(final Tag... tags) {
			final SequenceC1 result = new SequenceC1();
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
		public static SequenceC1 newInstance() {
			final SequenceC1 result = new SequenceC1();
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
		public static SequenceC1 newInstance(final SwiftTagListBlock... sequences) {
			final SequenceC1 result = new SequenceC1();
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
		private SequenceC1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceC1 delimited by 16R/16S with value specified in {@link SequenceC1#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
     * @return the found sequences or an empty list if none is found
	 * @see SequenceC1#START_END_16RS
	 */
	@NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC1> getSequenceC1List() {
  	    /*
		 * The delimiter LINK is not unique across all sequences, in this MT.
		 * The usual generated API for accessing this can not be used for sequence C1.
		 * So we call a special method to resolve this situation until we find a better approach.
		 */
		if (this.getSwiftMessage() == null) {
			return null;
		}
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT575GetSequenceC1List_sru2024(this);
	}


	/**
	 * Get the list of SequenceC1 delimited by 16R/16S with value specified in {@link SequenceC1#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	 * @see SequenceC1#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceC1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC1> getSequenceC1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC1.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceC1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceC1 s = new SequenceC1();
                    s.setTags(b.getSubBlock(SequenceC1.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}

 

	/**
	 * Class to model Sequence "C2" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceC2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceC2() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceC2(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>TRANSDET</em>.
		 */
		public static final String START_END_16RS = "TRANSDET";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC2 newInstance(final Tag... tags) {
			final SequenceC2 result = new SequenceC2();
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
		public static SequenceC2 newInstance() {
			final SequenceC2 result = new SequenceC2();
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
		public static SequenceC2 newInstance(final SwiftTagListBlock... sequences) {
			final SequenceC2 result = new SequenceC2();
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
		private SequenceC2(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceC2 delimited by 16R/16S with value specified in {@link SequenceC2#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceC2#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC2> getSequenceC2List() {
		return getSequenceC2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}

    /**
     * Same as getSequenceC2List using the sequence delimiter field qualifier
     * @see SequenceC2#getSequenceC2List()
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public List<SequenceC2> getSequenceTRANSDETList() {
        return getSequenceC2List();
     }

	/**
	 * Get the list of SequenceC2 delimited by 16R/16S with value specified in {@link SequenceC2#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceC2#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceC2 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC2> getSequenceC2List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC2.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceC2> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceC2 s = new SequenceC2();
                    s.setTags(b.getSubBlock(SequenceC2.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}

    /**
     * Same as getSequenceC2List using the sequence delimiter field qualifier
     * @see SequenceC2#getSequenceC2List(SwiftTagListBlock)
     * @param parentSequence a not null parent sequence to find SequenceC2 within it
     * @return the found sequences or an empty list if none is found
     * @since 9.2.18
     */
     public static List<SequenceC2> getSequenceTRANSDETList(final SwiftTagListBlock parentSequence) {
        return getSequenceC2List(parentSequence);
    }
 

	/**
	 * Class to model Sequence "C2a" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	@NonUniqueSeparator
	public static class SequenceC2a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceC2a() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceC2a(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SETPRTY</em>.
		 */
		public static final String START_END_16RS = "SETPRTY";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
	    @NonUniqueSeparator
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC2a newInstance(final Tag... tags) {
			final SequenceC2a result = new SequenceC2a();
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
		public static SequenceC2a newInstance() {
			final SequenceC2a result = new SequenceC2a();
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
		public static SequenceC2a newInstance(final SwiftTagListBlock... sequences) {
			final SequenceC2a result = new SequenceC2a();
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
		private SequenceC2a(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceC2a delimited by 16R/16S with value specified in {@link SequenceC2a#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
     * @return the found sequences or an empty list if none is found
	 * @see SequenceC2a#START_END_16RS
	 */
	@NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC2a> getSequenceC2aList() {
  	    /*
		 * The delimiter SETPRTY is not unique across all sequences, in this MT.
		 * The usual generated API for accessing this can not be used for sequence C2a.
		 * So we call a special method to resolve this situation until we find a better approach.
		 */
		if (this.getSwiftMessage() == null) {
			return null;
		}
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT575GetSequenceC2aList_sru2024(this);
	}


	/**
	 * Get the list of SequenceC2a delimited by 16R/16S with value specified in {@link SequenceC2a#START_END_16RS}.
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	 * @see SequenceC2a#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceC2a within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC2a> getSequenceC2aList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC2a.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceC2a> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceC2a s = new SequenceC2a();
                    s.setTags(b.getSubBlock(SequenceC2a.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}

 

	/**
	 * Class to model Sequence "D" in MT 575.
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceD extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceD() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceD(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>ADDINFO</em>.
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
		public static SequenceD newInstance(final Tag... tags) {
			final SequenceD result = new SequenceD();
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
		public static SequenceD newInstance() {
			final SequenceD result = new SequenceD();
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
		public static SequenceD newInstance(final SwiftTagListBlock... sequences) {
			final SequenceD result = new SequenceD();
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
		private SequenceD(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}
	/**
	 * Get the single occurrence of SequenceD delimited by 16R/16S the value of SequenceD#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @return the found sequence or an empty sequence if none is found
	 * @see SequenceD#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceD getSequenceD() {
		return new SequenceD(super.getSwiftMessageNotNullOrException());
	}

    /**
     * Same as getSequenceD using the sequence delimiter field qualifier
     * @see SequenceD#getSequenceD()
     * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
     * @since 9.2.18
     */
    public SequenceD getSequenceADDINFO() {
        return getSequenceD();
    }
	
	/**
	 * Get the single occurrence of SequenceD delimited by 16R/16S the value of SequenceD#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @see SequenceD#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceD within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceD getSequenceD(SwiftTagListBlock parentSequence) {
		final SequenceD s = new SequenceD();
		if (parentSequence != null) {
		    s.setTags(parentSequence.getSubBlock(SequenceD.START_END_16RS).getTags());
		}
		return s;
	}

    /**
	 * Same as getSequenceD using the sequence delimiter field qualifier
	 * @see SequenceD#getSequenceD(SwiftTagListBlock)
	 * @param parentSequence a not null parent sequence to find SequenceD within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 9.2.18
	 */
	public static SequenceD getSequenceADDINFO(SwiftTagListBlock parentSequence) {
		return getSequenceD(parentSequence);
	}
 



}

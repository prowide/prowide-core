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
package com.prowidesoftware.swift.model.mt.mt1xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * <strong>MT 103_REMIT - Single Customer Credit Transfer</strong>
 *
 * <p>
 * SWIFT MT103_REMIT (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="field">Field 20  (M)</li>
<li class="field">Field 13 C (O) (repetitive)</li>
<li class="field">Field 23 B (M)</li>
<li class="field">Field 23 E (O) (repetitive)</li>
<li class="field">Field 26 T (O)</li>
<li class="field">Field 32 A (M)</li>
<li class="field">Field 33 B (O)</li>
<li class="field">Field 36  (O)</li>
<li class="field">Field 50 A,F,K (M)</li>
<li class="field">Field 51 A (O)</li>
<li class="field">Field 52 A,D (O)</li>
<li class="field">Field 53 A,B,D (O)</li>
<li class="field">Field 54 A,B,D (O)</li>
<li class="field">Field 55 A,B,D (O)</li>
<li class="field">Field 56 A,C,D (O)</li>
<li class="field">Field 57 A,B,C,D (O)</li>
<li class="field">Field 59 A,F,NONE (M)</li>
<li class="field">Field 71 A (M)</li>
<li class="field">Field 71 F (O) (repetitive)</li>
<li class="field">Field 71 G (O)</li>
<li class="field">Field 72  (O)</li>
<li class="field">Field 77 B (O)</li>
<li class="field">Field 77 T (M)</li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT103_REMIT extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT103_REMIT.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "103_REMIT";

	/**
	 * Creates an MT103_REMIT initialized with the parameter SwiftMessage
	 * @param m swift message with the MT103_REMIT content
	 */
	public MT103_REMIT(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT103_REMIT initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT103_REMIT content, the parameter can not be null
	 * @see #MT103_REMIT(String)
	 */
	public MT103_REMIT(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT103_REMIT initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT103_REMIT content
	 * @return the created object or null if the parameter is null
	 * @see #MT103_REMIT(String)
	 * @since 7.7
	 */
	public static MT103_REMIT parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT103_REMIT(m);
	}
	
	/**
	 * Creates and initializes a new MT103_REMIT input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT103_REMIT() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT103_REMIT input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT103_REMIT(final String sender, final String receiver) {
		super(103, sender, receiver);
		m.setVariant(com.prowidesoftware.swift.model.mt.MTVariant.REMIT);
        // initialize the SWIFT gpi service unique end to end transaction reference
        m.setUETR();
	}
	
	/**
	 * Creates a new MT103_REMIT by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT103_REMIT(final String fin) {
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
			log.warning("Creating an MT103_REMIT object from FIN content with a Service Message. Check if the MT103_REMIT you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT103_REMIT object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT103_REMIT by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT103_REMIT will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT103_REMIT or null if fin is null 
	 * @since 7.7
	 */
	public static MT103_REMIT parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT103_REMIT(fin);
    }
    
    /**
	 * Creates a new MT103_REMIT by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT103_REMIT(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT103_REMIT by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT103_REMIT or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT103_REMIT parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT103_REMIT(stream);
    }
    
    /**
	 * Creates a new MT103_REMIT by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT103_REMIT(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT103_REMIT by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT103_REMIT or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT103_REMIT parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT103_REMIT(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "103";
	}

    /**
	 * Gets the Unique End to End Transaction Reference (field 121 from block 3).
	 * <p>
	 * This field is used by the SWIFT gpi service to track payments messages.
	 *
	 * @return the UETR value or null if block3 or field 121 in block3 are not present
	 * @since 7.10.0
	 */
	public String getUETR() {
	    if (this.getSwiftMessage() == null) {
        	return null;
        } else {
            return this.getSwiftMessage().getUETR();
        }
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT103_REMIT append(final SwiftTagListBlock block) {
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
	public MT103_REMIT append(final Tag ... tags) {
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
	public MT103_REMIT append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT103_REMIT messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT103_REMIT message
	 * @return a new instance of MT103_REMIT
	 * @since 7.10.3
	 */
	public final static MT103_REMIT fromJson(String json) {
		return (MT103_REMIT) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.<br>
	 * The first occurrence of field 20 at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 23B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 23B at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field23B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23B getField23B() {
		final Tag t = tag("23B");
		if (t != null) {
			return new Field23B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 26T, 
	 * or null if none is found.<br>
	 * The first occurrence of field 26T at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field26T object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field26T getField26T() {
		final Tag t = tag("26T");
		if (t != null) {
			return new Field26T(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 32A at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field32A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field32A getField32A() {
		final Tag t = tag("32A");
		if (t != null) {
			return new Field32A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 33B at MT103_REMIT is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 36 at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 50A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 50A at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field50A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50A getField50A() {
		final Tag t = tag("50A");
		if (t != null) {
			return new Field50A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 50F at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field50F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50F getField50F() {
		final Tag t = tag("50F");
		if (t != null) {
			return new Field50F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50K, 
	 * or null if none is found.<br>
	 * The first occurrence of field 50K at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field50K object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50K getField50K() {
		final Tag t = tag("50K");
		if (t != null) {
			return new Field50K(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 51A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 51A at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 52A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 52A at MT103_REMIT is expected to be the only one.
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
	 * The first occurrence of field 52D at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 53A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 53A at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 53B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 53B at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field53B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field53B getField53B() {
		final Tag t = tag("53B");
		if (t != null) {
			return new Field53B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 53D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 53D at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 54A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 54A at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field54A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field54A getField54A() {
		final Tag t = tag("54A");
		if (t != null) {
			return new Field54A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 54B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 54B at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field54B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field54B getField54B() {
		final Tag t = tag("54B");
		if (t != null) {
			return new Field54B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 54D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 54D at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field54D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field54D getField54D() {
		final Tag t = tag("54D");
		if (t != null) {
			return new Field54D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 55A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 55A at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field55A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field55A getField55A() {
		final Tag t = tag("55A");
		if (t != null) {
			return new Field55A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 55B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 55B at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field55B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field55B getField55B() {
		final Tag t = tag("55B");
		if (t != null) {
			return new Field55B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 55D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 55D at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field55D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field55D getField55D() {
		final Tag t = tag("55D");
		if (t != null) {
			return new Field55D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 56A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 56A at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 56C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 56C at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field56C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field56C getField56C() {
		final Tag t = tag("56C");
		if (t != null) {
			return new Field56C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 56D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 56D at MT103_REMIT is expected to be the only one.
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
	 * or null if none is found.<br>
	 * The first occurrence of field 57A at MT103_REMIT is expected to be the only one.
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
	 * The first occurrence of field 57B at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 57C, 
	 * or null if none is found.<br>
	 * The first occurrence of field 57C at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field57C object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field57C getField57C() {
		final Tag t = tag("57C");
		if (t != null) {
			return new Field57C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57D, 
	 * or null if none is found.<br>
	 * The first occurrence of field 57D at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 59A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 59A at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 59F, 
	 * or null if none is found.<br>
	 * The first occurrence of field 59F at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field59F object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59F getField59F() {
		final Tag t = tag("59F");
		if (t != null) {
			return new Field59F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 59, 
	 * or null if none is found.<br>
	 * The first occurrence of field 59 at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 71A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 71A at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field71A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71A getField71A() {
		final Tag t = tag("71A");
		if (t != null) {
			return new Field71A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71G, 
	 * or null if none is found.<br>
	 * The first occurrence of field 71G at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field71G object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71G getField71G() {
		final Tag t = tag("71G");
		if (t != null) {
			return new Field71G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or null if none is found.<br>
	 * The first occurrence of field 72 at MT103_REMIT is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 77B, 
	 * or null if none is found.<br>
	 * The first occurrence of field 77B at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field77B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77B getField77B() {
		final Tag t = tag("77B");
		if (t != null) {
			return new Field77B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77T, 
	 * or null if none is found.<br>
	 * The first occurrence of field 77T at MT103_REMIT is expected to be the only one.
	 * 
	 * @return a Field77T object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77T getField77T() {
		final Tag t = tag("77T");
		if (t != null) {
			return new Field77T(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 13C at MT103_REMIT are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field13C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field13C> getField13C() {
		final List<Field13C> result = new ArrayList<>();
		final Tag[] tags = tags("13C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field13C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 23E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 23E at MT103_REMIT are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field23E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field23E> getField23E() {
		final List<Field23E> result = new ArrayList<>();
		final Tag[] tags = tags("23E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field23E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 71F at MT103_REMIT are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71F> getField71F() {
		final List<Field71F> result = new ArrayList<>();
		final Tag[] tags = tags("71F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field71F(tag.getValue()));
            }
		}
		return result;
	}
	



}

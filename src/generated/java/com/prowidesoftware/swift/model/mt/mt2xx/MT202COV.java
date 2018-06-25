/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
package com.prowidesoftware.swift.model.mt.mt2xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.apache.commons.lang.StringUtils;

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
 * <h1>MT 202COV - General Financial Institution Transfer</h1>
 * <h3>SWIFT MT202COV (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 20  (M)</li>
<li class="field">Field 21  (M)</li>
<li class="field">Field 13 C (O) (repetitive)</li>
<li class="field">Field 32 A (M)</li>
<li class="field">Field 52 A,D (O)</li>
<li class="field">Field 53 A,B,D (O)</li>
<li class="field">Field 54 A,B,D (O)</li>
<li class="field">Field 56 A,D (O)</li>
<li class="field">Field 57 A,B,D (O)</li>
<li class="field">Field 58 A,D (M)</li>
<li class="field">Field 72  (O)</li>
</ul></li>
<li class="sequence">
Sequence B (M)<ul><li class="field">Field 50 A,F,K (M)</li>
<li class="field">Field 52 A,D (O)</li>
<li class="field">Field 56 A,C,D (O)</li>
<li class="field">Field 57 A,B,C,D (O)</li>
<li class="field">Field 59 A,F,NONE (M)</li>
<li class="field">Field 70  (O)</li>
<li class="field">Field 72  (O)</li>
<li class="field">Field 33 B (O)</li>
</ul></li>
</ul></div>

 <style>
.scheme, .scheme ul, .scheme li {
     position: relative;
}
.scheme ul {
    list-style: none;
    padding-left: 32px;
}
.scheme li::before, .scheme li::after {
    content: "";
    position: absolute;
    left: -12px;
}
.scheme li::before {
    border-top: 1px solid #000;
    top: 9px;
    width: 8px;
    height: 0;
}
.scheme li::after {
    border-left: 1px solid #000;
    height: 100%;
    width: 0px;
    top: 2px;
}
.scheme ul > li:last-child::after {
    height: 8px;
}</style>

 *
 * <p>This source code is specific to release <strong>SRU 2017</strong></p> 
 * <p>For additional resources check <a href="http://www.prowidesoftware.com/resources">http://www.prowidesoftware.com/resources</a></p>
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT202COV extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2017;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT202COV.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "202COV";
	
// begin qualifiers constants	

// end qualifiers constants	

	/**
	 * Creates an MT202COV initialized with the parameter SwiftMessage
	 * @param m swift message with the MT202COV content
	 */
	public MT202COV(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT202COV initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT202COV content, the parameter can not be <code>null</code>
	 * @see #MT202COV(String)
	 */
	public MT202COV(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT202COV initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT202COV content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT202COV(String)
	 * @since 7.7
	 */
	public static MT202COV parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT202COV(m.message());
	}
	
	/**
	 * Creates and initializes a new MT202COV input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT202COV() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT202COV input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT202COV(final String sender, final String receiver) {
		super(202, sender, receiver);
		m.addBlock(new SwiftBlock3());
		m.getBlock3().append(new Tag("119", "COV"));
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT202COV(String, String)
	* @deprecated Use instead <code>new MT202COV(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT202COV(final int messageType, final String sender, final String receiver) {
		super(202, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT202COV(int, String, String)", "Use the constructor MT202COV(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT202COV by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT202COV(final String fin) {
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
			log.warning("Creating an MT202COV object from FIN content with a Service Message. Check if the MT202COV you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT202COV object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT202COV by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT202COV will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT202COV or null if fin is null 
	 * @since 7.7
	 */
	public static MT202COV parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT202COV(fin);
    }
    
    /**
	 * Creates a new MT202COV by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT202COV(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT202COV by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT202COV or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT202COV parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT202COV(stream);
    }
    
    /**
	 * Creates a new MT202COV by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT202COV(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT202COV by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT202COV or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT202COV parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT202COV(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "202";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT202COV append(final SwiftTagListBlock block) {
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
	public MT202COV append(final Tag ... tags) {
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
	public MT202COV append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT202COV messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT202COV message
	 * @return a new instance of MT202COV
	 * @since 7.10.2
	 */
	public final static MT202COV fromJson(String json) {
		return (MT202COV) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT202COV is expected to be the only one.
	 * 
	 * @return a Field20 object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 21 at MT202COV is expected to be the only one.
	 * 
	 * @return a Field21 object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 32A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32A at MT202COV is expected to be the only one.
	 * 
	 * @return a Field32A object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 53A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 53A at MT202COV is expected to be the only one.
	 * 
	 * @return a Field53A object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 53B at MT202COV is expected to be the only one.
	 * 
	 * @return a Field53B object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 53D at MT202COV is expected to be the only one.
	 * 
	 * @return a Field53D object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 54A at MT202COV is expected to be the only one.
	 * 
	 * @return a Field54A object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 54B at MT202COV is expected to be the only one.
	 * 
	 * @return a Field54B object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 54D at MT202COV is expected to be the only one.
	 * 
	 * @return a Field54D object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 58A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 58A at MT202COV is expected to be the only one.
	 * 
	 * @return a Field58A object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 58D at MT202COV is expected to be the only one.
	 * 
	 * @return a Field58D object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 50A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 50A at MT202COV is expected to be the only one.
	 * 
	 * @return a Field50A object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 50F at MT202COV is expected to be the only one.
	 * 
	 * @return a Field50F object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 50K at MT202COV is expected to be the only one.
	 * 
	 * @return a Field50K object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 56C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 56C at MT202COV is expected to be the only one.
	 * 
	 * @return a Field56C object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 57C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57C at MT202COV is expected to be the only one.
	 * 
	 * @return a Field57C object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 59A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 59A at MT202COV is expected to be the only one.
	 * 
	 * @return a Field59A object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 59F at MT202COV is expected to be the only one.
	 * 
	 * @return a Field59F object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 59 at MT202COV is expected to be the only one.
	 * 
	 * @return a Field59 object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 70, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 70 at MT202COV is expected to be the only one.
	 * 
	 * @return a Field70 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field70 getField70() {
		final Tag t = tag("70");
		if (t != null) {
			return new Field70(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 33B at MT202COV is expected to be the only one.
	 * 
	 * @return a Field33B object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 13C at MT202COV are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field13C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field13C> getField13C() {
		final List<Field13C> result = new ArrayList<Field13C>();
		final Tag[] tags = tags("13C");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field13C(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 52A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 52A at MT202COV are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field52A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field52A> getField52A() {
		final List<Field52A> result = new ArrayList<Field52A>();
		final Tag[] tags = tags("52A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field52A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 52D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 52D at MT202COV are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field52D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field52D> getField52D() {
		final List<Field52D> result = new ArrayList<Field52D>();
		final Tag[] tags = tags("52D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field52D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 56A at MT202COV are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56A> getField56A() {
		final List<Field56A> result = new ArrayList<Field56A>();
		final Tag[] tags = tags("56A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field56A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 56D at MT202COV are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56D> getField56D() {
		final List<Field56D> result = new ArrayList<Field56D>();
		final Tag[] tags = tags("56D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field56D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57A at MT202COV are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57A> getField57A() {
		final List<Field57A> result = new ArrayList<Field57A>();
		final Tag[] tags = tags("57A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field57A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57B at MT202COV are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57B> getField57B() {
		final List<Field57B> result = new ArrayList<Field57B>();
		final Tag[] tags = tags("57B");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field57B(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57D at MT202COV are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57D> getField57D() {
		final List<Field57D> result = new ArrayList<Field57D>();
		final Tag[] tags = tags("57D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field57D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 72, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 72 at MT202COV are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field72 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field72> getField72() {
		final List<Field72> result = new ArrayList<Field72>();
		final Tag[] tags = tags("72");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field72(tags[i].getValue()));
		}
		return result;
	}
	

// BaseSequenceCodeGenerator [seq=A]
	/**
	* Class for Sequence "A" of MT 202COV
	*/
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
		* First mandatory tagname of the sequence: <em>"20"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "20"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"58A", "58D"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		protected static final String[] END = { "58A", "58D"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		protected static final String[] TAIL = new String[]{ "72"   };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceA newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceA newInstance(final int start, final int end, final Tag ... tags) {
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
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* If block 4 is empty this method returns <code>null</code>.
	* @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	*/ 
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceA getSequenceA() {
		return getSequenceA(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceA delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* If block 4 is empty this method returns <code>null</code>.
	* @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceA within the complete message
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
 

// BaseSequenceCodeGenerator [seq=B]
	/**
	* Class for Sequence "B" of MT 202COV
	*/
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
		* First mandatory tagname of the sequence: <em>"50A", "50F", "50K"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "50A", "50F", "50K"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"59A", "59F", "59"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		protected static final String[] END = { "59A", "59F", "59"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		protected static final String[] TAIL = new String[]{ "70", "72", "33B"   };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceB result = new SequenceB();

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
	* Get the single occurrence of SequenceB delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* If block 4 is empty this method returns <code>null</code>.
	* @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	*/ 
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceB getSequenceB() {
		return getSequenceB(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceB delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* If block 4 is empty this method returns <code>null</code>.
	* @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceB within the complete message
	* @since 7.7
	*/ 
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceB getSequenceB(SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final SwiftTagListBlock content = parentSequence.getSubBlockDelimitedWithOptionalTail(SequenceB.START, SequenceB.END, SequenceB.TAIL);
			if (log.isLoggable(java.util.logging.Level.FINE)) {
				if (content == null) {
					log.fine("content for sequence SequenceB: is null");
				} else {
					log.fine("content for sequence SequenceB: "+content.tagNamesList());
				}
			}
			if (content == null) {
				return new SequenceB();
			} else {
				return new SequenceB(content);
			}
		}
		return null;
	}
 



}

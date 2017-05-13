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
package com.prowidesoftware.swift.model.mt.mt6xx;



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
 * <h1>MT 644 - Advice of Rate and Amount Fixing</h1>
 * <h3>SWIFT MT644 (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 20  (M)</li>
<li class="field">Field 21  (O)</li>
<li class="field">Field 27  (O)</li>
<li class="field">Field 29 A (O)</li>
<li class="field">Field 29 B (O)</li>
<li class="field">Field 88 D (M)</li>
<li class="field">Field 32 A (M)</li>
</ul></li>
<li class="sequence">
Sequence B (M) (repetitive)<ul><li class="field">Field 26 P,N (M)</li>
<li class="field">Field 31 F (M)</li>
<li class="field">Field 33 B (O)</li>
<li class="field">Field 36  (O)</li>
<li class="field">Field 37 G (M)</li>
<li class="field">Field 37 M (O)</li>
<li class="field">Field 37 R (O)</li>
<li class="field">Field 37 A,B,C,D,E,F (O)</li>
<li class="field">Field 71 C (O)</li>
<li class="field">Field 34 P,R (O)</li>
<li class="field">Field 57 A,B,D (O)</li>
<li class="field">Field 72  (O)</li>
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
 * <p>This source code is specific to release <strong>SRU 2016</strong></p> 
 * <p>For additional resources check <a href="http://www.prowidesoftware.com/resources">http://www.prowidesoftware.com/resources</a></p>
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT644 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT644.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "644";
	
// begin qualifiers constants	

// end qualifiers constants	

	/**
	 * Creates an MT644 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT644 content
	 */
	public MT644(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT644 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT644 content, the parameter can not be <code>null</code>
	 * @see #MT644(String)
	 */
	public MT644(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT644 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT644 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT644(String)
	 * @since 7.7
	 */
	public static MT644 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT644(m.message());
	}
	
	/**
	 * Creates and initializes a new MT644 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT644() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT644 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT644(final String sender, final String receiver) {
		super(644, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT644(String, String)
	* @deprecated Use instead <code>new MT644(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT644(final int messageType, final String sender, final String receiver) {
		super(644, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT644(int, String, String)", "Use the constructor MT644(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT644 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT644(final String fin) {
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
			log.warning("Creating an MT644 object from FIN content with a Service Message. Check if the MT644 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT644 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT644 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT644 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT644 or null if fin is null 
	 * @since 7.7
	 */
	public static MT644 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT644(fin);
    }
    
    /**
	 * Creates a new MT644 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT644(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT644 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT644 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT644 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT644(stream);
    }
    
    /**
	 * Creates a new MT644 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT644(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT644 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT644 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT644 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT644(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "644";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT644 append(final SwiftTagListBlock block) {
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
	public MT644 append(final Tag ... tags) {
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
	public MT644 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT644 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT644 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 27, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 27 at MT644 is expected to be the only one.
	 * 
	 * @return a Field27 object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 29A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29A at MT644 is expected to be the only one.
	 * 
	 * @return a Field29A object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 29B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29B at MT644 is expected to be the only one.
	 * 
	 * @return a Field29B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29B getField29B() {
		final Tag t = tag("29B");
		if (t != null) {
			return new Field29B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 88D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 88D at MT644 is expected to be the only one.
	 * 
	 * @return a Field88D object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 32A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32A at MT644 is expected to be the only one.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 26P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 26P at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field26P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field26P> getField26P() {
		final List<Field26P> result = new ArrayList<Field26P>();
		final Tag[] tags = tags("26P");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field26P(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 26N, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 26N at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field26N objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field26N> getField26N() {
		final List<Field26N> result = new ArrayList<Field26N>();
		final Tag[] tags = tags("26N");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field26N(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 31F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 31F at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field31F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field31F> getField31F() {
		final List<Field31F> result = new ArrayList<Field31F>();
		final Tag[] tags = tags("31F");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field31F(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 33B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 33B at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field33B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field33B> getField33B() {
		final List<Field33B> result = new ArrayList<Field33B>();
		final Tag[] tags = tags("33B");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field33B(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 36 at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field36 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field36> getField36() {
		final List<Field36> result = new ArrayList<Field36>();
		final Tag[] tags = tags("36");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field36(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37G, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37G at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37G> getField37G() {
		final List<Field37G> result = new ArrayList<Field37G>();
		final Tag[] tags = tags("37G");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field37G(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37M, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37M at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37M objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37M> getField37M() {
		final List<Field37M> result = new ArrayList<Field37M>();
		final Tag[] tags = tags("37M");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field37M(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37R at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37R> getField37R() {
		final List<Field37R> result = new ArrayList<Field37R>();
		final Tag[] tags = tags("37R");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field37R(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37A at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37A> getField37A() {
		final List<Field37A> result = new ArrayList<Field37A>();
		final Tag[] tags = tags("37A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field37A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37B at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37B> getField37B() {
		final List<Field37B> result = new ArrayList<Field37B>();
		final Tag[] tags = tags("37B");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field37B(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37C at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37C> getField37C() {
		final List<Field37C> result = new ArrayList<Field37C>();
		final Tag[] tags = tags("37C");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field37C(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37D at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37D> getField37D() {
		final List<Field37D> result = new ArrayList<Field37D>();
		final Tag[] tags = tags("37D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field37D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37E at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37E> getField37E() {
		final List<Field37E> result = new ArrayList<Field37E>();
		final Tag[] tags = tags("37E");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field37E(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37F at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37F> getField37F() {
		final List<Field37F> result = new ArrayList<Field37F>();
		final Tag[] tags = tags("37F");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field37F(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 71C at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71C> getField71C() {
		final List<Field71C> result = new ArrayList<Field71C>();
		final Tag[] tags = tags("71C");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field71C(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 34P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 34P at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field34P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field34P> getField34P() {
		final List<Field34P> result = new ArrayList<Field34P>();
		final Tag[] tags = tags("34P");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field34P(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 34R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 34R at MT644 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field34R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field34R> getField34R() {
		final List<Field34R> result = new ArrayList<Field34R>();
		final Tag[] tags = tags("34R");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field34R(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57A at MT644 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 57B at MT644 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 57D at MT644 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 72 at MT644 are expected at one sequence or across several sequences.
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
	* Class for Sequence "A" of MT 644
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
		* Last mandatory tagname of the sequence: <em>"32A"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		protected static final String[] END = { "32A"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		protected static final String[] TAIL = new String[]{  };

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
	* Class for Sequence "B" of MT 644
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
		* First mandatory tagname of the sequence: <em>"26P", "26N"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "26P", "26N"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"37G"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		protected static final String[] END = { "37G"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		protected static final String[] TAIL = new String[]{ "37M", "37R", "37A", "37B", "37C", "37D", "37E", "37F", "71C", "34P", "34R", "57A", "57B", "57D", "72"   };

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
	* Get the list of SequenceB delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceB> getSequenceBList() {
		return getSequenceBList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceB delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceB within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceB> getSequenceBList(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceB> result = new ArrayList<SequenceB>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceB.START, SequenceB.END, SequenceB.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceB(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 



}

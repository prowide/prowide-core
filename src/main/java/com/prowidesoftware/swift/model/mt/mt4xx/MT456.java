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
package com.prowidesoftware.swift.model.mt.mt4xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * <h1>MT 456 - Advice of Dishonour</h1>
 * <h3>SWIFT MT456 (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="field">Field 25  (O)</li>
<li class="field">Field 52 A,B,D (O)</li>
<li class="field">Field 72  (O)</li>
<li class="sequence">
Sequence _A (M) (repetitive)<ul><li class="field">Field 20  (M)</li>
<li class="field">Field 21  (M)</li>
<li class="field">Field 32 A,B (M)</li>
<li class="field">Field 33 D (M)</li>
<li class="field">Field 71 B (O)</li>
<li class="field">Field 77 A (M)</li>
<li class="field">Field 77 D (M)</li>
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
 * <p>This source code is specific to release <strong>SRU 2017</strong></p> 
 * <p>For additional resources check <a href="http://www.prowidesoftware.com/resources">http://www.prowidesoftware.com/resources</a></p>
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT456 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2017;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT456.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "456";
	
// begin qualifiers constants	

// end qualifiers constants	

	/**
	 * Creates an MT456 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT456 content
	 */
	public MT456(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT456 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT456 content, the parameter can not be <code>null</code>
	 * @see #MT456(String)
	 */
	public MT456(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT456 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT456 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT456(String)
	 * @since 7.7
	 */
	public static MT456 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT456(m.message());
	}
	
	/**
	 * Creates and initializes a new MT456 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT456() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT456 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT456(final String sender, final String receiver) {
		super(456, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT456(String, String)
	* @deprecated Use instead <code>new MT456(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT456(final int messageType, final String sender, final String receiver) {
		super(456, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT456(int, String, String)", "Use the constructor MT456(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT456 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT456(final String fin) {
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
			log.warning("Creating an MT456 object from FIN content with a Service Message. Check if the MT456 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT456 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT456 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT456 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT456 or null if fin is null 
	 * @since 7.7
	 */
	public static MT456 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT456(fin);
    }
    
    /**
	 * Creates a new MT456 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT456(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT456 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT456 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT456 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT456(stream);
    }
    
    /**
	 * Creates a new MT456 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT456(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT456 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT456 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT456 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT456(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "456";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT456 append(final SwiftTagListBlock block) {
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
	public MT456 append(final Tag ... tags) {
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
	public MT456 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 25, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 25 at MT456 is expected to be the only one.
	 * 
	 * @return a Field25 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field25 getField25() {
		final Tag t = tag("25");
		if (t != null) {
			return new Field25(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 52A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 52A at MT456 is expected to be the only one.
	 * 
	 * @return a Field52A object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 52B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 52B at MT456 is expected to be the only one.
	 * 
	 * @return a Field52B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field52B getField52B() {
		final Tag t = tag("52B");
		if (t != null) {
			return new Field52B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 52D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 52D at MT456 is expected to be the only one.
	 * 
	 * @return a Field52D object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 20 at MT456 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field20 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field20> getField20() {
		final List<Field20> result = new ArrayList<Field20>();
		final Tag[] tags = tags("20");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field20(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 21 at MT456 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21> getField21() {
		final List<Field21> result = new ArrayList<Field21>();
		final Tag[] tags = tags("21");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field21(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32A at MT456 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32A> getField32A() {
		final List<Field32A> result = new ArrayList<Field32A>();
		final Tag[] tags = tags("32A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field32A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32B at MT456 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32B> getField32B() {
		final List<Field32B> result = new ArrayList<Field32B>();
		final Tag[] tags = tags("32B");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field32B(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 33D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 33D at MT456 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field33D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field33D> getField33D() {
		final List<Field33D> result = new ArrayList<Field33D>();
		final Tag[] tags = tags("33D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field33D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 71B at MT456 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71B> getField71B() {
		final List<Field71B> result = new ArrayList<Field71B>();
		final Tag[] tags = tags("71B");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field71B(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 77A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 77A at MT456 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field77A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field77A> getField77A() {
		final List<Field77A> result = new ArrayList<Field77A>();
		final Tag[] tags = tags("77A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field77A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 77D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 77D at MT456 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field77D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field77D> getField77D() {
		final List<Field77D> result = new ArrayList<Field77D>();
		final Tag[] tags = tags("77D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field77D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 72, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 72 at MT456 are expected at one sequence or across several sequences.
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
	



}

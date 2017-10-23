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
package com.prowidesoftware.swift.model.mt.mt7xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * <h1>MT 740 - Authorisation to Reimburse</h1>
 * <h3>SWIFT MT740 (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="field">Field 20  (M)</li>
<li class="field">Field 25  (O)</li>
<li class="field">Field 40 F (M)</li>
<li class="field">Field 31 D (O)</li>
<li class="field">Field 58 A,D (O)</li>
<li class="field">Field 59  (O)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 39 A (O)</li>
<li class="field">Field 39 B (O)</li>
<li class="field">Field 39 C (O)</li>
<li class="field">Field 41 A,D (M)</li>
<li class="field">Field 42 C (O)</li>
<li class="field">Field 42 A,D (O)</li>
<li class="field">Field 42 M (O)</li>
<li class="field">Field 42 P (O)</li>
<li class="field">Field 71 A (O)</li>
<li class="field">Field 71 B (O)</li>
<li class="field">Field 72  (O)</li>
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
public class MT740 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2017;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT740.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "740";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value CLM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLM
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CLM = "CLM";

	/**
	* Constant for qualifier with value NOTURR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NOTURR
	* @see com.prowidesoftware.swift.SchemeConstantsN#NOTURR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String NOTURR = "NOTURR";

	/**
	* Constant for qualifier with value OUR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OUR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OUR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String OUR = "OUR";

	/**
	* Constant for qualifier with value URR_LATEST_VERSION 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.URR_LATEST_VERSION
	* @see com.prowidesoftware.swift.SchemeConstantsU#URR_LATEST_VERSION
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String URR_LATEST_VERSION = "URR_LATEST_VERSION";

// end qualifiers constants	

	/**
	 * Creates an MT740 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT740 content
	 */
	public MT740(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT740 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT740 content, the parameter can not be <code>null</code>
	 * @see #MT740(String)
	 */
	public MT740(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT740 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT740 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT740(String)
	 * @since 7.7
	 */
	public static MT740 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT740(m.message());
	}
	
	/**
	 * Creates and initializes a new MT740 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT740() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT740 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT740(final String sender, final String receiver) {
		super(740, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT740(String, String)
	* @deprecated Use instead <code>new MT740(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT740(final int messageType, final String sender, final String receiver) {
		super(740, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT740(int, String, String)", "Use the constructor MT740(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT740 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT740(final String fin) {
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
			log.warning("Creating an MT740 object from FIN content with a Service Message. Check if the MT740 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT740 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT740 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT740 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT740 or null if fin is null 
	 * @since 7.7
	 */
	public static MT740 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT740(fin);
    }
    
    /**
	 * Creates a new MT740 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT740(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT740 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT740 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT740 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT740(stream);
    }
    
    /**
	 * Creates a new MT740 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT740(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT740 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT740 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT740 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT740(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "740";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT740 append(final SwiftTagListBlock block) {
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
	public MT740 append(final Tag ... tags) {
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
	public MT740 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT740 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 25, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 25 at MT740 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 40F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 40F at MT740 is expected to be the only one.
	 * 
	 * @return a Field40F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field40F getField40F() {
		final Tag t = tag("40F");
		if (t != null) {
			return new Field40F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31D at MT740 is expected to be the only one.
	 * 
	 * @return a Field31D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31D getField31D() {
		final Tag t = tag("31D");
		if (t != null) {
			return new Field31D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 58A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 58A at MT740 is expected to be the only one.
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
	 * The first occurrence of field 58D at MT740 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 59, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 59 at MT740 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32B at MT740 is expected to be the only one.
	 * 
	 * @return a Field32B object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 39A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 39A at MT740 is expected to be the only one.
	 * 
	 * @return a Field39A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39A getField39A() {
		final Tag t = tag("39A");
		if (t != null) {
			return new Field39A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 39B at MT740 is expected to be the only one.
	 * 
	 * @return a Field39B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39B getField39B() {
		final Tag t = tag("39B");
		if (t != null) {
			return new Field39B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 39C at MT740 is expected to be the only one.
	 * 
	 * @return a Field39C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39C getField39C() {
		final Tag t = tag("39C");
		if (t != null) {
			return new Field39C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 41A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 41A at MT740 is expected to be the only one.
	 * 
	 * @return a Field41A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field41A getField41A() {
		final Tag t = tag("41A");
		if (t != null) {
			return new Field41A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 41D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 41D at MT740 is expected to be the only one.
	 * 
	 * @return a Field41D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field41D getField41D() {
		final Tag t = tag("41D");
		if (t != null) {
			return new Field41D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 42C at MT740 is expected to be the only one.
	 * 
	 * @return a Field42C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42C getField42C() {
		final Tag t = tag("42C");
		if (t != null) {
			return new Field42C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 42A at MT740 is expected to be the only one.
	 * 
	 * @return a Field42A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42A getField42A() {
		final Tag t = tag("42A");
		if (t != null) {
			return new Field42A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 42D at MT740 is expected to be the only one.
	 * 
	 * @return a Field42D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42D getField42D() {
		final Tag t = tag("42D");
		if (t != null) {
			return new Field42D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42M, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 42M at MT740 is expected to be the only one.
	 * 
	 * @return a Field42M object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42M getField42M() {
		final Tag t = tag("42M");
		if (t != null) {
			return new Field42M(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 42P at MT740 is expected to be the only one.
	 * 
	 * @return a Field42P object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42P getField42P() {
		final Tag t = tag("42P");
		if (t != null) {
			return new Field42P(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 71A at MT740 is expected to be the only one.
	 * 
	 * @return a Field71A object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 71B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 71B at MT740 is expected to be the only one.
	 * 
	 * @return a Field71B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71B getField71B() {
		final Tag t = tag("71B");
		if (t != null) {
			return new Field71B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 72 at MT740 is expected to be the only one.
	 * 
	 * @return a Field72 object or <code>null</code> if the field is not found
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
	



}

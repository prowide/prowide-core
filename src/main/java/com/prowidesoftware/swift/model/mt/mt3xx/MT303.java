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
package com.prowidesoftware.swift.model.mt.mt3xx;



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
 * <h1>MT 303 - Forex/Currency Option Allocation Instruction</h1>
 * <h3>SWIFT MT303 (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 15 A (M)</li>
<li class="field">Field 20  (M)</li>
<li class="field">Field 21  (O)</li>
<li class="field">Field 22 A (M)</li>
<li class="field">Field 94 A (M)</li>
<li class="field">Field 22 C (M)</li>
<li class="field">Field 82 A,D,J (M)</li>
<li class="field">Field 87 A,D,J (M)</li>
<li class="field">Field 29 A (O)</li>
<li class="field">Field 72  (O)</li>
</ul></li>
<li class="sequence">
Sequence B (O)<ul><li class="field">Field 15 B (M)</li>
<li class="field">Field 30 T (M)</li>
<li class="field">Field 30 V (M)</li>
<li class="field">Field 36  (M)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 33 B (M)</li>
<li class="field">Field 77 D (O)</li>
</ul></li>
<li class="sequence">
Sequence C (O)<ul><li class="field">Field 15 C (M)</li>
<li class="field">Field 23 B (M)</li>
<li class="field">Field 17 A (M)</li>
<li class="field">Field 30 T (M)</li>
<li class="field">Field 30 X (O)</li>
<li class="field">Field 30 F (O)</li>
<li class="field">Field 29 C (M)</li>
<li class="field">Field 13 E (M)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 36 A (M)</li>
<li class="field">Field 33 B (M)</li>
<li class="field">Field 39 P (M)</li>
<li class="field">Field 30 P (M)</li>
<li class="field">Field 34 B (M)</li>
<li class="field">Field 77 D (O)</li>
</ul></li>
<li class="sequence">
Sequence D (O) (repetitive)<ul><li class="field">Field 15 D (M)</li>
<li class="field">Field 28 C (M)</li>
<li class="field">Field 21 A (M)</li>
<li class="field">Field 83 A,D,J (M)</li>
<li class="sequence">
Sequence D1 (M)<ul><li class="field">Field 32 B (M)</li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (M)</li>
</ul></li>
<li class="sequence">
Sequence D2 (M)<ul><li class="field">Field 33 B (M)</li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (M)</li>
<li class="field">Field 58 A,D,J (O)</li>
</ul></li>
<li class="sequence">
Sequence D3 (O)<ul><li class="field">Field 34 B (M)</li>
<li class="field">Field 53 A,D,J (O)</li>
<li class="field">Field 56 A,D,J (O)</li>
<li class="field">Field 57 A,D,J (M)</li>
<li class="field">Field 58 A,D,J (O)</li>
</ul></li>
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
public class MT303 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT303.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "303";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value AMNA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMNA
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMNA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String AMNA = "AMNA";

	/**
	* Constant for qualifier with value AMND 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMND
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMND
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String AMND = "AMND";

	/**
	* Constant for qualifier with value CANC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CANC
	* @see com.prowidesoftware.swift.SchemeConstantsC#CANC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CANC = "CANC";

	/**
	* Constant for qualifier with value CLAM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLAM
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLAM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CLAM = "CLAM";

	/**
	* Constant for qualifier with value CLEU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLEU
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLEU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CLEU = "CLEU";

	/**
	* Constant for qualifier with value CURR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CURR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CURR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CURR = "CURR";

	/**
	* Constant for qualifier with value DUPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DUPL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DUPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String DUPL = "DUPL";

	/**
	* Constant for qualifier with value FORX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FORX
	* @see com.prowidesoftware.swift.SchemeConstantsF#FORX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FORX = "FORX";

	/**
	* Constant for qualifier with value FXOP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FXOP
	* @see com.prowidesoftware.swift.SchemeConstantsF#FXOP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FXOP = "FXOP";

	/**
	* Constant for qualifier with value N 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.N
	* @see com.prowidesoftware.swift.SchemeConstantsN#N
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String N = "N";

	/**
	* Constant for qualifier with value NEWT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NEWT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NEWT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String NEWT = "NEWT";

	/**
	* Constant for qualifier with value PNTS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PNTS
	* @see com.prowidesoftware.swift.SchemeConstantsP#PNTS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PNTS = "PNTS";

	/**
	* Constant for qualifier with value PRCT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRCT
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRCT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PRCT = "PRCT";

	/**
	* Constant for qualifier with value PTAM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PTAM
	* @see com.prowidesoftware.swift.SchemeConstantsP#PTAM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PTAM = "PTAM";

	/**
	* Constant for qualifier with value PTEU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PTEU
	* @see com.prowidesoftware.swift.SchemeConstantsP#PTEU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PTEU = "PTEU";

	/**
	* Constant for qualifier with value Y 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsY.Y
	* @see com.prowidesoftware.swift.SchemeConstantsY#Y
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String Y = "Y";

// end qualifiers constants	

	/**
	 * Creates an MT303 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT303 content
	 */
	public MT303(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT303 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT303 content, the parameter can not be <code>null</code>
	 * @see #MT303(String)
	 */
	public MT303(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT303 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT303 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT303(String)
	 * @since 7.7
	 */
	public static MT303 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT303(m.message());
	}
	
	/**
	 * Creates and initializes a new MT303 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT303() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT303 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT303(final String sender, final String receiver) {
		super(303, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT303(String, String)
	* @deprecated Use instead <code>new MT303(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT303(final int messageType, final String sender, final String receiver) {
		super(303, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT303(int, String, String)", "Use the constructor MT303(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT303 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT303(final String fin) {
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
			log.warning("Creating an MT303 object from FIN content with a Service Message. Check if the MT303 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT303 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT303 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT303 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT303 or null if fin is null 
	 * @since 7.7
	 */
	public static MT303 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT303(fin);
    }
    
    /**
	 * Creates a new MT303 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT303(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT303 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT303 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT303 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT303(stream);
    }
    
    /**
	 * Creates a new MT303 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT303(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT303 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT303 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT303 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT303(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "303";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT303 append(final SwiftTagListBlock block) {
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
	public MT303 append(final Tag ... tags) {
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
	public MT303 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15A at MT303 is expected to be the only one.
	 * 
	 * @return a Field15A object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT303 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT303 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22A at MT303 is expected to be the only one.
	 * 
	 * @return a Field22A object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 94A at MT303 is expected to be the only one.
	 * 
	 * @return a Field94A object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22C at MT303 is expected to be the only one.
	 * 
	 * @return a Field22C object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 82A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 82A at MT303 is expected to be the only one.
	 * 
	 * @return a Field82A object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 82D at MT303 is expected to be the only one.
	 * 
	 * @return a Field82D object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 82J at MT303 is expected to be the only one.
	 * 
	 * @return a Field82J object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 87A at MT303 is expected to be the only one.
	 * 
	 * @return a Field87A object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 87D at MT303 is expected to be the only one.
	 * 
	 * @return a Field87D object or <code>null</code> if the field is not found
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
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 87J at MT303 is expected to be the only one.
	 * 
	 * @return a Field87J object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 29A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29A at MT303 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 72 at MT303 is expected to be the only one.
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
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15B at MT303 is expected to be the only one.
	 * 
	 * @return a Field15B object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 30V, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30V at MT303 is expected to be the only one.
	 * 
	 * @return a Field30V object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 36, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 36 at MT303 is expected to be the only one.
	 * 
	 * @return a Field36 object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 15C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15C at MT303 is expected to be the only one.
	 * 
	 * @return a Field15C object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 23B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23B at MT303 is expected to be the only one.
	 * 
	 * @return a Field23B object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 17A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17A at MT303 is expected to be the only one.
	 * 
	 * @return a Field17A object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 30X, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30X at MT303 is expected to be the only one.
	 * 
	 * @return a Field30X object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 30F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30F at MT303 is expected to be the only one.
	 * 
	 * @return a Field30F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30F getField30F() {
		final Tag t = tag("30F");
		if (t != null) {
			return new Field30F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29C at MT303 is expected to be the only one.
	 * 
	 * @return a Field29C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29C getField29C() {
		final Tag t = tag("29C");
		if (t != null) {
			return new Field29C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 13E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 13E at MT303 is expected to be the only one.
	 * 
	 * @return a Field13E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field13E getField13E() {
		final Tag t = tag("13E");
		if (t != null) {
			return new Field13E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 36A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 36A at MT303 is expected to be the only one.
	 * 
	 * @return a Field36A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field36A getField36A() {
		final Tag t = tag("36A");
		if (t != null) {
			return new Field36A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 39P at MT303 is expected to be the only one.
	 * 
	 * @return a Field39P object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39P getField39P() {
		final Tag t = tag("39P");
		if (t != null) {
			return new Field39P(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30P at MT303 is expected to be the only one.
	 * 
	 * @return a Field30P object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30T, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 30T at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30T objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30T> getField30T() {
		final List<Field30T> result = new ArrayList<Field30T>();
		final Tag[] tags = tags("30T");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field30T(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32B at MT303 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 33B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 33B at MT303 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 77D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 77D at MT303 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 15D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 15D at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field15D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field15D> getField15D() {
		final List<Field15D> result = new ArrayList<Field15D>();
		final Tag[] tags = tags("15D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field15D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 28C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 28C at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field28C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field28C> getField28C() {
		final List<Field28C> result = new ArrayList<Field28C>();
		final Tag[] tags = tags("28C");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field28C(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 21A at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21A> getField21A() {
		final List<Field21A> result = new ArrayList<Field21A>();
		final Tag[] tags = tags("21A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field21A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 83A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 83A at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field83A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field83A> getField83A() {
		final List<Field83A> result = new ArrayList<Field83A>();
		final Tag[] tags = tags("83A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field83A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 83D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 83D at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field83D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field83D> getField83D() {
		final List<Field83D> result = new ArrayList<Field83D>();
		final Tag[] tags = tags("83D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field83D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 83J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 83J at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field83J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field83J> getField83J() {
		final List<Field83J> result = new ArrayList<Field83J>();
		final Tag[] tags = tags("83J");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field83J(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 53A at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53A> getField53A() {
		final List<Field53A> result = new ArrayList<Field53A>();
		final Tag[] tags = tags("53A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field53A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 53D at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53D> getField53D() {
		final List<Field53D> result = new ArrayList<Field53D>();
		final Tag[] tags = tags("53D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field53D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 53J at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53J> getField53J() {
		final List<Field53J> result = new ArrayList<Field53J>();
		final Tag[] tags = tags("53J");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field53J(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 56A at MT303 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 56D at MT303 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 56J at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56J> getField56J() {
		final List<Field56J> result = new ArrayList<Field56J>();
		final Tag[] tags = tags("56J");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field56J(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57A at MT303 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57D at MT303 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57J at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57J> getField57J() {
		final List<Field57J> result = new ArrayList<Field57J>();
		final Tag[] tags = tags("57J");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field57J(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 34B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 34B at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field34B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field34B> getField34B() {
		final List<Field34B> result = new ArrayList<Field34B>();
		final Tag[] tags = tags("34B");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field34B(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 58A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 58A at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field58A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field58A> getField58A() {
		final List<Field58A> result = new ArrayList<Field58A>();
		final Tag[] tags = tags("58A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field58A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 58D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 58D at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field58D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field58D> getField58D() {
		final List<Field58D> result = new ArrayList<Field58D>();
		final Tag[] tags = tags("58D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field58D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 58J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 58J at MT303 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field58J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field58J> getField58J() {
		final List<Field58J> result = new ArrayList<Field58J>();
		final Tag[] tags = tags("58J");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field58J(tags[i].getValue()));
		}
		return result;
	}
	

// BaseSequenceCodeGenerator [seq=A]
	/**
	* Class for Sequence "A" of MT 303
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
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
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
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceA within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceA getSequenceA(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("A")) {
			return new SequenceA(map.get("A"));
		}
		return new SequenceA();
	}


// BaseSequenceCodeGenerator [seq=B]
	/**
	* Class for Sequence "B" of MT 303
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
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
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
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceB within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceB getSequenceB(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("B")) {
			return new SequenceB(map.get("B"));
		}
		return new SequenceB();
	}


// BaseSequenceCodeGenerator [seq=C]
	/**
	* Class for Sequence "C" of MT 303
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
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
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
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceC getSequenceC(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("C")) {
			return new SequenceC(map.get("C"));
		}
		return new SequenceC();
	}


// BaseSequenceCodeGenerator [seq=D]
	/**
	* Class for Sequence "D" of MT 303
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
	* Get the list of SequenceD using field field 15 as sequence boundary. 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @since 7.7
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public List<SequenceD> getSequenceDList() {
		return getSequenceDList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceD using field field 15 as sequence boundary. 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static List<SequenceD> getSequenceDList(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> ret = SwiftMessageUtils.splitByField15(parentSequence, "D");
		if (ret != null) {
			final List<SequenceD> result = new ArrayList<SequenceD>(ret.size());
			for (final SwiftTagListBlock b : ret) {
				result.add(new SequenceD(b));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}


// BaseSequenceCodeGenerator [seq=D1]
	/**
	* Class for Sequence "D1" of MT 303
	*/
	public static class SequenceD1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceD1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceD1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* First mandatory tagname of the sequence: <em>"32B"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "32B"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"57A", "57D", "57J"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		protected static final String[] END = { "57A", "57D", "57J"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		protected static final String[] TAIL = new String[]{  };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceD1 newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceD1 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceD1 result = new SequenceD1();

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
	* Get the list of SequenceD1 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceD1> getSequenceD1List() {
		return getSequenceD1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceD1 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceD1> getSequenceD1List(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceD1> result = new ArrayList<SequenceD1>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceD1.START, SequenceD1.END, SequenceD1.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceD1(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 

// BaseSequenceCodeGenerator [seq=D2]
	/**
	* Class for Sequence "D2" of MT 303
	*/
	public static class SequenceD2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceD2() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceD2(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* First mandatory tagname of the sequence: <em>"33B"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "33B"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"57A", "57D", "57J"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		protected static final String[] END = { "57A", "57D", "57J"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		protected static final String[] TAIL = new String[]{ "58A", "58D", "58J"   };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceD2 newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceD2 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceD2 result = new SequenceD2();

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
	* Get the list of SequenceD2 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceD2> getSequenceD2List() {
		return getSequenceD2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceD2 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD2 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceD2> getSequenceD2List(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceD2> result = new ArrayList<SequenceD2>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceD2.START, SequenceD2.END, SequenceD2.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceD2(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 

// BaseSequenceCodeGenerator [seq=D3]
	/**
	* Class for Sequence "D3" of MT 303
	*/
	public static class SequenceD3 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceD3() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceD3(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* First mandatory tagname of the sequence: <em>"34B"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "34B"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"57A", "57D", "57J"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		protected static final String[] END = { "57A", "57D", "57J"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		protected static final String[] TAIL = new String[]{ "58A", "58D", "58J"   };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceD3 newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceD3 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceD3 result = new SequenceD3();

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
	* Get the list of SequenceD3 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceD3> getSequenceD3List() {
		return getSequenceD3List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceD3 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD3 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceD3> getSequenceD3List(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceD3> result = new ArrayList<SequenceD3>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceD3.START, SequenceD3.END, SequenceD3.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceD3(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 



}

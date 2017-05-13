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
 * <h1>MT 256 - Advice of Non-Payment of Cheques</h1>
 * <h3>SWIFT MT256 (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 20  (M)</li>
<li class="field">Field 21  (O)</li>
</ul></li>
<li class="sequence">
Sequence B (M) (repetitive)<ul><li class="field">Field 44 A (M)</li>
<li class="field">Field 21  (O)</li>
<li class="field">Field 21 D (O)</li>
<li class="field">Field 21 E (O)</li>
<li class="field">Field 23 E (M)</li>
<li class="field">Field 32 J (M)</li>
<li class="field">Field 37 J (O)</li>
<li class="field">Field 71 G (O)</li>
<li class="field">Field 71 F (O)</li>
<li class="field">Field 71 H (O)</li>
</ul></li>
<li class="sequence">
Sequence C (M)<ul><li class="field">Field 32 A (M)</li>
<li class="field">Field 30  (O)</li>
<li class="field">Field 19  (O)</li>
<li class="field">Field 71 J (O)</li>
<li class="field">Field 71 L (O)</li>
<li class="field">Field 71 K (O)</li>
<li class="field">Field 57 A,C,D (O)</li>
<li class="field">Field 58 B (O)</li>
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
public class MT256 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT256.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "256";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value AMAM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMAM
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMAM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String AMAM = "AMAM";

	/**
	* Constant for qualifier with value AMTL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMTL
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMTL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String AMTL = "AMTL";

	/**
	* Constant for qualifier with value CLOS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLOS
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLOS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CLOS = "CLOS";

	/**
	* Constant for qualifier with value COLN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLN
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String COLN = "COLN";

	/**
	* Constant for qualifier with value DRAW 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DRAW
	* @see com.prowidesoftware.swift.SchemeConstantsD#DRAW
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String DRAW = "DRAW";

	/**
	* Constant for qualifier with value DUPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DUPL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DUPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String DUPL = "DUPL";

	/**
	* Constant for qualifier with value FRAU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FRAU
	* @see com.prowidesoftware.swift.SchemeConstantsF#FRAU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FRAU = "FRAU";

	/**
	* Constant for qualifier with value FROZ 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FROZ
	* @see com.prowidesoftware.swift.SchemeConstantsF#FROZ
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FROZ = "FROZ";

	/**
	* Constant for qualifier with value FRWD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FRWD
	* @see com.prowidesoftware.swift.SchemeConstantsF#FRWD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FRWD = "FRWD";

	/**
	* Constant for qualifier with value INCH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INCH
	* @see com.prowidesoftware.swift.SchemeConstantsI#INCH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String INCH = "INCH";

	/**
	* Constant for qualifier with value INSF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INSF
	* @see com.prowidesoftware.swift.SchemeConstantsI#INSF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String INSF = "INSF";

	/**
	* Constant for qualifier with value INSI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INSI
	* @see com.prowidesoftware.swift.SchemeConstantsI#INSI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String INSI = "INSI";

	/**
	* Constant for qualifier with value INVA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INVA
	* @see com.prowidesoftware.swift.SchemeConstantsI#INVA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String INVA = "INVA";

	/**
	* Constant for qualifier with value NELI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NELI
	* @see com.prowidesoftware.swift.SchemeConstantsN#NELI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String NELI = "NELI";

	/**
	* Constant for qualifier with value NMAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NMAT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NMAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String NMAT = "NMAT";

	/**
	* Constant for qualifier with value OTHR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String OTHR = "OTHR";

	/**
	* Constant for qualifier with value REVO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REVO
	* @see com.prowidesoftware.swift.SchemeConstantsR#REVO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String REVO = "REVO";

	/**
	* Constant for qualifier with value STLD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STLD
	* @see com.prowidesoftware.swift.SchemeConstantsS#STLD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String STLD = "STLD";

	/**
	* Constant for qualifier with value STOP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STOP
	* @see com.prowidesoftware.swift.SchemeConstantsS#STOP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String STOP = "STOP";

// end qualifiers constants	

	/**
	 * Creates an MT256 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT256 content
	 */
	public MT256(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT256 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT256 content, the parameter can not be <code>null</code>
	 * @see #MT256(String)
	 */
	public MT256(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT256 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT256 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT256(String)
	 * @since 7.7
	 */
	public static MT256 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT256(m.message());
	}
	
	/**
	 * Creates and initializes a new MT256 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT256() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT256 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT256(final String sender, final String receiver) {
		super(256, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT256(String, String)
	* @deprecated Use instead <code>new MT256(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT256(final int messageType, final String sender, final String receiver) {
		super(256, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT256(int, String, String)", "Use the constructor MT256(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT256 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT256(final String fin) {
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
			log.warning("Creating an MT256 object from FIN content with a Service Message. Check if the MT256 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT256 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT256 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT256 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT256 or null if fin is null 
	 * @since 7.7
	 */
	public static MT256 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT256(fin);
    }
    
    /**
	 * Creates a new MT256 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT256(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT256 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT256 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT256 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT256(stream);
    }
    
    /**
	 * Creates a new MT256 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT256(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT256 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT256 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT256 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT256(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "256";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT256 append(final SwiftTagListBlock block) {
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
	public MT256 append(final Tag ... tags) {
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
	public MT256 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT256 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 32A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32A at MT256 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30 at MT256 is expected to be the only one.
	 * 
	 * @return a Field30 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30 getField30() {
		final Tag t = tag("30");
		if (t != null) {
			return new Field30(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 19, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 19 at MT256 is expected to be the only one.
	 * 
	 * @return a Field19 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field19 getField19() {
		final Tag t = tag("19");
		if (t != null) {
			return new Field19(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 71J at MT256 is expected to be the only one.
	 * 
	 * @return a Field71J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71J getField71J() {
		final Tag t = tag("71J");
		if (t != null) {
			return new Field71J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 71L at MT256 is expected to be the only one.
	 * 
	 * @return a Field71L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71L getField71L() {
		final Tag t = tag("71L");
		if (t != null) {
			return new Field71L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71K, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 71K at MT256 is expected to be the only one.
	 * 
	 * @return a Field71K object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71K getField71K() {
		final Tag t = tag("71K");
		if (t != null) {
			return new Field71K(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57A at MT256 is expected to be the only one.
	 * 
	 * @return a Field57A object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 57C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57C at MT256 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 57D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57D at MT256 is expected to be the only one.
	 * 
	 * @return a Field57D object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 58B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 58B at MT256 is expected to be the only one.
	 * 
	 * @return a Field58B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field58B getField58B() {
		final Tag t = tag("58B");
		if (t != null) {
			return new Field58B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 44A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 44A at MT256 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field44A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field44A> getField44A() {
		final List<Field44A> result = new ArrayList<Field44A>();
		final Tag[] tags = tags("44A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field44A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 21 at MT256 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 21D at MT256 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21D> getField21D() {
		final List<Field21D> result = new ArrayList<Field21D>();
		final Tag[] tags = tags("21D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field21D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 21E at MT256 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21E> getField21E() {
		final List<Field21E> result = new ArrayList<Field21E>();
		final Tag[] tags = tags("21E");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field21E(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 23E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 23E at MT256 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field23E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field23E> getField23E() {
		final List<Field23E> result = new ArrayList<Field23E>();
		final Tag[] tags = tags("23E");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field23E(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32J at MT256 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32J> getField32J() {
		final List<Field32J> result = new ArrayList<Field32J>();
		final Tag[] tags = tags("32J");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field32J(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37J at MT256 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37J> getField37J() {
		final List<Field37J> result = new ArrayList<Field37J>();
		final Tag[] tags = tags("37J");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field37J(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71G, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 71G at MT256 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71G> getField71G() {
		final List<Field71G> result = new ArrayList<Field71G>();
		final Tag[] tags = tags("71G");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field71G(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 71F at MT256 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71F> getField71F() {
		final List<Field71F> result = new ArrayList<Field71F>();
		final Tag[] tags = tags("71F");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field71F(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 71H at MT256 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71H> getField71H() {
		final List<Field71H> result = new ArrayList<Field71H>();
		final Tag[] tags = tags("71H");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field71H(tags[i].getValue()));
		}
		return result;
	}
	

// SliceHeurisitcCodeGenerator [tagnames=[44A], type=START_OF_MESSAGE, delimiterIncludedInSequence=false ]
	/**
	* Class for Sequence "A" of MT 256
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
		
	}
	/**
	* Get the single occurrence of SequenceA slicing head or tail of the tags with delimiter ${s.getTagNames().get(0)}
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: if the tag delimiter is not found this method returns <code>null</code>.</em>
	*/
	@SequenceStyle(Type.GENERATED_SLICE) // SliceHeurisitcCodeGenerator [tagnames=[44A], type=START_OF_MESSAGE, delimiterIncludedInSequence=false ]
	public SequenceA getSequenceA() {
		return getSequenceA(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceA slicing head or tail of the tags with delimiter ${s.getTagNames().get(0)}
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: if the tag delimiter is not found this method returns <code>null</code>.</em>
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceA within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_SLICE) // SliceHeurisitcCodeGenerator [tagnames=[44A], type=START_OF_MESSAGE, delimiterIncludedInSequence=false ]
	public SequenceA getSequenceA(SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			// sequence is head of message
			return new SequenceA(parentSequence.getSubBlockBeforeFirst("44A", false));
		}
		return null;
	}


// BaseSequenceCodeGenerator [seq=B]
	/**
	* Class for Sequence "B" of MT 256
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
		* First mandatory tagname of the sequence: <em>"44A"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "44A"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"32J"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		protected static final String[] END = { "32J"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		protected static final String[] TAIL = new String[]{ "37J", "71G", "71F", "71H"   };

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
 

// SliceHeurisitcCodeGenerator [tagnames=[32A], type=END_OF_MESSAGE, delimiterIncludedInSequence=true ]
	/**
	* Class for Sequence "C" of MT 256
	*/
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
		
	}
	/**
	* Get the single occurrence of SequenceC slicing head or tail of the tags with delimiter ${s.getTagNames().get(0)}
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: if the tag delimiter is not found this method returns <code>null</code>.</em>
	*/
	@SequenceStyle(Type.GENERATED_SLICE) // SliceHeurisitcCodeGenerator [tagnames=[32A], type=END_OF_MESSAGE, delimiterIncludedInSequence=true ]
	public SequenceC getSequenceC() {
		return getSequenceC(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceC slicing head or tail of the tags with delimiter ${s.getTagNames().get(0)}
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: if the tag delimiter is not found this method returns <code>null</code>.</em>
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_SLICE) // SliceHeurisitcCodeGenerator [tagnames=[32A], type=END_OF_MESSAGE, delimiterIncludedInSequence=true ]
	public SequenceC getSequenceC(SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			// sequence is tail of message
			final SwiftTagListBlock content = parentSequence.getSubBlockAfterLast("32A", true);
			if (content == null) { 
				return null; 
			} 
			return new SequenceC(content);
		}
		return null;
	}




}

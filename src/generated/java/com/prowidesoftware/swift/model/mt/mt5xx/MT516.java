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
package com.prowidesoftware.swift.model.mt.mt5xx;



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
 * <h1>MT 516 - Securities Loan Confirmation</h1>
 * <h3>SWIFT MT516 (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 20  (M)</li>
<li class="field">Field 21  (O)</li>
<li class="field">Field 23  (M)</li>
<li class="field">Field 31 P (M)</li>
<li class="field">Field 83 C (O)</li>
<li class="field">Field 35 B (M)</li>
<li class="field">Field 35 A (O)</li>
<li class="field">Field 31 L (O)</li>
<li class="field">Field 31 X (O)</li>
<li class="field">Field 30  (M)</li>
<li class="field">Field 31 F (O)</li>
<li class="field">Field 87 A,D (O)</li>
<li class="field">Field 35 N (O)</li>
<li class="field">Field 33 T (O)</li>
</ul></li>
<li class="sequence">
Sequence B (O)<ul><li class="field">Field 37 J (O)</li>
<li class="field">Field 26 H (O)</li>
<li class="field">Field 33 S (O)</li>
<li class="field">Field 32 A,B (O)</li>
<li class="field">Field 37 A,B,C,D,E,F (O)</li>
<li class="field">Field 57 A,B,D (O)</li>
<li class="field">Field 35 S (O)</li>
<li class="field">Field 35 B (O)</li>
<li class="field">Field 87 A,D (O)</li>
</ul></li>
<li class="sequence">
Sequence C (O)<ul><li class="field">Field 77 D (O)</li>
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
public class MT516 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2017;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT516.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "516";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value BON 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BON
	* @see com.prowidesoftware.swift.SchemeConstantsB#BON
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String BON = "BON";

	/**
	* Constant for qualifier with value CER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CER
	* @see com.prowidesoftware.swift.SchemeConstantsC#CER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CER = "CER";

	/**
	* Constant for qualifier with value CPN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CPN
	* @see com.prowidesoftware.swift.SchemeConstantsC#CPN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CPN = "CPN";

	/**
	* Constant for qualifier with value FMT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FMT
	* @see com.prowidesoftware.swift.SchemeConstantsF#FMT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FMT = "FMT";

	/**
	* Constant for qualifier with value MSC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MSC
	* @see com.prowidesoftware.swift.SchemeConstantsM#MSC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String MSC = "MSC";

	/**
	* Constant for qualifier with value OPC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OPC
	* @see com.prowidesoftware.swift.SchemeConstantsO#OPC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String OPC = "OPC";

	/**
	* Constant for qualifier with value OPS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OPS
	* @see com.prowidesoftware.swift.SchemeConstantsO#OPS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String OPS = "OPS";

	/**
	* Constant for qualifier with value PCT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PCT
	* @see com.prowidesoftware.swift.SchemeConstantsP#PCT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PCT = "PCT";

	/**
	* Constant for qualifier with value PRC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PRC = "PRC";

	/**
	* Constant for qualifier with value PRS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRS
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PRS = "PRS";

	/**
	* Constant for qualifier with value RTE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RTE
	* @see com.prowidesoftware.swift.SchemeConstantsR#RTE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String RTE = "RTE";

	/**
	* Constant for qualifier with value RTS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RTS
	* @see com.prowidesoftware.swift.SchemeConstantsR#RTS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String RTS = "RTS";

	/**
	* Constant for qualifier with value SHS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SHS
	* @see com.prowidesoftware.swift.SchemeConstantsS#SHS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String SHS = "SHS";

	/**
	* Constant for qualifier with value UNKNOWN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UNKNOWN
	* @see com.prowidesoftware.swift.SchemeConstantsU#UNKNOWN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String UNKNOWN = "UNKNOWN";

	/**
	* Constant for qualifier with value UNT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UNT
	* @see com.prowidesoftware.swift.SchemeConstantsU#UNT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String UNT = "UNT";

	/**
	* Constant for qualifier with value WTS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WTS
	* @see com.prowidesoftware.swift.SchemeConstantsW#WTS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String WTS = "WTS";

// end qualifiers constants	

	/**
	 * Creates an MT516 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT516 content
	 */
	public MT516(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT516 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT516 content, the parameter can not be <code>null</code>
	 * @see #MT516(String)
	 */
	public MT516(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT516 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT516 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT516(String)
	 * @since 7.7
	 */
	public static MT516 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT516(m.message());
	}
	
	/**
	 * Creates and initializes a new MT516 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT516() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT516 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT516(final String sender, final String receiver) {
		super(516, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT516(String, String)
	* @deprecated Use instead <code>new MT516(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT516(final int messageType, final String sender, final String receiver) {
		super(516, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT516(int, String, String)", "Use the constructor MT516(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT516 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT516(final String fin) {
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
			log.warning("Creating an MT516 object from FIN content with a Service Message. Check if the MT516 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT516 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT516 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT516 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT516 or null if fin is null 
	 * @since 7.7
	 */
	public static MT516 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT516(fin);
    }
    
    /**
	 * Creates a new MT516 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT516(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT516 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT516 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT516 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT516(stream);
    }
    
    /**
	 * Creates a new MT516 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT516(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT516 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT516 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT516 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT516(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "516";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT516 append(final SwiftTagListBlock block) {
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
	public MT516 append(final Tag ... tags) {
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
	public MT516 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT516 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT516 message
	 * @return a new instance of MT516
	 * @since 7.10.2
	 */
	public final static MT516 fromJson(String json) {
		return (MT516) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT516 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT516 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 23, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23 at MT516 is expected to be the only one.
	 * 
	 * @return a Field23 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23 getField23() {
		final Tag t = tag("23");
		if (t != null) {
			return new Field23(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31P at MT516 is expected to be the only one.
	 * 
	 * @return a Field31P object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31P getField31P() {
		final Tag t = tag("31P");
		if (t != null) {
			return new Field31P(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 83C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 83C at MT516 is expected to be the only one.
	 * 
	 * @return a Field83C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field83C getField83C() {
		final Tag t = tag("83C");
		if (t != null) {
			return new Field83C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 35A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 35A at MT516 is expected to be the only one.
	 * 
	 * @return a Field35A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field35A getField35A() {
		final Tag t = tag("35A");
		if (t != null) {
			return new Field35A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31L at MT516 is expected to be the only one.
	 * 
	 * @return a Field31L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31L getField31L() {
		final Tag t = tag("31L");
		if (t != null) {
			return new Field31L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31X, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31X at MT516 is expected to be the only one.
	 * 
	 * @return a Field31X object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31X getField31X() {
		final Tag t = tag("31X");
		if (t != null) {
			return new Field31X(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30 at MT516 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 31F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31F at MT516 is expected to be the only one.
	 * 
	 * @return a Field31F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31F getField31F() {
		final Tag t = tag("31F");
		if (t != null) {
			return new Field31F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 35N, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 35N at MT516 is expected to be the only one.
	 * 
	 * @return a Field35N object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field35N getField35N() {
		final Tag t = tag("35N");
		if (t != null) {
			return new Field35N(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33T, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 33T at MT516 is expected to be the only one.
	 * 
	 * @return a Field33T object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field33T getField33T() {
		final Tag t = tag("33T");
		if (t != null) {
			return new Field33T(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37J at MT516 is expected to be the only one.
	 * 
	 * @return a Field37J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37J getField37J() {
		final Tag t = tag("37J");
		if (t != null) {
			return new Field37J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 26H, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 26H at MT516 is expected to be the only one.
	 * 
	 * @return a Field26H object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field26H getField26H() {
		final Tag t = tag("26H");
		if (t != null) {
			return new Field26H(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33S, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 33S at MT516 is expected to be the only one.
	 * 
	 * @return a Field33S object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field33S getField33S() {
		final Tag t = tag("33S");
		if (t != null) {
			return new Field33S(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32A at MT516 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32B at MT516 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 37A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37A at MT516 is expected to be the only one.
	 * 
	 * @return a Field37A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37A getField37A() {
		final Tag t = tag("37A");
		if (t != null) {
			return new Field37A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37B at MT516 is expected to be the only one.
	 * 
	 * @return a Field37B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37B getField37B() {
		final Tag t = tag("37B");
		if (t != null) {
			return new Field37B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37C at MT516 is expected to be the only one.
	 * 
	 * @return a Field37C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37C getField37C() {
		final Tag t = tag("37C");
		if (t != null) {
			return new Field37C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37D at MT516 is expected to be the only one.
	 * 
	 * @return a Field37D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37D getField37D() {
		final Tag t = tag("37D");
		if (t != null) {
			return new Field37D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37E at MT516 is expected to be the only one.
	 * 
	 * @return a Field37E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37E getField37E() {
		final Tag t = tag("37E");
		if (t != null) {
			return new Field37E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37F at MT516 is expected to be the only one.
	 * 
	 * @return a Field37F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37F getField37F() {
		final Tag t = tag("37F");
		if (t != null) {
			return new Field37F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57A at MT516 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 57B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57B at MT516 is expected to be the only one.
	 * 
	 * @return a Field57B object or <code>null</code> if the field is not found
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
	 * Iterates through block4 fields and return the first one whose name matches 57D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57D at MT516 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 35S, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 35S at MT516 is expected to be the only one.
	 * 
	 * @return a Field35S object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field35S getField35S() {
		final Tag t = tag("35S");
		if (t != null) {
			return new Field35S(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 77D at MT516 is expected to be the only one.
	 * 
	 * @return a Field77D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77D getField77D() {
		final Tag t = tag("77D");
		if (t != null) {
			return new Field77D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 72 at MT516 is expected to be the only one.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 35B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 35B at MT516 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field35B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field35B> getField35B() {
		final List<Field35B> result = new ArrayList<Field35B>();
		final Tag[] tags = tags("35B");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field35B(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 87A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 87A at MT516 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field87A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field87A> getField87A() {
		final List<Field87A> result = new ArrayList<Field87A>();
		final Tag[] tags = tags("87A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field87A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 87D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 87D at MT516 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field87D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field87D> getField87D() {
		final List<Field87D> result = new ArrayList<Field87D>();
		final Tag[] tags = tags("87D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field87D(tags[i].getValue()));
		}
		return result;
	}
	

// BaseSequenceCodeGenerator [seq=A]
	/**
	* Class for Sequence "A" of MT 516
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
		* Last mandatory tagname of the sequence: <em>"30"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		protected static final String[] END = { "30"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		protected static final String[] TAIL = new String[]{ "31F", "87A", "87D", "35N", "33T"   };

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
 



}

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
 * <h1>MT 365 - Cross Currency Interest Rate Swap Termination/Recouponing Confirmation</h1>
 * <h3>SWIFT MT365 (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 15 A (M)</li>
<li class="field">Field 20  (M)</li>
<li class="field">Field 21  (O)</li>
<li class="field">Field 22 A (M)</li>
<li class="field">Field 94 A (O)</li>
<li class="field">Field 22 B (M)</li>
<li class="field">Field 22 C (M)</li>
<li class="field">Field 23 A (M)</li>
<li class="field">Field 21 N (M)</li>
<li class="field">Field 21 B (O)</li>
<li class="field">Field 30 T (M)</li>
<li class="field">Field 30 Q (M)</li>
<li class="field">Field 30 P (M)</li>
<li class="field">Field 30 V (M)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 33 B (M)</li>
<li class="field">Field 82 A,D (M)</li>
<li class="field">Field 87 A,D (M)</li>
<li class="field">Field 83 A,D,J (O)</li>
<li class="field">Field 22 D (O)</li>
<li class="field">Field 32 G (O)</li>
<li class="field">Field 33 E (O)</li>
<li class="field">Field 37 N (O)</li>
<li class="field">Field 29 A (O)</li>
<li class="field">Field 72  (O)</li>
</ul></li>
<li class="sequence">
Sequence B (O)<ul><li class="field">Field 15 B (M)</li>
<li class="field">Field 37 M (M)</li>
<li class="field">Field 37 G (O)</li>
</ul></li>
<li class="sequence">
Sequence E (O)<ul><li class="field">Field 15 E (M)</li>
<li class="field">Field 37 M (M)</li>
<li class="field">Field 37 G (O)</li>
</ul></li>
<li class="sequence">
Sequence J (O)<ul><li class="field">Field 15 J (M)</li>
<li class="field">Field 30 F (M)</li>
<li class="field">Field 32 M (M)</li>
<li class="field">Field 53 A,D (O)</li>
<li class="field">Field 56 A,D (O)</li>
<li class="field">Field 86 A,D (O)</li>
<li class="field">Field 57 A,D (M)</li>
</ul></li>
<li class="sequence">
Sequence K (O)<ul><li class="field">Field 15 K (M)</li>
<li class="field">Field 30 F (M)</li>
<li class="field">Field 32 M (M)</li>
<li class="field">Field 53 A,D (O)</li>
<li class="field">Field 56 A,D (O)</li>
<li class="field">Field 86 A,D (O)</li>
<li class="field">Field 57 A,D (M)</li>
</ul></li>
<li class="sequence">
Sequence L (O)<ul><li class="field">Field 15 L (M)</li>
<li class="field">Field 30 F (M)</li>
<li class="field">Field 32 M (M)</li>
<li class="field">Field 53 A,D (O)</li>
<li class="field">Field 56 A,D (O)</li>
<li class="field">Field 86 A,D (O)</li>
<li class="field">Field 57 A,D (M)</li>
</ul></li>
<li class="sequence">
Sequence M (O)<ul><li class="field">Field 15 M (M)</li>
<li class="field">Field 30 F (M)</li>
<li class="field">Field 32 M (M)</li>
<li class="field">Field 53 A,D (O)</li>
<li class="field">Field 56 A,D (O)</li>
<li class="field">Field 86 A,D (O)</li>
<li class="field">Field 57 A,D (M)</li>
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
public class MT365 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2017;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT365.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "365";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value AGNT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AGNT
	* @see com.prowidesoftware.swift.SchemeConstantsA#AGNT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String AGNT = "AGNT";

	/**
	* Constant for qualifier with value AMND 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMND
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMND
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String AMND = "AMND";

	/**
	* Constant for qualifier with value BILA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BILA
	* @see com.prowidesoftware.swift.SchemeConstantsB#BILA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String BILA = "BILA";

	/**
	* Constant for qualifier with value CANC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CANC
	* @see com.prowidesoftware.swift.SchemeConstantsC#CANC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CANC = "CANC";

	/**
	* Constant for qualifier with value CORRBUYER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CORRBUYER
	* @see com.prowidesoftware.swift.SchemeConstantsC#CORRBUYER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CORRBUYER = "CORRBUYER";

	/**
	* Constant for qualifier with value CORRSELLER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CORRSELLER
	* @see com.prowidesoftware.swift.SchemeConstantsC#CORRSELLER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CORRSELLER = "CORRSELLER";

	/**
	* Constant for qualifier with value DUPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DUPL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DUPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String DUPL = "DUPL";

	/**
	* Constant for qualifier with value FIXEDFIXED 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FIXEDFIXED
	* @see com.prowidesoftware.swift.SchemeConstantsF#FIXEDFIXED
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FIXEDFIXED = "FIXEDFIXED";

	/**
	* Constant for qualifier with value FIXEDFLOAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FIXEDFLOAT
	* @see com.prowidesoftware.swift.SchemeConstantsF#FIXEDFLOAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FIXEDFLOAT = "FIXEDFLOAT";

	/**
	* Constant for qualifier with value FLOATFIXED 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FLOATFIXED
	* @see com.prowidesoftware.swift.SchemeConstantsF#FLOATFIXED
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FLOATFIXED = "FLOATFIXED";

	/**
	* Constant for qualifier with value FLOATFLOAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FLOATFLOAT
	* @see com.prowidesoftware.swift.SchemeConstantsF#FLOATFLOAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FLOATFLOAT = "FLOATFLOAT";

	/**
	* Constant for qualifier with value GROSS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GROSS
	* @see com.prowidesoftware.swift.SchemeConstantsG#GROSS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String GROSS = "GROSS";

	/**
	* Constant for qualifier with value LAST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LAST
	* @see com.prowidesoftware.swift.SchemeConstantsL#LAST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String LAST = "LAST";

	/**
	* Constant for qualifier with value NEWT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NEWT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NEWT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String NEWT = "NEWT";

	/**
	* Constant for qualifier with value NEXT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NEXT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NEXT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String NEXT = "NEXT";

	/**
	* Constant for qualifier with value OTHR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String OTHR = "OTHR";

	/**
	* Constant for qualifier with value PTRC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PTRC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PTRC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PTRC = "PTRC";

	/**
	* Constant for qualifier with value PTRM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PTRM
	* @see com.prowidesoftware.swift.SchemeConstantsP#PTRM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PTRM = "PTRM";

	/**
	* Constant for qualifier with value RCPN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RCPN
	* @see com.prowidesoftware.swift.SchemeConstantsR#RCPN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String RCPN = "RCPN";

	/**
	* Constant for qualifier with value TERM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TERM
	* @see com.prowidesoftware.swift.SchemeConstantsT#TERM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String TERM = "TERM";

	/**
	* Constant for qualifier with value VARBUYER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VARBUYER
	* @see com.prowidesoftware.swift.SchemeConstantsV#VARBUYER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String VARBUYER = "VARBUYER";

	/**
	* Constant for qualifier with value VARSELLER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VARSELLER
	* @see com.prowidesoftware.swift.SchemeConstantsV#VARSELLER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String VARSELLER = "VARSELLER";

	/**
	* Constant for qualifier with value VOLABUYER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VOLABUYER
	* @see com.prowidesoftware.swift.SchemeConstantsV#VOLABUYER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String VOLABUYER = "VOLABUYER";

	/**
	* Constant for qualifier with value VOLASELLER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VOLASELLER
	* @see com.prowidesoftware.swift.SchemeConstantsV#VOLASELLER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String VOLASELLER = "VOLASELLER";

// end qualifiers constants	

	/**
	 * Creates an MT365 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT365 content
	 */
	public MT365(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT365 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT365 content, the parameter can not be <code>null</code>
	 * @see #MT365(String)
	 */
	public MT365(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT365 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT365 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT365(String)
	 * @since 7.7
	 */
	public static MT365 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT365(m.message());
	}
	
	/**
	 * Creates and initializes a new MT365 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT365() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT365 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT365(final String sender, final String receiver) {
		super(365, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT365(String, String)
	* @deprecated Use instead <code>new MT365(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT365(final int messageType, final String sender, final String receiver) {
		super(365, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT365(int, String, String)", "Use the constructor MT365(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT365 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT365(final String fin) {
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
			log.warning("Creating an MT365 object from FIN content with a Service Message. Check if the MT365 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT365 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT365 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT365 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT365 or null if fin is null 
	 * @since 7.7
	 */
	public static MT365 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT365(fin);
    }
    
    /**
	 * Creates a new MT365 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT365(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT365 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT365 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT365 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT365(stream);
    }
    
    /**
	 * Creates a new MT365 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT365(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT365 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT365 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT365 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT365(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "365";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT365 append(final SwiftTagListBlock block) {
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
	public MT365 append(final Tag ... tags) {
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
	public MT365 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT365 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT365 message
	 * @return a new instance of MT365
	 * @since 7.10.2
	 */
	public final static MT365 fromJson(String json) {
		return (MT365) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 15A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15A at MT365 is expected to be the only one.
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
	 * The first occurrence of field 20 at MT365 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT365 is expected to be the only one.
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
	 * The first occurrence of field 22A at MT365 is expected to be the only one.
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
	 * The first occurrence of field 94A at MT365 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22B at MT365 is expected to be the only one.
	 * 
	 * @return a Field22B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22B getField22B() {
		final Tag t = tag("22B");
		if (t != null) {
			return new Field22B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22C at MT365 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 23A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23A at MT365 is expected to be the only one.
	 * 
	 * @return a Field23A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23A getField23A() {
		final Tag t = tag("23A");
		if (t != null) {
			return new Field23A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21N, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 21N at MT365 is expected to be the only one.
	 * 
	 * @return a Field21N object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21N getField21N() {
		final Tag t = tag("21N");
		if (t != null) {
			return new Field21N(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 21B at MT365 is expected to be the only one.
	 * 
	 * @return a Field21B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21B getField21B() {
		final Tag t = tag("21B");
		if (t != null) {
			return new Field21B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30T, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30T at MT365 is expected to be the only one.
	 * 
	 * @return a Field30T object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30T getField30T() {
		final Tag t = tag("30T");
		if (t != null) {
			return new Field30T(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30Q, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30Q at MT365 is expected to be the only one.
	 * 
	 * @return a Field30Q object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30Q getField30Q() {
		final Tag t = tag("30Q");
		if (t != null) {
			return new Field30Q(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30P at MT365 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30V, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30V at MT365 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32B at MT365 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 33B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 33B at MT365 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 82A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 82A at MT365 is expected to be the only one.
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
	 * The first occurrence of field 82D at MT365 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 87A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 87A at MT365 is expected to be the only one.
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
	 * The first occurrence of field 87D at MT365 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 83A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 83A at MT365 is expected to be the only one.
	 * 
	 * @return a Field83A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field83A getField83A() {
		final Tag t = tag("83A");
		if (t != null) {
			return new Field83A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 83D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 83D at MT365 is expected to be the only one.
	 * 
	 * @return a Field83D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field83D getField83D() {
		final Tag t = tag("83D");
		if (t != null) {
			return new Field83D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 83J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 83J at MT365 is expected to be the only one.
	 * 
	 * @return a Field83J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field83J getField83J() {
		final Tag t = tag("83J");
		if (t != null) {
			return new Field83J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22D at MT365 is expected to be the only one.
	 * 
	 * @return a Field22D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22D getField22D() {
		final Tag t = tag("22D");
		if (t != null) {
			return new Field22D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32G, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32G at MT365 is expected to be the only one.
	 * 
	 * @return a Field32G object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field32G getField32G() {
		final Tag t = tag("32G");
		if (t != null) {
			return new Field32G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 33E at MT365 is expected to be the only one.
	 * 
	 * @return a Field33E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field33E getField33E() {
		final Tag t = tag("33E");
		if (t != null) {
			return new Field33E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37N, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37N at MT365 is expected to be the only one.
	 * 
	 * @return a Field37N object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37N getField37N() {
		final Tag t = tag("37N");
		if (t != null) {
			return new Field37N(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29A at MT365 is expected to be the only one.
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
	 * The first occurrence of field 72 at MT365 is expected to be the only one.
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
	 * The first occurrence of field 15B at MT365 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15E at MT365 is expected to be the only one.
	 * 
	 * @return a Field15E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15E getField15E() {
		final Tag t = tag("15E");
		if (t != null) {
			return new Field15E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15J at MT365 is expected to be the only one.
	 * 
	 * @return a Field15J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15J getField15J() {
		final Tag t = tag("15J");
		if (t != null) {
			return new Field15J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15K, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15K at MT365 is expected to be the only one.
	 * 
	 * @return a Field15K object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15K getField15K() {
		final Tag t = tag("15K");
		if (t != null) {
			return new Field15K(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15L at MT365 is expected to be the only one.
	 * 
	 * @return a Field15L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15L getField15L() {
		final Tag t = tag("15L");
		if (t != null) {
			return new Field15L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15M, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15M at MT365 is expected to be the only one.
	 * 
	 * @return a Field15M object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15M getField15M() {
		final Tag t = tag("15M");
		if (t != null) {
			return new Field15M(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37M, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37M at MT365 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37G, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37G at MT365 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 30F at MT365 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30F> getField30F() {
		final List<Field30F> result = new ArrayList<Field30F>();
		final Tag[] tags = tags("30F");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field30F(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32M, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32M at MT365 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32M objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32M> getField32M() {
		final List<Field32M> result = new ArrayList<Field32M>();
		final Tag[] tags = tags("32M");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field32M(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 53A at MT365 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 53D at MT365 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 56A at MT365 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 56D at MT365 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 86A at MT365 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field86A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field86A> getField86A() {
		final List<Field86A> result = new ArrayList<Field86A>();
		final Tag[] tags = tags("86A");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field86A(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 86D at MT365 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field86D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field86D> getField86D() {
		final List<Field86D> result = new ArrayList<Field86D>();
		final Tag[] tags = tags("86D");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field86D(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57A at MT365 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 57D at MT365 are expected at one sequence or across several sequences.
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
	

// BaseSequenceCodeGenerator [seq=A]
	/**
	* Class for Sequence "A" of MT 365
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
	* Class for Sequence "B" of MT 365
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


// BaseSequenceCodeGenerator [seq=E]
	/**
	* Class for Sequence "E" of MT 365
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceE extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceE() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceE(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15E.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceE newInstance(final Tag ... tags) {
			final SequenceE result = new SequenceE();

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
		public static SequenceE newInstance() {
			final SequenceE result = new SequenceE();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceE newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE result = new SequenceE();

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
	* Get the single occurrence of SequenceE using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceE getSequenceE() {
		return getSequenceE(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceE using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceE within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceE getSequenceE(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("E")) {
			return new SequenceE(map.get("E"));
		}
		return new SequenceE();
	}


// BaseSequenceCodeGenerator [seq=J]
	/**
	* Class for Sequence "J" of MT 365
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceJ extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceJ() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceJ(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15J.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceJ newInstance(final Tag ... tags) {
			final SequenceJ result = new SequenceJ();

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
		public static SequenceJ newInstance() {
			final SequenceJ result = new SequenceJ();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceJ newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceJ result = new SequenceJ();

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
	* Get the single occurrence of SequenceJ using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceJ getSequenceJ() {
		return getSequenceJ(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceJ using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceJ within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceJ getSequenceJ(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("J")) {
			return new SequenceJ(map.get("J"));
		}
		return new SequenceJ();
	}


// BaseSequenceCodeGenerator [seq=K]
	/**
	* Class for Sequence "K" of MT 365
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceK extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceK() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceK(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15K.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceK newInstance(final Tag ... tags) {
			final SequenceK result = new SequenceK();

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
		public static SequenceK newInstance() {
			final SequenceK result = new SequenceK();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceK newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceK result = new SequenceK();

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
	* Get the single occurrence of SequenceK using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceK getSequenceK() {
		return getSequenceK(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceK using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceK within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceK getSequenceK(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("K")) {
			return new SequenceK(map.get("K"));
		}
		return new SequenceK();
	}


// BaseSequenceCodeGenerator [seq=L]
	/**
	* Class for Sequence "L" of MT 365
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceL extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceL() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceL(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15L.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceL newInstance(final Tag ... tags) {
			final SequenceL result = new SequenceL();

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
		public static SequenceL newInstance() {
			final SequenceL result = new SequenceL();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceL newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceL result = new SequenceL();

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
	* Get the single occurrence of SequenceL using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceL getSequenceL() {
		return getSequenceL(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceL using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceL within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceL getSequenceL(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("L")) {
			return new SequenceL(map.get("L"));
		}
		return new SequenceL();
	}


// BaseSequenceCodeGenerator [seq=M]
	/**
	* Class for Sequence "M" of MT 365
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceM extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceM() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceM(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15M.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceM newInstance(final Tag ... tags) {
			final SequenceM result = new SequenceM();

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
		public static SequenceM newInstance() {
			final SequenceM result = new SequenceM();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceM newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceM result = new SequenceM();

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
	* Get the single occurrence of SequenceM using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceM getSequenceM() {
		return getSequenceM(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceM using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceM within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceM getSequenceM(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("M")) {
			return new SequenceM(map.get("M"));
		}
		return new SequenceM();
	}




}

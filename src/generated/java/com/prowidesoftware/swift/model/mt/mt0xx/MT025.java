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
package com.prowidesoftware.swift.model.mt.mt0xx;



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
 * <h1>MT 025 - Bulk Retrieval Response</h1>
 * <h3>SWIFT MT025 (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="field">Field 251  (M)</li>
<li class="field">Field 140  (O)</li>
<li class="field">Field 144  (M)</li>
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
public class MT025 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2017;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT025.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "025";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value 00 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_0._00
	* @see com.prowidesoftware.swift.SchemeConstants_0#_00
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _00 = "00";

	/**
	* Constant for qualifier with value 01 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_0._01
	* @see com.prowidesoftware.swift.SchemeConstants_0#_01
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _01 = "01";

	/**
	* Constant for qualifier with value 02 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_0._02
	* @see com.prowidesoftware.swift.SchemeConstants_0#_02
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _02 = "02";

	/**
	* Constant for qualifier with value 03 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_0._03
	* @see com.prowidesoftware.swift.SchemeConstants_0#_03
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _03 = "03";

	/**
	* Constant for qualifier with value 06 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_0._06
	* @see com.prowidesoftware.swift.SchemeConstants_0#_06
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _06 = "06";

	/**
	* Constant for qualifier with value 07 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_0._07
	* @see com.prowidesoftware.swift.SchemeConstants_0#_07
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _07 = "07";

	/**
	* Constant for qualifier with value 08 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_0._08
	* @see com.prowidesoftware.swift.SchemeConstants_0#_08
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _08 = "08";

	/**
	* Constant for qualifier with value 10 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._10
	* @see com.prowidesoftware.swift.SchemeConstants_1#_10
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _10 = "10";

	/**
	* Constant for qualifier with value 11 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._11
	* @see com.prowidesoftware.swift.SchemeConstants_1#_11
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _11 = "11";

	/**
	* Constant for qualifier with value 12 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._12
	* @see com.prowidesoftware.swift.SchemeConstants_1#_12
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _12 = "12";

	/**
	* Constant for qualifier with value 13 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._13
	* @see com.prowidesoftware.swift.SchemeConstants_1#_13
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _13 = "13";

	/**
	* Constant for qualifier with value 14 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._14
	* @see com.prowidesoftware.swift.SchemeConstants_1#_14
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _14 = "14";

	/**
	* Constant for qualifier with value 15 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._15
	* @see com.prowidesoftware.swift.SchemeConstants_1#_15
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _15 = "15";

	/**
	* Constant for qualifier with value 16 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._16
	* @see com.prowidesoftware.swift.SchemeConstants_1#_16
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _16 = "16";

	/**
	* Constant for qualifier with value 17 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._17
	* @see com.prowidesoftware.swift.SchemeConstants_1#_17
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _17 = "17";

	/**
	* Constant for qualifier with value 18 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._18
	* @see com.prowidesoftware.swift.SchemeConstants_1#_18
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _18 = "18";

	/**
	* Constant for qualifier with value 19 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._19
	* @see com.prowidesoftware.swift.SchemeConstants_1#_19
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _19 = "19";

// end qualifiers constants	

	/**
	 * Creates an MT025 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT025 content
	 */
	public MT025(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT025 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT025 content, the parameter can not be <code>null</code>
	 * @see #MT025(String)
	 */
	public MT025(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT025 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT025 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT025(String)
	 * @since 7.7
	 */
	public static MT025 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT025(m.message());
	}
	
	/**
	 * Creates and initializes a new MT025 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT025() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT025 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT025(final String sender, final String receiver) {
		super(25, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT025(String, String)
	* @deprecated Use instead <code>new MT025(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT025(final int messageType, final String sender, final String receiver) {
		super(25, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT025(int, String, String)", "Use the constructor MT025(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT025 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT025(final String fin) {
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
			log.warning("Creating an MT025 object from FIN content with a Service Message. Check if the MT025 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT025 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT025 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT025 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT025 or null if fin is null 
	 * @since 7.7
	 */
	public static MT025 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT025(fin);
    }
    
    /**
	 * Creates a new MT025 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT025(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT025 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT025 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT025 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT025(stream);
    }
    
    /**
	 * Creates a new MT025 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT025(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT025 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT025 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT025 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT025(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "025";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT025 append(final SwiftTagListBlock block) {
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
	public MT025 append(final Tag ... tags) {
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
	public MT025 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT025 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT025 message
	 * @return a new instance of MT025
	 * @since 7.10.2
	 */
	public final static MT025 fromJson(String json) {
		return (MT025) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 251, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 251 at MT025 is expected to be the only one.
	 * 
	 * @return a Field251 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field251 getField251() {
		final Tag t = tag("251");
		if (t != null) {
			return new Field251(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 140, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 140 at MT025 is expected to be the only one.
	 * 
	 * @return a Field140 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field140 getField140() {
		final Tag t = tag("140");
		if (t != null) {
			return new Field140(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 144, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 144 at MT025 is expected to be the only one.
	 * 
	 * @return a Field144 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field144 getField144() {
		final Tag t = tag("144");
		if (t != null) {
			return new Field144(t.getValue());
		} else {
			return null;
		}
	}
	



}

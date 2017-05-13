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
 * <h1>MT 047 - Delivery Instructions Redefinition Request</h1>
 * <h3>SWIFT MT047 (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="field">Field 206  (M)</li>
<li class="field">Field 348  (O)</li>
<li class="sequence">
Sequence _A - Delivery details (M) (repetitive)<ul><li class="field">Field 339  (M)</li>
<li class="field">Field 349  (O)</li>
<li class="field">Field 344  (M) (repetitive)</li>
<li class="field">Field 345  (O) (repetitive)</li>
<li class="field">Field 346  (O) (repetitive)</li>
<li class="field">Field 347  (O) (repetitive)</li>
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
public class MT047 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT047.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "047";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value 0 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_0._0
	* @see com.prowidesoftware.swift.SchemeConstants_0#_0
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _0 = "0";

	/**
	* Constant for qualifier with value 1 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_1._1
	* @see com.prowidesoftware.swift.SchemeConstants_1#_1
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String _1 = "1";

	/**
	* Constant for qualifier with value L 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.L
	* @see com.prowidesoftware.swift.SchemeConstantsL#L
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String L = "L";

	/**
	* Constant for qualifier with value N 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.N
	* @see com.prowidesoftware.swift.SchemeConstantsN#N
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String N = "N";

	/**
	* Constant for qualifier with value O 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.O
	* @see com.prowidesoftware.swift.SchemeConstantsO#O
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String O = "O";

	/**
	* Constant for qualifier with value S 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.S
	* @see com.prowidesoftware.swift.SchemeConstantsS#S
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String S = "S";

	/**
	* Constant for qualifier with value U 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.U
	* @see com.prowidesoftware.swift.SchemeConstantsU#U
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String U = "U";

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
	 * Creates an MT047 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT047 content
	 */
	public MT047(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT047 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT047 content, the parameter can not be <code>null</code>
	 * @see #MT047(String)
	 */
	public MT047(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT047 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT047 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT047(String)
	 * @since 7.7
	 */
	public static MT047 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT047(m.message());
	}
	
	/**
	 * Creates and initializes a new MT047 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT047() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT047 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT047(final String sender, final String receiver) {
		super(47, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT047(String, String)
	* @deprecated Use instead <code>new MT047(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT047(final int messageType, final String sender, final String receiver) {
		super(47, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT047(int, String, String)", "Use the constructor MT047(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT047 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT047(final String fin) {
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
			log.warning("Creating an MT047 object from FIN content with a Service Message. Check if the MT047 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT047 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT047 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT047 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT047 or null if fin is null 
	 * @since 7.7
	 */
	public static MT047 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT047(fin);
    }
    
    /**
	 * Creates a new MT047 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT047(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT047 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT047 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT047 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT047(stream);
    }
    
    /**
	 * Creates a new MT047 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT047(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT047 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT047 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT047 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT047(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "047";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT047 append(final SwiftTagListBlock block) {
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
	public MT047 append(final Tag ... tags) {
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
	public MT047 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 206, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 206 at MT047 is expected to be the only one.
	 * 
	 * @return a Field206 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field206 getField206() {
		final Tag t = tag("206");
		if (t != null) {
			return new Field206(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 348, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 348 at MT047 is expected to be the only one.
	 * 
	 * @return a Field348 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field348 getField348() {
		final Tag t = tag("348");
		if (t != null) {
			return new Field348(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 339, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 339 at MT047 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field339 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field339> getField339() {
		final List<Field339> result = new ArrayList<Field339>();
		final Tag[] tags = tags("339");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field339(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 349, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 349 at MT047 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field349 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field349> getField349() {
		final List<Field349> result = new ArrayList<Field349>();
		final Tag[] tags = tags("349");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field349(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 344, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 344 at MT047 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field344 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field344> getField344() {
		final List<Field344> result = new ArrayList<Field344>();
		final Tag[] tags = tags("344");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field344(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 345, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 345 at MT047 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field345 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field345> getField345() {
		final List<Field345> result = new ArrayList<Field345>();
		final Tag[] tags = tags("345");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field345(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 346, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 346 at MT047 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field346 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field346> getField346() {
		final List<Field346> result = new ArrayList<Field346>();
		final Tag[] tags = tags("346");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field346(tags[i].getValue()));
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 347, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 347 at MT047 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field347 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field347> getField347() {
		final List<Field347> result = new ArrayList<Field347>();
		final Tag[] tags = tags("347");
		for (int i=0; i<tags.length; i++) {
			result.add(new Field347(tags[i].getValue()));
		}
		return result;
	}
	



}

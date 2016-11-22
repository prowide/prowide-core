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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
 * MT 798_763<br />
 * Request for Amendment of Guarantee Index<br />
 <h1>MT798_763 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="field"><em>Field 20</em>
Letter options: null<br/></div><div class="field"><em>Field 12</em>
Letter options: null<br/></div><div class="field"><em>Field 77</em>
Letter options: E<br/></div><div class="field"><em>Field 27</em>
Letter options: A<br/></div><div class="field"><em>Field 21</em>
Letter options: A<br/></div><div class="field"><em>Field 20</em>
Letter options: null<br/></div><div class="field"><em>Field 13</em>
Letter options: E<br/></div><div class="field"><em>Field 32</em>
Letter options: B<br/></div><div class="field"><em>Field 33</em>
Letter options: B<br/></div><div class="field"><em>Field 23</em>
Letter options: B<br/></div><div class="field"><em>Field 31</em>
Letter options: L<br/></div><div class="field"><em>Field 31</em>
Letter options: S<br/></div><div class="field"><em>Field 23</em>
Letter options: E<br/></div><div class="field"><em>Field 24</em>
Letter options: E<br/></div><div class="field"><em>Field 22</em>
Letter options: G<br/></div><div class="field"><em>Field 50</em>
Letter options: B<br/></div><div class="field"><em>Field 29</em>
Letter options: A<br/></div><div class="field"><em>Field 72</em>
Letter options: C<br/></div><div class="field"><em>Field 23</em>
Letter options: X<br/></div><div class="field"><em>Field 26</em>
Letter options: E<br/></div><div class="field"><em>Field 29</em>
Letter options: S<br/></div></div>

 </pre>
 * <em>This source code is specific to release SRU 2016</em><br /> 
 *
 *		 
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT798_763 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT798_763.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "798_763";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value ALTA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ALTA
	* @see com.prowidesoftware.swift.SchemeConstantsA#ALTA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ALTA = "ALTA";

	/**
	* Constant for qualifier with value APPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.APPL
	* @see com.prowidesoftware.swift.SchemeConstantsA#APPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String APPL = "APPL";

	/**
	* Constant for qualifier with value BENE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BENE
	* @see com.prowidesoftware.swift.SchemeConstantsB#BENE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BENE = "BENE";

	/**
	* Constant for qualifier with value COUR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COUR
	* @see com.prowidesoftware.swift.SchemeConstantsC#COUR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COUR = "COUR";

	/**
	* Constant for qualifier with value EMAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EMAL
	* @see com.prowidesoftware.swift.SchemeConstantsE#EMAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EMAL = "EMAL";

	/**
	* Constant for qualifier with value FACT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FACT
	* @see com.prowidesoftware.swift.SchemeConstantsF#FACT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FACT = "FACT";

	/**
	* Constant for qualifier with value FAXT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FAXT
	* @see com.prowidesoftware.swift.SchemeConstantsF#FAXT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FAXT = "FAXT";

	/**
	* Constant for qualifier with value LIMT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LIMT
	* @see com.prowidesoftware.swift.SchemeConstantsL#LIMT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LIMT = "LIMT";

	/**
	* Constant for qualifier with value MAIL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MAIL
	* @see com.prowidesoftware.swift.SchemeConstantsM#MAIL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MAIL = "MAIL";

	/**
	* Constant for qualifier with value MESS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MESS
	* @see com.prowidesoftware.swift.SchemeConstantsM#MESS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MESS = "MESS";

	/**
	* Constant for qualifier with value OTHR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OTHR = "OTHR";

	/**
	* Constant for qualifier with value REGM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REGM
	* @see com.prowidesoftware.swift.SchemeConstantsR#REGM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REGM = "REGM";

	/**
	* Constant for qualifier with value SPEC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SPEC
	* @see com.prowidesoftware.swift.SchemeConstantsS#SPEC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SPEC = "SPEC";

	/**
	* Constant for qualifier with value TELE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TELE
	* @see com.prowidesoftware.swift.SchemeConstantsT#TELE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TELE = "TELE";

	/**
	* Constant for qualifier with value UNLM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UNLM
	* @see com.prowidesoftware.swift.SchemeConstantsU#UNLM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String UNLM = "UNLM";

// end qualifiers constants	

	/**
	 * Creates an MT798_763 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT798_763 content
	 */
	public MT798_763(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT798_763 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT798_763 content, the parameter can not be <code>null</code>
	 * @see #MT798_763(String)
	 */
	public MT798_763(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT798_763 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT798_763 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT798_763(String)
	 * @since 7.7
	 */
	public static MT798_763 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT798_763(m.message());
	}
	
	/**
	 * Creates and initializes a new MT798_763 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT798_763() {
		super(798);
	}
	
	/**
	 * Creates and initializes a new MT798_763 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT798_763(final String sender, final String receiver) {
		super(798, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT798_763(sender, receiver)</code>
	* @see #MT798_763(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT798_763(final int messageType, final String sender, final String receiver) {
		super(798, sender, receiver);
	}
	
	/**
	 * Creates a new MT798_763 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT798_763(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT798_763 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT798_763 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT798_763 or null if fin is null 
	 * @since 7.7
	 */
	public static MT798_763 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT798_763(fin);
    }
    
    /**
	 * Creates a new MT798_763 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT798_763(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT798_763 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT798_763 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT798_763 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT798_763(stream);
    }
    
    /**
	 * Creates a new MT798_763 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT798_763(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT798_763 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT798_763 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT798_763 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT798_763(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "798_763";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT798_763 append(final SwiftTagListBlock block) {
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
	public MT798_763 append(final Tag ... tags) {
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
	public MT798_763 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 12 at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field12 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12 getField12() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("12");
			if (t == null) {
				log.fine("field 12 not found");
				return null;
			} else {
				return new Field12(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 77E at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field77E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77E getField77E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("77E");
			if (t == null) {
				log.fine("field 77E not found");
				return null;
			} else {
				return new Field77E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 27A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 27A at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field27A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field27A getField27A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("27A");
			if (t == null) {
				log.fine("field 27A not found");
				return null;
			} else {
				return new Field27A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 21A at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field21A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21A getField21A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("21A");
			if (t == null) {
				log.fine("field 21A not found");
				return null;
			} else {
				return new Field21A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 13E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 13E at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field13E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field13E getField13E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("13E");
			if (t == null) {
				log.fine("field 13E not found");
				return null;
			} else {
				return new Field13E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32B at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field32B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field32B getField32B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("32B");
			if (t == null) {
				log.fine("field 32B not found");
				return null;
			} else {
				return new Field32B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 33B at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field33B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field33B getField33B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("33B");
			if (t == null) {
				log.fine("field 33B not found");
				return null;
			} else {
				return new Field33B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23B at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field23B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23B getField23B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("23B");
			if (t == null) {
				log.fine("field 23B not found");
				return null;
			} else {
				return new Field23B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31L at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field31L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31L getField31L() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("31L");
			if (t == null) {
				log.fine("field 31L not found");
				return null;
			} else {
				return new Field31L(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31S, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31S at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field31S object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31S getField31S() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("31S");
			if (t == null) {
				log.fine("field 31S not found");
				return null;
			} else {
				return new Field31S(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23E at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field23E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23E getField23E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("23E");
			if (t == null) {
				log.fine("field 23E not found");
				return null;
			} else {
				return new Field23E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 24E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 24E at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field24E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field24E getField24E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("24E");
			if (t == null) {
				log.fine("field 24E not found");
				return null;
			} else {
				return new Field24E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22G, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22G at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field22G object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22G getField22G() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("22G");
			if (t == null) {
				log.fine("field 22G not found");
				return null;
			} else {
				return new Field22G(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 50B at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field50B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50B getField50B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("50B");
			if (t == null) {
				log.fine("field 50B not found");
				return null;
			} else {
				return new Field50B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29A at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field29A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29A getField29A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("29A");
			if (t == null) {
				log.fine("field 29A not found");
				return null;
			} else {
				return new Field29A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 72C at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field72C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field72C getField72C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("72C");
			if (t == null) {
				log.fine("field 72C not found");
				return null;
			} else {
				return new Field72C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23X, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23X at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field23X object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23X getField23X() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("23X");
			if (t == null) {
				log.fine("field 23X not found");
				return null;
			} else {
				return new Field23X(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 26E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 26E at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field26E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field26E getField26E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("26E");
			if (t == null) {
				log.fine("field 26E not found");
				return null;
			} else {
				return new Field26E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29S, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29S at MT798_763 is expected to be the only one.
	 * 
	 * @return a Field29S object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29S getField29S() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("29S");
			if (t == null) {
				log.fine("field 29S not found");
				return null;
			} else {
				return new Field29S(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 20 at MT798_763 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field20 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field20> getField20() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("20");
			final List<Field20> result = new ArrayList<Field20>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field20(tags[i].getValue()));
			}
			return result;
		}
	}
	

/*
 * sequences code
 *
 */ 





}

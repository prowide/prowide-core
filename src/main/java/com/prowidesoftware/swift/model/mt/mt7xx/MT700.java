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
 * MT 700<br />
 * Issue of a Documentary Credit<br />
 <h1>MT700 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="field"><em>Field 27</em>
Letter options: null<br/></div><div class="field"><em>Field 40</em>
Letter options: A<br/></div><div class="field"><em>Field 20</em>
Letter options: null<br/></div><div class="field"><em>Field 23</em>
Letter options: null<br/></div><div class="field"><em>Field 31</em>
Letter options: C<br/></div><div class="field"><em>Field 40</em>
Letter options: E<br/></div><div class="field"><em>Field 31</em>
Letter options: D<br/></div><div class="field"><em>Field 51</em>
Letter options: A,D<br/></div><div class="field"><em>Field 50</em>
Letter options: null<br/></div><div class="field"><em>Field 59</em>
Letter options: null<br/></div><div class="field"><em>Field 32</em>
Letter options: B<br/></div><div class="field"><em>Field 39</em>
Letter options: A<br/></div><div class="field"><em>Field 39</em>
Letter options: B<br/></div><div class="field"><em>Field 39</em>
Letter options: C<br/></div><div class="field"><em>Field 41</em>
Letter options: A,D<br/></div><div class="field"><em>Field 42</em>
Letter options: C<br/></div><div class="field"><em>Field 42</em>
Letter options: A,D<br/></div><div class="field"><em>Field 42</em>
Letter options: M<br/></div><div class="field"><em>Field 42</em>
Letter options: P<br/></div><div class="field"><em>Field 43</em>
Letter options: P<br/></div><div class="field"><em>Field 43</em>
Letter options: T<br/></div><div class="field"><em>Field 44</em>
Letter options: A<br/></div><div class="field"><em>Field 44</em>
Letter options: E<br/></div><div class="field"><em>Field 44</em>
Letter options: F<br/></div><div class="field"><em>Field 44</em>
Letter options: B<br/></div><div class="field"><em>Field 44</em>
Letter options: C<br/></div><div class="field"><em>Field 44</em>
Letter options: D<br/></div><div class="field"><em>Field 45</em>
Letter options: A<br/></div><div class="field"><em>Field 46</em>
Letter options: A<br/></div><div class="field"><em>Field 47</em>
Letter options: A<br/></div><div class="field"><em>Field 71</em>
Letter options: B<br/></div><div class="field"><em>Field 48</em>
Letter options: null<br/></div><div class="field"><em>Field 49</em>
Letter options: null<br/></div><div class="field"><em>Field 53</em>
Letter options: A,D<br/></div><div class="field"><em>Field 78</em>
Letter options: null<br/></div><div class="field"><em>Field 57</em>
Letter options: A,B,D<br/></div><div class="field"><em>Field 72</em>
Letter options: null<br/></div></div>

 </pre>
 * <em>This source code is specific to release SRU 2016</em><br /> 
 *
 *		 
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT700 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT700.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "700";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value CONFIRM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CONFIRM
	* @see com.prowidesoftware.swift.SchemeConstantsC#CONFIRM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CONFIRM = "CONFIRM";

	/**
	* Constant for qualifier with value EUCPURR_LATEST_VERSION 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EUCPURR_LATEST_VERSION
	* @see com.prowidesoftware.swift.SchemeConstantsE#EUCPURR_LATEST_VERSION
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EUCPURR_LATEST_VERSION = "EUCPURR_LATEST_VERSION";

	/**
	* Constant for qualifier with value EUCP_LATEST_VERSION 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EUCP_LATEST_VERSION
	* @see com.prowidesoftware.swift.SchemeConstantsE#EUCP_LATEST_VERSION
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EUCP_LATEST_VERSION = "EUCP_LATEST_VERSION";

	/**
	* Constant for qualifier with value IRREVOCABLE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.IRREVOCABLE
	* @see com.prowidesoftware.swift.SchemeConstantsI#IRREVOCABLE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String IRREVOCABLE = "IRREVOCABLE";

	/**
	* Constant for qualifier with value IRREVOCABLE_STANDBY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.IRREVOCABLE_STANDBY
	* @see com.prowidesoftware.swift.SchemeConstantsI#IRREVOCABLE_STANDBY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String IRREVOCABLE_STANDBY = "IRREVOCABLE_STANDBY";

	/**
	* Constant for qualifier with value IRREVOCABLE_TRANSFERABLE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.IRREVOCABLE_TRANSFERABLE
	* @see com.prowidesoftware.swift.SchemeConstantsI#IRREVOCABLE_TRANSFERABLE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String IRREVOCABLE_TRANSFERABLE = "IRREVOCABLE_TRANSFERABLE";

	/**
	* Constant for qualifier with value IRREVOC_TRANS_STANDBY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.IRREVOC_TRANS_STANDBY
	* @see com.prowidesoftware.swift.SchemeConstantsI#IRREVOC_TRANS_STANDBY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String IRREVOC_TRANS_STANDBY = "IRREVOC_TRANS_STANDBY";

	/**
	* Constant for qualifier with value ISP_LATEST_VERSION 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ISP_LATEST_VERSION
	* @see com.prowidesoftware.swift.SchemeConstantsI#ISP_LATEST_VERSION
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ISP_LATEST_VERSION = "ISP_LATEST_VERSION";

	/**
	* Constant for qualifier with value MAY_ADD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MAY_ADD
	* @see com.prowidesoftware.swift.SchemeConstantsM#MAY_ADD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MAY_ADD = "MAY_ADD";

	/**
	* Constant for qualifier with value NOT_EXCEEDING 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NOT_EXCEEDING
	* @see com.prowidesoftware.swift.SchemeConstantsN#NOT_EXCEEDING
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NOT_EXCEEDING = "NOT_EXCEEDING";

	/**
	* Constant for qualifier with value OTHR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OTHR = "OTHR";

	/**
	* Constant for qualifier with value REVOCABLE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REVOCABLE
	* @see com.prowidesoftware.swift.SchemeConstantsR#REVOCABLE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REVOCABLE = "REVOCABLE";

	/**
	* Constant for qualifier with value UCPURR_LATEST_VERSION 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UCPURR_LATEST_VERSION
	* @see com.prowidesoftware.swift.SchemeConstantsU#UCPURR_LATEST_VERSION
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String UCPURR_LATEST_VERSION = "UCPURR_LATEST_VERSION";

	/**
	* Constant for qualifier with value UCP_LATEST_VERSION 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UCP_LATEST_VERSION
	* @see com.prowidesoftware.swift.SchemeConstantsU#UCP_LATEST_VERSION
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String UCP_LATEST_VERSION = "UCP_LATEST_VERSION";

	/**
	* Constant for qualifier with value WITHOUT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WITHOUT
	* @see com.prowidesoftware.swift.SchemeConstantsW#WITHOUT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String WITHOUT = "WITHOUT";

// end qualifiers constants	

	/**
	 * Creates an MT700 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT700 content
	 */
	public MT700(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT700 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT700 content, the parameter can not be <code>null</code>
	 * @see #MT700(String)
	 */
	public MT700(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT700 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT700 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT700(String)
	 * @since 7.7
	 */
	public static MT700 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT700(m.message());
	}
	
	/**
	 * Creates and initializes a new MT700 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT700() {
		super(700);
	}
	
	/**
	 * Creates and initializes a new MT700 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT700(final String sender, final String receiver) {
		super(700, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT700(sender, receiver)</code>
	* @see #MT700(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT700(final int messageType, final String sender, final String receiver) {
		super(700, sender, receiver);
	}
	
	/**
	 * Creates a new MT700 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT700(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT700 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT700 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT700 or null if fin is null 
	 * @since 7.7
	 */
	public static MT700 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT700(fin);
    }
    
    /**
	 * Creates a new MT700 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT700(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT700 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT700 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT700 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT700(stream);
    }
    
    /**
	 * Creates a new MT700 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT700(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT700 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT700 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT700 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT700(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "700";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT700 append(final SwiftTagListBlock block) {
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
	public MT700 append(final Tag ... tags) {
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
	public MT700 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 27, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 27 at MT700 is expected to be the only one.
	 * 
	 * @return a Field27 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field27 getField27() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("27");
			if (t == null) {
				log.fine("field 27 not found");
				return null;
			} else {
				return new Field27(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 40A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 40A at MT700 is expected to be the only one.
	 * 
	 * @return a Field40A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field40A getField40A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("40A");
			if (t == null) {
				log.fine("field 40A not found");
				return null;
			} else {
				return new Field40A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT700 is expected to be the only one.
	 * 
	 * @return a Field20 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field20 getField20() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("20");
			if (t == null) {
				log.fine("field 20 not found");
				return null;
			} else {
				return new Field20(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23 at MT700 is expected to be the only one.
	 * 
	 * @return a Field23 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23 getField23() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("23");
			if (t == null) {
				log.fine("field 23 not found");
				return null;
			} else {
				return new Field23(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31C at MT700 is expected to be the only one.
	 * 
	 * @return a Field31C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31C getField31C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("31C");
			if (t == null) {
				log.fine("field 31C not found");
				return null;
			} else {
				return new Field31C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 40E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 40E at MT700 is expected to be the only one.
	 * 
	 * @return a Field40E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field40E getField40E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("40E");
			if (t == null) {
				log.fine("field 40E not found");
				return null;
			} else {
				return new Field40E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31D at MT700 is expected to be the only one.
	 * 
	 * @return a Field31D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31D getField31D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("31D");
			if (t == null) {
				log.fine("field 31D not found");
				return null;
			} else {
				return new Field31D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 51A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 51A at MT700 is expected to be the only one.
	 * 
	 * @return a Field51A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field51A getField51A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("51A");
			if (t == null) {
				log.fine("field 51A not found");
				return null;
			} else {
				return new Field51A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 51D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 51D at MT700 is expected to be the only one.
	 * 
	 * @return a Field51D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field51D getField51D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("51D");
			if (t == null) {
				log.fine("field 51D not found");
				return null;
			} else {
				return new Field51D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 50 at MT700 is expected to be the only one.
	 * 
	 * @return a Field50 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50 getField50() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("50");
			if (t == null) {
				log.fine("field 50 not found");
				return null;
			} else {
				return new Field50(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 59, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 59 at MT700 is expected to be the only one.
	 * 
	 * @return a Field59 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59 getField59() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("59");
			if (t == null) {
				log.fine("field 59 not found");
				return null;
			} else {
				return new Field59(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32B at MT700 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 39A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 39A at MT700 is expected to be the only one.
	 * 
	 * @return a Field39A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39A getField39A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("39A");
			if (t == null) {
				log.fine("field 39A not found");
				return null;
			} else {
				return new Field39A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 39B at MT700 is expected to be the only one.
	 * 
	 * @return a Field39B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39B getField39B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("39B");
			if (t == null) {
				log.fine("field 39B not found");
				return null;
			} else {
				return new Field39B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 39C at MT700 is expected to be the only one.
	 * 
	 * @return a Field39C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39C getField39C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("39C");
			if (t == null) {
				log.fine("field 39C not found");
				return null;
			} else {
				return new Field39C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 41A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 41A at MT700 is expected to be the only one.
	 * 
	 * @return a Field41A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field41A getField41A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("41A");
			if (t == null) {
				log.fine("field 41A not found");
				return null;
			} else {
				return new Field41A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 41D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 41D at MT700 is expected to be the only one.
	 * 
	 * @return a Field41D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field41D getField41D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("41D");
			if (t == null) {
				log.fine("field 41D not found");
				return null;
			} else {
				return new Field41D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 42C at MT700 is expected to be the only one.
	 * 
	 * @return a Field42C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42C getField42C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("42C");
			if (t == null) {
				log.fine("field 42C not found");
				return null;
			} else {
				return new Field42C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 42A at MT700 is expected to be the only one.
	 * 
	 * @return a Field42A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42A getField42A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("42A");
			if (t == null) {
				log.fine("field 42A not found");
				return null;
			} else {
				return new Field42A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 42D at MT700 is expected to be the only one.
	 * 
	 * @return a Field42D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42D getField42D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("42D");
			if (t == null) {
				log.fine("field 42D not found");
				return null;
			} else {
				return new Field42D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42M, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 42M at MT700 is expected to be the only one.
	 * 
	 * @return a Field42M object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42M getField42M() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("42M");
			if (t == null) {
				log.fine("field 42M not found");
				return null;
			} else {
				return new Field42M(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 42P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 42P at MT700 is expected to be the only one.
	 * 
	 * @return a Field42P object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field42P getField42P() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("42P");
			if (t == null) {
				log.fine("field 42P not found");
				return null;
			} else {
				return new Field42P(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 43P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 43P at MT700 is expected to be the only one.
	 * 
	 * @return a Field43P object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field43P getField43P() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("43P");
			if (t == null) {
				log.fine("field 43P not found");
				return null;
			} else {
				return new Field43P(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 43T, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 43T at MT700 is expected to be the only one.
	 * 
	 * @return a Field43T object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field43T getField43T() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("43T");
			if (t == null) {
				log.fine("field 43T not found");
				return null;
			} else {
				return new Field43T(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 44A at MT700 is expected to be the only one.
	 * 
	 * @return a Field44A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44A getField44A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("44A");
			if (t == null) {
				log.fine("field 44A not found");
				return null;
			} else {
				return new Field44A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 44E at MT700 is expected to be the only one.
	 * 
	 * @return a Field44E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44E getField44E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("44E");
			if (t == null) {
				log.fine("field 44E not found");
				return null;
			} else {
				return new Field44E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 44F at MT700 is expected to be the only one.
	 * 
	 * @return a Field44F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44F getField44F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("44F");
			if (t == null) {
				log.fine("field 44F not found");
				return null;
			} else {
				return new Field44F(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 44B at MT700 is expected to be the only one.
	 * 
	 * @return a Field44B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44B getField44B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("44B");
			if (t == null) {
				log.fine("field 44B not found");
				return null;
			} else {
				return new Field44B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 44C at MT700 is expected to be the only one.
	 * 
	 * @return a Field44C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44C getField44C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("44C");
			if (t == null) {
				log.fine("field 44C not found");
				return null;
			} else {
				return new Field44C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 44D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 44D at MT700 is expected to be the only one.
	 * 
	 * @return a Field44D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field44D getField44D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("44D");
			if (t == null) {
				log.fine("field 44D not found");
				return null;
			} else {
				return new Field44D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 45A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 45A at MT700 is expected to be the only one.
	 * 
	 * @return a Field45A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field45A getField45A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("45A");
			if (t == null) {
				log.fine("field 45A not found");
				return null;
			} else {
				return new Field45A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 46A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 46A at MT700 is expected to be the only one.
	 * 
	 * @return a Field46A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field46A getField46A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("46A");
			if (t == null) {
				log.fine("field 46A not found");
				return null;
			} else {
				return new Field46A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 47A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 47A at MT700 is expected to be the only one.
	 * 
	 * @return a Field47A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field47A getField47A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("47A");
			if (t == null) {
				log.fine("field 47A not found");
				return null;
			} else {
				return new Field47A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 71B at MT700 is expected to be the only one.
	 * 
	 * @return a Field71B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71B getField71B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("71B");
			if (t == null) {
				log.fine("field 71B not found");
				return null;
			} else {
				return new Field71B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 48, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 48 at MT700 is expected to be the only one.
	 * 
	 * @return a Field48 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field48 getField48() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("48");
			if (t == null) {
				log.fine("field 48 not found");
				return null;
			} else {
				return new Field48(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 49, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 49 at MT700 is expected to be the only one.
	 * 
	 * @return a Field49 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field49 getField49() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("49");
			if (t == null) {
				log.fine("field 49 not found");
				return null;
			} else {
				return new Field49(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 53A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 53A at MT700 is expected to be the only one.
	 * 
	 * @return a Field53A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field53A getField53A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("53A");
			if (t == null) {
				log.fine("field 53A not found");
				return null;
			} else {
				return new Field53A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 53D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 53D at MT700 is expected to be the only one.
	 * 
	 * @return a Field53D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field53D getField53D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("53D");
			if (t == null) {
				log.fine("field 53D not found");
				return null;
			} else {
				return new Field53D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 78, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 78 at MT700 is expected to be the only one.
	 * 
	 * @return a Field78 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field78 getField78() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("78");
			if (t == null) {
				log.fine("field 78 not found");
				return null;
			} else {
				return new Field78(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57A at MT700 is expected to be the only one.
	 * 
	 * @return a Field57A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field57A getField57A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("57A");
			if (t == null) {
				log.fine("field 57A not found");
				return null;
			} else {
				return new Field57A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57B at MT700 is expected to be the only one.
	 * 
	 * @return a Field57B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field57B getField57B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("57B");
			if (t == null) {
				log.fine("field 57B not found");
				return null;
			} else {
				return new Field57B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57D at MT700 is expected to be the only one.
	 * 
	 * @return a Field57D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field57D getField57D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("57D");
			if (t == null) {
				log.fine("field 57D not found");
				return null;
			} else {
				return new Field57D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 72 at MT700 is expected to be the only one.
	 * 
	 * @return a Field72 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field72 getField72() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("72");
			if (t == null) {
				log.fine("field 72 not found");
				return null;
			} else {
				return new Field72(t.getValue());
			}
		}
	}
	

/*
 * sequences code
 *
 */ 





}

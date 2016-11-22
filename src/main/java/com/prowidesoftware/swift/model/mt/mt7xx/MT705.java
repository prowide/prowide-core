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
 * MT 705<br />
 * Pre-Advice of a Documentary Credit<br />
 <h1>MT705 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="field"><em>Field 40</em>
Letter options: A<br/></div><div class="field"><em>Field 20</em>
Letter options: null<br/></div><div class="field"><em>Field 31</em>
Letter options: D<br/></div><div class="field"><em>Field 50</em>
Letter options: null<br/></div><div class="field"><em>Field 59</em>
Letter options: null<br/></div><div class="field"><em>Field 32</em>
Letter options: B<br/></div><div class="field"><em>Field 39</em>
Letter options: A<br/></div><div class="field"><em>Field 39</em>
Letter options: B<br/></div><div class="field"><em>Field 39</em>
Letter options: C<br/></div><div class="field"><em>Field 41</em>
Letter options: A,D<br/></div><div class="field"><em>Field 44</em>
Letter options: A<br/></div><div class="field"><em>Field 44</em>
Letter options: E<br/></div><div class="field"><em>Field 44</em>
Letter options: F<br/></div><div class="field"><em>Field 44</em>
Letter options: B<br/></div><div class="field"><em>Field 44</em>
Letter options: C<br/></div><div class="field"><em>Field 44</em>
Letter options: D<br/></div><div class="field"><em>Field 45</em>
Letter options: A<br/></div><div class="field"><em>Field 57</em>
Letter options: A,B,D<br/></div><div class="field"><em>Field 79</em>
Letter options: null<br/></div><div class="field"><em>Field 72</em>
Letter options: null<br/></div></div>

 </pre>
 * <em>This source code is specific to release SRU 2016</em><br /> 
 *
 *		 
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT705 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT705.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "705";
	
// begin qualifiers constants	

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
	* Constant for qualifier with value REVOCABLE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REVOCABLE
	* @see com.prowidesoftware.swift.SchemeConstantsR#REVOCABLE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REVOCABLE = "REVOCABLE";

// end qualifiers constants	

	/**
	 * Creates an MT705 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT705 content
	 */
	public MT705(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT705 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT705 content, the parameter can not be <code>null</code>
	 * @see #MT705(String)
	 */
	public MT705(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT705 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT705 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT705(String)
	 * @since 7.7
	 */
	public static MT705 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT705(m.message());
	}
	
	/**
	 * Creates and initializes a new MT705 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT705() {
		super(705);
	}
	
	/**
	 * Creates and initializes a new MT705 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT705(final String sender, final String receiver) {
		super(705, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT705(sender, receiver)</code>
	* @see #MT705(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT705(final int messageType, final String sender, final String receiver) {
		super(705, sender, receiver);
	}
	
	/**
	 * Creates a new MT705 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT705(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT705 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT705 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT705 or null if fin is null 
	 * @since 7.7
	 */
	public static MT705 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT705(fin);
    }
    
    /**
	 * Creates a new MT705 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT705(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT705 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT705 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT705 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT705(stream);
    }
    
    /**
	 * Creates a new MT705 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT705(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT705 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT705 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT705 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT705(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "705";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT705 append(final SwiftTagListBlock block) {
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
	public MT705 append(final Tag ... tags) {
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
	public MT705 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 40A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 40A at MT705 is expected to be the only one.
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
	 * The first occurrence of field 20 at MT705 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 31D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31D at MT705 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 50, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 50 at MT705 is expected to be the only one.
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
	 * The first occurrence of field 59 at MT705 is expected to be the only one.
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
	 * The first occurrence of field 32B at MT705 is expected to be the only one.
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
	 * The first occurrence of field 39A at MT705 is expected to be the only one.
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
	 * The first occurrence of field 39B at MT705 is expected to be the only one.
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
	 * The first occurrence of field 39C at MT705 is expected to be the only one.
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
	 * The first occurrence of field 41A at MT705 is expected to be the only one.
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
	 * The first occurrence of field 41D at MT705 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 44A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 44A at MT705 is expected to be the only one.
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
	 * The first occurrence of field 44E at MT705 is expected to be the only one.
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
	 * The first occurrence of field 44F at MT705 is expected to be the only one.
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
	 * The first occurrence of field 44B at MT705 is expected to be the only one.
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
	 * The first occurrence of field 44C at MT705 is expected to be the only one.
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
	 * The first occurrence of field 44D at MT705 is expected to be the only one.
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
	 * The first occurrence of field 45A at MT705 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 57A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57A at MT705 is expected to be the only one.
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
	 * The first occurrence of field 57B at MT705 is expected to be the only one.
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
	 * The first occurrence of field 57D at MT705 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 79, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 79 at MT705 is expected to be the only one.
	 * 
	 * @return a Field79 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field79 getField79() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("79");
			if (t == null) {
				log.fine("field 79 not found");
				return null;
			} else {
				return new Field79(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 72 at MT705 is expected to be the only one.
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

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
 package com.prowidesoftware.swift.model.mt.mt4xx;

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
 * MT 416<br />
 * Advice of Non-Payment/Non-Acceptance<br />
 <h1>MT416 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="sequence">
<em>Sequence A</em><br/>
<div class="field"><em>Field 20</em>
Letter options: null<br/></div><div class="field"><em>Field 21</em>
Letter options: null<br/></div><div class="field"><em>Field 23</em>
Letter options: E<br/></div><div class="field"><em>Field 51</em>
Letter options: A<br/></div><div class="field"><em>Field 53</em>
Letter options: A,B<br/></div><div class="field"><em>Field 71</em>
Letter options: F<br/></div><div class="field"><em>Field 77</em>
Letter options: A<br/></div></blockquote>
<div class="sequence">
<em>Sequence B</em><br/>
<div class="field"><em>Field 21</em>
Letter options: A<br/></div><div class="field"><em>Field 23</em>
Letter options: E<br/></div><div class="field"><em>Field 21</em>
Letter options: C<br/></div><div class="field"><em>Field 32</em>
Letter options: A,B,K<br/></div><div class="field"><em>Field 50</em>
Letter options: D<br/></div><div class="field"><em>Field 59</em>
Letter options: null<br/></div><div class="field"><em>Field 71</em>
Letter options: F<br/></div><div class="field"><em>Field 77</em>
Letter options: A<br/></div></blockquote>
</div>

 </pre>
 * <em>This source code is specific to release SRU 2016</em><br /> 
 *
 *		 
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT416 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT416.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "416";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value AMAM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMAM
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMAM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AMAM = "AMAM";

	/**
	* Constant for qualifier with value AMTL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMTL
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMTL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AMTL = "AMTL";

	/**
	* Constant for qualifier with value AUTH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AUTH
	* @see com.prowidesoftware.swift.SchemeConstantsA#AUTH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AUTH = "AUTH";

	/**
	* Constant for qualifier with value CHQB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CHQB
	* @see com.prowidesoftware.swift.SchemeConstantsC#CHQB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CHQB = "CHQB";

	/**
	* Constant for qualifier with value CLOS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLOS
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLOS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLOS = "CLOS";

	/**
	* Constant for qualifier with value CMSW 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CMSW
	* @see com.prowidesoftware.swift.SchemeConstantsC#CMSW
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CMSW = "CMSW";

	/**
	* Constant for qualifier with value CMTO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CMTO
	* @see com.prowidesoftware.swift.SchemeConstantsC#CMTO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CMTO = "CMTO";

	/**
	* Constant for qualifier with value CMZB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CMZB
	* @see com.prowidesoftware.swift.SchemeConstantsC#CMZB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CMZB = "CMZB";

	/**
	* Constant for qualifier with value COLN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLN
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLN = "COLN";

	/**
	* Constant for qualifier with value CORT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CORT
	* @see com.prowidesoftware.swift.SchemeConstantsC#CORT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CORT = "CORT";

	/**
	* Constant for qualifier with value DRAW 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DRAW
	* @see com.prowidesoftware.swift.SchemeConstantsD#DRAW
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DRAW = "DRAW";

	/**
	* Constant for qualifier with value DUPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DUPL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DUPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DUPL = "DUPL";

	/**
	* Constant for qualifier with value EQUI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EQUI
	* @see com.prowidesoftware.swift.SchemeConstantsE#EQUI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EQUI = "EQUI";

	/**
	* Constant for qualifier with value FRAU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FRAU
	* @see com.prowidesoftware.swift.SchemeConstantsF#FRAU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FRAU = "FRAU";

	/**
	* Constant for qualifier with value FROZ 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FROZ
	* @see com.prowidesoftware.swift.SchemeConstantsF#FROZ
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FROZ = "FROZ";

	/**
	* Constant for qualifier with value FRWD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FRWD
	* @see com.prowidesoftware.swift.SchemeConstantsF#FRWD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FRWD = "FRWD";

	/**
	* Constant for qualifier with value HOLD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsH.HOLD
	* @see com.prowidesoftware.swift.SchemeConstantsH#HOLD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String HOLD = "HOLD";

	/**
	* Constant for qualifier with value INCH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INCH
	* @see com.prowidesoftware.swift.SchemeConstantsI#INCH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INCH = "INCH";

	/**
	* Constant for qualifier with value INSF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INSF
	* @see com.prowidesoftware.swift.SchemeConstantsI#INSF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INSF = "INSF";

	/**
	* Constant for qualifier with value INSI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INSI
	* @see com.prowidesoftware.swift.SchemeConstantsI#INSI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INSI = "INSI";

	/**
	* Constant for qualifier with value INTC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INTC
	* @see com.prowidesoftware.swift.SchemeConstantsI#INTC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INTC = "INTC";

	/**
	* Constant for qualifier with value INVA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INVA
	* @see com.prowidesoftware.swift.SchemeConstantsI#INVA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INVA = "INVA";

	/**
	* Constant for qualifier with value NACC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NACC
	* @see com.prowidesoftware.swift.SchemeConstantsN#NACC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NACC = "NACC";

	/**
	* Constant for qualifier with value NAUT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NAUT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NAUT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NAUT = "NAUT";

	/**
	* Constant for qualifier with value NELI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NELI
	* @see com.prowidesoftware.swift.SchemeConstantsN#NELI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NELI = "NELI";

	/**
	* Constant for qualifier with value NETS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NETS
	* @see com.prowidesoftware.swift.SchemeConstantsN#NETS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NETS = "NETS";

	/**
	* Constant for qualifier with value NMAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NMAT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NMAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NMAT = "NMAT";

	/**
	* Constant for qualifier with value NPAY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NPAY
	* @see com.prowidesoftware.swift.SchemeConstantsN#NPAY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NPAY = "NPAY";

	/**
	* Constant for qualifier with value OTHR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OTHR = "OTHR";

	/**
	* Constant for qualifier with value PHOB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PHOB
	* @see com.prowidesoftware.swift.SchemeConstantsP#PHOB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PHOB = "PHOB";

	/**
	* Constant for qualifier with value PHOI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PHOI
	* @see com.prowidesoftware.swift.SchemeConstantsP#PHOI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PHOI = "PHOI";

	/**
	* Constant for qualifier with value PHON 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PHON
	* @see com.prowidesoftware.swift.SchemeConstantsP#PHON
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PHON = "PHON";

	/**
	* Constant for qualifier with value REPA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REPA
	* @see com.prowidesoftware.swift.SchemeConstantsR#REPA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REPA = "REPA";

	/**
	* Constant for qualifier with value REVO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REVO
	* @see com.prowidesoftware.swift.SchemeConstantsR#REVO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REVO = "REVO";

	/**
	* Constant for qualifier with value RFDD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RFDD
	* @see com.prowidesoftware.swift.SchemeConstantsR#RFDD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RFDD = "RFDD";

	/**
	* Constant for qualifier with value RTGS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RTGS
	* @see com.prowidesoftware.swift.SchemeConstantsR#RTGS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RTGS = "RTGS";

	/**
	* Constant for qualifier with value RTND 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RTND
	* @see com.prowidesoftware.swift.SchemeConstantsR#RTND
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RTND = "RTND";

	/**
	* Constant for qualifier with value SDVA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SDVA
	* @see com.prowidesoftware.swift.SchemeConstantsS#SDVA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SDVA = "SDVA";

	/**
	* Constant for qualifier with value STLD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STLD
	* @see com.prowidesoftware.swift.SchemeConstantsS#STLD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STLD = "STLD";

	/**
	* Constant for qualifier with value STOP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STOP
	* @see com.prowidesoftware.swift.SchemeConstantsS#STOP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STOP = "STOP";

	/**
	* Constant for qualifier with value TELB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TELB
	* @see com.prowidesoftware.swift.SchemeConstantsT#TELB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TELB = "TELB";

	/**
	* Constant for qualifier with value TELE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TELE
	* @see com.prowidesoftware.swift.SchemeConstantsT#TELE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TELE = "TELE";

	/**
	* Constant for qualifier with value TELI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TELI
	* @see com.prowidesoftware.swift.SchemeConstantsT#TELI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TELI = "TELI";

	/**
	* Constant for qualifier with value URGP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.URGP
	* @see com.prowidesoftware.swift.SchemeConstantsU#URGP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String URGP = "URGP";

// end qualifiers constants	

	/**
	 * Creates an MT416 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT416 content
	 */
	public MT416(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT416 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT416 content, the parameter can not be <code>null</code>
	 * @see #MT416(String)
	 */
	public MT416(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT416 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT416 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT416(String)
	 * @since 7.7
	 */
	public static MT416 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT416(m.message());
	}
	
	/**
	 * Creates and initializes a new MT416 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT416() {
		super(416);
	}
	
	/**
	 * Creates and initializes a new MT416 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT416(final String sender, final String receiver) {
		super(416, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT416(sender, receiver)</code>
	* @see #MT416(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT416(final int messageType, final String sender, final String receiver) {
		super(416, sender, receiver);
	}
	
	/**
	 * Creates a new MT416 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT416(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT416 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT416 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT416 or null if fin is null 
	 * @since 7.7
	 */
	public static MT416 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT416(fin);
    }
    
    /**
	 * Creates a new MT416 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT416(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT416 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT416 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT416 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT416(stream);
    }
    
    /**
	 * Creates a new MT416 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT416(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT416 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT416 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT416 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT416(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "416";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT416 append(final SwiftTagListBlock block) {
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
	public MT416 append(final Tag ... tags) {
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
	public MT416 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT416 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 21, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 21 at MT416 is expected to be the only one.
	 * 
	 * @return a Field21 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21 getField21() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("21");
			if (t == null) {
				log.fine("field 21 not found");
				return null;
			} else {
				return new Field21(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 51A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 51A at MT416 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 53A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 53A at MT416 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 53B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 53B at MT416 is expected to be the only one.
	 * 
	 * @return a Field53B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field53B getField53B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("53B");
			if (t == null) {
				log.fine("field 53B not found");
				return null;
			} else {
				return new Field53B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 21A at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21A> getField21A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("21A");
			final List<Field21A> result = new ArrayList<Field21A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field21A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 23E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 23E at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field23E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field23E> getField23E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("23E");
			final List<Field23E> result = new ArrayList<Field23E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field23E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 21C at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21C> getField21C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("21C");
			final List<Field21C> result = new ArrayList<Field21C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field21C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32A at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32A> getField32A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("32A");
			final List<Field32A> result = new ArrayList<Field32A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field32A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32B at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32B> getField32B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("32B");
			final List<Field32B> result = new ArrayList<Field32B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field32B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32K, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32K at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32K> getField32K() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("32K");
			final List<Field32K> result = new ArrayList<Field32K>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field32K(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 50D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 50D at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field50D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field50D> getField50D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("50D");
			final List<Field50D> result = new ArrayList<Field50D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field50D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 59, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 59 at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field59 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field59> getField59() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("59");
			final List<Field59> result = new ArrayList<Field59>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field59(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 71F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 71F at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field71F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field71F> getField71F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("71F");
			final List<Field71F> result = new ArrayList<Field71F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field71F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 77A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 77A at MT416 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field77A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field77A> getField77A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("77A");
			final List<Field77A> result = new ArrayList<Field77A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field77A(tags[i].getValue()));
			}
			return result;
		}
	}
	

/*
 * sequences code
 *
 */ 


// BaseSequenceCodeGenerator [seq=A]
	/**
	* Class for Sequence "A" of MT 416
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
		* Last mandatory tagname of the sequence: <em>"21"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] END = { "21"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		public static final String[] TAIL = new String[]{ "23E", "51A", "53A", "53B", "71F", "77A"   };

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
 

// BaseSequenceCodeGenerator [seq=B]
	/**
	* Class for Sequence "B" of MT 416
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
		* First mandatory tagname of the sequence: <em>"21A"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "21A"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"32A", "32B", "32K"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] END = { "32A", "32B", "32K"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		public static final String[] TAIL = new String[]{ "50D", "59", "71F", "77A"   };

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
 




}

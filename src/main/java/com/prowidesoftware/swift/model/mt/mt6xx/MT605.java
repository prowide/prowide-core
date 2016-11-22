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
 package com.prowidesoftware.swift.model.mt.mt6xx;

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
 * MT 605<br />
 * Commodity Notice to Receive<br />
 <h1>MT605 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="field"><em>Field 20</em>
Letter options: null<br/></div><div class="field"><em>Field 26</em>
Letter options: C<br/></div><div class="field"><em>Field 25</em>
Letter options: null<br/></div><div class="field"><em>Field 30</em>
Letter options: null<br/></div><div class="field"><em>Field 72</em>
Letter options: null<br/></div><div class="sequence">
<em>Sequence </em><br/>
<div class="field"><em>Field 21</em>
Letter options: null<br/></div><div class="field"><em>Field 23</em>
Letter options: null<br/></div><div class="field"><em>Field 26</em>
Letter options: D<br/></div><div class="field"><em>Field 32</em>
Letter options: F<br/></div><div class="field"><em>Field 82</em>
Letter options: A,B,D<br/></div><div class="field"><em>Field 86</em>
Letter options: A,B,D<br/></div><div class="field"><em>Field 87</em>
Letter options: A,B,D<br/></div><div class="field"><em>Field 88</em>
Letter options: A,B,D<br/></div><div class="field"><em>Field 72</em>
Letter options: null<br/></div></blockquote>
</div>

 </pre>
 * <em>This source code is specific to release SRU 2016</em><br /> 
 *
 *		 
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT605 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT605.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "605";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value ALLOC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ALLOC
	* @see com.prowidesoftware.swift.SchemeConstantsA#ALLOC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ALLOC = "ALLOC";

	/**
	* Constant for qualifier with value ALUM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ALUM
	* @see com.prowidesoftware.swift.SchemeConstantsA#ALUM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ALUM = "ALUM";

	/**
	* Constant for qualifier with value AMEG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMEG
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMEG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AMEG = "AMEG";

	/**
	* Constant for qualifier with value ANUG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ANUG
	* @see com.prowidesoftware.swift.SchemeConstantsA#ANUG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ANUG = "ANUG";

	/**
	* Constant for qualifier with value BRIT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BRIT
	* @see com.prowidesoftware.swift.SchemeConstantsB#BRIT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BRIT = "BRIT";

	/**
	* Constant for qualifier with value CFR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CFR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CFR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CFR = "CFR";

	/**
	* Constant for qualifier with value CIF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CIF
	* @see com.prowidesoftware.swift.SchemeConstantsC#CIF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CIF = "CIF";

	/**
	* Constant for qualifier with value CIP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CIP
	* @see com.prowidesoftware.swift.SchemeConstantsC#CIP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CIP = "CIP";

	/**
	* Constant for qualifier with value COIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COIN
	* @see com.prowidesoftware.swift.SchemeConstantsC#COIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COIN = "COIN";

	/**
	* Constant for qualifier with value COPP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COPP
	* @see com.prowidesoftware.swift.SchemeConstantsC#COPP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COPP = "COPP";

	/**
	* Constant for qualifier with value CORO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CORO
	* @see com.prowidesoftware.swift.SchemeConstantsC#CORO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CORO = "CORO";

	/**
	* Constant for qualifier with value CPT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CPT
	* @see com.prowidesoftware.swift.SchemeConstantsC#CPT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CPT = "CPT";

	/**
	* Constant for qualifier with value DAF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DAF
	* @see com.prowidesoftware.swift.SchemeConstantsD#DAF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DAF = "DAF";

	/**
	* Constant for qualifier with value DDP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DDP
	* @see com.prowidesoftware.swift.SchemeConstantsD#DDP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DDP = "DDP";

	/**
	* Constant for qualifier with value DDU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DDU
	* @see com.prowidesoftware.swift.SchemeConstantsD#DDU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DDU = "DDU";

	/**
	* Constant for qualifier with value DEQ 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DEQ
	* @see com.prowidesoftware.swift.SchemeConstantsD#DEQ
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DEQ = "DEQ";

	/**
	* Constant for qualifier with value DES 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DES
	* @see com.prowidesoftware.swift.SchemeConstantsD#DES
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DES = "DES";

	/**
	* Constant for qualifier with value DTD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DTD
	* @see com.prowidesoftware.swift.SchemeConstantsD#DTD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DTD = "DTD";

	/**
	* Constant for qualifier with value DUCA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DUCA
	* @see com.prowidesoftware.swift.SchemeConstantsD#DUCA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DUCA = "DUCA";

	/**
	* Constant for qualifier with value EXW 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXW
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXW
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXW = "EXW";

	/**
	* Constant for qualifier with value FAS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FAS
	* @see com.prowidesoftware.swift.SchemeConstantsF#FAS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FAS = "FAS";

	/**
	* Constant for qualifier with value FCA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FCA
	* @see com.prowidesoftware.swift.SchemeConstantsF#FCA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FCA = "FCA";

	/**
	* Constant for qualifier with value FOB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FOB
	* @see com.prowidesoftware.swift.SchemeConstantsF#FOB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FOB = "FOB";

	/**
	* Constant for qualifier with value FOZ 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FOZ
	* @see com.prowidesoftware.swift.SchemeConstantsF#FOZ
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FOZ = "FOZ";

	/**
	* Constant for qualifier with value FRFR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FRFR
	* @see com.prowidesoftware.swift.SchemeConstantsF#FRFR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FRFR = "FRFR";

	/**
	* Constant for qualifier with value GECU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GECU
	* @see com.prowidesoftware.swift.SchemeConstantsG#GECU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GECU = "GECU";

	/**
	* Constant for qualifier with value GOLD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GOLD
	* @see com.prowidesoftware.swift.SchemeConstantsG#GOLD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GOLD = "GOLD";

	/**
	* Constant for qualifier with value GOZ 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GOZ
	* @see com.prowidesoftware.swift.SchemeConstantsG#GOZ
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GOZ = "GOZ";

	/**
	* Constant for qualifier with value GRM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GRM
	* @see com.prowidesoftware.swift.SchemeConstantsG#GRM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GRM = "GRM";

	/**
	* Constant for qualifier with value IRID 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.IRID
	* @see com.prowidesoftware.swift.SchemeConstantsI#IRID
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String IRID = "IRID";

	/**
	* Constant for qualifier with value KLO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsK.KLO
	* @see com.prowidesoftware.swift.SchemeConstantsK#KLO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String KLO = "KLO";

	/**
	* Constant for qualifier with value KRUG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsK.KRUG
	* @see com.prowidesoftware.swift.SchemeConstantsK#KRUG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String KRUG = "KRUG";

	/**
	* Constant for qualifier with value LBTY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LBTY
	* @see com.prowidesoftware.swift.SchemeConstantsL#LBTY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LBTY = "LBTY";

	/**
	* Constant for qualifier with value LEAD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LEAD
	* @see com.prowidesoftware.swift.SchemeConstantsL#LEAD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LEAD = "LEAD";

	/**
	* Constant for qualifier with value LIT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LIT
	* @see com.prowidesoftware.swift.SchemeConstantsL#LIT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LIT = "LIT";

	/**
	* Constant for qualifier with value LOC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LOC
	* @see com.prowidesoftware.swift.SchemeConstantsL#LOC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LOC = "LOC";

	/**
	* Constant for qualifier with value LOT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LOT
	* @see com.prowidesoftware.swift.SchemeConstantsL#LOT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LOT = "LOT";

	/**
	* Constant for qualifier with value MAPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MAPL
	* @see com.prowidesoftware.swift.SchemeConstantsM#MAPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MAPL = "MAPL";

	/**
	* Constant for qualifier with value MEXP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MEXP
	* @see com.prowidesoftware.swift.SchemeConstantsM#MEXP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MEXP = "MEXP";

	/**
	* Constant for qualifier with value NBUF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NBUF
	* @see com.prowidesoftware.swift.SchemeConstantsN#NBUF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NBUF = "NBUF";

	/**
	* Constant for qualifier with value NICK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NICK
	* @see com.prowidesoftware.swift.SchemeConstantsN#NICK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NICK = "NICK";

	/**
	* Constant for qualifier with value NOBL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NOBL
	* @see com.prowidesoftware.swift.SchemeConstantsN#NOBL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NOBL = "NOBL";

	/**
	* Constant for qualifier with value NSOV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NSOV
	* @see com.prowidesoftware.swift.SchemeConstantsN#NSOV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NSOV = "NSOV";

	/**
	* Constant for qualifier with value OSMI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OSMI
	* @see com.prowidesoftware.swift.SchemeConstantsO#OSMI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OSMI = "OSMI";

	/**
	* Constant for qualifier with value OSOV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OSOV
	* @see com.prowidesoftware.swift.SchemeConstantsO#OSOV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OSOV = "OSOV";

	/**
	* Constant for qualifier with value OTH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTH
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OTH = "OTH";

	/**
	* Constant for qualifier with value OTHR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OTHR = "OTHR";

	/**
	* Constant for qualifier with value PALL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PALL
	* @see com.prowidesoftware.swift.SchemeConstantsP#PALL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PALL = "PALL";

	/**
	* Constant for qualifier with value PLAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PLAT
	* @see com.prowidesoftware.swift.SchemeConstantsP#PLAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PLAT = "PLAT";

	/**
	* Constant for qualifier with value PND 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PND
	* @see com.prowidesoftware.swift.SchemeConstantsP#PND
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PND = "PND";

	/**
	* Constant for qualifier with value POIL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.POIL
	* @see com.prowidesoftware.swift.SchemeConstantsP#POIL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String POIL = "POIL";

	/**
	* Constant for qualifier with value RHOD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RHOD
	* @see com.prowidesoftware.swift.SchemeConstantsR#RHOD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RHOD = "RHOD";

	/**
	* Constant for qualifier with value RUTH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RUTH
	* @see com.prowidesoftware.swift.SchemeConstantsR#RUTH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RUTH = "RUTH";

	/**
	* Constant for qualifier with value SAEG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SAEG
	* @see com.prowidesoftware.swift.SchemeConstantsS#SAEG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SAEG = "SAEG";

	/**
	* Constant for qualifier with value SECU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SECU
	* @see com.prowidesoftware.swift.SchemeConstantsS#SECU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SECU = "SECU";

	/**
	* Constant for qualifier with value SILV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SILV
	* @see com.prowidesoftware.swift.SchemeConstantsS#SILV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SILV = "SILV";

	/**
	* Constant for qualifier with value STAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STAT
	* @see com.prowidesoftware.swift.SchemeConstantsS#STAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STAT = "STAT";

	/**
	* Constant for qualifier with value STEE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STEE
	* @see com.prowidesoftware.swift.SchemeConstantsS#STEE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STEE = "STEE";

	/**
	* Constant for qualifier with value TAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TAL
	* @see com.prowidesoftware.swift.SchemeConstantsT#TAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TAL = "TAL";

	/**
	* Constant for qualifier with value TINA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TINA
	* @see com.prowidesoftware.swift.SchemeConstantsT#TINA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TINA = "TINA";

	/**
	* Constant for qualifier with value TITA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TITA
	* @see com.prowidesoftware.swift.SchemeConstantsT#TITA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TITA = "TITA";

	/**
	* Constant for qualifier with value TOL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TOL
	* @see com.prowidesoftware.swift.SchemeConstantsT#TOL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TOL = "TOL";

	/**
	* Constant for qualifier with value TON 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TON
	* @see com.prowidesoftware.swift.SchemeConstantsT#TON
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TON = "TON";

	/**
	* Constant for qualifier with value TOZ 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TOZ
	* @see com.prowidesoftware.swift.SchemeConstantsT#TOZ
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TOZ = "TOZ";

	/**
	* Constant for qualifier with value UNALL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UNALL
	* @see com.prowidesoftware.swift.SchemeConstantsU#UNALL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String UNALL = "UNALL";

	/**
	* Constant for qualifier with value UNT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UNT
	* @see com.prowidesoftware.swift.SchemeConstantsU#UNT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String UNT = "UNT";

	/**
	* Constant for qualifier with value VREN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VREN
	* @see com.prowidesoftware.swift.SchemeConstantsV#VREN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VREN = "VREN";

	/**
	* Constant for qualifier with value ZINC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsZ.ZINC
	* @see com.prowidesoftware.swift.SchemeConstantsZ#ZINC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ZINC = "ZINC";

// end qualifiers constants	

	/**
	 * Creates an MT605 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT605 content
	 */
	public MT605(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT605 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT605 content, the parameter can not be <code>null</code>
	 * @see #MT605(String)
	 */
	public MT605(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT605 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT605 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT605(String)
	 * @since 7.7
	 */
	public static MT605 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT605(m.message());
	}
	
	/**
	 * Creates and initializes a new MT605 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT605() {
		super(605);
	}
	
	/**
	 * Creates and initializes a new MT605 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT605(final String sender, final String receiver) {
		super(605, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT605(sender, receiver)</code>
	* @see #MT605(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT605(final int messageType, final String sender, final String receiver) {
		super(605, sender, receiver);
	}
	
	/**
	 * Creates a new MT605 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT605(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT605 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT605 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT605 or null if fin is null 
	 * @since 7.7
	 */
	public static MT605 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT605(fin);
    }
    
    /**
	 * Creates a new MT605 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT605(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT605 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT605 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT605 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT605(stream);
    }
    
    /**
	 * Creates a new MT605 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT605(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT605 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT605 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT605 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT605(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "605";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT605 append(final SwiftTagListBlock block) {
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
	public MT605 append(final Tag ... tags) {
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
	public MT605 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT605 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 26C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 26C at MT605 is expected to be the only one.
	 * 
	 * @return a Field26C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field26C getField26C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("26C");
			if (t == null) {
				log.fine("field 26C not found");
				return null;
			} else {
				return new Field26C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 25, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 25 at MT605 is expected to be the only one.
	 * 
	 * @return a Field25 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field25 getField25() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("25");
			if (t == null) {
				log.fine("field 25 not found");
				return null;
			} else {
				return new Field25(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30 at MT605 is expected to be the only one.
	 * 
	 * @return a Field30 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30 getField30() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("30");
			if (t == null) {
				log.fine("field 30 not found");
				return null;
			} else {
				return new Field30(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 21 at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21> getField21() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("21");
			final List<Field21> result = new ArrayList<Field21>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field21(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 23, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 23 at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field23 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field23> getField23() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("23");
			final List<Field23> result = new ArrayList<Field23>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field23(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 26D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 26D at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field26D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field26D> getField26D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("26D");
			final List<Field26D> result = new ArrayList<Field26D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field26D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32F at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32F> getField32F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("32F");
			final List<Field32F> result = new ArrayList<Field32F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field32F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 82A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 82A at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field82A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field82A> getField82A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("82A");
			final List<Field82A> result = new ArrayList<Field82A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field82A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 82B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 82B at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field82B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field82B> getField82B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("82B");
			final List<Field82B> result = new ArrayList<Field82B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field82B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 82D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 82D at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field82D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field82D> getField82D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("82D");
			final List<Field82D> result = new ArrayList<Field82D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field82D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 86A at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field86A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field86A> getField86A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("86A");
			final List<Field86A> result = new ArrayList<Field86A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field86A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 86B at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field86B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field86B> getField86B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("86B");
			final List<Field86B> result = new ArrayList<Field86B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field86B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 86D at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field86D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field86D> getField86D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("86D");
			final List<Field86D> result = new ArrayList<Field86D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field86D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 87A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 87A at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field87A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field87A> getField87A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("87A");
			final List<Field87A> result = new ArrayList<Field87A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field87A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 87B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 87B at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field87B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field87B> getField87B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("87B");
			final List<Field87B> result = new ArrayList<Field87B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field87B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 87D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 87D at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field87D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field87D> getField87D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("87D");
			final List<Field87D> result = new ArrayList<Field87D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field87D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 88A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 88A at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field88A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field88A> getField88A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("88A");
			final List<Field88A> result = new ArrayList<Field88A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field88A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 88B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 88B at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field88B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field88B> getField88B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("88B");
			final List<Field88B> result = new ArrayList<Field88B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field88B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 88D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 88D at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field88D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field88D> getField88D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("88D");
			final List<Field88D> result = new ArrayList<Field88D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field88D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 72, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 72 at MT605 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field72 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field72> getField72() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("72");
			final List<Field72> result = new ArrayList<Field72>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field72(tags[i].getValue()));
			}
			return result;
		}
	}
	

/*
 * sequences code
 *
 */ 


// BaseSequenceCodeGenerator [seq=_0]
	/**
	* Class for Sequence "_0" of MT 605
	*/
	public static class Sequence_0 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private Sequence_0() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private Sequence_0(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* First mandatory tagname of the sequence: <em>"21"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "21"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"87A", "87B", "87D"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] END = { "87A", "87B", "87D"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		public static final String[] TAIL = new String[]{ "88A", "88B", "88D", "72"   };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static Sequence_0 newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static Sequence_0 newInstance(final int start, final int end, final Tag ... tags) {
			final Sequence_0 result = new Sequence_0();

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
	* Get the list of Sequence_0 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<Sequence_0> getSequence_0List() {
		return getSequence_0List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of Sequence_0 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find Sequence_0 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<Sequence_0> getSequence_0List(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<Sequence_0> result = new ArrayList<Sequence_0>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(Sequence_0.START, Sequence_0.END, Sequence_0.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new Sequence_0(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 




}

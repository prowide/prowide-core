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
 * MT 607<br />
 * Commodity Credit Advice<br />
 <h1>MT607 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="field"><em>Field 20</em>
Letter options: null<br/></div><div class="field"><em>Field 21</em>
Letter options: null<br/></div><div class="field"><em>Field 26</em>
Letter options: C<br/></div><div class="field"><em>Field 25</em>
Letter options: null<br/></div><div class="field"><em>Field 26</em>
Letter options: D<br/></div><div class="field"><em>Field 30</em>
Letter options: null<br/></div><div class="field"><em>Field 32</em>
Letter options: F<br/></div><div class="field"><em>Field 82</em>
Letter options: A,D<br/></div><div class="field"><em>Field 86</em>
Letter options: A,B,D<br/></div><div class="field"><em>Field 87</em>
Letter options: A,D<br/></div><div class="field"><em>Field 88</em>
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
public class MT607 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT607.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "607";
	
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
	 * Creates an MT607 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT607 content
	 */
	public MT607(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT607 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT607 content, the parameter can not be <code>null</code>
	 * @see #MT607(String)
	 */
	public MT607(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT607 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT607 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT607(String)
	 * @since 7.7
	 */
	public static MT607 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT607(m.message());
	}
	
	/**
	 * Creates and initializes a new MT607 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT607() {
		super(607);
	}
	
	/**
	 * Creates and initializes a new MT607 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT607(final String sender, final String receiver) {
		super(607, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT607(sender, receiver)</code>
	* @see #MT607(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT607(final int messageType, final String sender, final String receiver) {
		super(607, sender, receiver);
	}
	
	/**
	 * Creates a new MT607 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT607(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT607 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT607 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT607 or null if fin is null 
	 * @since 7.7
	 */
	public static MT607 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT607(fin);
    }
    
    /**
	 * Creates a new MT607 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT607(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT607 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT607 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT607 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT607(stream);
    }
    
    /**
	 * Creates a new MT607 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT607(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT607 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT607 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT607 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT607(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "607";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT607 append(final SwiftTagListBlock block) {
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
	public MT607 append(final Tag ... tags) {
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
	public MT607 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT607 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT607 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 26C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 26C at MT607 is expected to be the only one.
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
	 * The first occurrence of field 25 at MT607 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 26D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 26D at MT607 is expected to be the only one.
	 * 
	 * @return a Field26D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field26D getField26D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("26D");
			if (t == null) {
				log.fine("field 26D not found");
				return null;
			} else {
				return new Field26D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30 at MT607 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 32F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32F at MT607 is expected to be the only one.
	 * 
	 * @return a Field32F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field32F getField32F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("32F");
			if (t == null) {
				log.fine("field 32F not found");
				return null;
			} else {
				return new Field32F(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 82A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 82A at MT607 is expected to be the only one.
	 * 
	 * @return a Field82A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field82A getField82A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("82A");
			if (t == null) {
				log.fine("field 82A not found");
				return null;
			} else {
				return new Field82A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 82D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 82D at MT607 is expected to be the only one.
	 * 
	 * @return a Field82D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field82D getField82D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("82D");
			if (t == null) {
				log.fine("field 82D not found");
				return null;
			} else {
				return new Field82D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 86A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 86A at MT607 is expected to be the only one.
	 * 
	 * @return a Field86A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field86A getField86A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("86A");
			if (t == null) {
				log.fine("field 86A not found");
				return null;
			} else {
				return new Field86A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 86B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 86B at MT607 is expected to be the only one.
	 * 
	 * @return a Field86B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field86B getField86B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("86B");
			if (t == null) {
				log.fine("field 86B not found");
				return null;
			} else {
				return new Field86B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 86D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 86D at MT607 is expected to be the only one.
	 * 
	 * @return a Field86D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field86D getField86D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("86D");
			if (t == null) {
				log.fine("field 86D not found");
				return null;
			} else {
				return new Field86D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 87A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 87A at MT607 is expected to be the only one.
	 * 
	 * @return a Field87A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field87A getField87A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("87A");
			if (t == null) {
				log.fine("field 87A not found");
				return null;
			} else {
				return new Field87A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 87D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 87D at MT607 is expected to be the only one.
	 * 
	 * @return a Field87D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field87D getField87D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("87D");
			if (t == null) {
				log.fine("field 87D not found");
				return null;
			} else {
				return new Field87D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 88A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 88A at MT607 is expected to be the only one.
	 * 
	 * @return a Field88A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field88A getField88A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("88A");
			if (t == null) {
				log.fine("field 88A not found");
				return null;
			} else {
				return new Field88A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 88B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 88B at MT607 is expected to be the only one.
	 * 
	 * @return a Field88B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field88B getField88B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("88B");
			if (t == null) {
				log.fine("field 88B not found");
				return null;
			} else {
				return new Field88B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 88D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 88D at MT607 is expected to be the only one.
	 * 
	 * @return a Field88D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field88D getField88D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("88D");
			if (t == null) {
				log.fine("field 88D not found");
				return null;
			} else {
				return new Field88D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 72 at MT607 is expected to be the only one.
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

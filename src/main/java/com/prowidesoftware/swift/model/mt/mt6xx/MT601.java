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
 * MT 601<br />
 * Commodity Option Confirmation<br />
 <h1>MT601 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="sequence">
<em>Sequence A</em><br/>
<div class="field"><em>Field 15</em>
Letter options: A<br/></div><div class="field"><em>Field 20</em>
Letter options: null<br/></div><div class="field"><em>Field 21</em>
Letter options: null<br/></div><div class="field"><em>Field 22</em>
Letter options: null<br/></div><div class="field"><em>Field 94</em>
Letter options: A<br/></div><div class="field"><em>Field 82</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 87</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 83</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 23</em>
Letter options: null<br/></div><div class="field"><em>Field 30</em>
Letter options: null<br/></div><div class="field"><em>Field 26</em>
Letter options: C<br/></div><div class="field"><em>Field 31</em>
Letter options: C<br/></div><div class="field"><em>Field 31</em>
Letter options: G<br/></div><div class="field"><em>Field 31</em>
Letter options: E<br/></div><div class="field"><em>Field 26</em>
Letter options: F<br/></div><div class="field"><em>Field 32</em>
Letter options: F<br/></div><div class="field"><em>Field 32</em>
Letter options: B<br/></div><div class="field"><em>Field 33</em>
Letter options: B<br/></div><div class="field"><em>Field 34</em>
Letter options: P,R<br/></div><div class="field"><em>Field 53</em>
Letter options: A,B,D<br/></div><div class="field"><em>Field 56</em>
Letter options: A,B,D<br/></div><div class="field"><em>Field 57</em>
Letter options: A,B,D<br/></div><div class="field"><em>Field 77</em>
Letter options: H<br/></div><div class="field"><em>Field 77</em>
Letter options: D<br/></div><div class="field"><em>Field 14</em>
Letter options: C<br/></div><div class="field"><em>Field 72</em>
Letter options: null<br/></div></blockquote>
<div class="sequence">
<em>Sequence B</em><br/>
<div class="field"><em>Field 15</em>
Letter options: B<br/></div><div class="sequence">
<em>Sequence B1</em><br/>
<div class="field"><em>Field 22</em>
Letter options: L<br/></div><div class="field"><em>Field 91</em>
Letter options: A,D,J<br/></div><div class="sequence">
<em>Sequence B1a</em><br/>
<div class="field"><em>Field 22</em>
Letter options: M<br/></div><div class="field"><em>Field 22</em>
Letter options: N<br/></div><div class="sequence">
<em>Sequence B1a1</em><br/>
<div class="field"><em>Field 22</em>
Letter options: P<br/></div><div class="field"><em>Field 22</em>
Letter options: R<br/></div></blockquote>
</blockquote>
</blockquote>
<div class="field"><em>Field 96</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 22</em>
Letter options: S<br/></div><div class="field"><em>Field 22</em>
Letter options: T<br/></div><div class="field"><em>Field 17</em>
Letter options: E<br/></div><div class="field"><em>Field 22</em>
Letter options: U<br/></div><div class="field"><em>Field 17</em>
Letter options: H<br/></div><div class="field"><em>Field 17</em>
Letter options: P<br/></div><div class="field"><em>Field 22</em>
Letter options: V<br/></div><div class="field"><em>Field 98</em>
Letter options: D<br/></div><div class="field"><em>Field 17</em>
Letter options: W<br/></div><div class="field"><em>Field 17</em>
Letter options: Y<br/></div><div class="field"><em>Field 17</em>
Letter options: Z<br/></div><div class="field"><em>Field 22</em>
Letter options: Q<br/></div><div class="field"><em>Field 17</em>
Letter options: L<br/></div><div class="field"><em>Field 17</em>
Letter options: M<br/></div><div class="field"><em>Field 17</em>
Letter options: Q<br/></div><div class="field"><em>Field 17</em>
Letter options: S<br/></div><div class="field"><em>Field 17</em>
Letter options: X<br/></div><div class="field"><em>Field 17</em>
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
public class MT601 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT601.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "601";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value A 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.A
	* @see com.prowidesoftware.swift.SchemeConstantsA#A
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String A = "A";

	/**
	* Constant for qualifier with value AGNT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AGNT
	* @see com.prowidesoftware.swift.SchemeConstantsA#AGNT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AGNT = "AGNT";

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
	* Constant for qualifier with value AUTO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AUTO
	* @see com.prowidesoftware.swift.SchemeConstantsA#AUTO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AUTO = "AUTO";

	/**
	* Constant for qualifier with value B 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.B
	* @see com.prowidesoftware.swift.SchemeConstantsB#B
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String B = "B";

	/**
	* Constant for qualifier with value BILA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BILA
	* @see com.prowidesoftware.swift.SchemeConstantsB#BILA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BILA = "BILA";

	/**
	* Constant for qualifier with value BRIT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BRIT
	* @see com.prowidesoftware.swift.SchemeConstantsB#BRIT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BRIT = "BRIT";

	/**
	* Constant for qualifier with value BROK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BROK
	* @see com.prowidesoftware.swift.SchemeConstantsB#BROK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BROK = "BROK";

	/**
	* Constant for qualifier with value BUY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BUY
	* @see com.prowidesoftware.swift.SchemeConstantsB#BUY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BUY = "BUY";

	/**
	* Constant for qualifier with value C 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.C
	* @see com.prowidesoftware.swift.SchemeConstantsC#C
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String C = "C";

	/**
	* Constant for qualifier with value CALL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CALL
	* @see com.prowidesoftware.swift.SchemeConstantsC#CALL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CALL = "CALL";

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
	* Constant for qualifier with value E 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.E
	* @see com.prowidesoftware.swift.SchemeConstantsE#E
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String E = "E";

	/**
	* Constant for qualifier with value EXW 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXW
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXW
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXW = "EXW";

	/**
	* Constant for qualifier with value F 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.F
	* @see com.prowidesoftware.swift.SchemeConstantsF#F
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String F = "F";

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
	* Constant for qualifier with value ISDA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ISDA
	* @see com.prowidesoftware.swift.SchemeConstantsI#ISDA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ISDA = "ISDA";

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
	* Constant for qualifier with value MANU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MANU
	* @see com.prowidesoftware.swift.SchemeConstantsM#MANU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MANU = "MANU";

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
	* Constant for qualifier with value N 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.N
	* @see com.prowidesoftware.swift.SchemeConstantsN#N
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String N = "N";

	/**
	* Constant for qualifier with value NBUF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NBUF
	* @see com.prowidesoftware.swift.SchemeConstantsN#NBUF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NBUF = "NBUF";

	/**
	* Constant for qualifier with value NETCASH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NETCASH
	* @see com.prowidesoftware.swift.SchemeConstantsN#NETCASH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NETCASH = "NETCASH";

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
	* Constant for qualifier with value O 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.O
	* @see com.prowidesoftware.swift.SchemeConstantsO#O
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String O = "O";

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
	* Constant for qualifier with value OTHER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHER
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OTHER = "OTHER";

	/**
	* Constant for qualifier with value OTHR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OTHR = "OTHR";

	/**
	* Constant for qualifier with value P 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.P
	* @see com.prowidesoftware.swift.SchemeConstantsP#P
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String P = "P";

	/**
	* Constant for qualifier with value PALL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PALL
	* @see com.prowidesoftware.swift.SchemeConstantsP#PALL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PALL = "PALL";

	/**
	* Constant for qualifier with value PHYSICAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PHYSICAL
	* @see com.prowidesoftware.swift.SchemeConstantsP#PHYSICAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PHYSICAL = "PHYSICAL";

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
	* Constant for qualifier with value PUT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PUT
	* @see com.prowidesoftware.swift.SchemeConstantsP#PUT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PUT = "PUT";

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
	* Constant for qualifier with value SELL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SELL
	* @see com.prowidesoftware.swift.SchemeConstantsS#SELL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SELL = "SELL";

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
	* Constant for qualifier with value U 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.U
	* @see com.prowidesoftware.swift.SchemeConstantsU#U
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String U = "U";

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
	* Constant for qualifier with value V 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.V
	* @see com.prowidesoftware.swift.SchemeConstantsV#V
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String V = "V";

	/**
	* Constant for qualifier with value VREN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VREN
	* @see com.prowidesoftware.swift.SchemeConstantsV#VREN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VREN = "VREN";

	/**
	* Constant for qualifier with value Y 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsY.Y
	* @see com.prowidesoftware.swift.SchemeConstantsY#Y
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String Y = "Y";

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
	 * Creates an MT601 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT601 content
	 */
	public MT601(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT601 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT601 content, the parameter can not be <code>null</code>
	 * @see #MT601(String)
	 */
	public MT601(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT601 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT601 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT601(String)
	 * @since 7.7
	 */
	public static MT601 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT601(m.message());
	}
	
	/**
	 * Creates and initializes a new MT601 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT601() {
		super(601);
	}
	
	/**
	 * Creates and initializes a new MT601 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT601(final String sender, final String receiver) {
		super(601, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT601(sender, receiver)</code>
	* @see #MT601(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT601(final int messageType, final String sender, final String receiver) {
		super(601, sender, receiver);
	}
	
	/**
	 * Creates a new MT601 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT601(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT601 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT601 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT601 or null if fin is null 
	 * @since 7.7
	 */
	public static MT601 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT601(fin);
    }
    
    /**
	 * Creates a new MT601 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT601(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT601 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT601 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT601 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT601(stream);
    }
    
    /**
	 * Creates a new MT601 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT601(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT601 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT601 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT601 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT601(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "601";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT601 append(final SwiftTagListBlock block) {
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
	public MT601 append(final Tag ... tags) {
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
	public MT601 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15A at MT601 is expected to be the only one.
	 * 
	 * @return a Field15A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15A getField15A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15A");
			if (t == null) {
				log.fine("field 15A not found");
				return null;
			} else {
				return new Field15A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT601 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22 at MT601 is expected to be the only one.
	 * 
	 * @return a Field22 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22 getField22() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("22");
			if (t == null) {
				log.fine("field 22 not found");
				return null;
			} else {
				return new Field22(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 94A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 94A at MT601 is expected to be the only one.
	 * 
	 * @return a Field94A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field94A getField94A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("94A");
			if (t == null) {
				log.fine("field 94A not found");
				return null;
			} else {
				return new Field94A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 82A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 82A at MT601 is expected to be the only one.
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
	 * The first occurrence of field 82D at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 82J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 82J at MT601 is expected to be the only one.
	 * 
	 * @return a Field82J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field82J getField82J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("82J");
			if (t == null) {
				log.fine("field 82J not found");
				return null;
			} else {
				return new Field82J(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 87A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 87A at MT601 is expected to be the only one.
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
	 * The first occurrence of field 87D at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 87J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 87J at MT601 is expected to be the only one.
	 * 
	 * @return a Field87J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field87J getField87J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("87J");
			if (t == null) {
				log.fine("field 87J not found");
				return null;
			} else {
				return new Field87J(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 83A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 83A at MT601 is expected to be the only one.
	 * 
	 * @return a Field83A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field83A getField83A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("83A");
			if (t == null) {
				log.fine("field 83A not found");
				return null;
			} else {
				return new Field83A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 83D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 83D at MT601 is expected to be the only one.
	 * 
	 * @return a Field83D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field83D getField83D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("83D");
			if (t == null) {
				log.fine("field 83D not found");
				return null;
			} else {
				return new Field83D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 83J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 83J at MT601 is expected to be the only one.
	 * 
	 * @return a Field83J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field83J getField83J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("83J");
			if (t == null) {
				log.fine("field 83J not found");
				return null;
			} else {
				return new Field83J(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23 at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30 at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 26C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 26C at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 31C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31C at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 31G, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31G at MT601 is expected to be the only one.
	 * 
	 * @return a Field31G object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31G getField31G() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("31G");
			if (t == null) {
				log.fine("field 31G not found");
				return null;
			} else {
				return new Field31G(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31E at MT601 is expected to be the only one.
	 * 
	 * @return a Field31E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31E getField31E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("31E");
			if (t == null) {
				log.fine("field 31E not found");
				return null;
			} else {
				return new Field31E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 26F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 26F at MT601 is expected to be the only one.
	 * 
	 * @return a Field26F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field26F getField26F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("26F");
			if (t == null) {
				log.fine("field 26F not found");
				return null;
			} else {
				return new Field26F(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32F at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32B at MT601 is expected to be the only one.
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
	 * The first occurrence of field 33B at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 34P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 34P at MT601 is expected to be the only one.
	 * 
	 * @return a Field34P object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field34P getField34P() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("34P");
			if (t == null) {
				log.fine("field 34P not found");
				return null;
			} else {
				return new Field34P(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 34R, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 34R at MT601 is expected to be the only one.
	 * 
	 * @return a Field34R object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field34R getField34R() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("34R");
			if (t == null) {
				log.fine("field 34R not found");
				return null;
			} else {
				return new Field34R(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 53A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 53A at MT601 is expected to be the only one.
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
	 * The first occurrence of field 53B at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 53D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 53D at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 56A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 56A at MT601 is expected to be the only one.
	 * 
	 * @return a Field56A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field56A getField56A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("56A");
			if (t == null) {
				log.fine("field 56A not found");
				return null;
			} else {
				return new Field56A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 56B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 56B at MT601 is expected to be the only one.
	 * 
	 * @return a Field56B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field56B getField56B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("56B");
			if (t == null) {
				log.fine("field 56B not found");
				return null;
			} else {
				return new Field56B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 56D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 56D at MT601 is expected to be the only one.
	 * 
	 * @return a Field56D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field56D getField56D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("56D");
			if (t == null) {
				log.fine("field 56D not found");
				return null;
			} else {
				return new Field56D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 57A at MT601 is expected to be the only one.
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
	 * The first occurrence of field 57B at MT601 is expected to be the only one.
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
	 * The first occurrence of field 57D at MT601 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 77H, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 77H at MT601 is expected to be the only one.
	 * 
	 * @return a Field77H object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77H getField77H() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("77H");
			if (t == null) {
				log.fine("field 77H not found");
				return null;
			} else {
				return new Field77H(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 77D at MT601 is expected to be the only one.
	 * 
	 * @return a Field77D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77D getField77D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("77D");
			if (t == null) {
				log.fine("field 77D not found");
				return null;
			} else {
				return new Field77D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 14C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 14C at MT601 is expected to be the only one.
	 * 
	 * @return a Field14C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field14C getField14C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("14C");
			if (t == null) {
				log.fine("field 14C not found");
				return null;
			} else {
				return new Field14C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 72 at MT601 is expected to be the only one.
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
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15B at MT601 is expected to be the only one.
	 * 
	 * @return a Field15B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15B getField15B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15B");
			if (t == null) {
				log.fine("field 15B not found");
				return null;
			} else {
				return new Field15B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 96A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 96A at MT601 is expected to be the only one.
	 * 
	 * @return a Field96A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field96A getField96A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("96A");
			if (t == null) {
				log.fine("field 96A not found");
				return null;
			} else {
				return new Field96A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 96D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 96D at MT601 is expected to be the only one.
	 * 
	 * @return a Field96D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field96D getField96D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("96D");
			if (t == null) {
				log.fine("field 96D not found");
				return null;
			} else {
				return new Field96D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 96J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 96J at MT601 is expected to be the only one.
	 * 
	 * @return a Field96J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field96J getField96J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("96J");
			if (t == null) {
				log.fine("field 96J not found");
				return null;
			} else {
				return new Field96J(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22T, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22T at MT601 is expected to be the only one.
	 * 
	 * @return a Field22T object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22T getField22T() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("22T");
			if (t == null) {
				log.fine("field 22T not found");
				return null;
			} else {
				return new Field22T(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17E at MT601 is expected to be the only one.
	 * 
	 * @return a Field17E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17E getField17E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17E");
			if (t == null) {
				log.fine("field 17E not found");
				return null;
			} else {
				return new Field17E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22U, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22U at MT601 is expected to be the only one.
	 * 
	 * @return a Field22U object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22U getField22U() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("22U");
			if (t == null) {
				log.fine("field 22U not found");
				return null;
			} else {
				return new Field22U(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17H, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17H at MT601 is expected to be the only one.
	 * 
	 * @return a Field17H object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17H getField17H() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17H");
			if (t == null) {
				log.fine("field 17H not found");
				return null;
			} else {
				return new Field17H(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17P at MT601 is expected to be the only one.
	 * 
	 * @return a Field17P object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17P getField17P() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17P");
			if (t == null) {
				log.fine("field 17P not found");
				return null;
			} else {
				return new Field17P(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22V, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22V at MT601 is expected to be the only one.
	 * 
	 * @return a Field22V object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22V getField22V() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("22V");
			if (t == null) {
				log.fine("field 22V not found");
				return null;
			} else {
				return new Field22V(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 98D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 98D at MT601 is expected to be the only one.
	 * 
	 * @return a Field98D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field98D getField98D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("98D");
			if (t == null) {
				log.fine("field 98D not found");
				return null;
			} else {
				return new Field98D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17W, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17W at MT601 is expected to be the only one.
	 * 
	 * @return a Field17W object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17W getField17W() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17W");
			if (t == null) {
				log.fine("field 17W not found");
				return null;
			} else {
				return new Field17W(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17Y, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17Y at MT601 is expected to be the only one.
	 * 
	 * @return a Field17Y object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17Y getField17Y() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17Y");
			if (t == null) {
				log.fine("field 17Y not found");
				return null;
			} else {
				return new Field17Y(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17Z, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17Z at MT601 is expected to be the only one.
	 * 
	 * @return a Field17Z object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17Z getField17Z() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17Z");
			if (t == null) {
				log.fine("field 17Z not found");
				return null;
			} else {
				return new Field17Z(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22Q, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22Q at MT601 is expected to be the only one.
	 * 
	 * @return a Field22Q object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22Q getField22Q() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("22Q");
			if (t == null) {
				log.fine("field 22Q not found");
				return null;
			} else {
				return new Field22Q(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17L at MT601 is expected to be the only one.
	 * 
	 * @return a Field17L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17L getField17L() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17L");
			if (t == null) {
				log.fine("field 17L not found");
				return null;
			} else {
				return new Field17L(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17M, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17M at MT601 is expected to be the only one.
	 * 
	 * @return a Field17M object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17M getField17M() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17M");
			if (t == null) {
				log.fine("field 17M not found");
				return null;
			} else {
				return new Field17M(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17Q, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17Q at MT601 is expected to be the only one.
	 * 
	 * @return a Field17Q object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17Q getField17Q() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17Q");
			if (t == null) {
				log.fine("field 17Q not found");
				return null;
			} else {
				return new Field17Q(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17S, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17S at MT601 is expected to be the only one.
	 * 
	 * @return a Field17S object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17S getField17S() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17S");
			if (t == null) {
				log.fine("field 17S not found");
				return null;
			} else {
				return new Field17S(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17X, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17X at MT601 is expected to be the only one.
	 * 
	 * @return a Field17X object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17X getField17X() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17X");
			if (t == null) {
				log.fine("field 17X not found");
				return null;
			} else {
				return new Field17X(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17A at MT601 is expected to be the only one.
	 * 
	 * @return a Field17A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17A getField17A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17A");
			if (t == null) {
				log.fine("field 17A not found");
				return null;
			} else {
				return new Field17A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22L at MT601 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22L> getField22L() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22L");
			final List<Field22L> result = new ArrayList<Field22L>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22L(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 91A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 91A at MT601 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field91A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field91A> getField91A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("91A");
			final List<Field91A> result = new ArrayList<Field91A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field91A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 91D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 91D at MT601 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field91D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field91D> getField91D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("91D");
			final List<Field91D> result = new ArrayList<Field91D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field91D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 91J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 91J at MT601 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field91J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field91J> getField91J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("91J");
			final List<Field91J> result = new ArrayList<Field91J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field91J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22M, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22M at MT601 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22M objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22M> getField22M() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22M");
			final List<Field22M> result = new ArrayList<Field22M>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22M(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22N, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22N at MT601 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22N objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22N> getField22N() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22N");
			final List<Field22N> result = new ArrayList<Field22N>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22N(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22P at MT601 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22P> getField22P() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22P");
			final List<Field22P> result = new ArrayList<Field22P>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22P(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22R at MT601 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22R> getField22R() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22R");
			final List<Field22R> result = new ArrayList<Field22R>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22R(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22S at MT601 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22S> getField22S() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22S");
			final List<Field22S> result = new ArrayList<Field22S>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22S(tags[i].getValue()));
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
	* Class for Sequence "A" of MT 601
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
	* Class for Sequence "B" of MT 601
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


// BaseSequenceCodeGenerator [seq=B1]
	/**
	* Class for Sequence "B1" of MT 601
	*/
	public static class SequenceB1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceB1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceB1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* tagname of the first tag in the sequence which must be mandatory.
		* may be null if we cannot determine this safely
		*/
		public static final String START_NAME =  "22L"  ;
	}


// BaseSequenceCodeGenerator [seq=B1a]
	/**
	* Class for Sequence "B1a" of MT 601
	*/
	public static class SequenceB1a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceB1a() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceB1a(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* First mandatory tagname of the sequence: <em>"22M"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "22M"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"22N"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] END = { "22N"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		public static final String[] TAIL = new String[]{  };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB1a newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB1a newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceB1a result = new SequenceB1a();

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
	* Get the list of SequenceB1a delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceB1a> getSequenceB1aList() {
		return getSequenceB1aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceB1a delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceB1a within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceB1a> getSequenceB1aList(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceB1a> result = new ArrayList<SequenceB1a>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceB1a.START, SequenceB1a.END, SequenceB1a.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceB1a(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 

// BaseSequenceCodeGenerator [seq=B1a1]
	/**
	* Class for Sequence "B1a1" of MT 601
	*/
	public static class SequenceB1a1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceB1a1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceB1a1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* First mandatory tagname of the sequence: <em>"22P"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "22P"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"22R"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] END = { "22R"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		public static final String[] TAIL = new String[]{  };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB1a1 newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB1a1 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceB1a1 result = new SequenceB1a1();

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
	* Get the list of SequenceB1a1 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceB1a1> getSequenceB1a1List() {
		return getSequenceB1a1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceB1a1 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceB1a1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceB1a1> getSequenceB1a1List(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceB1a1> result = new ArrayList<SequenceB1a1>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceB1a1.START, SequenceB1a1.END, SequenceB1a1.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceB1a1(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 




}

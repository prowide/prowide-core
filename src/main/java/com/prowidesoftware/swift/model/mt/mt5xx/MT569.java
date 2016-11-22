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
 package com.prowidesoftware.swift.model.mt.mt5xx;

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
 * MT 569<br />
 * Triparty Collateral and Exposure Statement<br />
 <h1>MT569 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="sequence">
<em>Sequence A</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 28</em>
Letter options: E<br/></div><div class="field"><em>Field 13</em>
Letter options: A<br/></div><div class="field"><em>Field 20</em>
Letter options: C<br/></div><div class="field"><em>Field 23</em>
Letter options: G<br/></div><div class="field"><em>Field 98</em>
Letter options: A,C,E<br/></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 H</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="sequence">
<em>Sequence A1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 L</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 97</em>
Letter options: A,B<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence A2</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 13</em>
Letter options: A,B<br/></div><div class="field"><em>Field 20</em>
Letter options: C<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence B</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 92</em>
Letter options: A<br/></div><div class="field"><em>Field 25</em>
Letter options: D<br/></div><div class="field"><em>Field 98</em>
Letter options: A,C<br/></div><div class="field"><em>Field 70</em>
Letter options: E<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence C</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F,H</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 92</em>
Letter options: A<br/></div><div class="field"><em>Field 25</em>
Letter options: D<br/></div><div class="sequence">
<em>Sequence C1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 13</em><br/>
<blockquote><ul><it><em>FieldsetItem 13 B</em><br/>
</it><it><em>FieldsetItem 13 B</em><br/>
</it><it><em>FieldsetItem 13 B</em><br/>
</it><it><em>FieldsetItem 13 B</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 L</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 92</em>
Letter options: A<br/></div><div class="field"><em>Field 25</em>
Letter options: D<br/></div><div class="sequence">
<em>Sequence C1a</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 20</em><br/>
<blockquote><ul><it><em>FieldsetItem 20 C</em><br/>
</it><it><em>FieldsetItem 20 C</em><br/>
</it><it><em>FieldsetItem 20 C</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 D</em><br/>
</it><it><em>FieldsetItem 92 D</em><br/>
</it></ul></blockquote></div><div class="sequence">
<em>Sequence C1a1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 17</em><br/>
<blockquote><ul><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 98</em>
Letter options: A,C<br/></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 B</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 99</em><br/>
<blockquote><ul><it><em>FieldsetItem 99 A</em><br/>
</it><it><em>FieldsetItem 99 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 22</em>
Letter options: F<br/></div><div class="sequence">
<em>Sequence C1a1A</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 35</em>
Letter options: B<br/></div><div class="field"><em>Field 36</em>
Letter options: B<br/></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 L</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 97</em>
Letter options: A,B<br/></div><div class="field"><em>Field 25</em>
Letter options: D<br/></div><div class="field"><em>Field 11</em>
Letter options: A<br/></div><div class="field"><em>Field 90</em>
Letter options: A,B<br/></div><div class="fieldset">
<em>Fieldset 94</em><br/>
<blockquote><ul><it><em>FieldsetItem 94 B</em><br/>
</it><it><em>FieldsetItem 94 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 70</em>
Letter options: C<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence D</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
</div>

 </pre>
 * <em>This source code is specific to release SRU 2016</em><br /> 
 *
 *		 
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT569 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT569.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "569";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value ACOW 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ACOW
	* @see com.prowidesoftware.swift.SchemeConstantsA#ACOW
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ACOW = "ACOW";

	/**
	* Constant for qualifier with value ACRU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ACRU
	* @see com.prowidesoftware.swift.SchemeConstantsA#ACRU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ACRU = "ACRU";

	/**
	* Constant for qualifier with value ADDINFO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ADDINFO
	* @see com.prowidesoftware.swift.SchemeConstantsA#ADDINFO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ADDINFO = "ADDINFO";

	/**
	* Constant for qualifier with value ALTE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ALTE
	* @see com.prowidesoftware.swift.SchemeConstantsA#ALTE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ALTE = "ALTE";

	/**
	* Constant for qualifier with value AUTA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AUTA
	* @see com.prowidesoftware.swift.SchemeConstantsA#AUTA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AUTA = "AUTA";

	/**
	* Constant for qualifier with value CANC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CANC
	* @see com.prowidesoftware.swift.SchemeConstantsC#CANC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CANC = "CANC";

	/**
	* Constant for qualifier with value CCTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CCTR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CCTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CCTR = "CCTR";

	/**
	* Constant for qualifier with value CLPA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLPA
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLPA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLPA = "CLPA";

	/**
	* Constant for qualifier with value CLPB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLPB
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLPB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLPB = "CLPB";

	/**
	* Constant for qualifier with value CLPR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLPR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLPR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLPR = "CLPR";

	/**
	* Constant for qualifier with value CLTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLTR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLTR = "CLTR";

	/**
	* Constant for qualifier with value CODU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CODU
	* @see com.prowidesoftware.swift.SchemeConstantsC#CODU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CODU = "CODU";

	/**
	* Constant for qualifier with value COLA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLA
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLA = "COLA";

	/**
	* Constant for qualifier with value COLL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLL
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLL = "COLL";

	/**
	* Constant for qualifier with value COLLPRTY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLLPRTY
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLLPRTY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLLPRTY = "COLLPRTY";

	/**
	* Constant for qualifier with value COPY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COPY
	* @see com.prowidesoftware.swift.SchemeConstantsC#COPY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COPY = "COPY";

	/**
	* Constant for qualifier with value COVA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COVA
	* @see com.prowidesoftware.swift.SchemeConstantsC#COVA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COVA = "COVA";

	/**
	* Constant for qualifier with value DAAC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DAAC
	* @see com.prowidesoftware.swift.SchemeConstantsD#DAAC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DAAC = "DAAC";

	/**
	* Constant for qualifier with value DENO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DENO
	* @see com.prowidesoftware.swift.SchemeConstantsD#DENO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DENO = "DENO";

	/**
	* Constant for qualifier with value DUPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DUPL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DUPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DUPL = "DUPL";

	/**
	* Constant for qualifier with value ELIG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ELIG
	* @see com.prowidesoftware.swift.SchemeConstantsE#ELIG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ELIG = "ELIG";

	/**
	* Constant for qualifier with value EXBN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXBN
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXBN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXBN = "EXBN";

	/**
	* Constant for qualifier with value EXCH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXCH
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXCH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXCH = "EXCH";

	/**
	* Constant for qualifier with value EXRQ 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXRQ
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXRQ
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXRQ = "EXRQ";

	/**
	* Constant for qualifier with value FSBN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FSBN
	* @see com.prowidesoftware.swift.SchemeConstantsF#FSBN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FSBN = "FSBN";

	/**
	* Constant for qualifier with value GCOS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GCOS
	* @see com.prowidesoftware.swift.SchemeConstantsG#GCOS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GCOS = "GCOS";

	/**
	* Constant for qualifier with value GCST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GCST
	* @see com.prowidesoftware.swift.SchemeConstantsG#GCST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GCST = "GCST";

	/**
	* Constant for qualifier with value GENL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GENL
	* @see com.prowidesoftware.swift.SchemeConstantsG#GENL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GENL = "GENL";

	/**
	* Constant for qualifier with value GETS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GETS
	* @see com.prowidesoftware.swift.SchemeConstantsG#GETS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GETS = "GETS";

	/**
	* Constant for qualifier with value LAST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LAST
	* @see com.prowidesoftware.swift.SchemeConstantsL#LAST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LAST = "LAST";

	/**
	* Constant for qualifier with value LICO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LICO
	* @see com.prowidesoftware.swift.SchemeConstantsL#LICO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LICO = "LICO";

	/**
	* Constant for qualifier with value LINK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LINK
	* @see com.prowidesoftware.swift.SchemeConstantsL#LINK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LINK = "LINK";

	/**
	* Constant for qualifier with value MARG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MARG
	* @see com.prowidesoftware.swift.SchemeConstantsM#MARG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MARG = "MARG";

	/**
	* Constant for qualifier with value MEOR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MEOR
	* @see com.prowidesoftware.swift.SchemeConstantsM#MEOR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MEOR = "MEOR";

	/**
	* Constant for qualifier with value MERE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MERE
	* @see com.prowidesoftware.swift.SchemeConstantsM#MERE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MERE = "MERE";

	/**
	* Constant for qualifier with value MICO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MICO
	* @see com.prowidesoftware.swift.SchemeConstantsM#MICO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MICO = "MICO";

	/**
	* Constant for qualifier with value MKTB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MKTB
	* @see com.prowidesoftware.swift.SchemeConstantsM#MKTB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MKTB = "MKTB";

	/**
	* Constant for qualifier with value MKTP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MKTP
	* @see com.prowidesoftware.swift.SchemeConstantsM#MKTP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MKTP = "MKTP";

	/**
	* Constant for qualifier with value MORE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MORE
	* @see com.prowidesoftware.swift.SchemeConstantsM#MORE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MORE = "MORE";

	/**
	* Constant for qualifier with value MRKT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MRKT
	* @see com.prowidesoftware.swift.SchemeConstantsM#MRKT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MRKT = "MRKT";

	/**
	* Constant for qualifier with value MVBF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MVBF
	* @see com.prowidesoftware.swift.SchemeConstantsM#MVBF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MVBF = "MVBF";

	/**
	* Constant for qualifier with value MVPF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MVPF
	* @see com.prowidesoftware.swift.SchemeConstantsM#MVPF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MVPF = "MVPF";

	/**
	* Constant for qualifier with value NEWM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NEWM
	* @see com.prowidesoftware.swift.SchemeConstantsN#NEWM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NEWM = "NEWM";

	/**
	* Constant for qualifier with value ONLY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.ONLY
	* @see com.prowidesoftware.swift.SchemeConstantsO#ONLY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ONLY = "ONLY";

	/**
	* Constant for qualifier with value PRBN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRBN
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRBN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRBN = "PRBN";

	/**
	* Constant for qualifier with value PREP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PREP
	* @see com.prowidesoftware.swift.SchemeConstantsP#PREP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PREP = "PREP";

	/**
	* Constant for qualifier with value PREV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PREV
	* @see com.prowidesoftware.swift.SchemeConstantsP#PREV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PREV = "PREV";

	/**
	* Constant for qualifier with value PRIC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRIC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRIC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRIC = "PRIC";

	/**
	* Constant for qualifier with value PRSS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRSS
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRSS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRSS = "PRSS";

	/**
	* Constant for qualifier with value PTYA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PTYA
	* @see com.prowidesoftware.swift.SchemeConstantsP#PTYA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PTYA = "PTYA";

	/**
	* Constant for qualifier with value PTYB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PTYB
	* @see com.prowidesoftware.swift.SchemeConstantsP#PTYB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PTYB = "PTYB";

	/**
	* Constant for qualifier with value QAGE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsQ.QAGE
	* @see com.prowidesoftware.swift.SchemeConstantsQ#QAGE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String QAGE = "QAGE";

	/**
	* Constant for qualifier with value RATS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RATS
	* @see com.prowidesoftware.swift.SchemeConstantsR#RATS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RATS = "RATS";

	/**
	* Constant for qualifier with value RELA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RELA
	* @see com.prowidesoftware.swift.SchemeConstantsR#RELA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RELA = "RELA";

	/**
	* Constant for qualifier with value RELC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RELC
	* @see com.prowidesoftware.swift.SchemeConstantsR#RELC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RELC = "RELC";

	/**
	* Constant for qualifier with value REPR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REPR
	* @see com.prowidesoftware.swift.SchemeConstantsR#REPR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REPR = "REPR";

	/**
	* Constant for qualifier with value SAFE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SAFE
	* @see com.prowidesoftware.swift.SchemeConstantsS#SAFE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SAFE = "SAFE";

	/**
	* Constant for qualifier with value SECDET 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SECDET
	* @see com.prowidesoftware.swift.SchemeConstantsS#SECDET
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SECDET = "SECDET";

	/**
	* Constant for qualifier with value SECU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SECU
	* @see com.prowidesoftware.swift.SchemeConstantsS#SECU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SECU = "SECU";

	/**
	* Constant for qualifier with value SECV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SECV
	* @see com.prowidesoftware.swift.SchemeConstantsS#SECV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SECV = "SECV";

	/**
	* Constant for qualifier with value SEME 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SEME
	* @see com.prowidesoftware.swift.SchemeConstantsS#SEME
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SEME = "SEME";

	/**
	* Constant for qualifier with value SETT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SETT
	* @see com.prowidesoftware.swift.SchemeConstantsS#SETT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SETT = "SETT";

	/**
	* Constant for qualifier with value SFRE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SFRE
	* @see com.prowidesoftware.swift.SchemeConstantsS#SFRE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SFRE = "SFRE";

	/**
	* Constant for qualifier with value STAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STAT
	* @see com.prowidesoftware.swift.SchemeConstantsS#STAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STAT = "STAT";

	/**
	* Constant for qualifier with value STBA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STBA
	* @see com.prowidesoftware.swift.SchemeConstantsS#STBA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STBA = "STBA";

	/**
	* Constant for qualifier with value SUMC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SUMC
	* @see com.prowidesoftware.swift.SchemeConstantsS#SUMC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SUMC = "SUMC";

	/**
	* Constant for qualifier with value SUME 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SUME
	* @see com.prowidesoftware.swift.SchemeConstantsS#SUME
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SUME = "SUME";

	/**
	* Constant for qualifier with value SUMM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SUMM
	* @see com.prowidesoftware.swift.SchemeConstantsS#SUMM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SUMM = "SUMM";

	/**
	* Constant for qualifier with value TACR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TACR
	* @see com.prowidesoftware.swift.SchemeConstantsT#TACR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TACR = "TACR";

	/**
	* Constant for qualifier with value TCFA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TCFA
	* @see com.prowidesoftware.swift.SchemeConstantsT#TCFA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TCFA = "TCFA";

	/**
	* Constant for qualifier with value TCHA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TCHA
	* @see com.prowidesoftware.swift.SchemeConstantsT#TCHA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TCHA = "TCHA";

	/**
	* Constant for qualifier with value TCOP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TCOP
	* @see com.prowidesoftware.swift.SchemeConstantsT#TCOP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TCOP = "TCOP";

	/**
	* Constant for qualifier with value TCOR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TCOR
	* @see com.prowidesoftware.swift.SchemeConstantsT#TCOR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TCOR = "TCOR";

	/**
	* Constant for qualifier with value TCTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TCTR
	* @see com.prowidesoftware.swift.SchemeConstantsT#TCTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TCTR = "TCTR";

	/**
	* Constant for qualifier with value TERM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TERM
	* @see com.prowidesoftware.swift.SchemeConstantsT#TERM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TERM = "TERM";

	/**
	* Constant for qualifier with value TEXA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TEXA
	* @see com.prowidesoftware.swift.SchemeConstantsT#TEXA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TEXA = "TEXA";

	/**
	* Constant for qualifier with value TEXP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TEXP
	* @see com.prowidesoftware.swift.SchemeConstantsT#TEXP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TEXP = "TEXP";

	/**
	* Constant for qualifier with value TPIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TPIN
	* @see com.prowidesoftware.swift.SchemeConstantsT#TPIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TPIN = "TPIN";

	/**
	* Constant for qualifier with value TPOU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TPOU
	* @see com.prowidesoftware.swift.SchemeConstantsT#TPOU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TPOU = "TPOU";

	/**
	* Constant for qualifier with value TPRI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TPRI
	* @see com.prowidesoftware.swift.SchemeConstantsT#TPRI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TPRI = "TPRI";

	/**
	* Constant for qualifier with value TRAA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAA
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAA = "TRAA";

	/**
	* Constant for qualifier with value TRAG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAG
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAG = "TRAG";

	/**
	* Constant for qualifier with value TRAN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAN
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAN = "TRAN";

	/**
	* Constant for qualifier with value TRANSDET 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRANSDET
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRANSDET
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRANSDET = "TRANSDET";

	/**
	* Constant for qualifier with value TREX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TREX
	* @see com.prowidesoftware.swift.SchemeConstantsT#TREX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TREX = "TREX";

	/**
	* Constant for qualifier with value TRTE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRTE
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRTE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRTE = "TRTE";

	/**
	* Constant for qualifier with value TVOC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TVOC
	* @see com.prowidesoftware.swift.SchemeConstantsT#TVOC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TVOC = "TVOC";

	/**
	* Constant for qualifier with value TVRC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TVRC
	* @see com.prowidesoftware.swift.SchemeConstantsT#TVRC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TVRC = "TVRC";

	/**
	* Constant for qualifier with value VAFC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VAFC
	* @see com.prowidesoftware.swift.SchemeConstantsV#VAFC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VAFC = "VAFC";

	/**
	* Constant for qualifier with value VALDET 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VALDET
	* @see com.prowidesoftware.swift.SchemeConstantsV#VALDET
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VALDET = "VALDET";

	/**
	* Constant for qualifier with value VALN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VALN
	* @see com.prowidesoftware.swift.SchemeConstantsV#VALN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VALN = "VALN";

// end qualifiers constants	

	/**
	 * Creates an MT569 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT569 content
	 */
	public MT569(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT569 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT569 content, the parameter can not be <code>null</code>
	 * @see #MT569(String)
	 */
	public MT569(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT569 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT569 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT569(String)
	 * @since 7.7
	 */
	public static MT569 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT569(m.message());
	}
	
	/**
	 * Creates and initializes a new MT569 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT569() {
		super(569);
	}
	
	/**
	 * Creates and initializes a new MT569 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT569(final String sender, final String receiver) {
		super(569, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT569(sender, receiver)</code>
	* @see #MT569(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT569(final int messageType, final String sender, final String receiver) {
		super(569, sender, receiver);
	}
	
	/**
	 * Creates a new MT569 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT569(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT569 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT569 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT569 or null if fin is null 
	 * @since 7.7
	 */
	public static MT569 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT569(fin);
    }
    
    /**
	 * Creates a new MT569 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT569(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT569 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT569 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT569 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT569(stream);
    }
    
    /**
	 * Creates a new MT569 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT569(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT569 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT569 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT569 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT569(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "569";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT569 append(final SwiftTagListBlock block) {
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
	public MT569 append(final Tag ... tags) {
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
	public MT569 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 28E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 28E at MT569 is expected to be the only one.
	 * 
	 * @return a Field28E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field28E getField28E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("28E");
			if (t == null) {
				log.fine("field 28E not found");
				return null;
			} else {
				return new Field28E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23G, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23G at MT569 is expected to be the only one.
	 * 
	 * @return a Field23G object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23G getField23G() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("23G");
			if (t == null) {
				log.fine("field 23G not found");
				return null;
			} else {
				return new Field23G(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 98E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 98E at MT569 is expected to be the only one.
	 * 
	 * @return a Field98E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field98E getField98E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("98E");
			if (t == null) {
				log.fine("field 98E not found");
				return null;
			} else {
				return new Field98E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 70E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 70E at MT569 is expected to be the only one.
	 * 
	 * @return a Field70E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field70E getField70E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("70E");
			if (t == null) {
				log.fine("field 70E not found");
				return null;
			} else {
				return new Field70E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22F at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22F> getField22F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22F");
			final List<Field22F> result = new ArrayList<Field22F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22H at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22H> getField22H() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22H");
			final List<Field22H> result = new ArrayList<Field22H>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22H(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 16R at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field16R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field16R> getField16R() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("16R");
			final List<Field16R> result = new ArrayList<Field16R>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field16R(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95L at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95L> getField95L() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("95L");
			final List<Field95L> result = new ArrayList<Field95L>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field95L(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95P at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95P> getField95P() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("95P");
			final List<Field95P> result = new ArrayList<Field95P>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field95P(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95Q, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95Q at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95Q objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95Q> getField95Q() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("95Q");
			final List<Field95Q> result = new ArrayList<Field95Q>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field95Q(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95R at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95R> getField95R() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("95R");
			final List<Field95R> result = new ArrayList<Field95R>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field95R(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 97A at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97A> getField97A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("97A");
			final List<Field97A> result = new ArrayList<Field97A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field97A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 97B at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97B> getField97B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("97B");
			final List<Field97B> result = new ArrayList<Field97B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field97B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 16S at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field16S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field16S> getField16S() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("16S");
			final List<Field16S> result = new ArrayList<Field16S>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field16S(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 13A at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field13A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field13A> getField13A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("13A");
			final List<Field13A> result = new ArrayList<Field13A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field13A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 13B at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field13B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field13B> getField13B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("13B");
			final List<Field13B> result = new ArrayList<Field13B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field13B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 20C at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field20C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field20C> getField20C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("20C");
			final List<Field20C> result = new ArrayList<Field20C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field20C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 19A at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field19A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field19A> getField19A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("19A");
			final List<Field19A> result = new ArrayList<Field19A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field19A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98A at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98A> getField98A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98A");
			final List<Field98A> result = new ArrayList<Field98A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98C at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98C> getField98C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98C");
			final List<Field98C> result = new ArrayList<Field98C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92A at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92A> getField92A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92A");
			final List<Field92A> result = new ArrayList<Field92A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 25D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 25D at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field25D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field25D> getField25D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("25D");
			final List<Field25D> result = new ArrayList<Field25D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field25D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98B at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98B> getField98B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98B");
			final List<Field98B> result = new ArrayList<Field98B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92D at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92D> getField92D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92D");
			final List<Field92D> result = new ArrayList<Field92D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 17B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 17B at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field17B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field17B> getField17B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("17B");
			final List<Field17B> result = new ArrayList<Field17B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field17B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92B at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92B> getField92B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92B");
			final List<Field92B> result = new ArrayList<Field92B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 99A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 99A at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field99A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field99A> getField99A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("99A");
			final List<Field99A> result = new ArrayList<Field99A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field99A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 99B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 99B at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field99B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field99B> getField99B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("99B");
			final List<Field99B> result = new ArrayList<Field99B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field99B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 35B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 35B at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field35B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field35B> getField35B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("35B");
			final List<Field35B> result = new ArrayList<Field35B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field35B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 36B at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field36B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field36B> getField36B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("36B");
			final List<Field36B> result = new ArrayList<Field36B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field36B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 11A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 11A at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field11A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field11A> getField11A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("11A");
			final List<Field11A> result = new ArrayList<Field11A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field11A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 90A at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90A> getField90A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("90A");
			final List<Field90A> result = new ArrayList<Field90A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field90A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 90B at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90B> getField90B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("90B");
			final List<Field90B> result = new ArrayList<Field90B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field90B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94B at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94B> getField94B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("94B");
			final List<Field94B> result = new ArrayList<Field94B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field94B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 70C at MT569 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70C> getField70C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("70C");
			final List<Field70C> result = new ArrayList<Field70C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field70C(tags[i].getValue()));
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
	* Class for Sequence "A" of MT 569
	*/
	@SequenceStyle(Type.GENERATED_16RS)
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>GENL</em>
		*/
		public static final String START_END_16RS = "GENL";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceA newInstance(final Tag ... tags) {
			final SequenceA result = new SequenceA();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceA newInstance() {
			final SequenceA result = new SequenceA();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceA newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceA result = new SequenceA();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceA(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}
	/**
	* Get the single occurrence of SequenceA delimited by 16R/16S the value of SequenceA#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceA</code> is returned</em>
	* @see SequenceA#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceA getSequenceA() {
		return new SequenceA(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceA delimited by 16R/16S the value of SequenceA#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceA</code> is returned</em>  
	* @see SequenceA#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceA within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceA getSequenceA(SwiftTagListBlock parentSequence) {
		final SequenceA s = new SequenceA();
		s.setTags(parentSequence.getSubBlock(SequenceA.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=A1]
	/**
	* Class for Sequence "A1" of MT 569
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceA1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceA1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceA1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>COLLPRTY</em>
		*/
		public static final String START_END_16RS = "COLLPRTY";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceA1 newInstance(final Tag ... tags) {
			final SequenceA1 result = new SequenceA1();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceA1 newInstance() {
			final SequenceA1 result = new SequenceA1();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceA1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceA1 result = new SequenceA1();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceA1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceA1 delimited by 16R/16S with value specified in SequenceA1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceA1#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceA1> getSequenceA1List() {
		return getSequenceA1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceA1 delimited by 16R/16S with value specified in SequenceA1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceA1#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceA1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceA1> getSequenceA1List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceA1.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceA1> result = new ArrayList<SequenceA1>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceA1 s = new SequenceA1();
				s.setTags(b.getSubBlock(SequenceA1.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=A2]
	/**
	* Class for Sequence "A2" of MT 569
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceA2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceA2() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceA2(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>LINK</em>
		*/
		public static final String START_END_16RS = "LINK";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceA2 newInstance(final Tag ... tags) {
			final SequenceA2 result = new SequenceA2();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceA2 newInstance() {
			final SequenceA2 result = new SequenceA2();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceA2 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceA2 result = new SequenceA2();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceA2(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceA2 delimited by 16R/16S with value specified in SequenceA2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceA2#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceA2> getSequenceA2List() {
		return getSequenceA2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceA2 delimited by 16R/16S with value specified in SequenceA2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceA2#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceA2 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceA2> getSequenceA2List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceA2.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceA2> result = new ArrayList<SequenceA2>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceA2 s = new SequenceA2();
				s.setTags(b.getSubBlock(SequenceA2.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=B]
	/**
	* Class for Sequence "B" of MT 569
	*/
	@SequenceStyle(Type.GENERATED_16RS)
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SUMM</em>
		*/
		public static final String START_END_16RS = "SUMM";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB newInstance(final Tag ... tags) {
			final SequenceB result = new SequenceB();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceB newInstance() {
			final SequenceB result = new SequenceB();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceB newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB result = new SequenceB();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}
	/**
	* Get the single occurrence of SequenceB delimited by 16R/16S the value of SequenceB#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceB</code> is returned</em>
	* @see SequenceB#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceB getSequenceB() {
		return new SequenceB(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceB delimited by 16R/16S the value of SequenceB#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceB</code> is returned</em>  
	* @see SequenceB#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceB within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceB getSequenceB(SwiftTagListBlock parentSequence) {
		final SequenceB s = new SequenceB();
		s.setTags(parentSequence.getSubBlock(SequenceB.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=C]
	/**
	* Class for Sequence "C" of MT 569
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceC extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceC() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceC(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SUME</em>
		*/
		public static final String START_END_16RS = "SUME";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC newInstance(final Tag ... tags) {
			final SequenceC result = new SequenceC();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceC newInstance() {
			final SequenceC result = new SequenceC();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceC newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceC result = new SequenceC();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceC(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceC delimited by 16R/16S with value specified in SequenceC#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC> getSequenceCList() {
		return getSequenceCList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceC delimited by 16R/16S with value specified in SequenceC#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC> getSequenceCList(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceC> result = new ArrayList<SequenceC>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceC s = new SequenceC();
				s.setTags(b.getSubBlock(SequenceC.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=C1]
	/**
	* Class for Sequence "C1" of MT 569
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceC1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceC1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceC1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SUMC</em>
		*/
		public static final String START_END_16RS = "SUMC";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC1 newInstance(final Tag ... tags) {
			final SequenceC1 result = new SequenceC1();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceC1 newInstance() {
			final SequenceC1 result = new SequenceC1();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceC1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceC1 result = new SequenceC1();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceC1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceC1 delimited by 16R/16S with value specified in SequenceC1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC1#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC1> getSequenceC1List() {
		return getSequenceC1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceC1 delimited by 16R/16S with value specified in SequenceC1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC1#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC1> getSequenceC1List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC1.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceC1> result = new ArrayList<SequenceC1>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceC1 s = new SequenceC1();
				s.setTags(b.getSubBlock(SequenceC1.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=C1a]
	/**
	* Class for Sequence "C1a" of MT 569
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceC1a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceC1a() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceC1a(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>TRANSDET</em>
		*/
		public static final String START_END_16RS = "TRANSDET";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC1a newInstance(final Tag ... tags) {
			final SequenceC1a result = new SequenceC1a();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceC1a newInstance() {
			final SequenceC1a result = new SequenceC1a();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceC1a newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceC1a result = new SequenceC1a();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceC1a(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceC1a delimited by 16R/16S with value specified in SequenceC1a#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC1a#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC1a> getSequenceC1aList() {
		return getSequenceC1aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceC1a delimited by 16R/16S with value specified in SequenceC1a#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC1a#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC1a within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC1a> getSequenceC1aList(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC1a.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceC1a> result = new ArrayList<SequenceC1a>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceC1a s = new SequenceC1a();
				s.setTags(b.getSubBlock(SequenceC1a.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=C1a1]
	/**
	* Class for Sequence "C1a1" of MT 569
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceC1a1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceC1a1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceC1a1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>VALDET</em>
		*/
		public static final String START_END_16RS = "VALDET";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC1a1 newInstance(final Tag ... tags) {
			final SequenceC1a1 result = new SequenceC1a1();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceC1a1 newInstance() {
			final SequenceC1a1 result = new SequenceC1a1();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceC1a1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceC1a1 result = new SequenceC1a1();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceC1a1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceC1a1 delimited by 16R/16S with value specified in SequenceC1a1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC1a1#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC1a1> getSequenceC1a1List() {
		return getSequenceC1a1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceC1a1 delimited by 16R/16S with value specified in SequenceC1a1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC1a1#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC1a1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC1a1> getSequenceC1a1List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC1a1.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceC1a1> result = new ArrayList<SequenceC1a1>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceC1a1 s = new SequenceC1a1();
				s.setTags(b.getSubBlock(SequenceC1a1.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=C1a1A]
	/**
	* Class for Sequence "C1a1A" of MT 569
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceC1a1A extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceC1a1A() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceC1a1A(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SECDET</em>
		*/
		public static final String START_END_16RS = "SECDET";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC1a1A newInstance(final Tag ... tags) {
			final SequenceC1a1A result = new SequenceC1a1A();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceC1a1A newInstance() {
			final SequenceC1a1A result = new SequenceC1a1A();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceC1a1A newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceC1a1A result = new SequenceC1a1A();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceC1a1A(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceC1a1A delimited by 16R/16S with value specified in SequenceC1a1A#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC1a1A#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC1a1A> getSequenceC1a1AList() {
		return getSequenceC1a1AList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceC1a1A delimited by 16R/16S with value specified in SequenceC1a1A#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC1a1A#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC1a1A within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC1a1A> getSequenceC1a1AList(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC1a1A.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceC1a1A> result = new ArrayList<SequenceC1a1A>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceC1a1A s = new SequenceC1a1A();
				s.setTags(b.getSubBlock(SequenceC1a1A.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=D]
	/**
	* Class for Sequence "D" of MT 569
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceD extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceD() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceD(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>ADDINFO</em>
		*/
		public static final String START_END_16RS = "ADDINFO";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceD newInstance(final Tag ... tags) {
			final SequenceD result = new SequenceD();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceD newInstance() {
			final SequenceD result = new SequenceD();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceD newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD result = new SequenceD();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceD(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceD delimited by 16R/16S with value specified in SequenceD#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceD#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceD> getSequenceDList() {
		return getSequenceDList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceD delimited by 16R/16S with value specified in SequenceD#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceD#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceD> getSequenceDList(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceD.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceD> result = new ArrayList<SequenceD>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceD s = new SequenceD();
				s.setTags(b.getSubBlock(SequenceD.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator





}

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
 * MT 506<br />
 * Collateral and Exposure Statement<br />
 <h1>MT506 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="sequence">
<em>Sequence A</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 28</em>
Letter options: E<br/></div><div class="fieldset">
<em>Fieldset 20</em><br/>
<blockquote><ul><it><em>FieldsetItem 20 C</em><br/>
</it><it><em>FieldsetItem 20 C</em><br/>
</it><it><em>FieldsetItem 20 C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 23</em>
Letter options: G<br/></div><div class="sequence">
<em>Sequence A1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 22</em>
Letter options: F<br/></div><div class="field"><em>Field 98</em>
Letter options: A<br/></div><div class="field"><em>Field 13</em>
Letter options: B<br/></div><div class="field"><em>Field 70</em>
Letter options: C<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 98</em>
Letter options: A,C,E<br/></div><div class="field"><em>Field 22</em>
Letter options: F,H<br/></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 70</em>
Letter options: C<br/></div><div class="sequence">
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
Letter options: R<br/></div><div class="field"><em>Field 95</em>
Letter options: P,Q,R<br/></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A,C</em><br/>
</it><it><em>FieldsetItem 98 A,C</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it></ul></blockquote></div><div class="sequence">
<em>Sequence B1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence C</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 20</em><br/>
<blockquote><ul><it><em>FieldsetItem 20 C</em><br/>
</it><it><em>FieldsetItem 20 C</em><br/>
</it><it><em>FieldsetItem 20 C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 22</em>
Letter options: F,H<br/></div><div class="field"><em>Field 98</em>
Letter options: A<br/></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 99</em>
Letter options: A<br/></div><div class="field"><em>Field 22</em>
Letter options: F<br/></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 B</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 70</em>
Letter options: D<br/></div><div class="sequence">
<em>Sequence C1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 19</em>
Letter options: B<br/></div><div class="field"><em>Field 35</em>
Letter options: B<br/></div><div class="field"><em>Field 36</em>
Letter options: B<br/></div><div class="field"><em>Field 92</em>
Letter options: A<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence C2</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 70</em>
Letter options: C<br/></div><div class="field"><em>Field 12</em>
Letter options: B<br/></div><div class="field"><em>Field 90</em>
Letter options: A,B<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence C3</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 92</em>
Letter options: A<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence D</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 20</em>
Letter options: C<br/></div><div class="field"><em>Field 22</em>
Letter options: H<br/></div><div class="field"><em>Field 25</em>
Letter options: D<br/></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 99</em>
Letter options: A<br/></div><div class="field"><em>Field 22</em>
Letter options: F<br/></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 B</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it></ul></blockquote></div><div class="sequence">
<em>Sequence D1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 19</em>
Letter options: B<br/></div><div class="field"><em>Field 35</em>
Letter options: B<br/></div><div class="field"><em>Field 36</em>
Letter options: B<br/></div><div class="field"><em>Field 92</em>
Letter options: A<br/></div><div class="field"><em>Field 98</em>
Letter options: A<br/></div><div class="fieldset">
<em>Fieldset 94</em><br/>
<blockquote><ul><it><em>FieldsetItem 94 B</em><br/>
</it><it><em>FieldsetItem 94 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 70</em>
Letter options: C<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence D2</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 19</em>
Letter options: B<br/></div><div class="field"><em>Field 22</em>
Letter options: H<br/></div><div class="field"><em>Field 98</em>
Letter options: A<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence D3</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 22</em>
Letter options: H<br/></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A,B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 95</em>
Letter options: P,Q,R<br/></div><div class="field"><em>Field 19</em>
Letter options: B<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence E</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
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
public class MT506 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT506.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "506";
	
// begin qualifiers constants	

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
	* Constant for qualifier with value AEXP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AEXP
	* @see com.prowidesoftware.swift.SchemeConstantsA#AEXP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AEXP = "AEXP";

	/**
	* Constant for qualifier with value AGRE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AGRE
	* @see com.prowidesoftware.swift.SchemeConstantsA#AGRE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AGRE = "AGRE";

	/**
	* Constant for qualifier with value BCOL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BCOL
	* @see com.prowidesoftware.swift.SchemeConstantsB#BCOL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BCOL = "BCOL";

	/**
	* Constant for qualifier with value CANC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CANC
	* @see com.prowidesoftware.swift.SchemeConstantsC#CANC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CANC = "CANC";

	/**
	* Constant for qualifier with value CCAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CCAL
	* @see com.prowidesoftware.swift.SchemeConstantsC#CCAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CCAL = "CCAL";

	/**
	* Constant for qualifier with value CCAM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CCAM
	* @see com.prowidesoftware.swift.SchemeConstantsC#CCAM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CCAM = "CCAM";

	/**
	* Constant for qualifier with value CCOL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CCOL
	* @see com.prowidesoftware.swift.SchemeConstantsC#CCOL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CCOL = "CCOL";

	/**
	* Constant for qualifier with value CHAI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CHAI
	* @see com.prowidesoftware.swift.SchemeConstantsC#CHAI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CHAI = "CHAI";

	/**
	* Constant for qualifier with value CHAR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CHAR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CHAR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CHAR = "CHAR";

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
	* Constant for qualifier with value COLD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLD
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLD = "COLD";

	/**
	* Constant for qualifier with value COLL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLL
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLL = "COLL";

	/**
	* Constant for qualifier with value COLR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLR
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLR = "COLR";

	/**
	* Constant for qualifier with value COMI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COMI
	* @see com.prowidesoftware.swift.SchemeConstantsC#COMI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COMI = "COMI";

	/**
	* Constant for qualifier with value CONM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CONM
	* @see com.prowidesoftware.swift.SchemeConstantsC#CONM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CONM = "CONM";

	/**
	* Constant for qualifier with value COPC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COPC
	* @see com.prowidesoftware.swift.SchemeConstantsC#COPC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COPC = "COPC";

	/**
	* Constant for qualifier with value COPY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COPY
	* @see com.prowidesoftware.swift.SchemeConstantsC#COPY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COPY = "COPY";

	/**
	* Constant for qualifier with value CORE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CORE
	* @see com.prowidesoftware.swift.SchemeConstantsC#CORE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CORE = "CORE";

	/**
	* Constant for qualifier with value COVA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COVA
	* @see com.prowidesoftware.swift.SchemeConstantsC#COVA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COVA = "COVA";

	/**
	* Constant for qualifier with value CPTA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CPTA
	* @see com.prowidesoftware.swift.SchemeConstantsC#CPTA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CPTA = "CPTA";

	/**
	* Constant for qualifier with value CPTB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CPTB
	* @see com.prowidesoftware.swift.SchemeConstantsC#CPTB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CPTB = "CPTB";

	/**
	* Constant for qualifier with value CPTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CPTR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CPTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CPTR = "CPTR";

	/**
	* Constant for qualifier with value CRET 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CRET
	* @see com.prowidesoftware.swift.SchemeConstantsC#CRET
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CRET = "CRET";

	/**
	* Constant for qualifier with value DAAC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DAAC
	* @see com.prowidesoftware.swift.SchemeConstantsD#DAAC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DAAC = "DAAC";

	/**
	* Constant for qualifier with value DEAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DEAL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DEAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DEAL = "DEAL";

	/**
	* Constant for qualifier with value DEPO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DEPO
	* @see com.prowidesoftware.swift.SchemeConstantsD#DEPO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DEPO = "DEPO";

	/**
	* Constant for qualifier with value DUPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DUPL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DUPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DUPL = "DUPL";

	/**
	* Constant for qualifier with value EXCH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXCH
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXCH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXCH = "EXCH";

	/**
	* Constant for qualifier with value EXER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXER
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXER = "EXER";

	/**
	* Constant for qualifier with value EXPD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXPD
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXPD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXPD = "EXPD";

	/**
	* Constant for qualifier with value EXPI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXPI
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXPI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXPI = "EXPI";

	/**
	* Constant for qualifier with value EXPO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXPO
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXPO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXPO = "EXPO";

	/**
	* Constant for qualifier with value EXPP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXPP
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXPP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXPP = "EXPP";

	/**
	* Constant for qualifier with value GENL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GENL
	* @see com.prowidesoftware.swift.SchemeConstantsG#GENL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GENL = "GENL";

	/**
	* Constant for qualifier with value GUAR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GUAR
	* @see com.prowidesoftware.swift.SchemeConstantsG#GUAR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GUAR = "GUAR";

	/**
	* Constant for qualifier with value INDA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INDA
	* @see com.prowidesoftware.swift.SchemeConstantsI#INDA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INDA = "INDA";

	/**
	* Constant for qualifier with value INIM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INIM
	* @see com.prowidesoftware.swift.SchemeConstantsI#INIM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INIM = "INIM";

	/**
	* Constant for qualifier with value ISSU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ISSU
	* @see com.prowidesoftware.swift.SchemeConstantsI#ISSU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ISSU = "ISSU";

	/**
	* Constant for qualifier with value LAST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LAST
	* @see com.prowidesoftware.swift.SchemeConstantsL#LAST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LAST = "LAST";

	/**
	* Constant for qualifier with value LINK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LINK
	* @see com.prowidesoftware.swift.SchemeConstantsL#LINK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LINK = "LINK";

	/**
	* Constant for qualifier with value LOCR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LOCR
	* @see com.prowidesoftware.swift.SchemeConstantsL#LOCR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LOCR = "LOCR";

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
	* Constant for qualifier with value MITR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MITR
	* @see com.prowidesoftware.swift.SchemeConstantsM#MITR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MITR = "MITR";

	/**
	* Constant for qualifier with value MKTV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MKTV
	* @see com.prowidesoftware.swift.SchemeConstantsM#MKTV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MKTV = "MKTV";

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
	* Constant for qualifier with value NEWM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NEWM
	* @see com.prowidesoftware.swift.SchemeConstantsN#NEWM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NEWM = "NEWM";

	/**
	* Constant for qualifier with value NRAD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NRAD
	* @see com.prowidesoftware.swift.SchemeConstantsN#NRAD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NRAD = "NRAD";

	/**
	* Constant for qualifier with value ONLY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.ONLY
	* @see com.prowidesoftware.swift.SchemeConstantsO#ONLY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ONLY = "ONLY";

	/**
	* Constant for qualifier with value OPCA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OPCA
	* @see com.prowidesoftware.swift.SchemeConstantsO#OPCA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OPCA = "OPCA";

	/**
	* Constant for qualifier with value OPTI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OPTI
	* @see com.prowidesoftware.swift.SchemeConstantsO#OPTI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OPTI = "OPTI";

	/**
	* Constant for qualifier with value PACO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PACO
	* @see com.prowidesoftware.swift.SchemeConstantsP#PACO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PACO = "PACO";

	/**
	* Constant for qualifier with value PEVA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PEVA
	* @see com.prowidesoftware.swift.SchemeConstantsP#PEVA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PEVA = "PEVA";

	/**
	* Constant for qualifier with value PRCV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRCV
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRCV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRCV = "PRCV";

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
	* Constant for qualifier with value PRHA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRHA
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRHA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRHA = "PRHA";

	/**
	* Constant for qualifier with value PRIC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRIC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRIC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRIC = "PRIC";

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
	* Constant for qualifier with value RADD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RADD
	* @see com.prowidesoftware.swift.SchemeConstantsR#RADD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RADD = "RADD";

	/**
	* Constant for qualifier with value RATS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RATS
	* @see com.prowidesoftware.swift.SchemeConstantsR#RATS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RATS = "RATS";

	/**
	* Constant for qualifier with value RCTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RCTR
	* @see com.prowidesoftware.swift.SchemeConstantsR#RCTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RCTR = "RCTR";

	/**
	* Constant for qualifier with value RECA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RECA
	* @see com.prowidesoftware.swift.SchemeConstantsR#RECA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RECA = "RECA";

	/**
	* Constant for qualifier with value RELA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RELA
	* @see com.prowidesoftware.swift.SchemeConstantsR#RELA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RELA = "RELA";

	/**
	* Constant for qualifier with value REPA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REPA
	* @see com.prowidesoftware.swift.SchemeConstantsR#REPA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REPA = "REPA";

	/**
	* Constant for qualifier with value REPO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REPO
	* @see com.prowidesoftware.swift.SchemeConstantsR#REPO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REPO = "REPO";

	/**
	* Constant for qualifier with value REPV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REPV
	* @see com.prowidesoftware.swift.SchemeConstantsR#REPV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REPV = "REPV";

	/**
	* Constant for qualifier with value ROUN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.ROUN
	* @see com.prowidesoftware.swift.SchemeConstantsR#ROUN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ROUN = "ROUN";

	/**
	* Constant for qualifier with value RSET 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RSET
	* @see com.prowidesoftware.swift.SchemeConstantsR#RSET
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RSET = "RSET";

	/**
	* Constant for qualifier with value SCOL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SCOL
	* @see com.prowidesoftware.swift.SchemeConstantsS#SCOL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SCOL = "SCOL";

	/**
	* Constant for qualifier with value SCTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SCTR
	* @see com.prowidesoftware.swift.SchemeConstantsS#SCTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SCTR = "SCTR";

	/**
	* Constant for qualifier with value SECS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SECS
	* @see com.prowidesoftware.swift.SchemeConstantsS#SECS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SECS = "SECS";

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
	* Constant for qualifier with value SHAI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SHAI
	* @see com.prowidesoftware.swift.SchemeConstantsS#SHAI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SHAI = "SHAI";

	/**
	* Constant for qualifier with value STRT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STRT
	* @see com.prowidesoftware.swift.SchemeConstantsS#STRT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STRT = "STRT";

	/**
	* Constant for qualifier with value SUMD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SUMD
	* @see com.prowidesoftware.swift.SchemeConstantsS#SUMD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SUMD = "SUMD";

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
	* Constant for qualifier with value TCRL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TCRL
	* @see com.prowidesoftware.swift.SchemeConstantsT#TCRL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TCRL = "TCRL";

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
	* Constant for qualifier with value THRS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.THRS
	* @see com.prowidesoftware.swift.SchemeConstantsT#THRS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String THRS = "THRS";

	/**
	* Constant for qualifier with value THRU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.THRU
	* @see com.prowidesoftware.swift.SchemeConstantsT#THRU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String THRU = "THRU";

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
	* Constant for qualifier with value TRAD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAD
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAD = "TRAD";

	/**
	* Constant for qualifier with value TREA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TREA
	* @see com.prowidesoftware.swift.SchemeConstantsT#TREA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TREA = "TREA";

	/**
	* Constant for qualifier with value TRRF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRRF
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRRF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRRF = "TRRF";

	/**
	* Constant for qualifier with value VALC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VALC
	* @see com.prowidesoftware.swift.SchemeConstantsV#VALC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VALC = "VALC";

	/**
	* Constant for qualifier with value VALE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VALE
	* @see com.prowidesoftware.swift.SchemeConstantsV#VALE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VALE = "VALE";

// end qualifiers constants	

	/**
	 * Creates an MT506 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT506 content
	 */
	public MT506(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT506 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT506 content, the parameter can not be <code>null</code>
	 * @see #MT506(String)
	 */
	public MT506(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT506 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT506 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT506(String)
	 * @since 7.7
	 */
	public static MT506 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT506(m.message());
	}
	
	/**
	 * Creates and initializes a new MT506 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT506() {
		super(506);
	}
	
	/**
	 * Creates and initializes a new MT506 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT506(final String sender, final String receiver) {
		super(506, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT506(sender, receiver)</code>
	* @see #MT506(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT506(final int messageType, final String sender, final String receiver) {
		super(506, sender, receiver);
	}
	
	/**
	 * Creates a new MT506 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT506(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT506 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT506 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT506 or null if fin is null 
	 * @since 7.7
	 */
	public static MT506 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT506(fin);
    }
    
    /**
	 * Creates a new MT506 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT506(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT506 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT506 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT506 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT506(stream);
    }
    
    /**
	 * Creates a new MT506 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT506(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT506 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT506 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT506 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT506(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "506";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT506 append(final SwiftTagListBlock block) {
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
	public MT506 append(final Tag ... tags) {
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
	public MT506 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 28E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 28E at MT506 is expected to be the only one.
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
	 * The first occurrence of field 23G at MT506 is expected to be the only one.
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
	 * The first occurrence of field 98E at MT506 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 12B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 12B at MT506 is expected to be the only one.
	 * 
	 * @return a Field12B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12B getField12B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("12B");
			if (t == null) {
				log.fine("field 12B not found");
				return null;
			} else {
				return new Field12B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 90A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 90A at MT506 is expected to be the only one.
	 * 
	 * @return a Field90A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field90A getField90A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("90A");
			if (t == null) {
				log.fine("field 90A not found");
				return null;
			} else {
				return new Field90A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 90B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 90B at MT506 is expected to be the only one.
	 * 
	 * @return a Field90B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field90B getField90B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("90B");
			if (t == null) {
				log.fine("field 90B not found");
				return null;
			} else {
				return new Field90B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 20C at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 16R at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22F at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98A at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 13B at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 70C at MT506 are expected at one sequence or across several sequences.
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
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 16S at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95P at MT506 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 95Q at MT506 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 95R at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 13A at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 19B at MT506 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field19B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field19B> getField19B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("19B");
			final List<Field19B> result = new ArrayList<Field19B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field19B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98C at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22H at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 19A at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 99A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 99A at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92A at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92B at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 70D at MT506 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70D> getField70D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("70D");
			final List<Field70D> result = new ArrayList<Field70D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field70D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 25D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 25D at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 35B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 35B at MT506 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 36B at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94B at MT506 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98B at MT506 are expected at one sequence or across several sequences.
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
	

/*
 * sequences code
 *
 */ 


// BaseSequenceCodeGenerator [seq=A]
	/**
	* Class for Sequence "A" of MT 506
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
	* Class for Sequence "A1" of MT 506
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>AGRE</em>
		*/
		public static final String START_END_16RS = "AGRE";
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
	* Class for Sequence "A2" of MT 506
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
	* Class for Sequence "B" of MT 506
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


// BaseSequenceCodeGenerator [seq=B1]
	/**
	* Class for Sequence "B1" of MT 506
	*/
	@SequenceStyle(Type.GENERATED_16RS)
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SUMD</em>
		*/
		public static final String START_END_16RS = "SUMD";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB1 newInstance(final Tag ... tags) {
			final SequenceB1 result = new SequenceB1();

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
		public static SequenceB1 newInstance() {
			final SequenceB1 result = new SequenceB1();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceB1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB1 result = new SequenceB1();

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
		private SequenceB1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}
	/**
	* Get the single occurrence of SequenceB1 delimited by 16R/16S the value of SequenceB1#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceB1</code> is returned</em>
	* @see SequenceB1#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceB1 getSequenceB1() {
		return new SequenceB1(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceB1 delimited by 16R/16S the value of SequenceB1#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceB1</code> is returned</em>  
	* @see SequenceB1#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceB1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceB1 getSequenceB1(SwiftTagListBlock parentSequence) {
		final SequenceB1 s = new SequenceB1();
		s.setTags(parentSequence.getSubBlock(SequenceB1.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=C]
	/**
	* Class for Sequence "C" of MT 506
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>EXPD</em>
		*/
		public static final String START_END_16RS = "EXPD";
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
	* Class for Sequence "C1" of MT 506
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SECS</em>
		*/
		public static final String START_END_16RS = "SECS";
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


// BaseSequenceCodeGenerator [seq=C2]
	/**
	* Class for Sequence "C2" of MT 506
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceC2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceC2() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceC2(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>TREA</em>
		*/
		public static final String START_END_16RS = "TREA";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC2 newInstance(final Tag ... tags) {
			final SequenceC2 result = new SequenceC2();

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
		public static SequenceC2 newInstance() {
			final SequenceC2 result = new SequenceC2();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceC2 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceC2 result = new SequenceC2();

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
		private SequenceC2(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceC2 delimited by 16R/16S with value specified in SequenceC2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC2#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC2> getSequenceC2List() {
		return getSequenceC2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceC2 delimited by 16R/16S with value specified in SequenceC2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC2#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC2 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC2> getSequenceC2List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC2.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceC2> result = new ArrayList<SequenceC2>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceC2 s = new SequenceC2();
				s.setTags(b.getSubBlock(SequenceC2.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=C3]
	/**
	* Class for Sequence "C3" of MT 506
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceC3 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceC3() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceC3(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>REPV</em>
		*/
		public static final String START_END_16RS = "REPV";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC3 newInstance(final Tag ... tags) {
			final SequenceC3 result = new SequenceC3();

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
		public static SequenceC3 newInstance() {
			final SequenceC3 result = new SequenceC3();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceC3 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceC3 result = new SequenceC3();

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
		private SequenceC3(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceC3 delimited by 16R/16S with value specified in SequenceC3#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC3#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceC3> getSequenceC3List() {
		return getSequenceC3List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceC3 delimited by 16R/16S with value specified in SequenceC3#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceC3#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC3 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceC3> getSequenceC3List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceC3.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceC3> result = new ArrayList<SequenceC3>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceC3 s = new SequenceC3();
				s.setTags(b.getSubBlock(SequenceC3.START_END_16RS).getTags());
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
	* Class for Sequence "D" of MT 506
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>COLD</em>
		*/
		public static final String START_END_16RS = "COLD";
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


// BaseSequenceCodeGenerator [seq=D1]
	/**
	* Class for Sequence "D1" of MT 506
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceD1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceD1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceD1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SCOL</em>
		*/
		public static final String START_END_16RS = "SCOL";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceD1 newInstance(final Tag ... tags) {
			final SequenceD1 result = new SequenceD1();

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
		public static SequenceD1 newInstance() {
			final SequenceD1 result = new SequenceD1();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceD1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD1 result = new SequenceD1();

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
		private SequenceD1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceD1 delimited by 16R/16S with value specified in SequenceD1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceD1#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceD1> getSequenceD1List() {
		return getSequenceD1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceD1 delimited by 16R/16S with value specified in SequenceD1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceD1#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceD1> getSequenceD1List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceD1.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceD1> result = new ArrayList<SequenceD1>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceD1 s = new SequenceD1();
				s.setTags(b.getSubBlock(SequenceD1.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=D2]
	/**
	* Class for Sequence "D2" of MT 506
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceD2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceD2() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceD2(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CCOL</em>
		*/
		public static final String START_END_16RS = "CCOL";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceD2 newInstance(final Tag ... tags) {
			final SequenceD2 result = new SequenceD2();

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
		public static SequenceD2 newInstance() {
			final SequenceD2 result = new SequenceD2();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceD2 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD2 result = new SequenceD2();

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
		private SequenceD2(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceD2 delimited by 16R/16S with value specified in SequenceD2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceD2#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceD2> getSequenceD2List() {
		return getSequenceD2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceD2 delimited by 16R/16S with value specified in SequenceD2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceD2#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD2 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceD2> getSequenceD2List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceD2.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceD2> result = new ArrayList<SequenceD2>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceD2 s = new SequenceD2();
				s.setTags(b.getSubBlock(SequenceD2.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=D3]
	/**
	* Class for Sequence "D3" of MT 506
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceD3 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceD3() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceD3(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>BCOL</em>
		*/
		public static final String START_END_16RS = "BCOL";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceD3 newInstance(final Tag ... tags) {
			final SequenceD3 result = new SequenceD3();

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
		public static SequenceD3 newInstance() {
			final SequenceD3 result = new SequenceD3();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceD3 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD3 result = new SequenceD3();

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
		private SequenceD3(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceD3 delimited by 16R/16S with value specified in SequenceD3#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceD3#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceD3> getSequenceD3List() {
		return getSequenceD3List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceD3 delimited by 16R/16S with value specified in SequenceD3#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceD3#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD3 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceD3> getSequenceD3List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceD3.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceD3> result = new ArrayList<SequenceD3>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceD3 s = new SequenceD3();
				s.setTags(b.getSubBlock(SequenceD3.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=E]
	/**
	* Class for Sequence "E" of MT 506
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceE extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceE() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceE(final SwiftTagListBlock content) {
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
		public static SequenceE newInstance(final Tag ... tags) {
			final SequenceE result = new SequenceE();

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
		public static SequenceE newInstance() {
			final SequenceE result = new SequenceE();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceE newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE result = new SequenceE();

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
		private SequenceE(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}
	/**
	* Get the single occurrence of SequenceE delimited by 16R/16S the value of SequenceE#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceE</code> is returned</em>
	* @see SequenceE#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceE getSequenceE() {
		return new SequenceE(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceE delimited by 16R/16S the value of SequenceE#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceE</code> is returned</em>  
	* @see SequenceE#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceE within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceE getSequenceE(SwiftTagListBlock parentSequence) {
		final SequenceE s = new SequenceE();
		s.setTags(parentSequence.getSubBlock(SequenceE.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator





}

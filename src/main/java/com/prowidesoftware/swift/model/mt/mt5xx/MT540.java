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
 * MT 540<br />
 * Receive Free<br />
 <h1>MT540 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="sequence">
<em>Sequence A</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 20</em>
Letter options: C<br/></div><div class="field"><em>Field 23</em>
Letter options: G<br/></div><div class="field"><em>Field 98</em>
Letter options: A,C,E<br/></div><div class="fieldset">
<em>Fieldset 99</em><br/>
<blockquote><ul><it><em>FieldsetItem 99 B</em><br/>
</it><it><em>FieldsetItem 99 B</em><br/>
</it></ul></blockquote></div><div class="sequence">
<em>Sequence A1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 22</em>
Letter options: F<br/></div><div class="field"><em>Field 13</em>
Letter options: A,B<br/></div><div class="field"><em>Field 20</em>
Letter options: C<br/></div><div class="field"><em>Field 36</em>
Letter options: B<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence B</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 94</em><br/>
<blockquote><ul><it><em>FieldsetItem 94 H,L</em><br/>
</it><it><em>FieldsetItem 94 B,L</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,C</em><br/>
</it><it><em>FieldsetItem 98 A,C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 90</em>
Letter options: A,B<br/></div><div class="field"><em>Field 99</em>
Letter options: A<br/></div><div class="field"><em>Field 35</em>
Letter options: B<br/></div><div class="sequence">
<em>Sequence B1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 94</em>
Letter options: B<br/></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 12</em><br/>
<blockquote><ul><it><em>FieldsetItem 12 A,C</em><br/>
</it><it><em>FieldsetItem 12 B</em><br/>
</it><it><em>FieldsetItem 12 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 11</em>
Letter options: A<br/></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 13</em><br/>
<blockquote><ul><it><em>FieldsetItem 13 A,B</em><br/>
</it><it><em>FieldsetItem 13 B</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 17</em><br/>
<blockquote><ul><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 90</em><br/>
<blockquote><ul><it><em>FieldsetItem 90 A,B</em><br/>
</it><it><em>FieldsetItem 90 A,B</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 36</em><br/>
<blockquote><ul><it><em>FieldsetItem 36 B</em><br/>
</it><it><em>FieldsetItem 36 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 35</em>
Letter options: B<br/></div><div class="field"><em>Field 70</em>
Letter options: E<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 11</em>
Letter options: A<br/></div><div class="fieldset">
<em>Fieldset 25</em><br/>
<blockquote><ul><it><em>FieldsetItem 25 D</em><br/>
</it><it><em>FieldsetItem 25 D</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 70</em><br/>
<blockquote><ul><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence C</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 36</em>
Letter options: B<br/></div><div class="field"><em>Field 70</em>
Letter options: D<br/></div><div class="field"><em>Field 13</em>
Letter options: B<br/></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,R</em><br/>
</it><it><em>FieldsetItem 95 L</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 97</em><br/>
<blockquote><ul><it><em>FieldsetItem 97 A,B</em><br/>
</it><it><em>FieldsetItem 97 A,E</em><br/>
</it><it><em>FieldsetItem 97 A,B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 94</em>
Letter options: B,C,F,L<br/></div><div class="sequence">
<em>Sequence C1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 13</em>
Letter options: B<br/></div><div class="field"><em>Field 36</em>
Letter options: B<br/></div><div class="field"><em>Field 98</em>
Letter options: A,C,E<br/></div><div class="field"><em>Field 90</em>
Letter options: A,B<br/></div><div class="field"><em>Field 22</em>
Letter options: F<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence D</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,C</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 20</em><br/>
<blockquote><ul><it><em>FieldsetItem 20 C</em><br/>
</it><it><em>FieldsetItem 20 C</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 C</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A,C</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 99</em><br/>
<blockquote><ul><it><em>FieldsetItem 99 B</em><br/>
</it><it><em>FieldsetItem 99 B</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 70</em>
Letter options: C<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence E</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="sequence">
<em>Sequence E1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,Q,R,C</em><br/>
</it><it><em>FieldsetItem 95 L,S</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 97</em>
Letter options: A,B<br/></div><div class="field"><em>Field 98</em>
Letter options: A,C<br/></div><div class="field"><em>Field 20</em>
Letter options: C<br/></div><div class="fieldset">
<em>Fieldset 70</em><br/>
<blockquote><ul><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 D</em><br/>
</it><it><em>FieldsetItem 70 C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence E2</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 L,S</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 97</em><br/>
<blockquote><ul><it><em>FieldsetItem 97 A,E</em><br/>
</it><it><em>FieldsetItem 97 A,E</em><br/>
</it><it><em>FieldsetItem 97 A,E</em><br/>
</it><it><em>FieldsetItem 97 A,E</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 70</em><br/>
<blockquote><ul><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence E3</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 17</em><br/>
<blockquote><ul><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it><it><em>FieldsetItem 19 A</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 92</em>
Letter options: B<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence F</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 C,P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 L,S</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 97</em>
Letter options: A<br/></div><div class="fieldset">
<em>Fieldset 70</em><br/>
<blockquote><ul><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 D</em><br/>
</it><it><em>FieldsetItem 70 C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 20</em>
Letter options: C<br/></div><div class="field"><em>Field 16</em>
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
public class MT540 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT540.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "540";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value ACCA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ACCA
	* @see com.prowidesoftware.swift.SchemeConstantsA#ACCA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ACCA = "ACCA";

	/**
	* Constant for qualifier with value ACCW 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ACCW
	* @see com.prowidesoftware.swift.SchemeConstantsA#ACCW
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ACCW = "ACCW";

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
	* Constant for qualifier with value ADEL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ADEL
	* @see com.prowidesoftware.swift.SchemeConstantsA#ADEL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ADEL = "ADEL";

	/**
	* Constant for qualifier with value AFFM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AFFM
	* @see com.prowidesoftware.swift.SchemeConstantsA#AFFM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AFFM = "AFFM";

	/**
	* Constant for qualifier with value ALTE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ALTE
	* @see com.prowidesoftware.swift.SchemeConstantsA#ALTE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ALTE = "ALTE";

	/**
	* Constant for qualifier with value AMT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMT
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AMT = "AMT";

	/**
	* Constant for qualifier with value ANTO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ANTO
	* @see com.prowidesoftware.swift.SchemeConstantsA#ANTO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ANTO = "ANTO";

	/**
	* Constant for qualifier with value BENE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BENE
	* @see com.prowidesoftware.swift.SchemeConstantsB#BENE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BENE = "BENE";

	/**
	* Constant for qualifier with value BENM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BENM
	* @see com.prowidesoftware.swift.SchemeConstantsB#BENM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BENM = "BENM";

	/**
	* Constant for qualifier with value BLOC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BLOC
	* @see com.prowidesoftware.swift.SchemeConstantsB#BLOC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BLOC = "BLOC";

	/**
	* Constant for qualifier with value BOOK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BOOK
	* @see com.prowidesoftware.swift.SchemeConstantsB#BOOK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BOOK = "BOOK";

	/**
	* Constant for qualifier with value BORR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BORR
	* @see com.prowidesoftware.swift.SchemeConstantsB#BORR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BORR = "BORR";

	/**
	* Constant for qualifier with value BREAK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BREAK
	* @see com.prowidesoftware.swift.SchemeConstantsB#BREAK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BREAK = "BREAK";

	/**
	* Constant for qualifier with value CADE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CADE
	* @see com.prowidesoftware.swift.SchemeConstantsC#CADE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CADE = "CADE";

	/**
	* Constant for qualifier with value CALD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CALD
	* @see com.prowidesoftware.swift.SchemeConstantsC#CALD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CALD = "CALD";

	/**
	* Constant for qualifier with value CALL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CALL
	* @see com.prowidesoftware.swift.SchemeConstantsC#CALL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CALL = "CALL";

	/**
	* Constant for qualifier with value CANC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CANC
	* @see com.prowidesoftware.swift.SchemeConstantsC#CANC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CANC = "CANC";

	/**
	* Constant for qualifier with value CASH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CASH
	* @see com.prowidesoftware.swift.SchemeConstantsC#CASH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CASH = "CASH";

	/**
	* Constant for qualifier with value CASY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CASY
	* @see com.prowidesoftware.swift.SchemeConstantsC#CASY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CASY = "CASY";

	/**
	* Constant for qualifier with value CCPT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CCPT
	* @see com.prowidesoftware.swift.SchemeConstantsC#CCPT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CCPT = "CCPT";

	/**
	* Constant for qualifier with value CERT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CERT
	* @see com.prowidesoftware.swift.SchemeConstantsC#CERT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CERT = "CERT";

	/**
	* Constant for qualifier with value CFRE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CFRE
	* @see com.prowidesoftware.swift.SchemeConstantsC#CFRE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CFRE = "CFRE";

	/**
	* Constant for qualifier with value CHAR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CHAR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CHAR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CHAR = "CHAR";

	/**
	* Constant for qualifier with value CLAS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLAS
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLAS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLAS = "CLAS";

	/**
	* Constant for qualifier with value CLCI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLCI
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLCI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLCI = "CLCI";

	/**
	* Constant for qualifier with value CLEA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLEA
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLEA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLEA = "CLEA";

	/**
	* Constant for qualifier with value CLTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLTR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLTR = "CLTR";

	/**
	* Constant for qualifier with value COAX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COAX
	* @see com.prowidesoftware.swift.SchemeConstantsC#COAX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COAX = "COAX";

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
	* Constant for qualifier with value COLE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLE
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLE = "COLE";

	/**
	* Constant for qualifier with value COLR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLR
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLR = "COLR";

	/**
	* Constant for qualifier with value COMM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COMM
	* @see com.prowidesoftware.swift.SchemeConstantsC#COMM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COMM = "COMM";

	/**
	* Constant for qualifier with value COPY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COPY
	* @see com.prowidesoftware.swift.SchemeConstantsC#COPY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COPY = "COPY";

	/**
	* Constant for qualifier with value COUN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COUN
	* @see com.prowidesoftware.swift.SchemeConstantsC#COUN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COUN = "COUN";

	/**
	* Constant for qualifier with value COUP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COUP
	* @see com.prowidesoftware.swift.SchemeConstantsC#COUP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COUP = "COUP";

	/**
	* Constant for qualifier with value CSBT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CSBT
	* @see com.prowidesoftware.swift.SchemeConstantsC#CSBT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CSBT = "CSBT";

	/**
	* Constant for qualifier with value CSHPRTY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CSHPRTY
	* @see com.prowidesoftware.swift.SchemeConstantsC#CSHPRTY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CSHPRTY = "CSHPRTY";

	/**
	* Constant for qualifier with value CUFC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CUFC
	* @see com.prowidesoftware.swift.SchemeConstantsC#CUFC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CUFC = "CUFC";

	/**
	* Constant for qualifier with value DAAC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DAAC
	* @see com.prowidesoftware.swift.SchemeConstantsD#DAAC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DAAC = "DAAC";

	/**
	* Constant for qualifier with value DBNM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DBNM
	* @see com.prowidesoftware.swift.SchemeConstantsD#DBNM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DBNM = "DBNM";

	/**
	* Constant for qualifier with value DDTE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DDTE
	* @see com.prowidesoftware.swift.SchemeConstantsD#DDTE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DDTE = "DDTE";

	/**
	* Constant for qualifier with value DEAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DEAL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DEAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DEAL = "DEAL";

	/**
	* Constant for qualifier with value DEBT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DEBT
	* @see com.prowidesoftware.swift.SchemeConstantsD#DEBT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DEBT = "DEBT";

	/**
	* Constant for qualifier with value DECL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DECL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DECL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DECL = "DECL";

	/**
	* Constant for qualifier with value DENC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DENC
	* @see com.prowidesoftware.swift.SchemeConstantsD#DENC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DENC = "DENC";

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
	* Constant for qualifier with value EXCH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXCH
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXCH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXCH = "EXCH";

	/**
	* Constant for qualifier with value EXEC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXEC
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXEC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXEC = "EXEC";

	/**
	* Constant for qualifier with value EXER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXER
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXER = "EXER";

	/**
	* Constant for qualifier with value EXPI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXPI
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXPI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXPI = "EXPI";

	/**
	* Constant for qualifier with value FCOU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FCOU
	* @see com.prowidesoftware.swift.SchemeConstantsF#FCOU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FCOU = "FCOU";

	/**
	* Constant for qualifier with value FIA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FIA
	* @see com.prowidesoftware.swift.SchemeConstantsF#FIA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FIA = "FIA";

	/**
	* Constant for qualifier with value FIAC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FIAC
	* @see com.prowidesoftware.swift.SchemeConstantsF#FIAC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FIAC = "FIAC";

	/**
	* Constant for qualifier with value FIAN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FIAN
	* @see com.prowidesoftware.swift.SchemeConstantsF#FIAN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FIAN = "FIAN";

	/**
	* Constant for qualifier with value FORF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FORF
	* @see com.prowidesoftware.swift.SchemeConstantsF#FORF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FORF = "FORF";

	/**
	* Constant for qualifier with value FORM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FORM
	* @see com.prowidesoftware.swift.SchemeConstantsF#FORM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FORM = "FORM";

	/**
	* Constant for qualifier with value FRNF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FRNF
	* @see com.prowidesoftware.swift.SchemeConstantsF#FRNF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FRNF = "FRNF";

	/**
	* Constant for qualifier with value FRNR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FRNR
	* @see com.prowidesoftware.swift.SchemeConstantsF#FRNR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FRNR = "FRNR";

	/**
	* Constant for qualifier with value FXCX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FXCX
	* @see com.prowidesoftware.swift.SchemeConstantsF#FXCX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FXCX = "FXCX";

	/**
	* Constant for qualifier with value FXIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FXIN
	* @see com.prowidesoftware.swift.SchemeConstantsF#FXIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FXIN = "FXIN";

	/**
	* Constant for qualifier with value FXIS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FXIS
	* @see com.prowidesoftware.swift.SchemeConstantsF#FXIS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FXIS = "FXIS";

	/**
	* Constant for qualifier with value GENL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GENL
	* @see com.prowidesoftware.swift.SchemeConstantsG#GENL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GENL = "GENL";

	/**
	* Constant for qualifier with value INCA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INCA
	* @see com.prowidesoftware.swift.SchemeConstantsI#INCA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INCA = "INCA";

	/**
	* Constant for qualifier with value INDC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INDC
	* @see com.prowidesoftware.swift.SchemeConstantsI#INDC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INDC = "INDC";

	/**
	* Constant for qualifier with value INDX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INDX
	* @see com.prowidesoftware.swift.SchemeConstantsI#INDX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INDX = "INDX";

	/**
	* Constant for qualifier with value INTM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INTM
	* @see com.prowidesoftware.swift.SchemeConstantsI#INTM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INTM = "INTM";

	/**
	* Constant for qualifier with value INTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INTR
	* @see com.prowidesoftware.swift.SchemeConstantsI#INTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INTR = "INTR";

	/**
	* Constant for qualifier with value ISDI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ISDI
	* @see com.prowidesoftware.swift.SchemeConstantsI#ISDI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ISDI = "ISDI";

	/**
	* Constant for qualifier with value ISSU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ISSU
	* @see com.prowidesoftware.swift.SchemeConstantsI#ISSU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ISSU = "ISSU";

	/**
	* Constant for qualifier with value LADT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LADT
	* @see com.prowidesoftware.swift.SchemeConstantsL#LADT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LADT = "LADT";

	/**
	* Constant for qualifier with value LEGA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LEGA
	* @see com.prowidesoftware.swift.SchemeConstantsL#LEGA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LEGA = "LEGA";

	/**
	* Constant for qualifier with value LEOG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LEOG
	* @see com.prowidesoftware.swift.SchemeConstantsL#LEOG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LEOG = "LEOG";

	/**
	* Constant for qualifier with value LEVY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LEVY
	* @see com.prowidesoftware.swift.SchemeConstantsL#LEVY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LEVY = "LEVY";

	/**
	* Constant for qualifier with value LINK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LINK
	* @see com.prowidesoftware.swift.SchemeConstantsL#LINK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LINK = "LINK";

	/**
	* Constant for qualifier with value LOCL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LOCL
	* @see com.prowidesoftware.swift.SchemeConstantsL#LOCL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LOCL = "LOCL";

	/**
	* Constant for qualifier with value LOCO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LOCO
	* @see com.prowidesoftware.swift.SchemeConstantsL#LOCO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LOCO = "LOCO";

	/**
	* Constant for qualifier with value LOTS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LOTS
	* @see com.prowidesoftware.swift.SchemeConstantsL#LOTS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LOTS = "LOTS";

	/**
	* Constant for qualifier with value MACL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MACL
	* @see com.prowidesoftware.swift.SchemeConstantsM#MACL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MACL = "MACL";

	/**
	* Constant for qualifier with value MARG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MARG
	* @see com.prowidesoftware.swift.SchemeConstantsM#MARG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MARG = "MARG";

	/**
	* Constant for qualifier with value MATU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MATU
	* @see com.prowidesoftware.swift.SchemeConstantsM#MATU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MATU = "MATU";

	/**
	* Constant for qualifier with value MFKT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MFKT
	* @see com.prowidesoftware.swift.SchemeConstantsM#MFKT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MFKT = "MFKT";

	/**
	* Constant for qualifier with value MICO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MICO
	* @see com.prowidesoftware.swift.SchemeConstantsM#MICO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MICO = "MICO";

	/**
	* Constant for qualifier with value MINO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MINO
	* @see com.prowidesoftware.swift.SchemeConstantsM#MINO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MINO = "MINO";

	/**
	* Constant for qualifier with value MTCH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MTCH
	* @see com.prowidesoftware.swift.SchemeConstantsM#MTCH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MTCH = "MTCH";

	/**
	* Constant for qualifier with value NETT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NETT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NETT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NETT = "NETT";

	/**
	* Constant for qualifier with value NEWM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NEWM
	* @see com.prowidesoftware.swift.SchemeConstantsN#NEWM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NEWM = "NEWM";

	/**
	* Constant for qualifier with value NWFC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NWFC
	* @see com.prowidesoftware.swift.SchemeConstantsN#NWFC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NWFC = "NWFC";

	/**
	* Constant for qualifier with value NXRT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NXRT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NXRT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NXRT = "NXRT";

	/**
	* Constant for qualifier with value OCMT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OCMT
	* @see com.prowidesoftware.swift.SchemeConstantsO#OCMT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OCMT = "OCMT";

	/**
	* Constant for qualifier with value OMAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OMAT
	* @see com.prowidesoftware.swift.SchemeConstantsO#OMAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OMAT = "OMAT";

	/**
	* Constant for qualifier with value OPST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OPST
	* @see com.prowidesoftware.swift.SchemeConstantsO#OPST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OPST = "OPST";

	/**
	* Constant for qualifier with value OPTI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OPTI
	* @see com.prowidesoftware.swift.SchemeConstantsO#OPTI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OPTI = "OPTI";

	/**
	* Constant for qualifier with value OTHR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OTHR = "OTHR";

	/**
	* Constant for qualifier with value OTHRPRTY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHRPRTY
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHRPRTY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OTHRPRTY = "OTHRPRTY";

	/**
	* Constant for qualifier with value PACO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PACO
	* @see com.prowidesoftware.swift.SchemeConstantsP#PACO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PACO = "PACO";

	/**
	* Constant for qualifier with value PAIR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PAIR
	* @see com.prowidesoftware.swift.SchemeConstantsP#PAIR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PAIR = "PAIR";

	/**
	* Constant for qualifier with value PAYE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PAYE
	* @see com.prowidesoftware.swift.SchemeConstantsP#PAYE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PAYE = "PAYE";

	/**
	* Constant for qualifier with value PAYS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PAYS
	* @see com.prowidesoftware.swift.SchemeConstantsP#PAYS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PAYS = "PAYS";

	/**
	* Constant for qualifier with value PCTI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PCTI
	* @see com.prowidesoftware.swift.SchemeConstantsP#PCTI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PCTI = "PCTI";

	/**
	* Constant for qualifier with value PFRE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PFRE
	* @see com.prowidesoftware.swift.SchemeConstantsP#PFRE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PFRE = "PFRE";

	/**
	* Constant for qualifier with value PLIS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PLIS
	* @see com.prowidesoftware.swift.SchemeConstantsP#PLIS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PLIS = "PLIS";

	/**
	* Constant for qualifier with value POOL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.POOL
	* @see com.prowidesoftware.swift.SchemeConstantsP#POOL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String POOL = "POOL";

	/**
	* Constant for qualifier with value PREA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PREA
	* @see com.prowidesoftware.swift.SchemeConstantsP#PREA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PREA = "PREA";

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
	* Constant for qualifier with value PRFC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRFC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRFC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRFC = "PRFC";

	/**
	* Constant for qualifier with value PRIC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRIC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRIC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRIC = "PRIC";

	/**
	* Constant for qualifier with value PRIR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRIR
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRIR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRIR = "PRIR";

	/**
	* Constant for qualifier with value PROC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PROC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PROC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PROC = "PROC";

	/**
	* Constant for qualifier with value PUTT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PUTT
	* @see com.prowidesoftware.swift.SchemeConstantsP#PUTT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PUTT = "PUTT";

	/**
	* Constant for qualifier with value RECO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RECO
	* @see com.prowidesoftware.swift.SchemeConstantsR#RECO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RECO = "RECO";

	/**
	* Constant for qualifier with value REGF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REGF
	* @see com.prowidesoftware.swift.SchemeConstantsR#REGF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REGF = "REGF";

	/**
	* Constant for qualifier with value REGI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REGI
	* @see com.prowidesoftware.swift.SchemeConstantsR#REGI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REGI = "REGI";

	/**
	* Constant for qualifier with value REGT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REGT
	* @see com.prowidesoftware.swift.SchemeConstantsR#REGT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REGT = "REGT";

	/**
	* Constant for qualifier with value RELA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RELA
	* @see com.prowidesoftware.swift.SchemeConstantsR#RELA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RELA = "RELA";

	/**
	* Constant for qualifier with value REPO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REPO
	* @see com.prowidesoftware.swift.SchemeConstantsR#REPO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REPO = "REPO";

	/**
	* Constant for qualifier with value REPP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REPP
	* @see com.prowidesoftware.swift.SchemeConstantsR#REPP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REPP = "REPP";

	/**
	* Constant for qualifier with value REPT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REPT
	* @see com.prowidesoftware.swift.SchemeConstantsR#REPT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REPT = "REPT";

	/**
	* Constant for qualifier with value RERA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RERA
	* @see com.prowidesoftware.swift.SchemeConstantsR#RERA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RERA = "RERA";

	/**
	* Constant for qualifier with value RERT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RERT
	* @see com.prowidesoftware.swift.SchemeConstantsR#RERT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RERT = "RERT";

	/**
	* Constant for qualifier with value REST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REST
	* @see com.prowidesoftware.swift.SchemeConstantsR#REST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REST = "REST";

	/**
	* Constant for qualifier with value RESU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RESU
	* @see com.prowidesoftware.swift.SchemeConstantsR#RESU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RESU = "RESU";

	/**
	* Constant for qualifier with value REVA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REVA
	* @see com.prowidesoftware.swift.SchemeConstantsR#REVA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REVA = "REVA";

	/**
	* Constant for qualifier with value RPOR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RPOR
	* @see com.prowidesoftware.swift.SchemeConstantsR#RPOR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RPOR = "RPOR";

	/**
	* Constant for qualifier with value RSPR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RSPR
	* @see com.prowidesoftware.swift.SchemeConstantsR#RSPR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RSPR = "RSPR";

	/**
	* Constant for qualifier with value RTGS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RTGS
	* @see com.prowidesoftware.swift.SchemeConstantsR#RTGS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RTGS = "RTGS";

	/**
	* Constant for qualifier with value SAFE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SAFE
	* @see com.prowidesoftware.swift.SchemeConstantsS#SAFE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SAFE = "SAFE";

	/**
	* Constant for qualifier with value SECO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SECO
	* @see com.prowidesoftware.swift.SchemeConstantsS#SECO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SECO = "SECO";

	/**
	* Constant for qualifier with value SEME 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SEME
	* @see com.prowidesoftware.swift.SchemeConstantsS#SEME
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SEME = "SEME";

	/**
	* Constant for qualifier with value SETDET 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SETDET
	* @see com.prowidesoftware.swift.SchemeConstantsS#SETDET
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SETDET = "SETDET";

	/**
	* Constant for qualifier with value SETPRTY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SETPRTY
	* @see com.prowidesoftware.swift.SchemeConstantsS#SETPRTY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SETPRTY = "SETPRTY";

	/**
	* Constant for qualifier with value SETR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SETR
	* @see com.prowidesoftware.swift.SchemeConstantsS#SETR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SETR = "SETR";

	/**
	* Constant for qualifier with value SETS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SETS
	* @see com.prowidesoftware.swift.SchemeConstantsS#SETS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SETS = "SETS";

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
	* Constant for qualifier with value SHIP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SHIP
	* @see com.prowidesoftware.swift.SchemeConstantsS#SHIP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SHIP = "SHIP";

	/**
	* Constant for qualifier with value SIZE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SIZE
	* @see com.prowidesoftware.swift.SchemeConstantsS#SIZE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SIZE = "SIZE";

	/**
	* Constant for qualifier with value SLMG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SLMG
	* @see com.prowidesoftware.swift.SchemeConstantsS#SLMG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SLMG = "SLMG";

	/**
	* Constant for qualifier with value SPCN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SPCN
	* @see com.prowidesoftware.swift.SchemeConstantsS#SPCN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SPCN = "SPCN";

	/**
	* Constant for qualifier with value SPRO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SPRO
	* @see com.prowidesoftware.swift.SchemeConstantsS#SPRO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SPRO = "SPRO";

	/**
	* Constant for qualifier with value SSBT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SSBT
	* @see com.prowidesoftware.swift.SchemeConstantsS#SSBT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SSBT = "SSBT";

	/**
	* Constant for qualifier with value STAM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STAM
	* @see com.prowidesoftware.swift.SchemeConstantsS#STAM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STAM = "STAM";

	/**
	* Constant for qualifier with value STCO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STCO
	* @see com.prowidesoftware.swift.SchemeConstantsS#STCO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STCO = "STCO";

	/**
	* Constant for qualifier with value STEX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STEX
	* @see com.prowidesoftware.swift.SchemeConstantsS#STEX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STEX = "STEX";

	/**
	* Constant for qualifier with value TAPC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TAPC
	* @see com.prowidesoftware.swift.SchemeConstantsT#TAPC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TAPC = "TAPC";

	/**
	* Constant for qualifier with value TAXE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TAXE
	* @see com.prowidesoftware.swift.SchemeConstantsT#TAXE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TAXE = "TAXE";

	/**
	* Constant for qualifier with value TCPI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TCPI
	* @see com.prowidesoftware.swift.SchemeConstantsT#TCPI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TCPI = "TCPI";

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
	* Constant for qualifier with value TOCO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TOCO
	* @see com.prowidesoftware.swift.SchemeConstantsT#TOCO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TOCO = "TOCO";

	/**
	* Constant for qualifier with value TOSE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TOSE
	* @see com.prowidesoftware.swift.SchemeConstantsT#TOSE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TOSE = "TOSE";

	/**
	* Constant for qualifier with value TRAD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAD
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAD = "TRAD";

	/**
	* Constant for qualifier with value TRADDET 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRADDET
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRADDET
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRADDET = "TRADDET";

	/**
	* Constant for qualifier with value TRAK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAK
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAK = "TRAK";

	/**
	* Constant for qualifier with value TRAN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAN
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAN = "TRAN";

	/**
	* Constant for qualifier with value TRAX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAX
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAX = "TRAX";

	/**
	* Constant for qualifier with value TRCA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRCA
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRCA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRCA = "TRCA";

	/**
	* Constant for qualifier with value TRCI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRCI
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRCI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRCI = "TRCI";

	/**
	* Constant for qualifier with value TRRF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRRF
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRRF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRRF = "TRRF";

	/**
	* Constant for qualifier with value TRTE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRTE
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRTE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRTE = "TRTE";

	/**
	* Constant for qualifier with value TTCO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TTCO
	* @see com.prowidesoftware.swift.SchemeConstantsT#TTCO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TTCO = "TTCO";

	/**
	* Constant for qualifier with value TURN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TURN
	* @see com.prowidesoftware.swift.SchemeConstantsT#TURN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TURN = "TURN";

	/**
	* Constant for qualifier with value VASU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VASU
	* @see com.prowidesoftware.swift.SchemeConstantsV#VASU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VASU = "VASU";

	/**
	* Constant for qualifier with value VATA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VATA
	* @see com.prowidesoftware.swift.SchemeConstantsV#VATA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VATA = "VATA";

	/**
	* Constant for qualifier with value WITH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WITH
	* @see com.prowidesoftware.swift.SchemeConstantsW#WITH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String WITH = "WITH";

	/**
	* Constant for qualifier with value YTMR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsY.YTMR
	* @see com.prowidesoftware.swift.SchemeConstantsY#YTMR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String YTMR = "YTMR";

// end qualifiers constants	

	/**
	 * Creates an MT540 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT540 content
	 */
	public MT540(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT540 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT540 content, the parameter can not be <code>null</code>
	 * @see #MT540(String)
	 */
	public MT540(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT540 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT540 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT540(String)
	 * @since 7.7
	 */
	public static MT540 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT540(m.message());
	}
	
	/**
	 * Creates and initializes a new MT540 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT540() {
		super(540);
	}
	
	/**
	 * Creates and initializes a new MT540 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT540(final String sender, final String receiver) {
		super(540, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT540(sender, receiver)</code>
	* @see #MT540(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT540(final int messageType, final String sender, final String receiver) {
		super(540, sender, receiver);
	}
	
	/**
	 * Creates a new MT540 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT540(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT540 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT540 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT540 or null if fin is null 
	 * @since 7.7
	 */
	public static MT540 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT540(fin);
    }
    
    /**
	 * Creates a new MT540 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT540(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT540 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT540 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT540 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT540(stream);
    }
    
    /**
	 * Creates a new MT540 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT540(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT540 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT540 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT540 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT540(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "540";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT540 append(final SwiftTagListBlock block) {
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
	public MT540 append(final Tag ... tags) {
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
	public MT540 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23G, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23G at MT540 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 99A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 99A at MT540 is expected to be the only one.
	 * 
	 * @return a Field99A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field99A getField99A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("99A");
			if (t == null) {
				log.fine("field 99A not found");
				return null;
			} else {
				return new Field99A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 99B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 99B at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 16R at MT540 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22F at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 13A at MT540 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 13B at MT540 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 20C at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 36B at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 16S at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94B at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94H at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94H> getField94H() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("94H");
			final List<Field94H> result = new ArrayList<Field94H>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field94H(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94L at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94L> getField94L() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("94L");
			final List<Field94L> result = new ArrayList<Field94L>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field94L(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98A at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98B at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98C at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98E at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98E> getField98E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98E");
			final List<Field98E> result = new ArrayList<Field98E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 12A at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12A> getField12A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("12A");
			final List<Field12A> result = new ArrayList<Field12A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field12A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 12C at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12C> getField12C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("12C");
			final List<Field12C> result = new ArrayList<Field12C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field12C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 12B at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12B> getField12B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("12B");
			final List<Field12B> result = new ArrayList<Field12B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field12B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92A at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 17B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 17B at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 90A at MT540 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 90B at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 35B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 35B at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 11A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 11A at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 25D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 25D at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 70E at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70E> getField70E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("70E");
			final List<Field70E> result = new ArrayList<Field70E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field70E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95P at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95R at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95L at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 97A at MT540 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 97B at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 97E at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97E> getField97E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("97E");
			final List<Field97E> result = new ArrayList<Field97E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field97E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94C at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94C> getField94C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("94C");
			final List<Field94C> result = new ArrayList<Field94C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field94C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94F at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94F> getField94F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("94F");
			final List<Field94F> result = new ArrayList<Field94F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field94F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92C at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92C> getField92C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92C");
			final List<Field92C> result = new ArrayList<Field92C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 19A at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95C at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95C> getField95C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("95C");
			final List<Field95C> result = new ArrayList<Field95C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field95C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95Q, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95Q at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95S at MT540 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95S> getField95S() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("95S");
			final List<Field95S> result = new ArrayList<Field95S>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field95S(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 70C at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 70D at MT540 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92B at MT540 are expected at one sequence or across several sequences.
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
	

/*
 * sequences code
 *
 */ 


// BaseSequenceCodeGenerator [seq=A]
	/**
	* Class for Sequence "A" of MT 540
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
	* Class for Sequence "A1" of MT 540
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


// BaseSequenceCodeGenerator [seq=B]
	/**
	* Class for Sequence "B" of MT 540
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>TRADDET</em>
		*/
		public static final String START_END_16RS = "TRADDET";
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
	* Class for Sequence "B1" of MT 540
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>FIA</em>
		*/
		public static final String START_END_16RS = "FIA";
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
	* Class for Sequence "C" of MT 540
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>FIAC</em>
		*/
		public static final String START_END_16RS = "FIAC";
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
	* Get the single occurrence of SequenceC delimited by 16R/16S the value of SequenceC#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceC</code> is returned</em>
	* @see SequenceC#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceC getSequenceC() {
		return new SequenceC(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceC delimited by 16R/16S the value of SequenceC#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceC</code> is returned</em>  
	* @see SequenceC#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceC getSequenceC(SwiftTagListBlock parentSequence) {
		final SequenceC s = new SequenceC();
		s.setTags(parentSequence.getSubBlock(SequenceC.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=C1]
	/**
	* Class for Sequence "C1" of MT 540
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>BREAK</em>
		*/
		public static final String START_END_16RS = "BREAK";
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


// BaseSequenceCodeGenerator [seq=D]
	/**
	* Class for Sequence "D" of MT 540
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>REPO</em>
		*/
		public static final String START_END_16RS = "REPO";
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
	* Get the single occurrence of SequenceD delimited by 16R/16S the value of SequenceD#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceD</code> is returned</em>
	* @see SequenceD#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceD getSequenceD() {
		return new SequenceD(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceD delimited by 16R/16S the value of SequenceD#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceD</code> is returned</em>  
	* @see SequenceD#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceD getSequenceD(SwiftTagListBlock parentSequence) {
		final SequenceD s = new SequenceD();
		s.setTags(parentSequence.getSubBlock(SequenceD.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=E]
	/**
	* Class for Sequence "E" of MT 540
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
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SETDET</em>
		*/
		public static final String START_END_16RS = "SETDET";
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


// BaseSequenceCodeGenerator [seq=E1]
	/**
	* Class for Sequence "E1" of MT 540
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceE1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceE1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceE1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SETPRTY</em>
		*/
		public static final String START_END_16RS = "SETPRTY";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceE1 newInstance(final Tag ... tags) {
			final SequenceE1 result = new SequenceE1();

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
		public static SequenceE1 newInstance() {
			final SequenceE1 result = new SequenceE1();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceE1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE1 result = new SequenceE1();

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
		private SequenceE1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceE1 delimited by 16R/16S with value specified in SequenceE1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE1#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceE1> getSequenceE1List() {
		return getSequenceE1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceE1 delimited by 16R/16S with value specified in SequenceE1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE1#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceE1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceE1> getSequenceE1List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceE1.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceE1> result = new ArrayList<SequenceE1>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceE1 s = new SequenceE1();
				s.setTags(b.getSubBlock(SequenceE1.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=E2]
	/**
	* Class for Sequence "E2" of MT 540
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceE2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceE2() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceE2(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CSHPRTY</em>
		*/
		public static final String START_END_16RS = "CSHPRTY";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceE2 newInstance(final Tag ... tags) {
			final SequenceE2 result = new SequenceE2();

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
		public static SequenceE2 newInstance() {
			final SequenceE2 result = new SequenceE2();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceE2 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE2 result = new SequenceE2();

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
		private SequenceE2(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceE2 delimited by 16R/16S with value specified in SequenceE2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE2#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceE2> getSequenceE2List() {
		return getSequenceE2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceE2 delimited by 16R/16S with value specified in SequenceE2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE2#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceE2 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceE2> getSequenceE2List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceE2.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceE2> result = new ArrayList<SequenceE2>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceE2 s = new SequenceE2();
				s.setTags(b.getSubBlock(SequenceE2.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=E3]
	/**
	* Class for Sequence "E3" of MT 540
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceE3 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceE3() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceE3(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>AMT</em>
		*/
		public static final String START_END_16RS = "AMT";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceE3 newInstance(final Tag ... tags) {
			final SequenceE3 result = new SequenceE3();

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
		public static SequenceE3 newInstance() {
			final SequenceE3 result = new SequenceE3();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceE3 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE3 result = new SequenceE3();

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
		private SequenceE3(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceE3 delimited by 16R/16S with value specified in SequenceE3#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE3#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceE3> getSequenceE3List() {
		return getSequenceE3List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceE3 delimited by 16R/16S with value specified in SequenceE3#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE3#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceE3 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceE3> getSequenceE3List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceE3.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceE3> result = new ArrayList<SequenceE3>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceE3 s = new SequenceE3();
				s.setTags(b.getSubBlock(SequenceE3.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=F]
	/**
	* Class for Sequence "F" of MT 540
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceF extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceF() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceF(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>OTHRPRTY</em>
		*/
		public static final String START_END_16RS = "OTHRPRTY";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceF newInstance(final Tag ... tags) {
			final SequenceF result = new SequenceF();

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
		public static SequenceF newInstance() {
			final SequenceF result = new SequenceF();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceF newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceF result = new SequenceF();

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
		private SequenceF(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceF delimited by 16R/16S with value specified in SequenceF#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceF#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceF> getSequenceFList() {
		return getSequenceFList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceF delimited by 16R/16S with value specified in SequenceF#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceF#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceF within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceF> getSequenceFList(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceF.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceF> result = new ArrayList<SequenceF>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceF s = new SequenceF();
				s.setTags(b.getSubBlock(SequenceF.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator





}

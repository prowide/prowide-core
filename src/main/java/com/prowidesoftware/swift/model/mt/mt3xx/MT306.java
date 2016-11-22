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
 package com.prowidesoftware.swift.model.mt.mt3xx;

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
 * MT 306<br />
 * Foreign Currency Option Confirmation<br />
 <h1>MT306 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="sequence">
<em>Sequence A</em><br/>
<div class="field"><em>Field 15</em>
Letter options: A<br/></div><div class="field"><em>Field 20</em>
Letter options: null<br/></div><div class="field"><em>Field 21</em>
Letter options: null<br/></div><div class="field"><em>Field 22</em>
Letter options: A<br/></div><div class="field"><em>Field 94</em>
Letter options: A<br/></div><div class="field"><em>Field 22</em>
Letter options: C<br/></div><div class="field"><em>Field 21</em>
Letter options: N<br/></div><div class="field"><em>Field 21</em>
Letter options: B<br/></div><div class="field"><em>Field 12</em>
Letter options: F<br/></div><div class="field"><em>Field 12</em>
Letter options: E<br/></div><div class="field"><em>Field 12</em>
Letter options: D<br/></div><div class="field"><em>Field 17</em>
Letter options: A<br/></div><div class="field"><em>Field 17</em>
Letter options: F<br/></div><div class="field"><em>Field 22</em>
Letter options: K<br/></div><div class="field"><em>Field 30</em>
Letter options: U<br/></div><div class="field"><em>Field 29</em>
Letter options: H<br/></div><div class="field"><em>Field 82</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 87</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 83</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 77</em>
Letter options: H<br/></div><div class="field"><em>Field 77</em>
Letter options: D<br/></div><div class="field"><em>Field 14</em>
Letter options: C<br/></div></blockquote>
<div class="sequence">
<em>Sequence B</em><br/>
<div class="field"><em>Field 15</em>
Letter options: B<br/></div><div class="field"><em>Field 17</em>
Letter options: V<br/></div><div class="field"><em>Field 30</em>
Letter options: T<br/></div><div class="field"><em>Field 30</em>
Letter options: X<br/></div><div class="field"><em>Field 29</em>
Letter options: E<br/></div><div class="field"><em>Field 30</em>
Letter options: F,J<br/></div><div class="field"><em>Field 14</em>
Letter options: S<br/></div><div class="sequence">
<em>Sequence B1</em><br/>
<div class="field"><em>Field 37</em>
Letter options: K<br/></div><div class="field"><em>Field 30</em>
Letter options: V<br/></div><div class="field"><em>Field 34</em>
Letter options: B<br/></div></blockquote>
<div class="sequence">
<em>Sequence B2</em><br/>
<div class="field"><em>Field 84</em>
Letter options: A,B,D,J<br/></div></blockquote>
</blockquote>
<div class="sequence">
<em>Sequence C</em><br/>
<div class="field"><em>Field 15</em>
Letter options: C<br/></div><div class="field"><em>Field 53</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 86</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 56</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 57</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 58</em>
Letter options: A,D,J<br/></div></blockquote>
<div class="sequence">
<em>Sequence D</em><br/>
<div class="field"><em>Field 15</em>
Letter options: D<br/></div><div class="field"><em>Field 30</em>
Letter options: P<br/></div><div class="field"><em>Field 30</em>
Letter options: Q<br/></div><div class="field"><em>Field 26</em>
Letter options: F<br/></div><div class="field"><em>Field 32</em>
Letter options: B<br/></div><div class="field"><em>Field 36</em>
Letter options: null<br/></div><div class="field"><em>Field 33</em>
Letter options: B<br/></div></blockquote>
<div class="sequence">
<em>Sequence E</em><br/>
<div class="field"><em>Field 15</em>
Letter options: E<br/></div><div class="field"><em>Field 33</em>
Letter options: E<br/></div><div class="field"><em>Field 30</em>
Letter options: H<br/></div><div class="field"><em>Field 53</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 86</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 56</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 57</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 58</em>
Letter options: A,D,J<br/></div></blockquote>
<div class="sequence">
<em>Sequence F</em><br/>
<div class="field"><em>Field 15</em>
Letter options: F<br/></div><div class="field"><em>Field 22</em>
Letter options: G<br/></div><div class="field"><em>Field 37</em>
Letter options: J<br/></div><div class="field"><em>Field 37</em>
Letter options: L<br/></div><div class="sequence">
<em>Sequence F1</em><br/>
<div class="field"><em>Field 30</em>
Letter options: G<br/></div><div class="field"><em>Field 29</em>
Letter options: J<br/></div><div class="field"><em>Field 29</em>
Letter options: K<br/></div><div class="field"><em>Field 14</em>
Letter options: S<br/></div></blockquote>
</blockquote>
<div class="sequence">
<em>Sequence G</em><br/>
<div class="field"><em>Field 15</em>
Letter options: G<br/></div><div class="field"><em>Field 22</em>
Letter options: J<br/></div><div class="field"><em>Field 37</em>
Letter options: U<br/></div><div class="field"><em>Field 37</em>
Letter options: P<br/></div><div class="field"><em>Field 32</em>
Letter options: Q<br/></div><div class="field"><em>Field 14</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence H</em><br/>
<div class="field"><em>Field 15</em>
Letter options: H<br/></div><div class="field"><em>Field 14</em>
Letter options: S<br/></div><div class="field"><em>Field 32</em>
Letter options: E<br/></div></blockquote>
<div class="sequence">
<em>Sequence I</em><br/>
<div class="field"><em>Field 15</em>
Letter options: I<br/></div><div class="field"><em>Field 12</em>
Letter options: G<br/></div><div class="field"><em>Field 30</em>
Letter options: T<br/></div><div class="field"><em>Field 22</em>
Letter options: Y<br/></div><div class="field"><em>Field 85</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 88</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 84</em>
Letter options: A,B,D,J<br/></div><div class="field"><em>Field 30</em>
Letter options: Y<br/></div><div class="field"><em>Field 29</em>
Letter options: L<br/></div><div class="field"><em>Field 29</em>
Letter options: E<br/></div><div class="field"><em>Field 29</em>
Letter options: M<br/></div><div class="field"><em>Field 17</em>
Letter options: I<br/></div><div class="field"><em>Field 29</em>
Letter options: N<br/></div><div class="field"><em>Field 30</em>
Letter options: Z<br/></div><div class="field"><em>Field 14</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence J</em><br/>
<div class="field"><em>Field 15</em>
Letter options: J<br/></div><div class="field"><em>Field 14</em>
Letter options: S<br/></div><div class="field"><em>Field 14</em>
Letter options: B<br/></div><div class="field"><em>Field 16</em>
Letter options: C<br/></div><div class="sequence">
<em>Sequence J1</em><br/>
<div class="field"><em>Field 18</em>
Letter options: B<br/></div><div class="sequence">
<em>Sequence J1a</em><br/>
<div class="field"><em>Field 30</em>
Letter options: M<br/></div><div class="field"><em>Field 19</em>
Letter options: Y<br/></div></blockquote>
</blockquote>
<div class="sequence">
<em>Sequence J2</em><br/>
<div class="field"><em>Field 18</em>
Letter options: C<br/></div><div class="sequence">
<em>Sequence J2a</em><br/>
<div class="field"><em>Field 30</em>
Letter options: N<br/></div><div class="field"><em>Field 19</em>
Letter options: Z<br/></div></blockquote>
</blockquote>
<div class="field"><em>Field 19</em>
Letter options: C<br/></div><div class="field"><em>Field 23</em>
Letter options: C<br/></div></blockquote>
<div class="sequence">
<em>Sequence K</em><br/>
<div class="field"><em>Field 15</em>
Letter options: K<br/></div><div class="field"><em>Field 29</em>
Letter options: A<br/></div><div class="field"><em>Field 24</em>
Letter options: D<br/></div><div class="field"><em>Field 88</em>
Letter options: A,D<br/></div><div class="field"><em>Field 71</em>
Letter options: F<br/></div><div class="field"><em>Field 21</em>
Letter options: G<br/></div><div class="field"><em>Field 72</em>
Letter options: null<br/></div></blockquote>
<div class="sequence">
<em>Sequence L</em><br/>
<div class="field"><em>Field 15</em>
Letter options: L<br/></div><div class="field"><em>Field 18</em>
Letter options: A<br/></div><div class="sequence">
<em>Sequence L1</em><br/>
<div class="field"><em>Field 30</em>
Letter options: F<br/></div><div class="field"><em>Field 32</em>
Letter options: H<br/></div></blockquote>
<div class="field"><em>Field 53</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 86</em>
Letter options: A,D,J<br/></div><div class="field"><em>Field 56</em>
Letter options: A,D,J<br/></div></blockquote>
<div class="sequence">
<em>Sequence M</em><br/>
<div class="field"><em>Field 15</em>
Letter options: M<br/></div><div class="sequence">
<em>Sequence M1</em><br/>
<div class="field"><em>Field 22</em>
Letter options: L<br/></div><div class="field"><em>Field 91</em>
Letter options: A,D,J<br/></div><div class="sequence">
<em>Sequence M1a</em><br/>
<div class="field"><em>Field 22</em>
Letter options: M<br/></div><div class="field"><em>Field 22</em>
Letter options: N<br/></div><div class="sequence">
<em>Sequence M1a1</em><br/>
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
Letter options: X<br/></div><div class="field"><em>Field 77</em>
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
public class MT306 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT306.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "306";
	
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
	* Constant for qualifier with value AD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AD
	* @see com.prowidesoftware.swift.SchemeConstantsA#AD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AD = "AD";

	/**
	* Constant for qualifier with value AFB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AFB
	* @see com.prowidesoftware.swift.SchemeConstantsA#AFB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AFB = "AFB";

	/**
	* Constant for qualifier with value AGNT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AGNT
	* @see com.prowidesoftware.swift.SchemeConstantsA#AGNT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AGNT = "AGNT";

	/**
	* Constant for qualifier with value AMER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMER
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AMER = "AMER";

	/**
	* Constant for qualifier with value AMND 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AMND
	* @see com.prowidesoftware.swift.SchemeConstantsA#AMND
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AMND = "AMND";

	/**
	* Constant for qualifier with value ASIA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ASIA
	* @see com.prowidesoftware.swift.SchemeConstantsA#ASIA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ASIA = "ASIA";

	/**
	* Constant for qualifier with value AVRF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AVRF
	* @see com.prowidesoftware.swift.SchemeConstantsA#AVRF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AVRF = "AVRF";

	/**
	* Constant for qualifier with value AVRO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AVRO
	* @see com.prowidesoftware.swift.SchemeConstantsA#AVRO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AVRO = "AVRO";

	/**
	* Constant for qualifier with value AVSF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AVSF
	* @see com.prowidesoftware.swift.SchemeConstantsA#AVSF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AVSF = "AVSF";

	/**
	* Constant for qualifier with value AVSO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AVSO
	* @see com.prowidesoftware.swift.SchemeConstantsA#AVSO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AVSO = "AVSO";

	/**
	* Constant for qualifier with value B 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.B
	* @see com.prowidesoftware.swift.SchemeConstantsB#B
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String B = "B";

	/**
	* Constant for qualifier with value BERM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BERM
	* @see com.prowidesoftware.swift.SchemeConstantsB#BERM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BERM = "BERM";

	/**
	* Constant for qualifier with value BILA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BILA
	* @see com.prowidesoftware.swift.SchemeConstantsB#BILA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BILA = "BILA";

	/**
	* Constant for qualifier with value BINA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BINA
	* @see com.prowidesoftware.swift.SchemeConstantsB#BINA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BINA = "BINA";

	/**
	* Constant for qualifier with value BROK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BROK
	* @see com.prowidesoftware.swift.SchemeConstantsB#BROK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BROK = "BROK";

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
	* Constant for qualifier with value CANC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CANC
	* @see com.prowidesoftware.swift.SchemeConstantsC#CANC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CANC = "CANC";

	/**
	* Constant for qualifier with value CLST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLST
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLST = "CLST";

	/**
	* Constant for qualifier with value CONF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CONF
	* @see com.prowidesoftware.swift.SchemeConstantsC#CONF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CONF = "CONF";

	/**
	* Constant for qualifier with value DAVF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DAVF
	* @see com.prowidesoftware.swift.SchemeConstantsD#DAVF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DAVF = "DAVF";

	/**
	* Constant for qualifier with value DAVO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DAVO
	* @see com.prowidesoftware.swift.SchemeConstantsD#DAVO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DAVO = "DAVO";

	/**
	* Constant for qualifier with value DBTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DBTR
	* @see com.prowidesoftware.swift.SchemeConstantsD#DBTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DBTR = "DBTR";

	/**
	* Constant for qualifier with value DERV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DERV
	* @see com.prowidesoftware.swift.SchemeConstantsD#DERV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DERV = "DERV";

	/**
	* Constant for qualifier with value DIGI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DIGI
	* @see com.prowidesoftware.swift.SchemeConstantsD#DIGI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DIGI = "DIGI";

	/**
	* Constant for qualifier with value DKIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DKIN
	* @see com.prowidesoftware.swift.SchemeConstantsD#DKIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DKIN = "DKIN";

	/**
	* Constant for qualifier with value DKOT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DKOT
	* @see com.prowidesoftware.swift.SchemeConstantsD#DKOT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DKOT = "DKOT";

	/**
	* Constant for qualifier with value ELEC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ELEC
	* @see com.prowidesoftware.swift.SchemeConstantsE#ELEC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ELEC = "ELEC";

	/**
	* Constant for qualifier with value EURO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EURO
	* @see com.prowidesoftware.swift.SchemeConstantsE#EURO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EURO = "EURO";

	/**
	* Constant for qualifier with value F 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.F
	* @see com.prowidesoftware.swift.SchemeConstantsF#F
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String F = "F";

	/**
	* Constant for qualifier with value FAXT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FAXT
	* @see com.prowidesoftware.swift.SchemeConstantsF#FAXT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FAXT = "FAXT";

	/**
	* Constant for qualifier with value FBF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FBF
	* @see com.prowidesoftware.swift.SchemeConstantsF#FBF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FBF = "FBF";

	/**
	* Constant for qualifier with value FEOMA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FEOMA
	* @see com.prowidesoftware.swift.SchemeConstantsF#FEOMA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FEOMA = "FEOMA";

	/**
	* Constant for qualifier with value FLIPPED 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FLIPPED
	* @see com.prowidesoftware.swift.SchemeConstantsF#FLIPPED
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FLIPPED = "FLIPPED";

	/**
	* Constant for qualifier with value ICOM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ICOM
	* @see com.prowidesoftware.swift.SchemeConstantsI#ICOM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ICOM = "ICOM";

	/**
	* Constant for qualifier with value IFEMA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.IFEMA
	* @see com.prowidesoftware.swift.SchemeConstantsI#IFEMA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String IFEMA = "IFEMA";

	/**
	* Constant for qualifier with value ISDA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ISDA
	* @see com.prowidesoftware.swift.SchemeConstantsI#ISDA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ISDA = "ISDA";

	/**
	* Constant for qualifier with value ISDACN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ISDACN
	* @see com.prowidesoftware.swift.SchemeConstantsI#ISDACN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ISDACN = "ISDACN";

	/**
	* Constant for qualifier with value KIKO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsK.KIKO
	* @see com.prowidesoftware.swift.SchemeConstantsK#KIKO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String KIKO = "KIKO";

	/**
	* Constant for qualifier with value KNIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsK.KNIN
	* @see com.prowidesoftware.swift.SchemeConstantsK#KNIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String KNIN = "KNIN";

	/**
	* Constant for qualifier with value KNOT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsK.KNOT
	* @see com.prowidesoftware.swift.SchemeConstantsK#KNOT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String KNOT = "KNOT";

	/**
	* Constant for qualifier with value KOKI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsK.KOKI
	* @see com.prowidesoftware.swift.SchemeConstantsK#KOKI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String KOKI = "KOKI";

	/**
	* Constant for qualifier with value N 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.N
	* @see com.prowidesoftware.swift.SchemeConstantsN#N
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String N = "N";

	/**
	* Constant for qualifier with value NETCASH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NETCASH
	* @see com.prowidesoftware.swift.SchemeConstantsN#NETCASH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NETCASH = "NETCASH";

	/**
	* Constant for qualifier with value NEWT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NEWT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NEWT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NEWT = "NEWT";

	/**
	* Constant for qualifier with value NORMAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NORMAL
	* @see com.prowidesoftware.swift.SchemeConstantsN#NORMAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NORMAL = "NORMAL";

	/**
	* Constant for qualifier with value NOTO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NOTO
	* @see com.prowidesoftware.swift.SchemeConstantsN#NOTO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NOTO = "NOTO";

	/**
	* Constant for qualifier with value O 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.O
	* @see com.prowidesoftware.swift.SchemeConstantsO#O
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String O = "O";

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
	* Constant for qualifier with value PC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PC = "PC";

	/**
	* Constant for qualifier with value PHON 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PHON
	* @see com.prowidesoftware.swift.SchemeConstantsP#PHON
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PHON = "PHON";

	/**
	* Constant for qualifier with value PRINCIPAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRINCIPAL
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRINCIPAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRINCIPAL = "PRINCIPAL";

	/**
	* Constant for qualifier with value PUTO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PUTO
	* @see com.prowidesoftware.swift.SchemeConstantsP#PUTO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PUTO = "PUTO";

	/**
	* Constant for qualifier with value S 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.S
	* @see com.prowidesoftware.swift.SchemeConstantsS#S
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String S = "S";

	/**
	* Constant for qualifier with value SITR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SITR
	* @see com.prowidesoftware.swift.SchemeConstantsS#SITR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SITR = "SITR";

	/**
	* Constant for qualifier with value SKIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SKIN
	* @see com.prowidesoftware.swift.SchemeConstantsS#SKIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SKIN = "SKIN";

	/**
	* Constant for qualifier with value SKOT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SKOT
	* @see com.prowidesoftware.swift.SchemeConstantsS#SKOT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SKOT = "SKOT";

	/**
	* Constant for qualifier with value TELX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TELX
	* @see com.prowidesoftware.swift.SchemeConstantsT#TELX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TELX = "TELX";

	/**
	* Constant for qualifier with value TRIG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRIG
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRIG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRIG = "TRIG";

	/**
	* Constant for qualifier with value U 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.U
	* @see com.prowidesoftware.swift.SchemeConstantsU#U
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String U = "U";

	/**
	* Constant for qualifier with value VANI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VANI
	* @see com.prowidesoftware.swift.SchemeConstantsV#VANI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VANI = "VANI";

	/**
	* Constant for qualifier with value Y 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsY.Y
	* @see com.prowidesoftware.swift.SchemeConstantsY#Y
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String Y = "Y";

// end qualifiers constants	

	/**
	 * Creates an MT306 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT306 content
	 */
	public MT306(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT306 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT306 content, the parameter can not be <code>null</code>
	 * @see #MT306(String)
	 */
	public MT306(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT306 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT306 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT306(String)
	 * @since 7.7
	 */
	public static MT306 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT306(m.message());
	}
	
	/**
	 * Creates and initializes a new MT306 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT306() {
		super(306);
	}
	
	/**
	 * Creates and initializes a new MT306 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT306(final String sender, final String receiver) {
		super(306, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT306(sender, receiver)</code>
	* @see #MT306(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT306(final int messageType, final String sender, final String receiver) {
		super(306, sender, receiver);
	}
	
	/**
	 * Creates a new MT306 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT306(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT306 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT306 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT306 or null if fin is null 
	 * @since 7.7
	 */
	public static MT306 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT306(fin);
    }
    
    /**
	 * Creates a new MT306 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT306(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT306 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT306 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT306 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT306(stream);
    }
    
    /**
	 * Creates a new MT306 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT306(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT306 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT306 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT306 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT306(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "306";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT306 append(final SwiftTagListBlock block) {
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
	public MT306 append(final Tag ... tags) {
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
	public MT306 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15A at MT306 is expected to be the only one.
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
	 * The first occurrence of field 20 at MT306 is expected to be the only one.
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
	 * The first occurrence of field 21 at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22A at MT306 is expected to be the only one.
	 * 
	 * @return a Field22A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22A getField22A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("22A");
			if (t == null) {
				log.fine("field 22A not found");
				return null;
			} else {
				return new Field22A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 94A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 94A at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 22C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22C at MT306 is expected to be the only one.
	 * 
	 * @return a Field22C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22C getField22C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("22C");
			if (t == null) {
				log.fine("field 22C not found");
				return null;
			} else {
				return new Field22C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21N, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 21N at MT306 is expected to be the only one.
	 * 
	 * @return a Field21N object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21N getField21N() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("21N");
			if (t == null) {
				log.fine("field 21N not found");
				return null;
			} else {
				return new Field21N(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 21B at MT306 is expected to be the only one.
	 * 
	 * @return a Field21B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21B getField21B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("21B");
			if (t == null) {
				log.fine("field 21B not found");
				return null;
			} else {
				return new Field21B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 12F at MT306 is expected to be the only one.
	 * 
	 * @return a Field12F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12F getField12F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("12F");
			if (t == null) {
				log.fine("field 12F not found");
				return null;
			} else {
				return new Field12F(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 12E at MT306 is expected to be the only one.
	 * 
	 * @return a Field12E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12E getField12E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("12E");
			if (t == null) {
				log.fine("field 12E not found");
				return null;
			} else {
				return new Field12E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 12D at MT306 is expected to be the only one.
	 * 
	 * @return a Field12D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12D getField12D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("12D");
			if (t == null) {
				log.fine("field 12D not found");
				return null;
			} else {
				return new Field12D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17A at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 17F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17F at MT306 is expected to be the only one.
	 * 
	 * @return a Field17F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17F getField17F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17F");
			if (t == null) {
				log.fine("field 17F not found");
				return null;
			} else {
				return new Field17F(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22K, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22K at MT306 is expected to be the only one.
	 * 
	 * @return a Field22K object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22K getField22K() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("22K");
			if (t == null) {
				log.fine("field 22K not found");
				return null;
			} else {
				return new Field22K(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30U, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30U at MT306 is expected to be the only one.
	 * 
	 * @return a Field30U object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30U getField30U() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("30U");
			if (t == null) {
				log.fine("field 30U not found");
				return null;
			} else {
				return new Field30U(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29H, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29H at MT306 is expected to be the only one.
	 * 
	 * @return a Field29H object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29H getField29H() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("29H");
			if (t == null) {
				log.fine("field 29H not found");
				return null;
			} else {
				return new Field29H(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 82A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 82A at MT306 is expected to be the only one.
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
	 * The first occurrence of field 82D at MT306 is expected to be the only one.
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
	 * The first occurrence of field 82J at MT306 is expected to be the only one.
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
	 * The first occurrence of field 87A at MT306 is expected to be the only one.
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
	 * The first occurrence of field 87D at MT306 is expected to be the only one.
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
	 * The first occurrence of field 87J at MT306 is expected to be the only one.
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
	 * The first occurrence of field 83A at MT306 is expected to be the only one.
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
	 * The first occurrence of field 83D at MT306 is expected to be the only one.
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
	 * The first occurrence of field 83J at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 77H, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 77H at MT306 is expected to be the only one.
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
	 * The first occurrence of field 77D at MT306 is expected to be the only one.
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
	 * The first occurrence of field 14C at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15B at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 17V, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17V at MT306 is expected to be the only one.
	 * 
	 * @return a Field17V object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17V getField17V() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17V");
			if (t == null) {
				log.fine("field 17V not found");
				return null;
			} else {
				return new Field17V(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30X, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30X at MT306 is expected to be the only one.
	 * 
	 * @return a Field30X object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30X getField30X() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("30X");
			if (t == null) {
				log.fine("field 30X not found");
				return null;
			} else {
				return new Field30X(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30J at MT306 is expected to be the only one.
	 * 
	 * @return a Field30J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30J getField30J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("30J");
			if (t == null) {
				log.fine("field 30J not found");
				return null;
			} else {
				return new Field30J(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37K, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37K at MT306 is expected to be the only one.
	 * 
	 * @return a Field37K object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37K getField37K() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("37K");
			if (t == null) {
				log.fine("field 37K not found");
				return null;
			} else {
				return new Field37K(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30V, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30V at MT306 is expected to be the only one.
	 * 
	 * @return a Field30V object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30V getField30V() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("30V");
			if (t == null) {
				log.fine("field 30V not found");
				return null;
			} else {
				return new Field30V(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 34B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 34B at MT306 is expected to be the only one.
	 * 
	 * @return a Field34B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field34B getField34B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("34B");
			if (t == null) {
				log.fine("field 34B not found");
				return null;
			} else {
				return new Field34B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15C at MT306 is expected to be the only one.
	 * 
	 * @return a Field15C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15C getField15C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15C");
			if (t == null) {
				log.fine("field 15C not found");
				return null;
			} else {
				return new Field15C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15D at MT306 is expected to be the only one.
	 * 
	 * @return a Field15D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15D getField15D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15D");
			if (t == null) {
				log.fine("field 15D not found");
				return null;
			} else {
				return new Field15D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30P at MT306 is expected to be the only one.
	 * 
	 * @return a Field30P object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30P getField30P() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("30P");
			if (t == null) {
				log.fine("field 30P not found");
				return null;
			} else {
				return new Field30P(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 26F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 26F at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 32B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32B at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 36, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 36 at MT306 is expected to be the only one.
	 * 
	 * @return a Field36 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field36 getField36() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("36");
			if (t == null) {
				log.fine("field 36 not found");
				return null;
			} else {
				return new Field36(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 33B at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15E at MT306 is expected to be the only one.
	 * 
	 * @return a Field15E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15E getField15E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15E");
			if (t == null) {
				log.fine("field 15E not found");
				return null;
			} else {
				return new Field15E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 33E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 33E at MT306 is expected to be the only one.
	 * 
	 * @return a Field33E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field33E getField33E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("33E");
			if (t == null) {
				log.fine("field 33E not found");
				return null;
			} else {
				return new Field33E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30H, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30H at MT306 is expected to be the only one.
	 * 
	 * @return a Field30H object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30H getField30H() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("30H");
			if (t == null) {
				log.fine("field 30H not found");
				return null;
			} else {
				return new Field30H(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15F at MT306 is expected to be the only one.
	 * 
	 * @return a Field15F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15F getField15F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15F");
			if (t == null) {
				log.fine("field 15F not found");
				return null;
			} else {
				return new Field15F(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22G, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22G at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 37J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37J at MT306 is expected to be the only one.
	 * 
	 * @return a Field37J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37J getField37J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("37J");
			if (t == null) {
				log.fine("field 37J not found");
				return null;
			} else {
				return new Field37J(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37L at MT306 is expected to be the only one.
	 * 
	 * @return a Field37L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37L getField37L() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("37L");
			if (t == null) {
				log.fine("field 37L not found");
				return null;
			} else {
				return new Field37L(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15H, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15H at MT306 is expected to be the only one.
	 * 
	 * @return a Field15H object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15H getField15H() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15H");
			if (t == null) {
				log.fine("field 15H not found");
				return null;
			} else {
				return new Field15H(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 32E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 32E at MT306 is expected to be the only one.
	 * 
	 * @return a Field32E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field32E getField32E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("32E");
			if (t == null) {
				log.fine("field 32E not found");
				return null;
			} else {
				return new Field32E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15I, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15I at MT306 is expected to be the only one.
	 * 
	 * @return a Field15I object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15I getField15I() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15I");
			if (t == null) {
				log.fine("field 15I not found");
				return null;
			} else {
				return new Field15I(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12G, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 12G at MT306 is expected to be the only one.
	 * 
	 * @return a Field12G object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12G getField12G() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("12G");
			if (t == null) {
				log.fine("field 12G not found");
				return null;
			} else {
				return new Field12G(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22Y, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22Y at MT306 is expected to be the only one.
	 * 
	 * @return a Field22Y object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22Y getField22Y() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("22Y");
			if (t == null) {
				log.fine("field 22Y not found");
				return null;
			} else {
				return new Field22Y(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 85A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 85A at MT306 is expected to be the only one.
	 * 
	 * @return a Field85A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field85A getField85A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("85A");
			if (t == null) {
				log.fine("field 85A not found");
				return null;
			} else {
				return new Field85A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 85D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 85D at MT306 is expected to be the only one.
	 * 
	 * @return a Field85D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field85D getField85D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("85D");
			if (t == null) {
				log.fine("field 85D not found");
				return null;
			} else {
				return new Field85D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 85J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 85J at MT306 is expected to be the only one.
	 * 
	 * @return a Field85J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field85J getField85J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("85J");
			if (t == null) {
				log.fine("field 85J not found");
				return null;
			} else {
				return new Field85J(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 88J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 88J at MT306 is expected to be the only one.
	 * 
	 * @return a Field88J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field88J getField88J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("88J");
			if (t == null) {
				log.fine("field 88J not found");
				return null;
			} else {
				return new Field88J(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30Y, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30Y at MT306 is expected to be the only one.
	 * 
	 * @return a Field30Y object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30Y getField30Y() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("30Y");
			if (t == null) {
				log.fine("field 30Y not found");
				return null;
			} else {
				return new Field30Y(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29L at MT306 is expected to be the only one.
	 * 
	 * @return a Field29L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29L getField29L() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("29L");
			if (t == null) {
				log.fine("field 29L not found");
				return null;
			} else {
				return new Field29L(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29M, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29M at MT306 is expected to be the only one.
	 * 
	 * @return a Field29M object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29M getField29M() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("29M");
			if (t == null) {
				log.fine("field 29M not found");
				return null;
			} else {
				return new Field29M(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 17I, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 17I at MT306 is expected to be the only one.
	 * 
	 * @return a Field17I object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field17I getField17I() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("17I");
			if (t == null) {
				log.fine("field 17I not found");
				return null;
			} else {
				return new Field17I(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29N, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29N at MT306 is expected to be the only one.
	 * 
	 * @return a Field29N object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29N getField29N() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("29N");
			if (t == null) {
				log.fine("field 29N not found");
				return null;
			} else {
				return new Field29N(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30Z, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 30Z at MT306 is expected to be the only one.
	 * 
	 * @return a Field30Z object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30Z getField30Z() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("30Z");
			if (t == null) {
				log.fine("field 30Z not found");
				return null;
			} else {
				return new Field30Z(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15J at MT306 is expected to be the only one.
	 * 
	 * @return a Field15J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15J getField15J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15J");
			if (t == null) {
				log.fine("field 15J not found");
				return null;
			} else {
				return new Field15J(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 14B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 14B at MT306 is expected to be the only one.
	 * 
	 * @return a Field14B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field14B getField14B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("14B");
			if (t == null) {
				log.fine("field 14B not found");
				return null;
			} else {
				return new Field14B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 16C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 16C at MT306 is expected to be the only one.
	 * 
	 * @return a Field16C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field16C getField16C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("16C");
			if (t == null) {
				log.fine("field 16C not found");
				return null;
			} else {
				return new Field16C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 18B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 18B at MT306 is expected to be the only one.
	 * 
	 * @return a Field18B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field18B getField18B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("18B");
			if (t == null) {
				log.fine("field 18B not found");
				return null;
			} else {
				return new Field18B(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 18C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 18C at MT306 is expected to be the only one.
	 * 
	 * @return a Field18C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field18C getField18C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("18C");
			if (t == null) {
				log.fine("field 18C not found");
				return null;
			} else {
				return new Field18C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 19C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 19C at MT306 is expected to be the only one.
	 * 
	 * @return a Field19C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field19C getField19C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("19C");
			if (t == null) {
				log.fine("field 19C not found");
				return null;
			} else {
				return new Field19C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23C at MT306 is expected to be the only one.
	 * 
	 * @return a Field23C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23C getField23C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("23C");
			if (t == null) {
				log.fine("field 23C not found");
				return null;
			} else {
				return new Field23C(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15K, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15K at MT306 is expected to be the only one.
	 * 
	 * @return a Field15K object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15K getField15K() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15K");
			if (t == null) {
				log.fine("field 15K not found");
				return null;
			} else {
				return new Field15K(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29A at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 24D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 24D at MT306 is expected to be the only one.
	 * 
	 * @return a Field24D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field24D getField24D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("24D");
			if (t == null) {
				log.fine("field 24D not found");
				return null;
			} else {
				return new Field24D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 71F at MT306 is expected to be the only one.
	 * 
	 * @return a Field71F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71F getField71F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("71F");
			if (t == null) {
				log.fine("field 71F not found");
				return null;
			} else {
				return new Field71F(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21G, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 21G at MT306 is expected to be the only one.
	 * 
	 * @return a Field21G object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21G getField21G() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("21G");
			if (t == null) {
				log.fine("field 21G not found");
				return null;
			} else {
				return new Field21G(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 72 at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 15L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15L at MT306 is expected to be the only one.
	 * 
	 * @return a Field15L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15L getField15L() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15L");
			if (t == null) {
				log.fine("field 15L not found");
				return null;
			} else {
				return new Field15L(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 18A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 18A at MT306 is expected to be the only one.
	 * 
	 * @return a Field18A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field18A getField18A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("18A");
			if (t == null) {
				log.fine("field 18A not found");
				return null;
			} else {
				return new Field18A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 15M, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 15M at MT306 is expected to be the only one.
	 * 
	 * @return a Field15M object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field15M getField15M() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("15M");
			if (t == null) {
				log.fine("field 15M not found");
				return null;
			} else {
				return new Field15M(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 96A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 96A at MT306 is expected to be the only one.
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
	 * The first occurrence of field 96D at MT306 is expected to be the only one.
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
	 * The first occurrence of field 96J at MT306 is expected to be the only one.
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
	 * The first occurrence of field 22T at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17E at MT306 is expected to be the only one.
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
	 * The first occurrence of field 22U at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17H at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17P at MT306 is expected to be the only one.
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
	 * The first occurrence of field 22V at MT306 is expected to be the only one.
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
	 * The first occurrence of field 98D at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17W at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17Y at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17Z at MT306 is expected to be the only one.
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
	 * The first occurrence of field 22Q at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17L at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17M at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17Q at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17S at MT306 is expected to be the only one.
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
	 * The first occurrence of field 17X at MT306 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 77A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 77A at MT306 is expected to be the only one.
	 * 
	 * @return a Field77A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77A getField77A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("77A");
			if (t == null) {
				log.fine("field 77A not found");
				return null;
			} else {
				return new Field77A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 14S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 14S at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field14S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field14S> getField14S() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("14S");
			final List<Field14S> result = new ArrayList<Field14S>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field14S(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30Q, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 30Q at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30Q objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30Q> getField30Q() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("30Q");
			final List<Field30Q> result = new ArrayList<Field30Q>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field30Q(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 53A at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53A> getField53A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("53A");
			final List<Field53A> result = new ArrayList<Field53A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field53A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 53D at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53D> getField53D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("53D");
			final List<Field53D> result = new ArrayList<Field53D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field53D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 53J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53J> getField53J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("53J");
			final List<Field53J> result = new ArrayList<Field53J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field53J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 86A at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 86D at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 86J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 86J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field86J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field86J> getField86J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("86J");
			final List<Field86J> result = new ArrayList<Field86J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field86J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 56A at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56A> getField56A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("56A");
			final List<Field56A> result = new ArrayList<Field56A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field56A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 56D at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56D> getField56D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("56D");
			final List<Field56D> result = new ArrayList<Field56D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field56D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 56J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56J> getField56J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("56J");
			final List<Field56J> result = new ArrayList<Field56J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field56J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57A at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57A> getField57A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("57A");
			final List<Field57A> result = new ArrayList<Field57A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field57A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57D at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57D> getField57D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("57D");
			final List<Field57D> result = new ArrayList<Field57D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field57D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 57J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 57J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field57J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field57J> getField57J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("57J");
			final List<Field57J> result = new ArrayList<Field57J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field57J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 58A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 58A at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field58A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field58A> getField58A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("58A");
			final List<Field58A> result = new ArrayList<Field58A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field58A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 58D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 58D at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field58D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field58D> getField58D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("58D");
			final List<Field58D> result = new ArrayList<Field58D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field58D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 58J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 58J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field58J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field58J> getField58J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("58J");
			final List<Field58J> result = new ArrayList<Field58J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field58J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30G, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 30G at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30G> getField30G() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("30G");
			final List<Field30G> result = new ArrayList<Field30G>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field30G(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 29J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 29J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field29J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field29J> getField29J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("29J");
			final List<Field29J> result = new ArrayList<Field29J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field29J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 29K, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 29K at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field29K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field29K> getField29K() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("29K");
			final List<Field29K> result = new ArrayList<Field29K>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field29K(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 15G, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 15G at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field15G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field15G> getField15G() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("15G");
			final List<Field15G> result = new ArrayList<Field15G>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field15G(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22J> getField22J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22J");
			final List<Field22J> result = new ArrayList<Field22J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37U, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37U at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37U objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37U> getField37U() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("37U");
			final List<Field37U> result = new ArrayList<Field37U>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field37U(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 37P at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37P> getField37P() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("37P");
			final List<Field37P> result = new ArrayList<Field37P>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field37P(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32Q, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32Q at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32Q objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32Q> getField32Q() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("32Q");
			final List<Field32Q> result = new ArrayList<Field32Q>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field32Q(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30T, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 30T at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30T objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30T> getField30T() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("30T");
			final List<Field30T> result = new ArrayList<Field30T>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field30T(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 84A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 84A at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field84A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field84A> getField84A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("84A");
			final List<Field84A> result = new ArrayList<Field84A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field84A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 84B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 84B at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field84B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field84B> getField84B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("84B");
			final List<Field84B> result = new ArrayList<Field84B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field84B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 84D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 84D at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field84D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field84D> getField84D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("84D");
			final List<Field84D> result = new ArrayList<Field84D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field84D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 84J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 84J at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field84J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field84J> getField84J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("84J");
			final List<Field84J> result = new ArrayList<Field84J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field84J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 29E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 29E at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field29E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field29E> getField29E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("29E");
			final List<Field29E> result = new ArrayList<Field29E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field29E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30M, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 30M at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30M objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30M> getField30M() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("30M");
			final List<Field30M> result = new ArrayList<Field30M>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field30M(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19Y, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 19Y at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field19Y objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field19Y> getField19Y() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("19Y");
			final List<Field19Y> result = new ArrayList<Field19Y>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field19Y(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30N, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 30N at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30N objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30N> getField30N() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("30N");
			final List<Field30N> result = new ArrayList<Field30N>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field30N(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19Z, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 19Z at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field19Z objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field19Z> getField19Z() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("19Z");
			final List<Field19Z> result = new ArrayList<Field19Z>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field19Z(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 88A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 88A at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 88D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 88D at MT306 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 30F at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30F> getField30F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("30F");
			final List<Field30F> result = new ArrayList<Field30F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field30F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 32H at MT306 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32H> getField32H() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("32H");
			final List<Field32H> result = new ArrayList<Field32H>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field32H(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22L at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 91A at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 91D at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 91J at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22M at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22N at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22P at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22R at MT306 are expected at one sequence or across several sequences.
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
	 * Multiple occurrences of field 22S at MT306 are expected at one sequence or across several sequences.
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
	* Class for Sequence "A" of MT 306
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
	* Class for Sequence "B" of MT 306
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


// BaseSequenceCodeGenerator [seq=C]
	/**
	* Class for Sequence "C" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
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
		public static final Tag START_TAG = Field15C.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceC newInstance(final Tag ... tags) {
			final SequenceC result = new SequenceC();

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
		public static SequenceC newInstance() {
			final SequenceC result = new SequenceC();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceC newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceC result = new SequenceC();

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
	* Get the single occurrence of SequenceC using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceC getSequenceC() {
		return getSequenceC(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceC using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceC getSequenceC(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("C")) {
			return new SequenceC(map.get("C"));
		}
		return new SequenceC();
	}


// BaseSequenceCodeGenerator [seq=D]
	/**
	* Class for Sequence "D" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
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
		public static final Tag START_TAG = Field15D.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceD newInstance(final Tag ... tags) {
			final SequenceD result = new SequenceD();

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
		public static SequenceD newInstance() {
			final SequenceD result = new SequenceD();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceD newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD result = new SequenceD();

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
	* Get the single occurrence of SequenceD using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceD getSequenceD() {
		return getSequenceD(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceD using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceD getSequenceD(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("D")) {
			return new SequenceD(map.get("D"));
		}
		return new SequenceD();
	}


// BaseSequenceCodeGenerator [seq=E]
	/**
	* Class for Sequence "E" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
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
		public static final Tag START_TAG = Field15E.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceE newInstance(final Tag ... tags) {
			final SequenceE result = new SequenceE();

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
		public static SequenceE newInstance() {
			final SequenceE result = new SequenceE();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceE newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE result = new SequenceE();

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
	* Get the single occurrence of SequenceE using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceE getSequenceE() {
		return getSequenceE(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceE using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceE within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceE getSequenceE(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("E")) {
			return new SequenceE(map.get("E"));
		}
		return new SequenceE();
	}


// BaseSequenceCodeGenerator [seq=F]
	/**
	* Class for Sequence "F" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
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
		public static final Tag START_TAG = Field15F.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceF newInstance(final Tag ... tags) {
			final SequenceF result = new SequenceF();

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
		public static SequenceF newInstance() {
			final SequenceF result = new SequenceF();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceF newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceF result = new SequenceF();

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
	* Get the single occurrence of SequenceF using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceF getSequenceF() {
		return getSequenceF(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceF using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceF within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceF getSequenceF(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("F")) {
			return new SequenceF(map.get("F"));
		}
		return new SequenceF();
	}


// BaseSequenceCodeGenerator [seq=F1]
	/**
	* Class for Sequence "F1" of MT 306
	*/
	public static class SequenceF1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceF1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceF1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* First mandatory tagname of the sequence: <em>"30G"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "30G"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"29K"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] END = { "29K"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		public static final String[] TAIL = new String[]{ "14S"   };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceF1 newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceF1 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceF1 result = new SequenceF1();

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
	* Get the list of SequenceF1 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceF1> getSequenceF1List() {
		return getSequenceF1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceF1 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceF1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceF1> getSequenceF1List(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceF1> result = new ArrayList<SequenceF1>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceF1.START, SequenceF1.END, SequenceF1.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceF1(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 

// BaseSequenceCodeGenerator [seq=G]
	/**
	* Class for Sequence "G" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceG extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceG() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceG(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15G.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceG newInstance(final Tag ... tags) {
			final SequenceG result = new SequenceG();

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
		public static SequenceG newInstance() {
			final SequenceG result = new SequenceG();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceG newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceG result = new SequenceG();

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
	* Get the list of SequenceG using field field 15 as sequence boundary. 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @since 7.7
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public List<SequenceG> getSequenceGList() {
		return getSequenceGList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceG using field field 15 as sequence boundary. 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceG within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static List<SequenceG> getSequenceGList(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> ret = SwiftMessageUtils.splitByField15(parentSequence, "G");
		if (ret != null) {
			final List<SequenceG> result = new ArrayList<SequenceG>(ret.size());
			for (final SwiftTagListBlock b : ret) {
				result.add(new SequenceG(b));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}


// BaseSequenceCodeGenerator [seq=H]
	/**
	* Class for Sequence "H" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceH extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceH() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceH(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15H.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceH newInstance(final Tag ... tags) {
			final SequenceH result = new SequenceH();

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
		public static SequenceH newInstance() {
			final SequenceH result = new SequenceH();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceH newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceH result = new SequenceH();

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
	* Get the single occurrence of SequenceH using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceH getSequenceH() {
		return getSequenceH(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceH using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceH within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceH getSequenceH(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("H")) {
			return new SequenceH(map.get("H"));
		}
		return new SequenceH();
	}


// BaseSequenceCodeGenerator [seq=I]
	/**
	* Class for Sequence "I" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceI extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceI() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceI(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15I.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceI newInstance(final Tag ... tags) {
			final SequenceI result = new SequenceI();

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
		public static SequenceI newInstance() {
			final SequenceI result = new SequenceI();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceI newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceI result = new SequenceI();

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
	* Get the single occurrence of SequenceI using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceI getSequenceI() {
		return getSequenceI(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceI using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceI within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceI getSequenceI(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("I")) {
			return new SequenceI(map.get("I"));
		}
		return new SequenceI();
	}


// BaseSequenceCodeGenerator [seq=J]
	/**
	* Class for Sequence "J" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceJ extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceJ() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceJ(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15J.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceJ newInstance(final Tag ... tags) {
			final SequenceJ result = new SequenceJ();

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
		public static SequenceJ newInstance() {
			final SequenceJ result = new SequenceJ();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceJ newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceJ result = new SequenceJ();

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
	* Get the single occurrence of SequenceJ using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceJ getSequenceJ() {
		return getSequenceJ(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceJ using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceJ within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceJ getSequenceJ(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("J")) {
			return new SequenceJ(map.get("J"));
		}
		return new SequenceJ();
	}


// BaseSequenceCodeGenerator [seq=J1a]
	/**
	* Class for Sequence "J1a" of MT 306
	*/
	public static class SequenceJ1a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceJ1a() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceJ1a(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* First mandatory tagname of the sequence: <em>"30M"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "30M"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"19Y"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] END = { "19Y"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		public static final String[] TAIL = new String[]{  };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceJ1a newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceJ1a newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceJ1a result = new SequenceJ1a();

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
	* Get the list of SequenceJ1a delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceJ1a> getSequenceJ1aList() {
		return getSequenceJ1aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceJ1a delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceJ1a within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceJ1a> getSequenceJ1aList(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceJ1a> result = new ArrayList<SequenceJ1a>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceJ1a.START, SequenceJ1a.END, SequenceJ1a.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceJ1a(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 

// BaseSequenceCodeGenerator [seq=J2a]
	/**
	* Class for Sequence "J2a" of MT 306
	*/
	public static class SequenceJ2a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceJ2a() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceJ2a(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* First mandatory tagname of the sequence: <em>"30N"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "30N"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"19Z"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] END = { "19Z"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		public static final String[] TAIL = new String[]{  };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceJ2a newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceJ2a newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceJ2a result = new SequenceJ2a();

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
	* Get the list of SequenceJ2a delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceJ2a> getSequenceJ2aList() {
		return getSequenceJ2aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceJ2a delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceJ2a within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceJ2a> getSequenceJ2aList(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceJ2a> result = new ArrayList<SequenceJ2a>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceJ2a.START, SequenceJ2a.END, SequenceJ2a.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceJ2a(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 

// BaseSequenceCodeGenerator [seq=K]
	/**
	* Class for Sequence "K" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceK extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceK() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceK(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15K.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceK newInstance(final Tag ... tags) {
			final SequenceK result = new SequenceK();

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
		public static SequenceK newInstance() {
			final SequenceK result = new SequenceK();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceK newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceK result = new SequenceK();

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
	* Get the single occurrence of SequenceK using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceK getSequenceK() {
		return getSequenceK(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceK using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceK within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceK getSequenceK(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("K")) {
			return new SequenceK(map.get("K"));
		}
		return new SequenceK();
	}


// BaseSequenceCodeGenerator [seq=L]
	/**
	* Class for Sequence "L" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceL extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceL() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceL(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15L.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceL newInstance(final Tag ... tags) {
			final SequenceL result = new SequenceL();

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
		public static SequenceL newInstance() {
			final SequenceL result = new SequenceL();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceL newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceL result = new SequenceL();

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
	* Get the single occurrence of SequenceL using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceL getSequenceL() {
		return getSequenceL(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceL using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceL within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceL getSequenceL(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("L")) {
			return new SequenceL(map.get("L"));
		}
		return new SequenceL();
	}


// BaseSequenceCodeGenerator [seq=L1]
	/**
	* Class for Sequence "L1" of MT 306
	*/
	public static class SequenceL1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceL1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceL1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* First mandatory tagname of the sequence: <em>"30F"  </em>.
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] START = { "30F"   } ;
		/**
		* Last mandatory tagname of the sequence: <em>"32H"  </em>
		* Array format is for cases when more than one letter options is allowed
		*/
		public static final String[] END = { "32H"   };
		/**
		* List of optional tags after the last mandatory tag
		*/
		public static final String[] TAIL = new String[]{  };

		/**
		* same as newInstance(0, 0, tags);
		* see #newInstance(Tag ... )
		*/
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceL1 newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceL1 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceL1 result = new SequenceL1();

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
	* Get the list of SequenceL1 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceL1> getSequenceL1List() {
		return getSequenceL1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceL1 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceL1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceL1> getSequenceL1List(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceL1> result = new ArrayList<SequenceL1>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceL1.START, SequenceL1.END, SequenceL1.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceL1(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 

// BaseSequenceCodeGenerator [seq=M]
	/**
	* Class for Sequence "M" of MT 306
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public static class SequenceM extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceM() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceM(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		public static final Tag START_TAG = Field15M.emptyTag();
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		* @since 7.7
		*/
		@SequenceStyle(Type.SPLIT_BY_15)
		public static SequenceM newInstance(final Tag ... tags) {
			final SequenceM result = new SequenceM();

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
		public static SequenceM newInstance() {
			final SequenceM result = new SequenceM();

			result.append(START_TAG);

			return result;
		}
		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.7
		*/
		public static SequenceM newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceM result = new SequenceM();

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
	* Get the single occurrence of SequenceM using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceM getSequenceM() {
		return getSequenceM(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the single occurrence of SequenceM using field field 15 as sequence boundary.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceM within the complete message
	* @since 7.7
	* @return a new sequence that may be empty, <em>never returns null</em>
	*/
	@SequenceStyle(Type.SPLIT_BY_15)
	public SequenceM getSequenceM(SwiftTagListBlock parentSequence) {
		final java.util.Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(parentSequence);
		if (map.containsKey("M")) {
			return new SequenceM(map.get("M"));
		}
		return new SequenceM();
	}


// BaseSequenceCodeGenerator [seq=M1]
	/**
	* Class for Sequence "M1" of MT 306
	*/
	public static class SequenceM1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceM1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceM1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* tagname of the first tag in the sequence which must be mandatory.
		* may be null if we cannot determine this safely
		*/
		public static final String START_NAME =  "22L"  ;
	}


// BaseSequenceCodeGenerator [seq=M1a]
	/**
	* Class for Sequence "M1a" of MT 306
	*/
	public static class SequenceM1a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceM1a() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceM1a(final SwiftTagListBlock content) {
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
		public static SequenceM1a newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceM1a newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceM1a result = new SequenceM1a();

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
	* Get the list of SequenceM1a delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceM1a> getSequenceM1aList() {
		return getSequenceM1aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceM1a delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceM1a within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceM1a> getSequenceM1aList(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceM1a> result = new ArrayList<SequenceM1a>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceM1a.START, SequenceM1a.END, SequenceM1a.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceM1a(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 

// BaseSequenceCodeGenerator [seq=M1a1]
	/**
	* Class for Sequence "M1a1" of MT 306
	*/
	public static class SequenceM1a1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceM1a1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceM1a1(final SwiftTagListBlock content) {
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
		public static SequenceM1a1 newInstance(final Tag ... tags) {
			return newInstance(0, 0, tags);
		}
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceM1a1 newInstance(final int start, final int end, final Tag ... tags) {
			final SequenceM1a1 result = new SequenceM1a1();

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
	* Get the list of SequenceM1a1 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceM1a1> getSequenceM1a1List() {
		return getSequenceM1a1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	* Get the list of SequenceM1a1 delimited by leading tag and end, with an optional tail.
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard. 
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceM1a1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceM1a1> getSequenceM1a1List(final SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final List<SequenceM1a1> result = new ArrayList<SequenceM1a1>();
			final List<SwiftTagListBlock> bs = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceM1a1.START, SequenceM1a1.END, SequenceM1a1.TAIL); 
			if (bs != null && !bs.isEmpty()) {
				for (final SwiftTagListBlock s : bs) {
					result.add(new SequenceM1a1(s));
				}
			}
			return result;
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();
	} 
 




}

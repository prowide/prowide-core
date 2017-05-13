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

import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * <h1>MT 798_761 - Application for issuance of Guarantee Index</h1>
 * <h3>SWIFT MT798_761 (ISO 15022) message structure:</h3>
 *
 <div class="scheme"><ul>
<li class="field">Field 20  (M)</li>
<li class="field">Field 12  (M)</li>
<li class="field">Field 77 E (M)</li>
<li class="field">Field 27 A (M)</li>
<li class="field">Field 21 A (M)</li>
<li class="field">Field 13 E (M)</li>
<li class="field">Field 22 D (M)</li>
<li class="field">Field 22 K (M)</li>
<li class="field">Field 22 E (M)</li>
<li class="field">Field 22 J (M)</li>
<li class="field">Field 22 B (O)</li>
<li class="field">Field 22 L (O)</li>
<li class="field">Field 50  (M)</li>
<li class="field">Field 50 M (O)</li>
<li class="field">Field 12 E (O)</li>
<li class="field">Field 39 P (M)</li>
<li class="field">Field 39 C (O)</li>
<li class="field">Field 23 B (M)</li>
<li class="field">Field 31 L (O)</li>
<li class="field">Field 31 S (O)</li>
<li class="field">Field 35 L (O)</li>
<li class="field">Field 23 E (O)</li>
<li class="field">Field 24 E (O)</li>
<li class="field">Field 22 G (O)</li>
<li class="field">Field 50 B (O)</li>
<li class="field">Field 53 C (O)</li>
<li class="field">Field 25 A (O)</li>
<li class="field">Field 59  (M)</li>
<li class="field">Field 52 A,D (O)</li>
<li class="field">Field 58 A,D (O)</li>
<li class="field">Field 49  (O)</li>
<li class="field">Field 26 D (M)</li>
<li class="field">Field 20 E (O)</li>
<li class="field">Field 31 R (O)</li>
<li class="field">Field 71 F (O)</li>
<li class="field">Field 37 J (O)</li>
<li class="field">Field 29 A (O)</li>
<li class="field">Field 29 D (O)</li>
<li class="field">Field 72 C (O)</li>
<li class="field">Field 23 X (O)</li>
<li class="field">Field 29 S (O)</li>
</ul></div>

 <style>
.scheme, .scheme ul, .scheme li {
     position: relative;
}
.scheme ul {
    list-style: none;
    padding-left: 32px;
}
.scheme li::before, .scheme li::after {
    content: "";
    position: absolute;
    left: -12px;
}
.scheme li::before {
    border-top: 1px solid #000;
    top: 9px;
    width: 8px;
    height: 0;
}
.scheme li::after {
    border-left: 1px solid #000;
    height: 100%;
    width: 0px;
    top: 2px;
}
.scheme ul > li:last-child::after {
    height: 8px;
}</style>

 *
 * <p>This source code is specific to release <strong>SRU 2016</strong></p> 
 * <p>For additional resources check <a href="http://www.prowidesoftware.com/resources">http://www.prowidesoftware.com/resources</a></p>
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT798_761 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT798_761.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "798_761";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value ACTP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ACTP
	* @see com.prowidesoftware.swift.SchemeConstantsA#ACTP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String ACTP = "ACTP";

	/**
	* Constant for qualifier with value ADVP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ADVP
	* @see com.prowidesoftware.swift.SchemeConstantsA#ADVP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String ADVP = "ADVP";

	/**
	* Constant for qualifier with value ALTA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ALTA
	* @see com.prowidesoftware.swift.SchemeConstantsA#ALTA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String ALTA = "ALTA";

	/**
	* Constant for qualifier with value APPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.APPL
	* @see com.prowidesoftware.swift.SchemeConstantsA#APPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String APPL = "APPL";

	/**
	* Constant for qualifier with value BENE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BENE
	* @see com.prowidesoftware.swift.SchemeConstantsB#BENE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String BENE = "BENE";

	/**
	* Constant for qualifier with value BILL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BILL
	* @see com.prowidesoftware.swift.SchemeConstantsB#BILL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String BILL = "BILL";

	/**
	* Constant for qualifier with value CONFIRM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CONFIRM
	* @see com.prowidesoftware.swift.SchemeConstantsC#CONFIRM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CONFIRM = "CONFIRM";

	/**
	* Constant for qualifier with value CONT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CONT
	* @see com.prowidesoftware.swift.SchemeConstantsC#CONT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CONT = "CONT";

	/**
	* Constant for qualifier with value COUR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COUR
	* @see com.prowidesoftware.swift.SchemeConstantsC#COUR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String COUR = "COUR";

	/**
	* Constant for qualifier with value CRED 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CRED
	* @see com.prowidesoftware.swift.SchemeConstantsC#CRED
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CRED = "CRED";

	/**
	* Constant for qualifier with value CUST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CUST
	* @see com.prowidesoftware.swift.SchemeConstantsC#CUST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String CUST = "CUST";

	/**
	* Constant for qualifier with value DELV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DELV
	* @see com.prowidesoftware.swift.SchemeConstantsD#DELV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String DELV = "DELV";

	/**
	* Constant for qualifier with value DIRC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DIRC
	* @see com.prowidesoftware.swift.SchemeConstantsD#DIRC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String DIRC = "DIRC";

	/**
	* Constant for qualifier with value EFCT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EFCT
	* @see com.prowidesoftware.swift.SchemeConstantsE#EFCT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String EFCT = "EFCT";

	/**
	* Constant for qualifier with value EFRE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EFRE
	* @see com.prowidesoftware.swift.SchemeConstantsE#EFRE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String EFRE = "EFRE";

	/**
	* Constant for qualifier with value EMAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EMAL
	* @see com.prowidesoftware.swift.SchemeConstantsE#EMAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String EMAL = "EMAL";

	/**
	* Constant for qualifier with value FACT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FACT
	* @see com.prowidesoftware.swift.SchemeConstantsF#FACT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FACT = "FACT";

	/**
	* Constant for qualifier with value FAXT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FAXT
	* @see com.prowidesoftware.swift.SchemeConstantsF#FAXT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String FAXT = "FAXT";

	/**
	* Constant for qualifier with value GUAR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GUAR
	* @see com.prowidesoftware.swift.SchemeConstantsG#GUAR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String GUAR = "GUAR";

	/**
	* Constant for qualifier with value ICST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ICST
	* @see com.prowidesoftware.swift.SchemeConstantsI#ICST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String ICST = "ICST";

	/**
	* Constant for qualifier with value IIAC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.IIAC
	* @see com.prowidesoftware.swift.SchemeConstantsI#IIAC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String IIAC = "IIAC";

	/**
	* Constant for qualifier with value IINT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.IINT
	* @see com.prowidesoftware.swift.SchemeConstantsI#IINT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String IINT = "IINT";

	/**
	* Constant for qualifier with value INDC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INDC
	* @see com.prowidesoftware.swift.SchemeConstantsI#INDC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String INDC = "INDC";

	/**
	* Constant for qualifier with value LEAS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LEAS
	* @see com.prowidesoftware.swift.SchemeConstantsL#LEAS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String LEAS = "LEAS";

	/**
	* Constant for qualifier with value LIMT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LIMT
	* @see com.prowidesoftware.swift.SchemeConstantsL#LIMT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String LIMT = "LIMT";

	/**
	* Constant for qualifier with value MAIL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MAIL
	* @see com.prowidesoftware.swift.SchemeConstantsM#MAIL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String MAIL = "MAIL";

	/**
	* Constant for qualifier with value MESS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MESS
	* @see com.prowidesoftware.swift.SchemeConstantsM#MESS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String MESS = "MESS";

	/**
	* Constant for qualifier with value OFFR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OFFR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OFFR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String OFFR = "OFFR";

	/**
	* Constant for qualifier with value ORDR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.ORDR
	* @see com.prowidesoftware.swift.SchemeConstantsO#ORDR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String ORDR = "ORDR";

	/**
	* Constant for qualifier with value OTHR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OTHR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OTHR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String OTHR = "OTHR";

	/**
	* Constant for qualifier with value OWNB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OWNB
	* @see com.prowidesoftware.swift.SchemeConstantsO#OWNB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String OWNB = "OWNB";

	/**
	* Constant for qualifier with value PAYM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PAYM
	* @see com.prowidesoftware.swift.SchemeConstantsP#PAYM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PAYM = "PAYM";

	/**
	* Constant for qualifier with value PGCO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PGCO
	* @see com.prowidesoftware.swift.SchemeConstantsP#PGCO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PGCO = "PGCO";

	/**
	* Constant for qualifier with value PGDO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PGDO
	* @see com.prowidesoftware.swift.SchemeConstantsP#PGDO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PGDO = "PGDO";

	/**
	* Constant for qualifier with value PGWO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PGWO
	* @see com.prowidesoftware.swift.SchemeConstantsP#PGWO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PGWO = "PGWO";

	/**
	* Constant for qualifier with value PINV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PINV
	* @see com.prowidesoftware.swift.SchemeConstantsP#PINV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PINV = "PINV";

	/**
	* Constant for qualifier with value PRIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRIN
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PRIN = "PRIN";

	/**
	* Constant for qualifier with value PROJ 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PROJ
	* @see com.prowidesoftware.swift.SchemeConstantsP#PROJ
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String PROJ = "PROJ";

	/**
	* Constant for qualifier with value REDC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REDC
	* @see com.prowidesoftware.swift.SchemeConstantsR#REDC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String REDC = "REDC";

	/**
	* Constant for qualifier with value REGM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REGM
	* @see com.prowidesoftware.swift.SchemeConstantsR#REGM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String REGM = "REGM";

	/**
	* Constant for qualifier with value SPDM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SPDM
	* @see com.prowidesoftware.swift.SchemeConstantsS#SPDM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String SPDM = "SPDM";

	/**
	* Constant for qualifier with value SPEC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SPEC
	* @see com.prowidesoftware.swift.SchemeConstantsS#SPEC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String SPEC = "SPEC";

	/**
	* Constant for qualifier with value STLC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STLC
	* @see com.prowidesoftware.swift.SchemeConstantsS#STLC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String STLC = "STLC";

	/**
	* Constant for qualifier with value STND 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STND
	* @see com.prowidesoftware.swift.SchemeConstantsS#STND
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String STND = "STND";

	/**
	* Constant for qualifier with value SURT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SURT
	* @see com.prowidesoftware.swift.SchemeConstantsS#SURT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String SURT = "SURT";

	/**
	* Constant for qualifier with value TELE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TELE
	* @see com.prowidesoftware.swift.SchemeConstantsT#TELE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String TELE = "TELE";

	/**
	* Constant for qualifier with value TEND 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TEND
	* @see com.prowidesoftware.swift.SchemeConstantsT#TEND
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String TEND = "TEND";

	/**
	* Constant for qualifier with value UNLM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UNLM
	* @see com.prowidesoftware.swift.SchemeConstantsU#UNLM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String UNLM = "UNLM";

	/**
	* Constant for qualifier with value WDAP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WDAP
	* @see com.prowidesoftware.swift.SchemeConstantsW#WDAP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String WDAP = "WDAP";

	/**
	* Constant for qualifier with value WDBF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WDBF
	* @see com.prowidesoftware.swift.SchemeConstantsW#WDBF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String WDBF = "WDBF";

	/**
	* Constant for qualifier with value WITHOUT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WITHOUT
	* @see com.prowidesoftware.swift.SchemeConstantsW#WITHOUT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String WITHOUT = "WITHOUT";

	/**
	* Constant for qualifier with value XCST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsX.XCST
	* @see com.prowidesoftware.swift.SchemeConstantsX#XCST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String XCST = "XCST";

	/**
	* Constant for qualifier with value XIAC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsX.XIAC
	* @see com.prowidesoftware.swift.SchemeConstantsX#XIAC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String XIAC = "XIAC";

	/**
	* Constant for qualifier with value XINT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsX.XINT
	* @see com.prowidesoftware.swift.SchemeConstantsX#XINT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public static final String XINT = "XINT";

// end qualifiers constants	

	/**
	 * Creates an MT798_761 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT798_761 content
	 */
	public MT798_761(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT798_761 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT798_761 content, the parameter can not be <code>null</code>
	 * @see #MT798_761(String)
	 */
	public MT798_761(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		sanityCheck(super.m);
	}
	
	/**
	 * Creates an MT798_761 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT798_761 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT798_761(String)
	 * @since 7.7
	 */
	public static MT798_761 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT798_761(m.message());
	}
	
	/**
	 * Creates and initializes a new MT798_761 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT798_761() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT798_761 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT798_761(final String sender, final String receiver) {
		super(798, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* 
	* @see #MT798_761(String, String)
	* @deprecated Use instead <code>new MT798_761(sender, receiver)</code> instead
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear._2018)
	public MT798_761(final int messageType, final String sender, final String receiver) {
		super(798, sender, receiver);
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(getClass(), "MT798_761(int, String, String)", "Use the constructor MT798_761(sender, receiver) instead.");
	}
	
	/**
	 * Creates a new MT798_761 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT798_761(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
				sanityCheck(parsed);
			}
		}
    }
    
    private void sanityCheck(final SwiftMessage param) {
    	if (param.isServiceMessage()) {
			log.warning("Creating an MT798_761 object from FIN content with a Service Message. Check if the MT798_761 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT798_761 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT798_761 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT798_761 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT798_761 or null if fin is null 
	 * @since 7.7
	 */
	public static MT798_761 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT798_761(fin);
    }
    
    /**
	 * Creates a new MT798_761 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT798_761(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT798_761 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT798_761 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT798_761 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT798_761(stream);
    }
    
    /**
	 * Creates a new MT798_761 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT798_761(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT798_761 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT798_761 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT798_761 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT798_761(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "798";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT798_761 append(final SwiftTagListBlock block) {
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
	public MT798_761 append(final Tag ... tags) {
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
	public MT798_761 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20 at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field20 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field20 getField20() {
		final Tag t = tag("20");
		if (t != null) {
			return new Field20(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 12 at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field12 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12 getField12() {
		final Tag t = tag("12");
		if (t != null) {
			return new Field12(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 77E at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field77E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77E getField77E() {
		final Tag t = tag("77E");
		if (t != null) {
			return new Field77E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 27A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 27A at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field27A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field27A getField27A() {
		final Tag t = tag("27A");
		if (t != null) {
			return new Field27A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 21A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 21A at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field21A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field21A getField21A() {
		final Tag t = tag("21A");
		if (t != null) {
			return new Field21A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 13E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 13E at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field13E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field13E getField13E() {
		final Tag t = tag("13E");
		if (t != null) {
			return new Field13E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22D at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field22D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22D getField22D() {
		final Tag t = tag("22D");
		if (t != null) {
			return new Field22D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22K, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22K at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field22K object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22K getField22K() {
		final Tag t = tag("22K");
		if (t != null) {
			return new Field22K(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22E at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field22E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22E getField22E() {
		final Tag t = tag("22E");
		if (t != null) {
			return new Field22E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22J at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field22J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22J getField22J() {
		final Tag t = tag("22J");
		if (t != null) {
			return new Field22J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22B at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field22B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22B getField22B() {
		final Tag t = tag("22B");
		if (t != null) {
			return new Field22B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22L at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field22L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22L getField22L() {
		final Tag t = tag("22L");
		if (t != null) {
			return new Field22L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 50 at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field50 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50 getField50() {
		final Tag t = tag("50");
		if (t != null) {
			return new Field50(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50M, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 50M at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field50M object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50M getField50M() {
		final Tag t = tag("50M");
		if (t != null) {
			return new Field50M(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 12E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 12E at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field12E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12E getField12E() {
		final Tag t = tag("12E");
		if (t != null) {
			return new Field12E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39P, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 39P at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field39P object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39P getField39P() {
		final Tag t = tag("39P");
		if (t != null) {
			return new Field39P(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 39C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 39C at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field39C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field39C getField39C() {
		final Tag t = tag("39C");
		if (t != null) {
			return new Field39C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23B at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field23B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23B getField23B() {
		final Tag t = tag("23B");
		if (t != null) {
			return new Field23B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31L at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field31L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31L getField31L() {
		final Tag t = tag("31L");
		if (t != null) {
			return new Field31L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31S, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31S at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field31S object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31S getField31S() {
		final Tag t = tag("31S");
		if (t != null) {
			return new Field31S(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 35L, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 35L at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field35L object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field35L getField35L() {
		final Tag t = tag("35L");
		if (t != null) {
			return new Field35L(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23E at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field23E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23E getField23E() {
		final Tag t = tag("23E");
		if (t != null) {
			return new Field23E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 24E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 24E at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field24E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field24E getField24E() {
		final Tag t = tag("24E");
		if (t != null) {
			return new Field24E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 22G, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 22G at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field22G object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field22G getField22G() {
		final Tag t = tag("22G");
		if (t != null) {
			return new Field22G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 50B, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 50B at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field50B object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field50B getField50B() {
		final Tag t = tag("50B");
		if (t != null) {
			return new Field50B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 53C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 53C at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field53C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field53C getField53C() {
		final Tag t = tag("53C");
		if (t != null) {
			return new Field53C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 25A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 25A at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field25A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field25A getField25A() {
		final Tag t = tag("25A");
		if (t != null) {
			return new Field25A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 59, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 59 at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field59 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field59 getField59() {
		final Tag t = tag("59");
		if (t != null) {
			return new Field59(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 52A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 52A at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field52A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field52A getField52A() {
		final Tag t = tag("52A");
		if (t != null) {
			return new Field52A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 52D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 52D at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field52D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field52D getField52D() {
		final Tag t = tag("52D");
		if (t != null) {
			return new Field52D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 58A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 58A at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field58A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field58A getField58A() {
		final Tag t = tag("58A");
		if (t != null) {
			return new Field58A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 58D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 58D at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field58D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field58D getField58D() {
		final Tag t = tag("58D");
		if (t != null) {
			return new Field58D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 49, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 49 at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field49 object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field49 getField49() {
		final Tag t = tag("49");
		if (t != null) {
			return new Field49(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 26D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 26D at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field26D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field26D getField26D() {
		final Tag t = tag("26D");
		if (t != null) {
			return new Field26D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 20E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 20E at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field20E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field20E getField20E() {
		final Tag t = tag("20E");
		if (t != null) {
			return new Field20E(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 31R, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 31R at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field31R object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field31R getField31R() {
		final Tag t = tag("31R");
		if (t != null) {
			return new Field31R(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 71F, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 71F at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field71F object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field71F getField71F() {
		final Tag t = tag("71F");
		if (t != null) {
			return new Field71F(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 37J, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 37J at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field37J object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field37J getField37J() {
		final Tag t = tag("37J");
		if (t != null) {
			return new Field37J(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29A at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field29A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29A getField29A() {
		final Tag t = tag("29A");
		if (t != null) {
			return new Field29A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29D at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field29D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29D getField29D() {
		final Tag t = tag("29D");
		if (t != null) {
			return new Field29D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72C, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 72C at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field72C object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field72C getField72C() {
		final Tag t = tag("72C");
		if (t != null) {
			return new Field72C(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23X, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23X at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field23X object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23X getField23X() {
		final Tag t = tag("23X");
		if (t != null) {
			return new Field23X(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 29S, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 29S at MT798_761 is expected to be the only one.
	 * 
	 * @return a Field29S object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field29S getField29S() {
		final Tag t = tag("29S");
		if (t != null) {
			return new Field29S(t.getValue());
		} else {
			return null;
		}
	}
	



}

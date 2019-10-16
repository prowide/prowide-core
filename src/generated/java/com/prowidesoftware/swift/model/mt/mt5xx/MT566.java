/*
 * Copyright 2006-2019 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prowidesoftware.swift.model.mt.mt5xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;

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
 * <strong>MT 566 - Corporate Action Confirmation</strong>
 *
 * <p>
 * SWIFT MT566 (ISO 15022) message structure:
 * <br>
 <div class="scheme"><ul>
<li class="sequence">
Sequence A - General Information (M)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 20
 (M) (repetitive)<ul><li>FieldsetItem 20 C (M)</li><li>FieldsetItem 20 C (M)</li><li>FieldsetItem 20 C (O)</li></ul></li><li class="field">Field 23 G (M)</li>
<li class="field">Field 22 F (M)</li>
<li class="field">Field 98 A,C (O)</li>
<li class="sequence">
Sequence A1 - Linkages (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 22 F (O)</li>
<li class="field">Field 13 A,B (O)</li>
<li class="field">Field 20 C (M)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence B - Underlying Securities (M)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 95 P,R (O)</li>
<li class="field">Field 97 A (M)</li>
<li class="field">Field 94 B,C,F (O)</li>
<li class="field">Field 35 B (M)</li>
<li class="sequence">
Sequence B1 - Financial Instrument Attributes (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 94 B (O)</li>
<li class="field">Field 22 F (O)</li>
<li class="field">Field 12 A,C (O)</li>
<li class="field">Field 11 A (O)</li>
<li class="fieldset">
Fieldset 98
 (O)<ul><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li></ul></li><li class="fieldset">
Fieldset 92
 (O)<ul><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 D (O)</li></ul></li><li class="fieldset">
Fieldset 36
 (O)<ul><li>FieldsetItem 36 B (O)</li><li>FieldsetItem 36 B (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
<li class="fieldset">
Fieldset 93
 (O) (repetitive)<ul><li>FieldsetItem 93 B,C (O) (repetitive)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O) (repetitive)</li><li>FieldsetItem 93 B,C (O) (repetitive)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O) (repetitive)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li><li>FieldsetItem 93 B,C (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence C - Corporate Action Details (O)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 98
 (O)<ul><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C,E (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li></ul></li><li class="fieldset">
Fieldset 69
 (O)<ul><li>FieldsetItem 69 A,B,C,D,E,F (O)</li><li>FieldsetItem 69 A,B,C,D,E,F (O)</li><li>FieldsetItem 69 A,B,C,D,E,F (O)</li><li>FieldsetItem 69 A,B,C,D,E,F (O)</li><li>FieldsetItem 69 A,B,C,D,E,F (O)</li><li>FieldsetItem 69 A,B,C,D,E,F (O)</li></ul></li><li class="field">Field 99 A (O)</li>
<li class="fieldset">
Fieldset 92
 (O)<ul><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A,F (O)</li><li>FieldsetItem 92 F,P (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A,K (O)</li><li>FieldsetItem 92 A,F (O)</li><li>FieldsetItem 92 A,F (O)</li></ul></li><li class="fieldset">
Fieldset 90
 (O)<ul><li>FieldsetItem 90 A,B (O)</li><li>FieldsetItem 90 A,B,L (O)</li><li>FieldsetItem 90 A,B,L (O)</li></ul></li><li class="fieldset">
Fieldset 36
 (O)<ul><li>FieldsetItem 36 B,C (O)</li><li>FieldsetItem 36 B,C (O)</li><li>FieldsetItem 36 B,C (O)</li><li>FieldsetItem 36 B (O)</li><li>FieldsetItem 36 B (O)</li><li>FieldsetItem 36 B (O)</li></ul></li><li class="field">Field 13 A,B (O) (repetitive)</li>
<li class="fieldset">
Fieldset 17
 (O)<ul><li>FieldsetItem 17 B (O)</li><li>FieldsetItem 17 B (O)</li></ul></li><li class="fieldset">
Fieldset 22
 (O) (repetitive)<ul><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O) (repetitive)</li><li>FieldsetItem 22 F (O) (repetitive)</li><li>FieldsetItem 22 F (O) (repetitive)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence D - Corporate Action Confirmation (O)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 13 A (M)</li>
<li class="fieldset">
Fieldset 22
 (M) (repetitive)<ul><li>FieldsetItem 22 F,H (M)</li><li>FieldsetItem 22 F (O) (repetitive)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="field">Field 11 A (O)</li>
<li class="fieldset">
Fieldset 98
 (O)<ul><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C,E (O)</li><li>FieldsetItem 98 A,B,C,E (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C,E,F (O)</li><li>FieldsetItem 98 A,B,C,E (O)</li><li>FieldsetItem 98 A,B,C,E (O)</li></ul></li><li class="fieldset">
Fieldset 69
 (O)<ul><li>FieldsetItem 69 A,B,C,D,E,F (O)</li><li>FieldsetItem 69 A,B,C,D,E,F (O)</li><li>FieldsetItem 69 A,B,C,D,E,F (O)</li></ul></li><li class="fieldset">
Fieldset 92
 (O) (repetitive)<ul><li>FieldsetItem 92 F,H,J (O) (repetitive)</li><li>FieldsetItem 92 A,F,R (O) (repetitive)</li><li>FieldsetItem 92 A,F (O)</li><li>FieldsetItem 92 A,F (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A,F,J (O) (repetitive)</li><li>FieldsetItem 92 J (O) (repetitive)</li><li>FieldsetItem 92 F,H,J (O) (repetitive)</li><li>FieldsetItem 92 A,F,R (O) (repetitive)</li></ul></li><li class="fieldset">
Fieldset 90
 (O)<ul><li>FieldsetItem 90 A,B (O)</li><li>FieldsetItem 90 A,B (O)</li></ul></li><li class="field">Field 94 B (O)</li>
<li class="sequence">
Sequence D1 - Securities Movement (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 22
 (M) (repetitive)<ul><li>FieldsetItem 22 H (M)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 H (O)</li><li>FieldsetItem 22 F (O) (repetitive)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="field">Field 35 B (M)</li>
<li class="sequence">
Sequence D1a - Financial Instrument Attributes (O)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 94 B (O)</li>
<li class="field">Field 22 F (O)</li>
<li class="field">Field 12 A,C (O)</li>
<li class="field">Field 11 A (O)</li>
<li class="fieldset">
Fieldset 98
 (O)<ul><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li><li>FieldsetItem 98 A (O)</li></ul></li><li class="field">Field 90 A,B (O)</li>
<li class="fieldset">
Fieldset 92
 (O)<ul><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li></ul></li><li class="fieldset">
Fieldset 36
 (O)<ul><li>FieldsetItem 36 B (O)</li><li>FieldsetItem 36 B (O)</li><li>FieldsetItem 36 B (O)</li><li>FieldsetItem 36 B (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 36 B (O) (repetitive)</li>
<li class="fieldset">
Fieldset 94
 (O)<ul><li>FieldsetItem 94 B,C,F (O)</li><li>FieldsetItem 94 C (O)</li></ul></li><li class="field">Field 22 F (O)</li>
<li class="field">Field 11 A (O)</li>
<li class="fieldset">
Fieldset 90
 (O)<ul><li>FieldsetItem 90 A,B (O)</li><li>FieldsetItem 90 A,B (O)</li><li>FieldsetItem 90 A,B,F,J,L (O)</li><li>FieldsetItem 90 A,B,K (O)</li><li>FieldsetItem 90 B (O)</li></ul></li><li class="fieldset">
Fieldset 92
 (O) (repetitive)<ul><li>FieldsetItem 92 D,L (O)</li><li>FieldsetItem 92 D,L,M,N (O)</li><li>FieldsetItem 92 D,L (O)</li><li>FieldsetItem 92 A,F (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A,F (O)</li><li>FieldsetItem 92 A (O)</li></ul></li><li class="fieldset">
Fieldset 98
 (M) (repetitive)<ul><li>FieldsetItem 98 A,C (M)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C,E (O)</li><li>FieldsetItem 98 A,B,C (O)</li><li>FieldsetItem 98 A,B,C (O)</li></ul></li><li class="sequence">
Sequence D1b - Receive/Deliver (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 95
 (M) (repetitive)<ul><li>FieldsetItem 95 P,Q,R,C (M)</li><li>FieldsetItem 95 S (O) (repetitive)</li></ul></li><li class="field">Field 97 A (O)</li>
<li class="field">Field 20 C (O)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence D2 - Cash Movements (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 22
 (M) (repetitive)<ul><li>FieldsetItem 22 H (M)</li><li>FieldsetItem 22 H (O)</li><li>FieldsetItem 22 F (O)</li><li>FieldsetItem 22 F (O) (repetitive)</li><li>FieldsetItem 22 F (O)</li></ul></li><li class="field">Field 94 C (O)</li>
<li class="field">Field 97 A,E (O)</li>
<li class="sequence">
Sequence D2a - Cash Parties (O) (repetitive)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 95
 (M) (repetitive)<ul><li>FieldsetItem 95 P,Q,R (M)</li><li>FieldsetItem 95 S (O)</li></ul></li><li class="field">Field 97 A,E (O)</li>
<li class="field">Field 20 C (O)</li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="fieldset">
Fieldset 19
 (M) (repetitive)<ul><li>FieldsetItem 19 B (M)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li><li>FieldsetItem 19 B (O)</li></ul></li><li class="fieldset">
Fieldset 98
 (M) (repetitive)<ul><li>FieldsetItem 98 A,C (M)</li><li>FieldsetItem 98 A,C (O)</li><li>FieldsetItem 98 A,C,E (O)</li><li>FieldsetItem 98 A,C (O)</li><li>FieldsetItem 98 A,C (O)</li></ul></li><li class="fieldset">
Fieldset 92
 (O) (repetitive)<ul><li>FieldsetItem 92 A,F (O)</li><li>FieldsetItem 92 A,F (O)</li><li>FieldsetItem 92 F (O)</li><li>FieldsetItem 92 A,F,M (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 F,H,J (O) (repetitive)</li><li>FieldsetItem 92 B (O)</li><li>FieldsetItem 92 A,F (O)</li><li>FieldsetItem 92 A,F,J (O) (repetitive)</li><li>FieldsetItem 92 F,H,J (O) (repetitive)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A,F,M (O)</li><li>FieldsetItem 92 A,F (O) (repetitive)</li><li>FieldsetItem 92 A,F,R (O) (repetitive)</li><li>FieldsetItem 92 A,F (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A (O)</li><li>FieldsetItem 92 A,F,R (O) (repetitive)</li><li>FieldsetItem 92 A,F,J,R (O) (repetitive)</li></ul></li><li class="fieldset">
Fieldset 90
 (O)<ul><li>FieldsetItem 90 A,B,F,J,L (O)</li><li>FieldsetItem 90 A,B,K (O)</li></ul></li><li class="sequence">
Sequence D2b - Tax Voucher Details (O)<ul><li class="field">Field 16 R (M)</li>
<li class="field">Field 20 C (M)</li>
<li class="fieldset">
Fieldset 98
 (O)<ul><li>FieldsetItem 98 A,C (O)</li><li>FieldsetItem 98 A,C (O)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="field">Field 16 S (M)</li>
</ul></li>
<li class="sequence">
Sequence E - Additional Information (O)<ul><li class="field">Field 16 R (M)</li>
<li class="fieldset">
Fieldset 70
 (O) (repetitive)<ul><li>FieldsetItem 70 E (O) (repetitive)</li><li>FieldsetItem 70 E (O) (repetitive)</li><li>FieldsetItem 70 E (O) (repetitive)</li><li>FieldsetItem 70 E (O) (repetitive)</li></ul></li><li class="fieldset">
Fieldset 95
 (O) (repetitive)<ul><li>FieldsetItem 95 P,Q,R (O)</li><li>FieldsetItem 95 P,Q,R (O)</li><li>FieldsetItem 95 P,Q,R (O) (repetitive)</li><li>FieldsetItem 95 P,Q,R (O) (repetitive)</li><li>FieldsetItem 95 P,Q,R (O) (repetitive)</li></ul></li><li class="field">Field 16 S (M)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2019</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT566 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT566.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "566";

	/**
	 * Creates an MT566 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT566 content
	 */
	public MT566(SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT566 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT566 content, the parameter can not be null
	 * @see #MT566(String)
	 */
	public MT566(MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT566 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT566 content
	 * @return the created object or null if the parameter is null
	 * @see #MT566(String)
	 * @since 7.7
	 */
	public static MT566 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT566(m);
	}
	
	/**
	 * Creates and initializes a new MT566 input message setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT566() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT566 input message from sender to receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT566(final String sender, final String receiver) {
		super(566, sender, receiver);
	}
	
	/**
	 * Creates a new MT566 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT566(final String fin) {
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
			log.warning("Creating an MT566 object from FIN content with a Service Message. Check if the MT566 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), getMessageType())) {
			log.warning("Creating an MT566 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT566 by parsing a String with the message content in its swift FIN format.<br>
	 * If the fin parameter cannot be parsed, the returned MT566 will have its internal message object
	 * initialized (blocks will be created) but empty.<br>
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT566 or null if fin is null 
	 * @since 7.7
	 */
	public static MT566 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT566(fin);
    }
    
    /**
	 * Creates a new MT566 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT566(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT566 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br>
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT566 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT566 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT566(stream);
    }
    
    /**
	 * Creates a new MT566 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT566(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT566 by parsing a file with the message content in its swift FIN format.<br>
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT566 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT566 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT566(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "566";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT566 append(final SwiftTagListBlock block) {
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
	public MT566 append(final Tag ... tags) {
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
	public MT566 append(final Field ... fields) {
		super.append(fields);
		return this;
	}

    /**
	 * Creates an MT566 messages from its JSON representation.
	 * <p>
	 * For generic conversion of JSON into the corresopnding MT instance
	 * see {@link AbstractMT#fromJson(String)}
	 *
	 * @param json a JSON representation of an MT566 message
	 * @return a new instance of MT566
	 * @since 7.10.3
	 */
	public final static MT566 fromJson(String json) {
		return (MT566) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 23G, 
	 * or null if none is found.<br>
	 * The first occurrence of field 23G at MT566 is expected to be the only one.
	 * 
	 * @return a Field23G object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23G getField23G() {
		final Tag t = tag("23G");
		if (t != null) {
			return new Field23G(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 99A, 
	 * or null if none is found.<br>
	 * The first occurrence of field 99A at MT566 is expected to be the only one.
	 * 
	 * @return a Field99A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field99A getField99A() {
		final Tag t = tag("99A");
		if (t != null) {
			return new Field99A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 20C at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field20C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field20C> getField20C() {
		final List<Field20C> result = new ArrayList<>();
		final Tag[] tags = tags("20C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field20C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 16R at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field16R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field16R> getField16R() {
		final List<Field16R> result = new ArrayList<>();
		final Tag[] tags = tags("16R");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field16R(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22F at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22F> getField22F() {
		final List<Field22F> result = new ArrayList<>();
		final Tag[] tags = tags("22F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 13A at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field13A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field13A> getField13A() {
		final List<Field13A> result = new ArrayList<>();
		final Tag[] tags = tags("13A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field13A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 13B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field13B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field13B> getField13B() {
		final List<Field13B> result = new ArrayList<>();
		final Tag[] tags = tags("13B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field13B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 16S at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field16S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field16S> getField16S() {
		final List<Field16S> result = new ArrayList<>();
		final Tag[] tags = tags("16S");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field16S(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 94B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94B> getField94B() {
		final List<Field94B> result = new ArrayList<>();
		final Tag[] tags = tags("94B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field94B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 12A at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12A> getField12A() {
		final List<Field12A> result = new ArrayList<>();
		final Tag[] tags = tags("12A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field12A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 12C at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12C> getField12C() {
		final List<Field12C> result = new ArrayList<>();
		final Tag[] tags = tags("12C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field12C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 11A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 11A at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field11A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field11A> getField11A() {
		final List<Field11A> result = new ArrayList<>();
		final Tag[] tags = tags("11A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field11A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 98A at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98A> getField98A() {
		final List<Field98A> result = new ArrayList<>();
		final Tag[] tags = tags("98A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field98A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92A at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92A> getField92A() {
		final List<Field92A> result = new ArrayList<>();
		final Tag[] tags = tags("92A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92D at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92D> getField92D() {
		final List<Field92D> result = new ArrayList<>();
		final Tag[] tags = tags("92D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 36B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field36B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field36B> getField36B() {
		final List<Field36B> result = new ArrayList<>();
		final Tag[] tags = tags("36B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field36B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 93B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 93B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field93B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field93B> getField93B() {
		final List<Field93B> result = new ArrayList<>();
		final Tag[] tags = tags("93B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field93B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 93C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 93C at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field93C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field93C> getField93C() {
		final List<Field93C> result = new ArrayList<>();
		final Tag[] tags = tags("93C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field93C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 98C at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98C> getField98C() {
		final List<Field98C> result = new ArrayList<>();
		final Tag[] tags = tags("98C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field98C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 98B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98B> getField98B() {
		final List<Field98B> result = new ArrayList<>();
		final Tag[] tags = tags("98B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field98B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 98E at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98E> getField98E() {
		final List<Field98E> result = new ArrayList<>();
		final Tag[] tags = tags("98E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field98E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 69A at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69A> getField69A() {
		final List<Field69A> result = new ArrayList<>();
		final Tag[] tags = tags("69A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field69A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 69B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69B> getField69B() {
		final List<Field69B> result = new ArrayList<>();
		final Tag[] tags = tags("69B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field69B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 69C at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69C> getField69C() {
		final List<Field69C> result = new ArrayList<>();
		final Tag[] tags = tags("69C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field69C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 69D at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69D> getField69D() {
		final List<Field69D> result = new ArrayList<>();
		final Tag[] tags = tags("69D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field69D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 69E at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69E> getField69E() {
		final List<Field69E> result = new ArrayList<>();
		final Tag[] tags = tags("69E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field69E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 69F at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69F> getField69F() {
		final List<Field69F> result = new ArrayList<>();
		final Tag[] tags = tags("69F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field69F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92F at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92F> getField92F() {
		final List<Field92F> result = new ArrayList<>();
		final Tag[] tags = tags("92F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92K, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92K at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92K> getField92K() {
		final List<Field92K> result = new ArrayList<>();
		final Tag[] tags = tags("92K");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92K(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92P at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92P> getField92P() {
		final List<Field92P> result = new ArrayList<>();
		final Tag[] tags = tags("92P");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92P(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 90A at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90A> getField90A() {
		final List<Field90A> result = new ArrayList<>();
		final Tag[] tags = tags("90A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field90A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 90B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90B> getField90B() {
		final List<Field90B> result = new ArrayList<>();
		final Tag[] tags = tags("90B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field90B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 90L at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90L> getField90L() {
		final List<Field90L> result = new ArrayList<>();
		final Tag[] tags = tags("90L");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field90L(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 36C at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field36C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field36C> getField36C() {
		final List<Field36C> result = new ArrayList<>();
		final Tag[] tags = tags("36C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field36C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 17B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 17B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field17B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field17B> getField17B() {
		final List<Field17B> result = new ArrayList<>();
		final Tag[] tags = tags("17B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field17B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 22H at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22H> getField22H() {
		final List<Field22H> result = new ArrayList<>();
		final Tag[] tags = tags("22H");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field22H(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 98F at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98F> getField98F() {
		final List<Field98F> result = new ArrayList<>();
		final Tag[] tags = tags("98F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field98F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92H at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92H> getField92H() {
		final List<Field92H> result = new ArrayList<>();
		final Tag[] tags = tags("92H");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92H(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92J at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92J> getField92J() {
		final List<Field92J> result = new ArrayList<>();
		final Tag[] tags = tags("92J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92R at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92R> getField92R() {
		final List<Field92R> result = new ArrayList<>();
		final Tag[] tags = tags("92R");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92R(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 35B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 35B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field35B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field35B> getField35B() {
		final List<Field35B> result = new ArrayList<>();
		final Tag[] tags = tags("35B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field35B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 94C at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94C> getField94C() {
		final List<Field94C> result = new ArrayList<>();
		final Tag[] tags = tags("94C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field94C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 94F at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94F> getField94F() {
		final List<Field94F> result = new ArrayList<>();
		final Tag[] tags = tags("94F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field94F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 90F at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90F> getField90F() {
		final List<Field90F> result = new ArrayList<>();
		final Tag[] tags = tags("90F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field90F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 90J at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90J> getField90J() {
		final List<Field90J> result = new ArrayList<>();
		final Tag[] tags = tags("90J");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field90J(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90K, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 90K at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90K> getField90K() {
		final List<Field90K> result = new ArrayList<>();
		final Tag[] tags = tags("90K");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field90K(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92L at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92L> getField92L() {
		final List<Field92L> result = new ArrayList<>();
		final Tag[] tags = tags("92L");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92L(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92M, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92M at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92M objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92M> getField92M() {
		final List<Field92M> result = new ArrayList<>();
		final Tag[] tags = tags("92M");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92M(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92N, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92N at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92N objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92N> getField92N() {
		final List<Field92N> result = new ArrayList<>();
		final Tag[] tags = tags("92N");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92N(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95C at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95C> getField95C() {
		final List<Field95C> result = new ArrayList<>();
		final Tag[] tags = tags("95C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95P at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95P> getField95P() {
		final List<Field95P> result = new ArrayList<>();
		final Tag[] tags = tags("95P");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95P(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95Q, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95Q at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95Q objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95Q> getField95Q() {
		final List<Field95Q> result = new ArrayList<>();
		final Tag[] tags = tags("95Q");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95Q(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95R at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95R> getField95R() {
		final List<Field95R> result = new ArrayList<>();
		final Tag[] tags = tags("95R");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95R(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 95S at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95S> getField95S() {
		final List<Field95S> result = new ArrayList<>();
		final Tag[] tags = tags("95S");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field95S(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 97A at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97A> getField97A() {
		final List<Field97A> result = new ArrayList<>();
		final Tag[] tags = tags("97A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field97A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 97E at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97E> getField97E() {
		final List<Field97E> result = new ArrayList<>();
		final Tag[] tags = tags("97E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field97E(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 19B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field19B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field19B> getField19B() {
		final List<Field19B> result = new ArrayList<>();
		final Tag[] tags = tags("19B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field19B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 92B at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92B> getField92B() {
		final List<Field92B> result = new ArrayList<>();
		final Tag[] tags = tags("92B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field92B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br>
	 * Multiple occurrences of field 70E at MT566 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70E> getField70E() {
		final List<Field70E> result = new ArrayList<>();
		final Tag[] tags = tags("70E");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field70E(tag.getValue()));
            }
		}
		return result;
	}
	

	/**
	 * Class to model Sequence "A" in MT 566
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
		 * @return a new instance of the sequence, initialized with the parameter tags
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
		 * @return a new instance of the sequence
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
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
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
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @return the found sequence or an empty sequence if none is found
	 * @see SequenceA#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceA getSequenceA() {
		return new SequenceA(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	 * Get the single occurrence of SequenceA delimited by 16R/16S the value of SequenceA#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @see SequenceA#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceA within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceA getSequenceA(SwiftTagListBlock parentSequence) {
		final SequenceA s = new SequenceA();
		if (parentSequence != null) {
		    s.setTags(parentSequence.getSubBlock(SequenceA.START_END_16RS).getTags());
		}
		return s;
	}
 

	/**
	 * Class to model Sequence "A1" in MT 566
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
		 * @return a new instance of the sequence, initialized with the parameter tags
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
		 * @return a new instance of the sequence
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
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
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
	 * Get the list of SequenceA1 delimited by 16R/16S with value specified in {@link SequenceA1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceA1#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceA1> getSequenceA1List() {
		return getSequenceA1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceA1 delimited by 16R/16S with value specified in {@link SequenceA1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceA1#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceA1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceA1> getSequenceA1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceA1.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceA1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceA1 s = new SequenceA1();
                    s.setTags(b.getSubBlock(SequenceA1.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "B" in MT 566
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>USECU</em>
		 */
		public static final String START_END_16RS = "USECU";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
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
		 * @return a new instance of the sequence
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
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
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
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @return the found sequence or an empty sequence if none is found
	 * @see SequenceB#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceB getSequenceB() {
		return new SequenceB(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	 * Get the single occurrence of SequenceB delimited by 16R/16S the value of SequenceB#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @see SequenceB#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceB getSequenceB(SwiftTagListBlock parentSequence) {
		final SequenceB s = new SequenceB();
		if (parentSequence != null) {
		    s.setTags(parentSequence.getSubBlock(SequenceB.START_END_16RS).getTags());
		}
		return s;
	}
 

	/**
	 * Class to model Sequence "B1" in MT 566
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	@NonUniqueSeparator
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
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
	    @NonUniqueSeparator
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
		 * @return a new instance of the sequence
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
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
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
	 * Get the list of SequenceB1 delimited by 16R/16S with value specified in {@link SequenceB1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
     * @return the found sequences or an empty list if none is found
	 * @see SequenceB1#START_END_16RS
	 */
	@NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB1> getSequenceB1List() {
  	    /*
		 * The delimiter FIA is not unique across all sequences, in this MT.
		 * The usual generated API for accessing this can not be used for sequence B1.
		 * So we call a special method to resolve this situation until we find a better approach.
		 */
		if (this.getSwiftMessage() == null) {
			return null;
		}
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT566GetSequenceB1List_sru2019(this);
	}
	/**
	 * Get the list of SequenceB1 delimited by 16R/16S with value specified in {@link SequenceB1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	 * @see SequenceB1#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceB1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB1> getSequenceB1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB1.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceB1 s = new SequenceB1();
                    s.setTags(b.getSubBlock(SequenceB1.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "C" in MT 566
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CADETL</em>
		 */
		public static final String START_END_16RS = "CADETL";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
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
		 * @return a new instance of the sequence
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
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
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
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @return the found sequence or an empty sequence if none is found
	 * @see SequenceC#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceC getSequenceC() {
		return new SequenceC(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	 * Get the single occurrence of SequenceC delimited by 16R/16S the value of SequenceC#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @see SequenceC#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceC within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceC getSequenceC(SwiftTagListBlock parentSequence) {
		final SequenceC s = new SequenceC();
		if (parentSequence != null) {
		    s.setTags(parentSequence.getSubBlock(SequenceC.START_END_16RS).getTags());
		}
		return s;
	}
 

	/**
	 * Class to model Sequence "D" in MT 566
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CACONF</em>
		 */
		public static final String START_END_16RS = "CACONF";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
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
		 * @return a new instance of the sequence
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
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
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
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @return the found sequence or an empty sequence if none is found
	 * @see SequenceD#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceD getSequenceD() {
		return new SequenceD(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	 * Get the single occurrence of SequenceD delimited by 16R/16S the value of SequenceD#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @see SequenceD#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceD within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceD getSequenceD(SwiftTagListBlock parentSequence) {
		final SequenceD s = new SequenceD();
		if (parentSequence != null) {
		    s.setTags(parentSequence.getSubBlock(SequenceD.START_END_16RS).getTags());
		}
		return s;
	}
 

	/**
	 * Class to model Sequence "D1" in MT 566
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SECMOVE</em>
		 */
		public static final String START_END_16RS = "SECMOVE";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
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
		 * @return a new instance of the sequence
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
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
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
	 * Get the list of SequenceD1 delimited by 16R/16S with value specified in {@link SequenceD1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceD1#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceD1> getSequenceD1List() {
		return getSequenceD1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceD1 delimited by 16R/16S with value specified in {@link SequenceD1#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceD1#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceD1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceD1> getSequenceD1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceD1.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceD1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceD1 s = new SequenceD1();
                    s.setTags(b.getSubBlock(SequenceD1.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "D1a" in MT 566
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	@NonUniqueSeparator
	public static class SequenceD1a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceD1a() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceD1a(final SwiftTagListBlock content) {
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
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
	    @NonUniqueSeparator
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceD1a newInstance(final Tag ... tags) {
			final SequenceD1a result = new SequenceD1a();
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
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceD1a newInstance() {
			final SequenceD1a result = new SequenceD1a();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceD1a newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD1a result = new SequenceD1a();
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
		private SequenceD1a(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceD1a delimited by 16R/16S with value specified in {@link SequenceD1a#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
     * @return the found sequences or an empty list if none is found
	 * @see SequenceD1a#START_END_16RS
	 */
	@NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceD1a> getSequenceD1aList() {
  	    /*
		 * The delimiter FIA is not unique across all sequences, in this MT.
		 * The usual generated API for accessing this can not be used for sequence D1a.
		 * So we call a special method to resolve this situation until we find a better approach.
		 */
		if (this.getSwiftMessage() == null) {
			return null;
		}
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT566GetSequenceD1aList_sru2019(this);
	}
	/**
	 * Get the list of SequenceD1a delimited by 16R/16S with value specified in {@link SequenceD1a#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     *
     * <p>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
     * present inside its parent sequences.
     * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	 * @see SequenceD1a#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceD1a within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceD1a> getSequenceD1aList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceD1a.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceD1a> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceD1a s = new SequenceD1a();
                    s.setTags(b.getSubBlock(SequenceD1a.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "D1b" in MT 566
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceD1b extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceD1b() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceD1b(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>RECDEL</em>
		 */
		public static final String START_END_16RS = "RECDEL";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceD1b newInstance(final Tag ... tags) {
			final SequenceD1b result = new SequenceD1b();
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
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceD1b newInstance() {
			final SequenceD1b result = new SequenceD1b();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceD1b newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD1b result = new SequenceD1b();
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
		private SequenceD1b(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceD1b delimited by 16R/16S with value specified in {@link SequenceD1b#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceD1b#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceD1b> getSequenceD1bList() {
		return getSequenceD1bList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceD1b delimited by 16R/16S with value specified in {@link SequenceD1b#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceD1b#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceD1b within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceD1b> getSequenceD1bList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceD1b.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceD1b> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceD1b s = new SequenceD1b();
                    s.setTags(b.getSubBlock(SequenceD1b.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "D2" in MT 566
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
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CASHMOVE</em>
		 */
		public static final String START_END_16RS = "CASHMOVE";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
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
		 * @return a new instance of the sequence
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
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
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
	 * Get the list of SequenceD2 delimited by 16R/16S with value specified in {@link SequenceD2#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceD2#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceD2> getSequenceD2List() {
		return getSequenceD2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceD2 delimited by 16R/16S with value specified in {@link SequenceD2#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceD2#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceD2 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceD2> getSequenceD2List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceD2.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceD2> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceD2 s = new SequenceD2();
                    s.setTags(b.getSubBlock(SequenceD2.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "D2a" in MT 566
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceD2a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceD2a() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceD2a(final SwiftTagListBlock content) {
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
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceD2a newInstance(final Tag ... tags) {
			final SequenceD2a result = new SequenceD2a();
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
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceD2a newInstance() {
			final SequenceD2a result = new SequenceD2a();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceD2a newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD2a result = new SequenceD2a();
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
		private SequenceD2a(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceD2a delimited by 16R/16S with value specified in {@link SequenceD2a#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceD2a#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceD2a> getSequenceD2aList() {
		return getSequenceD2aList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceD2a delimited by 16R/16S with value specified in {@link SequenceD2a#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceD2a#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceD2a within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceD2a> getSequenceD2aList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceD2a.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceD2a> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceD2a s = new SequenceD2a();
                    s.setTags(b.getSubBlock(SequenceD2a.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "D2b" in MT 566
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceD2b extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	    private SequenceD2b() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceD2b(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>TAXVODET</em>
		 */
		public static final String START_END_16RS = "TAXVODET";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);

		/**
		 * Creates a new instance of this sequence with the given tags inside.
		 * @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceD2b newInstance(final Tag ... tags) {
			final SequenceD2b result = new SequenceD2b();
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
		 * @return a new instance of the sequence
		 * @since 7.6
		 */
		public static SequenceD2b newInstance() {
			final SequenceD2b result = new SequenceD2b();
			result.append(START_TAG);
			result.append(END_TAG);
			return result;
		}

		/**
		 * Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		 * Mainly intended to create a sequence by adding subsequences
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
		 * @since 7.6
		 */
		public static SequenceD2b newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD2b result = new SequenceD2b();
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
		private SequenceD2b(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}

	}

	/**
	 * Get the list of SequenceD2b delimited by 16R/16S with value specified in {@link SequenceD2b#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
     * @return the found sequences or an empty list if none is found
	 * @see SequenceD2b#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceD2b> getSequenceD2bList() {
		return getSequenceD2bList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	 * Get the list of SequenceD2b delimited by 16R/16S with value specified in {@link SequenceD2b#START_END_16RS}
	 *
	 * <p>The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * @see SequenceD2b#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceD2b within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceD2b> getSequenceD2bList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceD2b.START_END_16RS);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceD2b> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    final SequenceD2b s = new SequenceD2b();
                    s.setTags(b.getSubBlock(SequenceD2b.START_END_16RS).getTags());
                    result.add(s);
                }
                return result;
            }
		}
		return Collections.emptyList();
	}
 

	/**
	 * Class to model Sequence "E" in MT 566
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
		 * @return a new instance of the sequence, initialized with the parameter tags
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
		 * @return a new instance of the sequence
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
		 * @param sequences a list of blocks to set as the new sequence content
		 * @return a new instance of the sequence, initialized with the parameter sequences content
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
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @return the found sequence or an empty sequence if none is found
	 * @see SequenceE#START_END_16RS
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceE getSequenceE() {
		return new SequenceE(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	 * Get the single occurrence of SequenceE delimited by 16R/16S the value of SequenceE#START_END_16RS.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * @see SequenceE#START_END_16RS
	 * @param parentSequence a not null parent sequence to find SequenceE within it
	 * @return the found sequence or an empty sequence if none is found, <em>never returns null</em>
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceE getSequenceE(SwiftTagListBlock parentSequence) {
		final SequenceE s = new SequenceE();
		if (parentSequence != null) {
		    s.setTags(parentSequence.getSubBlock(SequenceE.START_END_16RS).getTags());
		}
		return s;
	}
 



}

/*
 * Copyright 2006-2026 Prowide
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
package com.prowidesoftware.swift.model.field;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Placeholder tests for Field95Z introduced in MFVR 2026 (fast-track page 113).
 *
 * <p>Component layout comes from fin.370.2026.xsd complexType F95Z_Type:
 * <ol>
 *   <li>Qualifier</li>
 *   <li>CountryCode (Country_Type, prefix "/")</li>
 *   <li>TownName (Text_FIN_35x_Type, prefix "/")</li>
 *   <li>NameAndAddress Line 1 (Text_FIN_35x_Type, prefix CRLF, mandatory)</li>
 *   <li>NameAndAddress Line 2 (optional)</li>
 *   <li>NameAndAddress Line 3 (optional)</li>
 *   <li>NameAndAddress Line 4 (optional)</li>
 * </ol>
 *
 * <p>Syntax per MFVR page 113:
 * <pre>
 * ":"4!c"//"&lt;CC&gt;"/"35x"CRLF"35x["CRLF"35x]0-3
 * </pre>
 *
 * <p>Error codes: T26 T73.
 *
 * <p>CSV row driving the generation:
 * <pre>
 * 95,Z,SKSSSSS,:S//S/S$S[$S]0-3,:4!c//&lt;CC&gt;/35x$35x[$35x]0-3(***),"optional:5,6,7",(Qualifier)(Country Code)(Town Name)(Name And Address[4]),T26 T73,,
 * </pre>
 *
 * <p>Activate these tests once codegen regenerates Field95Z.
 */
public class Field95ZTest {

    /**
     * Parse a 95Z value with qualifier, country code, town name and single mandatory Name/Address line.
     */
    @Test
    @Disabled("SRU2026 placeholder: Field95Z class pending codegen")
    public void testField95Z_simple_parse() {
        // Field95Z f = new Field95Z(":BUYR//US/NEW YORK\nACME CORP");
        // assertEquals("BUYR", f.getComponent1());    // Qualifier
        // assertEquals("US", f.getComponent2());      // Country Code
        // assertEquals("NEW YORK", f.getComponent3()); // Town Name
        // assertEquals("ACME CORP", f.getComponent4()); // N&A line 1
    }

    /**
     * Parse a 95Z value with full Name/Address (4 lines).
     */
    @Test
    @Disabled("SRU2026 placeholder: Field95Z class pending codegen")
    public void testField95Z_fullNameAndAddress_parse() {
        // Field95Z f = new Field95Z(":BUYR//US/NEW YORK\nACME CORP\n5TH AVE\nSUITE 42\nNY 10001");
        // assertEquals("ACME CORP", f.getComponent4());
        // assertEquals("5TH AVE", f.getComponent5());
        // assertEquals("SUITE 42", f.getComponent6());
        // assertEquals("NY 10001", f.getComponent7());
    }

    /**
     * Invalid country code triggers T73.
     */
    @Test
    @Disabled("SRU2026 placeholder: Field95Z validator pending")
    public void testField95Z_invalidCountryCode_reportsT73() {
        // Validator should report T73 for an invalid CountryCode such as "Z1"
    }
}

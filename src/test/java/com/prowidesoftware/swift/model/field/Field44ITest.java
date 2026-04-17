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
 * Placeholder tests for Field44I introduced in MFVR 2026 (fast-track pages 99 and 132).
 *
 * <p>Field 44 option I carries an Incoterms code (3!a) followed by up to 2 optional
 * narrative lines. The pattern is:
 * <pre>
 * 3!a["CRLF"70z]0-2
 * </pre>
 *
 * <p>Used in MTs 700, 705, 707, 710 (trade finance documentary credits).
 *
 * <p><b>Error codes:</b>
 * <ul>
 *   <li><b>T42</b>: charset/pattern error on the 3!a code (from the CSV validator pattern)</li>
 *   <li><b>T66</b>: invalid code word -- per Part III Chapter 4 page 132, the Incoterms code
 *       in subfield 1 must be one of: CFR, CIF, CIP, CPT, DAP, DDP, DPU, EXW, FAS, FCA, FOB, OTH.
 *       T66 is enforced via the scheme XML {@code qualifiers} attribute on field 44 letterOption I
 *       for MTs 700/705/707/710 (to be added in Part V).</li>
 * </ul>
 *
 * <p>CSV row (already added in commit for pages 98-99):
 * <pre>
 * 44,I,SSS,S[$S]0-2,3!a[$70z]0-2,"optional:2,3",(Code|@Incoterms)(Narrative[2]),T42,,
 * </pre>
 *
 * <p>Activate these tests once codegen regenerates Field44I.
 */
public class Field44ITest {

    /**
     * Parse a simple 44I value with the Incoterms code only.
     */
    @Test
    @Disabled("SRU2026 placeholder: Field44I class pending codegen")
    public void testField44I_codeOnly_parse() {
        // Field44I f = new Field44I("CIF");
        // assertEquals("CIF", f.getComponent1());
        // assertNull(f.getComponent2());
        // assertNull(f.getComponent3());
    }

    /**
     * Parse a 44I value with code and one narrative line.
     */
    @Test
    @Disabled("SRU2026 placeholder: Field44I class pending codegen")
    public void testField44I_codeWithNarrative_parse() {
        // Field44I f = new Field44I("CIF\nDestination Port");
        // assertEquals("CIF", f.getComponent1());
        // assertEquals("Destination Port", f.getComponent2());
    }

    /**
     * Parse a 44I value with code and two narrative lines (maximum).
     */
    @Test
    @Disabled("SRU2026 placeholder: Field44I class pending codegen")
    public void testField44I_codeWithTwoNarrativeLines_parse() {
        // Field44I f = new Field44I("CIF\nDestination Port\nAdditional Info");
        // assertEquals("CIF", f.getComponent1());
        // assertEquals("Destination Port", f.getComponent2());
        // assertEquals("Additional Info", f.getComponent3());
    }

    /**
     * All 12 valid Incoterms codes per MFVR 2026 page 132.
     */
    @Test
    @Disabled("SRU2026 placeholder: Field44I class pending codegen")
    public void testField44I_validIncotermsCodes_parse() {
        // String[] validCodes = {
        //     "CFR", "CIF", "CIP", "CPT", "DAP", "DDP",
        //     "DPU", "EXW", "FAS", "FCA", "FOB", "OTH"
        // };
        // for (String code : validCodes) {
        //     Field44I f = new Field44I(code);
        //     assertEquals(code, f.getComponent1());
        // }
    }
}

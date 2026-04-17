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
 * Placeholder tests for Field59E introduced in MFVR 2026.
 *
 * <h2>Source documents and discrepancy</h2>
 *
 * <p>There are two related SRU2026 specification documents with a discrepancy on this field:
 *
 * <ul>
 *   <li><b>MFVR 2026 Fast-Track (13 Feb 2026)</b> -- page 104 introduces a new {@code (ICM)}
 *       variant of field 59 without letter option, with pattern {@code ["/"34x"CRLF"]35x} and
 *       error codes {@code T77 T98 (ICM)}. Pages 154-155 (Rule C05 matrix) and 156-157
 *       (Rule C06) refer to this new field as <b>"59A"</b> in the MTs 760/765/767/785.</li>
 *   <li><b>Updates to MFVR (20 Feb 2026)</b> -- one week later, SWIFT published corrections
 *       (errata) to the fast-track. Section 2.3 formally names the new option as
 *       <b>"59E"</b> (not 59A nor an ICM variant without letter). Section 2.5 (Rule C05)
 *       and 2.6 (Rule C06) explicitly state {@code "Changed letter option 59A to 59E"}.</li>
 * </ul>
 *
 * <p>The Updates document is the authoritative version. This codebase implements <b>59E</b>.
 *
 * <h2>Pattern</h2>
 *
 * <pre>
 * ["/"34x"CRLF"]35x
 * </pre>
 *
 * <p>Error codes: <b>T77</b> (name longer than 35 chars), <b>T98</b> (ICM party identifier check).
 *
 * <p>CSV row:
 * <pre>
 * 59,E,SS,[/S$]S,[/34x$]35x,optional:1;account:1,(Account)(Name And Address),T77 T98,,
 * </pre>
 *
 * <p>Activate these tests once codegen regenerates Field59E.
 */
public class Field59ETest {

    /**
     * Parse a 59E value with account number and name/address.
     */
    @Test
    @Disabled("SRU2026 placeholder: Field59E class pending codegen")
    public void testField59E_withAccount_parse() {
        // Field59E f = new Field59E("/12345678\nBeneficiary name");
        // assertEquals("12345678", f.getComponent1());  // Account
        // assertEquals("Beneficiary name", f.getComponent2());  // Name And Address
    }

    /**
     * Parse a 59E value without account number (only name/address).
     */
    @Test
    @Disabled("SRU2026 placeholder: Field59E class pending codegen")
    public void testField59E_nameOnly_parse() {
        // Field59E f = new Field59E("Beneficiary name");
        // assertNull(f.getComponent1());
        // assertEquals("Beneficiary name", f.getComponent2());
    }
}

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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests for Field50S introduced in SRU2026 (Applicant in MT 700/705/707/710/720).
 * Pattern: 35z[$35z]0-3 (up to 4 narrative lines, structured).
 */
public class Field50STest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("50S", "line1", "line1\nline2", "line1\nline2\nline3\nline4");
    }

    @Test
    public void testParse_multiLine() {
        Field50S f = new Field50S("NAME ACME CORP\nADDRESS 123 MAIN ST\nCITY LONDON\nCOUNTRY UK");
        assertEquals("NAME ACME CORP", f.getComponent1());
        assertEquals("ADDRESS 123 MAIN ST", f.getComponent2());
        assertEquals("CITY LONDON", f.getComponent3());
        assertEquals("COUNTRY UK", f.getComponent4());
    }
}

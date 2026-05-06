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
 * Tests for Field51S introduced in SRU2026 (Obligor/Instructing Party in MT 760/767).
 * Pattern: 35z[$35z]0-3 (up to 4 narrative lines, structured).
 */
public class Field51STest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("51S", "line1", "line1\nline2\nline3\nline4");
    }

    @Test
    public void testParse_multiLine() {
        Field51S f = new Field51S("NAME BETA CORP\nADDR 456 OAK\nCITY PARIS\nCOUNTRY FR");
        assertEquals("NAME BETA CORP", f.getComponent1());
        assertEquals("ADDR 456 OAK", f.getComponent2());
        assertEquals("CITY PARIS", f.getComponent3());
        assertEquals("COUNTRY FR", f.getComponent4());
    }
}

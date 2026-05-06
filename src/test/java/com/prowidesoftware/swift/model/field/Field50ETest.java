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
 * Tests for Field50E introduced in SRU2026.
 * Pattern: 35z[$35z]0-3 (up to 4 narrative lines).
 */
public class Field50ETest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("50E", "line1", "line1\nline2\nline3\nline4");
    }

    @Test
    public void testParse_multiLine() {
        Field50E f = new Field50E("NAME\nADDRESS\nCITY\nCOUNTRY");
        assertEquals("NAME", f.getComponent1());
        assertEquals("ADDRESS", f.getComponent2());
        assertEquals("CITY", f.getComponent3());
        assertEquals("COUNTRY", f.getComponent4());
    }
}

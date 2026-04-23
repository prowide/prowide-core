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
 * Tests for Field50N introduced in SRU2026 (Applicant/Beneficiary in MT 700/705/707/710/720).
 * Pattern: 35z[$35z]0-3 (up to 4 narrative lines).
 */
public class Field50NTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("50N", "line1", "line1\nline2", "line1\nline2\nline3\nline4");
    }

    @Test
    public void testParse_singleLine() {
        Field50N f = new Field50N("JOHN SMITH");
        assertEquals("JOHN SMITH", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
    }

    @Test
    public void testParse_multiLine() {
        Field50N f = new Field50N("JOHN SMITH\n299 PARK AVENUE\nNEW YORK\nUS");
        assertEquals("JOHN SMITH", f.getComponent1());
        assertEquals("299 PARK AVENUE", f.getComponent2());
        assertEquals("NEW YORK", f.getComponent3());
        assertEquals("US", f.getComponent4());
    }
}

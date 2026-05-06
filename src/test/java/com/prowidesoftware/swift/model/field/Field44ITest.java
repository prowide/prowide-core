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
 * Tests for Field44I introduced in SRU2026 (Incoterms code words for MTs 700/705/707/710).
 * Pattern: 3!a[$70z]0-2.
 */
public class Field44ITest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("44I", "CIF", "CIF\nDestination Port", "CIF\nDestination Port\nAdditional Info");
    }

    @Test
    public void testParse_codeOnly() {
        Field44I f = new Field44I("CIF");
        assertEquals("CIF", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
    }

    @Test
    public void testParse_codeWithNarrative() {
        Field44I f = new Field44I("CIF\nDestination Port");
        assertEquals("CIF", f.getComponent1());
        assertEquals("Destination Port", f.getComponent2());
        assertNull(f.getComponent3());
    }

    @Test
    public void testParse_codeWithTwoNarrativeLines() {
        Field44I f = new Field44I("CIF\nDestination Port\nAdditional Info");
        assertEquals("CIF", f.getComponent1());
        assertEquals("Destination Port", f.getComponent2());
        assertEquals("Additional Info", f.getComponent3());
    }
}

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
 * Tests for Field78K introduced in SRU2026 (documentary credit narrative in MT 700/707/710/720).
 * Pattern: 65z[$65z]0-29 (up to 30 narrative lines).
 */
public class Field78KTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("78K", "line1", "line1\nline2\nline3");
    }

    @Test
    public void testParse_singleLine() {
        Field78K f = new Field78K("DOCUMENTARY CREDIT TERMS");
        assertEquals("DOCUMENTARY CREDIT TERMS", f.getComponent1());
        assertNull(f.getComponent2());
    }

    @Test
    public void testParse_multiLine() {
        Field78K f = new Field78K("LINE1\nLINE2\nLINE3");
        assertEquals("LINE1", f.getComponent1());
        assertEquals("LINE2", f.getComponent2());
        assertEquals("LINE3", f.getComponent3());
    }
}

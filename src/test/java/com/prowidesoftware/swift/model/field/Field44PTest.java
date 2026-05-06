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
 * Tests for Field44P introduced in SRU2026 (MT 760).
 * Pattern: 65x (single narrative).
 */
public class Field44PTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("44P", "NARRATIVE LINE");
    }

    @Test
    public void testParse() {
        Field44P f = new Field44P("DELIVERY TERMS");
        assertEquals("DELIVERY TERMS", f.getComponent1());
    }

    @Test
    public void testSetComponent() {
        Field44P f = new Field44P();
        f.setComponent1("PORT OF LOADING");
        assertEquals("PORT OF LOADING", f.getValue());
    }
}

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
 * Tests for Field59T introduced in SRU2026 (Beneficiary in MT 700/705/707/710/720/740/760/765/767/785).
 * Pattern: 35z (single narrative, max 35 chars).
 */
public class Field59TTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("59T", "JANE DOE", "BETA CORPORATION LTD");
    }

    @Test
    public void testParse() {
        Field59T f = new Field59T("JANE DOE");
        assertEquals("JANE DOE", f.getComponent1());
    }

    @Test
    public void testSetComponent() {
        Field59T f = new Field59T();
        f.setComponent1("DOE JANE");
        assertEquals("DOE JANE", f.getValue());
    }
}

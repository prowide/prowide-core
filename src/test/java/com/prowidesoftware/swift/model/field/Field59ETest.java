/*
 * Copyright 20062026 Prowide
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
 * Tests for Field59E introduced in SRU2026 (MTs 760/765/767/785).
 * Definition (swift_fields.csv l.432): {@code 59,E,B,S,<BIC>} — a single
 * {@code <CONNECTED/NON-CONNECTED BIC>} component ("Identifier Code").
 */
public class Field59ETest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("59E", "ABNANL2A", "ABNANL2AXXX");
    }

    @Test
    public void testParse() {
        Field59E f = new Field59E("ABNANL2A");
        assertEquals("ABNANL2A", f.getComponent1());
    }

    @Test
    public void testParse_full11() {
        Field59E f = new Field59E("ABNANL2AXXX");
        assertEquals("ABNANL2AXXX", f.getComponent1());
    }
}

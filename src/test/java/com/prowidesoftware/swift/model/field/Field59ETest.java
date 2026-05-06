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
 * Tests for Field59E introduced in SRU2026 (MTs 760/765/767/785).
 * Pattern: [/34x$]35x (optional account + name/address).
 */
public class Field59ETest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("59E", "Beneficiary name", "/12345678\nBeneficiary name");
    }

    @Test
    public void testParse_withAccount() {
        Field59E f = new Field59E("/12345678\nBeneficiary name");
        assertEquals("12345678", f.getComponent1());
        assertEquals("Beneficiary name", f.getComponent2());
    }

    @Test
    public void testParse_nameOnly() {
        Field59E f = new Field59E("Beneficiary name");
        assertNull(f.getComponent1());
        assertEquals("Beneficiary name", f.getComponent2());
    }
}

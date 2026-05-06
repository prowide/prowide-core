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
 * Tests for Field95Z introduced in SRU2026.
 * Pattern: :4!c//&lt;CC&gt;/35x$35x[$35x]0-3 — qualifier + country code + town name + name/address (up to 4 lines).
 */
public class Field95ZTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("95Z", ":OWND//US/NEW YORK\nACME CORP\n123 BROADWAY");
    }

    @Test
    public void testParse() {
        Field95Z f = new Field95Z(":OWND//US/NEW YORK\nACME CORP\n123 BROADWAY");
        assertEquals("OWND", f.getComponent1());
        assertEquals("US", f.getComponent2());
        assertEquals("NEW YORK", f.getComponent3());
        assertEquals("ACME CORP", f.getComponent4());
        assertEquals("123 BROADWAY", f.getComponent5());
    }

    @Test
    public void testParse_minimal() {
        Field95Z f = new Field95Z(":OWND//US/NEW YORK\nACME CORP");
        assertEquals("OWND", f.getComponent1());
        assertEquals("US", f.getComponent2());
        assertEquals("NEW YORK", f.getComponent3());
        assertEquals("ACME CORP", f.getComponent4());
    }
}

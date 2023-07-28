/*
 * Copyright 2006-2023 Prowide
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class Field22CTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("22C", "AAAABB122C4CCCCDD", "CNFM2L0007GEBABB");
    }

    @Test
    public void testParse22C() {
        Field22C f;

        f = new Field22C((String) null);
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());

        f = new Field22C("");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());

        f = new Field22C("AAAA");
        assertEquals("AAAA", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());

        f = new Field22C("AAAABB");
        assertEquals("AAAA", f.getComponent1());
        assertEquals("BB", f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());

        f = new Field22C("AAAABB1234");
        assertEquals("AAAA", f.getComponent1());
        assertEquals("BB", f.getComponent2());
        assertEquals("1234", f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());

        f = new Field22C("AAAABB1234CCCC");
        assertEquals("AAAA", f.getComponent1());
        assertEquals("BB", f.getComponent2());
        assertEquals("1234", f.getComponent3());
        assertEquals("CCCC", f.getComponent4());
        assertNull(f.getComponent5());

        f = new Field22C("AAAABB1234CCCCDD");
        assertEquals("AAAA", f.getComponent1());
        assertEquals("BB", f.getComponent2());
        assertEquals("1234", f.getComponent3());
        assertEquals("CCCC", f.getComponent4());
        assertEquals("DD", f.getComponent5());
    }
}

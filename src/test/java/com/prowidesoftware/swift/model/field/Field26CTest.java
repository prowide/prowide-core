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

/**
 * Test for Field26C and similar fields.
 *
 * @since 6.4
 */
public class Field26CTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("26C", "A/B/CCCCCDDDDEEEE");
    }

    /**
     * [S]/S/5!a4!aS[//S]
     */
    @Test
    public void testField26C() {
        Field26C f = new Field26C((String) null);
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field26C("");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field26C("A");
        assertEquals("A", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field26C("A/");
        assertEquals("A", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field26C("A/B");
        assertEquals("A", f.getComponent1());
        assertEquals("B", f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field26C("A/B/C");
        assertEquals("A", f.getComponent1());
        assertEquals("B", f.getComponent2());
        assertEquals("C", f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field26C("A/B/CCCCC");
        assertEquals("A", f.getComponent1());
        assertEquals("B", f.getComponent2());
        assertEquals("CCCCC", f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field26C("A/B/CCCCCD");
        assertEquals("A", f.getComponent1());
        assertEquals("B", f.getComponent2());
        assertEquals("CCCCC", f.getComponent3());
        assertEquals("D", f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field26C("A/B/CCCCCDDDD");
        assertEquals("A", f.getComponent1());
        assertEquals("B", f.getComponent2());
        assertEquals("CCCCC", f.getComponent3());
        assertEquals("DDDD", f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field26C("A/B/CCCCCDDDDEEEE");
        assertEquals("A", f.getComponent1());
        assertEquals("B", f.getComponent2());
        assertEquals("CCCCC", f.getComponent3());
        assertEquals("DDDD", f.getComponent4());
        assertEquals("EEEE", f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field26C("A/B/CCCCCDDDDEEEE//FFFFFFFF");
        assertEquals("A", f.getComponent1());
        assertEquals("B", f.getComponent2());
        assertEquals("CCCCC", f.getComponent3());
        assertEquals("DDDD", f.getComponent4());
        assertEquals("EEEE", f.getComponent5());
        assertEquals("FFFFFFFF", f.getComponent6());
    }

    /**
     * [S]/S/5!a4!aS[//S]
     */
    @Test
    public void testField26C_DenominationForm() {

        Field26C f = new Field26C("A/B/CCCCCDDDDEEEE//FFFFFFFF");
        assertEquals("EEEE", f.getComponent5());
        assertEquals("FFFFFFFF", f.getComponent6());

        f = new Field26C("A/B/CCCCCDDDD//FFFFFFFF");
        assertNull(f.getComponent5());
        assertEquals("FFFFFFFF", f.getComponent6());

        f = new Field26C("A/B/CCCCCDDDD");
        f.setDenomination("EEEE");
        f.setForm("FFFFFFFF");
        assertEquals("EEEE", f.getComponent5());
        assertEquals("FFFFFFFF", f.getComponent6());
    }
}

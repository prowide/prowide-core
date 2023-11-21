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
 * Test for Field29O and similar fields.
 *
 * @since 9.4.13
 */
public class Field29OTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("29O", "ABCD/10231045");
    }

    /**
     * 4!c/<HHMM><HHMM>
     */
    @Test
    public void testField29O() {
        Field29O f = new Field29O((String) null);
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field29O("");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field29O("A");
        assertEquals("A", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field29O("XCVB/");
        assertEquals("XCVB", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field29O("XCVB/12");
        assertEquals("XCVB", f.getComponent1());
        assertEquals("12", f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field29O("XCVB/1212");
        assertEquals("XCVB", f.getComponent1());
        assertEquals("1212", f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field29O("XCVB/121210");
        assertEquals("XCVB", f.getComponent1());
        assertEquals("1212", f.getComponent2());
        assertEquals("10", f.getComponent3());

        f = new Field29O("XCVB/12121011");
        assertEquals("XCVB", f.getComponent1());
        assertEquals("1212", f.getComponent2());
        assertEquals("1011", f.getComponent3());

        f = new Field29O("XCVB/1212101122");
        assertEquals("XCVB", f.getComponent1());
        assertEquals("1212", f.getComponent2());
        assertEquals("101122", f.getComponent3());
    }
}

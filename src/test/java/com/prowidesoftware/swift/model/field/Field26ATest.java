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

public class Field26ATest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl(
                "26A",
                "AAAABBBBCCCCDDDD/FFFF",
                "68364118512/8516",
                "68364119321/9330",
                "68489165771/5775",
                "68489166203/6212",
                "68371148100/8104",
                "68371148100");
    }

    /**
     * S[/S]
     */
    @Test
    public void testField26A() {

        Field26A f = new Field26A((String) null);
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("", f.getValue());

        f = new Field26A("");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("", f.getValue());

        f = new Field26A("AAAABBBBCCCCDDDD");
        assertEquals("AAAABBBBCCCCDDDD", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("AAAABBBBCCCCDDDD", f.getValue());

        f = new Field26A("AAAABBBBCCCCDDDD/");
        assertEquals("AAAABBBBCCCCDDDD", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("AAAABBBBCCCCDDDD", f.getValue());

        f = new Field26A("AAAABBBBCCCCDDDD/EEEE");
        assertEquals("AAAABBBBCCCCDDDD", f.getComponent1());
        assertEquals("EEEE", f.getComponent2());
        assertEquals("AAAABBBBCCCCDDDD/EEEE", f.getValue());

        f = new Field26A("AAAABBBBCCCC");
        assertEquals("AAAABBBBCCCC", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("AAAABBBBCCCC", f.getValue());

        f = new Field26A("AAAABBBBCCCC/EEEE");
        assertEquals("AAAABBBBCCCC", f.getComponent1());
        assertEquals("EEEE", f.getComponent2());
        assertEquals("AAAABBBBCCCC/EEEE", f.getValue());

        f = new Field26A("/EEEE");
        assertNull(f.getComponent1());
        assertEquals("EEEE", f.getComponent2());
        assertEquals("/EEEE", f.getValue());
    }

    /**
     * S[/S]
     */
    @Test
    public void testField26A_Number() {

        Field26A f = new Field26A("68371148100/8104");
        assertEquals("68371148100", f.getComponent1());
        assertEquals("8104", f.getComponent2());
        assertEquals("68371148100/8104", f.getValue());

        f = new Field26A("68371148100");
        assertEquals("68371148100", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("68371148100", f.getValue());
    }
}

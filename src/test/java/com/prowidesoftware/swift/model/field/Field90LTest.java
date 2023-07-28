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

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class Field90LTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("90L", ":MAXP//235,06", ":OFFR//N3,");
    }

    @Test
    public void testField90LString() {
        Field90L f;

        f = new Field90L("");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field90L(":");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field90L(":MAXP");
        assertEquals("MAXP", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field90L(":MAXP//");
        assertEquals("MAXP", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field90L(":MAXP//123,");
        assertEquals("MAXP", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("123,", f.getComponent3());

        f = new Field90L(":MAXP//N123,");
        assertEquals("MAXP", f.getComponent1());
        assertEquals("N", f.getComponent2());
        assertEquals("123,", f.getComponent3());
    }

    @Test
    public void testGetters() {
        Field90L f = new Field90L(":MAXP//235,06");
        assertNull(f.getSign());
        assertEquals("235,06", f.getIndexPoints());
        assertEquals(new BigDecimal("235.06"), f.getIndexPointsAsBigDecimal());

        f = new Field90L(":OFFR//N3,");
        assertEquals("N", f.getSign());
        assertEquals("3,", f.getIndexPoints());
        assertEquals(new BigDecimal("3"), f.getIndexPointsAsBigDecimal());
    }
}

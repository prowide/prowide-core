/*
 * Copyright 2006-2021 Prowide
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

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Field34FTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("34F",
                "aaab123,45"
        );
    }

    @Test
    public void testField19AString() {
        Field34F f;

        f = new Field34F((String) null);
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field34F("");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field34F("a");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field34F("aa");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field34F("aaa");
        assertEquals("aaa", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field34F("aaab");
        assertEquals("aaa", f.getComponent1());
        assertEquals("b", f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field34F("aaabb");
        assertEquals("aaa", f.getComponent1());
        assertEquals("bb", f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field34F("aaabb1");
        assertEquals("aaa", f.getComponent1());
        assertEquals("bb", f.getComponent2());
        assertEquals("1", f.getComponent3());

        f = new Field34F("aaab1");
        assertEquals("aaa", f.getComponent1());
        assertEquals("b", f.getComponent2());
        assertEquals("1", f.getComponent3());

        f = new Field34F("aaab1x");
        assertEquals("aaa", f.getComponent1());
        assertEquals("b", f.getComponent2());
        assertEquals("1x", f.getComponent3());

        f = new Field34F("aaab123");
        assertEquals("aaa", f.getComponent1());
        assertEquals("b", f.getComponent2());
        assertEquals("123", f.getComponent3());
        assertEquals(new BigDecimal("123"), f.getComponent3AsBigDecimal());

        f = new Field34F("aaab123,");
        assertEquals("aaa", f.getComponent1());
        assertEquals("b", f.getComponent2());
        assertEquals("123,", f.getComponent3());
        assertEquals(new BigDecimal("123"), f.getComponent3AsBigDecimal());

        f = new Field34F("aaab123,45");
        assertEquals("aaa", f.getComponent1());
        assertEquals("b", f.getComponent2());
        assertEquals("123,45", f.getComponent3());
        assertEquals(new BigDecimal("123.45"), f.getComponent3AsBigDecimal());
    }

}
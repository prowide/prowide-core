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

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class Field37HTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("37H", "D9,75", "DN123");
    }

    @Test
    public void testParse37H_1() {
        Field37H f = new Field37H("D123");
        assertNotNull(f, "Parse of field failed");
        assertEquals("D", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("123", f.getComponent(3));
    }

    @Test
    public void testParse37H_2() {
        Field37H f = new Field37H("DN123");
        assertNotNull(f, "Parse of field failed");
        assertEquals("D", f.getComponent1());
        assertEquals("N", f.getComponent2());
        assertEquals("123", f.getComponent(3));
    }

    @Test
    public void testParse37H_3() {
        Field37H f = new Field37H("HelloWorld123");
        assertNotNull(f, "Parse of field failed");
        assertEquals("HelloWorl", f.getComponent1());
        assertEquals("d", f.getComponent2());
        assertEquals("123", f.getComponent(3));
    }

    @Test
    public void testParse37H_4() {
        Field37H f = new Field37H("DN");
        assertNotNull(f, "Parse of field failed");
        assertEquals("D", f.getComponent1());
        assertEquals("N", f.getComponent2());
        assertNull(f.getComponent(3));
    }

    @Test
    public void testParse37H_5() {
        Field37H f = new Field37H("HelloWorld");
        assertNotNull(f, "Parse of field failed");
        assertEquals("HelloWorl", f.getComponent1());
        assertEquals("d", f.getComponent2());
        assertNull(f.getComponent(3));
    }

    @Test
    public void testParse37H_6() {
        Field37H f = new Field37H("D9,75");
        assertNotNull(f, "Parse of field failed");
        assertEquals("D", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("9,75", f.getComponent(3));
    }

    @Test
    public void testFromMt935() {
        Field37H f = new Field37H("D9,75\n");
        assertEquals("D", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals(new BigDecimal("9.75"), f.getComponentAs(3, Number.class));
    }
}

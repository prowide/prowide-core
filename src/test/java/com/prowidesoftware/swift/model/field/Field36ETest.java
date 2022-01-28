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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;


public class Field36ETest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("36E",
                ":1234//ABCD/c123",
                ":1234//ABCD/123"
        );
    }

    @Test
    public void testParse() {
        Field36E f = null;

        f = new Field36E((String) null);
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field36E("");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field36E("1234");
        assertEquals("1234", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field36E(":1234");
        assertEquals("1234", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field36E(":1234//ABCD");
        assertEquals("1234", f.getComponent1());
        assertEquals("ABCD", f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field36E(":1234//ABCD/");
        assertEquals("1234", f.getComponent1());
        assertEquals("ABCD", f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field36E(":1234//ABCD/123");
        assertEquals("1234", f.getComponent1());
        assertEquals("ABCD", f.getComponent2());
        assertNull(f.getComponent3());
        assertEquals("123", f.getComponent4());

        f = new Field36E(":1234//ABCD/c123");
        assertEquals("1234", f.getComponent1());
        assertEquals("ABCD", f.getComponent2());
        assertEquals("c", f.getComponent3());
        assertEquals("123", f.getComponent4());
    }

}
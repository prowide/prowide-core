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

public class Field23Test extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("23", "abcd/efgh/ijk/USD//aaa");
    }

    @Test
    public void testParse23() {
        Field23 f;

        f = new Field23((String) null);
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field23("");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field23("abcd");
        assertEquals("abcd", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field23("abcd/");
        assertEquals("abcd", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field23("abcd/efgh");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field23("abcd/efgh/");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field23("abcd/efgh/ijk");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertEquals("ijk", f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field23("abcd/efgh/ijk/");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertEquals("ijk", f.getComponent3());
        assertNull(f.getComponent4());

        f = new Field23("abcd/efgh/ijk/USD");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertEquals("ijk", f.getComponent3());
        assertEquals("USD", f.getComponent4());

        f = new Field23("abcd/efgh/ijk/USD/");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertEquals("ijk", f.getComponent3());
        assertEquals("USD/", f.getComponent4());

        f = new Field23("abcd/efgh/ijk/USD//");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertEquals("ijk", f.getComponent3());
        assertEquals("USD//", f.getComponent4());

        f = new Field23("abcd/efgh/ijk/USD//aaa");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertEquals("ijk", f.getComponent3());
        assertEquals("USD//aaa", f.getComponent4());
    }

    @Test
    public void testParse23_WithMissingParts() {
        Field23 f;

        f = new Field23("abcd/efgh/ijkl/mnop");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertEquals("ijkl", f.getComponent3());
        assertEquals("mnop", f.getComponent4());
        assertEquals("abcd/efgh/ijkl/mnop", f.getValue());

        f = new Field23("/efgh/ijkl/mnop");
        assertNull(f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertEquals("ijkl", f.getComponent3());
        assertEquals("mnop", f.getComponent4());
        assertEquals("/efgh/ijkl/mnop", f.getValue());

        f = new Field23("abcd//ijkl/mnop");
        assertEquals("abcd", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("ijkl", f.getComponent3());
        assertEquals("mnop", f.getComponent4());
        assertEquals("abcd//ijkl/mnop", f.getValue());

        f = new Field23("abcd/efgh//mnop");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertNull(f.getComponent3());
        assertEquals("mnop", f.getComponent4());
        assertEquals("abcd/efgh//mnop", f.getValue());

        f = new Field23("abcd///mnop");
        assertEquals("abcd", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertEquals("mnop", f.getComponent4());
        assertEquals("abcd///mnop", f.getValue());

        f = new Field23("abcd/efgh/ijkl/");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertEquals("ijkl", f.getComponent3());
        assertNull(f.getComponent4());
        assertEquals("abcd/efgh/ijkl", f.getValue());

        f = new Field23("abcd/efgh/ijkl");
        assertEquals("abcd", f.getComponent1());
        assertEquals("efgh", f.getComponent2());
        assertEquals("ijkl", f.getComponent3());
        assertNull(f.getComponent4());
        assertEquals("abcd/efgh/ijkl", f.getValue());
    }
}

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

import org.junit.jupiter.api.Test;

public class Field70Test extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("70", "a\nb\nc\nd");
    }

    @Test
    public void testField70() {
        Field70 f = new Field70((String) null);
        assertNull(f.getComponent1());

        f = new Field70("a");
        assertEquals("a", f.getComponent1());

        f = new Field70("a\nb");
        assertEquals("a", f.getLine(1));
        assertEquals("b", f.getLine(2));
        assertNull(f.getLine(3));
        assertNull(f.getLine(4));

        f = new Field70("a\nb\nc");
        Narrative n = f.narrative();
        assertTrue(n.getStructured().isEmpty());
        assertEquals(3, n.getUnstructuredFragments().size());
        assertEquals("a", n.getUnstructuredFragments().get(0));
        assertEquals("b", n.getUnstructuredFragments().get(1));
        assertEquals("c", n.getUnstructuredFragments().get(2));
    }
}

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

public class Field77HTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("77H", "ISDA/20200310//2021");
    }

    @Test
    public void testField77H() {

        Field77H f = new Field77H((String) null);
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field77H("ISDA");
        assertEquals("ISDA", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field77H("ISDA//2021");
        assertEquals("ISDA", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("2021", f.getComponent3());

        f = new Field77H("ISDA/20200310");
        assertEquals("ISDA", f.getComponent1());
        assertEquals("20200310", f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field77H("ISDA/20200310//2021");
        assertEquals("ISDA", f.getComponent1());
        assertEquals("20200310", f.getComponent2());
        assertEquals("2021", f.getComponent3());

        f = new Field77H("/20200310//2021");
        assertNull(f.getComponent1());
        assertEquals("20200310", f.getComponent2());
        assertEquals("2021", f.getComponent3());
    }
}

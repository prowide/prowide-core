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

import org.junit.jupiter.api.Test;

public class Field94ETest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl(
                "94E",
                ":ISSU//foo bar",
                ":ISSU//foo bar\nsecond line\nthird line",
                ":ISSU//foo bar \n second line \n third line ");
    }

    @Test
    public void testParser1() {
        Field94E f = new Field94E(":ISSU//foo bar\nsecond line\nthird line");
        assertEquals("ISSU", f.getComponent1());
        assertEquals("foo bar", f.getComponent2());
        assertEquals("second line", f.getComponent3());
        assertEquals("third line", f.getComponent4());
        assertEquals("foo barsecond linethird line", f.getAddress());
    }

    @Test
    public void testParser2() {
        Field94E f = new Field94E(":ISSU//foo bar \nsecond line\n third line");
        assertEquals("ISSU", f.getComponent1());
        assertEquals("foo bar ", f.getComponent2());
        assertEquals("second line", f.getComponent3());
        assertEquals(" third line", f.getComponent4());
        assertEquals("foo bar second line third line", f.getAddress());
    }
}

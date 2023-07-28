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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Field49ATest extends AbstractFieldTest {
    Field49A f = null;

    @BeforeEach
    public void setup() {
        f = null;
    }

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("49A", "123", "123\nFOO", "123\nFOO\nBAR");
    }

    @Test
    public void testParse() {
        f = new Field49A("123\nFOO\nBAR");
        f.setComponent1("1234");
        f.setComponent2("FOO\nBAR");
    }

    @Test
    public void testGetValue() {
        f = new Field49A();
        f.setComponent1("1234");
        f.setComponent2("FOO\nBAR");
        assertEquals("1234\r\nFOO\nBAR", f.getValue());
    }
}

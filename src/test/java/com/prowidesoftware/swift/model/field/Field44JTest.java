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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Field44JTest extends AbstractFieldTest {
    Field44J f = null;

    @BeforeEach
    public void setup() {
        f = null;
    }

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("44J", "US/FOOBAR\r\n/HELLO WORLD");
    }

    @Test
    public void testParse1() {
        f = new Field44J("NL");
        assertEquals("NL", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
    }

    @Test
    public void testParse2() {
        f = new Field44J("NL/foo bar");
        assertEquals("NL", f.getComponent1());
        assertEquals("foo bar", f.getComponent2());
        assertNull(f.getComponent3());
    }

    @Test
    public void testParse3() {
        f = new Field44J("NL/foo bar\n/Hello world");
        assertEquals("NL", f.getComponent1());
        assertEquals("foo bar", f.getComponent2());
        // parse preserves the slash on purpose to enable validation of its presence
        assertEquals("/Hello world", f.getComponent3());
    }

    @Test
    public void testGetValue() {
        f = new Field44J("NL/foo bar\n/Hello world");
        assertEquals("NL/foo bar\r\n/Hello world", f.getValue());
    }

    @Test
    public void testGetValue2() {
        f = new Field44J("NL/foo bar");
        assertEquals("NL/foo bar", f.getValue());
    }

    @Test
    public void testGetValue3() {
        f = new Field44J("NL");
        assertEquals("NL", f.getValue());
    }
}

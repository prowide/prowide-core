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

public class Field31FTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("31F",
                "a\nb\nc\nd"
        );
    }

    @Test
    public void testField31F() {

        Field31F f = new Field31F((String) null);
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field31F("131223");
        assertEquals("131223", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field31F("131223//OSAKA WEEKEND");
        assertEquals("131223", f.getComponent1());
        assertNull(f.getComponent2());
        assertEquals("OSAKA WEEKEND", f.getComponent3());

        f = new Field31F("131223/131228");
        assertEquals("131223", f.getComponent1());
        assertEquals("131228", f.getComponent2());
        assertNull(f.getComponent3());

        f = new Field31F("131223/131228//OSAKA WEEKEND");
        assertEquals("131223", f.getComponent1());
        assertEquals("131228", f.getComponent2());
        assertEquals("OSAKA WEEKEND", f.getComponent3());

        f = new Field31F("/131228//OSAKA WEEKEND");
        assertNull(f.getComponent1());
        assertEquals("131228", f.getComponent2());
        assertEquals("OSAKA WEEKEND", f.getComponent3());
    }

}
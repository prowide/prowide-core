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


public class Field94DTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("94D",
                ":AAAA//BB/C",
                ":AAAA///C"
        );
    }

    @Test
    public void test1() {
        Field94D f = new Field94D(":AAAA//BB/C");
        assertEquals(f.getComponent1(), "AAAA");
        assertEquals(f.getComponent2(), "BB");
        assertEquals(f.getComponent3(), "C");
    }

    @Test
    public void test2() {
        Field94D f = new Field94D(":AAAA///C");
        assertEquals(f.getComponent1(), "AAAA");
        assertNull(f.getComponent2());
        assertEquals(f.getComponent3(), "C");
    }

}
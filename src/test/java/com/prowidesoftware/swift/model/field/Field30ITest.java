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

/**
 * Test for Field30I and similar fields.
 *
 * @since 9.4.13
 */
class Field30ITest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("30I", "20231027", "20231027/20240426");
    }

    /**
     * S[/S]
     */
    @Test
    void testField30I() {
        Field30I f = new Field30I((String) null);
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());

        f = new Field30I("");
        assertNull(f.getComponent1());
        assertNull(f.getComponent2());

        f = new Field30I("2023");
        assertEquals("2023", f.getComponent1());
        assertNull(f.getComponent2());

        f = new Field30I("20231027");
        assertEquals("20231027", f.getComponent1());
        assertNull(f.getComponent2());

        f = new Field30I("2023102711");
        assertEquals("2023102711", f.getComponent1());
        assertNull(f.getComponent2());

        f = new Field30I("20231027/");
        assertEquals("20231027", f.getComponent1());
        assertNull(f.getComponent2());

        f = new Field30I("20231027/12");
        assertEquals("20231027", f.getComponent1());
        assertEquals("12", f.getComponent2());

        f = new Field30I("20231027/20240426");
        assertEquals("20231027", f.getComponent1());
        assertEquals("20240426", f.getComponent2());

        f = new Field30I("20231027/2023102712");
        assertEquals("20231027", f.getComponent1());
        assertEquals("2023102712", f.getComponent2());

        f = new Field30I("2023102711/2023102712");
        assertEquals("2023102711", f.getComponent1());
        assertEquals("2023102712", f.getComponent2());
    }
}

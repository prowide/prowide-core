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

public class Field57DTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("57D", "//\nBIODATA LIMITED\nLONDON WC1 23H\nUNITED KINGDOM", "//");
    }

    @Test
    public void testEmptyPartyField() {
        Field57D f = new Field57D("//");
        assertNull(f.getComponent1());
        assertNotNull(f.getComponent2());
        assertEquals("/", f.getComponent2());
        assertEquals("", f.getAccount());
    }
}

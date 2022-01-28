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

import org.junit.jupiter.api.Test;


public class Field50HTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("50H",
                "/0000001111000000\r\nBNPPARIBAS\r\n66 VICTOIRE\r\nPARIS"
        );
    }

    @Test
    public void testGetValue() {
        Field50H f = new Field50H("/0000001111000000\r\nBNPPARIBAS\r\n66 VICTOIRE\r\nPARIS\r\n");
        assertEquals(f.getComponent1(), "0000001111000000");
        assertEquals(f.getComponent2(), "BNPPARIBAS");
        assertEquals(f.getComponent3(), "66 VICTOIRE");
        assertEquals(f.getComponent4(), "PARIS");
    }

}
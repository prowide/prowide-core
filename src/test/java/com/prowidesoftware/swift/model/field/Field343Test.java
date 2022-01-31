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
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Test for Field343 and similar fields.
 *
 * @author sebastian
 * @since 7.8.8
 */
public class Field343Test extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("343",
                "101 202 103 202"
        );
    }

    @Test
    public void testParse343() {
        Field343 f = new Field343("1");
        assertNotNull(f, "Parse of field failed");
        assertEquals("1", f.getComponent1());
        f = new Field343("101");
        assertNotNull(f, "Parse of field failed");
        assertEquals("101", f.getComponent1());
        f = new Field343("101 202 103");
        assertNotNull(f, "Parse of field failed");
        assertEquals("101", f.getComponent1());
        assertEquals("202", f.getComponent2());
        assertEquals("103", f.getComponent3());
    }

}
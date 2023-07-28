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
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Test for Field252 and similar fields.
 *
 * @since 7.8.8
 */
public class Field252Test extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("252", "MIR4567890123456789012345ENDMIR4567890123456789012345END11112222");
    }

    @Test
    public void testParse252() {
        Field252 f = new Field252("MIR4567890123456789012345ENDMIR4567890123456789012345END11112222");
        assertNotNull(f, "Parse of field failed");
        assertEquals("MIR4567890123456789012345END", f.getComponent1());
        assertEquals("MIR4567890123456789012345END", f.getComponent2());
        assertEquals("1111", f.getComponent3());
        assertEquals("2222", f.getComponent4());
    }
}

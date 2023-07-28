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

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class Field19Test extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("19", "12345,");
    }

    @Test
    public void testParse19() {
        Field19 f;

        f = new Field19("12345");
        assertNotNull(f, "Parse of correct field failed");
        assertEquals(new BigDecimal("12345"), f.getComponent1AsBigDecimal());

        f = new Field19("12345,12");
        assertNotNull(f, "Parse of correct field failed");
        assertEquals("12345,12", f.getComponent1());
        assertEquals(new BigDecimal("12345.12"), f.getComponent1AsBigDecimal());

        f = new Field19("12345,");
        assertNotNull(f, "Parse of correct field failed");
        assertEquals(new BigDecimal("12345"), f.getComponent1AsBigDecimal());
    }
}

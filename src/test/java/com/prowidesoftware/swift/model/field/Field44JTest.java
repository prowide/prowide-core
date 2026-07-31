/*
 * Copyright 20062026 Prowide
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
        testSerializationImpl("44J", "US/FOOBAR");
    }

    @Test
    public void testParse1() {
        f = new Field44J("NL");
        assertEquals("NL", f.getComponent1());
        assertNull(f.getComponent2());
    }

    @Test
    public void testParse2() {
        f = new Field44J("NL/foo bar");
        assertEquals("NL", f.getComponent1());
        assertEquals("foo bar", f.getComponent2());
    }

    @Test
    public void testGetValue() {
        f = new Field44J("NL/foo bar\n/Hello world");
        assertEquals("NL/foo bar\r\n/Hello world", f.getValue());
    }

    @Test
    public void testGetValueFromSetters() {
        f = new Field44J();
        f.setCountryCode("US");
        f.setCountrySubDivision("NY");
        f.setNarrative("narrative");
        // the mandatory starting slash in the narrative line is added when missing
        assertEquals("US/NY\r\n/narrative", f.getValue());
    }

    @Test
    public void testGetValueFromSettersNarrativeWithSlash() {
        f = new Field44J();
        f.setCountryCode("US");
        f.setCountrySubDivision("NY");
        f.setNarrative("/narrative");
        assertEquals("US/NY\r\n/narrative", f.getValue());
    }

    @Test
    public void testGetValueFromSettersWithoutSubDivision() {
        f = new Field44J();
        f.setCountryCode("US");
        f.setNarrative("narrative");
        assertEquals("US\r\n/narrative", f.getValue());
    }

    @Test
    public void testGetValue2() {
        f = new Field44J("NL/foo bar");
        assertEquals("NL/foo bar", f.getValue());
    }

    @Test
    public void testGetValue2() {
        f = new Field44J("NL");
        assertEquals("NL", f.getValue());
    }
}

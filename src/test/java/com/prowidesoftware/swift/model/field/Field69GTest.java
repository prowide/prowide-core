/*
 * Copyright 2006-2026 Prowide
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

/**
 * Tests for Field69G introduced in SRU2026 (MT 564).
 * Pattern: :4!c//&lt;DATE4&gt;&lt;TIME2&gt;/[3n][/[N]&lt;TIME3&gt;]&lt;DATE4&gt;&lt;TIME2&gt;/[/3n][/[N]&lt;TIME3&gt;]
 */
public class Field69GTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl(
                "69G",
                ":TRDP//20260101120000/20260102120000/",
                ":TRDP//20260101120000/50020260102120000//250",
                ":TRDP//20260101120000/500/N123020260102120000//250/N0100");
    }

    @Test
    public void testParse_simple() {
        Field69G f = new Field69G(":TRDP//20260101120000/20260102120000/");
        assertEquals("TRDP", f.getComponent1());
        assertEquals("20260101", f.getComponent2());
        assertEquals("120000", f.getComponent3());
        assertEquals("20260102", f.getComponent7());
        assertEquals("120000", f.getComponent8());
    }

    @Test
    public void testParse_withDecimals() {
        Field69G f = new Field69G(":TRDP//20260101120000/50020260102120000//250");
        assertEquals("TRDP", f.getComponent1());
        assertEquals("500", f.getComponent4());
        assertEquals("250", f.getComponent9());
    }
}

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

public class Field259Test extends AbstractFieldTest {

    /**
     * <cat-output-type>
     * <lt-identifier> 4!a2!a2!c1!c
     * <branch-code> 3!c
     * <session-number> 4!n
     * <msg-category> 1!n
     * <date> 6!n
     * <time-range> 4!n4!n
     * <p>
     * Ejemplos:
     * VNDZBET2AXXX 0025 9 050823 1548 1552
     */
    private static final String EXAMPLE1_FIELD_259 = "VNDZBET2AXXX0025905082315481552";

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("259", EXAMPLE1_FIELD_259);
    }

    @Test
    public void testParse259Ex1() {
        Field259 f = new Field259(EXAMPLE1_FIELD_259);
        assertNotNull(f, "Parse of field failed");

        assertEquals("VNDZBET2AXXX", f.getComponent1());
        assertEquals("0025", f.getComponent2());
        assertEquals("9", f.getComponent3());
        assertEquals("050823", f.getComponent4());
        assertEquals("1548", f.getComponent5());
        assertEquals("1552", f.getComponent6());
    }

    @Test
    public void testParse259Partial() {
        Field259 f = new Field259("AAAAAAAAAAAA");
        assertEquals("AAAAAAAAAAAA", f.getComponent1());
        assertNull(f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field259("AAAAAAAAAAAA1234");
        assertEquals("AAAAAAAAAAAA", f.getComponent1());
        assertEquals("1234", f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field259("AAAAAAAAAAAA12341");
        assertEquals("AAAAAAAAAAAA", f.getComponent1());
        assertEquals("1234", f.getComponent2());
        assertEquals("1", f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field259("AAAAAAAAAAAA12341123456");
        assertEquals("AAAAAAAAAAAA", f.getComponent1());
        assertEquals("1234", f.getComponent2());
        assertEquals("1", f.getComponent3());
        assertEquals("123456", f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field259("AAAAAAAAAAAA123411234561234");
        assertEquals("AAAAAAAAAAAA", f.getComponent1());
        assertEquals("1234", f.getComponent2());
        assertEquals("1", f.getComponent3());
        assertEquals("123456", f.getComponent4());
        assertEquals("1234", f.getComponent5());
        assertNull(f.getComponent6());

        f = new Field259("AAAAAAAAAAAA1234112345612349999999999");
        assertEquals("AAAAAAAAAAAA", f.getComponent1());
        assertEquals("1234", f.getComponent2());
        assertEquals("1", f.getComponent3());
        assertEquals("123456", f.getComponent4());
        assertEquals("1234", f.getComponent5());
        assertEquals("9999999999", f.getComponent6());
    }

    @Test
    public void testGetValue1() {
        Field259 f = new Field259(EXAMPLE1_FIELD_259);
        assertEquals(EXAMPLE1_FIELD_259, f.getValue());
    }
}

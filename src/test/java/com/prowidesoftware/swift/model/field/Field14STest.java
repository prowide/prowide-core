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
 * Test for Field14S and similar fields.
 *
 * @since 6.0
 */
public class Field14STest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("14S", "EMT00", "CHF01/1400/GBLO", "GBP01/1000/USNY");
    }

    @Test
    public void testField14SRateSource() {

        Field14S f;

        f = new Field14S("EMT00");
        assertEquals("EMT", f.getComponent1());
        assertEquals("00", f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertEquals("EMT00", f.getRateSource());
        f.setRateSource("CHF01");
        assertEquals("CHF01", f.getRateSource());
        assertEquals("CHF", f.getComponent1());
        assertEquals("01", f.getComponent2());

        f = new Field14S("CHF01/1400/GBLO");
        assertEquals("CHF", f.getComponent1());
        assertEquals("01", f.getComponent2());
        assertEquals("1400", f.getComponent3());
        assertEquals("GBLO", f.getComponent4());
        assertEquals("CHF01", f.getRateSource());
    }

    @Test
    public void testField14STimeAndLocation() {

        Field14S f;

        f = new Field14S("EMT00");
        assertEquals("EMT", f.getComponent1());
        assertEquals("00", f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getTimeAndLocation());
        f.setTimeAndLocation("1400/GBLO");
        assertEquals("/1400/GBLO", f.getTimeAndLocation());
        assertEquals("1400", f.getComponent3());
        assertEquals("GBLO", f.getComponent4());

        f = new Field14S("CHF01/1400/GBLO");
        assertEquals("CHF", f.getComponent1());
        assertEquals("01", f.getComponent2());
        assertEquals("1400", f.getComponent3());
        assertEquals("GBLO", f.getComponent4());
        assertEquals("/1400/GBLO", f.getTimeAndLocation());
        f.setTimeAndLocation("/1000/USNY");
        assertEquals("/1000/USNY", f.getTimeAndLocation());
        assertEquals("1000", f.getComponent3());
        assertEquals("USNY", f.getComponent4());
    }
}

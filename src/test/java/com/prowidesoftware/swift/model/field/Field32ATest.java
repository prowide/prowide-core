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

import java.math.BigDecimal;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

public class Field32ATest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("32A", "010203USD123", "081001USD30625,00");
    }

    @Test
    public void testParse32A() {
        Field32A f = new Field32A("010203USD123");
        assertNotNull(f, "Parse of field failed");
        assertEquals(2001, f.getComponent1AsCalendar().get(Calendar.YEAR));
        assertEquals(1, f.getComponent1AsCalendar().get(Calendar.MONTH));
        assertEquals(3, f.getComponent1AsCalendar().get(Calendar.DATE));
        assertEquals("USD", f.getComponent2());
        assertEquals(new BigDecimal("123"), f.getComponent3AsBigDecimal());
        // 081001USD30625,00
    }

    @Test
    public void testParse32A_2() {
        Field32A f = new Field32A("010203USD123dss");
        assertNotNull(f, "Parse of field failed");
        assertNotNull(f.getComponent1AsCalendar(), "Parse of field date failed");
        assertEquals(2001, f.getComponent1AsCalendar().get(Calendar.YEAR));
        assertEquals(Calendar.FEBRUARY, f.getComponent1AsCalendar().get(Calendar.MONTH));
        assertEquals(3, f.getComponent1AsCalendar().get(Calendar.DAY_OF_MONTH));
        assertEquals("USD", f.getComponent2());
        assertEquals("123dss", f.getComponent3());
        assertEquals(new BigDecimal("123"), f.getComponent3AsBigDecimal());
    }

    @Test
    public void testParse32A_3() {
        Field32A f = new Field32A("999999USD123");
        assertNotNull(f, "Parse of field failed");
        assertNull(f.getComponent1AsCalendar());
        assertEquals("USD", f.getComponent2());
        assertEquals(new BigDecimal("123"), f.getComponent3AsBigDecimal());
    }

    @Test
    public void testParse32A_4() {
        Field32A f = new Field32A("081001USD30625,");
        assertNotNull(f, "Parse of field failed");
        assertNotNull(f.getComponent1AsCalendar());
        assertEquals("USD", f.getComponent2());
        assertEquals(new BigDecimal("30625"), f.getComponent3AsBigDecimal());

        f = new Field32A("081001USD30625,00");
        assertNotNull(f, "Parse of field failed");
        assertNotNull(f.getComponent1AsCalendar());
        assertEquals("USD", f.getComponent2());
        assertEquals(new BigDecimal("30625.00"), f.getComponent3AsBigDecimal());
    }

    @Test
    public void testParse32A_Amount() {
        Field32A f = new Field32A("081001USD30625,00");
        assertNotNull(f, "Parse of field failed");
        assertEquals("USD", f.getComponent2());
        assertEquals(new BigDecimal("30625.00"), f.getComponent3AsBigDecimal());
    }

    @Test
    public void testParse32A_Amount_2() {
        Field32A f = new Field32A("081001USD30625,67");
        assertNotNull(f, "Parse of field failed");
        assertEquals("USD", f.getComponent2());
        assertEquals(new BigDecimal("30625.67"), f.getComponent3AsBigDecimal());
    }

    @Test
    public void testTicket32() {
        Field32A f = new Field32A("070813GBP,");
        assertEquals(null, f.getAmount());
    }

    @Test
    public void testTicketAmountSize() {
        Field32A f = new Field32A("051028EUR1765432,");
        assertNotNull(f, "Parse of field failed");
        assertEquals("EUR", f.getComponent2());
        assertEquals(new BigDecimal("1765432"), f.getComponent3AsBigDecimal());
    }
}

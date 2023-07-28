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
package com.prowidesoftware.swift.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.prowidesoftware.swift.model.field.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

/**
 * Test cases for currency amount containers
 *
 * @since 8.0.1
 */
public class MoneyTest {

    @Test
    public void testMoneyFromField() {
        Money m = Money.of(new Field32A("121212USD1234,"));
        assertEquals("USD", m.getCurrency());
        assertEquals(new BigDecimal("1234"), m.getAmount());

        assertNull(Money.of(new Field20("FOO")));

        m = Money.of(new Field19A(":AAAA//EUR567,8"));
        assertEquals("EUR", m.getCurrency());
        assertEquals(new BigDecimal("567.8"), m.getAmount());

        m = Money.of(new Field19A(":AAAA//NEUR567,8"));
        assertEquals("EUR", m.getCurrency());
        assertEquals(new BigDecimal("-567.8"), m.getAmount());

        m = Money.of(new Field33B("ARS1,"));
        assertEquals("ARS", m.getCurrency());
        assertEquals(new BigDecimal("1"), m.getAmount());

        m = Money.of(new Field62F("121212USD1234,"));
        assertEquals("USD", m.getCurrency());
        assertEquals(new BigDecimal("1234"), m.getAmount());

        m = Money.of(new Field62F("D121212USD1234,"));
        assertEquals("USD", m.getCurrency());
        assertEquals(new BigDecimal("-1234"), m.getAmount());
    }

    @Test
    public void testMoneySum() {
        Money m = Money.ofSum(
                new Field32A("121212USD1000,1"), new Field33B("USD2000,1"), new Field62F("121212USD3000,1"));
        assertEquals("USD", m.getCurrency());
        assertEquals(new BigDecimal("6000.3"), m.getAmount());

        m = Money.ofSum(new Field32A("121212USD5000,1"), new Field33B("USD5000,1"), new Field62F("D121212USD3000,1"));
        assertEquals("USD", m.getCurrency());
        assertEquals(new BigDecimal("7000.1"), m.getAmount());
    }
}

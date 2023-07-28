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
import org.junit.jupiter.api.Test;

public class Field71BTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("71B", "/ACGH/B/EUR1,00Fees");
    }

    @Test
    public void testGetters() {
        Field71B f = new Field71B("/ACGH/O/EUR1,00Fees");

        assertEquals("/ACGH/O/EUR1,00Fees", f.getComponent1());

        Narrative n = f.narrative();
        // n.getStructured().forEach(System.out::println);

        StructuredNarrative structuredNarrative = n.getStructured("ACGH");
        assertEquals("ACGH", structuredNarrative.getCodeword());
        assertEquals(new BigDecimal("1.00"), structuredNarrative.getAmount());
        assertEquals("Fees", structuredNarrative.getNarrative());

        // In SCORE messages there is a bank code within the codeword with a slash separator
        // Our parser cannot handle that and lets the bank code as part of the currency component
        assertEquals("EUR", structuredNarrative.getCurrency());
        assertEquals("O", structuredNarrative.getBankCode());
    }

    @Test
    public void testGettersScore() {
        Field71B f = new Field71B("/ACGH/B/EUR1,00Fees");

        assertEquals("/ACGH/B/EUR1,00Fees", f.getComponent1());

        Narrative n = f.narrative();
        StructuredNarrative structuredNarrative = n.getStructured("ACGH");
        assertEquals("B", structuredNarrative.getBankCode());
        assertEquals("EUR", structuredNarrative.getCurrency());

        structuredNarrative.setCurrency("EUR/");
        assertEquals("EUR/", structuredNarrative.getCurrency());

        f = new Field71B("/ACGH/EUR1,00Fees");
        assertEquals("/ACGH/EUR1,00Fees", f.getComponent1());

        n = f.narrative();
        structuredNarrative = n.getStructured("ACGH");
        assertNull(structuredNarrative.getBankCode());
        assertEquals("EUR", structuredNarrative.getCurrency());

        structuredNarrative.setCurrency("EUR/");
        assertEquals("EUR/", structuredNarrative.getCurrency());
    }
}

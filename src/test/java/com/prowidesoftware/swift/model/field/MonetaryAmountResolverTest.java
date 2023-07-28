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

import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MonetaryAmountResolverTest {

    @Test
    public void testResolveField32A() {
        Field32A f = new Field32A("130901USD10");
        assertEquals(new BigDecimal(10), MonetaryAmountResolver.amount(f));

        f = new Field32A("130901USD10,");
        assertEquals(new BigDecimal(10), MonetaryAmountResolver.amount(f));

        f = new Field32A("130901USD10,1");
        assertEquals(new BigDecimal("10.1"), MonetaryAmountResolver.amount(f));
    }

    @Test
    public void testResolve32Q_multiple() {
        Field32Q f = new Field32Q("USD/EUR");

        // list of currencies
        final List<Currency> currencies = MonetaryAmountResolver.currencies(f);
        assertNotNull(currencies);
        assertEquals(2, currencies.size());
        assertEquals(SwiftFormatUtils.getCurrency("USD"), currencies.get(0));
        assertEquals(SwiftFormatUtils.getCurrency("EUR"), currencies.get(1));

        // list of currency strings
        final List<String> currencyStrings = MonetaryAmountResolver.currencyStrings(f);
        assertNotNull(currencyStrings);
        assertEquals(2, currencyStrings.size());
        assertEquals("USD", currencyStrings.get(0));
        assertEquals("EUR", currencyStrings.get(1));
    }
}

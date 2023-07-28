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
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CurrencyResolverTest {

    @Test
    public void testResolve32Q_multiple() {

        Field32Q field = new Field32Q("USD/EUR");

        // list of currencies
        final List<Currency> currencies = field.currencies();
        assertNotNull(currencies);
        assertEquals(2, currencies.size());
        assertEquals(SwiftFormatUtils.getCurrency("USD"), currencies.get(0));
        assertEquals(SwiftFormatUtils.getCurrency("EUR"), currencies.get(1));

        // list of currency strings
        final List<String> currencyStrings = field.currencyStrings();
        assertNotNull(currencyStrings);
        assertEquals(2, currencyStrings.size());
        assertEquals("USD", currencyStrings.get(0));
        assertEquals("EUR", currencyStrings.get(1));

        // first currency
        assertEquals(SwiftFormatUtils.getCurrency("USD"), field.currency());

        // first currency string
        assertEquals("USD", field.currencyString());

        // initialize currencies
        field.initializeCurrencies(SwiftFormatUtils.getCurrency("GBP"));
        assertEquals(SwiftFormatUtils.getCurrency("GBP"), field.getComponent1AsCurrency());
        assertEquals(SwiftFormatUtils.getCurrency("GBP"), field.getComponent2AsCurrency());

        // initialize currency string
        field.initializeCurrencies("CHF");
        assertEquals("CHF", field.getCurrency1());
        assertEquals("CHF", field.getCurrency2());
    }

    @Test
    public void testResolve32M_single() {

        Field32M field = new Field32M("USD123,45");

        // list of currencies
        final List<Currency> currencies = field.currencies();
        assertNotNull(currencies);
        assertEquals(1, currencies.size());
        assertEquals(SwiftFormatUtils.getCurrency("USD"), currencies.get(0));

        // list of currency strings
        final List<String> currencyStrings = field.currencyStrings();
        assertNotNull(currencyStrings);
        assertEquals(1, currencyStrings.size());
        assertEquals("USD", currencyStrings.get(0));

        // first currency
        assertEquals(SwiftFormatUtils.getCurrency("USD"), field.currency());

        // first currency string
        assertEquals("USD", field.currencyString());

        // initialize currencies
        field.initializeCurrencies(SwiftFormatUtils.getCurrency("GBP"));
        assertEquals(SwiftFormatUtils.getCurrency("GBP"), field.getComponent1AsCurrency());

        // initialize currency string
        field.initializeCurrencies("CHF");
        assertEquals("CHF", field.getComponent1());
    }

    @Test
    public void testResolveCurrency() {
        List<String> list = new ArrayList<>();
        list.add("USD");
        DummyCurrencyContainer o = new DummyCurrencyContainer(list);
        assertEquals("USD", CurrencyResolver.resolveCurrencyString(o));
    }

    private static final class DummyCurrencyContainer implements CurrencyContainer {
        private final List<String> currencies;

        DummyCurrencyContainer(List<String> list) {
            this.currencies = list;
        }

        @Override
        public String typesPattern() {
            return null;
        }

        @Override
        public String parserPattern() {
            return null;
        }

        @Override
        public List<String> currencyStrings() {
            return this.currencies;
        }

        @Override
        public String currencyString() {
            return null;
        }

        @Override
        public List<Currency> currencies() {
            return null;
        }

        @Override
        public Currency currency() {
            return null;
        }

        @Override
        public void initializeCurrencies(String cur) {}

        @Override
        public void initializeCurrencies(Currency cur) {}
    }
}

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

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.logging.Logger;

/**
 * Helper API to detect amount component in fields.
 * @since 9.2.15
 */
public class MonetaryAmountResolver {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(MonetaryAmountResolver.class.getName());

    /**
     * @see AmountResolver#amounts(Field)
     */
    public static List<BigDecimal> amounts(final Field f) {
        return AmountResolver.amounts(f);
    }

    /**
     * @see AmountResolver#amount(Field)
     */
    public static BigDecimal amount(final Field f) {
        return AmountResolver.amount(f);
    }

    /**
     * @see CurrencyResolver#currencyStrings(Field)
     */
    public static List<String> currencyStrings(final Field f) {
        return CurrencyResolver.currencyStrings(f);
    }

    /**
     * @see CurrencyResolver#currencies(Field)
     */
    public static List<Currency> currencies(final Field f) {
        return CurrencyResolver.currencies(f);
    }

    /**
     * @see CurrencyResolver#resolveCurrency(CurrencyContainer)
     */
    public static Currency resolveCurrency(CurrencyContainer o) {
        return CurrencyResolver.resolveCurrency(o);
    }

    /**
     * @see CurrencyResolver#resolveCurrencyString(CurrencyContainer)
     */
    public static String resolveCurrencyString(CurrencyContainer o) {
        return CurrencyResolver.resolveCurrencyString(o);
    }

    /**
     * @see CurrencyResolver#resolveSetCurrency(CurrencyContainer, Currency)
     */
    public static void resolveSetCurrency(final CurrencyContainer cc, final Currency cur) {
        CurrencyResolver.resolveSetCurrency(cc, cur);
    }

    /**
     * @see CurrencyResolver#resolveSetCurrency(CurrencyContainer, String)
     */
    public static void resolveSetCurrency(final CurrencyContainer cc, final String cur) {
        CurrencyResolver.resolveSetCurrency(cc, cur);
    }
}

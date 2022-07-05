/*
 * Copyright 2006-2021 Prowide
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

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.utils.ResolverUtils;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Helper API to detect amount component in fields.
 */
public class MonetaryAmountResolver {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(MonetaryAmountResolver.class.getName());

    /**
     * Gets the amounts of the given field by reading it's components pattern.
     * All index of 'I', number, in the pattern are looked for and returned as amount.
     *
     * <em>See the returns notes</em>
     *
     * @param f the field where to extract the amounts, must not be null
     * @return a list of BigDecimal with the numbers found in the numeric components or an empty list if none is found.
     * Missing or invalid numeric components are ignored; meaning if a components expected to be a number is not present
     * or it is not a valid number or Field.getComponent(index,Number.class) fails, that component is not included in the
     * result list.
     */
    public static List<BigDecimal> amounts(final Field f) {
        return AmountResolver.amounts(f);
    }

    /**
     * Gets the amount of the given field by reading it's components pattern.
     * The first index of 'N', number, is returned as amount.
     *
     * <em>See the returns notes</em>
     *
     * @param f the field where to extract the amount, must not be null
     * @return a BigDecimal with the number found in the first numeric component or null if there is
     * no numeric component in the field. It may also return null if Field.getComponent(index,Number.class) fails
     * for that component
     */
    public static BigDecimal amount(final Field f) {
        return AmountResolver.amount(f);
    }

    /**
     * Returns the list of Currency values (as String) given an MT Field
     *
     * If you want a list of <code>Currency</code>, use <code>currencies</code> instead
     * @param f the field
     * @return the list of currencies
     * @see #currencies(Field)
     */
    public static List<String> currencyStrings(final Field f) {
        return CurrencyResolver.currencyStrings(f);
    }

    /**
     * Returns the list of Currency values (as String) given the Types Pattern and the list of values
     *
     * This is <EM>DEPRECATED</EM>, use currencyStrings instead
     * @param pattern the Types Pattern
     * @param components the list of Component Values
     * @return the list of currencies
     * @see #currencyStrings(Field)
     */
    @Deprecated
    @ProwideDeprecated(phase2= TargetYear.SRU2022)
    public static List<String> resolveComponentsPattern(String pattern, List<String> components) {
        return CurrencyResolver.resolveComponentsPattern(pattern,components);
    }

    /**
     * Returns the list of Currency values (as Currency) given an MT Field.
     *
     * If you want a list of currency strings, use <code>currencyStrings</code> instead
     * @param f the field
     * @return the list of currencies
     * @see #currencyStrings(Field)
     */
    public static List<Currency> currencies(final Field f) {
        return CurrencyResolver.currencies(f);
    }

    public static Currency resolveCurrency(CurrencyContainer o) {
        return CurrencyResolver.resolveCurrency(o);
    }

    public static String resolveCurrencyString(CurrencyContainer o) {
        return CurrencyResolver.resolveCurrencyString(o);
    }

    public static void resolveSetCurrency(final CurrencyContainer cc, final Currency cur) {
        CurrencyResolver.resolveSetCurrency(cc, cur);
    }

    public static void resolveSetCurrency(final CurrencyContainer cc, final String cur) {
        CurrencyResolver.resolveSetCurrency(cc, cur);
    }
}

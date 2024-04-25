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

import com.prowidesoftware.swift.utils.ResolverUtils;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import java.util.Currency;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CurrencyResolver {

    /**
     * Returns the list of Currency values (as String) given an MT Field
     *
     * If you want a list of <code>Currency</code>, use <code>currencies</code> instead
     * @param f the field
     * @return the list of currencies
     * @see #currencies(Field)
     */
    public static List<String> currencyStrings(final Field f) {

        // sanity check
        Objects.requireNonNull(f);

        return ResolverUtils.findWantedType(f.typesPattern(), 'C', f.getComponents());
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

        // sanity check
        Objects.requireNonNull(f);

        // find all the non-null AMOUNT components
        List<String> values = ResolverUtils.findWantedType(f.typesPattern(), 'C', f.getComponents());

        // prepare the result and convert all that match
        return values.stream().map(SwiftFormatUtils::getCurrency).collect(Collectors.toList());
    }

    public static Currency resolveCurrency(CurrencyContainer o) {
        List<Currency> currencies = o.currencies();
        return currencies != null && !currencies.isEmpty() ? currencies.get(0) : null;
    }

    public static String resolveCurrencyString(CurrencyContainer o) {
        List<String> currencies = o.currencyStrings();
        return currencies != null && !currencies.isEmpty() ? currencies.get(0) : null;
    }

    public static void resolveSetCurrency(final CurrencyContainer cc, final Currency cur) {
        resolveSetCurrency(cc, cur.toString());
    }

    public static void resolveSetCurrency(final CurrencyContainer cc, final String cur) {

        // sanity check
        if (cc instanceof Field) {

            // find the first currency component
            Field f = (Field) cc;
            List<Integer> positions = ResolverUtils.findWantedTypesPosition(f.typesPattern(), 'C');
            for (Integer position : positions) {
                f.setComponent(position, cur);
            }
        }
    }
}

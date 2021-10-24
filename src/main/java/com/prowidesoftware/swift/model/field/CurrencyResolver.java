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

import java.util.Currency;

import java.util.ArrayList;
import java.util.List;

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.utils.ResolverUtils;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.Validate;

public class CurrencyResolver {

    /**
     * Returns the list of Currency values (as String) given an MT Field
     *
     * If you want a <code>List<Currency></code>, use <code>currencies</code> instead
     * @param f the field
     * @return the list of currencies
     * @see #currencies(Field)
     */
    public static List<String> currencyStrings(final Field f) {

        // sanity check
        Validate.notNull(f);

        return ResolverUtils.findWantedType(f.typesPattern(), 'C', f.getComponents());
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
        return ResolverUtils.findWantedType(pattern, 'C', components);
    }

    /**
     * Returns the list of Currency values (as Currency) given an MT Field
     *
     * If you want a <code>List<String></code>, use <code>currencyStrings</code> instead
     * @param f the field
     * @return the list of currencies
     * @see #currencyStrings(Field)
     */
    public static List<Currency> currencies(final Field f) {

        // sanity check
        Validate.notNull(f);

        // find all the non-null AMOUNT components
        List<String> values = ResolverUtils.findWantedType(f.typesPattern(), 'C', f.getComponents());

        // prepare the result and convert all that match
        List<Currency> currencies = new ArrayList<>();
        for(String value : values) {
            currencies.add(SwiftFormatUtils.getCurrency(value));
        }

        return currencies;
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

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
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Helper API to detect amount component in fields.
 */
public class AmountResolver {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(AmountResolver.class.getName());

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
     * @since 7.8.9
     */
    public static List<BigDecimal> amounts(final Field f) {

        // sanity check
        Objects.requireNonNull(f);

        // find all the non-null AMOUNT components
        List<String> values = ResolverUtils.findNonNullWantedType(f.typesPattern(), 'I', f.getComponents());

        // prepare the result and convert all that match
        return values.stream()
                .map(SwiftFormatUtils::getBigDecimal)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
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
     * @since 7.8
     */
    public static BigDecimal amount(final Field f) {

        // sanity check
        Objects.requireNonNull(f);

        // find the first AMOUNT component
        String value = ResolverUtils.findFirstWantedType(f.typesPattern(), 'I', f.getComponents());

        // if non-null => try to convert it
        if (value != null) {
            return SwiftFormatUtils.getBigDecimal(value);
        }
        return null;
    }
}

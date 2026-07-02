package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.BIC;
import com.prowidesoftware.swift.utils.ResolverUtils;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BICResolver {

    /**
     * Returns the list of BIC values (as String) for the given MT field.
     *
     * @param f the field
     * @return the list of BIC strings
     * @see #bics(Field)
     */
    public static List<String> bicStrings(final Field f) {

        // sanity check
        Objects.requireNonNull(f);

        return ResolverUtils.findWantedType(f.typesPattern(), 'B', f.getComponents());
    }

    /**
     * Returns the list of BIC values (as {@link BIC}) for the given MT field.
     *
     * @param f the field
     * @return the list of BICs
     * @see #bicStrings(Field)
     */
    public static List<BIC> bics(final Field f) {

        // sanity check
        Objects.requireNonNull(f);

        // find all the non-null AMOUNT components
        List<String> values = ResolverUtils.findWantedType(f.typesPattern(), 'B', f.getComponents());

        // prepare the result and convert all that match
        return values.stream()
                .map(v -> v != null ? SwiftFormatUtils.getBIC(v) : null)
                .collect(Collectors.toList());
    }
}

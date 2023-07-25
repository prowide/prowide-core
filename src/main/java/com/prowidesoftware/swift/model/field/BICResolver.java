package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.BIC;
import com.prowidesoftware.swift.utils.ResolverUtils;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BICResolver {

    /**
     * Returns the list of BIC values (as String) given an MT Field
     *
     * If you want a list of BIC coes, use <code>bics</code> instead
     * @param f the field
     * @return the list of BICs
     * @see #bics(Field)
     */
    public static List<String> bicStrings(final Field f) {

        // sanity check
        Objects.requireNonNull(f);

        return ResolverUtils.findWantedType(f.typesPattern(), 'B', f.getComponents());
    }

    /**
     * Returns the list of BIC values (as BIC) given an MT Field
     *
     * If you want a list of Strings, use <code>bicStrings</code> instead
     * @param f the field
     * @return the list of currencies
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

package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.BIC;
import com.prowidesoftware.swift.utils.ResolverUtils;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class BICResolver {

    /**
     * Returns the list of BIC values (as String) given an MT Field
     *
     * If you want a <code>List<BIC></code>, use <code>bics</code> instead
     * @param f the field
     * @return the list of bics
     * @see #bics(Field)
     */
    public static List<String> bicStrings(final Field f) {

        // sanity check
        Validate.notNull(f);

        return ResolverUtils.findWantedType(f.typesPattern(), 'B', f.getComponents());
    }

    /**
     * Returns the list of BIC values (as BIC) given an MT Field
     *
     * If you want a <code>List<String></code>, use <code>bicStrings</code> instead
     * @param f the field
     * @return the list of currencies
     * @see #bicStrings(Field)
     */
    public static List<BIC> bics(final Field f) {

        // sanity check
        Validate.notNull(f);

        // find all the non-null AMOUNT components
        List<String> values = ResolverUtils.findWantedType(f.typesPattern(), 'B', f.getComponents());

        // prepare the result and convert all that match
        List<BIC> bics = new ArrayList<>();
        for(String value : values) {
            bics.add(value != null ? SwiftFormatUtils.getBIC(value) : (BIC) null);
        }

        return bics;
    }

}

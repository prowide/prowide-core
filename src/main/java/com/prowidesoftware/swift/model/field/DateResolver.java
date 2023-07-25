package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.utils.ResolverUtils;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;

public class DateResolver {

    /**
     * Gets the dates of the given field by reading it's components pattern.
     * All index of 'D', 'E', 'F', 'Y', 'A', 'U', 'P' or 'J' in the pattern are looked for
     * and returned as calendar.
     *
     * <em>See the returns notes</em>
     *
     * @param f the field where to extract the dates, must not be null
     * @return a list of Calendar with the dates found in the dates components or an empty list if none is found.
     * Missing or invalid dates components are returned as null; meaning if a components expected to be a date is not present
     * or it is not a valid date or Field.getComponent(index, Calendar.class) fails, that component is still included in the
     * result list as a null value.
     * @see Field#getComponentAs(int, Class)
     */
    public static List<Calendar> dates(final Field f) {

        // sanity check
        Objects.requireNonNull(f);

        // find all the non-null AMOUNT components
        List<Pair<Character, String>> values =
                ResolverUtils.findWantedType(f.typesPattern(), "DEFYAUPJ", f.getComponents());

        // prepare the result and convert all that match
        return values.stream()
                .map(pair -> _convert(pair.getKey(), pair.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Gets the date of the given field by reading it's components pattern.
     * The first index of 'D', 'E', 'F', 'Y', 'A', 'U', 'P' or 'J', is returned as a calendar.
     *
     * <em>See the returns notes</em>
     *
     * @param f the field where to extract the date, must not be null
     * @return a Calendar with the date found in the first date component or null if there is
     * no date component in the field. It may also return null if the date is not valid
     * @since 7.8
     */
    public static Calendar date(final Field f) {

        // sanity check
        Objects.requireNonNull(f);

        // find the first DATE component
        Pair<Character, String> value =
                ResolverUtils.findFirstWantedType(f.typesPattern(), "DEFYAUPJ", f.getComponents());
        return value != null ? _convert(value.getKey(), value.getValue()) : null;
    }

    private static Calendar _convert(Character type, String value) {

        switch (type) {
            case 'D':
                return SwiftFormatUtils.getDate4(value);
            case 'E':
                return SwiftFormatUtils.getDate2(value);
            case 'F':
                return SwiftFormatUtils.getDate1(value);
            case 'Y':
                return SwiftFormatUtils.getYear(value);
            case 'A':
                return SwiftFormatUtils.getDateTime(value);
            case 'U':
                return SwiftFormatUtils.getDateTimeShortYear(value);
            case 'P':
                return SwiftFormatUtils.getDayTime(value);
            case 'J':
                return SwiftFormatUtils.getMonthDay(value);
        }

        return null;
    }
}

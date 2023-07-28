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

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import java.util.Calendar;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DateResolverTest {
    /*
        public List<Calendar> dates()
        public Calendar date()
    */
    @Test
    public void testResolve69A_multiple() {

        Field69A field = new Field69A("PWAL//20050701/20050723");

        // list of currencies
        final List<Calendar> dates = field.dates();
        assertNotNull(dates);
        assertEquals(2, dates.size());
        assertEquals(SwiftFormatUtils.getDate4("20050701"), dates.get(0));
        assertEquals(SwiftFormatUtils.getDate4("20050723"), dates.get(1));

        // first date
        assertEquals(SwiftFormatUtils.getDate4("20050701"), field.date());
    }

    @Test
    public void testResolve32C_single() {

        Field69C field = new Field69C(":BLOK//20120621/ONGO");

        // list of currencies
        final List<Calendar> dates = field.dates();
        assertNotNull(dates);
        assertEquals(1, dates.size());
        assertEquals(SwiftFormatUtils.getDate4("20120621"), dates.get(0));

        // first date
        assertEquals(SwiftFormatUtils.getDate4("20120621"), field.date());
    }

    @Test
    public void testResolve32C_null() {

        Field69C field = new Field69C(":BLOK///ONGO");

        // list of currencies
        final List<Calendar> dates = field.dates();
        assertNotNull(dates);
        assertEquals(1, dates.size());
        assertNull(dates.get(0));

        // first date
        assertNull(field.date());
    }
}

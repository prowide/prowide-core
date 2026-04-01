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

package com.prowidesoftware.swift.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link SwiftMessageStatusInfo}
 *
 * @since 10.3.12
 */
public class SwiftMessageStatusInfoTest {

    @Test
    public void testCreationDateDefaultsToNowWhenNullInConstructor() {
        Calendar before = Calendar.getInstance();
        SwiftMessageStatusInfo info = new SwiftMessageStatusInfo("comment", null, "user", "name", "data");
        Calendar after = Calendar.getInstance();

        assertNotNull(info.getCreationDate());
        assertFalse(info.getCreationDate().before(before));
        assertFalse(info.getCreationDate().after(after));
    }

    @Test
    public void testCreationDatePreservedWhenProvidedInConstructor() {
        Calendar custom = Calendar.getInstance();
        custom.set(2020, Calendar.JANUARY, 1);
        SwiftMessageStatusInfo info = new SwiftMessageStatusInfo("comment", custom, "user", "name", "data");

        assertEquals(custom, info.getCreationDate());
    }

    @Test
    public void testSetCreationDateIgnoresNull() {
        SwiftMessageStatusInfo info = new SwiftMessageStatusInfo();
        Calendar original = info.getCreationDate();
        assertNotNull(original);

        info.setCreationDate(null);
        assertSame(original, info.getCreationDate());
    }

    @Test
    public void testSetCreationDateAcceptsNonNull() {
        SwiftMessageStatusInfo info = new SwiftMessageStatusInfo();
        Calendar custom = Calendar.getInstance();
        custom.set(2020, Calendar.JUNE, 15);

        info.setCreationDate(custom);
        assertEquals(custom, info.getCreationDate());
    }
}

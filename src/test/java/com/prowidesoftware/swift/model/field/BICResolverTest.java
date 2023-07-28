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

import com.prowidesoftware.swift.model.BIC;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BICResolverTest {

    @Test
    public void testResolve94H_single() {

        Field94H field = new Field94H(":CLEA//LCHLGB2L");

        // list of currencies
        final List<BIC> bics = field.bics();
        assertNotNull(bics);
        assertEquals(1, bics.size());
        assertEquals(SwiftFormatUtils.getBIC("LCHLGB2L"), bics.get(0));

        // list of currency strings
        final List<String> bicStrings = field.bicStrings();
        assertNotNull(bicStrings);
        assertEquals(1, bicStrings.size());
        assertEquals("LCHLGB2L", bicStrings.get(0));
    }

    @Test
    public void testResolve94H_null() {

        Field94H field = new Field94H(":CLEA//");

        // list of currencies
        final List<BIC> bics = field.bics();
        assertNotNull(bics);
        assertEquals(1, bics.size());
        assertNull(bics.get(0));

        // list of currency strings
        final List<String> bicStrings = field.bicStrings();
        assertNotNull(bicStrings);
        assertEquals(1, bicStrings.size());
        assertNull(bicStrings.get(0));
    }
}

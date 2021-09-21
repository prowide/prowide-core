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
package com.prowidesoftware.swift.model.mt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class MTVariantTest {

    @Test
    public void testExtract() {
        assertFalse(MTVariant.extract(null).isPresent());
        assertFalse(MTVariant.extract("").isPresent());
        assertFalse(MTVariant.extract("foo").isPresent());
        assertEquals(MTVariant.STP, MTVariant.extract("STP").get());
        assertEquals(MTVariant.STP, MTVariant.extract("103.STP").get());
        assertEquals(MTVariant.STP, MTVariant.extract("103STP").get());
        assertEquals(MTVariant.STP, MTVariant.extract("103_STP").get());
        assertEquals(MTVariant.STP, MTVariant.extract("fin.103.STP").get());
        assertEquals(MTVariant.COV, MTVariant.extract("COV").get());
        assertEquals(MTVariant.COV, MTVariant.extract("202.COV").get());
        assertEquals(MTVariant.COV, MTVariant.extract("202COV").get());
        assertEquals(MTVariant.COV, MTVariant.extract("202_COV").get());
        assertEquals(MTVariant.COV, MTVariant.extract("fin.202.COV").get());
    }

}

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
package com.prowidesoftware.swift.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResolverUtilsTest {

    @Test
    public void testResolveCurrency() {
        List<String> components = new ArrayList<>();
        components.add("c1");
        components.add("c2");
        components.add("c3");
        components.add("c4");
        components.add("c5");

        List<String> o = ResolverUtils.findWantedType("SC", 'C', components);
        assertEquals(1, o.size());
        assertEquals("c2", o.get(0));

        o = ResolverUtils.findWantedType("CS", 'C', components);
        assertEquals(1, o.size());
        assertEquals("c1", o.get(0));

        o = ResolverUtils.findWantedType("SCS", 'C', components);
        assertEquals(1, o.size());
        assertEquals("c2", o.get(0));
    }
}

/*
 * Copyright 2006 Prowide
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

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * The resolvers replaced by the generated parent-scoped accessors are deprecated and scheduled for
 * removal; only the resolvers that the parent scoping cannot express remain in service: MT537 B
 * (trims the message before C and D) and MT670/671 C (trim after the last B occurrence), all level
 * one sequences colliding with a nested one.
 */
public class SequenceUtilsDeprecationTest {

    private static final Set<String> KEPT_MANUAL_RESOLVERS = new HashSet<>(Arrays.asList(
            "resolveMT537GetSequenceBList_sru2026",
            "resolveMT670GetSequenceC_sru2026",
            "resolveMT671GetSequenceC_sru2026"));

    @Test
    public void testReplacedResolversAreDeprecatedAndManualOnesAreNot() {
        int deprecated = 0;
        int kept = 0;
        for (Method m : SequenceUtils.class.getDeclaredMethods()) {
            if (!Modifier.isPublic(m.getModifiers())) {
                continue;
            }
            if (KEPT_MANUAL_RESOLVERS.contains(m.getName())) {
                assertFalse(
                        m.isAnnotationPresent(Deprecated.class),
                        m.getName() + " is still required by the generated code and must not be deprecated");
                kept++;
            } else {
                assertTrue(
                        m.isAnnotationPresent(Deprecated.class),
                        m.getName() + " was replaced by a generated parent-scoped accessor and must be deprecated");
                deprecated++;
            }
        }
        // 49 replaced resolvers, plus the 3 manual ones (MT537 B has an extra block 4 overload)
        assertEquals(49, deprecated);
        assertEquals(4, kept);
    }
}

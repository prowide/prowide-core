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
package com.prowidesoftware.swift.model.mt.mt7xx;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Subsequences B1 and C1 share the same delimiters, so the no-arg getters must scope the lookup to
 * their parent sequence instead of the whole block 4.
 */
public class MT767Test {

    private static final String BOTH_B_AND_C = "{1:F01AAAAUS30AXXX0000123450}{2:I767BBBBGB44AXXXN}{4:\n" + ":15A:\n"
            + ":20:REF11111\n"
            + ":15B:\n"
            + ":59N:B-BENEFICIARY\n"
            + ":59R:B-BENEFICIARY-END\n"
            + ":15C:\n"
            + ":59N:C-BENEFICIARY\n"
            + ":59R:C-BENEFICIARY-END\n"
            + "-}";

    @Test
    public void testSequenceB1IsScopedToSequenceB() {
        final MT767 mt = new MT767(BOTH_B_AND_C);
        assertThat(mt.getSequenceB1().getTags())
                .extracting("value")
                .containsExactly("B-BENEFICIARY", "B-BENEFICIARY-END");
    }

    @Test
    public void testSequenceC1IsScopedToSequenceC() {
        final MT767 mt = new MT767(BOTH_B_AND_C);
        assertThat(mt.getSequenceC1().getTags())
                .extracting("value")
                .containsExactly("C-BENEFICIARY", "C-BENEFICIARY-END");
    }
}

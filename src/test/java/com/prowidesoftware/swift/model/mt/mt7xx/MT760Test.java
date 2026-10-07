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
 * Subsequences B1/B2/B3 and C1/C2/C3 share the same delimiters, so the no-arg getters must scope the
 * lookup to their parent sequence instead of the whole block 4.
 */
public class MT760Test {

    /** both sequence B and sequence C present, with all three subsequences in each */
    private static final String BOTH_B_AND_C = "{1:F01AAAAUS30AXXX0000123450}{2:I760BBBBGB44AXXXN}{4:\n" + ":15A:\n"
            + ":20:REF11111\n"
            + ":15B:\n"
            + ":50N:B-APPLICANT\n"
            + ":50R:B-APPLICANT-END\n"
            + ":51N:B-OBLIGOR\n"
            + ":51R:B-OBLIGOR-END\n"
            + ":59N:B-BENEFICIARY\n"
            + ":59R:B-BENEFICIARY-END\n"
            + ":15C:\n"
            + ":50N:C-APPLICANT\n"
            + ":50R:C-APPLICANT-END\n"
            + ":51N:C-OBLIGOR\n"
            + ":51R:C-OBLIGOR-END\n"
            + ":59N:C-BENEFICIARY\n"
            + ":59R:C-BENEFICIARY-END\n"
            + "-}";

    /** only sequence C present, sequence B absent */
    private static final String ONLY_C = "{1:F01AAAAUS30AXXX0000123450}{2:I760BBBBGB44AXXXN}{4:\n" + ":15A:\n"
            + ":20:REF11111\n"
            + ":15C:\n"
            + ":50N:C-APPLICANT\n"
            + ":50R:C-APPLICANT-END\n"
            + "-}";

    @Test
    public void testSequenceB1IsScopedToSequenceB() {
        final MT760 mt = new MT760(BOTH_B_AND_C);
        assertThat(mt.getSequenceB1().getTags()).extracting("value").containsExactly("B-APPLICANT", "B-APPLICANT-END");
    }

    @Test
    public void testSequenceB2IsScopedToSequenceB() {
        final MT760 mt = new MT760(BOTH_B_AND_C);
        assertThat(mt.getSequenceB2().getTags()).extracting("value").containsExactly("B-OBLIGOR", "B-OBLIGOR-END");
    }

    @Test
    public void testSequenceB3IsScopedToSequenceB() {
        final MT760 mt = new MT760(BOTH_B_AND_C);
        assertThat(mt.getSequenceB3().getTags())
                .extracting("value")
                .containsExactly("B-BENEFICIARY", "B-BENEFICIARY-END");
    }

    @Test
    public void testSequenceC1IsScopedToSequenceC() {
        final MT760 mt = new MT760(BOTH_B_AND_C);
        assertThat(mt.getSequenceC1().getTags()).extracting("value").containsExactly("C-APPLICANT", "C-APPLICANT-END");
    }

    @Test
    public void testSequenceC2IsScopedToSequenceC() {
        final MT760 mt = new MT760(BOTH_B_AND_C);
        assertThat(mt.getSequenceC2().getTags()).extracting("value").containsExactly("C-OBLIGOR", "C-OBLIGOR-END");
    }

    @Test
    public void testSequenceC3IsScopedToSequenceC() {
        final MT760 mt = new MT760(BOTH_B_AND_C);
        assertThat(mt.getSequenceC3().getTags())
                .extracting("value")
                .containsExactly("C-BENEFICIARY", "C-BENEFICIARY-END");
    }

    @Test
    public void testSequenceB1IsEmptyWhenSequenceBIsAbsent() {
        final MT760 mt = new MT760(ONLY_C);
        assertThat(mt.getSequenceB1()).isEmpty();
    }

    @Test
    public void testSequenceC1IsFoundWhenSequenceBIsAbsent() {
        final MT760 mt = new MT760(ONLY_C);
        assertThat(mt.getSequenceC1().getTags()).extracting("value").containsExactly("C-APPLICANT", "C-APPLICANT-END");
    }

    @Test
    public void testSequenceC1IsNullWhenBlock4IsAbsent() {
        final MT760 mt = new MT760("{1:F01AAAAUS30AXXX0000123450}{2:I760BBBBGB44AXXXN}");
        assertThat(mt.getSequenceC1()).isNull();
    }

    @Test
    public void testSequenceC1IsNullWhenBlock4IsEmpty() {
        final MT760 mt = new MT760("{1:F01AAAAUS30AXXX0000123450}{2:I760BBBBGB44AXXXN}{4:\n-}");
        assertThat(mt.getSequenceC1()).isNull();
    }

    /** The generic sequence API resolves through the same fixed getters. */
    @Test
    public void testGenericSequenceApiIsScopedToTheParent() {
        final MT760 mt = new MT760(BOTH_B_AND_C);
        assertThat(mt.getSequence("C1").getTags())
                .extracting("value")
                .containsExactly("C-APPLICANT", "C-APPLICANT-END");
        assertThat(mt.getSequence("B1").getTags())
                .extracting("value")
                .containsExactly("B-APPLICANT", "B-APPLICANT-END");
    }

    /**
     * The subsequence fields are present but the parent field 15B delimiter is missing, so the parent
     * sequence cannot be resolved and the subsequence is reported as not found.
     */
    @Test
    public void testSequenceB1IsEmptyWhenParentDelimiterIsMissing() {
        final MT760 mt = new MT760("{1:F01AAAAUS30AXXX0000123450}{2:I760BBBBGB44AXXXN}{4:\n" + ":15A:\n"
                + ":20:REF11111\n"
                + ":50N:B-APPLICANT\n"
                + ":50R:B-APPLICANT-END\n"
                + "-}");
        assertThat(mt.getSequenceB1()).isEmpty();
    }
}

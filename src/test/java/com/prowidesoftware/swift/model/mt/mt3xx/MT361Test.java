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
package com.prowidesoftware.swift.model.mt.mt3xx;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Subsequences B1/E1, C1/F1 and C2/F2 share the same delimiters, so the no-arg getters must scope the
 * lookup to their parent sequence instead of the whole block 4.
 */
public class MT361Test {

    private static final String ALL_SEQUENCES = "{1:F01AAAAUS30AXXX0000123450}{2:I361BBBBGB44AXXXN}{4:\n" + ":15A:\n"
            + ":20:REF11111\n"
            + ":15B:\n"
            + ":18A:B1-COUNT\n"
            + ":22B:B1-END\n"
            + ":15C:\n"
            + ":14J:C1-START\n"
            + ":22B:C1-END\n"
            + ":22D:C2-START\n"
            + ":30X:C2-END\n"
            + ":15E:\n"
            + ":18A:E1-COUNT\n"
            + ":22B:E1-END\n"
            + ":15F:\n"
            + ":14J:F1-START\n"
            + ":22B:F1-END\n"
            + ":22D:F2-START\n"
            + ":30X:F2-END\n"
            + "-}";

    @Test
    public void testSequenceB1IsScopedToSequenceB() {
        final MT361 mt = new MT361(ALL_SEQUENCES);
        assertThat(mt.getSequenceB1().getTags()).extracting("value").containsExactly("B1-COUNT", "B1-END");
    }

    @Test
    public void testSequenceE1IsScopedToSequenceE() {
        final MT361 mt = new MT361(ALL_SEQUENCES);
        assertThat(mt.getSequenceE1().getTags()).extracting("value").containsExactly("E1-COUNT", "E1-END");
    }

    @Test
    public void testSequenceC1IsScopedToSequenceC() {
        final MT361 mt = new MT361(ALL_SEQUENCES);
        assertThat(mt.getSequenceC1().getTags()).extracting("value").containsExactly("C1-START", "C1-END");
    }

    @Test
    public void testSequenceF1IsScopedToSequenceF() {
        final MT361 mt = new MT361(ALL_SEQUENCES);
        assertThat(mt.getSequenceF1().getTags()).extracting("value").containsExactly("F1-START", "F1-END");
    }

    @Test
    public void testSequenceC2IsScopedToSequenceC() {
        final MT361 mt = new MT361(ALL_SEQUENCES);
        assertThat(mt.getSequenceC2().getTags()).extracting("value").containsExactly("C2-START", "C2-END");
    }

    @Test
    public void testSequenceF2IsScopedToSequenceF() {
        final MT361 mt = new MT361(ALL_SEQUENCES);
        assertThat(mt.getSequenceF2().getTags()).extracting("value").containsExactly("F2-START", "F2-END");
    }
}

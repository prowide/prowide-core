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

package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MT564Test {

    /**
     * Sequence B1 and E1a use the same delimiter so we need to add parent sequence for unique find
     */
    @Test
    public void test1() {
        MT564 m = new MT564();
        m.append(MT564.SequenceB1.newInstance());
        m.append(MT564.SequenceE1.newInstance());
        assertTrue(m.getSequenceE1aList().isEmpty());
    }

    /**
     * Sequence B1 and E1a use the same delimiter so we need to add parent sequence for unique find
     */
    @Test
    public void test2() {
        MT564 m = new MT564();
        m.append(MT564.SequenceB.newInstance());
        m.append(MT564.SequenceE.newInstance(MT564.SequenceE1a.newInstance()));
        assertTrue(m.getSequenceB1().isEmpty());
    }

    @Test
    public void testGetSequences() {
        MT564 mt = MT564.parse("{1:F01FOOBARXXBGLO0524000001}{2:I564AAAABEBEXECLN}{4:\n" + ":16R:GENL\n"
                + ":20C::CORP//11111111\n"
                + ":20C::SEME//2222222\n"
                + ":23G:NEWM\n"
                + ":22F::CAEV//EXWA\n"
                + ":22F::CAMV//MAND\n"
                + ":98C::PREP//20151016170651\n"
                + ":25D::PROC//PREU\n"
                + ":16S:GENL\n"
                + ":16R:USECU\n"
                + ":35B:ISIN DE000UT12345\n"
                + "UBS LDN FOO IFX\n"
                + ":16R:ACCTINFO\n"
                + ":97A::SAFE//71xx0000\n"
                + ":93B::ELIG//UNIT/1000,\n"
                + ":93B::SETT//UNIT/1000,\n"
                + ":16S:ACCTINFO\n"
                + ":16S:USECU\n"
                + ":16R:CADETL\n"
                + ":17B::CERT//Y\n"
                + ":17B::LEOG//Y\n"
                + ":17B::SRDC//Y\n"
                + ":16S:CADETL\n"
                + ":16R:CAOPTN\n"
                + ":13A::CAON//001\n"
                + ":22F::CAOP//CASH\n"
                + ":17B::DFLT//Y\n"
                + ":17B::APLI//Y\n"
                + ":16S:CAOPTN\n"
                + "-}");

        // CADTL
        assertFalse(mt.getSequenceD().isEmpty());

        // CAOPTN
        assertEquals(1, mt.getSequenceEList().size());
    }
}

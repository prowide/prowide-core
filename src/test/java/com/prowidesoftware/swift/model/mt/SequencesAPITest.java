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

package com.prowidesoftware.swift.model.mt;

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.mt1xx.MT101;
import com.prowidesoftware.swift.model.mt.mt1xx.MT101.SequenceA;
import com.prowidesoftware.swift.model.mt.mt1xx.MT101.SequenceB;
import com.prowidesoftware.swift.model.mt.mt1xx.MT104;
import com.prowidesoftware.swift.model.mt.mt3xx.MT360;
import com.prowidesoftware.swift.model.mt.mt5xx.MT564;
import com.prowidesoftware.swift.model.mt.mt6xx.MT670;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SequencesAPITest {

    @Test
    public void testMT564_SequenceEList() {
        final MT564 m = new MT564();
        m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
        assertNotNull(m.getSequenceEList());
        assertEquals(1, m.getSequenceEList().size());
    }

    @Test
    public void testMT564_SequenceEList_2() {
        final MT564 m = new MT564();
        m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
        assertNotNull(m.getSequenceEList());
        assertEquals(2, m.getSequenceEList().size());
    }

    @Test
    public void testMT564_SequenceEList_3() {
        final MT564 m = new MT564();
        m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16R.NAME, MT564.SequenceE1.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE1.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
        assertNotNull(m.getSequenceEList());
        assertEquals(1, m.getSequenceEList().size());
        assertNotNull(m.getSequenceE1List());
        assertEquals(1, m.getSequenceE1List().size());
    }

    @Test
    public void testMT564_SequenceEList_4() {
        final MT564 m = new MT564();
        m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16R.NAME, MT564.SequenceE1.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE1.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
        assertNotNull(m.getSequenceEList());
        assertEquals(2, m.getSequenceEList().size());
        assertNotNull(m.getSequenceE1List());
        assertEquals(1, m.getSequenceE1List().size());
    }

    @Test
    public void testMT564_SequenceEList_5() {
        final MT564 m = new MT564();
        m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16R.NAME, MT564.SequenceE1.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE1.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16R.NAME, MT564.SequenceE1.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE1.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
        assertNotNull(m.getSequenceEList());
        assertEquals(2, m.getSequenceEList().size());
        assertNotNull(m.getSequenceE1List());
        assertEquals(2, m.getSequenceE1List().size());
    }

    @Test
    public void testMT564_SequenceEList_6() {
        final MT564 m = new MT564();
        m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
        m.append(new Tag(Field16R.NAME, MT564.SequenceE1.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE1.START_END_16RS));
        m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
        assertNotNull(m.getSequenceEList());
        assertEquals(2, m.getSequenceEList().size());
        assertNotNull(m.getSequenceE1List());
        assertEquals(1, m.getSequenceE1List().size());
        /*
         * nested call
         */
        assertEquals(0, MT564.getSequenceE1List(m.getSequenceEList().get(0)).size());
        assertEquals(1, MT564.getSequenceE1List(m.getSequenceEList().get(1)).size());
    }

    @Test
    public void testMT564_SequenceC() {
        final String s = "{1:F01SWHQBEBBAXXX0001000001}{2:I564SWHQBEBBXBILN}{3:{108:495}}{4:\n" + ":16R:GENL\n"
                + ":20C::SEME//FU00003020000001\n"
                + ":20C::CORP//OTHR000000000302\n"
                + ":23G:NEWM\n"
                + ":22F::CAEV//OTHR\n"
                + ":22F::CAMV//MAND\n"
                + ":98C::PREP//20141204070253\n"
                + ":25D::PROC//PREU\n"
                + ":16S:GENL\n"
                + ":16R:USECU\n"
                + ":35B:ISIN AT0000A00GJ3\n"
                + "FOO 322 Euro\n"
                + " FOO Duration(T)\n"
                + ":16R:ACCTINFO\n"
                + ":97C::SAFE//GENR\n"
                + ":16S:ACCTINFO\n"
                + ":16S:USECU\n"
                + ":16R:CADETL\n"
                + ":98A::EFFD//20150129\n"
                + ":70G::WEBB//sssss\n"
                + ":16S:CADETL\n"
                + ":16R:ADDINFO\n"
                + ":70E::ADTX//Fondsfusion\n"
                + " FOO 322 Euro \n"
                + "FOO Duration\n"
                + ":70E::TXNR//Foobar \n"
                + "Kapitalanlage Gesellschaft\n"
                + " m.b.H. informiert gem.\n"
                + " Paragraph133 Abs. 9 InvFG\n"
                + " 2011, dass\n"
                + ":16S:ADDINFO\n"
                + "-}";
        final MT564 m = new MT564(s);
        assertEquals(0, m.getSequenceC().size());
        assertEquals(0, MT564.getSequenceC(m.getSwiftMessage().getBlock4()).size());
    }

    @Test
    public void testMT564_SequenceB1() {
        MT564 mt = MT564.parse(
                "{1:F01SAMPLEXXXXXX0300000054}{2:O5641738190122EDISGB2LAXXX12345123451901230111N}{4:\n" + ":16R:GENL\n"
                        + ":20C::CORP//VQ8000V1LOI51000\n"
                        + ":20C::SEME//VQ8000V1LOI51000\n"
                        + ":23G:NEWM\n"
                        + ":22F::CAEV//ACTV\n"
                        + ":22F::CAMV//MAND\n"
                        + ":25D::PROC//COMP\n"
                        + ":16S:GENL\n"
                        +

                        // B1 not present in USECU (B)
                        ":16R:USECU\n"
                        + ":35B:ISIN INE411H01032\n"
                        + ":16R:ACCTINFO\n"
                        + ":97C::SAFE//GENR\n"
                        + ":16S:ACCTINFO\n"
                        + ":16S:USECU\n"
                        + ":16R:CAOPTN\n"
                        + ":13A::CAON//001\n"
                        + ":22F::CAOP//CASH\n"
                        + ":17B::DFLT//Y\n"
                        + ":16R:SECMOVE\n"
                        + ":22H::CRDB//CRED\n"
                        + ":35B:ISIN XXXXXXXX91B9\n"
                        +

                        // colliding FIA sequence in SECMOVE
                        ":16R:FIA\n"
                        + ":92A::PRFC//N0,1\n"
                        + ":16S:FIA\n"
                        + ":98A::PAYD//20250329\n"
                        + ":16S:SECMOVE\n"
                        + ":16S:CAOPTN\n"
                        + "-}");
        MT564.SequenceB seqB = mt.getSequenceB();
        assertNotNull(seqB);
        assertEquals(6, seqB.size());
        assertTrue(mt.getSequenceB1().isEmpty());

        // if we call this with a parent sequence, such as B it works
        // however if we pass the whole block 4, it fails because it returns the colliding FIA from SECMOVE
        assertTrue(MT564.getSequenceB1(mt.getSequenceB()).isEmpty());
    }

    @Test
    public void test_NPE() {
        try {
            final MT564 m = new MT564("invalid message");
            m.getSequenceA();
        } catch (NullPointerException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMT670_SequenceC() {
        MT670 m = new MT670()
                .append(MT670.SequenceA2.newInstance(Field95P.tag("SSIR")))
                .append(MT670.SequenceB.newInstance(MT670.SequenceB2.newInstance(Field22F.tag("PMTH"))));
        assertTrue(m.getSequenceC().isEmpty());
    }

    @Test
    public void testMT360() {
        MT360 m = new MT360()
                .append(MT360.SequenceA.newInstance(Field23A.tag("FIXEDFIXED")))
                .append(MT360.SequenceB.newInstance())
                .append(MT360.SequenceE.newInstance());
        assertTrue(m.getSequenceC().isEmpty());
        assertTrue(m.getSequenceF().isEmpty());
    }

    @Test
    public void testMT101_NewSequenceA() {
        MT101 m = new MT101().append(MT101.SequenceA.newInstance(Field98A.emptyTag()));
        SequenceA A = m.getSequenceA();
        assertNotNull(A);
        assertFalse(A.isEmpty());
    }

    @Test
    public void testMT101_NewSequenceB() {
        MT101 m = new MT101().append(MT101.SequenceB.newInstance(Field98A.emptyTag()));
        List<SequenceB> Bs = m.getSequenceBList();
        assertEquals(1, Bs.size());
    }

    @Test
    public void testMT104_SequenceC() {
        MT104 m = new MT104()
                .append(MT104.SequenceA.newInstance(Field20.tag("FOO"), Field30.tag("FOO")))
                .append(MT104.SequenceB.newInstance(
                        Field21.tag("FOO"), Field32B.tag("FOO"), Field59.tag("FOO"), Field36.tag("FOO")))
                .append(Field32B.tag("FOO"), Field71G.tag("FOO"));
        assertFalse(m.getSequenceC().isEmpty());
        assertEquals(2, m.getSequenceC().size());
        assertEquals(Field32B.NAME, m.getSequenceC().getTag(0).getName());
        assertEquals(Field71G.NAME, m.getSequenceC().getTag(1).getName());
    }
}

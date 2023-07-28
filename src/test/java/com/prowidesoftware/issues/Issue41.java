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
package com.prowidesoftware.issues;

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.model.SwiftMessageUtils;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.mt.mt5xx.MT564;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * https://github.com/prowide/prowide-core/issues/41
 */
public class Issue41 {

    @Test
    public void testMT564() {

        String fin = "{1:F01FIFRUS31AXXX0000000000}{2:I564N}{4:\n" + ":16R:GENL\n"
                + ":20C::CORP//DV200000168730\n"
                + ":20C::SEME//DV200000168730\n"
                + ":23G:NEWM\n"
                + ":22F::CAEV//DVCA\n"
                + ":22F::CAMV//MAND\n"
                + ":98C::PREP//20201029152301\n"
                + ":25D::PROC//COMP\n"
                + ":16S:GENL\n"
                + ":16R:USECU\n"
                + ":35B:/CUSP/12345B68\n"
                + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n"
                + ":16R:FIA\n"
                + ":94B::PLIS//EXCH/XTSE\n"
                + ":16S:FIA\n"
                + ":16R:ACCTINFO\n"
                + ":97A::SAFE//NONREF\n"
                + ":16S:ACCTINFO\n"
                + ":16S:USECU\n"
                + ":16R:CADETL\n"
                + ":98A::ANOU//20201029\n"
                + ":98A::XDTE//20001127\n"
                + ":98A::RDTE//20201130\n"
                + ":22F::DIVI//REGR\n"
                + ":16S:CADETL\n"
                +

                // sequence E
                ":16R:CAOPTN\n"
                + ":13A::CAON//001\n"
                + ":22F::CAOP//CASH\n"
                + ":17B::DFLT//Y\n"
                + ":92H::GRSS//USD0,12345657/ACTU\n"
                +

                // sequence E2
                ":16R:CASHMOVE\n"
                + ":22H::CRDB//CRED\n"
                + ":98A::PAYD//20201231\n"
                + ":92J::GRSS//INCO/USD0,1234567/ACTU\n"
                + ":16S:CASHMOVE\n"
                + ":70E::TAXE//US UNITED STATES\n"
                + ":16S:CAOPTN\n"
                + "-}";
        MT564 mt = MT564.parse(fin);

        // this returns all field 92a in the message
        assertEquals(2, mt.getSwiftMessage().getBlock4().getFieldsByNumber(92).size());

        MT564.SequenceE sequenceE = mt.getSequenceEList().get(0);

        // this returns all fields 92a in sequence E and ALSO in any subsequence such as the occurrence in the inner E2
        assertEquals(2, sequenceE.getFieldsByNumber(92).size());

        // this returns all fields 92a in sequence E only, not occurrence in subsequences
        SwiftTagListBlock trimmedSequenceE =
                SwiftMessageUtils.removeInnerSequences(mt.getSequenceEList().get(0));
        List<? extends Field> fields = trimmedSequenceE.getFieldsByNumber(92);
        assertEquals(1, fields.size());
        assertEquals(":GRSS//USD0,12345657/ACTU", fields.get(0).getValue());

        assertEquals(trimmedSequenceE.getFieldsByName("92H").length, 1);
        assertEquals(trimmedSequenceE.getFieldsByName("92J").length, 0);

        assertNull(trimmedSequenceE.getFieldByName("92J"));
        assertNotNull(trimmedSequenceE.getFieldByName("92H"));

        // this returns all fields 92a in sequence E2
        SwiftTagListBlock sequenceE2 =
                SwiftMessageUtils.removeInnerSequences(mt.getSequenceE2List().get(0));
        fields = sequenceE2.getFieldsByNumber(92);
        assertEquals(1, fields.size());
        assertEquals(":GRSS//INCO/USD0,1234567/ACTU", fields.get(0).getValue());
    }
}

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
 * distributed under the License is distributed on an "AS IS"BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import com.prowidesoftware.swift.SchemeConstantsS;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.field.Field20C;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class MT540Test {

    public static final String MT_540_CANC =
            "{1:F01AAAAFRPPAGSS0000000000}{2:O5401445211216BBBBFRPPAHCM5C3E1000002112161445N}{3:{108:5123C3E10}}{4:\n"
                    + ":16R:GENL\n"
                    + ":20C::SEME//TFH5436259-999\n"
                    + ":23G:CANC\n"
                    + ":98C::PREP//20211216144402\n"
                    + ":16R:LINK\n"
                    + ":20C::PREV//TFH5436259-999\n"
                    + ":16S:LINK\n"
                    + ":16S:GENL\n"
                    + ":16R:TRADDET\n"
                    + ":98A::SETT//20211216\n"
                    + ":98A::TRAD//20211216\n"
                    + ":35B:ISIN FR0099001N99\n"
                    + "FRTR 0 25 02 24 EUR\n"
                    + ":16S:TRADDET\n"
                    + ":16R:FIAC\n"
                    + ":36B::SETT//FAMT/31000000,\n"
                    + ":97A::SAFE//0528808067001999\n"
                    + ":16S:FIAC\n"
                    + ":16R:SETDET\n"
                    + ":22F::SETR//TRAD\n"
                    + ":16R:SETPRTY\n"
                    + ":95P::DEAG//CCCCBEBEECL\n"
                    + ":97A::SAFE//94999\n"
                    + ":16S:SETPRTY\n"
                    + ":16R:SETPRTY\n"
                    + ":95P::SELL//DDDDFRPPHCM\n"
                    + ":97A::SAFE//94999\n"
                    + ":16S:SETPRTY\n"
                    + ":16R:SETPRTY\n"
                    + ":95P::PSET//EEEEFRPPXXX\n"
                    + ":16S:SETPRTY\n"
                    + ":16S:SETDET\n"
                    + "-}";

    @Test
    void field20C_should_be_returned_by_MT540_CANC() {
        // Given
        com.prowidesoftware.swift.model.mt.mt5xx.MT540 mt540;
        // When
        try {
            mt540 = (com.prowidesoftware.swift.model.mt.mt5xx.MT540) AbstractMT.parse(MT_540_CANC);
            // Then
            assertThat(mt540.getField20C()).hasSize(2);
            assertThat(mt540.getField20C().get(0).getReference()).isEqualTo("TFH5436259-999");

            Field fieldByName =
                    mt540.getSwiftMessage().getBlock4().getFieldByName(Field20C.NAME, SchemeConstantsS.SEME);
            assertThat(fieldByName.getComponents()).hasSize(2);
            assertThat(fieldByName.getComponent(1)).isEqualTo("SEME");
            assertThat(fieldByName.getComponent(2)).isEqualTo("TFH5436259-999");

        } catch (IOException exception) {
            fail();
        }
    }
}

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

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prowidesoftware.swift.model.field.Field61;
import com.prowidesoftware.swift.model.mt.mt9xx.MT940;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class IssueGh148Test {

    @Test
    public void test() throws IOException {
        String fin = "{1:F01FOOBARXXAXXX0000000000}{2:I940FOOBARXXXXXXN}{4:\r\n" + ":20:REFXXXXX\r\n"
                + ":25:K005201001004509050156\r\n"
                + ":28C:00001\r\n"
                + ":60F:C051007XOF2644893271,0\r\n"
                + ":61:2212051205C,32NDIV252100549047714//RJHIPSH2233901WI000001215560\r\n"
                + ":62F:C061207XOF4123944619,0\r\n"
                + ":86:Message de bienvenue\r\n"
                + ":62M:C100921ZAR499650,23\r\n"
                + "-}";
        MT940 mt940 = MT940.parse(fin);
        List<Field61> field61List = mt940.getField61();
        assertEquals(1, field61List.size());
        Field61 field61 = field61List.get(0);
        double amount = field61.getComponentAsNumber(Field61.AMOUNT).doubleValue();
        assertEquals(0.32d, amount);
    }
}

/*
 * Copyright 2006-2018 Prowide
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
package com.prowidesoftware.swift.issues;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import com.prowidesoftware.swift.model.field.Field61;
import com.prowidesoftware.swift.model.mt.mt9xx.MT940;
import org.junit.Test;

/**
 * https://sourceforge.net/p/wife/bugs/81/
 */
public class TabInFieldValueTest {

    @Test
    public void test() {
        Field61 field = new Field61(":61:1804190419D56716,17NTRF\u000b//XXX 18041900259\n" +
            "FX-NORMAL TRANSACTION");
        assertNotNull(field);

        Field61 field2 = new Field61(":61:1804190419D56716,17NTRF\t//XXX 18041900259\n" +
            "FX-NORMAL TRANSACTION");
        assertNotNull(field2);
    }

    private static final String REF_ACC_OWN = "REFERENCE_BB_ACCOUNTOWNER";
    private static final String REF_ACC_OWN_TAB = "REFERENCE_\u000b\u000b_ACCOUNTOWNER";
    private static final String REF_ACC_OWN_TAB2 = "\u000b\u000b";

    private static final String MESSAGE = "{1:F01ABCDEFGHXXX0000000000}{2:I940WOWAUS6CUXXXX}{4:\n" +
            ":20:1234567890123456\n" +
            ":25:ABCDEFGHXXX/12345678\n" +
            ":28C:12345\n" +
            ":60F:C180418CNY0,00\n" +
            ":61:1804190419D93366,00NTRFREFERENCE_BB_ACCOUNTOWNER//NNN 123456789012\n" +
            "MULTITUDE\n" +
            ":86:/YYYY/\u000b\u000b MARKMS1234/PPPP/RRR93366,00/RASK/\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\n" +
            ":62F:C180419CNY0,00\n" +
            ":64:C180419CNY0,00\n" +
            "-}";

    private static final String MESSAGE_TAB = "{1:F01ABCDEFGHXXX0000000000}{2:I940WOWAUS6CUXXXX}{4:\n" +
            ":20:1234567890123456\n" +
            ":25:ABCDEFGHXXX/12345678\n" +
            ":28C:12345\n" +
            ":60F:C180418CNY0,00\n" +
            ":61:1804190419D93366,00NTRFREFERENCE_\u000b\u000b_ACCOUNTOWNER//NNN 123456789012\n" +
            "MULTITUDE\n" +
            ":86:/YYYY/\u000b\u000b MARKMS1234/PPPP/RRR93366,00/RASK/\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\n" +
            ":62F:C180419CNY0,00\n" +
            ":64:C180419CNY0,00\n" +
            "-}";

    private static final String MESSAGE_TAB2 = "{1:F01ABCDEFGHXXX0000000000}{2:I940WOWAUS6CUXXXX}{4:\n" +
            ":20:1234567890123456\n" +
            ":25:ABCDEFGHXXX/12345678\n" +
            ":28C:12345\n" +
            ":60F:C180418CNY0,00\n" +
            ":61:1804190419D93366,00NTRF\u000b\u000b//NNN 123456789012\n" +
            "MULTITUDE\n" +
            ":86:/YYYY/\u000b\u000b MARKMS1234/PPPP/RRR93366,00/RASK/\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\u000b\n" +
            ":62F:C180419CNY0,00\n" +
            ":64:C180419CNY0,00\n" +
            "-}";

    private void test(final String expected, final String message) {
        final MT940 mt940 = new MT940(message);
        final Field61 field61 = mt940.getField61().get(0);
        final String refAccOwn = field61.getReferenceForTheAccountOwner();
        assertEquals(expected, refAccOwn);
    }

    @Test
    public void message() {
        test(REF_ACC_OWN, MESSAGE);
    }

    @Test
    public void messageTab() {
        test(REF_ACC_OWN_TAB, MESSAGE_TAB);
    }

    @Test
    public void messageTab2() {
        test(REF_ACC_OWN_TAB2, MESSAGE_TAB2);
    }

}

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
package com.prowidesoftware.swift.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftMessage;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * Swift message comparator for tests.
 */
public class AckMessageComparatorTest {

    final String m = "{1:F01AAAAUSC0AXXX6083000009}{2:I103BBBBUSC0XXXXN}{4:\n"
            + ":20:TCLIO200908132\n"
            + ":23B:CRED\n"
            + ":32A:090813USD1000,\n"
            + ":50K:/01115446997234567890\n"
            + "RANGEL GUILARTE MADRIZ\n"
            + "R00000V01321705\n"
            + ":53B:/00010013800002000114\n"
            + "BANCO DEL CARIBE C.A.\n"
            + ":59:/00010013800020001146\n"
            + "BANCO DEL CARIBE C.A.\n"
            + ":71A:OUR\n"
            + ":72:/TIPO/410\n"
            + "-}";
    final String m2 = "{1:F01AAAAUSC0AXXX6083000009}{2:I103BBBBUSC0XXXXN}{4:\n"
            + ":20:TCLIO200908132\n"
            + ":23B:CRED\n"
            + ":32A:090813USD1000,\n"
            + ":50K:/01115446997234567890\n"
            + "RANGEL GUILARTE MADRIZ\n"
            + "R00000V01321705\n"
            + ":53B:/00010013800002000114\n"
            + "BANCO DEL CARIBE C.A.\n"
            + ":59:/00010013800020001146\n"
            + "BANCO DEL CARIBE C.A.\n"
            + ":71A:OUR\n"
            + ":72:/TIPO/410\n"
            + "-}";
    final String ack = "{1:F01AAAAUSC0AXXX6083000009}{2:I103BBBBUSC0XXXXN}{4:\n"
            + ":20:TCLIO200908132\n"
            + ":23B:CRED\n"
            + ":32A:090813USD1000,\n"
            + ":50K:/01115446997234567890\n"
            + "RANGEL GUILARTE MADRIZ\n"
            + "R00000V01321705\n"
            + ":53B:/00010013800002000114\n"
            + "BANCO DEL CARIBE C.A.\n"
            + ":59:/00010013800020001146\n"
            + "BANCO DEL CARIBE C.A.\n"
            + ":71A:OUR\n"
            + ":72:/TIPO/410\n"
            + "-}";

    @Test
    public void test1() {
        SwiftBlock1 b1 = new SwiftBlock1();
        b1.setApplicationId("foo");
        b1.setLogicalTerminal("term");
        b1.setSequenceNumber("1234");
        b1.setServiceId("99");
        b1.setSessionNumber("190");

        SwiftBlock1 b2 = new SwiftBlock1();
        b2.setApplicationId("foo");
        b2.setLogicalTerminal("term");
        b2.setSequenceNumber("1234");
        b2.setServiceId("99");
        b2.setSessionNumber("190");

        AckMessageComparator comp = new AckMessageComparator();
        assertTrue(comp.compareB1(b1, b2));

        b2.setSequenceNumber("99999999999999999999");
        b2.setSessionNumber("9999999999999999999999");

        /*
         * Check that changing these values compare still returns true
         */
        assertTrue(comp.compareB1(b1, b2));
    }

    @Test
    public void testCompare() throws IOException {
        AckMessageComparator c = new AckMessageComparator();
        SwiftMessage ackMsg = new SwiftParser(ack).message();
        SwiftMessage mMsg = new SwiftParser(m).message();
        assertEquals(m, m2);
        assertEquals(0, c.compare(ackMsg, mMsg));
        ackMsg.getBlock1().setSequenceNumber("X");
        ackMsg.getBlock1().setSessionNumber("X");
        assertEquals(0, c.compare(ackMsg, mMsg));
    }

    @Test
    public void testCompare2() throws IOException {
        String fin1 = "{1:F01AAAADEF0AXXX0023000109}{2:I999BBBBGB20AXXXN}{4:\r\n" + ":20:1234\r\n"
                + ":21:REPORT NAN\r\n"
                + ":79:TEST 13 NOV 2020\r\n"
                + "-}{5:{CHK:201113000184}{TNG:}}";

        String fin2 = "{1:F01AAAADEF0BXXX0000000000}{2:I999BBBBGB20XXXXN}{4:\r\n" + ":20:1234\r\n"
                + ":21:REPORT NAN\r\n"
                + ":79:TEST 13 NOV 2020\r\n"
                + "-}";

        AckMessageComparator comp = new AckMessageComparator();
        SwiftMessage msg1 = SwiftMessage.parse(fin1);
        SwiftMessage msg2 = SwiftMessage.parse(fin2);
        assertEquals(1, comp.compare(msg1, msg2));

        comp.setIgnoreLT(true);
        assertEquals(0, comp.compare(msg1, msg2));
    }

    @Test
    public void testCompare3() throws IOException {
        String fin1 = "{1:F01AAAADEFXAXXX0023000109}{2:I999BBBBGB22XXXXN}{4:\r\n" + ":20:1234\r\n"
                + ":21:REPORT NAN\r\n"
                + ":79:TEST 13 NOV 2020\r\n"
                + "-}{5:{CHK:201113000184}{TNG:}}";

        String fin2 = "{1:F01AAAADEF0AXXX0023000109}{2:I999BBBBGB20XXXXN}{4:\r\n" + ":20:1234\r\n"
                + ":21:REPORT NAN\r\n"
                + ":79:TEST 13 NOV 2020\r\n"
                + "-}";

        AckMessageComparator comp = new AckMessageComparator();
        SwiftMessage msg1 = SwiftMessage.parse(fin1);
        SwiftMessage msg2 = SwiftMessage.parse(fin2);
        assertEquals(1, comp.compare(msg1, msg2));

        comp.setIgnoreLocationFlag(true);
        assertEquals(0, comp.compare(msg1, msg2));
    }
}

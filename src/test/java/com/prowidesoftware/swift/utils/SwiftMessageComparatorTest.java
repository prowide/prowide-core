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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.SwiftBlock2Output;
import com.prowidesoftware.swift.model.SwiftMessage;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * Swift message comparator for tests.
 */
public class SwiftMessageComparatorTest {

    @Test
    public void testB1() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock1 left = new SwiftBlock1();
        assertTrue(comp.compareB1(left, left));

        left.setLogicalTerminal("FOOBARXAXXXX");
        assertTrue(comp.compareB1(left, left));

        left.setSequenceNumber("123456");
        assertTrue(comp.compareB1(left, left));

        left.setSessionNumber("1234");
        assertTrue(comp.compareB1(left, left));

        SwiftBlock1 right = new SwiftBlock1();
        right.setLogicalTerminal(left.getLogicalTerminal());
        right.setSequenceNumber(left.getSequenceNumber());
        right.setSessionNumber(left.getSessionNumber());
        assertTrue(comp.compareB1(left, right));

        right.setLogicalTerminal("QQQQARXAXXXX");
        assertFalse(comp.compareB1(left, right));
    }

    @Test
    public void testB1SequenceAndSession() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock1 left = new SwiftBlock1();
        left.setLogicalTerminal("FOOBARXAXXXX");
        left.setSequenceNumber("123456");
        left.setSessionNumber("1234");

        SwiftBlock1 right = new SwiftBlock1();
        right.setLogicalTerminal(left.getLogicalTerminal());
        right.setSequenceNumber("666666");
        right.setSessionNumber("4444");

        assertFalse(comp.compareB1(left, right));

        comp.setIgnoreHeaderSession(true);
        assertTrue(comp.compareB1(left, right));
    }

    @Test
    public void testB1LT() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock1 left = new SwiftBlock1();
        left.setLogicalTerminal("FOOBARXXAXXX");

        SwiftBlock1 right = new SwiftBlock1();
        right.setLogicalTerminal("FOOBARXXBXXX");

        assertFalse(comp.compareB1(left, right));

        comp.setIgnoreLT(true);
        assertTrue(comp.compareB1(left, right));
    }

    @Test
    public void testB1Location() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock1 left = new SwiftBlock1();
        left.setLogicalTerminal("FOOBARXXAXXX");

        SwiftBlock1 right = new SwiftBlock1();
        right.setLogicalTerminal("FOOBARX0AXXX");

        assertFalse(comp.compareB1(left, right));

        comp.setIgnoreLocationFlag(true);
        assertTrue(comp.compareB1(left, right));
    }

    @Test
    public void testB2Input() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock2Input left = new SwiftBlock2Input("I103BBBBUSC0XXXXN");
        assertTrue(comp.compareB2(left, left));

        SwiftBlock2Input right = new SwiftBlock2Input("I103BBBBUSC0XXXXN");
        assertTrue(comp.compareB2(left, right));

        right.setDeliveryMonitoring("3");
        assertFalse(comp.compareB2(left, right));
    }

    @Test
    public void testB2InputOptionalFields() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock2Input left = new SwiftBlock2Input("I103BBBBUSC0XXXXN");
        left.setDeliveryMonitoring("3");
        SwiftBlock2Input right = new SwiftBlock2Input("I103BBBBUSC0XXXXN");
        assertFalse(comp.compareB2(left, right));

        comp.setIgnoreBlock2OptionalFields(true);

        // block values differ but compare will be true because we are ignoring optional fields
        assertFalse(left.getValue().equals(right.getValue()));
        assertTrue(comp.compareB2(left, right));

        left.setObsolescencePeriod("003");
        assertTrue(comp.compareB2(left, right));

        comp.setIgnoreBlock2OptionalFields(false);
        assertFalse(comp.compareB2(left, right));
    }

    @Test
    public void testB2InputLT() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock2Input left = new SwiftBlock2Input("I103BBBBUSCAXXXXN");
        SwiftBlock2Input right = new SwiftBlock2Input("I103BBBBUSCABXXXN");
        assertFalse(comp.compareB2(left, right));

        comp.setIgnoreLT(true);
        assertTrue(comp.compareB2(left, right));
    }

    @Test
    public void testB2InputLocation() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock2Input left = new SwiftBlock2Input("I103BBBBUSC0XXXXN");
        SwiftBlock2Input right = new SwiftBlock2Input("I103BBBBUSCAXXXXN");
        assertFalse(comp.compareB2(left, right));

        comp.setIgnoreLocationFlag(true);
        assertTrue(comp.compareB2(left, right));
    }

    @Test
    public void testB2InputPriority() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock2Input left = new SwiftBlock2Input("I103BBBBUSCAXXXXN");
        SwiftBlock2Input right = new SwiftBlock2Input("I103BBBBUSCAXXXXU");
        assertFalse(comp.compareB2(left, right));

        comp.setIgnorePriority(true);
        assertTrue(comp.compareB2(left, right));
    }

    @Test
    public void testB2Output() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock2Output b3 = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N");
        assertTrue(comp.compareB2(b3, b3));

        SwiftBlock2Output b4 = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N");
        assertTrue(comp.compareB2(b3, b4));

        b4.setMessageType("999");
        assertFalse(comp.compareB2(b3, b4));
    }

    @Test
    public void testB2OutputLT() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock2Output b3 = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N");
        SwiftBlock2Output b4 = new SwiftBlock2Output("O1001200010103BANKBEBBBXXX22221234560101031201N");
        assertFalse(comp.compareB2(b3, b4));

        comp.setIgnoreLT(true);
        assertTrue(comp.compareB2(b3, b4));
    }

    @Test
    public void testB2OutputLocation() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock2Output b3 = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N");
        SwiftBlock2Output b4 = new SwiftBlock2Output("O1001200010103BANKBEB0AXXX22221234560101031201N");
        assertFalse(comp.compareB2(b3, b4));

        comp.setIgnoreLocationFlag(true);
        assertTrue(comp.compareB2(b3, b4));
    }

    @Test
    public void testB2OutputPriority() {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftBlock2Output b3 = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N");
        SwiftBlock2Output b4 = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201U");
        assertFalse(comp.compareB2(b3, b4));

        comp.setIgnorePriority(true);
        assertTrue(comp.compareB2(b3, b4));
    }

    @Test
    public void testFullMessage() throws IOException {
        SwiftMessageComparator comp = new SwiftMessageComparator();
        assertTrue(comp.compare(new SwiftMessage(), new SwiftMessage()) == 0);

        final String fin = "{1:F01AAAAUSC0AXXX6083000009}{2:I103BBBBUSC0XXXXN}{4:\n"
                + ":20:TCLIO200908132\n"
                + ":23B:CRED\n"
                + ":32A:090813USD1000,\n"
                + ":50K:/01115446997234567890\n"
                + "FOO GUILARTE MADRIZ\n"
                + "R00000V01321705\n"
                + ":53B:/00010013800002000114\n"
                + "BANCO DEL CARIBE C.A.\n"
                + ":59:/00010013800020001146\n"
                + "BANCO DEL CARIBE C.A.\n"
                + ":71A:OUR\n"
                + ":72:/TIPO/410\n"
                + "-}";
        SwiftMessage m1 = SwiftMessage.parse(fin);
        assertTrue(comp.compare(m1, m1) == 0);

        SwiftMessage m2 = SwiftMessage.parse(fin);
        assertTrue(comp.compare(m1, m2) == 0);

        m2.getBlock4().getTagByName("20").setValue("FOO");
        assertTrue(comp.compare(m1, m2) != 0);

        comp.addTagnameToIgnore("20");
        assertTrue(comp.compare(m1, m2) == 0);

        m2.getBlock4().getTagByName("53B").setValue("/00010013800002000114\r\nBANCO DEL CARIBE C.A.");
        assertTrue(comp.compare(m1, m2) != 0);

        comp.setIgnoreEolsInMultiline(true);
        assertTrue(comp.compare(m1, m2) == 0);
    }

    @Test
    public void testB3() throws IOException {
        SwiftMessageComparator comp = new SwiftMessageComparator();

        SwiftMessage msg1 = SwiftMessage.parse(
                "{1:F01BICFOOYYAXXX8667486276}{2:O1031610051014IRVTUS3NBXXX63382244920510142210N}{3:{108:FDF0510141142100}{121:8579f4a4-a547-463e-ae63-e7c6620d59b4}}{4:\n"
                        + ":20:FDF0510141142100\n"
                        + ":72:/ACC/ 00940060752415000231\n"
                        + "-}");
        assertTrue(comp.compare(msg1, msg1) == 0);

        SwiftMessage msg2 = SwiftMessage.parse(
                "{1:F01BICFOOYYAXXX8667486276}{2:O1031610051014IRVTUS3NBXXX63382244920510142210N}{3:{108:FDF0510141142100}}{4:\n"
                        + ":20:FDF0510141142100\n"
                        + ":72:/ACC/ 00940060752415000231\n"
                        + "-}");

        SwiftMessage msg3 = SwiftMessage.parse(
                "{1:F01BICFOOYYAXXX8667486276}{2:O1031610051014IRVTUS3NBXXX63382244920510142210N}{3:{121:8579f4a4-a547-463e-ae63-e7c6620d59b4}}{4:\n"
                        + ":20:FDF0510141142100\n"
                        + ":72:/ACC/ 00940060752415000231\n"
                        + "-}");

        assertTrue(comp.compare(msg2, msg3) != 0);

        comp.setIgnoreBlock3(true);
        assertTrue(comp.compare(msg2, msg3) == 0);
    }
}

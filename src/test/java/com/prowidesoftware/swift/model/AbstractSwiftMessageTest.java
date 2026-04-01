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

package com.prowidesoftware.swift.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test for {@link AbstractSwiftMessage} model API
 *
 * @since 7.8.4
 */
public class AbstractSwiftMessageTest {

    @Test
    public void match() {
        MtSwiftMessage msg = new MtSwiftMessage();
        assertFalse(msg.match(""));
        assertFalse(msg.match(null));

        msg.setIdentifier("");
        assertFalse(msg.match(""));
        assertFalse(msg.match(null));

        msg.setIdentifier("fin.103");
        assertFalse(msg.match(""));
        assertFalse(msg.match(null));
        assertTrue(msg.match("fin.103"));
        assertTrue(msg.match("fin.103|fin.102"));
        assertTrue(msg.match("fin.*"));
        assertFalse(msg.match("fin.*STP"));

        msg.setIdentifier("camt.002.002.01");
        assertTrue(msg.match("camt.*"));
        assertTrue(msg.match("camt.*01"));
        assertTrue(msg.match("camt\\..*01"));
    }

    @Test
    public void category() {
        MtSwiftMessage mt = new MtSwiftMessage();
        assertEquals("", mt.getCategory());

        mt.setIdentifier("");
        assertEquals("", mt.getCategory());

        mt.setIdentifier("fin.103");
        assertEquals("1", mt.getCategory());
    }

    @Test
    public void copyTo() {
        String fin =
                "{1:F01ABCDEFGHAXXX8669486760}{2:I103XYZWABCDXXXXN}{3:{108:REF123}{121:eb6305c9-1f7f-49de-aed0-16487c27b42d}}{4:\n"
                        + ":20:REFERENCE123\n"
                        + ":23B:CRED\n"
                        + ":32A:251018EUR1234,56\n"
                        + ":50K:/12345678\n"
                        + "ORDERING CUSTOMER\n"
                        + ":59:/87654321\n"
                        + "BENEFICIARY\n"
                        + ":71A:OUR\n"
                        + "-}";

        MtSwiftMessage source = MtSwiftMessage.parse(fin);

        MtSwiftMessage target = new MtSwiftMessage();
        source.copyTo(target);

        assertEquals(source.getMessage(), target.getMessage());
        assertEquals(source.getIdentifier(), target.getIdentifier());
        assertEquals(source.getSender(), target.getSender());
        assertEquals(source.getReceiver(), target.getReceiver());
        assertEquals(source.getDirection(), target.getDirection());
        assertEquals(source.getChecksum(), target.getChecksum());
        assertEquals(source.getChecksumBody(), target.getChecksumBody());
        assertEquals(source.getReference(), target.getReference());
        assertEquals(source.getCurrency(), target.getCurrency());
        assertEquals(source.getAmount(), target.getAmount());
        assertEquals(source.getValueDate(), target.getValueDate());
        assertEquals(source.getUetr(), target.getUetr());
        assertEquals("eb6305c9-1f7f-49de-aed0-16487c27b42d", target.getUetr());
    }
}

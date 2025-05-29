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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.prowidesoftware.swift.model.mt.DefaultMtMetadataStrategy;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.prowidesoftware.swift.model.mt.mt7xx.MT798;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class MtSwiftMessageTest {

    @Test
    public void testParseMt() {
        String fin = "{1:F01AGBLLT2XAXXX1012000002}{2:I103TESTARZZXXXXN}{3:{108:MYMUR123458}}{4:\n"
                + ":20:TEST\n"
                + ":32A:090903USD23453,"
                + "-}";
        MtSwiftMessage mt = MtSwiftMessage.parse(fin);
        assertEquals("AGBLLT2XXXX", mt.getSender());
        assertEquals("TESTARZZXXX", mt.getReceiver());
        assertEquals("MYMUR123458", mt.getMur());
        assertEquals("TEST", mt.getReference());
        assertEquals("USD", mt.getCurrency());
        assertEquals(new BigDecimal("23453"), mt.getAmount());
        Calendar valueDate = mt.getValueDate();
        assertEquals(2009, valueDate.get(Calendar.YEAR));
        assertEquals(Calendar.SEPTEMBER, valueDate.get(Calendar.MONTH));
        assertEquals(3, valueDate.get(Calendar.DAY_OF_MONTH));
        assertNull(mt.getTradeDate());
    }

    @Test
    public void testParseAck() {
        String fin = "{1:F21AAAALT2XAXXX0000000000}{4:{177:1903250612}{451:0}{108:MYMUR123458}}";
        MtSwiftMessage mt = MtSwiftMessage.parse(fin);

        assertEquals("MYMUR123458", mt.getMur());
        assertEquals("MYMUR123458", mt.getReference());

        // the receiver and sender are swapped in the ACK because the ACK is sent by the SWIFT interface back to the
        // sender of the original message. From the ACK perspective, the original sender is the receiver of the ACK.
        assertEquals("AAAALT2XXXX", mt.getReceiver());

        // the ACK itself (service 21) does not have a sender (it is sent by the SWIFT interface)
        assertNull(mt.getSender());

        assertNull(mt.getTradeDate());
        assertNull(mt.getValueDate());
        assertNull(mt.getCurrency());
        assertNull(mt.getAmount());
    }

    @Test
    public void testParseAckWithOriginalMessageCopy() {
        String fin =
                "{1:F21AAAALT2XAXXX0000000000}{4:{177:1903250612}{451:0}}{1:F01AAAALT2XAXXX1012000002}{2:I103BBBBARZZXXXXN}{4:\n"
                        + ":20:TEST\n"
                        + ":32A:090903USD23453,"
                        + "-}";
        MtSwiftMessage mt = MtSwiftMessage.parse(fin);

        assertNull(mt.getMur());
        assertEquals("TEST", mt.getReference());

        // the receiver and sender are swapped in the ACK because the ACK is sent by the SWIFT interface back to the
        // sender of the original message. From the ACK perspective, the original sender is the receiver of the ACK.
        assertEquals("AAAALT2XXXX", mt.getReceiver());

        // the ACK itself (service 21) does not have a sender (it is sent by the SWIFT interface) however for
        // convenience
        // we extract as sender the counterparty BIC in the original message
        assertEquals("BBBBARZZXXX", mt.getSender());

        assertNull(mt.getTradeDate());

        // we extract the value date from the original message
        Calendar valueDate = mt.getValueDate();
        assertEquals(2009, valueDate.get(Calendar.YEAR));
        assertEquals(Calendar.SEPTEMBER, valueDate.get(Calendar.MONTH));
        assertEquals(3, valueDate.get(Calendar.DAY_OF_MONTH));

        // the original message has an amount, we extract it
        assertEquals(new BigDecimal("23453"), mt.getAmount());
        assertEquals("USD", mt.getCurrency());
    }

    @Test
    public void testUpdateMetadata() {
        String fin = "{1:F01AGBLLT2XAXXX1012000002}{2:I399TESTARZZXXXXN}{3:{108:MYMUR123458}}{4:\n" + ":20:TEST\n"
                + ":79:AAAAA\n"
                + "-}";

        MtSwiftMessage mt = MtSwiftMessage.parse(fin);

        // default metadata
        assertEquals("AGBLLT2XXXX", mt.getSender());
        assertEquals("TESTARZZXXX", mt.getReceiver());
        assertEquals("MYMUR123458", mt.getMur());
        assertEquals("TEST", mt.getReference());

        // update metadata
        mt.updateMetadata(new TestMtMetadataStrategy());
        assertEquals("REFERENCE", mt.getReference());
        assertEquals(new BigDecimal("1234.56"), mt.getAmount());
        assertEquals("USD", mt.getCurrency());
        assertNull(mt.getValueDate());
        assertNull(mt.getTradeDate());
    }

    @Test
    public void testUpdateMetadata2() {
        String fin =
                "{1:F01AGBLLT2XAXXX1012000002}{2:I399TESTARZZXXXXN}{3:{108:MYMUR123458}}{4:\n" + ":79:AAAAA\n" + "-}";
        MtSwiftMessage mt = MtSwiftMessage.parse(fin);

        // default metadata
        assertEquals("AGBLLT2XXXX", mt.getSender());
        assertEquals("TESTARZZXXX", mt.getReceiver());
        assertEquals("MYMUR123458", mt.getMur());
        assertEquals("MYMUR123458", mt.getReference());
        assertNull(mt.getCurrency());
        assertNull(mt.getAmount());

        // preset some values
        mt.setReference("MYREFERENCE");
        mt.setCurrency("EUR");
        mt.setAmount(new BigDecimal("333.33"));

        // update metadata
        mt.updateMetadata(new DefaultMtMetadataStrategy());
        assertEquals("AGBLLT2XXXX", mt.getSender());
        assertEquals("TESTARZZXXX", mt.getReceiver());
        assertEquals("MYMUR123458", mt.getReference()); // updated
        assertEquals(new BigDecimal("333.33"), mt.getAmount()); // preserved
        assertEquals("EUR", mt.getCurrency()); // preserved
        assertNull(mt.getValueDate());
        assertNull(mt.getTradeDate());
    }

    @Test
    void testParseInvalidPayload() {
        MtSwiftMessage msg = MtSwiftMessage.parse("foo bar");
        assertNull(msg.getMessageType());
        assertNull(msg.getSender());

        SwiftMessage swiftMessage = msg.modelMessage();
        assertNull(swiftMessage.getBlock1());
        assertNull(swiftMessage.getBlock2());
        assertNull(swiftMessage.getBlock3());
        assertNull(swiftMessage.getBlock4());
        assertNull(swiftMessage.getBlock5());
        assertNull(swiftMessage.getUserBlocks());

        // Although we may wrap it as an MT
        MT103 mt103 = new MT103(msg);

        // thew MT content is null
        assertNull(mt103.getField20());
        assertNull(mt103.getField32A());
    }

    @Test
    void testParseEmptyPayload() {
        MtSwiftMessage msg = MtSwiftMessage.parse("");
        assertNull(msg.getMessageType());
        assertNull(msg.getSender());

        SwiftMessage swiftMessage = msg.modelMessage();
        assertNull(swiftMessage.getBlock1());
        assertNull(swiftMessage.getBlock2());
        assertNull(swiftMessage.getBlock3());
        assertNull(swiftMessage.getBlock4());
        assertNull(swiftMessage.getBlock5());
        assertNull(swiftMessage.getUserBlocks());

        // Although we may wrap it as an MT
        MT103 mt103 = new MT103(msg);

        // thew MT content is null
        assertNull(mt103.getField20());
        assertNull(mt103.getField32A());
    }

    @Test
    void testParseInvalidHeader() {
        MtSwiftMessage msg = MtSwiftMessage.parse("Big blue sea{4:\n" + ":20:123456789\n"
                + ":77E:\n"
                + ":27A:2/3\n"
                + ":15A:\n"
                + ":27:3/5\n"
                + "-}dark green forrest");

        // Still cast to a specific type
        MT798 mt798 = new MT798(msg);

        assertEquals("798", mt798.getMessageType());

        // missing field is is null, as expected
        assertNull(mt798.getField12());

        // The content of block 4 is still available
        assertEquals("123456789", mt798.getField20().getValue());
    }

    public static class TestMtMetadataStrategy implements MessageMetadataStrategy {

        @Override
        public Optional<String> reference(AbstractMessage message) {
            return Optional.of("REFERENCE");
        }

        @Override
        public Optional<Money> amount(AbstractMessage message) {
            return Optional.of(new Money("USD", new BigDecimal("1234.56")));
        }

        @Override
        public Optional<Calendar> valueDate(AbstractMessage message) {
            return Optional.empty();
        }

        @Override
        public Optional<Calendar> tradeDate(AbstractMessage message) {
            return Optional.empty();
        }
    }
}

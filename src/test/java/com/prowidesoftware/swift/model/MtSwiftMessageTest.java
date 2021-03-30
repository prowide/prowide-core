/*
 * Copyright 2006-2020 Prowide
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

import com.prowidesoftware.swift.model.mt.DefaultMtMetadataStrategy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MtSwiftMessageTest {

    @Test
    public void testParseMt() {
        String fin = "{1:F01AGBLLT2XAXXX1012000002}{2:I399TESTARZZXXXXN}{3:{108:MYMUR123458}}{4:\n" +
                ":20:TEST\n" +
                ":79:AAAAA\n" +
                "-}";
        MtSwiftMessage mt = MtSwiftMessage.parse(fin);
        assertEquals("AGBLLT2XXXX", mt.getSender());
        assertEquals("TESTARZZXXX", mt.getReceiver());
        assertEquals("MYMUR123458", mt.getMur());
        assertEquals("TEST", mt.getReference());
    }

    @Test
    public void testParseAck() {
        String fin = "{1:F21AGBLLT2XAXXX0000000000}{4:{177:1903250612}{451:0}{108:MYMUR123458}}{1:F01AGBLLT2XAXXX1012000002}{2:I399TESTARZZXXXXN}{4:\n" +
                ":20:TEST\n" +
                ":79:AAAAA\n" +
                "-}";
        MtSwiftMessage mt = MtSwiftMessage.parse(fin);
        assertEquals("MYMUR123458", mt.getMur());
        assertEquals("TEST", mt.getReference());
    }

    @Test
    public void testUpdateMetadata() {
        String fin = "{1:F01AGBLLT2XAXXX1012000002}{2:I399TESTARZZXXXXN}{3:{108:MYMUR123458}}{4:\n" +
                ":20:TEST\n" +
                ":79:AAAAA\n" +
                "-}";

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

    public class TestMtMetadataStrategy implements MessageMetadataStrategy {

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

    @Test
    public void testUpdateMetadata2() {
        String fin = "{1:F01AGBLLT2XAXXX1012000002}{2:I399TESTARZZXXXXN}{3:{108:MYMUR123458}}{4:\n" +
                ":79:AAAAA\n" +
                "-}";
        MtSwiftMessage mt = MtSwiftMessage.parse(fin);

        // default metadata
        assertEquals("AGBLLT2XXXX", mt.getSender());
        assertEquals("TESTARZZXXX", mt.getReceiver());
        assertEquals("MYMUR123458", mt.getMur());
        assertNull(mt.getReference());
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
        assertEquals("MYREFERENCE", mt.getReference()); // preserved
        assertEquals(new BigDecimal("333.33"), mt.getAmount()); // preserved
        assertEquals("EUR", mt.getCurrency()); // preserved
        assertNull(mt.getValueDate());
        assertNull(mt.getTradeDate());
    }

}

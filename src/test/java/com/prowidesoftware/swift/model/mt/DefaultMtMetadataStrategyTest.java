package com.prowidesoftware.swift.model.mt;

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.model.Money;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

class DefaultMtMetadataStrategyTest {

    @Test
    public void testParseMt() throws IOException {
        AbstractMT mt = AbstractMT.parse("{1:F01AGBLLT2XAXXX1012000002}{2:I103TESTARZZXXXXN}{3:{108:MYMUR123458}}{4:\n"
                + ":20:TEST\n"
                + ":32A:090903USD23453,"
                + "-}");
        DefaultMtMetadataStrategy strategy = new DefaultMtMetadataStrategy();

        assertEquals("TEST", strategy.reference(mt).orElse(null));

        Money money = strategy.amount(mt).orElse(null);
        assertNotNull(money);
        assertEquals("USD", money.getCurrency());
        assertEquals(new BigDecimal("23453"), money.getAmount());

        Calendar valueDate = strategy.valueDate(mt).orElse(null);
        assertNotNull(valueDate);
        assertEquals(2009, valueDate.get(Calendar.YEAR));
        assertEquals(Calendar.SEPTEMBER, valueDate.get(Calendar.MONTH));
        assertEquals(3, valueDate.get(Calendar.DAY_OF_MONTH));

        assertNull(strategy.tradeDate(mt).orElse(null));

        assertEquals("AGBLLT2XXXX", strategy.sender(mt).orElse(null));
        assertEquals("TESTARZZXXX", strategy.receiver(mt).orElse(null));

        assertEquals("fin.103", strategy.identifier(mt).orElse(null));
    }

    @Test
    public void testParseAck() throws IOException {
        AbstractMT mt = AbstractMT.parse("{1:F21AAAALT2XAXXX0000000000}{4:{177:1903250612}{451:0}{108:MYMUR123458}}");

        DefaultMtMetadataStrategy strategy = new DefaultMtMetadataStrategy();

        assertEquals("MYMUR123458", strategy.reference(mt).orElse(null));
        assertNull(strategy.amount(mt).orElse(null));
        assertNull(strategy.valueDate(mt).orElse(null));
        assertNull(strategy.tradeDate(mt).orElse(null));

        // the receiver and sender are swapped in the ACK because the ACK is sent by the SWIFT interface back to the
        // sender of the original message. From the ACK perspective, the original sender is the receiver of the ACK.
        assertEquals("AAAALT2XXXX", strategy.receiver(mt).orElse(null));

        // the ACK itself (service 21) does not have a sender (it is sent by the SWIFT interface)
        assertNull(strategy.sender(mt).orElse(null));

        assertEquals("ACK", strategy.identifier(mt).orElse(null));
    }

    @Test
    public void testParseNak() throws IOException {
        AbstractMT mt = AbstractMT.parse("{1:F21AAAALT2XAXXX0000000000}{4:{177:1903250612}{451:1}{108:MYMUR123458}}");

        DefaultMtMetadataStrategy strategy = new DefaultMtMetadataStrategy();

        assertEquals("MYMUR123458", strategy.reference(mt).orElse(null));
        assertNull(strategy.amount(mt).orElse(null));
        assertNull(strategy.valueDate(mt).orElse(null));
        assertNull(strategy.tradeDate(mt).orElse(null));

        // the receiver and sender are swapped in the ACK because the ACK is sent by the SWIFT interface back to the
        // sender of the original message. From the ACK perspective, the original sender is the receiver of the ACK.
        assertEquals("AAAALT2XXXX", strategy.receiver(mt).orElse(null));

        // the ACK itself (service 21) does not have a sender (it is sent by the SWIFT interface)
        assertNull(strategy.sender(mt).orElse(null));

        assertEquals("NAK", strategy.identifier(mt).orElse(null));
    }

    @Test
    public void testParseAckWithOriginalMessageCopy() throws IOException {
        AbstractMT mt = AbstractMT.parse(
                "{1:F21AAAALT2XAXXX0000000000}{4:{177:1903250612}{451:0}}{1:F01AAAALT2XAXXX1012000002}{2:I103BBBBARZZXXXXN}{4:\n"
                        + ":20:TEST\n"
                        + ":32A:090903USD23453,"
                        + "-}");

        DefaultMtMetadataStrategy strategy = new DefaultMtMetadataStrategy();

        assertEquals("TEST", strategy.reference(mt).orElse(null));

        // the original message is included in the ACK, we can extract the amount from it
        Money money = strategy.amount(mt).orElse(null);
        assertNotNull(money);
        assertEquals("USD", money.getCurrency());
        assertEquals(new BigDecimal("23453"), money.getAmount());

        // the original message is included in the ACK, we can extract the value date from it
        Calendar valueDate = strategy.valueDate(mt).orElse(null);
        assertNotNull(valueDate);
        assertEquals(2009, valueDate.get(Calendar.YEAR));
        assertEquals(Calendar.SEPTEMBER, valueDate.get(Calendar.MONTH));
        assertEquals(3, valueDate.get(Calendar.DAY_OF_MONTH));

        assertNull(strategy.tradeDate(mt).orElse(null));

        // the receiver and sender are swapped in the ACK because the ACK is sent by the SWIFT interface back to the
        // sender of the original message. From the ACK perspective, the original sender is the receiver of the ACK.
        assertEquals("AAAALT2XXXX", strategy.receiver(mt).orElse(null));

        // the ACK itself (service 21) does not have a sender (it is sent by the SWIFT interface) however for conveniece
        // we extract as sender the counterparty BIC in the origina message
        assertEquals("BBBBARZZXXX", strategy.sender(mt).orElse(null));

        assertEquals("ACK", strategy.identifier(mt).orElse(null));
    }
}

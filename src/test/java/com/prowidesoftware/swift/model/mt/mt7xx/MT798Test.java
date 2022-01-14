package com.prowidesoftware.swift.model.mt.mt7xx;

import com.prowidesoftware.swift.model.SwiftMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MT798Test {

    @Test
    public void testSubMessageType() {
        String fin = "{1:F01AAAADEM0AXXX0000000000}{2:I798BBBBITRRXMCEN2020}{4:\n" +
                ":20:12345\n" +
                ":12:760\n" +
                ":77E:\n" +
                ":27A:2/2\n" +
                ":21A:2201091711320000\n" +
                ":15A:\n" +
                ":27:1/1\n" +
                ":22A:ISSU\n" +
                ":15B:\n" +
                ":20:Bla Blah\n" +
                ":30:250109\n" +
                ":22D:DGAR\n" +
                ":40C:ISPR\n" +
                ":23B:FIXD\n" +
                ":31E:250109\n" +
                ":35G:If things happen\n" +
                ":50:Mr. App\n" +
                "This Way\n" +
                "Our City\n" +
                ":51:Mr. Obligor\n" +
                "His stay\n" +
                ":52D:Mr. Issue\n" +
                ":59:Mr. Bene\n" +
                "In Road\n" +
                ":56A:ANLAITRRMFE\n" +
                ":32B:USD23456789,\n" +
                ":77U:Terms and conditions\n" +
                "have been defined\n" +
                ":45L:Some details\n" +
                "about the underlying tx\n" +
                ":24E:MAIL\n" +
                ":24G:OTHR\n" +
                "Foobar\n" +
                "-}";
        MT798 mt798 = MT798.parse(fin);
        assertEquals(26, mt798.getSwiftMessage().getBlock4().getTags().size());

        SwiftMessage subMessage = mt798.getSubMessage();
        assertEquals(23, subMessage.getBlock4().getTags().size());
        assertEquals("760", subMessage.getBlock2().getMessageType());

        MT760 mt = (MT760) subMessage.toMT();
        assertEquals("MAIL", mt.getField24E().get(0).getValue());
    }

}

package com.prowidesoftware.swift.model.mt.mt9xx;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prowidesoftware.swift.model.field.Field12;
import com.prowidesoftware.swift.model.field.Field25;
import com.prowidesoftware.swift.model.field.Field34F;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MT920Test {

    final String message =
            "{1:F01AAAACAX0BXXX0502000001}{2:I920BBBBAU21XXXXN}{3:{108:19B12BFE0F043124}{121:f0c54bfc-77a5-4bc6-9a5b-0e50d3975960}}{4:\n"
                    + ":20:bb131231234\n"
                    + ":12:940\n"
                    + ":25:111111111111\n"
                    + ":34F:USDD1100,\n"
                    + ":34F:EURC1200,\n"
                    + ":12:941\n"
                    + ":25:2222222222\n"
                    + ":34F:USDD2100,\n"
                    + ":34F:USDC2200,\n"
                    + ":12:950\n"
                    + ":25:3333333333\n"
                    + ":34F:USDC3100,\n"
                    + ":12:942\n"
                    + ":25:CH9000244444G76402290\n"
                    + "-}";

    @Test
    public void test() {
        MT920 mt = MT920.parse(message);

        // check Loop API
        List<MT920.Loop1> loops = mt.getLoop1List();
        assertEquals(4, loops.size());

        assertEquals("940", loops.get(0).getTagValue(Field12.NAME));
        assertEquals("111111111111", loops.get(0).getTagValue(Field25.NAME));
        assertEquals("USDD1100,", loops.get(0).getTagsByName(Field34F.NAME)[0].getValue());
        assertEquals("EURC1200,", loops.get(0).getTagsByName(Field34F.NAME)[1].getValue());

        assertEquals("941", loops.get(1).getTagValue(Field12.NAME));
        assertEquals("2222222222", loops.get(1).getTagValue(Field25.NAME));
        assertEquals("USDD2100,", loops.get(1).getTagsByName(Field34F.NAME)[0].getValue());
        assertEquals("USDC2200,", loops.get(1).getTagsByName(Field34F.NAME)[1].getValue());

        assertEquals("950", loops.get(2).getTagValue(Field12.NAME));
        assertEquals("3333333333", loops.get(2).getTagValue(Field25.NAME));
        assertEquals("USDC3100,", loops.get(2).getTagsByName(Field34F.NAME)[0].getValue());

        assertEquals("942", loops.get(3).getTagValue(Field12.NAME));
        assertEquals("CH9000244444G76402290", loops.get(3).getTagValue(Field25.NAME));
    }
}

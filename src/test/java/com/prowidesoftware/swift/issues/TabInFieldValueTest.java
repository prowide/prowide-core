package com.prowidesoftware.swift.issues;

import static org.junit.Assert.assertNotNull;

import com.prowidesoftware.swift.model.field.Field61;
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

}

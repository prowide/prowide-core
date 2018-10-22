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

import com.prowidesoftware.swift.io.RJEReader;
import com.prowidesoftware.swift.model.field.Field86;
import com.prowidesoftware.swift.model.mt.mt9xx.MT940;
import com.prowidesoftware.swift.utils.Lib;
import org.junit.Test;

import java.io.IOException;

/**
 * https://sourceforge.net/p/wife/discussion/544817/thread/f8f66a6d/
 */
public class JapaneseCharactersTest {

    @Test
    public void testRJEFromFile() throws IOException {
        RJEReader reader = new RJEReader(this.getClass().getResourceAsStream("/sample_JPchar.txt"));
        MT940 mt = (MT940) reader.nextMT();
        assertNotNull(mt);
        Field86 field86 = mt.getField86().get(0);
        //System.out.println(mt.message());
        assertEquals("ﾞｱﾀｲﾍｲﾖｳｾﾝﾀ- AFEISEOHFIOSEIOIRT", field86.getComponent2());
    }

    @Test
    public void testRJEFromFile2() throws IOException {
        RJEReader reader = new RJEReader(Lib.readStream(this.getClass().getResourceAsStream("/sample_JPchar.txt")));
        MT940 mt = (MT940) reader.nextMT();
        assertNotNull(mt);
        Field86 field86 = mt.getField86().get(0);
        //System.out.println(mt.message());
        assertEquals("ﾞｱﾀｲﾍｲﾖｳｾﾝﾀ- AFEISEOHFIOSEIOIRT", field86.getComponent2());
    }

    @Test
    public void testMTFromFile() throws IOException {
        MT940 mt = new MT940(this.getClass().getResourceAsStream("/sample_JPchar.txt"));
        assertNotNull(mt);
        Field86 field86 = mt.getField86().get(0);
        //System.out.println(mt.message());
        assertEquals("ﾞｱﾀｲﾍｲﾖｳｾﾝﾀ- AFEISEOHFIOSEIOIRT", field86.getComponent2());
    }

    @Test
    public void testMTFromString() throws IOException {
        MT940 mt = new MT940("{1:F01FOOBARXXAXXX0000000000}{2:I940FOOBARXXXXXXN}{4:\n" +
                ":20:ABC123456530012\n" +
                ":25:987654321\n" +
                ":28C:00046/00001\n" +
                ":60F:C180312JPY15459988,\n" +
                ":61:3454543545CY1234,NTRFNONREF//AABB-01111\n" +
                ":86:/OP/ﾄｸﾃｲﾋｶﾂﾄﾞｳﾎｳｼﾞ\n" +
                "ﾞｱﾀｲﾍｲﾖｳｾﾝﾀ- AFEISEOHFIOSEIOIRT\n" +
                "VNRWINWNGWRIGNWIORNGIWRNIGNWORGNORNGIRIOGNJ /OI/ﾐﾄ\n" +
                "ﾓ ｶﾝﾀﾞ MOFRBGEOEBTIBD MNEJFO /EDI//REF/AABB-01111\n" +
                ":62F:C180312JPY17062895,\n" +
                ":64:C180312JPY17062895,\n" +
                ":86:/ABD/BANKJPJT   \n" +
                "-}");
        assertNotNull(mt);
        Field86 field86 = mt.getField86().get(0);
        //System.out.println(mt.message());
        assertEquals("ﾞｱﾀｲﾍｲﾖｳｾﾝﾀ- AFEISEOHFIOSEIOIRT", field86.getComponent2());
    }

}

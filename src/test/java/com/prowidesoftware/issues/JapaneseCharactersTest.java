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
package com.prowidesoftware.issues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.prowidesoftware.swift.io.RJEReader;
import com.prowidesoftware.swift.model.field.Field86;
import com.prowidesoftware.swift.model.mt.mt9xx.MT940;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

/**
 * https://sourceforge.net/p/wife/discussion/544817/thread/f8f66a6d/
 */
public class JapaneseCharactersTest {

    @Test
    public void testRJEFromFile() throws IOException {
        try (InputStream inputStream = JapaneseCharactersTest.class.getResourceAsStream("/sample_JPchar.txt")) {
            RJEReader reader = new RJEReader(inputStream, StandardCharsets.UTF_8);
            MT940 mt = (MT940) reader.nextMT();
            assertNotNull(mt);
            Field86 field86 = mt.getField86().get(0);
            // System.out.println(mt.message());
            assertEquals("ﾞｱﾀｲﾍｲﾖｳｾﾝﾀ- AFEISEOHFIOSEIOIRT", field86.getComponent2());
        }
    }

    @Test
    public void testRJEFromFile2() throws IOException {
        try (InputStream inputStream = JapaneseCharactersTest.class.getResourceAsStream("/sample_JPchar.txt")) {
            RJEReader reader = new RJEReader(inputStream, StandardCharsets.UTF_8);
            MT940 mt = (MT940) reader.nextMT();
            assertNotNull(mt);
            Field86 field86 = mt.getField86().get(0);
            // System.out.println(mt.message());
            assertEquals("ﾞｱﾀｲﾍｲﾖｳｾﾝﾀ- AFEISEOHFIOSEIOIRT", field86.getComponent2());
        }
    }

    @Test
    public void testMTFromFile() throws IOException {
        try (InputStream resourceStream = JapaneseCharactersTest.class.getResourceAsStream("/sample_JPchar.txt")) {
            if (resourceStream == null) {
                throw new IOException("Resource not found: MT101.fin");
            }
            MT940 mt = new MT940(resourceStream);
            assertNotNull(mt);
            Field86 field86 = mt.getField86().get(0);
            // System.out.println(mt.message());
            assertEquals("ﾞｱﾀｲﾍｲﾖｳｾﾝﾀ- AFEISEOHFIOSEIOIRT", field86.getComponent2());
        }
    }

    @Test
    public void testMTFromString() {
        MT940 mt = new MT940("{1:F01FOOBARXXAXXX0000000000}{2:I940FOOBARXXXXXXN}{4:\n" + ":20:ABC123456530012\n"
                + ":25:987654321\n"
                + ":28C:00046/00001\n"
                + ":60F:C180312JPY15459988,\n"
                + ":61:3454543545CY1234,NTRFNONREF//AABB-01111\n"
                + ":86:/OP/ﾄｸﾃｲﾋｶﾂﾄﾞｳﾎｳｼﾞ\n"
                + "ﾞｱﾀｲﾍｲﾖｳｾﾝﾀ- AFEISEOHFIOSEIOIRT\n"
                + "VNRWINWNGWRIGNWIORNGIWRNIGNWORGNORNGIRIOGNJ /OI/ﾐﾄ\n"
                + "ﾓ ｶﾝﾀﾞ MOFRBGEOEBTIBD MNEJFO /EDI//REF/AABB-01111\n"
                + ":62F:C180312JPY17062895,\n"
                + ":64:C180312JPY17062895,\n"
                + ":86:/ABD/BANKJPJT   \n"
                + "-}");
        assertNotNull(mt);
        Field86 field86 = mt.getField86().get(0);
        // System.out.println(mt.message());
        assertEquals("ﾞｱﾀｲﾍｲﾖｳｾﾝﾀ- AFEISEOHFIOSEIOIRT", field86.getComponent2());
    }
}

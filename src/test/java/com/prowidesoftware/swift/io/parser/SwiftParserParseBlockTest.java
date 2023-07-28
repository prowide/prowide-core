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
package com.prowidesoftware.swift.io.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftMessage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test cases for the parseBlock methods in the parser implementation
 */
public class SwiftParserParseBlockTest {

    @Test
    public void testGetBlock4() {
        final SwiftBlock4 b4 = SwiftParser.parseBlock4("{4:\r\n" + ":16R:GENL\r\n"
                + ":23G:NEWM\r\n"
                + ":98A::PREP//20050711\r\n"
                + ":16S:GENL\r\n"
                + ":16S:AMT\r\n"
                + ":16S:SETDET\r\n"
                + "-}");
        assertNotNull(b4);
        assertEquals(6, b4.size());
        assertEquals("16R", b4.getTag(0).getName());
        assertEquals("98A", b4.getTag(2).getName());
        assertEquals("GENL", b4.getTag(0).getValue());
        assertEquals(":PREP//20050711", b4.getTag(2).getValue());
    }

    @Test
    public void testGetBlock4Brackets1() {
        final SwiftBlock4 b4 = SwiftParser.parseBlock4("{4:\r\n" + ":79:foobar{bad\r\n" + "-}");
        assertNotNull(b4);
        assertEquals(1, b4.size());
        assertEquals("foobar{bad", b4.getTag(0).getValue());
    }

    @Test
    public void testGetBlock4Brackets2() {
        final SwiftBlock4 b4 = SwiftParser.parseBlock4("{4:\r\n" + ":79:foobar{bad\r\n" + "-}");
        assertNotNull(b4);
        assertEquals(1, b4.size());
        assertEquals("foobar{bad", b4.getTag(0).getValue());
    }

    @Test
    public void testGetBlock4WithMultiline() {
        final SwiftBlock4 b4 = SwiftParser.parseBlock4("{4:\r\n" + ":98A::SETT//20050708\r\n"
                + ":90B::DEAL//ACTU/USD28,86\r\n"
                + ":35B:ISIN US1112223330\r\n"
                + "MY COMPANY\r\n"
                + ":16S:TRADDET\r\n"
                + ":16R:FIAC\r\n"
                + ":36B::SETT//UNIT/370,00\r\n"
                + ":97A::SAFE//111222\r\n"
                + ":16S:FIAC\r\n"
                + ":16R:SETDET\r\n"
                + "-}");
        assertNotNull(b4);
        assertEquals(9, b4.size());
        assertEquals("35B", b4.getTag(2).getName());

        assertEquals(
                "ISIN US1112223330\r\n" + "MY COMPANY", b4.getTagByName("35B").getValue());
    }

    @Test
    public void testTicket28() {
        final SwiftBlock4 b4 = SwiftParser.parseBlock4("{4:\r\n" + ":16R:GENL\r\n"
                + ":23G:NEWM\r\n"
                + ":98A::PREP//20050711\r\n"
                + ":16S:GENL\r\n"
                + ":16S:AMT\r\n"
                + ":16S:SETDET"
                + "-}");
        assertNotNull(b4);
        assertEquals(6, b4.size());
    }

    /**
     * Test parsing nested blocks as tags
     */
    @Disabled
    @Test
    public void testNestedBlocks() throws Exception {
        String fin =
                "{1:F01OURSGB33AXXX0000000000}{2:O0961625170421ABLRXXXXGXXX00000000001704201625N}{3:{103:CLH}{108:SWIFTBICAXXX0000890}}{4:{1:F01PTY1US33AXXX0000000000}{2:I300PTY2GB33AXXXU3003}{3:{103:ABC}}{4:\n"
                        + ":15A:\n"
                        + ":20:R317703\n"
                        + ":22A:NEWT\n"
                        + "-}{5:{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}}}";

        // parse with SwiftMessage
        SwiftMessage sm = SwiftMessage.parse(fin);
        if (sm.isType(96)) {
            SwiftBlock4 nested = sm.getBlock4();
            SwiftMessage mt = new SwiftMessage();
            if (nested.getTagByNumber(1) != null) {
                mt.addBlock(SwiftParser.parseBlock1(nested.getTagByNumber(1).getValue()));
            }
            if (nested.getTagByNumber(2) != null) {
                mt.addBlock(SwiftParser.parseBlock2(nested.getTagByNumber(2).getValue()));
            }
            if (nested.getTagByNumber(3) != null) {
                // System.out.println(nested.getTagByNumber(3).getValue());
                mt.addBlock(SwiftParser.parseBlock3(nested.getTagByNumber(3).getValue()));
            }
            if (nested.getTagByNumber(4) != null) {
                mt.addBlock(SwiftParser.parseBlock4(nested.getTagByNumber(4).getValue()));
            }
            if (nested.getTagByNumber(5) != null) {
                mt.addBlock(SwiftParser.parseBlock5(nested.getTagByNumber(5).getValue()));
            }
            assertNotNull(mt.getBlock1());
            assertNotNull(mt.getBlock2());
            assertNotNull(mt.getBlock3());
            assertNotNull(mt.getBlock4());
            assertNotNull(mt.getBlock5());
            assertEquals("F01PTY1US33AXXX0000000000", nested.getTagValue("1"));
            assertEquals("I300PTY2GB33AXXXU3003", nested.getTagValue("2"));
            assertEquals("{103:ABC}", nested.getTagValue("3"));
            assertEquals("\\n" + ":15A:\\n" + ":20:R317703\\n" + ":22A:NEWT\\n" + "-", nested.getTagValue("4"));
            assertEquals("{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}", nested.getTagValue("5"));
        }
    }
}

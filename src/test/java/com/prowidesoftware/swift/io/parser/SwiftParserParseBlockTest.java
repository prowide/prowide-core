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

import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftMessage;
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

    @Test
    public void testParseBlock3WithBlockIdentifierAndBrackets() {
        SwiftBlock3 b3 = SwiftParser.parseBlock3("{3:{103:CLH}{108:MUR123}}");
        assertEquals(2, b3.size());
        assertEquals("CLH", b3.getTagValue("103"));
        assertEquals("MUR123", b3.getTagValue("108"));
    }

    @Test
    public void testParseBlock3WithBlockIdentifierWithoutBrackets() {
        SwiftBlock3 b3 = SwiftParser.parseBlock3("3:{103:CLH}{108:MUR123}");
        assertEquals(2, b3.size());
        assertEquals("CLH", b3.getTagValue("103"));
        assertEquals("MUR123", b3.getTagValue("108"));
    }

    /**
     * This is the form of the nested block 3 within the block 4 of an MT021 or MT096, as returned by the tag value
     */
    @Test
    public void testParseBlock3WithoutBlockIdentifier() {
        SwiftBlock3 b3 = SwiftParser.parseBlock3("{103:CLH}{108:MUR123}");
        assertEquals(2, b3.size());
        assertEquals("CLH", b3.getTagValue("103"));
        assertEquals("MUR123", b3.getTagValue("108"));
    }

    @Test
    public void testParseBlock3Empty() {
        assertEquals(0, SwiftParser.parseBlock3("").size());
        assertEquals(0, SwiftParser.parseBlock3("{3:}").size());
        assertEquals(0, SwiftParser.parseBlock3("3:").size());
    }

    @Test
    public void testParseBlock5WithBlockIdentifierAndBrackets() {
        SwiftBlock5 b5 = SwiftParser.parseBlock5("{5:{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}}");
        assertEquals(2, b5.size());
        assertEquals("73AC90A7A3F1", b5.getTagValue("CHK"));
        assertEquals("1309041018SMAIBE22AXXX0246001570", b5.getTagValue("SYS"));
    }

    @Test
    public void testParseBlock5WithBlockIdentifierWithoutBrackets() {
        SwiftBlock5 b5 = SwiftParser.parseBlock5("5:{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}");
        assertEquals(2, b5.size());
        assertEquals("73AC90A7A3F1", b5.getTagValue("CHK"));
        assertEquals("1309041018SMAIBE22AXXX0246001570", b5.getTagValue("SYS"));
    }

    /**
     * This is the form of the nested block 5 within the block 4 of an MT021 or MT096, as returned by the tag value
     */
    @Test
    public void testParseBlock5WithoutBlockIdentifier() {
        SwiftBlock5 b5 = SwiftParser.parseBlock5("{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}");
        assertEquals(2, b5.size());
        assertEquals("73AC90A7A3F1", b5.getTagValue("CHK"));
        assertEquals("1309041018SMAIBE22AXXX0246001570", b5.getTagValue("SYS"));
    }

    @Test
    public void testParseBlock5Empty() {
        assertEquals(0, SwiftParser.parseBlock5("").size());
        assertEquals(0, SwiftParser.parseBlock5("{5:}").size());
        assertEquals(0, SwiftParser.parseBlock5("5:").size());
    }

    /**
     * Test parsing nested blocks as tags
     *
     * @see SwiftParserNestedBlockTest
     * @see SwiftParserNestedMessageTest
     */
    @Test
    public void testNestedBlocks() throws Exception {
        String fin =
                "{1:F01OURSGB33AXXX0000000000}{2:O0961625170421ABLRXXXXGXXX00000000001704201625N}{3:{103:CLH}{108:SWIFTBICAXXX0000890}}{4:{1:F01PTY1US33AXXX0000000000}{2:I300PTY2GB33AXXXU3003}{3:{103:ABC}}{4:\r\n"
                        + ":15A:\r\n"
                        + ":20:R317703\r\n"
                        + ":22A:NEWT\r\n"
                        + "-}{5:{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}}}";

        SwiftMessage sm = SwiftMessage.parse(fin);
        assertEquals("096", sm.getType());

        final SwiftBlock4 nested = sm.getBlock4();
        assertNotNull(nested);
        assertEquals(5, nested.size());
        assertEquals("F01PTY1US33AXXX0000000000", nested.getTagValue("1"));
        assertEquals("I300PTY2GB33AXXXU3003", nested.getTagValue("2"));
        assertEquals("{103:ABC}", nested.getTagValue("3"));
        assertEquals("\r\n" + ":15A:\r\n" + ":20:R317703\r\n" + ":22A:NEWT\r\n" + "-", nested.getTagValue("4"));
        assertEquals("{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}", nested.getTagValue("5"));

        SwiftMessage mt = new SwiftMessage();
        mt.addBlock(SwiftParser.parseBlock1(nested.getTagValue("1")));
        mt.addBlock(SwiftParser.parseBlock2(nested.getTagValue("2")));
        mt.addBlock(SwiftParser.parseBlock3(nested.getTagValue("3")));
        mt.addBlock(SwiftParser.parseBlock4(nested.getTagValue("4")));
        mt.addBlock(SwiftParser.parseBlock5(nested.getTagValue("5")));
        assertNotNull(mt.getBlock1());
        assertNotNull(mt.getBlock2());
        assertEquals(1, mt.getBlock3().size());
        assertEquals(3, mt.getBlock4().size());
        assertEquals(2, mt.getBlock5().size());
    }
}

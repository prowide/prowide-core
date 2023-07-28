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

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.Constants;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;
import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test cases for the consumeTag and related methos in the parser implementation
 */
public class SwiftParserConsumeTagTest {
    private VisibleParser parser;

    private static boolean tagStarts(final String str) {
        SwiftParser p = new SwiftParser();
        return p.isTagStart(str, 0);
    }

    @BeforeEach
    public void setUp() {
        parser = new VisibleParser();
    }

    @Test
    public void testReadBlock() throws IOException {
        parser.setData("asdklajdkla{foobar}njdkasndkja}{not seen}");
        final String m = parser.readUntilBlockEnds();
        assertEquals("asdklajdkla{foobar}njdkasndkja", m);
    }

    @Test
    public void testConsumeTag16R() {
        final Tag t = parser.consumeTag(":16R:GENL");
        assertNotNull(t);
        assertEquals("16R", t.getName());
        assertEquals("GENL", t.getValue());
    }

    @Test
    public void testConsumeTagWithBraquets() {
        final Tag t = parser.consumeTag(":50K:AB\nCD}EFG\r\n");
        assertNotNull(t);
        assertEquals("50K", t.getName());
        assertEquals("AB\nCD}EFG\r\n", t.getValue());
    }

    @Test
    public void testConsumeTagColons1() {
        Tag o = this.parser.consumeTag(":86:/FOO\n" + ":BAR\n");
        assertTrue(o.getValue().contains("BAR"));
    }

    @Test
    public void testTagStartsTrue() {
        assertTrue(tagStarts("20:"));
        assertTrue(tagStarts("20:foo"));
        assertTrue(tagStarts("20::foo"));
        assertTrue(tagStarts("20C:"));
        assertTrue(tagStarts("20C:foo"));
        assertTrue(tagStarts("20C::foo"));
    }

    @Test
    public void testTagStartsFalse() {
        assertFalse(tagStarts("20foo"));
        assertFalse(tagStarts("2:foo"));
        assertFalse(tagStarts("20CC:"));
        assertFalse(tagStarts("20c:"));
        assertFalse(tagStarts(":20foo"));
        assertFalse(tagStarts("20foo"));
        assertFalse(tagStarts(":/ account stuff:"));
        assertFalse(tagStarts(":905:"));
    }

    @Test
    public void testFindEndOfTag1() {
        final String s = "4:\n" + ":20:628735BKRU3X\n"
                + ":79:TO FOO\n"
                + "ATTN. FOO OPERATIONS\n"
                + "FROM.\n"
                + "RE.   JOE DOE A/C 1111\n"
                + "A/C: 961XXX\n"
                + ".\n"
                + "WE CONFIRM TO INCREASE THE FOLLOWING DEPOSIT FROM\n"
                + "RATE       10.0000\n"
                + ".\n"
                + "INSTRUCTIONS:\n"
                + "STATE STREET BANK AND TRUST CO, NA NEW YORK\n"
                + "SWIFT CODE: FOOSUS3N\n"
                + "VALUE 22 MAY 2012\n"
                + ".\n"
                + "REGARDS,\n"
                + "}\n"
                + "-";
        final int start = 21;
        final int end = this.parser.findEndOfTagByLineFeed(s, start, true);
        final String tag = s.substring(start, end);
        assertEquals('-', tag.charAt(tag.length() - 1));
    }

    @Test
    public void testFindEndOfTag2() {
        final String s = ":79:foo\n}\n-}";
        final int end = this.parser.findEndOfTagByLineFeed(s, 0, true);
        assertEquals('-', s.charAt(end));
    }

    @Test
    public void testFindEndOfTag3() {
        final String s = ":20:foo\n:21:";
        final int end = this.parser.findEndOfTagByLineFeed(s, 0, true);
        assertEquals(7, end);
        assertEquals('\n', s.charAt(end));
    }

    @Test
    public void testFindEndOfTag4() {
        final String s = ":20:foo\r\n:21:";
        final int end = this.parser.findEndOfTagByLineFeed(s, 0, true);
        assertEquals(7, end);
        assertEquals('\r', s.charAt(end));
    }

    /**
     * The duplicated LF should be returned as part of the tag value
     */
    @Test
    public void testFindEndOfTag5() {
        final String s = ":20:foo\n\n:21:";
        final int end = this.parser.findEndOfTagByLineFeed(s, 0, true);
        assertEquals(8, end);
        assertEquals('\n', s.charAt(end));
    }

    /**
     * The duplicated CRLF should be returned as part of the tag value
     */
    @Test
    public void testFindEndOfTag6() {
        final String s = ":20:foo\r\n\r\n:21:";
        final int end = this.parser.findEndOfTagByLineFeed(s, 0, true);
        assertEquals(9, end);
        assertEquals('\r', s.charAt(end));
    }

    /**
     * The duplicated LF should be returned as part of the tag value
     */
    @Test
    public void testFindEndOfTag7() {
        final String s = ":20:foo\n\r\n:21:";
        final int end = this.parser.findEndOfTagByLineFeed(s, 0, true);
        assertEquals(8, end);
        assertEquals('\r', s.charAt(end));
    }

    @Test
    public void testFieldStartingWithColon() throws Exception {
        final String val = "/PY/OSA PAYMENT/BN/FOO LIMITED/BN1/6/F,HONGCHANG PLAZA,N\n"
                + ":6542670O2001,/BN2/SHENNAN ROAD EAST,LUOHU DIST,/BN3/SHENZHEN,CHINA/BI/12\n"
                + "44712009/BO/INFINITY HOME LIMITED ROOM 2105 FZ2250 TREND CTR 29-3\n"
                + "1 CH/BO3/EUNG LEE STREET CHAI WAN HK/CM/USD1,00/CA/1244712009/OB/\n"
                + "CHINA FOO BANK/PT/FT/PO/0005/OCMT/USD2620,80/XT/CD/REF/1029\n"
                + "200004099";
        final String fin = "{1:" + Constants.B1_DATA + "}{4:\n" + ":86:" + val + "\n" + "-}";
        final SwiftParser p = new SwiftParser(new StringReader(fin));
        final SwiftMessage msg = p.message();
        assertEquals(1, msg.getBlock4().countAll());
        assertNotNull(msg.getBlock4().getTagByName("86"));
        assertEquals(val, msg.getBlock4().getTagByName("86").getValue());
    }

    @Test
    public void testFieldStartingWithColonTrimmed() throws Exception {
        final String fin = "{1:" + Constants.B1_DATA + "}{4:\n" + ":86:/FOO\n" + ":123BAR\n" + "-}";
        final SwiftParser p = new SwiftParser(new StringReader(fin));
        final SwiftMessage msg = p.message();
        assertEquals(1, msg.getBlock4().countAll());
    }

    @Test
    public void testFieldStartingWithColonTrimmedColonAndText() throws Exception {
        final String fin = "{1:" + Constants.B1_DATA + "}{4:\n" + ":86:/FOO\n" + ":BAR\n" + "-}";
        final SwiftParser p = new SwiftParser(new StringReader(fin));
        final SwiftMessage msg = p.message();
        assertEquals(1, msg.getBlock4().countAll());
    }

    @Test
    public void testTag77Exceptions_1() throws Exception {
        final String m =
                "{1:F01FOOBARYYAXXX1234123456}{2:O1030811060227FOOBBSMMAXXX55529746000602270811N}{3:{113:NOMF}{108:0602021485081594}{119:STP}}{4:^M\r\n"
                        + ":77E:  \r\n"
                        + "ABCDEFG\r\n"
                        + "-}{5:{MAC:80C69B21}{CHK:63035B4672E0}}\r\n"
                        + "\r\n"
                        + "";
        final SwiftMessage msg = new SwiftParser(m).message();
        assertNotNull(msg);
        assertEquals(msg.getBlock4().getTagByName("77E").getValue(), "  \r\n" + "ABCDEFG");
    }

    @Test
    public void testTag77Exceptions_2() throws Exception {
        final String m =
                "{1:F01FOOBARYYAXXX1234123456}{2:O1030811060227FOOBBSMMAXXX55529746000602270811N}{3:{113:NOMF}{108:0602021485081594}{119:STP}}{4:\r\n"
                        + ":77E:\r\n"
                        + "ABCDEFG\r\n"
                        + "-}{5:{MAC:80C69B21}{CHK:63035B4672E0}}\r\n"
                        + "\r\n"
                        + "";
        final SwiftMessage msg = new SwiftParser(m).message();
        assertNotNull(msg);
        assertEquals(msg.getBlock4().getTagByName("77E").getValue(), "\r\n" + "ABCDEFG");
    }

    @Test
    public void testTag77Exceptions_3() throws Exception {
        final String m =
                "{1:F01FOOBARYYAXXX1234123456}{2:O1030811060227FOOBBSMMAXXX55529746000602270811N}{3:{113:NOMF}{108:0602021485081594}{119:STP}}{4:\r\n"
                        + ":77E::\r\n"
                        + ":\r\n"
                        + "QWERTYU\r\n"
                        + "-}{5:{MAC:80C69B21}{CHK:63035B4672E0}}\r\n"
                        + "\r\n"
                        + "";
        final SwiftMessage msg = new SwiftParser(m).message();
        assertNotNull(msg);
        assertEquals(msg.getBlock4().getTagByName("77E").getValue(), ":\r\n" + ":\r\n" + "QWERTYU");
    }

    @Test
    public void testTag77Exceptions_4() throws Exception {
        final String m =
                "{1:F01FOOBARYYAXXX1234123456}{2:O1030811060227FOOBBSMMAXXX55529746000602270811N}{3:{113:NOMF}{108:0602021485081594}{119:STP}}{4:\r\n"
                        + ":77E:-\r\n"
                        + ":\r\n"
                        + "ZXCVBNM\r\n"
                        + "-}{5:{MAC:80C69B21}{CHK:63035B4672E0}}\r\n"
                        + "\r\n"
                        + "";
        final SwiftMessage msg = new SwiftParser(m).message();
        assertNotNull(msg);
        assertEquals(msg.getBlock4().getTagByName("77E").getValue(), "-\r\n" + ":\r\n" + "ZXCVBNM");
    }

    /**
     * http://sourceforge.net/projects/wife/forums/forum/544818/topic/3399143
     */
    @Test
    public void test_MT535_35B_with_colon() throws Exception {
        final String m =
                "{1:F01BFOOUS3IADNC0147771111}{2:O5350837080313FOOSGB2LIXXX06988488300803130437N}{3:{108:000952CQ1650453}}{4:\r\n"
                        + ":16R:GENL\r\n"
                        + ":28E:6/MORE\r\n"
                        + ":20C::SEME//H200803121132222\r\n"
                        + ":23G:NEWM\r\n"
                        + ":98A::STAT//20080312\r\n"
                        + ":22F::SFRE//DAIL\r\n"
                        + ":22F::CODE//COMP\r\n"
                        + ":22F::STTY//CUST\r\n"
                        + ":22F::STBA//TRAD\r\n"
                        + ":97A::SAFE//S 02500\r\n"
                        + ":17B::ACTI//Y\r\n"
                        + ":17B::AUDT//N\r\n"
                        + ":17B::CONS//N\r\n"
                        + ":16S:GENL\r\n"
                        + ":16R:SUBSAFE\r\n"
                        + ":16R:FIN\r\n"
                        +
                        //  :35B:ISIN XS0222550880 4,125? LANXESS FIN.B.V.NT.V.05 21.6 :12
                        ":35B:/US/AGGR_AVAI\r\n"
                        + "AGGR=300, AVAI:=200\r\n"
                        + ":16R:FIA\r\n"
                        + ":12A::CLAS/ISIT/STF\r\n"
                        + ":16S:FIA\r\n"
                        + ":93B::AGGR//FAMT/300,\r\n"
                        + ":93B::AVAI//FAMT/200,\r\n"
                        + ":16R:SUBBAL\r\n"
                        + ":93B::AGGR//FAMT/50,\r\n"
                        + ":94F::SAFE//CUST/FOOSUS33\r\n"
                        + ":70C::SUBB//REGISTRATION CODE MEMR\n"
                        + ":16S:SUBBAL\r\n"
                        + ":16S:FIN\r\n"
                        + ":16R:FIN\r\n"
                        + "-}";
        final SwiftMessage msg = new SwiftParser(m).message();
        assertNotNull(msg);
        assertEquals(msg.getBlock4().getTagByName("35B").getValue(), "/US/AGGR_AVAI\r\nAGGR=300, AVAI:=200");
    }

    /**
     * http://sourceforge.net/projects/wife/forums/forum/544818/topic/3399143
     */
    @Test
    public void test_MT535_35B_with_colon_2() throws Exception {
        final String m =
                "{1:F01BFOOUS3IADNC0147771111}{2:O5350837080313FOOSGB2LIXXX06988488300803130437N}{3:{108:000952CQ1650453}}{4:\r\n"
                        + ":16R:GENL\r\n"
                        + ":28E:6/MORE\r\n"
                        + ":20C::SEME//H200803121132222\r\n"
                        + ":23G:NEWM\r\n"
                        + ":98A::STAT//20080312\r\n"
                        + ":22F::SFRE//DAIL\r\n"
                        + ":22F::CODE//COMP\r\n"
                        + ":22F::STTY//CUST\r\n"
                        + ":22F::STBA//TRAD\r\n"
                        + ":97A::SAFE//S 02500\r\n"
                        + ":17B::ACTI//Y\r\n"
                        + ":17B::AUDT//N\r\n"
                        + ":17B::CONS//N\r\n"
                        + ":16S:GENL\r\n"
                        + ":16R:SUBSAFE\r\n"
                        + ":16R:FIN\r\n"
                        + ":35B:ISIN XS0222550880\r\n"
                        + "4,125? LANXESS FIN.B.V.NT.V.05 21.6\r\n"
                        +
                        // ":12\r\n" +
                        /*
                         * within the field content, a colon ':' must never be used as the first character
                         * of a line (the combination 'CrLf:' always indicates a new field tag)
                         */
                        ":16R:FIA\r\n"
                        + ":12A::CLAS/ISIT/STF\r\n"
                        + ":16S:FIA\r\n"
                        + ":93B::AGGR//FAMT/300,\r\n"
                        + ":93B::AVAI//FAMT/200,\r\n"
                        + ":16R:SUBBAL\r\n"
                        + ":93B::AGGR//FAMT/50,\r\n"
                        + ":94F::SAFE//CUST/FOOSUS33\r\n"
                        + ":70C::SUBB//REGISTRATION CODE MEMR\n"
                        + ":16S:SUBBAL\r\n"
                        + ":16S:FIN\r\n"
                        + ":16R:FIN\r\n"
                        + "-}";
        final SwiftMessage msg = new SwiftParser(m).message();
        assertNotNull(msg);
    }
}

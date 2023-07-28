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
import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.model.SwiftMessage;
import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test cases for readUntilBlockEnds and related methods in the parser implementation
 */
public class SwiftParserReadBlockTest {
    private VisibleParser parser;

    @BeforeEach
    public void setUp() {
        parser = new VisibleParser();
    }

    @Test
    public void testIdentifyBlock1() {
        final String b = "1:F01MYBICFF0XXXX0000000000";
        assertEquals('1', parser.identifyBlock(b));
    }

    @Test
    public void testIdentifyBlock2() {
        final String b = "2:I541TTTTTL2XXXXXN";
        assertEquals('2', parser.identifyBlock(b));
    }

    @Test
    public void testReadBlock() throws IOException {
        parser.setData("asdklajdkla{foobar}njdkasndkja}{not seen}");
        final String m = parser.readUntilBlockEnds();
        assertEquals("asdklajdkla{foobar}njdkasndkja", m);
    }

    @Test
    public void testReadBlock3() throws IOException {
        parser.setData("3:{108:00750534912215}}");
        final String m = parser.readUntilBlockEnds();
        assertEquals("3:{108:00750534912215}", m);
    }

    @Test
    public void testReadBlock4() throws IOException {
        parser.setData("4:" + FINWriterVisitor.SWIFT_EOL + ":16R:GENL"
                + FINWriterVisitor.SWIFT_EOL + ":23G:NEWM"
                + FINWriterVisitor.SWIFT_EOL + ":98A::PREP//20050711"
                + FINWriterVisitor.SWIFT_EOL + ":16S:GENL"
                + FINWriterVisitor.SWIFT_EOL + ":16S:AMT"
                + FINWriterVisitor.SWIFT_EOL + ":16S:SETDET"
                + FINWriterVisitor.SWIFT_EOL + "-}");
        final String m = parser.readUntilBlockEnds();
        assertEquals(
                "4:\r\n" + ":16R:GENL\r\n"
                        + ":23G:NEWM\r\n"
                        + ":98A::PREP//20050711\r\n"
                        + ":16S:GENL\r\n"
                        + ":16S:AMT\r\n"
                        + ":16S:SETDET\r\n"
                        + "-",
                m);
    }

    @Test
    public void testReadBlockTwoInner() throws IOException {
        parser.setData("3:{113:NOMF}{108:0510280086100051}{119:STP}}");
        final String m = parser.readUntilBlockEnds();
        assertEquals("3:{113:NOMF}{108:0510280086100051}{119:STP}", m);
    }

    @Test
    public void testReadUntilBlockEnds1() throws IOException {
        parser.setData("damskldmsakld}");
        final String s = parser.readUntilBlockEnds();
        assertEquals("damskldmsakld", s);
    }

    @Test
    public void testReadUntilBlockEnds2() throws IOException {
        parser.setData("foo}{bar}");
        String s = parser.readUntilBlockEnds();
        assertEquals("foo", s);
        parser.findBlockStart();
        s = parser.readUntilBlockEnds();
        assertEquals("bar", s);
    }

    @Test
    public void testReadUntilBlockEnds3() throws IOException {
        parser.setData("foo}{bar}{as\r\nfoobar\nbye\r\n}");
        String s = parser.readUntilBlockEnds();
        assertEquals("foo", s);
        parser.findBlockStart();
        s = parser.readUntilBlockEnds();
        assertEquals("bar", s);
        parser.findBlockStart();
        s = parser.readUntilBlockEnds();
        assertEquals("as\r\nfoobar\nbye\r\n", s);
    }

    @Test
    public void testReadUntilBlockEnds2WithNested() throws IOException {
        parser.setData("foo{x}y{z}}{bar{feel}like{coding}today}");
        String s = parser.readUntilBlockEnds();
        assertEquals("foo{x}y{z}", s);
        parser.findBlockStart();
        s = parser.readUntilBlockEnds();
        assertEquals("bar{feel}like{coding}today", s);
    }

    @Test
    public void testReadUntilBlockEnds2WithBraquets() throws IOException {
        parser.setData("4:foo{xyz}4:bar{feellike{codingtoday\n-}");
        final String s = parser.readUntilBlockEnds();
        assertEquals("4:foo{xyz}4:bar{feellike{codingtoday\n-", s);
    }

    @Test
    public void testReadUntilBlockEnds2WithBraquetsB() throws IOException {
        parser.setData("4:bar{feellike{codingtoday}");
        final String s = parser.readUntilBlockEnds();
        /*
         * We expect } in the last value because it is not a proper block termination, and the block
         * actually ends by EOF, not the bracket
         */
        assertEquals("4:bar{feellike{codingtoday}", s);
    }

    @Test
    public void testReadBlock4WithStartingBraquetInFieldValue() throws IOException {
        parser.setData("4:" + FINWriterVisitor.SWIFT_EOL + ":16R:GENL"
                + FINWriterVisitor.SWIFT_EOL + ":23G:NEWM"
                + FINWriterVisitor.SWIFT_EOL + ":98A::PREP//20050711"
                + FINWriterVisitor.SWIFT_EOL + ":16S:GE{NL"
                + FINWriterVisitor.SWIFT_EOL + ":16S:AMT"
                + FINWriterVisitor.SWIFT_EOL + ":16S:SETDET"
                + FINWriterVisitor.SWIFT_EOL + "-}");
        final String m = parser.readUntilBlockEnds();
        assertEquals(
                "4:\r\n" + ":16R:GENL\r\n"
                        + ":23G:NEWM\r\n"
                        + ":98A::PREP//20050711\r\n"
                        + ":16S:GE{NL\r\n"
                        + ":16S:AMT\r\n"
                        + ":16S:SETDET\r\n"
                        + "-",
                m);
    }

    @Test
    public void testReadBlock4WithClosingBraquetInFieldValue() throws IOException {
        parser.setData("4:" + FINWriterVisitor.SWIFT_EOL + ":16R:GENL"
                + FINWriterVisitor.SWIFT_EOL + ":23G:NEWM"
                + FINWriterVisitor.SWIFT_EOL + ":98A::PREP//20050711"
                + FINWriterVisitor.SWIFT_EOL + ":16S:GE}NL"
                + FINWriterVisitor.SWIFT_EOL + ":16S:AMT"
                + FINWriterVisitor.SWIFT_EOL + ":16S:SETDET"
                + FINWriterVisitor.SWIFT_EOL + "-}");
        final String m = parser.readUntilBlockEnds();
        assertEquals(
                "4:\r\n" + ":16R:GENL\r\n"
                        + ":23G:NEWM\r\n"
                        + ":98A::PREP//20050711\r\n"
                        + ":16S:GE}NL\r\n"
                        + ":16S:AMT\r\n"
                        + ":16S:SETDET\r\n"
                        + "-",
                m);
    }

    @Test
    public void testBug1539324_2() throws IOException {
        final String fin = "{1:" + Constants.B1_DATA + "}{3:{n:v}}";
        parser.setData(fin);
        final SwiftMessage msg = parser.message();
        assertEquals(Constants.B1_DATA, msg.getBlock1().getBlockValue());
        assertNull(msg.getBlock2());
        assertEquals("n", msg.getBlock3().getTag(0).getName());
        assertEquals("v", msg.getBlock3().getTag(0).getValue());
        assertNull(msg.getBlock4());
        assertNull(msg.getBlock5());
    }

    @Test
    public void testBug1539324_3() throws IOException {
        final String fin = "{1:" + Constants.B1_DATA + "}{3:{n:v}}";
        final SwiftParser p = new SwiftParser(new StringReader(fin));
        final SwiftMessage msg = p.message();
        assertEquals(1, msg.getBlock1().getNumber().intValue());
        assertEquals(Constants.B1_DATA, msg.getBlock1().getBlockValue());
        assertNull(msg.getBlock2());
        assertEquals(3, msg.getBlock3().getNumber().intValue());
        assertEquals("n", msg.getBlock3().getTag(0).getName());
        assertEquals("v", msg.getBlock3().getTag(0).getValue());
        assertNull(msg.getBlock4());
        assertNull(msg.getBlock5());
    }

    @Test
    public void testOneTagSimilarToBug1540294_1() throws IOException {
        final String fin = "{4:\r\n" + ":t2:v2\r\n" + "-}";
        final SwiftParser p = new SwiftParser(new StringReader(fin));
        final SwiftMessage msg = p.message();
        assertNotNull(msg.getBlock4());
        assertEquals(1, msg.getBlock4().size());
        assertEquals("v2", msg.getBlock4().getTagValue("t2"));
    }

    @Test
    public void testBug1601122_1() throws IOException {
        final String fin = "{5:{MAC:32D7EA50}{CHK:AB1538FB729E}}";
        final SwiftParser p = new SwiftParser(new StringReader(fin));
        final SwiftMessage msg = p.message();
        assertNotNull(msg.getBlock5());
        assertEquals(2, msg.getBlock5().size());
        assertEquals("32D7EA50", msg.getBlock5().getTagValue("MAC"));
        assertEquals("AB1538FB729E", msg.getBlock5().getTagValue("CHK"));
    }
}

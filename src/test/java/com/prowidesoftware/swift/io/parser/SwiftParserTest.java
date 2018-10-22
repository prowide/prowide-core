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
package com.prowidesoftware.swift.io.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.Calendar;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.prowidesoftware.swift.Constants;
import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.model.SwiftBlock;
import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;

/**
 * Swift parser tests using the default lenient (permissive) mode.
 *
 * <p>In this configuration the parser will apply a best effort heuristic
 * to read all blocks content. For instance it will read the block 4 regardless
 * of the proper closing boundary -} and also will read the headers even if
 * some fields are not present and the overall header size is incorrect.
 */
public class SwiftParserTest {
	protected VisibleParser parser;

	@Before
	public void setUp() {
		this.parser = new VisibleParser();
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
		parser.setData("4:" + FINWriterVisitor.SWIFT_EOL +
				":16R:GENL" + FINWriterVisitor.SWIFT_EOL +
				":23G:NEWM" + FINWriterVisitor.SWIFT_EOL +
				":98A::PREP//20050711" + FINWriterVisitor.SWIFT_EOL +
				":16S:GENL" + FINWriterVisitor.SWIFT_EOL +
				":16S:AMT" + FINWriterVisitor.SWIFT_EOL +
				":16S:SETDET" + FINWriterVisitor.SWIFT_EOL +
				"-}");
		final String m = parser.readUntilBlockEnds();
		assertEquals("4:\r\n" +
				":16R:GENL\r\n" +
				":23G:NEWM\r\n" +
				":98A::PREP//20050711\r\n" +
				":16S:GENL\r\n" +
				":16S:AMT\r\n" +
				":16S:SETDET\r\n" +
				"-", m);
	}

	@Test
	public void testReadBlockTwoInner() throws IOException {
		parser.setData("3:{113:NOMF}{108:0510280086100051}{119:STP}}");
		final String m = parser.readUntilBlockEnds();
		assertEquals("3:{113:NOMF}{108:0510280086100051}{119:STP}", m);
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
	public void testGetBlock4() throws IOException {
		final SwiftBlock4 b4 = SwiftParser.parseBlock4("{4:\r\n" +
				":16R:GENL\r\n" +
				":23G:NEWM\r\n" +
				":98A::PREP//20050711\r\n" +
				":16S:GENL\r\n" +
				":16S:AMT\r\n" +
				":16S:SETDET\r\n" +
				"-}");
		assertNotNull(b4);
		assertEquals(6, b4.size());
		assertEquals("16R", b4.getTag(0).getName());
		assertEquals("98A", b4.getTag(2).getName());
		assertEquals("GENL", b4.getTag(0).getValue());
		assertEquals(":PREP//20050711", b4.getTag(2).getValue());
	}

	@Test
	public void testGetBlock4Brackets1() throws IOException {
		final SwiftBlock4 b4 = SwiftParser.parseBlock4("{4:\r\n" +
				":79:foobar{bad\r\n" +
				"-}");
		assertNotNull(b4);
		assertEquals(1, b4.size());
		assertEquals("foobar{bad", b4.getTag(0).getValue());
	}

	@Test
	public void testGetBlock4Brackets2() throws IOException {
		final SwiftBlock4 b4 = SwiftParser.parseBlock4("{4:\r\n" +
				":79:foobar{bad\r\n" +
				"-}");
		assertNotNull(b4);
		assertEquals(1, b4.size());
		assertEquals("foobar{bad", b4.getTag(0).getValue());
	}


	@Test
	public void testGetBlock4WithMultiline() throws IOException {
		final SwiftBlock4 b4 = SwiftParser.parseBlock4("{4:" + SwiftParser.EOL +
				":98A::SETT//20050708" +  SwiftParser.EOL +
				":90B::DEAL//ACTU/USD28,86" +  SwiftParser.EOL +
				":35B:ISIN US1112223330" +  SwiftParser.EOL +
				"MY COMPANY" +  SwiftParser.EOL +
				":16S:TRADDET" +  SwiftParser.EOL +
				":16R:FIAC" +  SwiftParser.EOL +
				":36B::SETT//UNIT/370,00" +  SwiftParser.EOL +
				":97A::SAFE//111222" +  SwiftParser.EOL +
				":16S:FIAC" +  SwiftParser.EOL +
				":16R:SETDET" +
				"-}");
		assertNotNull(b4);
		assertEquals(9, b4.size());
		assertEquals("35B", b4.getTag(2).getName());

		assertEquals("ISIN US1112223330" +SwiftParser.EOL +
				"MY COMPANY", b4.getTagByName("35B").getValue());

	}

	@Test
	public void testConsumeTag16R() throws IOException {
		final Tag t = parser.consumeTag(":16R:GENL\r\n");
		assertNotNull(t);
		assertEquals("16R", t.getName());
		assertEquals("GENL", t.getValue());
	}

	@Test
	public void testConsumeTagWithBraquets() throws IOException {
		final Tag t = parser.consumeTag(":50K:ABCD}EFG\r\n");
		assertNotNull(t);
		assertEquals("50K", t.getName());
		assertEquals("ABCD}EFG", t.getValue());
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
		parser.setData("4:" + FINWriterVisitor.SWIFT_EOL +
				":16R:GENL" + FINWriterVisitor.SWIFT_EOL +
				":23G:NEWM" + FINWriterVisitor.SWIFT_EOL +
				":98A::PREP//20050711" + FINWriterVisitor.SWIFT_EOL +
				":16S:GE{NL" + FINWriterVisitor.SWIFT_EOL +
				":16S:AMT" + FINWriterVisitor.SWIFT_EOL +
				":16S:SETDET" + FINWriterVisitor.SWIFT_EOL +
				"-}");
		final String m = parser.readUntilBlockEnds();
		assertEquals("4:\r\n" +
				":16R:GENL\r\n" +
				":23G:NEWM\r\n" +
				":98A::PREP//20050711\r\n" +
				":16S:GE{NL\r\n" +
				":16S:AMT\r\n" +
				":16S:SETDET\r\n" +
				"-", m);
	}

	@Test
	public void testReadBlock4WithClosingBraquetInFieldValue() throws IOException {
		parser.setData("4:" + FINWriterVisitor.SWIFT_EOL +
				":16R:GENL" + FINWriterVisitor.SWIFT_EOL +
				":23G:NEWM" + FINWriterVisitor.SWIFT_EOL +
				":98A::PREP//20050711" + FINWriterVisitor.SWIFT_EOL +
				":16S:GE}NL" + FINWriterVisitor.SWIFT_EOL +
				":16S:AMT" + FINWriterVisitor.SWIFT_EOL +
				":16S:SETDET" + FINWriterVisitor.SWIFT_EOL +
				"-}");
		final String m = parser.readUntilBlockEnds();
		assertEquals("4:\r\n" +
				":16R:GENL\r\n" +
				":23G:NEWM\r\n" +
				":98A::PREP//20050711\r\n" +
				":16S:GE}NL\r\n" +
				":16S:AMT\r\n" +
				":16S:SETDET\r\n" +
				"-", m);
	}

	@Test
	public void testConsumeBock1() throws IOException {
		parser.setData("{1:0123456789012345678901234}");
		final SwiftBlock1 b = (SwiftBlock1) parser.consumeBlock(null);
		assertNotNull(b);
		assertTrue(b instanceof SwiftBlock1);
		assertEquals("0123456789012345678901234", b.getBlockValue());
	}

	@Test
	public void testConsumeBock2() throws IOException {
		parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I100BANKDEFFXXXXU3003}");
		final SwiftBlock1 b = (SwiftBlock1) parser.consumeBlock(null);
		assertNotNull(b);
		assertEquals(1, b.getNumber().intValue());
		assertEquals("F01FOOBARXXXXXX0000000000", b.getBlockValue());

		final SwiftBlock2 b2 = (SwiftBlock2) parser.consumeBlock(null);
		assertNotNull(b2);
		assertEquals(2, b2.getNumber().intValue());
		assertEquals("I100BANKDEFFXXXXU3003", b2.getBlockValue());
	}

	@Test
	public void testConsumeBock3() throws IOException {
		parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I541CITIGB2LXXXXN}{4:\r\n" +
				":16R:GENL\r\n" +
				":20C::SEME//2005070600000006\r\n" +
				":23G:NEWM\r\n" +
				":98A::PREP//20050706\r\n" +
				":16S:GENL\r\n" +
				":16R:TRADDET\r\n" +
				":98A::TRAD//20050706\r\n" +
				":98A::SETT//20050711\r\n" +
				":90B::DEAL//ACTU/GBP1,38\r\n" +
				":35B:ISIN GB0007192106\r\n" +
				"VODAFONE\r\n" +
				":16S:TRADDET\r\n" +
				":16R:FIAC\r\n" +
				":36B::SETT//UNIT/5000,00\r\n" +
				":97A::SAFE//6990457647\r\n" +
				":16S:FIAC\r\n" +
				":16R:SETDET\r\n" +
				":22F::SETR//TRAD\r\n" +
				":16R:SETPRTY\r\n" +
				":95R::DEAG/CRST/382\r\n" +
				":16S:SETPRTY\r\n" +
				":16R:SETPRTY\r\n" +
				":95P::SELL//ISNTGB2L\r\n" +
				":16S:SETPRTY\r\n" +
				":16R:SETPRTY\r\n" +
				":95P::PSET//CRSTGB22\r\n" +
				":16S:SETPRTY\r\n" +
				":16R:AMT\r\n" +
				":19A::SETT//GBP6958,31\r\n" +
				":16S:AMT\r\n" +
				":16S:SETDET\r\n" +
				"-}\r\n" +
				"");
		final SwiftBlock1 b1 = (SwiftBlock1) parser.consumeBlock(null);
		assertNotNull(b1);
		assertEquals(1, b1.getNumber().intValue());
		assertEquals("F01FOOBARXXXXXX0000000000", b1.getBlockValue());

		final SwiftBlock2 b2 = (SwiftBlock2) parser.consumeBlock(null);
		assertNotNull(b2);
		assertEquals(2, b2.getNumber().intValue());
		assertEquals("I541CITIGB2LXXXXN", b2.getBlockValue());

		final SwiftBlock4 b4 = (SwiftBlock4) parser.consumeBlock(null);
		assertNotNull(b4);
		assertEquals(4, b4.getNumber().intValue());
		//assertEquals("", b4.getBlockValue());

		final SwiftBlock nil = parser.consumeBlock(null);
		assertNull(nil);
	}

	@Test
	public void testSimpleBlockConsumerBlock3_1() throws IOException {
		parser.setData("{3:{108:00112233}}");
		final SwiftBlock3 b3 = (SwiftBlock3) parser.consumeBlock(null);
		assertNotNull(b3);
		assertTrue(b3 instanceof SwiftBlock);
		assertTrue(b3.containsTag("108"));
		assertEquals("00112233", b3.getTagValue("108"));
	}

	@Test
	public void testSimpleBlockConsumerBlock3_2() throws IOException {
		parser.setData("{3:{108:00112233}{4:foobar}}");
		final SwiftBlock3 b3 = (SwiftBlock3) parser.consumeBlock(null);
		assertNotNull(b3);
		assertTrue(b3 instanceof SwiftBlock);
		assertTrue(b3.containsTag("108"));
		assertEquals("00112233", b3.getTagValue("108"));
		assertTrue(b3.containsTag("4"));
		assertEquals("foobar", b3.getTagValue("4"));
	}

	@Test
	public void testSimpleBlockConsumerBlock5_1() throws IOException {
		parser.setData("{5:{108:00112233}}");
		final SwiftBlock5 b = (SwiftBlock5) parser.consumeBlock(null);
		assertNotNull(b);
		assertTrue(b instanceof SwiftBlock);
		assertTrue(b.containsTag("108"));
		assertEquals("00112233", b.getTagValue("108"));
	}

	@Test
	public void testSimpleBlockConsumerBlock5_2() throws IOException {
		parser.setData("{5:{108:00112233}{4:foobar}}");
		final SwiftBlock5 b = (SwiftBlock5) parser.consumeBlock(null);
		assertNotNull(b);
		assertTrue(b instanceof SwiftBlock);
		assertTrue(b.containsTag("108"));
		assertEquals("00112233", b.getTagValue("108"));
		assertTrue(b.containsTag("4"));
		assertEquals("foobar", b.getTagValue("4"));
	}

	@Test
	public void testBug1539324() throws SAXException, IOException, ParserConfigurationException {
		final String fin = "{1:"+Constants.B1_DATA+"}{3:{n:v}}";
		parser.setData(fin);
		final SwiftBlock1 b1 = (SwiftBlock1) parser.consumeBlock(null);
		final SwiftBlock3 b3 = (SwiftBlock3) parser.consumeBlock(null);
		assertTrue(b1 instanceof SwiftBlock1);
		assertTrue(b3 instanceof SwiftBlock3);
		assertEquals(Constants.B1_DATA, ((SwiftBlock1)b1).getValue());
		assertEquals(1, ((SwiftBlock3)b3).countAll());
		assertEquals("n", ((SwiftBlock3)b3).getTag(0).getName());
		assertEquals("v", ((SwiftBlock3)b3).getTag(0).getValue());
	}

	@Test
	public void testBug1539324_2() throws SAXException, IOException, ParserConfigurationException {
		final String fin = "{1:"+Constants.B1_DATA+"}{3:{n:v}}";
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
	public void testBug1539324_3() throws SAXException, IOException, ParserConfigurationException {
		final String fin = "{1:"+Constants.B1_DATA+"}{3:{n:v}}";
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
	public void testOneTagSimilarToBug1540294_1 () throws IOException {
		final String fin = "{4:\r\n" +
				":t2:v2\r\n" +
				"-}";
		final SwiftParser p = new SwiftParser(new StringReader(fin));
		final SwiftMessage msg = p.message();
		assertNotNull(msg.getBlock4());
		assertEquals(1, msg.getBlock4().size());
		assertEquals("v2", msg.getBlock4().getTagValue("t2"));
	}

	@Test
	public void testBug1601122_1 () throws IOException {
		final String fin = "{5:{MAC:32D7EA50}{CHK:AB1538FB729E}}";
		final SwiftParser p = new SwiftParser(new StringReader(fin));
		final SwiftMessage msg = p.message();
		assertNotNull(msg.getBlock5());
		assertEquals(2, msg.getBlock5().size());
		assertEquals("32D7EA50", msg.getBlock5().getTagValue("MAC"));
		assertEquals("AB1538FB729E", msg.getBlock5().getTagValue("CHK"));
	}

	/*
	 * checks that text mixed with tags is handled as unparsed text
	 */
	@Test
	public void testSimpleBlockConsumerBlock3_3_KnownToFail() throws IOException {
		parser.setData("{3:blockdata{108:00112233}{4:foobar}}");
		final SwiftBlock3 b = (SwiftBlock3) parser.consumeBlock(null);
		assertNotNull(b);
		assertTrue(b instanceof SwiftBlock);
		assertTrue(b.containsTag("108"));
		assertEquals("00112233", b.getTagValue("108"));
		assertTrue(b.containsTag("4"));
		assertEquals("foobar", b.getTagValue("4"));
		assertEquals(b.getUnparsedTextsSize(), new Integer(1));
		assertEquals(b.unparsedTextGetText(0), "blockdata");
	}

	@Test
	public void testTag77Exceptions_1() throws Exception {
		final String m = "{1:F01FOOBARYYAXXX1234123456}{2:O1030811060227FOOBBSMMAXXX55529746000602270811N}{3:{113:NOMF}{108:0602021485081594}{119:STP}}{4:^M\r\n" +
				":77E:  \r\n" +
				"ABCDEFG\r\n" +
				"-}{5:{MAC:80C69B21}{CHK:63035B4672E0}}\r\n" +
				"\r\n" +
				"";
		final SwiftMessage msg = new SwiftParser(m).message();
		assertNotNull(msg);
		assertEquals(msg.getBlock4().getTagByName("77E").getValue(), "  \r\n" + "ABCDEFG");
	}

	@Test
	public void testTag77Exceptions_2() throws Exception {
		final String m = "{1:F01FOOBARYYAXXX1234123456}{2:O1030811060227FOOBBSMMAXXX55529746000602270811N}{3:{113:NOMF}{108:0602021485081594}{119:STP}}{4:\r\n" +
				":77E:\r\n" +
				"ABCDEFG\r\n" +
				"-}{5:{MAC:80C69B21}{CHK:63035B4672E0}}\r\n" +
				"\r\n" +
				"";
		final SwiftMessage msg = new SwiftParser(m).message();
		assertNotNull(msg);
		assertEquals(msg.getBlock4().getTagByName("77E").getValue(), "\r\n" + "ABCDEFG");
	}

	@Test
	public void testTag77Exceptions_3() throws Exception {
		final String m = "{1:F01FOOBARYYAXXX1234123456}{2:O1030811060227FOOBBSMMAXXX55529746000602270811N}{3:{113:NOMF}{108:0602021485081594}{119:STP}}{4:\r\n" +
				":77E::\r\n" +
				":\r\n" +
				"QWERTYU\r\n" +
				"-}{5:{MAC:80C69B21}{CHK:63035B4672E0}}\r\n" +
				"\r\n" +
				"";
		final SwiftMessage msg = new SwiftParser(m).message();
		assertNotNull(msg);
		assertEquals(msg.getBlock4().getTagByName("77E").getValue(), ":\r\n" + ":\r\n" + "QWERTYU");
	}

	@Test
	public void testTag77Exceptions_4() throws Exception {
		final String m = "{1:F01FOOBARYYAXXX1234123456}{2:O1030811060227FOOBBSMMAXXX55529746000602270811N}{3:{113:NOMF}{108:0602021485081594}{119:STP}}{4:\r\n" +
				":77E:-\r\n" +
				":\r\n" +
				"ZXCVBNM\r\n" +
				"-}{5:{MAC:80C69B21}{CHK:63035B4672E0}}\r\n" +
				"\r\n" +
				"";
		final SwiftMessage msg = new SwiftParser(m).message();
		assertNotNull(msg);
		assertEquals(msg.getBlock4().getTagByName("77E").getValue(), "-\r\n" + ":\r\n" + "ZXCVBNM");
	}

	/**
	 * http://sourceforge.net/projects/wife/forums/forum/544818/topic/3399143
	 */
	@Test
	public void test_MT535_35B_with_colon() throws Exception {
		final String m = "{1:F01BFOOUS3IADNC0147771111}{2:O5350837080313FOOSGB2LIXXX06988488300803130437N}{3:{108:000952CQ1650453}}{4:\r\n" +
				":16R:GENL\r\n" +
				":28E:6/MORE\r\n" +
				":20C::SEME//H200803121132222\r\n" +
				":23G:NEWM\r\n" +
				":98A::STAT//20080312\r\n" +
				":22F::SFRE//DAIL\r\n" +
				":22F::CODE//COMP\r\n" +
				":22F::STTY//CUST\r\n" +
				":22F::STBA//TRAD\r\n" +
				":97A::SAFE//S 02500\r\n" +
				":17B::ACTI//Y\r\n" +
				":17B::AUDT//N\r\n" +
				":17B::CONS//N\r\n" +
				":16S:GENL\r\n" +
				":16R:SUBSAFE\r\n" +
				":16R:FIN\r\n" +
				//				:35B:ISIN XS0222550880 4,125? LANXESS FIN.B.V.NT.V.05 21.6 :12
				":35B:/US/AGGR_AVAI\r\n" +
				"AGGR=300, AVAI:=200\r\n" +
				":16R:FIA\r\n" +
				":12A::CLAS/ISIT/STF\r\n" +
				":16S:FIA\r\n" +
				":93B::AGGR//FAMT/300,\r\n" +
				":93B::AVAI//FAMT/200,\r\n" +
				":16R:SUBBAL\r\n" +
				":93B::AGGR//FAMT/50,\r\n" +
				":94F::SAFE//CUST/FOOSUS33\r\n" +
				":70C::SUBB//REGISTRATION CODE MEMR\n" +
				":16S:SUBBAL\r\n" +
				":16S:FIN\r\n" +
				":16R:FIN\r\n" +
				"-}";
		final SwiftMessage msg = new SwiftParser(m).message();
		assertNotNull(msg);
		assertEquals(msg.getBlock4().getTagByName("35B").getValue(), "/US/AGGR_AVAI\r\nAGGR=300, AVAI:=200");
	}

	/**
	 * http://sourceforge.net/projects/wife/forums/forum/544818/topic/3399143
	 */
	@Test
	public void test_MT535_35B_with_colon_2() throws Exception {
		final String m = "{1:F01BFOOUS3IADNC0147771111}{2:O5350837080313FOOSGB2LIXXX06988488300803130437N}{3:{108:000952CQ1650453}}{4:\r\n" +
				":16R:GENL\r\n" +
				":28E:6/MORE\r\n" +
				":20C::SEME//H200803121132222\r\n" +
				":23G:NEWM\r\n" +
				":98A::STAT//20080312\r\n" +
				":22F::SFRE//DAIL\r\n" +
				":22F::CODE//COMP\r\n" +
				":22F::STTY//CUST\r\n" +
				":22F::STBA//TRAD\r\n" +
				":97A::SAFE//S 02500\r\n" +
				":17B::ACTI//Y\r\n" +
				":17B::AUDT//N\r\n" +
				":17B::CONS//N\r\n" +
				":16S:GENL\r\n" +
				":16R:SUBSAFE\r\n" +
				":16R:FIN\r\n" +
				":35B:ISIN XS0222550880\r\n" +
				"4,125? LANXESS FIN.B.V.NT.V.05 21.6\r\n" +
				//":12\r\n" +
				/*
				 * within the field content, a colon ':' must never be used as the first character
				 * of a line (the combination 'CrLf:' always indicates a new field tag)
				 */
				 ":16R:FIA\r\n" +
				 ":12A::CLAS/ISIT/STF\r\n" +
				 ":16S:FIA\r\n" +
				 ":93B::AGGR//FAMT/300,\r\n" +
				 ":93B::AVAI//FAMT/200,\r\n" +
				 ":16R:SUBBAL\r\n" +
				 ":93B::AGGR//FAMT/50,\r\n" +
				 ":94F::SAFE//CUST/FOOSUS33\r\n" +
				 ":70C::SUBB//REGISTRATION CODE MEMR\n" +
				 ":16S:SUBBAL\r\n" +
				 ":16S:FIN\r\n" +
				 ":16R:FIN\r\n" +
				 "-}";
		final SwiftMessage msg = new SwiftParser(m).message();
		assertNotNull(msg);
	}

	@Test
	public void testPatchWalterBirch() throws IOException {
		final String fin = "{1:F01VONTCHZZAXXX7586415286}{2:I202CHASUS33XXXXN}{3:{108:129324618/1XXXXX}}{4:" + FINWriterVisitor.SWIFT_EOL +
				":20:129324618/1XXXXX" +FINWriterVisitor.SWIFT_EOL +
				":21:NONREF" + FINWriterVisitor.SWIFT_EOL +
				":32A:110705USD20079,39" + FINWriterVisitor.SWIFT_EOL +
				":57A:CITIUS33XXX" + FINWriterVisitor.SWIFT_EOL +
				":58A:NBSZCHZZXXX" + FINWriterVisitor.SWIFT_EOL +
				":72:/BNF/30.05.11 10000" + FINWriterVisitor.SWIFT_EOL +
				"" + FINWriterVisitor.SWIFT_EOL +
				"-}{5:{CHK:88C7BBB37D50}}";
		final SwiftParser p = new SwiftParser(new StringReader(fin));
		final SwiftMessage msg = p.message();
		assertNotNull(msg.getBlock1());
		assertNotNull(msg.getBlock4());
		assertEquals("Expected 6 tags but found "+msg.getBlock4().size()+", "+msg.getBlock4().tagNamesList(), 6, msg.getBlock4().size());
		//		assertEquals("v1", msg.getBlock4().getTagValue("t1"));
		//		assertEquals("v2", msg.getBlock4().getTagValue("t2"));
	}

	@Test
	public void testTagEndSearch() {
		final String s = "4:\n" +
				":20:628735BKRU3X\n" +
				":79:TO FOO\n" +
				"ATTN. FOO OPERATIONS\n" +
				"FROM.\n" +
				"RE.   JOE DOE A/C 1111\n" +
				"A/C: 961XXX\n" +
				".\n" +
				"WE CONFIRM TO INCREASE THE FOLLOWING DEPOSIT FROM\n" +
				"RATE       10.0000\n" +
				".\n" +
				"INSTRUCTIONS:\n" +
				"STATE STREET BANK AND TRUST CO, NA NEW YORK\n" +
				"SWIFT CODE: FOOSUS3N\n" +
				"VALUE 22 MAY 2012\n" +
				".\n" +
				"REGARDS,\n" +
				"}\n" +
				"-";
		final int start = 21;
		final int end = this.parser.textTagEndBlock4(s, start, true);
		final String tag = s.substring(start, end);
		assertEquals('-', tag.charAt(tag.length()-1));
	}

	@Test
	public void testTagEndSearch1() {
		final String s = ":79:foo\n" +
				"}\n" +
				"-}";
		final int end = this.parser.textTagEndBlock4(s, 0, true);
		assertTrue(end+" mayor que largo total ("+s.length()+")", end<s.length());
		assertEquals('-', s.charAt(end));
	}

	@Test
	public void testTicket28() throws IOException {
		final SwiftBlock4 b4 = SwiftParser.parseBlock4("{4:\r\n" +
				":16R:GENL\r\n" +
				":23G:NEWM\r\n" +
				":98A::PREP//20050711\r\n" +
				":16S:GENL\r\n" +
				":16S:AMT\r\n" +
				":16S:SETDET" +
				"-}");
		assertNotNull(b4);
		assertEquals(6, b4.size());
	}

	@Test
	public void testParserConfigurationCompare() throws IOException {
		final SwiftParserConfiguration faster = new SwiftParserConfiguration();
		faster.setParseTextBlock(false);
		final long t1a = parse(new SwiftParserConfiguration(), 1000);
		final long t2a = parse(faster, 1000);
		assertTrue(t1a > t2a);
	}

	private long parse(final SwiftParserConfiguration config, final int repetitions) throws IOException {
		final SwiftParser parser = new SwiftParser();
		parser.setConfiguration(config);
		long cum = 0;
		SwiftMessage msg = null;
		for (int i = 0; i < repetitions; i++) {
			final long t0a = Calendar.getInstance().getTimeInMillis();
			msg = parser.parse(sample_535);
			final long t1a = Calendar.getInstance().getTimeInMillis();
			final long t = (t1a - t0a);
			cum = cum + t;
			assertNotNull(msg);
			if (config.isParseTextBlock()) {
				assertFalse(msg.getBlock4().isEmpty());
			} else {
				assertTrue(msg.getBlock4().isEmpty());
			}
			if (config.isParseTrailerBlock()) {
				assertFalse(msg.getBlock5().isEmpty());
			} else {
				assertTrue(msg.getBlock5().isEmpty());
			}
		}
		return cum;
	}

	String sample_535 =
			"{1:F01FOOBARXXAXXX0387240778}{2:O5350029060914FOOBARXXXXXX03549878070609140029N}{4:\n" +
					// sequence A - General Information
					":16R:GENL\n" +
					":28E:00005/MORE\n" +
					":20C::SEME//ICF2750609140005\n" +
					":23G:NEWM\n" +
					":98A::STAT//20060913\n" +
					":22F::SFRE//DAIL\n" +
					":22F::CODE//COMP\n" +
					":22F::STTY//CUST\n" +
					":22F::STBA//TRAD\n" +
					":97A::SAFE//F275\n" +
					":17B::ACTI//Y\n" +
					":17B::AUDT//N\n" +
					":17B::CONS//N\n" +
					":16S:GENL\n" +
					// sequence B - Sub-safekeeping account
					":16R:SUBSAFE\n" +
					":16R:FIN\n" +
					":35B:/US/31392EXH8\n" +
					"FEDERAL FOO MTG ASSN\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,14528727\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/35732656,\n" +
					":93B::AVAI//FAMT/35732656,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/35732656,\n" +
					":93B::AVAI//FAMT/35732656,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31392E7B0\n" +
					"FEDERAL FOO MTG ASSN\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,16255627\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/48864356,\n" +
					":93B::AVAI//FAMT/48864356,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/48864356,\n" +
					":93B::AVAI//FAMT/48864356,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31392FDB0\n" +
					"FEDERAL FOO MTG ASSN GTD\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,30628171\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/15000000,\n" +
					":93B::AVAI//FAMT/15000000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/15000000,\n" +
					":93B::AVAI//FAMT/15000000,\n" +
					":94F::SAFE//NCSD/DTCYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31392F6D4\n" +
					"FEDERAL FOO MTG ASSN\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,35018015\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/22700000,\n" +
					":93B::AVAI//FAMT/22700000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/22700000,\n" +
					":93B::AVAI//FAMT/22700000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31392F6K8\n" +
					"FEDERAL FOO MTG ASSN\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,1838114\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/43333333,\n" +
					":93B::AVAI//FAMT/43333333,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/43333333,\n" +
					":93B::AVAI//FAMT/43333333,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31392GVX0\n" +
					"FEDERAL FOO MTG ASSN\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,27894901\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/7865000,\n" +
					":93B::AVAI//FAMT/7865000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/7865000,\n" +
					":93B::AVAI//FAMT/7865000,\n" +
					":94F::SAFE//NCSD/DTCYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31392TSB4\n" +
					"FEDERAL HOME LN FOO CORP\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,13866795\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/20000000,\n" +
					":93B::AVAI//FAMT/20000000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/20000000,\n" +
					":93B::AVAI//FAMT/20000000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/313921CX4\n" +
					"FEDERAL FOO MTG ASSN\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,01834306\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/6409602,\n" +
					":93B::AVAI//FAMT/6409602,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/6409602,\n" +
					":93B::AVAI//FAMT/6409602,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31393AG84\n" +
					"FEDERAL FOO MTG ASSN MTN\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,42466806\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/8000000,\n" +
					":93B::AVAI//FAMT/8000000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/8000000,\n" +
					":93B::AVAI//FAMT/8000000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31393BU94\n" +
					"FEDERAL FOO MTG ASSN\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,28337156\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/23232171,\n" +
					":93B::AVAI//FAMT/23232171,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/23232171,\n" +
					":93B::AVAI//FAMT/23232171,\n" +
					":94F::SAFE//NCSD/DTCYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31393BX75\n" +
					"FEDERAL FOO MTG ASSN GTD\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,31807496\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/51600000,\n" +
					":93B::AVAI//FAMT/51600000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/51600000,\n" +
					":93B::AVAI//FAMT/51600000,\n" +
					":94F::SAFE//NCSD/DTCYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31393UMQ3\n" +
					"FEDERAL FOO MTG ASSN REMIC\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,53188477\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/1250000,\n" +
					":93B::AVAI//FAMT/1250000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/1250000,\n" +
					":93B::AVAI//FAMT/1250000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31393XFT9\n" +
					"FNMA FOO TRUST\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,43229892\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/4375650,\n" +
					":93B::AVAI//FAMT/4375650,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/4375650,\n" +
					":93B::AVAI//FAMT/4375650,\n" +
					":94F::SAFE//NCSD/DTCYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31394LBV3\n" +
					"FEDERAL HOME LN FOO CORP\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,40350442\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/6000000,\n" +
					":93B::AVAI//FAMT/6000000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/6000000,\n" +
					":93B::AVAI//FAMT/6000000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31394R2J7\n" +
					"FEDERAL HOME LN FOO CORP\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,18203448\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/8000000,\n" +
					":93B::AVAI//FAMT/8000000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/8000000,\n" +
					":93B::AVAI//FAMT/8000000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31394XVD5\n" +
					"FEDERAL HOME LN FOO CORP\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,48144936\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/3000000,\n" +
					":93B::AVAI//FAMT/3000000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/3000000,\n" +
					":93B::AVAI//FAMT/3000000,\n" +
					":94F::SAFE//NCSD/DTCYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31400PGE9\n" +
					"FNMA FOO 693297\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,19077368\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/1235403,\n" +
					":93B::AVAI//FAMT/1235403,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/1235403,\n" +
					":93B::AVAI//FAMT/1235403,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31402QHS3\n" +
					"FNMA FOO 734741\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,72142663\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/12735000,\n" +
					":93B::AVAI//FAMT/12735000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/12735000,\n" +
					":93B::AVAI//FAMT/12735000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31403NJ81\n" +
					"FNMA FOO 753687\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,31380405\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/25005520,\n" +
					":93B::AVAI//FAMT/25005520,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/25005520,\n" +
					":93B::AVAI//FAMT/25005520,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31405N4A0\n" +
					"FNMA FOO 794717\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,48266546\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/2885565,\n" +
					":93B::AVAI//FAMT/2885565,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/2885565,\n" +
					":93B::AVAI//FAMT/2885565,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31405PRS1\n" +
					"FNMA FOO 795297\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,51848398\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/25000000,\n" +
					":93B::AVAI//FAMT/25000000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/25000000,\n" +
					":93B::AVAI//FAMT/25000000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31406RR72\n" +
					"FNMA FOO 817810\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,000000\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/0,\n" +
					":93B::AVAI//FAMT/N990692,\n" +
					":93B::NAVL//FAMT/990692,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/0,\n" +
					":93B::AVAI//FAMT/N990692,\n" +
					":93B::NAVL//FAMT/990692,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					//":16R:SUBBAL\n" +
					//":93C::PEND//FAMT/NAVL/990692,\n" +
					//":94F::SAFE//NCSD/FRNYUS33\n" +
					//":16S:SUBBAL\n" +
					//":16R:SUBBAL\n" +
					//":93C::PENR//FAMT/NAVL/990692,\n" +
					//":94F::SAFE//NCSD/FRNYUS33\n" +
					//":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31407RSB1\n" +
					"FNMA FOO 838514\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,96155571\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/3650000,\n" +
					":93B::NAVL//FAMT/3650000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/3650000,\n" +
					":93B::NAVL//FAMT/3650000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					//":16R:SUBBAL\n" +
					//":93C::PENR//FAMT/NAVL/3650000,\n" +
					//":94F::SAFE//NCSD/FRNYUS33\n" +
					//":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31409KHC4\n" +
					"FNMA FOO 873327\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,99073685\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/2586984,\n" +
					":93B::AVAI//FAMT/2586984,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/2586984,\n" +
					":93B::AVAI//FAMT/2586984,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31409KHD2\n" +
					"FNMA FOO 873328\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,99026461\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/3900000,\n" +
					":93B::AVAI//FAMT/3900000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/3900000,\n" +
					":93B::AVAI//FAMT/3900000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31409KKH9\n" +
					"FNMA FOO 873396\n" +
					":16R:FIA\n" +
					":92A::CUFC//1,\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/7500000,\n" +
					":93B::AVAI//FAMT/7500000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/7500000,\n" +
					":93B::AVAI//FAMT/7500000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31409KLJ4\n" +
					"FNMA FOO 873429\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,9867294\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/3989570,\n" +
					":93B::AVAI//FAMT/3989570,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/3989570,\n" +
					":93B::AVAI//FAMT/3989570,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31409KMR5\n" +
					"FNMA FOO 873468\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,99476164\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/1056000,\n" +
					":93B::AVAI//FAMT/1056000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/1056000,\n" +
					":93B::AVAI//FAMT/1056000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31409KNL7\n" +
					"FNMA FOO 873495\n" +
					":16R:FIA\n" +
					":92A::CUFC//0,9892473\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/12500000,\n" +
					":93B::AVAI//FAMT/12500000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/12500000,\n" +
					":93B::AVAI//FAMT/12500000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16R:FIN\n" +
					":35B:/US/31409KQP5\n" +
					"FNMA FOO 873562\n" +
					":16R:FIA\n" +
					":92A::CUFC//1,\n" +
					":16S:FIA\n" +
					":93B::AGGR//FAMT/7680000,\n" +
					":93B::AVAI//FAMT/7680000,\n" +
					":16R:SUBBAL\n" +
					":93B::AGGR//FAMT/7680000,\n" +
					":93B::AVAI//FAMT/7680000,\n" +
					":94F::SAFE//NCSD/FRNYUS33\n" +
					":16S:SUBBAL\n" +
					":16S:FIN\n" +
					":16S:SUBSAFE\n" +
					"-}{5:{MAC:E19445CF}{CHK:D625798DFC51}}";

	@Test
	public void testFieldStartingWithColon() throws Exception {
		final String val = "/PY/OSA PAYMENT/BN/FOO LIMITED/BN1/6/F,HONGCHANG PLAZA,N\n" +
				":6542670O2001,/BN2/SHENNAN ROAD EAST,LUOHU DIST,/BN3/SHENZHEN,CHINA/BI/12\n" +
				"44712009/BO/INFINITY HOME LIMITED ROOM 2105 FZ2250 TREND CTR 29-3\n" +
				"1 CH/BO3/EUNG LEE STREET CHAI WAN HK/CM/USD1,00/CA/1244712009/OB/\n" +
				"CHINA FOO BANK/PT/FT/PO/0005/OCMT/USD2620,80/XT/CD/REF/1029\n" +
				"200004099";
		final String fin = "{1:"+Constants.B1_DATA+"}{4:\n" +
				":86:"+val+"\n" +
				"-}";
		final SwiftParser p = new SwiftParser(new StringReader(fin));
		final SwiftMessage msg = p.message();
		assertEquals(1, msg.getBlock4().countAll());
		assertNotNull(msg.getBlock4().getTagByName("86"));
		assertEquals(val, msg.getBlock4().getTagByName("86").getValue());
	}

	@Test
	public void testFieldStartingWithColonTrimmed() throws Exception {
		final String fin = "{1:"+Constants.B1_DATA+"}{4:\n" +
				":86:/FOO\n" +
				":123BAR\n" +
				"-}";
		final SwiftParser p = new SwiftParser(new StringReader(fin));
		final SwiftMessage msg = p.message();
		assertEquals(1, msg.getBlock4().countAll());
	}
	@Test
	public void testFieldStartingWithColonTrimmedColonAndText() throws Exception {
		final String fin = "{1:"+Constants.B1_DATA+"}{4:\n" +
				":86:/FOO\n" +
				":BAR\n" +
				"-}";
		final SwiftParser p = new SwiftParser(new StringReader(fin));
		final SwiftMessage msg = p.message();
		assertEquals(1, msg.getBlock4().countAll());
	}
	
	@Test
	public void testConsumeTagColons1() throws Exception {
		Tag o = this.parser.consumeTag(":86:/FOO\n" +
				":BAR\n");
		assertTrue(o.getValue().contains("BAR"));
	}
	
	@Test
	public void testTagStartsTrue() throws Exception {
		assertTrue(tagStarts("20:"));
		assertTrue(tagStarts("20:foo"));
		assertTrue(tagStarts("20::foo"));
		assertTrue(tagStarts("20C:"));
		assertTrue(tagStarts("20C:foo"));
		assertTrue(tagStarts("20C::foo"));
	}
	
	@Test
	public void testTagStartsFalse() throws Exception {
		assertFalse(tagStarts("20foo"));
		assertFalse(tagStarts("2:foo"));
		assertFalse(tagStarts("20CC:"));
		assertFalse(tagStarts("20c:"));
		assertFalse(tagStarts(":20foo"));
		assertFalse(tagStarts("20foo"));
		assertFalse(tagStarts(":/ account stuff:"));
	}
	
	private static final boolean tagStarts(final String str) {
		try {
			Method method = SwiftParser.class.getDeclaredMethod("tagStarts", String.class, int.class);
			method.setAccessible(true);
			return (Boolean) method.invoke(null, str, 0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void testAck1() throws Exception {
		final String msg = "{1:F21OMFNCIABAXXX6368087500}{4:{177:1511041614}{451:0}}{1:F01OMFNCIABAXXX6368087500}{2:O1031542151104BCAOSNDPAXXX22438129121511041542N}{3:{113:0030}{108:001RTGS153030005}}{4:\n" + 
				":20:1234567890\n" + 
				":23B:CRED\n" + 
				":23E:SDVA\n" + 
				":26T:001\n" + 
				":32A:151104XOF27000000,\n" + 
				":50K:/0020121503484101\n" + 
				"SOXNYFAYTONU VORYEAUGEIS\n" + 
				":53A:/D/D00030901\n" + 
				"ECOCMLBA\n" + 
				":57A:/C/A00031061\n" + 
				"OMFNCIAB\n" + 
				":59:/010010100100014010010160\n" + 
				"FOO VOYAGES\n" + 
				":70:TRANSFERT\n" + 
				":71A:SHA\n" + 
				":72:/CODTYPTR/001\n" + 
				"//REGLEMENT\n" + 
				"-}{5:{MAC:00000000}{CHK:0AF226411593}}{S:{SPD:}{SAC:}{COP:P}}";
		SwiftMessage sm = new SwiftParser(msg).message();
		assertNotNull(sm);
		assertTrue(sm.isAck());
	}
	
	@Test
	public void testAck2() throws Exception {
		final String msg = "{1:F21OMFNCIABAXXX6368087504}{4:{177:1511041718}{451:0}}{1:F01OMFNCIABAXXX6368087504}{2:O1031746151104CCEICMCXAXXX64953042471511041646N}{4:\n" + 
				":20:1234567890\n" + 
				":23B:CRED\n" + 
				":32A:151104XOF14773500,\n" + 
				":50K:/00057 03363591001 84\n" + 
				"FOO SARL \n" + 
				"AKWA, FACE ANCIEN DIRECTION NOBRA\n" + 
				"BP 1432 DOURAZLA\n" + 
				"237 CAMEROUN\n" + 
				":57A:CBAOSNDA\n" + 
				":59:/SN 012 01201 036169011401 63\n" + 
				"TSAEMOXU FOO INTERUNATIONALE SARL\n" + 
				"DIAMNIADO, DAKAR\n" + 
				"SENEGAL\n" + 
				":70:/INV/TFI-ZS-15002\n" + 
				":71A:SHA\n" + 
				"-}{5:{MAC:00000000}{CHK:50085EDF60EC}}{S:{SPD:}{SAC:}{COP:P}}";
		SwiftMessage sm = new SwiftParser(msg).message();
		assertNotNull(sm);
		assertTrue(sm.isAck());
	}
	
	/**
	 * Extra data simple
	 */
	@Test
	public void testExtraDataSimple() throws IOException {
		final String fin = "{1:F01MOSWRUMMAXXX0000000000}{2:I103COBADEFFXXXXN}{3:{108:02161OKP00130914}}{4:\n"+
				":20:12345677890\n"+
				":23B:CRED\n"+
				":32A:160217EUR500,\n"+
				":50K:/42301978502050100067\n"+
				"SHEPTUKHA VIKTORIA PAS45 15 362057\n"+
				"CCC MOSCOW MOSCOW UL. AVIACIONNAYA\n"+
				"DON. 99 KV. 123\n"+
				":52D:BANK OF MOSCOW\n"+
				":57A:CAIXESBBXXX\n"+
				":59:/ES3021000122390200002631\n"+
				"FOO TRADE SL SPAIN CASTELLO D E\n"+
				"FOO PLACA JOC DE LA PILOTA , NU\n"+
				"M 1\n"+
				":70:PAYMENT FOR NALOG ZA APARTAMENT\n"+
				":71A:OUR\n"+
				":72:/ACC/UR LIZO BBBB ))))))))::::::\n"+
				"-}foo";
		SwiftParser p = new SwiftParser(fin);
		SwiftMessage m = p.message();
		assertFalse(m.getUnparsedTextsSize()==0);
	}
	
	/**
	 * Expected extra "}}}}" reported as error
	 */
	@Test
	public void testExtraData() throws IOException {
		final String fin = "{1:F01MOSWRUMMAXXX0000000000}{2:I103COBADEFFXXXXN}{3:{108:02161OKP00130914}}{4:\n"+
			":20:1234567890\n"+
			":23B:CRED\n"+
			":32A:160217EUR500,\n"+
			":50K:/42301978502050100067\n"+
			"FOO VIKTORIA PAS45 15 362057\n"+
			"CCC MOSCOW MOSCOW UL. FOO\n"+
			"DON. 13 KV. 131\n"+
			":52D:BANK OF MOSCOW\n"+
			":57A:CAIXESBBXXX\n"+
			":59:/ES3021000122390200002631\n"+
			"FOO TRADE SL SPAIN CASTELLO D E\n"+
			"FOO PLACA JOC DE LA PILOTA , NU\n"+
			"M 1\n"+
			":70:PAYMENT FOR NALOG ZA APARTAMENT\n"+
			":71A:OUR\n"+
			":72:/ACC/UR LIZO BBBB ))))))))::::::\n"+
			"-}}}}}";
		SwiftParser p = new SwiftParser(fin);
		SwiftMessage m = p. message();
		assertFalse(m.getUnparsedTextsSize()==0);
	}
	
	/*
	 * https://sourceforge.net/p/wife/bugs/80/
	 */
	@Test
	public void testParse() throws IOException {
		final String fin = "{1:F01TESTAR00AXXX7607663781}{2:O1010824170510TESTAR00AXXX94149133901705101425N}{4:\n" +
				":20:DG942_171206-004\n" +
				":28D:00001/00001\n" +
				":50H:/344110001637\n" +
				"TESTAR00AXXX\n" +
				"Utrecht\n" +
				"Netherlands\n" +
				":30:170502\n" +
				":21:010735904\n" +
				":32B:CNY14,00\n" +
				":57A:CIBKCNBJ473\n" +
				":59:/344110000361\n" +
				"CASH CUSTOMER I\n" +
				"TESTAR00AXXX\n" +
				"Utrecht\n" +
				"Netherlands\n" +
				":70:/RFB/C767405OCP021001\n" +
				":71A:SHA\n" +
				"-}{5:{CHK:B3BF0D846AFD}}";
		SwiftMessage msg = (new SwiftParser(fin)).message();
		assertNotNull(msg);
		assertNotNull(msg.getBlock1());
		assertNotNull(msg.getBlock2());
		assertNotNull(msg.getBlock4());
		assertNotNull(msg.getBlock5());
		assertEquals("TESTAR00AXXX", msg.getBlock1().getLogicalTerminal());
		assertEquals("101", msg.getBlock2().getMessageType());
		assertEquals("DG942_171206-004", msg.getBlock4().getFieldByName("20").getValue());
	}

}
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
package com.prowidesoftware.swift.model;

import com.prowidesoftware.swift.Constants;
import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.io.IConversionService;
import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.io.writer.SwiftWriter;
import org.junit.Before;
import org.junit.Test;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;

import static org.junit.Assert.*;


/**
 * Conversion services test.
 *
 * @since 4.0
 */
public class ConversionServiceTest {

	private IConversionService srv;
	private SwiftMessage msg;
	private String fin = "{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{3:{108:P22VUXC43C6J3NLD}}{4:\n" +
			":20:AMLX985338-D4E5E\n" + 
			":23B:CRED\n" + 
			":32A:051018EUR66969,52\n" + 
			":33B:EUR66969,52\n" + 
			":50K:FOO SA\n" + 
			":53A:DEUTDEFF\n" + 
			":54A://RT\n" + 
			"FOOBARYY\n" +
			":59:/-\n" + 
			"Tressis SA\n" + 
			":70:/CS BD ST EUR B\n" + 
			"REDEMPTION AMLX985338\n" + 
			":71A:OUR\n" + 
			"-}{5:{MAC:52F48656}{CHK:24C40F1FF931}}";
	private UnparsedTextList unparsedTexts;
	private String someMsgText = "{1:L02VNDZBET2AXXX}{4:{501:05134200001900000513420000190000B8D33C65}{110:001}}";
	private String someText = "hello world";

	private void assertXmlEqual(String control, String test) {
		Diff diff = DiffBuilder.compare(control).withTest(test).ignoreWhitespace().build();
		assertFalse(diff.hasDifferences());
	}

	@Before
	public void setUp() {
		srv = new ConversionService();
		msg = new SwiftMessage();
		unparsedTexts = new UnparsedTextList();
		unparsedTexts.addText(this.someMsgText);
		unparsedTexts.addText(this.someText);
	}
	
	/**
	 * Test method for {@link ConversionService#getFIN(SwiftMessage)}.
	 */
	@Test 
	public void testGetFINFromObj() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("113:NOMT"));
		msg.getBlock3().append(new Tag("108", "P22VUXC43C6J3NLD"));
		String fin = srv.getFIN(msg);
		assertEquals("{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{3:{113:NOMT}{108:P22VUXC43C6J3NLD}}", fin);
	}

	/**
	 * Test method for {@link ConversionService#getFIN(SwiftMessage)}.
	 */
	@Test
	public void testGetFINFromObj2() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("108", "P22VUXC43C6J3NLD"));
		String fin = srv.getFIN(msg);
		assertEquals("{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{3:{108:P22VUXC43C6J3NLD}}", fin);
	}


	/**
	 * Test method for {@link ConversionService#getFIN(SwiftMessage)}.
	 */
	@Test
	public void testGetFINFromObj3_unparsedText() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("113:NOMT"));
		msg.getBlock3().append(new Tag("108", "P22VUXC43C6J3NLD"));
		
		msg.setUnparsedTexts(this.unparsedTexts);
		
		String fin = srv.getFIN(msg);
		assertEquals("{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{3:{113:NOMT}{108:P22VUXC43C6J3NLD}}" + this.someMsgText, fin);
	}

	/**
	 * Test method for {@link ConversionService#getFIN(SwiftMessage)}.
	 */
	@Test
	public void testGetFINFromObj4_unparsedText() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("113:NOMT"));
		msg.getBlock3().append(new Tag("108", "P22VUXC43C6J3NLD"));
		
		msg.getBlock3().setUnparsedTexts(this.unparsedTexts);
		
		String fin = srv.getFIN(msg);
		assertEquals("{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{3:{113:NOMT}{108:P22VUXC43C6J3NLD}" + this.someMsgText + "}", fin);
	}
	
	/**
	 * Test method for {@link ConversionService#getFIN(SwiftMessage)}.
	 */
	@Test
	public void testGetFINFromObj5_unparsedText() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("113:NOMT"));
		msg.getBlock3().append(new Tag("108", "P22VUXC43C6J3NLD"));
		
		msg.getBlock3().getTagByName("113").setUnparsedTexts(this.unparsedTexts);
		
		String fin = srv.getFIN(msg);
		assertEquals("{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{3:{113:NOMT" + this.someMsgText + "}{108:P22VUXC43C6J3NLD}}" , fin);
	}

	/**
	 * Test method for {@link ConversionService#getFIN(java.lang.String)}.
	 */
	@Test
	public void testGetFINThroughXML() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("108:P22VUXC43C6J3NLD"));
		
		String xml = SwiftWriter.getInternalXml(msg);
		assertNotNull(xml);
		String fin = srv.getFIN(xml);
		assertEquals("{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{3:{108:P22VUXC43C6J3NLD}}", fin);
	}

	/**
	 * Test method for {@link ConversionService#getFIN(java.lang.String)}.
	 */
	@Test
	public void testGetFINThroughXML_2() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("113:NOMT"));
		msg.getBlock3().append(new Tag("108:P22VUXC43C6J3NLD"));
		
		String xml = SwiftWriter.getInternalXml(msg);
		assertNotNull(xml);
		String fin = srv.getFIN(xml);
		assertEquals("{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{3:{113:NOMT}{108:P22VUXC43C6J3NLD}}", fin);
	}

	/**
	 * Test method for {@link ConversionService#getFIN(java.lang.String)}.
	 */
	@Test
	public void testGetFINThroughXML_3() {	
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlockUser("Z"));
		msg.getUserBlock("Z").append(new Tag("1:val1"));
		msg.getUserBlock("Z").append(new Tag("2:val2"));
		
		String xml = SwiftWriter.getInternalXml(msg);
		assertNotNull(xml);
		String fin = srv.getFIN(xml);
		assertEquals("{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{Z:{1:val1}{2:val2}}", fin);
	}
	
	/**
	 * Test method for {@link ConversionService#getMessageFromXML(java.lang.String)}.
	 */
	@Test
	public void testGetObjFromXML_block1() {
		String xml = "<message>"+Constants.B1_DATA_XML+"</message>";
		SwiftMessage msg = srv.getMessageFromXML(xml);
		assertNotNull(msg);
		assertNotNull(msg.getBlock1());
		assertNull(msg.getBlock2());
		assertNull(msg.getBlock3());
		assertNull(msg.getBlock4());
		assertNull(msg.getBlock5());
		assertEquals(Constants.B1_DATA, msg.getBlock1().getValue());
	}

	/**
	 * Test method for {@link ConversionService#getMessageFromXML(java.lang.String)}.
	 */
	@Test
	public void testGetObjFromXML_block2input() {
		String xml = "<message>"+Constants.B2_INPUT_XML+"</message>";
		SwiftMessage msg = srv.getMessageFromXML(xml);
		assertNotNull(msg);
		assertNull(msg.getBlock1());
		assertNotNull(msg.getBlock2());
		assertNull(msg.getBlock3());
		assertNull(msg.getBlock4());
		assertNull(msg.getBlock5());
		assertEquals(Constants.B2_INPUT, msg.getBlock2().getBlockValue());
	}

	/**
	 * Test method for {@link ConversionService#getMessageFromXML(java.lang.String)}.
	 */
	@Test
	public void testGetObjFromXML_block2output() {
		String xml = "<message>"+Constants.B2_OUTPUT_XML+"</message>";
		SwiftMessage msg = srv.getMessageFromXML(xml);
		assertNotNull(msg);
		assertNull(msg.getBlock1());
		assertNotNull(msg.getBlock2());
		assertNull(msg.getBlock3());
		assertNull(msg.getBlock4());
		assertNull(msg.getBlock5());
		assertEquals(Constants.B2_OUTPUT, msg.getBlock2().getBlockValue());
	}
	
	/**
	 * Test method for {@link ConversionService#getMessageFromXML(java.lang.String)}.
	 */
	@Test
	public void testGetObjFromXML_block3() {
		String xml = "<message><block3><tag><name>108</name><value>P22VUXC43C6J3NLD</value></tag></block3></message>";
		SwiftMessage msg = srv.getMessageFromXML(xml);
		assertNotNull(msg);
		assertNull(msg.getBlock1());
		assertNull(msg.getBlock2());
		assertNotNull(msg.getBlock3());
		assertNull(msg.getBlock4());
		assertNull(msg.getBlock5());
		assertNotNull(msg.getBlock3());
		assertNotNull(msg.getBlock3().getTagByName("108"));
		assertEquals("P22VUXC43C6J3NLD", msg.getBlock3().getTagByName("108").getValue());
	}

	/**
	 * Test method for {@link ConversionService#getMessageFromXML(java.lang.String)}.
	 */
	@Test
	public void testGetObjFromXML_block5() {
		String xml = "<message><block5><tag><name>MAC</name><value>52F48656</value></tag><tag><name>CHK</name><value>24C40F1FF931</value></tag></block5></message>";
		SwiftMessage msg = srv.getMessageFromXML(xml);
		assertNotNull(msg);
		assertNull(msg.getBlock1());
		assertNull(msg.getBlock2());
		assertNull(msg.getBlock3());
		assertNull(msg.getBlock4());
		assertNotNull(msg.getBlock5());
		assertFalse(msg.getBlock5().isEmpty());
		assertEquals("52F48656", msg.getBlock5().getTag(0).getValue());
		assertEquals("24C40F1FF931", msg.getBlock5().getTagByName("CHK").getValue());
	}
	
	/**
	 * Test method for {@link ConversionService#getMessageFromXML(java.lang.String)}.
	 */
	@Test
	public void testGetObjFromXML_blockUser() {
		String xml = "<message><block name=\"Z\"><tag><name>1</name><value>val1</value></tag><tag><name>2</name><value>val2</value></tag></block></message>";
		SwiftMessage msg = srv.getMessageFromXML(xml);
		assertNotNull(msg);
		assertNull(msg.getBlock1());
		assertNull(msg.getBlock2());
		assertNull(msg.getBlock3());
		assertNull(msg.getBlock4());
		assertNull(msg.getBlock5());
		assertNotNull(msg.getUserBlock("Z"));
		assertEquals("val1", msg.getUserBlock("Z").getTag(0).getValue());
		assertEquals("val2", msg.getUserBlock("Z").getTagByName("2").getValue());
	}
	
	/**
	 * Test method for {@link ConversionService#getXml(SwiftMessage)}.
	 */
	@Test
	public void testGetObjThroughXML() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("108:P22VUXC43C6J3NLD"));
		
		String xml = srv.getXml(msg);
		SwiftMessage m = srv.getMessageFromXML(xml);
		assertNotNull(m);
		assertNotNull(m.getBlock1());
		assertNotNull(m.getBlock2());
		assertNotNull(m.getBlock3());

		assertEquals("F01FOOBARYYAXXX8669486759", m.getBlock1().getBlockValue());
		assertEquals("O1030831051017CRESLULLCXXX10194697810510170831N", m.getBlock2().getBlockValue());
		assertEquals("P22VUXC43C6J3NLD", m.getBlock3().getTag(0).getValue());
		assertEquals("P22VUXC43C6J3NLD", m.getBlock3().getTagValue("108"));
	}

	/**
	 * Test method for {@link ConversionService#getXml(SwiftMessage)}.
	 */
	@Test
	public void testGetObjThroughXML_2() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlockUser("Z"));
		msg.getUserBlock("Z").append(new Tag("1:val1"));
		
		String xml = srv.getXml(msg);
		SwiftMessage m = srv.getMessageFromXML(xml);
		assertNotNull(m);
		assertNotNull(m.getBlock1());
		assertNotNull(m.getBlock2());
		assertNotNull(m.getUserBlock("Z"));

		assertEquals("F01FOOBARYYAXXX8669486759", m.getBlock1().getBlockValue());
		assertEquals("O1030831051017CRESLULLCXXX10194697810510170831N", m.getBlock2().getBlockValue());
		assertEquals("val1", m.getUserBlock("Z").getTag(0).getValue());
		assertEquals("val1", m.getUserBlock("Z").getTagValue("1"));
	}
	
	/**
	 * Test method for {@link ConversionService#getXml(SwiftMessage)}.
	 */
	@Test
	public void testGetObjThroughXML3_MsgUnparsedText() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("108:P22VUXC43C6J3NLD"));

		msg.setUnparsedTexts(this.unparsedTexts);

		String xml = srv.getXml(msg);	
		SwiftMessage m = srv.getMessageFromXML(xml);
		assertNotNull(m);
		assertNotNull(m.getBlock1());
		assertNotNull(m.getBlock2());
		assertNotNull(m.getBlock3());
		assertEquals("F01FOOBARYYAXXX8669486759", m.getBlock1().getBlockValue());
		assertEquals("O1030831051017CRESLULLCXXX10194697810510170831N", m.getBlock2().getBlockValue());
		assertEquals("P22VUXC43C6J3NLD", m.getBlock3().getTag(0).getValue());
		assertEquals("P22VUXC43C6J3NLD", m.getBlock3().getTagValue("108"));
		assertEquals(2, m.getUnparsedTextsSize().intValue());
		assertEquals(this.someMsgText, m.getUnparsedTexts().getText(0));
		assertEquals(this.someText, m.getUnparsedTexts().getText(1));
	}
	
	/**
	 * Test method for {@link ConversionService#getXml(SwiftMessage)}.
	 */
	@Test
	public void testGetObjThroughXML4_BlockUnparsedText() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("108:P22VUXC43C6J3NLD"));

		msg.getBlock1().setUnparsedTexts(this.unparsedTexts);
		msg.getBlock2().setUnparsedTexts(this.unparsedTexts);
		msg.getBlock3().setUnparsedTexts(this.unparsedTexts);
		
		String xml = srv.getXml(msg);
		assertNotNull(xml);
		SwiftMessage m = srv.getMessageFromXML(xml);
		assertNotNull(m);
		assertNotNull(m.getBlock1());
		assertNotNull(m.getBlock2());
		assertNotNull(m.getBlock3());

		assertEquals("F01FOOBARYYAXXX8669486759", m.getBlock1().getBlockValue());
		assertEquals("O1030831051017CRESLULLCXXX10194697810510170831N", m.getBlock2().getBlockValue());
		assertEquals("P22VUXC43C6J3NLD", m.getBlock3().getTag(0).getValue());
		assertEquals("P22VUXC43C6J3NLD", m.getBlock3().getTagValue("108"));
		
		assertEquals(2, m.getBlock1().getUnparsedTextsSize().intValue());
		assertEquals(this.someMsgText, m.getBlock1().getUnparsedTexts().getText(0));
		assertEquals(this.someText, m.getBlock1().getUnparsedTexts().getText(1));

		assertEquals(2, m.getBlock2().getUnparsedTextsSize().intValue());
		assertEquals(this.someMsgText, m.getBlock2().getUnparsedTexts().getText(0));
		assertEquals(this.someText, m.getBlock2().getUnparsedTexts().getText(1));

		assertEquals(2, m.getBlock3().getUnparsedTextsSize().intValue());
		assertEquals(this.someMsgText, m.getBlock3().getUnparsedTexts().getText(0));
		assertEquals(this.someText, m.getBlock3().getUnparsedTexts().getText(1));
	}

	/**
	 * Test method for {@link ConversionService#getXml(SwiftMessage)}.
	 */
	@Test
	public void testGetObjThroughXML5_TagUnparsedText() {
		msg.clear();
		msg.addBlock(new SwiftBlock1("F01FOOBARYYAXXX8669486759"));
		msg.addBlock(new SwiftBlock2Output("O1030831051017CRESLULLCXXX10194697810510170831N"));
		msg.addBlock(new SwiftBlock3());
		msg.getBlock3().append(new Tag("108:P22VUXC43C6J3NLD"));

		msg.getBlock3().getTagByName("108").setUnparsedTexts(this.unparsedTexts);
		
		String xml = srv.getXml(msg);	
		SwiftMessage m = srv.getMessageFromXML(xml);
		assertNotNull(m);
		assertNotNull(m.getBlock1());
		assertNotNull(m.getBlock2());
		assertNotNull(m.getBlock3());

		assertEquals("F01FOOBARYYAXXX8669486759", m.getBlock1().getBlockValue());
		assertEquals("O1030831051017CRESLULLCXXX10194697810510170831N", m.getBlock2().getBlockValue());
		assertEquals("P22VUXC43C6J3NLD", m.getBlock3().getTag(0).getValue());
		assertEquals("P22VUXC43C6J3NLD", m.getBlock3().getTagValue("108"));
		
		assertEquals(2, m.getBlock3().getTagByName("108").getUnparsedTextsSize().intValue());
		assertEquals(this.someMsgText, m.getBlock3().getTagByName("108").getUnparsedTexts().getText(0));
		assertEquals(this.someText, m.getBlock3().getTagByName("108").getUnparsedTexts().getText(1));
	}

	/**
	 * Test method for {@link ConversionService#getMessageFromFIN(java.lang.String)}.
	 */
	@Test
	public void testGetObjFromFIN_block4() {
		String xml = srv.getXml(fin);
		SwiftMessage m = srv.getMessageFromXML(xml);
		assertNotNull(m);
		assertNotNull(m.getBlock1());
		assertNotNull(m.getBlock2());
		assertNotNull(m.getBlock3());
		assertNotNull(m.getBlock4());
		assertNotNull(m.getBlock5());
		
		assertEquals("F01FOOBARYYAXXX8669486759", m.getBlock1().getBlockValue());
		SwiftBlock4 b = m.getBlock4();
		assertEquals(10, b.countAll());
		assertEquals("AMLX985338-D4E5E", b.getTagValue("20"));
		assertEquals("CRED", b.getTagValue("23B"));
		assertEquals("051018EUR66969,52", b.getTagValue("32A"));
		assertEquals("OUR", b.getTagValue("71A"));
	}
	
	@Test
	public void testBug1539324() {
		String fin = "{1:F01FOOBARYYAXXX8669486759}{3:{108:P22VUXC43C6J3NLD}}";
		String xml = srv.getXml(fin);
		String expected = "<message>\n" +
				"\n<block1>" +
				"\n\t<applicationId>F</applicationId>" +
				"\n\t<serviceId>01</serviceId>" +
				"\n\t<logicalTerminal>FOOBARYYAXXX</logicalTerminal>" +
				"\n\t<sessionNumber>8669</sessionNumber>" +
				"\n\t<sequenceNumber>486759</sequenceNumber>" +
				"\n</block1>" + 
				"\n<block3>" +
				"\n\t<tag>" +
				"\n\t\t<name>108</name>" +
				"\n\t\t<value>P22VUXC43C6J3NLD</value>" +
				"\n\t</tag>" +
				"\n</block3>" + 
				"\n</message>";
		assertXmlEqual(expected, xml);
	}

	@Test
	public void testBug1539324_2() {
		String fin = "{1:"+Constants.B1_DATA+"}{3:"+Constants.B3_DATA+"}";
		msg = srv.getMessageFromFIN(fin);
		assertNull(msg.getBlock2());
		assertNull(msg.getBlock4());
		assertNull(msg.getBlock5());
		assertEquals(Constants.B1_DATA, msg.getBlock1().getValue());
		assertEquals(2, msg.getBlock3().countAll());
		assertEquals("v", msg.getBlock3().getTagByName("n").getValue());
		assertEquals("v2", msg.getBlock3().getTagByName("n2").getValue());
	}
	
	/**
	 * Test method for {@link ConversionService#getMessageFromFIN(java.lang.String)}.
	 */
	@Test
	public void testGetObjFromFIN() {
		ConversionService srv;
		String fin = "{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{3:{108:P22VUXC43C6J3NLD}}{4:\n" +
				":20:AMLX985338-D4E5E\n" + 
				":23B:CRED\n" + 
				":32A:051018EUR66969,52\n" + 
				":33B:EUR66969,52\n" + 
				":50K:Tressis SA\n" + 
				":53A:DEUTDEFF\n" + 
				":54A://RT\n" + 
				"FOOBARYY\n" +
				":59:/-\n" + 
				"Tressis SA\n" + 
				":70:/CS BD ST EUR B\n" + 
				"REDEMPTION AMLX985338\n" + 
				":71A:OUR\n" + 
				"-}{5:{MAC:52F48656}{CHK:24C40F1FF931}}";


		srv = new ConversionService();
		msg = new SwiftMessage();
		
		SwiftMessage m = srv.getMessageFromFIN(fin);
		
		assertNotNull(m.getBlock1());
		assertNotNull(m.getBlock2());
		assertNotNull(m.getBlock3());
		assertNotNull(m.getBlock4());
		assertNotNull(m.getBlock5());
		
		assertEquals("F01FOOBARYYAXXX8669486759", m.getBlock1().getBlockValue());
		assertEquals(2, m.getBlock5().countAll());
		
		assertEquals("MAC", m.getBlock5().getTag(0).getName());
		assertEquals("52F48656", m.getBlock5().getTag(0).getValue());

		assertEquals("CHK", m.getBlock5().getTag(1).getName());
		assertEquals("24C40F1FF931", m.getBlock5().getTag(1).getValue());
		
		assertEquals(1, m.getBlock3().countAll());
		assertEquals("108", m.getBlock3().getTag(0).getName());
		assertEquals("P22VUXC43C6J3NLD", m.getBlock3().getTag(0).getValue());	
	}
	
	@Test
	public void testReadEmptyBlock1() {
		SwiftMessage m = srv.getMessageFromXML("<message><block1/></message>");
		assertNotNull(m);
		assertNotNull(m.getBlock1());
		assertNull(m.getBlock2());
		assertNull(m.getBlock3());
		assertNull(m.getBlock4());
		assertNull(m.getBlock5());
	}
	
	@Test
	public void testReadEmptyBlock2() {
		SwiftMessage m = srv.getMessageFromXML("<message><block2 type=\"input\"/></message>");
		assertNotNull(m);
		assertNull(m.getBlock1());
		assertNotNull(m.getBlock2());
		assertNull(m.getBlock3());
		assertNull(m.getBlock4());
		assertNull(m.getBlock5());
	}
	
	@Test
	public void testGetObjFromIncompleteXML() {
		String xml = "<message><block1><serviceId>01</serviceId></block1></message>";
		SwiftMessage m = srv.getMessageFromXML(xml);
		assertNotNull(m);
		assertNotNull(m.getBlock1());
		//assertNull(m.getBlock1().getApplicationId());
		assertEquals("01", m.getBlock1().getServiceId());
		assertNull(m.getBlock1().getLogicalTerminal());
		//assertNull(m.getBlock1().getSessionNumber());
		//assertNull(m.getBlock1().getSequenceNumber());
		assertNull(m.getBlock2());
		assertNull(m.getBlock3());
		assertNull(m.getBlock4());
		assertNull(m.getBlock5());
	}
	
	/**
	 * Test method for {@link ConversionService#getMessageFromXML(java.lang.String)}.
	 */
	@Test
	public void testCRLF_0() {
		String xml = "<message><block4><tag><name>58</name><value>line1</value></tag></block4></message>";
		SwiftMessage msg = srv.getMessageFromXML(xml);
		assertEquals("line1", msg.getBlock4().getTagByName("58").getValue());
	}
	
	/**
	 * Test method for {@link ConversionService#getMessageFromXML(java.lang.String)}.
	 */
	@Test
	public void testCRLF_1() {
		String xml = "<message><block4><tag><name>58</name><value>line1\nline2</value></tag></block4></message>";
		SwiftMessage msg = srv.getMessageFromXML(xml);
		assertEquals("line1\r\nline2", msg.getBlock4().getTagByName("58").getValue());
	}
	
	/**
	 * Test method for {@link ConversionService#getMessageFromXML(java.lang.String)}.
	 */
	@Test
	public void testCRLF_2() {
		String xml = "<message><block4><tag><name>58</name><value>line1\r\nline2</value></tag></block4></message>";
		SwiftMessage msg = srv.getMessageFromXML(xml);
		assertEquals("line1\r\nline2", msg.getBlock4().getTagByName("58").getValue());
	}
	
	/**
	 * Test method for {@link ConversionService#getMessageFromXML(java.lang.String)}.
	 */
	@Test
	public void testCRLF_3() {
		String xml = "<message><block4><tag><name>58</name><value>line1\r\nline2\r\nline3</value></tag></block4></message>";
		SwiftMessage msg = srv.getMessageFromXML(xml);
		assertEquals("line1\r\nline2\r\nline3", msg.getBlock4().getTagByName("58").getValue());
	}

	@Test
	public void testBackAndForthXMLConversion1() {
		final String fin = "{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{4:" + FINWriterVisitor.SWIFT_EOL +
				":57A:/123456789" + FINWriterVisitor.SWIFT_EOL +
				"FOOBARYY" + FINWriterVisitor.SWIFT_EOL +
				"-}";
		//no fields
		String xml = srv.getXml(fin);
		String fin2 = srv.getFIN(xml);
		assertEquals(fin, fin2);

		//with fields
		ConversionService srv2 = new ConversionService();
		xml = srv2.getXml(fin, true);
		fin2 = srv2.getFIN(xml);
		assertEquals(fin, fin2);
	}
	
	@Test
	public void testBackAndForthXMLConversion2() {
		final String fin = "{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{4:" + FINWriterVisitor.SWIFT_EOL +
				":57A:/D/123456789" + FINWriterVisitor.SWIFT_EOL +
				"FOOBARYY" + FINWriterVisitor.SWIFT_EOL +
				"-}";
		//no fields
		String xml = srv.getXml(fin);
		String fin2 = srv.getFIN(xml);
		assertEquals(fin, fin2);

		//with fields
		ConversionService srv2 = new ConversionService();
		xml = srv2.getXml(fin, true);
		fin2 = srv2.getFIN(xml);
		assertEquals(fin, fin2);
	}

	/**
	 * Test if leading and trailing spaces are preserved in the conversion
	 */
	@Test
	public void testBackAndForthXMLConversion3() {
		final String fin = "{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{4:" + FINWriterVisitor.SWIFT_EOL +
				":57A:/123456789" + FINWriterVisitor.SWIFT_EOL +
				" FOOBARYY" + FINWriterVisitor.SWIFT_EOL +
				":61:190907D5675,S103AZMES11071950766" + FINWriterVisitor.SWIFT_EOL +
				"  FOOEDEMMAXXXKREDBEBBXXXXN071404 " + FINWriterVisitor.SWIFT_EOL +
				"-}";
		ConversionService srv2 = new ConversionService();

		//no fields
		String xml = srv.getXml(fin);
		String fin2 = srv.getFIN(xml);
		assertEquals(fin, fin2);

		//with fields
		xml = srv2.getXml(fin, true);
		fin2 = srv2.getFIN(xml);
		assertEquals(fin, fin2);
	}

}

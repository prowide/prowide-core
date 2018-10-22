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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.prowidesoftware.swift.model.SwiftMessage;

/**
 * System messages tests
 *
 * @since 4.0
 */
public class SystemMessageTest extends BaseMessageTestcase {

	/**
	 * Message posted https://sourceforge.net/forum/message.php?msg_id=4243373
	 */
	@Test 
	public void testPostedFengw2_01() {
		String msg = "{1:F21FOOBARXXAXXX1234567890}{4:{177:0703281337}{451:1}{405:E66013}}{1:F01FOOBARXXAXXX3219604112}{2:I535FOOBARXXXXXXN}{4:\n" +
					":16R:GENL\n" +
					":28E:1/ONLY\n" +
					":13A::STAT//086\n" +
					":20C::SEME//ABC20070327P1\n" +
					":23G:NEWM\n" +
					":98A::STAT//20070327\n" +
					":98C::PREP//20070328043657\n" +
					":22F::SFRE//DAIL\n" +
					":22F::CODE//COMP\n" +
					":22F::STTY//CUST\n" +
					":22F::STBA//TRAD\n" +
					":97A::SAFE//ABC\n" +
					":17B::ACTI//Y\n" +
					":17B::CONS//Y\n" +
					":16S:GENL\n" +
					":16R:ADDINFO\n" +
					":19A::HOLP//USD0,\n" +
					":19A::HOLS//USD0,\n" +
					":16S:ADDINFO\n" +
					"-}{5:{MAC:8A1FADA1}{CHK:B018C2CA74CD}}{S:{REF:I20070328.386482886.out/1/1}}";
		parseMessage(msg);
		
		assertNotNull(b1);
		assertEquals("F", b1.getApplicationId());
		assertEquals("21", b1.getServiceId());
		assertEquals("FOOBARXXAXXX", b1.getLogicalTerminal());
		assertEquals("1234", b1.getSessionNumber());
		assertEquals("567890", b1.getSequenceNumber());
		
		assertNull(b2);
		assertNull(b3);
		
		assertNotNull(b4);
		assertEquals("0703281337", b4.getTagValue("177"));
		assertEquals("1", b4.getTagValue("451"));
		assertEquals("E66013", b4.getTagValue("405"));
		
		//the MT 535 attached to this ACK system message is put into the unparsed text by the parser
		assertNotNull(o.getUnparsedTexts());
		assertEquals(1, o.getUnparsedTextsSize().intValue());
		
		SwiftMessage mt535 = o.getUnparsedTexts().getTextAsMessage(0);
		assertEquals("535", mt535.getType());
	
		//the block5 is part of the inner mt 535
		assertNull(b5);
	}
	
	/**
	 * Message posted https://sourceforge.net/forum/message.php?msg_id=4243962
	 */
	@Test 
	public void testPostedFengw2_02() {
		String msg = "{1:F21FOOBARXXAXXX1234567890}{4:{177:0704032320}{451:0}}{1:F01FOOBARXXAXXX3227607589}{2:I950FOOBARXXXXXXN}{4:\n" +
					":20:12345678070403\n" +
					":25:12345678\n" +
					":28C:93/1\n" +
					":60F:C070403USD0,\n" +
					":61:0704050402C115454,92NSALNONREF\n" +
					"/US/037833100/SHS/1235,\n" +
					":62M:C070403USD115454,92\n" +
					"-}{5:{CHK:12C48A7C53B2}}{S:{REF:I20070404.763727356.out/1/1}}";
		parseMessage(msg);
		
		assertNotNull(b1);
		assertEquals("F", b1.getApplicationId());
		assertEquals("21", b1.getServiceId());
		assertEquals("FOOBARXXAXXX", b1.getLogicalTerminal());
		assertEquals("1234", b1.getSessionNumber());
		assertEquals("567890", b1.getSequenceNumber());
		
		assertNull(b2);
		assertNull(b3);
		
		assertNotNull(b4);
		assertEquals("0704032320", b4.getTagValue("177"));
		assertEquals("0", b4.getTagValue("451"));
		
		//the MT 950 attached to this ACK system message is put into the unparsed text by the parser
		assertNotNull(o.getUnparsedTexts());
		assertEquals(1, o.getUnparsedTextsSize().intValue());
		
		SwiftMessage mt950 = o.getUnparsedTexts().getTextAsMessage(0);
		assertEquals("950", mt950.getType());
	
		//the block5 is part of the inner mt 535
		assertNull(b5);
	}
		
	/**
	 * Message posted https://sourceforge.net/forum/message.php?msg_id=4248618
	 *
	 */
	@Test 
	public void testPostedDonreda_01() {
		String msg = "{1:F21MTGSUS6SAXXX3206837054}{4:{177:0703161035}{451:0}}{1:F01MTGSUS6SAXXX3206837054}{2:O5641435070316CHASGB2LDGST07128160300703160735N}{3:{108:000255CQ8272245}}{4:\n" +
			":16R:GENL\n" +
			":20C::CORP//D455103\n" +
			":20C::SEME//029206016\n" +
			":23G:NEWM\n" +
			":22F::CAEV//DVCA\n" +
			":22F::CAMV//MAND\n" +
			":98C::PREP//20070316143348\n" +
			":25D::PROC//COMP\n" +
			":16S:GENL\n" +
			":16R:USECU\n" +
			":35B:ISIN CH0011075394\n" +
			"/XX/5983816\n" +
			"ZURICH FIN SVS GRP\n" +
			"CHF0.10\n" +
			":16R:ACCTINFO\n" +
			":97A::SAFE//760043140\n" +
			":94F::SAFE//CUST/UBSWCHZH80A\n" +
			":93B::ELIG//UNIT/7000,\n" +
			":16S:ACCTINFO\n" +
			":16S:USECU\n" +
			":16R:CADETL\n" +
			":98A::XDTE//20111111\n" +
			":98A::PAYD//20111111\n" +
			":98A::RDTE//20111111\n" +
			":92A::WITF//35,\n" +
			":92A::GRSS//0,000001000\n" +
			":16S:CADETL\n" +
			":16R:CAOPTN\n" +
			":13A::CAON//001\n" +
			":22F::CAOP//CASH\n" +
			":11A::OPTN//CHF\n" +
			":17B::DFLT//Y\n" +
			":98A::XDTE//20111111\n" +
			":98A::PAYD//20111111\n" +
			":98A::RDTE//20111111\n" +
			":92A::GRSS//0,000001000\n" +
			":16R:CASHMOVE\n" +
			":22H::CRDB//CRED\n" +
			":19B::ENTL//CHF0,01\n" +
			":19B::GRSS//CHF0,01\n" +
			":19B::NETT//CHF0,01\n" +
			":98A::PAYD//20111111\n" +
			":98A::VALU//20111111\n" +
			":16S:CASHMOVE\n" +
			":16S:CAOPTN\n" +
			"-}";
		parseMessage(msg);

		assertNotNull(b1);
		assertEquals("F21MTGSUS6SAXXX3206837054", b1.getBlockValue());
		assertEquals("F", b1.getApplicationId());
		assertEquals("21", b1.getServiceId());
		assertEquals("MTGSUS6SAXXX", b1.getLogicalTerminal());
		assertEquals("3206", b1.getSessionNumber());
		assertEquals("837054", b1.getSequenceNumber());
		
		assertNull(b2);
		assertNull(b3);
		
		assertNotNull(b4);
		assertEquals("0703161035", b4.getTagValue("177"));
		assertEquals("0", b4.getTagValue("451"));
		
		//the MT 564 attached to this ACK system message is put into the unparsed text by the parser
		assertNotNull(o.getUnparsedTexts());
		assertEquals(1, o.getUnparsedTextsSize().intValue());
		
		SwiftMessage mt564 = o.getUnparsedTexts().getTextAsMessage(0);
		assertEquals("564", mt564.getType());
	
		//the block5 is part of the inner mt 535
		assertNull(b5);
	}
	
	@Test 
	public void test1() {
		String msg = "{1:L02BANKBEBBAXXX0000001111}\n" +
					"{4:\n" +
					"{501:21101000000500002110100000050000ABCDABCD00000000000000000000000000000000}\n" +
					"{110:001}\n" +
					"{329:N}}";
		parseMessage(msg);
		assertNotNull(b4);
		assertEquals("21101000000500002110100000050000ABCDABCD00000000000000000000000000000000", b4.getTagValue("501"));
		assertEquals("001", b4.getTagValue("110"));
		assertEquals("N", b4.getTagValue("329"));
	}

	@Test 
	public void test2() {
		String msg = "{1:A21FOOZBET2AXXX0018000015}\n" +
					"{4:{177:9703051524}\n" +
					"{451:1}\n" +
					"{405:H80}}";
		parseMessage(msg);
		assertNotNull(b4);
		assertEquals("9703051524", b4.getTagValue("177"));
		assertEquals("1", b4.getTagValue("451"));
		assertEquals("H80", b4.getTagValue("405"));
	}

	@Test 
	public void test3() {
		String msg = "{1:F21FOOZBET2AXXX0027000595}{4:{177:9703151159}{451:1}{405:Y01}}";
		parseMessage(msg);
		assertNotNull(b4);
		assertEquals("9703151159", b4.getTagValue("177"));
		assertEquals("1", b4.getTagValue("451"));
		assertEquals("Y01", b4.getTagValue("405"));
	}

}

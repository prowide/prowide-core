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
import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.field.Field111;
import com.prowidesoftware.swift.model.field.Field119;
import com.prowidesoftware.swift.model.field.Field121;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.model.mt.MTVariant;
import com.prowidesoftware.swift.model.mt.MtCategory;
import com.prowidesoftware.swift.model.mt.mt1xx.MT102;
import com.prowidesoftware.swift.model.mt.mt5xx.MT540;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * General swift message tests.
 *
 * @since 4.0
 */
public class SwiftMessageTest {

	/**
	 * Ensure the message with data can be serialized
	 * 
	 * @throws IOException
	 */
	@Test 
	public void testSerialization() throws IOException {
		final SwiftMessage m = new SwiftMessage(true);
		m.getBlock1().setValue(Constants.B1_DATA);
		m.getBlock2().setValue(Constants.B2_INPUT);
		m.getBlock3().append(new Tag("120:asdadad"));
		m.getBlock4().append(new Tag("120:asdadad"));
		m.getBlock5().append(new Tag("120:asdadad"));
		final SwiftBlockUser bu = new SwiftBlockUser("S");
		bu.append(new Tag("120:asdadad"));
		m.addUserBlock(bu);

		final ByteArrayOutputStream b = new ByteArrayOutputStream();
		final ObjectOutputStream oos = new ObjectOutputStream(b);
		oos.writeObject(m);
	}

	@Test 
	public void testClear() throws IOException {
		final SwiftMessage m = new SwiftMessage();
		m.clear();
		assertEquals(0, m.getBlockCount());
		assertNull(m.getBlock1());
		assertNull(m.getBlock2());
		assertNull(m.getBlock3());
		assertNull(m.getBlock4());
		assertNull(m.getBlock5());
		assertNull(m.getUserBlocks());
	}

	@Test 
	public void testNotInitializedConstructor() throws IOException {
		final SwiftMessage m = new SwiftMessage(false);
		assertEquals(0, m.getBlockCount());
		assertNull(m.getBlock1());
		assertNull(m.getBlock2());
		assertNull(m.getBlock3());
		assertNull(m.getBlock4());
		assertNull(m.getBlock5());
		assertNull(m.getUserBlocks());
	}

	@Test 
	public void testDefaultConstructor() {
		final SwiftMessage m = new SwiftMessage(true);

		assertNotNull(m.getBlock1());
		assertTrue(m.getBlock1() instanceof SwiftBlock1);

		assertNotNull(m.getBlock2());
		assertTrue(m.getBlock2() instanceof SwiftBlock2);

		assertNotNull(m.getBlock3());
		assertTrue(m.getBlock3() instanceof SwiftBlock3);

		assertNotNull(m.getBlock4());
		assertTrue(m.getBlock4() instanceof SwiftBlock4);

		assertNotNull(m.getBlock5());
		assertTrue(m.getBlock5() instanceof SwiftBlock5);

		assertNotNull(m.getUserBlocks());
		assertTrue(m.getUserBlocks() instanceof List);

		//expected 2 because empty blocks are not counted and block 1 and 2 have default attribute values
		assertEquals(2, m.getBlockCount());
	}

	@Test 
	public void testGetBlockCount() {
		final SwiftMessage m = new SwiftMessage();

		m.addBlock(new SwiftBlock1());

		m.getBlock1().setApplicationId("F");
		assertEquals(1, m.getBlockCount());

		m.addBlock(new SwiftBlock3());
		m.getBlock3().append(new Tag("n", "v"));
		assertEquals(2, m.getBlockCount());

		m.clear();
		assertEquals(0, m.getBlockCount());
	}

	@Test 
	public void testGetBlockCountBoolean() {
		final SwiftMessage m = new SwiftMessage(false);

		final SwiftBlockUser ub = new SwiftBlockUser();
		m.addBlock(ub);

		m.addBlock(new SwiftBlock1());
		assertEquals(1, m.getBlockCount(false));
		assertEquals(2, m.getBlockCount());

		m.getBlock1().setApplicationId("F");
		assertEquals(2, m.getBlockCount());

		m.getBlock1().setApplicationId("F");
		assertEquals(1, m.getBlockCount(false));

		m.clear();
		assertEquals(0, m.getBlockCount());
	}

	/**
	 * Message posted https://sourceforge.net/forum/message.php?msg_id=4430916
	 */
	@Test 
	public void testPostedTimclarke_01() {
		SwiftParser parser;
		SwiftMessage msg;

		final String messageOutput = "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}{119:STP}}{4:\n" + ":20:D051026EUR100057\n" + ":13C:/RNCTIME/0802+0000\n" + ":23B:CRED\n" + ":32A:051028EUR6740,91\n" + ":33B:EUR6740,91\n" + ":50A:SSSSESMMXXX\n" + ":53A:BBBBESMMXXX\n" + ":57A:FOOBARYYXXX\n" + ":59:/ES0123456789012345671234\n" + "FOOOOO 1000 FOOBAR S.A.\n" + ":70:REDEMPTS. TRADEDATE 2222-10-26\n" + "/123123123: FOOVIMAR 2000 FOOBAR\n" + ":71A:SHA\n" + "-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";

		final String messageInput = "{1:F01FOOBARXXAXXX3219604112}{2:I535FOOBARXXXXXXN}{4:\n" + ":16R:GENL\n" + ":28E:1/ONLY\n" + ":13A::STAT//086\n" + ":20C::SEME//ABC20070327P1\n" + ":23G:NEWM\n" + ":98A::STAT//20070327\n" + ":98C::PREP//20070328043657\n" + ":22F::SFRE//DAIL\n" + ":22F::CODE//COMP\n" + ":22F::STTY//CUST\n" + ":22F::STBA//TRAD\n" + ":97A::SAFE//ABC\n" + ":17B::ACTI//Y\n" + ":17B::CONS//Y\n" + ":16S:GENL\n" + ":16R:ADDINFO\n" + ":19A::HOLP//USD0,\n" + ":19A::HOLS//USD0,\n" + ":16S:ADDINFO\n" + "-}{5:{MAC:8A1FADA1}{CHK:B018C2CA74CD}}{S:{REF:I20070328.386482886.out/1/1}}";

		try {
 		parser = new SwiftParser(messageOutput); 
		msg = parser.message(); 
		assertTrue(msg.getBlock2() instanceof SwiftBlock2Output);
		
		assertFalse(msg.getBlock2().isInput());
		SwiftBlock2Output b2o = (SwiftBlock2Output)msg.getBlock2();
		assertEquals(b2o.getMessageType(), "103");
		
		parser = new SwiftParser(messageInput); 
		msg = parser.message(); 
		assertTrue(msg.getBlock2() instanceof SwiftBlock2Input);
		
		//msSender = msg.getBlock2().getSender(); 
		//msPriority = msg.getBlock2().getMessagePriority();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * cover payment messages
	 */
	@Test 
	public void testCOVMessage() {
		SwiftParser parser;
		final String msg1s = "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}{119:COV}}{4:\n" + ":20:D051026EUR100057\n" + ":13C:/RNCTIME/0802+0000\n" + ":23B:CRED\n" + ":32A:051028EUR6740,91\n" + ":33B:EUR6740,91\n" + ":50A:SSSSESMMXXX\n" + ":53A:BBBBESMMXXX\n" + ":57A:FOOBARYYXXX\n" + ":59:/ES0123456789012345671234\n" + "FOOOOO 1000 FOOBAR S.A.\n" + ":70:REDEMPTS. TRADEDATE 2222-10-26\n" + "/123123123: FOOVIMAR 2000 FOOBAR\n" + ":71A:SHA\n" + "-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";
		final String msg2s = "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}}{4:\n" + ":20:D051026EUR100057\n" + ":13C:/RNCTIME/0802+0000\n" + ":23B:CRED\n" + ":32A:051028EUR6740,91\n" + ":33B:EUR6740,91\n" + ":50A:SSSSESMMXXX\n" + ":53A:BBBBESMMXXX\n" + ":57A:FOOBARYYXXX\n" + ":59:/ES0123456789012345671234\n" + "FOOOOO 1000 FOOBAR S.A.\n" + ":70:REDEMPTS. TRADEDATE 2222-10-26\n" + "/123123123: FOOVIMAR 2000 FOOBAR\n" + ":71A:SHA\n" + "-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";
		try {
	 		parser = new SwiftParser(msg1s); 
	 		SwiftMessage msg1 = parser.message(); 
			assertTrue(msg1.isCOV());
			
	 		parser = new SwiftParser(msg2s); 
	 		SwiftMessage msg2 = parser.message(); 
			assertFalse(msg2.isCOV());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * STP
	 */
	@Test 
	public void testSTPMessage() {
		SwiftParser parser;
		final String msg1s = "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}{119:STP}}{4:\n" + ":20:D051026EUR100057\n" + ":13C:/RNCTIME/0802+0000\n" + ":23B:CRED\n" + ":32A:051028EUR6740,91\n" + ":33B:EUR6740,91\n" + ":50A:SSSSESMMXXX\n" + ":53A:BBBBESMMXXX\n" + ":57A:FOOBARYYXXX\n" + ":59:/ES0123456789012345671234\n" + "FOOOOO 1000 FOOBAR S.A.\n" + ":70:REDEMPTS. TRADEDATE 2222-10-26\n" + "/123123123: FOOVIMAR 2000 FOOBAR\n" + ":71A:SHA\n" + "-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";
		final String msg2s = "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}}{4:\n" + ":20:D051026EUR100057\n" + ":13C:/RNCTIME/0802+0000\n" + ":23B:CRED\n" + ":32A:051028EUR6740,91\n" + ":33B:EUR6740,91\n" + ":50A:SSSSESMMXXX\n" + ":53A:BBBBESMMXXX\n" + ":57A:FOOBARYYXXX\n" + ":59:/ES0123456789012345671234\n" + "FOOOOO 1000 FOOBAR S.A.\n" + ":70:REDEMPTS. TRADEDATE 2222-10-26\n" + "/123123123: FOOVIMAR 2000 FOOBAR\n" + ":71A:SHA\n" + "-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";
		try {
	 		parser = new SwiftParser(msg1s); 
	 		SwiftMessage msg1 = parser.message(); 
			assertTrue(msg1.isSTP());
			
	 		parser = new SwiftParser(msg2s); 
	 		SwiftMessage msg2 = parser.message(); 
			assertFalse(msg2.isSTP());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testToMt() throws Exception {
		 final SwiftMessage m = new SwiftMessage(true);
	        final SwiftBlock2Input b2 = new SwiftBlock2Input();
	        b2.setMessageType("102");
	        b2.setInput(true);
	        b2.setMessagePriority("N");
	        b2.setDeliveryMonitoring("2");
	        b2.setObsolescencePeriod("020");
	        b2.setReceiverAddress("12345612XXXX");
	        m.setBlock2(b2);
	        
		AbstractMT o = m.toMT();
		assertTrue("MT not an instance of 102", o instanceof MT102);
	}
	
	@Test
	public void testToMt_540() throws Exception {
		 final SwiftMessage m = new SwiftMessage(true);
	        final SwiftBlock2Input b2 = new SwiftBlock2Input();
	        b2.setMessageType("540");
	        b2.setInput(true);
	        b2.setMessagePriority("N");
	        b2.setDeliveryMonitoring("2");
	        b2.setObsolescencePeriod("020");
	        b2.setReceiverAddress("12345612XXXX");
	        m.setBlock2(b2);
		AbstractMT o = m.toMT();
		assertTrue("MT not an instance of 540", o instanceof MT540);
	}
	
	@Test
	public void PDE() {
		SwiftMessage m = new SwiftMessage();
		m.setBlock5(new SwiftBlock5());
		m.getBlock5().append(new Tag("PDE", ""));
		String fin = (new ConversionService()).getFIN(m);
		assertEquals("{5:{PDE:}}", fin);
	}
	
	@Test
	public void isAck() throws IOException {
		String msg = "{1:F21LITEBEBBAXXX0066000079}{4:{177:1104180901}{451:0}}{1:F01LITEBEBBAXXX0066000079}{2:I999LITEBEBBXXXXN}{4:\n"+
					":20:TESTREF1\n"+
					":79:This is text line 1\n"+
					"-}{5:{CHK:7602B010CF31}{TNG:}}";
		SwiftMessage m = SwiftMessage.parse(msg);
		assertTrue(m.isAck());
		assertFalse(m.isNack());
	}

	@Test
	public void getMtId() throws IOException {
		String msg = "{1:F01BICAUS11AXXX0000000000}{2:I202N}{4:\n" +
			":20:asdfasdf\n" +
			"-}";
		SwiftParser p = new SwiftParser(msg);
		SwiftMessage m = p.message();
		assertNotNull(m.getMtId());
		assertEquals("fin.202", m.getMtId().id());
	}

	@Test
	public void isServiceMessage21() throws IOException {
		SwiftMessage m = SwiftMessage.parse("{1:F01BNPAFRPPZXXX0000000006}{2:O0111702040914DYLRXXXXCXXX00000000001702040914S}{4:{175:0914}{106:170204BNPAFRPPZXXX0000000007}{108:MyRef9}{175:0914}{107:170204MGTCBEBBXXXX0000000007}}{5:{CHK:ABCDEF123456}{SYS:}}");
		assertFalse(m.isServiceMessage());
		assertFalse(m.isAck());
		assertFalse(m.isNack());
		/*
		 * this one returns false because the method actually checks for service i2 21 (ACK/NACK)
		 */
		assertFalse(m.isServiceMessage21());
	}
	
	@Test
	public void isServiceMessage() throws IOException {
		SwiftMessage m = SwiftMessage.parse("{1:F21BNPAFRPPZXXX0000000007}{4:{177:1702040914}{451:0}}{1:F01BNPAFRPPZXXX0000000007}{2:I103MGTCBEBBXXXXN}{3:{108:MyRef9}}{4:\n-}{5:{MAC:ABCD1234}{CHK:ABCDEF123456}}");
		assertTrue(m.isServiceMessage());
		assertTrue(m.isAck());
		assertFalse(m.isNack());
		/*
		 * this one returns true because the method actually checks for service i2 21 (ACK/NACK)
		 */
		assertTrue(m.isServiceMessage21());
	}
	
	@Test
	public void testGetSenderReceiver() throws IOException {
		/*
		 * incomming
		 */
		SwiftMessage m = SwiftMessage.parse("{1:F01FOOBARXXAXXX0387241036}{2:O9502352060913FOOBUS22XXXX18884819330609140052N}{4:\n:20:123456\n-}");
		assertEquals("FOOBUS22XXXX", m.getSender());
		assertEquals("FOOBARXXAXXX", m.getReceiver());
		/*
		 * outgoing
		 */
		m = SwiftMessage.parse("{1:F01FOOBARAAAXXX3219604112}{2:I535FOOBUS22XXXXN}{4:\n:16R:GENL\n-}");
		assertEquals("FOOBARAAAXXX", m.getSender());
		assertEquals("FOOBUS22XXXX", m.getReceiver());
		/*
		 * ack
		 */
		m = SwiftMessage.parse("{1:F21BNPAFRPPZXXX0000000007}{4:{177:1702040914}{451:0}}");
		assertEquals("BNPAFRPPZXXX", m.getSender());
		assertNull(m.getReceiver());
	}
	
	@Test
	public void testGetCategory() throws IOException {
		SwiftMessage m = SwiftMessage.parse("{1:F01FOOBARXXAXXX0387241036}{2:O9502352060913YYYYUSYYYYYY18884819330609140052N}{4:\n:20:123456\n-}");
		assertEquals(MtCategory._9, m.getCategory());
		assertTrue(m.isCategory(MtCategory._9));
		assertTrue(m.isCategory(MtCategory._0, MtCategory._1, MtCategory._3, MtCategory._9));
		assertFalse(m.isCategory(MtCategory._8));
		m = SwiftMessage.parse("{1:F21BNPAFRPPZXXX0000000007}{4:{177:1702040914}{451:0}}");
		assertNull(m.getCategory());
	}

	@Test
	public void testCorrespondent() throws IOException {
		SwiftMessage m = SwiftMessage.parse("{1:F01FOOBARAAAXXX3219604112}{2:I535BBBBBBBXXXXXN}{4:\n:16R:GENL\n-}");
		assertEquals(new BIC("BBBBBBBXXXXX"), m.getCorrespondentBIC());
		
		m = SwiftMessage.parse("{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{4:\n:16R:GENL\n-}");
		assertEquals(new BIC("AAPBESMMAXXX"), m.getCorrespondentBIC());
	}

	@Test
	public void testUUMID() throws IOException {
		SwiftMessage m = SwiftMessage.parse("{1:F01FOOBARAAAXXX3219604112}{2:I535BBBBBBBXXXXXN}{4:\n:16R:GENL\n-}");
		assertEquals("IBBBBBBBXXXX535", m.getUUID());
		
		m = SwiftMessage.parse("{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{4:\n:16R:GENL\n-}");
		assertEquals("OAAPBESMMXXX103", m.getUUID());
	}

	@Test
	public void testUID() throws IOException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.AUGUST);
		cal.set(Calendar.DAY_OF_MONTH, 27);
		
		SwiftMessage m = SwiftMessage.parse("{1:F01FOOBARAAAXXX3219604112}{2:I535BBBBBBBXXXXXN}{4:\n:16R:GENL\n-}");
		assertEquals("IBBBBBBBXXXX5351508270000001234", m.getUID(cal, 1234L));
		
		m = SwiftMessage.parse("{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{4:\n:16R:GENL\n-}");
		assertEquals("OAAPBESMMXXX1031508270000001234", m.getUID(cal, 1234L));
	}

	@Test
	public void testServiceTypeIdentifier() {
		SwiftMessage m = new SwiftMessage();
		assertNull(m.getServiceTypeIdentifier());
		m.setServiceTypeIdentifier("001");
		assertEquals("001", m.getServiceTypeIdentifier());
		m.setServiceTypeIdentifier("002");
		assertEquals("002", m.getServiceTypeIdentifier());
		assertTrue(m.getBlock3().countByName(Field111.NAME) == 1);
	}

	@Test
	public void testUETR() {
		SwiftMessage m = new SwiftMessage();
		assertNull(m.getUETR());
		m.setUETR();
		assertNotNull(m.getUETR());
		m.setUETR("eb6305c9-1f7f-49de-aed0-16487c27b42d");
		assertEquals("eb6305c9-1f7f-49de-aed0-16487c27b42d", m.getUETR());
		m.setUETR("foo");
		assertEquals("foo", m.getUETR());
		assertTrue(m.getBlock3().countByName(Field121.NAME) == 1);
	}

	@Test
	public void testVariant() {
		SwiftMessage m = new SwiftMessage();
		assertFalse(m.isSTP());
		m.setVariant(MTVariant.STP);
		assertTrue(m.isSTP());
		m.setVariant(MTVariant.COV);
		assertFalse(m.isSTP());
		assertTrue(m.isCOV());
		m.setVariant(MTVariant.REMIT);
		assertFalse(m.isSTP());
		assertFalse(m.isCOV());
		assertTrue(m.isREMIT());
		assertTrue(m.getBlock3().countByName(Field119.NAME) == 1);
	}
	
}
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

import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.field.Field50K;
import com.prowidesoftware.swift.model.mt.MTVariant;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103_STP;
import com.prowidesoftware.swift.model.mt.mt2xx.MT202;
import com.prowidesoftware.swift.model.mt.mt2xx.MT202COV;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Test for {@link MtSwiftMessage} model API
 * 
 * @since 7.8
 */
public class MtSwiftMessageTest {

	@Test
	public void testGetModelMessage() throws IOException {
		String fin = "{1:F01CARBVEC0AXXX8321000092}{2:I199FOOBARAAXXXXN}{4:\n"
		        + ":20:ABC\n"
				+ ":50K:/1234567890\n"
				+ "FOO\n"
		        + "-}";
		MtSwiftMessage mtsm = new MtSwiftMessage(fin);
		assertNotNull(mtsm.getFileFormat());
		assertEquals(FileFormat.FIN, mtsm.getFileFormat());
		SwiftMessage sm = mtsm.modelMessage();
		assertNotNull(sm);
		assertNotNull(sm.getBlock4());
		assertEquals(2, sm.getBlock4().size());
		assertEquals("/1234567890\nFOO", sm.getBlock4().getTagByName("50K").getValue());

		// when created from model the EOLS are fixed in FIN writer with missing CR
		MtSwiftMessage mtsm2 = new MtSwiftMessage(SwiftMessage.parse(fin));
		SwiftMessage sm2 = mtsm2.modelMessage();
		assertNotNull(sm2);
		assertNotNull(sm2.getBlock4());
		assertEquals(2, sm2.getBlock4().size());
		assertEquals("/1234567890\r\nFOO", sm2.getBlock4().getTagByName("50K").getValue());
	}

	@Test
	public void testModelMessage2() {
		MtSwiftMessage mt = MtSwiftMessage.parse("{1:F01ABCDJOC0AXXX0293022700}{2:I103ABCDJOC0XXXXN}{3:{103:JOD}{113:0112}{108:12345}{119:STP}}{4:\n" +
				":20:12345\n" +
				":23B:CRED\n" +
				":26T:001\n" +
				":32A:190110JOD1000,\n" +
				":33B:JOD10000,\n" +
				":50K:/987654321\n" +
				"MINISTRY OF FINANCE COLLECTED REVEN\n" +
				"BR CENTER\n" +
				":59:/876543219\n" +
				"MINISTRY OF FINANCE COLLECTED REVEN\n" +
				"NEW YORK USA\n" +
				":70:0101\n" +
				"INVOICE PAYMENT AND PURCHASE\n" +
				":71A:OUR\n" +
				"-}");
		assertEquals("STP", mt.getMtId().getVariant());
		SwiftMessage msg = mt.modelMessage();
		assertEquals("12345", msg.getBlock4().getFieldByName("20").getValue());
		Field f = msg.getBlock4().getFieldByName(Field50K.NAME);
		assertEquals("987654321", f.getComponent(1));
	}

	@Test
	public void testSystemMessage() {
		String fin = "{1:F21LITEBEBBADSZ0066000079}{4:{177:1104180901}{451:0}}\n"
					+"{1:F01LITEBEBBADSZ0066000079}{2:I999FOOEBEBBXABCN}{4:\n"
					+":20:TESTREF1\n"
					+":79:This is text line 1\n"
					+"-}{5:{CHK:7602B010CF31}{TNG:}}";
		MtSwiftMessage m = new MtSwiftMessage(fin);
		assertEquals(AbstractSwiftMessage.IDENTIFIER_ACK, m.getIdentifier());
		assertEquals("LITEBEBBDSZ", m.getSender());
		/*
		 * data from original message
		 */
		assertEquals(m.getDirection(), MessageIOType.outgoing);
		assertEquals("TESTREF1", m.getReference());
		assertEquals("FOOEBEBBABC", m.getReceiver());
	}
	
	@Test
	public void updateFromIncompleteModel() {
		MtSwiftMessage m = new MtSwiftMessage();
		SwiftMessage sm = new SwiftMessage();
		sm.addBlock(new SwiftBlock1());
		sm.addBlock(new SwiftBlock2Input());
		sm.getBlock2().setMessageType("202");
		m.updateFromModel(sm);
		assertEquals("fin.202", m.getIdentifier());
	}

	@Test
	public void testIdentifier() {
		MtSwiftMessage m = new MtSwiftMessage();
		assertNull(m.getIdentifier());

		m = new MtSwiftMessage(new MT103().getSwiftMessage());
		assertEquals("fin.103", m.getIdentifier());

		m = new MtSwiftMessage(new MT103_STP().getSwiftMessage());
		assertEquals("fin.103.STP", m.getIdentifier());

		m = new MtSwiftMessage(new MT202().getSwiftMessage());
		assertEquals("fin.202", m.getIdentifier());

		m = new MtSwiftMessage(new MT202COV().getSwiftMessage());
		assertEquals("fin.202.COV", m.getIdentifier());
	}

	@Test
	public void testIdentifierAndIsType() {
		MtSwiftMessage m = new MtSwiftMessage();
		assertNull(m.getIdentifier());
		assertFalse(m.isType(103));

		m = new MtSwiftMessage(new MT103().getSwiftMessage());
		assertTrue(m.isType(103));
		assertFalse(m.isType(202));

		m = new MtSwiftMessage(new MT103_STP().getSwiftMessage());
		assertTrue(m.isType(103));
		assertFalse(m.isType(202));

		m = new MtSwiftMessage(new MT202().getSwiftMessage());
		assertFalse(m.isType(103));
		assertTrue(m.isType(202));

		m = new MtSwiftMessage(new MT202COV().getSwiftMessage());
		assertFalse(m.isType(103));
		assertTrue(m.isType(202));
	}

	@Test
	public void testVariant() {
		MtSwiftMessage m = new MtSwiftMessage();
		assertNull(m.getVariant());

		m = new MtSwiftMessage(new MT103().getSwiftMessage());
		assertNull(m.getVariant());

		m = new MtSwiftMessage(new MT103_STP().getSwiftMessage());
		assertEquals(MTVariant.STP, m.getVariant());

		m = new MtSwiftMessage(new MT202().getSwiftMessage());
		assertNull(m.getVariant());

		m = new MtSwiftMessage(new MT202COV().getSwiftMessage());
		assertEquals(MTVariant.COV, m.getVariant());
	}

	@Test
	public void testMtId() {
		MtSwiftMessage m = new MtSwiftMessage();
		assertNull(m.getMtId().getMessageType());
		assertNull(m.getMtId().getVariant());

		m = new MtSwiftMessage(new MT103().getSwiftMessage());
		assertEquals(new MtId("103"), m.getMtId());

		m = new MtSwiftMessage(new MT103_STP().getSwiftMessage());
		assertEquals(new MtId("103", "STP"), m.getMtId());

		m = new MtSwiftMessage(new MT202().getSwiftMessage());
		assertEquals(new MtId("202"), m.getMtId());

		m = new MtSwiftMessage(new MT202COV().getSwiftMessage());
		assertEquals(new MtId("202", "COV"), m.getMtId());
	}

}

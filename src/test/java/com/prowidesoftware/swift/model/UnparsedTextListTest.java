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

import com.prowidesoftware.swift.io.ConversionService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Unparsed text lists tests.
 *
 * @since 4.0
 */
public class UnparsedTextListTest {
	
	private static final String someText = "[some text]";
	private static final String someMsg  = "{1:test}";
	private static final String finMsg   = "{1:F01BANKBEBBAXXX2222123456}"; 

	private UnparsedTextList  t = null;

	@Before
	public void setUp() {
		t = new UnparsedTextList();
	}

	@Test
	public void test_toString() {
		assertEquals(t.getAsFINString(), "");
		t.addText(someText);
		assertEquals(t.getAsFINString(), someText);
	}

	@Test
	public void test_staticIsMessage() {
		assertFalse(UnparsedTextList.isMessage(someText));
		assertTrue(UnparsedTextList.isMessage(someMsg));
	}

	@Test
	public void test_addText() {
		t.addText(someText);
		assertEquals(t.size(), new Integer(1));
		assertEquals(t.getText(0), someText);
	}

	@Test
	public void test_isMessage() {
		t.addText(someText);
		t.addText(someMsg);
		assertFalse(t.isMessage(0));
		assertTrue(t.isMessage(1));
	}

	@Test
	public void test_size() {
		assertEquals(t.size(), new Integer(0));
		t.addText(someText);
		assertEquals(t.size(), new Integer(1));
	}

	@Test
	public void test_getTextOK() {
		t.addText(someText);
		t.addText(someMsg);
		assertEquals(t.getText(0), someText);
		assertEquals(t.getText(1), someMsg);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void test_getTextBAD() {
		assertNull(t.getText(-1));
	}

	@Test
	public void test_getTextAsMessageOK() {
		t.addText(finMsg);
		assertNotNull(t.getTextAsMessage(0));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void test_getTextAsMessageBAD() {
		assertNull(t.getTextAsMessage(-1));
	}

	@Test
	public void test_addTextMessage() {
		// create a message and get it's string representation
		ConversionService cService	= new ConversionService();
		SwiftMessage 	  msg 		= cService.getMessageFromFIN(finMsg);
		String       	  msgString = cService.getFIN(msg);

		// add the message
		t.addText(msg);

		// check things out
		assertEquals(t.size(), new Integer(1));
		assertEquals(t.getText(0), msgString);
	}

	@Test
	public void test_removeIndexOK() {
		t.addText(someText);
		t.addText(someMsg);
		t.removeText(0);
		assertEquals(t.getText(0), someMsg);
		assertEquals(t.size(), new Integer(1));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void test_removeIndexBAD() {
		t.removeText(1);
	}

	@Test
	public void test_removeText() {
		t.addText(someText);
		t.addText(someMsg);
		t.removeText(someText);
		assertEquals(t.getText(0), someMsg);
		assertEquals(t.size(), new Integer(1));
	}
	
	@Test
	public void test_BlockTexts() {
		t.addText(someText);
		t.addText(someMsg);
		SwiftBlock3 b3 = new SwiftBlock3();
		b3.setUnparsedTexts(t);
		
		assertEquals(2, b3.getUnparsedTextsSize().intValue());
		assertNotNull(b3.getUnparsedTexts().getText(0));
		assertEquals(someText, b3.getUnparsedTexts().getText(0));
		assertNotNull(b3.getUnparsedTexts().getText(1));
		assertEquals(someMsg, b3.getUnparsedTexts().getText(1));
	}
	
	@Test
	public void test_bug2822350() throws IOException {
		String m = "{1:F01DEUTDEFFZP1V1284289805}{2:O9402239090403DEUTDEFFZXXX12842898050904032239N}{3:{108: }}{4:\r\n"
			+":20:1234567890"
			+":25:60001218710100\r\n"
			+":28C:00029/001\r\n"
			+":60F:D090331EUR61,02\r\n"
			+":61:090402C1951,77NSECNONREF\r\n"
			+":86: /REMI/WERTPAPIERE WERTPAPIERKENN-NR. FOO WERTPAPIER-VERKAUF\r\n"
			+"FIL/DEPOT-NR: 600/012187100 FOO STRATEGIEPTF OFFENSIV UI INH.ANT. A DO\r\n"
			+"05050643103 310309020409\r\n"
			+":62F:C090403EUR1890,75\r\n"
			+":64:C090403EUR1890,75\r\n"
			+"-}{5:{CHK:000000000000}}";
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<3;i++) {
			sb.append(m);
		}

		SwiftMessage msg = SwiftMessage.parse(sb.toString());
				
		@SuppressWarnings("unused")
		SwiftMessage m2 = SwiftMessage.parse(msg.getUnparsedTexts().getText(0));
		
		@SuppressWarnings("unused")
		SwiftMessage m3 = SwiftMessage.parse(msg.getUnparsedTexts().getText(1));
	}
	
}

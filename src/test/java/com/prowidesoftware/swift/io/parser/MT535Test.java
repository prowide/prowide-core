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

import com.prowidesoftware.swift.model.SwiftBlock2Input;

/**
 * MT535 tests
 *
 * @since 4.0
 */
public class MT535Test extends BaseMessageTestcase {
	
	@Test 
	public void test535_1() {
		messageToParse = "{1:F01FOOBARXXAXXX3219604112}{2:I535FOOBARXXXXXXN}{4:\n" +
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
		
		assertEquals("535", (parseMessage(messageToParse)).getType());
		
		//check b1
		assertEquals("F01FOOBARXXAXXX3219604112", b1.getBlockValue());
		assertEquals("F", b1.getApplicationId());
		assertEquals("01", b1.getServiceId());
		assertEquals("FOOBARXXAXXX", b1.getLogicalTerminal());
		assertEquals("3219", b1.getSessionNumber());
		assertEquals("604112", b1.getSequenceNumber());
		
		//check b2
		assertEquals("I535FOOBARXXXXXXN", b2.getBlockValue());
		assertEquals("535", ((SwiftBlock2Input)b2).getMessageType());
		assertEquals("FOOBARXXXXXX", ((SwiftBlock2Input)b2).getReceiverAddress());
		assertEquals("N", ((SwiftBlock2Input)b2).getMessagePriority());
		assertNull(((SwiftBlock2Input)b2).getDeliveryMonitoring());
		assertNull(((SwiftBlock2Input)b2).getObsolescencePeriod());
		
		//check b4
		assertEquals(19, b4.countAll());
		
		tags = b4.getTagsByName("16R");
		assertEquals("GENL", tags[0].getValue());
		assertEquals("ADDINFO", tags[1].getValue());
		
		assertEquals("1/ONLY", b4.getTagValue("28E"));
		assertEquals(":STAT//086", b4.getTagValue("13A"));
		assertEquals(":SEME//ABC20070327P1", b4.getTagValue("20C"));
		assertEquals("NEWM", b4.getTagValue("23G"));
		assertEquals(":STAT//20070327", b4.getTagValue("98A"));
		assertEquals(":PREP//20070328043657", b4.getTagValue("98C"));
		
		tags = b4.getTagsByName("22F");
		assertEquals(":SFRE//DAIL", tags[0].getValue());
		assertEquals(":CODE//COMP", tags[1].getValue());
		assertEquals(":STTY//CUST", tags[2].getValue());
		assertEquals(":STBA//TRAD", tags[3].getValue());
		
		assertEquals(":SAFE//ABC", b4.getTagValue("97A"));	
		
		tags = b4.getTagsByName("17B");
		assertEquals(":ACTI//Y", tags[0].getValue());
		assertEquals(":CONS//Y", tags[1].getValue());
		
		tags = b4.getTagsByName("16S");
		assertEquals("GENL", tags[0].getValue());
		assertEquals("ADDINFO", tags[1].getValue());	
	
		tags = b4.getTagsByName("19A");
		assertEquals(":HOLP//USD0,", tags[0].getValue());
		assertEquals(":HOLS//USD0,", tags[1].getValue());
		
		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("8A1FADA1", b5.getTagValue("MAC"));
		assertEquals("B018C2CA74CD", b5.getTagValue("CHK"));	
		
		//user block (extra data, not swift standard, attached to the message as a trailer block)
		assertNotNull(o.getUserBlock("S"));
		assertEquals("I20070328.386482886.out/1/1", o.getUserBlock("S").getTagValue("REF"));
	}
	
}
	

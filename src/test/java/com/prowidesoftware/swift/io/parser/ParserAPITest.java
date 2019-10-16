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

import com.prowidesoftware.swift.model.SwiftBlock2Output;
import com.prowidesoftware.swift.model.SwiftMessage;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Test for SwiftParser main API and functions.
 *
 * @since 4.0
 */
public class ParserAPITest {
	
	@Test 
	public void test103_1() throws IOException {
		String messageToParse = "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}{119:STP}}{4:\n" +
					":20:D051026EUR100057\n" + 
					":13C:/RNCTIME/0802+0000\n" + 
					":23B:CRED\n" + 
					":32A:051028EUR6740,91\n" + 
					":33B:EUR6740,91\n" + 
					":50A:SSSSESMMXXX\n" + 
					":53A:BBBBESMMXXX\n" + 
					":57A:FOOBARYYXXX\n" +
					":59:/ES0123456789012345671234\n" + 
					"FOOOOO 1000 FOOBAR S.A.\n" + 
					":70:REDEMPTS. TRADEDATE 2222-10-26\n" + 
					"/123123123: FOOVIMAR 2000 FOOBAR\n" + 
					":71A:SHA\n" + 
					"-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";

		SwiftMessage m = (new SwiftParser(messageToParse)).message();

		//get a simple value tag
		@SuppressWarnings("unused")
		String val32a = m.getBlock3().getTagValue("32A");

		//get a repeated value tag
		@SuppressWarnings("unused")
		String[] list71 = m.getBlock3().getTagValues("71F");
		
		assertEquals("103", m.getType());

		//check b1
		assertEquals("F01FOOBARYYAXXX1234123456", m.getBlock1().getBlockValue());
		assertEquals("F", m.getBlock1().getApplicationId());
		assertEquals("01", m.getBlock1().getServiceId());
		assertEquals("FOOBARYYAXXX", m.getBlock1().getLogicalTerminal());
		assertEquals("1234", m.getBlock1().getSessionNumber());
		assertEquals("123456", m.getBlock1().getSequenceNumber());

		//check b2
		assertEquals("O1030803051028AAPBESMMAXXX54237368560510280803N", m.getBlock2().getBlockValue());
		assertEquals("103", ((SwiftBlock2Output) m.getBlock2()).getMessageType());
		assertEquals("0803", ((SwiftBlock2Output) m.getBlock2()).getSenderInputTime());
		assertEquals("051028", ((SwiftBlock2Output) m.getBlock2()).getMIRDate());
		assertEquals("AAPBESMMAXXX", ((SwiftBlock2Output) m.getBlock2()).getMIRLogicalTerminal());
		assertEquals("5423", ((SwiftBlock2Output) m.getBlock2()).getMIRSessionNumber());
		assertEquals("736856", ((SwiftBlock2Output) m.getBlock2()).getMIRSequenceNumber());
		assertEquals("051028AAPBESMMAXXX5423736856", ((SwiftBlock2Output) m.getBlock2()).getMIR());
		assertEquals("051028", ((SwiftBlock2Output) m.getBlock2()).getReceiverOutputDate());
		assertEquals("0803", ((SwiftBlock2Output) m.getBlock2()).getReceiverOutputTime());
		assertEquals("N", ((SwiftBlock2Output) m.getBlock2()).getMessagePriority());

		//check b3
		assertEquals(3, m.getBlock3().countAll());
		assertEquals("NOMF", m.getBlock3().getTagValue("113"));
		assertEquals("0510280086100057", m.getBlock3().getTagValue("108"));
		assertEquals("STP", m.getBlock3().getTagValue("119"));

		//check b4
		assertEquals(11, m.getBlock4().countAll());
		assertEquals("D051026EUR100057", m.getBlock4().getTagValue("20"));
		assertEquals("/RNCTIME/0802+0000", m.getBlock4().getTagValue("13C"));
		assertEquals("CRED", m.getBlock4().getTagValue("23B"));
		assertEquals("051028EUR6740,91", m.getBlock4().getTagValue("32A"));
		assertEquals("EUR6740,91", m.getBlock4().getTagValue("33B"));
		assertEquals("SSSSESMMXXX", m.getBlock4().getTagValue("50A"));
		assertEquals("BBBBESMMXXX", m.getBlock4().getTagValue("53A"));
		assertEquals("FOOBARYYXXX", m.getBlock4().getTagValue("57A"));
		assertEquals("/ES0123456789012345671234\n" + "FOOOOO 1000 FOOBAR S.A.", m.getBlock4().getTagValue("59"));
		assertEquals("REDEMPTS. TRADEDATE 2222-10-26\n" + "/123123123: FOOVIMAR 2000 FOOBAR", m.getBlock4().getTagValue("70"));
		assertEquals("SHA", m.getBlock4().getTagValue("71A"));

		//check b5
		assertEquals(2, m.getBlock5().countAll());
		assertEquals("D9D8FA56", m.getBlock5().getTagValue("MAC"));
		assertEquals("46E46A6460F2", m.getBlock5().getTagValue("CHK"));
	}
	
	@Test 
	public void test103_2() throws IOException {
		String messageToParse = "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}{119:STP}}{4:\n" +
					":20:D051026EUR100057\n" + 
					":13C:/RNCTIME/0802+0000\n" + 
					":23B:CRED\n" + 
					":32A:051028EUR6740,91\n" + 
					":33B:EUR6740,91\n" + 
					":50A:SSSSESMMXXX\n" + 
					":53A:BBBBESMMXXX\n" + 
					":57A:FOOBARYYXXX\n" +
					":59:/ES0123456789012345671234\n" + 
					"FOOOOO 1000 FOOBAR S.A.\n" + 
					":70:REDEMPTS. TRADEDATE 2222-10-26\n" + 
					"/123123123: FOOVIMAR 2000 FOOBAR\n" + 
					":71A:SHA\n" + 
					"-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";

		SwiftMessage m = SwiftMessage.parse(messageToParse);

		assertEquals("103", m.getType());

		//check b1
		assertEquals("F01FOOBARYYAXXX1234123456", m.getBlock1().getBlockValue());
		assertEquals("F", m.getBlock1().getApplicationId());
		assertEquals("01", m.getBlock1().getServiceId());
		assertEquals("FOOBARYYAXXX", m.getBlock1().getLogicalTerminal());
		assertEquals("1234", m.getBlock1().getSessionNumber());
		assertEquals("123456", m.getBlock1().getSequenceNumber());

		//check b2
		assertEquals("O1030803051028AAPBESMMAXXX54237368560510280803N", m.getBlock2().getBlockValue());
		assertEquals("103", ((SwiftBlock2Output) m.getBlock2()).getMessageType());
		assertEquals("0803", ((SwiftBlock2Output) m.getBlock2()).getSenderInputTime());
		assertEquals("051028", ((SwiftBlock2Output) m.getBlock2()).getMIRDate());
		assertEquals("AAPBESMMAXXX", ((SwiftBlock2Output) m.getBlock2()).getMIRLogicalTerminal());
		assertEquals("5423", ((SwiftBlock2Output) m.getBlock2()).getMIRSessionNumber());
		assertEquals("736856", ((SwiftBlock2Output) m.getBlock2()).getMIRSequenceNumber());
		assertEquals("051028AAPBESMMAXXX5423736856", ((SwiftBlock2Output) m.getBlock2()).getMIR());
		assertEquals("051028", ((SwiftBlock2Output) m.getBlock2()).getReceiverOutputDate());
		assertEquals("0803", ((SwiftBlock2Output) m.getBlock2()).getReceiverOutputTime());
		assertEquals("N", ((SwiftBlock2Output) m.getBlock2()).getMessagePriority());

		//check b3
		assertEquals(3, m.getBlock3().countAll());
		assertEquals("NOMF", m.getBlock3().getTagValue("113"));
		assertEquals("0510280086100057", m.getBlock3().getTagValue("108"));
		assertEquals("STP", m.getBlock3().getTagValue("119"));

		//check b4
		assertEquals(11, m.getBlock4().countAll());
		assertEquals("D051026EUR100057", m.getBlock4().getTagValue("20"));
		assertEquals("/RNCTIME/0802+0000", m.getBlock4().getTagValue("13C"));
		assertEquals("CRED", m.getBlock4().getTagValue("23B"));
		assertEquals("051028EUR6740,91", m.getBlock4().getTagValue("32A"));
		assertEquals("EUR6740,91", m.getBlock4().getTagValue("33B"));
		assertEquals("SSSSESMMXXX", m.getBlock4().getTagValue("50A"));
		assertEquals("BBBBESMMXXX", m.getBlock4().getTagValue("53A"));
		assertEquals("FOOBARYYXXX", m.getBlock4().getTagValue("57A"));
		assertEquals("/ES0123456789012345671234\n" + "FOOOOO 1000 FOOBAR S.A.", m.getBlock4().getTagValue("59"));
		assertEquals("REDEMPTS. TRADEDATE 2222-10-26\n" + "/123123123: FOOVIMAR 2000 FOOBAR", m.getBlock4().getTagValue("70"));
		assertEquals("SHA", m.getBlock4().getTagValue("71A"));

		//check b5
		assertEquals(2, m.getBlock5().countAll());
		assertEquals("D9D8FA56", m.getBlock5().getTagValue("MAC"));
		assertEquals("46E46A6460F2", m.getBlock5().getTagValue("CHK"));
	}
	
}
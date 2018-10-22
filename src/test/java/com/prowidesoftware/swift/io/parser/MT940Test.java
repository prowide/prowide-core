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

import java.io.IOException;

import org.junit.Test;

import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.io.IConversionService;
import com.prowidesoftware.swift.model.SwiftBlock2Input;

/**
 * MT940 tests
 *
 * @since 4.0
 */
public class MT940Test extends BaseMessageTestcase {
	
	@Test 
	public void test940_1() {
		messageToParse = " {1:F01FOOBARXXAXXX0000000000}{2:I940FOOBARXXXXXXN}{4:\n" +
			":20:REFXXXXX\n" +
			":25:K005201001004509050156\n" +
			":28C:00001\n" +
			":60F:C051007XOF2644893271,0\n" +
			":61:0710241024DF4105400,0FMSC1234567890\n" +
			"TEST LIBELLE\n" +
			":61:0710251025DF3000000000,0FMSC1234567890\n" +
			"TEST LIBELLE\n" +
			":61:0710251025CF959919691,0FMSC1234567890\n" +
			"TEST LIBELLE\n" +
			":61:0710251025CF523237057,0FMSC1234567890\n" +
			"TEST LIBELLE\n" +
			":61:0710251025CF3000000000,0FMSC1234567890\n" +
			"TEST LIBELLE\n" +
			":62F:C061207XOF4123944619,0\n" +
			":86:Message de bienvenue\n" +
			"-}"; 
		
		assertEquals("940", (parseMessage(messageToParse)).getType());
		
		//check b1
		assertEquals("F01FOOBARXXAXXX0000000000", b1.getBlockValue());
		assertEquals("F", b1.getApplicationId());
		assertEquals("01", b1.getServiceId());
		//assertEquals("ABCDEFGHIJKX", b1.getLogicalTerminal());
		//assertEquals("3227", b1.getSessionNumber());
		//assertEquals("607589", b1.getSequenceNumber());
		
		//check b2
		assertEquals("I940FOOBARXXXXXXN", b2.getBlockValue());
		assertEquals("940", ((SwiftBlock2Input)b2).getMessageType());
		//assertEquals("FOOBARXXXXXX", ((SwiftBlock2Input)b2).getReceiverAddress());
		//assertEquals("N", ((SwiftBlock2Input)b2).getMessagePriority());
		//assertNull(((SwiftBlock2Input)b2).getDeliveryMonitoring());
		//assertNull(((SwiftBlock2Input)b2).getObsolescencePeriod());
		
		//check b4
		assertEquals(11, b4.countAll());
		assertEquals("REFXXXXX", b4.getTagValue("20"));
		assertEquals("K005201001004509050156", b4.getTagValue("25"));
		assertEquals("00001", b4.getTagValue("28C"));
		assertEquals("C051007XOF2644893271,0", b4.getTagValue("60F"));
		
		tags = b4.getTagsByName("61");
		assertEquals("0710241024DF4105400,0FMSC1234567890\n" + "TEST LIBELLE", tags[0].getValue());
		assertEquals("0710251025DF3000000000,0FMSC1234567890\n" + "TEST LIBELLE", tags[1].getValue());
		assertEquals("0710251025CF959919691,0FMSC1234567890\n" + "TEST LIBELLE", tags[2].getValue());
		assertEquals("0710251025CF523237057,0FMSC1234567890\n" + "TEST LIBELLE", tags[3].getValue());
		assertEquals("0710251025CF3000000000,0FMSC1234567890\n" + "TEST LIBELLE", tags[4].getValue());
		
		assertEquals("C061207XOF4123944619,0", b4.getTagValue("62F"));
		assertEquals("Message de bienvenue", b4.getTagValue("86"));
	}
	
	/**
	 * Bugs item #3085821, was opened at 2010-10-12 11:27
	 * https://sourceforge.net/tracker/?func=detail&atid=818173&aid=3085821&group_id=161017
	 */
	@Test 
	public void test940_2() throws IOException {
		String expectedMT940 = "{1:F01SBZAZAJJXXXX0000999999}{2:I940SBZAZAJJTINXN2999}{4:\r\n" +
	      ":20:S00147 L00001\r\n" +
	      ":25:401450139\r\n" +
	      ":28C:00147/00001\r\n" +
	      ":60F:C100915ZAR504917,30\r\n" +
	      ":61:1009150915C228,00FTRF019440587//019440587\r\n" +
	      ":86:CREDIT TRANSFER\r\n" +
	      "019440587\r\n" +
	      "9119\r\n" +
	      "000000000000036\r\n" +
	      "0,00\r\n" +
	      ":61:1009150915D500,00FDDT000000083//000000083\r\n" +
	      ":86:MONEY TRANSFER DEBIT\r\n" +
	      "000000083\r\n" +
	      "\r\n" +
	      "000000000000072\r\n" +
	      "0,00\r\n" +
	      ":61:1009150915D100,00FDDT000000083//000000083\r\n" +
	      ":86:MONEY TRANSFER DEBIT\r\n" +
	      "000000083\r\n" +
	      "\r\n" +
	      "000000000000072\r\n" +
	      "0,00\r\n" +
	      ":61:1009150915D6,70FDDT000000094//000000094\r\n" +
	      ":86:PAYMENT\r\n" +
	      "000000094\r\n" +
	      "1509\r\n" +
	      "000000000000071\r\n" +
	      "0,00\r\n" +
	      ":61:1009150915D4,85FDDT000000094//000000094\r\n" +
	      ":86:MONEY TRANSFER DEBIT\r\n" +
	      "000000094\r\n" +
	      "1509\r\n" +
	      "000000000000072\r\n" +
	      "0,00\r\n" +
	      ":61:1009170917D500,00FCHG000301284//000301284\r\n" +
	      ":86:CHEQUE CASHED\r\n" +
	      "000301284\r\n" +
	      "\r\n" +
	      "000000000000062\r\n" +
	      "0,00\r\n" +
	      ":61:1009170917D350,00FDDT000000083//000000083\r\n" +
	      ":86:MONEY TRANSFER DEBIT\r\n" +
	      "000000083\r\n" +
	      "\r\n" +
	      "000000000000072\r\n" +
	      "0,00\r\n" +
	      ":61:1009170917D6,70FDDT000000094//000000094\r\n" +
	      ":86:PAYMENT\r\n" +
	      "000000094\r\n" +
	      "1709\r\n" +
	      "000000000000071\r\n" +
	      "0,00\r\n" +
	      ":61:1009170917D7,60FDDT000000094//000000094\r\n" +
	      ":86:MONEY TRANSFER DEBIT\r\n" +
	      "000000094\r\n" +
	      "1709\r\n" +
	      "000000000000072\r\n" +
	      "0,00\r\n" +
	      ":61:1009200920D350,00FDDT000000083//000000083\r\n" +
	      ":86:MONEY TRANSFER DEBIT\r\n" +
	      "000000083\r\n" +
	      "\r\n" +
	      "000000000000072\r\n" +
	      "0,00\r\n" +
	      ":61:1009200920D3554,92FDDT000000083//000000083\r\n" +
	      ":86:MONEY TRANSFER DEBIT\r\n" +
	      "000000083\r\n" +
	      "\r\n" +
	      "000000000000072\r\n" +
	      "0,00\r\n" +
	      ":61:1009200920D6,70FDDT000000094//000000094\r\n" +
	      ":86:PAYMENT\r\n" +
	      "000000094\r\n" +
	      "2009\r\n" +
	      "000000000000071\r\n" +
	      "0,00\r\n" +
	      ":61:1009200920D7,60FDDT000000094//000000094\r\n" +
	      ":86:MONEY TRANSFER DEBIT\r\n" +
	      "000000094\r\n" +
	      "2009\r\n" +
	      "000000000000072\r\n" +
	      "0,00\r\n" +
	      ":61:1009210921D100,00FDDT000000083//000000083\r\n" +
	      ":86:MONEY TRANSFER DEBIT\r\n" +
	      "000000083\r\n" +
	      "\r\n" +
	      "000000000000072\r\n" +
	      "0,00\r\n" +
	      ":62M:C100921ZAR499650,23\r\n" +
	      "-}";
	   IConversionService conversionService = new ConversionService();

	   String actualMT940 = conversionService.getFIN(new SwiftParser(expectedMT940).message());
	   assertEquals(actualMT940, expectedMT940);
	 }
	
}

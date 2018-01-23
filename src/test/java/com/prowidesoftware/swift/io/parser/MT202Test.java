/* 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
*/
package com.prowidesoftware.swift.io.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.prowidesoftware.swift.model.SwiftBlock2Output;

/**
 * MT202 tests
 * 
 * @author www.prowidesoftware.com
 * @since 4.0
 */
public class MT202Test extends BaseMessageTestcase {
	
	@Test 
	public void test202_1() {
		messageToParse = "{1:F01BICFOOYYAXXX1234123456}{2:O2020810060308QQQQESMMAXXX55610922240603080810N}{3:{113:NOMT}{108:2006030800940016}}{4:\n" +
			":20:X2XC05060308\n" +
			":21:X2XC05060308\n" +
			":13C:/SNDTIME/0809+0100\n" +
			":13C:/RNCTIME/0809+0100\n" +
			":32A:060308EUR12345,67\n" +
			":52A://FOOLLLLLLULLXXXL2SC05060308\n" +
			"LLLLLULLXXX\n" +
			":53A:/0809A060308LUES00054\n" +
			"FOOOOOOO\n" +
			":57A:BICFOOYYXXX\n" +
			":58A:/ES4100940060792840000017\n" +
			"BICFOOYYXXX\n" +
			":72:/BNF/REDEM 123.456 SHS B LU01191229\n" +
			"//00 FOOOOO L FUND EQUITY FOOOBAR\n" +
			"//EUROP AT NAV 88.88 06032006\n" +
			"//BY ORDER OF FOOBAR L FUND\n" +
			"//EQUITY FOOOBAR EUROPE\n" +
			"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		
		assertEquals("202", (parseMessage(messageToParse)).getType());
		
		//check b1
		assertEquals("F01BICFOOYYAXXX1234123456", b1.getBlockValue());
		assertEquals("F", b1.getApplicationId());
		assertEquals("01", b1.getServiceId());
		assertEquals("BICFOOYYAXXX", b1.getLogicalTerminal());
		assertEquals("1234", b1.getSessionNumber());
		assertEquals("123456", b1.getSequenceNumber());
		
		//check b2
		assertEquals("O2020810060308QQQQESMMAXXX55610922240603080810N", b2.getBlockValue());
		assertEquals("202", ((SwiftBlock2Output)b2).getMessageType());
		assertEquals("0810", ((SwiftBlock2Output)b2).getSenderInputTime());	
		assertEquals("060308", ((SwiftBlock2Output)b2).getMIRDate());
		assertEquals("QQQQESMMAXXX", ((SwiftBlock2Output)b2).getMIRLogicalTerminal());
		assertEquals("5561", ((SwiftBlock2Output)b2).getMIRSessionNumber());
		assertEquals("092224", ((SwiftBlock2Output)b2).getMIRSequenceNumber());
		assertEquals("060308QQQQESMMAXXX5561092224", ((SwiftBlock2Output)b2).getMIR());
		assertEquals("060308", ((SwiftBlock2Output)b2).getReceiverOutputDate());
		assertEquals("0810", ((SwiftBlock2Output)b2).getReceiverOutputTime());
		assertEquals("N", ((SwiftBlock2Output)b2).getMessagePriority());
		
		//check b3
		assertEquals(2, b3.countAll());
		assertEquals("NOMT", b3.getTagValue("113"));
		assertEquals("2006030800940016", b3.getTagValue("108"));
		
		//check b4
		assertEquals(10, b4.countAll());
		assertEquals("X2XC05060308", b4.getTagValue("20"));
		assertEquals("X2XC05060308", b4.getTagValue("21"));
		
		tags = b4.getTagsByName("13C");
		assertEquals("/SNDTIME/0809+0100", tags[0].getValue());
		assertEquals("/RNCTIME/0809+0100", tags[1].getValue());
		
		assertEquals("060308EUR12345,67", b4.getTagValue("32A"));
		assertEquals("//FOOLLLLLLULLXXXL2SC05060308\n" + "LLLLLULLXXX", b4.getTagValue("52A"));
		assertEquals("/0809A060308LUES00054\n" + "FOOOOOOO", b4.getTagValue("53A"));
		assertEquals("BICFOOYYXXX", b4.getTagValue("57A"));
		assertEquals("/ES4100940060792840000017\n" + "BICFOOYYXXX", b4.getTagValue("58A"));
		assertEquals("/BNF/REDEM 123.456 SHS B LU01191229\n" +
			"//00 FOOOOO L FUND EQUITY FOOOBAR\n" +
			"//EUROP AT NAV 88.88 06032006\n" +
			"//BY ORDER OF FOOBAR L FUND\n" +
			"//EQUITY FOOOBAR EUROPE", b4.getTagValue("72"));
		
		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("0D3E6718", b5.getTagValue("MAC"));
		assertEquals("76FFBA03C41F", b5.getTagValue("CHK"));
	}
	
	@Test 
	public void test202_2() {
		messageToParse = "{1:F01BICFOOYYAXXX1234123456}{2:O2021340060306PPPPESMMAXXX55590714410603061340N}{3:{113:NOMT}{108:2006030600940035}}{4:\n" +
			":20:C2CI03060306\n" +
			":21:C2CI03060306\n" +
			":13C:/SNDTIME/1339+0100\n" +
			":13C:/RNCTIME/1339+0100\n" +
			":32A:060306EUR199999,99\n" +
			":52A://FOOOBGLLLUYYXXXL2SI03060306\n" +
			"BGLLLUYYXXX\n" +
			":53A:/1339A060306LUES00052\n" +
			"FOOOOOOO\n" +
			":57A:BICFOOYYXXX\n" +
			":58A:/ES4100940060792840000017\n" +
			"BICFOOYYXXX\n" +
			":72:/BNF/REDEM 1876.543 SHS B LU011111\n" +
			"//3634 FOOBAR L FUND ABSOLUTE\n" +
			"//RETURN BOND AT NAV 199.99 FROM\n" +
			"//02032006 B/O FOOBAR L FUND ABSOLU\n" +
			"//TE RETURN BOND\n" +
			"-}{5:{MAC:2424F8B6}{CHK:F76887F6C516}}";
		
		assertEquals("202", (parseMessage(messageToParse)).getType());
		
		//check b1
		assertEquals("F01BICFOOYYAXXX1234123456", b1.getBlockValue());
		
		//check b2
		assertEquals("O2021340060306PPPPESMMAXXX55590714410603061340N", b2.getBlockValue());
		
		//check b3
		assertEquals(2, b3.countAll());
		assertEquals("NOMT", b3.getTagValue("113"));
		assertEquals("2006030600940035", b3.getTagValue("108"));
		
		//check b4
		assertEquals(10, b4.countAll());
		assertEquals("C2CI03060306", b4.getTagValue("20"));
		assertEquals("C2CI03060306", b4.getTagValue("21"));
		
		tags = b4.getTagsByName("13C");
		assertEquals("/SNDTIME/1339+0100", tags[0].getValue());
		assertEquals("/RNCTIME/1339+0100", tags[1].getValue());
		
		assertEquals("060306EUR199999,99", b4.getTagValue("32A"));
		assertEquals("//FOOOBGLLLUYYXXXL2SI03060306\n" + "BGLLLUYYXXX", b4.getTagValue("52A"));
		assertEquals("/1339A060306LUES00052\n" + "FOOOOOOO", b4.getTagValue("53A"));
		assertEquals("BICFOOYYXXX", b4.getTagValue("57A"));
		assertEquals("/ES4100940060792840000017\n" + "BICFOOYYXXX", b4.getTagValue("58A"));
		assertEquals("/BNF/REDEM 1876.543 SHS B LU011111\n" +
			"//3634 FOOBAR L FUND ABSOLUTE\n" +
			"//RETURN BOND AT NAV 199.99 FROM\n" +
			"//02032006 B/O FOOBAR L FUND ABSOLU\n" +
			"//TE RETURN BOND", b4.getTagValue("72"));
		
		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("2424F8B6", b5.getTagValue("MAC"));
		assertEquals("F76887F6C516", b5.getTagValue("CHK"));
	}
	
	@Test 
	public void test202_3() {
		messageToParse = "{1:F01BICFOOYYAXXX1234123456}{2:O2020838060307AAAABRMMAXXX55600795140603070838N}{3:{113:NOMT}{108:2006030700940021}}{4:\n" +
			":20:B2B404060307\n" +
			":21:B2B404060307\n" +
			":13C:/SNDTIME/0837+0100\n" +
			":13C:/RNCTIME/0837+0100\n" +
			":32A:060307EUR54321,23\n" +
			":52A://FOOUBGLLBRLLXXXL2S404060307\n" +
			"BGLLBRLLXXX\n" +
			":53A:/0837A060307AABR00038\n" +
			"FOOOOOOO\n" +
			":57A:BICFOOYYXXX\n" +
			":58A:/BR4100940060792840000017\n" +
			"BICFOOYYXXX\n" +
			":72:/BNF/REDEM 123.456 SHS B AA02077585\n" +
			"//81 FOOOBAR L FUND BOND INFLATION\n" +
			"//LINKE AT NAV 123.45 FROM 03032006\n" +
			"//B/O FOOOBAR L FUND BOND INFLATION\n" +
			"//LINKED\n" +
			"-}{5:{MAC:CF70285B}{CHK:51C671F55CB7}}";
		
		assertEquals("202", (parseMessage(messageToParse)).getType());
		
		//check b1
		assertEquals("F01BICFOOYYAXXX1234123456", b1.getBlockValue());
		
		//check b2
		assertEquals("O2020838060307AAAABRMMAXXX55600795140603070838N", b2.getBlockValue());
		
		//check b3
		assertEquals(2, b3.countAll());
		assertEquals("NOMT", b3.getTagValue("113"));
		assertEquals("2006030700940021", b3.getTagValue("108"));
		
		//check b4
		assertEquals(10, b4.countAll());
		assertEquals("B2B404060307", b4.getTagValue("20"));
		assertEquals("B2B404060307", b4.getTagValue("21"));
		
		tags = b4.getTagsByName("13C");
		assertEquals("/SNDTIME/0837+0100", tags[0].getValue());
		assertEquals("/RNCTIME/0837+0100", tags[1].getValue());
		
		assertEquals("060307EUR54321,23", b4.getTagValue("32A"));
		assertEquals("//FOOUBGLLBRLLXXXL2S404060307\n" + "BGLLBRLLXXX", b4.getTagValue("52A"));
		assertEquals("/0837A060307AABR00038\n" + "FOOOOOOO", b4.getTagValue("53A"));
		assertEquals("BICFOOYYXXX", b4.getTagValue("57A"));
		assertEquals("/BR4100940060792840000017\n" + "BICFOOYYXXX", b4.getTagValue("58A"));
		assertEquals("/BNF/REDEM 123.456 SHS B AA02077585\n" +
			"//81 FOOOBAR L FUND BOND INFLATION\n" +
			"//LINKE AT NAV 123.45 FROM 03032006\n" +
			"//B/O FOOOBAR L FUND BOND INFLATION\n" +
			"//LINKED", b4.getTagValue("72"));
		
		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("CF70285B", b5.getTagValue("MAC"));
		assertEquals("51C671F55CB7", b5.getTagValue("CHK"));
	}
	
	@Test 
	public void test202_4() {
		messageToParse = "{1:F01BICFOOYYAXXX1234123456}{2:O2021011060227FOOOESMMAXXX55529778600602271011N}{3:{113:NOMT}{108:2006022700940034}}{4:\n" +
			":20:A2A504060227\n" +
			":21:A2A504060227\n" +
			":13C:/SNDTIME/1010+0100\n" +
			":32A:060227EUR11111,11\n" +
			":52A://FOOUBGLLARLLXXXL2S504060227\n" +
			"BGLLARLLXXX\n" +
			":53A:/1010A060227ARES00071\n" +
			"FOOOOOOO\n" +
			":57A:BICFOOYYXXX\n" +
			":58A:/AR4100940060792840000017\n" +
			"BICFOOYYXXX\n" +
			":72:/BNF/REDEM 33.333 SHS B XX008704538\n" +
			"//0 FOOOBAR X YYYY BOND EURO PM/RV\n" +
			"//1 AT NAV 444.44 FROM 22.02.06\n" +
			"//B/O FOOBAR X YYYY BOND EURO\n" +
			"-}{5:{MAC:D45AA0E8}{CHK:3406C04414BD}}";
		
		assertEquals("202", (parseMessage(messageToParse)).getType());
		
		//check b1
		assertEquals("F01BICFOOYYAXXX1234123456", b1.getBlockValue());
		
		//check b2
		assertEquals("O2021011060227FOOOESMMAXXX55529778600602271011N", b2.getBlockValue());
		
		//check b3
		assertEquals(2, b3.countAll());
		assertEquals("NOMT", b3.getTagValue("113"));
		assertEquals("2006022700940034", b3.getTagValue("108"));
		
		//check b4
		assertEquals(9, b4.countAll());
		assertEquals("A2A504060227", b4.getTagValue("20"));
		assertEquals("A2A504060227", b4.getTagValue("21"));
		assertEquals("/SNDTIME/1010+0100", b4.getTagValue("13C"));
		assertEquals("060227EUR11111,11", b4.getTagValue("32A"));
		assertEquals("//FOOUBGLLARLLXXXL2S504060227\n" + "BGLLARLLXXX", b4.getTagValue("52A"));
		assertEquals("/1010A060227ARES00071\n" + "FOOOOOOO", b4.getTagValue("53A"));
		assertEquals("BICFOOYYXXX", b4.getTagValue("57A"));
		assertEquals("/AR4100940060792840000017\n" + "BICFOOYYXXX", b4.getTagValue("58A"));
		assertEquals("/BNF/REDEM 33.333 SHS B XX008704538\n" +
			"//0 FOOOBAR X YYYY BOND EURO PM/RV\n" +
			"//1 AT NAV 444.44 FROM 22.02.06\n" +
			"//B/O FOOBAR X YYYY BOND EURO", b4.getTagValue("72"));
		
		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("D45AA0E8", b5.getTagValue("MAC"));
		assertEquals("3406C04414BD", b5.getTagValue("CHK"));
	}
	
	@Test 
	public void test202_5() {
		messageToParse = "{1:F01BICFOOYYAXXX1234123456}{2:O2021559051102ABCDEFMMAXXX54267910040511021559N}{3:{113:NOMT}{108:2005110200940055}}{4:\n" +
			":20:FTR2222222 01\n" +
			":21:NONREF\n" +
			":13C:/RNCTIME/1559+0100\n" +
			":32A:051102EUR339262,0\n" +
			":52A://ABCDEFGHDEFFXXX1234567890 01\n" +
			"CHASGB2L\n" +
			":53A:/1234A0123456ABC012345\n" +
			"MARKDEFF\n" +
			":57A:BICFOOYY\n" +
			":58A:/US12 1234 6789 1234 1111 1234\n" +
			"BICFOOYY\n" +
			":72:/BNF/00940001852410932921ING DIRECT\n" +
			"//F.N.IBEX 35 FI\n" +
			"-}{5:{MAC:00EAF2F1}{CHK:5A1A7D7807F7}}";
		
		assertEquals("202", (parseMessage(messageToParse)).getType());
		
		//check b1
		assertEquals("F01BICFOOYYAXXX1234123456", b1.getBlockValue());
		
		//check b2
		assertEquals("O2021559051102ABCDEFMMAXXX54267910040511021559N", b2.getBlockValue());
		
		//check b3
		assertEquals(2, b3.countAll());
		assertEquals("NOMT", b3.getTagValue("113"));
		assertEquals("2005110200940055", b3.getTagValue("108"));
		
		//check b4
		assertEquals(9, b4.countAll());
		assertEquals("FTR2222222 01", b4.getTagValue("20"));
		assertEquals("NONREF", b4.getTagValue("21"));
		assertEquals("/RNCTIME/1559+0100", b4.getTagValue("13C"));
		assertEquals("051102EUR339262,0", b4.getTagValue("32A"));
		assertEquals("//ABCDEFGHDEFFXXX1234567890 01\n" + "CHASGB2L", b4.getTagValue("52A"));
		assertEquals("/1234A0123456ABC012345\n" + "MARKDEFF", b4.getTagValue("53A"));
		assertEquals("BICFOOYY", b4.getTagValue("57A"));
		assertEquals("/US12 1234 6789 1234 1111 1234\n" + "BICFOOYY", b4.getTagValue("58A"));
		assertEquals("/BNF/00940001852410932921ING DIRECT\n" +
			"//F.N.IBEX 35 FI", b4.getTagValue("72"));
		
		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("00EAF2F1", b5.getTagValue("MAC"));
		assertEquals("5A1A7D7807F7", b5.getTagValue("CHK"));
	}
	
}

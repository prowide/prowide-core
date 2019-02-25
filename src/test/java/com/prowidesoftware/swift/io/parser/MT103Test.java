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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import org.junit.Test;

import com.prowidesoftware.swift.model.SwiftBlock2Output;

/**
 * MT103 tests
 *
 * @since 4.0
 */
public class MT103Test extends BaseMessageTestcase {
	
	@Test 
	public void test103_1() {
		messageToParse = "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}{119:STP}}{4:\n" +
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

		assertEquals("103", (parseMessage(messageToParse)).getType());

		//check b1
		assertEquals("F01FOOBARYYAXXX1234123456", b1.getBlockValue());
		assertEquals("F", b1.getApplicationId());
		assertEquals("01", b1.getServiceId());
		assertEquals("FOOBARYYAXXX", b1.getLogicalTerminal());
		assertEquals("1234", b1.getSessionNumber());
		assertEquals("123456", b1.getSequenceNumber());

		//check b2
		assertEquals("O1030803051028AAPBESMMAXXX54237368560510280803N", b2.getBlockValue());
		assertEquals("103", ((SwiftBlock2Output) b2).getMessageType());
		assertEquals("0803", ((SwiftBlock2Output) b2).getSenderInputTime());
		assertEquals("051028", ((SwiftBlock2Output) b2).getMIRDate());
		assertEquals("AAPBESMMAXXX", ((SwiftBlock2Output) b2).getMIRLogicalTerminal());
		assertEquals("5423", ((SwiftBlock2Output) b2).getMIRSessionNumber());
		assertEquals("736856", ((SwiftBlock2Output) b2).getMIRSequenceNumber());
		assertEquals("051028AAPBESMMAXXX5423736856", ((SwiftBlock2Output) b2).getMIR());
		assertEquals("051028", ((SwiftBlock2Output) b2).getReceiverOutputDate());
		assertEquals("0803", ((SwiftBlock2Output) b2).getReceiverOutputTime());
		assertEquals("N", ((SwiftBlock2Output) b2).getMessagePriority());

		//check b3
		assertEquals(3, b3.countAll());
		assertEquals("NOMF", b3.getTagValue("113"));
		assertEquals("0510280086100057", b3.getTagValue("108"));
		assertEquals("STP", b3.getTagValue("119"));

		//check b4
		assertEquals(11, b4.countAll());
		assertEquals("D051026EUR100057", b4.getTagValue("20"));
		assertEquals("/RNCTIME/0802+0000", b4.getTagValue("13C"));
		assertEquals("CRED", b4.getTagValue("23B"));
		assertEquals("051028EUR6740,91", b4.getTagValue("32A"));
		assertEquals("EUR6740,91", b4.getTagValue("33B"));
		assertEquals("SSSSESMMXXX", b4.getTagValue("50A"));
		assertEquals("BBBBESMMXXX", b4.getTagValue("53A"));
		assertEquals("FOOBARYYXXX", b4.getTagValue("57A"));
		assertEquals("/ES0123456789012345671234\n" + "FOOOOO 1000 FOOBAR S.A.", b4.getTagValue("59"));
		assertEquals("REDEMPTS. TRADEDATE 2222-10-26\n" + "/123123123: FOOVIMAR 2000 FOOBAR", b4.getTagValue("70"));
		assertEquals("SHA", b4.getTagValue("71A"));

		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("D9D8FA56", b5.getTagValue("MAC"));
		assertEquals("46E46A6460F2", b5.getTagValue("CHK"));
	}
	
	@Test 
	public void test103_2() {
		messageToParse = "{1:F01FOOBARXXAXXX1234123456}{2:O1031041060411AAABESMMAXXX55944670160604111041N}{3:{113:ROMF}{108:0604113641000001}{119:STP}}{4:\n" +
					":20:1234123421340001\n" + 
					":13C:/RNCTIME/1040+0000\n" + 
					":23B:CRED\n" + 
					":23E:SDVA\n" + 
					":23E:CORT\n" + 
					":32A:010411EUR1275000,\n" + 
					":33B:EUR1234567,\n" + 
					":50A:ABCEESM1XXX\n" + 
					":52A:ABCEESM1XXX\n" + 
					":53A:ABCEESM1XXX\n" + 
					":57A:FOOBARXXXXX\n" +
					":59:/ES1234123412341234123412\n" + 
					"FOOBAR SECURITIES S.V. S.A\n" + 
					":71A:OUR\n" + 
					"-}{5:{MAC:184123B4}{CHK:5EFE8E14DF81}}";

		assertEquals("103", (parseMessage(messageToParse)).getType());

		//check b1
		assertEquals("F01FOOBARXXAXXX1234123456", b1.getBlockValue());

		//check b2
		assertEquals("O1031041060411AAABESMMAXXX55944670160604111041N", b2.getBlockValue());

		//check b3
		assertEquals(3, b3.countAll());
		assertEquals("ROMF", b3.getTagValue("113"));
		assertEquals("0604113641000001", b3.getTagValue("108"));
		assertEquals("STP", b3.getTagValue("119"));

		//check b4
		assertEquals(13, b4.countAll());
		assertEquals("1234123421340001", b4.getTagValue("20"));
		assertEquals("/RNCTIME/1040+0000", b4.getTagValue("13C"));
		assertEquals("CRED", b4.getTagValue("23B"));

		//first ocurrence of 23E
		assertEquals("SDVA", b4.getTagValue("23E"));

		//all ocurrences of 23E
		tags = b4.getTagsByName("23E");
		assertEquals("SDVA", tags[0].getValue());
		assertEquals("CORT", tags[1].getValue());

		assertEquals("010411EUR1275000,", b4.getTagValue("32A"));
		assertEquals("EUR1234567,", b4.getTagValue("33B"));
		assertEquals("ABCEESM1XXX", b4.getTagValue("50A"));
		assertEquals("ABCEESM1XXX", b4.getTagValue("52A"));
		assertEquals("ABCEESM1XXX", b4.getTagValue("53A"));
		assertEquals("FOOBARXXXXX", b4.getTagValue("57A"));
		assertEquals("/ES1234123412341234123412\n" + "FOOBAR SECURITIES S.V. S.A", b4.getTagValue("59"));
		assertEquals("OUR", b4.getTagValue("71A"));

		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("184123B4", b5.getTagValue("MAC"));
		assertEquals("5EFE8E14DF81", b5.getTagValue("CHK"));
	}
	
	@Test 
	public void test103_3() {
		messageToParse = "{1:F01FOOBARYYAXXX1234123456}{2:O1030954060228RRRRESMMAXXX55549966520602280954N}{3:{113:NOMT}{108:2006022800940029}{119:STP}}{4:\n" +
					":20:B185008345547244\n" + 
					":13C:/SNDTIME/0951+0100\n" + 
					":13C:/RNCTIME/0952+0100\n" + 
					":23B:CRED\n" + 
					":32A:010228EUR2999,66\n" + 
					":33B:EUR2999,66\n" + 
					":50K:FOOOBANK NA EUR (LONDON BRANCH) LVL\n" + 
					"12, FOOOGROUP CENT. CANADA SQ., CA\n" + 
					"NNNN WWWWW, LONDON E99 5LB CONTACT\n" + 
					"99 (0) 999 999 9999 GCNPPCCY FOOO\n" + 
					":52A://TAGBFOOOGB2LXXXB185008345547244\n" + 
					"FOOOIE2X\n" + 
					":53A:/0951A060228GBES00350\n" + 
					"FOONGB2L\n" + 
					":57A:FOOBARYY\n" +
					":59:/ES8700940001822410908524\n" + 
					"FOO CAPITAL ADVISORS\n" + 
					"SPAIN AGENCIA DE VALORES\n" + 
					"PLAZA XXXXXX YYYYY ZZZZZZ 9\n" + 
					"MADRID,\n" + 
					":70:B0706\n" + 
					":71A:BEN\n" + 
					":71F:EUR0,\n" + 
					":72:/ACC/BANKXXXX FOOOOOOOO, 20\n" + 
					"//MADRID,\n" + 
					"-}{5:{MAC:07CDCC9A}{CHK:AD1FAEE8537B}}";

		assertEquals("103", (parseMessage(messageToParse)).getType());

		//check b1
		assertEquals("F01FOOBARYYAXXX1234123456", b1.getBlockValue());

		//check b2
		assertEquals("O1030954060228RRRRESMMAXXX55549966520602280954N", b2.getBlockValue());

		//check b3
		assertEquals(3, b3.countAll());
		assertEquals("NOMT", b3.getTagValue("113"));
		assertEquals("2006022800940029", b3.getTagValue("108"));
		assertEquals("STP", b3.getTagValue("119"));

		//check b4
		assertEquals(15, b4.countAll());
		assertEquals("B185008345547244", b4.getTagValue("20"));

		tags = b4.getTagsByName("13C");
		assertEquals("/SNDTIME/0951+0100", tags[0].getValue());
		assertEquals("/RNCTIME/0952+0100", tags[1].getValue());

		assertEquals("CRED", b4.getTagValue("23B"));
		assertEquals("010228EUR2999,66", b4.getTagValue("32A"));
		assertEquals("EUR2999,66", b4.getTagValue("33B"));

		assertEquals("FOOOBANK NA EUR (LONDON BRANCH) LVL\n" + "12, FOOOGROUP CENT. CANADA SQ., CA\n" + "NNNN WWWWW, LONDON E99 5LB CONTACT\n" + "99 (0) 999 999 9999 GCNPPCCY FOOO", b4.getTagValue("50K"));

		assertEquals("//TAGBFOOOGB2LXXXB185008345547244\n" + "FOOOIE2X", b4.getTagValue("52A"));
		assertEquals("/0951A060228GBES00350\n" + "FOONGB2L", b4.getTagValue("53A"));
		assertEquals("FOOBARYY", b4.getTagValue("57A"));

		assertEquals("/ES8700940001822410908524\n" + "FOO CAPITAL ADVISORS\n" + "SPAIN AGENCIA DE VALORES\n" + "PLAZA XXXXXX YYYYY ZZZZZZ 9\n" + "MADRID,", b4.getTagValue("59"));

		assertEquals("B0706", b4.getTagValue("70"));
		assertEquals("BEN", b4.getTagValue("71A"));
		assertEquals("EUR0,", b4.getTagValue("71F"));
		assertEquals("/ACC/BANKXXXX FOOOOOOOO, 20\n" + "//MADRID,", b4.getTagValue("72"));

		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("07CDCC9A", b5.getTagValue("MAC"));
		assertEquals("AD1FAEE8537B", b5.getTagValue("CHK"));
	}
	
	@Test 
	public void test103_4() {
		messageToParse = "{1:F01FOOBARYYAXXX1234123456}{2:O1031101051102UUUUESMMAXXX54267818770511021101N}{3:{113:ROMF}{108:0511029000000056}}{4:\n" +
					":20:0511029000000056\n" + 
					":13C:/RNCTIME/123123123+0000\n" + 
					":23B:CRED\n" + 
					":32A:051102EUR88888,88\n" + 
					":33B:EUR88888,88\n" + 
					":50K:/12345678\n" + 
					"DIRECCION GENERAL DEL FOOBAR\n" + 
					":53A:EEEEESMMXXX\n" + 
					":57A:FOOBARYYXXX\n" +
					":59:/00123456789012345678\n" + 
					"FOOOOBAR, S.A.\n" + 
					"PS DE YYYYYYYYY 88\n" + 
					"MADRID\n" + 
					":70:/CNC/FRA. 8888 CUENTA 88 SEPTIEMBRE\n" + 
					"//MANT\n" + 
					"//NIMIENTO EQUIPOS E INSTALACIONES\n" + 
					"//TO\n" + 
					":71A:OUR\n" + 
					":72:/PORCTA1/M  FOOOOOO(001622053100386\n" + 
					"//123123123)\n" + 
					"/REFBEN/123123123A80960552\n" + 
					"/REC/123123123\n" + 
					"/CODORD/123123123\n" + 
					":77B:/ORDERRES///123123123\n" + 
					"-}{5:{MAC:17F13741}{CHK:802BE35B36EB}}";

		assertEquals("103", (parseMessage(messageToParse)).getType());

		//check b1
		assertEquals("F01FOOBARYYAXXX1234123456", b1.getBlockValue());

		//check b2
		assertEquals("O1031101051102UUUUESMMAXXX54267818770511021101N", b2.getBlockValue());

		//check b3
		assertEquals(2, b3.countAll());
		assertEquals("ROMF", b3.getTagValue("113"));
		assertEquals("0511029000000056", b3.getTagValue("108"));

		//check b4
		assertEquals(13, b4.countAll());
		assertEquals("0511029000000056", b4.getTagValue("20"));
		assertEquals("/RNCTIME/123123123+0000", b4.getTagValue("13C"));
		assertEquals("CRED", b4.getTagValue("23B"));
		assertEquals("051102EUR88888,88", b4.getTagValue("32A"));
		assertEquals("EUR88888,88", b4.getTagValue("33B"));
		assertEquals("/12345678\n" + "DIRECCION GENERAL DEL FOOBAR", b4.getTagValue("50K"));
		assertEquals("EEEEESMMXXX", b4.getTagValue("53A"));
		assertEquals("FOOBARYYXXX", b4.getTagValue("57A"));

		assertEquals("/00123456789012345678\n" + "FOOOOBAR, S.A.\n" + "PS DE YYYYYYYYY 88\n" + "MADRID", b4.getTagValue("59"));

		assertEquals("/CNC/FRA. 8888 CUENTA 88 SEPTIEMBRE\n" + "//MANT\n" + "//NIMIENTO EQUIPOS E INSTALACIONES\n" + "//TO", b4.getTagValue("70"));

		assertEquals("OUR", b4.getTagValue("71A"));

		assertEquals("/PORCTA1/M  FOOOOOO(001622053100386\n" + "//123123123)\n" + "/REFBEN/123123123A80960552\n" + "/REC/123123123\n" + "/CODORD/123123123", b4.getTagValue("72"));

		assertEquals("/ORDERRES///123123123", b4.getTagValue("77B"));

		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("17F13741", b5.getTagValue("MAC"));
		assertEquals("802BE35B36EB", b5.getTagValue("CHK"));
	}
	
	@Test 
	public void test103_5() {
		messageToParse = "{1:F01FOOBARYYAXXX1234123456}{2:O1031101051102KKKKESMMAXXX54267818770511021101N}{3:{113:ROMF}{108:0511029000000056}}{4:\n" +
					":20:0511029000000056\n" + 
					":13C:/RNCTIME/1101+0000\n" + 
					":23B:CRED\n" + 
					":32A:051102EUR66666,66\n" + 
					":33B:EUR66666,66\n" + 
					":50K:/12345678\n" + 
					"AAAA BBB CCCCC DDDDD\n" + 
					":53A:FOOBARMMXXX\n" +
					":57A:FOOBARYYXXX\n" +
					":59:/00123456789012345678\n" + 
					"FOOBAR, S.A.\n" + 
					"PS DE FFFFFFF 66\n" + 
					"MADRID\n" + 
					":70:/CNC/FRA. 6666 CUENTA 66 EEEEEEE\n" + 
					"//MANT\n" + "//NIMIENTO EQUIPOS E UUUUUUUUUUUUU\n" + 
					"//TO\n" + ":71A:OUR\n" + 
					":72:/PORCTA1/M  YYYYYYY(001622053100386\n" + 
					"//98)\n" + "/REFBEN/000A80960552\n" + 
					"/REC/00940001872410904744\n" + 
					"/CODORD/40005\n" + 
					":77B:/ORDERRES///000000\n" + 
					"-}{5:{MAC:17F13741}{CHK:802BE35B36EB}}";

		assertEquals("103", (parseMessage(messageToParse)).getType());

		//check b1
		assertEquals("F01FOOBARYYAXXX1234123456", b1.getBlockValue());

		//check b2
		assertEquals("O1031101051102KKKKESMMAXXX54267818770511021101N", b2.getBlockValue());

		//check b3
		assertEquals(2, b3.countAll());
		assertEquals("ROMF", b3.getTagValue("113"));
		assertEquals("0511029000000056", b3.getTagValue("108"));

		//check b4
		assertEquals(13, b4.countAll());
		assertEquals("0511029000000056", b4.getTagValue("20"));
		assertEquals("/RNCTIME/1101+0000", b4.getTagValue("13C"));
		assertEquals("CRED", b4.getTagValue("23B"));
		assertEquals("051102EUR66666,66", b4.getTagValue("32A"));
		assertEquals("EUR66666,66", b4.getTagValue("33B"));
		assertEquals("/12345678\n" + "AAAA BBB CCCCC DDDDD", b4.getTagValue("50K"));
		assertEquals("FOOBARMMXXX", b4.getTagValue("53A"));
		assertEquals("FOOBARYYXXX", b4.getTagValue("57A"));

		assertEquals("/00123456789012345678\n" + "FOOBAR, S.A.\n" + "PS DE FFFFFFF 66\n" + "MADRID", b4.getTagValue("59"));

		assertEquals("/CNC/FRA. 6666 CUENTA 66 EEEEEEE\n" + "//MANT\n" + "//NIMIENTO EQUIPOS E UUUUUUUUUUUUU\n" + "//TO", b4.getTagValue("70"));

		assertEquals("OUR", b4.getTagValue("71A"));

		assertEquals("/PORCTA1/M  YYYYYYY(001622053100386\n" + "//98)\n" + "/REFBEN/000A80960552\n" + "/REC/00940001872410904744\n" + "/CODORD/40005", b4.getTagValue("72"));

		assertEquals("/ORDERRES///000000", b4.getTagValue("77B"));

		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("17F13741", b5.getTagValue("MAC"));
		assertEquals("802BE35B36EB", b5.getTagValue("CHK"));
	}
	
	@Test 
	public void test103_6() {
		messageToParse = "{1:F01FOOBARYYAXXX1234123456}{2:O1031101051102KKKKESMMAXXX54267818770511021101N}{3:{113:ROMF}{108:0511029000000056}}{4:\n" +
					":20:0511029000000056\n" + 
					":13C:/RNCTIME/1101+0000\n" + 
					":23B:CRED\n" + 
					":32A:051102EUR66666,66\n" + 
					":33B:EUR66666,66\n" + 
					":50K:/1234}5678\n" + 
					"AAAA BBB CCCCC DDDDD\n" + 
					":53A:FOOBARMMXXX\n" +
					":57A:FOOBARYYXXX\n" +
					":59:/00123456789012345678\n" + 
					"FOOBAR, S.A.\n" + 
					"PS DE FFFFFFF 66\n" + 
					"MADRID\n" + 
					":70:/CNC/FRA. 6666 CUENTA 66 EEEEEEE\n" + 
					"//MANT\n" + 
					"//NIMIENTO EQUIPOS E UUUUUUUUUUUUU\n" + 
					"//TO\n" + 
					":71A:OUR\n" + 
					":72:/PORCTA1/M  YYYYYYY(001622053100386\n" + 
					"//98)\n" + "/REFBEN/000A80960552\n" + 
					"/REC/00940001872410904744\n" + 
					"/CODORD/40005\n" + 
					":77B:/ORDERRES///000000\n" + 
					"-}{5:{MAC:17F13741}{CHK:802BE35B36EB}}";

		assertEquals("103", (parseMessage(messageToParse)).getType());

		//check b1
		assertEquals("F01FOOBARYYAXXX1234123456", b1.getBlockValue());

		//check b2
		assertEquals("O1031101051102KKKKESMMAXXX54267818770511021101N", b2.getBlockValue());

		//check b3
		assertEquals(2, b3.countAll());
		assertEquals("ROMF", b3.getTagValue("113"));
		assertEquals("0511029000000056", b3.getTagValue("108"));

		//check b4
//		assertEquals(13, b4.countAll());
		assertEquals("0511029000000056", b4.getTagValue("20"));
		assertEquals("/RNCTIME/1101+0000", b4.getTagValue("13C"));
		assertEquals("CRED", b4.getTagValue("23B"));
		assertEquals("051102EUR66666,66", b4.getTagValue("32A"));
		assertEquals("EUR66666,66", b4.getTagValue("33B"));
		assertEquals("/1234}5678\n" + "AAAA BBB CCCCC DDDDD", b4.getTagValue("50K"));
		assertEquals("FOOBARMMXXX", b4.getTagValue("53A"));
		assertEquals("FOOBARYYXXX", b4.getTagValue("57A"));

		assertEquals("/00123456789012345678\n" + "FOOBAR, S.A.\n" + "PS DE FFFFFFF 66\n" + "MADRID", b4.getTagValue("59"));

		assertEquals("/CNC/FRA. 6666 CUENTA 66 EEEEEEE\n" + "//MANT\n" + "//NIMIENTO EQUIPOS E UUUUUUUUUUUUU\n" + "//TO", b4.getTagValue("70"));

		assertEquals("OUR", b4.getTagValue("71A"));

		assertEquals("/PORCTA1/M  YYYYYYY(001622053100386\n" + "//98)\n" + "/REFBEN/000A80960552\n" + "/REC/00940001872410904744\n" + "/CODORD/40005", b4.getTagValue("72"));

		assertEquals("/ORDERRES///000000", b4.getTagValue("77B"));

		//check b5
		assertEquals(2, b5.countAll());
		assertEquals("17F13741", b5.getTagValue("MAC"));
		assertEquals("802BE35B36EB", b5.getTagValue("CHK"));
	}
	
	@Test 
	public void test103_7() {
		messageToParse = "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}{119:STP}}{4:\n" +
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
					":71A:SHA" + 
					"-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";

		assertEquals("103", (parseMessage(messageToParse)).getType());
	}

}

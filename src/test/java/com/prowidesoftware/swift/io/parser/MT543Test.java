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
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.Tag;

/**
 * MT543 tests
 *
 * @since 4.0
 */
public class MT543Test extends BaseMessageTestcase {
	
	@Test 
	public void test543_1() {
		messageToParse = "{1:F01FOOBARXXXXXX0000000000}{2:I543FOOODEFFXCUSN}{4:\n" +
			":16R:GENL\n" +
			":20C::SEME//2008101900002890\n" +
			":23G:NEWM\n" +
			":98A::PREP//20081019\n" +
			":16S:GENL\n" +
			":16R:TRADDET\n" +
			":98A::TRAD//20081017\n" +
			":98A::SETT//20081019\n" +
			":90B::DEAL//ACTU/EUR11,11\n" +
			":35B:ISIN US1234567890\n" +
			"AAAA BBBBBB\n" +
			":70E::SPRO//1234\n" +
			":16S:TRADDET\n" +
			":16R:FIAC\n" +
			":36B::SETT//UNIT/123,45\n" +
			":97A::SAFE//100948783600\n" +
			":16S:FIAC\n" +
			":16R:SETDET\n" +
			":22F::SETR//TRAD\n" +
			":16R:SETPRTY\n" +
			":95R::REAG/DAKV/8888\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::BUYR//SSSSNL2A\n" +
			":97A::SAFE//223602222\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::PSET//FOOVDEFF\n" +
			":16S:SETPRTY\n" +
			":16R:AMT\n" +
			":19A::SETT//EUR1234,56\n" +
			":16S:AMT\n" +
			":16S:SETDET\n" +
			"-}"; 
		
		assertEquals("543", (parseMessage(messageToParse)).getType());
		
		//check b1
		assertEquals("F01FOOBARXXXXXX0000000000", b1.getBlockValue());
		assertEquals("F", b1.getApplicationId());
		assertEquals("01", b1.getServiceId());
		assertEquals("FOOBARXXXXXX", b1.getLogicalTerminal());
		assertEquals("0000", b1.getSessionNumber());
		assertEquals("000000", b1.getSequenceNumber());
		
		//check b2
		assertEquals("I543FOOODEFFXCUSN", b2.getBlockValue());
		assertEquals("543", ((SwiftBlock2Input)b2).getMessageType());
		assertEquals("FOOODEFFXCUS", ((SwiftBlock2Input)b2).getReceiverAddress());	
		assertEquals("N", ((SwiftBlock2Input)b2).getMessagePriority());
		assertNull(((SwiftBlock2Input)b2).getDeliveryMonitoring());
		assertNull(((SwiftBlock2Input)b2).getObsolescencePeriod());
		
		assertEquals(32, b4.countAll());
		
		List<Tag> b4Tags = b4.getTags();
		int pos = 0;
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16R", t.getName());
		assertEquals("GENL", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("20C", t.getName());
		assertEquals(":SEME//2008101900002890", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("23G", t.getName());
		assertEquals("NEWM", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("98A", t.getName());
		assertEquals(":PREP//20081019", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16S", t.getName());
		assertEquals("GENL", t.getValue());
	}
	
	@Test 
	public void test543_2() {
		messageToParse = "{1:F01FOOBARXXXXXX0000000000}{2:I543FOOOUKPPXXXXN}{4:\n" +
		":16R:GENL\n" +
		":20C::SEME//2004080300000523\n" +
		":23G:NEWM\n" +
		":98A::PREP//20040803\n" +
		":16S:GENL\n" +
		":16R:TRADDET\n" +
		":98A::TRAD//20040801\n" +
		":98A::SETT//20040804\n" +
		":90B::DEAL//ACTU/EUR11,11\n" +
		":35B:ISIN FR1234567890\n" +
		"UKUKUK SA\n" +
		":70E::SPRO//2222\n" +
		":16S:TRADDET\n" +
		":16R:FIAC\n" +
		":36B::SETT//UNIT/1000,00\n" +
		":97A::SAFE//0655015035\n" +
		":16S:FIAC\n" +
		":16R:SETDET\n" +
		":22F::SETR//TRAD\n" +
		":16R:SETPRTY\n" +
		":95R::REAG/SICV/2222\n" +
		":16S:SETPRTY\n" +
		":16R:SETPRTY\n" +
		":95P::BUYR//FOOOUKPP\n" +
		":97A::SAFE//0655093044\n" +
		":16S:SETPRTY\n" +
		":16R:SETPRTY\n" +
		":95P::PSET//SICVUKPP\n" +
		":16S:SETPRTY\n" +
		":16R:AMT\n" +
		":19A::SETT//EUR11111,00\n" +
		":16S:AMT\n" +
		":16S:SETDET\n" +
		"-}";
		assertEquals("543", (parseMessage(messageToParse)).getType());
		assertEquals("F01FOOBARXXXXXX0000000000", b1.getBlockValue());
		assertEquals("I543FOOOUKPPXXXXN", b2.getBlockValue());
		assertEquals(32, b4.countAll());
	}
	
	@Test 
	public void test543_3() {
		messageToParse = "{1:F01FOOBARXXXXXX0000000000}{2:I543FOOOARPPXXXXN}{4:\n" +
		":16R:GENL\n" +
		":20C::SEME//2005071100000156\n" +
		":23G:NEWM\n" +
		":98A::PREP//11111111\n" +
		":16S:GENL\n" +
		":16R:TRADDET\n" +
		":98A::TRAD//11111111\n" +
		":98A::SETT//11111111\n" +
		":90B::DEAL//ACTU/EUR22,22\n" +
		":35B:ISIN AR1234567890\n" +
		"FOOO\n" +
		":70E::SPRO//123\n" +
		":16S:TRADDET\n" +
		":16R:FIAC\n" +
		":36B::SETT//UNIT/333,00\n" +
		":97A::SAFE//0655013333\n" +
		":16S:FIAC\n" +
		":16R:SETDET\n" +
		":22F::SETR//TRAD\n" +
		":16R:SETPRTY\n" +
		":95R::REAG/SICV/444\n" +
		":16S:SETPRTY\n" +
		":16R:SETPRTY\n" +
		":95P::BUYR//FOOANL2A\n" +
		":97A::SAFE//223602590\n" +
		":16S:SETPRTY\n" +
		":16R:SETPRTY\n" +
		":95P::PSET//SICVARPP\n" +
		":16S:SETPRTY\n" +
		":16R:AMT\n" +
		":19A::SETT//EUR8888,88\n" +
		":16S:AMT\n" +
		":16S:SETDET\n" +
		"-}";
		assertEquals("543", (parseMessage(messageToParse)).getType());
		assertEquals("F01FOOBARXXXXXX0000000000", b1.getBlockValue());
		assertEquals("I543FOOOARPPXXXXN", b2.getBlockValue());
		assertEquals(32, b4.countAll());
	}
	
	@Test 
	public void test543_4() {
		messageToParse = "{1:F01FOOBARXXXXXX0000000000}{2:I543FOOOPRPPXXXXN}{4:\n" +
		":16R:GENL\n" +
		":20C::SEME//2005071400000574\n" +
		":23G:NEWM\n" +
		":98A::PREP//20050714\n" +
		":16S:GENL\n" +
		":16R:TRADDET\n" +
		":98A::TRAD//20050713\n" +
		":98A::SETT//20050718\n" +
		":90B::DEAL//ACTU/EUR9,99\n" +
		":35B:ISIN PR1234567890\n" +
		"FOOBAR SA\n" +
		":70E::SPRO//4444\n" +
		":16S:TRADDET\n" +
		":16R:FIAC\n" +
		":36B::SETT//UNIT/500,00\n" +
		":97A::SAFE//0655015035\n" +
		":16S:FIAC\n" +
		":16R:SETDET\n" +
		":22F::SETR//TRAD\n" +
		":16R:SETPRTY\n" +
		":95R::REAG/SICV/4444\n" +
		":16S:SETPRTY\n" +
		":16R:SETPRTY\n" +
		":95P::BUYR//FOOOPRPP\n" +
		":97A::SAFE//0655093044\n" +
		":16S:SETPRTY\n" +
		":16R:SETPRTY\n" +
		":95P::PSET//SICVPRPP\n" +
		":16S:SETPRTY\n" +
		":16R:AMT\n" +
		":19A::SETT//EUR4999,00\n" +
		":16S:AMT\n" +
		":16S:SETDET\n" +
		"-}";
		assertEquals("543", (parseMessage(messageToParse)).getType());
		assertEquals("F01FOOBARXXXXXX0000000000", b1.getBlockValue());
		assertEquals("I543FOOOPRPPXXXXN", b2.getBlockValue());
		assertEquals(32, b4.countAll());
	}
	
	@Test 
	public void test543_5() {
		messageToParse = "{1:F01FOOBARXXXXXX0000000000}{2:I543FOOOUS33XASTN}{4:\n" +
		":16R:GENL\n" +
		":20C::SEME//B070905000173\n" +
		":23G:NEWM\n" +
		":98A::PREP//20020908\n" +
		":16S:GENL\n" +
		":16R:TRADDET\n" +
		":98A::TRAD//20020906\n" +
		":98A::SETT//20020909\n" +
		":90B::DEAL//ACTU/USD3,33\n" +
		":35B:ISIN CA1234567890\n" +
		"NORFOO NETW\n" +
		":16S:TRADDET\n" +
		":16R:FIAC\n" +
		":36B::SETT//UNIT/3666,66\n" +
		":97A::SAFE//096373\n" +
		":16S:FIAC\n" +
		":16R:SETDET\n" +
		":22F::SETR//TRAD\n" +
		":16R:SETPRTY\n" +
		":95R::REAG/DTCYID/050\n" +
		":16S:SETPRTY\n" +
		":16R:SETPRTY\n" +
		":95P::BUYR//MSNYUS44\n" +
		":16S:SETPRTY\n" +
		":16R:SETPRTY\n" +
		":95P::PSET//DTCYUS44\n" +
		":16S:SETPRTY\n" +
		":16R:AMT\n" +
		":19A::SETT//USD12345,56\n" +
		":16S:AMT\n" +
		":16S:SETDET\n" +
		"-}";
		assertEquals("543", (parseMessage(messageToParse)).getType());
		assertEquals("F01FOOBARXXXXXX0000000000", b1.getBlockValue());
		assertEquals("I543FOOOUS33XASTN", b2.getBlockValue());
		assertEquals(30, b4.countAll());
	}
	
}
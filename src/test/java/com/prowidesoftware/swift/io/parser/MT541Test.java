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
 * MT541 tests
 *
 * @since 4.0
 */
public class MT541Test extends BaseMessageTestcase {
	
	@Test 
	public void test541_1() {
		messageToParse = "{1:F01FOOBARXXXXXX1234123456}{2:I541FOOOFRPPXXXXN}{4:\n" +
			":16R:GENL\n" +
			":20C::SEME//2005080800000944\n" +
			":23G:NEWM\n" +
			":98A::PREP//20050808\n" +
			":16S:GENL\n" +
			":16R:TRADDET\n" +
			":98A::TRAD//20050803\n" +
			":98A::SETT//20050808\n" +
			":90B::DEAL//ACTU/EUR11,11\n" +
			":35B:ISIN FR1234567111\n" +
			"FRA.FOOOBAR\n" +
			":70E::SPRO//4042\n" +
			":16S:TRADFOO\n" +
			":16R:FIAC\n" +
			":36B::SETT//UNIT/1000,00\n" +
			":97A::SAFE//123456789\n" +
			":16S:FIAC\n" +
			":16R:SETDET\n" +
			":22F::SETR//TRAD\n" +
			":16R:SETPRTY\n" +
			":95R::DEAG/FOOV/1234\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::SELL//FOOOFRPP\n" +
			":97A::SAFE//123456789\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::PSET//FOOVFRPP\n" +
			":16S:SETPRTY\n" +
			":16R:AMT\n" +
			":19A::SETT//EUR123456,50\n" +
			":16S:AMT\n" +
			":16S:SETDET\n" +
			"-}"; 
		
		assertEquals("541", (parseMessage(messageToParse)).getType());
		
		//check b1
		assertEquals("F01FOOBARXXXXXX1234123456", b1.getBlockValue());
		assertEquals("F", b1.getApplicationId());
		assertEquals("01", b1.getServiceId());
		assertEquals("FOOBARXXXXXX", b1.getLogicalTerminal());
		assertEquals("1234", b1.getSessionNumber());
		assertEquals("123456", b1.getSequenceNumber());
		
		//check b2
		assertEquals("I541FOOOFRPPXXXXN", b2.getBlockValue());
		assertEquals("541", ((SwiftBlock2Input)b2).getMessageType());
		assertEquals("FOOOFRPPXXXX", ((SwiftBlock2Input)b2).getReceiverAddress());	
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
		assertEquals(":SEME//2005080800000944", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("23G", t.getName());
		assertEquals("NEWM", t.getValue());
				
		t = (Tag) b4Tags.get(pos++);
		assertEquals("98A", t.getName());
		assertEquals(":PREP//20050808", t.getValue());
				
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16S", t.getName());
		assertEquals("GENL", t.getValue());
				
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16R", t.getName());
		assertEquals("TRADDET", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("98A", t.getName());
		assertEquals(":TRAD//20050803", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("98A", t.getName());
		assertEquals(":SETT//20050808", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("90B", t.getName());
		assertEquals(":DEAL//ACTU/EUR11,11", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("35B", t.getName());
		assertEquals("ISIN FR1234567111\n" + "FRA.FOOOBAR", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("70E", t.getName());
		assertEquals(":SPRO//4042", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16S", t.getName());
		assertEquals("TRADFOO", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16R", t.getName());
		assertEquals("FIAC", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("36B", t.getName());
		assertEquals(":SETT//UNIT/1000,00", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("97A", t.getName());
		assertEquals(":SAFE//123456789", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16S", t.getName());
		assertEquals("FIAC", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16R", t.getName());
		assertEquals("SETDET", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("22F", t.getName());
		assertEquals(":SETR//TRAD", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16R", t.getName());
		assertEquals("SETPRTY", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("95R", t.getName());
		assertEquals(":DEAG/FOOV/1234", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16S", t.getName());
		assertEquals("SETPRTY", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16R", t.getName());
		assertEquals("SETPRTY", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("95P", t.getName());
		assertEquals(":SELL//FOOOFRPP", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("97A", t.getName());
		assertEquals(":SAFE//123456789", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16S", t.getName());
		assertEquals("SETPRTY", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16R", t.getName());
		assertEquals("SETPRTY", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("95P", t.getName());
		assertEquals(":PSET//FOOVFRPP", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16S", t.getName());
		assertEquals("SETPRTY", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16R", t.getName());
		assertEquals("AMT", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("19A", t.getName());
		assertEquals(":SETT//EUR123456,50", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16S", t.getName());
		assertEquals("AMT", t.getValue());
		
		t = (Tag) b4Tags.get(pos++);
		assertEquals("16S", t.getName());
		assertEquals("SETDET", t.getValue());
	}
	
	@Test 
	public void test541_2() {
		messageToParse = "{1:F01FOOBARXXXXXX0000000000}{2:I541FOOOFRPPXXXXN}{4:\n" +
			":16R:GENL\n" +
			":20C::SEME//2002071500000614\n" +
			":23G:NEWM\n" +
			":98A::PREP//20020715\n" +
			":16S:GENL\n" +
			":16R:TRADDET\n" +
			":98A::TRAD//20020713\n" +
			":98A::SETT//20020718\n" +
			":90B::DEAL//ACTU/EUR22,22\n" +
			":35B:ISIN FR1234567890\n" +
			"FOO DE FRAN\n" +
			":70E::SPRO//1234\n" +
			":16S:TRADDET\n" +
			":16R:FIAC\n" +
			":36B::SETT//UNIT/321,00\n" +
			":97A::SAFE//123456789\n" +
			":16S:FIAC\n" +
			":16R:SETDET\n" +
			":22F::SETR//TRAD\n" +
			":16R:SETPRTY\n" +
			":95R::DEAG/SICV/4042\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::SELL//FOOOFRPP\n" +
			":97A::SAFE//123456789\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::PSET//SICVFRPP\n" +
			":16S:SETPRTY\n" +
			":16R:AMT\n" +
			":19A::SETT//EUR123456,78\n" +
			":16S:AMT\n" +
			":16S:SETDET\n" +
			"-}";
		assertEquals("541", (parseMessage(messageToParse)).getType());
		assertEquals("F01FOOBARXXXXXX0000000000", b1.getBlockValue());
		assertEquals("I541FOOOFRPPXXXXN", b2.getBlockValue());
		assertEquals(32, b4.countAll());
	}
	
	@Test 
	public void test541_3() {
		messageToParse = "{1:F01FOOBARXXXXXX4321654321}{2:I541FOOOARPPXXXXN}{4:\n" +
			":16R:GENL\n" +
			":20C::SEME//2007071800000923\n" +
			":23G:NEWM\n" +
			":98A::PREP//20070718\n" +
			":16S:GENL\n" +
			":16R:TRADDET\n" +
			":98A::TRAD//20070714\n" +
			":98A::SETT//20070719\n" +
			":90B::DEAL//ACTU/EUR12,34\n" +
			":35B:ISIN FR1234567890\n" +
			"FOO UAP\n" +
			":70E::SPRO//4321\n" +
			":16S:TRADDET\n" +
			":16R:FIAC\n" +
			":36B::SETT//UNIT/222,22\n" +
			":97A::SAFE//123456789\n" +
			":16S:FIAC\n" +
			":16R:SETDET\n" +
			":22F::SETR//TRAD\n" +
			":16R:SETPRTY\n" +
			":95R::DEAG/SICV/4321\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::SELL//FOOOARPP\n" +
			":97A::SAFE//123456789\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::PSET//SICVARPP\n" +
			":16S:SETPRTY\n" +
			":16R:AMT\n" +
			":19A::SETT//EUR123456,78\n" +
			":16S:AMT\n" +
			":16S:SETDET\n" +
			"-}";
		assertEquals("541", (parseMessage(messageToParse)).getType());
		assertEquals("F01FOOBARXXXXXX4321654321", b1.getBlockValue());
		assertEquals("I541FOOOARPPXXXXN", b2.getBlockValue());
		assertEquals(32, b4.countAll());
	}
	
	@Test 
	public void test541_4() {
		messageToParse = "{1:F01FOOBARXXXXXX1234123456}{2:I541FOOODEFFXCUSN}{4:\n" +
			":16R:GENL\n" +
			":20C::SEME//2001071800001228\n" +
			":23G:NEWM\n" +
			":98A::PREP//20010718\n" +
			":16S:GENL\n" +
			":16R:TRADDET\n" +
			":98A::TRAD//20010713\n" +
			":98A::SETT//20010715\n" +
			":90B::DEAL//ACTU/EUR8,88\n" +
			":35B:ISIN DE1234567890\n" +
			"FOOO CREATI\n" +
			":16S:TRADDET\n" +
			":16R:FIAC\n" +
			":36B::SETT//UNIT/6666,66\n" +
			":97A::SAFE//123456789\n" +
			":16S:FIAC\n" +
			":16R:SETDET\n" +
			":22F::SETR//TRAD\n" +
			":16R:SETPRTY\n" +
			":95R::DEAG/AAKV/9876\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::SELL//AAKVDEFF\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::PSET//AAKVDEFF\n" +
			":16S:SETPRTY\n" +
			":16R:AMT\n" +
			":19A::SETT//EUR123456,78\n" +
			":16S:AMT\n" +
			":16S:SETDET\n" +
			"-}";
		assertEquals("541", (parseMessage(messageToParse)).getType());
		assertEquals("F01FOOBARXXXXXX1234123456", b1.getBlockValue());
		assertEquals("I541FOOODEFFXCUSN", b2.getBlockValue());
		assertEquals(30, b4.countAll());
	}
	
	@Test 
	public void test541_5() {
		messageToParse = "{1:F01FOOBARXXXXXX0000000000}{2:I541FOOOUS33XASTN}{4:\n" +
			":16R:GENL\n" +
			":20C::SEME//2005071300000248\n" +
			":23G:NEWM\n" +
			":98A::PREP//20050713\n" +
			":16S:GENL\n" +
			":16R:TRADDET\n" +
			":98A::TRAD//20050708\n" +
			":98A::SETT//20050713\n" +
			":90B::DEAL//ACTU/USD18,81\n" +
			":35B:ISIN US1234567890\n" +
			"FOOOO SYS\n" +
			":70E::SPRO//050\n" +
			":16S:TRADDET\n" +
			":16R:FIAC\n" +
			":36B::SETT//UNIT/1234,00\n" +
			":97A::SAFE//123456789\n" +
			":16S:FIAC\n" +
			":16R:SETDET\n" +
			":22F::SETR//TRAD\n" +
			":16R:SETPRTY\n" +
			":95R::DEAG/DTCYID/050\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::SELL//MSNYUS11\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::PSET//DTCYUS11\n" +
			":16S:SETPRTY\n" +
			":16R:AMT\n" +
			":19A::SETT//EUR123456,78\n" +
			":16S:AMT\n" +
			":16S:SETDET\n" +
			"-}";
		assertEquals("541", (parseMessage(messageToParse)).getType());
		assertEquals("F01FOOBARXXXXXX0000000000", b1.getBlockValue());
		assertEquals("I541FOOOUS33XASTN", b2.getBlockValue());
		assertEquals(31, b4.countAll());
	}
	
}

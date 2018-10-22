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

import java.util.List;

import org.junit.Test;

import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;

/**
 * MT564 tests
 *
 * @since 4.0
 */
public class MT564Test extends BaseMessageTestcase {
	
	@Test 
	public void test564_1() {
		final String msg = "{1:F01MTGSUS6SAXXX3206837054}{2:O5641435070316CHASGB2LDGST07128160300703160735N}{3:{108:000255CQ8272245}}{4:\n" + 
				":16R:GENL\n" + 
				":20C::CORP//D455103\n" + 
				":20C::SEME//029206016\n" + 
				":23G:NEWM\n" + 
				":22F::CAEV//DVCA\n" + 
				":22F::CAMV//MAND\n" + 
				":98C::PREP//20070316143348\n" + 
				":25D::PROC//COMP\n" + 
				":16S:GENL\n" + 
				":16R:USECU\n" + 
				":35B:ISIN CH0011075394\n" + 
				"/XX/5983816\n" + 
				"ZURICH FIN SVS GRP\n" + 
				"CHF0.10\n" + 
				":16R:ACCTINFO\n" + 
				":97A::SAFE//760043140\n" + 
				":94F::SAFE//CUST/UBSWCHZH80A\n" + 
				":93B::ELIG//UNIT/7000,\n" + 
				":16S:ACCTINFO\n" + 
				":16S:USECU\n" + 
				":16R:CADETL\n" + 
				":98A::XDTE//20111111\n" + 
				":98A::PAYD//20111111\n" + 
				":98A::RDTE//20111111\n" + 
				":92A::WITF//35,\n" + 
				":92A::GRSS//0,000001000\n" + 
				":16S:CADETL\n" + 
				":16R:CAOPTN\n" + 
				":13A::CAON//001\n" + 
				":22F::CAOP//CASH\n" + 
				":11A::OPTN//CHF\n" + 
				":17B::DFLT//Y\n" + 
				":98A::XDTE//20111111\n" + 
				":98A::PAYD//20111111\n" + 
				":98A::RDTE//20111111\n" + 
				":92A::GRSS//0,000001000\n" + 
				":16R:CASHMOVE\n" + 
				":22H::CRDB//CRED\n" + 
				":19B::ENTL//CHF0,01\n" + 
				":19B::GRSS//CHF0,01\n" + 
				":19B::NETT//CHF0,01\n" + 
				":98A::PAYD//20111111\n" + 
				":98A::VALU//20111111\n" + 
				":16S:CASHMOVE\n" + 
				":16S:CAOPTN\n" +
				"-}";
		SwiftMessage o = parseMessage(msg);
		assertEquals(6, o.getBlock4().countByName("16R"));

		Tag[] blocks = o.getBlock4().getTagsByName("16R");
		List<Tag> b4Tags = o.getBlock4().getTags();
		
		// Check first and last subblocks
		int pos = b4Tags.indexOf(blocks[0]);
		Tag t = (Tag) b4Tags.get(pos+1);
		assertEquals("20C", t.getName());
		assertEquals(":CORP//D455103", t.getValue());
		t = (Tag) b4Tags.get(pos+2);
		assertEquals("20C", t.getName());
		assertEquals(":SEME//029206016", t.getValue());
		
		
		// Last sub block
		pos = b4Tags.indexOf(blocks[5]);

		t = (Tag) b4Tags.get(++pos);
		assertEquals("22H", t.getName());
		assertEquals(":CRDB//CRED", t.getValue());

		t = (Tag) b4Tags.get(++pos);
		assertEquals("19B", t.getName());
		assertEquals(":ENTL//CHF0,01", t.getValue());

		t = (Tag) b4Tags.get(++pos);
		assertEquals("19B", t.getName());
		assertEquals(":GRSS//CHF0,01", t.getValue());

		t = (Tag) b4Tags.get(++pos);
		assertEquals("19B", t.getName());
		assertEquals(":NETT//CHF0,01", t.getValue());

		t = (Tag) b4Tags.get(++pos);
		assertEquals("98A", t.getName());
		assertEquals(":PAYD//20111111", t.getValue());

		t = (Tag) b4Tags.get(++pos);
		assertEquals("98A", t.getName());
		assertEquals(":VALU//20111111", t.getValue());
	}
	
	/**
	 * Message posted https://sourceforge.net/forum/message.php?msg_id=4248618
	 */
	@Test 
	public void test564_2() {
		messageToParse = "{1:F01MTGSUS6SAXXX3206837054}{2:O5641435070316CHASGB2LDGST07128160300703160735N}{3:{108:000255CQ8272245}}{4:\n" +
			":16R:GENL\n" +
			":20C::CORP//D455103\n" +
			":20C::SEME//029206016\n" +
			":23G:NEWM\n" +
			":22F::CAEV//DVCA\n" +
			":22F::CAMV//MAND\n" +
			":98C::PREP//20070316143348\n" +
			":25D::PROC//COMP\n" +
			":16S:GENL\n" +
			":16R:USECU\n" +
			":35B:ISIN CH0011075394\n" +
			"/XX/5983816\n" +
			"ZURICH FIN SVS GRP\n" +
			"CHF0.10\n" +
			":16R:ACCTINFO\n" +
			":97A::SAFE//760043140\n" +
			":94F::SAFE//CUST/UBSWCHZH80A\n" +
			":93B::ELIG//UNIT/7000,\n" +
			":16S:ACCTINFO\n" +
			":16S:USECU\n" +
			":16R:CADETL\n" +
			":98A::XDTE//20111111\n" +
			":98A::PAYD//20111111\n" +
			":98A::RDTE//20111111\n" +
			":92A::WITF//35,\n" +
			":92A::GRSS//0,000001000\n" +
			":16S:CADETL\n" +
			":16R:CAOPTN\n" +
			":13A::CAON//001\n" +
			":22F::CAOP//CASH\n" +
			":11A::OPTN//CHF\n" +
			":17B::DFLT//Y\n" +
			":98A::XDTE//20111111\n" +
			":98A::PAYD//20111111\n" +
			":98A::RDTE//20111111\n" +
			":92A::GRSS//0,000001000\n" +
			":16R:CASHMOVE\n" +
			":22H::CRDB//CRED\n" +
			":19B::ENTL//CHF0,01\n" +
			":19B::GRSS//CHF0,01\n" +
			":19B::NETT//CHF0,01\n" +
			":98A::PAYD//20111111\n" +
			":98A::VALU//20111111\n" +
			":16S:CASHMOVE\n" +
			":16S:CAOPTN\n" +
			"-}";
		assertEquals("564", (parseMessage(messageToParse)).getType());
		assertEquals("F01MTGSUS6SAXXX3206837054", b1.getBlockValue());
		assertEquals("O5641435070316CHASGB2LDGST07128160300703160735N", b2.getBlockValue());
		assertEquals(42, b4.countAll());
	}
	
	@Test 
	public void test564_3() {
		messageToParse = "{1:F01MIDLGB22XJAC0000000000}{2:O5640601101117HKBAAU2SXSYD00000000001011160601N}{3:{108:103200583375}}{4:\n" +
			":16R:GENL\n" +
			":20C::CORP//123456\n" +
			":20C::SEME//FOOLLFIXIT2\n" +
			":23G:NEWM\n" +
			":22F::CAEV//RHDI\n" +
			":22F::CAMV//MAND\n" +
			":98A::PREP//20101117\n" +
			":25D::PROC//PREC\n" +
			":16R:LINK\n" +
			":22F::LINK//AFTE\n" +
			":13A::LINK//564\n" +
			":20C::PREV//123757326622300\n" +
			":16S:LINK\n" +
			":16S:GENL\n" +
			":16R:USECU\n" +
			":35B:ISIN AU000000SFR8\n" +
			"SANDFIRE RESOURCES NL\n" +
			":16R:ACCTINFO\n" +
			":97A::SAFE//011-176591-061\n" +
			":93B::SETT//UNIT/14586,\n" +
			":16S:ACCTINFO\n" +
			":16S:USECU\n" +
			":16R:CADETL\n" +
			":98A::ANOU//20101116\n" +
			":98B::XDTE//UKWN\n" +
			":98A::EXPI//20101208\n" +
			":98B::MKDT//UKWN\n" +
			":98A::SUBS//20101208\n" +
			":98B::RDDT//UKWN\n" +
			":98A::RDTE//20101119\n" +
			":90B::PRPP//ACTU/AUD6,6\n" +
			":22F::RHDI//EXRI\n" +
			":16S:CADETL\n" +
			":16R:CAOPTN\n" +
			":13A::CAON//001\n" +
			":22F::CAOP//SECU\n" +
			":22F::DISF//RDDN\n" +
			":17B::DFLT//Y\n" +
			":35B:/AU/+SFRRZ\n" +
			"FOO RESOURCES NON R RTS\n" +
			":98B::AVAL//UKWN\n" +
			":98A::PAYD//20101122\n" +
			":92D::ADEX//1,/12,\n" +
			":16S:CAOPTN\n" +
			":16R:ADDINFO\n" +
			":70E::ADTX//.\n" +
			":95Q::MERE//ATT: LEE FOO\n" +
			":16S:ADDINFO\n" +
			"-}{5:{CHK:000000000000}}";
		
		assertEquals("564", (parseMessage(messageToParse)).getType());
		assertEquals(":SETT//UNIT/14586,", b4.getTagValue("93B"));
		
		b4.getTagByName("93B").setValue(":SETT//UNIT/0000,");
		assertEquals(":SETT//UNIT/0000,", b4.getTagValue("93B"));
	}
	
}

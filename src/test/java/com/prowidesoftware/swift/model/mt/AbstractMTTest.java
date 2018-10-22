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

package com.prowidesoftware.swift.model.mt;

import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.field.Field32A;
import com.prowidesoftware.swift.model.field.Field35B;
import com.prowidesoftware.swift.model.mt.mt1xx.MT102;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103_STP;
import com.prowidesoftware.swift.model.mt.mt2xx.MT202;
import com.prowidesoftware.swift.model.mt.mt2xx.MT202COV;
import com.prowidesoftware.swift.model.mt.mt5xx.MT547;
import com.prowidesoftware.swift.model.mt.mt5xx.MT549;
import com.prowidesoftware.swift.model.mt.mt9xx.MT940;
import com.prowidesoftware.swift.utils.TestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import com.prowidesoftware.swift.model.field.Field;

import static org.junit.Assert.*;

public class AbstractMTTest {

	@Test
	public void testGetSequence() {
		SwiftMessage m = new MT102().append(MT102.SequenceA.newInstance(Field32A.tag("foo"))).getSwiftMessage();
		TestUtils.append(m, MT102.SequenceB.newInstance(Field32A.tag("bar")));
		AbstractMT o = m.toMT();
		SwiftTagListBlock A = o.getSequence("A");
		assertNotNull("Expected A but got null", A);
		assertEquals(3, A.size());
		assertEquals("foo", A.getTag(1).getValue());
	}
	
	@Test
	public void testGetSequenceList() {
		SwiftMessage m = new MT102().append(
				MT102.SequenceA.newInstance(Field32A.tag("foo"))
				.append(MT102.SequenceB.newInstance(Field32A.tag("bar")))
				.append(MT102.SequenceB.newInstance(Field32A.tag("bar1"), Field32A.tag("bar2")))
				).getSwiftMessage();
		AbstractMT o = m.toMT();
		List<SwiftTagListBlock> Bs = o.getSequenceList("B");
		assertNotNull(Bs);
		assertEquals(2, Bs.size());
		assertEquals(3, Bs.get(0).size());
		assertEquals(4, Bs.get(1).size());
		assertEquals("bar", Bs.get(0).getTag(1).getValue());
		assertEquals("bar1", Bs.get(1).getTag(1).getValue());
		assertEquals("bar2", Bs.get(1).getTag(2).getValue());
	}
	
	@Test
	public void test_conversin_to_xml() {
		String fin = "{1:F01FMACUS33AXXX1625159979}{2:O5471302141113CHASUSU9AXXX05821058501411131302N}{3:{108:001823CQ1833911}}{4:\n" +
			":16R:GENL\n" +
			":20C::SEME//T314314CDM0\n" +
			":23G:NEWM\n" +
			":98E::PREP//20141113130218/N05\n" +
			":16R:LINK\n" +
			":20C::RELA//00013507299330A\n" +
			":16S:LINK\n" +
			":16S:GENL\n" +
			":16R:TRADDET\n" +
			":98A::TRAD//20141107\n" +
			":98A::ESET//20141113\n" +
			":98A::SETT//20141113\n" +
			":90A::DEAL//PRCT/102,713552\n" +
			":35B:/US/3132MAD40\n" +
			"FOO MORTPASS 3.5+ 01/NOV/2044\n" +
			"Q2 PN+ Q29423\n" +
			":16S:TRADDET\n" +
			":16R:FIAC\n" +
			":36B::ESTT//AMOR/7999999,573\n" +
			":36B::ESTT//FAMT/8167548,\n" +
			":97A::SAFE//P 61947\n" +
			":16S:FIAC\n" +
			":16R:SETDET\n" +
			":22F::SETR//TRAD\n" +
			":16R:SETPRTY\n" +
			":95R::REAG/USFW/021000021\n" +
			":97A::SAFE//FBCMBS\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95R::BUYR/DTCYID/00355\n" +
			":16S:SETPRTY\n" +
			":16R:SETPRTY\n" +
			":95P::PSET//FRNYUS33\n" +
			":16S:SETPRTY\n" +
			":16R:AMT\n" +
			":19A::DEAL//USD8217083,72\n" +
			":16S:AMT\n" +
			":16R:AMT\n" +
			":19A::ACRU//USD9333,33\n" +
			":16S:AMT\n" +
			":16R:AMT\n" +
			":19A::ESTT//USD8226417,05\n" +
			":16S:AMT\n" +
			":16S:SETDET\n" +
			":16R:OTHRPRTY\n" +
			":95P::MEOR//CHASUS33\n" +
			":16S:OTHRPRTY\n" +
			"-}";
		MT547 mt = new MT547(fin);
		String xml = mt.xml();
		assertTrue(StringUtils.contains(xml, "<logicalTerminal>FMACUS33AXXX</logicalTerminal>"));
		assertTrue(StringUtils.contains(xml, "<block2 type=\"output\">"));
		assertTrue(StringUtils.contains(xml, "<MIRLogicalTerminal>CHASUSU9AXXX</MIRLogicalTerminal>"));
		assertTrue(StringUtils.contains(xml, "<component number=\"1\">GENL</component>"));
		assertTrue(StringUtils.contains(xml, "<name>20C</name>"));
	}
	
	@Test
	public void testParsingSystemMessage() throws IOException {
		final String msg = "{1:F21OMFNCIABAXXX6368087500}{4:{177:1511041614}{451:0}}{1:F01OMFNCIABAXXX6368087500}{2:O1031542151104BCAOSNDPAXXX22438129121511041542N}{3:{113:0030}{108:001RTGS153030005}}{4:\n"+
			":20:1234567890\n"+
			":23B:CRED\n"+
			":23E:SDVA\n"+
			":26T:001\n"+
			":32A:151104XOF27000000,\n"+
			":50K:/0020121503484101\n"+
			"FOO VORYEAUGEIS\n"+
			":53A:/D/D00030901\n"+
			"ECOCMLBA\n"+
			":57A:/C/A00031061\n"+
			"OMFNCIAB\n"+
			":59:/010010100100014010010160\n"+
			"FOO VOYAGES\n"+
			":70:TRANSFERT\n"+
			":71A:SHA\n"+
			":72:/CODTYPTR/001\n"+
			"//REGLEMENT\n"+
			"-}{5:{MAC:00000000}{CHK:0AF226411593}}{S:{SPD:}{SAC:}{COP:P}}";
		
		AbstractMT asm = AbstractMT.parse(msg);
		assertNotNull(asm);
		assertTrue(asm.getSwiftMessage().isServiceMessage());
	}
	
	@Test
	public void testNameFromClass103() throws Exception {
		assertEquals("103", new MT103().nameFromClass());
	}

	@Test
	public void testNameFromClass202COV() throws Exception {
		assertEquals("202COV", new MT202COV().nameFromClass());
	}
	
	@Test
	public void testMtId() throws Exception {
		assertEquals("fin.202.COV", new MT202COV().getMtId().id());
		assertEquals("fin.202", new MT202().getMtId().id());
		assertEquals("fin.103.STP", new MT103_STP().getMtId().id());
		assertEquals("fin.103", new MT103().getMtId().id());
	}

	@Test
	public void testRetrieveFields() throws Exception {
		MT549 mt = new MT549();
		mt.append(new Tag("35B", "ISIN DE000A0AAA09"));
		mt.append(new Tag("35B", "ISIN LU000B0BBB09"));
		for (Tag tag : mt.tags("35B")) {
			Field35B field = (Field35B) tag.asField();
			assertEquals(field.getComponent1(), "ISIN");
		}
	}

	/*
	@Test 
	public void testRemoveInnerSequences1() {
		SwiftTagListBlock s1 = new SwiftTagListBlock();
		s1.append(TestUtils.newSeq("FOO", "20", "20"));
		SwiftTagListBlock s2 = AbstractMT.removeInnerSequences(s1);
		assertEquals(4, s2.size());
		assertEquals(new Tag("16R", "FOO"), s2.getTag(0));
		assertEquals(new Tag("20", ""), s2.getTag(1));
		assertEquals(new Tag("20", ""), s2.getTag(2));
		assertEquals(new Tag("16S", "FOO"), s2.getTag(3));
	}

	@Test 
	public void testRemoveInnerSequences2() {
		SwiftTagListBlock s1 = new SwiftTagListBlock();
		s1.append(new Tag("16R", "ABC"));
		s1.append(new Tag("21", ""));
		s1.append(TestUtils.newSeq("FOO", "20", "20"));
		s1.append(new Tag("21", ""));
		s1.append(new Tag("16S", "ABC"));
		
		SwiftTagListBlock s2 = AbstractMT.removeInnerSequences(s1);
		assertEquals(4, s2.size());
		assertEquals(new Tag("16R", "ABC"), s2.getTag(0));
		assertEquals(new Tag("21", ""), s2.getTag(1));
		assertEquals(new Tag("21", ""), s2.getTag(2));
		assertEquals(new Tag("16S", "ABC"), s2.getTag(3));
	}
	
	@Test 
	public void testRemoveInnerSequences3() {
		SwiftTagListBlock s1 = new SwiftTagListBlock();
		s1.append(new Tag("16R", "ABC"));
		s1.append(new Tag("21", ""));
		s1.append(TestUtils.newSeq("FOO", "20", "20"));
		s1.append(TestUtils.newSeq("FO2", "59", "59"));
		s1.append(new Tag("21", ""));
		s1.append(new Tag("16S", "ABC"));
		
		SwiftTagListBlock s2 = AbstractMT.removeInnerSequences(s1);
		assertEquals(4, s2.size());
		assertEquals(new Tag("16R", "ABC"), s2.getTag(0));
		assertEquals(new Tag("21", ""), s2.getTag(1));
		assertEquals(new Tag("21", ""), s2.getTag(2));
		assertEquals(new Tag("16S", "ABC"), s2.getTag(3));
	}
	*/
	@Test
	public void testGetFields() throws IOException {
		final String msg = "{1:F21OMFNCIABAXXX6368087500}{4:{177:1511041614}{451:0}}{1:F01OMFNCIABAXXX6368087500}{2:O1031542151104BCAOSNDPAXXX22438129121511041542N}{3:{113:0030}{108:001RTGS153030005}}{4:\n" +
				":20:1234567890\n" +
				":23B:CRED\n" +
				":23E:SDVA\n" +
				":26T:001\n" +
				":32A:151104XOF27000000,\n" +
				":50K:/0020121503484101\n" +
				"FOO VORYEAUGEIS\n" +
				":53A:/D/D00030901\n" +
				"ECOCMLBA\n" +
				":57A:/C/A00031061\n" +
				"OMFNCIAB\n" +
				":59:/010010100100014010010160\n" +
				"FOO VOYAGES\n" +
				":70:TRANSFERT\n" +
				":71A:SHA\n" +
				":72:/CODTYPTR/001\n" +
				"//REGLEMENT\n" +
				"-}{5:{MAC:00000000}{CHK:0AF226411593}}{S:{SPD:}{SAC:}{COP:P}}";

		AbstractMT asm = AbstractMT.parse(msg);
		List<Field> fields = asm.getFields();
		assertNotNull(asm);
		assertTrue(fields.size() == 2);
	}

	@Test
	public void testMTClassParse() {
		MT940 mt = MT940.parse("{1:F01ANASCH20AXXX0000000000}{2:I940BSCHGB2LXEQUN}{3:{108:FOOB3926BE868XXX}}{4:\n" +
				":20:123456\n" +
				":25:123-304958\n" +
				":28C:123/1\n" +
				":60F:C980622USD395212311,71\n" +
				":61:980623C50000000,NTRFNONREF//8951234\n" +
				"ORDER BK OF NYC WESTERN CASH RESERVE\n" +
				":61:980625C5700000,NFEX036960//8954321\n" +
				":61:980626C200000,NDIVNONREF//8846543\n" +
				":86:DIVIDEND LORAL CORP\n" +
				"PREFERRED STOCK 1ST QUARTER 1998\n" +
				":62F:C980623USD451112311,71\n" +
				":64:C980623USD445212311,71\n" +
				":65:C980625USD450912311,71\n" +
				":65:C980626USD451112311,71\n" +
				":86:PRIME RATE AS OF TODAY 11 PCT\n" +
				"-}{5:{CHK:3916EF336FF7}}");
		assertEquals(ServiceIdType._01, mt.getSwiftMessage().getBlock1().getServiceIdType());
	}
}

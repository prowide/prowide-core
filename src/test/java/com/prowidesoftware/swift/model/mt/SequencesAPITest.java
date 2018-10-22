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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.field.Field16R;
import com.prowidesoftware.swift.model.field.Field16S;
import com.prowidesoftware.swift.model.field.Field20;
import com.prowidesoftware.swift.model.field.Field21;
import com.prowidesoftware.swift.model.field.Field22F;
import com.prowidesoftware.swift.model.field.Field23A;
import com.prowidesoftware.swift.model.field.Field30;
import com.prowidesoftware.swift.model.field.Field32B;
import com.prowidesoftware.swift.model.field.Field36;
import com.prowidesoftware.swift.model.field.Field59;
import com.prowidesoftware.swift.model.field.Field71G;
import com.prowidesoftware.swift.model.field.Field95P;
import com.prowidesoftware.swift.model.field.Field98A;
import com.prowidesoftware.swift.model.mt.mt1xx.MT101;
import com.prowidesoftware.swift.model.mt.mt1xx.MT101.SequenceA;
import com.prowidesoftware.swift.model.mt.mt1xx.MT101.SequenceB;
import com.prowidesoftware.swift.model.mt.mt1xx.MT104;
import com.prowidesoftware.swift.model.mt.mt3xx.MT360;
import com.prowidesoftware.swift.model.mt.mt5xx.MT564;
import com.prowidesoftware.swift.model.mt.mt6xx.MT670;

/**
 * Main test for MT sequences API
 *
 * @author sebastian@prowidesoftware.com
 * @since 7.7
 */
public class SequencesAPITest {

	@Test
	public void test_01() {
		final MT564 m = new MT564();
		m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
		assertNotNull(m.getSequenceEList());
		assertEquals(1, m.getSequenceEList().size());
	}

	@Test
	public void test_02() {
		final MT564 m = new MT564();
		m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
		assertNotNull(m.getSequenceEList());
		assertEquals(2, m.getSequenceEList().size());
	}

	@Test
	public void test_03() {
		final MT564 m = new MT564();
		m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16R.NAME, MT564.SequenceE1.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE1.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
		assertNotNull(m.getSequenceEList());
		assertEquals(1, m.getSequenceEList().size());
		assertNotNull(m.getSequenceE1List());
		assertEquals(1, m.getSequenceE1List().size());
	}

	@Test
	public void test_04() {
		final MT564 m = new MT564();
		m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16R.NAME, MT564.SequenceE1.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE1.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
		assertNotNull(m.getSequenceEList());
		assertEquals(2, m.getSequenceEList().size());
		assertNotNull(m.getSequenceE1List());
		assertEquals(1, m.getSequenceE1List().size());
	}

	@Test
	public void test_05() {
		final MT564 m = new MT564();
		m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16R.NAME, MT564.SequenceE1.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE1.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16R.NAME, MT564.SequenceE1.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE1.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
		assertNotNull(m.getSequenceEList());
		assertEquals(2, m.getSequenceEList().size());
		assertNotNull(m.getSequenceE1List());
		assertEquals(2, m.getSequenceE1List().size());
	}

	@Test
	public void test_06() {
		final MT564 m = new MT564();
		m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16R.NAME, MT564.SequenceE.START_END_16RS));
		m.append(new Tag(Field16R.NAME, MT564.SequenceE1.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE1.START_END_16RS));
		m.append(new Tag(Field16S.NAME, MT564.SequenceE.START_END_16RS));
		assertNotNull(m.getSequenceEList());
		assertEquals(2, m.getSequenceEList().size());
		assertNotNull(m.getSequenceE1List());
		assertEquals(1, m.getSequenceE1List().size());
		/*
		 * nested call
		 */
		assertEquals(0, MT564.getSequenceE1List(m.getSequenceEList().get(0)).size());
		assertEquals(1, MT564.getSequenceE1List(m.getSequenceEList().get(1)).size());
	}

	@Test
	public void test_07() {
		final String s =
				"{1:F01SWHQBEBBAXXX0001000001}{2:I564SWHQBEBBXBILN}{3:{108:495}}{4:\n" +
						":16R:GENL\n" +
						":20C::SEME//FU00003020000001\n" +
						":20C::CORP//OTHR000000000302\n" +
						":23G:NEWM\n" +
						":22F::CAEV//OTHR\n" +
						":22F::CAMV//MAND\n" +
						":98C::PREP//20141204070253\n" +
						":25D::PROC//PREU\n" +
						":16S:GENL\n" +

		                ":16R:USECU\n" +
		                ":35B:ISIN AT0000A00GJ3\n" +
		                "FOO 322 Euro\n"
		                + " FOO Duration(T)\n" +
		                ":16R:ACCTINFO\n" +
		                ":97C::SAFE//GENR\n" +
		                ":16S:ACCTINFO\n" +
		                ":16S:USECU\n" +

		                ":16R:CADETL\n" +
		                ":98A::EFFD//20150129\n" +
		                ":70G::WEBB//sssss\n" +
		                ":16S:CADETL\n" +

		                ":16R:ADDINFO\n" +
		                ":70E::ADTX//Fondsfusion\n"
		                + " FOO 322 Euro \n"
		                + "FOO Duration\n" +
		                ":70E::TXNR//Raiffeisen \n"
		                + "Kapitalanlage Gesellschaft\n"
		                + " m.b.H. informiert gem.\n"
		                + " Paragraph133 Abs. 1 InvFG\n"
		                + " 2011, dass\n" +
		                ":16S:ADDINFO\n" +
		                "-}";
		final MT564 m = new MT564(s);
		assertEquals(0, m.getSequenceC().size());
		assertEquals(0, MT564.getSequenceC(m.getSwiftMessage().getBlock4()).size());
	}

	@Test
	public void test_NPE() {
		try {
			final MT564 m = new MT564("invalid message");
			m.getSequenceA();
		} catch (NullPointerException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test670_SequenceC() throws Exception {
		MT670 m = new MT670()
				.append(MT670.SequenceA2.newInstance(
						Field95P.tag("SSIR")
						)
						)
				.append(MT670.SequenceB.newInstance(
						MT670.SequenceB2.newInstance(
								Field22F.tag("PMTH")
								))
						);
		assertTrue(m.getSequenceC().isEmpty());
	}
	
	@Test
	public void testMT360() throws Exception {
		MT360 m = new MT360()
				.append(MT360.SequenceA.newInstance(Field23A.tag("FIXEDFIXED")))
				.append(MT360.SequenceB.newInstance())
				.append(MT360.SequenceE.newInstance());
		assertTrue(m.getSequenceC().isEmpty());
		assertTrue(m.getSequenceF().isEmpty());
	}
	
	@Test
	public void testNewSequenceA_MT101() throws Exception {
		MT101 m = new MT101().append(MT101.SequenceA.newInstance(Field98A.emptyTag()));
		SequenceA A = m.getSequenceA();
		assertNotNull(A);
		assertFalse(A.isEmpty());
	}
	
	@Test
	public void testNewSequenceB_MT101() throws Exception {
		MT101 m = new MT101().append(MT101.SequenceB.newInstance(Field98A.emptyTag()));
		List<SequenceB> Bs = m.getSequenceBList();
		assertEquals(1, Bs.size());
	}
	
	@Test
	public void test104_SequenceC() throws Exception {
		MT104 m = new MT104()
				.append(MT104.SequenceA.newInstance(
						Field20.tag("FOO"),
						Field30.tag("FOO")
						))
				.append(MT104.SequenceB.newInstance(
						Field21.tag("FOO"),
						Field32B.tag("FOO"),
						Field59.tag("FOO"),
						Field36.tag("FOO")
						))
				.append(Field32B.tag("FOO"), Field71G.tag("FOO"));
		assertFalse(m.getSequenceC().isEmpty());
		assertEquals(2, m.getSequenceC().size());
		assertEquals(Field32B.NAME, m.getSequenceC().getTag(0).getName());
		assertEquals(Field71G.NAME, m.getSequenceC().getTag(1).getName());
	}
}

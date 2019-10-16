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
package com.prowidesoftware.swift.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.prowidesoftware.swift.model.field.Field13A;
import com.prowidesoftware.swift.model.field.Field13B;
import com.prowidesoftware.swift.model.field.Field13C;
import com.prowidesoftware.swift.model.field.Field15A;
import com.prowidesoftware.swift.model.field.Field15B;
import com.prowidesoftware.swift.model.field.Field15C;
import com.prowidesoftware.swift.model.field.Field15D;
import com.prowidesoftware.swift.model.field.Field16R;
import com.prowidesoftware.swift.model.field.Field16S;
import com.prowidesoftware.swift.model.field.Field32A;
import com.prowidesoftware.swift.model.field.Field32B;
import com.prowidesoftware.swift.model.field.Field33A;
import com.prowidesoftware.swift.model.field.Field34B;
import com.prowidesoftware.swift.model.mt.mt5xx.MT502;
import com.prowidesoftware.swift.model.mt.mt5xx.MT535;

public class SwiftMessageUtilsTest {

	@Test
	public void testSplitByField15() {
		final SwiftMessage sm = new SwiftMessage(true);
		sm.getBlock4().append(Field15B.emptyTag())
		.append(Field32A.emptyTag());
		final Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(sm);
		assertNotNull(map);
		assertTrue(map.containsKey("B"));
		final SwiftTagListBlock list = map.get("B");
		assertNotNull(list);
		assertEquals(2, list.size());
	}

	@Test
	public void testSplitByField15LetterOption() {
		final SwiftMessage sm = new SwiftMessage(true);
		sm.getBlock4()
		        .append(Field15A.emptyTag())
		        .append(Field33A.emptyTag())

		        .append(Field15B.emptyTag())
		        .append(Field32A.emptyTag())

		        .append(Field15B.emptyTag())
		        .append(Field32B.emptyTag())
		        .append(Field32B.emptyTag());

		List<SwiftTagListBlock> Bs = SwiftMessageUtils.splitByField15(sm, "B");
		assertNotNull(Bs);
		assertEquals(2, Bs.size());

		final SwiftTagListBlock list0 = Bs.get(0);
		assertNotNull(list0);
		assertEquals(2, list0.size());

		final SwiftTagListBlock list1 = Bs.get(1);
		assertNotNull(list1);
		assertEquals(3, list1.size());
	}

	@Test
	public void testSplitByField15LetterOptionIntercalado() {
		final SwiftMessage sm = new SwiftMessage(true);
		sm.getBlock4()
		        .append(Field15A.emptyTag())
		        .append(Field33A.emptyTag())

		        .append(Field15B.emptyTag())

		        .append(Field15C.emptyTag())
		        .append(Field32A.emptyTag())

		        .append(Field15B.emptyTag())
		        .append(Field32B.emptyTag())
		        .append(Field32B.emptyTag());

		List<SwiftTagListBlock> Bs = SwiftMessageUtils.splitByField15(sm, "B");
		assertNotNull(Bs);
		assertEquals(2, Bs.size());

		final SwiftTagListBlock list0 = Bs.get(0);
		assertNotNull(list0);
		assertEquals(1, list0.size());

		final SwiftTagListBlock list1 = Bs.get(1);
		assertNotNull(list1);
		assertEquals(3, list1.size());
	}

	@Test
	public void testSplitByField15LetterOptionPrimero() {
		final SwiftMessage sm = new SwiftMessage(true);
		sm.getBlock4()
		        .append(Field15A.emptyTag())
		        .append(Field33A.emptyTag())

		        .append(Field15B.emptyTag())

		        .append(Field15C.emptyTag())
		        .append(Field32A.emptyTag())

		        .append(Field15B.emptyTag())
		        .append(Field32B.emptyTag())
		        .append(Field32B.emptyTag());

		List<SwiftTagListBlock> Bs = SwiftMessageUtils.splitByField15(sm, "A");
		assertNotNull(Bs);
		assertEquals(1, Bs.size());

		final SwiftTagListBlock list0 = Bs.get(0);
		assertNotNull(list0);
		assertEquals(2, list0.size());

	}

	@Test
	public void testSplitByField15LetterOptionUltimo() {
		final SwiftMessage sm = new SwiftMessage(true);
		sm.getBlock4()
		        .append(Field15A.emptyTag())
		        .append(Field33A.emptyTag())

		        .append(Field15B.emptyTag())

		        .append(Field15C.emptyTag())
		        .append(Field32A.emptyTag())

		        .append(Field15B.emptyTag())
		        .append(Field32B.emptyTag())
		        .append(Field32B.emptyTag())

		        .append(Field15D.emptyTag())
		        .append(Field34B.emptyTag())
		        .append(Field34B.emptyTag())
		        .append(Field34B.emptyTag())
		        .append(Field34B.emptyTag());

		List<SwiftTagListBlock> Bs = SwiftMessageUtils.splitByField15(sm, "D");
		assertNotNull(Bs);
		assertEquals(1, Bs.size());

		final SwiftTagListBlock list0 = Bs.get(0);
		assertNotNull(list0);
		assertEquals(5, list0.size());

	}

	@Test
	public void testCreateSubsequenceWithParentsB_502() throws Exception {
		SwiftTagListBlock o = SwiftMessageUtils.createSubsequenceWithParents(MT502.class, "B", 
				Field13A.emptyTag(), Field13B.emptyTag(), Field13C.emptyTag());
		assertEquals(5, o.size());
	}
	@Test
	public void testCreateSubsequenceWithParentsA() throws Exception {
		SwiftTagListBlock o = SwiftMessageUtils.createSubsequenceWithParents(MT535.class, "A", Field13A.emptyTag());
		assertEquals(3, o.size());
	}
	@Test
	public void testCreateSubsequenceWithParentsA1() throws Exception {
		SwiftTagListBlock o = SwiftMessageUtils.createSubsequenceWithParents(MT535.class, "A1", Field13A.emptyTag());
		assertEquals(5, o.size());
	}
	@Test
	public void testCreateSubsequenceWithParentsA1_order() throws Exception {
		SwiftTagListBlock o = SwiftMessageUtils.createSubsequenceWithParents(MT535.class, "A1", Field13A.emptyTag());
		assertEquals(5, o.size());
		assertEquals(MT535.SequenceA.START_END_16RS, o.getTag(0).getValue());
		assertEquals(Field16R.NAME, o.getTag(0).getName());
		
		assertEquals(MT535.SequenceA1.START_END_16RS, o.getTag(1).getValue());
		assertEquals(Field16R.NAME, o.getTag(1).getName());
		
		assertEquals("13A", o.getTag(2).getName());
		
		assertEquals(MT535.SequenceA1.START_END_16RS, o.getTag(3).getValue());
		assertEquals(Field16S.NAME, o.getTag(3).getName());
		
		assertEquals(MT535.SequenceA.START_END_16RS, o.getTag(4).getValue());
		assertEquals(Field16S.NAME, o.getTag(4).getName());
	}
	@Test
	public void testCreateSubsequenceWithParentsB1b1() throws Exception {
		SwiftTagListBlock o = SwiftMessageUtils.createSubsequenceWithParents(MT535.class, "B1b1", Field13A.emptyTag());
		assertEquals(9, o.size());
	}
	
	@Test
	public void testRemoveInnerSequences() throws Exception {
		MT535 m = new MT535()
				.append(MT535.SequenceA.newInstance(
						MT535.SequenceA1.newInstance(
								Field13C.tag("foo1")
								).append(Field13C.tag("foo2"))
						)
						)
				;
		SwiftTagListBlock sublist = SwiftMessageUtils.removeInnerSequences(m.getSequenceA());
		
		assertEquals(3, sublist.size());
		assertEquals("foo2", sublist.getTag(1).getValue());
	}
	
	@Test
	public void testcurrencyAmountFromMessage() throws IOException {
		final String fin = "{1:F01CCRTIT2TX36A0000000000}{2:I101PPABPLPKXXXXN}{3:{108:YSGU193268223XXX}}{4:\n" +
			":20:4C2W0S0V8AM6X7OH\n" +
			":28D:00001/00001\n" +
			":50H:/PL66160011270003012399999999\n" +
			"FOO\n" +
			":30:131119\n" +
			":21:ZCAR1HI1HF3STLJO\n" +
			":32B:PLN2044,10\n" +
			":59:/PL74175000090000000001905201\n" +
			"POLONIA FOO HOTEL\n" +
			"AL FOOLIMSKIE 45\n" +
			"00-692\n" +
			"PL WARSAWA\n" +
			":70:1/34530/13\n" +
			":71A:SHA\n" +
			"-}";
		Money money = SwiftMessageUtils.money(SwiftMessage.parse(fin));
		assertNotNull(money);
		assertEquals("PLN", money.getCurrency());
		assertEquals(new BigDecimal("2044.10"), money.getAmount());
	}
	
	@Test
	public void testcurrencyAmountFromSystemMessage() throws IOException {
		final String fin = "{1:F21BNPAFRPPZXXX0000000002}{4:{177:1702090741}{451:0}}{1:F01BNPAFRPPZXXX0000000002}{2:I103BNPAFRPPXXXXN}{3:{108:REF1}}{4:\n" +
			":20:WITHMUR\n" +
			"-}{5:{MAC:ABCD1234}{CHK:ABCDEF123456}}";
		Money money = SwiftMessageUtils.money(SwiftMessage.parse(fin));
		assertNull(money);
	}

}

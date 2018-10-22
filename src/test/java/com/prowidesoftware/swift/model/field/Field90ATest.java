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
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;

public class Field90ATest extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("90A",
				":AAAA//BBBB/N123",
				":AAAA//BBBB/123",
				":DEAL//YIEL/N1234,5"
			);
	}
	
	@Test
	public void testParse90A_1() throws Exception {
		Field90A f = new Field90A(":AAAA//BBBB/N123");
		assertNotNull("Parse of field failed", f);
		assertEquals("AAAA", f.getComponent1());
		assertEquals("BBBB", f.getComponent2());
		assertEquals("N", f.getComponent3());
		assertEquals("123", f.getComponent4());
	}
	
	@Test
	public void testParse90A_2() throws Exception {
		Field90A f = new Field90A(":AAAA//BBBB/123");
		assertNotNull("Parse of field failed", f);
		assertEquals("AAAA", f.getComponent1());
		assertEquals("BBBB", f.getComponent2());
		assertNull(f.getComponent3());
		assertEquals("123", f.getComponent4());
	}
	
	@Test
	public void testParse90A_3() throws Exception {
		Field90A f = new Field90A(":DEAL//YIEL/N1234,5");
		assertNotNull("Parse of field failed", f);
		
		assertEquals("DEAL", f.getQualifier());
		assertEquals("DEAL", f.getComponent(Field90A.QUALIFIER));
		assertEquals("DEAL", f.getComponent1());
		
		assertEquals("YIEL", f.getPercentageTypeCode());
		assertEquals("YIEL", f.getComponent(Field90A.PERCENTAGE_TYPE_CODE));
		assertEquals("YIEL", f.getComponent2());
		
		/*
		 * get the sign code, if not present this methods will return null
		 */
		assertEquals("N", f.getSign());
		assertEquals("N", f.getComponent(Field90A.SIGN));
		assertEquals("N", f.getComponent3());
		
		assertEquals("1234,5", f.getPrice());
		assertEquals("1234,5", f.getComponent(Field90A.PRICE));
		assertEquals("1234,5", f.getComponent4());
		assertEquals(new BigDecimal("1234.5"), f.getPriceAsNumber());
	}

}
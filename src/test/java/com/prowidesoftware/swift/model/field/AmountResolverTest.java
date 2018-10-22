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

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

public class AmountResolverTest {

	@Test
	public void testResolveField32A() {
		Field32A f = new Field32A("130901USD10");
		assertEquals(new BigDecimal(10), AmountResolver.amount(f));

		f = new Field32A("130901USD10,");
		assertEquals(new BigDecimal(10), AmountResolver.amount(f));

		f = new Field32A("130901USD10,1");
		assertEquals(new BigDecimal("10.1"), AmountResolver.amount(f));
	}

	@Test
	public void testResolveField32B() {
		Field32B f = new Field32B("USD10");
		assertEquals(new BigDecimal(10), AmountResolver.amount(f));

		f = new Field32B("USD10,");
		assertEquals(new BigDecimal(10), AmountResolver.amount(f));

		f = new Field32B("USD10,1");
		assertEquals(new BigDecimal("10.1"), AmountResolver.amount(f));

	}
	@Test
	public void testResolveField32B_JPY() {
		Field32B _32B =  new Field32B("JPY21000000,");
		assertNotNull(_32B.amount());
		assertEquals(new BigDecimal("21000000"), _32B.amount());
	}
	
	@Test
	public void testResolve90F_multiple() {
		Field90F _90F = new Field90F(":AAAA//BBBB/EUR1234,56/CCCC/23456,78");
		final List<BigDecimal> amounts = _90F.amounts(); 
		assertNotNull(amounts);
		assertEquals(2, amounts.size());
		assertEquals(new BigDecimal("1234.56"), amounts.get(0));
		assertEquals(new BigDecimal("23456.78"), amounts.get(1));
	}

}

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
package com.prowidesoftware.swift.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;

import com.prowidesoftware.swift.model.field.Field19A;
import com.prowidesoftware.swift.model.field.Field20;
import com.prowidesoftware.swift.model.field.Field32A;
import com.prowidesoftware.swift.model.field.Field33B;
import com.prowidesoftware.swift.model.field.Field62F;

/**
 * Test cases for currency amount containers
 * 
 * @author sebastian
 * @since 7.8.8
 */
public class CurrencyAmountTest {

	@Test
	public void testCurrencyAmountFromField() {
		CurrencyAmount ca = CurrencyAmount.of(new Field32A("121212USD1234,"));
		assertEquals("USD", ca.getCurrency());
		assertEquals(new BigDecimal("1234"), ca.getAmount());

		assertNull(CurrencyAmount.of(new Field20("FOO")));
		
		ca = CurrencyAmount.of(new Field19A(":AAAA//EUR567,8"));
		assertEquals("EUR", ca.getCurrency());
		assertEquals(new BigDecimal("567.8"), ca.getAmount());
		
		ca = CurrencyAmount.of(new Field19A(":AAAA//NEUR567,8"));
		assertEquals("EUR", ca.getCurrency());
		assertEquals(new BigDecimal("-567.8"), ca.getAmount());

		ca = CurrencyAmount.of(new Field33B("ARS1,"));
		assertEquals("ARS", ca.getCurrency());
		assertEquals(new BigDecimal("1"), ca.getAmount());
		
		ca = CurrencyAmount.of(new Field62F("121212USD1234,"));
		assertEquals("USD", ca.getCurrency());
		assertEquals(new BigDecimal("1234"), ca.getAmount());
		
		ca = CurrencyAmount.of(new Field62F("D121212USD1234,"));
		assertEquals("USD", ca.getCurrency());
		assertEquals(new BigDecimal("-1234"), ca.getAmount());
	}
	
	@Test
	public void testCurrencyAmountSum() {
		CurrencyAmount ca = CurrencyAmount.ofSum(new Field32A("121212USD1000,1"), new Field33B("USD2000,1"), new Field62F("121212USD3000,1"));
		assertEquals("USD", ca.getCurrency());
		assertEquals(new BigDecimal("6000.3"), ca.getAmount());

		ca = CurrencyAmount.ofSum(new Field32A("121212USD5000,1"), new Field33B("USD5000,1"), new Field62F("D121212USD3000,1"));
		assertEquals("USD", ca.getCurrency());
		assertEquals(new BigDecimal("7000.1"), ca.getAmount());
	}
}

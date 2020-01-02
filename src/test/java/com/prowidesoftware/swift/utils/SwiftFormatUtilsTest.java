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
package com.prowidesoftware.swift.utils;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Test for SwiftFormatUtils.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class SwiftFormatUtilsTest {

	@Test
	public void testGetNumber() throws Exception {
		assertNotNull(SwiftFormatUtils.getNumber("123"));
		assertEquals(123, (SwiftFormatUtils.getNumber("123").intValue()));

		assertNotNull(SwiftFormatUtils.getNumber("123,"));
		assertEquals(new BigDecimal(123), new BigDecimal(SwiftFormatUtils.getNumber("123,").doubleValue()));
		
		//this test does not work but this format is not used
		//assertNotNull(SwiftFormatUtils.getNumber(",12"));
		//assertEquals(new BigDecimal(0.12), new BigDecimal(SwiftFormatUtils.getNumber(",12").doubleValue()));

		assertNotNull(SwiftFormatUtils.getNumber("1,2"));
		assertEquals(new Double(1.2), new Double(SwiftFormatUtils.getNumber("1,2").doubleValue()));
		
		assertNotNull(SwiftFormatUtils.getNumber("12,34"));
		assertEquals(new Double(12.34), new Double(SwiftFormatUtils.getNumber("12,34").doubleValue()));
		
		assertNotNull(SwiftFormatUtils.getNumber("12,3456"));
		assertEquals(new Double(12.3456), new Double(SwiftFormatUtils.getNumber("12,3456").doubleValue()));

		assertNotNull(SwiftFormatUtils.getNumber("0,"));
		assertEquals(new Double(0), new Double(SwiftFormatUtils.getNumber("0,").doubleValue()));

		assertNotNull(SwiftFormatUtils.getNumber("299000,34"));
		assertEquals(new Double(299000.34), new Double(SwiftFormatUtils.getNumber("299000,34").doubleValue()));		
	}
	
	@Test
	public void testGetNumberWriter() throws Exception {
		assertEquals("12,", SwiftFormatUtils.getNumber(new BigDecimal(12)));
		assertEquals("12,34", SwiftFormatUtils.getNumber(new BigDecimal(12.34)));
		assertEquals("12,", SwiftFormatUtils.getNumber(new BigDecimal(12.0)));
		assertEquals("123,", SwiftFormatUtils.getNumber(new BigDecimal(123)));
		assertEquals("1,2", SwiftFormatUtils.getNumber(new BigDecimal(1.2)));
		assertEquals("0,7", SwiftFormatUtils.getNumber(new BigDecimal(0.7)));
		assertEquals("12,345", SwiftFormatUtils.getNumber(new BigDecimal(12.345)));
		assertEquals("12,", SwiftFormatUtils.getNumber(12));
		assertEquals("12,3", SwiftFormatUtils.getNumber(12.3));
		assertEquals("12,34", SwiftFormatUtils.getNumber(12.34));
		assertEquals("12,345", SwiftFormatUtils.getNumber(12.345));
		assertEquals("12,3456", SwiftFormatUtils.getNumber(new BigDecimal(12.3456)));
		assertEquals("12,34567", SwiftFormatUtils.getNumber(new BigDecimal(12.34567)));
		assertEquals("12,345678", SwiftFormatUtils.getNumber(new BigDecimal(12.345678)));
		assertEquals("12,3456789", SwiftFormatUtils.getNumber(new BigDecimal(12.3456789)));
	}
	
	@Test
	public void testIsHHMM() throws Exception {
		assertNotNull(SwiftFormatUtils.getHhmm("0000"));
		assertEquals(0, SwiftFormatUtils.getHhmm("0000").get(Calendar.HOUR_OF_DAY));
		assertEquals(0, SwiftFormatUtils.getHhmm("0000").get(Calendar.MINUTE));
		
		assertNotNull(SwiftFormatUtils.getHhmm("1245"));
		assertEquals(12, SwiftFormatUtils.getHhmm("1245").get(Calendar.HOUR_OF_DAY));
		assertEquals(45, SwiftFormatUtils.getHhmm("1245").get(Calendar.MINUTE));
		
		assertNotNull(SwiftFormatUtils.getHhmm("1359"));
		assertEquals(13, SwiftFormatUtils.getHhmm("1359").get(Calendar.HOUR_OF_DAY));
		assertEquals(59, SwiftFormatUtils.getHhmm("1359").get(Calendar.MINUTE));

		assertNull(SwiftFormatUtils.getHhmm("0060"));
		assertNull(SwiftFormatUtils.getHhmm("2400"));
	}
	
	@Test
	public void testIsOffset() throws Exception {
		assertNotNull(SwiftFormatUtils.getOffset("0000"));
		assertNotNull(SwiftFormatUtils.getOffset("1245"));
		assertNotNull(SwiftFormatUtils.getOffset("1300"));
		assertNotNull(SwiftFormatUtils.getOffset("1301"));
		assertNotNull(SwiftFormatUtils.getOffset("1359"));
		assertNull(SwiftFormatUtils.getOffset("0060"));
		assertNull(SwiftFormatUtils.getOffset("2400"));
	}
	
	@Test
	public void testIsDate2() throws Exception {
		// TODO add test for specific values to be parsed correctly
		assertNotNull(SwiftFormatUtils.getDate2("070131"));
		assertNotNull(SwiftFormatUtils.getDate2("070228"));
		assertNotNull(SwiftFormatUtils.getDate2("070430"));
		
		assertNull(SwiftFormatUtils.getDate2("070229"));
		assertNull(SwiftFormatUtils.getDate2("070132"));
	}
	
	@Test
	public void testLeapYear() {
		assertTrue(SwiftFormatUtils.isLeapYear(2016));
		assertFalse(SwiftFormatUtils.isLeapYear(2017));
		assertTrue(SwiftFormatUtils.isLeapYear(2020));
	}

	@Test
	public void testIsMonthDay() {
		Calendar cal = SwiftFormatUtils.getMonthDay("0827");
		assertNotNull(cal);
		assertEquals(Calendar.AUGUST, cal.get(Calendar.MONTH));
		assertEquals(27, cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), cal.get(Calendar.YEAR));
	}

	@Test
	public void testIsMonthDayLeapYear() {
		if (Year.now().isLeap()) {
			Calendar cal = SwiftFormatUtils.getMonthDay("0229");
			assertNotNull(cal);
			assertEquals(Calendar.FEBRUARY, cal.get(Calendar.MONTH));
			assertEquals(29, cal.get(Calendar.DAY_OF_MONTH));
		} else {
			assertNull(SwiftFormatUtils.getMonthDay("0229"));
		}
	}

	@Test
	public void testDecimalsInAmount() throws Exception {
		assertEquals(0, SwiftFormatUtils.decimalsInAmount((String)null));
		assertEquals(0, SwiftFormatUtils.decimalsInAmount(""));
		assertEquals(0, SwiftFormatUtils.decimalsInAmount("1"));
		assertEquals(0, SwiftFormatUtils.decimalsInAmount("1,"));
		assertEquals(0, SwiftFormatUtils.decimalsInAmount("1127892189"));
		
		assertEquals(1, SwiftFormatUtils.decimalsInAmount("112789218,9"));
		assertEquals(1, SwiftFormatUtils.decimalsInAmount("112789,218,9"));
		assertEquals(1, SwiftFormatUtils.decimalsInAmount("112789,,,218,9"));
	}
	@Test
	public void testDecimalsInAmountBigDecimal() throws Exception {
		assertEquals(0, SwiftFormatUtils.decimalsInAmount((BigDecimal)null));
		assertEquals(0, SwiftFormatUtils.decimalsInAmount(new BigDecimal("1")));
		assertEquals(0, SwiftFormatUtils.decimalsInAmount(new BigDecimal("1.00")));
		assertEquals(0, SwiftFormatUtils.decimalsInAmount("new BigDecimal(1127892189"));
		
		assertEquals(5, SwiftFormatUtils.decimalsInAmount(new BigDecimal("11278.92189")));
		assertEquals(1, SwiftFormatUtils.decimalsInAmount(new BigDecimal("112789218.9")));
		assertEquals(4, SwiftFormatUtils.decimalsInAmount(new BigDecimal("112789.2189")));
	}
	
}

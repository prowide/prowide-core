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
 * 
 */
package com.prowidesoftware.swift.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * test cases for {@link IsoUtils}
 * 
 * @author sebastian
 * @since 7.9.2
 */
public class IsoUtilsTest {

	@Test
	public void testCurrencies() {
		/*
		 * valid
		 */
		assertTrue(IsoUtils.getInstance().isValidISOCurrency("EUR"));
		assertTrue(IsoUtils.getInstance().isValidISOCurrency("USD"));
		assertTrue(IsoUtils.getInstance().isValidISOCurrency("ARS"));
		/*
		 * invalid
		 */
		assertFalse(IsoUtils.getInstance().isValidISOCurrency("usd"));
		assertFalse(IsoUtils.getInstance().isValidISOCurrency(""));
		assertFalse(IsoUtils.getInstance().isValidISOCurrency(null));
		assertFalse(IsoUtils.getInstance().isValidISOCurrency("XYZ"));

		IsoUtils.getInstance().getCurrencies().add("XYZ");
		assertTrue(IsoUtils.getInstance().isValidISOCurrency("XYZ"));
		IsoUtils.getInstance().getCurrencies().remove("XYZ");
	}
	
	@Test
	public void testCountries() {
		/*
		 * valid
		 */
		assertTrue(IsoUtils.getInstance().isValidISOCountry("US"));
		assertTrue(IsoUtils.getInstance().isValidISOCountry("AR"));
		assertTrue(IsoUtils.getInstance().isValidISOCountry("BR"));
		assertTrue(IsoUtils.getInstance().isValidISOCountry("XK")); //Kosovo, not currently in ISO
		/*
		 * invalid
		 */
		assertFalse(IsoUtils.getInstance().isValidISOCountry("us"));
		assertFalse(IsoUtils.getInstance().isValidISOCountry("Foo"));
		assertFalse(IsoUtils.getInstance().isValidISOCountry(""));
		assertFalse(IsoUtils.getInstance().isValidISOCountry(null));
		assertFalse(IsoUtils.getInstance().isValidISOCountry("XX"));
		assertFalse(IsoUtils.getInstance().isValidISOCountry("ZZ"));
		assertFalse(IsoUtils.getInstance().isValidISOCountry("ar"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddCountry_1() {
		IsoUtils.getInstance().addCountry(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddCountry_2() {
		IsoUtils.getInstance().addCountry("33");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddCountry_3() {
		IsoUtils.getInstance().addCountry("aa");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddCountry_4() {
		IsoUtils.getInstance().addCountry("AAA");
	}

	@Test
	public void testAddCountry_5() {
		IsoUtils.getInstance().addCountry("SZ");
		assertTrue(IsoUtils.getInstance().isValidISOCountry("SZ"));
		IsoUtils.getInstance().getCountries().remove("SZ");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddCurrency_1() {
		IsoUtils.getInstance().addCurrency(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddCurrency_2() {
		IsoUtils.getInstance().addCurrency("333");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddCurrency_3() {
		IsoUtils.getInstance().addCurrency("aaa");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddCurrency_4() {
		IsoUtils.getInstance().addCurrency("AAAA");
	}

	@Test
	public void testAddCurrency_5() {
		IsoUtils.getInstance().addCurrency("DSZ");
		assertTrue(IsoUtils.getInstance().isValidISOCurrency("DSZ"));
		IsoUtils.getInstance().getCurrencies().remove("DSZ");
	}

}

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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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

}

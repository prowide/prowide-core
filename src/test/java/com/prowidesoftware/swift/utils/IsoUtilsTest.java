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

import java.util.Currency;

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
		assertTrue(IsoUtils.getInstance().isValidISOCurrency("BYN"));
		assertTrue(IsoUtils.getInstance().isValidISOCurrency("NGN"));
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

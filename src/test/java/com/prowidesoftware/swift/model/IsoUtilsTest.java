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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.prowidesoftware.swift.utils.IsoUtils;

public class IsoUtilsTest {

	@Test public void testSomeCodes() {
		assertFalse(IsoUtils.getInstance().isValidISOCountry("ZZ"));
		assertFalse(IsoUtils.getInstance().isValidISOCountry("ar"));
		assertTrue(IsoUtils.getInstance().isValidISOCountry("AR"));
	}
	
	@Test public void testValidCode() {
		assertTrue(IsoUtils.getInstance().isValidISOCurrency("ARS"));
		assertFalse(IsoUtils.getInstance().isValidISOCurrency("XYZ"));
	}
	
}
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
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

/**
 * Test for fields getValueDisplay API.
 *
 * @author www.prowidesoftware.com
 * @since 7.9.5
 */
public class GetValueDisplayTest {

	/*
	 * Rate formatting
	 */
	@Test
	public void test36() {
		Field36 f = new Field36("1,234567890120");
		assertEquals("1.23456789012", f.getValueDisplay(Locale.US));
		assertEquals("1,23456789012", f.getValueDisplay(Locale.GERMANY));
		assertEquals("1,23456789012", f.getValueDisplay(Locale.FRANCE));
		f = new Field36("1234,234567890120");
		assertEquals("1,234.23456789012", f.getValueDisplay(Locale.US));
		assertEquals("1.234,23456789012", f.getValueDisplay(Locale.GERMANY));
		assertEquals("1 234,23456789012", f.getValueDisplay(Locale.FRANCE));
	}
	
	/*
	 * Amount formatting
	 */
	@Test
	public void test32A() {
		Field32A f = new Field32A("121212USD1,234500");
		assertEquals("1.2345", f.getValueDisplay(3, Locale.US));
		assertEquals("1,2345", f.getValueDisplay(3, Locale.GERMANY));
		assertEquals("1,2345", f.getValueDisplay(3, Locale.FRANCE));
		f = new Field32A("121212USD1234,5670");
		assertEquals("1,234.567", f.getValueDisplay(3, Locale.US));
		assertEquals("1.234,567", f.getValueDisplay(3, Locale.GERMANY));
		assertEquals("1 234,567", f.getValueDisplay(3, Locale.FRANCE));
	}
	
	/*
	 * Account formatting
	 */
	@Test
	public void test50F() {
		final String value = "/1234567890\r\n"+
				"1/JOHN SMITH\r\n"+
				"2/HIGH STREET 6, APT 6C\r\n"+
				"3/BE/BRUSSELS";
		Field50F f = new Field50F(value);
		assertEquals("1234567890", f.getValueDisplay(1, Locale.US));
	}
	
}

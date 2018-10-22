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

import java.util.Locale;

import org.junit.Test;

/**
 * Test for fields getValueDisplay API.
 *
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

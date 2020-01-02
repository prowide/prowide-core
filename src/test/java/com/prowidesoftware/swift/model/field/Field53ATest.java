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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test for Field53A and similar fields.
 *
 * @since 8.0.2
 */
public class Field53ATest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("53A",
				"/00010001380002000114",
				"/00010001/3800-02000114",
				"/C/1234/56",
				"/D/123\nABCDAEAD",
				"ABCDAEAD"
			);
	}
	
	@Test
	public void test53A() {
		Field53A f = new Field53A((String)null);
		assertNull(f.getDCMark());
		assertNull(f.getAccount());
		assertNull(f.getBIC());
		
		f = new Field53A("");
		assertNull(f.getDCMark());
		assertNull(f.getAccount());
		assertNull(f.getBIC());
		
		f = new Field53A("/D");
		assertNull(f.getDCMark());
		assertEquals("D", f.getAccount());
		assertNull(f.getBIC());
		
		f = new Field53A("/D/");
		assertEquals("D", f.getDCMark());
		assertNull(f.getAccount());
		assertNull(f.getBIC());
		
		f = new Field53A("/D/1234");
		assertEquals("D", f.getDCMark());
		assertEquals("1234", f.getAccount());
		assertNull(f.getBIC());
		
		f = new Field53A("/D/1234/56");
		assertEquals("D", f.getDCMark());
		assertEquals("1234/56", f.getAccount());
		assertNull(f.getBIC());
		
		f = new Field53A("ABCDAEAD");
		assertNull(f.getDCMark());
		assertNull(f.getAccount());
		assertEquals("ABCDAEAD", f.getBIC());
		
		f = new Field53A("/C/1234\nABCDAEAD");
		assertEquals("C", f.getDCMark());
		assertEquals("1234", f.getAccount());
		assertEquals("ABCDAEAD", f.getBIC());
		
		f = new Field53A("/D\nABCDAEAD");
		assertNull(f.getDCMark());
		assertEquals("D", f.getAccount());
		assertEquals("ABCDAEAD", f.getBIC());
		
		f = new Field53A("/1234\nABCDAEAD");
		assertNull(f.getDCMark());
		assertEquals("1234", f.getAccount());
		assertEquals("ABCDAEAD", f.getBIC());
		
		f = new Field53A("/00010001380002000114");
		assertEquals("00010001380002000114", f.getAccount());
		assertNull(f.getDCMark());
		assertNull(f.getBIC());
	}

	/**
	 * Anything in the first line that is not a '/D/*' '/C/*' should be parsed as the account
	 */
	@Test
	public void test53AAccount() {
		Field53A f = new Field53A("/1");
		assertNull(f.getDCMark());
		assertEquals("1", f.getAccount());
		
		f = new Field53A("/DD");
		assertNull(f.getDCMark());
		assertEquals("DD", f.getAccount());

		f = new Field53A("/A");
		assertNull(f.getDCMark());
		assertEquals("A", f.getAccount());

		f = new Field53A("/D/");
		assertEquals("D", f.getDCMark());
		assertNull(f.getAccount());

		f = new Field53A("/C/");
		assertEquals("C", f.getDCMark());
		assertNull(f.getAccount());

		f = new Field53A("/A/");
		assertEquals("A", f.getDCMark());
		assertNull(f.getAccount());

		f = new Field53A("/D");
		assertNull(f.getDCMark());
		assertEquals("D", f.getAccount());

		f = new Field53A("/C");
		assertNull(f.getDCMark());
		assertEquals("C", f.getAccount());

		f = new Field53A("/C/1");
		assertEquals("C", f.getDCMark());
		assertEquals("1", f.getAccount());
	}
	
	@Test
	public void testGetValueDisplay() {
		Field53A f = new Field53A("/00010001380002000114");
		assertEquals("00010001380002000114", f.getAccount());
		assertNull(f.getDCMark());
		assertNull(f.getBIC());
	}

}
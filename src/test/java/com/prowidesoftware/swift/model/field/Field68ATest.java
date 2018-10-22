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
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test for Field68A and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.4
 */
public class Field68ATest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("68A",
				"130301FOO130302/1234/999",
				"130301FOO130302/1234/999//ABC"
			);
	}
	
	/**
	 * NSN/N[/N][//S]
	 */
	@Test
	public void testField68A() {		
		Field68A f = new Field68A((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());

		f = new Field68A("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());

		f = new Field68A("130301");
		assertEquals("130301", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());

		f = new Field68A("130301FOO");
		assertEquals("130301", f.getComponent1());
		assertEquals("FOO", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field68A("130301FOO130302");
		assertEquals("130301", f.getComponent1());
		assertEquals("FOO", f.getComponent2());
		assertEquals("130302", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());

		f = new Field68A("130301FOO130302/");
		assertEquals("130301", f.getComponent1());
		assertEquals("FOO", f.getComponent2());
		assertEquals("130302", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());

		f = new Field68A("130301FOO130302/1234");
		assertEquals("130301", f.getComponent1());
		assertEquals("FOO", f.getComponent2());
		assertEquals("130302", f.getComponent3());
		assertEquals("1234", f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());

		f = new Field68A("130301FOO130302/1234/");
		assertEquals("130301", f.getComponent1());
		assertEquals("FOO", f.getComponent2());
		assertEquals("130302", f.getComponent3());
		assertEquals("1234", f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());

		f = new Field68A("130301FOO130302/1234/999");
		assertEquals("130301", f.getComponent1());
		assertEquals("FOO", f.getComponent2());
		assertEquals("130302", f.getComponent3());
		assertEquals("1234", f.getComponent4());
		assertEquals("999", f.getComponent5());
		assertNull(f.getComponent6());

		f = new Field68A("130301FOO130302/1234/999//");
		assertEquals("130301", f.getComponent1());
		assertEquals("FOO", f.getComponent2());
		assertEquals("130302", f.getComponent3());
		assertEquals("1234", f.getComponent4());
		assertEquals("999", f.getComponent5());
		assertNull(f.getComponent6());

		f = new Field68A("130301FOO130302/1234/999//ABC");
		assertEquals("130301", f.getComponent1());
		assertEquals("FOO", f.getComponent2());
		assertEquals("130302", f.getComponent3());
		assertEquals("1234", f.getComponent4());
		assertEquals("999", f.getComponent5());
		assertEquals("ABC", f.getComponent6());
	}
	
}
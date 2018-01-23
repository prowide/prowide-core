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
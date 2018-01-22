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
 * Test for Field37A and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.4
 */
public class Field37ATest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("37A",
				"1234//131201AFOO/ABC"
			);
	}
	
	/**
	 * N[//<DATE2>cS][/S]
	 */
	@Test
	public void testField37A() {		
		Field37A f = new Field37A((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("1234");
		assertEquals("1234", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("1234//");
		assertEquals("1234", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field37A("1234//131201");
		assertEquals("1234", f.getComponent1());
		assertEquals("131201", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("1234//131201A");
		assertEquals("1234", f.getComponent1());
		assertEquals("131201", f.getComponent2());
		assertEquals("A", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("1234//131201AFOO");
		assertEquals("1234", f.getComponent1());
		assertEquals("131201", f.getComponent2());
		assertEquals("A", f.getComponent3());
		assertEquals("FOO", f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("1234//131201AFOO/ABC");
		assertEquals("1234", f.getComponent1());
		assertEquals("131201", f.getComponent2());
		assertEquals("A", f.getComponent3());
		assertEquals("FOO", f.getComponent4());
		assertEquals("ABC", f.getComponent5());
	}

}
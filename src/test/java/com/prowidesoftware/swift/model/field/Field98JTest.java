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
 * Test for field 98J and similar fields.
 * 
 * @author sebastian
 * @since 7.9.3
 */
public class Field98JTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("98J",
				":FOO//121212121111/ABCDUSAAXXX"
			);
	}
	
	@Test
	public void testField98JString() {
		Field98J f = null;
		
		f = new Field98J("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field98J(":");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98J("//");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98J("://");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98J(":abc//");
		assertEquals("abc", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field98J(":abc//11111111");
		assertEquals("abc", f.getComponent1());
		assertEquals("11111111", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98J(":abc//111111112222");
		assertEquals("abc", f.getComponent1());
		assertEquals("11111111", f.getComponent2());
		assertEquals("2222", f.getComponent3());
		assertNull(f.getComponent4());
	
		f = new Field98J(":abc//111111112222/foo");
		assertEquals("abc", f.getComponent1());
		assertEquals("11111111", f.getComponent2());
		assertEquals("2222", f.getComponent3());
		assertEquals("foo", f.getComponent4());
	}

}
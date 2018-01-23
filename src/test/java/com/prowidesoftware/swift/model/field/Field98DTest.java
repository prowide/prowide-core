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
 * Test for Field98D and similar fields.
 * <DATE4><TIME2>[,S][/[c]<TIME3>]
 * 
 * @author sebastian
 * @since 7.8.8
 */
public class Field98DTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("98D",
				"20150827121212/a10"
			);
	}
	
	@Test
	public void testField98D() {
		Field98D f = null;
		
		f = new Field98D("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertEquals("", f.getValue());

		f = new Field98D("20150827");
		assertEquals("20150827", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertEquals("20150827", f.getValue());
		
		f = new Field98D("20150827121212");
		assertEquals("20150827", f.getComponent1());
		assertEquals("121212", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertEquals("20150827121212", f.getValue());
		
		f = new Field98D("20150827121212,FOO");
		assertEquals("20150827", f.getComponent1());
		assertEquals("121212", f.getComponent2());
		assertEquals("FOO", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertEquals("20150827121212,FOO", f.getValue());
		
		f = new Field98D("20150827121212,FOO/a");
		assertEquals("20150827", f.getComponent1());
		assertEquals("121212", f.getComponent2());
		assertEquals("FOO", f.getComponent3());
		assertEquals("a", f.getComponent4());
		assertNull(f.getComponent5());
		assertEquals("20150827121212,FOO/a", f.getValue());
		
		f = new Field98D("20150827121212,FOO/a");
		assertEquals("20150827", f.getComponent1());
		assertEquals("121212", f.getComponent2());
		assertEquals("FOO", f.getComponent3());
		assertEquals("a", f.getComponent4());
		assertNull(f.getComponent5());
		assertEquals("20150827121212,FOO/a", f.getValue());
		
		f = new Field98D("20150827121212,FOO/a1020");
		assertEquals("20150827", f.getComponent1());
		assertEquals("121212", f.getComponent2());
		assertEquals("FOO", f.getComponent3());
		assertEquals("a", f.getComponent4());
		assertEquals("1020", f.getComponent5());
		assertEquals("20150827121212,FOO/a1020", f.getValue());
		
		f = new Field98D("20150827121212,FOO/a10");
		assertEquals("20150827", f.getComponent1());
		assertEquals("121212", f.getComponent2());
		assertEquals("FOO", f.getComponent3());
		assertEquals("a", f.getComponent4());
		assertEquals("10", f.getComponent5());
		assertEquals("20150827121212,FOO/a10", f.getValue());
		
		f = new Field98D("20150827121212/a10");
		assertEquals("20150827", f.getComponent1());
		assertEquals("121212", f.getComponent2());
		assertNull(f.getComponent3());
		assertEquals("a", f.getComponent4());
		assertEquals("10", f.getComponent5());
		assertEquals("20150827121212/a10", f.getValue());
	}
	
}
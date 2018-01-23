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
 * Test for Field33G and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.4
 */
public class Field33GTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("33G",
				"USD123,4FOO"
			);
	}
	
	/**
	 * cNS<CUR>N
	 */
	@Test
	public void testField33G() {		
		Field33G f = new Field33G((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());

		f = new Field33G("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());

		f = new Field33G("USD");
		assertEquals("USD", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());

		f = new Field33G("USD123,4");
		assertEquals("USD", f.getComponent1());
		assertEquals("123,4", f.getComponent2());
		assertNull(f.getComponent3());
		
		f = new Field33G("USD123,4FOO");
		assertEquals("USD", f.getComponent1());
		assertEquals("123,4", f.getComponent2());
		assertEquals("FOO", f.getComponent3());
		
		f = new Field33G("123,4FOO");
		assertNull(f.getComponent1());
		assertEquals("123,4", f.getComponent2());
		assertEquals("FOO", f.getComponent3());
	}

}
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
 * Test for Field32B and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field32BTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("32B",
				"USD123"
			);
	}
	
	@Test
	public void testField32B() {		
		Field32B f = new Field32B("USD123");
		assertEquals("USD", f.getComponent1());
		assertEquals("123", f.getComponent2());
		assertEquals(new Double(123), new Double(f.getComponent2AsNumber().doubleValue()));
		
		f = new Field32B("123");
		assertNull(f.getComponent1());
		assertEquals("123", f.getComponent2());
		assertEquals(new Double(123), new Double(f.getComponent2AsNumber().doubleValue()));
		
		f = new Field32B("USD");
		assertEquals("USD", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent2AsNumber());
		
		f = new Field32B("USD123,");
		assertEquals("USD", f.getComponent1());
		assertEquals("123,", f.getComponent2());
		assertEquals(new Double(123), new Double(f.getComponent2AsNumber().doubleValue()));
		
		f = new Field32B("USD123,45");
		assertEquals("USD", f.getComponent1());
		assertEquals("123,45", f.getComponent2());
		assertEquals(new Double(123.45), new Double(f.getComponent2AsNumber().doubleValue()));
	}

}
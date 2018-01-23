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
 * Test for Field70 and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field70Test extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("70",
				"a\nb\nc\nd"
			);
	}
	
	@Test
	public void testField70() {		
		Field70 f = new Field70((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field70("a");
		assertEquals("a", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field70("a\nb");
		assertEquals("a", f.getComponent1());
		assertEquals("b", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field70("a\nb\nc");
		assertEquals("a", f.getComponent1());
		assertEquals("b", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field70("a\nb\nc\nd");
		assertEquals("a", f.getComponent1());
		assertEquals("b", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("d", f.getComponent4());
	}
	
}
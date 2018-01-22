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
 * Test for Field26C and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.4
 */
public class Field26CTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("26C",
				"A/B/CCCCCDDDDEEEE"
			);
	}
	
	/**
	 * [S]/S/5!a4!aS
	 */
	@Test
	public void testField26C() {		
		Field26C f = new Field26C((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field26C("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field26C("A");
		assertEquals("A", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field26C("A/");
		assertEquals("A", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field26C("A/B");
		assertEquals("A", f.getComponent1());
		assertEquals("B", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field26C("A/B/C");
		assertEquals("A", f.getComponent1());
		assertEquals("B", f.getComponent2());
		assertEquals("C", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field26C("A/B/CCCCC");
		assertEquals("A", f.getComponent1());
		assertEquals("B", f.getComponent2());
		assertEquals("CCCCC", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field26C("A/B/CCCCCD");
		assertEquals("A", f.getComponent1());
		assertEquals("B", f.getComponent2());
		assertEquals("CCCCC", f.getComponent3());
		assertEquals("D", f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field26C("A/B/CCCCCDDDD");
		assertEquals("A", f.getComponent1());
		assertEquals("B", f.getComponent2());
		assertEquals("CCCCC", f.getComponent3());
		assertEquals("DDDD", f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field26C("A/B/CCCCCDDDDEEEE");
		assertEquals("A", f.getComponent1());
		assertEquals("B", f.getComponent2());
		assertEquals("CCCCC", f.getComponent3());
		assertEquals("DDDD", f.getComponent4());
		assertEquals("EEEE", f.getComponent5());
	}

}
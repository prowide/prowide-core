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
 * Test for Field58D and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field58DTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("58D",
				"/00010001380002000114"
			);
	}
	
	@Test
	public void test58D() {
		Field58D f = new Field58D((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D");
		assertEquals("D", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D/");
		assertEquals("D", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D/1234");
		assertEquals("D", f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D/1234/56");
		assertEquals("D", f.getComponent1());
		assertEquals("1234/56", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("abcd");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertEquals("abcd", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D/1234\nabcd");
		assertEquals("D", f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertEquals("abcd", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D\nabcd");
		assertEquals("D", f.getComponent1());
		assertNull(f.getComponent2());
		assertEquals("abcd", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/1234\nabcd");
		assertNull(f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertEquals("abcd", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/00010001380002000114");
		assertEquals("00010001380002000114", f.getComponent2());
		assertNull(f.getComponent1());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D/1234\nabcd\nefgh\nijkl\nmnop");
		assertEquals("D", f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertEquals("abcd", f.getComponent3());
		assertEquals("efgh", f.getComponent4());
		assertEquals("ijkl", f.getComponent5());
		assertEquals("mnop", f.getComponent6());
	}
	
	@Test
	public void testGetValueDisplay() {
		Field58D f = new Field58D("/00010001380002000114");
		assertEquals("00010001380002000114", f.getComponent2());
		assertNull(f.getComponent1());
		assertNull(f.getComponent3());
	}

}
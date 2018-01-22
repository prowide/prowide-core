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
 * Test for Field54B and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field54BTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("54B",
				"/00010001380002000114",
				"/D/1234/56",
				"/D\nabcd"
			);
	}
	
	@Test
	public void test54B() {
		Field54B f = new Field54B((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		
		f = new Field54B("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		
		f = new Field54B("/D");
		assertEquals("D", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		
		f = new Field54B("/D/");
		assertEquals("D", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		
		f = new Field54B("/D/1234");
		assertEquals("D", f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertNull(f.getComponent3());
		
		f = new Field54B("/D/1234/56");
		assertEquals("D", f.getComponent1());
		assertEquals("1234/56", f.getComponent2());
		assertNull(f.getComponent3());
		
		f = new Field54B("abcd");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertEquals("abcd", f.getComponent3());
		
		f = new Field54B("/D/1234\nabcd");
		assertEquals("D", f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertEquals("abcd", f.getComponent3());
		
		f = new Field54B("/D\nabcd");
		assertEquals("D", f.getComponent1());
		assertNull(f.getComponent2());
		assertEquals("abcd", f.getComponent3());
		
		f = new Field54B("/1234\nabcd");
		assertNull(f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertEquals("abcd", f.getComponent3());
		
		f = new Field54B("/00010001380002000114");
		assertEquals("00010001380002000114", f.getComponent2());
		assertNull(f.getComponent1());
		assertNull(f.getComponent3());
	}
	
	@Test
	public void testGetValueDisplay() {
		Field54B f = new Field54B("/00010001380002000114");
		assertEquals("00010001380002000114", f.getComponent2());
		assertNull(f.getComponent1());
		assertNull(f.getComponent3());
	}

}
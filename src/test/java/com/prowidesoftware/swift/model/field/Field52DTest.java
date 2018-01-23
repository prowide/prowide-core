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
 * Test for Field52D and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field52DTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("52D",
				"//SC1111111\r\nXXX XX\r\n111 XXXXXXXXX XX XXXXXX",
				"/D/SC1111111"
			);
	}
	
	@Test
	public void test52D_issue6() {
		Field52D f = new Field52D("//SC1111111\r\n"
					+ "XXX XX\r\n"
					+"111 XXXXXXXXX XX XXXXXX");
		assertNull(f.getComponent1());
		assertEquals("/SC1111111", f.getComponent2());
		assertEquals("XXX XX", f.getComponent3());
		assertEquals("111 XXXXXXXXX XX XXXXXX", f.getComponent4());
	}

	@Test
	public void test52D_2() {
		Field52D f = new Field52D("/D/SC1111111\r\n");
		assertEquals("D", f.getComponent1());
		assertEquals("SC1111111", f.getComponent2());
	}
	
	@Test
	public void test52D_3() {
		Field52D f = new Field52D("/D2/SC1111111\r\n");
		assertNull(f.getComponent1());
		assertEquals("D2/SC1111111", f.getComponent2());
	}
	
}
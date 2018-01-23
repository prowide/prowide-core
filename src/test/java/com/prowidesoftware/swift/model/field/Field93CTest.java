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
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * Test for Field93C and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field93CTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("93C",
				":DDDD//EEEEEEEE/FFFF/E1234"
			);
	}
	
	/**
	 * :S//S/S/[c]N
	 */
	@Test
	public void testField93CString() {
		Field93C f = null;
		
		f = new Field93C("");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));

		f = new Field93C(":");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));

		f = new Field93C(":/");
		//assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));

		f = new Field93C("://");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));

		f = new Field93C(":///");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));

		f = new Field93C(":////");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));

		f = new Field93C(":DDDD");
		assertEquals("DDDD", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		
		f = new Field93C(":DDDD//");
		assertEquals("DDDD", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		
		f = new Field93C(":DDDD//EEEEEEEE");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		
		f = new Field93C(":DDDD//EEEEEEEE/");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		
		f = new Field93C(":DDDD//");
		assertEquals("DDDD", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		
		f = new Field93C(":DDDD//EEEEEEEE/FFFF");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFFF", f.getComponent3());
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
					
		f = new Field93C(":DDDD//EEEEEEEE/FFFF/E");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFFF", f.getComponent3());
		assertEquals("E", f.getComponent4());
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		
		f = new Field93C(":DDDD//EEEEEEEE/FFFF/E1234");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFFF", f.getComponent3());
		assertEquals("E", f.getComponent4());
		assertEquals("1234", f.getComponent5());
	}

}
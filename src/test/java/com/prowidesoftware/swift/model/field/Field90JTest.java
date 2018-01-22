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
 * Test for Field90J and similar fields.
 * Pattern: ":S//S/SN/SN"
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field90JTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("90J",
				":DDDD//EEEEEEEE/FFF123/GGG456"
			);
	}
	
	@Test
	public void testField90JString() {
		Field90J f = null;
		
		f = new Field90J("");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field90J(":");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field90J(":/");
		//assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field90J("://");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field90J(":///");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
				
		f = new Field90J(":DDDD");
		assertEquals("DDDD", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field90J(":DDDD//");
		assertEquals("DDDD", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field90J(":DDDD//EEEEEEEE");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));

		f = new Field90J(":DDDD//EEEEEEEE/");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));

		f = new Field90J(":DDDD//EEEEEEEE/FFF");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFF", f.getComponent3());
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));

		f = new Field90J(":DDDD//EEEEEEEE/FFF123");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFF", f.getComponent3());
		assertEquals("123", f.getComponent4());
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));

		f = new Field90J(":DDDD//EEEEEEEE/FFF123/");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFF", f.getComponent3());
		assertEquals("123", f.getComponent4());
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field90J(":DDDD//EEEEEEEE/FFF123/GGG");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFF", f.getComponent3());
		assertEquals("123", f.getComponent4());
		assertEquals("GGG", f.getComponent5());
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field90J(":DDDD//EEEEEEEE/FFF123/GGG456");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFF", f.getComponent3());
		assertEquals("123", f.getComponent4());
		assertEquals("GGG", f.getComponent5());
		assertEquals("456", f.getComponent6());
	}

}
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
 * Test for Field92M and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field92MTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("92M",
				":DDDD//EEEEEEEE123/FFFF"
			);
	}
	
	@Test
	public void testField92MString() {
		Field92M f = null;
		
		f = new Field92M("");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		
		f = new Field92M(":");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		
		f = new Field92M(":/");
		//assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		
		f = new Field92M("://");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		
		f = new Field92M(":///");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
				
		f = new Field92M(":DDDD");
		assertEquals("DDDD", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		
		f = new Field92M(":DDDD//");
		assertEquals("DDDD", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		
		f = new Field92M(":DDDD//EEEEEEEE");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		
		f = new Field92M(":DDDD//EEEEEEEE123/");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("123", f.getComponent3());
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		
		f = new Field92M(":DDDD//EEEEEEEE123/FFFF");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("123", f.getComponent3());
		assertEquals("FFFF", f.getComponent4());
	}

}
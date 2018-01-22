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
 * Test for Field97A and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field97ATest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("97A",
				":abc//def//ggg"
			);
	}
	
	@Test
	public void testField97AString() {
		Field97A f = null;
		
		f = new Field97A("");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));

		f = new Field97A(":");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		
		f = new Field97A("/");
		assertEquals("/", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		
		f = new Field97A("//");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		
		f = new Field97A("://");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		
		f = new Field97A(":/");
		assertEquals("/", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		
		f = new Field97A("///");
		assertEquals("/", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent1()));
	
		f = new Field97A(":///");
		assertEquals("/", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		
		f = new Field97A(":abc//");
		assertEquals("abc", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));

		f = new Field97A(":abc//def");
		assertEquals("abc", f.getComponent1());
		assertEquals("def", f.getComponent2());
		
		f = new Field97A(":abc//def/ggg");
		assertEquals("abc", f.getComponent1());
		assertEquals("def/ggg", f.getComponent2());
	
		f = new Field97A(":abc//def/d/ggg");
		assertEquals("abc", f.getComponent1());
		assertEquals("def/d/ggg", f.getComponent2());
		
		f = new Field97A(":abc//def//ggg");
		assertEquals("abc", f.getComponent1());
		assertEquals("def//ggg", f.getComponent2());
	}

}
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
 * Test for Field98F and similar fields.
 * :S/[S]/S<TIME2>
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field98FTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("98F",
				":RDDT//ONGO160000",
				":abc/def/ggggggggfffaaaaaa"
			);
	}
	
	@Test
	public void testField98FString() {
		Field98F f = null;
		
		f = new Field98F("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field98F(":");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98F("/");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98F("//");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98F("://");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98F(":/");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98F(":abc/");
		assertEquals("abc", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field98F(":abc/def");
		assertEquals("abc", f.getComponent1());
		assertEquals("def", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98F(":abc/def/ggg");
		assertEquals("abc", f.getComponent1());
		assertEquals("def", f.getComponent2());
		assertEquals("ggg", f.getComponent3());
		assertNull(f.getComponent4());
	
		f = new Field98F(":abc/def/aaaagggggg");
		assertEquals("abc", f.getComponent1());
		assertEquals("def", f.getComponent2());
		assertEquals("aaaa", f.getComponent3());
		assertEquals("gggggg", f.getComponent4());
		
		f = new Field98F(":abc/def/ggggggggaaaaaa");
		assertEquals("abc", f.getComponent1());
		assertEquals("def", f.getComponent2());
		assertEquals("gggggggg", f.getComponent3());
		assertEquals("aaaaaa", f.getComponent4());
		
		f = new Field98F(":abc/def/ggggggggfffaaaaaa");
		assertEquals("abc", f.getComponent1());
		assertEquals("def", f.getComponent2());
		assertEquals("ggggggggfff", f.getComponent3());
		assertEquals("aaaaaa", f.getComponent4());
	}
	
	@Test
	public void testParse() {
		Field98F f = new Field98F(":RDDT//ONGO160000");
		assertEquals("RDDT", f.getComponent1());
		assertNull(f.getComponent2());
		assertEquals("ONGO", f.getComponent3());
		assertEquals("160000", f.getComponent4());
	}

}
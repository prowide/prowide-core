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
 * Test for Field23 and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field23Test extends AbstractFieldTest {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(Field23Test.class.getName());

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("23",
				"abcd/efgh/ijk/VEF//aaa"
			);
	}
	
	@Test
	public void testParse23() {
		Field23 f = null;
	
		f = new Field23((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd");
		assertEquals("abcd", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/");
		assertEquals("abcd", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/efgh");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/efgh/");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk/");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk/VEF");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertEquals("VEF", f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk/VEF/");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertEquals("VEF/", f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk/VEF//");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertEquals("VEF//", f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk/VEF//aaa");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertEquals("VEF//aaa", f.getComponent4());
	}

}
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
 * Test for field 22C.
 * 
 * @author sebastian
 * @since 7.9.3
 */
public class Field22CTest extends AbstractFieldTest {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(Field22CTest.class.getName());

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("22C",
				"AAAABB122C4CCCCDD",
				"CNFM2L0007GEBABB"
			);
	}
	
	@Test
	public void testParse22C() {
		Field22C f = null;
	
		f = new Field22C((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field22C("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field22C("AAAA");
		assertEquals("AAAA", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field22C("AAAABB");
		assertEquals("AAAA", f.getComponent1());
		assertEquals("BB", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field22C("AAAABB1234");
		assertEquals("AAAA", f.getComponent1());
		assertEquals("BB", f.getComponent2());
		assertEquals("1234", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field22C("AAAABB1234CCCC");
		assertEquals("AAAA", f.getComponent1());
		assertEquals("BB", f.getComponent2());
		assertEquals("1234", f.getComponent3());
		assertEquals("CCCC", f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field22C("AAAABB1234CCCCDD");
		assertEquals("AAAA", f.getComponent1());
		assertEquals("BB", f.getComponent2());
		assertEquals("1234", f.getComponent3());
		assertEquals("CCCC", f.getComponent4());
		assertEquals("DD", f.getComponent5());		
	}

}
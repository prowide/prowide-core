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
 * Test for Field13D and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field13DTest extends AbstractFieldTest {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(Field13DTest.class.getName());

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("13D",
				"aaaaaabbbbcddddx"
			);
	}
	
	@Test
	public void testField13DString() {
		Field13D f = null;
	
		f = new Field13D((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("a");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aa");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaa");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaa");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaa");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaa");
		assertEquals("aaaaaa", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaab");
		assertEquals("aaaaaa", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaabb");
		assertEquals("aaaaaa", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaabbb");
		assertEquals("aaaaaa", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaabbbb");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaabbbbc");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaabbbbcd");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("d", f.getComponent4());
		
		f = new Field13D("aaaaaabbbbcdd");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("dd", f.getComponent4());
		
		f = new Field13D("aaaaaabbbbcddd");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("ddd", f.getComponent4());
		
		f = new Field13D("aaaaaabbbbcdddd");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("dddd", f.getComponent4());
		
		f = new Field13D("aaaaaabbbbcddddx");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("ddddx", f.getComponent4());
	}

}
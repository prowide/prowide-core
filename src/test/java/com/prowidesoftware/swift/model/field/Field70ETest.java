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
 * Test for Field70E and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field70ETest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("70E",
				":2134//goobar",
				"://goobar"
			);
	}
	
	@Test
	public void testField70EString() {
		Field70E f = new Field70E();
		
		f = new Field70E(":2134//");
		assertEquals("2134", f.getComponent1());
		
		f = new Field70E(":2134//goobar");
		assertEquals("2134", f.getComponent1());
		assertEquals("goobar", f.getComponent2());
		
		f = new Field70E("://goobar");
		assertEquals("goobar", f.getComponent2());
	}
	
	@Test
	public void testField70EString2() {
		Field70E f = new Field70E("://goobar");
		assertEquals("goobar", f.getComponent2());
	}

	@Test
	public void testField70ELines() {
		Field70E f = new Field70E("://goobar");
		assertEquals("goobar", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		assertNull(f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
		assertNull(f.getComponent10());
		assertNull(f.getComponent11());

		f = new Field70E("://goobar\nAAAA");
		assertEquals("goobar", f.getComponent2());
		assertEquals("AAAA", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		assertNull(f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
		assertNull(f.getComponent10());
		assertNull(f.getComponent11());
		
		f = new Field70E("://goobar\nAAAA\nBBBB");
		assertEquals("goobar", f.getComponent2());
		assertEquals("AAAA", f.getComponent3());
		assertEquals("BBBB", f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		assertNull(f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
		assertNull(f.getComponent10());
		assertNull(f.getComponent11());
		
		//remaining lines are ignored by parser
		f = new Field70E("://goobar\nAAAA\nBBBB\nCCCC\nDDDD\nEEEE\nFFFF\nGGGG\nHHHH\nIIII\nJJJJ\nKKKK");
		assertEquals("goobar", f.getComponent2());
		assertEquals("AAAA", f.getComponent3());
		assertEquals("BBBB", f.getComponent4());
		assertEquals("CCCC", f.getComponent5());
		assertEquals("DDDD", f.getComponent6());
		assertEquals("EEEE", f.getComponent7());
		assertEquals("FFFF", f.getComponent8());
		assertEquals("GGGG", f.getComponent9());
		assertEquals("HHHH", f.getComponent10());
		assertEquals("IIII", f.getComponent11());
	}

}
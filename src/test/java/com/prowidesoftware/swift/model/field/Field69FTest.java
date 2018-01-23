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

import java.util.Calendar;

import org.junit.Test;

/**
 * Test for Field69F and similar fields.
 * Pattern: ":4!c//4!c/<DATE4><TIME2> "
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field69FTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("69F",
				":ABC//DEF/20111224131415"
			);
	}
	
	@Test
	public void testParse69F() {
		Field69F f = null;
		
		f = new Field69F((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field69F("ABC");
		assertEquals("ABC", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field69F(":ABC");
		assertEquals("ABC", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field69F("ABC//");
		assertEquals("ABC", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field69F(":ABC//");
		assertEquals("ABC", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field69F(":ABC//DEF");
		assertEquals("ABC", f.getComponent1());
		assertEquals("DEF", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field69F(":ABC//DEF/20111224131415");
		assertEquals("ABC", f.getComponent1());
		assertEquals("DEF", f.getComponent2());
		assertEquals("20111224", f.getComponent3());
		assertEquals(2011, f.getComponent3AsCalendar().get(Calendar.YEAR));
		assertEquals(Calendar.DECEMBER, f.getComponent3AsCalendar().get(Calendar.MONTH));
		assertEquals(24, f.getComponent3AsCalendar().get(Calendar.DAY_OF_MONTH));
		assertEquals("131415", f.getComponent4());
		assertEquals(1, f.getComponent4AsCalendar().get(Calendar.HOUR));
		assertEquals(14, f.getComponent4AsCalendar().get(Calendar.MINUTE));
		assertEquals(15, f.getComponent4AsCalendar().get(Calendar.SECOND));
	}
		
}
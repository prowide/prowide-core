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
 * Test for Field69D and similar fields.
 * Pattern: ":S//<DATE4><TIME2>/S"
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field69DTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("69D",
				":ABC//20111224131415/DEF"
			);
	}
	
	@Test
	public void testParse69D() {
		Field69D f = null;
		
		f = new Field69D((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field69D("ABC");
		assertEquals("ABC", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field69D(":ABC");
		assertEquals("ABC", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field69D("ABC//");
		assertEquals("ABC", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field69D(":ABC//");
		assertEquals("ABC", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field69D(":ABC//20111224");
		assertEquals("ABC", f.getComponent1());
		assertEquals("20111224", f.getComponent2());
		assertEquals(2011, f.getComponent2AsCalendar().get(Calendar.YEAR));
		assertEquals(Calendar.DECEMBER, f.getComponent2AsCalendar().get(Calendar.MONTH));
		assertEquals(24, f.getComponent2AsCalendar().get(Calendar.DAY_OF_MONTH));
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field69D(":ABC//20111224131415");
		assertEquals("ABC", f.getComponent1());
		assertEquals("20111224", f.getComponent2());
		assertEquals(2011, f.getComponent2AsCalendar().get(Calendar.YEAR));
		assertEquals(Calendar.DECEMBER, f.getComponent2AsCalendar().get(Calendar.MONTH));
		assertEquals(24, f.getComponent2AsCalendar().get(Calendar.DAY_OF_MONTH));
		assertEquals("131415", f.getComponent3());
		assertEquals(1, f.getComponent3AsCalendar().get(Calendar.HOUR));
		assertEquals(14, f.getComponent3AsCalendar().get(Calendar.MINUTE));
		assertEquals(15, f.getComponent3AsCalendar().get(Calendar.SECOND));
		assertNull(f.getComponent4());

		f = new Field69D(":ABC//20111224131415/DEF");
		assertEquals("ABC", f.getComponent1());
		assertEquals("20111224", f.getComponent2());
		assertEquals(2011, f.getComponent2AsCalendar().get(Calendar.YEAR));
		assertEquals(Calendar.DECEMBER, f.getComponent2AsCalendar().get(Calendar.MONTH));
		assertEquals(24, f.getComponent2AsCalendar().get(Calendar.DAY_OF_MONTH));
		assertEquals("131415", f.getComponent3());
		assertEquals(13, f.getComponent3AsCalendar().get(Calendar.HOUR_OF_DAY));
		assertEquals(14, f.getComponent3AsCalendar().get(Calendar.MINUTE));
		assertEquals(15, f.getComponent3AsCalendar().get(Calendar.SECOND));
		assertEquals("DEF", f.getComponent4());
	}
		
}	
/*
 * Copyright 2006-2018 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
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
 * Test for Field69F and similar fields.
 * Pattern: ":4!c//4!c/<DATE4><TIME2> "
 *
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
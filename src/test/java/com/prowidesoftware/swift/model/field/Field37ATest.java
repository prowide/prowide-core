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

import org.junit.Test;

/**
 * Test for Field37A and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.4
 */
public class Field37ATest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("37A",
				"1234//131201AFOO/ABC"
			);
	}
	
	/**
	 * N[//<DATE2>cS][/S]
	 */
	@Test
	public void testField37A() {		
		Field37A f = new Field37A((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("1234");
		assertEquals("1234", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("1234//");
		assertEquals("1234", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field37A("1234//131201");
		assertEquals("1234", f.getComponent1());
		assertEquals("131201", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("1234//131201A");
		assertEquals("1234", f.getComponent1());
		assertEquals("131201", f.getComponent2());
		assertEquals("A", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("1234//131201AFOO");
		assertEquals("1234", f.getComponent1());
		assertEquals("131201", f.getComponent2());
		assertEquals("A", f.getComponent3());
		assertEquals("FOO", f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field37A("1234//131201AFOO/ABC");
		assertEquals("1234", f.getComponent1());
		assertEquals("131201", f.getComponent2());
		assertEquals("A", f.getComponent3());
		assertEquals("FOO", f.getComponent4());
		assertEquals("ABC", f.getComponent5());
	}

}
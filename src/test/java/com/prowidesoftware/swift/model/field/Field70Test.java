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
 * Test for Field70 and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field70Test extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("70",
				"a\nb\nc\nd"
			);
	}
	
	@Test
	public void testField70() {		
		Field70 f = new Field70((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field70("a");
		assertEquals("a", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field70("a\nb");
		assertEquals("a", f.getComponent1());
		assertEquals("b", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field70("a\nb\nc");
		assertEquals("a", f.getComponent1());
		assertEquals("b", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field70("a\nb\nc\nd");
		assertEquals("a", f.getComponent1());
		assertEquals("b", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("d", f.getComponent4());
	}
	
}
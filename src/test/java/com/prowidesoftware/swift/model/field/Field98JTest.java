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
 * Test for field 98J and similar fields.
 * 
 * @author sebastian
 * @since 7.9.3
 */
public class Field98JTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("98J",
				":FOO//121212121111/ABCDUSAAXXX"
			);
	}
	
	@Test
	public void testField98JString() {
		Field98J f = null;
		
		f = new Field98J("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field98J(":");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98J("//");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98J("://");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98J(":abc//");
		assertEquals("abc", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field98J(":abc//11111111");
		assertEquals("abc", f.getComponent1());
		assertEquals("11111111", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field98J(":abc//111111112222");
		assertEquals("abc", f.getComponent1());
		assertEquals("11111111", f.getComponent2());
		assertEquals("2222", f.getComponent3());
		assertNull(f.getComponent4());
	
		f = new Field98J(":abc//111111112222/foo");
		assertEquals("abc", f.getComponent1());
		assertEquals("11111111", f.getComponent2());
		assertEquals("2222", f.getComponent3());
		assertEquals("foo", f.getComponent4());
	}

}
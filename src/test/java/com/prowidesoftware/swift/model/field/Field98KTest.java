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
 * Test for field 98K and similar fields.
 * 
 * @author sebastian
 * @since 7.9.3
 */
public class Field98KTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("98K",
				":FOO/AAA/121212121111/TEXT"
			);
	}
	
	@Test
	public void testField98KString() {
		Field98K f = null;
		
		f = new Field98K("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field98K(":abc");
		assertEquals("abc", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field98K(":abc/foo");
		assertEquals("abc", f.getComponent1());
		assertEquals("foo", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field98K(":abc/foo/11111111");
		assertEquals("abc", f.getComponent1());
		assertEquals("foo", f.getComponent2());
		assertEquals("11111111", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
	
		f = new Field98K(":abc/foo/111111112222");
		assertEquals("abc", f.getComponent1());
		assertEquals("foo", f.getComponent2());
		assertEquals("11111111", f.getComponent3());
		assertEquals("2222", f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field98K(":abc/foo/111111112222/text");
		assertEquals("abc", f.getComponent1());
		assertEquals("foo", f.getComponent2());
		assertEquals("11111111", f.getComponent3());
		assertEquals("2222", f.getComponent4());
		assertEquals("text", f.getComponent5());
	}

}
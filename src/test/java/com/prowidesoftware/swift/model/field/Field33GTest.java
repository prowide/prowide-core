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
 * Test for Field33G and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.4
 */
public class Field33GTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("33G",
				"USD123,4FOO"
			);
	}
	
	/**
	 * cNS<CUR>N
	 */
	@Test
	public void testField33G() {		
		Field33G f = new Field33G((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());

		f = new Field33G("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());

		f = new Field33G("USD");
		assertEquals("USD", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());

		f = new Field33G("USD123,4");
		assertEquals("USD", f.getComponent1());
		assertEquals("123,4", f.getComponent2());
		assertNull(f.getComponent3());
		
		f = new Field33G("USD123,4FOO");
		assertEquals("USD", f.getComponent1());
		assertEquals("123,4", f.getComponent2());
		assertEquals("FOO", f.getComponent3());
		
		f = new Field33G("123,4FOO");
		assertNull(f.getComponent1());
		assertEquals("123,4", f.getComponent2());
		assertEquals("FOO", f.getComponent3());
	}

}
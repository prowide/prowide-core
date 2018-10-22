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
 * Test for Field23 and similar fields.
 *
 * @since 6.0
 */
public class Field23Test extends AbstractFieldTest {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(Field23Test.class.getName());

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("23",
				"abcd/efgh/ijk/VEF//aaa"
			);
	}
	
	@Test
	public void testParse23() {
		Field23 f = null;
	
		f = new Field23((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd");
		assertEquals("abcd", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/");
		assertEquals("abcd", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/efgh");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/efgh/");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk/");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk/VEF");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertEquals("VEF", f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk/VEF/");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertEquals("VEF/", f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk/VEF//");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertEquals("VEF//", f.getComponent4());
		
		f = new Field23("abcd/efgh/ijk/VEF//aaa");
		assertEquals("abcd", f.getComponent1());
		assertEquals("efgh", f.getComponent2());
		assertEquals("ijk", f.getComponent3());
		assertEquals("VEF//aaa", f.getComponent4());
	}

}
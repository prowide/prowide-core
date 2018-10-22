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
 * Test for Field13D and similar fields.
 *
 * @since 6.0
 */
public class Field13DTest extends AbstractFieldTest {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(Field13DTest.class.getName());

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("13D",
				"aaaaaabbbbcddddx"
			);
	}
	
	@Test
	public void testField13DString() {
		Field13D f = null;
	
		f = new Field13D((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("a");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aa");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaa");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaa");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaa");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaa");
		assertEquals("aaaaaa", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaab");
		assertEquals("aaaaaa", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaabb");
		assertEquals("aaaaaa", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaabbb");
		assertEquals("aaaaaa", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaabbbb");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaabbbbc");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field13D("aaaaaabbbbcd");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("d", f.getComponent4());
		
		f = new Field13D("aaaaaabbbbcdd");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("dd", f.getComponent4());
		
		f = new Field13D("aaaaaabbbbcddd");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("ddd", f.getComponent4());
		
		f = new Field13D("aaaaaabbbbcdddd");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("dddd", f.getComponent4());
		
		f = new Field13D("aaaaaabbbbcddddx");
		assertEquals("aaaaaa", f.getComponent1());
		assertEquals("bbbb", f.getComponent2());
		assertEquals("c", f.getComponent3());
		assertEquals("ddddx", f.getComponent4());
	}

}
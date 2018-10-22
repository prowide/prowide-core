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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author www.prowidesoftware.com
 */
public class Field41DTest extends AbstractFieldTest {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(Field41DTest.class.getName());
	Field41D f = null;

	@Before
	public void setup() {
		f = null;
	}

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("41D",
				"ANY BANK\r\nBY NEGOTIATION",
				"A\r\nB\r\nC\r\nD\r\nE"
			);
	}
	
	@Test
	public void testParse1() {
		f = new Field41D("ANY BANK\r\n" + "BY NEGOTIATION\n");
		assertNotNull(f.getComponent1());
		assertNotNull(f.getComponent5());
	}

	@Test
	public void testParse2() {
		f = new Field41D("A");
		assertEquals("A", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
	}

	@Test
	public void testParse3() {
		f = new Field41D("A\r\nB");
		assertEquals("A", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertEquals("B", f.getComponent5());
	}

	@Test
	public void testParse4() {
		f = new Field41D("A\r\nB\r\nC");
		assertEquals("A", f.getComponent1());
		assertEquals("B", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertEquals("C", f.getComponent5());
	}

	@Test
	public void testParse5() {
		f = new Field41D("A\r\nB\r\nC\r\nD");
		assertEquals("A", f.getComponent1());
		assertEquals("B", f.getComponent2());
		assertEquals("C", f.getComponent3());
		assertNull(f.getComponent4());
		assertEquals("D", f.getComponent5());
	}

	@Test
	public void testParse6() {
		f = new Field41D("A\r\nB\r\nC\r\nD\r\nE");
		assertEquals("A", f.getComponent1());
		assertEquals("B", f.getComponent2());
		assertEquals("C", f.getComponent3());
		assertEquals("D", f.getComponent4());
		assertEquals("E", f.getComponent5());
	}

	@Test
	public void testParse7() {
		f = new Field41D("A\r\nB\r\nC\r\nD\r\nE\r\nFOO");
		assertEquals("A", f.getComponent1());
		assertEquals("B", f.getComponent2());
		assertEquals("C", f.getComponent3());
		assertEquals("D", f.getComponent4());
		assertEquals("E", f.getComponent5());
	}

	@Test
	public void testName() throws Exception {
		String s = "c1\nc5";
		Field41D f = new Field41D(s);
		assertFalse(StringUtils.isEmpty(f.getComponent5()));
	}
	
}
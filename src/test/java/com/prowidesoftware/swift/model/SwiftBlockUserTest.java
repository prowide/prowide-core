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
package com.prowidesoftware.swift.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * User blocks tests.
 *
 * @since 4.0
 */
public class SwiftBlockUserTest {

	private SwiftMessage   m   = null;
	private SwiftBlockUser buS = null;
	private SwiftBlockUser bu9 = null;

	@Before
	public void setUp() {
		m   = new SwiftMessage();
		buS = new SwiftBlockUser("S");
		bu9 = new SwiftBlockUser("9");
	}

	@Test 
	public void test_ValidNames() {
		// numbers 0 or 6 are valid
		assertTrue(SwiftBlockUser.isValidName(0));
		assertTrue(SwiftBlockUser.isValidName(6));

		// numbers 0 or 6 are valid
		assertTrue(SwiftBlockUser.isValidName("0"));
		assertTrue(SwiftBlockUser.isValidName("6"));

		// single letters are valid
		assertTrue(SwiftBlockUser.isValidName("A"));
		assertTrue(SwiftBlockUser.isValidName("z"));
	}

	@Test
	public void test_InValidNames() {
		// numbers 1-5 are invalid
		assertFalse(SwiftBlockUser.isValidName(1));
		assertFalse(SwiftBlockUser.isValidName(2));
		assertFalse(SwiftBlockUser.isValidName(3));
		assertFalse(SwiftBlockUser.isValidName(4));
		assertFalse(SwiftBlockUser.isValidName(5));

		// srings 1-5 are invalid
		assertFalse(SwiftBlockUser.isValidName("1"));
		assertFalse(SwiftBlockUser.isValidName("2"));
		assertFalse(SwiftBlockUser.isValidName("3"));
		assertFalse(SwiftBlockUser.isValidName("4"));
		assertFalse(SwiftBlockUser.isValidName("5"));

		// other strings are invalid
		assertFalse(SwiftBlockUser.isValidName(""));
		assertFalse(SwiftBlockUser.isValidName("AB"));
	}

	@Test
	public void test_block_S() {
		m.addUserBlock(buS);
		assertTrue(m.getUserBlock("S") == buS);
		m.removeUserBlock("S");
	}

	@Test
	public void test_addBlock_9() {
		assertEquals(null, m.getUserBlocks());
		m.addUserBlock(bu9);
		assertEquals(1, m.getUserBlocks().size());
		assertTrue(m.getUserBlock(9) == bu9);
		m.removeUserBlock(9);
		assertEquals(0, m.getUserBlocks().size());
	}

	@Test
	public void test_addBlock_9String() {
		m.addUserBlock(bu9);
		assertTrue(m.getUserBlock("9") == bu9);
		m.removeUserBlock("9");
	}

	@Test
	public void test_getBlock_1() {
		assertNull(m.getUserBlock(1));
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_removeBlock_1() {
		// FIXME why does this test fail? IAE is thrown and expected...
		m.removeUserBlock(1);
	}
	
	/**
	 * Remove UserBlock using a string for block naming
	 */
	@Test
	public void testRemoveBlockUserStringName() throws IOException {
		final SwiftMessage m = new SwiftMessage(false);
		assertEquals(0, m.getBlockCount());
		
		final SwiftBlockUser bu = new SwiftBlockUser("S");
		bu.append(new Tag("120:asdadad"));
		m.addUserBlock(bu);
		assertEquals(1, m.getBlockCount());
		assertEquals(bu, m.getUserBlock("S"));
		
		m.removeUserBlock("S");
		assertEquals(0, m.getBlockCount());
		assertNull(m.getUserBlock("S"));
	}
	
	/**
	 * Remove UserBlock using an integer for block naming
	 */
	@Test
	public void testRemoveBlockUserNumberName() throws IOException {
		final SwiftMessage m = new SwiftMessage(false);
		assertEquals(0, m.getBlockCount());
		
		final SwiftBlockUser bu = new SwiftBlockUser(6);
		bu.append(new Tag("120:asdadad"));
		m.addUserBlock(bu);
		assertEquals(1, m.getBlockCount());
		assertEquals(bu, m.getUserBlock(6));
		
		m.removeUserBlock(6);
		assertEquals(0, m.getBlockCount());
		assertNull(m.getUserBlock(6));
	}
}

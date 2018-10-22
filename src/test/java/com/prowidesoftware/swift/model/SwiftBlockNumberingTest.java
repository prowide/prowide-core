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

import org.junit.Test;

/**
 * Blocks numbering tests.
 *
 * @since 4.0
 */
public class SwiftBlockNumberingTest {

	@Test 
	public void testNumber_1() {
		SwiftBlock1 b = new SwiftBlock1();
		assertEquals(Integer.valueOf(1), b.getNumber());
		assertEquals("1", b.getName());
	}

	@Test 
	public void testNumber_2Input() {
		SwiftBlock2 b = new SwiftBlock2Input();
		assertEquals(Integer.valueOf(2), b.getNumber());
		assertEquals("2", b.getName());
	}

	@Test 
	public void testNumber_2Output() {
		SwiftBlock2 b = new SwiftBlock2Output();
		assertEquals(Integer.valueOf(2), b.getNumber());
		assertEquals("2", b.getName());
	}

	@Test 
	public void testNumber_3() {
		SwiftBlock3 b = new SwiftBlock3();
		assertEquals(Integer.valueOf(3), b.getNumber());
		assertEquals("3", b.getName());
	}

	@Test 
	public void testNumber_4() {
		SwiftBlock4 b = new SwiftBlock4();
		assertEquals(Integer.valueOf(4), b.getNumber());
		assertEquals("4", b.getName());
	}

	@Test 
	public void testNumber_5() {
		SwiftBlock5 b = new SwiftBlock5();
		assertEquals(Integer.valueOf(5), b.getNumber());
		assertEquals("5", b.getName());
	}

	@Test 
	public void testNumber_9() {
		SwiftBlockUser b = new SwiftBlockUser(9);
		assertEquals(Integer.valueOf(9), b.getNumber());
		assertEquals("9", b.getName());
	}

	@Test 
	public void testNumber_S() {
		SwiftBlockUser b = new SwiftBlockUser("S");
		assertEquals(Integer.valueOf(-1), b.getNumber());
		assertEquals("S", b.getName());
	}
}

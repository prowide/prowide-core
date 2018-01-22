/* 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
*/
package com.prowidesoftware.swift.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Blocks numbering tests.
 * 
 * @author www.prowidesoftware.com
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

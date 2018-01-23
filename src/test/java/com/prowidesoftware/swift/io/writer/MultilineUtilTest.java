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
package com.prowidesoftware.swift.io.writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

/**
 * Swift writer tests
 * 
 * @author www.prowidesoftware.com
 * @since 4.0
 */
public class MultilineUtilTest {

	private MultilineUtil util;

	@Before
	public void setUp() {
		this.util = new MultilineUtil();
	}
	
	/**
	 * Returns the same array if it is empty
	 *
	 */
	@Test 
	public void testEmpty() {
		final String [] lines = new String[0];
		String[] got = util.removeInnerEmptyLines(lines);
		assertSame(lines, got);
	}
	
	@Test 
	public void testReturnEmpty() {
		final String [] lines = new String[10];
		String[] got = util.removeInnerEmptyLines(lines);
		assertNotNull(got);
		assertEquals(0, got.length);
	}
	
	@Test 
	public void testReturnEmptyKeep() {
		final String [] lines = new String[10];
		String[] got = util.removeInnerEmptyLines(lines, true);
		assertNotNull(got);
		assertEquals(10, got.length);
	}
	
	@Test 
	public void testSimple1() {
		final String [] lines = new String[3];
		lines[0] = "foo";
		lines[1] = "    ";
		lines[2] = "bar";
		String[] got = util.removeInnerEmptyLines(lines);
		assertNotNull(got);
		assertEquals(2, got.length);
		assertEquals("foo", got[0]);
		assertEquals("bar", got[1]);
	}
}

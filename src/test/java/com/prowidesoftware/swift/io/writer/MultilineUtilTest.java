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
package com.prowidesoftware.swift.io.writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

/**
 * Swift writer tests
 *
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

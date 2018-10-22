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

import java.util.List;

import org.junit.Test;

/**
 * Test for fields getLine API.
 *
 * @since 7.7
 */
public class GetLineTest {

	/**
	 * Simplest case
	 */
	@Test
	public void test01() {
		final Field35B f = new Field35B("ISIN HELLO\nAAAA\nBBBB\nCCCC\nDDDD\nEEEE\nFFFF\nGGGG");
		assertEquals("ISIN HELLO", f.getLine(1));
		assertEquals("AAAA", f.getLine(2));
		assertEquals("BBBB", f.getLine(3));
		assertEquals("CCCC", f.getLine(4));
		assertEquals("DDDD", f.getLine(5));
		//remaining lines are ignored by copy constructor
		assertNull(f.getLine(6));
		assertNull(f.getLine(7));
		assertNull(f.getLine(8));
	}

	/**
	 * Missing component 2
	 */
	@Test
	public void test02() {
		final Field35B f = new Field35B("ISIN \nAAAA\nBBBB\nCCCC\nDDDD");
		assertEquals("ISIN", f.getLine(1));
		assertEquals("AAAA", f.getLine(2));
		assertEquals("BBBB", f.getLine(3));
		assertEquals("CCCC", f.getLine(4));
		assertEquals("DDDD", f.getLine(5));
	}

	/**
	 * Missing first line
	 */
	@Test
	public void test03() {
		final Field35B f = new Field35B("AAAA\nBBBB\nCCCC\nDDDD");
		assertNull(f.getLine(1));
		assertEquals("AAAA", f.getLine(2));
		assertEquals("BBBB", f.getLine(3));
		assertEquals("CCCC", f.getLine(4));
		assertEquals("DDDD", f.getLine(5));
	}

	/**
	 * Missing first two lines
	 */
	@Test
	public void test04() {
		final Field35B f = new Field35B("BBBB\nCCCC\nDDDD");
		assertNull(f.getLine(1));
		assertEquals("BBBB", f.getLine(2));
		assertEquals("CCCC", f.getLine(3));
		assertEquals("DDDD", f.getLine(4));
		assertNull(f.getLine(5));
	}

	/**
	 * Using offset
	 */
	@Test
	public void test05() {
		final Field35B f = new Field35B("ISIN HELLO\nAAAA\nBBBB\nCCCC\nDDDD");
		assertEquals("AAAA", f.getLine(1, Field35B.DESCRIPTION));
		assertEquals("BBBB", f.getLine(2, Field35B.DESCRIPTION));
		assertEquals("CCCC", f.getLine(3, Field35B.DESCRIPTION));
		assertEquals("DDDD", f.getLine(4, Field35B.DESCRIPTION));
	}

	/**
	 * Using offset and missing fields
	 */
	@Test
	public void test06() {
		final Field35B f = new Field35B("ISIN \nAAAA\nBBBB\nCCCC\nDDDD");
		assertEquals("AAAA", f.getLine(1, Field35B.DESCRIPTION));
		assertEquals("BBBB", f.getLine(2, Field35B.DESCRIPTION));
		assertEquals("CCCC", f.getLine(3, Field35B.DESCRIPTION));
		assertEquals("DDDD", f.getLine(4, Field35B.DESCRIPTION));
	}

	/**
	 * Using offset and missing fields
	 */
	@Test
	public void test07() {
		final Field35B f = new Field35B("AAAA\nBBBB\nCCCC\nDDDD");
		assertEquals("AAAA", f.getLine(1, Field35B.DESCRIPTION));
		assertEquals("BBBB", f.getLine(2, Field35B.DESCRIPTION));
		assertEquals("CCCC", f.getLine(3, Field35B.DESCRIPTION));
		assertEquals("DDDD", f.getLine(4, Field35B.DESCRIPTION));
	}

	/**
	 * Using offset
	 */
	@Test
	public void test08() {
		final Field35B f = new Field35B("ISIN HELLO\nAAAA\nBBBB\nCCCC\nDDDD");
		/*
		 * plain lines
		 */
		assertEquals("ISIN HELLO", f.getLine(1));
		assertEquals("AAAA", f.getLine(2));
		assertEquals("BBBB", f.getLine(3));
		assertEquals("CCCC", f.getLine(4));
		assertEquals("DDDD", f.getLine(5));
		/*
		 * lines numbered since de description component
		 */
		assertEquals("AAAA", f.getLine(1, Field35B.DESCRIPTION));
		assertEquals("BBBB", f.getLine(2, Field35B.DESCRIPTION));
		assertEquals("CCCC", f.getLine(3, Field35B.DESCRIPTION));
		assertEquals("DDDD", f.getLine(4, Field35B.DESCRIPTION));
	}

	/**
	 * Empty
	 */
	@Test
	public void test09() {
		final Field35B f = new Field35B();
		assertNull(f.getLine(1));
		assertNull(f.getLine(2));
		assertNull(f.getLine(3));
		assertNull(f.getLine(4));
		assertNull(f.getLine(5));
	}

	/**
	 * Empty
	 */
	@Test
	public void test10() {
		final Field35B f = new Field35B("");
		assertNull(f.getLine(1));
		assertNull(f.getLine(2));
		assertNull(f.getLine(3));
		assertNull(f.getLine(4));
		assertNull(f.getLine(5));
	}

	/**
	 * Null
	 */
	@Test
	public void test11() {
		final Field35B f = new Field35B((String)null);
		assertNull(f.getLine(1));
		assertNull(f.getLine(2));
		assertNull(f.getLine(3));
		assertNull(f.getLine(4));
		assertNull(f.getLine(5));
	}

	/**
	 * Empty
	 */
	@Test
	public void test12() {
		final Field59 f = new Field59("");
		assertNull(f.getLine(1));
		assertNull(f.getLine(2));
		assertNull(f.getLine(3));
		assertNull(f.getLine(4));
		assertNull(f.getLine(5));
	}

	/**
	 * Null
	 */
	@Test
	public void test13() {
		final Field59 f = new Field59((String)null);
		assertNull(f.getLine(1));
		assertNull(f.getLine(2));
		assertNull(f.getLine(3));
		assertNull(f.getLine(4));
		assertNull(f.getLine(5));
	}

	/**
	 * Using offset
	 */
	@Test
	public void test14() {
		final Field35B f = new Field35B("ISIN HELLO\nAAAA\nBBBB\nCCCC\nDDDD");

		assertEquals("ISIN HELLO", f.getLinesBetween(1, 1).get(0));
		assertEquals(1, f.getLinesBetween(1, 1).size());

		assertEquals("AAAA", f.getLinesBetween(2, 2).get(0));
		assertEquals(1, f.getLinesBetween(2, 2).size());

		assertEquals("ISIN HELLO", f.getLinesBetween(1, 2).get(0));
		assertEquals("AAAA", f.getLinesBetween(1, 2).get(1));
		assertEquals(2, f.getLinesBetween(1, 2).size());

		assertEquals("BBBB", f.getLinesBetween(3, 5, Field35B.ISIN).get(0));
		assertEquals("CCCC", f.getLinesBetween(3, 5, Field35B.ISIN).get(1));
		assertEquals("DDDD", f.getLinesBetween(3, 5, Field35B.ISIN).get(2));
		assertEquals(3, f.getLinesBetween(3, 5, Field35B.ISIN).size());
	}

	@Test
	public void test15() {
		final Field53B f = new Field53B("/1234\nBANK");
		assertEquals("/1234", f.getLine(1));
	}

	@Test
	public void test16() {
		final Field53B f = new Field53B("//1234\nBANK");
		assertEquals("//1234", f.getLine(1));
	}

	@Test
	public void test17() {
		final Field50H f = new Field50H(
				"/8754219990\n" +
						"MAG-NUM INC.\n" +
						"GENERAL A/C\n" +
						"BANHOFFSTRASSE 30\n" +
				"ZURICH, SWITZERLAND");
		assertEquals("/8754219990", f.getLine(1));
		assertEquals("/8754219990", f.getLine(1, 0));
		assertEquals("MAG-NUM INC.", f.getLine(2));
		assertEquals("MAG-NUM INC.", f.getLine(1, Field50H.NAME_AND_ADDRESS));
		assertEquals("GENERAL A/C", f.getLine(2, Field50H.NAME_AND_ADDRESS));
	}
	
	@Test
	public void test18() {
		Field95Q f = new Field95Q(":INVE//JOE DOE");
		assertEquals(":INVE//JOE DOE", f.getLine(1));
	}

	@Test
	public void test19() {
		Field95Q f = new Field95Q(":INVE//JOE DOE");
		assertEquals("JOE DOE", f.getLine(1, Field95Q.NAME_AND_ADDRESS));
	}

	@Test
	public void test19b() {
		Field95Q f = new Field95Q(":INVE//JOE DOE\n/FOO");
		List<String> lines = f.getLinesBetween(1, 2, Field95Q.NAME_AND_ADDRESS);
		/*
		 * the separators ":" and "//" are removed
		 */
		assertEquals("JOE DOE", lines.get(0));
		/*
		 * the "/" prefix is kept
		 */
		assertEquals("/FOO", lines.get(1));
	}

	@Test
	public void test19c() {
		Field95Q f = new Field95Q(":INVE//JOE DOE\n/FOO");
		List<String> lines = f.getLinesBetween(1, 2);
		/*
		 * the separators ":" and "//" are kept because there is no component offset involved
		 */
		assertEquals(":INVE//JOE DOE", lines.get(0));
		/*
		 * the "/" prefix is kept
		 */
		assertEquals("/FOO", lines.get(1));
	}

	@Test
	public void test19d() throws Exception {
		Field35B f = new Field35B("/US/31392EXH8\nFEDERAL NATL MTG ASSN");
		assertEquals("/US/31392EXH8", f.getLine(2));
		/*
		 * the starting slash will not be returned because the query includes an offset
		 */
		assertEquals("US/31392EXH8", f.getLine(1, Field35B.DESCRIPTION));
	}

	@Test
	public void test20() {
		Field50K f = new Field50K("/12345");
		assertEquals(1, f.getLines().size());
		assertEquals("/12345", f.getLine(1));
		assertNull(f.getLine(2));
	}

	@Test
	public void test21() {
		Field50K f = new Field50K("ABC");
		assertEquals(1, f.getLines().size());
		assertNull(f.getLine(1));
		assertEquals("ABC", f.getLine(2));
	}

	@Test
	public void test22() {
		Field50K f = new Field50K("ABC");
		assertEquals(1, f.getLines().size());
		assertNull(f.getLine(1));
		assertEquals("ABC", f.getLine(2));
	}
}

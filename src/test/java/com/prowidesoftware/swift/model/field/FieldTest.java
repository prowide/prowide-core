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

import com.prowidesoftware.swift.model.Tag;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Test for base class Field.
 *
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class FieldTest {

	@Test
	public void testSetComponent() {
		final Field f = new Field70E();
		f.setComponent(2, "world");
		assertNull(f.getComponent(1));
		assertEquals("world", f.getComponent(2));
		assertNull(f.getComponent(3));
		assertNull(f.getComponent(4));
		assertNull(f.getComponent(5));

		f.setComponent(2, "hello");
		assertNull(f.getComponent(1));
		assertEquals("hello", f.getComponent(2));
		assertNull(f.getComponent(3));
		assertNull(f.getComponent(4));
		assertNull(f.getComponent(5));

		f.setComponent(1, "cruel");
		assertEquals("cruel", f.getComponent(1));
		assertEquals("hello", f.getComponent(2));
		assertNull(f.getComponent(3));
		assertNull(f.getComponent(4));
		assertNull(f.getComponent(5));

		f.setComponent(2, null);
		assertEquals("cruel", f.getComponent(1));
		assertEquals(null, f.getComponent(2));
		assertNull(f.getComponent(3));
		assertNull(f.getComponent(4));
		assertNull(f.getComponent(5));

		f.setComponent(5, "bye");
		assertEquals("cruel", f.getComponent(1));
		assertNull(f.getComponent(2));
		assertNull(f.getComponent(3));
		assertNull(f.getComponent(4));
		assertEquals("bye", f.getComponent(5));
	}

	@Test
	public void testJoinComponents_01() {
		Field f = new Field70E();
		f.setComponent(1, "1");
		f.setComponent(2, "2");
		f.setComponent(3, "3");
		f.setComponent(4, "4");
		f.setComponent(5, "");

		assertEquals("1234", f.joinComponents(0, false));
		assertEquals("123", f.joinComponents(0, true));
		assertEquals("234", f.joinComponents(1, false));
		assertEquals("23", f.joinComponents(1, true));
		assertEquals("34", f.joinComponents(2, false));
		assertEquals("3", f.joinComponents(2, true));
		assertEquals("4", f.joinComponents(3, false));
		assertEquals("", f.joinComponents(3, true));
		assertEquals("", f.joinComponents(4, false));
		assertEquals("", f.joinComponents(4, true));
		assertEquals("", f.joinComponents(5, false));
		assertEquals("", f.joinComponents(5, true));

		f = new Field70E();
		f.setComponent(1, "1");
		f.setComponent(2, "2");
		f.setComponent(3, "3");
		f.setComponent(4, "4");
		f.setComponent(5, null);

		assertEquals("1234", f.joinComponents(0, false));
		assertEquals("123", f.joinComponents(0, true));
		assertEquals("234", f.joinComponents(1, false));
		assertEquals("23", f.joinComponents(1, true));
		assertEquals("34", f.joinComponents(2, false));
		assertEquals("3", f.joinComponents(2, true));
		assertEquals("4", f.joinComponents(3, false));
		assertEquals("", f.joinComponents(3, true));
		assertEquals("", f.joinComponents(4, false));
		assertEquals("", f.joinComponents(4, true));
		assertEquals("", f.joinComponents(5, false));
		assertEquals("", f.joinComponents(5, true));
	}

	@Test
	public void testJoinComponents_02() {
		final Field32A f = new Field32A();
		f.setAmount("123,");
		assertEquals("123,", f.joinComponents(0));
	}

	@Test
	public void testFindComponentStartingWith() {
		final Field f = new Field70E();
		f.setComponent(1, "1234");
		f.setComponent(2, "2345");
		f.setComponent(3, "hello world");
		f.setComponent(4, "4567");
		f.setComponent(5, "8901");

		assertEquals("hello world", f.findComponentStartingWith("hello"));
		assertNull(f.findComponentStartingWith("foo"));
	}

	@Test
	public void testGetValueByCodeword() {
		final Field f = new Field70E();
		f.setComponent(1, "/ACC/BLABLABLA");
		f.setComponent(2, "//BLABLABLA");
		f.setComponent(3, "/INS/CITIUS33MIA");
		f.setComponent(4, "//BLABLABLA");

		assertEquals("CITIUS33MIA", f.getValueByCodeword("INS"));
		assertNull(f.getValueByCodeword("foo"));
	}

	@Test
	public void testGetName() {
		final Field32A f = new Field32A("");
		assertEquals("32A", f.getName());
	}

	@Test
	public void testLabel1() {
		assertEquals("Transaction Reference Number", Field.getLabel("20", "199", null, new Locale("en")));
	}

	@Test
	public void testLabel2() {
		assertEquals("Currency", Field.getLabel("11A", "500", "B1", new Locale("en")));
	}

	@Test
	//TODO add API for partyfields structure like field 83J
	public void testGetValueByCodewordWorkaround() {
		final Field83J f = new Field83J("/ACCT/006-6005XXXXXX\n/NAME/JF ASIAN TOTAL RETURN BOND FUND");
		assertEquals("006-6005XXXXXX", StringUtils.substringBetween(f.getComponent1(), "/ACCT/", "\n"));
	}

	@Test
	public void testTicket31() {
		final Field32A f = new Field32A();
		final BigDecimal set = new BigDecimal(1000);
		f.setAmount(set);
		final BigDecimal got = f.getAmountBigDecimal();
		assertEquals(set, got);
	}

	@Test
	public void testLetterOption() throws Exception {
		assertEquals(Character.valueOf('A'), new Field59A().letterOption());
		assertEquals(null, new Field59().letterOption());
	}

	@Test
	public void testIsLetterOption() throws Exception {
		assertTrue(new Field59A().isLetterOption('A'));
		assertTrue(new Field56B().isLetterOption('B'));
		assertFalse(new Field59().isLetterOption('B'));
	}

	@Test
	public void testNumericConversion() {
		final Field32A f = new Field32A("130901USD10,1");
		assertEquals(new BigDecimal("10.1"), f.getAmountBigDecimal());
		assertEquals(new BigDecimal("10.1"), f.getComponent3AsNumber());
	}

	@Test
	public void testReflection_01() {
		Field f = Field.getField(new Tag("20C", "foo"));
		assertNotNull(f);
	}

	@Test
	public void testReflection_02() {
		Field f = Field.getField("20C", "foo");
		assertNotNull(f);
	}

	@Test
	public void testReflection_03() {
		Field f = Field.getField("20C", null);
		assertNotNull(f);
	}

	@Test
	public void testValidName() {
		/*
		 * ok
		 */
		assertTrue(Field.validName("20"));
		assertTrue(Field.validName("20C"));
		assertTrue(Field.validName("22a"));
		assertTrue(Field.validName("108"));
		/*
		 * not ok
		 */
		assertFalse(Field.validName("2022"));
		assertFalse(Field.validName("20b"));
		assertFalse(Field.validName("20CD"));
		assertFalse(Field.validName("a20C"));
		assertFalse(Field.validName("2"));
		assertFalse(Field.validName("C"));
		assertFalse(Field.validName(""));
		assertFalse(Field.validName(null));
	}
	

	@Test
	public void testLines_01() {
		Field95Q f = new Field95Q(":INVE//JOE DOE");
		assertEquals(":INVE//JOE DOE", f.getLine(1));
	}

	@Test
	public void testLines_02() {
		Field95Q f = new Field95Q(":INVE//JOE DOE");
		assertEquals("JOE DOE", f.getLine(1, Field95Q.NAME_AND_ADDRESS));
	}

	@Test
	public void testLines_03() {
		Field50K f = new Field50K("/12345");
		assertEquals(1, f.getLines().size());
		assertEquals("/12345", f.getLine(1));
		assertNull(f.getLine(2));
	}

	@Test
	public void testLines_04() {
		Field50K f = new Field50K("ABC");
		assertEquals(1, f.getLines().size());
		assertNull(f.getLine(1));
		assertEquals("ABC", f.getLine(2));
	}

	@Test
	public void testLines_05() {
		Field50K f = new Field50K("ABC");
		assertEquals(1, f.getLines().size());
		assertNull(f.getLine(1));
		assertEquals("ABC", f.getLine(2));
	}
	
	@Test
	public void testConstructorFromTag_01() {
		Tag t = new Tag("32A", "121212USD1234,5");
		Field32A f = new Field32A(t);
		assertEquals("121212", f.getComponent1());
		assertEquals("USD", f.getComponent2());
		assertEquals("1234,5", f.getComponent3());
	}

	@Test
	public void testConstructorFromTag_02() {
		Tag t = new Tag("20", "121212USD1234,5");
		try {
			new Field32A(t);
			fail("exception expected");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testIsValues() {
		Field95Q f = new Field95Q(":INVE//JOE DOE");
		assertTrue(f.is("FOO", "INVE", "ABC"));
		assertFalse(f.is("FOO", "BAR", "ABC"));
	}
	
}
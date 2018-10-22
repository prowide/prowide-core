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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tag tests.
 *
 * @since 4.0
 */
public class TagTest {

	@Test 
	public void test1() {
		Tag t = new Tag("");
		assertNull(t.getName());
		assertNull(t.getValue());
	}

	@Test 
	public void test2() {
		Tag t = new Tag(":foobar");
		assertEquals("foobar", t.getValue());
		assertNull(t.getName());
	}

	@Test 
	public void test3() {
		Tag t = new Tag("foobar:");
		assertEquals("foobar", t.getName());
		assertNull(t.getValue());
	}

	@Test 
	public void test4() {
		Tag t = new Tag("name:value");
		assertEquals("name", t.getName());
		assertEquals("value", t.getValue());
	}

	@Test 
	public void test5() {
		Tag t = new Tag("value");
		assertEquals("value", t.getValue());
		assertNull(t.getName());
	}

	@Test 
	public void test6() {
		Tag t = new Tag("a:b");
		assertEquals("a", t.getName());
		assertEquals("b", t.getValue());
	}

	@Test 
	public void test7() {
		Tag t = new Tag("a:");
		assertEquals("a", t.getName());
		assertEquals(null, t.getValue());
	}

	@Test 
	public void test8() {
		Tag t = new Tag(":b");
		assertEquals(null, t.getName());
		assertEquals("b", t.getValue());
	}

	@Test 
	public void test_getLetterOption() {
		Tag t = new Tag("58A:value");
		assertEquals("58A", t.getName());
		assertEquals("value", t.getValue());
		assertEquals("A", t.getLetterOption());
		t = new Tag("58:value");
		assertEquals("58", t.getName());
		assertEquals("value", t.getValue());
		assertNull(t.getLetterOption());
	}

	@Test 
	public void test_isNumber() {
		Tag t = new Tag("58A:value");
		assertEquals("58A", t.getName());
		assertEquals("value", t.getValue());
		assertTrue(t.isNumber(58));
		assertFalse(t.isNumber(5));
	}

	@Test 
	public void testGetNumber() {
		Tag t = new Tag("20:value");
		assertEquals(Integer.valueOf(20), t.getNumber());
		
		t = new Tag("32A:value");
		assertEquals(Integer.valueOf(32), t.getNumber());
		
		t = new Tag("5:value");
		assertEquals(Integer.valueOf(5), t.getNumber());
		
		t = new Tag("CHK:value");
		assertNull(t.getNumber());
	}
	
	@Test 
	public void testEquals() {
		assertEquals(new Tag(), new Tag());
		assertEquals(new Tag("a"), new Tag("a"));
		assertEquals(new Tag("20:a"), new Tag("20:a"));
		assertEquals(new Tag("50K:FOO1\nFOO2"), new Tag("50K:FOO1\nFOO2"));
		assertEquals(new Tag("50K:FOO1\r\nFOO2"), new Tag("50K:FOO1\r\nFOO2"));
		/*
		 * not equals
		 */
		assertNotEquals(new Tag("50K:FOO1\nFOO2"), new Tag("50K:FOO1\nFOO3"));
		assertNotEquals(new Tag("50K:FOO1\r\nFOO2"), new Tag("50K:FOO1\nFOO2"));
		assertNotEquals(new Tag("50K:FOO1\nFOO2"), new Tag("50K:FOO1\r\nFOO2"));
	}
	
	@Test 
	public void testEqualsIgnoreCR() {
		assertTrue((new Tag()).equalsIgnoreCR(new Tag()));
		assertTrue((new Tag("a")).equalsIgnoreCR(new Tag("a")));
		assertTrue((new Tag("20:a")).equalsIgnoreCR(new Tag("20:a")));
		assertTrue((new Tag("50K:FOO1\nFOO2")).equalsIgnoreCR(new Tag("50K:FOO1\nFOO2")));
		assertTrue((new Tag("50K:FOO1\r\nFOO2")).equalsIgnoreCR(new Tag("50K:FOO1\r\nFOO2")));
		assertTrue((new Tag("50K:FOO1\r\nFOO2")).equalsIgnoreCR(new Tag("50K:FOO1\nFOO2")));
		assertTrue((new Tag("50K:FOO1\nFOO2")).equalsIgnoreCR(new Tag("50K:FOO1\r\nFOO2")));
		/*
		 * not equals
		 */
		assertFalse((new Tag("50K:FOO1\nFOO2")).equalsIgnoreCR(new Tag("50K:FOO1\nFOO3")));
	}

}
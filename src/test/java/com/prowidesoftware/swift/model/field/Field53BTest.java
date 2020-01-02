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
 * Test for Field53B and similar fields.
 *
 * @since 6.0
 */
public class Field53BTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("53B",
				"/00010001380002000114",
				"/D/1234/56",
				"/D\nabcd"
			);
	}
	
	@Test
	public void test53B() {
		Field53B f = new Field53B((String)null);
		assertNull(f.getDCMark());
		assertNull(f.getAccount());
		assertNull(f.getComponent3());
		
		f = new Field53B("");
		assertNull(f.getDCMark());
		assertNull(f.getAccount());
		assertNull(f.getComponent3());
		
		f = new Field53B("/D");
		assertNull(f.getDCMark());
		assertEquals("D", f.getAccount());
		assertNull(f.getComponent3());
		
		f = new Field53B("/D/");
		assertEquals("D", f.getDCMark());
		assertNull(f.getAccount());
		assertNull(f.getComponent3());
		
		f = new Field53B("/D/1234");
		assertEquals("D", f.getDCMark());
		assertEquals("1234", f.getAccount());
		assertNull(f.getComponent3());
		
		f = new Field53B("/D/1234/56");
		assertEquals("D", f.getDCMark());
		assertEquals("1234/56", f.getAccount());
		assertNull(f.getComponent3());
		
		f = new Field53B("abcd");
		assertNull(f.getDCMark());
		assertNull(f.getAccount());
		assertEquals("abcd", f.getComponent3());
		
		f = new Field53B("/D/1234\nabcd");
		assertEquals("D", f.getDCMark());
		assertEquals("1234", f.getAccount());
		assertEquals("abcd", f.getComponent3());
		
		f = new Field53B("/D\nabcd");
		assertNull(f.getDCMark());
		assertEquals("D", f.getAccount());
		assertEquals("abcd", f.getComponent3());
		
		f = new Field53B("/1234\nabcd");
		assertNull(f.getDCMark());
		assertEquals("1234", f.getAccount());
		assertEquals("abcd", f.getComponent3());
		
		f = new Field53B("/00010001380002000114");
		assertEquals("00010001380002000114", f.getAccount());
		assertNull(f.getDCMark());
		assertNull(f.getComponent3());
	}
	
	@Test
	public void testGetValueDisplay() {
		Field53B f = new Field53B("/00010001380002000114");
		assertEquals("00010001380002000114", f.getAccount());
		assertNull(f.getDCMark());
		assertNull(f.getComponent3());
	}

}
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
 * Test for Field58D and similar fields.
 *
 * @since 6.0
 */
public class Field58DTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("58D",
				"/00010001380002000114"
			);
	}
	
	@Test
	public void test58D() {
		Field58D f = new Field58D((String)null);
		assertNull(f.getDCMark());
		assertNull(f.getAccount());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("");
		assertNull(f.getDCMark());
		assertNull(f.getAccount());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D");
		assertNull(f.getDCMark());
		assertEquals("D", f.getAccount());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D/");
		assertEquals("D", f.getDCMark());
		assertNull(f.getAccount());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D/1234");
		assertEquals("D", f.getDCMark());
		assertEquals("1234", f.getAccount());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D/1234/56");
		assertEquals("D", f.getDCMark());
		assertEquals("1234/56", f.getAccount());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("abcd");
		assertNull(f.getDCMark());
		assertNull(f.getAccount());
		assertEquals("abcd", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D/1234\nabcd");
		assertEquals("D", f.getDCMark());
		assertEquals("1234", f.getAccount());
		assertEquals("abcd", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D\nabcd");
		assertNull(f.getDCMark());
		assertEquals("D", f.getAccount());
		assertEquals("abcd", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/1234\nabcd");
		assertNull(f.getDCMark());
		assertEquals("1234", f.getAccount());
		assertEquals("abcd", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/00010001380002000114");
		assertEquals("00010001380002000114", f.getAccount());
		assertNull(f.getDCMark());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field58D("/D/1234\nabcd\nefgh\nijkl\nmnop");
		assertEquals("D", f.getDCMark());
		assertEquals("1234", f.getAccount());
		assertEquals("abcd", f.getComponent3());
		assertEquals("efgh", f.getComponent4());
		assertEquals("ijkl", f.getComponent5());
		assertEquals("mnop", f.getComponent6());
	}
	
	@Test
	public void testGetValueDisplay() {
		Field58D f = new Field58D("/00010001380002000114");
		assertEquals("00010001380002000114", f.getAccount());
		assertNull(f.getDCMark());
		assertNull(f.getComponent3());
	}

}
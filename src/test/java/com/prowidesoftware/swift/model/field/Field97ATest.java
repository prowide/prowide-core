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
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Test for Field97A and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field97ATest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("97A",
				":abc//def//ggg"
			);
	}
	
	@Test
	public void testField97AString() {
		Field97A f = null;
		
		f = new Field97A("");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));

		f = new Field97A(":");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		
		f = new Field97A("/");
		assertEquals("/", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		
		f = new Field97A("//");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		
		f = new Field97A("://");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		
		f = new Field97A(":/");
		assertEquals("/", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		
		f = new Field97A("///");
		assertEquals("/", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent1()));
	
		f = new Field97A(":///");
		assertEquals("/", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		
		f = new Field97A(":abc//");
		assertEquals("abc", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));

		f = new Field97A(":abc//def");
		assertEquals("abc", f.getComponent1());
		assertEquals("def", f.getComponent2());
		
		f = new Field97A(":abc//def/ggg");
		assertEquals("abc", f.getComponent1());
		assertEquals("def/ggg", f.getComponent2());
	
		f = new Field97A(":abc//def/d/ggg");
		assertEquals("abc", f.getComponent1());
		assertEquals("def/d/ggg", f.getComponent2());
		
		f = new Field97A(":abc//def//ggg");
		assertEquals("abc", f.getComponent1());
		assertEquals("def//ggg", f.getComponent2());
	}

}
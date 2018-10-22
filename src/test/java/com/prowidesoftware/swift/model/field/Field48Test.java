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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Field48Test extends AbstractFieldTest {
	Field48 f = null;

	@Before
	public void setup() {
		f = null;
	}

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("48",
				"1",
				"1/FOO"
			);
	}
	
	@Test
	public void testGetValue1() {
		f = new Field48();
		f.setComponent1("1234");
		assertEquals("1234", f.getValue());
	}

	@Test
	public void testGetValue2() {
		f = new Field48();
		f.setComponent1("1234");
		f.setComponent2("FOO");
		assertEquals("1234/FOO", f.getValue());
	}

}
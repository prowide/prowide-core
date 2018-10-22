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
 * Test for Field50A and similar fields.
 *
 * @since 6.0
 */
public class Field50ATest extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("50A",
				"bbb",
				"/acc\nbbb"
			);
	}
	
	@Test
	public void testGetValue2() {
		Field50A f = new Field50A("/acc\nbbb");
		assertEquals("acc", f.getComponent1());
		assertEquals("bbb", f.getComponent2());
	}
	
	@Test
	public void testGetValue3() {
		Field50A f = new Field50A("bbb");
		assertNull(f.getComponent1());
		assertEquals("bbb", f.getComponent2());
	}

}
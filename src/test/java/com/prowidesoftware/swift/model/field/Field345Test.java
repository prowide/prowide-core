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
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Test for Field345 and similar fields.
 *
 * @since 7.8.8
 */
public class Field345Test extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("345",
				"101202103"
			);
	}
	
	@Test
	public void testParse345() throws Exception {
		Field345 f = new Field345("1");
		assertNotNull("Parse of field failed", f);
		assertEquals("1", f.getComponent1());
		f = new Field345("101");
		assertNotNull("Parse of field failed", f);
		assertEquals("101", f.getComponent1());
		f = new Field345("101202103");
		assertNotNull("Parse of field failed", f);
		assertEquals("101", f.getComponent1());
		assertEquals("202", f.getComponent2());
		assertEquals("103", f.getComponent3());
	}
	
}
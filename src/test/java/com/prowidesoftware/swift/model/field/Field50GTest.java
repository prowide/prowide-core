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

import org.junit.Test;


/**
 * Test for Field50G and similar fields.
 *
 */
public class Field50GTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("50G",
				"/0000001111000000\r\nBNPPARIBAS"
			);
	}
	
	@Test
	public void testGetValue() {
		Field50G f = new Field50G("/0000001111000000\r\nBNPPARIBAS");
		assertEquals(f.getComponent1(), "0000001111000000");
		assertEquals(f.getComponent2(), "BNPPARIBAS");
	}

}
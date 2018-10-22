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
 * Test for Field19 and similar fields.
 *
 * @since 6.0
 */
public class Field19Test extends AbstractFieldTest {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(Field19Test.class.getName());

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("19",
				"12345,"
			);
	}
	
	@Test
	public void testParse19() {
		Field19 f = null;
	
		f = new Field19("12345");
		assertNotNull("Parse of correct field failed", f);
		assertEquals(new Double(12345), new Double(f.getComponent1AsNumber().doubleValue()));

		f = new Field19("12345,12");
		assertNotNull("Parse of correct field failed", f);
		assertEquals("12345,12", f.getComponent1());
		assertEquals(new Double(12345.12), new Double(f.getComponent1AsNumber().doubleValue()));

		f = new Field19("12345,");
		assertNotNull("Parse of correct field failed", f);
		assertEquals(new Double(12345), new Double(f.getComponent1AsNumber().doubleValue()));
	}

}
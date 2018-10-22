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
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Test for Field64 and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field64Test extends AbstractFieldTest {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(Field64Test.class.getName());

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("64",
				"090822EUR1234,56",
				"D090822EUR1234,56"
			);
	}
	
	@Test
	public void testField64String() {
		Field64 f = null;
		
		f = new Field64("");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));

		f = new Field64("D090822EUR1234,56");
		assertEquals("D", f.getComponent1());
		assertEquals("090822", f.getComponent2());
		assertEquals("EUR", f.getComponent3());
		assertEquals("1234,56", f.getComponent4());
		
		f = new Field64("090822EUR1234,56");
		assertNull(f.getComponent1());
		assertEquals("090822", f.getComponent2());
		assertEquals("EUR", f.getComponent3());
		assertEquals("1234,56", f.getComponent4());
	}

}
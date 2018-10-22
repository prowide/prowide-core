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
 * Test for Field32K and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field32KTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("32K",
				"D123AAAEUR1234,56",
				"123AAAEUR1234,56"
			);
	}
	
	/**
	 * cNS<CUR>N
	 */
	@Test
	public void testField32K() {		
		Field32K f = new Field32K((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field32K("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field32K("D");
		assertEquals("D", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());

		f = new Field32K("D123");
		assertEquals("D", f.getComponent1());
		assertEquals("123", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field32K("D123EUR");
		assertEquals("D", f.getComponent1());
		assertEquals("123", f.getComponent2());
		assertNull(f.getComponent3());
		assertEquals("EUR", f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field32K("D123AAAEUR");
		assertEquals("D", f.getComponent1());
		assertEquals("123", f.getComponent2());
		assertEquals("AAA", f.getComponent3());
		assertEquals("EUR", f.getComponent4());
		assertNull(f.getComponent5());	
		
		f = new Field32K("D123AAAEUR1234,56");
		assertEquals("D", f.getComponent1());
		assertEquals("123", f.getComponent2());
		assertEquals("AAA", f.getComponent3());
		assertEquals("EUR", f.getComponent4());
		assertEquals("1234,56", f.getComponent5());
	}

}
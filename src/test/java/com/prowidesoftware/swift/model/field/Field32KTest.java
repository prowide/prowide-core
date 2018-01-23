/* 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
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
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
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
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
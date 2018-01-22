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
import static org.junit.Assert.assertNotNull;

import org.junit.Test;


/**
 * Test for Field19 and similar fields.
 * 
 * @author www.prowidesoftware.com
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
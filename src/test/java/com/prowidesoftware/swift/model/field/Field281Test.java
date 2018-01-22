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
 * Test for Field281 and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 7.8.8
 */
public class Field281Test extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("281",
				"1020MIR4567890123456789012345678AFOO"
			);
	}
		
	@Test
	public void testParse281() throws Exception {
		Field281 f = new Field281("1020MIR4567890123456789012345678AFOO");
		assertNotNull("Parse of field failed", f);
		assertEquals("1020", f.getComponent1());
		assertEquals("MIR4567890123456789012345678", f.getComponent2());
		assertEquals("A", f.getComponent3());
		assertEquals("FOO", f.getComponent4());
	}
	
}
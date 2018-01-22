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
 * Test for Field252 and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 7.8.8
 */
public class Field252Test extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("252",
				"MIR4567890123456789012345ENDMIR4567890123456789012345END11112222"
			);
	}
	
	@Test
	public void testParse252() throws Exception {
		Field252 f = new Field252("MIR4567890123456789012345ENDMIR4567890123456789012345END11112222");
		assertNotNull("Parse of field failed", f);
		assertEquals("MIR4567890123456789012345END", f.getComponent1());
		assertEquals("MIR4567890123456789012345END", f.getComponent2());
		assertEquals("1111", f.getComponent3());
		assertEquals("2222", f.getComponent4());
	}
	
}
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
 * Test for Field343 and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 7.8.8
 */
public class Field343Test extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("343",
				"101 202 103 202"
			);
	}
	
	@Test
	public void testParse343() throws Exception {
		Field343 f = new Field343("1");
		assertNotNull("Parse of field failed", f);
		assertEquals("1", f.getComponent1());
		f = new Field343("101");
		assertNotNull("Parse of field failed", f);
		assertEquals("101", f.getComponent1());
		f = new Field343("101 202 103");
		assertNotNull("Parse of field failed", f);
		assertEquals("101", f.getComponent1());
		assertEquals("202", f.getComponent2());
		assertEquals("103", f.getComponent3());
	}
	
}
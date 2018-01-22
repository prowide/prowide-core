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
 * Test for Field50A and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field50ATest extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("50A",
				"bbb",
				"/acc\nbbb"
			);
	}
	
	@Test
	public void testGetValue2() {
		Field50A f = new Field50A("/acc\nbbb");
		assertEquals("acc", f.getComponent1());
		assertEquals("bbb", f.getComponent2());
	}
	
	@Test
	public void testGetValue3() {
		Field50A f = new Field50A("bbb");
		assertNull(f.getComponent1());
		assertEquals("bbb", f.getComponent2());
	}

}
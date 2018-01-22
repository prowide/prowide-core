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

import org.junit.Test;

/**
 * Test for Field57C and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field57CTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("57C",
				"/acc/bb"
			);
	}
	
	@Test
	public void testGetComponent1() {
		Field57C f = new Field57C("/acc");
		assertEquals("acc", f.getComponent1());
	}

	@Test
	public void testGetComponent1b() {
		Field57C f = new Field57C("acc");
		assertEquals("acc", f.getComponent1());
	}

	@Test
	public void testGetComponent1c() {
		Field57C f = new Field57C("/acc/bb");
		assertEquals("acc/bb", f.getComponent1());
	}

}
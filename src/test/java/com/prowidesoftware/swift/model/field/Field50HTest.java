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
 * Test for Field50H and similar fields.
 * 
 * @author www.prowidesoftware.com
 */
public class Field50HTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("50H",
				"/0000001111000000\r\nBNPPARIBAS\r\n66 VICTOIRE\r\nPARIS"
			);
	}
	
	@Test
	public void testGetValue() {
		Field50H f = new Field50H("/0000001111000000\r\nBNPPARIBAS\r\n66 VICTOIRE\r\nPARIS\r\n");
		assertEquals(f.getComponent1(), "0000001111000000");
		assertEquals(f.getComponent2(), "BNPPARIBAS");
		assertEquals(f.getComponent3(), "66 VICTOIRE");
		assertEquals(f.getComponent4(), "PARIS");
	}

}
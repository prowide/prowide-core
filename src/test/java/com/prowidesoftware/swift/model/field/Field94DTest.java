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
 * Test for Field94D and similar fields.
 * 
 * @author www.prowidesoftware.com
 */
public class Field94DTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("94D",
				":AAAA//BB/C",
				":AAAA///C"
			);
	}
	
	@Test
	public void test1() {
		Field94D f = new Field94D(":AAAA//BB/C");
		assertEquals(f.getComponent1(), "AAAA");
		assertEquals(f.getComponent2(), "BB");
		assertEquals(f.getComponent3(), "C");
	}

	@Test
	public void test2() {
		Field94D f = new Field94D(":AAAA///C");
		assertEquals(f.getComponent1(), "AAAA");
		assertNull(f.getComponent2());
		assertEquals(f.getComponent3(), "C");
	}

}
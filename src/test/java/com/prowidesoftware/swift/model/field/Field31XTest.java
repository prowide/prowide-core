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
 * Test for Field31X and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.4
 */
public class Field31XTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("31X",
				"1312011212",
				"FOO"
			);
	}
	
	/**
	 * (<DATE2>[<HHMM>])|S
	 */
	@Test
	public void testField31X() {		
		Field31X f = new Field31X((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());

		f = new Field31X("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());

		f = new Field31X("131212");
		assertEquals("131212", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		
		f = new Field31X("1312011212");
		assertEquals("131201", f.getComponent1());
		assertEquals("1212", f.getComponent2());
		assertNull(f.getComponent3());

		f = new Field31X("FOO");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertEquals("FOO", f.getComponent3());
	}
	
}
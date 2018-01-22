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
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field50K and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field50KTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("50K",
				"/acc",
				"/acc\nbbb\nccc\nddd\neee"
			);
	}

	@Test
	public void testSerialization2() {
		Field50K f = new Field50K("/345345234534\nSDFGSDFGSDFGSD");
		assertNotNull(f.getValue());
		assertEquals("/345345234534"+FINWriterVisitor.SWIFT_EOL+"SDFGSDFGSDFGSD", f.getValue());
	}

	@Test
	public void testGetValue() {
		Field50K f = new Field50K("/acc");
		assertEquals("/acc", f.getValue());
		f.setComponent2("c2");
		assertEquals("/acc\r\nc2", f.getValue());
	}
	
	@Test
	public void testGetValue2() {
		Field50K f = new Field50K("/acc\nbbb\nccc\nddd\neee");
		assertEquals("acc", f.getComponent1());
		assertEquals("bbb", f.getComponent2());
		assertEquals("ccc", f.getComponent3());
		assertEquals("ddd", f.getComponent4());
		assertEquals("eee", f.getComponent5());
	}
	
	@Test
	public void testGetValue3() {
		Field50K f = new Field50K("bbb\nccc\nddd\neee");
		assertNull(f.getComponent1());
		assertEquals("bbb", f.getComponent2());
		assertEquals("ccc", f.getComponent3());
		assertEquals("ddd", f.getComponent4());
		assertEquals("eee", f.getComponent5());
	}
	
}
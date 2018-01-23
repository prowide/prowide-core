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

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field57A and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 7.7
 */
public class Field57ATest extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("57A",
				"/D/1234\nFOOBIC",
				"/1234\nFOOBIC",
				"FOOBIC"
			);
	}
	
	@Test
	public void test_getValue() {
		Field57A f = new Field57A();
		f.setComponent1("");
		f.setComponent2("1234567890");
		f.setComponent3("BICFOOXX");
		assertEquals("//1234567890" + FINWriterVisitor.SWIFT_EOL + "BICFOOXX", f.getValue());
	}

	@Test
	public void test_getValue2() {
		Field57A f = new Field57A();
		f.setComponent2("1234567890");
		f.setComponent3("BICFOOXX");
		assertEquals("/1234567890" + FINWriterVisitor.SWIFT_EOL + "BICFOOXX", f.getValue());
	}

}
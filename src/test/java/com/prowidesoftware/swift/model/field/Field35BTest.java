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

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field35B and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field35BTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("35B",
				"ISIN HELLO\nAAAA\nBBBB\nCCCC",
				"AAAA\nBBBB\nCCCC\nDDDD"
			);
	}
	
	@Test
	public void testParse() {
		Field35B f = new Field35B();
		
		//remaining lines are ignored by parser
		f = new Field35B("ISIN HELLO\nAAAA\nBBBB\nCCCC\nDDDD\nEEEE\nFFFF\nGGGG");
		assertEquals("ISIN", f.getComponent1());
		assertEquals("HELLO", f.getComponent2());
		assertEquals("AAAA", f.getComponent3());
		assertEquals("BBBB", f.getComponent4());
		assertEquals("CCCC", f.getComponent5());
		assertEquals("DDDD", f.getComponent6());
		
		f = new Field35B("ISIN HELLO\nAAAA\nBBBB\nCCCC");
		assertEquals("ISIN", f.getComponent1());
		assertEquals("HELLO", f.getComponent2());
		assertEquals("AAAA", f.getComponent3());
		assertEquals("BBBB", f.getComponent4());
		assertEquals("CCCC", f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field35B("ISIN HELLO");
		assertEquals("ISIN", f.getComponent1());
		assertEquals("HELLO", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field35B("ISINHELLO");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertEquals("ISINHELLO", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field35B(" ISINHELLO");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertEquals(" ISINHELLO", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
	}
	
	@Test
	public void testGetValue() {
		Field35B f = new Field35B();		
		String v = "ISIN HELLO\nAAAA\nBBBB\nCCCC\nDDDD";
		f = new Field35B(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}

	@Test
	public void testGetValue_2() {
		Field35B f = new Field35B();		
		String v = "ISIN 123456789012\nAAAA\nBBBB\nCCCC\nDDDD";
		f = new Field35B(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}

	@Test
	public void testGetValue_3() {
		Field35B f = new Field35B();		
		String v = "AAAA\nBBBB\nCCCC\nDDDD";
		f = new Field35B(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}

}
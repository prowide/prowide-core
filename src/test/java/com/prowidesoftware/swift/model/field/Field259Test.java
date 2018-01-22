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

/**
 * Test for Field257 and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 7.8.8
 */
public class Field259Test extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("259",
				EXAMPLE1_FIELD_259
			);
	}
	
	/**
	 * <cat-output-type>
	 * <lt-identifier> 4!a2!a2!c1!c
	 * <branch-code> 3!c
	 * <session-number> 4!n
	 * <msg-category> 1!n
	 * <date> 6!n
	 * <time-range> 4!n4!n
	 * 
	 * Ejemplos:
	 * VNDZBET2AXXX 0025 9 050823 1548 1552
	 */
	private static String EXAMPLE1_FIELD_259 = "VNDZBET2AXXX0025905082315481552";
	
	@Test
	public void testParse259Ex1() throws Exception {
		Field259 f = new Field259(EXAMPLE1_FIELD_259);
		assertNotNull("Parse of field failed", f);
		
		assertEquals("VNDZBET2AXXX", f.getComponent1());
		assertEquals("0025", f.getComponent2());
		assertEquals("9", f.getComponent3());
		assertEquals("050823", f.getComponent4());
		assertEquals("1548", f.getComponent5());
		assertEquals("1552", f.getComponent6());
	}

	@Test
	public void testParse259Partial() throws Exception {
		Field259 f = new Field259("AAAAAAAAAAAA");
		assertEquals("AAAAAAAAAAAA", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());

		f = new Field259("AAAAAAAAAAAA1234");
		assertEquals("AAAAAAAAAAAA", f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field259("AAAAAAAAAAAA12341");
		assertEquals("AAAAAAAAAAAA", f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertEquals("1", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field259("AAAAAAAAAAAA12341123456");
		assertEquals("AAAAAAAAAAAA", f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertEquals("1", f.getComponent3());
		assertEquals("123456", f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field259("AAAAAAAAAAAA123411234561234");
		assertEquals("AAAAAAAAAAAA", f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertEquals("1", f.getComponent3());
		assertEquals("123456", f.getComponent4());
		assertEquals("1234", f.getComponent5());
		assertNull(f.getComponent6());
		
		f = new Field259("AAAAAAAAAAAA1234112345612349999999999");
		assertEquals("AAAAAAAAAAAA", f.getComponent1());
		assertEquals("1234", f.getComponent2());
		assertEquals("1", f.getComponent3());
		assertEquals("123456", f.getComponent4());
		assertEquals("1234", f.getComponent5());
		assertEquals("9999999999", f.getComponent6());
	}

	@Test    
	public void testGetValue1() {
		Field259 f = new Field259(EXAMPLE1_FIELD_259);
		assertEquals(EXAMPLE1_FIELD_259, f.getValue());
	}
	
}
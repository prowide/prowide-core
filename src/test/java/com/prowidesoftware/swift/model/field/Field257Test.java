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

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field257 and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 7.8.8
 */
public class Field257Test extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("257",
				EXAMPLE1_FIELD_257,
				EXAMPLE2_FIELD_257
			);
	}
	
	/**
	 * <input-time-range>
	 * <lt-identifier> 4!a2!a2!c1!c
	 * <branch-code> 3!c
	 * <date> 6!n
	 * <time-range> 4!n4!n
	 * [<session-number> 4!n]
	 * 
	 * 
	 * Ejemplos:
	 * BICFOOXXXXXX731019121213139999
	 * BICFOOABCDEF210117111122223333
	 */
	private static String EXAMPLE1_FIELD_257 = "BICFOOXXXXXX731019121213139999";
	private static String EXAMPLE2_FIELD_257 = "BICFOOABCDEF210117111122223333";
	
	@Test
	public void testParse257Ex1() throws Exception {
		Field257 f = new Field257(EXAMPLE1_FIELD_257);
		assertNotNull("Parse of field failed", f);
		assertEquals("BICFOOXXXXXX", f.getComponent1());
		assertEquals("731019", f.getComponent2());
		assertEquals("1212", f.getComponent3());
		assertEquals("1313", f.getComponent4());
		assertEquals("9999", f.getComponent5());
		
		f = new Field257("BICFOOXXXXXX");
		assertEquals("BICFOOXXXXXX", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field257("BICFOOXXXXXX731019");
		assertEquals("BICFOOXXXXXX", f.getComponent1());
		assertEquals("731019", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field257("BICFOOXXXXXX7310191212");
		assertEquals("BICFOOXXXXXX", f.getComponent1());
		assertEquals("731019", f.getComponent2());
		assertEquals("1212", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field257("BICFOOXXXXXX73101912121313");
		assertEquals("BICFOOXXXXXX", f.getComponent1());
		assertEquals("731019", f.getComponent2());
		assertEquals("1212", f.getComponent3());
		assertEquals("1313", f.getComponent4());
		assertNull(f.getComponent5());
		
	}
	
	@Test
	public void testParse257Ex2() throws Exception {
		Field257 f = new Field257(EXAMPLE2_FIELD_257);
		assertNotNull("Parse of field failed", f);
		assertEquals("BICFOOABCDEF", f.getComponent1());
		assertEquals("210117", f.getComponent2());
		assertEquals("1111", f.getComponent3());
		assertEquals("2222", f.getComponent4());
		assertEquals("3333", f.getComponent5());
	}
	
	@Test    
	public void testGetValue1() {
		Field257 f = new Field257();		
		String v = EXAMPLE1_FIELD_257;
		f = new Field257(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}
	
	@Test    
	public void testGetValue2() {
		Field257 f = new Field257();		
		String v = EXAMPLE2_FIELD_257;
		f = new Field257(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}
	
}
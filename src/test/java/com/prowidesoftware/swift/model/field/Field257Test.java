/*
 * Copyright 2006-2018 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field257 and similar fields.
 *
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
	 * FOOBARXXXXXX731019121213139999
	 * FOOBARABCDEF210117111122223333
	 */
	private static String EXAMPLE1_FIELD_257 = "FOOBARXXXXXX731019121213139999";
	private static String EXAMPLE2_FIELD_257 = "FOOBARABCDEF210117111122223333";
	
	@Test
	public void testParse257Ex1() throws Exception {
		Field257 f = new Field257(EXAMPLE1_FIELD_257);
		assertNotNull("Parse of field failed", f);
		assertEquals("FOOBARXXXXXX", f.getComponent1());
		assertEquals("731019", f.getComponent2());
		assertEquals("1212", f.getComponent3());
		assertEquals("1313", f.getComponent4());
		assertEquals("9999", f.getComponent5());
		
		f = new Field257("FOOBARXXXXXX");
		assertEquals("FOOBARXXXXXX", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field257("FOOBARXXXXXX731019");
		assertEquals("FOOBARXXXXXX", f.getComponent1());
		assertEquals("731019", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field257("FOOBARXXXXXX7310191212");
		assertEquals("FOOBARXXXXXX", f.getComponent1());
		assertEquals("731019", f.getComponent2());
		assertEquals("1212", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field257("FOOBARXXXXXX73101912121313");
		assertEquals("FOOBARXXXXXX", f.getComponent1());
		assertEquals("731019", f.getComponent2());
		assertEquals("1212", f.getComponent3());
		assertEquals("1313", f.getComponent4());
		assertNull(f.getComponent5());
		
	}
	
	@Test
	public void testParse257Ex2() throws Exception {
		Field257 f = new Field257(EXAMPLE2_FIELD_257);
		assertNotNull("Parse of field failed", f);
		assertEquals("FOOBARABCDEF", f.getComponent1());
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
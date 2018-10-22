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
import static org.junit.Assert.assertNull;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field133 and similar fields.
 *
 * @since 7.8.8
 */
public class Field133Test extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("133",
				EXAMPLE1_FIELD_133,
				EXAMPLE2_FIELD_133,
				EXAMPLE3_FIELD_133,
				EXAMPLE4_FIELD_133
			);
	}
	
	/**
	 * <original-broadcast-number>
	 * "B"|"S""XXX"
	 * "HQ"|"HK"|"NL"|"US"4!n
	 * 
	 * B User-initiated Broadcast
	 * S SWIFT-initiated Broadcast
	 * XXX indicates an unsequenced Broadcast (that is for selected countries)
	 * HQ Broadcast issued from La Hulpe
	 * HK Broadcast issued from Hong Kong
	 * NL Broadcast issued from Netherlands
	 * US Broadcast issued from the United States
	 * 4!n 4 digit Broadcast number
	 * 
	 * Ejemplos:
	 * BAZEUS1111
	 * SAAUNZ2101
	 * BJBDHQ1506
	 * SCCXHK9999
	 * 
	 * @plucero
	 * Note: Unsequenced Broadcast cannot contain numbers.
	 */
	
	private static String EXAMPLE1_FIELD_133 = "BAZEUS1111";
	private static String EXAMPLE2_FIELD_133 = "SAAUNZ2101";
	private static String EXAMPLE3_FIELD_133 = "BJBDHQ1506";
	private static String EXAMPLE4_FIELD_133 = "SCCXHK9999";
	
	@Test
	public void testParse() {
		Field133 f = new Field133();
		
		f = new Field133(EXAMPLE1_FIELD_133);
		assertEquals("B", f.getComponent1());
		assertEquals("AZE", f.getComponent2());
		assertEquals("US", f.getComponent3());
		assertEquals("1111", f.getComponent4());
		
		f = new Field133(EXAMPLE2_FIELD_133);
		assertEquals("S", f.getComponent1());
		assertEquals("AAU", f.getComponent2());
		assertEquals("NZ", f.getComponent3());
		assertEquals("2101", f.getComponent4());
		
		f = new Field133(EXAMPLE3_FIELD_133);
		assertEquals("B", f.getComponent1());
		assertEquals("JBD", f.getComponent2());
		assertEquals("HQ", f.getComponent3());
		assertEquals("1506", f.getComponent4());
		
		f = new Field133(EXAMPLE4_FIELD_133);
		assertEquals("S", f.getComponent1());
		assertEquals("CCX", f.getComponent2());
		assertEquals("HK", f.getComponent3());
		assertEquals("9999", f.getComponent4());
		
		f = new Field133("B");
		assertEquals("B", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field133("BAZE");
		assertEquals("B", f.getComponent1());
		assertEquals("AZE", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field133("BAZEUS");
		assertEquals("B", f.getComponent1());
		assertEquals("AZE", f.getComponent2());
		assertEquals("US", f.getComponent3());
		assertNull(f.getComponent4());
	}
	
	@Test
	public void testGetValue1() {
		Field133 f = new Field133();		
		String v = EXAMPLE1_FIELD_133;
		f = new Field133(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}
	
	@Test
	public void testGetValue2() {
		Field133 f = new Field133();		
		String v = EXAMPLE2_FIELD_133;
		f = new Field133(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}
	
	@Test
	public void testGetValue3() {
		Field133 f = new Field133();		
		String v = EXAMPLE3_FIELD_133;
		f = new Field133(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}
	
	@Test
	public void testGetValue4() {
		Field133 f = new Field133();		
		String v = EXAMPLE4_FIELD_133;
		f = new Field133(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}
	
}
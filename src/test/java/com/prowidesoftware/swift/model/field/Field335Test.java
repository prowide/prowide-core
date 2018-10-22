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
 * Test for Field335 and similar fields.
 *
 * @since 7.4
 */
public class Field335Test extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("335",
				EXAMPLE1_FIELD_335,
				EXAMPLE2_FIELD_335
			);
	}
	
	/**
	 * <report-line>
	 * <time> 4!n
	 * <mir> 28!c
	 * <msg-type> 3!n
	 * <address> 4!a2!a2!c1!c3!c
	 * [<time> 4!n]
	 * 
	 * Ejemplos:
	 * 1522010605VNDZBET2AXXX0018000377999BANKBEBBXXXX
	 * 1800010606BANKBEBBAXXX0008222211100DEUTDEFFXXXX1802
	 */
	private static String EXAMPLE1_FIELD_335 = "1522010605VNDZBET2AXXX0018000377999BANKBEBBXXXX";
	private static String EXAMPLE2_FIELD_335 = "1800010606BANKBEBBAXXX0008222211100DEUTDEFFXXXX1802";
	
	@Test
	public void testParse281() throws Exception {
		Field335 f = new Field335("1020MIR4567890123456789012345END103AAAAAAAAAAAA1234");
		assertNotNull("Parse of field failed", f);
		assertEquals("1020", f.getComponent1());
		assertEquals("MIR4567890123456789012345END", f.getComponent2());
		assertEquals("103", f.getComponent3());
		assertEquals("AAAAAAAAAAAA", f.getComponent4());
		assertEquals("1234", f.getComponent5());
	}
	
	@Test
	public void testParse2() throws Exception {
		Field335 f = new Field335(EXAMPLE1_FIELD_335);
		assertNotNull("Parse of field failed", f);
		assertEquals("1522", f.getComponent1());
		assertEquals("010605VNDZBET2AXXX0018000377", f.getComponent2());
		assertEquals("999", f.getComponent3());
		assertEquals("BANKBEBBXXXX", f.getComponent4());
		assertEquals(null, f.getComponent5());
	}
	
	@Test
	public void testParse3() throws Exception {
		Field335 f = new Field335(EXAMPLE2_FIELD_335);
		assertNotNull("Parse of field failed", f);
		assertEquals("1800", f.getComponent1());
		assertEquals("010606BANKBEBBAXXX0008222211", f.getComponent2());
		assertEquals("100", f.getComponent3());
		assertEquals("DEUTDEFFXXXX", f.getComponent4());
		assertEquals("1802", f.getComponent5());
		
		f = new Field335("1800");
		assertEquals("1800", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field335("1800010606BANKBEBBAXXX0008222211");
		assertEquals("1800", f.getComponent1());
		assertEquals("010606BANKBEBBAXXX0008222211", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field335("1800010606BANKBEBBAXXX0008222211100");
		assertEquals("1800", f.getComponent1());
		assertEquals("010606BANKBEBBAXXX0008222211", f.getComponent2());
		assertEquals("100", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		
		f = new Field335("1800010606BANKBEBBAXXX0008222211100DEUTDEFFXXXX");
		assertEquals("1800", f.getComponent1());
		assertEquals("010606BANKBEBBAXXX0008222211", f.getComponent2());
		assertEquals("100", f.getComponent3());
		assertEquals("DEUTDEFFXXXX", f.getComponent4());
		assertNull(f.getComponent5());
	}
	
	@Test    
	public void testGetValue1() {
		Field335 f = new Field335();		
		String v = EXAMPLE1_FIELD_335;
		f = new Field335(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}
	
	@Test    
	public void testGetValue2() {
		Field335 f = new Field335();		
		String v = EXAMPLE2_FIELD_335;
		f = new Field335(v);
		assertEquals(StringUtils.replace(v, "\n", FINWriterVisitor.SWIFT_EOL), f.getValue());
	}
	
}
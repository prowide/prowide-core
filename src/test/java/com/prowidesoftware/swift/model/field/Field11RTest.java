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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field11R and similar fields.
 *
 * @since 6.0
 */
public class Field11RTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("11R",
				"100\n091019",
				"100\n091019\n1234123456"
			);
	}
	
	@Test
	public void testSerialization2() throws Exception {
		Field11R field11r = new Field11R();
		field11r.setComponent1("103");
		field11r.setComponent2(Calendar.getInstance());
		field11r.setComponent3(1);
		assertFalse(StringUtils.isBlank(field11r.asTag().getValue()));
	}
	
	@Test
	public void testParser() {		
		Field11R f = new Field11R((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field11R("100");
		assertEquals("100", f.getComponent1());
		assertEquals("100", f.getMT());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field11R("100\n091019");
		assertEquals("100", f.getComponent1());
		assertEquals("100", f.getMT());
		assertEquals("091019", f.getComponent2());
		assertEquals(2009, f.getComponent2AsCalendar().get(Calendar.YEAR));
		assertEquals(10, f.getComponent2AsCalendar().get(Calendar.MONTH)+1); //MONTH is zero based at Calendar
		assertEquals(19, f.getComponent2AsCalendar().get(Calendar.DAY_OF_MONTH));
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field11R("100\n091019\nabc");
		assertEquals("100", f.getComponent1());
		assertEquals("100", f.getMT());
		assertEquals("091019", f.getComponent2());
		assertEquals(2009, f.getComponent2AsCalendar().get(Calendar.YEAR));
		assertEquals(10, f.getComponent2AsCalendar().get(Calendar.MONTH)+1);
		assertEquals(19, f.getComponent2AsCalendar().get(Calendar.DAY_OF_MONTH));
		assertEquals("abc", f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field11R("100\n091019\n1234567890");
		assertEquals("1234", f.getComponent3());
		assertEquals("567890", f.getComponent4());
	}
	
	@Test
	public void testSetters() {
		Field11R f = new Field11R();
		f.setComponent1("103"); 
		f.setComponent2("151111"); 
		f.setComponent3("4444666666"); 
		assertEquals("103", f.getComponent1());
		assertEquals("151111", f.getComponent2());
		assertEquals("4444666666", f.getComponent3());
		assertNull(f.getComponent4());
		assertEquals("103"+FINWriterVisitor.SWIFT_EOL+"151111"+FINWriterVisitor.SWIFT_EOL+"4444666666", f.getValue());
		
		f = new Field11R();
		f.setComponent1("103"); 
		f.setComponent2("151111"); 
		f.setComponent3("4444"); 
		f.setComponent4("666666"); 
		assertEquals("103", f.getComponent1());
		assertEquals("151111", f.getComponent2());
		assertEquals("4444", f.getComponent3());
		assertEquals("666666", f.getComponent4());
		assertEquals("103"+FINWriterVisitor.SWIFT_EOL+"151111"+FINWriterVisitor.SWIFT_EOL+"4444666666", f.getValue());

		f = new Field11R();
		f.setComponent1("103");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		cal.set(Calendar.DAY_OF_MONTH, 19);
		f.setComponent2(cal); 
		f.setComponent3("4444"); 
		f.setComponent4("666666"); 
		assertEquals("103", f.getComponent1());
		assertEquals("151019", f.getComponent2());
		assertEquals("4444", f.getComponent3());
		assertEquals("666666", f.getComponent4());
		assertEquals("103"+FINWriterVisitor.SWIFT_EOL+"151019"+FINWriterVisitor.SWIFT_EOL+"4444666666", f.getValue());

		f = new Field11R();
		f.setComponent1("103"); 
		f.setComponent2("151111"); 
		f.setComponent3(4444); 
		f.setComponent4(666666); 
		assertEquals("103", f.getComponent1());
		assertEquals("151111", f.getComponent2());
		assertEquals("4444", f.getComponent3());
		assertEquals("666666", f.getComponent4());
		assertEquals("103"+FINWriterVisitor.SWIFT_EOL+"151111"+FINWriterVisitor.SWIFT_EOL+"4444666666", f.getValue());

		f = new Field11R();
		f.setComponent1("103"); 
		f.setComponent2("151111"); 
		f.setComponent3(4); 
		f.setComponent4(6); 
		assertEquals("103", f.getComponent1());
		assertEquals("151111", f.getComponent2());
		assertEquals("4", f.getComponent3());
		assertEquals("6", f.getComponent4());
		assertEquals("103"+FINWriterVisitor.SWIFT_EOL+"151111"+FINWriterVisitor.SWIFT_EOL+"46", f.getValue());
	}
	
}
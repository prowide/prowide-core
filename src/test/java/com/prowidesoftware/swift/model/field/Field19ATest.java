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

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Test for Field19A and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field19ATest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("19A",
				":abc//errr123",
				":SETT//CHF178626,04"
			);
	}
	
	@Test
	public void testField19AString() {
		Field19A f = null;
	
		f = new Field19A((String)null);
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field19A("");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field19A("/");
		assertEquals("/", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field19A("//");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field19A("://");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field19A(":/");
		assertEquals("/", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field19A("///");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());	// the expected component is a letter, so it is not filled with the slash
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
	
		f = new Field19A(":///");
		assertNull(f.getComponent1());
		assertNull(f.getComponent2());	// the expected component is a letter, so it is not filled with the slash
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field19A(":abc//");
		assertEquals("abc", f.getComponent1());
		assertNull(f.getComponent2());	
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field19A(":abc//e");
		assertEquals("abc", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());

		f = new Field19A(":abc//er");
		assertEquals("abc", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field19A(":abc//err");
		assertEquals("abc", f.getComponent1());
		assertNull(f.getComponent2());
		assertEquals("err", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field19A(":abc//errr");
		assertEquals("abc", f.getComponent1());
		assertEquals("e", f.getComponent2());
		assertEquals("rrr", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field19A(":abc//errrxx");
		assertEquals("abc", f.getComponent1());
		assertEquals("e", f.getComponent2());
		assertEquals("rrrxx", f.getComponent3());
		assertNull(f.getComponent4());
		
		f = new Field19A(":abc//errr123");
		assertEquals("abc", f.getComponent1());
		assertEquals("e", f.getComponent2());
		assertEquals("rrr", f.getComponent3());
		assertEquals(new BigDecimal(123), new BigDecimal(f.getComponent4AsNumber().doubleValue()));
		
		f = new Field19A(":abc//errr123,");
		assertEquals("abc", f.getComponent1());
		assertEquals("e", f.getComponent2());
		assertEquals("rrr", f.getComponent3());
		assertEquals(new BigDecimal(123), new BigDecimal(f.getComponent4AsNumber().doubleValue()));
		
		f = new Field19A(":abc//errr123,45");
		assertEquals("abc", f.getComponent1());
		assertEquals("e", f.getComponent2());
		assertEquals("rrr", f.getComponent3());
		assertEquals(new BigDecimal(123.45), new BigDecimal(f.getComponent4AsNumber().doubleValue()));
		
		f = new Field19A(":abc//errr123,45,");
		assertEquals("abc", f.getComponent1());
		assertEquals("e", f.getComponent2());
		assertEquals("rrr", f.getComponent3());
		//log.fine("number:"+f.getComponent4().doubleValue());
		//assertNull(f.getComponent4());
		
		f = new Field19A(":abc//errr123.45");
		assertEquals("abc", f.getComponent1());
		assertEquals("e", f.getComponent2());
		assertEquals("rrr", f.getComponent3());
		//log.fine("number:"+f.getComponent4().doubleValue());
		//assertNull(f.getComponent4());
		
		f = new Field19A(":abc//errr123aaa");
		assertEquals("abc", f.getComponent1());
		assertEquals("e", f.getComponent2());
		assertEquals("rrr", f.getComponent3());
		//assertNull(f.getComponent4());
	}

	@Test
	public void testIssueAmountResolver() throws Exception {
		Field19A f = new Field19A("SETT//CHF178626,04");
		Object n = f.getComponentAs(4, Number.class);
		assertNotNull(n);
	}

}
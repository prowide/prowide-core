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
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * Test for Field92J and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field92JTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("92J",
				":DDDD/EEEEEEEE/FFFF/EUR1234,56/AAAA"
			);
	}
	
	/**
	 * ':'4!c'/'[8c]'/'4!c'/'<CUR><AMOUNT>15['/'4!c]
	 */
	@Test
	public void testField92JString() {
		Field92J f = null;
		
		f = new Field92J("");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));

		f = new Field92J(":");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));

		f = new Field92J(":/");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));

		f = new Field92J("://");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));

		f = new Field92J(":///");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));

		f = new Field92J(":////");
		assertTrue(StringUtils.isBlank(f.getComponent1()));
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));

		f = new Field92J(":DDDD");
		assertEquals("DDDD", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field92J(":DDDD/");
		assertEquals("DDDD", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field92J(":DDDD/EEEEEEEE");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field92J(":DDDD/EEEEEEEE/");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertTrue(StringUtils.isBlank(f.getComponent3()));
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field92J(":DDDD/EEEEEEEE/FFFF");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFFF", f.getComponent3());
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field92J(":DDDD//FFFF");
		assertEquals("DDDD", f.getComponent1());
		assertTrue(StringUtils.isBlank(f.getComponent2()));
		assertEquals("FFFF", f.getComponent3());
		assertTrue(StringUtils.isBlank(f.getComponent4()));
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
			
		f = new Field92J(":DDDD/EEEEEEEE/FFFF/EUR");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFFF", f.getComponent3());
		assertEquals("EUR", f.getComponent4());
		assertTrue(StringUtils.isBlank(f.getComponent5()));
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field92J(":DDDD/EEEEEEEE/FFFF/EUR1234");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFFF", f.getComponent3());
		assertEquals("EUR", f.getComponent4());
		assertEquals("1234", f.getComponent5());
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field92J(":DDDD/EEEEEEEE/FFFF/EUR1234,");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFFF", f.getComponent3());
		assertEquals("EUR", f.getComponent4());
		assertEquals("1234,", f.getComponent5());
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field92J(":DDDD/EEEEEEEE/FFFF/EUR1234,56");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFFF", f.getComponent3());
		assertEquals("EUR", f.getComponent4());
		assertEquals("1234,56", f.getComponent5());
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field92J(":DDDD/EEEEEEEE/FFFF/EUR1234,56/");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFFF", f.getComponent3());
		assertEquals("EUR", f.getComponent4());
		assertEquals("1234,56", f.getComponent5());
		assertTrue(StringUtils.isBlank(f.getComponent6()));
		
		f = new Field92J(":DDDD/EEEEEEEE/FFFF/EUR1234,56/AAAA");
		assertEquals("DDDD", f.getComponent1());
		assertEquals("EEEEEEEE", f.getComponent2());
		assertEquals("FFFF", f.getComponent3());
		assertEquals("EUR", f.getComponent4());
		assertEquals("1234,56", f.getComponent5());
		assertEquals("AAAA", f.getComponent6());
	}

}
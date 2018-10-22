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

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Test for Field19A and similar fields.
 * 
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
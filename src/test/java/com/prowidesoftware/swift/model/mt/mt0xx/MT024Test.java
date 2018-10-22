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

package com.prowidesoftware.swift.model.mt.mt0xx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.prowidesoftware.swift.model.field.Field140;
import com.prowidesoftware.swift.model.field.Field142;
import com.prowidesoftware.swift.model.field.Field143;

public class MT024Test {

	private String sample = "{1:F01VNDZBET2AXXX0000000000}{2:I024DYDYXXXXXXXXN}{4:"
			+ "{140:111222333444555}"
			+ "{142:200703051430}"
			+ "{143:200703051530}}";
	@Test
	public void test_parse() {
		MT024 m = MT024.parse(sample);
		assertNotNull(m);

		assertNotNull(m.getField140());
		assertEquals("111222333444555", m.getField140().getValue());
		
		assertNotNull(m.getField142());
		assertEquals("200703051430", m.getField142().getValue());
		
		assertNotNull(m.getField143());
		assertEquals("200703051530", m.getField143().getValue());
	}
	
	@Test
	public void test_create() {
		MT024 m = new MT024();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field140("111222333444555"));
		m.append(new Field142("200703051430"));
		m.append(new Field143("200703051530"));
		
		assertEquals(sample, m.message());
	}
}

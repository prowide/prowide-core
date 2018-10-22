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

import com.prowidesoftware.swift.model.field.Field177;
import com.prowidesoftware.swift.model.field.Field303;

public class MT031Test {

	private String sample1 = "{1:F01VNDZBET2AXXX0000000000}{2:I031DYDYXXXXXXXXN}{4:"
			+ "{303:A}"
			+ "{177:0106050000}"
			+ "{177:0106052359}}";
	
	@Test
	public void test_parse() {
		MT031 m = MT031.parse(sample1);
		assertNotNull(m);

		assertNotNull(m.getField303());
		assertEquals("A", m.getField303().getValue());
		
		assertNotNull(m.getField177());
		assertEquals("0106050000", m.getField177().get(0).getValue());

		assertNotNull(m.getField177());
		assertEquals("0106052359", m.getField177().get(1).getValue());
	}
	
	@Test
	public void test_create() {
		MT031 m = new MT031();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field303("A"));
		m.append(new Field177("0106050000"));
		m.append(new Field177("0106052359"));
		
		assertEquals(sample1, m.message());
		
	}
}

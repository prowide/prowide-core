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

import com.prowidesoftware.swift.model.field.Field405;

public class MT015Test {

	private String sample = "{1:F01VNDZBET2AXXX0000000000}{2:I015DYDYXXXXXXXXN}{4:"
			+ "{405:V22}}";
	@Test
	public void test_parse() {
		MT015 m = MT015.parse(sample);
		assertNotNull(m);

		assertNotNull(m.getField405());
		assertEquals("V22", m.getField405().getValue());
	}
	
	@Test
	public void test_create() {
		MT015 m = new MT015();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field405("V22"));
		
		assertEquals(sample, m.message());
	}
}

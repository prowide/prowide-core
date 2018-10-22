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

import com.prowidesoftware.swift.model.field.Field102;
import com.prowidesoftware.swift.model.field.Field106;
import com.prowidesoftware.swift.model.field.Field175;
import com.prowidesoftware.swift.model.field.Field432;
import com.prowidesoftware.swift.model.field.Field619;

public class MT019Test {

	private String sample = "{1:F01VNDZBET2AXXX0000000000}{2:I019DYDYXXXXXXXXN}{4:"
			+ "{175:0604}"
			+ "{106:140901VNDZBET2AXXX0021000443}"
			+ "{102:BBBNBEBBAXXX}"
			+ "{432:12}"
			+ "{619:CPY}"
			+ "}";
	@Test
	public void test_parse() {
		MT019 m = MT019.parse(sample);
		assertNotNull(m);

		assertNotNull(m.getField175());
		assertEquals("0604", m.getField175().getValue());

		assertNotNull(m.getField106());
		assertEquals("140901VNDZBET2AXXX0021000443", m.getField106().getValue());
		
		assertNotNull(m.getField102());
		assertEquals("BBBNBEBBAXXX", m.getField102().getValue());
		
		assertNotNull(m.getField432());
		assertEquals("12", m.getField432().getValue());

		assertNotNull(m.getField619());
		assertEquals("CPY", m.getField619().getValue());
	}
	
	@Test
	public void test_create() {
		MT019 m = new MT019();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field175("0604"));
		m.append(new Field106("140901VNDZBET2AXXX0021000443"));
		m.append(new Field102("BBBNBEBBAXXX"));
		m.append(new Field432("12"));
		m.append(new Field619("CPY"));
		
		assertEquals(sample, m.message());
	}
}

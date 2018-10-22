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

import com.prowidesoftware.swift.model.field.Field108;
import com.prowidesoftware.swift.model.field.Field202;
import com.prowidesoftware.swift.model.field.Field203;
import com.prowidesoftware.swift.model.field.Field280;
import com.prowidesoftware.swift.model.field.Field281;
import com.prowidesoftware.swift.model.field.Field431;

public class MT023Test {

	private String sample1 = "{1:F01VNDZBET2AXXX0000000000}{2:I023DYDYXXXXXXXXN}{4:"
			+ "{202:0001}"
			+ "{203:0001}"
			+ "{280:1508010605VNDZBET2AXXX0017000375Y}"
			+ "{108:TEST 1}"
			+ "{431:01}"
			+ "{281:1508010605VNDZBET2AXXX0017000244Y}}";
	
	@Test
	public void test_parse1() {
		MT023 m = MT023.parse(sample1);
		assertNotNull(m);

		assertNotNull(m.getField202());
		assertEquals("0001", m.getField202().get(0).getValue());

		assertNotNull(m.getField203());
		assertEquals("0001", m.getField203().get(0).getValue());
		
		assertNotNull(m.getField280());
		assertEquals("1508010605VNDZBET2AXXX0017000375Y", m.getField280().get(0).getValue());
		
		assertNotNull(m.getField108());
		assertEquals("TEST 1", m.getField108().get(0).getValue());
		
		assertNotNull(m.getField431());
		assertEquals("01", m.getField431().get(0).getValue());
		
		assertNotNull(m.getField281());
		assertEquals("1508010605VNDZBET2AXXX0017000244Y", m.getField281().get(0).getValue());
	}
	
	@Test
	public void test_create1() {
		MT023 m = new MT023();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field202("0001"));
		m.append(new Field203("0001"));
		m.append(new Field280("1508010605VNDZBET2AXXX0017000375Y"));
		m.append(new Field108("TEST 1"));
		m.append(new Field431("01"));
		m.append(new Field281("1508010605VNDZBET2AXXX0017000244Y"));
		
		assertEquals(sample1, m.message());
	}
	
}

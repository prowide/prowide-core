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
import com.prowidesoftware.swift.model.field.Field144;
import com.prowidesoftware.swift.model.field.Field251;

public class MT025Test {

	private String sample = "{1:F01VNDZBET2AXXX0000000000}{2:I025DYDYXXXXXXXXN}{4:"
			+ "{251:061220BANKBEBBAXXX0074005566}"
			+ "{140:123456789012345}"
			+ "{144:00}}";
	@Test
	public void test_parse() {
		MT025 m = MT025.parse(sample);
		assertNotNull(m);

		assertNotNull(m.getField251());
		assertEquals("061220BANKBEBBAXXX0074005566", m.getField251().getValue());
		
		assertNotNull(m.getField140());
		assertEquals("123456789012345", m.getField140().getValue());
		
		assertNotNull(m.getField144());
		assertEquals("00", m.getField144().getValue());
	}
	
	@Test
	public void test_create() {
		MT025 m = new MT025();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field251("061220BANKBEBBAXXX0074005566"));
		m.append(new Field140("123456789012345"));
		m.append(new Field144("00"));
		
		assertEquals(sample, m.message());
	}
}

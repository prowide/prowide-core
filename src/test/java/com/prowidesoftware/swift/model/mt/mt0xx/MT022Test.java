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
import com.prowidesoftware.swift.model.field.Field251;
import com.prowidesoftware.swift.model.field.Field252;
import com.prowidesoftware.swift.model.field.Field253;
import com.prowidesoftware.swift.model.field.Field254;
import com.prowidesoftware.swift.model.field.Field258;
import com.prowidesoftware.swift.model.field.Field259;
import com.prowidesoftware.swift.model.field.Field260;

public class MT022Test {

	private String sample1 = "{1:F01VNDZBET2AXXX0000000000}{2:I022DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{251:010605VNDZBET2AXXX0017000375}}";
	
	private String sample2 = "{1:F01VNDZBET2AXXX0000000000}{2:I022DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{251:050822VNDZBET2AXXX0529001624}}";

	private String sample3 = "{1:F01VNDZBET2AXXX0000000000}{2:I022DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{252:050822VNDZBET2AXXX0294001093050822VNDZBET2AXXX0294001096}}";
	
	private String sample4 = "{1:F01VNDZBET2AXXX0000000000}{2:I022DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{253:050823VNDZBET2AXXX0042000211}}";

	private String sample5 = "{1:F01VNDZBET2AXXX0000000000}{2:I022DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{254:050822VNDZBET2AXXX0025000093050822VNDZBET2AXXX002500009714501454}}";
	
	private String sample6 = "{1:F01VNDZBET2AXXX0000000000}{2:I022DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{258:VNDZBET2AXXX002599905082214501454}}";	
	
	private String sample7 = "{1:F01VNDZBET2AXXX0000000000}{2:I022DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{259:VNDZBET2AXXX0025905082214501454}}";
	
	private String sample8 = "{1:F01VNDZBET2AXXX0000000000}{2:I022DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{260:VNDZBET2AXXX050822145014540025}}";	
	
	@Test
	public void test_parse1() {
		MT022 m = MT022.parse(sample1);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField251());
		assertEquals("010605VNDZBET2AXXX0017000375", m.getField251().getValue());
	}
	
	@Test
	public void test_parse2() {
		MT022 m = MT022.parse(sample2);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField251());
		assertEquals("050822VNDZBET2AXXX0529001624", m.getField251().getValue());
	}
	
	@Test
	public void test_parse3() {
		MT022 m = MT022.parse(sample3);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField252());
		assertEquals("050822VNDZBET2AXXX0294001093050822VNDZBET2AXXX0294001096", m.getField252().getValue());
	}

	@Test
	public void test_parse4() {
		MT022 m = MT022.parse(sample4);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField253());
		assertEquals("050823VNDZBET2AXXX0042000211", m.getField253().getValue());
	}

	@Test
	public void test_parse5() {
		MT022 m = MT022.parse(sample5);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField254());
		assertEquals("050822VNDZBET2AXXX0025000093050822VNDZBET2AXXX002500009714501454", m.getField254().getValue());
	}

	@Test
	public void test_parse6() {
		MT022 m = MT022.parse(sample6);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField258());
		assertEquals("VNDZBET2AXXX002599905082214501454", m.getField258().getValue());
	}

	@Test
	public void test_parse7() {
		MT022 m = MT022.parse(sample7);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField259());
		assertEquals("VNDZBET2AXXX0025905082214501454", m.getField259().getValue());
	}

	@Test
	public void test_parse8() {
		MT022 m = MT022.parse(sample8);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField260());
		assertEquals("VNDZBET2AXXX050822145014540025", m.getField260().getValue());
	}

	@Test
	public void test_create1() {
		MT022 m = new MT022();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field251("010605VNDZBET2AXXX0017000375"));
		
		assertEquals(sample1, m.message());
	}
	
	@Test
	public void test_create2() {
		MT022 m = new MT022();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field251("050822VNDZBET2AXXX0529001624"));
		
		assertEquals(sample2, m.message());
	}
	
	@Test
	public void test_create3() {
		MT022 m = new MT022();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field252("050822VNDZBET2AXXX0294001093050822VNDZBET2AXXX0294001096"));
		
		assertEquals(sample3, m.message());
	}
	
	@Test
	public void test_create4() {
		MT022 m = new MT022();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field253("050823VNDZBET2AXXX0042000211"));
		
		assertEquals(sample4, m.message());
	}
	
	@Test
	public void test_create5() {
		MT022 m = new MT022();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field254("050822VNDZBET2AXXX0025000093050822VNDZBET2AXXX002500009714501454"));
		
		assertEquals(sample5, m.message());
	}
	
	@Test
	public void test_create6() {
		MT022 m = new MT022();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field258("VNDZBET2AXXX002599905082214501454"));
		
		assertEquals(sample6, m.message());
	}
	
	@Test
	public void test_create7() {
		MT022 m = new MT022();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field259("VNDZBET2AXXX0025905082214501454"));
		
		assertEquals(sample7, m.message());
	}
	
	@Test
	public void test_create8() {
		MT022 m = new MT022();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field260("VNDZBET2AXXX050822145014540025"));
		
		assertEquals(sample8, m.message());
	}
	
}

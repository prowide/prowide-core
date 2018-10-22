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
import com.prowidesoftware.swift.model.field.Field255;
import com.prowidesoftware.swift.model.field.Field258;
import com.prowidesoftware.swift.model.field.Field259;
import com.prowidesoftware.swift.model.field.Field260;

public class MT020Test {

	private String sample1 = "{1:F01VNDZBET2AXXX0000000000}{2:I020DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{251:010605VNDZBET2AXXX0017000375}}";
	
	private String sample2 = "{1:F01VNDZBET2AXXX0000000000}{2:I020DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{252:050801VNDZBET2AXXX0134000649050801VNDZBET2AXXX0135000663}}";

	private String sample3 = "{1:F01VNDZBET2AXXX0000000000}{2:I020DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{253:050719MVNDZBET2AXXX0181000391}}";
	
	private String sample4 = "{1:F01VNDZBET2AXXX0000000000}{2:I020DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{254:050723VNDZBET2AXXX0207001127050723VNDZBET2AXXX0210001130}}";

	private String sample5 = "{1:F01VNDZBET2AXXX0000000000}{2:I020DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{255:VNDZBET2AXXXX003310305082419221942}}";
	
	private String sample6 = "{1:F01VNDZBET2AXXX0000000000}{2:I020DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{258:VNDZBET2AXXX002599905082315481552}}";	
	
	private String sample7 = "{1:F01VNDZBET2AXXX0000000000}{2:I020DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{259:VNDZBET2AXXXXXX0025905082315481552}}";
	
	private String sample8 = "{1:F01VNDZBET2AXXX0000000000}{2:I020DYDYXXXXXXXXN}{4:"
			+ "{102:VNDZBET2AXXX}"
			+ "{260:VNDZBET2AXXX050823154815520025}}";	
	
	@Test
	public void test_parse1() {
		MT020 m = MT020.parse(sample1);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField251());
		assertEquals("010605VNDZBET2AXXX0017000375", m.getField251().getValue());
	}
	
	@Test
	public void test_parse2() {
		MT020 m = MT020.parse(sample2);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField252());
		assertEquals("050801VNDZBET2AXXX0134000649050801VNDZBET2AXXX0135000663", m.getField252().getValue());
	}
	
	@Test
	public void test_parse3() {
		MT020 m = MT020.parse(sample3);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField253());
		assertEquals("050719MVNDZBET2AXXX0181000391", m.getField253().getValue());
	}

	@Test
	public void test_parse4() {
		MT020 m = MT020.parse(sample4);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField254());
		assertEquals("050723VNDZBET2AXXX0207001127050723VNDZBET2AXXX0210001130", m.getField254().getValue());
	}

	@Test
	public void test_parse5() {
		MT020 m = MT020.parse(sample5);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField255());
		assertEquals("VNDZBET2AXXXX003310305082419221942", m.getField255().getValue());
	}

	@Test
	public void test_parse6() {
		MT020 m = MT020.parse(sample6);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField258());
		assertEquals("VNDZBET2AXXX002599905082315481552", m.getField258().getValue());
	}

	@Test
	public void test_parse7() {
		MT020 m = MT020.parse(sample7);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField259());
		assertEquals("VNDZBET2AXXXXXX0025905082315481552", m.getField259().getValue());
	}

	@Test
	public void test_parse8() {
		MT020 m = MT020.parse(sample8);
		assertNotNull(m);

		assertNotNull(m.getField102());
		assertEquals("VNDZBET2AXXX", m.getField102().getValue());

		assertNotNull(m.getField260());
		assertEquals("VNDZBET2AXXX050823154815520025", m.getField260().getValue());
	}

	@Test
	public void test_create1() {
		MT020 m = new MT020();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field251("010605VNDZBET2AXXX0017000375"));
		
		assertEquals(sample1, m.message());
	}
	
	@Test
	public void test_create2() {
		MT020 m = new MT020();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field252("050801VNDZBET2AXXX0134000649050801VNDZBET2AXXX0135000663"));
		
		assertEquals(sample2, m.message());
	}
	
	@Test
	public void test_create3() {
		MT020 m = new MT020();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field253("050719MVNDZBET2AXXX0181000391"));
		
		assertEquals(sample3, m.message());
	}
	
	@Test
	public void test_create4() {
		MT020 m = new MT020();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field254("050723VNDZBET2AXXX0207001127050723VNDZBET2AXXX0210001130"));
		
		assertEquals(sample4, m.message());
	}
	
	@Test
	public void test_create5() {
		MT020 m = new MT020();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field255("VNDZBET2AXXXX003310305082419221942"));
		
		assertEquals(sample5, m.message());
	}
	
	@Test
	public void test_create6() {
		MT020 m = new MT020();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field258("VNDZBET2AXXX002599905082315481552"));
		
		assertEquals(sample6, m.message());
	}
	
	@Test
	public void test_create7() {
		MT020 m = new MT020();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field259("VNDZBET2AXXXXXX0025905082315481552"));
		
		assertEquals(sample7, m.message());
	}
	
	@Test
	public void test_create8() {
		MT020 m = new MT020();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field102("VNDZBET2AXXX"));
		m.append(new Field260("VNDZBET2AXXX050823154815520025"));
		
		assertEquals(sample8, m.message());
	}
	
}

package com.prowidesoftware.swift.model.mt.mt0xx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.prowidesoftware.swift.model.field.Field106;
import com.prowidesoftware.swift.model.field.Field107;
import com.prowidesoftware.swift.model.field.Field108;
import com.prowidesoftware.swift.model.field.Field175;


public class MT011Test {

	private String sample = "{1:F01VNDZBET2AXXX0000000000}{2:I011DYDYXXXXXXXXN}{4:"
			+ "{175:1608}"
			+ "{106:010605VNDZBET2AXXX0017000375}"
			+ "{108:TEST 1}"
			+ "{175:1508}"
			+ "{107:010605VNDZGBT2AXXX0017000244}}";

	@Test
	public void test_parse() {
		MT011 m = MT011.parse(sample);
		assertNotNull(m);

		assertNotNull(m.getField175());
		assertEquals("1608", m.getField175().get(0).getValue());
		
		assertNotNull(m.getField106());
		assertEquals("010605VNDZBET2AXXX0017000375", m.getField106().getValue());
		
		assertNotNull(m.getField108());
		assertEquals("TEST 1", m.getField108().getValue());
		
		assertNotNull(m.getField175());
		assertEquals("1508", m.getField175().get(1).getValue());
		
		assertNotNull(m.getField107());
		assertEquals("010605VNDZGBT2AXXX0017000244", m.getField107().getValue());
		
	}
	
	@Test
	public void test_create() {
		MT011 m = new MT011();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field175("1608"));
		m.append(new Field106("010605VNDZBET2AXXX0017000375"));
		m.append(new Field108("TEST 1"));
		m.append(new Field175("1508"));
		m.append(new Field107("010605VNDZGBT2AXXX0017000244"));
		
		assertEquals(sample, m.message());
	}
}
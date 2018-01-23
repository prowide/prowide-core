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

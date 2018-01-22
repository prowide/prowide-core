package com.prowidesoftware.swift.model.mt.mt0xx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.prowidesoftware.swift.model.field.Field102;
import com.prowidesoftware.swift.model.field.Field104;
import com.prowidesoftware.swift.model.field.Field106;
import com.prowidesoftware.swift.model.field.Field108;
import com.prowidesoftware.swift.model.field.Field431;


public class MT010Test {

	private String sample = "{1:F01VNDZBET2AXXX0000000000}{2:I010DYDYXXXXXXXXN}{4:"
			+ "{106:010517VNDZBET2AXXX0026000409}"
			+ "{108:PRIORITY}"
			+ "{431:07}"
			+ "{102:VNZDBET2XXXX}"
			+ "{104:U}}";

	@Test
	public void test_parse() {
		MT010 m = MT010.parse(sample);
		assertNotNull(m);
		
		assertNotNull(m.getField106());
		assertEquals("010517VNDZBET2AXXX0026000409", m.getField106().getValue());
		
		assertNotNull(m.getField108());
		assertEquals("PRIORITY", m.getField108().getValue());
		
		assertNotNull(m.getField431());
		assertEquals("07", m.getField431().getValue());
		
		assertNotNull(m.getField102());
		assertEquals("VNZDBET2XXXX", m.getField102().getValue());
		
		assertNotNull(m.getField104());
		assertEquals("U", m.getField104().getValue());
	}
	
	@Test
	public void test_create() {
		MT010 m = new MT010();
		m.setSender("VNDZBET2AXXX");
		m.setReceiver("DYDYXXXXFXXX");
		m.append(new Field106("010517VNDZBET2AXXX0026000409"));
		m.append(new Field108("PRIORITY"));
		m.append(new Field431("07"));
		m.append(new Field102("VNZDBET2XXXX"));
		m.append(new Field104("U"));
		assertEquals(sample, m.message());
	}
}
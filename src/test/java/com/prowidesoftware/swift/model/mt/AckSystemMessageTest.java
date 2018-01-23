package com.prowidesoftware.swift.model.mt;

import org.junit.Ignore;

@Ignore
public class AckSystemMessageTest {

	/* sebastian marxo 2016 los getters con Fieldnn se sacaron por dependencia circular en codegen
	@Test
	public void testParseAck() {
		AckSystemMessage ack = AckSystemMessage.parse("{1:F21MLCOUS33AXXX0221000001}{4:{177:1702040914}{451:0}}");
		assertNotNull(ack);
		assertTrue(ack.isAck());
		assertEquals("1702040914", ack.getField177().getValue());
		assertEquals("0", ack.getField451().getValue());
	}
	
	@Test
	public void testParseNak() {
		AckSystemMessage ack = AckSystemMessage.parse("{1:F21MLCOUS33AXXX0221000001}{4:{177:1702040914}{451:1}}");
		assertNotNull(ack);
		assertTrue(ack.isNack());
		assertEquals("1702040914", ack.getField177().getValue());
		assertEquals("1", ack.getField451().getValue());
	}
	*/
}

package com.prowidesoftware.swift.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link AbstractSwiftMessage} model API
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8.4
 */
public class AbstractSwiftMessageTest {

	@Test
	public void match() {
		MtSwiftMessage msg = new MtSwiftMessage();
		assertFalse(msg.match(""));
		assertFalse(msg.match(null));
		msg.setIdentifier("");
		assertFalse(msg.match(""));
		assertFalse(msg.match(null));
		msg.setIdentifier("fin.103");
		assertFalse(msg.match(""));
		assertFalse(msg.match(null));
		assertTrue(msg.match("fin.103"));
		assertTrue(msg.match("fin.*"));
		assertFalse(msg.match("fin.*STP"));
		msg.setIdentifier("camt.002.002.01");
		assertTrue(msg.match("camt.*"));
		assertTrue(msg.match("camt.*01"));
	}
}

package com.prowidesoftware.swift.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MxIdTest {

	@Test
	public void testNamespaceConstructor1() {
		MxId mid = new MxId("urn:iso:std:iso:20022:tech:xsd:acmt.015.001.02");
		assertEquals(MxBusinessProcess.acmt, mid.getBusinessProcess());
		assertEquals("015", mid.getFunctionality());
		assertEquals("001", mid.getVariant());
		assertEquals("02", mid.getVersion());
	}
	
	@Test
	public void testNamespaceConstructor2() {
		MxId mid = new MxId("urn:swift:xsd:tsmt.039.001.02");
		assertEquals(MxBusinessProcess.tsmt, mid.getBusinessProcess());
		assertEquals("039", mid.getFunctionality());
		assertEquals("001", mid.getVariant());
		assertEquals("02", mid.getVersion());
	}

}

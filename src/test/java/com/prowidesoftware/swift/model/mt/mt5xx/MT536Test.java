package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MT536Test {

	@Test
	public void testA1() {
		MT536 m = new MT536();
		m.append(MT536.SequenceA1.newInstance());
		assertTrue(m.getSequenceB1a1List().isEmpty());
	}
	
	@Test
	public void test2() {
		MT536 m = new MT536();
		m.append(MT536.SequenceB1a1.newInstance());
		assertTrue(m.getSequenceA1List().isEmpty());
	}
	
}

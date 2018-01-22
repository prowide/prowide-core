package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.prowidesoftware.swift.model.mt.mt5xx.MT576;


public class MT576Test {

	@Test
	public void test1() {
		MT576 m = new MT576();
		m.append(MT576.SequenceA1.newInstance());
		assertTrue(m.getSequenceB2aList().isEmpty());
	}
	@Test
	public void test2() {
		MT576 m = new MT576();
		m.append(MT576.SequenceB2a.newInstance());
		assertTrue(m.getSequenceA1List().isEmpty());
	}
	
}

package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.prowidesoftware.swift.model.mt.mt5xx.MT538;


public class MT538Test {

	@Test
	public void test1() {
		MT538 m = new MT538();
		m.append(MT538.SequenceA1.newInstance());
		assertTrue(m.getSequenceB2a1List().isEmpty());
	}
	@Test
	public void test2() {
		MT538 m = new MT538();
		m.append(MT538.SequenceB2a1.newInstance());
		assertTrue(m.getSequenceA1List().isEmpty());
	}
	
}

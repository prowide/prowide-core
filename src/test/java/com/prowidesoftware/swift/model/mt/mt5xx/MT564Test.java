package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.prowidesoftware.swift.model.mt.mt5xx.MT564;


public class MT564Test {

	@Test
	public void test1() {
		MT564 m = new MT564();
		m.append(MT564.SequenceB1.newInstance());
		assertTrue(m.getSequenceE1aList().isEmpty());
	}
	@Test
	public void test2() {
		MT564 m = new MT564();
		m.append(MT564.SequenceE.newInstance(MT564.SequenceE1a.newInstance()));
		assertTrue(m.getSequenceB1().isEmpty());
	}
	
}

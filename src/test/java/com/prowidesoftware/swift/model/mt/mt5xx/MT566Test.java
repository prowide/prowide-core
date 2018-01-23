package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.prowidesoftware.swift.model.mt.mt5xx.MT566;


public class MT566Test {

	@Test
	public void test1() {
		MT566 m = new MT566();
		m.append(MT566.SequenceB1.newInstance());
		assertTrue(m.getSequenceD1aList().isEmpty());
	}
	@Test
	public void test2() {
		MT566 m = new MT566();
		m.append(MT566.SequenceD1a.newInstance());
		assertTrue(m.getSequenceB1List().isEmpty());
	}
	
}

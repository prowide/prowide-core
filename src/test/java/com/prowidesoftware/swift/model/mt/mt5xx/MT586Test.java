package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.prowidesoftware.swift.model.mt.mt5xx.MT586;



public class MT586Test {

	@Test
	public void test1() {
		MT586 m = new MT586();
		m.append(MT586.SequenceA1.newInstance());
		assertTrue(m.getSequenceB1List().isEmpty());
	}
	@Test
	public void test2() {
		MT586 m = new MT586();
		m.append(MT586.SequenceB1.newInstance());
		assertTrue(m.getSequenceA1List().isEmpty());
	}
	
}

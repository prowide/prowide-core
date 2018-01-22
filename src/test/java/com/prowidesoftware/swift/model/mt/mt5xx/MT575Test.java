package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.prowidesoftware.swift.model.mt.mt5xx.MT575;


public class MT575Test {

	@Test
	public void test1() {
		MT575 m = new MT575();
		m.append(MT575.SequenceA1.newInstance());
		assertTrue(m.getSequenceB1a1List().isEmpty());
		assertTrue(m.getSequenceC1List().isEmpty());
	}
	
	@Test
	public void test2() {
		MT575 m = new MT575();
		m.append(MT575.SequenceB1a1.newInstance());
		assertTrue(m.getSequenceA1List().isEmpty());
		assertTrue(m.getSequenceC1List().isEmpty());
	}
	
	@Test
	public void test3() {
		MT575 m = new MT575();
		m.append(MT575.SequenceC1.newInstance());
		assertTrue(m.getSequenceA1List().isEmpty());
		assertTrue(m.getSequenceB1a1List().isEmpty());
	}
	
	@Test
	public void test4() {
		MT575 m = new MT575();
		m.append(MT575.SequenceB1a4.newInstance());
		assertTrue(m.getSequenceC2aList().isEmpty());
	}
	
	@Test
	public void test5() {
		MT575 m = new MT575();
		m.append(MT575.SequenceC2a.newInstance());
		assertTrue(m.getSequenceB1a4List().isEmpty());
	}
	
}

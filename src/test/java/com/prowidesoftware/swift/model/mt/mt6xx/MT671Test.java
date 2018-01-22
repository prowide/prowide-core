package com.prowidesoftware.swift.model.mt.mt6xx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.prowidesoftware.swift.model.mt.mt6xx.MT671;


public class MT671Test {

	@Test
	public void test1() {
		MT671 m = new MT671();
		m.append(MT671.SequenceB.newInstance(MT671.SequenceB2.newInstance()));
		assertTrue(m.getSequenceC().isEmpty());
	}
	@Test
	public void test2() {
		MT671 m = new MT671();
		m.append(MT671.SequenceC.newInstance());
		assertTrue(m.getSequenceB2List().isEmpty());
	}
	
	@Test
	public void test3() {
		MT671 m = new MT671();
		m.append(MT671.SequenceC.newInstance());
		assertFalse(m.getSequenceC().isEmpty());
	}
	
}

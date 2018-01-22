package com.prowidesoftware.swift.model.mt.mt6xx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.prowidesoftware.swift.model.mt.mt6xx.MT670;


public class MT670Test {

	@Test
	public void test1() {
		MT670 m = new MT670();
		m.append(MT670.SequenceB.newInstance(MT670.SequenceB2.newInstance()));
		assertTrue(m.getSequenceC().isEmpty());
		assertFalse(m.getSequenceB2List().isEmpty());
	}
	@Test
	public void test2() {
		MT670 m = new MT670();
		m.append(MT670.SequenceC.newInstance());
		assertTrue(m.getSequenceB2List().isEmpty());
	}
	
	@Test
	public void test3() {
		MT670 m = new MT670();
		m.append(MT670.SequenceC.newInstance());
		assertFalse(m.getSequenceC().isEmpty());
	}
	
}

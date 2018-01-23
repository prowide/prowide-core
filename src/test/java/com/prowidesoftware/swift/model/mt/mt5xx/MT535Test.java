package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MT535Test {

	@Test
	public void test1() {
		MT535 m = new MT535();
		m.append(MT535.SequenceB1b.newInstance(MT535.SequenceB1b1.newInstance()));
		assertTrue(m.getSequenceB1cList().isEmpty());
	}
	
	@Test
	public void test1a() {
		MT535 m = new MT535();
		m.append(MT535.SequenceB.newInstance(MT535.SequenceB1b1.newInstance()));
		assertTrue(m.getSequenceB1cList().isEmpty());
	}
	
	@Test
	public void test1b() {
		MT535 m = new MT535();
		m.append(MT535.SequenceB1b1.newInstance());
		assertTrue(m.getSequenceB1cList().isEmpty());
	}
	
	@Test
	public void test2() {
		MT535 m = new MT535();
		m.append(MT535.SequenceB1.newInstance(MT535.SequenceB1c.newInstance()));
		assertTrue(m.getSequenceB1b1List().isEmpty());
	}
	
}

package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Field38GTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("38G",
				"11A/22b"
			);
	}
	
	@Test
	public void test() {
		final Field38G f = new Field38G("11A/22b");
		assertEquals("11", f.getComponent1());
		assertEquals(11, f.getComponent1AsNumber().intValue());
		assertEquals("A", f.getComponent2());
		assertEquals("22", f.getComponent3());
		assertEquals(22, f.getComponent3AsNumber().intValue());
		assertEquals("b", f.getComponent4());
	}

}
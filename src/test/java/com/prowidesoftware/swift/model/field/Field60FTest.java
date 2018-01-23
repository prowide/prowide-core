/*
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 */
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Field60FTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("60F",
				"D121212USD1234,56",
				"121212USD1234,56"
			);
	}
	
	@Test
	public void testSetCurrency() throws Exception {
		assertEquals("ARS", new Field60F().setCurrency("ARS").getValue());
	}

	@Test
	public void testSetAmount() throws Exception {
		assertEquals("100,", new Field60F().setAmount(100).getValue());
	}

	@Test
	public void testSetDCMark() throws Exception {
		assertEquals("D", new Field60F().setDCMark("D").getValue());
	}

	@Test
	public void testSetCurrencyTag() throws Exception {
		assertEquals("ARS", new Field60F().setCurrency("ARS").asTag().getValue());
	}

	@Test
	public void testSetAmountTag() throws Exception {
		assertEquals("100,", new Field60F().setAmount(100).asTag().getValue());
	}

	@Test
	public void testSetDCMarkTag() throws Exception {
		assertEquals("D", new Field60F().setDCMark("D").asTag().getValue());
	}

}

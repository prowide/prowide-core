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

/**
 * Test for fields getLabel API.
 *
 * @author www.prowidesoftware.com
 * @since 7.8.4
 */
public class GetLabelTest {

	@Test
	public void test35B() {
		final Field35B f = new Field35B();
		assertEquals("Qualifier", f.getComponentLabel(1));
		assertEquals("ISIN", f.getComponentLabel(2));
	}
	
	@Test
	public void test32A() {
		final Field32A f = new Field32A();
		assertEquals("Date", f.getComponentLabel(1));
		assertEquals("Currency", f.getComponentLabel(2));
		assertEquals("Amount", f.getComponentLabel(3));
	}
	
	@Test
	public void test50K() {
		final Field50K f = new Field50K();
		assertEquals("Account", f.getComponentLabel(1));
		assertEquals("Name And Address", f.getComponentLabel(2));
		assertEquals("Name And Address 2", f.getComponentLabel(3));
	}

	
}

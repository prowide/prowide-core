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
*/
package com.prowidesoftware.swift.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.prowidesoftware.swift.Constants;

/**
 * Message fragment tests.
 * 
 * @author www.prowidesoftware.com
 * @since 4.0
 */
public class SwiftMessageFragmentTest {
	
	@Test 
	public void testFragment_no() {
		SwiftMessage m = new SwiftMessage(true);
		m.getBlock1().setValue(Constants.B1_DATA);
		m.getBlock2().setValue(Constants.B2_INPUT);
		m.getBlock3().append(new Tag("120:asdadad"));
		m.getBlock4().append(new Tag("120:asdadad"));
		m.getBlock5().append(new Tag("120:asdadad"));

		assertFalse(m.isFragment());
	}

	@Test 
	public void testFragment_yesMiddle() {
		SwiftMessage m = new SwiftMessage(true);
		m.getBlock1().setValue(Constants.B1_DATA);
		m.getBlock2().setValue(Constants.B2_INPUT);
		m.getBlock3().append(new Tag("120:asdadad"));
		m.getBlock4().append(new Tag("120:asdadad"));
		m.getBlock4().append(new Tag("202:0001"));
		m.getBlock4().append(new Tag("203:0002"));
		m.getBlock5().append(new Tag("120:asdadad"));

		assertTrue(m.isFragment());
		assertEquals(Integer.valueOf(2), m.fragmentCount());
		assertEquals(Integer.valueOf(1), m.fragmentNumber());
		assertFalse(m.isLastFragment());
	}

	@Test 
	public void testFragment_yesLast() {
		SwiftMessage m = new SwiftMessage(true);
		m.getBlock1().setValue(Constants.B1_DATA);
		m.getBlock2().setValue(Constants.B2_INPUT);
		m.getBlock3().append(new Tag("120:asdadad"));
		m.getBlock4().append(new Tag("120:asdadad"));
		m.getBlock4().append(new Tag("202:0002"));
		m.getBlock4().append(new Tag("203:0002"));
		m.getBlock5().append(new Tag("120:asdadad"));

		assertTrue(m.isFragment());
		assertEquals(Integer.valueOf(2), m.fragmentCount());
		assertEquals(Integer.valueOf(2), m.fragmentNumber());
		assertTrue(m.isLastFragment());
	}
}

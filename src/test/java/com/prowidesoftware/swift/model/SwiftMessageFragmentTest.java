/*
 * Copyright 2006-2018 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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

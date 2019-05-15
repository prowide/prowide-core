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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Block2 input tests.
 *
 * @since 4.0
 */
public class SwiftBlock2InputTest {

	SwiftBlock2Input in;
	
	@Before
	public void setUp() {
		in = new SwiftBlock2Input();
	}

	@Test 
	public void testInput_1a() {
		in.setValue("2:I103BANKDEFFXXXXU3003");
		assertTrue(in.isInput());
		assertEquals("103", in.getMessageType());
		assertEquals("BANKDEFFXXXX", in.getReceiverAddress());	
		assertEquals("U", in.getMessagePriority());
		assertEquals("3", in.getDeliveryMonitoring());
		assertEquals("003", in.getObsolescencePeriod());
	}

	@Test 
	public void testInput_1b() {
		in.setValue("2:I103BANKDEFFXXXXU3");
		assertTrue(in.isInput());
		assertEquals("103", in.getMessageType());
		assertEquals("BANKDEFFXXXX", in.getReceiverAddress());	
		assertEquals("U", in.getMessagePriority());
		assertEquals("3", in.getDeliveryMonitoring());
		assertNull(in.getObsolescencePeriod());
	}

	@Test 
	public void testInput_1c() {
		in.setValue("2:I103BANKDEFFXXXXU");
		assertTrue(in.isInput());
		assertEquals("103", in.getMessageType());
		assertEquals("BANKDEFFXXXX", in.getReceiverAddress());	
		assertEquals("U", in.getMessagePriority());
		assertNull(in.getDeliveryMonitoring());
		assertNull(in.getObsolescencePeriod());
	}

	@Test 
	public void testInput_2a() {
		in.setValue("I103BANKDEFFXXXXU3003");
		assertTrue(in.isInput());
		assertEquals("103", in.getMessageType());
		assertEquals("BANKDEFFXXXX", in.getReceiverAddress());	
		assertEquals("U", in.getMessagePriority());
		assertEquals("3", in.getDeliveryMonitoring());
		assertEquals("003", in.getObsolescencePeriod());
	}

	@Test 
	public void testInput_2b() {
		in.setValue("I103BANKDEFFXXXXU3");
		assertTrue(in.isInput());
		assertEquals("103", in.getMessageType());
		assertEquals("BANKDEFFXXXX", in.getReceiverAddress());	
		assertEquals("U", in.getMessagePriority());
		assertEquals("3", in.getDeliveryMonitoring());
		assertNull(in.getObsolescencePeriod());
	}

	@Test 
	public void testInput_2c() {
		in.setValue("I103BANKDEFFXXXXU");
		assertTrue(in.isInput());
		assertEquals("103", in.getMessageType());
		assertEquals("BANKDEFFXXXX", in.getReceiverAddress());	
		assertEquals("U", in.getMessagePriority());
		assertNull(in.getDeliveryMonitoring());
		assertNull(in.getObsolescencePeriod());
	}

	@Test 
	public void testInput_3() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:I103BANKDEFFXXXXU3003");
		assertTrue(nin.isInput());
		assertEquals("103", nin.getMessageType());
		assertEquals("BANKDEFFXXXX", nin.getReceiverAddress());	
		assertEquals("U", nin.getMessagePriority());
		assertEquals("3", nin.getDeliveryMonitoring());
		assertEquals("003", nin.getObsolescencePeriod());
	}

	@Test 
	public void testInput_4() {
		SwiftBlock2Input nin = new SwiftBlock2Input("I103BANKDEFFXXXXU3003");
		assertTrue(nin.isInput());
		assertEquals("103", nin.getMessageType());
		assertEquals("BANKDEFFXXXX", nin.getReceiverAddress());	
		assertEquals("U", nin.getMessagePriority());
		assertEquals("3", nin.getDeliveryMonitoring());
		assertEquals("003", nin.getObsolescencePeriod());
	}

	@Test 
	public void testInput_5() {
		try {
			//set an invalid length value
			in.setValue("I103BANKDEFFXXXXU300");
		} catch (IllegalArgumentException e) {
			return;
		}
		fail("IllegalArgumentException not thrown");
	}

	@Test 
	public void testInput_6() {
		try {
			//set an invalid starting substring
			in.setValue("O103BANKDEFFXXXXU3003");
		} catch (IllegalArgumentException e) {
			return;
		}
		fail("IllegalArgumentException not thrown");
	}

	@Test 
	public void testInput_7() {
		try {
			//set an invalid starting substring
			in.setValue("1:I103BANKDEFFXXXXU3003");
		} catch (IllegalArgumentException e) {
			return;
		}
		fail("IllegalArgumentException not thrown");
	}

	@Test 
	public void testInputGetValue() {
		String value = "I103BANKDEFFXXXXU3003";
		in.setValue(value);
		assertEquals(value, in.getValue());
	}

	@Test 
	public void testIsEmptyAndSize() {
		in.setMessagePriority(null);
		assertTrue(in.isEmpty());
		assertTrue(in.size() == 0);
		in.setValue("I103BANKDEFFXXXXU3003");
		assertFalse(in.isEmpty());
		assertTrue(in.size() == 21);
	}
	
	@Test 
	public void testInput_Lenient() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:I103BANKDEFFXXXXU3003", true);
		assertTrue(nin.isInput());
		assertEquals("103", nin.getMessageType());
		assertEquals("BANKDEFFXXXX", nin.getReceiverAddress());	
		assertEquals("U", nin.getMessagePriority());
		assertEquals("3", nin.getDeliveryMonitoring());
		assertEquals("003", nin.getObsolescencePeriod());
	}
	
	@Test 
	public void testInput_LenientLessThanExpected() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:I103BANKDEFFXXXXU300", true);
		assertTrue(nin.isInput());
		assertEquals("103", nin.getMessageType());
		assertEquals("BANKDEFFXXXX", nin.getReceiverAddress());	
		assertEquals("U", nin.getMessagePriority());
		assertEquals("3", nin.getDeliveryMonitoring());
		assertEquals("00", nin.getObsolescencePeriod()); //less than expected
	}

	@Test 
	public void testInput_LenientMoreThanExpected() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:I103BANKDEFFXXXXU300399", true);
		assertTrue(nin.isInput());
		assertEquals("103", nin.getMessageType());
		assertEquals("BANKDEFFXXXX", nin.getReceiverAddress());	
		assertEquals("U", nin.getMessagePriority());
		assertEquals("3", nin.getDeliveryMonitoring());
		assertEquals("00399", nin.getObsolescencePeriod()); //more than expected
	}

	@Test 
	public void testInput_LenientMissignObsolencePeriod() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:I103BANKDEFFXXXXU3", true);
		assertTrue(nin.isInput());
		assertEquals("103", nin.getMessageType());
		assertEquals("BANKDEFFXXXX", nin.getReceiverAddress());	
		assertEquals("U", nin.getMessagePriority());
		assertEquals("3", nin.getDeliveryMonitoring());
		assertNull(nin.getObsolescencePeriod());
	}
	
	@Test 
	public void testInput_LenientMissignDeliveryMonitoring() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:I103BANKDEFFXXXXU", true);
		assertTrue(nin.isInput());
		assertEquals("103", nin.getMessageType());
		assertEquals("BANKDEFFXXXX", nin.getReceiverAddress());	
		assertEquals("U", nin.getMessagePriority());
		assertNull(nin.getDeliveryMonitoring());
		assertNull(nin.getObsolescencePeriod());
	}

	@Test 
	public void testInput_LenientMissignPriority() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:I103BANKDEFFXXXX", true);
		assertTrue(nin.isInput());
		assertEquals("103", nin.getMessageType());
		assertEquals("BANKDEFFXXXX", nin.getReceiverAddress());	
		assertNull(nin.getMessagePriority());
		assertNull(nin.getDeliveryMonitoring());
		assertNull(nin.getObsolescencePeriod());
	}

	@Test 
	public void testInput_LenientMissignLTBranch() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:I103BANKDEFFX", true);
		assertTrue(nin.isInput());
		assertEquals("103", nin.getMessageType());
		assertEquals("BANKDEFFX", nin.getReceiverAddress());	
		assertNull(nin.getMessagePriority());
		assertNull(nin.getDeliveryMonitoring());
		assertNull(nin.getObsolescencePeriod());
	}

	@Test 
	public void testInput_LenientMissignLT() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:I103", true);
		assertTrue(nin.isInput());
		assertEquals("103", nin.getMessageType());
		assertNull(nin.getReceiverAddress());	
		assertNull(nin.getMessagePriority());
		assertNull(nin.getDeliveryMonitoring());
		assertNull(nin.getObsolescencePeriod());
	}

	@Test 
	public void testInput_LenientMissignType() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:I", true);
		assertTrue(nin.isInput());
		assertNull(nin.getMessageType());
		assertNull(nin.getReceiverAddress());	
		assertNull(nin.getMessagePriority());
		assertNull(nin.getDeliveryMonitoring());
		assertNull(nin.getObsolescencePeriod());
	}

	@Test 
	public void testInput_LenientMissignInputOututIndication() {
		SwiftBlock2Input nin = new SwiftBlock2Input("2:", true);
		assertTrue(nin.isInput());
		assertNull(nin.getMessageType());
		assertNull(nin.getReceiverAddress());	
		assertNull(nin.getMessagePriority());
		assertNull(nin.getDeliveryMonitoring());
		assertNull(nin.getObsolescencePeriod());
	}

	@Test 
	public void testInput_LenientEmpty() {
		SwiftBlock2Input nin = new SwiftBlock2Input("", true);
		assertTrue(nin.isInput());
		assertNull(nin.getMessageType());
		assertNull(nin.getReceiverAddress());	
		assertNull(nin.getMessagePriority());
		assertNull(nin.getDeliveryMonitoring());
		assertNull(nin.getObsolescencePeriod());
	}

	@Test 
	public void testInput_LenientNull() {
		SwiftBlock2Input nin = new SwiftBlock2Input(null, true);
		assertTrue(nin.isInput());
		assertNull(nin.getMessageType());
		assertNull(nin.getReceiverAddress());	
		assertNull(nin.getMessagePriority());
		assertNull(nin.getDeliveryMonitoring());
		assertNull(nin.getObsolescencePeriod());
	}

	@Test
	public void testCopyConstructor() {
		SwiftBlock2Input a = new SwiftBlock2Input("I103BANKDEFFXXXXU3003");
		SwiftBlock2Input b = new SwiftBlock2Input(a);
		assertEquals(a.getValue(), b.getValue());
	}

}

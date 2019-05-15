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
 * Block2 output tests.
 *
 * @since 4.0
 */
public class SwiftBlock2OutputTest {

	SwiftBlock2Output out;
	
	@Before
	public void setUp() {
		out = new SwiftBlock2Output();
	}

	@Test 
	public void testOutput() {
		out.setValue("2:O1001200010103BANKBEBBAXXX22221234560101031201N");
		assertFalse(out.isInput());
		assertEquals("100", out.getMessageType());
		assertEquals("1200", out.getSenderInputTime());		
		
		assertEquals("010103", out.getMIRDate());
		assertEquals("BANKBEBBAXXX", out.getMIRLogicalTerminal());
		assertEquals("2222", out.getMIRSessionNumber());
		assertEquals("123456", out.getMIRSequenceNumber());
		assertEquals("010103BANKBEBBAXXX2222123456", out.getMIR());
		
		assertEquals("010103", out.getReceiverOutputDate());
		assertEquals("1201", out.getReceiverOutputTime());
		assertEquals("N", out.getMessagePriority());
	}

	@Test 
	public void testOutput_2() {
		out.setValue("O1001200010103BANKBEBBAXXX22221234560101031201N");
		assertFalse(out.isInput());
		assertEquals("100", out.getMessageType());
		assertEquals("1200", out.getSenderInputTime());		
		assertEquals("010103BANKBEBBAXXX2222123456", out.getMIR());
		assertEquals("010103", out.getReceiverOutputDate());
		assertEquals("1201", out.getReceiverOutputTime());
		assertEquals("N", out.getMessagePriority());
	}

	@Test 
	public void testOutput_3() {
		SwiftBlock2Output nout = new SwiftBlock2Output("2:O1001200010103BANKBEBBAXXX22221234560101031201N");
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertEquals("1200", nout.getSenderInputTime());		
		assertEquals("010103BANKBEBBAXXX2222123456", nout.getMIR());
		assertEquals("010103", nout.getReceiverOutputDate());
		assertEquals("1201", nout.getReceiverOutputTime());
		assertEquals("N", nout.getMessagePriority());
	}

	@Test 
	public void testOutput_4() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N");
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertEquals("1200", nout.getSenderInputTime());		
		assertEquals("010103BANKBEBBAXXX2222123456", nout.getMIR());
		assertEquals("010103", nout.getReceiverOutputDate());
		assertEquals("1201", nout.getReceiverOutputTime());
		assertEquals("N", nout.getMessagePriority());
	}

	@Test 
	public void testOutput_5() {
		try {
			//set an invalid length value
			out.setValue("O1001200010103BANKBEBBAXXX222212345601010");
		} catch (IllegalArgumentException e) {
			return;
		}
		fail("IllegalArgumentException not thrown");
	}

	@Test 
	public void testOutput_6() {
		try {
			//set an invalid starting substring
			out.setValue("I1001200010103BANKBEBBAXXX22221234560101031201N");
		} catch (IllegalArgumentException e) {
			return;
		}
		fail("IllegalArgumentException not thrown");
	}

	@Test 
	public void testOutput_7() {
		try {
			//set an invalid starting substring
			out.setValue("1:O1001200010103BANKBEBBAXXX22221234560101031201N");
		} catch (IllegalArgumentException e) {
			return;
		}
		fail("IllegalArgumentException not thrown");
	}

	@Test 
	public void testOutputGetValue() {
		String value = "O1001200010103BANKBEBBAXXX22221234560101031201N";
		out.setValue(value);
		assertEquals(value, out.getValue());
	}	

	@Test 
	public void testOutputMIR() {
		out.setMIR("YYMMDDBANKBEBBAXXX2222123456");
		assertEquals("YYMMDD", out.getMIRDate());
		assertEquals("BANKBEBBAXXX", out.getMIRLogicalTerminal());
		assertEquals("2222", out.getMIRSessionNumber());
		assertEquals("123456", out.getMIRSequenceNumber());
	}

	@Test 
	public void testOutputMIR_2() {
		try {
			//set an invalid length string
			out.setMIR("YYMMDDBANKBEBBAXXX2222123");
		} catch (IllegalArgumentException e) {
			return;
		}
		fail("IllegalArgumentException not thrown");
	}

	@Test 
	public void testIsEmptyAndSize() {
		out.setMessagePriority(null);
		assertTrue(out.isEmpty());
		assertTrue(out.size() == 0);
		out.setValue("O1001200010103BANKBEBBAXXX22221234560101031201N");
		assertFalse(out.isEmpty());
		assertTrue(out.size() == 47);
	}
	
	@Test 
	public void testOutput_Lenient() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N", true);
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertEquals("1200", nout.getSenderInputTime());		
		assertEquals("010103BANKBEBBAXXX2222123456", nout.getMIR());
		assertEquals("010103", nout.getReceiverOutputDate());
		assertEquals("1201", nout.getReceiverOutputTime());
		assertEquals("N", nout.getMessagePriority());
	}
	
	@Test 
	public void testOutput_LenientMoreThanExpected() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201NAA", true);
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertEquals("1200", nout.getSenderInputTime());		
		assertEquals("010103BANKBEBBAXXX2222123456", nout.getMIR());
		assertEquals("010103", nout.getReceiverOutputDate());
		assertEquals("1201", nout.getReceiverOutputTime());
		assertEquals("NAA", nout.getMessagePriority());
	}
	
	@Test 
	public void testOutput_LenientMissingPriority() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201", true);
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertEquals("1200", nout.getSenderInputTime());		
		assertEquals("010103BANKBEBBAXXX2222123456", nout.getMIR());
		assertEquals("010103", nout.getReceiverOutputDate());
		assertEquals("1201", nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}
	
	@Test 
	public void testOutput_LenientInvalidOutputTime() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX222212345601010312", true);
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertEquals("1200", nout.getSenderInputTime());		
		assertEquals("010103BANKBEBBAXXX2222123456", nout.getMIR());
		assertEquals("010103", nout.getReceiverOutputDate());
		assertEquals("12", nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}

	@Test 
	public void testOutput_LenientMissingOutputTime() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX2222123456010103", true);
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertEquals("1200", nout.getSenderInputTime());		
		assertEquals("010103BANKBEBBAXXX2222123456", nout.getMIR());
		assertEquals("010103", nout.getReceiverOutputDate());
		assertNull(nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}
	
	@Test 
	public void testOutput_LenientMissingOutputDate() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX2222123456", true);
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertEquals("1200", nout.getSenderInputTime());		
		assertEquals("010103BANKBEBBAXXX2222123456", nout.getMIR());
		assertNull(nout.getReceiverOutputDate());
		assertNull(nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}

	@Test 
	public void testOutput_LenientInvalidMIR() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX222212", true);
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertEquals("1200", nout.getSenderInputTime());		
		assertEquals("010103BANKBEBBAXXX222212", nout.getMIR());
		assertNull(nout.getReceiverOutputDate());
		assertNull(nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}

	@Test 
	public void testOutput_LenientMissingMIR() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O1001200", true);
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertEquals("1200", nout.getSenderInputTime());		
		assertNull(nout.getMIR());
		assertNull(nout.getReceiverOutputDate());
		assertNull(nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}

	@Test 
	public void testOutput_LenientMissingInputTime() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O100", true);
		assertFalse(nout.isInput());
		assertEquals("100", nout.getMessageType());
		assertNull(nout.getSenderInputTime());		
		assertNull(nout.getMIR());
		assertNull(nout.getReceiverOutputDate());
		assertNull(nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}

	@Test 
	public void testOutput_LenientMissingType() {
		SwiftBlock2Output nout = new SwiftBlock2Output("O", true);
		assertFalse(nout.isInput());
		assertNull(nout.getMessageType());
		assertNull(nout.getSenderInputTime());		
		assertNull(nout.getMIR());
		assertNull(nout.getReceiverOutputDate());
		assertNull(nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}

	@Test 
	public void testOutput_LenientMissingInputOutputIndication() {
		SwiftBlock2Output nout = new SwiftBlock2Output("2:", true);
		assertFalse(nout.isInput());
		assertNull(nout.getMessageType());
		assertNull(nout.getSenderInputTime());		
		assertNull(nout.getMIR());
		assertNull(nout.getReceiverOutputDate());
		assertNull(nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}

	@Test 
	public void testOutput_LenientEmpty() {
		SwiftBlock2Output nout = new SwiftBlock2Output("", true);
		assertFalse(nout.isInput());
		assertNull(nout.getMessageType());
		assertNull(nout.getSenderInputTime());		
		assertNull(nout.getMIR());
		assertNull(nout.getReceiverOutputDate());
		assertNull(nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}

	@Test 
	public void testOutput_LenientNull() {
		SwiftBlock2Output nout = new SwiftBlock2Output(null, true);
		assertFalse(nout.isInput());
		assertNull(nout.getMessageType());
		assertNull(nout.getSenderInputTime());		
		assertNull(nout.getMIR());
		assertNull(nout.getReceiverOutputDate());
		assertNull(nout.getReceiverOutputTime());
		assertNull(nout.getMessagePriority());
	}

	@Test
	public void testSetMIR() {
		SwiftBlock2Output b = new SwiftBlock2Output();
		b.setMIR("010103BANKBEBBAXXX2222123456", true);
		assertEquals("010103BANKBEBBAXXX2222123456", b.getMIR());
		MIR mir = new MIR(b.getMIR());
		assertEquals("010103", mir.getDate());
		assertEquals("BANKBEBBAXXX", mir.getLogicalTerminal());
		assertEquals("2222", mir.getSessionNumber());
		assertEquals("123456", mir.getSequenceNumber());

		b.setMIR("010103BANKBEBBAXXX2222", true);
		assertEquals("010103BANKBEBBAXXX2222", b.getMIR());

		b.setMIR("010103BANKBEBBAXXX", true);
		assertEquals("010103BANKBEBBAXXX", b.getMIR());

		b.setMIR("010103", true);
		assertEquals("010103", b.getMIR());

		b.setMIR("FOO", true);
		assertEquals("FOO", b.getMIR());
	}

	@Test
	public void testCopyConstructor() {
		SwiftBlock2Output a = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N");
		SwiftBlock2Output b = new SwiftBlock2Output(a);
		assertEquals(a.getValue(), b.getValue());
	}

}

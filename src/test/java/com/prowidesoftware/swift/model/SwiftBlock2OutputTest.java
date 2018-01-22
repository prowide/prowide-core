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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Block2 output tests.
 * 
 * @author www.prowidesoftware.com
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

}

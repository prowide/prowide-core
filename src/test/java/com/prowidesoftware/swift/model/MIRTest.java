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
package com.prowidesoftware.swift.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test for Message Input Reference (MIR) model class.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class MIRTest {

	@Test
	public void testSplitComponents() throws Exception {
		MIR mir = new MIR("");
		assertNull(mir.getDate());
		assertNull(mir.getLogicalTerminal());
		assertNull(mir.getSessionNumber());		
		assertNull(mir.getSequenceNumber());

		mir = new MIR(null);
		assertNull(mir.getDate());
		assertNull(mir.getLogicalTerminal());
		assertNull(mir.getSessionNumber());		
		assertNull(mir.getSequenceNumber());
		
		mir = new MIR("1234567890");
		assertNull(mir.getDate());
		assertNull(mir.getLogicalTerminal());
		assertNull(mir.getSessionNumber());		
		assertNull(mir.getSequenceNumber());
		
		mir = new MIR("1234567890123456789012345678901234567890");
		assertNull(mir.getDate());
		assertNull(mir.getLogicalTerminal());
		assertNull(mir.getSessionNumber());		
		assertNull(mir.getSequenceNumber());
		
		mir = new MIR("091203BANKBEBBAXXX2222123456");
		assertEquals("091203", mir.getDate());
		assertEquals("BANKBEBBAXXX", mir.getLogicalTerminal());
		assertEquals("2222", mir.getSessionNumber());
		assertEquals("123456", mir.getSequenceNumber());	
	}
	
}

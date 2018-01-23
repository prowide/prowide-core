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
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * LT address model testing
 * 
 * @author www.prowidesoftware.com
 * @since 7.6
 */
public class LogicalTerminalAddressTest {

	@Test public void testGetLogicalTerminalIdentifier() {
		assertEquals("A", String.valueOf(new LogicalTerminalAddress("FOOOOOHUAXXX").getLTIdentifier()));
		assertNull(new LogicalTerminalAddress("FOOOOOHUXXX").getLTIdentifier());
		assertNull(new LogicalTerminalAddress("FOOOOOHU").getLTIdentifier());
		assertNull(new LogicalTerminalAddress("").getLTIdentifier());
	}
	
	@Test public void testSenderLT() {
		assertEquals("FOOOOOHUAXXX", new LogicalTerminalAddress("FOOOOOHUAXXX").getSenderLogicalTerminalAddress());
		assertEquals("FOOOOOHUAXXX", new LogicalTerminalAddress("FOOOOOHUXXXX").getSenderLogicalTerminalAddress());
		assertEquals("FOOOOOHUAXXX", new LogicalTerminalAddress("FOOOOOHUXXX").getSenderLogicalTerminalAddress());
		assertEquals("FOOOOOHUAXXX", new LogicalTerminalAddress("FOOOOOHU").getSenderLogicalTerminalAddress());
		assertNull(new LogicalTerminalAddress("FOO").getSenderLogicalTerminalAddress());
	}

	@Test public void testReceiverLT() {
		assertEquals("FOOOOOHUXXXX", new LogicalTerminalAddress("FOOOOOHUXXXX").getReceiverLogicalTerminalAddress());
		assertEquals("FOOOOOHUXXXX", new LogicalTerminalAddress("FOOOOOHUAXXX").getReceiverLogicalTerminalAddress());
		assertEquals("FOOOOOHUXXXX", new LogicalTerminalAddress("FOOOOOHUXXX").getReceiverLogicalTerminalAddress());
		assertEquals("FOOOOOHUXXXX", new LogicalTerminalAddress("FOOOOOHU").getReceiverLogicalTerminalAddress());
		assertNull(new LogicalTerminalAddress("FOO").getReceiverLogicalTerminalAddress());
	}

}

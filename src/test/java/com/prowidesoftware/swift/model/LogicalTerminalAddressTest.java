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
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * LT address model testing
 *
 * @since 7.6
 */
public class LogicalTerminalAddressTest {

	@Test
	public void testParse() {
		LogicalTerminalAddress b = new LogicalTerminalAddress(null);
		assertNull(b.getInstitution());
		assertNull(b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		assertNull(b.getLTIdentifier());
		b = new LogicalTerminalAddress("");
		assertNull(b.getInstitution());
		assertNull(b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		assertNull(b.getLTIdentifier());
		b = new LogicalTerminalAddress("I");
		assertEquals("I", b.getInstitution());
		assertNull(b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		assertNull(b.getLTIdentifier());
		b = new LogicalTerminalAddress("IIII");
		assertEquals("IIII", b.getInstitution());
		assertNull(b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		assertNull(b.getLTIdentifier());
		b = new LogicalTerminalAddress("IIIIC");
		assertEquals("IIII", b.getInstitution());
		assertEquals("C", b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		assertNull(b.getLTIdentifier());
		b = new LogicalTerminalAddress("IIIICC");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		assertNull(b.getLTIdentifier());
		b = new LogicalTerminalAddress("IIIICCL");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertEquals("L", b.getLocation());
		assertNull(b.getBranch());
		assertNull(b.getLTIdentifier());
		b = new LogicalTerminalAddress("IIIICCLL");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertEquals("LL", b.getLocation());
		assertNull(b.getBranch());
		assertNull(b.getLTIdentifier());
		b = new LogicalTerminalAddress("IIIICCLLB");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertEquals("LL", b.getLocation());
		assertEquals("B", b.getBranch());
		assertNull(b.getLTIdentifier());
		b = new LogicalTerminalAddress("IIIICCLLBBB");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertEquals("LL", b.getLocation());
		assertEquals("BBB", b.getBranch());
		assertNull(b.getLTIdentifier());
		b = new LogicalTerminalAddress("IIIICCLLABBB");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertEquals("LL", b.getLocation());
		assertEquals('A', b.getLTIdentifier().charValue());
		assertEquals("BBB", b.getBranch());
	}

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

	@Test
	public void testGetBranchBIC12() {
		final LogicalTerminalAddress lt = new LogicalTerminalAddress("FOOOOOHUABCD");
		assertEquals('A', lt.getLTIdentifier().charValue());
		assertEquals("BCD", lt.getBranch());
		assertEquals("FOOOOOHUBCD", lt.getBic11());
	}

}

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
 * Test for Message Input Reference (MIR) model class.
 *
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

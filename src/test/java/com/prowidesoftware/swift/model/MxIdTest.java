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

import org.junit.Test;

public class MxIdTest {

	@Test
	public void testNamespaceConstructor1() {
		MxId mid = new MxId("urn:iso:std:iso:20022:tech:xsd:acmt.015.001.02");
		assertEquals(MxBusinessProcess.acmt, mid.getBusinessProcess());
		assertEquals("015", mid.getFunctionality());
		assertEquals("001", mid.getVariant());
		assertEquals("02", mid.getVersion());
	}
	
	@Test
	public void testNamespaceConstructor2() {
		MxId mid = new MxId("urn:swift:xsd:tsmt.039.001.02");
		assertEquals(MxBusinessProcess.tsmt, mid.getBusinessProcess());
		assertEquals("039", mid.getFunctionality());
		assertEquals("001", mid.getVariant());
		assertEquals("02", mid.getVersion());
	}

}

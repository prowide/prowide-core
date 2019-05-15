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

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link AbstractSwiftMessage} model API
 * 
 * @since 7.8.4
 */
public class AbstractSwiftMessageTest {

	@Test
	public void match() {
		MtSwiftMessage msg = new MtSwiftMessage();
		assertFalse(msg.match(""));
		assertFalse(msg.match(null));

		msg.setIdentifier("");
		assertFalse(msg.match(""));
		assertFalse(msg.match(null));

		msg.setIdentifier("fin.103");
		assertFalse(msg.match(""));
		assertFalse(msg.match(null));
		assertTrue(msg.match("fin.103"));
		assertTrue(msg.match("fin.*"));
		assertFalse(msg.match("fin.*STP"));

		msg.setIdentifier("camt.002.002.01");
		assertTrue(msg.match("camt.*"));
		assertTrue(msg.match("camt.*01"));
	}

	@Test
	public void category() {
		MtSwiftMessage mt = new MtSwiftMessage();
		assertEquals("", mt.getCategory());

		mt.setIdentifier("");
		assertEquals("", mt.getCategory());

		mt.setIdentifier("fin.103");
		assertEquals("1", mt.getCategory());

		MxSwiftMessage mx = new MxSwiftMessage();
		assertEquals("", mx.getCategory());

		mx.setIdentifier("");
		assertEquals("", mx.getCategory());

		mx.setIdentifier("camt.002.002.01");
		assertEquals("camt", mx.getCategory());
	}

}

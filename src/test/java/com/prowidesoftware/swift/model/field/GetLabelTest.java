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
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test for fields getLabel API.
 *
 * @author www.prowidesoftware.com
 * @since 7.8.4
 */
public class GetLabelTest {

	@Test
	public void test35B() {
		final Field35B f = new Field35B();
		assertEquals("Qualifier", f.getComponentLabel(1));
		assertEquals("ISIN", f.getComponentLabel(2));
	}
	
	@Test
	public void test32A() {
		final Field32A f = new Field32A();
		assertEquals("Date", f.getComponentLabel(1));
		assertEquals("Currency", f.getComponentLabel(2));
		assertEquals("Amount", f.getComponentLabel(3));
	}
	
	@Test
	public void test50K() {
		final Field50K f = new Field50K();
		assertEquals("Account", f.getComponentLabel(1));
		assertEquals("Name And Address", f.getComponentLabel(2));
		assertEquals("Name And Address 2", f.getComponentLabel(3));
	}

	
}

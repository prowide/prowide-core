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

public class Field60FTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("60F",
				"D121212USD1234,56",
				"121212USD1234,56"
			);
	}
	
	@Test
	public void testSetCurrency() throws Exception {
		assertEquals("ARS", new Field60F().setCurrency("ARS").getValue());
	}

	@Test
	public void testSetAmount() throws Exception {
		assertEquals("100,", new Field60F().setAmount(100).getValue());
	}

	@Test
	public void testSetDCMark() throws Exception {
		assertEquals("D", new Field60F().setDCMark("D").getValue());
	}

	@Test
	public void testSetCurrencyTag() throws Exception {
		assertEquals("ARS", new Field60F().setCurrency("ARS").asTag().getValue());
	}

	@Test
	public void testSetAmountTag() throws Exception {
		assertEquals("100,", new Field60F().setAmount(100).asTag().getValue());
	}

	@Test
	public void testSetDCMarkTag() throws Exception {
		assertEquals("D", new Field60F().setDCMark("D").asTag().getValue());
	}

}

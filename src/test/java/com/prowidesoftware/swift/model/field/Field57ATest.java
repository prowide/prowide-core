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

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field57A and similar fields.
 *
 * @since 7.7
 */
public class Field57ATest extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("57A",
				"/D/1234\nFOOBAR",
				"/1234\nFOOBAR",
				"FOOBAR"
			);
	}
	
	@Test
	public void test_getValue() {
		Field57A f = new Field57A();
		f.setComponent1("");
		f.setComponent2("1234567890");
		f.setComponent3("FOOBARXX");
		assertEquals("//1234567890" + FINWriterVisitor.SWIFT_EOL + "FOOBARXX", f.getValue());
	}

	@Test
	public void test_getValue2() {
		Field57A f = new Field57A();
		f.setComponent2("1234567890");
		f.setComponent3("FOOBARXX");
		assertEquals("/1234567890" + FINWriterVisitor.SWIFT_EOL + "FOOBARXX", f.getValue());
	}

}
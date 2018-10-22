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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field50K and similar fields.
 *
 * @since 6.0
 */
public class Field50KTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("50K",
				"/acc",
				"/acc\nbbb\nccc\nddd\neee"
			);
	}

	@Test
	public void testSerialization2() {
		Field50K f = new Field50K("/345345234534\nSDFGSDFGSDFGSD");
		assertNotNull(f.getValue());
		assertEquals("/345345234534"+FINWriterVisitor.SWIFT_EOL+"SDFGSDFGSDFGSD", f.getValue());
	}

	@Test
	public void testGetValue() {
		Field50K f = new Field50K("/acc");
		assertEquals("/acc", f.getValue());
		f.setComponent2("c2");
		assertEquals("/acc\r\nc2", f.getValue());
	}
	
	@Test
	public void testGetValue2() {
		Field50K f = new Field50K("/acc\nbbb\nccc\nddd\neee");
		assertEquals("acc", f.getComponent1());
		assertEquals("bbb", f.getComponent2());
		assertEquals("ccc", f.getComponent3());
		assertEquals("ddd", f.getComponent4());
		assertEquals("eee", f.getComponent5());
	}
	
	@Test
	public void testGetValue3() {
		Field50K f = new Field50K("bbb\nccc\nddd\neee");
		assertNull(f.getComponent1());
		assertEquals("bbb", f.getComponent2());
		assertEquals("ccc", f.getComponent3());
		assertEquals("ddd", f.getComponent4());
		assertEquals("eee", f.getComponent5());
	}
	
}
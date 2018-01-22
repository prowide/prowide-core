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
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field59 and similar fields.
 *
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field59Test extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("59",
				"/acc\nbbb\nccc\nddd\neee"
			);
	}
	
	@Test
	public void testGetValue() {
		final Field59 f = new Field59("/acc");
		assertEquals("/acc", f.getValue());
		f.setComponent2("c2");
		assertEquals("/acc\r\nc2", f.getValue());
	}

	@Test
	public void testGetValue2() {
		final Field59 f = new Field59("/acc\nbbb\nccc\nddd\neee");
		assertEquals("acc", f.getComponent1());
		assertEquals("bbb", f.getComponent2());
		assertEquals("ccc", f.getComponent3());
		assertEquals("ddd", f.getComponent4());
		assertEquals("eee", f.getComponent5());
	}

	@Test
	public void testGetValue3() {
		final Field59 f = new Field59("bbb\nccc\nddd\neee");
		assertNull(f.getComponent1());
		assertEquals("bbb", f.getComponent2());
		assertEquals("ccc", f.getComponent3());
		assertEquals("ddd", f.getComponent4());
		assertEquals("eee", f.getComponent5());
	}

	@Test
	public void testGetWithLabelsRepetitions() {
		final Field59 f = new Field59("/1234\nccc\nddd\neee\nfff");
		assertEquals("1234", f.getAccount());
		assertEquals("ccc", f.getNameAndAddressLine1());
		assertEquals("ddd", f.getNameAndAddressLine2());
		assertEquals("eee", f.getNameAndAddressLine3());
		assertEquals("fff", f.getNameAndAddressLine4());
		assertEquals("ccc"+FINWriterVisitor.SWIFT_EOL+"ddd"+FINWriterVisitor.SWIFT_EOL+"eee"+FINWriterVisitor.SWIFT_EOL+"fff", f.getNameAndAddress());
		f.setComponent3(null);
		assertEquals("ccc"+FINWriterVisitor.SWIFT_EOL+"eee"+FINWriterVisitor.SWIFT_EOL+"fff", f.getNameAndAddress());
	}

	@Test
	public void testSetWithLabelsRepetitions() {
		Field59 f = new Field59();
		f.setAccount("1234");
		assertEquals("1234", f.getComponent1());

		f.setNameAndAddressLine1("aaaa");
		assertEquals("aaaa", f.getComponent2());

		f.setNameAndAddressLine2("bbbb");
		assertEquals("bbbb", f.getComponent3());

		f.setNameAndAddressLine3("cccc");
		assertEquals("cccc", f.getComponent4());

		f.setNameAndAddressLine4("dddd");
		assertEquals("dddd", f.getComponent5());

		f = new Field59();
		f.setNameAndAddress("aaaa\nbbbb\ncccc");
		assertEquals("aaaa"+FINWriterVisitor.SWIFT_EOL+"bbbb"+FINWriterVisitor.SWIFT_EOL+"cccc", f.getNameAndAddress());
	}

	@Test
	public void testMultilineApiGetLine1Empty() throws Exception {
		assertNull(new Field59("").getLine(1));
	}

	@Test
	public void testMultilineApiGetLine1Null() throws Exception {
		assertNull(new Field59((String)null).getLine(1));
	}
	
}
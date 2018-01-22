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
package com.prowidesoftware.swift.io;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Test;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;

/**
 * Test cases for the {@link RJEWriter} class
 * 
 * @author sebastian
 * @since 7.8.8
 */
public class RJEWriterTest {

	@Test
	public void test1() throws IOException {
		StringWriter s = new StringWriter();
		RJEWriter w = new RJEWriter(s);
		MT103 mt = new MT103();
		w.write(mt);
		assertEquals(s.toString(), mt.message());
	}
	
	@Test
	public void test2() throws IOException {
		StringWriter s = new StringWriter();
		RJEWriter w = new RJEWriter(s);
		MT103 mt = new MT103();
		w.write(mt);
		w.write(mt);
		assertEquals(s.toString(), mt.message() + FINWriterVisitor.SWIFT_EOL + RJEReader.SPLITCHAR + FINWriterVisitor.SWIFT_EOL + mt.message());
	}

}

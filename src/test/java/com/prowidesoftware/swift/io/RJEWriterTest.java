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

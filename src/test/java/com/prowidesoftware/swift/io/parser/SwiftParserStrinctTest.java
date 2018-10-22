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
package com.prowidesoftware.swift.io.parser;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Swift parser tests using the non lenient (strict) configuration.
 *
 * <p>In this configuration the parser will throw IllegalArgumentException
 * when the content is not wellfromed in terms of headers size and starting
 * and closing tags.
 */
public class SwiftParserStrinctTest {
	protected VisibleParser parser;

	@Before
	public void setUp() {
		this.parser = new VisibleParser();
		this.parser.getConfiguration().setLenient(false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConsumeBock1InvalidValueSize() throws IOException {
		parser.setData("{1:012345678901}");
		parser.consumeBlock(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConsumeBock1MissingClossingBracket() throws IOException {
		parser.setData("{1:0123456789012345678901234");
		parser.consumeBlock(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConsumeBock1MissingClossingBracket2() throws IOException {
		parser.setData("{1:0123456789012345678901234{2:I100BANKDEFFXXXXU3003}");
		parser.consumeBlock(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConsumeBock2InvalidValueSize() throws IOException {
		parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I100BANKDEFF3}");
		parser.consumeBlock(null); // block 1
		parser.consumeBlock(null); // block 2
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConsumeBock2MissingClosingBracket() throws IOException {
		parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I100BANKDEFFXXXXU3003");
		parser.consumeBlock(null); // block 1
		parser.consumeBlock(null); // block 2
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConsumeBock2MissingClosingBracket2() throws IOException {
		parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I100BANKDEFFXXXXU3003{3:{108:11111111}}");
		parser.consumeBlock(null); // block 1
		parser.consumeBlock(null); // block 2
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConsumeBock3MissingClosingBracket() throws IOException {
		parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I100BANKDEFFXXXXU3003}{3:{108:11111111}");
		parser.consumeBlock(null); // block 1
		parser.consumeBlock(null); // block 2
		parser.consumeBlock(null); // block 3
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBlock4MissingClossingBracket() throws IOException {
		parser.setData("{4:\r\n" +
				":79:FOO");
		parser.consumeBlock(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBlock4MissingClossingBracket2() throws IOException {
		parser.setData("{4:\r\n" +
				":79:FOO\r\n");
		parser.consumeBlock(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBlock4MissingClossingBracket3() throws IOException {
		parser.setData("{4:\r\n" +
				":79:FOO\r\n" +
				"-");
		parser.consumeBlock(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBlock4MissingClossingBracket4() throws IOException {
		parser.setData("{4:\r\n" +
				":79:FOO\r\n" +
				"-{");
		parser.consumeBlock(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBlock4MissingClossingBracket5() throws IOException {
		parser.setData("{4:\r\n" +
				":79:FOO\r\n" +
				"-{5:CHK:ABSH}");
		parser.consumeBlock(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBlock4MissingClossingHyphen() throws IOException {
		parser.setData("{4:\r\n" +
				":79:FOO\r\n" +
				"}");
		parser.consumeBlock(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBlock4MissingClossingHyphen2() throws IOException {
		parser.setData("{4:\r\n" +
				":79:FOO}");
		parser.consumeBlock(null);
	}

	@Test
	public void testBlock4ClossingBracketOk() throws IOException {
		parser.setData("{4:\r\n" +
				":79:FOO\r\n" +
				"-}");
		parser.consumeBlock(null);
	}

}
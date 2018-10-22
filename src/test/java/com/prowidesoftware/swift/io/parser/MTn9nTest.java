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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test cases for Mts n92, n95 and n96
 */
public class MTn9nTest extends BaseMessageTestcase {
	
	@Test 
	public void test192_1() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I192FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":11S:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("192", (parseMessage(messageToParse)).getType());
		assertEquals(3, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("11S"));
	}

	@Test 
	public void test192_2() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I192FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":11S:FOO\n" +
					":79:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("192", (parseMessage(messageToParse)).getType());
		assertEquals(4, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("11S"));
		assertEquals("FOO", b4.getTagValue("79"));
	}

	@Test 
	public void test192_3() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I192FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":11S:FOO\n" +
					":79:FOO\n" +
					":52A:FOO\n" +
					":23G:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("192", (parseMessage(messageToParse)).getType());
		assertEquals(6, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("11S"));
		assertEquals("FOO", b4.getTagValue("79"));
		assertEquals("FOO", b4.getTagValue("52A"));
		assertEquals("FOO", b4.getTagValue("23G"));
	}

	@Test 
	public void test192_4() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I192FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":11S:FOO\n" +
					":52A:FOO\n" +
					":23G:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("192", (parseMessage(messageToParse)).getType());
		assertEquals(5, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("11S"));
		assertEquals("FOO", b4.getTagValue("52A"));
		assertEquals("FOO", b4.getTagValue("23G"));
	}

	@Test 
	public void test192_5() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I192FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":11S:FOO\n" +
					":59:FOO\n" +
					"FOO2\n" +
					":23G:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("192", (parseMessage(messageToParse)).getType());
		assertEquals(5, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("11S"));
		assertEquals("FOO\nFOO2", b4.getTagValue("59"));
		assertEquals("FOO", b4.getTagValue("23G"));
	}

	@Test 
	public void test195_1() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I195FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":75:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("195", (parseMessage(messageToParse)).getType());
		assertEquals(3, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("75"));
	}

	@Test 
	public void test195_2() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I195FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":75:FOO\n" +
					":79:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("195", (parseMessage(messageToParse)).getType());
		assertEquals(4, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("75"));
		assertEquals("FOO", b4.getTagValue("79"));
	}

	@Test 
	public void test195_3() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I195FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":75:FOO\n" +
					":79:FOO\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("195", (parseMessage(messageToParse)).getType());
		assertEquals(6, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("75"));
		assertEquals("FOO", b4.getTagValue("79"));
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
	}

	@Test 
	public void test195_4() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I195FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":75:FOO\n" +
					":11R:FOO\n" +
					":21:FOO\n" +
					":52A:FOO\n" +
					":23G:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("195", (parseMessage(messageToParse)).getType());
		assertEquals(7, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("75"));
		assertEquals("FOO", b4.getTagValue("11R"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("52A"));	
		assertEquals("FOO", b4.getTagValue("23G"));	
	}

	@Test 
	public void test195_5() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I195FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":75:FOO\n" +
					":11R:FOO\n" +
					":21:FOO\n" +
					":52A:FOO\n" +
					":23G:FOO\n" +
					":59:FOO\n" +
					"FOO2\n" +
					":20:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("195", (parseMessage(messageToParse)).getType());
		assertEquals(9, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("75"));
		assertEquals("FOO", b4.getTagValue("11R"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("52A"));	
		assertEquals("FOO", b4.getTagValue("23G"));
		assertEquals("FOO\nFOO2", b4.getTagValue("59"));
		assertEquals("FOO", b4.getTagValue("20"));
	}

	@Test 
	public void test196_1() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I196FOOBARXXXXXXN}{4:\n" +
					":20:FOO\n" +
					":21:FOO\n" +
					":75:FOO\n" +
					":11R:FOO\n" +
					":21:FOO\n" +
					":52A:FOO\n" +
					":23G:FOO\n" +
					":59:FOO\n" +
					"FOO2\n" +
					":20:FOO\n" +
					"-}{5:{MAC:0D3E6718}{CHK:76FFBA03C41F}}"; 
		assertEquals("196", (parseMessage(messageToParse)).getType());
		assertEquals(9, b4.countAll());
		assertEquals("FOO", b4.getTagValue("20"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("75"));
		assertEquals("FOO", b4.getTagValue("11R"));
		assertEquals("FOO", b4.getTagValue("21"));
		assertEquals("FOO", b4.getTagValue("52A"));	
		assertEquals("FOO", b4.getTagValue("23G"));
		assertEquals("FOO\nFOO2", b4.getTagValue("59"));
		assertEquals("FOO", b4.getTagValue("20"));
	}
	
}
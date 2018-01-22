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
package com.prowidesoftware.swift.io.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test cases for Mts n92, n95 and n96
 * 
 * @author www.prowidesoftware.com
 */
public class MTn9nTest extends BaseMessageTestcase {
	
	@Test 
	public void test192_1() {
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I192ABCDEFGXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I192ABCDEFGXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I192ABCDEFGXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I192ABCDEFGXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I192ABCDEFGXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I195ABCDEFGXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I195ABCDEFGXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I195ABCDEFGXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I195ABCDEFGXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I195ABCDEFGXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I196ABCDEFGXXXXXN}{4:\n" +
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
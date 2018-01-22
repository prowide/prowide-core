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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * MT900 tests
 * 
 * @author www.prowidesoftware.com
 * @since 6.3
 */
public class MT900Test extends BaseMessageTestcase {
	
	@Test 
	public void testImproperBlock4Ending() {
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I900ABCDEFGXXXXXN}{4:\n" +
					":20:628735BKRU3X\n" + 
					":79:TO.   FOOBANK NA (HONG KONG)\n" + 
					"ATTN. FOO - FOO OPERATIONS\n" + 
					"FROM.\n" + 
					"RE.   FOO  SUB A/C 123456\n" + 
					"A/C: 961XXX\n" + 
					".\n" + 
					"WE CONFIRM TO INCREASE THE FOLLOWING DEPOSIT FROM\n" + 
					".\n" + 
					"INSTRUCTIONS:\n" + 
					".\n" + 
					"REGARDS,\n" + 
					"}"+
					"{5:{CHK:12C48A7C53B2}}{S:{REF:I20070404.763727356.out/1/1}}"; 
		
		parseMessage(messageToParse);
		assertEquals("900", this.o.getType());
		
		assertNull(b5);
		String expected = "out/1/1}}";
		String last = b4.getTagByName("79").getValue();
		last = last.substring(last.length()-expected.length(), last.length());
		assertEquals(expected, last);
	}

	@Test 
	public void testMissingEOBandB5() {
		messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I900ABCDEFGXXXXXN}{4:\n" +
					":20:628735BKRU3X\n" + 
					":79:TO FOO\n" + 
					"REGARDS,\n" + 
					"{"+
					"{5:{CHK:12C48A7C53B2}}{S:{REF:I20070404.763727356.out/1/1}}"; 
			
			parseMessage(messageToParse);
			assertEquals("900", this.o.getType());
			assertNull(b5);
			String expected = "out/1/1}}";
			String last = b4.getTagByName("79").getValue();
			last = last.substring(last.length()-expected.length(), last.length());
			assertEquals(expected, last);
		}

	@Test 
		public void testMissingEOBAndEOF() {
			messageToParse = "{1:F01ABCDEFGHIJKX3227607589}{2:I900ABCDEFGXXXXXN}{4:\n" +
						":20:628735BKRU3X\n" + 
						":79:TO FOO\n" + 
						"INSTRUCTIONS:\n" + 
						"{";
			
			parseMessage(messageToParse);
			assertEquals("900", this.o.getType());
			
			String last = b4.getTagByName("79").getValue();
			assertTrue(last.endsWith("\n{"));
		}

}
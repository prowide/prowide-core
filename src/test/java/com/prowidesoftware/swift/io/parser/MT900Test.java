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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * MT900 tests
 *
 * @since 6.3
 */
public class MT900Test extends BaseMessageTestcase {
	
	@Test 
	public void testImproperBlock4Ending() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I900FOOBARXXXXXXN}{4:\n" +
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
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I900FOOBARXXXXXXN}{4:\n" +
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
			messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I900FOOBARXXXXXXN}{4:\n" +
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
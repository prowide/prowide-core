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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Ignore;
import org.junit.Test;

import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.mt1xx.MT101;

public class ParserTest {

	@Test
	public void testParseoIso15022() {
		parseMessage("MT320.txt");
		parseMessage("SWIFTMT300_0000039099_0002.txt");
	}

	@Test
	public void testFormateoIso15022() {
		parseMessage("MT320.xml");
		parseMessage("SWIFTMT300_0000039099_0002.xml");
	}
	
	/*
	 * https://sourceforge.net/p/wife/bugs/80/
	 */
	@Test
	public void testParse101() {
		SwiftMessage msg = parseMessage("mt101.fin");
		assertMT101(msg);
	}
	
	/*
	 * https://sourceforge.net/p/wife/bugs/80/
	 */
	@Test
	public void testParse101Stream() throws IOException {
		MT101 mt = MT101.parse(getClass().getResourceAsStream("/mt101.fin"));
		SwiftMessage msg = mt.getSwiftMessage();
		assertMT101(msg);
	}

	/*
	 * https://sourceforge.net/p/wife/bugs/80/
	 */
	@Ignore("requires absolute path for file")
	@Test
	public void testParse101File() throws IOException {
		MT101 mt = MT101.parse(new File("/home/foo/src/prowide-core/src/test/resourcesmt101.fin"));
		SwiftMessage msg = mt.getSwiftMessage();
		assertMT101(msg);
	}

	private void assertMT101(final SwiftMessage msg) {
		assertNotNull(msg);
		assertNotNull(msg.getBlock1());
		assertNotNull(msg.getBlock2());
		assertNotNull(msg.getBlock4());
		assertNotNull(msg.getBlock5());
		assertEquals("TESTAR00AXXX", msg.getBlock1().getLogicalTerminal());
		assertEquals("101", msg.getBlock2().getMessageType());
		assertEquals("DG942_171206-004", msg.getBlock4().getFieldByName("20").getValue());
	}
	
	protected void formatMessage(String messagePath) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			InputStream is = ParserTest.class.getResourceAsStream(messagePath);
			int c;
			while ((c=is.read())!=-1) {
				baos.write(c);
			}
			baos.close();
			String xml = new String(baos.toByteArray());
			assertNotNull(xml);
		} catch (Throwable t) {
			t.printStackTrace();
			fail("error while processing: " + messagePath);
		}
	}

	protected SwiftMessage parseMessage(String messagePath) {
		InputStream input = ParserTest.class.getResourceAsStream("/"+messagePath);
		SwiftParser p = new SwiftParser(input);
		try {
			return p.message();
		} catch (Throwable t) {
			t.printStackTrace();
			fail("error while processing: " + messagePath);
		}
		return null;
	}

}

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
package com.prowidesoftware.swift;


import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.io.IConversionService;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.UnparsedTextList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Conversion services test.
 * 
 * @since 4.0
 */
public class GeneralAPITest {

	private IConversionService srv;
	private SwiftMessage msg;
	private String fin = "{1:F01FOOBARYYAXXX8669486759}{2:O1030831051017CRESLULLCXXX10194697810510170831N}{3:{108:P22VUXC43C6J3NLD}}{4:\n" +
			":20:AMLX985338-D4E5E\n" + 
			":23B:CRED\n" + 
			":32A:051018EUR66969,52\n" + 
			":33B:EUR66969,52\n" + 
			":50K:Foo SA\n" + 
			":53A:DEUTDEFF\n" + 
			":54A://RT\n" + 
			"FOOBARYY\n" +
			":59:/-\n" + 
			"Tressis SA\n" + 
			":70:/CS BD ST EUR B\n" + 
			"REDEMPTION AMLX985338\n" + 
			":71A:OUR\n" + 
			"-}{5:{MAC:52F48656}{CHK:24C40F1FF931}}";
	private String fin2 = "{1:F01FOOBARCAAXXX5306843322}{2:O2021128081024FOOSUS33DXXX19330576120810241058N}{4:\n" + 
		":20:TCPLO200919447\n" + 
		":21:345234\n" + 
		":32A:091118VEF2345234,3\n" + 
		":53B:/00010013800002000114\n" + 
		"FOO BANK\n" + 
		":58D:/00013500510020179998\n" + 
		"FOO NAME\n" + 
		"R00000V234234\n" + 
		":72:/TIPO/419\n" + 
		"/PLAZO/3\n" + 
		"/TASA/4\n" + 
		"-}";
	private UnparsedTextList unparsedTexts;
	private String someMsgText = "{1:L02VNDZBET2AXXX}{4:{501:05134200001900000513420000190000B8D33C65}{110:001}}";
	private String someText = "hello world";
	
	@Before
	public void setUp() {
		srv = new ConversionService();
		msg = new SwiftMessage();
		
		unparsedTexts = new UnparsedTextList();
		unparsedTexts.addText(this.someMsgText);
		unparsedTexts.addText(this.someText);
	}
	
	/**
	 * Test method for model and parser.
	 */
	@Test
	public void testGetMTFromFIN() {
		msg = srv.getMessageFromFIN(fin);
		assertNotNull(msg);	
		SwiftBlock4 b4 = msg.getBlock4();
		assertNotNull(b4);
		assertEquals("AMLX985338-D4E5E", b4.getTagByName("20").getValue());
		assertEquals("051018EUR66969,52", b4.getTagByName("32A").getValue());
	}
	
	/**
	 * Test method for model and parser.
	 */
	@Test
	public void testGetMTFromFIN2() {
		msg = srv.getMessageFromFIN(fin2);
		assertNotNull(msg);
		SwiftBlock4 b4 = msg.getBlock4();
		assertNotNull(b4);
		assertEquals("TCPLO200919447", b4.getTagByName("20").getValue());
		assertEquals("091118VEF2345234,3", b4.getTagByName("32A").getValue());
//		assertEquals((new Double(2345234.3)).doubleValue(), mt202.getField32A().getComponent3AsNumber().doubleValue());
	}
	
}

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
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.model.SwiftMessage;

/**
 * MT940 tests
 *
 * @since 4.0
 */
public class UnparsedTextParsingTest extends BaseMessageTestcase {
	
	@Test 
	public void test_1() {
	    String msg = "{1:F21XYZABCAAXXX1111112222}{4:{177:0011111111}{451:0}}{1:F21XYZABCAAXXXX1111112222}{2:O5691340110817LXLXXXXX4A1000002782131108171440N}{3:{108:MT569 011 OF 021}}{4:\n"
		    + ":35B:ISIN 123456ABCDEF\n"
		    + ":36B::SECV//UNIT/1,34\n"
		    + ":16S:SECDET\n"
		    + ":16S:VALDET\n"
		    + ":16S:TRANSDET\n"
		    + ":16S:SUMC\n"
		    + ":16S:SUME\n"
		    + ":16R:ADDINFO\n"
		    + ":19A::TCOP//USD123456789012,34\n"
		    + ":16S:ADDINFO\n"
		    + "-}{5:{CHK:15C62B525DAA}{TNG:}}{S:{SAC:}{COP:P}}"; 
	    
	    try {
			SwiftMessage m = SwiftMessage.parse(msg);
			SwiftMessage m569 = SwiftMessage.parse(m.getUnparsedTexts().getAsFINString());
	
			assertEquals("569", m569.getType());
			assertEquals("F21XYZABCAAXXXX1111112222", m569.getBlock1().getBlockValue());
			
			ConversionService service = new ConversionService(); 
			service.getXml(m.getUnparsedTexts().getAsFINString());
				
	    } catch (IOException ex) {
	    	fail(ex.getMessage());
	    }
		
	}
	
}
	

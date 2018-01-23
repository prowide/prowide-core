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
package com.prowidesoftware.swift.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftMessage;

/**
 * Swift message comparator for tests.
 * 
 * @author www.prowidesoftware.com
 * @since 4.0
 */
public class AckMessageComparatorTest {

	@Test
	public void test1() {
		SwiftBlock1 b1 = new SwiftBlock1();
		b1.setApplicationId("foo");
		b1.setLogicalTerminal("term");
		b1.setSequenceNumber("1234");
		b1.setServiceId("99");
		b1.setSessionNumber("190");

		SwiftBlock1 b2 = new SwiftBlock1();
		b2.setApplicationId("foo");
		b2.setLogicalTerminal("term");
		b2.setSequenceNumber("1234");
		b2.setServiceId("99");
		b2.setSessionNumber("190");

		
		AckMessageComparator comp = new AckMessageComparator();
		assertTrue(comp.compareB1(b1, b2));
		
		b2.setSequenceNumber("99999999999999999999");
		b2.setSessionNumber("9999999999999999999999");
		
		/*
		 * Check that changing these values compare still returns true
		 */
		assertTrue(comp.compareB1(b1, b2));
	}
	
	String m = "{1:F01CARBVEC0AXXX6083000009}{2:I103CARAANC0XXXXN}{4:\n"
		+":20:TCLIO200908132\n"
		+":23B:CRED\n"
		+":32A:090813VEF1000,\n"
		+":50K:/01115446997234567890\n"
		+"RANGEL GUILARTE MADRIZ\n"
		+"R00000V01321705\n"
		+":53B:/00010013800002000114\n"
		+"BANCO DEL CARIBE C.A.\n"
		+":59:/00010013800020001146\n"
		+"BANCO DEL CARIBE C.A.\n"
		+":71A:OUR\n"
		+":72:/TIPO/410\n"
		+"-}";
		
		
	String m2 ="{1:F01CARBVEC0AXXX6083000009}{2:I103CARAANC0XXXXN}{4:\n"
		+":20:TCLIO200908132\n"
		+":23B:CRED\n"
		+":32A:090813VEF1000,\n"
		+":50K:/01115446997234567890\n"
		+"RANGEL GUILARTE MADRIZ\n"
		+"R00000V01321705\n"
		+":53B:/00010013800002000114\n"
		+"BANCO DEL CARIBE C.A.\n"
		+":59:/00010013800020001146\n"
		+"BANCO DEL CARIBE C.A.\n"
		+":71A:OUR\n"
		+":72:/TIPO/410\n"
		+"-}";
		
	String ack = "{1:F01CARBVEC0AXXX6083000009}{2:I103CARAANC0XXXXN}{4:\n"
		+":20:TCLIO200908132\n"
		+":23B:CRED\n"
		+":32A:090813VEF1000,\n"
		+":50K:/01115446997234567890\n"
		+"RANGEL GUILARTE MADRIZ\n"
		+"R00000V01321705\n"
		+":53B:/00010013800002000114\n"
		+"BANCO DEL CARIBE C.A.\n"
		+":59:/00010013800020001146\n"
		+"BANCO DEL CARIBE C.A.\n"
		+":71A:OUR\n"
		+":72:/TIPO/410\n"
		+"-}";

	@Test 
	public void testCompare() throws IOException {
		AckMessageComparator c = new AckMessageComparator();
		SwiftMessage ackMsg = new SwiftParser(ack).message();
		SwiftMessage mMsg = new SwiftParser(m).message();
		assertEquals(m, m2);
		assertEquals(0, c.compare(ackMsg, mMsg));
		ackMsg.getBlock1().setSequenceNumber("X");
		ackMsg.getBlock1().setSessionNumber("X");
		assertEquals(0, c.compare(ackMsg, mMsg));
	}

}

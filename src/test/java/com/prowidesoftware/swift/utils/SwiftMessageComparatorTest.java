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
package com.prowidesoftware.swift.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.SwiftBlock2Output;
import com.prowidesoftware.swift.model.SwiftMessage;

/**
 * Swift message comparator for tests.
 * 
 * @author sebastian
 * @since 7.8.8
 */
public class SwiftMessageComparatorTest {
	
	final private SwiftMessageComparator comp = new SwiftMessageComparator();
	
	@Test
	public void testB1() {
		SwiftBlock1 b1 = new SwiftBlock1();
		assertTrue(comp.compareB1(b1, b1));
		
		b1.setLogicalTerminal("FOOBARXXXXX");
		assertTrue(comp.compareB1(b1, b1));
		
		b1.setSequenceNumber("123456");
		assertTrue(comp.compareB1(b1, b1));
		
		b1.setSessionNumber("1234");
		assertTrue(comp.compareB1(b1, b1));

		SwiftBlock1 b2 = new SwiftBlock1();
		b2.setApplicationId(b1.getApplicationId());
		b2.setServiceId(b1.getServiceId());
		b2.setLogicalTerminal(b1.getLogicalTerminal());
		b2.setSequenceNumber(b1.getSequenceNumber());
		b2.setSessionNumber(b1.getSessionNumber());
		assertTrue(comp.compareB1(b1, b2));
		
		b2.setSequenceNumber("666666");
		b2.setSessionNumber("4444");
		assertFalse(comp.compareB1(b1, b2));
		
		/*
		 * Check that changing these values compare still returns true
		 * with the ignore header session on true
		 */
		comp.setIgnoreHeaderSession(true);
		assertTrue(comp.compareB1(b1, b2));
	}

	@Test
	public void testB2() {
		SwiftBlock2Input b1 = new SwiftBlock2Input("I103CARAANC0XXXXN");
		assertTrue(comp.compareB2(b1, b1));
		
		SwiftBlock2Input b2 = new SwiftBlock2Input("I103CARAANC0XXXXN");
		assertTrue(comp.compareB2(b1, b2));
		
		b2.setDeliveryMonitoring("3");
		assertFalse(comp.compareB2(b1, b2));
		
		SwiftBlock2Output b3 = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N");
		assertTrue(comp.compareB2(b3, b3));

		SwiftBlock2Output b4 = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N");
		assertTrue(comp.compareB2(b3, b4));
		
		b4.setMessageType("999");
		assertFalse(comp.compareB2(b3, b4));
	}
	
	@Test
	public void testFullMessage() throws IOException {
		assertTrue(comp.compare(new SwiftMessage(), new SwiftMessage()) == 0);
		
		final String fin = "{1:F01CARBVEC0AXXX6083000009}{2:I103CARAANC0XXXXN}{4:\n"
				+":20:TCLIO200908132\n"
				+":23B:CRED\n"
				+":32A:090813VEF1000,\n"
				+":50K:/01115446997234567890\n"
				+"FOO GUILARTE MADRIZ\n"
				+"R00000V01321705\n"
				+":53B:/00010013800002000114\n"
				+"BANCO DEL CARIBE C.A.\n"
				+":59:/00010013800020001146\n"
				+"BANCO DEL CARIBE C.A.\n"
				+":71A:OUR\n"
				+":72:/TIPO/410\n"
				+"-}";
		SwiftMessage m1 = SwiftMessage.parse(fin);
		assertTrue(comp.compare(m1, m1) == 0);

		SwiftMessage m2 = SwiftMessage.parse(fin);
		assertTrue(comp.compare(m1, m2) == 0);
		
		m2.getBlock4().getTagByName("20").setValue("FOO");
		assertTrue(comp.compare(m1, m2) != 0);
		
		comp.addTagnameToIgnore("20");
		assertTrue(comp.compare(m1, m2) == 0);
		
		m2.getBlock4().getTagByName("53B").setValue("/00010013800002000114\r\nBANCO DEL CARIBE C.A.");
		assertTrue(comp.compare(m1, m2) != 0);
		
		comp.setIgnoreEolsInMultiline(true);
		assertTrue(comp.compare(m1, m2) == 0);
	}
}

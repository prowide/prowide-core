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
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.prowidesoftware.swift.model.SwiftBlock2Input;

/**
 * MT950 tests
 *
 * @since 4.0
 */
public class MT950Test extends BaseMessageTestcase {
	
	@Test 
	public void test535_1() {
		messageToParse = "{1:F01FOOBARXXAXXX3227607589}{2:I950FOOBARXXXXXXN}{4:\n" +
					":20:12345678070403\n" +
					":25:12345678\n" +
					":28C:93/1\n" +
					":60F:C070403USD0,\n" +
					":61:0704050402C115454,92NSALNONREF\n" +
					"/US/037833100/SHS/1235,\n" +
					":62M:C070403USD115454,92\n" +
					"-}{5:{CHK:12C48A7C53B2}}{S:{REF:I20070404.763727356.out/1/1}}"; 
		
		assertEquals("950", (parseMessage(messageToParse)).getType());
		
		//check b1
		assertEquals("F01FOOBARXXAXXX3227607589", b1.getBlockValue());
		assertEquals("F", b1.getApplicationId());
		assertEquals("01", b1.getServiceId());
		assertEquals("FOOBARXXAXXX", b1.getLogicalTerminal());
		assertEquals("3227", b1.getSessionNumber());
		assertEquals("607589", b1.getSequenceNumber());
		
		//check b2
		assertEquals("I950FOOBARXXXXXXN", b2.getBlockValue());
		assertEquals("950", ((SwiftBlock2Input)b2).getMessageType());
		assertEquals("FOOBARXXXXXX", ((SwiftBlock2Input)b2).getReceiverAddress());
		assertEquals("N", ((SwiftBlock2Input)b2).getMessagePriority());
		assertNull(((SwiftBlock2Input)b2).getDeliveryMonitoring());
		assertNull(((SwiftBlock2Input)b2).getObsolescencePeriod());
		
		//check b4
		assertEquals(6, b4.countAll());
		assertEquals("12345678070403", b4.getTagValue("20"));
		assertEquals("12345678", b4.getTagValue("25"));
		assertEquals("93/1", b4.getTagValue("28C"));
		assertEquals("C070403USD0,", b4.getTagValue("60F"));
		assertEquals("0704050402C115454,92NSALNONREF\n" + "/US/037833100/SHS/1235,", b4.getTagValue("61"));
		assertEquals("C070403USD115454,92", b4.getTagValue("62M"));
		
		//check b5
		assertEquals(1, b5.countAll());
		assertEquals("12C48A7C53B2", b5.getTagValue("CHK"));	
		
		//user block (extra data, not swift standard, attached to the message as a trailer block)
		assertNotNull(o.getUserBlock("S"));
		assertEquals("I20070404.763727356.out/1/1", o.getUserBlock("S").getTagValue("REF"));
	}
	
}
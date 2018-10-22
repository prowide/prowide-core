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
package com.prowidesoftware.swift.io.writer;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

import com.prowidesoftware.swift.Constants;
import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;

/**
 * Swift writer tests
 *
 * @since 4.0
 */
public class FINWriterVisitorTest {

	private FINWriterVisitor visitor;
	private Writer io;

	@Before
	public void setUp() {
		this.io = new StringWriter();
		this.visitor = new FINWriterVisitor(this.io);
	}

	@SuppressWarnings("unused")
	private String getResult() {
		return(this.getResult(""));
	}	
	
	private String getResult(String testName) {
		return this.io.toString();
	}
	
	@Test 
	public void testWriteBlock1() {
		SwiftMessage msg = new SwiftMessage(true);
		msg.getBlock1().setValue(Constants.B1_DATA);
		
		this.visitor.startBlock1(msg.getBlock1());
		this.visitor.value(msg.getBlock1(), msg.getBlock1().getValue());
		this.visitor.endBlock1(msg.getBlock1());
		assertEquals("{1:"+Constants.B1_DATA+"}", getResult("testWriteBlock1"));
	}

	/**
	 * Default constructor of swift messages creates empty blocks
	 */
	@Test 
	public void testWriteBlock1_2() {
		SwiftMessage msg = new SwiftMessage(true);
		msg.getBlock1().setValue(Constants.B1_DATA);
		
		msg.visit(this.visitor);
		assertEquals("{1:"+Constants.B1_DATA+"}{2:IN}{3:}{4:\r\n-}{5:}", getResult("testWriteBlock1_2"));
	}
	
	@Test 
	public void testWriteBlock1_3() {
		SwiftMessage msg = new SwiftMessage(true);
		msg.getBlock1().setValue(Constants.B1_DATA);
		msg.setBlock2(null);
		msg.setBlock3(null);
		
		msg.visit(this.visitor);
		assertEquals("{1:"+Constants.B1_DATA+"}{4:\r\n-}{5:}", getResult("testWriteBlock1_3"));
	}
	
	@Test 
	public void testBug1690027_1() {
		SwiftMessage msg = new SwiftMessage(true);
		msg.setBlock1(null);
		msg.setBlock2(null);
		msg.getBlock3().append(new Tag("1:val1"));
		msg.getBlock3().append(new Tag("2:val2"));
				
		msg.visit(this.visitor);
		assertEquals("{3:{1:val1}{2:val2}}{4:\r\n-}{5:}", getResult("testBug1690027_1"));
	}
	
	@Test 
	public void testWriteBlock4() {
		SwiftMessage msg = new SwiftMessage(true);
		msg.setBlock1(null);
		msg.setBlock2(null);
		msg.setBlock3(null);
		msg.setBlock5(null);
		
		msg.getBlock4().append(new Tag("1:val1"));
		msg.getBlock4().append(new Tag("2:val2"));
		
		msg.visit(this.visitor);
		assertEquals("{4:\r\n:1:val1\r\n:2:val2\r\n-}", getResult("testWriteBlock4"));
	}
	
	@Test 
	public void testWriteBlock4_2() {
		SwiftMessage msg = new SwiftMessage(true);
		msg.setBlock1(null);
		msg.setBlock2(new SwiftBlock2Input("I028CARAANC0XXXXN"));
		msg.setBlock3(null);
		msg.setBlock5(null);
		
		msg.getBlock4().append(new Tag("1:val1"));
		msg.getBlock4().append(new Tag("2:val2"));
		
		msg.visit(this.visitor);
		assertEquals("{2:I028CARAANC0XXXXN}{4:{1:val1}{2:val2}}", getResult("testWriteBlock4_2"));
	}
	
	@Test 
	public void testWriteBlock4_3() {
		SwiftMessage msg = new SwiftMessage(true);
		msg.setBlock1(new SwiftBlock1("F01VNDZBET2AXXX0027000580"));
		msg.setBlock2(new SwiftBlock2Input("I028CARAANC0XXXXN"));
		msg.setBlock3(null);
		msg.setBlock5(null);
		
		msg.getBlock4().append(new Tag("1:val1"));
		msg.getBlock4().append(new Tag("2:val2"));
		
		msg.visit(this.visitor);
		assertEquals("{1:F01VNDZBET2AXXX0027000580}{2:I028CARAANC0XXXXN}{4:{1:val1}{2:val2}}", getResult("testWriteBlock4_3"));
	}
	
	@Test 
	public void testBug1601122_1() {
		SwiftMessage msg = new SwiftMessage(true);
		msg.setBlock1(null);
		msg.setBlock2(null);
		msg.setBlock3(null);
		msg.setBlock4(null);
		
		msg.getBlock5().append(new Tag("MAC:valmac"));
		msg.getBlock5().append(new Tag("CHK:valchk"));
		
		msg.visit(this.visitor);
		assertEquals("{5:{MAC:valmac}{CHK:valchk}}", getResult("testBug1601122_1"));
	}
	
}

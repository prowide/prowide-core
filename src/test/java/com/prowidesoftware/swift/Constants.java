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
package com.prowidesoftware.swift;

/**
 * Constants for tests.
 * 
 * @author www.prowidesoftware.com
 * @since 4.0
 */
public interface Constants {
	
	String B1_DATA = "F01BANKBEBBAXXX2222123456";
	
	String B1_DATA_XML = 
	"\n\t<block1>"+
	"\n\t<applicationId>F</applicationId>"+
	"\n\t<serviceId>01</serviceId>"+
	"\n\t<logicalTerminal>BANKBEBBAXXX</logicalTerminal>"+
	"\n\t<sessionNumber>2222</sessionNumber>"+
	"\n\t<sequenceNumber>123456</sequenceNumber>"+
	"\n</block1>";
	
	String B2_INPUT = "I100BANKDEFFXXXXU3003";
	
	String B2_INPUT_XML = 
		"\n\t<block2 type=\"input\">"+
		"\n\t<messageType>100</messageType>"+
		"\n\t<receiverAddress>BANKDEFFXXXX</receiverAddress>"+
		"\n\t<messagePriority>U</messagePriority>"+
		"\n\t<deliveryMonitoring>3</deliveryMonitoring>"+
		"\n\t<obsolescencePeriod>003</obsolescencePeriod>"+
		"\n</block2>";
		
	String B2_OUTPUT = "O1001200970103BANKBEBBAXXX22221234569701031201N";
	
	String B2_OUTPUT_XML = 
		"\n\t<block2 type=\"output\">"+
		"\n\t<messageType>100</messageType>"+
		"\n\t<senderInputTime>1200</senderInputTime>"+
		"\n\t<MIRDate>970103</MIRDate>"+
		"\n\t<MIRLogicalTerminal>BANKBEBBAXXX</MIRLogicalTerminal>"+
		"\n\t<MIRSessionNumber>2222</MIRSessionNumber>"+
		"\n\t<MIRSequenceNumber>123456</MIRSequenceNumber>"+
		"\n\t<receiverOutputDate>970103</receiverOutputDate>"+
		"\n\t<receiverOutputTime>1201</receiverOutputTime>"+
		"\n\t<messagePriority>N</messagePriority>"+
		"\n</block2>";

	String B3_DATA = "{n:v}{n2:v2}";
}

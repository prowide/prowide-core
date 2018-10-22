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

/**
 * Constants for tests.
 *
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

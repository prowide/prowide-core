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

import com.prowidesoftware.swift.model.MxNode;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Test cases for {@link MxParser} XML conversion into {@link MxNode}
 * and content finder API on the parsed structure. 
 *
 * @since 7.8.8
 */
public class MxNodeTest {

	@Test
	public void testParse01() throws IOException {
		final String xml = "<FaceAmount>1234567.89</FaceAmount>";
		final MxNode doc = new MxParser(xml).parse();
		assertEquals("1234567.89", doc.findFirstByName("FaceAmount").getValue());
	}

	@Test
	public void testParse02() throws IOException {
		final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<Doc:Document xmlns:Doc=\"urn:swift:xsd:semt.002.002.03\">" +
				"   <Doc:SecuritiesBalanceCustodyReport.002V03>" +
				"      <Doc:Identification>" +
				"         <Doc:Identification>ICF2750609140005</Doc:Identification>" +
				"      </Doc:Identification>" +
				"      <Doc:Pagination>" +
				"         <Doc:PageNumber>00005</Doc:PageNumber>" +
				"         <Doc:LastPageIndicator>false</Doc:LastPageIndicator>" +
				"      </Doc:Pagination>" +
				"      <Doc:StatementGeneralDetails>" +
				"         <Doc:StatementDateTime>" +
				"            <Doc:Date>2006-09-13T00:00:00</Doc:Date>" +
				"         </Doc:StatementDateTime>" +
				"         <Doc:Frequency>" +
				"            <Doc:Code>DAIL</Doc:Code>" +
				"         </Doc:Frequency>" +
				"         <Doc:UpdateType>" +
				"            <Doc:Code>COMP</Doc:Code>" +
				"         </Doc:UpdateType>" +
				"         <Doc:StatementBasis>" +
				"            <Doc:Code>TRAD</Doc:Code>" +
				"         </Doc:StatementBasis>" +
				"         <Doc:ActivityIndicator>true</Doc:ActivityIndicator>" +
				"         <Doc:SubAccountIndicator>false</Doc:SubAccountIndicator>" +
				"      </Doc:StatementGeneralDetails>" +
				"      <Doc:SafekeepingAccount>" +
				"         <Doc:Identification>F275</Doc:Identification>" +
				"      </Doc:SafekeepingAccount>" +
				"      <Doc:BalanceForAccount>" +
				"         <Doc:FinancialInstrumentIdentification>" +
				"            <Doc:Identification>" +
				"               <Doc:OtherIdentification>" +
				"                  <Doc:Identification>31392EXH8</Doc:Identification>" +
				"                  <Doc:IdentificationSource>" +
				"                     <Doc:Domestic>US</Doc:Domestic>" +
				"                  </Doc:IdentificationSource>" +
				"               </Doc:OtherIdentification>" +
				"            </Doc:Identification>" +
				"            <Doc:Description>/US/31392EXH8 FEDERAL FOO MTG ASSN</Doc:Description>" +
				"         </Doc:FinancialInstrumentIdentification>" +
				"         <Doc:FinancialInstrumentAttributes>" +
				"            <Doc:CurrentFactor>0.14528727</Doc:CurrentFactor>" +
				"         </Doc:FinancialInstrumentAttributes>" +
				"         <Doc:AggregateBalance>" +
				"            <Doc:ShortLongIndicator>LONG</Doc:ShortLongIndicator>" +
				"            <Doc:Quantity>" +
				"               <Doc:Quantity>" +
				"                  <Doc:OriginalAndCurrentFace>" +
				"                     <Doc:FaceAmount>35732656.0</Doc:FaceAmount>" +
				"                     <Doc:AmortisedValue>35732656.0</Doc:AmortisedValue>" +
				"                  </Doc:OriginalAndCurrentFace>" +
				"               </Doc:Quantity>" +
				"            </Doc:Quantity>" +
				"         </Doc:AggregateBalance>" +
				"         <Doc:AvailableBalance>" +
				"            <Doc:Quantity>" +
				"               <Doc:FaceAmount>35732656.0</Doc:FaceAmount>" +
				"            </Doc:Quantity>" +
				"         </Doc:AvailableBalance>" +
				"         <Doc:SafekeepingPlace>" +
				"            <Doc:TypeAndIdentification>" +
				"               <Doc:SafekeepingPlaceType>NCSD</Doc:SafekeepingPlaceType>" +
				"               <Doc:Identification>FRNYUS33</Doc:Identification>" +
				"            </Doc:TypeAndIdentification>" +
				"         </Doc:SafekeepingPlace>" +
				"         <Doc:BalanceAtSafekeepingPlace>" +
				"            <Doc:SafekeepingPlace>" +
				"               <Doc:TypeAndIdentification>" +
				"                  <Doc:SafekeepingPlaceType>NCSD</Doc:SafekeepingPlaceType>" +
				"                  <Doc:Identification>FRNYUS33</Doc:Identification>" +
				"               </Doc:TypeAndIdentification>" +
				"            </Doc:SafekeepingPlace>" +
				"            <Doc:AggregateBalance>" +
				"               <Doc:ShortLongIndicator>LONG</Doc:ShortLongIndicator>" +
				"               <Doc:Quantity>" +
				"                  <Doc:Quantity>" +
				"                     <Doc:Quantity>" +
				"                        <Doc:FaceAmount>35732656.0</Doc:FaceAmount>" +
				"                     </Doc:Quantity>" +
				"                  </Doc:Quantity>" +
				"               </Doc:Quantity>" +
				"            </Doc:AggregateBalance>" +
				"            <Doc:AvailableBalance>" +
				"               <Doc:Quantity>" +
				"                  <Doc:FaceAmount>35732656.0</Doc:FaceAmount>" +
				"               </Doc:Quantity>" +
				"            </Doc:AvailableBalance>" +
				"         </Doc:BalanceAtSafekeepingPlace>" +
				"         <Doc:BalanceAtSafekeepingPlace>" +
				"            <Doc:SafekeepingPlace>" +
				"               <Doc:TypeAndIdentification>" +
				"                  <Doc:SafekeepingPlaceType>NCSD</Doc:SafekeepingPlaceType>" +
				"                  <Doc:Identification>FRNYUS33</Doc:Identification>" +
				"               </Doc:TypeAndIdentification>" +
				"            </Doc:SafekeepingPlace>" +
				"            <Doc:AggregateBalance>" +
				"               <Doc:ShortLongIndicator>LONG</Doc:ShortLongIndicator>" +
				"               <Doc:Quantity>" +
				"                  <Doc:Quantity>" +
				"                     <Doc:Quantity>" +
				"                        <Doc:FaceAmount>35732656.0</Doc:FaceAmount>" +
				"                     </Doc:Quantity>" +
				"                  </Doc:Quantity>" +
				"               </Doc:Quantity>" +
				"            </Doc:AggregateBalance>" +
				"            <Doc:AvailableBalance>" +
				"               <Doc:Quantity>" +
				"                  <Doc:FaceAmount>35732656.0</Doc:FaceAmount>" +
				"               </Doc:Quantity>" +
				"            </Doc:AvailableBalance>" +
				"         </Doc:BalanceAtSafekeepingPlace>" +
				"      </Doc:BalanceForAccount>" +
				"      <Doc:BalanceForAccount>" +
				"         <Doc:FinancialInstrumentIdentification>" +
				"            <Doc:Identification>" +
				"               <Doc:OtherIdentification>" +
				"                  <Doc:Identification>31406RR72</Doc:Identification>" +
				"                  <Doc:IdentificationSource>" +
				"                     <Doc:Domestic>US</Doc:Domestic>" +
				"                  </Doc:IdentificationSource>" +
				"               </Doc:OtherIdentification>" +
				"            </Doc:Identification>" +
				"            <Doc:Description>/US/31406RR72 FOO POOL 817810</Doc:Description>" +
				"         </Doc:FinancialInstrumentIdentification>" +
				"         <Doc:FinancialInstrumentAttributes>" +
				"            <Doc:CurrentFactor>0.0</Doc:CurrentFactor>" +
				"         </Doc:FinancialInstrumentAttributes>" +
				"         <Doc:AggregateBalance>" +
				"            <Doc:ShortLongIndicator>LONG</Doc:ShortLongIndicator>" +
				"            <Doc:Quantity>" +
				"               <Doc:Quantity>" +
				"                  <Doc:OriginalAndCurrentFace>" +
				"                     <Doc:FaceAmount>0.0</Doc:FaceAmount>" +
				"                     <Doc:AmortisedValue>0.0</Doc:AmortisedValue>" +
				"                  </Doc:OriginalAndCurrentFace>" +
				"               </Doc:Quantity>" +
				"            </Doc:Quantity>" +
				"         </Doc:AggregateBalance>" +
				"         <Doc:AvailableBalance>" +
				"            <Doc:Quantity>" +
				"               <Doc:FaceAmount>990692.0</Doc:FaceAmount>" +
				"            </Doc:Quantity>" +
				"         </Doc:AvailableBalance>" +
				"         <Doc:NotAvailableBalance>" +
				"            <Doc:Quantity>" +
				"               <Doc:FaceAmount>990692.0</Doc:FaceAmount>" +
				"            </Doc:Quantity>" +
				"         </Doc:NotAvailableBalance>" +
				"         <Doc:SafekeepingPlace>" +
				"            <Doc:TypeAndIdentification>" +
				"               <Doc:SafekeepingPlaceType>NCSD</Doc:SafekeepingPlaceType>" +
				"               <Doc:Identification>FRNYUS33</Doc:Identification>" +
				"            </Doc:TypeAndIdentification>" +
				"         </Doc:SafekeepingPlace>" +
				"         <Doc:BalanceAtSafekeepingPlace>" +
				"            <Doc:SafekeepingPlace>" +
				"               <Doc:TypeAndIdentification>" +
				"                  <Doc:SafekeepingPlaceType>NCSD</Doc:SafekeepingPlaceType>" +
				"                  <Doc:Identification>FRNYUS33</Doc:Identification>" +
				"               </Doc:TypeAndIdentification>" +
				"            </Doc:SafekeepingPlace>" +
				"            <Doc:AggregateBalance>" +
				"               <Doc:ShortLongIndicator>SHOR</Doc:ShortLongIndicator>" +
				"               <Doc:Quantity>" +
				"                  <Doc:Quantity>" +
				"                     <Doc:Quantity>" +
				"                        <Doc:FaceAmount>0.0</Doc:FaceAmount>" +
				"                     </Doc:Quantity>" +
				"                  </Doc:Quantity>" +
				"               </Doc:Quantity>" +
				"            </Doc:AggregateBalance>" +
				"            <Doc:AvailableBalance>" +
				"               <Doc:Quantity>" +
				"                  <Doc:FaceAmount>990692.0</Doc:FaceAmount>" +
				"               </Doc:Quantity>" +
				"            </Doc:AvailableBalance>" +
				"            <Doc:NotAvailableBalance>" +
				"               <Doc:Quantity>" +
				"                  <Doc:FaceAmount>990692.0</Doc:FaceAmount>" +
				"               </Doc:Quantity>" +
				"            </Doc:NotAvailableBalance>" +
				"         </Doc:BalanceAtSafekeepingPlace>" +
				"         <Doc:BalanceAtSafekeepingPlace>" +
				"            <Doc:SafekeepingPlace>" +
				"               <Doc:TypeAndIdentification>" +
				"                  <Doc:SafekeepingPlaceType>NCSD</Doc:SafekeepingPlaceType>" +
				"                  <Doc:Identification>FRNYUS33</Doc:Identification>" +
				"               </Doc:TypeAndIdentification>" +
				"            </Doc:SafekeepingPlace>" +
				"            <Doc:AggregateBalance>" +
				"               <Doc:ShortLongIndicator>SHOR</Doc:ShortLongIndicator>" +
				"               <Doc:Quantity>" +
				"                  <Doc:Quantity>" +
				"                     <Doc:Quantity>" +
				"                        <Doc:FaceAmount>0.0</Doc:FaceAmount>" +
				"                     </Doc:Quantity>" +
				"                  </Doc:Quantity>" +
				"               </Doc:Quantity>" +
				"            </Doc:AggregateBalance>" +
				"            <Doc:AvailableBalance>" +
				"               <Doc:Quantity>" +
				"                  <Doc:FaceAmount>990692.0</Doc:FaceAmount>" +
				"               </Doc:Quantity>" +
				"            </Doc:AvailableBalance>" +
				"            <Doc:NotAvailableBalance>" +
				"               <Doc:Quantity>" +
				"                  <Doc:FaceAmount>990692.0</Doc:FaceAmount>" +
				"               </Doc:Quantity>" +
				"            </Doc:NotAvailableBalance>" +
				"         </Doc:BalanceAtSafekeepingPlace>" +
				"      </Doc:BalanceForAccount>" +
				"   </Doc:SecuritiesBalanceCustodyReport.002V03>" +
				"</Doc:Document>";

		final MxParser parser = new MxParser(xml);
		final MxNode n = parser.parse();
		assertEquals(
				"35732656.0",
				n.singlePathValue("/Document/SecuritiesBalanceCustodyReport.002V03/BalanceForAccount/AggregateBalance/Quantity/Quantity/OriginalAndCurrentFace/FaceAmount"));
	}

	@Test
	public void testParse03_attributes() throws IOException {
		final String xml = "<FaceAmount Ccy='USD'>1234567.89</FaceAmount>";
		final MxNode doc = new MxParser(xml).parse();
		assertEquals("1234567.89", doc.findFirstByName("FaceAmount").getValue());
		assertEquals("USD", doc.findFirstByName("FaceAmount").getAttribute("Ccy"));
	}

	@Test
	public void testParse04_ns() throws IOException {
		final String xml = "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.01\"><From></From></AppHdr>";
		final MxNode doc = new MxParser(xml).parse();
		assertEquals("urn:iso:std:iso:20022:tech:xsd:head.001.001.01", doc.findFirstByName("AppHdr").getAttribute("xmlns"));
		assertNotNull(doc.findFirst("AppHdr/From"));
		assertNull(doc.findFirst("AppHdr/From").getAttribute("xmlns"));
	}

	@Test
	public void testFindFirst() throws IOException {
		String xml = "<a></a>";
		MxNode doc = new MxParser(xml).parse();
		assertNull(doc.singlePathValue("a"));

		xml = "<a>1</a>";
		doc = new MxParser(xml).parse();
		assertEquals("1", doc.singlePathValue("a"));
	}

	@Test
	public void testFindFirstLevel2() throws IOException {
		String xml = "<a><a>1</a></a>";
		MxNode doc = new MxParser(xml).parse();
		assertEquals("1", doc.singlePathValue("a/a"));

		xml = "<a><b>2</b></a>";
		doc = new MxParser(xml).parse();
		assertEquals("2", doc.singlePathValue("a/b"));
	}

	@Test
	public void testFindFirstWithChildren() throws IOException {
		final String xml =  "<a>"
				+ "		<b>1</b>"
				+ "		<c>2</c>"
				+ "</a>";
		final MxNode doc = new MxParser(xml).parse();
		assertNotNull(doc.singlePathValue("a/b"));
		assertNotNull(doc.singlePathValue("a/c"));
	}

	@Test
	public void testFindFirstAbsoluteAndRelativePath() throws IOException {
		final String xml = "<a><b><c>1</c></b></a>";
		final MxNode doc = new MxParser(xml).parse();
		/*
		 * absolute
		 */
		assertEquals("1", doc.singlePathValue("/a/b/c"));
		/*
		 * relative from root
		 */
		assertEquals("1", doc.singlePathValue("a/b/c"));
		/*
		 * invalid relative
		 */
		assertNull(doc.singlePathValue("b/c"));
		/*
		 * invalid absolute
		 */
		assertNull(doc.singlePathValue("/b/c"));
	}

	@Test
	public void testFindByName() throws IOException {
		final String xml = "<a>1</a>";
		final MxNode doc = new MxParser(xml).parse();
		assertNotNull(doc.findFirstByName("a"));
		assertEquals("1", doc.findFirstByName("a").getValue());
		assertTrue(doc.findFirstByName("b") == null);
	}

	@Test
	public void testFindByNameLevel2() throws IOException {
		final String xml = "<a><b>2</b><b>3</b></a>";
		final MxNode doc = new MxParser(xml).parse();
		assertNotNull(doc.findFirstByName("a"));
		assertNotNull(doc.findFirstByName("b"));
		assertEquals("2", doc.findFirstByName("b").getValue());
	}

	@Test
	public void testFindByNameAndPath() throws IOException {
		final String xml = "<a>"
				+"	<b>"
				+"		<c>"
				+"			<d>4</d>"
				+"		</c>"
				+"	</b>"
				+"</a>";
		final MxNode doc = new MxParser(xml).parse();

		assertEquals("4", doc.singlePathValue("/a/b/c/d"));

		final MxNode b = (MxNode) doc.findFirstByName("b");
		assertNotNull(b);

		assertEquals("4", b.singlePathValue("b/c/d"));
	}

	@Test
	public void testReadSample() throws IOException {
		final InputStream inputStream = getClass().getResourceAsStream("/mx_sample_document.xml");
		assertNotNull(inputStream);
		final MxNode doc = new MxParser(inputStream).parse();
		assertNotNull(doc);
		doc.print();
		assertEquals("1", doc.singlePathValue("Document/GetAcct/MsgId/Id"));
		assertEquals("1", doc.singlePathValue("/Document/GetAcct/MsgId/Id"));
		assertEquals("1", doc.singlePathValue("Document/GetAcct/MsgId/Id/"));
		assertEquals("1", doc.singlePathValue("/Document/GetAcct/MsgId/Id/"));
		assertNull(doc.singlePathValue("/foobar"));
		assertNull(doc.singlePathValue("/foobar/1/2/3/4/5/6/7"));
	}

	@Test
	public void testReadSampleByNode() throws IOException {
		final InputStream inputStream = getClass().getResourceAsStream("/mx_sample_document.xml");
		final MxNode doc = new MxParser(inputStream).parse();
		doc.print();
		MxNode n = (MxNode) doc.findFirstByName("Id");
		assertNotNull(n);
		assertEquals("1", n.getValue());
		n = (MxNode) doc.findFirstByName("ID");
		assertNotNull(n);
		assertEquals("1", n.getValue());
	}

	@Test
	public void testPathApplicationHeader() throws IOException {
		final InputStream inputStream = getClass().getResourceAsStream("/mx_sample_header.xml");
		final MxNode doc = new MxParser(inputStream).parse();
		assertNotNull(doc);
		assertEquals("DN", doc.singlePathValue("AppHdr/From/Type"));
		assertEquals("DN", doc.singlePathValue("/AppHdr/From/Type"));
	}

	@Test
	public void createMxTest() {
		MxNode n = new MxNode(null, "Document");
		MxNode n1 = new MxNode(n, "FIToFICstmrCdtTrf");
		MxNode n2 = new MxNode(n1, "GrpHdr");
		new MxNode(n2, "MsgId").setValue("MSGID-0001");
		new MxNode(n2, "CreDtTm").setValue("2001-12-17T09:30:47Z");
		new MxNode(n2, "NbOfTxs").setValue("1");
		new MxNode(n2, "IntrBkSttlmDt").setValue("2012-01-25");
		//n.print();
	}

	/**
	 * Test that external entities feature is disabled in the XML parsing to avoid XXE (external entity injection)
	 */
	@Test
	public void testXxeDisabled() {
		String xml = "<!DOCTYPE foo [ <!ENTITY xxe SYSTEM \"file:///etc/passwd\" >]>"+
				"<FaceAmount>&xxe;</FaceAmount>";
		final MxNode doc = new MxParser(xml).parse();
		assertNull(doc);
	}

}

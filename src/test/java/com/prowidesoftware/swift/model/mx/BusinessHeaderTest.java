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

package com.prowidesoftware.swift.model.mx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.prowidesoftware.swift.model.mx.dic.ApplicationHeader;
import com.prowidesoftware.swift.model.mx.dic.BranchAndFinancialInstitutionIdentification5;
import com.prowidesoftware.swift.model.mx.dic.BranchData2;
import com.prowidesoftware.swift.model.mx.dic.BusinessApplicationHeaderV01;
import com.prowidesoftware.swift.model.mx.dic.EntityIdentification;
import com.prowidesoftware.swift.model.mx.dic.FinancialInstitutionIdentification8;
import com.prowidesoftware.swift.model.mx.dic.Party9Choice;
import com.prowidesoftware.swift.model.mx.dic.PostalAddress6;
import com.prowidesoftware.swift.utils.TestUtils;

/**
 * Test cases for readign and writing MX headers
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
public class BusinessHeaderTest {

	/*
	 * ISO header
	 */
	@Test
	public void testWriteBAH() throws TransformerConfigurationException, SAXException, IOException, ParserConfigurationException, TransformerException, XpathException {
		BusinessApplicationHeaderV01 bah = new BusinessApplicationHeaderV01();
		bah.setFr(new Party9Choice());
		bah.getFr().setFIId(new BranchAndFinancialInstitutionIdentification5());
		
		bah.getFr().getFIId().setFinInstnId(new FinancialInstitutionIdentification8());
		bah.getFr().getFIId().getFinInstnId().setBICFI("BIC");
		
		bah.getFr().getFIId().setBrnchId(new BranchData2());
		bah.getFr().getFIId().getBrnchId().setId("id");
		bah.getFr().getFIId().getBrnchId().setNm("name");
		bah.getFr().getFIId().getBrnchId().setPstlAdr(new PostalAddress6());
		bah.getFr().getFIId().getBrnchId().getPstlAdr().setCtry("AR");
		
		BusinessHeader header = new BusinessHeader();
		header.setBusinessApplicationHeader(bah);
				
		final String xml = header.xml();
		
		assertNotNull(xml);
		
		XMLAssert.assertXpathEvaluatesTo("BIC", TestUtils.patch("/AppHdr/Fr/FIId/FinInstnId/BICFI"), xml);
		XMLAssert.assertXpathEvaluatesTo("id", TestUtils.patch("/AppHdr/Fr/FIId/BrnchId/Id"), xml);
		XMLAssert.assertXpathEvaluatesTo("name", TestUtils.patch("/AppHdr/Fr/FIId/BrnchId/Nm"), xml);
	}
	
	/*
	 * SWIFT header
	 */
	@Test
	public void testWriteBH() throws TransformerConfigurationException, SAXException, IOException, ParserConfigurationException, TransformerException, XpathException {
		ApplicationHeader ah = new ApplicationHeader();
		ah.setFrom(new EntityIdentification());
		ah.getFrom().setId("id");
		
		BusinessHeader header = new BusinessHeader();
		header.setApplicationHeader(ah);
				
		final String xml = header.xml();
		
		assertNotNull(xml);
		
		XMLAssert.assertXpathEvaluatesTo("id", TestUtils.patch("/AppHdr/From/Id"), xml);
	}
	
	@Test
	public void testWriteEmpty() {
		BusinessHeader header = new BusinessHeader();
		final String xml = header.xml();
		assertNull(xml);
	}
	
	@Test
	public void testAHFromTo() {
		BusinessHeader h = new BusinessHeader(new ApplicationHeader());
		
		h.getApplicationHeader().setFrom(new EntityIdentification());
		h.getApplicationHeader().getFrom().setType("BIC");
		h.getApplicationHeader().getFrom().setId("FOOBARXX");
		h.getApplicationHeader().setTo(new EntityIdentification());
		h.getApplicationHeader().getTo().setType("BIC");
		h.getApplicationHeader().getTo().setId("ABCFOOXX");
		assertEquals("FOOBARXX", h.from());
		assertEquals("ABCFOOXX", h.to());
		
		h.getApplicationHeader().getFrom().setType("DN");
		h.getApplicationHeader().getFrom().setId("cn=funds,o=abcdchzz,o=swift");
		h.getApplicationHeader().setTo(new EntityIdentification());
		h.getApplicationHeader().getTo().setType("DN");
		h.getApplicationHeader().getTo().setId("cn=funds,o=dcbadeff,o=swift");
		assertEquals("ABCDCHZZ", h.from());
		assertEquals("DCBADEFF", h.to());		
	}
	
	@Test
	public void testBAHFromTo() {
		BusinessHeader h = new BusinessHeader(new BusinessApplicationHeaderV01());
		
		h.getBusinessApplicationHeader().setFr(new Party9Choice());
		h.getBusinessApplicationHeader().getFr().setFIId(new BranchAndFinancialInstitutionIdentification5());
		h.getBusinessApplicationHeader().getFr().getFIId().setFinInstnId(new FinancialInstitutionIdentification8());
		h.getBusinessApplicationHeader().getFr().getFIId().getFinInstnId().setBICFI("FOOBARXX");
		h.getBusinessApplicationHeader().setTo(new Party9Choice());
		h.getBusinessApplicationHeader().getTo().setFIId(new BranchAndFinancialInstitutionIdentification5());
		h.getBusinessApplicationHeader().getTo().getFIId().setFinInstnId(new FinancialInstitutionIdentification8());
		h.getBusinessApplicationHeader().getTo().getFIId().getFinInstnId().setBICFI("ABCFOOXX");
		assertEquals("FOOBARXX", h.from());
		assertEquals("ABCFOOXX", h.to());
	}

}

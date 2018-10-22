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
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

/**
 * Test for Field61 and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field61Test extends AbstractFieldTest {
    
    @Override
    @Test
    public void testSerialization() {
    	testSerializationImpl("61", 
    			"081027C858,28NOPT12716219\n1524/6006/TESORO NACIONAL",
    			"1001060106D341,34N422NONREF\r\nFURTHER REFERENCE",
    			"090227C291553,62NAYG13391140\n1524/6009/TRASPASO AUTOMATICO AL",
    			"020626D120000,NCOLABCD//12345",
    			"1512290201EDZ0000000002,2222FBNKNONREF",
    			"170717D203336,94NTRFR016341554//2395200  \n01P"
    	);
    }
    
	@Test
	public void testParse61_01() {
		String v1 ="081027C266181,86NOPT12715201";
		String v2 = "081027C858,28NOPT12716219";
		String v3 = "081024C10215,NOPT12710361";
		String v4 = "081027C858,28NOPT12716219\n1524/6006/TESORO NACIONAL";
		
		Field61 f = null;
		
		f = new Field61(v1);
		assertNotNull(f);
		assertEquals("266181,86", f.getComponent5());
		assertEquals("N", f.getComponent(Field61.TRANSACTION_TYPE));
		assertEquals("OPT", f.getComponent(Field61.IDENTIFICATION_CODE));
		assertEquals("12715201", f.getComponent8());

		f = new Field61(v2);
		assertNotNull(f);
		assertEquals("858,28", f.getComponent5());
		assertEquals("N", f.getComponent(Field61.TRANSACTION_TYPE));
		assertEquals("OPT", f.getComponent(Field61.IDENTIFICATION_CODE));
		assertEquals("12716219", f.getComponent8());
		
		f = new Field61(v3);
		assertNotNull(f);
		assertEquals(new BigDecimal(10215), new BigDecimal(f.getComponent5AsNumber().doubleValue()));
		assertEquals("N", f.getComponent(Field61.TRANSACTION_TYPE));
		assertEquals("OPT", f.getComponent(Field61.IDENTIFICATION_CODE));
		assertEquals("12710361", f.getComponent8());
		
		f = new Field61(v4);
		assertNotNull(f);
		assertEquals("N", f.getComponent(Field61.TRANSACTION_TYPE));
		assertEquals("OPT", f.getComponent(Field61.IDENTIFICATION_CODE));
		
		f = new Field61("090227C291553,62NAYG13391140" + "\n" + "1524/6009/TRASPASO AUTOMATICO AL");
		assertNotNull(f);
		assertEquals(new BigDecimal(291553.62), new BigDecimal(f.getComponent5AsNumber().doubleValue()));
		
		assertFalse(291553.9962 == f.getComponent5AsNumber().doubleValue());
	}
	
	@Test
	public void testParse_02() {
		String val = "081024"+"C"+"10215,NOPT12710361\n"
			+"1524/6006/TESORO NACIONAL";
		Field61 f = new Field61(val);
		assertNotNull(f);
		assertEquals(2008, f.getComponent1AsCalendar().get(Calendar.YEAR));
		assertEquals(Calendar.OCTOBER, f.getComponent1AsCalendar().get(Calendar.MONTH));
		assertEquals(24, f.getComponent1AsCalendar().get(Calendar.DAY_OF_MONTH));
		assertEquals(new BigDecimal(10215), new BigDecimal(f.getComponent5AsNumber().doubleValue()));
		assertEquals("10215,", f.getComponent5());
	}
	
	@Test
	public void test_issue5(){
		Field61 f = new Field61("1001060106D341,34N422NONREF\r\nFURTHER REFERENCE");
		assertEquals("100106", f.getComponent1());
		assertEquals("0106", f.getComponent2());
		assertEquals("D", f.getComponent3());
		assertNull(f.getComponent4());
		assertEquals("341,34", f.getComponent5());
		assertEquals("N", f.getComponent6());
		assertEquals("422", f.getComponent7());
		assertEquals("NONREF", f.getComponent8());
		assertNull(f.getComponent9());
		assertEquals("FURTHER REFERENCE", f.getComponent10());
	}

	@Test
	public void testParse_03() {
		Field61 f = new Field61("020626D120000,NCOLABCD//12345");
		assertNotNull(f);
		assertEquals("020626", f.getComponent(Field61.VALUE_DATE));
		assertEquals("D", f.getComponent(Field61.DC_MARK));
		assertEquals("120000,", f.getComponent(Field61.AMOUNT));
		assertEquals("N", f.getComponent(Field61.TRANSACTION_TYPE));
		assertEquals("COL", f.getComponent(Field61.IDENTIFICATION_CODE));
		assertEquals("ABCD", f.getComponent(Field61.REFERENCE_FOR_THE_ACCOUNT_OWNER));
		assertEquals("12345", f.getComponent(Field61.REFERENCE_OF_THE_ACCOUNT_SERVICING_INSTITUTION));
	}

	@Test
	public void testParse_04() {
		Field61 f = new Field61("150903C41,98N059NONREF");
		assertNotNull(f);
		assertEquals("150903", f.getComponent(Field61.VALUE_DATE));
		assertEquals("C", f.getComponent(Field61.DC_MARK));
		assertEquals("41,98", f.getComponent(Field61.AMOUNT));
		assertEquals("N", f.getComponent(Field61.TRANSACTION_TYPE));
		assertEquals("059", f.getComponent(Field61.IDENTIFICATION_CODE));
		assertEquals("NONREF", f.getComponent(Field61.REFERENCE_FOR_THE_ACCOUNT_OWNER));
	}

	@Test
	public void testParse_05() {
		Field61 f = new Field61("1512171218RCF23423,S202//23sdf\nssdfsd");
		assertNotNull(f);
		assertEquals("151217", f.getComponent1());
		assertEquals("1218", f.getComponent2());
		assertEquals("RC", f.getComponent3());
		assertEquals("F", f.getComponent4());
		assertEquals("23423,", f.getComponent5());
		assertEquals("S", f.getComponent6());
		assertEquals("202", f.getComponent7());
		assertNull(f.getComponent8());
		assertEquals("23sdf", f.getComponent9());
		assertEquals("ssdfsd", f.getComponent10());	
	}
	
	/**
	 * https://sourceforge.net/p/wife/bugs/61/
	 */
    @Test
    public void test_DCMark() {

        /**
         C  Credit
         D  Debit
         EC Expected Credit
         ED Expected Debit
         RC Reversal of Credit (debit entry)
         RD Reversal of Debit (credit entry)
         */
        Field61 field61 =  null;

        field61 = new Field61("1512290201C0000000002,2222FBNKNONREF");
        assertEquals("C", field61.getDCMark());

        field61 = new Field61("1512290201D0000000002,2222FBNKNONREF");
        assertEquals("D", field61.getDCMark());

        field61 = new Field61("1512290201RC0000000002,2222FBNKNONREF");
        assertEquals("RC", field61.getDCMark());

        field61 = new Field61("1512290201RD0000000002,2222FBNKNONREF");
        assertEquals("RD", field61.getDCMark());

        field61 = new Field61("1512290201EC0000000002,2222FBNKNONREF");
        assertEquals("EC", field61.getDCMark());

        field61 = new Field61("1512290201ED0000000002,2222FBNKNONREF");
        assertEquals("ED", field61.getDCMark());
    }
    
    @Test
    public void test_DCMArk_with_funds_code() {
        /**
         C  Credit
         D  Debit
         EC Expected Credit
         ED Expected Debit
         RC Reversal of Credit (debit entry)
         RD Reversal of Debit (credit entry)
         */
        Field61 field61 =  null;

        field61 = new Field61("1512290201CZ0000000002,2222FBNKNONREF");
        assertEquals("C", field61.getDCMark());
        assertEquals("Z", field61.getFundsCode());

        field61 = new Field61("1512290201DZ0000000002,2222FBNKNONREF");
        assertEquals("D", field61.getDCMark());
        assertEquals("Z", field61.getFundsCode());

        field61 = new Field61("1512290201RCZ0000000002,2222FBNKNONREF");
        assertEquals("RC", field61.getDCMark());
        assertEquals("Z", field61.getFundsCode());

        field61 = new Field61("1512290201RDZ0000000002,2222FBNKNONREF");
        assertEquals("RD", field61.getDCMark());
        assertEquals("Z", field61.getFundsCode());

        field61 = new Field61("1512290201ECZ0000000002,2222FBNKNONREF");
        assertEquals("EC", field61.getDCMark());
        assertEquals("Z", field61.getFundsCode());

        field61 = new Field61("1512290201EDZ0000000002,2222FBNKNONREF");
        assertEquals("ED", field61.getDCMark());
        assertEquals("Z", field61.getFundsCode());
    }

    @Test
    public void testPreserveWhitespaces() {
    	Field61 f = new Field61("170717D203336,94NTRFR016341554//2395200  \n01P");
    	assertEquals("170717", f.getComponent1());
    	assertNull(f.getComponent2());
    	assertEquals("D", f.getComponent3());
    	assertNull(f.getComponent4());
    	assertEquals("203336,94", f.getComponent5());
    	assertEquals("N", f.getComponent6());
    	assertEquals("TRF", f.getComponent7());
    	assertEquals("R016341554", f.getComponent8());
    	assertEquals("2395200  ", f.getComponent9());
    	assertEquals("01P", f.getComponent10());
    }
    
}
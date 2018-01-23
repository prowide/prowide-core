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
package com.prowidesoftware.swift.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IBANTest {

	@Test public void testIsValidFoooo() {
		assertFalse(new IBAN("fooo").isValid());
	}
	@Test public void testIsValidFo00() {
		assertFalse(new IBAN("fo00").isValid());
	}

	@Test public void testReportedBad() {
		
		IBAN iban = new IBAN("CH10002300A1023502601");
		boolean valid = iban.isValid();
		assertTrue(valid);
	}
	
	@Test public void testAustrian() {
		assertIbanOk("AT611904300234573201");
	}

	@Test public void testItaly() {
		assertIbanOk("IT40S0542811101000000123456");
	}

	@Test public void testBelgium() {
		assertIbanOk("BE62510007547061");
	}

	@Test public void testLuxembourg() {
		assertIbanOk("LU280019400644750000");
	}

	@Test public void testDenmark() {
		assertIbanOk("DK5000400440116243");
	}

	@Test public void testNetherlands() {
		assertIbanOk("NL39RABO0300065264");
	}

	@Test public void testFinland() {
		assertIbanOk("FI2112345600000785");
	}

	@Test public void testNorway() {
		assertIbanOk("NO9386011117947");
	}

	@Test public void testFrance() {
		assertIbanOk("FR1420041010050500013M02606");
	}

	@Test public void testPoland() {
		assertIbanOk("PL60102010260000042270201111");
	}

	@Test public void testGermany() {
		assertIbanOk("DE89370400440532013000");
	}

	@Test public void testPortugal() {
		assertIbanOk("PT50000201231234567890154");
	}

	@Test public void testGibraltar() {
		assertIbanOk("GI75NWBK000000007099453");
	}

	@Test public void testSpain() {
		assertIbanOk("ES0700120345030000067890");
	}

	@Test public void testGreece() {
		assertIbanOk("GR1601101250000000012300695");
	}

	@Test public void testSweden() {
		assertIbanOk("SE3550000000054910000003");
	}

	@Test public void testIceland() {
		assertIbanOk("IS140159260076545510730339");
	}

	@Test public void testSwitzerland() {
		assertIbanOk("CH9300762011623852957");
	}

	@Test public void testIreland() {
		assertIbanOk("IE29AIBK93115212345678");
	}  	
	
	@Test public void testValidCode() {
			assertIbanOk(" GB51 LOYD 3092 0700 7195 88.");
	}
	
	@Test public void testSomeValidCodes() {
		assertIbanOk("CY17002001280000001200527600");
		assertIbanOk("GB45-LOYD-3092-0711-1072-32");
		assertIbanOk("  GB51 LOYD 3092 0700 7195 88.");
		assertIbanOk("IE62BOFI90381614262992");
		assertIbanOk("SE76 8000.08105903-7676/5343");
		assertIbanOk(" NO81 9001 0702 673");
		assertIbanOk("  ES30 2077 0277 8616 0104 3768");
		assertIbanOk("GB61CHAS60924232466601");
		assertIbanOk(".  GB77CHAS60924232466604");
		assertIbanOk("  NL87ABNA0428581854");
		assertIbanOk("  GB38CHAS60924232684101");
		assertIbanOk("  GB88 NWBK 6073 0142 0086 38");
		assertIbanOk(".GB50 NWBK 6073 0142 0082 55");
		assertIbanOk(" -DE20 2005 0550 1206 128 421");
		assertIbanOk("/GB75NWBK60730108338329");
		assertIbanOk("GB54NWBK60730108369844");
		assertIbanOk(" /  GB 56 ANZB 203253 00664276");
		assertIbanOk("  /FR76 1660 7002 1909 4054 2101 892");
		assertIbanOk("  ES64 0049 6170 68 2810279951");
		assertIbanOk("GB96BARC20785869842533");
		assertIbanOk("  FR76   1570 7000 1909 4054 2101 863");
		assertIbanOk("  GB56TUBA40519800026955");
		assertIbanOk("  G B 3 4 T U B A 4 0 5 19800027060");
		assertIbanOk("  FI258000150197683./2");
		assertIbanOk("  CH14 0076 7001 S509 6773 7");
		assertIbanOk("  CY29 0030 0178 0000# 0178 32 041704");
		assertIbanOk("  NL76 FTSB 084.47.26.494");
		assertIbanOk("GB97CHAS60924232684106*&^%()!@");
		assertIbanOk("  FI8916603000104953");
		assertIbanOk("  FI3750000120377337");
		assertIbanOk("GB69MIDL40362292241714");
		assertIbanOk("  GB71 BARC 2006 0530 3517 25");
		assertIbanOk("  GB06 BARC 2006 0500 9524 86");
		assertIbanOk("  GB06 LOYD 3097 5104 5702 05.");
		assertIbanOk("GB26BOFS80200643721002");
	}  
	
	private void assertIbanOk(String string) {
		IBAN iban = new IBAN(string);
		boolean valid = iban.isValid();
		assertTrue(valid);
	}
}

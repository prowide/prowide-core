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
package com.prowidesoftware.swift.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

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

    @Test public void testOkAustrian() {
        assertIbanOk("AT611904300234573201");
    }

    @Test public void testInvalidBbanAustrian() {
        IBAN iban = new IBAN("AT32010000000173363");
        boolean valid = iban.isValid();
        assertFalse(valid);
    }

    @Test public void testOKSeychelles() {
        assertIbanOk("SC52BAHL01031234567890123456USD");
    }

    @Test public void testOKItaly() {
        assertIbanOk("IT40S0542811101000000123456");
    }

    @Test public void testOKBelgiumOK() {
        assertIbanOk("BE62510007547061");
    }

    @Test public void testOKLuxembourg() {
        assertIbanOk("LU280019400644750000");
    }

    @Test public void testOKDenmark() {
        assertIbanOk("DK5000400440116243");
    }

    @Test public void testOKNetherlands() {
        assertIbanOk("NL39RABO0300065264");
    }

    @Test public void testOKFinland() {
        assertIbanOk("FI2112345600000785");
    }

    @Test public void testOKNorway() {
        assertIbanOk("NO9386011117947");
    }

    @Test public void testOKFrance() {
        assertIbanOk("FR1420041010050500013M02606");
    }

    @Test public void testOKPoland() {
        assertIbanOk("PL60102010260000042270201111");
    }

    @Test public void testOKGermany() {
        assertIbanOk("DE89370400440532013000");
    }

    @Test public void testOKPortugal() {
        assertIbanOk("PT50000201231234567890154");
    }

    @Test public void testOKGibraltar() {
        assertIbanOk("GI75NWBK000000007099453");
    }

    @Test public void testOKSpain() {
        assertIbanOk("ES0700120345030000067890");
    }

    @Test public void testOKGreece() {
        assertIbanOk("GR1601101250000000012300695");
    }

    @Test public void testOKSweden() {
        assertIbanOk("SE3550000000054910000003");
    }

    @Test public void testOKIceland() {
        assertIbanOk("IS140159260076545510730339");
    }

    @Test public void testOKSwitzerland() {
        assertIbanOk("CH9300762011623852957");
    }

    @Test public void testOKIreland() {
        assertIbanOk("IE29AIBK93115212345678");
    }

    @Test public void testOKGreatBritain() {
        assertIbanOk(" GB51 LOYD 3092 0700 7195 88.");
    }

    @Test public void testErrorEmpty() {
        IBAN iban = new IBAN("");
        assertTrue(iban.validate() == IbanValidationResult.IBAN_IS_EMPTY);
    }

    @Test public void testErrorNull() {
        IBAN iban = new IBAN(null);
        assertTrue(iban.validate() == IbanValidationResult.IBAN_IS_NULL);
    }

    @Test public void testErrorMissingBban() {
        IBAN iban = new IBAN("IE99");
        assertTrue(iban.validate() == IbanValidationResult.MISSING_BBAN);
    }

    @Test public void testErrorBbanMaxLength() {
        IBAN iban = new IBAN("IE991234567890123456789012345678901");
        assertTrue(iban.validate() == IbanValidationResult.BBAN_MAX_LENGTH);
    }

    @Test public void testErrorBbanLength() {
        IBAN iban = new IBAN("AT32010000000173363");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.BBAN_INVALID_LENGTH);
        //System.out.println(result.message());
    }

    @Test public void testErrorCountry() {
        IBAN iban = new IBAN("aa17002001280000001200527600");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.INVALID_COUNTRY_CODE_CHARSET);
        //System.out.println(result.message());
        iban = new IBAN("ZZ17002001280000001200527600");
        result = iban.validate();
        assertTrue(result == IbanValidationResult.INVALID_COUNTRY_CODE);
        //System.out.println(result.message());
    }

    @Test public void testValidateCheckDigitPresence() {
        IBAN iban = new IBAN("AT1");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.MISSING_CHECK_DIGITS);
    }

    @Test public void testValidateBbanInvalidDigits() {
        IBAN iban = new IBAN("DK5000400T40116243");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.BBAN_INVALID_DIGITS);
    }

    @Test public void testValidateBbanInvalidDigitsOrLetters() {
        IBAN iban = new IBAN("GI75NWBK00000000709t453");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.BBAN_INVALID_DIGITS_OR_LETTERS);
        //System.out.println(result.message());
    }

    @Test public void testValidateBbanInvalidUpperCaseLetters() {
        IBAN iban = new IBAN("GI75nWBK000000007099453");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.BBAN_INVALID_UPPER_CASE_LETTERS);
        //System.out.println(result.message());
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
        IbanValidationResult result = iban.validate();
        //System.out.println(result.message());
        assertEquals(result, IbanValidationResult.OK);
    }

}
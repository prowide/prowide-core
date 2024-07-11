/*
 * Copyright 2006-2023 Prowide
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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IBANValidateTest {

    @Test
    public void testIsValidFoooo() {
        assertFalse(IbanValidationResult.OK == IBAN.validate("fooo"));
    }

    @Test
    public void testIsValidFo00() {
        assertFalse(IbanValidationResult.OK == IBAN.validate("fo00"));
    }

    @Test
    public void testReportedBad() {
        assertTrue(IbanValidationResult.OK == IBAN.validate("CH10002300A1023502601"));
    }

    @Test
    public void testOkAustrian() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("AT611904300234573201"));
    }

    @Test
    public void testInvalidBbanAustrian() {
        assertFalse(IbanValidationResult.OK == IBAN.validate("AT32010000000173363"));
    }

    @Test
    public void testOKSeychelles() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("SC52BAHL01031234567890123456USD"));
    }

    @Test
    public void testOKItaly() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("IT40S0542811101000000123456"));
    }

    @Test
    public void testOKBelgiumOK() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("BE62510007547061"));
    }

    @Test
    public void testOKLuxembourg() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("LU280019400644750000"));
    }

    @Test
    public void testOKDenmark() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("DK5000400440116243"));
    }

    @Test
    public void testOKNetherlands() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("NL39RABO0300065264"));
    }

    @Test
    public void testOKFinland() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("FI2112345600000785"));
    }

    @Test
    public void testOKNorway() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("NO9386011117947"));
    }

    @Test
    public void testOKFrance() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("FR1420041010050500013M02606"));
    }

    @Test
    public void testOKPoland() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("PL60102010260000042270201111"));
    }

    @Test
    public void testOKGermany() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("DE89370400440532013000"));
    }

    @Test
    public void testOKPortugal() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("PT50000201231234567890154"));
    }

    @Test
    public void testOKGibraltar() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("GI75NWBK000000007099453"));
    }

    @Test
    public void testOKSpain() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("ES0700120345030000067890"));
    }

    @Test
    public void testOKGreece() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("GR1601101250000000012300695"));
    }

    @Test
    public void testOKSweden() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("SE3550000000054910000003"));
    }

    @Test
    public void testOKIceland() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("IS140159260076545510730339"));
    }

    @Test
    public void testOKSwitzerland() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("CH9300762011623852957"));
    }

    @Test
    public void testOKIreland() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("IE29AIBK93115212345678"));
    }

    @Test
    public void testSpaceGreatBritain() {
        assertTrue(IBAN.validate(" GB51 LOYD 3092 0700 7195 88.") == IbanValidationResult.INVALID_COUNTRY_CODE_CHARSET);
    }

    @Test
    public void testErrorEmpty() {
        assertTrue(IBAN.validate("") == IbanValidationResult.IBAN_IS_EMPTY);
    }

    @Test
    public void testErrorNull() {
        assertTrue(IBAN.validate(null) == IbanValidationResult.IBAN_IS_NULL);
    }

    @Test
    public void testErrorMissingBban() {
        assertTrue(IBAN.validate("IE99") == IbanValidationResult.MISSING_BBAN);
    }

    @Test
    public void testErrorBbanMaxLength() {
        assertTrue(IBAN.validate("IE991234567890123456789012345678901") == IbanValidationResult.BBAN_MAX_LENGTH);
    }

    @Test
    public void testErrorBbanLength() {
        IbanValidationResult result = IBAN.validate("AT32010000000173363");
        assertTrue(result == IbanValidationResult.BBAN_INVALID_LENGTH);
        // System.out.println(result.message());
    }

    @Test
    public void testErrorCountry() {
        IbanValidationResult result = IBAN.validate("aa17002001280000001200527600");
        assertTrue(result == IbanValidationResult.INVALID_COUNTRY_CODE_CHARSET);
        // System.out.println(result.message());
        result = IBAN.validate("ZZ17002001280000001200527600");
        assertTrue(result == IbanValidationResult.INVALID_COUNTRY_CODE);
        // System.out.println(result.message());
    }

    @Test
    public void testValidateCheckDigitPresence() {
        IbanValidationResult result = IBAN.validate("AT1");
        assertTrue(result == IbanValidationResult.MISSING_CHECK_DIGITS);
    }

    @Test
    public void testValidateBbanInvalidDigits() {
        IbanValidationResult result = IBAN.validate("DK5000400T40116243");
        assertTrue(result == IbanValidationResult.BBAN_INVALID_DIGITS);
    }

    @Test
    public void testValidateBbanInvalidDigitsOrLetters() {
        IbanValidationResult result = IBAN.validate("GI75NWBK00000000709t453");
        assertTrue(result == IbanValidationResult.BBAN_INVALID_DIGITS_OR_LETTERS);
        // System.out.println(result.message());
    }

    @Test
    public void testValidateBbanInvalidUpperCaseLetters() {
        IbanValidationResult result = IBAN.validate("GI75nWBK000000007099453");
        assertTrue(result == IbanValidationResult.BBAN_INVALID_UPPER_CASE_LETTERS);
        // System.out.println(result.message());
    }

    @Test
    public void testCodes() {
        assertEquals(IbanValidationResult.OK, IBAN.validate("CY17002001280000001200527600"));
        assertEquals(IbanValidationResult.OK, IBAN.validate("IE62BOFI90381614262992"));
        assertEquals(IbanValidationResult.OK, IBAN.validate("GB61CHAS60924232466601"));
        assertEquals(IbanValidationResult.OK, IBAN.validate("EG389004000100300074201200001"));
        assertEquals(IbanValidationResult.BBAN_INVALID_LENGTH, IBAN.validate("GB45-LOYD-3092-0711-1072-32"));
        assertEquals(IbanValidationResult.BBAN_INVALID_LENGTH, IBAN.validate("SE76 8000.08105903-7676/5343"));
        assertEquals(IbanValidationResult.BBAN_INVALID_LENGTH, IBAN.validate("GB97CHAS60924232684106*&^%()!@"));
        assertEquals(IbanValidationResult.INVALID_COUNTRY_CODE_CHARSET, IBAN.validate("  NL76 FTSB 084.47.26.494"));
        assertEquals(IbanValidationResult.INVALID_COUNTRY_CODE_CHARSET, IBAN.validate("  FI8916603000104953"));
    }
}

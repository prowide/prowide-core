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

public class IBANTest {

    @Test
    public void testIsValidFoooo() {
        assertFalse(new IBAN("fooo").isValid());
    }

    @Test
    public void testIsValidFo00() {
        assertFalse(new IBAN("fo00").isValid());
    }

    @Test
    public void testReportedBad() {
        IBAN iban = new IBAN("CH10002300A1023502601");
        boolean valid = iban.isValid();
        assertTrue(valid);
    }

    @Test
    public void testOkAustrian() {
        assertIbanOk("AT611904300234573201");
    }

    @Test
    public void testInvalidBbanAustrian() {
        IBAN iban = new IBAN("AT32010000000173363");
        boolean valid = iban.isValid();
        assertFalse(valid);
    }

    @Test
    public void testOKSeychelles() {
        assertIbanOk("SC52BAHL01031234567890123456USD");
    }

    @Test
    public void testOKItaly() {
        assertIbanOk("IT40S0542811101000000123456");
    }

    @Test
    public void testOKBelgiumOK() {
        assertIbanOk("BE62510007547061");
    }

    @Test
    public void testOKLuxembourg() {
        assertIbanOk("LU280019400644750000");
    }

    @Test
    public void testOKDenmark() {
        assertIbanOk("DK5000400440116243");
    }

    @Test
    public void testOKNetherlands() {
        assertIbanOk("NL39RABO0300065264");
    }

    @Test
    public void testOKFinland() {
        assertIbanOk("FI2112345600000785");
    }

    @Test
    public void testOKNorway() {
        assertIbanOk("NO9386011117947");
    }

    @Test
    public void testOKFrance() {
        assertIbanOk("FR1420041010050500013M02606");
    }

    @Test
    public void testOKPoland() {
        assertIbanOk("PL60102010260000042270201111");
    }

    @Test
    public void testOKGermany() {
        assertIbanOk("DE89370400440532013000");
    }

    @Test
    public void testOKPortugal() {
        assertIbanOk("PT50000201231234567890154");
    }

    @Test
    public void testOKGibraltar() {
        assertIbanOk("GI75NWBK000000007099453");
    }

    @Test
    public void testOKSpain() {
        assertIbanOk("ES0700120345030000067890");
    }

    @Test
    public void testOKGreece() {
        assertIbanOk("GR1601101250000000012300695");
    }

    @Test
    public void testOKSweden() {
        assertIbanOk("SE3550000000054910000003");
    }

    @Test
    public void testOKIceland() {
        assertIbanOk("IS140159260076545510730339");
    }

    @Test
    public void testOKSwitzerland() {
        assertIbanOk("CH9300762011623852957");
    }

    @Test
    public void testOKIreland() {
        assertIbanOk("IE29AIBK93115212345678");
    }

    @Test
    public void testOKGreatBritain() {
        assertIbanOk(" GB51 LOYD 3092 0700 7195 88.");
    }

    @Test
    public void testErrorEmpty() {
        IBAN iban = new IBAN("");
        assertTrue(iban.validate() == IbanValidationResult.IBAN_IS_EMPTY);
    }

    @Test
    public void testErrorNull() {
        IBAN iban = new IBAN(null);
        assertTrue(iban.validate() == IbanValidationResult.IBAN_IS_NULL);
    }

    @Test
    public void testErrorMissingBban() {
        IBAN iban = new IBAN("IE99");
        assertTrue(iban.validate() == IbanValidationResult.MISSING_BBAN);
    }

    @Test
    public void testErrorBbanMaxLength() {
        IBAN iban = new IBAN("IE991234567890123456789012345678901");
        assertTrue(iban.validate() == IbanValidationResult.BBAN_MAX_LENGTH);
    }

    @Test
    public void testErrorBbanLength() {
        IBAN iban = new IBAN("AT32010000000173363");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.BBAN_INVALID_LENGTH);
        // System.out.println(result.message());
    }

    @Test
    public void testErrorCountry() {
        IBAN iban = new IBAN("aa17002001280000001200527600");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.INVALID_COUNTRY_CODE_CHARSET);
        // System.out.println(result.message());
        iban = new IBAN("ZZ17002001280000001200527600");
        result = iban.validate();
        assertTrue(result == IbanValidationResult.INVALID_COUNTRY_CODE);
        // System.out.println(result.message());
    }

    @Test
    public void testValidateCheckDigitPresence() {
        IBAN iban = new IBAN("AT1");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.MISSING_CHECK_DIGITS);
    }

    @Test
    public void testValidateBbanInvalidDigits() {
        IBAN iban = new IBAN("DK5000400T40116243");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.BBAN_INVALID_DIGITS);
    }

    @Test
    public void testValidateBbanInvalidDigitsOrLetters() {
        IBAN iban = new IBAN("GI75NWBK00000000709t453");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.BBAN_INVALID_DIGITS_OR_LETTERS);
        // System.out.println(result.message());
    }

    @Test
    public void testValidateBbanInvalidUpperCaseLetters() {
        IBAN iban = new IBAN("GI75nWBK000000007099453");
        IbanValidationResult result = iban.validate();
        assertTrue(result == IbanValidationResult.BBAN_INVALID_UPPER_CASE_LETTERS);
        // System.out.println(result.message());
    }

    @Test
    public void testSomeValidCodes() {
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
        assertIbanOk("EG389004000100300074201200001");
        assertIbanOk("IL620108000000099999999");

        assertIbanOk("AD1200012030200359100100"); // Andorra
        assertIbanOk("AE070331234567890123456"); // United Arab Emirates
        assertIbanOk("AL7620511021812537CLPRCFUSDP"); // Albania
        assertIbanOk("AT611904300234573201"); // Austria
        assertIbanOk("AZ21NABZ00000000137010001944"); // Azerbaijan
        assertIbanOk("BA391290079401028494"); // Bosnia and Herzegovina
        assertIbanOk("BE68539007547034"); // Belgium
        assertIbanOk("BG80BNBG96611020345678"); // Bulgaria
        assertIbanOk("BH67BMAG00001299123456"); // Bahrain
        assertIbanOk("BI4210000100010000332045181"); // Burundi
        assertIbanOk("BR1800360305000010009795493C1"); // Brazil
        assertIbanOk("BY13NBRB3600900000002Z00AB00"); // Republic of Belarus
        assertIbanOk("CH9300762011623852957"); // Switzerland
        assertIbanOk("CR05015202001026284066"); // Costa Rica
        assertIbanOk("CY17002001280000001200527600"); // Cyprus
        assertIbanOk("CZ6508000000192000145399"); // Czech Republic
        assertIbanOk("DE89370400440532013000"); // Germany
        assertIbanOk("DJ2100010000000154000100186"); // Djibouti
        assertIbanOk("DK5000400440116243"); // Denmark
        assertIbanOk("DO28BAGR00000001212453611324"); // Dominican Republic
        assertIbanOk("EE382200221020145685"); // Estonia
        assertIbanOk("EG380019000500000000263180002"); // Egypt
        assertIbanOk("ES9121000418450200051332"); // Spain
        assertIbanOk("FI2112345600000785"); // Finland
        assertIbanOk("FK88SC123456789012"); // Falkland Islands
        assertIbanOk("FO6264600001631634"); // Faroe Islands
        assertIbanOk("FR1420041010050500013M02606"); // France
        assertIbanOk("GB29NWBK60161331926819"); // United Kingdom
        assertIbanOk("GE29NB0000000101904917"); // Georgia
        assertIbanOk("GI75NWBK000000007099453"); // Gibraltar
        assertIbanOk("GL8964710001000206"); // Greenland
        assertIbanOk("GR1601101250000000012300695"); // Greece
        assertIbanOk("GT82TRAJ01020000001210029690"); // Guatemala
        assertIbanOk("HR1210010051863000160"); // Croatia
        assertIbanOk("HU42117730161111101800000000"); // Hungary
        assertIbanOk("IE29AIBK93115212345678"); // Ireland
        assertIbanOk("IL620108000000099999999"); // Israel
        assertIbanOk("IQ98NBIQ850123456789012"); // Iraq
        assertIbanOk("IS140159260076545510730339"); // Iceland
        assertIbanOk("IT60X0542811101000000123456"); // Italy
        assertIbanOk("JO94CBJO0010000000000131000302"); // Jordan
        assertIbanOk("KW81CBKU0000000000001234560101"); // Kuwait
        assertIbanOk("KZ86125KZT5004100100"); // Kazakhstan
        assertIbanOk("LB62099900000001001901229114"); // Lebanon
        assertIbanOk("LC55HEMM000100010012001200023015"); // Saint Lucia
        assertIbanOk("LI21088100002324013AA"); // Liechtenstein
        assertIbanOk("LT121000011101001000"); // Lithuania
        assertIbanOk("LU280019400644750000"); // Luxembourg
        assertIbanOk("LV80BANK0000435195001"); // Latvia
        assertIbanOk("LY83002048000020100120361"); // Libya
        assertIbanOk("MC5811222000010123456789030"); // Monaco
        assertIbanOk("MD24AG000225100013104168"); // Moldova
        assertIbanOk("ME25505000012345678951"); // Montenegro
        assertIbanOk("MK07200002785123453"); // North Macedonia
        assertIbanOk("MR1300020001010000123456753"); // Mauritania
        assertIbanOk("MT84MALT011000012345MTLCAST001S"); // Malta
        assertIbanOk("MU17BOMM0101101030300200000MUR"); // Mauritius
        assertIbanOk("NL91ABNA0417164300"); // Netherlands
        assertIbanOk("NO9386011117947"); // Norway
        assertIbanOk("PK36SCBL0000001123456702"); // Pakistan
        assertIbanOk("PL61109010140000071219812874"); // Poland
        assertIbanOk("PS92PALS000000000400123456702"); // Palestine, State of
        assertIbanOk("PT50000201231234567890154"); // Portugal
        assertIbanOk("QA58DOHB00001234567890ABCDEFG"); // Qatar
        assertIbanOk("RO49AAAA1B31007593840000"); // Romania
        assertIbanOk("RS35260005601001611379"); // Serbia
        assertIbanOk("SA0380000000608010167519"); // Saudi Arabia
        assertIbanOk("SC18SSCB11010000000000001497USD"); // Seychelles
        assertIbanOk("SE4550000000058398257466"); // Sweden
        assertIbanOk("SI56263300012039086"); // Slovenia
        assertIbanOk("SK3112000000198742637541"); // Slovakia
        assertIbanOk("SM86U0322509800000000270100"); // San Marino
        assertIbanOk("ST32000200010192194210112"); // Sao Tome and Principe
        assertIbanOk("SV62CENR00000000000000700025"); // El Salvador
        assertIbanOk("TL380080012345678910157"); // Timor-Leste
        assertIbanOk("TN5914207207100707129648"); // Tunisia
        assertIbanOk("TR330006100519786457841326"); // Turkey
        assertIbanOk("UA213223130000026007233566001"); // Ukraine
        assertIbanOk("VG96VPVG0000012345678901"); // Virgin Islands
        assertIbanOk("XK051212012345678906"); // Kosovo
        assertIbanOk("YE15CBYE0001018861234567891234"); // Yemen

        assertIbanOk("IQ24TRIQ994005007249002");
        assertIbanOk("IQ24TRIQ994005007249002");
        assertIbanOk("LY57009001000000000003093");
        assertIbanOk("AL7620511021812537CLPRCFUSDP");
        assertIbanOk("AL9220512046016756CLPRCFEURR");
        assertIbanOk("BY41PJCB30120730451000000840");
        assertIbanOk("BY98PJCB30120730451000000978");
    }

    private void assertIbanOk(String string) {
        IBAN iban = new IBAN(string);
        IbanValidationResult result = iban.validate();
        // System.out.println(result.message());
        assertEquals(IbanValidationResult.OK, result);
    }
}

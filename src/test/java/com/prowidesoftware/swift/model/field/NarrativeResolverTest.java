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
package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class NarrativeResolverTest {

    @Test
    public void testWrongField() {
        Narrative n = NarrativeResolver.parse(new Field15O());
        assertEquals(0, n.getStructured().size());
        assertNull(n.getUnstructured("\n"));
        assertNull(n.getUnstructured());
        assertNull(n.getUnstructured(" "));
    }

    /*
     * FORMAT 1
     * Line 1:      /8a/[additional information]    (Code)(Narrative)
     * Lines 2-n:   /8a/[additional information]    (Code)(Narrative)
     * [//continuation of additional information]   (Narrative)
     */

    /**
     * empty
     */
    @Test
    public void testFormat1_1() {
        // empty value
        Narrative n = NarrativeResolver.parse(new Field77A());
        assertEquals(0, n.getStructured().size());
        assertNull(n.getUnstructured("\n"));
        assertNull(n.getUnstructured());
        assertNull(n.getUnstructured(" "));
    }

    /**
     * missing codeword (/8a/) section
     */
    @Test
    public void testFormat1_2() {
        String v = "WE NOTED FCR SHOWING YOURSELVES\n" + "AS CONSIGNEE PLEASE DISCHARGE\n" + "US SOONEST";
        Narrative n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
        assertEquals(StringUtils.replace(v, "\n", ""), n.getUnstructured());
        assertEquals(StringUtils.replace(v, "\n", " "), n.getUnstructured(" "));
    }

    /**
     * missing codeword (/8a/) section
     */
    @Test
    public void testFormat1_3() {
        String v = "/WE NOTED FCR SHOWING YOURSELVES";
        Narrative n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());
    }

    /**
     * invalid codeword charset (not [A-Z])
     */
    @Test
    public void testFormat1_4() {
        String v = "/111/WE NOTED FCR SHOWING YOURSELVES";
        Narrative n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());
    }

    /**
     * invalid codeword charset (not [A-Z])
     */
    @Test
    public void testFormat1_5() {
        String v = "/aaa/WE NOTED FCR SHOWING YOURSELVES";
        Narrative n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());
    }

    /**
     * invalid codeword length  (more than 8a)
     */
    @Test
    public void testFormat1_6() {
        String v = "/AAAAAAAAA/Long codeword";
        Narrative n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());
    }

    /**
     * invalid codeword charset (not [A-Z])
     */
    @Test
    public void testFormat1_7() {
        String v = "/AA$AA/Long codeword";
        Narrative n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat1_8() {
        String v = "/AAA/WE NOTED FCR SHOWING YOURSELVES";
        Narrative n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("WE NOTED FCR SHOWING YOURSELVES", n.getStructured("AAA").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat1_9() {
        String v = "/AAA/WE NOTED FCR SHOWING YOURSELVES";
        Narrative n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("WE NOTED FCR SHOWING YOURSELVES", n.getStructured("AAA").getNarrative());
        assertNull(n.getUnstructured());
    }

    /*
     * FORMAT 2
     * Line 1:       /8c/[additional information]   (Code)(Narrative)
     * Lines 2-n:    /8c/[additional information]   (Code)(Narrative)
     * [//continuation of additional information]   (Narrative)
     */

    /**
     * empty
     */
    @Test
    public void testFormat2_1() {
        String v = "WE NOTED FCR SHOWING YOURSELVES\n" + "AS CONSIGNEE PLEASE DISCHARGE\n" + "US SOONEST";
        Narrative n = NarrativeResolver.parse(new Field72Z(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
    }

    /**
     * invalid codeword charset (not [A-Z])
     */
    @Test
    public void testFormat2_2() {
        String v = "/aaa/WE NOTED FCR SHOWING YOURSELVES";
        Narrative n = NarrativeResolver.parse(new Field77(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());
    }

    /**
     * valid
     */
    @Test
    public void testFormat2_3() {
        String v = "/REC123/EURO\n" + "//Target";
        Narrative n = NarrativeResolver.parse(new Field72(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("EUROTarget", n.getStructured("REC123").getNarrative());
        assertEquals("EURO Target", n.getStructured("REC123").getNarrative(" "));
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat2_4() {
        String v = "/RETN/59\n" + "/BE02/UNKNOWN BENEFICIARY\n" + "/MREF/0511030094000014";
        Narrative n = NarrativeResolver.parse(new Field72(v));
        assertEquals(3, n.getStructured().size());
        assertEquals("59", n.getStructured("RETN").getNarrative());
        assertEquals("UNKNOWN BENEFICIARY", n.getStructured("BE02").getNarrative());
        assertEquals("0511030094000014", n.getStructured("MREF").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat2_5() {
        String v = "/RETN/59\n" + "//UNKNOWN BENEFICIARY\n" + "/MREF/0511030094000014";
        Narrative n = NarrativeResolver.parse(new Field72(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("59UNKNOWN BENEFICIARY", n.getStructured("RETN").getNarrative());
        assertEquals("0511030094000014", n.getStructured("MREF").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     * 1 Fragment Empty 1 codeword
     * 2 Fragments with values 2 Codewords
     */
    @Test
    public void testFormat2_6() {
        String v = "/RETN/\n" + "/BE02/UNKNOWN BENEFICIARY\n" + "/MREF/0511030094000014";
        Narrative n = NarrativeResolver.parse(new Field72(v));
        assertEquals(3, n.getStructured().size());
        assertEquals("", n.getStructured("RETN").getNarrative());
        assertEquals("UNKNOWN BENEFICIARY", n.getStructured("BE02").getNarrative());
        assertEquals("0511030094000014", n.getStructured("MREF").getNarrative());
        // Check Fragments
        assertEquals(1, n.getStructured("RETN").getNarrativeFragments().size());
        assertEquals(1, n.getStructured("BE02").getNarrativeFragments().size());
        assertEquals(1, n.getStructured("MREF").getNarrativeFragments().size());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     * 1 Fragment Empty + 1 Non empty value, 1 codeword
     * 1 Non empty value, 1 codeword
     */
    @Test
    public void testFormat2_7() {
        String v = "/RETN/\n" + "//UNKNOWN BENEFICIARY\n" + "/MREF/0511030094000014";
        Narrative n = NarrativeResolver.parse(new Field72(v));
        assertEquals(2, n.getStructured().size()); // This count only the CodeWords
        assertEquals("", n.getStructured("RETN").getNarrativeFragments().get(0));
        assertEquals(
                "UNKNOWN BENEFICIARY",
                n.getStructured("RETN").getNarrativeFragments().get(1));
        assertEquals("UNKNOWN BENEFICIARY", n.getStructured("RETN").getNarrative());
        assertEquals("0511030094000014", n.getStructured("MREF").getNarrative());
        // Check Fragments
        assertEquals(2, n.getStructured("RETN").getNarrativeFragments().size());
        assertEquals(1, n.getStructured("MREF").getNarrativeFragments().size());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     * 1 Fragment Empty + 4 Non empty value, 1 codeword
     */
    @Test
    public void testFormat11() {
        // PW-1812 - Invalid parsing for field 72 in prowide form
        String v = "/ACC/\n"
                + "//ABU DHABI ISLAMIC BANK DUBAI INTE\n"
                + "//RNET CITY BRANCH, P.O. BOX 46000,\n"
                + "//DUBAI, UAE\n"
                + "//UNITED ARAB EMIRATES";
        Narrative n = NarrativeResolver.parse(new Field72(v));
        assertEquals(1, n.getStructured().size()); // This count only the CodeWords
        assertEquals(5, n.getStructured("ACC").getNarrativeFragments().size());
        assertEquals("", n.getStructured("ACC").getNarrativeFragments().get(0));
        assertEquals(
                "ABU DHABI ISLAMIC BANK DUBAI INTE",
                n.getStructured("ACC").getNarrativeFragments().get(1));
        assertEquals(
                "RNET CITY BRANCH, P.O. BOX 46000,",
                n.getStructured("ACC").getNarrativeFragments().get(2));
        assertEquals(
                "DUBAI, UAE", n.getStructured("ACC").getNarrativeFragments().get(3));
        assertEquals(
                "UNITED ARAB EMIRATES",
                n.getStructured("ACC").getNarrativeFragments().get(4));
    }

    /**
     * valid input
     */
    @Test
    public void testFormat2_8() {
        String v = "/RETN/\n" + "/ /UNKNOWN BENEFICIARY\n" + "/MREF/0511030094000014\n" + "//WELL KNOWN BENEFICIARY";
        Narrative n = NarrativeResolver.parse(new Field72(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("", n.getStructured("RETN").getNarrative());
        assertEquals("/ /UNKNOWN BENEFICIARY /MREF/0511030094000014 //WELL KNOWN BENEFICIARY", n.getUnstructured(" "));
    }

    /**
     * valid input
     */
    @Test
    public void testFormat2_9() {
        String v = "/RETN/\n" + "//UNKNOWN BENEFICIARY\n" + "/MREF/0511030094000014";
        Narrative n = NarrativeResolver.parse(new Field72(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("UNKNOWN BENEFICIARY", n.getStructured("RETN").getNarrative());
        assertEquals("0511030094000014", n.getStructured("MREF").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat2_10() {
        String v = "/12BNF34/1000057346REDEMPTION MERRILL L\n" + "//YNCH FUNDSFFC 123455600000078 //BAN\n"
                + "//COFOO / FOO";
        Narrative n = NarrativeResolver.parse(new Field72(v));
        assertEquals(1, n.getStructured().size());
        assertEquals(
                "1000057346REDEMPTION MERRILL LYNCH FUNDSFFC 123455600000078 //BANCOFOO / FOO",
                n.getStructured("12BNF34").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat2_11() {
        String v = "/MYCODE/FOO BAR\n" + "//CONTINUATION OF MYCODE\n" + "FREE ADDITIONAL NARRATIVE\n" + "CONTINUATION";
        Narrative n = NarrativeResolver.parse(new Field77J(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("FOO BAR CONTINUATION OF MYCODE", n.getStructured("MYCODE").getNarrative(" "));
        assertEquals("FREE ADDITIONAL NARRATIVE CONTINUATION", n.getUnstructured(" "));
    }

    /**
     * valid input
     */
    @Test
    public void testFormat2_12() {
        String v = "/ACC/   \n" + "//CONTINUATION OF MYCODE";
        // Fragmento uno es    . (White spaces detectados luego del /ACC/)
        Narrative n = NarrativeResolver.parse(new Field77J(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("   ", n.getStructured("ACC").getNarrativeFragments().get(0));
        assertEquals(
                "CONTINUATION OF MYCODE",
                n.getStructured("ACC").getNarrativeFragments().get(1));
    }

    /**
     * valid input
     */
    @Test
    public void testFormat2_13() {
        String v = "/BNF/RETN\n"
                + "//THE TRANSACTION IS REJECTED DUE T\n"
                + "//O INTERNAL POLICY\n"
                + "/MREF/XXX55444/220424\n"
                + "/TEXT/WE CONSIDER YR MT103 AS NULL\n"
                + "//AND VOID\n";
        Narrative n = NarrativeResolver.parse(new Field72(v));

        assertNull(n.getUnstructured());

        assertEquals(3, n.getStructured().size()); // This count only the CodeWords

        StructuredNarrative BNF = n.getStructured().get(0);
        StructuredNarrative MREF = n.getStructured().get(1);
        StructuredNarrative TEXT = n.getStructured().get(2);

        assertEquals(3, BNF.getNarrativeFragmentsDetail().size());
        assertEquals(1, MREF.getNarrativeFragmentsDetail().size());
        assertEquals(2, TEXT.getNarrativeFragmentsDetail().size());

        // "/BNF/RETN"
        assertEquals(9, BNF.getNarrativeFragmentsDetail().get(0).getLineLength());
        assertEquals(1, BNF.getNarrativeFragmentsDetail().get(0).getLineIndex());

        // "//THE TRANSACTION IS REJECTED DUE T"
        assertEquals(35, BNF.getNarrativeFragmentsDetail().get(1).getLineLength());
        assertEquals(2, BNF.getNarrativeFragmentsDetail().get(1).getLineIndex());

        // "//O INTERNAL POLICY"
        assertEquals(19, BNF.getNarrativeFragmentsDetail().get(2).getLineLength());
        assertEquals(3, BNF.getNarrativeFragmentsDetail().get(2).getLineIndex());

        // "/MREF/XXX55444/220424"
        assertEquals(21, MREF.getNarrativeFragmentsDetail().get(0).getLineLength());
        assertEquals(4, MREF.getNarrativeFragmentsDetail().get(0).getLineIndex());

        // "/TEXT/WE CONSIDER YR MT103 AS NULL"
        assertEquals(34, TEXT.getNarrativeFragmentsDetail().get(0).getLineLength());
        assertEquals(5, TEXT.getNarrativeFragmentsDetail().get(0).getLineIndex());

        // "//AND VOID"
        assertEquals(10, TEXT.getNarrativeFragmentsDetail().get(1).getLineLength());
        assertEquals(6, TEXT.getNarrativeFragmentsDetail().get(1).getLineIndex());
    }

    /*
     * FORMAT 3
     *  Line 1:       /8c/[3!a13d][additional information]   (Code)(Currency)(Amount)(Narrative)
     * Lines 2-6:    /8c/[3!a13d][additional information]   (Code)(Currency)(Amount)(Narrative)
     * [//continuation of additional information]           (Narrative)
     */

    /**
     * empty (Code)(Currency)(Amount)
     */
    @Test
    public void testFormat3_1() {
        String v = "YOUR CHARGES GBP 95,\n" + "CABLE GBP10,\n" + "INTEREST GBP18,";
        Narrative n = NarrativeResolver.parse(new Field73A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
    }

    /**
     * empty (Code)(Currency)(Amount)
     */
    @Test
    public void testFormat3_2() {
        String v = "COMMISSION EUR200,";
        Narrative n = NarrativeResolver.parse(new Field73A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat3_3() {
        String v = "/COMM/EUR300,\n" + "/CABLE/USD20,3";
        Narrative n = NarrativeResolver.parse(new Field71D(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("EUR", n.getStructured("COMM").getCurrency());
        assertEquals(new BigDecimal("300"), n.getStructured("COMM").getAmount());
        assertEquals("USD", n.getStructured("CABLE").getCurrency());
        assertEquals(new BigDecimal("20.3"), n.getStructured("CABLE").getAmount());
        assertNull(n.getStructured("COMM").getNarrative());
        assertNull(n.getStructured("CABLE").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat3_4() {
        String v = "/TELECHAR/USD21,\n" + "/COMM/USD14,";
        Narrative n = NarrativeResolver.parse(new Field71B(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("USD", n.getStructured("TELECHAR").getCurrency());
        assertEquals(new BigDecimal("21"), n.getStructured("TELECHAR").getAmount());
        assertEquals("USD", n.getStructured("COMM").getCurrency());
        assertEquals(new BigDecimal("14"), n.getStructured("COMM").getAmount());
        assertNull(n.getStructured("TELECHAR").getNarrative());
        assertNull(n.getStructured("COMM").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat3_5() {
        String v = "/COMM/EUR300,FOO BAR";
        Narrative n = NarrativeResolver.parse(new Field71B(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("EUR", n.getStructured("COMM").getCurrency());
        assertEquals(new BigDecimal("300"), n.getStructured("COMM").getAmount());
        assertEquals("FOO BAR", n.getStructured("COMM").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat3_6() {
        String v = "/WITX/CAPITAL GAINS TAX RELATING TO\n" + "//THE PERIOD 1998-07-01 2022-10-30\n"
                + "//REF 009524780232\n"
                + "//BANCA DEL TEST";
        Narrative n = NarrativeResolver.parse(new Field71B(v));
        assertEquals(
                "CAPITAL GAINS TAX RELATING TO",
                n.getStructured("WITX").getNarrativeFragments().get(0));
        assertEquals(
                "THE PERIOD 1998-07-01 2022-10-30",
                n.getStructured("WITX").getNarrativeFragments().get(1));
        assertEquals(
                "REF 009524780232",
                n.getStructured("WITX").getNarrativeFragments().get(2));
        assertEquals(
                "BANCA DEL TEST",
                n.getStructured("WITX").getNarrativeFragments().get(3));
    }

    /*
     * FORMAT 3 SCORE
     *  Line 1 option for SCORE:       /8a/1!a/[3!a13d][additional information]  (Code)(Currency)(Amount)(Narrative)
     * Lines 2-6 option for SCORE:   /8c/1!a/[3!a13d][additional information]   (Code)(Currency)(Amount)(Narrative)
     * [//continuation of additional information]           (Narrative)
     */

    /**
     * valid input
     */
    @Test
    public void testFormat3Score_1() {
        String v = "/ACGH/O/EUR1,00Fees";
        Narrative n = NarrativeResolver.parse(new Field71B(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("EUR", n.getStructured("ACGH").getCurrency());
        assertEquals(new BigDecimal("1.00"), n.getStructured("ACGH").getAmount());
        assertEquals("O", n.getStructured("ACGH").getBankCode());
        assertEquals("Fees", n.getStructured("ACGH").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat3Score_2() {
        String v = "/ACGH/B/EUR1,00Fees";
        Narrative n = NarrativeResolver.parse(new Field71B(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("EUR", n.getStructured("ACGH").getCurrency());
        assertEquals(new BigDecimal("1.00"), n.getStructured("ACGH").getAmount());
        assertEquals("B", n.getStructured("ACGH").getBankCode());
        assertEquals("Fees", n.getStructured("ACGH").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat3Score_3() {
        String v = "/ISSU/B/EUR150,00\n" + "/TELECHAR/B/EUR20,00Fees\n"
                + "/POST/O/EUR8,50\n"
                + "//INIT OF MYCODE\n"
                + "//CONTINUATION OF MYCODE";
        Narrative n = NarrativeResolver.parse(new Field71B(v));
        assertEquals(3, n.getStructured().size());
        assertEquals("EUR", n.getStructured("ISSU").getCurrency());
        assertEquals("B", n.getStructured("ISSU").getBankCode());
        assertEquals(new BigDecimal("150.00"), n.getStructured("ISSU").getAmount());

        assertEquals("EUR", n.getStructured("TELECHAR").getCurrency());
        assertEquals("B", n.getStructured("TELECHAR").getBankCode());
        assertEquals(new BigDecimal("20.00"), n.getStructured("TELECHAR").getAmount());
        assertEquals("Fees", n.getStructured("TELECHAR").getNarrative());

        assertEquals("EUR", n.getStructured("POST").getCurrency());
        assertEquals("O", n.getStructured("POST").getBankCode());
        assertEquals(new BigDecimal("8.50"), n.getStructured("POST").getAmount());
        assertEquals(
                "INIT OF MYCODE",
                n.getStructured("POST").getNarrativeFragments().get(0));
        assertEquals(
                "CONTINUATION OF MYCODE",
                n.getStructured("POST").getNarrativeFragments().get(1));

        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat3Score_4() {
        String v = "/ACGH/H/EUR1,00Fees";
        Narrative n = NarrativeResolver.parse(new Field71B(v));
        assertEquals("H", n.getStructured("ACGH").getBankCode());
        assertEquals(1, n.getStructured().size());
        assertEquals("EUR", n.getStructured("ACGH").getCurrency());
        assertEquals(new BigDecimal("1.00"), n.getStructured("ACGH").getAmount());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input, no currency/amount, only narrative
     */
    @Test
    public void testFormat3Score_5() {
        String v = "/TAXES/O/0,19% MwSt 190,00 EUR";
        Narrative n = NarrativeResolver.parse(new Field71B(v));
        StructuredNarrative s = n.getStructured("TAXES");
        assertEquals("O", s.getBankCode());
        assertNull(s.getCountry());
        assertNull(s.getCurrency());
        assertNull(s.getAmount());
        assertEquals("0,19% MwSt 190,00 EUR", s.getNarrativeFragments().get(0));
        assertNull(n.getUnstructured());
    }

    /**
     * valid input, only bank code
     */
    @Test
    public void testFormat3Score_6() {
        String v = "/TAXES/O/";
        Narrative n = NarrativeResolver.parse(new Field71B(v));
        StructuredNarrative s = n.getStructured("TAXES");
        assertEquals("O", s.getBankCode());
        assertNull(s.getCountry());
        assertNull(s.getCurrency());
        assertNull(s.getAmount());
        assertEquals(1, s.getNarrativeFragments().size());
        assertTrue(s.getNarrative().isEmpty());
        assertNull(n.getUnstructured());
    }

    /*
     * FORMAT 4
     *  Line 1:      /8c/[additional information]               (Code)(Narrative)
     * Lines 2-3:   [//continuation of additional information] (Narrative)
     * Variant for cat 1 with country
     * Line 1:      /8c/2!a[//additional information]          (Code)(Country)(Narrative)
     * Lines 2-3:   [//continuation of additional information] (Narrative)
     */

    /**
     * valid input unstructured
     */
    @Test
    public void testFormat4_1() {
        String v = "61A";
        Narrative n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(0, n.getStructured().size());
        assertEquals("61A", n.getUnstructured());
    }

    /**
     * valid input unstructured
     */
    @Test
    public void testFormat4_2() {
        String v = "Foo bar";
        Narrative n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(0, n.getStructured().size());
        assertEquals("Foo bar", n.getUnstructured());
    }

    /**
     * valid input (Code)(Country)
     */
    @Test
    public void testFormat4_3() {
        String v = "/BENEFRES/IT";
        Narrative n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("IT", n.getStructured("BENEFRES").getCountry());
        assertNull(n.getStructured("BENEFRES").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input (Code)(Country)(Narrative)
     */
    @Test
    public void testFormat4_4() {
        String v = "/12NEFRES/IT//Test narrative";
        Narrative n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("IT", n.getStructured("12NEFRES").getCountry());
        assertEquals("Test narrative", n.getStructured("12NEFRES").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input (Code)(Narrative)
     */
    @Test
    public void testFormat4_5() {
        String v = "/BENEFRES/ZZ";
        Narrative n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertNull(n.getStructured("BENEFRES").getCountry());
        assertEquals("ZZ", n.getStructured("BENEFRES").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input (Code)
     */
    @Test
    public void testFormat4_6() {
        String v = "/HOLD/";
        Narrative n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertNotNull(n.getStructured("HOLD"));
        assertNull(n.getStructured().get(0).getCountry());
        assertNull(n.getStructured("HOLD").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input (Code)(Narrative)
     */
    @Test
    public void testFormat4_7() {
        String v = "/HOLD/Foo bar";
        Narrative n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertNotNull(n.getStructured("HOLD"));
        assertEquals("Foo bar", n.getStructured("HOLD").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input (Code)(Narrative) + (//narative)
     */
    @Test
    public void testFormat4_8() {
        String v = "/HOLD/Foo bar\n//Hello world";
        Narrative n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertNotNull(n.getStructured("HOLD"));
        assertEquals("Foo bar Hello world", n.getStructured("HOLD").getNarrative(" "));
        assertNull(n.getUnstructured());
    }

    /**
     * valid input (Code)(Narrative) + unstructured
     */
    @Test
    public void testFormat4_9() {
        String v = "/HOLD/Foo bar\nHello world";
        Narrative n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertNotNull(n.getStructured("HOLD"));
        assertEquals("Foo bar", n.getStructured("HOLD").getNarrative());
        assertEquals("Hello world", n.getUnstructured());
    }

    /*
     * FORMAT 5
     *  Line 1:    /2n/[supplement 1][/supplement2]    (Query Number)(Narrative 1)(Narrative 2)
     * Lines 2-6  /2n/[supplement 1][/supplement2]
     * [//continuation of supplementary information]
     */

    /**
     * valid input (/2n/)
     */
    @Test
    public void testFormat5_1() {
        String v = "/3/";
        Narrative n = NarrativeResolver.parse(new Field75(v));
        assertEquals(1, n.getStructured().size());
        assertNotNull(n.getStructured("3"));
        assertNull(n.getStructured("3").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * invalid input (/2n/) -> unestructured
     */
    @Test
    public void testFormat5_2() {
        String v = "/A/";
        Narrative n = NarrativeResolver.parse(new Field75(v));
        assertEquals(0, n.getStructured().size());
        assertEquals("/A/", n.getUnstructured());
    }

    /**
     * valid input (Query Number)(Narrative 1)(Narrative 2)
     */
    @Test
    public void testFormat5_3() {
        String v = "/36/FOURTH REQUEST\n/17/";
        Narrative n = NarrativeResolver.parse(new Field75(v));
        assertEquals(2, n.getStructured().size());
        assertNotNull(n.getStructured("36"));
        assertEquals("FOURTH REQUEST", n.getStructured("36").getNarrative());
        assertNotNull(n.getStructured("17"));
        assertNull(n.getStructured("17").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * invalid input
     */
    @Test
    public void testFormat5_4() {
        String v = "WE HAVE RECEIVED THE FOLLOWING\n" + "MESSAGE FROM BNF BANK FBACUAUX";
        Narrative n = NarrativeResolver.parse(new Field75(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
    }

    /**
     * invalid input -> unstructured
     */
    @Test
    public void testFormat5_5() {
        String v = "//";
        Narrative n = NarrativeResolver.parse(new Field75(v));
        assertEquals(0, n.getStructured().size());
        assertEquals("//", n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat5_6() {
        String v = "/1/FIRST QUERY RESPONSE\n//SECOND LINE";
        Narrative n = NarrativeResolver.parse(new Field76(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("FIRST QUERY RESPONSESECOND LINE", n.getStructured("1").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat5_7() {
        String v = "/1/FIRST QUERY RESPONSE/SUPPLEMENT";
        Narrative n = NarrativeResolver.parse(new Field76(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("FIRST QUERY RESPONSE", n.getStructured("1").getNarrative());
        assertEquals("SUPPLEMENT", n.getStructured("1").getNarrativeSupplement());
        assertNull(n.getUnstructured());
    }

    /**
     * valid input
     */
    @Test
    public void testFormat5_8() {
        String v = "/1/FIRST QUERY RESPONSE/SUPPLEMENT\n//CONTINUATION OF SUPPLEMENT";
        Narrative n = NarrativeResolver.parse(new Field76(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("FIRST QUERY RESPONSE", n.getStructured("1").getNarrative(" "));
        assertEquals(
                "SUPPLEMENT CONTINUATION OF SUPPLEMENT", n.getStructured("1").getNarrativeSupplement(" "));
        assertNull(n.getUnstructured());
    }

    /*
     * FORMAT 6
     *  Line 1:       /6c/[additional information]   (Code)(Narrative)
     * Lines 2-100:  /6c/[additional information]   (Code)(Narrative)
     * [continuation of additional information]     (Narrative) (cannot start with slash)
     */

    @Test
    public void testFormat6_1() {
        String v = "/ADD/+COPY OF CERTIFICATE OF ORIGIN\n" + "SHOWING GOODS ARE OF BELGIAN ORIGIN\n"
                + "/ADD/+COPY OF CONSULAR INVOICE MENTIONING\n"
                + "IMPORT REGISTRATION NUMBER 123";
        Narrative n = NarrativeResolver.parse(new Field46B(v));
        assertEquals(2, n.getStructured().size());
        assertEquals(
                "+COPY OF CERTIFICATE OF ORIGIN SHOWING GOODS ARE OF BELGIAN ORIGIN",
                n.getStructured("ADD").getNarrative(" "));
        assertEquals(
                "+COPY OF CERTIFICATE OF ORIGIN SHOWING GOODS ARE OF BELGIAN ORIGIN",
                n.getStructured().get(0).getNarrative(" "));
        assertEquals(
                "+COPY OF CONSULAR INVOICE MENTIONING IMPORT REGISTRATION NUMBER 123",
                n.getStructured().get(1).getNarrative(" "));
        assertNull(n.getStructured("FOO"));
        assertNull(n.getUnstructured());
    }

    @Test
    public void testFormat6_2() {
        String v = "/ADD/+COPY OF CERTIFICATE OF ORIGIN\n" + "SHOWING GOODS ARE OF BELGIAN ORIGIN\n"
                + "//ADD/+COPY OF CONSULAR INVOICE MENTIONING\n"
                + "IMPORT REGISTRATION NUMBER 123";
        Narrative n = NarrativeResolver.parse(new Field49M(v));
        assertEquals(1, n.getStructured().size());
        assertEquals(
                "+COPY OF CERTIFICATE OF ORIGIN SHOWING GOODS ARE OF BELGIAN ORIGIN //ADD/+COPY OF CONSULAR INVOICE MENTIONING IMPORT REGISTRATION NUMBER 123",
                n.getStructured("ADD").getNarrative(" "));
        assertEquals(
                "+COPY OF CERTIFICATE OF ORIGIN SHOWING GOODS ARE OF BELGIAN ORIGIN //ADD/+COPY OF CONSULAR INVOICE MENTIONING IMPORT REGISTRATION NUMBER 123",
                n.getStructured().get(0).getNarrative(" "));
        assertNull(n.getStructured("FOO"));
        assertNull(n.getUnstructured());
    }

    @Test
    public void testFormat6_3() {
        String v = "/ADD/59\n" + "/0123456789/BENEFICIARIO DESCONOCIDO\n" + "/MREF/0511030094000014";
        Narrative n = NarrativeResolver.parse(new Field49N(v));
        assertEquals(2, n.getStructured().size());
        assertEquals(
                "59/0123456789/BENEFICIARIO DESCONOCIDO", n.getStructured("ADD").getNarrative());
        assertEquals("0511030094000014", n.getStructured("MREF").getNarrative());
        assertEquals("59", n.getStructured().get(0).getNarrativeFragments().get(0));
        assertEquals(
                "/0123456789/BENEFICIARIO DESCONOCIDO",
                n.getStructured().get(0).getNarrativeFragments().get(1));
        assertEquals(
                "0511030094000014",
                n.getStructured().get(1).getNarrativeFragments().get(0));
        assertNull(n.getUnstructured());
    }

    /*
     * FORMAT 7
     * Code between slashes at the beginning of a line
     */

    @Test
    public void testFormat7_1() {
        String v = "/RFB/C767405OCP021001";
        Narrative n = NarrativeResolver.parse(new Field70(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("C767405OCP021001", n.getStructured("RFB").getNarrative());
        assertNull(n.getUnstructured());
    }

    @Test
    public void testFormat7_2() {
        String v = "/CNC/FRA. 2213 CUENTA 18 SEPTIEMBRE\n" + "// MANT\n" + "//NIMIENTO EQUIPOS E INSTALACIONES";
        Narrative n = NarrativeResolver.parse(new Field70(v));
        assertEquals(1, n.getStructured().size());
        assertEquals(
                "FRA. 2213 CUENTA 18 SEPTIEMBRE MANTNIMIENTO EQUIPOS E INSTALACIONES",
                n.getStructured("CNC").getNarrative());
        assertNull(n.getUnstructured());
    }

    @Test
    public void testFormat7_3() {
        String v = "RESERVATION OF HOTEL";
        Narrative n = NarrativeResolver.parse(new Field70(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());
    }

    @Test
    public void testFormat7_4() {
        String v = "/MASTER/EMAD";
        Narrative n = NarrativeResolver.parse(new Field77D(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("EMAD", n.getStructured("MASTER").getNarrative());
        assertNull(n.getUnstructured());
    }

    @Test
    public void testFormat7_5() {
        String v = "/VALD/20040509\n" + "/SETC/USD";
        Narrative n = NarrativeResolver.parse(new Field77D(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("20040509", n.getStructured("VALD").getNarrative());
        assertEquals("USD", n.getStructured("SETC").getNarrative());
        assertNull(n.getUnstructured());
    }

    @Test
    public void testFormat7_6() {
        String v = "IN THE ABSENCE OF ANY OTHER MASTER\n" + "AGREEMENT BETWEEN US WHICH GOVERNS\n"
                + "FOREIGN EXCHANGE TRANSACTIONS, THE\n"
                + "1997 INTERNATIONAL FOREIGN EXCHANGE\n"
                + "MASTER AGREEMENT (IFEMA) TERMS\n"
                + "SHALL APPLY";
        Narrative n = NarrativeResolver.parse(new Field77D(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
    }

    /*
     * FORMAT 8
     *  Free format codes in slashes, not necessary on new lines
     */

    @Test
    public void testFormat8_1() {
        Narrative n = NarrativeResolver.parse(new Field29A());
        assertEquals(0, n.getStructured().size());
        assertNull(n.getUnstructured());
    }

    @Test
    public void testFormat8_2() {
        String v = "/NAME/Jones/DEPT/IRS Back Office";
        Narrative n = NarrativeResolver.parse(new Field29A(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("Jones", n.getStructured("NAME").getNarrative());
        assertEquals("IRS Back Office", n.getStructured("DEPT").getNarrative());
        assertNull(n.getUnstructured());
    }

    @Test
    public void testFormat8_3() {
        String v = "/NAME/Jones/Brian/DEPT/IRS Back Office\n" + " - more DEPT description";
        Narrative n = NarrativeResolver.parse(new Field29A(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("Jones/Brian", n.getStructured("NAME").getNarrative());
        assertEquals(
                "IRS Back Office - more DEPT description",
                n.getStructured("DEPT").getNarrative());
        assertNull(n.getUnstructured());
    }

    @Test
    public void testFormat8_4() {
        String v = "/NAME/Jones/Brian//DEPT/IRS Back Office\n" + " - more DEPT description/description2/GENDER/Male";
        Narrative n = NarrativeResolver.parse(new Field29A(v));
        assertEquals(3, n.getStructured().size());
        assertEquals("Jones/Brian/", n.getStructured("NAME").getNarrative());
        assertEquals(
                "IRS Back Office - more DEPT description/description2",
                n.getStructured("DEPT").getNarrative());
        assertEquals("Male", n.getStructured("GENDER").getNarrative());
        assertNull(n.getUnstructured());
    }

    @Test
    public void testFormat8_5() {
        String v = "/unstruct/NAME/Jones/DEPT/IRS Back Office\n" + " - more DEPT description/description2/GENDER/Male";
        Narrative n = NarrativeResolver.parse(new Field29A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
    }

    @Test
    public void testFormat8_6() {
        // for field 61 the structure narrative could be part of the supplementary details
        Narrative n =
                NarrativeResolver.parse(new Field61("1512171218RCF23423,S202d//23sdf\n/OCMT/EUR123,4/EXCH/EUR0,01"));
        assertEquals(2, n.getStructured().size());
        assertEquals("EUR123,4", n.getStructured("OCMT").getNarrative());
    }

    @Test
    public void testFormat8_7() {
        Narrative n = NarrativeResolver.parseFormat8(
                "/OCMT/EUR10000,\n//CHGS/EUR100,/xxxxxxxxxx\n/CHGS/EUR50,/\n//xxxxxxxxxx");
        assertEquals(3, n.getStructured().size());
        assertEquals("EUR10000,/", n.getStructured().get(0).getNarrative());
        assertEquals("EUR100,/xxxxxxxxxx", n.getStructured().get(1).getNarrative());
        assertEquals("EUR50,///xxxxxxxxxx", n.getStructured().get(2).getNarrative());
    }

    @Test
    void isCurrencyAndAmountWithBankCode() {
        String v = "B/EUR1,00Fees";
        // currency amount method should check just the currency amount without bank code
        assertFalse(NarrativeResolver.isCurrencyAndAmount(v));
    }

    @Test
    void isCurrencyAndAmountWithoutBankCode() {
        String v = "EUR1,00Fees";
        assertTrue(NarrativeResolver.isCurrencyAndAmount(v));
    }

    @Test
    void isCurrencyAndAmountShortSize() {
        String v = "B/EU";
        assertFalse(NarrativeResolver.isCurrencyAndAmount(v));
    }

    @Test
    void isCurrencyAndAmountShortSizeWithoutBankCode() {
        String v = "EU";
        assertFalse(NarrativeResolver.isCurrencyAndAmount(v));
    }

    @Test
    void isCurrencyAndNoAmount() {
        String v = "EURA";
        assertFalse(NarrativeResolver.isCurrencyAndAmount(v));
    }

    @Test
    void isNoCurrencyAndAmount() {
        String v = "EU12";
        assertFalse(NarrativeResolver.isCurrencyAndAmount(v));
    }

    @Test
    void isNoCurrencyAndNoAmount() {
        String v = "12";
        assertFalse(NarrativeResolver.isCurrencyAndAmount(v));
    }
}

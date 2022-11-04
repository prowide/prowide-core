/*
 * Copyright 2006-2021 Prowide
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

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NarrativeResolverTest {

    Narrative n;
    String v;

    @Test
    public void testWrongField() {
        n = NarrativeResolver.parse(new Field15O());
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
        assertEquals(StringUtils.replace(v, "\n", ""), n.getUnstructured());
        assertEquals(StringUtils.replace(v, "\n", " "), n.getUnstructured(" "));
    }


        /**
         * Line 1:      /8a/[additional information]    (Code)(Narrative)
         * Lines 2-n:   /8a/[additional information]    (Code)(Narrative)
         * [//continuation of additional information]   (Narrative)
         */
    @Test
    public void testFormat1() {
        //empty value
        n = NarrativeResolver.parse(new Field77A());
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
        assertEquals(StringUtils.replace(v, "\n", ""), n.getUnstructured());
        assertEquals(StringUtils.replace(v, "\n", " "), n.getUnstructured(" "));

        // missing codeword (/8a/) section
        v = "WE NOTED FCR SHOWING YOURSELVES\n" +
                "AS CONSIGNEE PLEASE DISCHARGE\n" +
                "US SOONEST";
        n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
        assertEquals(StringUtils.replace(v, "\n", ""), n.getUnstructured());
        assertEquals(StringUtils.replace(v, "\n", " "), n.getUnstructured(" "));

        // missing codeword (/8a/) section
        v = "/WE NOTED FCR SHOWING YOURSELVES";
        n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());

        // invalid codeword charset (not [A-Z])
        v = "/111/WE NOTED FCR SHOWING YOURSELVES";
        n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());

        // invalid codeword charset (not [A-Z])
        v = "/aaa/WE NOTED FCR SHOWING YOURSELVES";
        n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());

        // invalid codeword length  (more than 8a)
        v = "/AAAAAAAAA/Long codeword";
        n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());

        // invalid codeword charset (not [A-Z])
        v = "/AA$AA/Long codeword";
        n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());

        //valid input
        v = "/AAA/WE NOTED FCR SHOWING YOURSELVES";
        n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("WE NOTED FCR SHOWING YOURSELVES", n.getStructured("AAA").getNarrative());
        assertNull(n.getUnstructured());
        
        //valid input
        v = "/AAA/WE NOTED FCR SHOWING YOURSELVES";
        n = NarrativeResolver.parse(new Field77A(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("WE NOTED FCR SHOWING YOURSELVES", n.getStructured("AAA").getNarrative());
        assertNull(n.getUnstructured());
    }

    /**
     * Line 1:       /8c/[additional information]   (Code)(Narrative)
     * Lines 2-n:    /8c/[additional information]   (Code)(Narrative)
     * [//continuation of additional information]   (Narrative)
     */
    @Test
    public void testFormat2() {
        //empty code value
        v = "WE NOTED FCR SHOWING YOURSELVES\n" +
                "AS CONSIGNEE PLEASE DISCHARGE\n" +
                "US SOONEST";
        n = NarrativeResolver.parse(new Field72Z(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));

        // invalid codeword charset (not [A-Z])
        v = "/aaa/WE NOTED FCR SHOWING YOURSELVES";
        n = NarrativeResolver.parse(new Field77(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());


        //valid input
        v = "/REC123/EURO\n" +
                "//Target";
        n = NarrativeResolver.parse(new Field72(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("EUROTarget", n.getStructured("REC123").getNarrative());
        assertEquals("EURO Target", n.getStructured("REC123").getNarrative(" "));
        assertNull(n.getUnstructured());

        //valid input
        v = "/RETN/59\n" +
                "/BE02/BENEFICIARIO DESCONOCIDO\n" +
                "/MREF/0511030094000014";
        n = NarrativeResolver.parse(new Field72(v));
        assertEquals(3, n.getStructured().size());
        assertEquals("59", n.getStructured("RETN").getNarrative());
        assertEquals("BENEFICIARIO DESCONOCIDO", n.getStructured("BE02").getNarrative());
        assertEquals("0511030094000014", n.getStructured("MREF").getNarrative());
        assertNull(n.getUnstructured());

        //valid input
        v = "/12BNF34/1000057346REDEMPTION MERRILL L\n" +
                "//YNCH FUNDSFFC 123455600000078 //BAN\n" +
                "//COFOO / FOO";
        n = NarrativeResolver.parse(new Field72(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("1000057346REDEMPTION MERRILL LYNCH FUNDSFFC 123455600000078 //BANCOFOO / FOO", n.getStructured("12BNF34").getNarrative());
        assertNull(n.getUnstructured());

        //valid input
        v = "/MYCODE/FOO BAR\n" +
                "//CONTINUATION OF MYCODE\n" +
                "FREE ADDITIONAL NARRATIVE\n" +
                "CONTINUATION";
        n = NarrativeResolver.parse(new Field77J(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("FOO BAR CONTINUATION OF MYCODE", n.getStructured("MYCODE").getNarrative(" "));
        assertEquals("FREE ADDITIONAL NARRATIVE CONTINUATION", n.getUnstructured(" "));
    }

    /**
     * Line 1:       /8c/[3!a13d][additional information]   (Code)(Currency)(Amount)(Narrative)
     * Lines 2-6:    /8c/[3!a13d][additional information]   (Code)(Currency)(Amount)(Narrative)
     * [//continuation of additional information]           (Narrative)
     */
    @Test
    public void testFormat3() {

        //empty (Code)(Currency)(Amount)
        v = "YOUR CHARGES GBP 95,\n" +
                "CABLE GBP10,\n" +
                "INTEREST GBP18,";
        n = NarrativeResolver.parse(new Field73A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));

        //empty (Code)(Currency)(Amount)
        v = "COMMISSION EUR200,";
        n = NarrativeResolver.parse(new Field73A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());

        //valid input
        v = "/COMM/EUR300,\n" +
                "/CABLE/USD20,3";
        n = NarrativeResolver.parse(new Field71D(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("EUR", n.getStructured("COMM").getCurrency());
        assertEquals(new BigDecimal("300"), n.getStructured("COMM").getAmount());
        assertEquals("USD", n.getStructured("CABLE").getCurrency());
        assertEquals(new BigDecimal("20.3"), n.getStructured("CABLE").getAmount());
        assertNull(n.getStructured("COMM").getNarrative());
        assertNull(n.getStructured("CABLE").getNarrative());
        assertNull(n.getUnstructured());

        //valid input
        v = "/TELECHAR/USD21,\n" +
                "/COMM/USD14,";
        n = NarrativeResolver.parse(new Field71B(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("USD", n.getStructured("TELECHAR").getCurrency());
        assertEquals(new BigDecimal("21"), n.getStructured("TELECHAR").getAmount());
        assertEquals("USD", n.getStructured("COMM").getCurrency());
        assertEquals(new BigDecimal("14"), n.getStructured("COMM").getAmount());
        assertNull(n.getStructured("TELECHAR").getNarrative());
        assertNull(n.getStructured("COMM").getNarrative());
        assertNull(n.getUnstructured());

        //valid input
        v = "/COMM/EUR300,FOO BAR";
        n = NarrativeResolver.parse(new Field71B(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("EUR", n.getStructured("COMM").getCurrency());
        assertEquals(new BigDecimal("300"), n.getStructured("COMM").getAmount());
        assertEquals("FOO BAR", n.getStructured("COMM").getNarrative());
        assertNull(n.getUnstructured());

        v = "/WITX/CAPITAL GAINS TAX RELATING TO\n" +
                "//THE PERIOD 1998-07-01 2022-10-30\n" +
                "//REF 009524780232\n" +
                "//BANCA DEL TEST";
        n = NarrativeResolver.parse(new Field71B(v));
        assertEquals("CAPITAL GAINS TAX RELATING TO", n.getStructured("WITX").getNarrativeFragments().get(0));
        assertEquals("THE PERIOD 1998-07-01 2022-10-30", n.getStructured("WITX").getNarrativeFragments().get(1));
        assertEquals("REF 009524780232", n.getStructured("WITX").getNarrativeFragments().get(2));
        assertEquals("BANCA DEL TEST", n.getStructured("WITX").getNarrativeFragments().get(3));
    }

    /**
     * Line 1 option for SCORE:       /8a/1!a/[3!a13d][additional information]  (Code)(Currency)(Amount)(Narrative)
     * Lines 2-6 option for SCORE:   /8c/1!a/[3!a13d][additional information]   (Code)(Currency)(Amount)(Narrative)
     * [//continuation of additional information]           (Narrative)
     */
    @Test
    public void testFormat3Score() {

        //valid input
        v = "/ACGH/O/EUR1,00Fees";
        n = NarrativeResolver.parse(new Field71B(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("EUR", n.getStructured("ACGH").getCurrency());
        assertEquals(new BigDecimal("1.00"), n.getStructured("ACGH").getAmount());
        assertEquals("O", n.getStructured("ACGH").getBankCode());
        assertEquals("Fees", n.getStructured("ACGH").getNarrative());
        assertNull(n.getUnstructured());


        //valid input
        v = "/ACGH/B/EUR1,00Fees";
        n = NarrativeResolver.parse(new Field71B(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("EUR", n.getStructured("ACGH").getCurrency());
        assertEquals(new BigDecimal("1.00"), n.getStructured("ACGH").getAmount());
        assertEquals("B", n.getStructured("ACGH").getBankCode());
        assertEquals("Fees", n.getStructured("ACGH").getNarrative());
        assertNull(n.getUnstructured());

        //valid input
        v = "/ISSU/B/EUR150,00\n" +
                "/TELECHAR/B/EUR20,00Fees\n" +
                "/POST/O/EUR8,50\n" +
                "//INIT OF MYCODE\n" +
                "//CONTINUATION OF MYCODE";
        n = NarrativeResolver.parse(new Field71B(v));
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
        assertEquals("INIT OF MYCODE", n.getStructured("POST").getNarrativeFragments().get(0));
        assertEquals("CONTINUATION OF MYCODE", n.getStructured("POST").getNarrativeFragments().get(1));

        assertNull(n.getUnstructured());

        v = "/ACGH/H/EUR1,00Fees";
        n = NarrativeResolver.parse(new Field71B(v));
        assertEquals("H", n.getStructured("ACGH").getBankCode());
        assertEquals(1, n.getStructured().size());
        assertEquals("EUR", n.getStructured("ACGH").getCurrency());
        assertEquals(new BigDecimal("1.00"), n.getStructured("ACGH").getAmount());
        assertNull(n.getUnstructured());
    }

    /**
     * Line 1:      /8c/[additional information]               (Code)(Narrative)
     * Lines 2-3:   [//continuation of additional information] (Narrative)
     * Variant for cat 1 with country
     * Line 1:      /8c/2!a[//additional information]          (Code)(Country)(Narrative)
     * Lines 2-3:   [//continuation of additional information] (Narrative)
     */
    @Test
    public void testFormat4() {
        //valid input unstructured
        v = "61A";
        n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(0, n.getStructured().size());
        assertEquals("61A", n.getUnstructured());

        //valid input unstructured
        v = "Foo bar";
        n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(0, n.getStructured().size());
        assertEquals("Foo bar", n.getUnstructured());

        // valid input (Code)(Country)
        v = "/BENEFRES/IT";
        n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("IT", n.getStructured("BENEFRES").getCountry());
        assertNull(n.getStructured("BENEFRES").getNarrative());
        assertNull(n.getUnstructured());

        //valid input (Code)(Country)(Narrative)
        v = "/12NEFRES/IT//Test narrative";
        n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("IT", n.getStructured("12NEFRES").getCountry());
        assertEquals("Test narrative", n.getStructured("12NEFRES").getNarrative());
        assertNull(n.getUnstructured());

        //valid input (Code)(Narrative)
        v = "/BENEFRES/ZZ";
        n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertNull(n.getStructured("BENEFRES").getCountry());
        assertEquals("ZZ", n.getStructured("BENEFRES").getNarrative());
        assertNull(n.getUnstructured());

        //valid input (Code)
        v = "/HOLD/";
        n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertNotNull(n.getStructured("HOLD"));
        assertNull(n.getStructured().get(0).getCountry());
        assertNull(n.getStructured("HOLD").getNarrative());
        assertNull(n.getUnstructured());

        //valid input (Code)(Narrative)
        v = "/HOLD/Foo bar";
        n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertNotNull(n.getStructured("HOLD"));
        assertEquals("Foo bar", n.getStructured("HOLD").getNarrative());
        assertNull(n.getUnstructured());

        //valid input (Code)(Narrative) + (//narative)
        v = "/HOLD/Foo bar\n//Hello world";
        n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertNotNull(n.getStructured("HOLD"));
        assertEquals("Foo bar Hello world", n.getStructured("HOLD").getNarrative(" "));
        assertNull(n.getUnstructured());

        //valid input (Code)(Narrative) + unstructured
        v = "/HOLD/Foo bar\nHello world";
        n = NarrativeResolver.parse(new Field77B(v));
        assertEquals(1, n.getStructured().size());
        assertNotNull(n.getStructured("HOLD"));
        assertEquals("Foo bar", n.getStructured("HOLD").getNarrative());
        assertEquals("Hello world", n.getUnstructured());
    }

    /**
     * Line 1:    /2n/[supplement 1][/supplement2]    (Query Number)(Narrative 1)(Narrative 2)
     * Lines 2-6  /2n/[supplement 1][/supplement2]
     * [//continuation of supplementary information]
     */
    @Test
    public void testFormat5() {
        //valid input (/2n/)
        v = "/3/";
        n = NarrativeResolver.parse(new Field75(v));
        assertEquals(1, n.getStructured().size());
        assertNotNull(n.getStructured("3"));
        assertNull(n.getStructured("3").getNarrative());
        assertNull(n.getUnstructured());

        //invalid input (/2n/) -> unestructured
        v = "/A/";
        n = NarrativeResolver.parse(new Field75(v));
        assertEquals(0, n.getStructured().size());
        assertEquals("/A/", n.getUnstructured());

        //valid input (Query Number)(Narrative 1)(Narrative 2)
        v = "/36/FOURTH REQUEST\n/17/";
        n = NarrativeResolver.parse(new Field75(v));
        assertEquals(2, n.getStructured().size());
        assertNotNull(n.getStructured("36"));
        assertEquals("FOURTH REQUEST", n.getStructured("36").getNarrative());
        assertNotNull(n.getStructured("17"));
        assertNull(n.getStructured("17").getNarrative());
        assertNull(n.getUnstructured());

        //invalid input
        v = "WE HAVE RECEIVED THE FOLLOWING\n" +
                "MESSAGE FROM BNF BANK FBACUAUX";
        n = NarrativeResolver.parse(new Field75(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));

        //invalid input -> unstructured
        v = "//";
        n = NarrativeResolver.parse(new Field75(v));
        assertEquals(0, n.getStructured().size());
        assertEquals("//", n.getUnstructured());

        //valid input
        v = "/1/FIRST QUERY RESPONSE\n//SECOND LINE";
        n = NarrativeResolver.parse(new Field76(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("FIRST QUERY RESPONSESECOND LINE", n.getStructured("1").getNarrative());
        assertNull(n.getUnstructured());

        v = "/1/FIRST QUERY RESPONSE/SUPPLEMENT";
        n = NarrativeResolver.parse(new Field76(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("FIRST QUERY RESPONSE", n.getStructured("1").getNarrative());
        assertEquals("SUPPLEMENT", n.getStructured("1").getNarrativeSupplement());
        assertNull(n.getUnstructured());

        v = "/1/FIRST QUERY RESPONSE/SUPPLEMENT\n//CONTINUATION OF SUPPLEMENT";
        n = NarrativeResolver.parse(new Field76(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("FIRST QUERY RESPONSE", n.getStructured("1").getNarrative(" "));
        assertEquals("SUPPLEMENT CONTINUATION OF SUPPLEMENT", n.getStructured("1").getNarrativeSupplement(" "));
        assertNull(n.getUnstructured());
    }

    /**
     * Line 1:       /6c/[additional information]   (Code)(Narrative)
     * Lines 2-100:  /6c/[additional information]   (Code)(Narrative)
     * [continuation of additional information]     (Narrative) (cannot start with slash)
     */
    @Test
    public void testFormat6() {
        v = "/ADD/+COPY OF CERTIFICATE OF ORIGIN\n" +
                "SHOWING GOODS ARE OF BELGIAN ORIGIN\n" +
                "/ADD/+COPY OF CONSULAR INVOICE MENTIONING\n" +
                "IMPORT REGISTRATION NUMBER 123";
        n = NarrativeResolver.parse(new Field46B(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("+COPY OF CERTIFICATE OF ORIGIN SHOWING GOODS ARE OF BELGIAN ORIGIN", n.getStructured("ADD").getNarrative(" "));
        assertEquals("+COPY OF CERTIFICATE OF ORIGIN SHOWING GOODS ARE OF BELGIAN ORIGIN", n.getStructured().get(0).getNarrative(" "));
        assertEquals("+COPY OF CONSULAR INVOICE MENTIONING IMPORT REGISTRATION NUMBER 123", n.getStructured().get(1).getNarrative(" "));
        assertNull(n.getStructured("FOO"));
        assertNull(n.getUnstructured());

        v = "/ADD/+COPY OF CERTIFICATE OF ORIGIN\n" +
                "SHOWING GOODS ARE OF BELGIAN ORIGIN\n" +
                "//ADD/+COPY OF CONSULAR INVOICE MENTIONING\n" +
                "IMPORT REGISTRATION NUMBER 123";
        n = NarrativeResolver.parse(new Field49M(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("+COPY OF CERTIFICATE OF ORIGIN SHOWING GOODS ARE OF BELGIAN ORIGIN //ADD/+COPY OF CONSULAR INVOICE MENTIONING IMPORT REGISTRATION NUMBER 123", n.getStructured("ADD").getNarrative(" "));
        assertEquals("+COPY OF CERTIFICATE OF ORIGIN SHOWING GOODS ARE OF BELGIAN ORIGIN //ADD/+COPY OF CONSULAR INVOICE MENTIONING IMPORT REGISTRATION NUMBER 123", n.getStructured().get(0).getNarrative(" "));
        assertNull(n.getStructured("FOO"));
        assertNull(n.getUnstructured());

        v = "/ADD/59\n" +
                "/0123456789/BENEFICIARIO DESCONOCIDO\n" +
                "/MREF/0511030094000014";
        n = NarrativeResolver.parse(new Field49N(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("59/0123456789/BENEFICIARIO DESCONOCIDO", n.getStructured("ADD").getNarrative());
        assertEquals("0511030094000014", n.getStructured("MREF").getNarrative());
        assertEquals("59", n.getStructured().get(0).getNarrativeFragments().get(0));
        assertEquals("/0123456789/BENEFICIARIO DESCONOCIDO", n.getStructured().get(0).getNarrativeFragments().get(1));
        assertEquals("0511030094000014", n.getStructured().get(1).getNarrativeFragments().get(0));
        assertNull(n.getUnstructured());
    }

    /**
     * Code between slashes at the beginning of a line
     */
    @Test
    public void testFormat7() {
        v = "/RFB/C767405OCP021001";
        n = NarrativeResolver.parse(new Field70(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("C767405OCP021001", n.getStructured("RFB").getNarrative());
        assertNull(n.getUnstructured());

        v = "/CNC/FRA. 2213 CUENTA 18 SEPTIEMBRE\n" +
                "// MANT\n" +
                "//NIMIENTO EQUIPOS E INSTALACIONES";
        n = NarrativeResolver.parse(new Field70(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("FRA. 2213 CUENTA 18 SEPTIEMBRE MANTNIMIENTO EQUIPOS E INSTALACIONES", n.getStructured("CNC").getNarrative());
        assertNull(n.getUnstructured());

        v = "RESERVATION OF HOTEL";
        n = NarrativeResolver.parse(new Field70(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured());

        v = "/MASTER/EMAD";
        n = NarrativeResolver.parse(new Field77D(v));
        assertEquals(1, n.getStructured().size());
        assertEquals("EMAD", n.getStructured("MASTER").getNarrative());
        assertNull(n.getUnstructured());

        v = "/VALD/20040509\n" +
                "/SETC/USD";
        n = NarrativeResolver.parse(new Field77D(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("20040509", n.getStructured("VALD").getNarrative());
        assertEquals("USD", n.getStructured("SETC").getNarrative());
        assertNull(n.getUnstructured());

        v = "IN THE ABSENCE OF ANY OTHER MASTER\n" +
                "AGREEMENT BETWEEN US WHICH GOVERNS\n" +
                "FOREIGN EXCHANGE TRANSACTIONS, THE\n" +
                "1997 INTERNATIONAL FOREIGN EXCHANGE\n" +
                "MASTER AGREEMENT (IFEMA) TERMS\n" +
                "SHALL APPLY";
        n = NarrativeResolver.parse(new Field77D(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
    }

    /**
     * Free format codes in slashes, not necessary on new lines
     */
    @Test
    public void testFormat8() {

        n = NarrativeResolver.parse(new Field29A());
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));
        assertEquals(StringUtils.replace(v, "\n", ""), n.getUnstructured());
        assertEquals(StringUtils.replace(v, "\n", " "), n.getUnstructured(" "));

        v = "/NAME/Jones/DEPT/IRS Back Office";
        n = NarrativeResolver.parse(new Field29A(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("Jones", n.getStructured("NAME").getNarrative());
        assertEquals("IRS Back Office", n.getStructured("DEPT").getNarrative());
        assertNull(n.getUnstructured());

        v = "/NAME/Jones/Brian/DEPT/IRS Back Office\n" +
                " - more DEPT description";
        n = NarrativeResolver.parse(new Field29A(v));
        assertEquals(2, n.getStructured().size());
        assertEquals("Jones/Brian", n.getStructured("NAME").getNarrative());
        assertEquals("IRS Back Office - more DEPT description", n.getStructured("DEPT").getNarrative());
        assertNull(n.getUnstructured());

        v = "/NAME/Jones/Brian//DEPT/IRS Back Office\n" +
                " - more DEPT description/description2/GENDER/Male";
        n = NarrativeResolver.parse(new Field29A(v));
        assertEquals(3, n.getStructured().size());
        assertEquals("Jones/Brian/", n.getStructured("NAME").getNarrative());
        assertEquals("IRS Back Office - more DEPT description/description2", n.getStructured("DEPT").getNarrative());
        assertEquals("Male", n.getStructured("GENDER").getNarrative());
        assertNull(n.getUnstructured());

        v = "/unstruct/NAME/Jones/DEPT/IRS Back Office\n" +
                " - more DEPT description/description2/GENDER/Male";
        n = NarrativeResolver.parse(new Field29A(v));
        assertEquals(0, n.getStructured().size());
        assertEquals(v, n.getUnstructured("\n"));

        // for field 61 the structure narrative could be part of the supplementary details
        n = NarrativeResolver.parse(new Field61("1512171218RCF23423,S202d//23sdf\n/OCMT/EUR123,4/EXCH/EUR0,01"));
        assertEquals(2, n.getStructured().size());
        assertEquals("EUR123,4", n.getStructured("OCMT").getNarrative());

        n = NarrativeResolver.parseFormat8("/OCMT/EUR10000,\n//CHGS/EUR100,/xxxxxxxxxx\n/CHGS/EUR50,/\n//xxxxxxxxxx");
        assertEquals(3, n.getStructured().size());
        assertEquals("EUR10000,/", n.getStructured().get(0).getNarrative());
        assertEquals("EUR100,/xxxxxxxxxx", n.getStructured().get(1).getNarrative());
        assertEquals("EUR50,///xxxxxxxxxx", n.getStructured().get(2).getNarrative());
    }

}

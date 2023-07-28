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
import org.junit.jupiter.api.Test;

/**
 * @since 8.1.0
 */
public class NarrativeBuilderTest {

    @Test
    public void testUnstructured() {
        String text = "WE NOTED FCR SHOWING YOURSELVES AS CONSIGNEE PLEASE DISCHARGE US SOONEST";
        Narrative n = Narrative.builder(35).addUnstructured(text).build();
        assertTrue(n.getStructured().isEmpty());
        assertEquals(text, n.getUnstructured(" "));
        assertEquals(3, n.getUnstructuredFragments().size());
        assertEquals(
                "WE NOTED FCR SHOWING YOURSELVES AS",
                n.getUnstructuredFragments().get(0));
        assertEquals(
                "CONSIGNEE PLEASE DISCHARGE US", n.getUnstructuredFragments().get(1));
        assertEquals("SOONEST", n.getUnstructuredFragments().get(2));
        String v = "WE NOTED FCR SHOWING YOURSELVES AS\r\n" + "CONSIGNEE PLEASE DISCHARGE US\r\n" + "SOONEST";
        assertEquals(v, n.getValue());
    }

    @Test
    public void testStructured() {
        Narrative n = Narrative.builder(35).addCodeword("REC", "EURO Target").build();
        assertEquals(1, n.getStructured().size());
        assertEquals("REC", n.getStructured().get(0).getCodeword());
        assertEquals("EURO Target", n.getStructured().get(0).getNarrative());
        assertEquals("/REC/EURO Target", n.getValue());
        assertTrue(n.getUnstructuredFragments().isEmpty());
        assertNull(n.getUnstructured());
    }

    @Test
    public void testRepetitiveCodewords() {
        Narrative n = Narrative.builder(35)
                .addCodeword("ADD", "Text 1")
                .addCodeword("ADD", "Text 2")
                .build();
        assertEquals(2, n.getStructured().size());
        assertEquals("ADD", n.getStructured().get(0).getCodeword());
        assertEquals("Text 1", n.getStructured().get(0).getNarrative());
        assertEquals("ADD", n.getStructured().get(1).getCodeword());
        assertEquals("Text 2", n.getStructured().get(1).getNarrative());
        assertEquals("/ADD/Text 1\r\n/ADD/Text 2", n.getValue());
        assertTrue(n.getUnstructuredFragments().isEmpty());
        assertNull(n.getUnstructured());
    }

    @Test
    public void testStructuredLineWrapping() {
        Narrative.Builder narrativeBuilder;
        narrativeBuilder = Narrative.builder(35);
        narrativeBuilder.addCodeword("INS", "JOHN DOE HAS GONE TO AMSTERDAM AND FROM THERE HE GOES TO PARIS AND");

        Narrative n = narrativeBuilder.build();
        assertEquals(1, n.getStructured().size());
        assertEquals("INS", n.getStructured().get(0).getCodeword());
        assertEquals(
                "JOHN DOE HAS GONE TO AMSTERDAM",
                n.getStructured().get(0).getNarrativeFragments().get(0));
        assertEquals(
                "AND FROM THERE HE GOES TO PARIS",
                n.getStructured().get(0).getNarrativeFragments().get(1));
        assertEquals("AND", n.getStructured().get(0).getNarrativeFragments().get(2));
    }

    @Test
    public void testStructuredAndUnstructured() {
        Narrative n = Narrative.builder(35)
                .addCodeword("RETN", "59")
                .addCodeword("BE02", "BENEFICIARIO DESCONOCIDO")
                .addCodeword("MREF", "0511030094000014")
                .addUnstructured("Additional unstructured information should be at the end")
                .build();
        assertEquals(3, n.getStructured().size());
        assertEquals("RETN", n.getStructured().get(0).getCodeword());
        assertEquals("59", n.getStructured().get(0).getNarrative());
        assertEquals("BE02", n.getStructured().get(1).getCodeword());
        assertEquals("BENEFICIARIO DESCONOCIDO", n.getStructured().get(1).getNarrative());
        assertEquals("MREF", n.getStructured().get(2).getCodeword());
        assertEquals("0511030094000014", n.getStructured().get(2).getNarrative());
        assertEquals(2, n.getUnstructuredFragments().size());
        assertEquals(
                "Additional unstructured information",
                n.getUnstructuredFragments().get(0));
        assertEquals("should be at the end", n.getUnstructuredFragments().get(1));
        String v = "/RETN/59\r\n" + "/BE02/BENEFICIARIO DESCONOCIDO\r\n"
                + "/MREF/0511030094000014\r\n"
                + "Additional unstructured information\r\n"
                + "should be at the end";
        assertEquals(v, n.getValue());
    }

    @Test
    public void testWithAmount() {
        Narrative n = Narrative.builder(35)
                .addCodewordWithAmount("COMM", "EUR", new BigDecimal("300"), null)
                .addCodewordWithAmount("CABLE", "USD", new BigDecimal("20.3"), "FOO TEXT")
                .build();
        assertEquals(2, n.getStructured().size());
        assertEquals("COMM", n.getStructured().get(0).getCodeword());
        assertEquals("EUR", n.getStructured().get(0).getCurrency());
        assertEquals(new BigDecimal("300"), n.getStructured().get(0).getAmount());
        assertNull(n.getStructured().get(0).getNarrative());
        assertEquals("CABLE", n.getStructured().get(1).getCodeword());
        assertEquals("USD", n.getStructured().get(1).getCurrency());
        assertEquals(new BigDecimal("20.3"), n.getStructured().get(1).getAmount());
        assertEquals("FOO TEXT", n.getStructured().get(1).getNarrative());
        assertTrue(n.getUnstructuredFragments().isEmpty());
        assertNull(n.getUnstructured());
        String v = "/COMM/EUR300\r\n/CABLE/USD20.3FOO TEXT";
        assertEquals(v, n.getValue());
    }

    @Test
    public void testWithCountry() {
        Narrative n = Narrative.builder(35)
                .addCodewordWithCountry("BENEFRES", "IT", null)
                .addCodewordWithCountry("OTHER", "ES", "Foo Text")
                .build();
        assertEquals(2, n.getStructured().size());
        assertEquals("BENEFRES", n.getStructured().get(0).getCodeword());
        assertEquals("IT", n.getStructured().get(0).getCountry());
        assertNull(n.getStructured().get(0).getNarrative());
        assertEquals("OTHER", n.getStructured().get(1).getCodeword());
        assertEquals("ES", n.getStructured().get(1).getCountry());
        assertEquals("Foo Text", n.getStructured().get(1).getNarrative());
        assertTrue(n.getUnstructuredFragments().isEmpty());
        assertNull(n.getUnstructured());
        String v = "/BENEFRES/IT\r\n/OTHER/ES//Foo Text";
        assertEquals(v, n.getValue());
    }

    @Test
    public void testCodewordOnly() {
        Narrative n = Narrative.builder(35).addCodeword("HOLD", null).build();
        assertEquals(1, n.getStructured().size());
        assertEquals("HOLD", n.getStructured().get(0).getCodeword());
        assertNull(n.getStructured().get(0).getNarrative());
        assertTrue(n.getUnstructuredFragments().isEmpty());
        assertNull(n.getUnstructured());
        assertEquals("/HOLD/", n.getValue());
    }

    @Test
    public void testSupplement() {
        Narrative n = Narrative.builder(35)
                .addCodewordWithSupplement("10", "Primary text", "Additional Text")
                .addCodewordWithSupplement("11", "Primary text that should be wrapped in lines", "Additional Text")
                .addCodewordWithSupplement("12", "Primary text", "Additional Text that should be wrapped in lines")
                .build();
        assertEquals(3, n.getStructured().size());

        // first
        assertEquals("10", n.getStructured().get(0).getCodeword());
        assertEquals("Primary text", n.getStructured().get(0).getNarrative());
        assertEquals("Additional Text", n.getStructured().get(0).getNarrativeSupplement());

        // second
        assertEquals("11", n.getStructured().get(1).getCodeword());
        assertEquals(
                "Primary text that should be wrapped in lines",
                n.getStructured().get(1).getNarrative(" "));
        assertEquals(
                "Primary text that should be",
                n.getStructured().get(1).getNarrativeFragments().get(0));
        assertEquals(
                "wrapped in lines",
                n.getStructured().get(1).getNarrativeFragments().get(1));
        assertEquals("Additional Text", n.getStructured().get(1).getNarrativeSupplement());

        // third
        assertEquals("12", n.getStructured().get(2).getCodeword());
        assertEquals("Primary text", n.getStructured().get(2).getNarrative());
        assertEquals(
                "Additional Text that should be wrapped in lines",
                n.getStructured().get(2).getNarrativeSupplement(" "));
        assertEquals(
                "Additional Text",
                n.getStructured().get(2).getNarrativeSupplementFragments().get(0));
        assertEquals(
                "that should be wrapped in lines",
                n.getStructured().get(2).getNarrativeSupplementFragments().get(1));

        assertTrue(n.getUnstructuredFragments().isEmpty());
        assertNull(n.getUnstructured());
        String v = "/10/Primary text/Additional Text\r\n" + "/11/Primary text that should be\r\n"
                + "//wrapped in lines/Additional Text\r\n"
                + "/12/Primary text/Additional Text\r\n"
                + "//that should be wrapped in lines";
        assertEquals(v, n.getValue());
    }
}

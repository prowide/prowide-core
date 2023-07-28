package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NarrativeContainerJsonUtilsTest {

    @Test
    void countNarrativesInJsonTestSimple() {
        String json = "{\n" + "'name': '70',\n"
                + "'narrative':  'VALUE 1 ',\n"
                + "'narrative2': 'VALUE 2 ',\n"
                + "'narrative3': 'VALUE 3 ',\n"
                + "'narrative4': 'VALUE 4 '\n"
                + "}";
        assertEquals(4, NarrativeContainerJsonUtils.countNarrativesInJson(json));
    }

    @Test
    void countNarrativesInJsonTestDouble() {
        String json = "{\n" + "\"name\": \"70\",\n"
                + "\"narrative\":  \"VALUE 1 \",\n"
                + "\"narrative2\": \"VALUE 2 \",\n"
                + "\"narrative3\": \"VALUE 3 \",\n"
                + "\"narrative4\": \"VALUE 4 \"\n"
                + "}";
        assertEquals(4, NarrativeContainerJsonUtils.countNarrativesInJson(json));
    }

    @Test
    void countNarrativesInJsonTestComplex() {
        String json = "{\"name\":\"71B\",\n" + "\"narrative\":  \"VALUE 1 \",\n"
                + "\"narrative2\": \"VALUE 2 \",\n"
                + "\"narrative3\": \"VALUE 3 \",\n"
                + "\"narrative4\": \"VALUE 4 \"\n"
                + "\"structured\":[{ \"narrativeFragments\":\n"
                + "[\"CAPITAL GAINS TAX RELATING TO\",\n"
                + "\"THE PERIOD 1998-07-01 2022-10-30\",\n"
                + "\"REF 009524780232\",\"BANCA DEL TEST\",\n"
                + "\"(REF. ART. 6 DL 461/97)\"],\n"
                + "\"narrativeSupplementFragments\":[],\n"
                + "\"codeword\":\"WITX\"\n"
                + "}],\n"
                + "\"unstructuredFragments\":[]}\n";
        assertEquals(4, NarrativeContainerJsonUtils.countNarrativesInJson(json));
    }
}

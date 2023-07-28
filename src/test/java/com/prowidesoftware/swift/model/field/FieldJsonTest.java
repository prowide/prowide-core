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

import com.google.gson.*;
import org.junit.jupiter.api.Test;

/**
 * Test cases for fields JSON conversion
 */
public class FieldJsonTest {

    @Test
    public void toJsonField32A() {
        Field32A f32A = new Field32A("010203USD123,45");
        // {"name":"32A","date":"010203","currency":"USD","amount":"123"}

        JsonObject o = JsonParser.parseString(f32A.toJson()).getAsJsonObject();
        assertEquals("32A", o.get("name").getAsString());
        assertEquals("010203", o.get("date").getAsString());
        assertEquals("USD", o.get("currency").getAsString());
        assertEquals("123,45", o.get("amount").getAsString());
    }

    @Test
    public void toJsonField71B() {

        StructuredNarrative structNarrative = new StructuredNarrative()
                .setCodeword("WITX")
                .addNarrativeFragment("CAPITAL GAINS TAX RELATING TO")
                .addNarrativeFragment("THE PERIOD 1998-07-01 2022-10-30")
                .addNarrativeFragment("REF 009524780232")
                .addNarrativeFragment("BANCA DEL TEST");
        Narrative narrative = new Narrative();
        narrative.add(structNarrative);

        Field71B tag71Ba = new Field71B();
        tag71Ba.setNarrative(narrative);

        assertEquals(
                "CAPITAL GAINS TAX RELATING TO",
                tag71Ba.narrative()
                        .getStructured("WITX")
                        .getNarrativeFragments()
                        .get(0));
        assertEquals(
                "THE PERIOD 1998-07-01 2022-10-30",
                tag71Ba.narrative()
                        .getStructured("WITX")
                        .getNarrativeFragments()
                        .get(1));
        assertEquals(
                "REF 009524780232",
                tag71Ba.narrative()
                        .getStructured("WITX")
                        .getNarrativeFragments()
                        .get(2));
        assertEquals(
                "BANCA DEL TEST",
                tag71Ba.narrative()
                        .getStructured("WITX")
                        .getNarrativeFragments()
                        .get(3));
    }

    @Test
    public void toJsonNarrativeField71B() {

        StructuredNarrative structNarrative = new StructuredNarrative()
                .setCodeword("WITX")
                .addNarrativeFragment("CAPITAL GAINS TAX RELATING TO")
                .addNarrativeFragment("THE PERIOD 1998-07-01 2022-10-30")
                .addNarrativeFragment("REF 009524780232")
                .addNarrativeFragment("BANCA DEL TEST");
        Narrative narrative = new Narrative();
        narrative.add(structNarrative);

        Field71B tag71Ba = new Field71B();
        tag71Ba.setNarrative(narrative);

        JsonObject tag71BaNarrative =
                JsonParser.parseString(tag71Ba.toNarrativeFormat()).getAsJsonObject();

        JsonObject structuredNarrative =
                tag71BaNarrative.get("structured").getAsJsonArray().get(0).getAsJsonObject();
        assertEquals("WITX", structuredNarrative.get("codeword").getAsString());

        JsonArray narrativeFragments =
                structuredNarrative.get("narrativeFragments").getAsJsonArray();
        assertTrue(narrativeFragments.get(0).getAsString().contains("CAPITAL GAINS TAX RELATING TO"));
        assertTrue(narrativeFragments.get(1).getAsString().contains("THE PERIOD 1998-07-01 2022-10-30"));
        assertTrue(narrativeFragments.get(2).getAsString().contains("REF 009524780232"));
        assertTrue(narrativeFragments.get(3).getAsString().contains("BANCA DEL TEST"));
    }

    @Test
    public void toJsonField50D() {
        Field50D f50D = new Field50D("/D/1234\nFoo1\nFoo2\nFoo3");
        // {"name":"50D","dCMark":"D","account":"1234","nameAndAddress":"Foo1","nameAndAddress2":"Foo2","nameAndAddress3":"Foo3"}

        JsonObject o = JsonParser.parseString(f50D.toJson()).getAsJsonObject();
        assertEquals("50D", o.get("name").getAsString());
        assertEquals("D", o.get("dCMark").getAsString());
        assertEquals("1234", o.get("account").getAsString());
        assertEquals("Foo1", o.get("nameAndAddress").getAsString());
        assertEquals("Foo2", o.get("nameAndAddress2").getAsString());
        assertEquals("Foo3", o.get("nameAndAddress3").getAsString());
    }

    @Test
    public void toJsonField15A() {
        Field15A f15A = new Field15A();
        // {"name":"15A"}

        JsonObject o = JsonParser.parseString(f15A.toJson()).getAsJsonObject();
        assertEquals("15A", o.get("name").getAsString());
        assertNull(o.get("value"));
    }

    @Test
    public void toJsonField70() {
        Narrative narrative = new Narrative();
        narrative.addUnstructuredFragment("VALUE 1 ");
        narrative.addUnstructuredFragment("VALUE 2 ");
        narrative.addUnstructuredFragment("VALUE 3");
        Field70 f70 = new Field70(narrative);
        // {"name":"70","narrative":"\"VALUE 1 \\r\\nVALUE 2 \\r\\nVALUE 3\"";}

        JsonObject o = JsonParser.parseString(f70.toJson()).getAsJsonObject();
        assertEquals(
                "VALUE 1 VALUE 2 VALUE 3",
                o.get("narrative").getAsString().replace("\n", "").replace("\r", ""));
    }

    @Test
    public void toJsonNarrativeField70() {
        Narrative narrative = new Narrative();
        narrative.addUnstructuredFragment("VALUE 1 ");
        narrative.addUnstructuredFragment("VALUE 2 ");
        narrative.addUnstructuredFragment("VALUE 3");
        Field70 f70 = new Field70(narrative);
        // {"name":"70","narrative":"\"VALUE 1 \\r\\nVALUE 2 \\r\\nVALUE 3\"";}

        JsonObject o = JsonParser.parseString(f70.toNarrativeFormat()).getAsJsonObject();
        JsonArray asJsonArray = o.get("unstructuredFragments").getAsJsonArray();

        assertTrue(asJsonArray.get(0).getAsString().contains("VALUE 1"));
        assertTrue(asJsonArray.get(1).getAsString().contains("VALUE 2"));
        assertTrue(asJsonArray.get(2).getAsString().contains("VALUE 3"));
    }

    @Test
    public void toJsonField70E() {
        Field70E f = new Field70E(":INST//first line\nsecond line\nthird line\nforth line");

        JsonObject o = JsonParser.parseString(f.toJson()).getAsJsonObject();
        assertEquals("first line", o.get("narrative").getAsString());
        assertEquals("second line", o.get("narrative2").getAsString());
    }

    @Test
    public void fromJson32A() {
        // check fromJson in specific Field classes
        String json32A = "{\"name\":\"32A\",\"date\":\"010203\",\"currency\":\"USD\",\"amount\":\"123,45\"}";
        Field32A f32A = Field32A.fromJson(json32A);
        assertEquals("010203", f32A.getDate());
        assertEquals("USD", f32A.getCurrency());
        assertEquals("123,45", f32A.getAmount());

        // check factory methods in Field
        Field32A f32Abis = (Field32A) Field.fromJson(json32A);
        assertEquals(f32A, f32Abis);
    }

    @Test
    public void fromJson50D() {
        String json50D =
                "{\"name\":\"50D\",\"dCMark\":\"D\",\"account\":\"1234\",\"nameAndAddress\":\"Foo1\",\"nameAndAddress2\":\"Foo2\",\"nameAndAddress3\":\"Foo3\"}";
        Field50D f50D = Field50D.fromJson(json50D);
        assertEquals("D", f50D.getDCMark());
        assertEquals("1234", f50D.getAccount());
        assertEquals("Foo1", f50D.getNameAndAddressLine1());
        assertEquals("Foo2", f50D.getNameAndAddressLine2());
        assertEquals("Foo3", f50D.getNameAndAddressLine3());

        Field50D f50Dbis = (Field50D) Field.fromJson(json50D);
        assertEquals(f50D, f50Dbis);
    }

    /**
     * Check fromJson in the Field70 with a single "narrative" key present in json (current model structure)
     */
    @Test
    public void fromJson70() {
        String field70JsonStringWithOneNarrative =
                "{\n" + "    \"name\": \"70\",\n" + "    \"narrative\":  \"VALUE 1 VALUE 2\"\n" + "}";
        Field70 f70 = Field70.fromJson(field70JsonStringWithOneNarrative);
        assertEquals(
                "VALUE 1 VALUE 2", f70.narrative().getUnstructuredFragments().get(0));
        assertEquals("VALUE 1 VALUE 2", f70.getComponent(1));
    }

    /**
     * Check fromJson in the Field70 with more than one "narrative" key present in json. This is compatible from the
     * old field model, where narrative lines where parsed into individual components. It was later replaced by the
     * {@link NarrativeContainer} interface, having a single String narrative component in the field model.
     */
    @Test
    public void fromJson70_backwardCompatibility() {
        String field70JsonStringMoreThanOneNarratives = "{\n" + "    \"name\": \"70\",\n"
                + "    \"narrative\":  \"VALUE 1 \",\n"
                + "    \"narrative2\": \"VALUE 2 \",\n"
                + "    \"narrative3\": \"VALUE 3 \",\n"
                + "    \"narrative4\": \"VALUE 4 \"\n"
                + "}";
        Field70 f70 = Field70.fromJson(field70JsonStringMoreThanOneNarratives);

        Narrative narrative = f70.narrative();
        assertEquals("VALUE 1 ", narrative.getUnstructuredFragments().get(0));
        assertEquals("VALUE 2 ", narrative.getUnstructuredFragments().get(1));
        assertEquals("VALUE 3 ", narrative.getUnstructuredFragments().get(2));
        assertEquals("VALUE 4 ", narrative.getUnstructuredFragments().get(3));
    }

    /**
     * Check fromJson in the Field72 with more than one "narrative" key present in json.
     */
    @Test
    public void fromJson72() {
        String field72WithNarrativeS = "{" + "    'name': '72',"
                + "    'narrative':  '/INS/PURPOSE CODE 1670',"
                + "    'narrative2':  '//SERVICES, SELF COMPANY FUNDING'"
                + "}";
        Field72 f72 = Field72.fromJson(field72WithNarrativeS);
        Narrative narrative = f72.narrative();
        assertEquals("INS", narrative.getStructured().get(0).getCodeword());
        assertEquals(
                "PURPOSE CODE 1670",
                narrative.getStructured().get(0).getNarrativeFragments().get(0));
        assertEquals(
                "SERVICES, SELF COMPANY FUNDING",
                narrative.getStructured().get(0).getNarrativeFragments().get(1));
    }

    @Test
    public void fromJson72B() {
        Field72 f72 = new Field72("/INS/PURPOSE CODE 1670\n//SERVICES, SELF COMPANY FUNDING");
        Narrative narrative = f72.narrative();
        assertEquals("INS", narrative.getStructured().get(0).getCodeword());
        assertEquals(
                "PURPOSE CODE 1670",
                narrative.getStructured().get(0).getNarrativeFragments().get(0));
        assertEquals(
                "SERVICES, SELF COMPANY FUNDING",
                narrative.getStructured().get(0).getNarrativeFragments().get(1));
    }
}

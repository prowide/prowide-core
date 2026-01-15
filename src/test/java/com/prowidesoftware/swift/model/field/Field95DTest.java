/*
 * Copyright 2006-2025 Prowide
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.Test;

/**
 * Test for Field95D (Digital Ledger Identifier).
 *
 * @since 10.2.0
 */
public class Field95DTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("95D", ":PSET//DLI456788", ":ISSU//ABCD12345");
    }

    @Test
    public void testParser() {
        Field95D f = new Field95D(":PSET//DLI456788");
        assertEquals("PSET", f.getComponent1());
        assertEquals("DLI456788", f.getComponent2());
        assertEquals("PSET", f.getQualifier());
        assertEquals("DLI456788", f.getDigitalLedgerIdentifier());
    }

    @Test
    public void testParserWithDifferentQualifier() {
        Field95D f = new Field95D(":ISSU//ABCD12345");
        assertEquals("ISSU", f.getComponent1());
        assertEquals("ABCD12345", f.getComponent2());
        assertEquals("ISSU", f.getQualifier());
        assertEquals("ABCD12345", f.getDigitalLedgerIdentifier());
    }

    @Test
    public void testGetValue() {
        Field95D f = new Field95D();
        f.setQualifier("PSET");
        f.setDigitalLedgerIdentifier("DLI456788");
        assertEquals(":PSET//DLI456788", f.getValue());
    }

    @Test
    public void testSetters() {
        Field95D f = new Field95D();
        f.setComponent1("PSET");
        f.setComponent2("DLI456788");
        assertEquals("PSET", f.getQualifier());
        assertEquals("DLI456788", f.getDigitalLedgerIdentifier());
    }

    @Test
    public void testGetValueDisplay() {
        Field95D f = new Field95D(":PSET//DLI456788");
        assertNotNull(f.getValueDisplay(Locale.getDefault()));
        assertEquals("PSET", f.getValueDisplay(1, Locale.getDefault()));
        assertEquals("DLI456788", f.getValueDisplay(2, Locale.getDefault()));
    }

    /**
     * Regression test for PW-2967: Field 95D component label must be "Digital Ledger Identifier"
     * to match the XSD schema element name.
     */
    @Test
    public void testComponentLabels() {
        Field95D f = new Field95D();
        List<String> labels = f.getComponentLabels();
        assertEquals(2, labels.size());
        assertEquals("Qualifier", labels.get(0));
        assertEquals("Digital Ledger Identifier", labels.get(1));
    }

    /**
     * Regression test for PW-2967: Verifies the component map uses correct camelCase naming
     * that will generate the proper XML element name.
     */
    @Test
    public void testComponentMap() {
        Field95D f = new Field95D(":PSET//DLI456788");
        // The component map should use "digitalLedgerIdentifier" which generates
        // XML element <DigitalLedgerIdentifier> matching the XSD schema
        String componentName = f.getComponentLabel(2);
        assertTrue(
                componentName.contains("Digital") && componentName.contains("Ledger"),
                "Component 2 label should be 'Digital Ledger Identifier', but was: " + componentName);
    }

    @Test
    public void testFromJson() {
        String json = "{\"qualifier\":\"PSET\",\"digitalLedgerIdentifier\":\"DLI456788\"}";
        Field95D f = Field95D.fromJson(json);
        assertEquals("PSET", f.getQualifier());
        assertEquals("DLI456788", f.getDigitalLedgerIdentifier());
    }

    @Test
    public void testNewInstance() {
        Field95D original = new Field95D(":PSET//DLI456788");
        Field95D copy = Field95D.newInstance(original);
        assertEquals(original.getValue(), copy.getValue());
        assertEquals(original.getQualifier(), copy.getQualifier());
        assertEquals(original.getDigitalLedgerIdentifier(), copy.getDigitalLedgerIdentifier());
    }
}

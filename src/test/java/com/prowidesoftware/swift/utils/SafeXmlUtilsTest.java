package com.prowidesoftware.swift.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

class SafeXmlUtilsTest {

    /**
     * Tests the creation of a DocumentBuilder with default parameters.
     */
    @Test
    void testDocumentBuilder() {
        assertDoesNotThrow(() -> SafeXmlUtils.documentBuilder());
    }

    /**
     * Tests the creation of a DocumentBuilder with specified namespace awareness.
     */
    @Test
    void testDocumentBuilderNamespaceAware() {
        assertDoesNotThrow(() -> SafeXmlUtils.documentBuilder(true));
    }

    /**
     * Tests the creation of an XMLReader with default parameters.
     */
    @Test
    void testReader() {
        assertDoesNotThrow(() -> SafeXmlUtils.reader());
    }

    /**
     * Tests the creation of an XMLReader with specified namespace awareness and schema.
     */
    @Test
    void testReaderNamespaceAware() {
        assertDoesNotThrow(() -> SafeXmlUtils.reader(true, null));
    }

    /**
     * Tests the creation of an XMLInputFactory.
     */
    @Test
    void testInputFactory() {
        assertDoesNotThrow(SafeXmlUtils::inputFactory);
    }

    /**
     * Tests the creation of a Transformer.
     */
    @Test
    void testTransformer() {
        assertDoesNotThrow(SafeXmlUtils::transformer);
    }

    /**
     * Tests the prevention of XXE attack on DocumentBuilder.
     */
    @Test
    void testXXEAttackOnDocumentBuilder() {
        String maliciousXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<!DOCTYPE foo [<!ELEMENT foo ANY ><!ENTITY xxe SYSTEM \"file:///etc/passwd\">]>"
                + "<foo>&xxe;</foo>";

        DocumentBuilder documentBuilder = SafeXmlUtils.documentBuilder();

        assertThrows(SAXParseException.class, () -> {
            documentBuilder.parse(new ByteArrayInputStream(maliciousXml.getBytes(StandardCharsets.UTF_8)));
        });
    }

    /**
     * Tests XXE attack on the Safe SAX parser with default parameters.
     */
    @Test
    void testXXEAttackOnSAXReaderDefaultParameters() {
        String maliciousXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<!DOCTYPE foo [<!ELEMENT foo ANY ><!ENTITY xxe SYSTEM \"file:///etc/passwd\">]>"
                + "<foo>&xxe;</foo>";

        assertThrows(SAXException.class, () -> {
            SafeXmlUtils.reader().parse(new org.xml.sax.InputSource(new java.io.StringReader(maliciousXml)));
        });
    }

    /**
     * Tests XXE attack on the Safe SAX parser with custom parameters.
     */
    @Test
    void testXXEAttackOnSAXReaderCustomParameters() {
        String maliciousXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<!DOCTYPE foo [<!ELEMENT foo ANY ><!ENTITY xxe SYSTEM \"file:///etc/passwd\">]>"
                + "<foo>&xxe;</foo>";

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        try {
            schema = schemaFactory.newSchema();
        } catch (SAXException e) {
            fail(e);
        }

        Schema finalSchema = schema;
        assertThrows(SAXException.class, () -> {
            SafeXmlUtils.reader(true, finalSchema)
                    .parse(new org.xml.sax.InputSource(new java.io.StringReader(maliciousXml)));
        });
    }

    /**
     * Tests XXE attack on the Safe Transformer and verifies that the entity in the XML is ignored.
     */
    @Test
    void testXXEAttackOnTransformer() {
        // Malicious XML document with XXE attack
        String maliciousXml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" + "<!DOCTYPE foo [\n"
                + "  <!ELEMENT foo ANY >\n"
                + "  <!ENTITY xxe SYSTEM \"file:///etc/passwd\" >]>\n"
                + "<foo>&xxe;</foo>";

        // Attempt to create a Transformer using SafeXmlUtils.transformer
        assertThrows(TransformerException.class, () -> {
            Transformer transformer = SafeXmlUtils.transformer();

            // Attempt to transform the malicious XML document
            transformer.transform(
                    new StreamSource(new java.io.StringReader(maliciousXml)),
                    new StreamResult(new java.io.StringWriter()));
        });
    }

    /**
     * Tests XXE attack on the Safe StAX parser and verifies that the entity is ignored.
     */
    @Test
    void testXXEAttackOnStAXParser() {
        // Malicious XML document with XXE attack
        String maliciousXml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" + "<!DOCTYPE foo [\n"
                + "  <!ELEMENT foo ANY >\n"
                + "  <!ENTITY xxe SYSTEM \"file:///etc/passwd\" >]>\n"
                + "<foo>&xxe;</foo>";

        assertThrows(XMLStreamException.class, () -> {
            XMLInputFactory xmlInputFactory = SafeXmlUtils.inputFactory();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(
                    new ByteArrayInputStream(maliciousXml.getBytes(StandardCharsets.UTF_8)));
            while (xmlStreamReader.hasNext()) {
                int event = xmlStreamReader.next();
                switch (event) {
                    case XMLStreamReader.START_ELEMENT:
                        System.out.println("Start Element: " + xmlStreamReader.getLocalName());
                        break;
                    case XMLStreamReader.CHARACTERS:
                        System.out.println("Text: " + xmlStreamReader.getText());
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        System.out.println("End Element: " + xmlStreamReader.getLocalName());
                        break;
                }
            }
        });
    }

    /**
     * This test actually reproduces the vulnerability when the SafeXmlUtils is not used
     */
    @Disabled
    @Test
    void _testXXEAttackOnStAXParser() throws XMLStreamException {
        // Create an XMLInputFactory with the default configuration
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        // Malicious XML document with XXE attack
        String xmlContent = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" + "<!DOCTYPE foo [\n"
                + "  <!ELEMENT foo ANY >\n"
                + "  <!ENTITY xxe SYSTEM \"file:///etc/passwd\" >]>\n"
                + "<foo>&xxe;</foo>";

        // Create an XMLStreamReader
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StringReader(xmlContent));

        // Use the XMLStreamReader as needed
        while (xmlStreamReader.hasNext()) {
            int event = xmlStreamReader.next();
            switch (event) {
                case XMLStreamReader.START_ELEMENT:
                    System.out.println("Start Element: " + xmlStreamReader.getLocalName());
                    break;
                case XMLStreamReader.CHARACTERS:
                    System.out.println("Text: " + xmlStreamReader.getText());
                    break;
                case XMLStreamReader.END_ELEMENT:
                    System.out.println("End Element: " + xmlStreamReader.getLocalName());
                    break;
            }
        }
    }
}

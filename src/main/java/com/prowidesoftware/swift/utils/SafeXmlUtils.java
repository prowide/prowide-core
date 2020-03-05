package com.prowidesoftware.swift.utils;

import com.prowidesoftware.ProwideException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * Reusable safe XML document builder to prevent XXE
 * https://cheatsheetseries.owasp.org/cheatsheets/XML_External_Entity_Prevention_Cheat_Sheet.html
 * @since 8.0.5
 */
public class SafeXmlUtils {
    private static transient final java.util.logging.Logger log = java.util.logging.Logger.getLogger(SafeXmlUtils.class.getName());

    // Suppress default constructor for noninstantiability
    private SafeXmlUtils() {
        throw new AssertionError();
    }

    /**
     * Safe DOM parsing, with default parameters
     * @throws ProwideException if the parser cannot be configured
     * @see #documentBuilder(boolean)
     */
    public static DocumentBuilder documentBuilder() {
        return documentBuilder(false);
    }

    /**
     * Safe DOM parsing
     * @param namespaceAware factory awareness
     * @throws ProwideException if the parser cannot be configured
     */
    public static DocumentBuilder documentBuilder(boolean namespaceAware) {
        String feature = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            feature = XMLConstants.FEATURE_SECURE_PROCESSING;
            dbf.setFeature(feature, true );

            // Xerces 1 - http://xerces.apache.org/xerces-j/features.html#external-general-entities
            // Xerces 2 - http://xerces.apache.org/xerces2-j/features.html#external-general-entities

            // Using the SAXParserFactory's setFeature
            feature = "http://xml.org/sax/features/external-general-entities";
            dbf.setFeature(feature, false);

            // Xerces 2 only - http://xerces.apache.org/xerces-j/features.html#external-general-entities
            feature = "http://apache.org/xml/features/disallow-doctype-decl";
            dbf.setFeature(feature, true);

            // set parameter
            dbf.setNamespaceAware(namespaceAware);

            return dbf.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            throw new ProwideException("Error configuring the XML document builder. " +
                    "The feature " + feature + " is probably not supported by your XML processor.", e);
        }
    }

    /**
     * Safe SAX parser, with default parameters
     * @throws ProwideException if the parser cannot be configured
     * @see #reader(boolean, Schema)
     */
    public static XMLReader reader() throws ProwideException {
        return reader(false, null);
    }

    /**
     * Safe SAX parser
     * @param namespaceAware SAX factory awareness
     * @param schema optional schema if the reader will be used for validaiton, null to ignore
     * @throws ProwideException if the parser cannot be configured
     */
    public static XMLReader reader(boolean namespaceAware, Schema schema) throws ProwideException {
        String feature = null;
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();

            feature = XMLConstants.FEATURE_SECURE_PROCESSING;
            spf.setFeature(feature, true );

            // Xerces 1 - http://xerces.apache.org/xerces-j/features.html#external-general-entities
            // Xerces 2 - http://xerces.apache.org/xerces2-j/features.html#external-general-entities

            // Using the SAXParserFactory's setFeature
            feature = "http://xml.org/sax/features/external-general-entities";
            spf.setFeature(feature, false);

            // Xerces 2 only - http://xerces.apache.org/xerces-j/features.html#external-general-entities
            feature = "http://apache.org/xml/features/disallow-doctype-decl";
            spf.setFeature(feature, true);

            // set parameters
            spf.setNamespaceAware(namespaceAware);
            if (schema != null) {
                spf.setSchema(schema);
            }

            SAXParser saxParser = spf.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();

            // Using the XMLReader's setFeature

            feature = "http://apache.org/xml/features/disallow-doctype-decl";
            reader.setFeature(feature, true);

            // This may not be strictly required as DTDs shouldn't be allowed at all, per previous line.
            feature = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
            reader.setFeature(feature, false);

            feature = "http://xml.org/sax/features/external-general-entities";
            reader.setFeature(feature, false);

            feature = "http://xml.org/sax/features/external-parameter-entities";
            reader.setFeature(feature, false);

            return reader;

        } catch (ParserConfigurationException | SAXException e) {
            throw new ProwideException("Error configuring the XML parser. " +
                    "The feature " + feature + " is probably not supported by your XML processor.", e);
        }
    }

    /**
     * Safe StAX parser
     * @throws ProwideException if the parser cannot be configured
     */
    public static XMLInputFactory inputFactory() {
        XMLInputFactory xif = XMLInputFactory.newInstance();

        // This disables DTDs entirely for that factory
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);

        // disable external entities
        xif.setProperty("javax.xml.stream.isSupportingExternalEntities", false);

        return xif;
    }

    /**
     * Safe transformer
     */
    public static Transformer transformer() {
        String feature = null;
        try {
            TransformerFactory tf = TransformerFactory.newInstance();

            feature = XMLConstants.ACCESS_EXTERNAL_DTD;
            tf.setAttribute(feature, "");

            feature = XMLConstants.ACCESS_EXTERNAL_STYLESHEET;
            tf.setAttribute(feature, "");

            return tf.newTransformer();

        } catch (TransformerConfigurationException e) {
            throw new ProwideException("Error configuring the XML transformer factory. " +
                    "The feature " + feature + " is probably not supported by your XML processor.", e);
        }
    }

    /**
     * Safe schema factory
     */
    public static SchemaFactory schemaFactory() {
        String feature = null;
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            feature = XMLConstants.ACCESS_EXTERNAL_DTD;
            factory.setProperty(feature, "");

            // we keep this one for the moment because it is needed in MX xsys validation
            //feature = XMLConstants.ACCESS_EXTERNAL_SCHEMA;
            //factory.setProperty(feature, "");

            return factory;

        } catch (SAXNotRecognizedException | SAXNotSupportedException e) {
            throw new ProwideException("Error configuring the schema factory. " +
                    "The feature " + feature + " is probably not supported by your XML processor.", e);
        }
    }

    /**
     * Safe schema validator
     */
    public static Validator validator(Schema schema) {
        String feature = null;
        try {
            Validator validator = schema.newValidator();

            feature = XMLConstants.ACCESS_EXTERNAL_DTD;
            validator.setProperty(feature, "");

            feature = XMLConstants.ACCESS_EXTERNAL_SCHEMA;
            validator.setProperty(feature, "");

            return validator;

        } catch (SAXNotRecognizedException | SAXNotSupportedException e) {
            throw new ProwideException("Error configuring the schema validator. " +
                    "The feature " + feature + " is probably not supported by your XML processor.", e);
        }
    }

}
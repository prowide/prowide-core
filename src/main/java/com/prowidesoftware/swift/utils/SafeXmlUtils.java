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
package com.prowidesoftware.swift.utils;

import com.prowidesoftware.ProwideException;
import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import java.util.logging.Level;
import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.commons.lang3.ArrayUtils;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/**
 * This class is uses in many places in the library to create XML parsers and transformers, to switch off certain
 * features that may be vulnerable to XXE attacks.
 * <p>
 * The features are implementation dependent, thus they might not be present in certain implementations of the XML apis.
 * We have experience issues with many xerces and xalan versions. So when faced with an error because a feature is
 * not present in your environment, the first choice should be to review the xml related dependencies, and to try to
 * those that do not support the feature.
 * <p>
 * When the dependencies cannot be changed, you can ignore the error by adding a pw-swift-core.properties file in the
 * application classpath with a safeXmlUtils.ignore=featureName,featureName,featureName property. This will prevent the
 * indicated features to be applied.
 *
 * @since 8.0.5
 */
public class SafeXmlUtils {
    private static final java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(SafeXmlUtils.class.getName());

    private static final String FEATURE_IGNORE_PROPERTY = "safeXmlUtils.ignore";

    private SafeXmlUtils() {
        throw new AssertionError();
    }

    /**
     * Safe DOM parsing, with default parameters
     *
     * @throws ProwideException if the parser cannot be configured
     * @see #documentBuilder(boolean)
     */
    public static DocumentBuilder documentBuilder() {
        return documentBuilder(false);
    }

    /**
     * Safe DOM parsing
     *
     * @param namespaceAware factory awareness
     * @throws ProwideException if the parser cannot be configured
     */
    public static DocumentBuilder documentBuilder(boolean namespaceAware) {
        String feature = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            feature = XMLConstants.FEATURE_SECURE_PROCESSING;
            if (applyFeature(feature)) {
                dbf.setFeature(feature, true);
            }

            // Xerces 1 - http://xerces.apache.org/xerces-j/features.html#external-general-entities
            // Xerces 2 - http://xerces.apache.org/xerces2-j/features.html#external-general-entities

            // Using the SAXParserFactory's setFeature
            feature = "http://xml.org/sax/features/external-general-entities";
            if (applyFeature(feature)) {
                dbf.setFeature(feature, false);
            }

            // Xerces 2 only - http://xerces.apache.org/xerces-j/features.html#external-general-entities
            feature = "http://apache.org/xml/features/disallow-doctype-decl";
            if (applyFeature(feature)) {
                dbf.setFeature(feature, true);
            }

            // set parameter
            dbf.setNamespaceAware(namespaceAware);

            return dbf.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            throw logAndCreateException(e, feature, DocumentBuilderFactory.class.getName());
        }
    }

    /**
     * Safe SAX parser, with default parameters
     *
     * @throws ProwideException if the parser cannot be configured
     * @see #reader(boolean, Schema)
     */
    public static XMLReader reader() throws ProwideException {
        return reader(false, null);
    }

    /**
     * Safe SAX parser
     *
     * @param namespaceAware SAX factory awareness
     * @param schema         optional schema if the reader will be used for validaiton, null to ignore
     * @throws ProwideException if the parser cannot be configured
     */
    public static XMLReader reader(boolean namespaceAware, Schema schema) throws ProwideException {
        String feature = null;
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();

            feature = XMLConstants.FEATURE_SECURE_PROCESSING;
            if (applyFeature(feature)) {
                spf.setFeature(feature, true);
            }

            // Xerces 1 - http://xerces.apache.org/xerces-j/features.html#external-general-entities
            // Xerces 2 - http://xerces.apache.org/xerces2-j/features.html#external-general-entities

            // Using the SAXParserFactory's setFeature
            feature = "http://xml.org/sax/features/external-general-entities";
            if (applyFeature(feature)) {
                spf.setFeature(feature, false);
            }

            // Xerces 2 only - http://xerces.apache.org/xerces-j/features.html#external-general-entities
            feature = "http://apache.org/xml/features/disallow-doctype-decl";
            if (applyFeature(feature)) {
                spf.setFeature(feature, true);
            }

            // set parameters
            spf.setNamespaceAware(namespaceAware);
            if (schema != null) {
                spf.setSchema(schema);
            }

            SAXParser saxParser = spf.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();

            // Using the XMLReader's setFeature

            feature = "http://apache.org/xml/features/disallow-doctype-decl";
            if (applyFeature(feature)) {
                spf.setFeature(feature, true);
            }

            // This may not be strictly required as DTDs shouldn't be allowed at all, per previous line.
            feature = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
            if (applyFeature(feature)) {
                spf.setFeature(feature, false);
            }

            feature = "http://xml.org/sax/features/external-general-entities";
            if (applyFeature(feature)) {
                spf.setFeature(feature, false);
            }

            feature = "http://xml.org/sax/features/external-parameter-entities";
            if (applyFeature(feature)) {
                spf.setFeature(feature, false);
            }

            return reader;

        } catch (ParserConfigurationException | SAXException e) {
            throw logAndCreateException(e, feature, SAXParserFactory.class.getName());
        }
    }

    /**
     * Safe StAX parser
     *
     * @throws ProwideException if the parser cannot be configured
     */
    public static XMLInputFactory inputFactory() {
        XMLInputFactory xif = XMLInputFactory.newInstance();

        // This disables DTDs entirely for that factory
        if (applyFeature(XMLInputFactory.SUPPORT_DTD)) {
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        }
        // disable external entities
        String property = "javax.xml.stream.isSupportingExternalEntities";
        if (applyFeature(property)) {
            xif.setProperty(property, false);
        }

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
            if (applyFeature(feature)) {
                tf.setAttribute(feature, "");
            }

            feature = XMLConstants.ACCESS_EXTERNAL_STYLESHEET;
            if (applyFeature(feature)) {
                tf.setAttribute(feature, "");
            }

            return tf.newTransformer();

        } catch (TransformerConfigurationException e) {
            throw logAndCreateException(e, feature, Transformer.class.getName());
        }
    }

    /**
     * @deprecated use the default SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI) instead, there is no need to prevent XXE attacks in the schema factory
     */
    @Deprecated
    @ProwideDeprecated(phase3 = TargetYear.SRU2025)
    public static SchemaFactory schemaFactory() {
        DeprecationUtils.phase2(
                SafeXmlUtils.class,
                "schemaFactory",
                "use SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI) instead");
        String feature = null;
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // https://stackoverflow.com/questions/58374278/org-xml-sax-saxnotrecognizedexception-property-http-javax-xml-xmlconstants-p
            feature = XMLConstants.ACCESS_EXTERNAL_DTD;
            if (applyFeature(feature)) {
                factory.setProperty(feature, "");
            }

            // we keep this one for the moment because it is needed in MX xsys validation
            // feature = XMLConstants.ACCESS_EXTERNAL_SCHEMA;
            // factory.setProperty(feature, "");

            return factory;

        } catch (SAXNotRecognizedException | SAXNotSupportedException e) {
            throw logAndCreateException(e, feature, SchemaFactory.class.getName());
        }
    }

    /**
     * @deprecated use the default schema.newValidator() instead, there is no need to prevent XXE attacks in validation
     */
    @Deprecated
    @ProwideDeprecated(phase3 = TargetYear.SRU2025)
    public static Validator validator(Schema schema) {
        DeprecationUtils.phase2(SafeXmlUtils.class, "validator", "use schema.newValidator() instead");
        String feature = null;
        try {
            Validator validator = schema.newValidator();

            feature = XMLConstants.ACCESS_EXTERNAL_DTD;
            if (applyFeature(feature)) {
                validator.setProperty(feature, "");
            }

            feature = XMLConstants.ACCESS_EXTERNAL_SCHEMA;
            if (applyFeature(feature)) {
                validator.setProperty(feature, "");
            }

            return validator;

        } catch (SAXNotRecognizedException | SAXNotSupportedException e) {
            throw logAndCreateException(e, feature, Validator.class.getName());
        }
    }

    private static boolean applyFeature(final String feature) {
        final String[] prop = PropertyLoader.getPropertyArray(FEATURE_IGNORE_PROPERTY);
        return (!ArrayUtils.contains(prop, feature));
    }

    private static ProwideException logAndCreateException(Exception e, String feature, String className) {
        log.log(
                Level.SEVERE,
                "Error configuring the " + className + ". The feature " + feature
                        + " is not supported by your XML processor. Increase log level for details.");
        log.log(
                Level.FINER,
                "To avoid the missing feature, try removing the xerces and xalan dependencies in your project. If that is not doable, you can ignore this error by adding a "
                        + PropertyLoader.PROPERTIES_FILE + " in your application classpath with property "
                        + FEATURE_IGNORE_PROPERTY + "=" + feature,
                e);
        return new ProwideException(
                "Error configuring the " + className + ". The feature " + feature
                        + " is not supported by your XML processor.",
                e);
    }
}

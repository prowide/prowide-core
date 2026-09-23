/*
 * Copyright 2006 Prowide
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
import java.util.logging.Level;
import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.validation.Schema;
import org.apache.commons.lang3.ArrayUtils;
import org.xml.sax.SAXException;
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
 * <p>
 * Since 10.3.17 the DOM, SAX and StAX parsers also restore the JDK entity size limits
 * (jdk.xml.maxGeneralEntitySizeLimit and jdk.xml.totalEntitySizeLimit) to unlimited, so large documents with many
 * escaped characters keep parsing on JDK 24+ (JDK-8343006 lowered the general entity limit to 100,000). These limit
 * properties participate in the same safeXmlUtils.ignore opt-out: listing them keeps the JDK-default limits in place.
 * The restore is applied only while DTD blocking is active, so it never widens the entity-expansion DoS surface.
 *
 * @since 8.0.5
 */
public class SafeXmlUtils {
    private static final java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(SafeXmlUtils.class.getName());

    private static final String FEATURE_IGNORE_PROPERTY = "safeXmlUtils.ignore";

    /** Xerces feature that blocks DTDs, and therefore any custom (internal or external) entity declaration. */
    private static final String DISALLOW_DOCTYPE_FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";

    /**
     * JAXP limit property bounding the size of a single general entity. JDK 24 changed its default from
     * unlimited (0) to 100,000 (JDK-8343006), which makes parsing large documents that carry many
     * predefined entity references (e.g. {@code &amp;}, {@code &lt;}, {@code &gt;} in narrative fields of
     * a camt/pacs statement) fail with JAXP00010003. The parsers built here disable DTDs, so no custom
     * entities can be declared and only the predefined entities may appear, each expanding 1:1 with no
     * amplification; restoring the unlimited value is therefore safe and keeps the parsing behavior stable
     * across JDK 11/17/21/24/25. To keep that rationale sound even when DTD blocking is switched off via
     * {@value #FEATURE_IGNORE_PROPERTY}, the restore is applied only while DTD blocking is actually active
     * (see {@link #applyEntitySizeLimits(boolean, LimitSetter)}).
     */
    private static final String MAX_GENERAL_ENTITY_SIZE_LIMIT =
            "http://www.oracle.com/xml/jaxp/properties/maxGeneralEntitySizeLimit";

    /**
     * JAXP limit property bounding the accumulated size of all entities. Must be lifted together with
     * {@link #MAX_GENERAL_ENTITY_SIZE_LIMIT}, otherwise a large document trips this one instead
     * (JAXP00010004). See {@link #MAX_GENERAL_ENTITY_SIZE_LIMIT} for the safety rationale.
     */
    private static final String TOTAL_ENTITY_SIZE_LIMIT =
            "http://www.oracle.com/xml/jaxp/properties/totalEntitySizeLimit";

    /**
     * Value meaning "no limit" for the entity size limit properties above.
     */
    private static final String UNLIMITED = "0";

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

            // restore unlimited entity size limits, only while DTD blocking is active (see javadoc)
            applyEntitySizeLimits(applyFeature(DISALLOW_DOCTYPE_FEATURE), dbf::setAttribute);

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
            feature = DISALLOW_DOCTYPE_FEATURE;
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

            // Set the features on the reader itself: the factory is already built, so changing it here
            // would not propagate to this reader. These reinforce the factory settings applied above.

            feature = DISALLOW_DOCTYPE_FEATURE;
            if (applyFeature(feature)) {
                reader.setFeature(feature, true);
            }

            // This may not be strictly required as DTDs shouldn't be allowed at all, per previous line.
            feature = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
            if (applyFeature(feature)) {
                reader.setFeature(feature, false);
            }

            feature = "http://xml.org/sax/features/external-general-entities";
            if (applyFeature(feature)) {
                reader.setFeature(feature, false);
            }

            feature = "http://xml.org/sax/features/external-parameter-entities";
            if (applyFeature(feature)) {
                reader.setFeature(feature, false);
            }

            // restore unlimited entity size limits, only while DTD blocking is active (see javadoc)
            applyEntitySizeLimits(applyFeature(DISALLOW_DOCTYPE_FEATURE), reader::setProperty);

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

        // restore unlimited entity size limits, only while DTD support is disabled (see javadoc)
        applyEntitySizeLimits(applyFeature(XMLInputFactory.SUPPORT_DTD), xif::setProperty);

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
     * Applies a single JAXP limit property. The concrete call differs per parser API
     * ({@code DocumentBuilderFactory.setAttribute}, {@code XMLReader.setProperty},
     * {@code XMLInputFactory.setProperty}), each of which may throw a checked or unchecked exception.
     */
    @FunctionalInterface
    private interface LimitSetter {
        void set(String property, String value) throws Exception;
    }

    /**
     * Restores the JAXP entity size limits to unlimited (0), reverting the tighter JDK 24+ defaults so that
     * large entity-bearing documents keep parsing across JDK versions. Honors the
     * {@value #FEATURE_IGNORE_PROPERTY} opt-out per property and tolerates processors that do not recognize
     * the properties (unsupported ones are logged at FINE and skipped).
     *
     * <p>The restore is applied only when {@code dtdBlockingActive} is true, i.e. when DTDs are actually
     * being blocked for this parser. When a deployment turns DTD blocking off through
     * {@value #FEATURE_IGNORE_PROPERTY}, the JDK entity size limits are left untouched so they still act as a
     * backstop against DTD-defined entity-expansion (billion laughs) memory DoS.
     *
     * @param dtdBlockingActive whether DTD blocking is in effect for the parser being configured
     * @param setter            the parser-specific property setter
     */
    private static void applyEntitySizeLimits(final boolean dtdBlockingActive, final LimitSetter setter) {
        if (!dtdBlockingActive) {
            return;
        }
        for (final String property : new String[] {MAX_GENERAL_ENTITY_SIZE_LIMIT, TOTAL_ENTITY_SIZE_LIMIT}) {
            if (applyFeature(property)) {
                try {
                    setter.set(property, UNLIMITED);
                } catch (final Exception e) {
                    log.log(
                            Level.FINE,
                            e,
                            () -> "XML processor does not support the entity size limit property " + property);
                }
            }
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

/*
 * Copyright 2006-2018 Prowide
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
package com.prowidesoftware.swift.io.parser;

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.model.MxId;
import com.prowidesoftware.swift.model.MxNode;
import com.prowidesoftware.swift.model.mx.AbstractMX;
import com.prowidesoftware.swift.model.mx.BusinessHeader;
import com.prowidesoftware.swift.model.mx.dic.ApplicationHeader;
import com.prowidesoftware.swift.model.mx.dic.BusinessApplicationHeaderV01;
import com.prowidesoftware.swift.utils.Lib;
import com.prowidesoftware.swift.utils.SafeXmlUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Optional;
import java.util.logging.Level;

/**
 * Basic parser for MX messages.
 *
 * <p>IMPORTANT: An MX message is conformed by a set of optional headers  and a message payload or document with the
 * actual specific MX message. The name of the envelope element that binds a Header to the message to which it applies
 * is <b>implementation/network specific</b> and not part of the scope of the parser.
 *
 * <p>This parser has three main utilities;
 * <ol>
 * <li>The first one to <em>convert the message into an MxNode tree</em>. This is a generic structured representation
 * of the complete content that can be used to get specific items by xpath. It parses the complete tree including both
 *  payload and overhead information (wrappers, if any, application header and body content).</li>
 * <li>The second utility is to <em>parse the application header</em> extract of the XML into a model object. Notice
 * the application header is mainly used to identify the specific message, and two versions are supported; the legacy
 * SWIFT {@link ApplicationHeader} and the ISO {@link BusinessApplicationHeaderV01}.</li>
 * <li>The third one is to provide convenient API to detect the specific Mx message type, to analyze the payload
 * structure and to strip the document or header portions from the XML in a lightweight and efficient way.</li>
 * </ol>
 *
 * <p>Notice that support for MX in Prowide Core is limited. Complete model and parser implementation for each MX
 * message type is implemented into subclasses of {@link AbstractMX} by
 * <a href="http://www.prowidesoftware.com/products/integrator">Prowide Integrator</a>.
 *
 * @since 7.6
 */
public class MxParser {
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MxParser.class.getName());
	/**
	 * @since 7.8.4
	 */
	public static final String HEADER_LOCALNAME = "AppHdr";
	/**
	 * @since 7.8.4
	 */
	public static final String DOCUMENT_LOCALNAME = "Document";
	
	private String buffer = null;
	private MxStructureInfo info = null;

	/**
	 * Construct a parser for a file containing a single MX message
	 * @param file the file containing a single unit of a message
	 * @since 7.7
	 * @throws IOException if an error occurs during the read of the file
	 */
	public MxParser(final File file) throws IOException {
		Validate.notNull(file);
		this.buffer = Lib.readFile(file);
	}

	/**
	 * Construct a parser for a stream containing a single MX message
	 * @param stream non null stream containing a single unit of message
	 */
	public MxParser(final InputStream stream) throws IOException {
		this.buffer = Lib.readStream(stream);
	}

	/**
	 * Creates the parser initializing its content source from the given string.
	 * @since 7.7
	 */
	public MxParser(final String message) {
		super();
		buffer = message;
	}

	/**
	 * Non-namespace aware parse.<br>
	 * Parses the complete message content into an {@link MxNode} tree structure.
	 * The parser should be initialized with a valid source.
	 *
	 * @since 7.7
	 */
	public MxNode parse() {
		Validate.notNull(buffer, "the source must be initialized");
		try {
			XMLReader xmlReader = SafeXmlUtils.reader(true, null);
			final MxNodeContentHandler contentHandler = new MxNodeContentHandler();
			xmlReader.setContentHandler(contentHandler);
			xmlReader.parse(new org.xml.sax.InputSource(new StringReader(this.buffer)));
			return contentHandler.getRootNode();
		} catch (final Exception e) {
			log.log(Level.SEVERE, "Error parsing XML", e);
		}
		return null;
	}

	/**
	 * Detects the type of header and parses it as a legacy SWIFT Application Header or ISO Business Application Header.
	 * Uses the namespace (if present) or an heuristic based on tags names.
	 * <br>
	 * By default ISO Business Application Header is expected and assumed for the AppHdr tag.
	 * 
	 * @return parsed header or null if the content cannot be parsed or the header is not present in the XML
	 */
	public BusinessHeader parseBusinessHeader() {
		final BusinessHeader bh = new BusinessHeader();
		final MxNode tree = parse();
		if (tree != null) {
			MxNode appHdr = tree.findFirstByName(HEADER_LOCALNAME);
			if (appHdr != null) {
				final String ns = appHdr.getAttribute("xmlns");
				if ((ns != null && ns.equals(BusinessHeader.NAMESPACE_AH)) || (appHdr.findFirstByName("From") != null)) {
					bh.setApplicationHeader(parseApplicationHeader(tree));
				} else {
					bh.setBusinessApplicationHeader(parseBusinessApplicationHeaderV01(tree));
				}
				return bh;
			}
		}
		return null;
	}
	
	/**
	 * Parse the business header from an XML Element node
	 * @see #parseBusinessHeader()
	 * @since 7.8
	 */
	public static BusinessHeader parseBusinessHeader(final org.w3c.dom.Element e) {
		org.w3c.dom.ls.DOMImplementationLS lsImpl = (org.w3c.dom.ls.DOMImplementationLS) e.getOwnerDocument().getImplementation().getFeature("LS", "3.0");
		org.w3c.dom.ls.LSSerializer serializer = lsImpl.createLSSerializer();
		serializer.getDomConfig().setParameter("xml-declaration", false);
		String xml = serializer.writeToString(e);
		MxParser parser = new MxParser(xml);
		return parser.parseBusinessHeader();
	}

	/**
	 * Parses the application header (SWIFT legacy) from the internal message source.
	 * <br>
	 * @see #parseBusinessHeader()
	 * @return parsed header or null if the content cannot be parsed or the header is not present in the XML
	 */
	public ApplicationHeader parseApplicationHeader() {
		return parseApplicationHeader(parse());
	}
	
	/**
	 * Parses the application header (SWIFT legacy) from the parameter node.
	 * <br>
	 * @see #parseBusinessHeader()
	 * @return parsed header or null if the content cannot be parsed or the header is not present in the XML
	 */
	public static ApplicationHeader parseApplicationHeader(final MxNode tree) {
		return MxBusinessHeaderParser.parseApplicationHeader(tree);
	}

	/**
	 * Parses the application header (ISO) from the internal message source.
	 * <br>
	 * @see #parseBusinessHeader()
	 * @return parsed header or null if the content cannot be parsed or the header is not present in the XML
	 */
	public BusinessApplicationHeaderV01 parseBusinessApplicationHeaderV01() {
		return parseBusinessApplicationHeaderV01(parse());
	}
	
	/**
	 * Parses the application header (ISO) from the parameter node.
	 * <br>
	 * @see #parseBusinessHeader()
	 * @return parsed header or null if the content cannot be parsed or the header is not present in the XML
	 */
	public static BusinessApplicationHeaderV01 parseBusinessApplicationHeaderV01(final MxNode tree) {
		return MxBusinessHeaderParser.parseBusinessApplicationHeaderV01(tree);
	}

	/**
	 * Takes an xml with an MX message and detects the specific message type
	 * parsing just the namespace from the Document element. If the Document
	 * element is not present, or without the namespace or if the namespace url
	 * contains invalid content it will return null.
	 *
     * <p>
	 * Example of a recognizable Document element:<br>
	 * &lt;Doc:Document xmlns:Doc="urn:swift:xsd:camt.003.001.04" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"&gt;
	 *
     * <p>
	 * The implementation is intended to be lightweight and efficient, based on {@link javax.xml.stream.XMLStreamReader} 
	 *
	 * @return id with the detected MX message type or null if it cannot be determined.
	 * @since 7.7
	 */
	public MxId detectMessage() {
		if (StringUtils.isBlank(this.buffer)) {
			log.log(Level.SEVERE, "cannot detect message from null or empty content");
			return null;
		}
		final javax.xml.stream.XMLInputFactory xif = SafeXmlUtils.inputFactory();
		try {
			final javax.xml.stream.XMLStreamReader reader = xif.createXMLStreamReader(new StringReader(this.buffer));
			while (reader.hasNext()) {
				int event = reader.next();
				if (javax.xml.stream.XMLStreamConstants.START_ELEMENT == event && reader.getLocalName().equals(DOCUMENT_LOCALNAME)) {
					if (reader.getNamespaceCount() > 0) {
						//log.finest("ELEMENT START: " + reader.getLocalName() + " , namespace count is: " + reader.getNamespaceCount());
						for (int nsIndex = 0; nsIndex < reader.getNamespaceCount(); nsIndex++) {
							final String nsPrefix = StringUtils.trimToNull(reader.getNamespacePrefix(nsIndex));
							final String elementPrefix = StringUtils.trimToNull(reader.getPrefix());
							if (StringUtils.equals(nsPrefix, elementPrefix)) {
								String nsId = reader.getNamespaceURI(nsIndex);
								//log.finest("\tNamepsace prefix: " + nsPrefix + " associated with URI " + nsId);
								return new MxId(nsId);
							}
						}
					}
				}
			}
		} catch (final Exception e) {
			log.log(Level.SEVERE, "error while detecting message", e);
		}
		return null;
	}
	
	/**
	 * @deprecated use {@link #analyzeMessage()} instead
	 * @since 7.8.4
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public MxStructureInfo analizeMessage() {
		return analyzeMessage();
	}

	/**
	 * Convenient API to get structure information from an MX message.
	 * <p>This can be helpful when the actual content of an XML is unknown and 
	 * some preprocessing of the XML must be done in order to parse or
	 * validate its content properly.
	 * <p>The implementation is intended to be lightweight and efficient, based on {@link javax.xml.stream.XMLStreamReader}
	 * <p>If the message contains more than one Document element, the first one will be picked. The same applies for
	 * the header, only the first AppHdr will be picked
	 *
	 * @since 7.10.3
	 */
	public MxStructureInfo analyzeMessage() {
		if (this.info != null) {
			return this.info;
		}
		this.info = new MxStructureInfo();
		if (StringUtils.isBlank(this.buffer)) {
			log.log(Level.WARNING, "cannot analyze message from null or empty content");
			return this.info;
		}
		final javax.xml.stream.XMLInputFactory xif = SafeXmlUtils.inputFactory();
		try {
			final javax.xml.stream.XMLStreamReader reader = xif.createXMLStreamReader(new StringReader(this.buffer));
			boolean first = true;
			while (reader.hasNext()) {
				int event = reader.next();
				if (javax.xml.stream.XMLStreamConstants.START_ELEMENT == event) {
					if (!this.info.containsDocument && reader.getLocalName().equals(DOCUMENT_LOCALNAME)) {
						this.info.containsDocument = true;
						this.info.documentNamespace = readNamespace(reader);
						this.info.documentPrefix = StringUtils.trimToNull(reader.getPrefix());
					} else if (!this.info.containsHeader && reader.getLocalName().equals(HEADER_LOCALNAME)) {
						this.info.containsHeader = true;
						this.info.headerNamespace = readNamespace(reader);
						this.info.headerPrefix = StringUtils.trimToNull(reader.getPrefix());
					} else if (first) {
						this.info.containsWrapper = true;
					}
					first = false;
				}
			}
		} catch (final Exception e) {
			log.log(Level.SEVERE, "error while analyzing message: "+ e.getMessage());
			info.exception = e;
		}
		return this.info;
	}

	/**
	 * Gets the namespace, if any, from current position in the parameter reader
	 * @since 7.8.4
	 */
	private String readNamespace(final javax.xml.stream.XMLStreamReader reader) {
		if (reader.getNamespaceCount() > 0) {
			//log.finest("ELEMENT START: " + reader.getLocalName() + " , namespace count is: " + reader.getNamespaceCount());
			for (int nsIndex = 0; nsIndex < reader.getNamespaceCount(); nsIndex++) {
				final String nsPrefix = StringUtils.trimToNull(reader.getNamespacePrefix(nsIndex));
				final String elementPrefix = StringUtils.trimToNull(reader.getPrefix());
				if (StringUtils.equals(nsPrefix, elementPrefix)) {
					//log.finest("\tNamepsace prefix: " + nsPrefix + " associated with URI " + nsId);
					return reader.getNamespaceURI(nsIndex);
				}
			}
		}
		return null;
	}
		
	/**
	 * Helper bean used by {@link MxParser#analyzeMessage()} to return 
	 * structure information from an MX message
	 * 
	 * @since 7.8.4
	 */
	public class MxStructureInfo {
		private boolean containsWrapper = false;
		private boolean containsHeader = false;
		private boolean containsDocument = false;
		private String documentNamespace = null;
		private String documentPrefix = null;
		private String headerNamespace = null;
		private String headerPrefix = null;
		private Exception exception = null;
		
		public boolean containsWrapper() {
			return containsWrapper;
		}

		public boolean containsHeader() {
			return containsHeader;
		}

		public boolean containsDocument() {
			return containsDocument;
		}

		public String getDocumentNamespace() {
			return documentNamespace;
		}

		public String getDocumentPrefix() {
			return documentPrefix;
		}

		public String getHeaderNamespace() {
			return headerNamespace;
		}

		public String getHeaderPrefix() {
			return headerPrefix;
		}

		public Exception getException() {
			return exception;
		}

		/**
		 * @return true if the message contains a header and it is a legacy SWIFT ahV10 header, false if it is not and
		 * empty if the message has no header to check
		 * @since 8.0.5
		 */
		public Optional<Boolean> containsLegacyHeader() {
			if (containsHeader) {
				return Optional.of(StringUtils.contains(this.headerNamespace, "ahV10"));
			} else {
				return Optional.empty();
			}
		}

		@Override
		public String toString() {
			return "MxStructureInfo [containsWrapper=" + containsWrapper + ", containsHeader=" + containsHeader
					+ ", containsDocument=" + containsDocument + ", documentNamespace=" + documentNamespace
					+ ", documentPrefix=" + documentPrefix + ", headerNamespace=" + headerNamespace + ", headerPrefix="
					+ headerPrefix + "]";
		}
	}
	
	/**
	 * Distinguished Name structure: cn=name,ou=payment,o=bank,o=swift
	 * <br>
	 * Example: o=spxainjj,o=swift
	 * 
	 * @param dn the DN element content
	 * @return returns capitalized "bank", in the example SPXAINJJ
	 */
	public static String getBICFromDN(final String dn) {
		for (String s : StringUtils.split(dn, ",")) {
			if (StringUtils.startsWith(s, "o=") && !StringUtils.equals(s, "o=swift")) {
				return StringUtils.upperCase(StringUtils.substringAfter(s, "o="));
			}
			/*
			else if (StringUtils.startsWith(s, "ou=") && !StringUtils.equals(s, "ou=swift")) {
				return StringUtils.upperCase(StringUtils.substringAfter(s, "ou="));
			}
			*/
		}
		return null;
	}
	
	/**
	 * Helper API to strip Document portion of message XML.
	 * 
	 * <p>This API is convenient when only the Document element of an MX message
	 * is needed and the wrapper/payload structure is unknown.
	 *
	 * <p>This implementation is intended to be lightweight and efficient so it actually
	 * does a simple substring operation on the XML using information provided
	 * by the result of {@link #analyzeMessage()}. The XML is not converted into DOM.
	 * <br >
	 * If the message contains more than one Document element the expected result is as follows:
	 * <ul>
	 * <li>If the documents are nested (this can happen for example when an additional MX message
	 * is provided within a supplementary data element within the main MX) then the outermost Document
	 * will be returned.</li>
	 * <li>If the documents are not-nested (weird situation) the result might be not well-formed</li>
	 * </ul>
	 *  
	 * @since 7.8.4
	 * @return XML with Document element of the Mx message or null if message is blank or invalid
	 */
	public String stripDocument() {
		analyzeMessage();
		if (this.info.containsDocument) {
			final String tag = this.info.getDocumentPrefix() != null ? this.info.getDocumentPrefix() + ":" + MxParser.DOCUMENT_LOCALNAME : MxParser.DOCUMENT_LOCALNAME;
			int beginIndex = this.buffer.indexOf("<" + tag);
			int endIndex = this.buffer.lastIndexOf("</" + tag);
			if (beginIndex >= 0 && endIndex >= 0) {
				return this.buffer.substring(beginIndex, endIndex) + "</" + tag + ">";
			}
		}
		return null;
	}
	
	/* alternative future implementation using DOM instead of MxNode
	public String stripDocument1() {
		try {
		    javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		    org.w3c.dom.Document doc = dbf.newDocumentBuilder().parse(new org.xml.sax.InputSource(new StringReader(this.buffer)));
		    javax.xml.xpath.XPath xPath = javax.xml.xpath.XPathFactory.newInstance().newXPath();
		    org.w3c.dom.Node result = (org.w3c.dom.Node)xPath.evaluate("Document", doc, javax.xml.xpath.XPathConstants.NODE);
		    return nodeToString(result);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private static String nodeToString(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {
	    StringWriter buf = new StringWriter();
	    javax.xml.transform.Transformer xform = SafeXmlUtils.transformer();
	    xform.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes");
	    xform.transform(new javax.xml.transform.dom.DOMSource(node), new javax.xml.transform.stream.StreamResult(buf));
	    return(buf.toString());
	}
	*/
	
	/**
	 * Helper API to strip AppHdr portion of message XML.
	 * 
	 * <p>This API is convenient when only the header element of an MX message
	 * is needed and the wrapper/payload structure is unknown.
	 * 
	 * <p>To gather the header already parsed into objects see {@link #parseBusinessHeader()}
	 * 
	 * <p>This implementation is intended to be lightweight and efficient so it actually
	 * does a simple substring operation on the XML using information provided
	 * by the result of {@link #analyzeMessage()}. The XML is not converted into DOM.
	 * <br >
	 * If the message contains more than one AppHdr element the expected result is as follows:
	 * <ul>
	 * <li>If the headers are not nested, the first one will be returned.</li>
	 * <li>If the headers are nested (weird situation) the result might be not well-formed</li>
	 * </ul>
	 * 
	 * @since 7.8.4
	 * @return XML with AppHdr element of the Mx message or null if not found
	 */
	public String stripHeader() {
		analyzeMessage();
		if (this.info.containsHeader()) {
			final String tag = this.info.getHeaderPrefix() != null? this.info.getHeaderPrefix() + ":" + MxParser.HEADER_LOCALNAME : MxParser.HEADER_LOCALNAME;
			int beginIndex = this.buffer.indexOf("<" + tag);
			int endIndex = this.buffer.indexOf("</" + tag);
			if (beginIndex >=0 && endIndex >= 0) {
				return this.buffer.substring(beginIndex, endIndex) + "</"+tag+">";
			}
		}
		return null;
	}
}

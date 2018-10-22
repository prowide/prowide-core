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

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.MxNode;

/**
 * Non-public content handler used by {@link MxParser} to parse MX message into {@link MxNode} tree
 * <br >
 * Non Namespace Aware. 
 * The namespace uri, if present, is stored as attribute named "xmlns" in the root node.
 */
/*
 * TODO sebastian oct 2015
 * Esto debiera soportar namespaces, ahroa se lo guarda como attr porque se usa para detectar tipo de header.
 */
final class MxNodeContentHandler implements org.xml.sax.ContentHandler {
	private static final transient Logger log = Logger.getLogger(MxNodeContentHandler.class.getName());

	private MxNode currentNode;
	private MxNode rootNode;

	MxNode getRootNode() {
		return this.rootNode;
	}

	public void setDocumentLocator(final org.xml.sax.Locator locator) {
	}

	public void startDocument() throws org.xml.sax.SAXException {
		this.currentNode = null;
	}

	public void endDocument() throws org.xml.sax.SAXException {
	}

	public void startPrefixMapping(final String prefix, final String uri) throws org.xml.sax.SAXException {
	}

	public void endPrefixMapping(final String prefix) throws org.xml.sax.SAXException {
	}

	public void startElement(final String uri, final String localName, final String qName, final org.xml.sax.Attributes atts) throws org.xml.sax.SAXException {
		if (log.isLoggable(Level.FINEST)) {
			log.finest("uri: "+uri+"\nlocalName: "+localName+"\nqName: "+qName+
					(atts == null ? "" :
						"\natts("+atts.getLength()+"): ..."
							)
					);
		}
		final MxNode node = new MxNode(currentNode, localName);
		if (atts != null) {
			for (int i = 0; i < atts.getLength(); i++) {
				node.addAttribute(atts.getLocalName(i), atts.getValue(i));
			}
		}
		/*
		 * set uri as xmlns attribute for the first node in namespace
		 */
		if (uri != null && (node.getParent() == null || !StringUtils.equals(node.getParent().getAttribute("xmlns"), uri))) {
			node.addAttribute("xmlns", uri);
		}
		currentNode = node;
	}

	public void endElement(final String uri, final String localName, final String qName) throws org.xml.sax.SAXException {
		log.finest("end: " + localName);
		if (currentNode.getParent() == null) {
			rootNode = currentNode;
		}
		// shouln't overlap
		// TODO merge review
		currentNode = currentNode.getParent();
	}

	public void characters(final char[] ch, final int start, final int length) throws org.xml.sax.SAXException {
		final String v = new String(ch, start, length);
		log.finest("characters: " + v);
		// TODO this may need buffering and be pushed in end element, check with big data and impl specs
		currentNode.setValue(v);
	}

	public void ignorableWhitespace(final char[] ch, final int start, final int length) throws org.xml.sax.SAXException {
	}

	public void processingInstruction(final String target, final String data) throws org.xml.sax.SAXException {
		/*
		 *  2015.03 miguel
		 *  seria muy intersante soportar custom processing instructions aca
		 */
	}

	public void skippedEntity(final String name) throws org.xml.sax.SAXException {
		log.finer("skippedEntity: " + name);
	}
}

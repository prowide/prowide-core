/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
package com.prowidesoftware.swift.io.parser;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;

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

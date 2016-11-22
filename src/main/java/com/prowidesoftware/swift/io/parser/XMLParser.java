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

import java.io.ByteArrayInputStream;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.SwiftBlock2Output;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftBlockUser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.UnparsedTextList;
import com.prowidesoftware.swift.model.field.Field;

/**
 * This is the main parser for WIFE's XML internal representation.<br>
 * The supported XML format is consider <i>internal</i> because it is an ad-hoc
 * defined XML structure for Swift messages, so it's not the SWIFT XML
 * Standard for FIN Messages.<br>
 * <br>
 *
 * This implementation should be used by calling some of the the conversion
 * services.
 *
 * @see com.prowidesoftware.swift.io.IConversionService
 * @since 5.0
 * @author www.prowidesoftware.com
 */
public class XMLParser {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(XMLParser.class.getName());

	/**
	 * Given a String containing a message in its WIFE internal XML
	 * representation, returns a SwiftMessage object.
	 * If there is any error during conversion this method returns <code>null</code>
	 * @param xml the string containing the XML to parse
	 * @return the XML parsed into a SwiftMessage object
	 *
	 * @see com.prowidesoftware.swift.io.IConversionService#getMessageFromXML(java.lang.String)
	 */
	public SwiftMessage parse(final String xml) {
		Validate.notNull(xml);
		try {
			final DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			final Document doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
			return createMessage(doc);
		} catch (final Exception e) {
			log.log(Level.WARNING, "Error parsing XML", e);
			return null;
		}
	}

	/**
	 * Helper method for XML representation parsing.<br>
	 *
	 * @param doc
	 *            Document object containing a message in XML format
	 * @return SwiftMessage object populated with the given XML message data
	 */
	private SwiftMessage createMessage(final Document doc) {
		final NodeList messageNL = doc.getElementsByTagName("message");

		if (messageNL.getLength() == 1) {
			final Node message = messageNL.item(0);
			final SwiftMessage m = new SwiftMessage(false);

			final NodeList blocksNL = message.getChildNodes();
			if (log.isLoggable(Level.FINE)) {
				log.fine("blocks in message: " + blocksNL.getLength());
			}

			for (int i = 0; i < blocksNL.getLength(); i++) {
				final Node blockNode = blocksNL.item(i);
				if (log.isLoggable(Level.FINE)) {
					log.fine("evaluating node " + blockNode.getNodeName());
				}
				if (blockNode.getNodeType()==Node.ELEMENT_NODE) {
					final String blockName = blockNode.getNodeName();

					if (blockName.equalsIgnoreCase("block1")) {
						m.setBlock1(getBlock1FromNode(blockNode));
					} else if (blockName.equalsIgnoreCase("block2")) {
						m.setBlock2(getBlock2FromNode(blockNode));
					} else if (blockName.equalsIgnoreCase("unparsedtexts")) {
						// unparsed texts at <message> level
						m.setUnparsedTexts(getUnparsedTextsFromNode(blockNode));
					} else {
						// blocks 3, 4, 5 or user blocks
						m.addBlock(getTagListBlockFromNode(blockNode));
					}
				}
			} // end block list iteration
			return m;
		} else {
			throw new IllegalArgumentException("<message> tag not found");
		}
	}

	/**
	 * Helper method for XML representation parsing.<br>
	 * Given the &lt;block1&gt; node in the XML tree, returns the SwiftBlock1 object.
	 *
	 * @param blockNode Node object of the &lt;block1&gt; tag in the XML message
	 * @return SwiftBlock1 object populated with the given portion of the XML message
	 */
	private SwiftBlock1 getBlock1FromNode(final Node blockNode) {
		final NodeList fields = blockNode.getChildNodes();
		if (log.isLoggable(Level.FINE)) {
			log.fine(fields.getLength() + " children in <block1>");
		}

		final SwiftBlock1 b1 = new SwiftBlock1();

		for (int i = 0; i < fields.getLength(); i++) {
			final Node n = fields.item(i);
			if ("APPLICATIONID".equalsIgnoreCase(n.getNodeName())) {
				b1.setApplicationId(getText(n));
			} else if ("SERVICEID".equalsIgnoreCase(n.getNodeName())) {
				b1.setServiceId(getText(n));
			} else if ("LOGICALTERMINAL".equalsIgnoreCase(n.getNodeName())) {
				b1.setLogicalTerminal(getText(n));
			} else if ("SESSIONNUMBER".equalsIgnoreCase(n.getNodeName())) {
				b1.setSessionNumber(getText(n));
			} else if ("SEQUENCENUMBER".equalsIgnoreCase(n.getNodeName())) {
				b1.setSequenceNumber(getText(n));
			} else if ("unparsedTexts".equalsIgnoreCase(n.getNodeName())) {
				b1.setUnparsedTexts(getUnparsedTextsFromNode(n));
			}
		}

		return b1;
	}

	private String getText(final Node n) {
		String text = null;
		final Node c = n.getFirstChild();
		if (c != null) {
			if (c.getNodeType() == Node.TEXT_NODE) {
				text = c.getNodeValue().trim();
			} else {
				log.warning("Node is not TEXT_NODE: "+c);
			}
		}
		return text;
	}

	/**
	 * Helper method for XML representation parsing.<br>
	 * Given the &lt;block2&gt; node in the XML tree, returns the SwiftBlock1 object.
	 * The method checks for the "type" attribute in the &lt;block2&gt; tag and
	 * returns a SwiftBlock2Input or SwiftBlock2Output.
	 *
	 * @param blockNode Node object of the &lt;block2&gt; tag in the XML message
	 * @return SwiftBlock2 object populated with the given portion of the XML message
	 * @see #getBlock2InputFromNode(Node)
	 * @see #getBlock2OutputFromNode(Node)
	 */
	private SwiftBlock2 getBlock2FromNode(final Node blockNode) {
		final String type = getNodeAttribute(blockNode, "type");

		if (type == null) {
			log.severe("atrribute 'type' was expected but not found at <block2> xml tag");
			return null;
		} else if (type.equals("input")) {
			return getBlock2InputFromNode(blockNode);
		} else if (type.equals("output")) {
			return getBlock2OutputFromNode(blockNode);
		} else {
			log.severe("expected 'input' or 'output' value for 'type' atribute at <block2> xml tag, and found: " + type);
			return null;
		}
	}

	/**
	 * Helper method for XML representation parsing.<br>
	 * Given the &lt;block2 type="input"&gt; node in the XML tree, returns the
	 * SwiftBlock2Input object.
	 *
	 * @param blockNode Node object of the &lt;block2&gt; tag in the XML message
	 * @return SwiftBlock2Input object populated with the given portion of the XML message
	 */
	private SwiftBlock2Input getBlock2InputFromNode(final Node blockNode) {
		final NodeList fields = blockNode.getChildNodes();
		if (log.isLoggable(Level.FINE)) {
			log.fine(fields.getLength() + " childrens in <block2 type=\"input\">");
		}

		final SwiftBlock2Input b2 = new SwiftBlock2Input();

		for (int i = 0; i < fields.getLength(); i++) {
			final Node n = fields.item(i);
			if ("MESSAGETYPE".equalsIgnoreCase(n.getNodeName())) {
				b2.setMessageType(getText(n));
			} else if ("RECEIVERADDRESS".equalsIgnoreCase(n.getNodeName())) {
				b2.setReceiverAddress(getText(n));
			} else if ("MESSAGEPRIORITY".equalsIgnoreCase(n.getNodeName())) {
				b2.setMessagePriority(getText(n));
			} else if ("DELIVERYMONITORING".equalsIgnoreCase(n.getNodeName())) {
				b2.setDeliveryMonitoring(getText(n));
			} else if ("OBSOLESCENCEPERIOD".equalsIgnoreCase(n.getNodeName())) {
				b2.setObsolescencePeriod(getText(n));
			} else if ("unparsedTexts".equalsIgnoreCase(n.getNodeName())) {
				b2.setUnparsedTexts(getUnparsedTextsFromNode(n));
			}
		}

		return b2;
	}

	/**
	 * Helper method for XML representation parsing.<br>
	 * Given the &lt;block2 type="output" node in the XML tree, returns the
	 * SwiftBlock2Output object.
	 *
	 * @param blockNode Node object of the &lt;block2&gt; tag in the XML message
	 * @return SwiftBlock2Output object populated with the given portion of the XML message
	 */
	private SwiftBlock2Output getBlock2OutputFromNode(final Node blockNode) {
		final NodeList fields = blockNode.getChildNodes();
		if (log.isLoggable(Level.FINE)) {
			log.fine(fields.getLength() + " childrens in <block2 type=\"output\">");
		}

		final SwiftBlock2Output b2 = new SwiftBlock2Output();

		for (int i = 0; i < fields.getLength(); i++) {
			final Node n = fields.item(i);
			if ("MESSAGETYPE".equalsIgnoreCase(n.getNodeName())) {
				b2.setMessageType(getText(n));
			} else if ("SENDERINPUTTIME".equalsIgnoreCase(n.getNodeName())) {
				b2.setSenderInputTime(getText(n));
			} else if ("MIRDATE".equalsIgnoreCase(n.getNodeName())) {
				b2.setMIRDate(getText(n));
			} else if ("MIRLOGICALTERMINAL".equalsIgnoreCase(n.getNodeName())) {
				b2.setMIRLogicalTerminal(getText(n));
			} else if ("MIRSESSIONNUMBER".equalsIgnoreCase(n.getNodeName())) {
				b2.setMIRSessionNumber(getText(n));
			} else if ("MIRSEQUENCENUMBER".equalsIgnoreCase(n.getNodeName())) {
				b2.setMIRSequenceNumber(getText(n));
			} else if ("RECEIVEROUTPUTDATE".equalsIgnoreCase(n.getNodeName())) {
				b2.setReceiverOutputDate(getText(n));
			} else if ("RECEIVEROUTPUTTIME".equalsIgnoreCase(n.getNodeName())) {
				b2.setReceiverOutputTime(getText(n));
			} else if ("MESSAGEPRIORITY".equalsIgnoreCase(n.getNodeName())) {
				b2.setMessagePriority(getText(n));
			} else if ("unparsedTexts".equalsIgnoreCase(n.getNodeName())) {
				b2.setUnparsedTexts(getUnparsedTextsFromNode(n));
			}
		}

		return b2;
	}

	/**
	 * Helper method for XML representation parsing.<br>
	 * Given the &lt;block3&gt;, &lt;block4&gt;, &lt;block5&gt; or &lt;block&gt; (user block) node in
	 * the XML tree, returns the corresponding SwiftTagListBlock object
	 * populated with the given portion of the XML message.
	 *
	 * @param blockNode Node object of the &lt;block3&gt;, &lt;block4&gt;, &lt;block5&gt; or &lt;block&gt; tag in the XML message
	 * @return SwiftTagListBlock object populated with the given portion of the XML message
	 */
	private SwiftTagListBlock getTagListBlockFromNode(final Node blockNode) {
		final String blockName = blockNode.getNodeName();
		SwiftTagListBlock b = null;
		if (blockName.equalsIgnoreCase("block3")) {
			b = new SwiftBlock3();
		} else if (blockName.equalsIgnoreCase("block4")) {
			b = new SwiftBlock4();
		} else if (blockName.equalsIgnoreCase("block5")) {
			b = new SwiftBlock5();
		} else if (blockName.equalsIgnoreCase("block")) {
			final String name = getNodeAttribute(blockNode, "name");
			if (name != null) {
				b = new SwiftBlockUser(name);
			} else {
				b = new SwiftBlockUser();
			}
		} else {
			return null;
		}

		final NodeList fields = blockNode.getChildNodes();
		if (log.isLoggable(Level.FINE)) {
			log.fine(fields.getLength() + " children in tag list " + blockName);
		}

		for (int j = 0; j < fields.getLength(); j++) {
			final Node t = fields.item(j);
			if ("tag".equalsIgnoreCase(t.getNodeName())) {
				final Tag tag = getTag(t);
				b.append(tag);
			} else if ("field".equalsIgnoreCase(t.getNodeName())) {
					final Field field = getField(t);
					b.append(field);
			} else if ("unparsedtexts".equalsIgnoreCase(t.getNodeName())) {
				b.setUnparsedTexts(getUnparsedTextsFromNode(t));
			}
		}

		return b;
	}

	/**
	 * Helper method for XML representation parsing.<br>
	 * Parses the given &lt;tag&gt; Node and returns a Tag object containing data from
	 * the expected &lt;name&gt; and &lt;value&gt; tags. If name or value are not found as
	 * children of the given node, the Tag object is returned with empty values.
	 *
	 * @param t the XML node to parse for name-value pair
	 * @return a Tag object containing the name and value of the given XML node.
	 */
	private Tag getTag(final Node t) {
		final Tag tag = new Tag();
		final NodeList children = t.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			final Node n = children.item(i);
			
			/*
			 * soportar ambas versiones de xml automagicamente
			 */
			
			if ("name".equalsIgnoreCase(n.getNodeName())) {
				tag.setName(getText(n));
			}
			if ("value".equalsIgnoreCase(n.getNodeName())) {
				String text = getText(n);
				//normalize line feeds (DOM parser removes carriage return characters from original XML file)
				text = StringUtils.replace(text, "\n", FINWriterVisitor.SWIFT_EOL);
				tag.setValue(text);
			} else if ("unparsedtexts".equalsIgnoreCase(n.getNodeName())) {
				tag.setUnparsedTexts(getUnparsedTextsFromNode(n));
			}
		}
		return tag;
	}
	
	/**
	 * Helper method for XML representation parsing.<br>
	 * Parses the given &gt;field&lt; Node and returns a Field object containing data from
	 * the expected &lt;name&gt; and &lt;component&gt; inner elements. 
	 * If &lt;name&gt; element is not set it will return null. Otherwise it will return a Field
	 * instance filled with content from &lt;component&gt; elements.
	 *
	 * @param t the XML node to parse for name-value pair
	 * @return a Field object or null if "name" element is not present
	 */
	private Field getField(final Node t) {
		final NodeList children = t.getChildNodes();
		String name = null;
		for (int i = 0; i < children.getLength(); i++) {
			final Node n = children.item(i);
			if ("name".equalsIgnoreCase(n.getNodeName())) {
				name = getText(n);
				break;
			}
		}
		if (name != null) {
			Field field = Field.getField(name, null);
			for (int i = 0; i < children.getLength(); i++) {
				final Node n = children.item(i);
				if ("component".equalsIgnoreCase(n.getNodeName())) {
					final String number = getNodeAttribute(n, "number");
					if (StringUtils.isNumeric(number)) {
						String text = getText(n);
						//normalize line feeds (DOM parser removes carriage return characters from original XML file)
						text = StringUtils.replace(text, "\n", FINWriterVisitor.SWIFT_EOL);
						field.setComponent(Integer.valueOf(number), text);
					}
				}
			}
			return field;
		}
		return null;
	}

	/**
	 * Helper method for XML representation parsing.<br>
	 * Given the &lt;unparsedtexts&gt; node in the XML tree, returns an
	 * UnparsedTextList object populated with the contents of the <text> child
	 * tags of &lt;unparsedtexts&gt;.
	 *
	 * @param blockNode Node object of the &lt;unparsedtexts&gt; tag in the XML message
	 * @return UnparsedTextList object populated with the given &lt;text&gt; tags content of the &lt;unparsedtexts&gt;
	 */
	private UnparsedTextList getUnparsedTextsFromNode(final Node blockNode) {
		final UnparsedTextList unparsedTexts = new UnparsedTextList();

		final NodeList texts = blockNode.getChildNodes();
		if (log.isLoggable(Level.FINE)) {
			log.fine(texts.getLength() + " children in <unparsedtexts>");
		}
		for (int j = 0; j < texts.getLength(); j++) {
			final Node t = texts.item(j);
			if ("text".equalsIgnoreCase(t.getNodeName())) {
				unparsedTexts.addText(getText(t));
			}
		}
		return unparsedTexts;
	}

	/**
	 * Helper method for XML representation parsing.<br>
	 * Gets the value of an expected attribute in a Node.
	 *
	 * @param n Node to analyze to find the attribute
	 * @param attributeName the attribute name expected in the analyzed Node n
	 * @return the value of the attribute expected, or null if the attribute was not found
	 */
	private String getNodeAttribute(final Node n, final String attributeName) {
		final Node attr = n.getAttributes().getNamedItem(attributeName);
		if ((attr == null) || !attr.getNodeName().equals(attributeName)) {
			return null;
		} else {
			return attr.getNodeValue();
		}
	}
}

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
package com.prowidesoftware.swift.model.mx;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * XMl writer for MX model classes.
 * 
 * @since 7.8
 */
public final class XmlEventWriter implements XMLEventWriter {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(XmlEventWriter.class.getName());
	private Writer out;
	private final StringBuilder indent = new StringBuilder();
	private StartElement delayedStart = null;
	private boolean startTagIncomplete = false;
	private int startElementCount;
	private String defaultPrefix = null;
	private Map<String, String> peferredPrefixes;
	private boolean includeXMLDeclaration = true;
	private String rootElement = null;
	
	/**
	 * @param baos output buffer to write
	 * @param defaultPrefix optional prefix (empty by default) to used for all elements that are not binded to a specific prefix
	 * @param includeXMLDeclaration true to include the XML declaration (true by default)
	 * @param rootElement local name of the root element of the XML fragment to create, used to declare namespace
	 * @see #setPeferredPrefixes(Map)
	 */
	public XmlEventWriter(Writer baos, final String defaultPrefix, boolean includeXMLDeclaration, final String rootElement) {
		this.out = baos;
		this.startElementCount = 0;
		this.defaultPrefix = defaultPrefix;
		this.includeXMLDeclaration = includeXMLDeclaration;
		this.rootElement = rootElement;
	}

	public void add(final XMLEvent event) throws XMLStreamException {
		if (event != null) {
			try {
				final int type = event.getEventType();
				switch (type) {
				case XMLEvent.START_DOCUMENT:
					if (this.includeXMLDeclaration) {
						out.write("<?xml version=\"1.0\" encoding=\"" + ((StartDocument) event).getCharacterEncodingScheme() + "\"?>");
					} else {
						log.finest("skipping xml declaration");
					}
					break;
					
				case XMLEvent.START_ELEMENT:
					this.startElementCount++;
					closeStartTagIfNeeded();
					indent.append(' ');
					final StartElement se = event.asStartElement();
					/*
					 * the startElementyCount below fixes the bug related to not opening nested Document inside xs:any
					 */
					if (StringUtils.equals(se.getName().getLocalPart(), this.rootElement) && this.startElementCount==1) { 
						delayedStart = se;
						log.finest("local part is Document, initializing delayed start, startElementCount="+this.startElementCount);
					} else {
						out.write("\n" + indent + "<" + prefix(se.getName()) + se.getName().getLocalPart());
						/* 
						 * to support attributes instead of closing here we set a flag and close this later
						 */
						startTagIncomplete = true;
					}
					break;
					
				case XMLEvent.NAMESPACE:
					final Namespace ne = (Namespace) event;
					StringBuilder sb = new StringBuilder();
					if (delayedStart != null) {
						sb.append("\n" + indent + "<" + prefix(ne.getName()) + delayedStart.getName().getLocalPart());
						delayedStart = null;
					}
					sb.append(namespace(ne));
					out.write(sb.toString());
					startTagIncomplete = true;
					break;
					
				case XMLEvent.CHARACTERS:
					closeStartTagIfNeeded();
					final Characters ce = event.asCharacters();
					final char[] arr = ce.getData().toCharArray();
					out.write(escape(arr));
					break;
					
				case XMLEvent.END_ELEMENT:
					closeStartTagIfNeeded();
					indent.deleteCharAt(0);
					final EndElement ee = event.asEndElement();
					out.write("</" + prefix(ee.getName()) + ee.getName().getLocalPart() + ">\n" + indent);
					break;
					
				case XMLEvent.END_DOCUMENT:
					closeStartTagIfNeeded();
					/*  
					 * No need to do anything while writing to a string 
					 */
					break;
					
				case XMLEvent.ATTRIBUTE:
					final Attribute a = (Attribute) event;
					out.write(" " + a.getName() + "=\"" + a.getValue() + "\" ");
					break;
					
				default:
					log.finer("PW Unhandled XMLEvent " + ToStringBuilder.reflectionToString(event));
					break;
				}
			} catch (IOException e) {
				log.severe("PW I/O error: " + e.getMessage());
				log.log(Level.FINER, "PW I/O error: ", e);
				throw new XMLStreamException(e);
			}
		}
	}

	/**
	 * Given a namespace event, returns the xmlns declaration with proper prefix
	 * from the preferred prefix parameter map or default prefix
	 */
	private String namespace(final Namespace ne) {
		StringBuilder sb = new StringBuilder(" xmlns");
		String prefix = null;
		if (this.peferredPrefixes != null) {
			prefix = this.peferredPrefixes.get(ne.getValue());
		}
		if (prefix == null && this.defaultPrefix != null) {
			prefix = this.defaultPrefix;
		}
		if (prefix != null) {
			sb.append(":").append(prefix);
		}
		sb.append("=\"").append(ne.getValue()).append("\"");
		return sb.toString();
	}

	/**
	 * Inplace escape por xml
	 * repa
	 * @param arr
	 * @since 7.8
	 */
	private String escape(char[] arr) {
		final StringBuilder sb = new StringBuilder(arr.length);
		// 2015.11 miguel
		// Consider code in com.sun.xml.bind.marshaller.DumbEscapeHandler for replacements
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case '&':
				sb.append("&amp;");
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '\"':
				// 2015.11 miguel: esto podria dar probelmas eventualmente con escapeo dentro de atributos, ignorado por ahora porque se usa para curency y ns
				//	                if (isAttVal) {
				//	                    sb.append("&quot;");
				//	                } else {
				sb.append('\"');
				//	                }
				break;
			default:
				if (arr[i] > '\u007f') {
					sb.append("&#");
					sb.append(Integer.toString(arr[i]));
					sb.append(';');
				} else {
					sb.append(arr[i]);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * Return the prefix for the current tag checking if there is a parent prefix set, or a default prefix
	 */
	private String peferredPrefix(final QName qname) {
		if (this.peferredPrefixes != null) {
			String prefix = this.peferredPrefixes.get(qname.getNamespaceURI());
			if (prefix != null) {
				return prefix;
			}
		}
		/*
		 * Sebastian sep 2017: qname prefix must be ignored since closing AppHdr will include unbounded ns2
		 */
		//if (!StringUtils.isBlank(qname.getPrefix()) && !StringUtils.equals(qname.getPrefix(), "xmlns")) {
		//	return qname.getPrefix();
		if (this.defaultPrefix != null) {
			return this.defaultPrefix;
		} else {
			return null;
		}
	}
	
	private String prefix(final QName qname) {
		String prefix = peferredPrefix(qname);
		if (prefix != null) {
			return prefix + ":";
		} else {
			return "";
		}
	}
	
	private void closeStartTagIfNeeded() throws IOException {
        if (this.startTagIncomplete) {
        	out.write('>');
        	this.startTagIncomplete = false;
        }
    }

	public void add(XMLEventReader arg0) throws XMLStreamException {
	}

	public void close() throws XMLStreamException {
	}

	public void flush() throws XMLStreamException {
		try {
            out.flush();
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
	}

	public NamespaceContext getNamespaceContext() {
		return new ProwideNamespaceContext();
	}

	public String getPrefix(String arg0) throws XMLStreamException {
		return null;
	}

	public void setDefaultNamespace(String arg0) throws XMLStreamException {
	}

	public void setNamespaceContext(NamespaceContext arg0) throws XMLStreamException {
	}

	public void setPrefix(String arg0, String arg1) throws XMLStreamException {
	}
	
	/*
	 * Sebastian sep 2017: esto no se puede usar porque al usarlo funciona en los elements pero 
	 * no se recibe ningun evento namespace y quedan sin definir en el root
	 */
	private static final class ProwideNamespaceContext implements NamespaceContext {
		
		public String getNamespaceURI(String prefix) {
			//return XsysNamespaces.namespaceURI(prefix);
			return null;
		}

		public String getPrefix(String namespaceURI) {
			//return XsysNamespaces.prefix(namespaceURI);
			return null;
		}

		@SuppressWarnings("rawtypes")
        public Iterator getPrefixes(String namespaceURI) {
			/*
			String prefix = XsysNamespaces.prefix(namespaceURI);
			if (prefix != null) {
				List<String> result = new ArrayList<>();
				result.add(prefix);
				return result.iterator();
			}
			*/
			return null;
		}
	}

	/**
	 * @since 7.9.3
	 */
	public String getDefaultPrefix() {
		return defaultPrefix;
	}

	/**
	 * @since 7.9.3
	 */
	public void setDefaultPrefix(String defaultPrefix) {
		this.defaultPrefix = defaultPrefix;
	}

	/**
	 * @since 7.9.3
	 */
	public Map<String, String> getPeferredPrefixes() {
		return peferredPrefixes;
	}

	/**
	 * Custom optional prefix configuration, if provided, this prefixes will
	 * be used regardless of any other context namespaces and prefix configuration.
	 * @param peferredPrefixes a map with namespaceURIs as keys and prefixes as values
	 * @since 7.9.3
	 */
	public void setPeferredPrefixes(Map<String, String> peferredPrefixes) {
		this.peferredPrefixes = peferredPrefixes;
	}

	/**
	 * @since 7.9.3
	 */
	public boolean isIncludeXMLDeclaration() {
		return includeXMLDeclaration;
	}

	/**
	 * @since 7.9.3
	 */
	public void setIncludeXMLDeclaration(boolean includeXMLDeclaration) {
		this.includeXMLDeclaration = includeXMLDeclaration;
	}

	/**
	 * @since 7.9.3
	 */
	public String getRootElement() {
		return rootElement;
	}

	/**
	 * @since 7.9.3
	 */
	public void setRootElement(String rootElement) {
		this.rootElement = rootElement;
	}
	
}
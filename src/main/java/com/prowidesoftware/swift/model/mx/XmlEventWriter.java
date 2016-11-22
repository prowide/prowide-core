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
package com.prowidesoftware.swift.model.mx;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.logging.Level;

import javax.xml.namespace.NamespaceContext;
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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * XMl writer for MX model classes.
 * 
 * @since 7.8
 */
public final class XmlEventWriter implements XMLEventWriter {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(XmlEventWriter.class.getName());
	private static final Level STEP_LEVEL = Level.FINER;
	private Writer out;
	private final StringBuilder indent = new StringBuilder();
	private StartElement delayedStart = null;
	private boolean startTagIncomplete = false;
	private int startElementCount;
	/*
	 * Variable para acumular el log del xml que se va generando en modo de debug 
	 */
	private final StringBuilder stepOutLog;
	private String prefix = null;
	private boolean includeXMLDeclaration = true;
	private String rootElement = null;
	
	/**
	 * 
	 * @param baos output buffer to write
	 * @param prefix optional prefix for ns (empty by default)
	 * @param includeXMLDeclaration true to include the xml declaration (true by default)
	 * @param rootElement local name of the root element of the XML fragment to create, used to declare namespace
	 */
	public XmlEventWriter(Writer baos, final String prefix, boolean includeXMLDeclaration, final String rootElement) {
		this.out = baos;
		if (log.isLoggable(STEP_LEVEL)) {
			this.stepOutLog =  new StringBuilder();
		} else {
			this.stepOutLog = null;
		}
		this.startElementCount = 0;
		this.prefix = prefix;
		this.includeXMLDeclaration = includeXMLDeclaration;
		this.rootElement = rootElement;
	}

	public void add(final XMLEvent event) throws XMLStreamException {
		if (event != null) {
			log.finest("XmlEventType: " + event.getEventType());
			try {
				final int type = event.getEventType();
				switch (type) {
				case XMLEvent.START_DOCUMENT:
					if (this.includeXMLDeclaration) {
						log.finer(">> START_DOCUMENT");
						log.finer("START_DOCUMENT XMLEvent " + ToStringBuilder.reflectionToString(event));
						final String str = "<?xml version=\"1.0\" encoding=\"" + ((StartDocument) event).getCharacterEncodingScheme() + "\"?>";
						out.write(str);
						logStep(str);
					} else {
						log.finer("skipping xml declaration");
					}
					break;
					
				case XMLEvent.START_ELEMENT:
					this.startElementCount++;
					closeStartTagIfNeeded();
					log.finer(">> START_ELEMENT");
					indent.append(' ');
					final StartElement se = event.asStartElement();
					@SuppressWarnings("rawtypes")
                    final Iterator it = se.getNamespaces();
					while (it.hasNext()) {
						log.fine("ns: " + it.next());
					}
					/*---------------------------------------------------------------------------------------
					 * 2015.03 miguel
					 * Cuidado con esta condicion! esto generaba el bug de que no abria el Document anidado dentro del xs:any
					 * Esto es porque este document delayed solo se completa cuando recibe un namespace, pensado como elemento inicial
					 * esto DEEEEBEEEEEEEEEEe corregirse cuando se cambie la serializacion, si se cambia
					 * porque si el document queda dentro de un elemento payload, entonces en count es != 1 y debe revisarse como se identifica el primer 
					 * document y un document anidado.
					 *  
					 */
					if (StringUtils.equals(se.getName().getLocalPart(), this.rootElement)
							&& this.startElementCount==1 ) { // 2015.03 miguel: ESTE era el bug de esprow, que aparecian tags anidados de document cerrando que no abria, era porque entraban por aca sin esta condicion de depth count
						delayedStart = se;
						log.finer("local part is Document, initializing delayed start, startElementCount="+this.startElementCount);
					} else {
						final String s = "\n" + indent + "<" + prefix() + se.getName().getLocalPart() /* + ">" */;
						out.write(s);
						
						logStep(s);
						
						/* 2014.11 miguel
						 * para soportar atributos en lugar de cerrar aca seteamos un flag para indicar 
						 * que hace falta cerrar el startTag
						 */
						startTagIncomplete = true;
						if (se.isNamespace()) {
							log.fine("is ns in start XMLEvent " + ToStringBuilder.reflectionToString(event));
						}
					}
					break;
					
				case XMLEvent.NAMESPACE:
					log.finer(">> NAMESPACE");
					final Namespace ne = (Namespace) event;
					if (delayedStart != null) {
						final String s = "\n" + indent + "<" + prefix() + delayedStart.getName().getLocalPart() + " "+
						"xmlns"+ (this.prefix != null? ":"+this.prefix : "") + "=\"" + ne.getValue() + "\" xmlns:xsi=\"" + ne.getName() + "\""+
						">";
						out.write(s);
						logStep(s);
						delayedStart = null;
					} else {
						log.fine("NAMESPACE XMLEvent " + ToStringBuilder.reflectionToString(event));
					}
					break;
					
				case XMLEvent.CHARACTERS:
					log.finer(">> CHARACTERS");
					closeStartTagIfNeeded();
					final Characters ce = event.asCharacters();
					final char[] arr = ce.getData().toCharArray();
					out.write(escape(arr));
					logStep(ce.getData());
					break;
					
				case XMLEvent.END_ELEMENT:
					log.finer(">> END_ELEMENT");
					closeStartTagIfNeeded();
					indent.deleteCharAt(0);
					final EndElement ee = event.asEndElement();
					final String str2 = "</" + prefix() + ee.getName().getLocalPart() + ">\n" + indent;
					out.write(str2);
					logStep(str2);
					break;
					
				case XMLEvent.END_DOCUMENT:
					log.finer(">> END_DOCUMENT");
					closeStartTagIfNeeded();
					/*  2014.10 miguel
					 *  No need to do anything while writing to a string 
					 */
					log.finer("END_DOCUMENT XMLEvent " + ToStringBuilder.reflectionToString(event));
					break;
					
				case XMLEvent.ATTRIBUTE:
					log.finer(">> ATTRIBUTE");
					final Attribute a = (Attribute) event;
					final String str3 = " " + a.getName() + "=\"" + a.getValue() + "\" ";
					out.write(str3);
					log.fine(ToStringBuilder.reflectionToString(a));
					logStep(str3);
					break;
					
				default:
					log.info("getEventType " + event.getEventType());
					log.info("PW Unhandled XMLEvent " + ToStringBuilder.reflectionToString(event));
					break;
				}
			} catch (IOException e) {
				log.log(Level.SEVERE, "PW I/O error: "+e);
				log.log(Level.FINER, "PW I/O error: ", e);
				throw new XMLStreamException(e);
			}
		}
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

	private String prefix() {
		if (this.prefix != null) {
			return this.prefix + ":";
		} else {
			return "";
		}
	}
	
	private void logStep(final String str) {
        if (log.isLoggable(STEP_LEVEL)) {
        	stepOutLog.append(str);
        	log.log(STEP_LEVEL, stepOutLog.toString());
        }
    }

	private void closeStartTagIfNeeded() throws IOException {
        if (this.startTagIncomplete) {
        	out.write('>');
        	logStep(">");
        	this.startTagIncomplete = false;
        }
    }

	public void add(XMLEventReader arg0) throws XMLStreamException {
		log.fine("ADD EventReader: " + ToStringBuilder.reflectionToString(arg0));
	}

	public void close() throws XMLStreamException {
		log.fine("close ");
	}

	public void flush() throws XMLStreamException {
		log.fine("flush ");
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
		log.fine("ADD EventReader: " + ToStringBuilder.reflectionToString(arg0));
		return null;
	}

	public void setDefaultNamespace(String arg0) throws XMLStreamException {
		log.fine("ADD EventReader: " + ToStringBuilder.reflectionToString(arg0));
	}

	public void setNamespaceContext(NamespaceContext arg0) throws XMLStreamException {
		log.fine("ADD EventReader: " + ToStringBuilder.reflectionToString(arg0));
	}

	public void setPrefix(String arg0, String arg1) throws XMLStreamException {
		log.fine("ADD EventReader: " + ToStringBuilder.reflectionToString(arg0) + ", " + ToStringBuilder.reflectionToString(arg1));
	}
	
	private static final class ProwideNamespaceContext implements NamespaceContext {
		private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(ProwideNamespaceContext.class.getName());

		public String getNamespaceURI(String prefix) {
			log.finest("getNamespaceURI(" + ToStringBuilder.reflectionToString(prefix) + ")");
			return null;
		}

		public String getPrefix(String namespaceURI) {
			log.finest("getPrefix(" + ToStringBuilder.reflectionToString(namespaceURI) + ")");
			return null;
		}

		@SuppressWarnings("rawtypes")
        public Iterator getPrefixes(String namespaceURI) {
			log.finest("getPrefixes(" + ToStringBuilder.reflectionToString(namespaceURI) + ")");
			return null;
		}
	}

}

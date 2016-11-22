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

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.transform.dom.DOMResult;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.prowidesoftware.swift.io.parser.MxParser;
import com.prowidesoftware.swift.model.MxId;
import com.prowidesoftware.swift.model.mx.dic.ApplicationHeader;
import com.prowidesoftware.swift.model.mx.dic.BranchAndFinancialInstitutionIdentification5;
import com.prowidesoftware.swift.model.mx.dic.BusinessApplicationHeaderV01;
import com.prowidesoftware.swift.model.mx.dic.FinancialInstitutionIdentification8;
import com.prowidesoftware.swift.model.mx.dic.Party9Choice;

/**
 * General information applicable to any MX.
 *
 * The business header is an optional part of the payload of a message,
 * and contains information that is relevant to the business applications
 * that process the message.
 *
 * There are two different business standards, but a message can contain only one.
 * <ul>
 * <li>The ISO 20022 business application header: {@link BusinessApplicationHeaderV01}</li>
 * <li>The application header originally defined by swift: {@link ApplicationHeader}</li>
 * </ul>
 *
 * @author sebastian@prowidesoftware.com
 * @since 7.7
 */
public class BusinessHeader {
	private static final transient Logger log = Logger.getLogger(BusinessHeader.class.getName());
	
	private ApplicationHeader applicationHeader;
	private BusinessApplicationHeaderV01 businessApplicationHeader;
	
    public static final transient String NAMESPACE_AH = "urn:swift:xsd:$ahV10";
    public static final transient String NAMESPACE_BAH = "urn:iso:std:iso:20022:tech:xsd:head.001.001.01";

	/**
	 * Creates an empty header
	 */
	public BusinessHeader() {
		super();
	}

	/**
	 * Creates a business header from the SWIFT Application Header
	 * @param applicationHeader
	 * @since 7.8
	 */
	public BusinessHeader(final ApplicationHeader applicationHeader) {
		this();
		this.applicationHeader = applicationHeader;
	}

	/**
	 * Creates a business header from the ISO Business Application Header
	 * @param businessApplicationHeader
	 * @since 7.8
	 */
	public BusinessHeader(final BusinessApplicationHeaderV01 businessApplicationHeader) {
		this();
		this.businessApplicationHeader = businessApplicationHeader;
	}

	public ApplicationHeader getApplicationHeader() {
		return applicationHeader;
	}

	public void setApplicationHeader(final ApplicationHeader applicationHeader) {
		if (this.businessApplicationHeader != null) {
			throw new IllegalStateException("can't set applicationHeader when businessApplicationHeader is not null, set it to null before. These attributes overlap each other");
		}
		this.applicationHeader = applicationHeader;
	}

	public BusinessApplicationHeaderV01 getBusinessApplicationHeader() {
		return businessApplicationHeader;
	}

	public void setBusinessApplicationHeader(final BusinessApplicationHeaderV01 businessApplicationHeader) {
		if (this.applicationHeader != null) {
			throw new IllegalStateException("can't set businessApplicationHeader when applicationHeader is not null, set it to null before. These attributes overlap each other");
		}
		this.businessApplicationHeader = businessApplicationHeader;
	}

	/*
	 *  2015.08 miguel.
	 *  ver MX Headers/stdsmx_usgi.pdf
	 *  doc 3.2.3 Correspondence between the ISO Business Application Header and the Application Header
	 *  de ahi sintentizar los atributos aca.
	 *  FIXME replicar metodos unificados segun el mapeo de la seccion 3.2.3
	 */

	/**
	 * Gets the sender BIC code
	 * 
	 * If the header is a BAH, gets the BIC code from BusinessApplicationHeaderV01/Fr/FIId/FinInstnId/BICFI
	 * <br />
	 * If the header is an AH, gets the same from ApplicationHeader/From/Type+Id where if Type
	 * is BIC the Id is returned as is, otherwise the domain name is parsed using {@link MxParser#getBICFromDN(String)}
	 * 
	 * @return found BIC or null if not present or cannot be parsed
	 */
	public String from() {
		if (this.applicationHeader == null) {
			if (this.businessApplicationHeader == null) {
				return null;
			}
			/*
			 * is BAH
			 */
			try {
				return this.businessApplicationHeader.getFr().getFIId().getFinInstnId().getBICFI();
			} catch (NullPointerException e) {
				return null;
			}
		} else {
			/*
			 * is AH
			 */
			try {
				if (StringUtils.equals(this.applicationHeader.getFrom().getType(), "BIC")) {
					return this.applicationHeader.getFrom().getId();
				} else {
					return MxParser.getBICFromDN(this.applicationHeader.getFrom().getId());
				}
			} catch (NullPointerException e) {
				return null;
			}
		}
	}

	/**
	 * Gets the receiver BIC code
	 * 
	 * If the header is a BAH, gets the BIC code from BusinessApplicationHeaderV01/To/FIId/FinInstnId/BICFI
	 * <br />
	 * If the header is an AH, gets the same from ApplicationHeader/To/Type+Id where if Type
	 * is BIC the Id is returned as is, otherwise the domain name is parsed using {@link MxParser#getBICFromDN(String)}
	 * 
	 * @return found BIC or null if not present or cannot be parsed
	 */
	public String to() {
		if (this.applicationHeader == null) {
			if (this.businessApplicationHeader == null) {
				return null;
			}
			/*
			 * is BAH
			 */
			try {
				return this.businessApplicationHeader.getTo().getFIId().getFinInstnId().getBICFI();
			} catch (NullPointerException e) {
				return null;
			}
		} else {
			/*
			 * is AH
			 */
			try {
				if (StringUtils.equals(this.applicationHeader.getTo().getType(), "BIC")) {
					return this.applicationHeader.getTo().getId();
				} else {
					return MxParser.getBICFromDN(this.applicationHeader.getTo().getId());
				}
			} catch (NullPointerException e) {
				return null;
			}
		}
	}
	

	/**
	 * Get the message reference.
	 * 
	 * @see BusinessApplicationHeaderV01#getBizMsgIdr()
	 * @see ApplicationHeader#getMsgRef()
	 * 
	 * @since 7.8
	 */
	public String reference() {
		if (this.applicationHeader == null) {
			if (this.businessApplicationHeader == null) {
				return null;
			}
			return this.businessApplicationHeader.getBizMsgIdr();
		}
		return this.applicationHeader.getMsgRef();
	}

	/**
	 * Get this header as an XML string.
	 * 
	 * @return header serialized into XML string or null if neither header version is present
	 * @since 7.8
	 * @see #xml(String, boolean)
	 */
	public String xml() {
		return xml(null, false);
	}
	
	/**
	 * Get this header as an XML string.
	 * Since this class contains a dual model supporting two type of headers (swift and ISO), if both
	 * headers are present in the object the BusinessApplicationHeaderV01 will be used.
	 * 
	 * @param prefix optional prefix for namespace (empty by default)
	 * @param includeXMLDeclaration true to include the XML declaration (false by default)
	 * @return header serialized into XML string or null if neither header version is present
	 * @since 7.8
	 */
	public String xml(final String prefix, boolean includeXMLDeclaration) {
		Object header = null;
		if (this.businessApplicationHeader != null) {
			header = this.businessApplicationHeader;
		} else if (this.applicationHeader != null) {
			header = this.applicationHeader;
		} else {
			return null;
		}
		try {
			JAXBContext context = JAXBContext.newInstance(header.getClass());
			final Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			 
			final StringWriter sw = new StringWriter();
			marshaller.marshal(_element(header), new XmlEventWriter(sw, prefix, includeXMLDeclaration, "AppHdr"));
			return sw.getBuffer().toString();
			
		} catch (JAXBException e) {
			log.log(Level.SEVERE, "Error writing XML:" + e + "\n for header: " + header);
		}
		return null;
	 }
	
	/**
	 * Gets the header as an Element object.
	 *  
	 * @return Element this header parsed into Element or null if header is null
	 * @since 7.8
	 */
	public Element element() {
		Object header = null;
		if (this.businessApplicationHeader != null) {
			header = this.businessApplicationHeader;
		} else if (this.applicationHeader != null) {
			header = this.applicationHeader;
		} else {
			return null;
		}
		try {
			JAXBContext context = JAXBContext.newInstance(header.getClass());
			final Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			 
			DOMResult res = new DOMResult();
			marshaller.marshal(_element(header), res);
			Document doc = (Document) res.getNode();
			return (Element) doc.getFirstChild();
			
		} catch (JAXBException e) {
			log.log(Level.SEVERE, "Error writing XML:" + e + "\n for header: " + header);
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JAXBElement _element(final Object header) {
		if (header instanceof BusinessApplicationHeaderV01) {
			return (JAXBElement<BusinessApplicationHeaderV01>) new JAXBElement(new QName(NAMESPACE_BAH, "AppHdr"), header.getClass(), null, header);
		} else if (header instanceof ApplicationHeader) {
			return (JAXBElement<ApplicationHeader>) new JAXBElement(new QName(NAMESPACE_AH, "AppHdr"), header.getClass(), null, header);
		} else {
			return null;
		}
	}
	
	/**
	 * Convenient method to create a new header, initialized from simple parameters.
	 * <br>
	 * The created header will be of type {@link BusinessApplicationHeaderV01}.
	 * Creation date will be set to current time.
	 * <br />
	 * All parameters are optional but in order for the header to be valid the
	 * sender, receiver and reference must be set.
	 * 
	 * @param sender optional sender BIC for the Fr element or <code>null</code> to leave not set
	 * @param receiver optional receiver BIC for the To element or <code>null</code> to leave not set
	 * @param reference optional reference for the BizMsgIdr (business message identifier) or <code>null</code> to leave not set
	 * @param id optional MX identification for the MsgDefIdr (message definition identifier) element or <code>null</code> to leave not set
	 * @return new header initialized from parameters.
	 * @since 7.8.5
	 */
	public static BusinessHeader create(final String sender, final String receiver, final String reference, final MxId id) {
		BusinessHeader h = new BusinessHeader();
		h.setBusinessApplicationHeader(new BusinessApplicationHeaderV01());
		
		if (sender != null) {
			h.getBusinessApplicationHeader().setFr(new Party9Choice());
			h.getBusinessApplicationHeader().getFr().setFIId(new BranchAndFinancialInstitutionIdentification5());
			h.getBusinessApplicationHeader().getFr().getFIId().setFinInstnId(new FinancialInstitutionIdentification8());
			h.getBusinessApplicationHeader().getFr().getFIId().getFinInstnId().setBICFI(sender);
		}
		
		if (receiver != null) {
			h.getBusinessApplicationHeader().setTo(new Party9Choice());
			h.getBusinessApplicationHeader().getTo().setFIId(new BranchAndFinancialInstitutionIdentification5());
			h.getBusinessApplicationHeader().getTo().getFIId().setFinInstnId(new FinancialInstitutionIdentification8());
			h.getBusinessApplicationHeader().getTo().getFIId().getFinInstnId().setBICFI(receiver);
		}
		
		if (reference != null) {
			h.getBusinessApplicationHeader().setBizMsgIdr(reference);
		}
		
		if (id != null) {
			h.getBusinessApplicationHeader().setMsgDefIdr(id.id());
		}
		
		h.getBusinessApplicationHeader().setCreDt(now());
		
		return h;
	}
	
	/**
	 * Sets the creation date in the inner header object with current moment in UTC time zone.
	 * <br>
	 * Either of the inner headers must be not null. If both are null this method does nothing.
	 * @param overwrite if true, the creation date will always be set overwriting any previous value; if false it will be set only if it is not already set 
	 * @since 7.8.5
	 */
	public void setCreationDate(boolean overwrite) {
		if (this.businessApplicationHeader != null && (this.businessApplicationHeader.getCreDt() == null || overwrite)) {
			this.businessApplicationHeader.setCreDt(now());
		} else if (this.applicationHeader != null && (this.applicationHeader.getCrDate() == null || overwrite)) {
			this.applicationHeader.setCrDate(now());
		}
	}
	
	/**
	 * Returns a gregorian calendar for current moment in UTC time zone
	 * @return created calendar or null if DatatypeFactory fails to create the calendar instance
	 */
	private static XMLGregorianCalendar now() {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime());
		XMLGregorianCalendar creationDate = null;
		try {
			/*
			 * important: cannot create XMLGregorianCalendar directly from Calendar object, 
			 * specific format must be used for the unmarshalled XML to pass XSD validation.
			 */
			creationDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(c.getTime()));
		} catch (DatatypeConfigurationException e) {
			log.log(Level.WARNING, "error initializing header creation date", e);
		}
		return creationDate;
	}
}

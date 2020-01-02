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

import com.prowidesoftware.swift.model.mx.dic.*;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.prowidesoftware.swift.io.parser.MxParser;
import com.prowidesoftware.swift.model.MxId;

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
	private static final String APPHDR = "AppHdr";

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
	 * Gets the sender BIC code.
	 * <br>
	 * If the header is a BAH, tries to gets the BIC code from this elements in the following order:
	 * <ol>
	 * 	<li>BusinessApplicationHeaderV01/Fr/FIId/FinInstnId/BICFI</li>
	 *  <li>BusinessApplicationHeaderV01/Fr/OrgId/Id/OrgId/Id/AnyBIC</li>
	 * </ol>
	 * <br>
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
			return getBIC(this.businessApplicationHeader.getFr());
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
	 * <br>
	 * If the header is a BAH, tries to gets the BIC code from this elements in the following order:
	 * <ol>
	 * 	<li>BusinessApplicationHeaderV01/To/FIId/FinInstnId/BICFI</li>
	 *  <li>BusinessApplicationHeaderV01/To/OrgId/Id/OrgId/Id/AnyBIC</li>
	 * </ol>
	 * <br>
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
			return getBIC(this.businessApplicationHeader.getTo());
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

	private String getBIC(final Party9Choice p) {
		try {
			final String found = p.getFIId().getFinInstnId().getBICFI();
			if (!StringUtils.isEmpty(found)) {
				return found;
			}
		} catch (NullPointerException e) {
			try {
				final String found = p.getOrgId().getId().getOrgId().getAnyBIC();
				if (!StringUtils.isEmpty(found)) {
					return found;
				}
			} catch (NullPointerException e2) {
				return null;
			}
		}
		return null;
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
		Object header;
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
			marshaller.marshal(_element(header), new XmlEventWriter(sw, prefix, includeXMLDeclaration, APPHDR));
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
		Object header;
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
			return (JAXBElement<BusinessApplicationHeaderV01>) new JAXBElement(new QName(NAMESPACE_BAH, APPHDR), header.getClass(), null, header);
		} else if (header instanceof ApplicationHeader) {
			return (JAXBElement<ApplicationHeader>) new JAXBElement(new QName(NAMESPACE_AH, APPHDR), header.getClass(), null, header);
		} else {
			return null;
		}
	}

	/**
	 * Convenient method to create a new ISO header, initialized from simple parameters.
	 *
	 * <p>All parameters are optional but in order for the header to be valid the sender, receiver and reference must
	 * be set. Creation date will be set to current time.
	 *
	 * @param sender optional sender BIC for the Fr element or null to leave not set
	 * @param receiver optional receiver BIC for the To element or null to leave not set
	 * @param reference optional reference for the BizMsgIdr (business message identifier) or null to leave not set
	 * @param id optional MX identification for the MsgDefIdr (message definition identifier) element or null to leave not set
	 * @return new header initialized from parameters.
	 * @since 8.0.5
	 */
	public static BusinessApplicationHeaderV01 createBusinessApplicationHeaderV01(final String sender, final String receiver, final String reference, final MxId id) {
		BusinessApplicationHeaderV01 h = new BusinessApplicationHeaderV01();

		if (sender != null) {
			h.setFr(new Party9Choice());
			h.getFr().setFIId(new BranchAndFinancialInstitutionIdentification5());
			h.getFr().getFIId().setFinInstnId(new FinancialInstitutionIdentification8());
			h.getFr().getFIId().getFinInstnId().setBICFI(sender);
		}

		if (receiver != null) {
			h.setTo(new Party9Choice());
			h.getTo().setFIId(new BranchAndFinancialInstitutionIdentification5());
			h.getTo().getFIId().setFinInstnId(new FinancialInstitutionIdentification8());
			h.getTo().getFIId().getFinInstnId().setBICFI(receiver);
		}

		if (reference != null) {
			h.setBizMsgIdr(reference);
		}

		if (id != null) {
			h.setMsgDefIdr(id.id());
		}

		h.setCreDt(now());

		return h;
	}

	/**
	 * Convenient method to create a new header, initialized from simple parameters.
	 *
	 * <p>The implementation will create a new {@link BusinessApplicationHeaderV01} and then wrap it into a generic
	 * {@link BusinessHeader} object.
	 *
	 * @see #createBusinessApplicationHeaderV01(String, String, String, MxId)
	 * @since 7.8.5
	 */
	public static BusinessHeader create(final String sender, final String receiver, final String reference, final MxId id) {
		return new BusinessHeader(createBusinessApplicationHeaderV01(sender, receiver, reference, id));
	}

	/**
	 * Convenient method to create a new legacy SWIFT header, initialized from simple parameters.
	 *
	 * <p>All parameters are optional but in order for the header to be valid the sender, receiver and reference must
	 * be set. Creation date will be set to current time.
	 *
	 * @param sender optional sender BIC for the Fr element or null to leave not set
	 * @param receiver optional receiver BIC for the To element or null to leave not set
	 * @param reference optional reference for the BizMsgIdr (business message identifier) or null to leave not set
	 * @param id optional MX identification for the MsgDefIdr (message definition identifier) element or null to leave not set
	 * @return new header initialized from parameters.
	 * @since 8.0.5
	 */
	public static ApplicationHeader createApplicationHeader(final String sender, final String receiver, final String reference, final MxId id) {
		ApplicationHeader h = new ApplicationHeader();

		if (sender != null) {
			h.setFrom(new EntityIdentification());
			h.getFrom().setType("BIC");
			h.getFrom().setId(sender);
		}

		if (receiver != null) {
			h.setTo(new EntityIdentification());
			h.getTo().setType("BIC");
			h.getTo().setId(receiver);
		}

		if (reference != null) {
			h.setMsgRef(reference);
		}

		if (id != null) {
			h.setMsgName(id.id());
		}

		h.setCrDate(now());

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

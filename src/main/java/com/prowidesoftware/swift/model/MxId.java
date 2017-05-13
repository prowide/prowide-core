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
package com.prowidesoftware.swift.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 * Class for identification of MX messages.<br >
 * Composed by the business process (business area), functionality (message type), variant and version.
 *
 * @author miguel@prowidesoftware.com
 * @since 7.7
 */
public class MxId {
	private MxBusinessProcess businessProcess;
	private String functionality;
	private String variant;
	private String version;
	private static final Pattern pattern = Pattern.compile(".*([a-zA-Z]{4}).(\\d{3}).(\\d{3}).(\\d{2}).*");

	public MxId() {
		this.businessProcess = null;
		this.functionality = StringUtils.EMPTY;
		this.variant = StringUtils.EMPTY;
		this.version = StringUtils.EMPTY;
	}
	/**
	 * Creates a new object getting data from a targetnamespace
	 * @param namespace
	 * @throws IllegalArgumentException if namespace parameter cannot be parsed as MX identification
	 */
	public MxId(final String namespace) {
		Validate.notNull(namespace);
		final Matcher matcher = pattern.matcher(namespace);
		if (matcher.matches()) {
			final String bpStr = matcher.group(1);
			try {
				this.businessProcess = MxBusinessProcess.valueOf(bpStr);
			} catch (final Exception e) {
				throw new IllegalArgumentException("Illegal value for business process: '"+bpStr+"' see enum values in "+MxBusinessProcess.class.getName()+" for valid options", e);
			}
			this.functionality = matcher.group(2);
			this.variant = matcher.group(3);
			this.version = matcher.group(4);
		} else {
			throw new IllegalArgumentException("Could not parse namespace '"+namespace+"'");
		}
	}

	public MxId(final String bpString, final String funString, final String varString, final String verString) {
		this.businessProcess = MxBusinessProcess.valueOf(bpString);
		this.functionality = funString;
		this.variant = varString;
		this.version = verString;
	}

	/**
	 * Gets the business process (a.k.a. business area)
	 * @return the business process set
	 */
	public MxBusinessProcess getBusinessProcess() {
		return businessProcess;
	}
	public void setBusinessProcess(final MxBusinessProcess businessProcess) {
		this.businessProcess = businessProcess;
	}
	
	/**
	 * Gets the functionality (a.k.a. message type)
	 * @return the functionality set
	 */
	public String getFunctionality() {
		return functionality;
	}
	public void setFunctionality(final String functionality) {
		this.functionality = functionality;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(final String variant) {
		this.variant = variant;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(final String version) {
		this.version = version;
	}

	public String camelized() {
		final StringBuilder sb = new StringBuilder();
		if (businessProcess != null) {
			sb.append(Character.toUpperCase(businessProcess.name().charAt(0)));
			sb.append(businessProcess.name().substring(1));
		}
		if (functionality != null) { sb.append(functionality); }
		if (variant != null) { sb.append(variant); }
		if (version != null) { sb.append(version); }

		return sb.toString();
	}

	public int getVersionInt() {
		return Integer.valueOf(getVersion());
	}
	public int getVariantInt() {
		return Integer.valueOf(getVariant());
	}
	public int getFunctionalityInt() {
		return Integer.valueOf(getFunctionality());
	}

	/**
	 * Creates a namespace URI for this MX, for example: urn:swift:xsd:camt.003.001.04
	 * All id attributes should be properly filled.
	 *
	 * @return a string representing the namespace URI for the MX or null if any of the attributes is not set
	 */
	public String namespaceURI() {
		return new StringBuilder("urn:swift:xsd:").append(id()).toString();
	}

	/**
	 * Get a string in the form of businessprocess.functionality.variant.version
	 * @return a string with the MX message type identification
	 * @since 7.7
	 */
	public String id() {
		final StringBuilder sb = new StringBuilder();
		if (businessProcess != null) {
			sb.append(businessProcess.name());
		} else {
			return null;
		}
		if (functionality != null) {
			sb.append("." + functionality);
		} else {
			return null;
		}
		if (variant != null) {
			sb.append("." + variant);
		} else {
			return null;
		}
		if (version != null) {
			sb.append("." + version);
		} else {
			return null;
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return id();
	}
	
	/**
	 * @since 7.8.8
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessProcess == null) ? 0 : businessProcess.hashCode());
		result = prime * result + ((functionality == null) ? 0 : functionality.hashCode());
		result = prime * result + ((variant == null) ? 0 : variant.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	/**
	 * @since 7.8.8
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MxId other = (MxId) obj;
		if (businessProcess != other.businessProcess)
			return false;
		if (functionality == null) {
			if (other.functionality != null)
				return false;
		} else if (!functionality.equals(other.functionality))
			return false;
		if (variant == null) {
			if (other.variant != null)
				return false;
		} else if (!variant.equals(other.variant))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}

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
package com.prowidesoftware.swift.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * Class for identification of MX messages.
 *
 * <p>It is composed by the business process (business area), functionality (message type), variant and version.
 * For a better understanding of ISO 20022 variants check https://www.iso20022.org/variants.page
 *
 * @author miguel
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
	 * Creates a new object getting data from an MX message namespace.
	 * <p>The implementation parses the namespace using a regex to detect the message type part.
	 *
	 * @param namespace a complete or partial namespace such as "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03" or just "pain.001.001.03"
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

	public MxId(final MxBusinessProcess businessProcess, final String funString, final String varString, final String verString) {
		this.businessProcess = businessProcess;
		this.functionality = funString;
		this.variant = varString;
		this.version = verString;
	}

	public MxId(final String bpString, final String funString, final String varString, final String verString) {
		this(MxBusinessProcess.valueOf(bpString), funString, varString, verString);
	}

	/**
	 * Gets the business process (a.k.a. business area)
	 * @return the business process set
	 */
	public MxBusinessProcess getBusinessProcess() {
		return businessProcess;
	}

	public MxId setBusinessProcess(final MxBusinessProcess businessProcess) {
		this.businessProcess = businessProcess;
		return this;
	}
	
	/**
	 * Gets the functionality (a.k.a. message type)
	 * @return the functionality set
	 */
	public String getFunctionality() {
		return functionality;
	}

	public MxId setFunctionality(final String functionality) {
		this.functionality = functionality;
		return this;
	}

	public String getVariant() {
		return variant;
	}

	public MxId setVariant(final String variant) {
		this.variant = variant;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public MxId setVersion(final String version) {
		this.version = version;
		return this;
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
	 * @return a string with the MX message type identification or null if any of the properties is null
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MxId mxId = (MxId) o;
		return businessProcess == mxId.businessProcess &&
				Objects.equals(functionality, mxId.functionality) &&
				Objects.equals(variant, mxId.variant) &&
				Objects.equals(version, mxId.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessProcess, functionality, variant, version);
	}

	/**
	 * Check if this identification matches the given namespace.
	 *
	 * <p>This is particularly useful if this identifier is not completely filled, for example: if the business process
	 * is set to "pain" and the functionality is set to "002" but the variant and version are left null, then this
	 * identifier will match any namespace containing pain.002.*.* where the wildcard could be any number.
	 * <br>new MxId("pain", "002", null, null).matches("pain.002.001.03") will be true.
	 *
	 * @param namespace a complete or partial namespace such as "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03" or just "pain.001.001.03"
	 * @return true if this id matches the parameter
	 * @throws IllegalArgumentException if namespace parameter cannot be parsed as MX identification
	 * @since 7.10.7
	 */
	public boolean matches(String namespace) {
		return matches(new MxId(namespace));
	}

	/**
	 * Check if this identification matches another one.
	 *
	 * <p>This is particularly useful if this identifier is not completely filled, for example: if the business process
	 * is set to "pain" and the functionality is set to "002" but the variant and version are left null, then this
	 * identifier will match for example both pain.002.001.03 and pain.002.002.04.
	 *
	 * <p>The difference between this implementation and {@link #equals(Object)} is that here null and empty properties
	 * are treated as equals. Meaning it is not sensible to null versus blank properties, thus pain.001.001.null will
	 * match pain.001.001.empty. </p>
	 *
	 * @param other an identification to compare
	 * @return true if this id matches the parameter
	 * @throws IllegalArgumentException if namespace parameter cannot be parsed as MX identification
	 * @since 7.10.7
	 */
	public boolean matches(MxId other) {
		return this.businessProcess == other.getBusinessProcess() &&
				(StringUtils.isBlank(this.functionality) || StringUtils.isBlank(other.getFunctionality()) || StringUtils.equals(this.functionality, other.getFunctionality())) &&
				(StringUtils.isBlank(this.variant) || StringUtils.isBlank(other.getVariant()) || StringUtils.equals(this.variant, other.getVariant())) &&
				(StringUtils.isBlank(this.version) || StringUtils.isBlank(other.getVersion()) || StringUtils.equals(this.version, other.getVersion()));
	}

}

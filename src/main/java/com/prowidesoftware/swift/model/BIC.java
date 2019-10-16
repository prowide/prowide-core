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

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.utils.IsoUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Helper class to process BIC information.
 *
 * <p>Bank Identifier Codes (also known as SWIFT-BIC, BIC, SWIFT ID or SWIFT code) is a unique identification code for
 * both financial and non-financial institutions. When assigned to a non-financial institution, the code may also be
 * known as a Business Entity Identifier or BEI.
 *
 * <p>It is composed by:
 * <ul>
 * 	<li>4 letters: institution code or bank code.
 * 	<li>2 letters: ISO 3166-1 alpha-2 country code
 * 	<li>2 letters or digits: location code
 * 	<li>3 letters: branch code
 * </ul>
 *
 * @since 3.3
 */
public class BIC {
	/**
	 * Fake "test &amp; training" BIC with 8 chars for testing
	 * @since 7.6
	 */
	public static final transient String TEST8 = "TESTARZZ";

	/**
	 * Fake Logical terminal address for testing,
	 * consisting of a fake "test &amp; training" BIC of 12 chars
	 * (including the terminal identification)
	 *
	 * @since 7.6
	 * @see SwiftBlock1#getLogicalTerminal()
	 */
	public static final transient String TEST12 = "TESTARZZAXXX";

	/**
	 * Constant value with which all partner bics start 
	 * @since 7.8
	 */
	public static final String PARTNER_PREFIX = "PTS";

	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	private String invalidCause = null;

	private String institution = null;
	private String country = null;
	private String location = null;
	protected String branch = null;
	private String subtype = null;

	/**
	 * Constructor with a BIC8 or BIC11 code.
	 *
	 * <p>For BIC codes with 12 characters (meaning it includes the logical terminal identifier) use
	 * {@link LogicalTerminalAddress} instead. This implementation will drop the LT identifier if a
	 * 12 characters full logical terminal addess is passed as parameter.
	 *
	 * <p>If the code is longer than 11 characters, the remainder will be store as part of the branch code.
	 *
	 * @param bic the BIC code to use in this BIC (8 or 11 chars)
	 */
	public BIC(final String bic) {
		super();
		parse(bic);
	}

	protected void parse(final String bic) {
		if (bic != null) {
			this.institution = StringUtils.trimToNull(StringUtils.substring(bic,0, 4));
			this.country = StringUtils.trimToNull(StringUtils.substring(bic,4, 6));
			this.location = StringUtils.trimToNull(StringUtils.substring(bic,6, 8));
			if (bic.length() >= 12) {
				// drop LT identifier
				this.branch = StringUtils.trimToNull(StringUtils.substring(bic, 9));
			} else {
				this.branch = StringUtils.trimToNull(StringUtils.substring(bic, 8));
			}
		}
	}

	/**
	 * Default constructor
	 */
	public BIC() {
		super();
	}

	/**
	 * Get a string with information about why the BIC was found invalid
	 * @return a human readable (english) string
	 * @deprecated use the {@link #validate()} method to get a detailed result of the validation problem found
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public String getInvalidCause() {
		DeprecationUtils.phase2(this.getClass(), "getInvalidCause()", "Use the validate() method to get a detailed result of the validation problem found");
		return invalidCause;
	}

	/**
	 * Validates the BIC structure.
	 *
	 * @see #validate() for details regarding the validation checks or if you need structured details of the validation
	 * problem found.
	 *
	 * @return true if the BIC is valid and false otherwise
	 */
	public boolean isValid() {
		BicValidationResult result = validate();
		if (result == BicValidationResult.OK) {
			return true;
		} else {
			this.invalidCause = result.message();
			return false;
		}
	}

	/**
	 * Validates the BIC structure.
	 *
	 * <p>Checks the syntax of the BIC, verifying: the total length is 8, 11 or 12 (LT identifier), the country is a
	 * valid ISO country code using {@link IsoUtils}, the institution is composed by upper case letters and the
	 * location and branch are composed by upper case letter or digits.
	 *
	 * <p>This method does not validate against any BIC directory.
	 *
	 * @return BicValidationResult with detailed information of the validation problem found
	 * @since 7.10.3
	 */
	public BicValidationResult validate() {
		if (this.institution == null || this.country == null || this.location == null) {
			return BicValidationResult.INVALID_LENGTH;
		}
		if (this.institution.length() != 4) {
			BicValidationResult result = BicValidationResult.INVALID_INSTITUTION_LENGTH;
			result.setFound(this.institution);
			return result;
		}
		if (this.country.length() != 2) {
			BicValidationResult result = BicValidationResult.INVALID_COUNTRY_LENGTH;
			result.setFound(this.country);
			return result;
		}
		if (this.location.length() != 2) {
			BicValidationResult result = BicValidationResult.INVALID_LOCATION_LENGTH;
			result.setFound(this.location);
			return result;
		}
		if (this.branch != null && this.branch.length() != 3) {
			BicValidationResult result = BicValidationResult.INVALID_BRANCH_LENGTH;
			result.setFound(this.branch);
			return result;
		}
		if (!isUpperCase(this.institution)) {
			BicValidationResult result = BicValidationResult.INVALID_INSTITUTION_CHARSET;
			result.setFound(this.institution);
			return result;
		}
		if (!IsoUtils.getInstance().isValidISOCountry(this.country)) {
			BicValidationResult result = BicValidationResult.INVALID_COUNTRY;
			result.setFound(this.country);
			return result;
		}
		if (!isUpperCaseOrDigit(this.location)) {
			BicValidationResult result = BicValidationResult.INVALID_LOCATION_CHARSET;
			result.setFound(this.location);
			return result;
		}
		if (this.branch != null && !isUpperCaseOrDigit(this.branch)) {
			BicValidationResult result = BicValidationResult.INVALID_BRANCH_CHARSET;
			result.setFound(this.branch);
			return result;
		}
		return BicValidationResult.OK;
	}

	private boolean isUpperCase(final String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isUpperCase(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private boolean isUpperCaseOrDigit(final String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isUpperCase(text.charAt(i)) && !Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * It returns the last three that conform the branch or null if branch is not present.
	 *
	 * @since 7.8.5
	 * @return the BIC's branch part or null if not found.
	 */
	public String getBranch() {
		return this.branch;
	}

	/**
	 * Returns the branch code or XXX as default
	 * @since 7.10.3
	 * @return
	 */
	public String getBranchOrDefault() {
		return this.branch != null? this.branch : "XXX";
	}

	/**
	 * Returns ths subtype code.
	 * Notice this information is not part of the BIC code, it must be explicitly set with {@link #setSubtype(String)}
	 * @since 7.4
	 */
	public String getSubtype() {
		return subtype;
	}

	/**
	 * Sets a subtype code
	 * @since 7.4
	 */
	public void setSubtype(final String subtype) {
		this.subtype = subtype;
	}

	/**
	 * Returns true if the BIC is a Test &amp; Training BIC code.
	 * <p>In SWIFT’s FIN messaging system, a BIC with a zero in the 8th position is a Test &amp; Training BIC, and as
	 * such it cannot be used in production FIN messages.
	 *
	 * @return true if it is a Test &amp; Training BIC, false if is not or if the condition cannot be determined
	 * @since 7.6
	 */
	public boolean isTestAndTraining() {
		if (this.location != null) {
			return this.location.charAt(1) == '0';
		}
		return false;
	}

	/**
	 * Returns true if the BIC is not live (not connected) on the network.
	 *
	 * <p>BICs can identify not only financial institutions but also non-financial ones
	 * either connected or not connected to the SWIFT network.
	 *
	 * <p>A BIC of an institution which is <strong>not connected</strong> to the SWIFT network
	 * still has a location code with the digit 1 at the end (for instance AFSEUS31). 
	 * BICs like that are called non-SWIFT BICs (or BIC 1).
	 *
	 * <p>In SWIFT’s FIN messaging system, a BIC with a one in the 8th position is a Non-Live BIC.
	 *
	 * <p>Note this is not the opposite of {@link #isLive()}
	 * 
	 * @return true if it is a Non-Live BIC, false if is not or if the condition cannot be determined
	 * @since 7.7
	 */
	public boolean isNonLive() {
		if (this.location != null) {
			return this.location.charAt(1) == '1';
		}
		return false;
	}

	/**
	 * Returns true if the BIC is live (connected and not test &amp; training) on the network.
	 * 
	 * <p>BICs can identify not only financial institutions but also non-financial ones
	 * either connected or not connected to the SWIFT network.
	 *
	 * <p>In SWIFT’s FIN messaging system, a BIC with a character different than zero (that would be Test &amp;
	 * Training) or one (that would be non-connected) in the 8th position is a Live BIC.
	 *
	 * <p>Note this is not the opposite of {@link #isNonLive()}
	 *
	 * @return true if it is a Non-Live BIC, false if is not or if the condition cannot be determined
	 * @since 7.7
	 */
	public boolean isLive() {
		if (this.location != null) {
			return this.location.charAt(1) != '0' && this.location.charAt(1) != '1';
		}
		return false;
	}

	/**
	 * Returns the first 8 characters of the BIC code, composed by the institution code, country and location.
	 *
	 * @return the bic8 or null if the BIC has less than 8 characters
	 * @since 7.6
	 */
	public String getBic8() {
		if (this.institution != null && this.country != null && this.location != null) {
			return this.institution + this.country + this.location;
		} else {
			return null;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BIC bic = (BIC) o;
		return Objects.equals(institution, bic.institution) &&
				Objects.equals(country, bic.country) &&
				Objects.equals(location, bic.location) &&
				Objects.equals(branch, bic.branch) &&
				Objects.equals(subtype, bic.subtype);
	}

	@Override
	public int hashCode() {
		return Objects.hash(institution, country, location, branch, subtype);
	}

	/**
	 * Returns the BIC code with 11 characters composed by institution code, country, location and branch.
	 * <p>If the branch is not present, then XXX will be used as default branch.
	 *
	 * @return the bic11 or null if the BIC has less than 8 characters
	 * @since 7.6
	 */
	public String getBic11() {
		final String bic8 = getBic8();
		if (bic8 != null) {
			return bic8 + getBranchOrDefault();
		}
		return null;
	}

	/**
	 * @since 7.7
	 * @deprecated use {@link #getCountry()} instead
	 */
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	@Deprecated
	public String country() {
		DeprecationUtils.phase2(getClass(), "country()", "use getCountry() instead");
		return getCountry();
	}

	/**
	 * @since 7.8.5
	 * @deprecated use {@link #getInstitution()} instead
	 */
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	@Deprecated
	public String institution() {
		DeprecationUtils.phase2(getClass(), "institution()", "use getInstitution() instead");
		return getInstitution();
	}
	
	/**
	 * Returns the Distinguished Name (DN) for this BIC.
	 *
	 * <p>The created DN always includes the BIC8 and "swift" and
	 * if the branch is present and not "XXX" it will also be included
	 * as organization unit (ou)
	 * 
	 * @return ou=&lt;branch&gt;,o=&lt;bic8&gt;,o=swift
	 * @since 7.9.3
	 */
	public String distinguishedName() {
		StringBuilder result = new StringBuilder();
		if (this.branch != null && !this.branch.equals("XXX")) {
			result.append("ou=").append(StringUtils.lowerCase(this.branch)).append(",");
		}
		result.append("o=").append(StringUtils.lowerCase(getBic8())).append(",o=swift");
		return result.toString();
	}

	@Override
	public String toString() {
		return getBic11();
	}

	/**
	 * @since 7.10.3
	 * @return the institution identifier part of the BIC
	 */
	public String getInstitution() {
		return institution;
	}

	/**
	 * @since 7.10.3
	 * @param institution the institution identifier part of the BIC
	 */
	public void setInstitution(String institution) {
		this.institution = institution;
	}

	/**
	 * @since 7.10.3
	 * @return the country part of the BIC
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @since 7.10.3
	 * @param country the country part of the BIC
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @since 7.10.3
	 * @return the location part of the BIC
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @since 7.10.3
	 * @param location the location part of the BIC
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @since 7.10.3
	 * @param branch the branch part of the BIC
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

}
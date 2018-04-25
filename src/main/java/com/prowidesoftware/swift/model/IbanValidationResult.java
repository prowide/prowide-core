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

import org.apache.commons.lang.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;

/**
 * To indicate the validation problem found when validating an IBAN
 * @see IBAN#validate()
 * @since 7.9.7
 * @author psantamarina
 */
public enum IbanValidationResult {
    OK("IBAN is ok"),

    IBAN_IS_NULL("The IBAN is null"),
    IBAN_IS_EMPTY("The IBAN is empty"),

    MISSING_COUNTRY_CODE("The IBAN must start with the two letters ISO country code"),
    INVALID_COUNTRY_CODE_CHARSET("The country code must contain upper case letters and ${found} was found"),
    INVALID_COUNTRY_CODE("The country code ${found} is not a valid ISO country code or the country code is not configured for IBAN validations"),

    INVALID_CHARACTERS("Invalid character '${found}' found"),
    MISSING_CHECK_DIGITS("Missing check digits"),
    INVALID_CHECK_DIGITS_FORMAT("Expected 2 check digits and found ${found}"),
    IVALID_CHECK_DIGITS("The expected computed check digit is ${expectedCheckDigit} and ${found} was found"),

    MISSING_BBAN("Missing custom account number (BBAN)"),
    BBAN_MAX_LENGTH("The max length for the custom account number (BBAN) is ${expectedLength} and found ${foundLength}"),

    MISSING_BBAN_CONFIGURATION("Missing custom account number (BBAN) configuration for country ${found}"),
    BBAN_INVALID_LENGTH("Expected a ${expectedLength} characters length for the custom account number (BBAN) and found ${foundLength} in ${found}"),
    BBAN_INVALID_UPPER_CASE_LETTERS("The ${bbanEntryType} ${found} must contain only upper case letters"),
    BBAN_INVALID_DIGITS_OR_LETTERS("The ${bbanEntryType} ${found} must contain only digits or upper case letters"),
    BBAN_INVALID_DIGITS("The ${bbanEntryType} ${found} must contain only digits"),

    UNKNOWN("Unknown exception validating IBAN");


    IbanValidationResult(final String message) {
        this.message = message;
    }

    private String message;
    private Map<String, String> vars = new HashMap<String, String>();

    /**
     * Validation problem description including expected and found content when necessary
     */
    public String message() {
        final StrSubstitutor sub = new StrSubstitutor(this.vars);
        return sub.replace(this.message);
    }

    /**
     * Sets a "found" variable for messages text
     */
    void setFound(final String found) {
        this.vars.put("found", found);
    }

    /**
     * Sets a "expectedLength" variable for messages text
     */
    void setExpectedLength(final int expectedLength) {
        this.vars.put("expectedLength", String.valueOf(expectedLength));
    }

    /**
     * Sets a "foundLength" variable for messages text
     */
    void setFoundLength(final int foundLength) {
        this.vars.put("foundLength", String.valueOf(foundLength));
    }

    /**
     * Sets a "bbanEntryType" variable for messages text
     */
    void setBbanEntryType(final BbanEntryType type) {
        this.vars.put("bbanEntryType", type.name());
    }

    /**
     * Sets a "expectedCheckDigit" variable for messages text
     */
    void setExpectedCheckDigit(final String expectedCheckDigit) {
        this.vars.put("expectedCheckDigit", expectedCheckDigit);
    }

    /**
     * @return the validation message parameters set to the enum value
     */
    public Map<String, String> vars() {
        return this.vars;
    }

}
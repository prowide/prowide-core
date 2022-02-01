/*
 * Copyright 2006-2021 Prowide
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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * To indicate the validation problem found when validating an IBAN
 *
 * @author psantamarina
 * @see IBAN#validate()
 * @since 7.9.7
 */
public enum IbanValidationResult {
    OK("The IBAN is valid"),

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

    private final String              message;
    private final Map<String, String> vars = new HashMap<>();

    IbanValidationResult(final String message) {
        this.message = message;
    }

    /**
     * Validation problem description including expected and found content when necessary
     */
    public String message() {
        String msg = this.message;
        for (Entry<String, String> e : vars.entrySet()) {
            msg = msg.replace("${" + e.getKey() + "}", e.getValue());
        }
        return msg;
    }

    /**
     * Sets a "found" variable for messages text
     */
    //TODO enums should be immutable
    void setFound(final String found) {
        this.vars.put("found", found);
    }

    /**
     * Sets a "expectedLength" variable for messages text
     */
    //TODO enums should be immutable
    void setExpectedLength(final int expectedLength) {
        this.vars.put("expectedLength", String.valueOf(expectedLength));
    }

    /**
     * Sets a "foundLength" variable for messages text
     */
    //TODO enums should be immutable
    void setFoundLength(final int foundLength) {
        this.vars.put("foundLength", String.valueOf(foundLength));
    }

    /**
     * Sets a "bbanEntryType" variable for messages text
     */
    //TODO enums should be immutable
    void setBbanEntryType(final BbanEntryType type) {
        this.vars.put("bbanEntryType", type.name());
    }

    /**
     * Sets a "expectedCheckDigit" variable for messages text
     */
    //TODO enums should be immutable
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

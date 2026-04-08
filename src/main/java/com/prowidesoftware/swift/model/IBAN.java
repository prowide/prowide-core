/*
 * Copyright 2006-2023 Prowide
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

import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;

/**
 * Utility class to validate IBAN codes.
 *
 * <p>The IBAN consists of an ISO 3166-1 alpha-2 country code, followed by two check
 * digits, and up to thirty alphanumeric characters for the domestic bank account number,
 * called the BBAN (Basic Bank Account Number).
 *
 * <p>Example usage:
 * <pre>
 * IBAN iban = new IBAN("ES2153893489");
 * if (iban.isValid())
 *     System.out.println("ok");
 * else
 *     System.out.println("problem with iban: " + iban.validate());
 * </pre>
 *
 * @since 3.3
 */
public class IBAN {
    static final int COUNTRY_CODE_LENGTH = 2;
    static final int CHECK_DIGIT_LENGTH = 2;
    private static final transient java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(IBAN.class.getName());
    private static final int COUNTRY_CODE_INDEX = 0;
    private static final int CHECK_DIGIT_INDEX = COUNTRY_CODE_LENGTH;
    private static final int BBAN_INDEX = CHECK_DIGIT_INDEX + CHECK_DIGIT_LENGTH;
    private static final String INVALIDA_IBAN_LENGTH = "Invalid IBAN length in";
    private String iban;

    /**
     * Creates an IBAN object with the given code.
     * This constructor does not perform any validation on the IBAN.
     *
     * @param iban the IBAN string
     */
    public IBAN(String iban) {
        this.iban = iban;
    }

    /**
     * Gets the BBAN (custom account number) part of the given IBAN.
     *
     * @param iban a well-formed IBAN
     * @return the custom account part of the IBAN
     * @throws IndexOutOfBoundsException if the IBAN length is wrong
     * @since 7.9.7
     */
    public static String getBban(final String iban) throws IndexOutOfBoundsException {
        return iban.substring(BBAN_INDEX);
    }

    /**
     * Gets the check digits part of the given IBAN.
     *
     * @param iban a well-formed IBAN
     * @return the check digits (two digits as String)
     * @throws IndexOutOfBoundsException if the IBAN length is wrong
     * @since 7.9.7
     */
    public static String getCheckDigits(final String iban) throws IndexOutOfBoundsException {
        return iban.substring(CHECK_DIGIT_INDEX, CHECK_DIGIT_INDEX + CHECK_DIGIT_LENGTH);
    }

    /**
     * Gets the country code part of the given IBAN.
     *
     * @param iban a well-formed IBAN
     * @return the two-letter ISO country code
     * @throws IndexOutOfBoundsException if the IBAN length is wrong
     * @since 7.9.7
     */
    public static String getCountryCode(final String iban) throws IndexOutOfBoundsException {
        return iban.substring(COUNTRY_CODE_INDEX, COUNTRY_CODE_INDEX + COUNTRY_CODE_LENGTH);
    }

    /**
     * Get the IBAN
     *
     * @return a string with the IBAN
     */
    public String getIban() {
        return iban;
    }

    /**
     * Set the IBAN
     *
     * @param iban the IBAN to set
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * Checks if the IBAN number is valid.
     *
     * @return <code>true</code> if the IBAN is valid and <code>false</code> in other case
     * @see #validate() for details regarding the validation checks or if you need structured details of the validation
     * problem found.
     */
    public boolean isValid() {
        return validate() == IbanValidationResult.OK;
    }

    /**
     * Validates the IBAN and returns the result with details if invalid.
     *
     * <p>Validates that the length is at least 5 chars: a valid 2-letter ISO country code,
     * 2 check digits, and 1 or more BBAN characters. The check digits are also computed and verified.
     * For BBAN validation, the country-specific structure must be defined either in the
     * BbanStructureValidations.json file or via the {@link BbanStructureValidations} API.
     *
     * <p>Non-alphanumeric characters are removed from the code prior to validation, so an IBAN
     * such as "ES64 0049 6170 68 2810279951" will be considered valid.
     *
     * @return {@link IbanValidationResult#OK} if valid, or a specific result describing the validation problem
     */
    public IbanValidationResult validate() {
        if (this.iban == null) {
            return IbanValidationResult.IBAN_IS_NULL;
        }
        final String code = removeNonAlpha(this.iban);

        return validate(code);
    }

    /**
     * Validates the given IBAN code and returns the result with details if invalid.
     *
     * <p>Validates that the length is at least 5 chars: a valid 2-letter ISO country code,
     * 2 check digits, and 1 or more BBAN characters. The check digits are also computed and verified.
     * For BBAN validation, the country-specific structure must be defined either in the
     * BbanStructureValidations.json file or via the {@link BbanStructureValidations} API.
     *
     * <p>Non-alphanumeric characters are <strong>not</strong> removed in this static variant;
     * the caller is expected to pass a clean IBAN code.
     *
     * @param code the IBAN code to validate
     * @return {@link IbanValidationResult#OK} if valid, or a specific result describing the validation problem
     */
    public static IbanValidationResult validate(String code) {
        if (code == null) {
            return IbanValidationResult.IBAN_IS_NULL;
        }
        if (code.isEmpty()) {
            return IbanValidationResult.IBAN_IS_EMPTY;
        }

        IbanValidationResult result;
        try {

            result = IbanValidationUtils.validateCountryCode(code);

            if (result == null) {
                result = IbanValidationUtils.validateCheckDigitPresence(code);
            }

            if (result == null) {
                result = IbanValidationUtils.validateBbanPresence(code);
            }

            if (result == null) {
                final String bban = getBban(code);

                result = IbanValidationUtils.validateBbanMaxLength(bban);

                if (result == null) {
                    /*
                     * load specific structure for country
                     */
                    final String country = getCountryCode(code);
                    final BbanStructureDTO structure =
                            BbanStructureValidations.getInstance().forCountry(country);
                    if (structure == null) {
                        result = IbanValidationResult.MISSING_BBAN_CONFIGURATION;
                        result.setFound(country);
                    } else {
                        result = IbanValidationUtils.validateBban(bban, structure);
                    }
                }
            }

            if (result == null) {
                result = IbanValidationUtils.validateCharacters(code);
            }
            if (result == null) {
                result = IbanValidationUtils.validateCheckDigit(code);
            }

        } catch (RuntimeException e) {
            return IbanValidationResult.UNKNOWN;
        }

        if (result != null) {
            return result;
        } else {
            return IbanValidationResult.OK;
        }
    }

    /**
     * Translates letters to their numeric values (A=10, B=11, ..., Z=35) and keeps digits as-is.
     * Non-alphanumeric characters are ignored.
     *
     * @param str input string
     * @return the translated numeric string
     */
    public String translateChars(final StringBuilder str) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                result.append(Character.getNumericValue(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Removes all non-alphanumeric characters from the given IBAN string.
     *
     * @param iban IBAN string
     * @return the IBAN containing only letters and digits
     */
    public String removeNonAlpha(final String iban) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < iban.length(); i++) {
            char c = iban.charAt(i);
            if (Character.isLetter(c) || Character.isDigit(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Gets the BBAN (custom account number) part of the IBAN.
     *
     * @return the custom account part of the IBAN, or null if the IBAN has an invalid length
     * @see #getBban(String)
     * @since 7.9.7
     */
    public String getBban() {
        if (StringUtils.isNotEmpty(this.iban)) {
            try {
                return getBban(this.iban);
            } catch (IndexOutOfBoundsException e) {
                log.log(Level.FINER, INVALIDA_IBAN_LENGTH + this.iban, e);
            }
        }
        return null;
    }

    /**
     * Gets the check digits part of the IBAN.
     *
     * @return the check digits (two digits as String), or null if the IBAN has an invalid length
     * @see #getCheckDigits(String)
     * @since 7.9.7
     */
    public String getCheckDigits() {
        if (StringUtils.isNotEmpty(this.iban)) {
            try {
                return getCheckDigits(this.iban);
            } catch (IndexOutOfBoundsException e) {
                log.log(Level.FINER, INVALIDA_IBAN_LENGTH + this.iban, e);
            }
        }
        return null;
    }

    /**
     * Gets the country code part of the IBAN.
     *
     * @return the two-letter ISO country code, or null if the IBAN has an invalid length
     * @see #getCountryCode(String)
     * @since 7.9.7
     */
    public String getCountryCode() {
        if (StringUtils.isNotEmpty(this.iban)) {
            try {
                return getCountryCode(this.iban);
            } catch (IndexOutOfBoundsException e) {
                log.log(Level.FINER, INVALIDA_IBAN_LENGTH + this.iban, e);
            }
        }
        return null;
    }
}

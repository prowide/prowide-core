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
 * <p>
 * The IBAN consists of a ISO 3166-1 alpha-2 country code, followed by two check
 * digits (represented by kk in the examples below), and up to thirty alphanumeric
 * characters for the domestic bank account number, called the BBAN (Basic Bank
 * Account Number).
 * <p>
 * Exampe usage scenario<br>
 * <pre>IBAN iban = new IBAN("ES2153893489");
 * if (iban.isValid())
 *     System.out.println("ok");
 * else
 *     System.out.println("problem with iban: "+iban.getInvalidCause());
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
     * Create an IBAN object with the given iban code.
     * This constructor does not perform any validation on the iban, only
     * @param iban the IBAN string
     *
     */
    public IBAN(String iban) {
        this.iban = iban;
    }

    /**
     * Gets the BBAN (custom account number) part of the given IBAN
     *
     * @param iban a well-formed IBAN
     * @return the custom account part of the IBAN
     * @throws IndexOutOfBoundsException if the IBAN length is wrong
     * @author psantamarina
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
     * @author psantamarina
     * @since 7.9.7
     */
    public static String getCheckDigits(final String iban) throws IndexOutOfBoundsException {
        return iban.substring(CHECK_DIGIT_INDEX, CHECK_DIGIT_INDEX + CHECK_DIGIT_LENGTH);
    }

    /**
     * Gets the country code part of the given IBAN.
     *
     * @param iban a well-formed IBAN
     * @return the two letters ISO country code
     * @throws IndexOutOfBoundsException if the IBAN length is wrong
     * @author psantamarina
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
     * Check an IBAN number throwing an exception with validation details if it is not valid.
     *
     * <p>Validates that the length is at least 5 chars: composed by a valid 2 letters ISO country code,
     * 2 verifying digits, and 1 BBAN. The verification digits are also computed and verified.
     * For the BBAN validation the specific per country structure must be defined either in the
     * BbanStructureValidations.json file or by API in the {@link BbanStructureValidations} instance.
     *
     * <p>Non alpha-numeric characters are removed from the code prior to validation. Meaning an IBAN
     * such as "ES64 0049 6170 68 2810279951" will be considered valid.
     *
     * @return IbanFormatStatus with detailed information of the validation problem found
     */
    public IbanValidationResult validate() {
        if (this.iban == null) {
            return IbanValidationResult.IBAN_IS_NULL;
        }
        final String code = removeNonAlpha(this.iban);

        return validate(code);
    }

    /**
     * Check an IBAN code throwing an exception with validation details if it is not valid.
     *
     * <p>Validates that the length is at least 5 chars: composed by a valid 2 letters ISO country code,
     * 2 verifying digits, and 1 BBAN. The verification digits are also computed and verified.
     * For the BBAN validation the specific per country structure must be defined either in the
     * BbanStructureValidations.json file or by API in the {@link BbanStructureValidations} instance.
     *
     * <p>Non alpha-numeric characters are removed from the code prior to validation. Meaning an IBAN
     * such as "ES64 0049 6170 68 2810279951" will be considered valid.
     *
     * @return IbanFormatStatus with detailed information of the validation problem found
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
     * Translate letters to numbers, also ignoring non alphanumeric characters
     * @param str input string
     * @return the translated value
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
     * Removes all non alpha-numeric characters in the IBAN code
     * @param iban IBAN string
     * @return the resulting IBAN
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
     * Gets the BBAN (custom account number) part of the IBAN
     *
     * @return the custom account part of the IBAN or null if the IBAN has an invalid length
     * @author psantamarina
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
     * Gets the check digits part of the IBAN
     *
     * @return the check digits (two digits as String) of the IBAN or null if the IBAN has an invalid length
     * @author psantamarina
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
     * Gets the country code part of the IBAN
     *
     * @return the two letters ISO country code of the IBAN or null if the IBAN has an invalid length
     * @author psantamarina
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

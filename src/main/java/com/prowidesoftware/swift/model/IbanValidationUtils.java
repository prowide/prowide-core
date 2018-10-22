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

import com.prowidesoftware.swift.utils.IsoUtils;

/**
 * Helper API for IBAN validation
 * @since 7.9.7
 * @author psantamarina
 */
class IbanValidationUtils {

    static final String IBAN_DEFAULT_CHECK_DIGIT = "00";

    private static final int MOD = 97;
    private static final long MAX = 999999999;
    private static final int MAX_BBAN_LENGTH = 30;

    // Suppress default constructor for noninstantiability
    private IbanValidationUtils() {
        throw new AssertionError();
    }

    /**
     * Checks the IBAN country code
     * @return problem found or null if country code is OK
     */
    static IbanValidationResult validateCountryCode(final String iban) {
        // check if iban contains 2 char country code
        if (iban.length() < IBAN.COUNTRY_CODE_LENGTH) {
            return IbanValidationResult.MISSING_COUNTRY_CODE;
        }

        final String countryCode = IBAN.getCountryCode(iban);

        // check case sensitivity
        if (!countryCode.equals(countryCode.toUpperCase()) ||
                !Character.isLetter(countryCode.charAt(0)) ||
                !Character.isLetter(countryCode.charAt(1))) {
            IbanValidationResult result = IbanValidationResult.INVALID_COUNTRY_CODE_CHARSET;
            result.setFound(countryCode);
            return result;
        }

        if (!IsoUtils.getInstance().isValidISOCountry(countryCode)) {
            IbanValidationResult result = IbanValidationResult.INVALID_COUNTRY_CODE;
            result.setFound(countryCode);
            return result;
        }

        return null;
    }

    /**
     * Checks the check digits are present
     * @return problem found or null if OK
     */
    static IbanValidationResult validateCheckDigitPresence(final String iban) {
        // check if iban contains 2 digit check digit
        if (iban.length() < IBAN.COUNTRY_CODE_LENGTH + IBAN.CHECK_DIGIT_LENGTH) {
            return IbanValidationResult.MISSING_CHECK_DIGITS;
        }

        final String checkDigit = IBAN.getCheckDigits(iban);

        // check digits
        if(!Character.isDigit(checkDigit.charAt(0)) ||
                !Character.isDigit(checkDigit.charAt(1))) {
            IbanValidationResult result = IbanValidationResult.INVALID_CHECK_DIGITS_FORMAT;
            result.setFound(checkDigit);
            return result;
        }
        return null;
    }

    /**
     * Checks the BBAN is present
     * @return problem found or null if OK
     * @since 7.9.7
     */
    static IbanValidationResult validateBbanPresence(final String iban) {
        if (iban.length() <= IBAN.COUNTRY_CODE_LENGTH + IBAN.CHECK_DIGIT_LENGTH) {
            return IbanValidationResult.MISSING_BBAN;
        }
        return null;
    }

    /**
     * Validates Bban max length
     * @param bban the BBAN part of the IBAN to check
     * @return problem found or null if OK
     * @since 7.9.7
     */
    static IbanValidationResult validateBbanMaxLength(final String bban) {
        if (bban.length() > MAX_BBAN_LENGTH) {
            IbanValidationResult result = IbanValidationResult.BBAN_MAX_LENGTH;
            result.setExpectedLength(MAX_BBAN_LENGTH);
            result.setFoundLength(bban.length());
            return result;
        }
        return null;
    }

    /**
     * Validates Bban length
     * @param bban the BBAN part of the IBAN to check
     * @param  structure structure to check
     * @return problem found or null if OK
     * @since 7.9.7
     */
    static IbanValidationResult validateBban(final String bban, final BbanStructureDTO structure) {
        final int expectedBbanLength = getBbanLengh(structure);

        if (expectedBbanLength != bban.length()) {
            IbanValidationResult result = IbanValidationResult.BBAN_INVALID_LENGTH;
            result.setFound(bban);
            result.setFoundLength(bban.length());
            result.setExpectedLength(expectedBbanLength);
            return result;
        }

        int bbanEntryOffset = 0;
        for(final BbanStructureEntryDTO entry : structure.getValidation_rules()) {

            final int entryLength = entry.getLength();

            String entryValue = bban.substring(bbanEntryOffset, bbanEntryOffset + entryLength);

            bbanEntryOffset = bbanEntryOffset + entryLength;

            // validate character type
            IbanValidationResult result = validateBbanEntryCharacterType(entry, entryValue);
            if (result != null) {
                return result;
            }

        }
        return null;
    }

    /**
     * Returns bban's length.
     *
     * @param bbanStructure BbanStructureDTO
     * @return Returns bban's length
     * @since 7.9.7
     */
    private static int getBbanLengh(BbanStructureDTO bbanStructure) {
        int length = 0;
        for (BbanStructureEntryDTO entry : bbanStructure.getValidation_rules()) {
            length += entry.getLength();
        }
        return length;
    }

    /**
     * Checks the check digits are present
     * @return problem found or null if OK
     * @since 7.9.7
     */
    private static IbanValidationResult validateBbanEntryCharacterType(final BbanStructureEntryDTO entry, final String entryValue) {
        if (SwiftCharsetUtils.is(entryValue, entry.getCharacterType()) != SwiftCharsetUtils.OK) {
            IbanValidationResult result = null;
            switch (entry.getCharacterType()) {
                case a:
                    result = IbanValidationResult.BBAN_INVALID_UPPER_CASE_LETTERS;
                    break;
                case c:
                    result = IbanValidationResult.BBAN_INVALID_DIGITS_OR_LETTERS;
                    break;
                case n:
                    result = IbanValidationResult.BBAN_INVALID_DIGITS;
                    break;

                default: break;

            }
            if (result != null) {
                result.setFound(entryValue);
                result.setBbanEntryType(entry.getEntryType());
                return result;
            }
        }
        return null;
    }

    /**
     * Validates the check digits
     * @return problem found or null if OK
     * @since 7.9.7
     */
    static IbanValidationResult validateCheckDigit(final String iban) {
        if (calculateMod(iban) != 1) {
            final String checkDigit = IBAN.getCheckDigits(iban);
            final String expectedCheckDigit = calculateCheckDigit(iban);
            IbanValidationResult result = IbanValidationResult.IVALID_CHECK_DIGITS;
            result.setExpectedCheckDigit(expectedCheckDigit);
            result.setFound(checkDigit);
            return result;
        }
        return null;
    }

    /**
     * Validates the IBAN characters numeric range
     * @return problem found or null if OK
     * @since 7.9.7
     */
    static IbanValidationResult validateCharacters(final String iban) {
        for (int i = 0; i < iban.length(); i++) {
            final int numericValue = Character.getNumericValue(iban.charAt(i));
            if (numericValue < 0 || numericValue > 35) {
                IbanValidationResult result = IbanValidationResult.INVALID_CHARACTERS;
                result.setFound(String.valueOf(iban.charAt(i)));
                return result;
            }
        }
        return null;
    }

    /**
     * Calculates Iban
     * <a href="http://en.wikipedia.org/wiki/ISO_13616#Generating_IBAN_check_digits">Check Digit</a>.
     *
     * @param iban string value
     * @return check digit as String
     * @since 7.9.7
     */
    private static String calculateCheckDigit(final String iban)  {
        final String reformattedIban = replaceCheckDigit(iban, IBAN_DEFAULT_CHECK_DIGIT);
        final int modResult = calculateMod(reformattedIban);
        final int checkDigitIntValue = (98 - modResult);
        final String checkDigit = Integer.toString(checkDigitIntValue);
        return checkDigitIntValue > 9 ? checkDigit : "0" + checkDigit;
    }

    /**
     * Returns an iban with replaced check digit.
     *
     * @param iban The iban
     * @return The iban without the check digit
     * @since 7.9.7
     */
    private static String replaceCheckDigit(final String iban, final String checkDigit) {
        return IBAN.getCountryCode(iban) + checkDigit + IBAN.getBban(iban);
    }

    /**
     * Calculates
     * <a href="http://en.wikipedia.org/wiki/ISO_13616#Modulo_operation_on_IBAN">Iban Modulo</a>.
     *
     * @param iban String value
     * @return modulo 97
     * @since 7.9.7
     */
    private static int calculateMod(final String iban) {
        final String reformattedIban = IBAN.getBban(iban) + IBAN.getCountryCode(iban) + IBAN.getCheckDigits(iban);
        long total = 0;
        for (int i = 0; i < reformattedIban.length(); i++) {
            final int numericValue = Character.getNumericValue(reformattedIban.charAt(i));
            total = (numericValue > 9 ? total * 100 : total * 10) + numericValue;
            if (total > MAX) {
                total = (total % MOD);
            }
        }
        return (int) (total % MOD);
    }

}
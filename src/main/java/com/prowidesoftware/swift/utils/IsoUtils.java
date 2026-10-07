/*
 * Copyright 2006 Prowide
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
package com.prowidesoftware.swift.utils;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * Helper API to check country and currency codes using Java {@link Currency} and {@link Locale} API.
 *
 * <p>The list of valid currency and country codes can be manipulated after initialization in order to
 * change or add new values. This can be particularly helpful when the application is not running on
 * the latest Java version and a currency change or addition has not yet been updated in the used JRE.
 *
 * <p>The ISO 3166-1 country names are also available, by alpha-2, alpha-3 or numeric code, with
 * {@link #getCountryName(String)}.
 *
 * @since 7.9.2
 */
public final class IsoUtils {
    private static final transient Logger log = Logger.getLogger(IsoUtils.class.getName());
    private static final IsoUtils INSTANCE = new IsoUtils();
    private Set<String> currencies;
    private Set<String> countries;

    private IsoUtils() {
        currencies = new HashSet<>();
        for (Currency currency : Currency.getAvailableCurrencies()) {
            String val = currency.getCurrencyCode();
            currencies.add(val);
        }
        // Jul 2016: Belarus changed currency from 974 (BYR) to 933 (BYN)
        currencies.add("BYN");

        countries = new HashSet<>(Arrays.asList(Locale.getISOCountries()));

        log.fine("IsoUtils initialized with " + currencies.size() + " currency codes and " + countries.size()
                + " country codes");
    }

    public static IsoUtils getInstance() {
        return INSTANCE;
    }

    public Set<String> getCurrencies() {
        return Collections.unmodifiableSet(currencies);
    }

    public void setCurrencies(Set<String> currencies) {
        this.currencies = currencies;
    }

    public Set<String> getCountries() {
        return Collections.unmodifiableSet(countries);
    }

    public void setCountries(Set<String> countries) {
        this.countries = countries;
    }

    /**
     * Checks if the currency code is a valid ISO currency using Java {@link Currency}
     *
     * @param currencyCode a three letters capitalized currency code, example: USD
     * @return true if currency code is valid, false if it is blank or not valid
     */
    public boolean isValidISOCurrency(String currencyCode) {
        if (StringUtils.length(currencyCode) == 3) {
            return currencies.contains(currencyCode);
        }
        return false;
    }

    /**
     * Checks if the country code is a valid ISO country using Java {@link Locale#getISOCountries()}
     *
     * @param countryCode a two letters capitalized country code, example: US
     * @return true if country code is valid, false if it is blank or not valid
     */
    public boolean isValidISOCountry(String countryCode) {
        if (StringUtils.length(countryCode) == 2) {
            return countries.contains(countryCode) || isUserAssignedCountryCode(countryCode);
        }
        return false;
    }

    /**
     * Checks if the country code belongs to the ISO 3166-1 user assigned range XA to XZ, for example XK or XX.
     *
     * <p>These codes are accepted by {@link #isValidISOCountry(String)} regardless of the country codes list. The other
     * ISO 3166-1 user assigned codes (AA, QM to QZ and ZZ) are not part of this range.
     *
     * @param countryCode a two letters capitalized country code, example: XK
     * @return true if the parameter is an X followed by a letter in the A-Z range, false otherwise, including null
     * @since 10.3.20
     */
    public boolean isUserAssignedCountryCode(String countryCode) {
        return StringUtils.length(countryCode) == 2
                && countryCode.charAt(0) == 'X'
                && countryCode.charAt(1) >= 'A'
                && countryCode.charAt(1) <= 'Z';
    }

    /**
     * Gets the English short name of a country from its ISO 3166-1 code.
     *
     * <p>The parameter can be the alpha-2 code (US), the alpha-3 code (USA) or the numeric code (840). The lookup is
     * case-insensitive, ignores surrounding whitespace, accepts a numeric code with fewer or more leading zeros than
     * the three digits of the ISO code (28 or 0028 for Antigua and Barbuda, whose ISO numeric code is 028), and does
     * not depend on the default locale.
     *
     * <p>The names are the English short names of the officially assigned codes, in the comma-inverted form of the
     * ISO 3166-1 lists (for example "Bolivia, Plurinational State of"). This catalog is independent of the country
     * codes list: a code added with {@link #addCountry(String)} has no name, and the user assigned codes (the XA to
     * XZ range) have no name either.
     *
     * @param code an alpha-2, alpha-3 or numeric ISO 3166-1 country code
     * @return the English short name of the country, or null if the parameter is null, blank or not an officially
     * assigned code
     * @since 10.3.20
     */
    public String getCountryName(String code) {
        if (code == null) {
            return null;
        }
        String key = code.trim().toUpperCase(Locale.ROOT);
        if (isAsciiDigits(key)) {
            String digits = stripLeadingZeros(key);
            if (digits.length() > 3) {
                return null;
            }
            key = "000".substring(digits.length()) + digits;
        }
        return CountryNames.BY_CODE.get(key);
    }

    private static boolean isAsciiDigits(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private static String stripLeadingZeros(String digits) {
        int i = 0;
        while (i < digits.length() && digits.charAt(i) == '0') {
            i++;
        }
        return digits.substring(i);
    }

    /**
     * Lazily loaded ISO 3166-1 names, keyed by the alpha-2, alpha-3 and numeric codes.
     *
     * <p>The data comes from the IsoCountries.txt resource, one country per line as alpha-2;alpha-3;numeric;name,
     * with lines starting with # ignored.
     */
    private static final class CountryNames {
        private static final Map<String, String> BY_CODE = load();

        private static Map<String, String> load() {
            Map<String, String> map = new HashMap<>();
            try {
                String content = Lib.readResource("IsoCountries.txt", "UTF-8", IsoUtils.class);
                for (String line : content.split("\\R")) {
                    if (line.isEmpty() || line.charAt(0) == '#') {
                        continue;
                    }
                    String[] fields = line.split(";", 4);
                    if (fields.length == 4) {
                        map.put(fields[0], fields[3]);
                        map.put(fields[1], fields[3]);
                        map.put(fields[2], fields[3]);
                    }
                }
            } catch (IOException e) {
                log.log(Level.SEVERE, "Could not load the ISO 3166-1 country names", e);
            }
            if (map.isEmpty()) {
                log.severe("The ISO 3166-1 country names resource IsoCountries.txt is missing or empty");
            }
            return map;
        }
    }

    /**
     * Adds the given country code to the current list of codes, verifying that it does not exist previously.
     *
     * @param countryCode a two capital letters country code, for example: XK
     * @throws IllegalArgumentException if the parameter code is null or not two uppercase letters
     * @since 7.9.7
     */
    public void addCountry(final String countryCode) {
        Validate.isTrue(
                countryCode != null && countryCode.length() == 2 && countryCode.matches("[A-Z]*"),
                "The country code must by indicated with two uppercase letters");
        countries.add(countryCode);
    }

    /**
     * Removes the given country code from the current list of codes.
     *
     * @param countryCode a two capital letters country code, for example: XK
     * @throws IllegalArgumentException if the parameter code is null or not two uppercase letters
     * @since 9.4.18
     */
    public void removeCountry(final String countryCode) {
        Validate.isTrue(
                countryCode != null && countryCode.length() == 2 && countryCode.matches("[A-Z]*"),
                "The country code must be indicated with two uppercase letters");
        countries.remove(countryCode);
    }

    /**
     * Adds the given currency code to the current list of codes, verifying that it does not exist previously.
     *
     * @param currencyCode a three capital letters currency code, for example: ARS
     * @throws IllegalArgumentException if the parameter code is null or not three uppercase letters
     * @since 7.9.7
     */
    public void addCurrency(final String currencyCode) {
        Validate.isTrue(
                currencyCode != null && currencyCode.length() == 3 && currencyCode.matches("[A-Z]*"),
                "The currency code must by indicated with three uppercase letters");
        currencies.add(currencyCode);
    }

    /**
     * Removes the given currency code from the current list of codes.
     *
     * @param currencyCode a three capital letters currency code, for example: ARS
     * @throws IllegalArgumentException if the parameter code is null or not three uppercase letters
     * @since 9.4.18
     */
    public void removeCurrency(final String currencyCode) {
        Validate.isTrue(
                currencyCode != null && currencyCode.length() == 3 && currencyCode.matches("[A-Z]*"),
                "The currency code must be indicated with three uppercase letters");
        currencies.remove(currencyCode);
    }
}

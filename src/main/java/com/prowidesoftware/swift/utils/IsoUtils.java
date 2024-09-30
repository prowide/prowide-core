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
package com.prowidesoftware.swift.utils;

import java.util.*;
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
 * @author sebastian
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

    private boolean isUserAssignedCountryCode(String code) {
        return code.charAt(0) == 'X' && Character.isUpperCase(code.charAt(1));
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

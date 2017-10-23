/* 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 */
package com.prowidesoftware.swift.utils;

import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Helper API to check country and currency codes using Java {@link Currency} and {@link Locale} API.
 * 
 * <p>The list of valid currency and country codes can be manipulated after initialization in order to
 * change or add new values. This can be particularly helpful when the application is not running on 
 * the latest Java version and a currency change or addition has not yet been updated in the used JRE.</p>
 * 
 * @author sebastian
 * @since 7.9.2
 */
public final class IsoUtils {
	private static final transient Logger log = Logger.getLogger(IsoUtils.class.getName());
	
    private Set<String> currencies;
    private Set<String> countries;

    private static IsoUtils instance;
    
    private IsoUtils() {
    	/*
    	 * load currencies from all available locale instances
    	 * 
    	 * TODO This should be replaced by Currency.getAvailableCurrencies() once Prowide Core in migrated to Java7
    	 */
    	currencies = new HashSet<String>();
    	for(Locale locale : Locale.getAvailableLocales()) {
            try {
                String val = Currency.getInstance(locale).getCurrencyCode();
                if (!currencies.contains(val)) {
                	currencies.add(val);
                }
            } catch(Exception e) {
            	log.log(Level.FINEST, "error loading currencies from locale "+locale, e);
            }
        }
    	
    	countries = new HashSet<String> (Arrays.asList(Locale.getISOCountries()));
    }
    
    public static synchronized IsoUtils getInstance(){
    	if (instance == null){
            synchronized (IsoUtils.class) {
                if (instance == null) {
                	instance = new IsoUtils();
                }
            }
        }
        return instance;
    }

	public Set<String> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Set<String> currencies) {
		this.currencies = currencies;
	}

	public Set<String> getCountries() {
		return countries;
	}

	public void setCountries(Set<String> countries) {
		this.countries = countries;
	}

    /**
     * Checks if the currency code is a valid ISO currency using Java {@link Currency}
     * @param currencyCode a three letters capitalized currency code, example: USD
     * @return true if currency code is valid, false if it is blank or not valid
     */
    public boolean isValidISOCurrency(String currencyCode) {
    	return currencies.contains(currencyCode);
    }

    /**
     * Checks if the country code is a valid ISO country using Java {@link Locale#getISOCountries()}
     * @param countryCode a two letters capitalized country code, example: US
     * @return true if country code is valid, false if it is blank or not valid
     */
    public boolean isValidISOCountry(String countryCode) {
        return countries.contains(countryCode);
    }
    
}
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
package com.prowidesoftware.swift.model.field;

import java.util.Currency;
import java.util.List;

/**
 * Interface to mark fields whose definition contain a currency.
 * Note that if a field has a currency and it is optional, and the actual 
 * field has not set the optional currency/ies then
 * the call currencies() will return an empty list
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 * @version $Revision: 1.1 $
 */
public interface CurrencyContainer extends PatternContainer {

	/**
	 * Get a list of strings of currencies present in this field
	 * @return a list, with zero or more currencies in this field.
	 */
	List<String> currencyStrings();
	
	/**
	 * Get the single currency contained in this field.
	 * @return null if no currency is contained - which should never happen, or throws an exception if more than one currency is present in this field.
	 * 
	 */
	String currencyString();
	
	/**
	 * Utility method that creates a Currency for every string returned by {@link #currencyStrings()}
	 * 
	 */
	List<Currency> currencies();
	
	/**
	 * Analog to {@link #currencyString()}
	 * @see #currencyStrings()
	 * @see #currencyString()
	 */
	Currency currency();
	
	/**
	 * set the currency of this field.
	 * If this field contains more than one currency then all currency components will be set.
	 * Individual setComponentNN should be used to set only one component of the field.
	 */
	void initializeCurrencies(String cur);
	
	/**
	 * @see #initializeCurrencies(String)
	 */
	void initializeCurrencies(Currency cur);
	
}

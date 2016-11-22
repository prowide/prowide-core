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

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class CurrencyResolver {

	public static List<String> resolveComponentsPattern(String pattern, List<String> components) {
		final List<String> result = new ArrayList<String>();
		if (pattern != null) {
			if (pattern.indexOf('C')>=0) {
				for (int i=0;i<pattern.length();i++) {
					if (pattern.charAt(i)=='C') {
						result.add(components.get(i));
					}
				}
			}
		}
		return result;
	}
	
	public static Currency resolveCurrency(CurrencyContainer o) {
		final String s = resolveCurrencyString(o);
		if (s==null)
			return null;
		return Currency.getInstance(s);
	}

	public static String resolveCurrencyString(CurrencyContainer o) {
		final List<String> list = o.currencyStrings();
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	public static void resolveSetCurrency(final CurrencyContainer cc, final Currency cur) {
		
	}
	public static void resolveSetCurrency(final CurrencyContainer cc, final String cur) {
		final String pat = cc.componentsPattern();
		Field f = (Field)cc;
		for (int i=0;i<pat.length();i++) {
			if (pat.charAt(i)=='C') {
				f.setComponent(i, cur);
			}
		}
	}
}

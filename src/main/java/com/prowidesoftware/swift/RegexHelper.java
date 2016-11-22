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
package com.prowidesoftware.swift;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHelper {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(RegexHelper.class.getName());

	static List<String> parse(String regex, String string) {
		Pattern pat = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher matcher = pat.matcher(string);
		List<String> result = new ArrayList<String>();
		if (matcher.matches()) {
			int groups = matcher.groupCount();
			for (int i=1;i<=groups;i++) {
				result.add(matcher.group(i));
			}
		} else {
			log.fine("regex "+regex+" tot matched parameter string");
		}
		return result;
	}
		
}

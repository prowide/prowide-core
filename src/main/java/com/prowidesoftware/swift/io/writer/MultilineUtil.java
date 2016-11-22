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
package com.prowidesoftware.swift.io.writer;

import java.util.ArrayList;
import java.util.logging.Level;

import org.apache.commons.lang.Validate;

/**
 * Helper class to deal with swift fields that allow many lines of text
 * 
 * @author www.prowidesoftware.com
 */
public class MultilineUtil {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger
			.getLogger(MultilineUtil.class.getName());
	
	/**
	 * Same as <code>removeInnerEmptyLines(lines, false)</code>
	 * @param lines 
	 * @return a String array with all nonempty lines contained in the lines array
	 * 
	 * @see #removeInnerEmptyLines(String[], boolean)
	 */
	public String[] removeInnerEmptyLines(final String[] lines) {
		return removeInnerEmptyLines(lines, false);
	}
	
	/**
	 * Helper method to remove empty lines on a multiline field.
	 * 
	 * @param lines an non null array of lines to process
	 * @param keepAll if <code>true</code> this method will have the effect of sorting empty lines to the end, if <code>false</code>, empty lines will be removed 
	 * @return a String array with all nonempty lines contained in the lines array, the string may be empty if lines is empty, or no non-empty lines are present
	 */
	public String[] removeInnerEmptyLines(final String[] lines, final boolean keepAll) {
		Validate.notNull(lines, "lines cannot be null");
		if (lines.length==0)
			return lines;
		final ArrayList<String> text = new ArrayList<String>();
		ArrayList<String> empty = null;
		if (keepAll) {
			empty = new ArrayList<String>();
		}
		for (int i=0;i<lines.length;i++) {
			if (isEmpty(lines[i])) {
				if (keepAll) {
					empty.add(lines[i]);
				}
			} else {
				text.add(lines[i]);
			}
		}
		if (keepAll) {
			text.addAll(empty);
		}
		if (log.isLoggable(Level.FINE)) log.fine("text: "+text);
		return text.toArray(new String[text.size()]);
	}

	/**
	 * Returns <code>true</code> if string is not <code>null</code> and contains at least one non white character
	 */
	private boolean isEmpty(String string) {
		return string==null || string.trim().length()==0;
	}
	
}

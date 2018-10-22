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
package com.prowidesoftware.swift.io.writer;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Helper class to deal with swift fields that allow many lines of text
 * 
 * @author www.prowidesoftware.com
 */
//Sebastian Feb 2016: make this API static
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
		final ArrayList<String> text = new ArrayList<>();
		ArrayList<String> empty = null;
		if (keepAll) {
			empty = new ArrayList<>();
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
	 * Returns <code>true</code> if string is not null and contains at least one non white character
	 */
	private boolean isEmpty(String string) {
		return string==null || string.trim().length()==0;
	}
	
}

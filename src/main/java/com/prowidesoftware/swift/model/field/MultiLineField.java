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

import java.util.List;


/**
 * Interface to mark fields whose structure admits multiple lines
 *
 * @author www.prowidesoftware.com
 * @since 7.7
 */
public interface MultiLineField {

	/**
	 * Returns a specific line from the field's value.<br>
	 *
	 * @param line a reference to a specific line in the field, first line being 1
	 * @return line content or null if not present or if line number is above the expected
	 *
	 * @see #getLine(int, int)
	 * @since 7.7
	 */
	public abstract String getLine(int line);

	/**
	 * Returns a specific line from the field's value.<br><br>
	 *
	 * Performs a semantic line retrieval based on the field components definition,
	 * so this is not the same as just splitting the value in lines and getting
	 * one of the lines with an index.<br>
	 * If the field defines the first line components as optional and those components
	 * are not present in the particular field instance, then getLine(1) will return null
	 * because according to the field definition the first line is not present.<br>
	 *
	 * Also notice that a line may be composed by several components, there is
	 * no linear relation between component numbers and lines numbers.<br>
	 *
	 * The offset parameter is used to count lines from a specific component instead
	 * of the first one, and it is particularly useful when combined with the component
	 * static names, for example getLine(1, Field35B.DESCRIPTION)
	 * Notice than if the query includes a component offset, the result will not contain 
	 * prefix component separators. If the line for example starts with a slash character
	 * it will be removed. This is to avoid meaningless separators for components that
	 * are being skipped because of the offset parameter. 
	 *
	 * @param line a reference to a specific line in the field, first line being 1
	 * @param offset an optional component number used as offset when counting lines
	 *
	 * @return line content or null if not present, if line number is above the expected or if the offset is invalid
	 * @since 7.7
	 */
	public abstract String getLine(int line, int offset);

	/**
	 * Returns the field value split into lines.<br>
	 *
	 * @return found lines or empty list if value is empty
	 * @since 7.7
	 */
	public abstract List<String> getLines();

	/**
	 * Returns the field value starting at the offset component, split into lines.<br>
	 *
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public abstract List<String> getLines(int offset);

	/**
	 * Returns a specific subset of lines from the field's value, given a range.<br>
	 *
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 *
	 * @return found lines or empty list if value is empty
	 *
	 * @see #getLinesBetween(int, int, int)
	 * @since 7.7
	 */
	public abstract List<String> getLinesBetween(int start, int end);

	/**
	 * Returns a specific subset of lines from the field's value, starting at the offset component.<br>
	 *
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @param offset an optional component number used as offset when counting lines
	 *
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 *
	 * @since 7.7
	 */
	public abstract List<String> getLinesBetween(int start, int end, int offset);

}

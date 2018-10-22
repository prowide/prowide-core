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

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

import com.prowidesoftware.ProwideException;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;



/**
 * This class provides methods to parse field components.
 *
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class SwiftParseUtils {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftParseUtils.class.getName());

	// Suppress default constructor for noninstantiability
	private SwiftParseUtils() {
		throw new AssertionError();
	}
	
	/**
	 * Split components of a line, with an optional starting string and a component separator.
	 * Adjacent separators are treated as one separator.
	 * This method does not validate the starting string presence, it just strips it if present.
	 * this methods uses {@link StringUtils#splitByWholeSeparator(String, String)}
	 *
	 * @param line the string to parse
	 * @param starting an optional starting string
	 * @param separator the components separator
	 * @return a list of String with the found components or an empty list if none is found
	 */
	public static List<String> splitComponents(final String line, final String starting, final String separator) {
		final ArrayList<String> result = new ArrayList<>();

		if (StringUtils.isNotBlank(line)) {
			String lineNoPrefix = removePrefix(line, starting);

			if (StringUtils.isNotBlank(separator)) {
				final String[] tokens = StringUtils.splitByWholeSeparator(lineNoPrefix, separator);
				//add not empty tokens to result
				for (int i=0; i<tokens.length; i++) {
					if (StringUtils.isNotBlank(tokens[i])) {
						result.add(tokens[i]);
					}
				}
			} else {
				result.add(lineNoPrefix);
			}
		}
		return result;
	}

	/**
	 * Split components of a line with an optional starting string and a component separator
	 * and returns the first token found or null if the string without starting substring
	 * is empty or null.<br>
	 * This method does not validate the starting string presence, it just strips it if present.
	 *
	 * @param line
	 * @param starting
	 * @param separator
	 * @return the first token found or null
	 */
	public static String getTokenFirst(String line, final String starting, final String separator) {
		String result = null;
		if (StringUtils.isNotBlank(line)) {
			String lineNoPrefix = removePrefix(line, starting);

			result = StringUtils.substringBefore(lineNoPrefix, separator);
			if (StringUtils.isBlank(result)) {
				return null;
			}
		}
		return result;
	}

	/**
	 * @param line
	 * @param separator
	 * @return found token
	 * @see #getTokenFirst(String, String, String)
	 */
	public static String getTokenFirst(final String line, final String separator) {
		return getTokenFirst(line, null, separator);
	}

	/**
	 * @param value
	 * @param prefix
	 * @return s
	 */
	public static String removePrefix(final String value, final String prefix) {
		if (StringUtils.isNotBlank(value) && StringUtils.isNotBlank(prefix) && value.startsWith(prefix)) {
			return StringUtils.substringAfter(value, prefix);
		}
		return value;
	}

	/**
	 * Split components of a line using the parameter separator and returns the second token found or null if
	 * second component is missing. Two adjacent separators are NOT treated as one.<br>
	 * Examples with slash as separator:<ul>
	 * 		<li>for the literal "abc//def/ghi" will return null.</li>
	 * 		<li>for the literal "abc/foo/def" will return "foo".</li>
	 * 		<li>for the literal "abc/foo/def/ghi" will return "foo".</li>
	 * </ul>
	 *
	 * @param line
	 * @param separator
	 * @return s
	 */
	public static String getTokenSecond(final String line, final String separator) {
		//notice we cannot use String.split nor StringUtils.split because in that implementations two adjacent separators are treated as one
		final String result = getTokenFirst(StringUtils.substringAfter(line, separator), null, separator);
		return result;
	}

	/**
	 * Split components of a line using the parameter separator and returns the second token found or null if
	 * second component is missing. Two adjacent separators are NOT treated as one. The second component is assumed as the
	 * last one so its content may have additional separators if present.<br>
	 * Examples with slash as separator:<ul>
	 * 		<li>for the literal "abc//def/ghi" will return null.</li>
	 * 		<li>for the literal "abc/foo" will return "foo".</li>
	 * 		<li>for the literal "abc/foo/def/ghi" will return "foo/def/ghi".</li>
	 * </ul>
	 *
	 * @param line
	 * @param separator
	 * @return s
	 */
	public static String getTokenSecondLast(final String line, final String separator) {
		String result = StringUtils.substringAfter(line, separator);
		if (StringUtils.isBlank(result)) {
			result = null;
		}
		return result;
	}

	/**
	 * Split components of a line with an optional starting string and a component separator
	 * and returns the second token found or null if the string without starting substring
	 * is empty or null.<br>
	 * This method does not validate the starting string presence, it just strips it if present.
	 *
	 * @param line
	 * @param starting
	 * @param separator
	 * @return the second token found or null
	 * @since 7.4
	 */
	public static String getTokenSecond(final String line, final String starting, final String separator) {
		return getTokenSecond(removePrefix(line, starting), separator);
	}

	/**
	 * Split components of a line with an optional starting string and a component separator
	 * and returns the second token found or null if the string without starting substring
	 * is empty or null.
	 * <br>
	 * Two adjacent separators are NOT treated as one. The second component is assumed as the
	 * last one so its content may have additional separators if present.<br>
	 * This method does not validate the starting string presence, it just strips it if present.
	 *
	 * @param line
	 * @param starting
	 * @param separator
	 * @return the second token found or null
	 * @since 7.4
	 */
	public static String getTokenSecondLast(final String line, final String starting, final String separator) {
		return getTokenSecondLast(removePrefix(line, starting), separator);
	}

	/**
	 * Split components of a line using the parameter separator and returns the third token found or null if
	 * third component is missing. Two adjacent separators are NOT treated as one.<br>
	 * Examples with slash as separator:<ul>
	 * 		<li>for the literal "abc/def//ghi" will return null.</li>
	 * 		<li>for the literal "abc/foo" will return "null".</li>
	 * 		<li>for the literal "abc/def/foo" will return "foo".</li>
	 * 		<li>for the literal "abc/def/foo/ghi" will return "foo".</li>
	 * </ul>
	 *
	 * @param line
	 * @param separator
	 * @return s
	 */
	public static String getTokenThird(final String line, final String separator) {
		final String result = getTokenSecond(getTokenSecondLast(line, separator), separator);
		return result;
	}

	/**
	 * Split components of a line using the parameter separator and returns the third token found or null if
	 * third component is missing. Two adjacent separators are NOT treated as one. The third component is assumed as the
	 * last one so its content may have additional separators if present.<br>
	 * Examples with slash as separator:<ul>
	 * 		<li>for the literal "abc/def//ghi" will return null.</li>
	 * 		<li>for the literal "abc/foo" will return "null".</li>
	 * 		<li>for the literal "abc/def/foo" will return "foo".</li>
	 * 		<li>for the literal "abc/def/foo/ghi" will return "foo/ghi".</li>
	 * </ul>
	 *
	 * @param line
	 * @param separator
	 * @return s
	 */
	public static String getTokenThirdLast(final String line, final String separator) {
		String result = null;
		final String s1 = getTokenSecondLast(line, separator);
		if (StringUtils.isNotBlank(s1)) {
			result = StringUtils.substringAfter(s1, separator);
			if (StringUtils.isBlank(result)) {
				result = null;
			}
		}
		return result;
	}

	/**
	 * Split components of a line using the parameter separator and returns the forth token found or null if
	 * forth component is missing. Two adjacent separators are NOT treated as one.<br>
	 * Examples with slash as separator:<ul>
	 * 		<li>for the literal "abc/def/ghi//ghi" will return null.</li>
	 * 		<li>for the literal "abc/foo/ghi" will return "null".</li>
	 * 		<li>for the literal "abc/def/ghi/foo" will return "foo".</li>
	 * 		<li>for the literal "abc/def/ghi/foo/ghi" will return "foo".</li>
	 * </ul>
	 *
	 * @param line
	 * @param separator
	 * @return s
	 */
	public static String getTokenForth(final String line, final String separator) {
		final String result = getTokenSecond(getTokenThirdLast(line, separator), separator);
		return result;
	}

	/**
	 * Split components of a line using the parameter separator and returns the forth token found or null if
	 * forth component is missing. Two adjacent separators are NOT treated as one. The forth component is assumed as the
	 * last one so its content may have additional separators if present.<br>
	 * Examples with slash as separator:<ul>
	 * 		<li>for the literal "abc/def/ghi//ghi" will return null.</li>
	 * 		<li>for the literal "abc/foo/ghi" will return "null".</li>
	 * 		<li>for the literal "abc/def/ghi/foo" will return "foo".</li>
	 * 		<li>for the literal "abc/def/ghi/foo/ghi" will return "foo/ghi".</li>
	 * </ul>
	 *
	 * @param line
	 * @param separator
	 * @return s
	 */
	public static String getTokenForthLast(final String line, final String separator) {
		String result = null;
		final String s1 = getTokenThirdLast(line, separator);
		if (StringUtils.isNotBlank(s1)) {
			result = StringUtils.substringAfter(s1, separator);
			if (StringUtils.isBlank(result)) {
				result = null;
			}
		}
		return result;
	}

	/**
	 * Returns the alphabetic starting substring of the value.
	 * The split is made when the first numeric character is found.
	 * For example:<br>
	 * ABCD2345,33 will be return ABCD<br>
	 * If the value does not contain any alphabetic character null is returned.
	 *
	 * @param value
	 * @return s
	 */
	public static String getAlphaPrefix(final String value) {
		if (value != null && value.length() > 0) {
			int i = 0;
			while (i<value.length() && !StringUtils.isNumeric(Character.toString(value.charAt(i)))) {
				i++;
			}
			if (i > 0) {
				return StringUtils.substring(value, 0, i);
			}
		}
		return null;
	}

	/**
	 * Returns the numeric starting substring of the value.
	 * The split is made when the first alpha character (not number or comma) is found.
	 * For example:<br>
	 * 2345,33ABCD will be return 2345,33<br>
	 * If the value does not contain any numeric or comma character null is returned.
	 *
	 * @param value
	 * @return s
	 */
	public static String getNumericPrefix(final String value) {
		if (value != null && value.length() > 0) {
			int i = 0;
			while (i<value.length() && (StringUtils.isNumeric(Character.toString(value.charAt(i))) || value.charAt(i) == ',')) {
				i++;
			}
			if (i > 0) {
				return StringUtils.substring(value, 0, i);
			}
		}
		return null;
	}

	/**
	 * Returns the numeric suffix of the value.
	 * The split is made when the first numeric character is found.
	 * For example:<br>
	 * ABCD2345,33 will be return 2345,33<br>
	 * If the value does not contain any numeric character null is returned.
	 *
	 * @param value
	 * @return s
	 */
	public static String getNumericSuffix(final String value) {
		if (value != null && value.length() > 0) {
			int i = 0;
			while (i<value.length() && !StringUtils.isNumeric(Character.toString(value.charAt(i)))) {
				i++;
			}
			if (i < value.length()) {
				return StringUtils.substring(value, i);
			}
		}
		return null;
	}

	/**
	 * Returns the alpha suffix of the value.
	 * The split is made when the first alpha (not numetic or comma) character is found.
	 * For example:<br>
	 * 2345,33ABCD will be return ABCD<br>
	 * If the value does not contain any alpha character null is returned.
	 *
	 * @param value
	 * @return s
	 */
	public static String getAlphaSuffix(final String value) {
		if (value != null && value.length() > 0) {
			int i = 0;
			while (i<value.length() && (StringUtils.isNumeric(Character.toString(value.charAt(i))) || value.charAt(i) == ',')) {
				i++;
			}
			if (i < value.length()) {
				return StringUtils.substring(value, i);
			}
		}
		return null;
	}

	/**
	 * Separate the given string in lines, removing trailing empty lines.
	 * <p>The implementation uses using {@link BufferedReader#readLine()} so if the string ends with a LF, the trailing
	 * "empty" line is not returned in the result.
	 *
	 * @param value
	 * @return list of found lines
	 */
	public static List<String> getLines(final String value) {
		final List<String> result = new ArrayList<>();
		if (value != null) {
			final BufferedReader br = new BufferedReader(new StringReader(value));
			try {
				String l = br.readLine();
				while (l!=null) {
					result.add(l);
					l = br.readLine();
				}
			} catch (final IOException e) {
				throw new ProwideException(e);
			}
		}
		return result;
	}

	/**
	 * Populates a multiline field with content from an array of Strings.
	 *
	 * @param f field to populate with components' values
	 * @param startingComponentNumber first component number to be set, then it will increment on each line added
	 * @param linesToSet how many components must to be set, or null to set all available lines as components
	 * @param startingLine lines list offset, zero based
	 * @param lines list of lines from where to get components content
	 */
	public static void setComponentsFromLines(final Field f, final int startingComponentNumber, final Integer linesToSet, final int startingLine, final List<String> lines) {
		int max = linesToSet != null? linesToSet : lines.size();
		int componentNumber = startingComponentNumber;
		int lineNumber = startingLine;
		for (int i=0; i<max; i++) {
			if (lines.size() > lineNumber) {
				f.setComponent(componentNumber, lines.get(lineNumber));
			}
			componentNumber++;
			lineNumber++;
		}
	}

	/**
	 * Populates field with content from of a String splited into fixed length tokens.
	 *
	 * @param f field to populate with components' values
	 * @param startingComponentNumber first component number to be set, then it will increment on each token added
	 * @param componentsToSet how many components must to be set
	 * @param tokenSize fixed size for each token grabbed from the String value
	 * @param value from where to get components content
	 * @since 7.4
	 */
	public static void setComponentsFromTokens(final Field f, final int startingComponentNumber, final int componentsToSet, final int tokenSize, final String value) {
		StringBuilder token = new StringBuilder();
		int componentNumber = startingComponentNumber;
		for (final char c : value.toCharArray()) {
			if (token.length() < tokenSize) {
				token.append(c);
			} else {
				//token complete
				if (componentNumber <= componentsToSet) {
					f.setComponent(componentNumber, token.toString());
				}
				componentNumber++;
				token = new StringBuilder();
				token.append(c);
			}
		}
		//add remainder
		if (token.length() > 0 && componentNumber <= componentsToSet) {
			f.setComponent(componentNumber, token.toString());
		}
	}

}

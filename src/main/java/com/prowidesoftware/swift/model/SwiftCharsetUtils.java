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
package com.prowidesoftware.swift.model;

import com.prowidesoftware.ProwideException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Helper class to validate SWIFT char sets (named after the SWIFT User Handbook).
 *
 * <p>Note that when a SWIFT character set refers to a set of letters, lowercase or uppercase, it means only letters in
 * English. Therefore this implementation does not use the Character API as being Character.isLetter because that would
 * accept letters with internationalization. Instead, the integer values of the characters are used to compare them with
 * the set of allowed characters in each case.
 */
public class SwiftCharsetUtils {
	private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private static char[] AZ = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	private static char[] azLowerCase = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private static char[] specialCharacters_x = {'/', '-', '?', ':', '(', ')', '.', ',', '\'', '+', ' ', '\n', '\r'};
	private static char[] specialCharacters_y = {' ', '.', ',', '-', '(', ')', '/', '=', '\'', '+', ':', '?', '!', '"', '%', '&', '*', ';', '<', '>'};
	private static char[] specialCharacters_z = {'.', ',', '-', '(', ')', '/', '=', '\'', '+', ':', '?', '@', '#', ' ', '{', '!', '"', '%', '&', '*', ';', '<', '>', '_', '\n', '\r'};

	public static int OK = -1;
	
	// Suppress default constructor for noninstantiability
	private SwiftCharsetUtils() {
		throw new AssertionError();
	}

	private static boolean isNumber(char character) {
		return (character >= '0') && (character <= '9');
	}

	private static boolean isLowercaseLetter(char character) {
		return (character >= 'a') && (character <= 'z');
	}

	private static boolean isUppercaseLetter(char character) {
		return (character >= 'A') && (character <= 'Z');
	}

	/**
	 * Returns true if the parameter char is part of the n character set;
	 * numeric digits (0 through 9) only
	 */
	public static boolean is_n(final char character) {
		return isNumber(character);
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the n character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_n()
	 */
	public static int is_n(final String s) {
		return is(s, SwiftCharset.n);
	}

	/**
	 * Returns true if the parameter char is part of the a character set;
	 * alphabetic capital letters (A through Z), upper case only
	 */
	public static boolean is_a(final char character) {
		return isUppercaseLetter(character);
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the a character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_a()
	 */
	public static int is_a(final String s) {
		return is(s, SwiftCharset.a);
	}
		
	/**
	 * Returns true if the parameter char is part of the x character set;
	 * any character of the X permitted set (General FIN application set)  upper case and lower case allowed
	 */
	public static boolean is_x(final char character) {
		return isLowercaseLetter(character) || isUppercaseLetter(character) || isNumber(character) || is(character, specialCharacters_x);
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the x character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_x()
	 */
	public static int is_x(final String s) {
		return is(s, SwiftCharset.x);
	}
	
	/**
	 * Returns true if the parameter char is part of the y character set;
	 * any character of the Y permitted set (EDI service specific set), upper case only
	 */
	public static boolean is_y(final char character) {
		return isUppercaseLetter(character) || isNumber(character) || is(character, specialCharacters_y);
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the y character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_y()
	 */
	public static int is_y(final String s) {
		return is(s, SwiftCharset.y);
	}
	
	/**
	 * Returns true if the parameter char is part of the z character set;
	 * all characters included in the X and Y sets, plus a couple of special characters
	 */
	public static boolean is_z(final char character) {
		return isLowercaseLetter(character) || isUppercaseLetter(character) || isNumber(character) || is(character, specialCharacters_z);
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the z character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_z()
	 */
	public static int is_z(final String s) {
		return is(s, SwiftCharset.z);
	}

	/**
	 * Returns true if the parameter char is part of the c character set;
	 * alpha-numeric capital letters (upper case), and digits only
	 */
	public static boolean is_c(final char character) {
		return isUppercaseLetter(character) || isNumber(character);
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the c character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_c()
	 */
	public static int is_c(final String s) {
		return is(s, SwiftCharset.c);
	}
	
	/**
	 * Returns true if the parameter char is part of the A character set;
	 * alphabetic, upper case or lower case A through Z, a through z
	 */
	public static boolean is_A(final char character) {
		return isLowercaseLetter(character) || isUppercaseLetter(character);
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the A character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_A()
	 */
	public static int is_A(final String s) {
		return is(s, SwiftCharset.A);
	}

	/**
	 * Returns true if the parameter char is part of the B character set;
	 * alphanumeric upper case or lower case A through Z, a through z and digits
	 */
	public static boolean is_B(final char character) {
		return isLowercaseLetter(character) || isUppercaseLetter(character) || isNumber(character);
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the B character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_B()
	 */
	public static int is_B(final String s) {
		return is(s, SwiftCharset.B);
	}
	
	/**
	 * Checks if the string character belogs to a given SWIFT charset
	 * @return Returns this.OK (-1) if all characters in the string matches a char defined in the charset or
	 * the position (zero based) of the first invalid character found
	 */
	public static int is(final String s, SwiftCharset charset) {
		if (StringUtils.isNotEmpty(s)) {
			for (int i = 0; i < s.length(); i++) {
				if (!is(s.charAt(i), charset)) {
					return i;
				}
			}
		}
		return OK;
	}

	/**
	 * Checks if the character belogs to a given SWIFT charset
	 * @return true if character matches a char defined in the charset
	 */
	public static boolean is(final char c, SwiftCharset charset) {
		switch (charset) {
			case n: {
				return is_n(c);
			}
			case a: {
				return is_a(c);
			}
			case A: {
				return is_A(c);
			}
			case x: {
				return is_x(c);
			}
			case y: {
				return is_y(c);
			}
			case z: {
				return is_z(c);
			}
			case c: {
				return is_c(c);
			}
			case B: {
				return is_B(c);
			}
			default: {
				throw new ProwideException("Unexpected charset value "+charset);
			}
		}
	}
	
	/**
	 * Returns a human-friendly description of the charset
	 * @param charset a list of character defining a charset
	 * @return a string describing the charset
	 */
	public static String getAsString(SwiftCharset charset) {
		String result = null;
		switch (charset) {
			case n: {
				result = getAsString(get_n());
				break;
			}
			case a: {
				result = getAsString(get_a());
				break;
			}
			case A: {
				result = getAsString(get_A());
				break;
			}
			case x: {
				result = getAsString(get_x());
				break;
			}
			case y: {
				result = getAsString(get_y());
				break;
			}
			case z: {
				result = getAsString(get_z());
				break;
			}
			case c: {
				result = getAsString(get_c());
				break;
			}
			case B: {
				result = getAsString(get_B());
				break;
			}
			default: {
				throw new ProwideException("Unexpected charset value "+charset);
			}
		}
		result = StringUtils.replace(result, getAsString(get_n()), "[0-9]");
		result = StringUtils.replace(result, getAsString(get_a()), "[A-Z]");
		result = StringUtils.replace(result, getAsString(azLowerCase), "[a-z]");
		return result;
	}
	
	/**
	 * Returns true if the parameter char is part of the parameter character set
	 */
	private static boolean is(final char c, final char[] charset) {
		return ArrayUtils.contains(charset, c);
	}
	
	/**
	 * Gets SWIFT n charset; numeric digits (0 through 9) only.
	 */
	public static char[] get_n() {
		char[] result = {'0','1','2','3','4','5','6','7','8','9'};
		return result;
	}
	
	/**
	 * Gets SWIFT a charset; alphabetic capital letters (A through Z), upper case only.
	 */
	public static char[] get_a() {
		char[] result = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		return result;
	}

	/**
	 * Lower case a to z.
	 */
	private static char[] _get_az() {
		char[] result = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		return result;
	}
		
	/**
	 * Gets SWIFT A charset; alphabetic, upper case or lower case A through Z, a through z.
	 */
	public static char[] get_A() {
		char[] result = get_a();
		return ArrayUtils.addAll(result, _get_az());
	}
	
	/**
	 * Gets SWIFT x charset; any character of the X permitted set (General FIN application set)  upper case and lower case allowed.
	 */
	public static char[] get_x() {
		char[] result = specialCharacters_x;
		result = ArrayUtils.addAll(result, get_A());
		result = ArrayUtils.addAll(result, get_n());
		return result;
	}
	
	/**
	 * Gets SWIFT y charset; any character of the Y permitted set (EDI service specific set), upper case only.
	 */
	public static char[] get_y() {
		char[] result = specialCharacters_y;
		result = ArrayUtils.addAll(result, get_a());
		result = ArrayUtils.addAll(result, get_n());
		return result;
	}
	
	/**
	 * Gets SWIFT z charset; all characters included in the X and Y sets, plus a couple of special characters.
	 */
	public static char[] get_z() {
		char[] result = specialCharacters_z;
		result = ArrayUtils.addAll(result, get_A());
		result = ArrayUtils.addAll(result, get_n());
		return result;
	}
	
	/**
	 * Gets SWIFT c charset; alpha-numeric capital letters (upper case), and digits only.
	 */
	public static char[] get_c() {
		char[] result = get_a();
		return ArrayUtils.addAll(result, get_n());
	}
	
	/**
	 * Gets SWIFT B charset; alphanumeric upper case or lower case A through Z, a through z and 0, 1, 2, 3, 4, 5, 6, 7, 8, 9.
	 */
	public static char[] get_B() {
		char[] result = get_A();
		return ArrayUtils.addAll(result, get_n());
	}

	/**
	 * Returns a human-friendly description of the charset
	 * @param charset a list of character defining a charset
	 * @return a string describing the charset
	 */
	public static String getAsString(char[] charset) {
		StringBuffer result = new StringBuffer();
		for (int i=0; i<charset.length; i++) {
			String ch = null;
			if (charset[i] == '\n') {
				ch = "LF";
			} else if (charset[i] == '\r') {
				ch = "CR";
			} else {
				ch = ""+charset[i];
			}
			result.append("[");
			result.append(ch);
			result.append("]");
		}
		return result.toString();
	}
	
	/**
	 * Returns a new string removing all characters that not belong to the parameter charset
	 * @param s the string to filter
	 * @param charset a charset to match
	 * @return a new string with non matching characters removed
	 */
	public static String filter(String s, SwiftCharset charset) {
		StringBuilder result = new StringBuilder();
		for (int i=0; i<s.length(); i++) {
			if (is(s.charAt(i), charset)) {
				result.append(s.charAt(i));
			}
		}
		return result.toString();
	}

}
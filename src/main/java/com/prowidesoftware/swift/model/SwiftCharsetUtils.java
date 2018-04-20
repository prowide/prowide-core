/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of private license agreements
 * between Prowide Inc. and its commercial customers and partners.
 *******************************************************************************/
package com.prowidesoftware.swift.model;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

// FIXME 2015.10 miguel: how come is returns int??? should be boolean
/**
 * Helper class to validate SWIFT char sets.
 * Character sets are named after the SWIFT User Handbook.
 * 
 * @author www.prowidesoftware.com
 */
public class SwiftCharsetUtils {
	static public int OK = -1;
	
	// Suppress default constructor for noninstantiability
	private SwiftCharsetUtils() {
		throw new AssertionError();
	}

	/**
	 * Returns true if the parameter char is part of the n character set.
	 * @see #get_n()
	 */
	static public boolean is_n(final char c) {
		return is(c, get_n());
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the n character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_n()
	 */
	static public int is_n(final String s) {
		return is(s, get_n());
	}

	/**
	 * Returns true if the parameter char is part of the a character set.
	 * @see #get_a()
	 */
	static public boolean is_a(final char c) {
		return is(c, get_a());
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the a character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_a()
	 */
	static public int is_a(final String s) {
		return is(s, get_a());
	}
		
	/**
	 * Returns true if the parameter char is part of the x character set.
	 * @see #get_x()
	 */
	static public boolean is_x(final char c) {
		return is(c, get_x());
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the x character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_x()
	 */
	static public int is_x(final String s) {
		return is(s, get_x());
	}
	
	/**
	 * Returns true if the parameter char is part of the y character set.
	 * @see #get_y()
	 */
	static public boolean is_y(final char c) {
		return is(c, get_y());
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the y character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_y()
	 */
	static public int is_y(final String s) {
		return is(s, get_y());
	}
	
	/**
	 * Returns true if the parameter char is part of the z character set.
	 * @see #get_z()
	 */
	static public boolean is_z(final char c) {
		return is(c, get_z());
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the z character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_z()
	 */
	static public int is_z(final String s) {
		return is(s, get_z());
	}
	
	/**
	 * Returns true if the parameter char is part of the c character set.
	 * @see #get_c()
	 */
	static public boolean is_c(final char c) {
		return is(c, get_c());
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the c character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_c()
	 */
	static public int is_c(final String s) {
		return is(s, get_c());
	}
	
	/**
	 * Returns true if the parameter char is part of the A character set.
	 * @see #get_A()
	 */
	static public boolean is_A(final char c) {
		return is(c, get_A());
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the A character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_A()
	 */
	static public int is_A(final String s) {
		return is(s, get_A());
	}

	/**
	 * Returns true if the parameter char is part of the B character set.
	 * @see #get_B()
	 */
	static public boolean is_B(final char c) {
		return is(c, get_B());
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the B character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 * @see #get_B()
	 */
	static public int is_B(final String s) {
		return is(s, get_B());
	}
	
	/**
	 * Returns this.OK (-1) if all characters of parameter string are part of the parameter character set.
	 * Otherwise returns the position (zero based) of the first invalid character found.
	 */
	static private int is(final String s, final char[] charset) {
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
	 * @see #is(String, char[])
	 */
	static public int is(final String s, SwiftCharset charset) {
		if (SwiftCharset.n.equals(charset)) {
			return is_n(s);
		} else if (SwiftCharset.a.equals(charset)) {
			return is_a(s);			
		} else if (SwiftCharset.A.equals(charset)) {
			return is_A(s);
		} else if (SwiftCharset.x.equals(charset)) {
			return is_x(s);
		} else if (SwiftCharset.y.equals(charset)) {
			return is_y(s);
		} else if (SwiftCharset.z.equals(charset)) {
			return is_z(s);
		} else if (SwiftCharset.c.equals(charset)) {
			return is_c(s);
		} else if (SwiftCharset.B.equals(charset)) {
			return is_B(s);
		} else {
			throw new RuntimeException("unexpected charset enum");
		}
	}
	
	/**
	 * @see #is(String, char[])
	 */
	static public boolean is(final char c, SwiftCharset charset) {
		if (SwiftCharset.n.equals(charset)) {
			return is_n(c);
		} else if (SwiftCharset.a.equals(charset)) {
			return is_a(c);			
		} else if (SwiftCharset.A.equals(charset)) {
			return is_A(c);
		} else if (SwiftCharset.x.equals(charset)) {
			return is_x(c);
		} else if (SwiftCharset.y.equals(charset)) {
			return is_y(c);
		} else if (SwiftCharset.z.equals(charset)) {
			return is_z(c);
		} else if (SwiftCharset.c.equals(charset)) {
			return is_c(c);
		} else if (SwiftCharset.B.equals(charset)) {
			return is_B(c);
		} else {
			throw new RuntimeException("unexpected charset enum");
		}
	}
	
	/**
	 * @see #getAsString(char[])
	 */
	static public String getAsString(SwiftCharset charset) {
		String result = null;
		if (SwiftCharset.n.equals(charset)) {
			result = getAsString(get_n());
		} else if (SwiftCharset.a.equals(charset)) {
			result = getAsString(get_a());
		} else if (SwiftCharset.A.equals(charset)) {
			result = getAsString(get_A());
		} else if (SwiftCharset.x.equals(charset)) {
			result = getAsString(get_x());
		} else if (SwiftCharset.y.equals(charset)) {
			result = getAsString(get_y());
		} else if (SwiftCharset.z.equals(charset)) {
			result = getAsString(get_z());
		} else if (SwiftCharset.c.equals(charset)) {
			result = getAsString(get_c());
		} else if (SwiftCharset.B.equals(charset)) {
			result = getAsString(get_B());
		} else {
			throw new RuntimeException("unexpected charset enum");
		}
		result = StringUtils.replace(result, getAsString(get_n()), "[0-9]");
		result = StringUtils.replace(result, getAsString(get_a()), "[A-Z]");
		result = StringUtils.replace(result, getAsString(_get_az()), "[a-z]");
		return result;
	}
	
	/**
	 * Returns true if the parameter char is part of the parameter character set
	 */
	static private boolean is(final char c, final char[] charset) {
		return ArrayUtils.contains(charset, c);
	}
	
	/**
	 * Gets SWIFT n charset; numeric digits (0 through 9) only.
	 */
	//TODO sebastian feb 2016: meter estos arrays en bloque de iniciailzacion static en vez de en metodos
	static public char[] get_n() {
		char[] result = {'0','1','2','3','4','5','6','7','8','9'};
		return result;
	}
	
	/**
	 * Gets SWIFT a charset; alphabetic capital letters (A through Z), upper case only.
	 */
	static public char[] get_a() {
		char[] result = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		return result;
	}
		
	/**
	 * Lower case a to z.
	 */
	static private char[] _get_az() {
		char[] result = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		return result;
	}
	
	/**
	 * Gets SWIFT A charset; alphabetic, upper case or lower case A through Z, a through z.
	 */
	static public char[] get_A() {
		char[] result = get_a();
		return ArrayUtils.addAll(result, _get_az());
	}
	
	/**
	 * Gets SWIFT x charset; any character of the X permitted set (General FIN application set)  upper case and lower case allowed.
	 */
	static public char[] get_x() {
		char[] result = {'/', '-', '?', ':', '(', ')', '.', ',', '\'', '+', ' ', '\n', '\r'};
		result = ArrayUtils.addAll(result, get_A());
		result = ArrayUtils.addAll(result, get_n());
		return result;
	}
	
	/**
	 * Gets SWIFT y charset; any character of the Y permitted set (EDI service specific set), upper case only.
	 */
	static public char[] get_y() {
		char[] result = {' ', '.', ',', '-', '(', ')', '/', '=', '\'', '+', ':', '?', '!', '"', '%', '&', '*', ';', '<', '>'};
		result = ArrayUtils.addAll(result, get_a());
		result = ArrayUtils.addAll(result, get_n());
		return result;
	}
	
	/**
	 * Gets SWIFT z charset; all characters included in the X and Y sets, plus a couple of special characters.
	 */
	static public char[] get_z() {
		char[] result = {'.', ',', '-', '(', ')', '/', '=', '\'', '+', ':', '?', '@', '#', ' ', '{', '!', '"', '%', '&', '*', ';', '<', '>', '_', '\n', '\r'};
		result = ArrayUtils.addAll(result, get_A());
		result = ArrayUtils.addAll(result, get_n());
		return result;
	}
	
	/**
	 * Gets SWIFT c charset; alpha-numeric capital letters (upper case), and digits only.
	 */
	static public char[] get_c() {
		char[] result = get_a();
		return ArrayUtils.addAll(result, get_n());
	}
	
	/**
	 * Gets SWIFT B charset; alphanumeric upper case or lower case A through Z, a through z and 0, 1, 2, 3, 4, 5, 6, 7, 8, 9.
	 */
	static public char[] get_B() {
		char[] result = get_A();
		return ArrayUtils.addAll(result, get_n());
	}

	static public String getAsString(char[] charset) {
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
	 * @param s
	 * @param charset
	 * @return
	 */
	static public String filter(String s, SwiftCharset charset) {
		StringBuilder result = new StringBuilder();
		for (int i=0; i<s.length(); i++) {
			if (is(s.charAt(i), charset)) {
				result.append(s.charAt(i));
			}
		}
		return result.toString();
	}
}

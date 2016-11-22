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
package com.prowidesoftware.swift.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.lang.StringUtils;

/**
 * Miscellaneous helper functions.
 */
public class Lib {
	private Lib(){}

	/**
	 * Read the content of the given file into a string.
	 *
	 * @param filename the name of the file to be read
	 * @see #readFile(File)
	 * @since 7.6
	 * @throws IOException if an error occurs during read
	 */
	public static String readFile(final String filename) throws IOException {
		return readFile(new File(filename));
	}

	/**
	 * Read the content of the given file into a string, usign UTF8 as default encoding
	 * @see #readFile(File, String)
	 */
	public static String readFile(final File file) throws IOException {
		return readFile(file, "UTF8");
	}
	
	/**
	 * Read the content of the given file into a string.
	 *
	 * @param file the file to be read
	 * @param encoding encoding to use
	 * @return the file contents or null if file is null or does not exist, or can't be read, or is not a file
	 * @throws IOException if an error occurs during read
	 */
	public static String readFile(final File file, final String encoding) throws IOException {
		if (file == null || !file.exists() || !file.canRead() || !file.isFile()) {
			return null;
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
		final StringBuilder sb = new StringBuilder((int) file.length());
		try {
			int c = 0;
			while ((c = in.read()) != -1) {
				sb.append((char)c);
			}
		} finally {
			in.close();
		}
		return sb.toString();
	}

	/**
	 * Read a resource from classpath using the context classloader
	 * @param resource the resource name to read, must not be null
	 * @param encoding optional, may be null in chich case UTF-8 is used
	 * @return read content or empty string if resource cannot be loaded
	 * @throws IOException
	 * @since 7.7
	 */
	public static String readResource(final String resource, final String encoding) throws IOException {
		final InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
		if (is == null) {
			return StringUtils.EMPTY;
		}
		return readStream(is, null);
	}
	/**
	 * Read the content of the given stream into a string.
	 *
	 * @param stream the contents to read
	 * @return the read content
	 * @see #readStream(InputStream, String)
	 * @throws IOException
	 * @since 7.7
	 */
	public static String readStream(final InputStream stream) throws IOException {
		return readStream(stream, null);
	}

	/**
	 * Read the content of the given stream into a string.
	 *
	 * @param stream the contents to read
	 * @param enconding optional encoding to use, if null "UTF-8" is used as default
	 * @return the read content
	 * @throws IOException
	 * @since 7.7
	 */
	public static String readStream(final InputStream stream, final String enconding) throws IOException {
		if (stream == null) {
			return null;
		}
		final StringBuilder out = new StringBuilder();
		final String enc = enconding != null ? enconding : "UTF-8";
		final Reader in = new InputStreamReader(stream, enc);
		try {
			int c = 0;
			while ((c = in.read()) != -1) {
				out.append((char)c);
			}
		} finally {
			in.close();
		}
		return out.toString();
	}

	/**
	 * Read the content of the given reader into a string.
	 *
	 * @param reader the contents to read
	 * @return the read content
	 * @throws IOException
	 * @since 7.7
	 */
	public static String readReader(final Reader reader) throws IOException {
		if (reader == null) {
			return null;
		}
		final StringBuilder out = new StringBuilder();
		try {
			int c = 0;
			while ((c = reader.read()) != -1) {
				out.append((char) c);
			}
		} finally {
			reader.close();
		}
		return out.toString();
	}
}

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
package com.prowidesoftware.swift.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

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
	 * Read the content of the given file into a string, using UTF8 as default encoding
	 * @see #readFile(File, String)
	 */
	public static String readFile(final File file) throws IOException {
		return readFile(file, null);
	}
	
	/**
	 * Read the content of the given file into a string.
	 *
	 * @param file the file to be read
	 * @param encoding encoding to use, may be null in which case UTF-8 is used as default
	 * @return the file contents or null if file is null or does not exist, or can't be read, or is not a file
	 * @throws IOException if an error occurs during read
	 */
	public static String readFile(final File file, final String encoding) throws IOException {
		if (file == null || !file.exists() || !file.canRead() || !file.isFile()) {
			return null;
		}
		final String charset = encoding != null? encoding : "UTF-8";
		final StringBuilder sb = new StringBuilder((int) file.length());
		try (
				FileInputStream fileStream = new FileInputStream(file);
				BufferedReader in = new BufferedReader(new InputStreamReader(fileStream, charset))
		) {
			int c;
			while ((c = in.read()) != -1) {
				sb.append((char)c);
			}
		}
		return sb.toString();
	}

	/**
	 * Read a resource from classpath using the context classloader, using UTF8 as default encoding
	 * @see #readResource(String, String)
	 * @since 7.10.0
	 */
	public static String readResource(final String resource) throws IOException {
		return readResource(resource, null);
	}

	/**
	 * Read a resource from classpath using the current thread classloader
	 * @see #readResource(String, String, Class)
	 * @param resource the resource name to read, must not be null
	 * @param encoding optional, may be null in which case UTF-8 is used as default
	 * @return read content or empty string if resource cannot be loaded
	 * @throws IOException if the resource stream cannot be read
	 * @since 7.7
	 */
	public static String readResource(final String resource, final String encoding) throws IOException {
		return readResource(resource, encoding, null);
	}

	/**
	 * Read a resource from classpath.
	 *
	 * <p>The implementation will attempt first to use the current thread classloader, and if the resource is not found
	 * it will use the classloader from the parameter class. This class parameter should be the class that is calling
	 * this method.
	 *
	 * @param resource the resource name to read, must not be null
	 * @param encoding optional, may be null in which case UTF-8 is used as default
	 * @param clazz optional parameter with the loading object class, for the fallback attempt
	 * @return read content or empty string if resource cannot be loaded
	 * @throws IOException if the resource stream cannot be read
	 * @since 8.0.3
	 */
	public static String readResource(final String resource, final String encoding, Class clazz) throws IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
		if (is == null && clazz != null) {
			// if not found we fallback with this loading object classloader
			is = clazz.getClassLoader().getResourceAsStream(resource);
		}
		if (is == null) {
			return StringUtils.EMPTY;
		}
		return readStream(is, encoding);
	}

	/**
	 * Read the content of the given stream into a string.
	 *
	 * @param stream the contents to read
	 * @return the read content
	 * @see #readStream(InputStream, String)
	 * @throws IOException if the resource stream cannot be read
	 * @since 7.7
	 */
	public static String readStream(final InputStream stream) throws IOException {
		return readStream(stream, null);
	}

	/**
	 * Read the content of the given stream into a string.
	 *
	 * @param stream the contents to read
	 * @param enconding encoding to use, , may be null in which case UTF-8 is used as default
	 * @return the read content
	 * @throws IOException if the resource stream cannot be read
	 * @since 7.7
	 */
	public static String readStream(final InputStream stream, final String enconding) throws IOException {
		if (stream == null) {
			return null;
		}
		final StringBuilder out = new StringBuilder();
		final String enc = enconding != null ? enconding : "UTF-8";
		try (Reader in = new InputStreamReader(stream, enc)) {
			int c;
			while ((c = in.read()) != -1) {
				out.append((char)c);
			}
		}
		return out.toString();
	}

	/**
	 * Read the content of the given reader into a string.
	 *
	 * @param reader the contents to read
	 * @return the read content
	 * @throws IOException if the resource stream cannot be read
	 * @since 7.7
	 */
	public static String readReader(final Reader reader) throws IOException {
		if (reader == null) {
			return null;
		}
		final StringBuilder out = new StringBuilder();
		try {
			int c;
			while ((c = reader.read()) != -1) {
				out.append((char) c);
			}
		} finally {
			reader.close();
		}
		return out.toString();
	}

}
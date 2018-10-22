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
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
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
	 * Read a resource from classpath using the context classloader, using UTF8 as default encoding
	 * @see #readResource(String, String)
	 * @since 7.10.0
	 */
	public static String readResource(final String resource) throws IOException {
		return readResource(resource, null);
	}

	/**
	 * Read a resource from classpath using the context classloader
	 * @param resource the resource name to read, must not be null
	 * @param encoding optional, may be null in which case UTF-8 is used as default
	 * @return read content or empty string if resource cannot be loaded
	 * @throws IOException if the resource stream cannot be read
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
			int c = 0;
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
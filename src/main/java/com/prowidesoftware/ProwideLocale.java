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
package com.prowidesoftware;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Helper class to manage default supported locales
 * 
 * @author miguel
 *
 * @since 7.7
 */
public final class ProwideLocale {
	public static String[] SUPPORTED_LANGS = new String[] { "en", "es", "fr", "it", "ru" };
	
	/**
	 * Get requested bundle or ENGLISH if missing resource for the given locale.
	 * Uses the calss FQN (with package) for the resource location.
	 * 
	 * @param clazz
	 *            the class for which the resource bundle is loaded
	 * @param locale
	 *            a locale
	 * @return the bundle for the given class and locale or English if not found.
	 * @since 7.7
	 */
	public static ResourceBundle getBundle(Class<? extends Object> clazz, Locale locale) {
		return getBundle(clazz.getName(), locale);
    }

	/**
	 * Safe get locale, checking if current locale is supported Same as
	 * <code>getBundle(clazz, Locale.getDefault()))</code>
	 * 
	 * @see #getBundle(Class, Locale)
	 * @since 7.7
	 */
	public static ResourceBundle getBundle(Class<? extends Object> clazz) {
		return getBundle(clazz.getName());
    }

	/**
	 * Get requested bundle or ENGLISH if missing resource for the given locale.
	 * 
	 * @param resource
	 *            the name ot the resource bundle to loaded
	 * @param locale
	 *            a locale
	 * @return the bundle for the given resource name and locale or English if not
	 *         found.
	 * @since 7.9.7
	 */
	public static ResourceBundle getBundle(final String resource, Locale locale) {
		try {
			return java.util.ResourceBundle.getBundle(resource, locale);
		} catch (MissingResourceException e) {
			return java.util.ResourceBundle.getBundle(resource, Locale.ENGLISH);
		}
	}

	/**
	 * Safe get locale, checking if current locale is supported Same as
	 * <code>getBundle(resource, Locale.getDefault()))</code>
	 * 
	 * @see #getBundle(String, Locale)
	 * @since 7.9.7
	 */
	public static ResourceBundle getBundle(final String resource) {
		return getBundle(resource, Locale.getDefault());
	}

}

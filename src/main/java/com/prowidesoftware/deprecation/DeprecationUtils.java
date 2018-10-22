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
package com.prowidesoftware.deprecation;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;

/**
 * Helper API to implement the http://www.prowidesoftware.com/resources/deprecation-policy
 * 
 * @author sebastian
 * @since 7.8.9
 */
public class DeprecationUtils {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(DeprecationUtils.class.getName());

	/**
	 * Environment variable used to switch off deprecation phase implementation
	 */
	public static final String PW_DEPRECATED = "PW_DEPRECATED";
	
	// Suppress default constructor for noninstantiability
	private DeprecationUtils() {
		throw new AssertionError();
	}
	
	/**
	 * According to the deprecation policy this method implements the phase 2 which 
	 * involves logging a warning and making a small pause in the execution thread.
	 * @param message the log message
	 */
	@SuppressWarnings("rawtypes")
	public static void phase2(final Class clazz, final String method, final String message) {
		if (!isSet(EnvironmentVariableKey.NOLOG)) {
			log.warning(notice(clazz, method) + message);
		}
		if (!isSet(EnvironmentVariableKey.NODELAY)) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				log.log(Level.WARNING, notice(clazz, method) + message, e);
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static String notice(final Class clazz, final String method) {
		StringBuilder note = new StringBuilder();
		note.append("The API ").append(clazz.getSimpleName());
		if (method != null) {
			note.append("#").append(method);
		}
		note.append(" is deprecated. ");
		return note.toString();
	}
	
	/**
	 * According to the deprecation policy this method implements the phase 3 which 
	 * involves throwing a runtime exception.
	 * @param message the log message
	 */
	@SuppressWarnings("rawtypes")
	public static void phase3(final Class clazz, final String method, final String message) {
		if (!isSet(EnvironmentVariableKey.NOEXCEPTION)) {
			throw new UnsupportedOperationException(notice(clazz, method) + message);
		} else {
			/*
			 * fall back to phase 2
			 */
			phase2(clazz, method, message);
		}
	}
	
	/**
	 * Returns true if the environment variable {@link #PW_DEPRECATED} contains
	 * the given key in its value
	 */
	private static final boolean isSet(final EnvironmentVariableKey key) {
		return StringUtils.containsIgnoreCase(System.getenv(PW_DEPRECATED), key.name());
	}
	
	/**
	 * Keywords for the environment variable {@link #PW_DEPRECATED}
	 */
	public enum EnvironmentVariableKey {
		NOLOG,
		NODELAY,
		NOEXCEPTION
	}
	
	/**
	 * Helper hack to set the environment variable from Java.
	 * 
	 * <p>For example if all keys are passed as parameter, this will set 
	 * the environment variable PW_DEPRECATED=nolog,nodelay,noexception
	 *  
	 * @param keys the variables to set in the environment variable
	 */
	public static void setEnv(EnvironmentVariableKey ...keys) {
		if (keys != null && keys.length > 0) {
			StringBuilder value = new StringBuilder();
			for (EnvironmentVariableKey key : keys) {
				if (value.length() > 0) {
					value.append(",");
				}
				value.append(key.name().toLowerCase());
			}
			setEnv(PW_DEPRECATED, value.toString());
		}
	}
	
	/**
	 * Sets the environment variable PW_DEPRECATED to an empty string, meaning
	 * all flags corresponding to the deprecation phase will be active by default.
	 */
	public static void clearEnv() {
		setEnv(PW_DEPRECATED, "");
	}
	
	/**
	 * Helper hack to set environment variables from Java code
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void setEnv(final String key, final String value) {
		try {
			Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
			Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
			theEnvironmentField.setAccessible(true);
			Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
			env.put(key, value);
			Field theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
			theCaseInsensitiveEnvironmentField.setAccessible(true);
			Map<String, String> cienv = (Map<String, String>) theCaseInsensitiveEnvironmentField.get(null);
			cienv.put(key, value);
		} catch (NoSuchFieldException e) {
			try {
				Class[] classes = Collections.class.getDeclaredClasses();
				Map<String, String> env = System.getenv();
				for(Class cl : classes) {
					if("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
						Field field = cl.getDeclaredField("m");
						field.setAccessible(true);
						Object obj = field.get(env);
						Map<String, String> map = (Map<String, String>) obj;
						map.clear();
						map.put(key, value);
					}
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
}

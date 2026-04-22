/*
 * Copyright 2006-2023 Prowide
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

import java.util.logging.Level;
import org.apache.commons.lang3.Strings;

/**
 * Helper API to implement the http://www.prowidesoftware.com/resources/deprecation-policy
 *
 * @since 7.8.9
 */
public class DeprecationUtils {
    /**
     * Environment variable used to switch off deprecation phase implementation
     */
    public static final String PW_DEPRECATED = "PW_DEPRECATED";

    private static final transient java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(DeprecationUtils.class.getName());

    // Suppress default constructor for noninstantiability
    private DeprecationUtils() {
        throw new AssertionError();
    }

    /**
     * According to the deprecation policy this method implements the phase 2 which
     * involves logging a warning and making a small pause in the execution thread.
     *
     * @param clazz deprecated class
     * @param method name of deprecated method
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
     *
     * @param clazz deprecated class
     * @param method name of deprecated method
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
     * Returns true if the {@link #PW_DEPRECATED} configuration contains the given key.
     *
     * <p>The configuration is read from two channels, in this order of precedence:
     * <ol>
     *     <li>JVM system property {@code -DPW_DEPRECATED=...} or values set via {@link #setEnv(EnvironmentVariableKey...)}</li>
     *     <li>OS environment variable {@code PW_DEPRECATED}</li>
     * </ol>
     * A key is considered active if it appears (case-insensitive) in either source.
     */
    private static boolean isSet(final EnvironmentVariableKey key) {
        return Strings.CI.contains(System.getProperty(PW_DEPRECATED), key.name())
                || Strings.CI.contains(System.getenv(PW_DEPRECATED), key.name());
    }

    /**
     * Enables the given deprecation flags at runtime from Java code by setting
     * the JVM system property {@link #PW_DEPRECATED}.
     *
     * <p>For example, if all keys are passed as parameter, this will set the
     * system property to {@code PW_DEPRECATED=nolog,nodelay,noexception}.
     *
     * <p>Any value previously set in the OS environment variable {@link #PW_DEPRECATED}
     * is still honored in addition to the flags set through this method.
     *
     * @param keys the variables to enable
     */
    public static void setEnv(EnvironmentVariableKey... keys) {
        if (keys != null && keys.length > 0) {
            StringBuilder value = new StringBuilder();
            for (EnvironmentVariableKey key : keys) {
                if (value.length() > 0) {
                    value.append(",");
                }
                value.append(key.name().toLowerCase());
            }
            System.setProperty(PW_DEPRECATED, value.toString());
        }
    }

    /**
     * Clears any deprecation flags previously enabled through {@link #setEnv(EnvironmentVariableKey...)}.
     *
     * <p>Note that this does not override flags set via the OS environment variable
     * {@link #PW_DEPRECATED}; those remain in effect for the lifetime of the JVM.
     */
    public static void clearEnv() {
        System.clearProperty(PW_DEPRECATED);
    }

    /**
     * Keywords for the environment variable {@link #PW_DEPRECATED}
     */
    public enum EnvironmentVariableKey {
        NOLOG,
        NODELAY,
        NOEXCEPTION
    }
}

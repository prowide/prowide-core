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
package com.prowidesoftware;

import java.util.*;
import java.util.Map.Entry;

/**
 * Base class for Prowide exceptions hierarchy.
 *
 * @since 7.7
 */
public class ProwideException extends RuntimeException {
    private static final long serialVersionUID = 4645197208853563727L;
    private static final transient java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(ProwideException.class.getName());

    private final Map<String, String> variables = new HashMap<>();

    public ProwideException() {}

    public ProwideException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ProwideException(final String message) {
        super(message);
    }

    public ProwideException(final Throwable cause) {
        super(cause);
    }

    public static ResourceBundle getBundle() {
        return ProwideLocale.getBundle(ProwideException.class.getSimpleName());
    }

    public static ResourceBundle getBundle(final Locale locale) {
        return ProwideLocale.getBundle(ProwideException.class.getSimpleName(), locale);
    }

    /**
     * Gets a descriptive, localized error message suitable for presenting to the final user.
     *
     * @param locale optional locale
     * @return exception description
     */
    public String getMessage(final Locale locale) {
        return getMessage(locale, null);
    }

    /**
     * Gets a descriptive message suitable for presenting to the final user, using the default locale.
     *
     * @return the formated text message
     */
    @Override
    public String getMessage() {
        return getMessage(null, null);
    }

    /**
     * Gets a descriptive, localized error message suitable for presenting to the final user.
     *
     * @param locale    optional locale
     * @param variables optional map of variables to replace in the message read from resource bundle
     * @return exception description
     */
    protected String getMessage(final Locale locale, final Map<String, String> variables) {
        ResourceBundle bundle;
        try {
            bundle = locale == null ? getBundle() : getBundle(locale);
        } catch (final MissingResourceException ignored) {
            final String lan = locale != null ? locale.getLanguage() : "en";
            return "Missing resource bundle. Please check that " + ProwideException.class.getSimpleName() + "_" + lan
                    + ".properties is present in the classpath";
        }
        final String key = this.getClass().getSimpleName();
        try {
            String msg = bundle.getString(key);
            msg = substitute(msg, this.variables);
            return substitute(msg, variables);
        } catch (final MissingResourceException ignored) {
            log.fine("No localized message found for exception key '" + key + "'");
            return super.getMessage();
        }
    }

    static String substitute(String message, Map<String, String> variables) {
        if (message == null) {
            return null;
        } else if (variables != null && !variables.isEmpty()) {
            for (Entry<String, String> e : variables.entrySet()) {
                message = message.replace("${" + e.getKey() + "}", e.getValue());
            }
        }
        return message;
    }

    /**
     * Initializes the variables Map if necessary and puts the parameter tuple.
     *
     * @param key   variable key
     * @param value variable value
     */
    protected void addVariable(final String key, final String value) {
        Objects.requireNonNull(key, "Key required");
        this.variables.put(key, value);
    }

    /**
     * Returns a variable value, if set, given its key
     *
     * @param key variable key name
     * @return found variable value or null if not found
     */
    protected String getVariable(final String key) {
        Objects.requireNonNull(key, "Key required");
        return this.variables.get(key);
    }
}

/*
 * Copyright 2006-2021 Prowide
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

import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;

/**
 * To indicate the validation problem found when validating a BIC
 *
 * @author sebastian
 * @see BIC#validate()
 * @since 7.10.3
 */
public enum BicValidationResult {
    OK("The BIC code is valid"),

    INVALID_LENGTH("The BIC code must contain at least 8 characters with the institution (4), country (2) and location code (2)"),
    INVALID_INSTITUTION_LENGTH("The institution code must contain 4 characters and ${length} were found in ${found}"),
    INVALID_COUNTRY_LENGTH("The country code must contain 2 characters and ${length} were found in ${found}"),
    INVALID_LOCATION_LENGTH("The location code must contain 2 characters and ${length} were found in ${found}"),
    INVALID_BRANCH_LENGTH("The branch code must contain 3 characters and ${length} were found in ${found}"),
    INVALID_INSTITUTION_CHARSET("The institution code can only contain uppercase letters and ${found} was found"),
    INVALID_COUNTRY("Invalid country code ${found}"),
    INVALID_LOCATION_CHARSET("The location code can only contain uppercase letters or digits and ${found} was found"),
    INVALID_BRANCH_CHARSET("The branch code can only contain uppercase letters or digits and ${found} was found");

    private final String message;
    private final Map<String, String> vars = new HashMap<>();
    BicValidationResult(final String message) {
        this.message = message;
    }

    /**
     * Validation problem description including expected and found content when necessary.
     *
     * @return message with variables replaced
     */
    public String message() {
        final StringSubstitutor sub = new StringSubstitutor(this.vars);
        return sub.replace(this.message);
    }

    /**
     * Sets a "found" and "length" variable for messages text
     */
    void setFound(final String found) {
        this.vars.put("found", found);
        if (found != null) {
            this.vars.put("length", String.valueOf(found.length()));
        }
    }

}
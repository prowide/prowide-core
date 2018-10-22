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

import java.util.List;


/**
 * Container for a specific country BBAN structure.
 *
 * <p>BBAN is short for Basic Bank Account Number. It represents a country-specific bank account number.
 * The BBAN is the last part of the IBAN when used for international funds transfers.
 * Every country has it's specific BBAN format and length depending on it's own standards.
 *
 * @since 7.9.7
 * @author psantamarina
 */
public class BbanStructureDTO {
    /**
     * The country code.
     */
    private String country_code;

    /**
     * The validation rules list.
     */
    private List<BbanStructureEntryDTO> validation_rules = null;

    /**
     * Gets validation rules list.
     *
     * @return the validation rules list.
     */
    public List<BbanStructureEntryDTO> getValidation_rules() {
        return validation_rules;
    }

    /**
     * Sets the validation rules list.
     *
     * @param validation_rules the validation rules list.
     */
    public void setValidation_rules(List<BbanStructureEntryDTO> validation_rules) {
        this.validation_rules = validation_rules;
    }

    /**
     * Gets country code.
     *
     * @return the country code
     */
    public String getCountry_coode() {
        return country_code;
    }

    /**
     * Sets country code.
     *
     * @param country_coode the character type
     */
    public void setCountry_coode(String country_coode) {
        this.country_code = country_coode;
    }

}

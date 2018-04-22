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
package com.prowidesoftware.swift.model;

import java.util.List;


/**
 * Container for a specific country BBAN structure.
 *
 * <p>BBAN is short for Basic Bank Account Number. It represents a country-specific bank account number.
 * The BBAN is the last part of the IBAN when used for international funds transfers.
 * Every country has it's specific BBAN format and length depending on it's own standards.</p>
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

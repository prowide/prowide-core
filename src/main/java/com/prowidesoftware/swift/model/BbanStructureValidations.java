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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.prowidesoftware.swift.utils.Lib;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;


/**
 * This singleton handles all the available BBAN structure entries.
 *
 * <p>BBAN is short for Basic Bank Account Number. It represents a country-specific bank account number.
 * The BBAN is the last part of the IBAN when used for international funds transfers.
 * Every country has it's specific BBAN format and length depending on it's own standards.</p>
 *
 * @since 7.9.7
 * @author psantamarina
 */
public class BbanStructureValidations {
    private static transient final java.util.logging.Logger log = java.util.logging.Logger.getLogger(BbanStructureValidations.class.getName());

    private static BbanStructureValidations instance = null;

    private static final Type REVIEW_TYPE = new TypeToken<List<BbanStructureDTO>>() {}.getType();
    private static String JSON_FILE = "BbanStructureValidations.json";

    private List<BbanStructureDTO> bbanStructures = null;

    private BbanStructureValidations() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BbanEntryType.class, new BbanEntryTypeDeserializer());
        Gson gson = gsonBuilder.create();
        String reader = null;
        try {
            reader = Lib.readResource(JSON_FILE,null);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Cannot load "+ JSON_FILE + " from classpath, the BBAN structure validations will be initialized empty", e);
        }
        if (reader != null) {
            this.bbanStructures = gson.fromJson(reader, REVIEW_TYPE);
        }
    }

    public static BbanStructureValidations getInstance() {
        if (instance==null) {
            instance = new BbanStructureValidations();
        }
        return instance;
    }

    /**
     * Gets the BBAN structure entries
     * @return the list of all available BBAN structures entries.
     */
    public List<BbanStructureDTO> getBbanStructures() {
        return bbanStructures;
    }

    /**
     * Sets the BBAN structure entries
     * @param bbanStructures the list of BBAN structures entries to set.
     * @see #add(BbanStructureDTO)
     */
    public void setBbanStructures(List<BbanStructureDTO> bbanStructures) {
        this.bbanStructures = bbanStructures;
    }

    /**
     * Gets the specific BBAN structure for a given country code.
     * @param countryCode the country code to search (two letters ISO country code)
     * @return BbanStructure for specified country or null if country is not supported.
     * @see #contains(String)
     */
    public BbanStructureDTO forCountry(final String countryCode) {
        BbanStructureDTO bbanStructure = null;
        if (this.bbanStructures != null) {
            for (BbanStructureDTO structure : this.bbanStructures) {
                if (StringUtils.equals(structure.getCountry_coode(), countryCode)) {
                    bbanStructure = structure;
                    break;
                }
            }
        }
        return bbanStructure;
    }

    /**
     * Checks if the given country is configured for BBAN validations
     * @param countryCode the country code to check (two letters ISO country code)
     * @return true if a BBAN structure exists for the given country
     */
    public boolean contains(final String countryCode) {
        return supportedCountries().contains(countryCode);
    }

    /**
     * Gets the list of countries configured for BBAN validation
     */
    public List<String> supportedCountries() {
        final List<String> countryCodes = new ArrayList<String>(bbanStructures.size());
        for (BbanStructureDTO structure : this.bbanStructures){
            countryCodes.add(structure.getCountry_coode());
        }
        return Collections.unmodifiableList(countryCodes);
    }

    /**
     * Adds a new country BBAN structure configuration
     * @param bbanStructure the specific BBAN configuration to add
     */
    public BbanStructureValidations add(final BbanStructureDTO bbanStructure) {
        if (this.bbanStructures == null) {
            this.bbanStructures = new ArrayList<BbanStructureDTO>();
        }
        if (contains(bbanStructure.getCountry_coode())) {
            log.warning("Duplicate BBAN configuration for country " + bbanStructure.getCountry_coode());
        }
        this.bbanStructures.add(bbanStructure);
        return this;
    }

}
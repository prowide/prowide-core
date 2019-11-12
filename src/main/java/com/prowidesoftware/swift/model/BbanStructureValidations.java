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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.prowidesoftware.swift.utils.Lib;
import org.apache.commons.lang3.StringUtils;

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
 * Every country has it's specific BBAN format and length depending on it's own standards.
 *
 * @since 7.9.7
 * @author psantamarina
 */
public class BbanStructureValidations {
    private static transient final java.util.logging.Logger log = java.util.logging.Logger.getLogger(BbanStructureValidations.class.getName());

    private volatile static BbanStructureValidations instance = null;

    private static final Type REVIEW_TYPE = new TypeToken<List<BbanStructureDTO>>() {}.getType();
    private static String JSON_FILE = "BbanStructureValidations.json";

    private List<BbanStructureDTO> bbanStructures = null;

    private BbanStructureValidations() {
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(BbanEntryType.class, new BbanEntryTypeDeserializer())
            .create();
        String reader = null;
        try {
            reader = Lib.readResource(JSON_FILE,null, BbanStructureValidations.class);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Cannot load "+ JSON_FILE + " from classpath, the BBAN structure validations will be initialized empty", e);
        }
        if (reader != null) {
            this.bbanStructures = gson.fromJson(reader, REVIEW_TYPE);
        }
    }

    public static BbanStructureValidations getInstance() {
        if (instance == null){
            synchronized (BbanStructureValidations.class) {
                if (instance == null) {
                    instance = new BbanStructureValidations();
                }
            }
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
        final List<String> countryCodes = new ArrayList<>(bbanStructures.size());
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
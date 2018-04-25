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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The bban structure entry.
 * @since 7.9.7
 * @author psantamarina
 */
public class BbanStructureEntryDTO {

    /**
     * The Entry type.
     */
    @SerializedName("entry_type")
    @Expose
    private BbanEntryType entryType;

    /**
     * The character type.
     */
    @SerializedName("character_type")
    @Expose
    private SwiftCharset characterType;

    /**
     * The length.
     */
    @SerializedName("length")
    @Expose
    private int length;


    /**
     * Gets entry type.
     *
     * @return the entry type
     */
    public BbanEntryType getEntryType() {
        return entryType;
    }

    /**
     * Sets entry type.
     *
     * @param entryType the entry type
     */
    public void setEntryType(String entryType) {
        this.entryType = BbanEntryType.fromString(entryType);
    }

    /**
     * Gets character type
     *
     * @return the character type.
     */
    public SwiftCharset getCharacterType() {
        return characterType;
    }

    /**
     * Sets character type.
     *
     * @param characterType the character type
     */
    public void setCharacterType(SwiftCharset characterType) {
        this.characterType = characterType;
    }

    /**
     * Gets length
     *
     * @return the length.
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets length.
     *
     * @param length the length
     */
    public void setLength(int length) {
        this.length = length;
    }

}

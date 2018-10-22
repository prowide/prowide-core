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

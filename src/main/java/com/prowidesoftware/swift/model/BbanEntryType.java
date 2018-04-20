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

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


/**
 * Basic Bank Account Number Entry Types.
 * @since 7.9.7
 * @author psantamarina
 */
public enum BbanEntryType {
    BANK_CODE("bank_code"),
    BRANCH_CODE("branch_code"),
    ACCOUNT_NUMBER("account_number"),
    NATIONAL_CHECK_DIGIT("national_check_digit"),
    ACCOUNT_TYPE("account_type"),
    OWNER_ACCOUNT_NUMBER("owner_account_number"),
    IDENTIFICATION_NUMBER("identification_number");

    private String text;

    BbanEntryType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static BbanEntryType fromString(String text) {
        for (BbanEntryType b : BbanEntryType.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

}

class BbanEntryTypeDeserializer implements JsonDeserializer<BbanEntryType>
{
    @Override
    public BbanEntryType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        BbanEntryType[] scopes = BbanEntryType.values();
        for (BbanEntryType scope : scopes)
        {
            if (scope.getText().equals(json.getAsString()))
                return scope;
        }
        return null;
    }
}


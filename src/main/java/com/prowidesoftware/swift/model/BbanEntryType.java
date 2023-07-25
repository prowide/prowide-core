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
package com.prowidesoftware.swift.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/**
 * Basic Bank Account Number Entry Types.
 *
 * @author psantamarina
 * @since 7.9.7
 */
public enum BbanEntryType {
    BANK_CODE("bank_code"),
    BRANCH_CODE("branch_code"),
    ACCOUNT_NUMBER("account_number"),
    NATIONAL_CHECK_DIGIT("national_check_digit"),
    ACCOUNT_TYPE("account_type"),
    OWNER_ACCOUNT_NUMBER("owner_account_number"),
    IDENTIFICATION_NUMBER("identification_number"),
    CURRENCY("currency");

    private final String text;

    BbanEntryType(String text) {
        this.text = text;
    }

    public static BbanEntryType fromString(String text) {
        for (BbanEntryType b : BbanEntryType.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getText() {
        return this.text;
    }
}

class BbanEntryTypeDeserializer implements JsonDeserializer<BbanEntryType> {
    @Override
    public BbanEntryType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        BbanEntryType[] scopes = BbanEntryType.values();
        for (BbanEntryType scope : scopes) {
            if (scope.getText().equals(json.getAsString())) return scope;
        }
        return null;
    }
}

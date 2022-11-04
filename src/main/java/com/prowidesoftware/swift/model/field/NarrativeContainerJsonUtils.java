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
package com.prowidesoftware.swift.model.field;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;

/**
 * Helper API for the {@link NarrativeContainer} fields JSON support
 *
 * @since 9.1.4
 */
class NarrativeContainerJsonUtils {

    static void fromJson(JsonObject jsonObject, String json, StructuredNarrativeField field) {
        if (jsonObject.get("narrative") != null) {
            int numberOfNarrativesInJson = countNarrativesInJson(json);
            if (numberOfNarrativesInJson > 1) {
                JsonObject jsonWithNarrativeGroup = groupNarratives(json, numberOfNarrativesInJson);
                field.setComponent(1, jsonWithNarrativeGroup.get("narrative").getAsString());
            } else {
                field.setComponent(1, jsonObject.get("narrative").getAsString());
            }
        } else {
            if (jsonObject.get("structured") != null) {
                Narrative narrative = new Gson().fromJson(jsonObject, Narrative.class);
                field.setNarrative(narrative);
            }
        }
    }

    private static JsonObject groupNarratives(String json, int numberOfNarrativesInJson) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        JsonObject jsonObj = element.getAsJsonObject();

        String finalNarrativeValue = jsonObj.get("narrative").getAsString();
        for (int i = 2; i <= numberOfNarrativesInJson; i++) {
            String currentNarrativeValue = jsonObj.get("narrative" + i).getAsString();
            finalNarrativeValue = finalNarrativeValue + currentNarrativeValue;
            jsonObj.remove("narrative" + i);
        }

        jsonObj.addProperty("narrative", finalNarrativeValue);
        return jsonObj;
    }

    private static int countNarrativesInJson(String json) {
        return StringUtils.countMatches(json, "narrative")
                - (StringUtils.countMatches(json, "narrativeFragments")
                + StringUtils.countMatches(json, "narrativeSupplementFragments"));
    }

}

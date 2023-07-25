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
package com.prowidesoftware.swift.model.field;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Helper API for the {@link NarrativeContainer} fields JSON support
 *
 * @since 9.1.4
 */
class NarrativeContainerJsonUtils {

    static Pattern NARRATIVE_PATTERN = Pattern.compile("[\"|']narrative([0-9]*)[\"|']");

    static void fromJson(JsonObject jsonObject, String json, StructuredNarrativeField field) {
        if (jsonObject.get("narrative") != null) {
            int numberOfNarrativesInJson = countNarrativesInJson(json);
            if (numberOfNarrativesInJson > 1) {
                field.setComponent(1, groupNarratives(json, numberOfNarrativesInJson));
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

    private static String groupNarratives(String json, int numberOfNarrativesInJson) {
        JsonObject jsonObj = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        StringBuilder sb = new StringBuilder(jsonObj.get("narrative").getAsString());
        for (int i = 2; i <= numberOfNarrativesInJson; i++) {
            String currentNarrativeValue = jsonObj.get("narrative" + i).getAsString();
            sb.append(FINWriterVisitor.SWIFT_EOL);
            sb.append(currentNarrativeValue);
        }

        return sb.toString();
    }

    static int countNarrativesInJson(String json) {
        Matcher narrativeMatcher = NARRATIVE_PATTERN.matcher(json);
        int count = 0;
        while (narrativeMatcher.find()) {
            count++;
        }
        return count;
    }
}

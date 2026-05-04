/*
 * Copyright 2006-2026 Prowide
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

import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Gson adapter for {@link Calendar} that serializes months as 1-based (January=1, December=12)
 * instead of the Java Calendar internal 0-based convention (January=0, December=11).
 *
 * <p><b>Known limitations:</b>
 * <ul>
 *   <li>Milliseconds are not serialized. Any {@link Calendar#MILLISECOND} precision is lost on roundtrip.</li>
 *   <li>Timezone is not serialized. Deserialization always creates a {@link GregorianCalendar} in the JVM
 *       default timezone, regardless of the timezone set on the original Calendar instance.</li>
 * </ul>
 *
 * @since 10.3.13
 */
public class CalendarTypeAdapter implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {

    static final CalendarTypeAdapter INSTANCE = new CalendarTypeAdapter();

    @Override
    public JsonElement serialize(Calendar src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();
        obj.addProperty("year", src.get(Calendar.YEAR));
        obj.addProperty("month", src.get(Calendar.MONTH) + 1);
        obj.addProperty("dayOfMonth", src.get(Calendar.DAY_OF_MONTH));
        obj.addProperty("hourOfDay", src.get(Calendar.HOUR_OF_DAY));
        obj.addProperty("minute", src.get(Calendar.MINUTE));
        obj.addProperty("second", src.get(Calendar.SECOND));
        return obj;
    }

    @Override
    public Calendar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();
        int year = getRequiredInt(obj, "year");
        int month = getRequiredInt(obj, "month") - 1;
        int day = getRequiredInt(obj, "dayOfMonth");
        int hour = obj.has("hourOfDay") ? obj.get("hourOfDay").getAsInt() : 0;
        int minute = obj.has("minute") ? obj.get("minute").getAsInt() : 0;
        int second = obj.has("second") ? obj.get("second").getAsInt() : 0;
        return new GregorianCalendar(year, month, day, hour, minute, second);
    }

    private static int getRequiredInt(JsonObject obj, String field) {
        JsonElement element = obj.get(field);
        if (element == null) {
            throw new JsonParseException("Missing required Calendar field: " + field);
        }
        return element.getAsInt();
    }
}

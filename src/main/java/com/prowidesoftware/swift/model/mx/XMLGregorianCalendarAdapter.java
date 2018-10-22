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

package com.prowidesoftware.swift.model.mx;

import com.google.gson.*;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Type;

/**
 * Helper class for Gson serialization and deserialization of XMLGregorianCalendar
 * @since 7.10.3
 */
public class XMLGregorianCalendarAdapter implements JsonSerializer<XMLGregorianCalendar>, JsonDeserializer<XMLGregorianCalendar> {

    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final String DAY = "day";
    private static final String TIMEZONE = "timezone";
    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";
    private static final String SECOND = "second";
    private static final String FRACTIONAL = "fractionalSecond";

    @Override
    public JsonElement serialize(XMLGregorianCalendar cal, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject obj = new JsonObject();
        obj.addProperty(YEAR, cal.getYear());
        obj.addProperty(MONTH, cal.getMonth());
        obj.addProperty(DAY, cal.getDay());
        obj.addProperty(TIMEZONE, cal.getTimezone());
        obj.addProperty(HOUR, cal.getHour());
        obj.addProperty(MINUTE, cal.getMinute());
        obj.addProperty(SECOND, cal.getSecond());
        obj.addProperty(FRACTIONAL, cal.getFractionalSecond());
        return obj;
        // this alternative implementation is not working
        //return new JsonPrimitive(cal.toXMLFormat());
    }

    @Override
    public XMLGregorianCalendar deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            JsonObject obj  = jsonElement.getAsJsonObject();
            XMLGregorianCalendar xmlGregCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(
                    obj.get(YEAR).getAsInt(),
                    obj.get(MONTH).getAsInt(),
                    obj.get(DAY).getAsInt(),
                    obj.get(HOUR).getAsInt(),
                    obj.get(MINUTE).getAsInt(),
                    obj.get(SECOND).getAsInt(),
                    0,
                    obj.get(TIMEZONE).getAsInt());
            xmlGregCalendar.setFractionalSecond(obj.get(FRACTIONAL).getAsBigDecimal());
            return xmlGregCalendar;
            // use the line below as implementation in Java 8
            //return DatatypeFactory.newInstance().newXMLGregorianCalendar(jsonElement.getAsString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
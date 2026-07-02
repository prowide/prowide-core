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

import static org.junit.jupiter.api.Assertions.*;

import com.google.gson.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests that Calendar fields are serialized with 1-based months in JSON (January=1, December=12),
 * not the Java Calendar internal 0-based convention (January=0, December=11).
 */
class CalendarJsonSerializationTest {

    private static final String FIN = "{1:F01AAAAUSC0ADDD0344000050}{2:I103BBBBUSC0XFFFN}{4:\n"
            + ":20:TBEXO200909031\n"
            + ":23B:CRED\n"
            + ":32A:090903USD23453,\n"
            + ":50K:/01111001759234567890\n"
            + "JOE DOE\n"
            + "R00000V0574734\n"
            + ":53B:/00010013800002001234\n"
            + "MI BANCO\n"
            + ":59:/00013500510020179998\n"
            + "FOO CORP\n"
            + "R00000V000034534\n"
            + ":71A:OUR\n"
            + ":72:/TIPO/422\n"
            + "-}{5:{PDE:FOO}}";

    @Test
    void toJson_serializesMonthAsOneBased() {
        MtSwiftMessage m = new MtSwiftMessage(FIN);

        // Set a known date: April 10, 2026
        Calendar april = new GregorianCalendar(2026, Calendar.APRIL, 10, 6, 6, 7);
        m.setCreationDate(april);
        m.setLastModified(april);

        String json = m.toJson();
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        // month should be 4 (1-based April), not 3 (0-based)
        JsonObject creationDate = root.getAsJsonObject("creationDate");
        assertEquals(4, creationDate.get("month").getAsInt(), "April should be month 4 (1-based)");
        assertEquals(2026, creationDate.get("year").getAsInt());
        assertEquals(10, creationDate.get("dayOfMonth").getAsInt());

        JsonObject lastModified = root.getAsJsonObject("lastModified");
        assertEquals(4, lastModified.get("month").getAsInt(), "April should be month 4 (1-based)");
    }

    @Test
    void toJson_january_serializesAsOne() {
        MtSwiftMessage m = new MtSwiftMessage(FIN);

        Calendar january = new GregorianCalendar(2026, Calendar.JANUARY, 5, 0, 0, 0);
        m.setCreationDate(january);

        String json = m.toJson();
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        assertEquals(
                1, root.getAsJsonObject("creationDate").get("month").getAsInt(), "January should be month 1 (1-based)");
    }

    @Test
    void toJson_december_serializesAsTwelve() {
        MtSwiftMessage m = new MtSwiftMessage(FIN);

        Calendar december = new GregorianCalendar(2026, Calendar.DECEMBER, 25, 0, 0, 0);
        m.setCreationDate(december);

        String json = m.toJson();
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        assertEquals(
                12,
                root.getAsJsonObject("creationDate").get("month").getAsInt(),
                "December should be month 12 (1-based)");
    }

    @Test
    void toJson_statusTrailMonth_isOneBased() {
        MtSwiftMessage m = new MtSwiftMessage(FIN);

        Calendar september = new GregorianCalendar(2026, Calendar.SEPTEMBER, 15, 10, 30, 0);
        SwiftMessageStatusInfo status = new SwiftMessageStatusInfo("comments", september, "user", "LOADED");
        m.addStatus(status);

        String json = m.toJson();
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        JsonObject statusDate =
                root.getAsJsonArray("statusTrail").get(0).getAsJsonObject().getAsJsonObject("creationDate");
        assertEquals(9, statusDate.get("month").getAsInt(), "September should be month 9 (1-based)");
    }

    @Test
    void fromJson_deserializesOneBasedMonth() {
        String json = "{\n"
                + "  \"schemaVersion\": 4,\n"
                + "  \"message\": \"{1:F01AAAAUSC0ADDD0344000050}{2:I103BBBBUSC0XFFFN}{4:\\n:20:TBEXO200909031\\n:23B:CRED\\n:32A:090903USD23453,\\n:50K:/01111001759234567890\\nJOE DOE\\nR00000V0574734\\n:53B:/00010013800002001234\\nMI BANCO\\n:59:/00013500510020179998\\nFOO CORP\\nR00000V000034534\\n:71A:OUR\\n:72:/TIPO/422\\n-}\",\n"
                + "  \"identifier\": \"fin.103\",\n"
                + "  \"creationDate\": {\n"
                + "    \"year\": 2026,\n"
                + "    \"month\": 4,\n"
                + "    \"dayOfMonth\": 10,\n"
                + "    \"hourOfDay\": 6,\n"
                + "    \"minute\": 6,\n"
                + "    \"second\": 7\n"
                + "  }\n"
                + "}";

        MtSwiftMessage msg = MtSwiftMessage.fromJson(json);

        // month 4 in JSON (1-based) should be April = Calendar.APRIL (3 in 0-based)
        assertEquals(Calendar.APRIL, msg.getCreationDate().get(Calendar.MONTH));
        assertEquals(2026, msg.getCreationDate().get(Calendar.YEAR));
        assertEquals(10, msg.getCreationDate().get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void toJson_nullCalendarFields_producesValidJson() {
        MtSwiftMessage m = new MtSwiftMessage(FIN);
        // creationDate and lastModified are set by constructor; explicitly null them
        m.setCreationDate(null);
        m.setLastModified(null);

        String json = m.toJson();
        assertNotNull(json);

        // The JSON should parse without error; Gson omits null fields by default
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();
        assertFalse(root.has("creationDate"), "null creationDate should be omitted from JSON");
        assertFalse(root.has("lastModified"), "null lastModified should be omitted from JSON");

        // When deserialized, fields default to Calendar.getInstance() since they are
        // initialized in AbstractSwiftMessage and Gson does not overwrite with null for missing fields
        MtSwiftMessage restored = MtSwiftMessage.fromJson(json);
        assertNotNull(restored);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 13})
    void fromJson_outOfRangeMonth_isLenient(int month) {
        // GregorianCalendar is lenient by default; month 0 rolls to Dec of previous year,
        // month 13 rolls to Jan of next year. This test documents the behavior.
        String json = "{\n"
                + "  \"schemaVersion\": 4,\n"
                + "  \"message\": \"{1:F01AAAAUSC0ADDD0344000050}{2:I103BBBBUSC0XFFFN}{4:\\n:20:TBEXO200909031\\n:23B:CRED\\n:32A:090903USD23453,\\n:50K:/01111001759234567890\\nJOE DOE\\nR00000V0574734\\n:53B:/00010013800002001234\\nMI BANCO\\n:59:/00013500510020179998\\nFOO CORP\\nR00000V000034534\\n:71A:OUR\\n:72:/TIPO/422\\n-}\",\n"
                + "  \"identifier\": \"fin.103\",\n"
                + "  \"creationDate\": {\n"
                + "    \"year\": 2026,\n"
                + "    \"month\": " + month + ",\n"
                + "    \"dayOfMonth\": 15\n"
                + "  }\n"
                + "}";

        MtSwiftMessage msg = MtSwiftMessage.fromJson(json);
        Calendar cal = msg.getCreationDate();
        assertNotNull(cal);

        if (month == 0) {
            // month 0 in JSON -> adapter subtracts 1 -> Calendar month -1 -> lenient rolls to December of previous year
            assertEquals(Calendar.DECEMBER, cal.get(Calendar.MONTH));
            assertEquals(2025, cal.get(Calendar.YEAR));
        } else {
            // month 13 in JSON -> adapter subtracts 1 -> Calendar month 12 -> lenient rolls to January of next year
            assertEquals(Calendar.JANUARY, cal.get(Calendar.MONTH));
            assertEquals(2027, cal.get(Calendar.YEAR));
        }
    }

    @Test
    void toJson_valueDateAndTradeDate_areOneBased() {
        MtSwiftMessage m = new MtSwiftMessage(FIN);

        Calendar march = new GregorianCalendar(2026, Calendar.MARCH, 20, 9, 15, 0);
        Calendar november = new GregorianCalendar(2026, Calendar.NOVEMBER, 5, 16, 45, 30);
        m.setValueDate(march);
        m.setTradeDate(november);

        String json = m.toJson();
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        JsonObject valueDate = root.getAsJsonObject("valueDate");
        assertEquals(3, valueDate.get("month").getAsInt(), "March should be month 3 (1-based)");
        assertEquals(2026, valueDate.get("year").getAsInt());
        assertEquals(20, valueDate.get("dayOfMonth").getAsInt());

        JsonObject tradeDate = root.getAsJsonObject("tradeDate");
        assertEquals(11, tradeDate.get("month").getAsInt(), "November should be month 11 (1-based)");
        assertEquals(2026, tradeDate.get("year").getAsInt());
        assertEquals(5, tradeDate.get("dayOfMonth").getAsInt());
    }

    @Test
    void adapter_serialize_directCall() {
        CalendarTypeAdapter adapter = CalendarTypeAdapter.INSTANCE;
        Calendar cal = new GregorianCalendar(2026, Calendar.MARCH, 15, 10, 30, 45);

        JsonElement json = adapter.serialize(cal, Calendar.class, null);
        JsonObject obj = json.getAsJsonObject();

        assertEquals(2026, obj.get("year").getAsInt());
        assertEquals(3, obj.get("month").getAsInt(), "March should be 3 (1-based)");
        assertEquals(15, obj.get("dayOfMonth").getAsInt());
        assertEquals(10, obj.get("hourOfDay").getAsInt());
        assertEquals(30, obj.get("minute").getAsInt());
        assertEquals(45, obj.get("second").getAsInt());
    }

    @Test
    void adapter_deserialize_directCall() {
        CalendarTypeAdapter adapter = CalendarTypeAdapter.INSTANCE;
        JsonObject obj = new JsonObject();
        obj.addProperty("year", 2025);
        obj.addProperty("month", 7);
        obj.addProperty("dayOfMonth", 4);
        obj.addProperty("hourOfDay", 8);
        obj.addProperty("minute", 20);
        obj.addProperty("second", 10);

        Calendar cal = adapter.deserialize(obj, Calendar.class, null);

        assertEquals(2025, cal.get(Calendar.YEAR));
        assertEquals(Calendar.JULY, cal.get(Calendar.MONTH), "JSON month 7 (1-based) should be July");
        assertEquals(4, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(8, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(20, cal.get(Calendar.MINUTE));
        assertEquals(10, cal.get(Calendar.SECOND));
    }

    @Test
    void adapter_deserialize_missingRequiredField_throws() {
        CalendarTypeAdapter adapter = CalendarTypeAdapter.INSTANCE;
        JsonObject obj = new JsonObject();
        obj.addProperty("year", 2025);
        // missing "month" and "dayOfMonth"

        assertThrows(JsonParseException.class, () -> adapter.deserialize(obj, Calendar.class, null));
    }

    @Test
    void adapter_deserialize_optionalTimeFields_defaultToZero() {
        CalendarTypeAdapter adapter = CalendarTypeAdapter.INSTANCE;
        JsonObject obj = new JsonObject();
        obj.addProperty("year", 2026);
        obj.addProperty("month", 1);
        obj.addProperty("dayOfMonth", 1);
        // no hourOfDay, minute, second

        Calendar cal = adapter.deserialize(obj, Calendar.class, null);

        assertEquals(0, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, cal.get(Calendar.MINUTE));
        assertEquals(0, cal.get(Calendar.SECOND));
    }

    @Test
    void toJson_includesSchemaVersionMarker() {
        MtSwiftMessage m = new MtSwiftMessage(FIN);

        String json = m.toJson();
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        assertTrue(root.has("schemaVersion"), "toJson output must include the schemaVersion marker");
        assertEquals(
                AbstractSwiftMessage.JSON_SCHEMA_VERSION,
                root.get("schemaVersion").getAsInt(),
                "schemaVersion must match AbstractSwiftMessage.JSON_SCHEMA_VERSION");
    }

    @Test
    void fromJson_legacyPayloadWithoutMarker_deserializesZeroBasedMonth() {
        // Legacy format: month is 0-based (January=0, December=11), no schemaVersion marker.
        // Month 7 in legacy JSON corresponds to Calendar.AUGUST (which is also 7 in 0-based).
        String json = "{\n"
                + "  \"message\": \"{1:F01AAAAUSC0ADDD0344000050}{2:I103BBBBUSC0XFFFN}{4:\\n:20:TBEXO200909031\\n:23B:CRED\\n:32A:090903USD23453,\\n:50K:/01111001759234567890\\nJOE DOE\\nR00000V0574734\\n:53B:/00010013800002001234\\nMI BANCO\\n:59:/00013500510020179998\\nFOO CORP\\nR00000V000034534\\n:71A:OUR\\n:72:/TIPO/422\\n-}\",\n"
                + "  \"identifier\": \"fin.103\",\n"
                + "  \"creationDate\": {\n"
                + "    \"year\": 2025,\n"
                + "    \"month\": 7,\n"
                + "    \"dayOfMonth\": 15,\n"
                + "    \"hourOfDay\": 14,\n"
                + "    \"minute\": 30,\n"
                + "    \"second\": 0\n"
                + "  }\n"
                + "}";

        MtSwiftMessage msg = MtSwiftMessage.fromJson(json);

        assertEquals(2025, msg.getCreationDate().get(Calendar.YEAR));
        assertEquals(Calendar.AUGUST, msg.getCreationDate().get(Calendar.MONTH));
        assertEquals(15, msg.getCreationDate().get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void fromJson_payloadWithMarker_deserializesOneBasedMonth() {
        // New format: month is 1-based (January=1, December=12), schemaVersion marker present.
        // Month 8 in new JSON corresponds to Calendar.AUGUST (which is 7 in 0-based).
        String json = "{\n"
                + "  \"schemaVersion\": 4,\n"
                + "  \"message\": \"{1:F01AAAAUSC0ADDD0344000050}{2:I103BBBBUSC0XFFFN}{4:\\n:20:TBEXO200909031\\n:23B:CRED\\n:32A:090903USD23453,\\n:50K:/01111001759234567890\\nJOE DOE\\nR00000V0574734\\n:53B:/00010013800002001234\\nMI BANCO\\n:59:/00013500510020179998\\nFOO CORP\\nR00000V000034534\\n:71A:OUR\\n:72:/TIPO/422\\n-}\",\n"
                + "  \"identifier\": \"fin.103\",\n"
                + "  \"creationDate\": {\n"
                + "    \"year\": 2025,\n"
                + "    \"month\": 8,\n"
                + "    \"dayOfMonth\": 15,\n"
                + "    \"hourOfDay\": 14,\n"
                + "    \"minute\": 30,\n"
                + "    \"second\": 0\n"
                + "  }\n"
                + "}";

        MtSwiftMessage msg = MtSwiftMessage.fromJson(json);

        assertEquals(2025, msg.getCreationDate().get(Calendar.YEAR));
        assertEquals(Calendar.AUGUST, msg.getCreationDate().get(Calendar.MONTH));
        assertEquals(15, msg.getCreationDate().get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void fromJson_legacyPayloadWithJanuary_deserializesAsJanuary() {
        // In legacy format, January is encoded as month 0 (Calendar.JANUARY).
        // This is the most sensitive case: under the new adapter, month 0 would be lenient-rolled
        // to December of the previous year. The marker-based discrimination must prevent that.
        String json = "{\n"
                + "  \"message\": \"{1:F01AAAAUSC0ADDD0344000050}{2:I103BBBBUSC0XFFFN}{4:\\n:20:TBEXO200909031\\n:23B:CRED\\n:32A:090903USD23453,\\n:50K:/01111001759234567890\\nJOE DOE\\nR00000V0574734\\n:53B:/00010013800002001234\\nMI BANCO\\n:59:/00013500510020179998\\nFOO CORP\\nR00000V000034534\\n:71A:OUR\\n:72:/TIPO/422\\n-}\",\n"
                + "  \"identifier\": \"fin.103\",\n"
                + "  \"creationDate\": {\n"
                + "    \"year\": 2024,\n"
                + "    \"month\": 0,\n"
                + "    \"dayOfMonth\": 20\n"
                + "  }\n"
                + "}";

        MtSwiftMessage msg = MtSwiftMessage.fromJson(json);

        assertEquals(2024, msg.getCreationDate().get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, msg.getCreationDate().get(Calendar.MONTH));
        assertEquals(20, msg.getCreationDate().get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void roundtrip_preservesDate() {
        MtSwiftMessage original = new MtSwiftMessage(FIN);

        Calendar august = new GregorianCalendar(2025, Calendar.AUGUST, 15, 14, 30, 45);
        original.setCreationDate(august);

        // Serialize and deserialize
        String json = original.toJson();
        MtSwiftMessage restored = MtSwiftMessage.fromJson(json);

        // The date should survive the roundtrip
        assertEquals(2025, restored.getCreationDate().get(Calendar.YEAR));
        assertEquals(Calendar.AUGUST, restored.getCreationDate().get(Calendar.MONTH));
        assertEquals(15, restored.getCreationDate().get(Calendar.DAY_OF_MONTH));
        assertEquals(14, restored.getCreationDate().get(Calendar.HOUR_OF_DAY));
        assertEquals(30, restored.getCreationDate().get(Calendar.MINUTE));
        assertEquals(45, restored.getCreationDate().get(Calendar.SECOND));
    }
}

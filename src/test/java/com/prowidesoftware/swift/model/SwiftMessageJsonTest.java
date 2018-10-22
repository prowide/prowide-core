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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import com.prowidesoftware.swift.utils.SwiftMessageComparator;

/**
 * Test cases for SwiftMessage and blocks JSON API
 *
 * @author psantamarina
 * @since 7.9.8
 */
public class SwiftMessageJsonTest {

    @Test
    public void testBlock1ToJson(){
        SwiftBlock1 b1 = new SwiftBlock1("F","01","FOOSEDR0AXXX","0000","000000");
        String s = b1.toJson();

        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(s).getAsJsonObject();

        assertNotNull(o);
        assertEquals("F", o.get("applicationId").getAsString());
        assertEquals("01", o.get("serviceId").getAsString());
        assertEquals("FOOSEDR0AXXX", o.get("logicalTerminal").getAsString());
        assertEquals("0000", o.get("sessionNumber").getAsString());
        assertEquals("000000", o.get("sequenceNumber").getAsString());
    }

    @Test
    public void testBlock1FromJson(){
        String json = "{\"applicationId\":\"F\",\"serviceId\":\"01\",\"logicalTerminal\":\"FOOSEDR0AXXX\",\"sessionNumber\":\"0000\",\"sequenceNumber\":\"000000\"}";
        SwiftBlock1 b1 = SwiftBlock1.fromJson(json);
        assertEquals("F", b1.getApplicationId());
        assertEquals("01", b1.getServiceId());
        assertEquals("FOOSEDR0AXXX", b1.getLogicalTerminal());
        assertEquals("0000", b1.getSessionNumber());
        assertEquals("000000", b1.getSequenceNumber());
    }

    @Test
    public void testBlock2InputToJson(){
        SwiftBlock2Input b1 = new SwiftBlock2Input("I103CARAANC0XXXXN");
        String s = b1.toJson();

        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(s).getAsJsonObject();

        assertNotNull(o);
        assertEquals("I", o.get("direction").getAsString());
        assertEquals("CARAANC0XXXX", o.get("receiverAddress").getAsString());
        assertEquals("103", o.get("messageType").getAsString());
        assertEquals("N", o.get("messagePriority").getAsString());
    }

    @Test
    public void testBlock2OutputToJson(){
        SwiftBlock2Output nout = new SwiftBlock2Output("O1001200010103BANKBEBBAXXX22221234560101031201N");
        String s = nout.toJson();

        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(s).getAsJsonObject();

        assertNotNull(o);
        assertFalse(nout.isInput());
        assertEquals("O", o.get("direction").getAsString());
        assertEquals("100", o.get("messageType").getAsString());
        assertEquals("1200", o.get("senderInputTime").getAsString());
        assertEquals("010103", o.get("receiverOutputDate").getAsString());
        assertEquals("1201", o.get("receiverOutputTime").getAsString());
    }

    @Test
    public void testBlock2InputFromJson(){
        String s = "{\"direction\":\"I\",\"messageType\":\"103\",\"receiverAddress\":\"CARAANC0XXXX\",\"messagePriority\":\"N\",\"deliveryMonitoring\":\"2\",\"obsolescencePeriod\":\"003\"}";
        SwiftBlock2Input block2Input = SwiftBlock2Input.fromJson(s);
        assertTrue(block2Input.isInput());
        assertEquals("103", block2Input.getMessageType());
        assertEquals("CARAANC0XXXX", block2Input.getReceiverAddress());
        assertEquals("N", block2Input.getMessagePriority());
        assertEquals("2", block2Input.getDeliveryMonitoring());
        assertEquals("003", block2Input.getObsolescencePeriod());
    }

    @Test
    public void testBlock2OutputFromJson(){
        String s = "{\"direction\":\"O\",\"messageType\":\"100\",\"senderInputTime\":\"1200\",\"MIRDate\":\"010103\",\"MIRLogicalTerminal\":\"BANKBEBBAXXX\",\"MIRSessionNumber\":\"2222\",\"MIRSequenceNumber\":\"123456\",\"receiverOutputDate\":\"010103\",\"receiverOutputTime\":\"1201\",\"messagePriority\":\"N\"}";

        SwiftBlock2Output block2Output = SwiftBlock2Output.fromJson(s);
        assertTrue(block2Output.isOutput());
        assertEquals("100", block2Output.getMessageType());
        assertEquals("1200", block2Output.getSenderInputTime());
        assertEquals("010103BANKBEBBAXXX2222123456", block2Output.getMIR());
        assertEquals("010103", block2Output.getReceiverOutputDate());
        assertEquals("1201", block2Output.getReceiverOutputTime());
        assertEquals("N", block2Output.getMessagePriority());
    }

    @Test
    public void testBlock3ToJson(){
        SwiftBlock3 b3 = new SwiftBlock3();
        b3.append(new Tag("113","SEPA"));
        b3.append(new Tag("108","ILOVESEPA"));

        String s = b3.toJson();
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(s).getAsJsonObject();

        assertNotNull(o);
        assertTrue(o.get("tags").getAsJsonArray().size()==2);
        //TODO agregar mas asserts, ver testBlock1ToJson
    }

    @Test
    public void testBlock3FromJson(){
        String json = "{\"tags\":[{\"name\":\"113\",\"value\":\"SEPA\"},{\"name\":\"108\",\"value\":\"ILOVESEPA\"}]}";
        SwiftBlock3 b3 = SwiftBlock3.fromJson(json);
        assertTrue(b3.getTags().size() == 2);
        assertEquals("SEPA", b3.getTagValue("113"));
        assertEquals("ILOVESEPA", b3.getTagValue("108"));
    }

    @Test
    public void testBlock4ToJson(){
        SwiftBlock4 b4 = new SwiftBlock4();
        b4.append(new Tag("20", "REFERENCE"));
        b4.append(new Tag("23B", "CRED"));

        String s = b4.toJson();
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(s).getAsJsonObject();

        assertNotNull(o);
        assertTrue(o.get("tags").getAsJsonArray().size() == 2);
        assertEquals("20", o.get("tags").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString());
        assertEquals("23B",o.get("tags").getAsJsonArray().get(1).getAsJsonObject().get("name").getAsString());
        assertEquals("REFERENCE",o.get("tags").getAsJsonArray().get(0).getAsJsonObject().get("value").getAsString());
        assertEquals("CRED", o.get("tags").getAsJsonArray().get(1).getAsJsonObject().get("value").getAsString());
    }

    @Test
    public void testBlock4FromJson(){
        String json = "{\"tags\":[{\"name\":\"20\",\"value\":\"REFERENCE\"},{\"name\":\"23B\",\"value\":\"CRED\"}]}";
        SwiftBlock4 b4 = SwiftBlock4.fromJson(json);
        assertTrue(b4.getTags().size() == 2);
        assertEquals("REFERENCE", b4.getTagValue("20"));
        assertEquals("CRED", b4.getTagValue("23B"));
    }

    @Test
    public void testBlock5ToJson(){
        SwiftBlock5 b5 = new SwiftBlock5();
        b5.append(new Tag("PDE"));
        b5.append(new Tag("CHK", "aaaa1111bbbb2222"));

        String s = b5.toJson();
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(s).getAsJsonObject();

        assertNotNull(o);
        assertTrue(o.get("tags").getAsJsonArray().size() == 2);

        assertEquals("PDE", o.get("tags").getAsJsonArray().get(0).getAsJsonObject().get("value").getAsString());
        assertEquals("CHK",o.get("tags").getAsJsonArray().get(1).getAsJsonObject().get("name").getAsString());
        assertEquals("aaaa1111bbbb2222", o.get("tags").getAsJsonArray().get(1).getAsJsonObject().get("value").getAsString());

    }

    @Test
    public void testBlock5FromJson(){
        String json = "{\"tags\":[{\"name\":\"PDE\",\"value\":\"\"},{\"name\":\"CHK\",\"value\":\"aaaa1111bbbb2222\"}]}";
        SwiftBlock5 b5 = SwiftBlock5.fromJson(json);
        assertTrue(b5.getTags().size() == 2);

        assertEquals("", b5.getTagValue("PDE"));
        assertEquals("aaaa1111bbbb2222", b5.getTagValue("CHK"));
    }

    @Test
    public void testSwiftBlockUserToJson(){
        SwiftBlockUser bu = new SwiftBlockUser("P");
        bu.append(new Tag("PDE"));
        bu.append(new Tag("CHK", "aaaa1111bbbb2222"));

        String s = bu.toJson();
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(s).getAsJsonObject();

        assertNotNull(o);
        assertTrue(o.get("tags").getAsJsonArray().size() == 2);

        assertEquals("PDE", o.get("tags").getAsJsonArray().get(0).getAsJsonObject().get("value").getAsString());
        assertEquals("CHK",o.get("tags").getAsJsonArray().get(1).getAsJsonObject().get("name").getAsString());
        assertEquals("P", o.get("blockName").getAsString());
    }

    @Test
    public void testSwiftBlockUserFromJson(){
        String json = "{\"blockName\":\"A\",\"tags\":[{\"name\":\"PDE\",\"value\":\"\"},{\"name\":\"CHK\",\"value\":\"aaaa1111bbbb2222\"}]}";
        SwiftBlockUser b = SwiftBlockUser.fromJson(json);
        assertTrue(b.getTags().size() == 2);

        assertEquals("", b.getTagValue("PDE"));
        assertEquals("aaaa1111bbbb2222", b.getTagValue("CHK"));
        assertEquals("A", b.getName());
    }

    @Test
    public void testSwiftMessageToJson() throws Exception {
        SwiftMessage m = MT103.parse("{1:F01FOOSEDR0AXXX0000000000}{3:{113:SEPA}{108:ILOVESEPA}}{2:I103FOORECV0XXXXN}{4:\n" +
                ":20:REFERENCE\n" +
                ":23B:CRED\n" +
                ":32A:130204USD1234567,89\n" +
                ":50K:/12345678901234567890\n" +
                "FOOBANKXXXXX\n" +
                ":59:/12345678901234567890\n" +
                "JOE DOE\n" +
                ":71A:OUR\n" +
                "-}").getSwiftMessage();
        final String json = m.toJson();

        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(json).getAsJsonObject();

        assertNotNull(o);
        assertEquals(SwiftMessage.JSON_VERSION, o.get("version").getAsInt());
        assertNotNull(o.get("timestamp"));
        assertNotNull(o.get("data"));

        JsonObject block4 = o.get("data").getAsJsonObject().get("block4").getAsJsonObject();
        assertNotNull(block4);

        JsonArray tags = block4.get("tags").getAsJsonArray();
        assertEquals(6, tags.size());

        JsonObject tag50K = tags.get(3).getAsJsonObject();
        assertNotNull(tag50K);

        assertEquals("/12345678901234567890\nFOOBANKXXXXX", tag50K.get("value").getAsString());
    }

    @Test
    public void testSwiftMessageFromJsonWithBlock3() throws Exception {
        String json ="{\n" +
                "  \"timestamp\": \"2018-04-19T02:31:26Z\",\n" +
                "  \"version\": 2,\n" +
                "  \"data\": {\n" +
                "    \"block1\": {\n" +
                "      \"applicationId\": \"F\",\n" +
                "      \"serviceId\": \"01\",\n" +
                "      \"logicalTerminal\": \"FOOSEDR0AXXX\",\n" +
                "      \"sessionNumber\": \"0000\",\n" +
                "      \"sequenceNumber\": \"000000\"\n" +
                "    },\n" +
                "    \"block2\": {\n" +
                "      \"receiverAddress\": \"FOORECV0XXXX\",\n" +
                "      \"messagePriority\": \"N\",\n" +
                "      \"messageType\": \"103\",\n" +
                "      \"direction\": \"I\"\n" +
                "    },\n" +
                "    \"block3\": {\n" +
                "      \"tags\": [\n" +
                "        {\n" +
                "          \"name\": \"113\",\n" +
                "          \"value\": \"SEPA\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"108\",\n" +
                "          \"value\": \"ILOVESEPA\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"block4\": {\n" +
                "      \"tags\": [\n" +
                "        {\n" +
                "          \"name\": \"20\",\n" +
                "          \"value\": \"REFERENCE\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"23B\",\n" +
                "          \"value\": \"CRED\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"32A\",\n" +
                "          \"value\": \"130204USD1234567,89\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"50K\",\n" +
                "          \"value\": \"/12345678901234567890\\nFOOBANKXXXXX\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"59\",\n" +
                "          \"value\": \"/12345678901234567890\\nJOE DOE\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"71A\",\n" +
                "          \"value\": \"OUR\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";

        SwiftMessage m = SwiftMessage.fromJson(json);
        assertNotNull(m.getBlock1());
        assertNotNull(m.getBlock2());
        assertTrue(m.getBlock2().isInput());
        assertNotNull(m.getBlock3());
        assertNotNull(m.getBlock4());
        assertNull(m.getBlock5());
        assertEquals("SEPA", m.getBlock3().getTagValue("113"));
        assertEquals("/12345678901234567890\nFOOBANKXXXXX", m.getBlock4().getTagValue("50K"));
    }

    @Test
    public void testSwiftMessageFromJson() throws Exception {
        String json ="{\n" +
                "  \"timestamp\": \"2018-04-16T03:57:16Z\",\n" +
                "  \"version\": 2,\n" +
                "  \"data\": {\n" +
                "    \"block1\": {\n" +
                "      \"applicationId\": \"F\",\n" +
                "      \"serviceId\": \"01\",\n" +
                "      \"logicalTerminal\": \"FOOSEDR0AXXX\",\n" +
                "      \"sessionNumber\": \"0000\",\n" +
                "      \"sequenceNumber\": \"000000\"\n" +
                "    },\n" +
                "    \"block2\": {\n" +
                "      \"input\": true,\n" +
                "      \"direction\": I,\n" +
                "      \"receiverAddress\": \"FOORECV0XXXX\",\n" +
                "      \"messagePriority\": \"N\",\n" +
                "      \"messageType\": \"103\"\n" +
                "    },\n" +
                "    \"block4\": {\n" +
                "      \"tags\": [\n" +
                "        {\n" +
                "          \"name\": \"20\",\n" +
                "          \"value\": \"REFERENCE\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"23B\",\n" +
                "          \"value\": \"CRED\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"32A\",\n" +
                "          \"value\": \"130204USD1234567,89\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"50K\",\n" +
                "          \"value\": \"/12345678901234567890\\nFOOBANKXXXXX\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"59\",\n" +
                "          \"value\": \"/12345678901234567890\\nJOE DOE\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"71A\",\n" +
                "          \"value\": \"OUR\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";

        SwiftMessage m = SwiftMessage.fromJson(json);
        assertNotNull(m.getBlock1());
        assertNotNull(m.getBlock2());
        assertTrue(m.getBlock2().isInput());
        assertNull(m.getBlock3());
        assertNotNull(m.getBlock4());
        assertNull(m.getBlock5());
    }

    @Test
    public void testSwiftMessageFromJsonUserBlocks() {
        String json ="{\n" +
                "  \"timestamp\": \"2018-04-25T02:22:10Z\",\n" +
                "  \"version\": 2,\n" +
                "  \"data\": {\n" +
                "    \"block1\": {\n" +
                "      \"applicationId\": \"F\",\n" +
                "      \"serviceId\": \"01\",\n" +
                "      \"logicalTerminal\": \"FOOSEDR0AXXX\",\n" +
                "      \"sessionNumber\": \"0000\",\n" +
                "      \"sequenceNumber\": \"000000\"\n" +
                "    },\n" +
                "    \"block2\": {\n" +
                "      \"receiverAddress\": \"FOORECV0XXXX\",\n" +
                "      \"messagePriority\": \"N\",\n" +
                "      \"messageType\": \"103\",\n" +
                "      \"direction\": \"I\"\n" +
                "    },\n" +
                "    \"block3\": {\n" +
                "      \"tags\": [\n" +
                "        {\n" +
                "          \"name\": \"113\",\n" +
                "          \"value\": \"SEPA\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"108\",\n" +
                "          \"value\": \"ILOVESEPA\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"block4\": {\n" +
                "      \"tags\": [\n" +
                "        {\n" +
                "          \"name\": \"20\",\n" +
                "          \"value\": \"REFERENCE\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"23B\",\n" +
                "          \"value\": \"CRED\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"32A\",\n" +
                "          \"value\": \"130204USD1234567,89\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"50K\",\n" +
                "          \"value\": \"/12345678901234567890\\nFOOBANKXXXXX\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"59\",\n" +
                "          \"value\": \"/12345678901234567890\\nJOE DOE\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"71A\",\n" +
                "          \"value\": \"OUR\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"userBlocks\": [\n" +
                "      {\n" +
                "       \"blockName\":\"P\",\n"+
                "        \"tags\": [\n" +
                "          {\n" +
                "            \"name\": \"20\",\n" +
                "            \"value\": \"REFERENCE\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"23B\",\n" +
                "            \"value\": \"CRED\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"tags\": [\n" +
                "          {\n" +
                "            \"name\": \"20\",\n" +
                "            \"value\": \"REFERENCE\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"23B\",\n" +
                "            \"value\": \"CRED\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        SwiftMessage m = SwiftMessage.fromJson(json);
        assertNotNull(m.getBlock1());
        assertNotNull(m.getBlock2());
        assertNotNull(m.getBlock3());
        assertNotNull(m.getBlock4());
        assertNull(m.getBlock5());
        assertNotNull(m.getUserBlocks());
        assertEquals("REFERENCE", m.getBlock4().getTagValue("20"));
        assertEquals("CRED", m.getBlock4().getTagValue("23B"));
        assertEquals("P", m.getUserBlocks().get(0).getName());
    }

    @Test
    public void testSwiftMessageToJsonV1() {
        SwiftMessage m = MT103.parse("{1:F01FOOSEDR0AXXX0000000000}{3:{113:SEPA}{108:ILOVESEPA}}{2:I103FOORECV0XXXXN}{4:\n" +
                ":20:REFERENCE\n" +
                ":23B:CRED\n" +
                ":32A:130204USD1234567,89\n" +
                ":50K:/12345678901234567890\n" +
                "FOOBANKXXXXX\n" +
                ":59:/12345678901234567890\n" +
                "JOE DOE\n" +
                ":71A:OUR\n" +
                "-}").getSwiftMessage();

        String toJsonV1SwiftMessage = m.toJsonV1();

        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(toJsonV1SwiftMessage).getAsJsonObject();

        assertNotNull(o);
        assertEquals(SwiftMessage.JSON_VERSION, o.get("version").getAsInt());
        assertNotNull(o.get("timestamp"));
        assertNotNull(o.get("data"));

        JsonObject block4 = o.get("data").getAsJsonObject().get("block4").getAsJsonObject();
        assertNotNull(block4);

        JsonArray tags = block4.get("tags").getAsJsonArray();
        assertEquals(6, tags.size());

        JsonObject tag50K = tags.get(3).getAsJsonObject();
        assertNotNull(tag50K);

        assertEquals("/12345678901234567890\nFOOBANKXXXXX", tag50K.get("value").getAsString());
    }

    @Test
    public void testSwiftMessageToJsonAndFromJson() {
        SwiftMessage m = MT103.parse("{1:F01FOOSEDR0AXXX0000000000}{3:{113:SEPA}{108:ILOVESEPA}}{2:I103FOORECV0XXXXN}{4:\n" +
                ":20:REFERENCE\n" +
                ":23B:CRED\n" +
                ":32A:130204USD1234567,89\n" +
                ":50K:/12345678901234567890\n" +
                "FOOBANKXXXXX\n" +
                ":59:/12345678901234567890\n" +
                "JOE DOE\n" +
                ":71A:OUR\n" +
                "-}{5:{CHK:C77F8E009597}}").getSwiftMessage();

        String toJsonSwiftMessage = m.toJson();

        SwiftMessage fromJsonSwiftMessage = SwiftMessage.fromJson(toJsonSwiftMessage);

        SwiftMessageComparator comp = new SwiftMessageComparator();

        assertTrue(comp.compare(m, fromJsonSwiftMessage) == 0);
    }

}

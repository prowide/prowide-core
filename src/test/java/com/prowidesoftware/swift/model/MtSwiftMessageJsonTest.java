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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for JSON API in MtSwiftMessage
 */
public class MtSwiftMessageJsonTest {

	@Test
	public void testMtSwiftMessageToJson() {
		String fin = "{1:F01CARBVEC0ADDD0344000050}{2:I103CARAANC0XFFFN}{4:\n" +
				":20:TBEXO200909031\n" +
				":23B:CRED\n" +
				":32A:090903VEF23453,\n" +
				":50K:/01111001759234567890\n" +
				"ROMAN GUILLEN DOBOZI \n" +
				"R00000V0574734\n" +
				":53B:/00010013800002001234\n" +
				"MI BANCO\n" +
				":59:/00013500510020179998\n" +
				"PDVSA GAS\n" +
				"R00000V000034534\n" +
				":71A:OUR\n" +
				":72:/TIPO/422\n" +
				"-}";

		MtSwiftMessage m = new MtSwiftMessage(fin);

		SwiftMessageStatusInfo statusInfo = new SwiftMessageStatusInfo("comments", "creationUser", "name","data");
        List<SwiftMessageStatusInfo> statusTrial = new ArrayList<SwiftMessageStatusInfo>();
        statusTrial.add(statusInfo);
		m.setStatusTrail(statusTrial);

        SwiftMessageNote swiftMessageNote = new SwiftMessageNote("creationUser","text");
        List<SwiftMessageNote> notes = new ArrayList<SwiftMessageNote>();
        notes.add(swiftMessageNote);
        m.setNotes(notes);
		assertNotNull(m);
		String s = m.toJson();

        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(s).getAsJsonObject();

        assertNotNull(o);

        assertNull(o.get("mir"));
        assertNull(o.get("pde"));
        assertNull(o.get("pdm"));
        assertNull(o.get("mur"));
		assertEquals("ICARAANC0FFF103TBEXO200909031", o.get("uuid").getAsString());
		assertTrue(o.get("statusTrail").getAsJsonArray().size() == 1);
        assertEquals("comments", o.get("statusTrail").getAsJsonArray().get(0).getAsJsonObject().get("comments").getAsString());
        assertTrue(o.get("notes").getAsJsonArray().size() == 1);
        assertEquals("creationUser", o.get("notes").getAsJsonArray().get(0).getAsJsonObject().get("creationUser").getAsString());
	}

    @Test
    public void testMtSwiftMessageFromJson() {
        String json = "{\n" +
                "  \"uuid\": \"ICARAANC0FFF103TBEXO200909031\",\n" +
                "  \"message\": \"{1:F01CARBVEC0ADDD0344000050}{2:I103CARAANC0XFFFN}{4:\\n:20:TBEXO200909031\\n:23B:CRED\\n:32A:090903VEF23453,\\n:50K:/01111001759234567890\\nROMAN GUILLEN DOBOZI \\nR00000V0574734\\n:53B:/00010013800002001234\\nMI BANCO\\n:59:/00013500510020179998\\nPDVSA GAS\\nR00000V000034534\\n:71A:OUR\\n:72:/TIPO/422\\n-}\",\n" +
                "  \"identifier\": \"fin.103\",\n" +
                "  \"sender\": \"CARBVEC0DDD\",\n" +
                "  \"receiver\": \"CARAANC0FFF\",\n" +
                "  \"direction\": \"outgoing\",\n" +
                "  \"checksum\": \"c82941778f70a0426ffc04321fa145ad\",\n" +
                "  \"checksumBody\": \"7d5e9d83c18a16664df1dfd9b1ebe8a6\",\n" +
                "  \"lastModified\": {\n" +
                "    \"year\": 2018,\n" +
                "    \"month\": 4,\n" +
                "    \"dayOfMonth\": 22,\n" +
                "    \"hourOfDay\": 0,\n" +
                "    \"minute\": 48,\n" +
                "    \"second\": 4\n" +
                "  },\n" +
                "  \"creationDate\": {\n" +
                "    \"year\": 2018,\n" +
                "    \"month\": 4,\n" +
                "    \"dayOfMonth\": 22,\n" +
                "    \"hourOfDay\": 0,\n" +
                "    \"minute\": 48,\n" +
                "    \"second\": 4\n" +
                "  },\n" +
                "  \"statusTrail\": [\n" +
                "    {\n" +
                "      \"name\": \"name\",\n" +
                "      \"comments\": \"comments\",\n" +
                "      \"creationDate\": {\n" +
                "        \"year\": 2018,\n" +
                "        \"month\": 4,\n" +
                "        \"dayOfMonth\": 22,\n" +
                "        \"hourOfDay\": 0,\n" +
                "        \"minute\": 48,\n" +
                "        \"second\": 4\n" +
                "      },\n" +
                "      \"creationUser\": \"creationUser\",\n" +
                "      \"data\": \"data\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"notes\": [\n" +
                "    {\n" +
                "      \"creationDate\": {\n" +
                "        \"year\": 2018,\n" +
                "        \"month\": 4,\n" +
                "        \"dayOfMonth\": 22,\n" +
                "        \"hourOfDay\": 0,\n" +
                "        \"minute\": 48,\n" +
                "        \"second\": 4\n" +
                "      },\n" +
                "      \"creationUser\": \"creationUser\",\n" +
                "      \"text\": \"text\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"properties\": {},\n" +
                "  \"fileFormat\": \"FIN\",\n" +
                "  \"reference\": \"TBEXO200909031\",\n" +
                "  \"currency\": \"VEF\",\n" +
                "  \"amount\": 23453,\n" +
                "  \"revisions\": []\n" +
                "}";


        MtSwiftMessage swiftMessage = MtSwiftMessage.fromJson(json);

        assertEquals("ICARAANC0FFF103TBEXO200909031", swiftMessage.getUuid());
        assertEquals("TBEXO200909031", swiftMessage.getReference());
        assertEquals("FIN", swiftMessage.getFileFormat().toString());
        assertEquals("fin.103", swiftMessage.getIdentifier());
        assertTrue(swiftMessage.getStatusTrail().size() == 1);
        assertEquals("comments", swiftMessage.getStatusTrail().get(0).getComments());
        assertTrue(swiftMessage.getNotes().size() == 1);
        assertEquals("creationUser", swiftMessage.getNotes().get(0).getCreationUser());

        SwiftMessage sm = swiftMessage.modelMessage();
        assertNotNull(sm.getBlock1());
        assertNotNull(sm.getBlock2());
        assertNotNull(sm.getBlock4());
        assertTrue(sm.getBlock2().isInput());
        assertEquals("TBEXO200909031", sm.getBlock4().getTagValue("20"));
        assertEquals("CARBVEC0ADDD", sm.getBlock1().getLogicalTerminal());
        assertEquals("103", sm.getBlock2().getMessageType());
        assertEquals("0344", sm.getBlock1().getSessionNumber());
        assertNull(sm.getBlock5());
    }

}

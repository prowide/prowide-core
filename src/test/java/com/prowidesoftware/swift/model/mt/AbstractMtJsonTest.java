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

package com.prowidesoftware.swift.model.mt;

import static org.junit.jupiter.api.Assertions.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.field.Field16R;
import com.prowidesoftware.swift.model.field.Narrative;
import com.prowidesoftware.swift.model.field.StructuredNarrative;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.prowidesoftware.swift.model.mt.mt2xx.MT202;
import com.prowidesoftware.swift.model.mt.mt5xx.MT547;
import com.prowidesoftware.swift.utils.SwiftMessageComparator;
import org.junit.jupiter.api.Test;

/**
 * Test for JSON API in AbstractMT and subclasses
 */
public class AbstractMtJsonTest {

    @Test
    public void testMT547ToJson() {
        String fin =
                "{1:F01FMACUS33AXXX1625159979}{2:O5471302141113CHASUSU9AXXX05821058501411131302N}{3:{108:001823CQ1833911}}{4:\n"
                        + ":16R:GENL\n"
                        + ":20C::SEME//T314314CDM0\n"
                        + ":23G:NEWM\n"
                        + ":98E::PREP//20141113130218/N05\n"
                        + ":16R:LINK\n"
                        + ":20C::RELA//00013507299330A\n"
                        + ":16S:LINK\n"
                        + ":16S:GENL\n"
                        + ":16R:TRADDET\n"
                        + ":98A::TRAD//20141107\n"
                        + ":98A::ESET//20141113\n"
                        + ":98A::SETT//20141113\n"
                        + ":90A::DEAL//PRCT/102,713552\n"
                        + ":35B:/US/3132MAD40\n"
                        + "FOO MORTPASS 3.5+ 01/NOV/2044\n"
                        + "Q2 PN+ Q29423\n"
                        + ":16S:TRADDET\n"
                        + ":16R:FIAC\n"
                        + ":36B::ESTT//AMOR/7999999,573\n"
                        + ":36B::ESTT//FAMT/8167548,\n"
                        + ":97A::SAFE//P 61947\n"
                        + ":16S:FIAC\n"
                        + ":16R:SETDET\n"
                        + ":22F::SETR//TRAD\n"
                        + ":16R:SETPRTY\n"
                        + ":95R::REAG/USFW/021000021\n"
                        + ":97A::SAFE//FBCMBS\n"
                        + ":16S:SETPRTY\n"
                        + ":16R:SETPRTY\n"
                        + ":95R::BUYR/DTCYID/00355\n"
                        + ":16S:SETPRTY\n"
                        + ":16R:SETPRTY\n"
                        + ":95P::PSET//FRNYUS33\n"
                        + ":16S:SETPRTY\n"
                        + ":16R:AMT\n"
                        + ":19A::DEAL//USD8217083,72\n"
                        + ":16S:AMT\n"
                        + ":16R:AMT\n"
                        + ":19A::ACRU//USD9333,33\n"
                        + ":16S:AMT\n"
                        + ":16R:AMT\n"
                        + ":19A::ESTT//USD8226417,05\n"
                        + ":16S:AMT\n"
                        + ":16S:SETDET\n"
                        + ":16R:OTHRPRTY\n"
                        + ":95P::MEOR//CHASUS33\n"
                        + ":16S:OTHRPRTY\n"
                        + "-}";
        MT547 mt = new MT547(fin);
        String toJson = mt.toJson();

        JsonObject o = JsonParser.parseString(toJson).getAsJsonObject();

        assertEquals(
                "FMACUS33AXXX",
                o.get("basicHeaderBlock")
                        .getAsJsonObject()
                        .get("logicalTerminal")
                        .getAsString());
        assertEquals(
                "CHASUSU9AXXX",
                o.get("applicationHeaderBlock")
                        .getAsJsonObject()
                        .get("MIRLogicalTerminal")
                        .getAsString());
        assertEquals(
                "108",
                o.get("userHeaderBlock")
                        .getAsJsonObject()
                        .get("fields")
                        .getAsJsonArray()
                        .get(0)
                        .getAsJsonObject()
                        .get("name")
                        .getAsString());
        assertEquals(
                "98E",
                o.get("textBlock")
                        .getAsJsonObject()
                        .get("fields")
                        .getAsJsonArray()
                        .get(3)
                        .getAsJsonObject()
                        .get("name")
                        .getAsString());
        assertEquals(
                "PREP",
                o.get("textBlock")
                        .getAsJsonObject()
                        .get("fields")
                        .getAsJsonArray()
                        .get(3)
                        .getAsJsonObject()
                        .get("qualifier")
                        .getAsString());
        assertEquals(
                "N",
                o.get("textBlock")
                        .getAsJsonObject()
                        .get("fields")
                        .getAsJsonArray()
                        .get(3)
                        .getAsJsonObject()
                        .get("sign")
                        .getAsString());
    }

    @Test
    public void testMT547FromJson() {
        String json = "{\n" + "  \"type\": \"MT\",\n"
                + "  \"basicHeaderBlock\": {\n"
                + "    \"applicationId\": \"F\",\n"
                + "    \"serviceId\": \"01\",\n"
                + "    \"logicalTerminal\": \"FMACUS33AXXX\",\n"
                + "    \"sessionNumber\": \"1625\",\n"
                + "    \"sequenceNumber\": \"159979\"\n"
                + "  },\n"
                + "  \"applicationHeaderBlock\": {\n"
                + "    \"senderInputTime\": \"1302\",\n"
                + "    \"MIRDate\": \"141113\",\n"
                + "    \"MIRLogicalTerminal\": \"CHASUSU9AXXX\",\n"
                + "    \"MIRSessionNumber\": \"0582\",\n"
                + "    \"MIRSequenceNumber\": \"105850\",\n"
                + "    \"receiverOutputDate\": \"141113\",\n"
                + "    \"receiverOutputTime\": \"1302\",\n"
                + "    \"messagePriority\": \"N\",\n"
                + "    \"messageType\": \"547\",\n"
                + "    \"direction\": \"O\"\n"
                + "  },\n"
                + "  \"userHeaderBlock\": {\n"
                + "    \"fields\": [\n"
                + "      {\n"
                + "        \"name\": \"108\",\n"
                + "        \"mUR\": \"001823CQ1833911\"\n"
                + "      }\n"
                + "    ]\n"
                + "  },\n"
                + "  \"textBlock\": {\n"
                + "    \"fields\": [\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"GENL\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"20C\",\n"
                + "        \"qualifier\": \"SEME\",\n"
                + "        \"reference\": \"T314314CDM0\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"23G\",\n"
                + "        \"function\": \"NEWM\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"98E\",\n"
                + "        \"qualifier\": \"PREP\",\n"
                + "        \"date\": \"20141113\",\n"
                + "        \"time\": \"130218\",\n"
                + "        \"sign\": \"N\",\n"
                + "        \"uTCIndicator\": \"05\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"LINK\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"20C\",\n"
                + "        \"qualifier\": \"RELA\",\n"
                + "        \"reference\": \"00013507299330A\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"LINK\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"GENL\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"TRADDET\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"98A\",\n"
                + "        \"qualifier\": \"TRAD\",\n"
                + "        \"date\": \"20141107\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"98A\",\n"
                + "        \"qualifier\": \"ESET\",\n"
                + "        \"date\": \"20141113\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"98A\",\n"
                + "        \"qualifier\": \"SETT\",\n"
                + "        \"date\": \"20141113\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"90A\",\n"
                + "        \"qualifier\": \"DEAL\",\n"
                + "        \"percentageTypeCode\": \"PRCT\",\n"
                + "        \"price\": \"102,713552\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"35B\",\n"
                + "        \"description\": \"/US/3132MAD40\",\n"
                + "        \"description2\": \"FOO MORTPASS 3.5+ 01/NOV/2044\",\n"
                + "        \"description3\": \"Q2 PN+ Q29423\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"TRADDET\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"FIAC\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"36B\",\n"
                + "        \"qualifier\": \"ESTT\",\n"
                + "        \"quantityTypeCode\": \"AMOR\",\n"
                + "        \"quantity\": \"7999999,573\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"36B\",\n"
                + "        \"qualifier\": \"ESTT\",\n"
                + "        \"quantityTypeCode\": \"FAMT\",\n"
                + "        \"quantity\": \"8167548,\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"97A\",\n"
                + "        \"qualifier\": \"SAFE\",\n"
                + "        \"account\": \"P 61947\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"FIAC\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"SETDET\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"22F\",\n"
                + "        \"qualifier\": \"SETR\",\n"
                + "        \"indicator\": \"TRAD\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"SETPRTY\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"95R\",\n"
                + "        \"qualifier\": \"REAG\",\n"
                + "        \"dataSourceScheme\": \"USFW\",\n"
                + "        \"proprietaryCode\": \"021000021\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"97A\",\n"
                + "        \"qualifier\": \"SAFE\",\n"
                + "        \"account\": \"FBCMBS\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"SETPRTY\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"SETPRTY\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"95R\",\n"
                + "        \"qualifier\": \"BUYR\",\n"
                + "        \"dataSourceScheme\": \"DTCYID\",\n"
                + "        \"proprietaryCode\": \"00355\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"SETPRTY\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"SETPRTY\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"95P\",\n"
                + "        \"qualifier\": \"PSET\",\n"
                + "        \"bIC\": \"FRNYUS33\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"SETPRTY\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"AMT\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"19A\",\n"
                + "        \"qualifier\": \"DEAL\",\n"
                + "        \"currency\": \"USD\",\n"
                + "        \"amount\": \"8217083,72\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"AMT\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"AMT\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"19A\",\n"
                + "        \"qualifier\": \"ACRU\",\n"
                + "        \"currency\": \"USD\",\n"
                + "        \"amount\": \"9333,33\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"AMT\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"AMT\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"19A\",\n"
                + "        \"qualifier\": \"ESTT\",\n"
                + "        \"currency\": \"USD\",\n"
                + "        \"amount\": \"8226417,05\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"AMT\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"SETDET\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16R\",\n"
                + "        \"blockName\": \"OTHRPRTY\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"95P\",\n"
                + "        \"qualifier\": \"MEOR\",\n"
                + "        \"bIC\": \"CHASUS33\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"16S\",\n"
                + "        \"blockName\": \"OTHRPRTY\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";

        MT547 mt = (MT547) AbstractMT.fromJson(json);

        assertNotNull(mt);
        assertEquals("547", mt.getMessageType());
        assertEquals("SEME", mt.getField20C().get(0).getQualifier());
        assertEquals("T314314CDM0", mt.getField20C().get(0).getReference());
        assertEquals("NEWM", mt.getField23G().getValue());
        assertEquals("8217083,72", mt.getField19A().get(0).getAmount());

        assertEquals(1, mt.m.getBlock3().getTags().size());
        assertEquals("001823CQ1833911", mt.m.getBlock3().getTag(0).getValue());

        assertEquals(45, mt.m.getBlock4().getTags().size());
        assertEquals(":TRAD//20141107", mt.m.getBlock4().getTag(9).getValue());
    }

    @Test
    public void testToJsonAndFromJson() {
        SwiftMessageComparator comp = new SwiftMessageComparator();
        comp.setIgnoreEolsInMultiline(true);

        MT103 mt = MT103.parse("{1:F01FOOSEDR0AXXX0000000000}{3:{113:SEPA}{108:ILOVESEPA}}{2:I103FOORECV0XXXXN}{4:\n"
                + ":20:REFERENCE\n"
                + ":23B:CRED\n"
                + ":32A:130204USD1234567,89\n"
                + ":50K:/12345678901234567890\n"
                + "FOOBANKXXXXX\n"
                + ":59:/12345678901234567890\n"
                + "JOE DOE\n"
                + ":71A:OUR\n"
                + "-}{5:{CHK:C77F8E009597}{PDE:}}");

        SwiftMessage original = mt.getSwiftMessage();

        /*
         * to JSON
         */
        String json = mt.toJson();
        // System.out.println(json);

        /*
         * Generic fromJson implementation
         */
        MT103 mt2 = (MT103) AbstractMT.fromJson(json);
        assertEquals(0, comp.compare(original, mt2.getSwiftMessage()));

        /*
         * Specific MT class fromJson implementation
         */
        MT103 mt3 = MT103.fromJson(json);
        assertEquals(0, comp.compare(original, mt3.getSwiftMessage()));
    }

    /**
     * https://github.com/prowide/prowide-core/issues/21
     */
    @Test
    public void testJsonSlashPreserveField59() {
        String fin =
                "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}{119:STP}}{4:\n"
                        + ":20:D051026EUR100057\n"
                        + ":13C:/RNCTIME/0802+0000\n"
                        + ":23B:CRED\n"
                        + ":32A:051028EUR6740,91\n"
                        + ":33B:EUR6740,91\n"
                        + ":50A:SSSSESMMXXX\n"
                        + ":53A:BBBBESMMXXX\n"
                        + ":57A:FOOBARYYXXX\n"
                        + ":59:/ES0123456789012345671234\n"
                        + "FOOOOO 1000 FOOBAR S.A.\n"
                        + ":70:REDEMPTS. TRADEDATE 2222-10-26\n"
                        + "/123123123: FOOVIMAR 2000 FOOBAR\n"
                        + ":71A:SHA"
                        + "-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";

        SwiftMessage m = MT103.parse(fin).getSwiftMessage();

        String toJsonV1SwiftMessage = m.toJson();

        JsonObject o = JsonParser.parseString(toJsonV1SwiftMessage).getAsJsonObject();

        assertNotNull(o);
        assertEquals(
                "/ES0123456789012345671234\nFOOOOO 1000 FOOBAR S.A.",
                o.get("data")
                        .getAsJsonObject()
                        .get("block4")
                        .getAsJsonObject()
                        .getAsJsonArray("tags")
                        .get(8)
                        .getAsJsonObject()
                        .get("value")
                        .getAsString());
    }

    @Test
    public void testMT103_Field70() {

        String mt103JsonOneNarrative = "{\n" + "  \"type\": \"MT\",\n"
                + "  \"basicHeaderBlock\": {\n"
                + "    \"applicationId\": \"F\",\n"
                + "    \"serviceId\": \"01\",\n"
                + "    \"logicalTerminal\": \"FOOSEDR0AXXX\",\n"
                + "    \"sessionNumber\": \"0000\",\n"
                + "    \"sequenceNumber\": \"000000\"\n"
                + "  },\n"
                + "  \"applicationHeaderBlock\": {\n"
                + "    \"receiverAddress\": \"FOORECV0XXXX\",\n"
                + "    \"messagePriority\": \"N\",\n"
                + "    \"messageType\": \"103\",\n"
                + "    \"direction\": \"I\"\n"
                + "  },\n"
                + "  \"userHeaderBlock\": {\n"
                + "    \"fields\": [\n"
                + "      {\n"
                + "        \"name\": \"113\",\n"
                + "        \"bankingPriority\": \"SEPA\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"108\",\n"
                + "        \"mUR\": \"ILOVESEPA\"\n"
                + "      }\n"
                + "    ]\n"
                + "  },\n"
                + "  \"textBlock\": {\n"
                + "    \"fields\": [\n"
                + "      {\n"
                + "        \"name\": \"20\",\n"
                + "        \"reference\": \"REFERENCE\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"70\",\n"
                + "        \"narrative\": \"Narrative Value 1\"\n"
                + "      }\n"
                + "    ]\n"
                + "  },\n"
                + "  \"trailerBlock\": {\n"
                + "    \"fields\": [\n"
                + "      {\n"
                + "        \"name\": \"CHK\",\n"
                + "        \"value\": \"C77F8E009597\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"PDE\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";
        MT103 mt103 = (MT103) AbstractMT.fromJson(mt103JsonOneNarrative);
        String narrativeFinalValue =
                mt103.getField70().narrative().getUnstructuredFragments().get(0);
        assertEquals("Narrative Value 1", narrativeFinalValue);
        assertEquals("Narrative Value 1", mt103.getField70().getComponent(1));
    }

    @Test
    public void testMT103_Field70_backwardCompatibility() {
        String mt103JsonMoreThanOneNarrative = "{\n" + "  \"type\": \"MT\",\n"
                + "  \"basicHeaderBlock\": {\n"
                + "    \"applicationId\": \"F\",\n"
                + "    \"serviceId\": \"01\",\n"
                + "    \"logicalTerminal\": \"FOOSEDR0AXXX\",\n"
                + "    \"sessionNumber\": \"0000\",\n"
                + "    \"sequenceNumber\": \"000000\"\n"
                + "  },\n"
                + "  \"applicationHeaderBlock\": {\n"
                + "    \"receiverAddress\": \"FOORECV0XXXX\",\n"
                + "    \"messagePriority\": \"N\",\n"
                + "    \"messageType\": \"103\",\n"
                + "    \"direction\": \"I\"\n"
                + "  },\n"
                + "  \"userHeaderBlock\": {\n"
                + "    \"fields\": [\n"
                + "      {\n"
                + "        \"name\": \"113\",\n"
                + "        \"bankingPriority\": \"SEPA\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"108\",\n"
                + "        \"mUR\": \"ILOVESEPA\"\n"
                + "      }\n"
                + "    ]\n"
                + "  },\n"
                + "  \"textBlock\": {\n"
                + "    \"fields\": [\n"
                + "      {\n"
                + "        \"name\": \"20\",\n"
                + "        \"reference\": \"REFERENCE\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"70\",\n"
                + "        \"narrative\": \"Narrative Value 1 \",\n"
                + "        \"narrative2\": \"Narrative Value 2 \",\n"
                + "        \"narrative3\": \"Narrative Value 3\"\n"
                + "      }\n"
                + "    ]\n"
                + "  },\n"
                + "  \"trailerBlock\": {\n"
                + "    \"fields\": [\n"
                + "      {\n"
                + "        \"name\": \"CHK\",\n"
                + "        \"value\": \"C77F8E009597\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"PDE\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";

        MT103 mt103 = (MT103) AbstractMT.fromJson(mt103JsonMoreThanOneNarrative);

        Narrative narrative = mt103.getField70().narrative();
        assertEquals("Narrative Value 1 ", narrative.getUnstructuredFragments().get(0));
        assertEquals("Narrative Value 2 ", narrative.getUnstructuredFragments().get(1));
        assertEquals("Narrative Value 3", narrative.getUnstructuredFragments().get(2));
    }

    @Test
    public void testMT202_Field72() {
        String mt202JsonOneNarrative = "{" + "    'type': 'MT',"
                + "    'basicHeaderBlock': {"
                + "        'applicationId': 'F',"
                + "        'serviceId': '01',"
                + "        'logicalTerminal': 'GECGHKHHAXXX',"
                + "        'sessionNumber': '0000',"
                + "        'sequenceNumber': '000000'"
                + "    },"
                + "    'applicationHeaderBlock': {"
                + "        'receiverAddress': 'EXMTHKHHXXXX',"
                + "        'senderInputTime': null,"
                + "        'MIRDate': null,"
                + "        'MIRLogicalTerminal': null,"
                + "        'MIRSessionNumber': null,"
                + "        'MIRSequenceNumber': null,"
                + "        'receiverOutputDate': null,"
                + "        'receiverOutputTime': null,"
                + "        'messagePriority': 'N',"
                + "        'messageType': '202',"
                + "        'direction': 'I'"
                + "    },"
                + "    'userHeaderBlock': {"
                + "        'fields': ["
                + "            {"
                + "                'name': '121',"
                + "                'uniqueReference': '36e05862-4af1-43ed-a54c-ccdcf0101396'"
                + "            }"
                + "        ]"
                + "    },"
                + "    'textBlock': {"
                + "        'fields': ["
                + "            {"
                + "                'name': '20',"
                + "                'reference': 'TEST2021234'"
                + "            },"
                + "            {"
                + "                'name': '21',"
                + "                'reference': 'TEST202123233'"
                + "            },"
                + "            {"
                + "                'name': '32A',"
                + "                'date': '230131',"
                + "                'currency': 'USD',"
                + "                'amount': '7878778,'"
                + "            },"
                + "            {"
                + "                'name': '58A',"
                + "                'account': '898989',"
                + "                'bIC': 'EXMTHKHH'"
                + "            },"
                + "            {"
                + "                'name': '72',"
                + "                'structured': ["
                + "                    {"
                + "                        'narrativeFragments': ["
                + "                            'PURPOSE CODE 1670',"
                + "                            'SERVICES, SELF COMPANY FUNDING'"
                + "                        ],"
                + "                        'narrativeSupplementFragments': [],"
                + "                        'codeword': 'INS'"
                + "                    }"
                + "                ]"
                + "            }"
                + "        ]"
                + "    }"
                + "}";
        MT202 mt202 = (MT202) AbstractMT.fromJson(mt202JsonOneNarrative);
        Narrative narrative = mt202.getField72().narrative();
        StructuredNarrative structuredNarrative = narrative.getStructured().get(0);
        assertEquals("INS", structuredNarrative.getCodeword());
        assertEquals(
                "PURPOSE CODE 1670", structuredNarrative.getNarrativeFragments().get(0));
        assertEquals(
                "SERVICES, SELF COMPANY FUNDING",
                structuredNarrative.getNarrativeFragments().get(1));
    }

    @Test
    public void testInvalidField() {
        final String json = "{\n"
                + "    \"type\": \"MT\",\n"
                + "    \"basicHeaderBlock\": {\n"
                + "        \"applicationId\": \"F\",\n"
                + "        \"serviceId\": \"01\",\n"
                + "        \"logicalTerminal\": \"AAAABEBBAXXX\",\n"
                + "        \"sessionNumber\": \"0001\",\n"
                + "        \"sequenceNumber\": \"000001\"\n"
                + "    },\n"
                + "    \"applicationHeaderBlock\": {\n"
                + "    \"receiverAddress\": \"BBBBBEBBXBIL\",\n"
                + "    \"messagePriority\": \"N\",\n"
                + "    \"messageType\": \"565\",\n"
                + "    \"blockType\": \"I\",\n"
                + "    \"direction\": \"I\"\n"
                + "    },\n"
                + "    \"userHeaderBlock\": {\n"
                + "        \"fields\": [\n"
                + "            { \"name\": \"108\", \"mUR\": \"495\" }\n"
                + "        ]\n"
                + "    },\n"
                + "    \"textBlock\": {\n"
                + "        \"fields\": [\n"
                + "            { \"name\": \"16R\", \"blockName\": \"GENL\" },\n"
                // invalid name
                + "            { \"name\": \"foo\", \"qualifier\": \"CORP\", \"reference\": \"ABCD1234\" },\n"
                // incomatible structure for components
                + "            { \"name\": \"99Q\", \"function\": \"NEWM\" },\n"
                // empty name
                + "            { \"name\": \"\", \"qualifier\": \"CAEV\", \"indicator\": \"CONV\" },\n"
                // missing name
                + "            { \"qualifier\": \"PREP\", \"date\": \"20210912\", \"time\": \"123111\" }\n"
                + "        ]\n"
                + "    }\n"
                + "}\n";
        AbstractMT mt = AbstractMT.fromJson(json);
        assertNotNull(mt);
        assertEquals(1, mt.getFields().size());
        assertTrue(mt.getFields().get(0) instanceof Field16R);
    }

    @Test
    public void testMT103ParsingWithTrailingSlashesInField70() {
        String msg =
                "{1:F01FOOGIT2TAXXX8236800072}{2:O1030750131111FOOGDEFFAXXX04925010251311110751N}{3:{103:TGT}{113:NNNN}{108:96NG868888869101}{119:STP}{121:1420a5f5-a452-436b-ab36-b2d3379c40e5}{115:075115075115DE0000000497323714}}{4:\n"
                        + ":20:96NG868888869101\n"
                        + ":23B:CRED\n"
                        + ":32A:131111EUR1170,\n"
                        + ":33B:EUR1170,\n"
                        + ":50F:CCPT/RU/03 01 767874 DD 08.08.2002\n"
                        + "1/SOROKIN PAVEL NIKOLAEVICH\n"
                        + "2/SAYAT-NOVA 42\n"
                        + "3/RU/SOCHI\n"
                        + ":52A:FOOIRUMMRA1\n"
                        + ":57A:FOOGIT2TH00\n"
                        + ":59:/IT90W0869254370016000540148\n"
                        + "GRUPPO MANGANO SRL\n"
                        + ":70:/ROC/V250721B47764872///URI/FFC OTP\n"
                        + "P GLOBAL CREDIT LP / NPNF/GLOBAL SE\n"
                        + "RVICE GMBH JUL 2019//\n"
                        + ":71A:OUR\n"
                        + "-}{5:{CHK:044E280702DB}}{S:{SAC:}{FAC:}{COP:P}}";

        MT103 mt103 = new MT103(msg);
        assertNotNull(mt103.getField70());
        String field70Content = mt103.getField70().getValue();
        assertTrue(field70Content.contains("JUL 2019//"), "Field 70 should preserve trailing slashes");
    }
}

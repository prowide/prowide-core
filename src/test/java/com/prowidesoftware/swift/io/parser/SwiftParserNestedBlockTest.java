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
package com.prowidesoftware.swift.io.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Test cases for the nested blocks that SWIFT defines inside the tag list block 4 of some system messages.
 *
 * <p>The affected messages are MT021 (the retrieved message is conveyed as the block 1, 2, 3 headers, the block 4
 * text and the block 5 trailers), MT096 (the copied message is conveyed as a complete block 1 to 5 message) and
 * MT056 (each login attempt in field 270 embeds a block 1 and a block 4).
 */
public class SwiftParserNestedBlockTest {

    /**
     * MT096 FINCopy to Server Destination Message: block 4 is a complete nested message.
     */
    private static final String MT096 = "{1:F01OURSGB33AXXX0000000000}"
            + "{2:O0961625170421ABLRXXXXGXXX00000000001704201625N}"
            + "{3:{103:CLH}{108:SWIFTBICAXXX0000890}}"
            + "{4:{1:F01PTY1US33AXXX0000000000}{2:I300PTY2GB33AXXXU3003}{3:{103:ABC}}{4:\r\n"
            + ":15A:\r\n"
            + ":20:R317703\r\n"
            + ":22A:NEWT\r\n"
            + "-}{5:{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}}}";

    /**
     * MT021 Retrieved Message (Text and History): the retrieved message headers, text and trailers are appended
     * to the report fields in the same block 4.
     */
    private static final String MT021 = "{1:F01VNDZBET2AXXX0000000000}{2:I021DYDYXXXXXXXXN}{4:"
            + "{202:0002}{203:0002}{280:1047010517VNDZBET2AXXX0026000410Y}{108:PRIORITY 2}{431:01}"
            + "{281:1156010517VNDZBET2AXXX0027000584Y}"
            + "{1:F01PTY1US33AXXX0000000000}{2:I300PTY2GB33AXXXU3003}{3:{103:ABC}{108:MUR123}}{4:\r\n"
            + ":20:REF1\r\n"
            + "-}{5:{CHK:73AC90A7A3F1}{TNG:}}}";

    /**
     * MT056 Logical Terminal History Report: every field 270 login attempt embeds a login block and, optionally,
     * a login result, each one made of a block 1 and a block 4.
     */
    private static final String MT056 = "{1:F01VNDZBET2AXXX0000000000}{2:I056DYDYXXXXXXXXN}{4:"
            + "{202:0001}{203:0001}{305:A}"
            + "{270:2410231030{1:F01VNDZBET2AXXX0000000000}{4:{110:001}}}"
            + "{270:2410231045{1:F01VNDZBET2AXXX0000000000}{4:{110:002}{114:1}}}}";

    private static SwiftBlock4 block4(String fin) throws IOException {
        SwiftBlock4 b4 = SwiftMessage.parse(fin).getBlock4();
        assertThat(b4).isNotNull();
        return b4;
    }

    private static void assertTagNamesAndValues(SwiftBlock4 b4, String... nameValuePairs) {
        assertThat(b4.size()).isEqualTo(nameValuePairs.length / 2);
        for (int i = 0; i < nameValuePairs.length; i += 2) {
            Tag tag = b4.getTag(i / 2);
            assertThat(tag.getName()).isEqualTo(nameValuePairs[i]);
            assertThat(tag.getValue()).isEqualTo(nameValuePairs[i + 1]);
        }
    }

    @Nested
    @DisplayName("MT096 - FINCopy nested message")
    class Mt096 {

        @Test
        void nestedBlocksAreParsedAsSingleTags() throws IOException {
            assertTagNamesAndValues(
                    block4(MT096),
                    "1",
                    "F01PTY1US33AXXX0000000000",
                    "2",
                    "I300PTY2GB33AXXXU3003",
                    "3",
                    "{103:ABC}",
                    "4",
                    "\r\n:15A:\r\n:20:R317703\r\n:22A:NEWT\r\n-",
                    "5",
                    "{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}");
        }

        @Test
        void nestedSubBlockTagsDoNotLeakIntoTheBlock4() throws IOException {
            assertThat(block4(MT096).getTagByName("SYS")).isNull();
            assertThat(block4(MT096).getTagByName("CHK")).isNull();
            assertThat(block4(MT096).getTagByName("103")).isNull();
        }

        @Test
        void messageIsWrittenBackUnchanged() throws IOException {
            assertThat(SwiftMessage.parse(MT096).message()).isEqualTo(MT096);
        }

        @Test
        void theOuterTrailersAreNotMixedWithTheNestedOnes() throws IOException {
            String fin = "{1:F01FOOGCC2AAXXX0246000987}"
                    + "{2:O0961200070901ESASNZYYXXXX00001399900709011201S}"
                    + "{3:{103:AVP}{108:FOOICC2AA1234456}}"
                    + "{4:{1:F01FOOICC2AAXXX0123000456}{2:I103RCVRCC2AXXXXU}{3:{103:COP}{108:12345678}}{4:\r\n"
                    + ":20:TRANSREF\r\n"
                    + "-}{5:{MRF:070901120000070901FOOICC2AAXXX0123000456}}}"
                    + "{5:{CHK:017654328DEF}{SYS:1200070901FOOICC2AAXXX01234000456}}";

            SwiftMessage sm = SwiftMessage.parse(fin);

            assertThat(sm.getBlock4().size()).isEqualTo(5);
            assertThat(sm.getBlock4().getTagValue("5")).isEqualTo("{MRF:070901120000070901FOOICC2AAXXX0123000456}");

            assertThat(sm.getBlock5().size()).isEqualTo(2);
            assertThat(sm.getBlock5().getTagValue("CHK")).isEqualTo("017654328DEF");
            assertThat(sm.getBlock5().getTagValue("SYS")).isEqualTo("1200070901FOOICC2AAXXX01234000456");
            assertThat(sm.getBlock5().getTagByName("MRF")).isNull();

            assertThat(sm.message()).isEqualTo(fin);
        }
    }

    @Nested
    @DisplayName("MT021 - retrieved message")
    class Mt021 {

        @Test
        void nestedBlocksAreParsedAsSingleTags() throws IOException {
            assertTagNamesAndValues(
                    block4(MT021),
                    "202",
                    "0002",
                    "203",
                    "0002",
                    "280",
                    "1047010517VNDZBET2AXXX0026000410Y",
                    "108",
                    "PRIORITY 2",
                    "431",
                    "01",
                    "281",
                    "1156010517VNDZBET2AXXX0027000584Y",
                    "1",
                    "F01PTY1US33AXXX0000000000",
                    "2",
                    "I300PTY2GB33AXXXU3003",
                    "3",
                    "{103:ABC}{108:MUR123}",
                    "4",
                    "\r\n:20:REF1\r\n-",
                    "5",
                    "{CHK:73AC90A7A3F1}{TNG:}");
        }

        @Test
        void theMurOfTheNestedBlock3DoesNotCollideWithTheReportField108() throws IOException {
            assertThat(block4(MT021).getTagsByName("108")).hasSize(1);
            assertThat(block4(MT021).getTagValue("108")).isEqualTo("PRIORITY 2");
        }

        @Test
        void messageIsWrittenBackUnchanged() throws IOException {
            assertThat(SwiftMessage.parse(MT021).message()).isEqualTo(MT021);
        }
    }

    @Nested
    @DisplayName("MT056 - login attempts in field 270")
    class Mt056 {

        @Test
        void nestedBlocksAreKeptInTheField270Value() throws IOException {
            assertTagNamesAndValues(
                    block4(MT056),
                    "202",
                    "0001",
                    "203",
                    "0001",
                    "305",
                    "A",
                    "270",
                    "2410231030{1:F01VNDZBET2AXXX0000000000}{4:{110:001}}",
                    "270",
                    "2410231045{1:F01VNDZBET2AXXX0000000000}{4:{110:002}{114:1}}");
        }

        @Test
        void nestedSubBlockTagsDoNotLeakIntoTheBlock4() throws IOException {
            assertThat(block4(MT056).getTagByName("4")).isNull();
            assertThat(block4(MT056).getTagByName("110")).isNull();
        }

        @Test
        void messageIsWrittenBackUnchanged() throws IOException {
            assertThat(SwiftMessage.parse(MT056).message()).isEqualTo(MT056);
        }
    }

    /**
     * Tag list blocks are only read as nested blocks for the tag names where SWIFT defines them. Everywhere else the
     * legacy lenient reading is preserved: an unbalanced or unexpected curly brace in a tag value keeps ending the
     * tag at the first closing brace, as it always did.
     */
    @Nested
    @DisplayName("blocks without nested block definitions are read as before")
    class NotNestedBlocks {

        @Test
        void nakErrorCodeSwallowingTheMurIsReadAsBefore() throws IOException {
            // real world sample where the NAK error code is not closed before the MUR trailer field
            String nak = "{1:F21FOOGIT2TC36A7846389660}{4:{177:1311221031}{451:1}{405:T28008{108:YSGU19326821AXXX}}";
            assertTagNamesAndValues(block4(nak), "177", "1311221031", "451", "1", "405", "T28008{108:YSGU19326821AXXX");
            assertThat(SwiftMessage.parse(nak).message()).isEqualTo(nak);
        }

        @Test
        void wellFormedNakIsReadAsBefore() throws IOException {
            String nak = "{1:F21FOOGIT2TC36A7846389660}{4:{177:1311221031}{451:1}{405:T28008}{108:YSGU19326821AXXX}}";
            assertTagNamesAndValues(
                    block4(nak), "177", "1311221031", "451", "1", "405", "T28008", "108", "YSGU19326821AXXX");
            assertThat(SwiftMessage.parse(nak).message()).isEqualTo(nak);
        }

        @Test
        void trailerValueWithACurlyBraceIsReadAsBefore() throws IOException {
            String fin = "{1:F01AAAAAAAAAXXX0000000000}{2:I103BBBBBBBBXXXXN}{4:\n"
                    + ":20:X\n"
                    + "-}{5:{MAC:{12345678}}{CHK:ABC}}";
            SwiftMessage sm = SwiftMessage.parse(fin);
            assertThat(sm.getBlock5().getTagValue("MAC")).isEqualTo("{12345678");
            assertThat(sm.getBlock5().getTagValue("CHK")).isEqualTo("ABC");
        }

        @Test
        void ackWithTheOriginalMessageAttachedIsReadAsBefore() throws IOException {
            String original = "{1:F01AAAAAAAAAXXX0000000000}{2:I103BBBBBBBBXXXXN}{4:\n" + ":20:X\n" + "-}";
            String ack = "{1:F21AAAAAAAAAXXX0000000000}{4:{177:1003250000}{451:0}}" + original;
            SwiftMessage sm = SwiftMessage.parse(ack);
            assertTagNamesAndValues(sm.getBlock4(), "177", "1003250000", "451", "0");
            assertThat(sm.getUnparsedTextsSize()).isEqualTo(1);
            assertThat(sm.getUnparsedTexts().getText(0)).isEqualTo(original);
        }

        @Test
        void userBlockIsReadAsBefore() throws IOException {
            String fin =
                    "{1:F01AAAAAAAAAXXX0000000000}{2:I103BBBBBBBBXXXXN}{4:\r\n" + ":20:X\r\n" + "-}{S:{SAC:}{COP:P}}";
            SwiftMessage sm = SwiftMessage.parse(fin);
            assertThat(sm.getUserBlock("S").getTagValue("COP")).isEqualTo("P");
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
        }

        @Test
        void unclosedNestedBlockTagIsSkippedAsBefore() throws IOException {
            // the field 270 opens a login block and the message ends without closing any of them
            String truncated = "{1:F01VNDZBET2AXXX0000000000}{2:I056DYDYXXXXXXXXN}{4:"
                    + "{202:0001}{270:2410231030{1:F01VNDZBET2AXXX0000000000";
            SwiftBlock4 b4 = block4(truncated);
            assertTagNamesAndValues(b4, "202", "0001");
        }

        @Test
        void tagWithoutValueSeparatorIsReadAsBefore() throws IOException {
            String fin = "{1:F01AAAAAAAAAXXX0000000000}{2:I103BBBBBBBBXXXXN}{3:{ABC}}{4:\r\n" + ":20:X\r\n" + "-}";
            SwiftMessage sm = SwiftMessage.parse(fin);
            assertThat(sm.getBlock3().size()).isEqualTo(1);
            assertThat(sm.getBlock3().getTag(0).getName()).isNull();
            assertThat(sm.getBlock3().getTag(0).getValue()).isEqualTo("ABC");
        }

        @Test
        void unclosedPlainTagIsSkippedAsBefore() throws IOException {
            String truncated = "{1:F01VNDZBET2AXXX0000000000}{2:I056DYDYXXXXXXXXN}{4:" + "{202:0001}{305:AAAA";
            SwiftBlock4 b4 = block4(truncated);
            assertTagNamesAndValues(b4, "202", "0001");
        }

        @Test
        void block3IsReadAsBefore() throws IOException {
            String fin = "{1:F01AAAAAAAAAXXX0000000000}{2:I103BBBBBBBBXXXXN}{3:{108:MUR123}{119:STP}}{4:\r\n"
                    + ":20:X\r\n"
                    + "-}";
            SwiftMessage sm = SwiftMessage.parse(fin);
            assertThat(sm.getBlock3().size()).isEqualTo(2);
            assertThat(sm.getBlock3().getTagValue("108")).isEqualTo("MUR123");
            assertThat(sm.getBlock3().getTagValue("119")).isEqualTo("STP");
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
        }
    }
}

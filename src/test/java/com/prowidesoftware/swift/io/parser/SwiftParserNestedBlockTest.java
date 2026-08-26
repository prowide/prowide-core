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
import static org.assertj.core.api.Assertions.tuple;

import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;
import java.io.IOException;
import java.util.List;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Test cases for the nested blocks that SWIFT defines inside the tag list block 4 of some system messages.
 *
 * <p>The affected messages are MT021 (the retrieved message is conveyed as the block 1, 2, 3 headers, the block 4
 * text and the block 5 trailers), MT096 (the copied message is conveyed as a complete block 1 to 5 message) and
 * MT056 (each login attempt in field 270 embeds a block 1 and a block 4).
 *
 * @see SwiftParserNestedMessageTest
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

    /**
     * Wraps the given block 4 content, which is the nested message, in an MT096 header.
     */
    private static String mt096(String nested) {
        return "{1:F01OURSGB33AXXX0000000000}"
                + "{2:O0961625170421ABLRXXXXGXXX00000000001704201625N}"
                + "{4:"
                + nested
                + "}";
    }

    /**
     * Asserts the block contains exactly the expected tags, in order, each one given as a name and value pair.
     */
    private static void assertTags(SwiftBlock4 b4, Tuple... expectedNamesAndValues) {
        assertThat(b4.getTags()).extracting(Tag::getName, Tag::getValue).containsExactly(expectedNamesAndValues);
    }

    /**
     * Parses the message keeping the parser instance, to assert on the errors it recorded.
     */
    private static List<String> parsingErrors(String fin) throws IOException {
        SwiftParser parser = new SwiftParser(fin);
        parser.message();
        return parser.getErrors();
    }

    @Nested
    @DisplayName("MT096 - FINCopy nested message")
    class Mt096 {

        @Test
        void nestedBlocksAreParsedAsSingleTags() throws IOException {
            assertTags(
                    block4(MT096),
                    tuple("1", "F01PTY1US33AXXX0000000000"),
                    tuple("2", "I300PTY2GB33AXXXU3003"),
                    tuple("3", "{103:ABC}"),
                    tuple("4", "\r\n:15A:\r\n:20:R317703\r\n:22A:NEWT\r\n-"),
                    tuple("5", "{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}"));
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
            assertTags(
                    block4(MT021),
                    tuple("202", "0002"),
                    tuple("203", "0002"),
                    tuple("280", "1047010517VNDZBET2AXXX0026000410Y"),
                    tuple("108", "PRIORITY 2"),
                    tuple("431", "01"),
                    tuple("281", "1156010517VNDZBET2AXXX0027000584Y"),
                    tuple("1", "F01PTY1US33AXXX0000000000"),
                    tuple("2", "I300PTY2GB33AXXXU3003"),
                    tuple("3", "{103:ABC}{108:MUR123}"),
                    tuple("4", "\r\n:20:REF1\r\n-"),
                    tuple("5", "{CHK:73AC90A7A3F1}{TNG:}"));
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
            assertTags(
                    block4(MT056),
                    tuple("202", "0001"),
                    tuple("203", "0001"),
                    tuple("305", "A"),
                    tuple("270", "2410231030{1:F01VNDZBET2AXXX0000000000}{4:{110:001}}"),
                    tuple("270", "2410231045{1:F01VNDZBET2AXXX0000000000}{4:{110:002}{114:1}}"));
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

        @Test
        @DisplayName("a login attempt with both a login block and a login result is kept whole")
        void loginAttemptWithLoginResult() throws IOException {
            String loginAttempt = "2410231030{1:F01VNDZBET2AXXX0000000000}{4:{110:001}}"
                    + "{1:F01VNDZBET2AXXX0000000000}{4:{110:002}}";
            String fin = "{1:F01VNDZBET2AXXX0000000000}{2:I056DYDYXXXXXXXXN}{4:" + "{202:0001}{203:0001}{305:A}{270:"
                    + loginAttempt + "}}";
            assertTags(
                    block4(fin),
                    tuple("202", "0001"),
                    tuple("203", "0001"),
                    tuple("305", "A"),
                    tuple("270", loginAttempt));
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
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
            assertTags(
                    block4(nak),
                    tuple("177", "1311221031"),
                    tuple("451", "1"),
                    tuple("405", "T28008{108:YSGU19326821AXXX"));
            assertThat(SwiftMessage.parse(nak).message()).isEqualTo(nak);
        }

        @Test
        void wellFormedNakIsReadAsBefore() throws IOException {
            String nak = "{1:F21FOOGIT2TC36A7846389660}{4:{177:1311221031}{451:1}{405:T28008}{108:YSGU19326821AXXX}}";
            assertTags(
                    block4(nak),
                    tuple("177", "1311221031"),
                    tuple("451", "1"),
                    tuple("405", "T28008"),
                    tuple("108", "YSGU19326821AXXX"));
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
            assertTags(sm.getBlock4(), tuple("177", "1003250000"), tuple("451", "0"));
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
            assertTags(b4, tuple("202", "0001"));
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

        @Test
        @DisplayName("the nested block tag names are matched exactly, not by prefix")
        void tagNamesCloseToTheNestedBlockOnesAreReadAsBefore() throws IOException {
            String fin =
                    "{1:F01VNDZBET2AXXX0000000000}{2:I056DYDYXXXXXXXXN}{4:" + "{27:A{Y:1}}{45:B{Y:2}}{2701:C{Y:3}}}";
            assertTags(block4(fin), tuple("27", "A{Y:1"), tuple("45", "B{Y:2"), tuple("2701", "C{Y:3"));
        }

        @Test
        @DisplayName("a tag with an empty name is not read as a nested block")
        void tagWithAnEmptyNameIsReadAsBefore() throws IOException {
            String fin = "{1:F01VNDZBET2AXXX0000000000}{2:I056DYDYXXXXXXXXN}{4:" + "{202:0001}{:A{Y:1}}}";
            SwiftBlock4 b4 = block4(fin);
            assertThat(b4.getTagValue("202")).isEqualTo("0001");
            assertThat(b4.getTag(1).getValue()).isEqualTo("A{Y:1");
        }
    }

    /**
     * Well formed variations of the nested blocks, beyond the plain MT021, MT056 and MT096 samples.
     */
    @Nested
    @DisplayName("nested block variations")
    class Variations {

        /**
         * The block 4 of the MT096 copied message, which is itself a complete MT103, as it travels nested within the
         * retrieved message of an MT021.
         */
        private static final String MT096_BLOCK_4 = "{1:F01PTY1US33AXXX0000000000}{2:I103PTY2GB33AXXXN}{4:\r\n"
                + ":20:REF103\r\n"
                + "-}{5:{CHK:AAAAAAAAAAAA}}";

        @Test
        @DisplayName("a retrieved message that is itself a FINCopy nests three levels deep")
        void threeLevelsOfNesting() throws IOException {
            // an MT021 whose retrieved message is an MT096, whose copied message is an MT103
            String fin = "{1:F01VNDZBET2AXXX0000000000}{2:I021DYDYXXXXXXXXN}{4:"
                    + "{202:0001}{203:0001}"
                    + "{1:F01OURSGB33AXXX0000000000}"
                    + "{2:O0961625170421ABLRXXXXGXXX00000000001704201625N}"
                    + "{4:"
                    + MT096_BLOCK_4
                    + "}"
                    + "{5:{CHK:BBBBBBBBBBBB}}}";

            assertTags(
                    block4(fin),
                    tuple("202", "0001"),
                    tuple("203", "0001"),
                    tuple("1", "F01OURSGB33AXXX0000000000"),
                    tuple("2", "O0961625170421ABLRXXXXGXXX00000000001704201625N"),
                    tuple("4", MT096_BLOCK_4),
                    tuple("5", "{CHK:BBBBBBBBBBBB}"));
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
        }

        @Test
        @DisplayName("the optional nested block 3 may be absent")
        void copiedMessageWithoutBlock3() throws IOException {
            String fin = mt096("{1:F01PTY1US33AXXX0000000000}{2:I199PTY2GB33AXXXU3003}{4:\r\n"
                    + ":20:X\r\n"
                    + "-}{5:{CHK:73AC90A7A3F1}}");
            assertTags(
                    block4(fin),
                    tuple("1", "F01PTY1US33AXXX0000000000"),
                    tuple("2", "I199PTY2GB33AXXXU3003"),
                    tuple("4", "\r\n:20:X\r\n-"),
                    tuple("5", "{CHK:73AC90A7A3F1}"));
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
        }

        @Test
        @DisplayName("the optional nested block 5 may be absent")
        void copiedMessageWithoutBlock5() throws IOException {
            String fin = mt096(
                    "{1:F01PTY1US33AXXX0000000000}{2:I199PTY2GB33AXXXU3003}{3:{103:ABC}}{4:\r\n" + ":20:X\r\n" + "-}");
            assertTags(
                    block4(fin),
                    tuple("1", "F01PTY1US33AXXX0000000000"),
                    tuple("2", "I199PTY2GB33AXXXU3003"),
                    tuple("3", "{103:ABC}"),
                    tuple("4", "\r\n:20:X\r\n-"));
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
        }

        @Test
        @DisplayName("an empty nested block is read as a tag without value, and written back unchanged")
        void emptyNestedBlock3() throws IOException {
            String fin = mt096("{1:F01PTY1US33AXXX0000000000}{3:}{4:\r\n" + ":20:X\r\n" + "-}");
            SwiftBlock4 b4 = block4(fin);
            assertThat(b4.size()).isEqualTo(3);
            assertThat(b4.getTagByName("3")).isNotNull();
            // Tag(String) leaves the value null when there is nothing after the separator
            assertThat(b4.getTagValue("3")).isNull();
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
        }

        @Test
        @DisplayName("a nested block 5 with several trailers is kept whole")
        void nestedBlock5WithSeveralTrailers() throws IOException {
            String fin = mt096("{1:F01PTY1US33AXXX0000000000}{4:\r\n"
                    + ":20:X\r\n"
                    + "-}{5:{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}{TNG:}}");
            assertThat(block4(fin).getTagValue("5"))
                    .isEqualTo("{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}{TNG:}");
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
        }

        @Test
        @DisplayName("a nested block 4 in tag mode is balanced instead of ending at an end of block mark")
        void copiedSystemMessageHasATagModeBlock4() throws IOException {
            String fin = mt096("{1:F01PTY1US33AXXX0000000000}{2:O0111625170421ABLRXXXXGXXX00000000001704201625N}"
                    + "{4:{177:1003250000}{451:0}}{5:{CHK:73AC90A7A3F1}}");
            assertTags(
                    block4(fin),
                    tuple("1", "F01PTY1US33AXXX0000000000"),
                    tuple("2", "O0111625170421ABLRXXXXGXXX00000000001704201625N"),
                    tuple("4", "{177:1003250000}{451:0}"),
                    tuple("5", "{CHK:73AC90A7A3F1}"));
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
        }

        @Test
        @DisplayName("an end of block sequence within the nested text is not mistaken for the end of the block")
        void endOfBlockSequenceInsideTheNestedText() throws IOException {
            // the first "-}" does not follow a line break, so it is part of the narrative and the search for the end
            // of block mark continues after it
            String fin =
                    mt096("{1:F01PTY1US33AXXX0000000000}{4:\r\n" + ":79:NARRATIVE X{Y-}Z\r\n" + "-}{5:{CHK:73AC90A7}}");
            assertTags(
                    block4(fin),
                    tuple("1", "F01PTY1US33AXXX0000000000"),
                    tuple("4", "\r\n:79:NARRATIVE X{Y-}Z\r\n-"),
                    tuple("5", "{CHK:73AC90A7}"));
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
        }

        @Test
        @DisplayName("an unmatched opening brace in the nested text does not swallow the following blocks")
        void unmatchedOpeningBraceInTheNestedText() throws IOException {
            // the parser is lenient with curly braces in a text block value, see
            // SwiftParserParseBlockTest#testGetBlock4Brackets1
            String fin = "{1:F01OURSGB33AXXX0000000000}"
                    + "{2:O0961625170421ABLRXXXXGXXX00000000001704201625N}"
                    + "{4:{1:F01PTY1US33AXXX0000000000}{2:I199PTY2GB33AXXXU3003}{4:\r\n"
                    + ":79:foobar{bad\r\n"
                    + "-}{5:{CHK:73AC90A7A3F1}}}";

            assertTags(
                    block4(fin),
                    tuple("1", "F01PTY1US33AXXX0000000000"),
                    tuple("2", "I199PTY2GB33AXXXU3003"),
                    tuple("4", "\r\n:79:foobar{bad\r\n-"),
                    tuple("5", "{CHK:73AC90A7A3F1}"));

            // the braces of the sample are unbalanced by one, so the reader reaches the end of the input looking for
            // the closing brace of the block 4 and reports it. The message is therefore not written back unchanged
            assertThat(parsingErrors(fin)).containsExactly("Missing or invalid closing bracket in block 4");
        }
    }

    /**
     * Malformed or truncated nesting. The parser is lenient with these, the point of the assertions below is to pin
     * the outcome down so that any future change to the nested block reading is a deliberate one.
     */
    @Nested
    @DisplayName("malformed nesting")
    class MalformedNesting {

        @Test
        @DisplayName("an unclosed nested block tag does not leak its sub-tags into the enclosing block")
        void unclosedNestedBlockTagFallsBackToTheHistoricalReading() throws IOException {
            // the nested block 5 is opened and the message ends before it is closed, so the tag is read as any other
            // tag, ending at the first closing brace, instead of dropping the tag and reading CHK as a sibling
            String truncated = "{1:F01AAAAAAAAAXXX0000000000}{4:{1:AAA}{5:{CHK:X}";
            SwiftBlock4 b4 = block4(truncated);
            assertTags(b4, tuple("1", "AAA"), tuple("5", "{CHK:X"));
            assertThat(b4.getTagByName("CHK")).isNull();
            assertThat(b4.getUnparsedTextsSize()).isZero();
        }

        @Test
        @DisplayName("an unclosed nested block tag with nothing left to read is skipped as before")
        void unclosedNestedBlockTagIsSkippedAsBefore() throws IOException {
            // the field 270 opens a login block and the message ends without closing any of them, there is no closing
            // brace left for the fallback reading either, so the tag is discarded
            String truncated = "{1:F01VNDZBET2AXXX0000000000}{2:I056DYDYXXXXXXXXN}{4:"
                    + "{202:0001}{270:2410231030{1:F01VNDZBET2AXXX0000000000";
            SwiftBlock4 b4 = block4(truncated);
            assertTags(b4, tuple("202", "0001"));
        }

        @Test
        @DisplayName("an unbalanced sub-tag makes a nested tag mode block 4 swallow the nested block 5")
        void unbalancedSubTagInANestedTagModeBlock4() throws IOException {
            // an MT096 copying the malformed NAK of NotNestedBlocks#nakErrorCodeSwallowingTheMurIsReadAsBefore: the
            // error code 405 is never closed, so the nested block 4 is only balanced by the closing brace of the
            // nested block 5 and takes it in
            String fin = mt096("{4:{405:T28008{108:X}}{5:{CHK:A}}");
            assertTags(block4(fin), tuple("4", "{405:T28008{108:X}}{5:{CHK:A}}"));
            assertThat(parsingErrors(fin)).containsExactly("Missing or invalid closing bracket in block 4");
        }

        @Test
        @DisplayName("two nested text blocks 4 merge when the first one has no end of block mark")
        void twoNestedTextBlocks4WhenTheFirstHasNoEndOfBlockMark() throws IOException {
            // a nested message has a single block 4, so this cannot be a well formed sample. The first block 4 ends
            // with a plain closing brace, so the end of block mark that closes the second one is taken as its own
            String fin = mt096("{4:\r\n" + ":20:X\r\n" + "}{4:\r\n" + ":20:Y\r\n" + "-}");
            assertTags(block4(fin), tuple("4", "\r\n:20:X\r\n}{4:\r\n:20:Y\r\n-"));
            // the content is preserved, so the message is still written back unchanged
            assertThat(SwiftMessage.parse(fin).message()).isEqualTo(fin);
        }

        @Test
        @DisplayName("an end of block sequence in the nested text truncates the enclosing block 4")
        void endOfBlockSequenceInsideTheNestedTextWithoutCurlyBraces() throws IOException {
            // the "-}" of the narrative closes the enclosing block 4 before the tag reading even starts, because the
            // block content is delimited by the block reader and not by the nested block tag values. The nested
            // trailers therefore end up as the trailers of the enclosing message. This is a pre-existing limitation
            // of the block reader, unrelated to the nested block tag values, kept here to document it
            String fin =
                    mt096("{1:F01PTY1US33AXXX0000000000}{4:\r\n" + ":79:NARRATIVE XY-}Z\r\n" + "-}{5:{CHK:73AC90A7}}");
            SwiftMessage sm = SwiftMessage.parse(fin);
            assertTags(sm.getBlock4(), tuple("1", "F01PTY1US33AXXX0000000000"), tuple("4", "\r\n:79:NARRATIVE XY-"));
            assertThat(sm.getBlock5().getTagValue("CHK")).isEqualTo("73AC90A7");
            assertThat(sm.message()).isNotEqualTo(fin);
        }
    }

    @Nested
    @DisplayName("single block parse of a nested block content")
    class SingleBlockParse {

        @Test
        @DisplayName("parseBlock3 prepends the identifier to content that merely starts with the same digit")
        void parseBlock3WithContentStartingWithTheSameDigit() {
            assertThat(SwiftParser.parseBlock3("{308:X}").getTagValue("308")).isEqualTo("X");
        }

        @Test
        @DisplayName("parseBlock5 keeps the legacy reading for a trailer value with a curly brace")
        void parseBlock5WithACurlyBraceInTheValue() {
            assertThat(SwiftParser.parseBlock5("{MAC:{12345678}}").getTagValue("MAC"))
                    .isEqualTo("{12345678");
        }

        @Test
        @DisplayName("the block identifier form does not leave the closing brace as an unparsed text")
        void identifierFormLeavesNoUnparsedText() {
            assertThat(SwiftParser.parseBlock3("{3:{103:CLH}{108:MUR123}}").getUnparsedTextsSize())
                    .isZero();
            assertThat(SwiftParser.parseBlock5("{5:{CHK:73AC90A7A3F1}}").getUnparsedTextsSize())
                    .isZero();
        }

        @Test
        @DisplayName("a null content returns an empty block instead of failing")
        void nullContentReturnsAnEmptyBlock() {
            assertThat(SwiftParser.parseBlock3(null).isEmpty()).isTrue();
            assertThat(SwiftParser.parseBlock5(null).isEmpty()).isTrue();
        }
    }
}

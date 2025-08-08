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
package com.prowidesoftware.swift.io.parser;

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.Constants;
import com.prowidesoftware.swift.model.*;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Swift parser tests using the default lenient (permissive) mode.
 *
 * <p>In this configuration the parser will apply a best effort heuristic to read all blocks content. For instance it
 * will read the block 4 regardless of the proper closing boundary -} and also will read the headers even if some
 * fields are not present and the overall header size is incorrect. In lenient mode exceptions are not thrown but the
 * parsing issues are reported in the parser internal list of errors.
 */
public class SwiftParserConsumeBlockLenientTest {
    protected VisibleParser parser;

    @BeforeEach
    public void setUp() {
        this.parser = new VisibleParser();
        this.parser.getConfiguration().setLenient(true);
    }

    @Test
    public void testConsumeBock1InvalidValueSize() throws IOException {
        parser.setData("{1:012345678901}");
        parser.consumeBlock(null);
        assertError();
    }

    private void assertError() {
        assertFalse(parser.getErrors().isEmpty());
        for (String error : parser.getErrors()) {
            System.out.println(error);
        }
    }

    @Test
    public void testConsumeBock1MissingClossingBracket() throws IOException {
        parser.setData("{1:0123456789012345678901234");
        parser.consumeBlock(null);
        assertError();
    }

    @Test
    public void testConsumeBock1MissingClossingBracket2() throws IOException {
        parser.setData("{1:0123456789012345678901234{2:I100BANKDEFFXXXXU3003}");
        parser.consumeBlock(null);
        assertError();
    }

    @Test
    public void testConsumeBock2InvalidValueSize() throws IOException {
        parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I100BANKDEFF3}");
        parser.consumeBlock(null); // block 1
        parser.consumeBlock(null); // block 2
        assertError();
    }

    @Test
    public void testConsumeBock2MissingClosingBracket() throws IOException {
        parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I100BANKDEFFXXXXU3003");
        parser.consumeBlock(null); // block 1
        parser.consumeBlock(null); // block 2
        assertError();
    }

    @Test
    public void testConsumeBock2MissingClosingBracket2() throws IOException {
        parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I100BANKDEFFXXXXU3003{3:{108:11111111}}");
        parser.consumeBlock(null); // block 1
        parser.consumeBlock(null); // block 2
        assertError();
    }

    @Test
    public void testConsumeBock3MissingClosingBracket() throws IOException {
        parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I100BANKDEFFXXXXU3003}{3:{108:11111111}");
        parser.consumeBlock(null); // block 1
        parser.consumeBlock(null); // block 2
        parser.consumeBlock(null); // block 3
        assertError();
    }

    @Test
    public void testBlock4MissingClossingBracket() throws IOException {
        parser.setData("{4:\r\n" + ":79:FOO");
        parser.consumeBlock(null);
        assertError();
    }

    @Test
    public void testBlock4MissingClossingBracket2() throws IOException {
        parser.setData("{4:\r\n" + ":79:FOO\r\n");
        parser.consumeBlock(null);
        assertError();
    }

    @Test
    public void testBlock4MissingClossingBracket3() throws IOException {
        parser.setData("{4:\r\n" + ":79:FOO\r\n" + "-");
        parser.consumeBlock(null);
        assertError();
    }

    @Test
    public void testBlock4MissingClossingBracket4() throws IOException {
        parser.setData("{4:\r\n" + ":79:FOO\r\n" + "-{");
        parser.consumeBlock(null);
        assertError();
    }

    @Test
    public void testBlock4MissingClossingBracket5() throws IOException {
        parser.setData("{4:\r\n" + ":79:FOO\r\n" + "-{5:CHK:ABSH}");
        parser.consumeBlock(null);
        assertError();
    }

    @Test
    public void testBlock4MissingClossingHyphen() throws IOException {
        parser.setData("{4:\r\n" + ":79:FOO\r\n" + "}");
        parser.consumeBlock(null);
        assertError();
    }

    @Test
    public void testBlock4MissingClossingHyphen2() throws IOException {
        parser.setData("{4:\r\n" + ":79:FOO}");
        parser.consumeBlock(null);
        assertError();
    }

    @Test
    public void testBlock4ClossingBracketOk() throws IOException {
        parser.setData("{4:\r\n" + ":79:FOO\r\n" + "-}");
        parser.consumeBlock(null);
    }

    @Test
    public void testConsumeBock_01() throws IOException {
        parser.setData("{1:0123456789012345678901234}");
        final SwiftBlock1 b = (SwiftBlock1) parser.consumeBlock(null);
        assertNotNull(b);
        assertTrue(b instanceof SwiftBlock1);
        assertEquals("0123456789012345678901234", b.getBlockValue());
    }

    @Test
    public void testConsumeBock_02() throws IOException {
        parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I100BANKDEFFXXXXU3003}");
        final SwiftBlock1 b = (SwiftBlock1) parser.consumeBlock(null);
        assertNotNull(b);
        assertEquals(1, b.getNumber().intValue());
        assertEquals("F01FOOBARXXXXXX0000000000", b.getBlockValue());

        final SwiftBlock2 b2 = (SwiftBlock2) parser.consumeBlock(null);
        assertNotNull(b2);
        assertEquals(2, b2.getNumber().intValue());
        assertEquals("I100BANKDEFFXXXXU3003", b2.getBlockValue());
    }

    @Test
    public void testConsumeBock_03() throws IOException {
        parser.setData("{1:F01FOOBARXXXXXX0000000000}{2:I541CITIGB2LXXXXN}{4:\r\n" + ":16R:GENL\r\n"
                + ":20C::SEME//2005070600000006\r\n"
                + ":23G:NEWM\r\n"
                + ":98A::PREP//20050706\r\n"
                + ":16S:GENL\r\n"
                + ":16R:TRADDET\r\n"
                + ":98A::TRAD//20050706\r\n"
                + ":98A::SETT//20050711\r\n"
                + ":90B::DEAL//ACTU/GBP1,38\r\n"
                + ":35B:ISIN GB0007192106\r\n"
                + "VODAFONE\r\n"
                + ":16S:TRADDET\r\n"
                + ":16R:FIAC\r\n"
                + ":36B::SETT//UNIT/5000,00\r\n"
                + ":97A::SAFE//6990457647\r\n"
                + ":16S:FIAC\r\n"
                + ":16R:SETDET\r\n"
                + ":22F::SETR//TRAD\r\n"
                + ":16R:SETPRTY\r\n"
                + ":95R::DEAG/CRST/382\r\n"
                + ":16S:SETPRTY\r\n"
                + ":16R:SETPRTY\r\n"
                + ":95P::SELL//ISNTGB2L\r\n"
                + ":16S:SETPRTY\r\n"
                + ":16R:SETPRTY\r\n"
                + ":95P::PSET//CRSTGB22\r\n"
                + ":16S:SETPRTY\r\n"
                + ":16R:AMT\r\n"
                + ":19A::SETT//GBP6958,31\r\n"
                + ":16S:AMT\r\n"
                + ":16S:SETDET\r\n"
                + "-}\r\n"
                + "");
        final SwiftBlock1 b1 = (SwiftBlock1) parser.consumeBlock(null);
        assertNotNull(b1);
        assertEquals(1, b1.getNumber().intValue());
        assertEquals("F01FOOBARXXXXXX0000000000", b1.getBlockValue());

        final SwiftBlock2 b2 = (SwiftBlock2) parser.consumeBlock(null);
        assertNotNull(b2);
        assertEquals(2, b2.getNumber().intValue());
        assertEquals("I541CITIGB2LXXXXN", b2.getBlockValue());

        final SwiftBlock4 b4 = (SwiftBlock4) parser.consumeBlock(null);
        assertNotNull(b4);
        assertEquals(4, b4.getNumber().intValue());
        // assertEquals("", b4.getBlockValue());

        final SwiftBlock nil = parser.consumeBlock(null);
        assertNull(nil);
    }

    @Test
    public void testSimpleBlockConsumerBlock3_1() throws IOException {
        parser.setData("{3:{108:00112233}}");
        final SwiftBlock3 b3 = (SwiftBlock3) parser.consumeBlock(null);
        assertNotNull(b3);
        assertTrue(b3.containsTag("108"));
        assertEquals("00112233", b3.getTagValue("108"));
    }

    @Test
    public void testSimpleBlockConsumerBlock3_2() throws IOException {
        parser.setData("{3:{108:00112233}{4:foobar}}");
        final SwiftBlock3 b3 = (SwiftBlock3) parser.consumeBlock(null);
        assertNotNull(b3);
        assertTrue(b3.containsTag("108"));
        assertEquals("00112233", b3.getTagValue("108"));
        assertTrue(b3.containsTag("4"));
        assertEquals("foobar", b3.getTagValue("4"));
    }

    @Test
    public void testSimpleBlockConsumerBlock5_1() throws IOException {
        parser.setData("{5:{108:00112233}}");
        final SwiftBlock5 b = (SwiftBlock5) parser.consumeBlock(null);
        assertNotNull(b);
        assertTrue(b.containsTag("108"));
        assertEquals("00112233", b.getTagValue("108"));
    }

    @Test
    public void testSimpleBlockConsumerBlock5_2() throws IOException {
        parser.setData("{5:{108:00112233}{4:foobar}}");
        final SwiftBlock5 b = (SwiftBlock5) parser.consumeBlock(null);
        assertNotNull(b);
        assertTrue(b.containsTag("108"));
        assertEquals("00112233", b.getTagValue("108"));
        assertTrue(b.containsTag("4"));
        assertEquals("foobar", b.getTagValue("4"));
    }

    @Test
    public void testBug1539324() throws IOException {
        final String fin = "{1:" + Constants.B1_DATA + "}{3:{n:v}}";
        parser.setData(fin);
        final SwiftBlock1 b1 = (SwiftBlock1) parser.consumeBlock(null);
        final SwiftBlock3 b3 = (SwiftBlock3) parser.consumeBlock(null);
        assertEquals(Constants.B1_DATA, b1.getValue());
        assertEquals(1, b3.countAll());
        assertEquals("n", b3.getTag(0).getName());
        assertEquals("v", b3.getTag(0).getValue());
    }

    /*
     * checks that text mixed with tags is handled as unparsed text
     */
    @Test
    public void testSimpleBlockConsumerBlock3_3_KnownToFail() throws IOException {
        parser.setData("{3:blockdata{108:00112233}{4:foobar}}");
        final SwiftBlock3 b = (SwiftBlock3) parser.consumeBlock(null);
        assertNotNull(b);
        assertTrue(b.containsTag("108"));
        assertEquals("00112233", b.getTagValue("108"));
        assertTrue(b.containsTag("4"));
        assertEquals("foobar", b.getTagValue("4"));
        assertEquals(b.getUnparsedTextsSize(), Integer.valueOf(1));
        assertEquals(b.unparsedTextGetText(0), "blockdata");
    }

    @Test
    public void testConsumeEmptyLinesField() {
        SwiftBlock4 b4 = new SwiftBlock4();

        this.parser.consumeBlock4(b4, "\n:20:FOO\r\n");
        assertEquals("FOO", b4.getTags().get(0).getValue());

        this.parser.consumeBlock4(b4, "\n:20:FOO\n");
        assertEquals("FOO", b4.getTags().get(1).getValue());

        this.parser.consumeBlock4(b4, "\n:20:FOO\n\n");
        assertEquals("FOO\n", b4.getTags().get(2).getValue());

        this.parser.consumeBlock4(b4, "\n:20:FOO\n\r\n");
        assertEquals("FOO\n", b4.getTags().get(3).getValue());

        this.parser.consumeBlock4(b4, "\n:20:FOO\r\n\r\n");
        assertEquals("FOO\r\n", b4.getTags().get(4).getValue());
    }

    @Test
    // Test empty block 4 content
    void testEmptyBlock4() {
        SwiftBlock4 block = new SwiftBlock4();
        SwiftBlock4 result = this.parser.consumeBlock4(block, "4:");

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    // Test block 4 with only identifier
    void testBlock4OnlyIdentifier() {
        SwiftBlock4 block = new SwiftBlock4();
        SwiftBlock4 result = this.parser.consumeBlock4(block, "4");

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    // Test single character block
    void testSingleCharacterBlock() {
        SwiftBlock4 block = new SwiftBlock4();
        SwiftBlock4 result = this.parser.consumeBlock4(block, ":");

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    // Test simple text block with single tag
    void testSimpleTextBlock() {
        SwiftBlock4 block = new SwiftBlock4();
        SwiftBlock4 result = this.parser.consumeBlock4(block, "4::20:REFERENCE123");

        assertNotNull(result);
        assertEquals(1, result.size());
        Tag tag = result.getTag(0);
        assertEquals("20", tag.getName());
        assertEquals("REFERENCE123", tag.getValue());
    }

    @Test
    // Test text block with multiple tags
    void testTextBlockMultipleTags() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20:REF123\n:23B:CRED\n:32A:240101USD1000,00";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("20", result.getTag(0).getName());
        assertEquals("23B", result.getTag(1).getName());
        assertEquals("32A", result.getTag(2).getName());
    }

    @Test
    // Test text block with CRLF line endings
    void testTextBlockWithCRLF() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20:REF123\r\n:23B:CRED\r\n:32A:240101USD1000,00";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    // Test text block with EOB (End of Block) marker
    void testTextBlockWithEOB() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20:REF123\n:32A:240101USD1000,00\n-";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(2, result.size());
        // Last tag should have EOB stripped
        Tag lastTag = result.getTag(1);
        assertEquals("240101USD1000,00", lastTag.getValue());
    }

    @Test
    // Test text block with CRLF EOB marker
    void testTextBlockWithCRLFEOB() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20:REF123\r\n:32A:240101USD1000,00\r\n-";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(2, result.size());
        Tag lastTag = result.getTag(1);
        assertEquals("240101USD1000,00", lastTag.getValue());
    }

    @Test
    // Test tag block with braces
    void testTagBlock() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:{101:0001}{102:BANKDEFFXXXX}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("101", result.getTag(0).getName());
        assertEquals("0001", result.getTag(0).getValue());
        assertEquals("102", result.getTag(1).getName());
        assertEquals("BANKDEFFXXXX", result.getTag(1).getValue());
    }

    @Test
    // Test mixed tag and text format
    void testMixedTagAndTextFormat() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:{101:0001}:20:REF123";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    // Test unparsed text before tags
    void testUnparsedTextBeforeTags() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:UNPARSED TEXT\n:20:REF123";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertNotNull(result.getUnparsedTexts());
        assertTrue(result.getUnparsedTexts().size() > 0);
    }

    @Test
    // Test unparsed text with {1: pattern
    void testUnparsedTextWithBlock1Pattern() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:{1:UNPARSED}:20:REF123";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        // Should handle {1: as unparsed text
        assertNotNull(result.getUnparsedTexts());
    }

    @Test
    // Test tag with unparsed text inside
    void testTagWithUnparsedText() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:{20:REF123{1:INNER}}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        Tag tag = result.getTag(0);
        assertEquals("20", tag.getName());
        assertEquals("REF123", tag.getValue());
        assertNotNull(tag.getUnparsedTexts());
    }

    @Test
    // Test malformed tag - missing colon
    void testMalformedTagMissingColon() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20REF123";

        assertThrows(IllegalArgumentException.class, () -> {
            parser.consumeBlock4(block, content);
        });
    }

    @Test
    // Test tag with empty name
    void testTagWithEmptyName() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::VALUE_ONLY";

        // Should throw IllegalArgumentException for empty tag name
        assertThrows(IllegalArgumentException.class, () -> {
            parser.consumeBlock4(block, content);
        });
    }

    @Test
    // Test tag with empty value
    void testTagWithEmptyValue() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20:";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("20", result.getTag(0).getName());
        assertEquals("", result.getTag(0).getValue());
    }

    @Test
    // Test block ending with closing brace
    void testBlockEndingWithClosingBrace() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20:REF123}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    // Test block ending with -}
    void testBlockEndingWithDashBrace() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20:REF123-}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        // Should not include -} in tag value
        assertEquals("REF123", result.getTag(0).getValue());
    }

    @Test
    // Test nested braces in tag block
    void testNestedBraces() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:{108:{{NESTED}}}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("108", result.getTag(0).getName());
        assertEquals("{{NESTED}}", result.getTag(0).getValue());
    }

    @Test
    // Test multiple unparsed texts
    void testMultipleUnparsedTexts() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:UNPARSED1{1:BLOCK1}UNPARSED2{1:BLOCK2}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertNotNull(result.getUnparsedTexts());
        assertTrue(result.getUnparsedTexts().size() >= 2);
    }

    @Test
    // Test whitespace handling
    void testWhitespaceHandling() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:   \n  :20:REF123  \n  ";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("20", result.getTag(0).getName());
    }

    @Test
    // Test char 'c' equals '}' branch in switch
    void testSwitchCaseBrace() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        // Tests the switch case for '}' character
    }

    @Test
    // Test char 'c' equals ':' branch in switch")
    void testSwitchCaseColon() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20:VALUE";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        // Tests the switch case for ':' character
    }

    @Test
    // Test char 'c' equals '{' branch in switch
    void testSwitchCaseOpenBrace() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:{20:VALUE}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        // Tests the switch case for '{' character
    }

    @Test
    // Test s.startsWith('1:') condition true
    void testStartsWithOneColonTrue() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:{1:UNPARSED_BLOCK}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        // Tests the condition s.startsWith("1:") == true
    }

    @Test
    // Test s.startsWith('1:') condition false
    void testStartsWithOneColonFalse() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:{20:NORMAL_TAG}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        // Tests the condition s.startsWith("1:") == false
    }

    @Test
    // Test utPos != -1 condition
    void testUtPosNotMinusOne() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:{20:VALUE{1:UNPARSED}}";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        // Tests the condition utPos != -1
    }

    @Test
    // Test tag != null condition
    void testTagNotNull() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20:VALUE";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());
        // Tests the condition tag != null
    }

    @Test
    // Test stripEOB with null lastTag
    void testStripEOBWithNullLastTag() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        // Tests stripEOB method with lastTag == null
    }

    @Test
    // Test all loop conditions and increments
    void testLoopConditionsAndIncrements() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:ABC:20:VAL1:21:VAL2XYZ";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        // Tests various loop conditions: start < s.length(), i < data.length(), etc.
    }

    @Test
    // Test ignore calculation branches
    void testIgnoreCalculation() {
        String content1 = "4::20:VALUE-}";
        String content2 = "4::20:VALUE}";

        SwiftBlock4 result1 = this.parser.consumeBlock4(new SwiftBlock4(), content1);
        SwiftBlock4 result2 = this.parser.consumeBlock4(new SwiftBlock4(), content2);

        assertNotNull(result1);
        assertNotNull(result2);
        // Tests both ignore = 1 and ignore = 0 branches
    }

    @Test
    // Test unparsedText.isEmpty() conditions
    void testUnparsedTextEmptyConditions() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:   :20:VALUE   ";
        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        // Tests both !StringUtils.isEmpty(unparsedText) branches
    }

    @Test
    // Test comprehensive scenario covering all branches
    void testComprehensiveScenario() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:INITIAL_UNPARSED\n" + ":20:REF123\n"
                + "MID_UNPARSED\n"
                + "{21:TAG_BLOCK}\n"
                + "{1:UNPARSED_BLOCK_START{NESTED}MORE{1:ANOTHER}}\n"
                + ":32A:DATE_VALUE{1:TAG_UNPARSED}\n"
                + "FINAL_UNPARSED\r\n-";

        SwiftBlock4 result = this.parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertNotNull(result.getUnparsedTexts());

        // Verify EOB stripping worked
        if (result.size() > 0) {
            Tag lastTag = result.getTag(result.size() - 1);
            if (lastTag.getValue() != null) {
                assertFalse(lastTag.getValue().endsWith("-"));
            }
        }
    }

    @Test
    // "Test real SWIFT message format")
    void testRealSwiftMessage() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:\n" + ":20:ASDFASDF\n"
                + ":21:ASDFASDF2342\n"
                + ":32A:180529USD22423,\n"
                + ":52A:SSTYPLP1XXX\n"
                + ":56A:RRPLZAJJXXX\n"
                + ":57A://FFFF\nCTZNCA8V001\n"
                + ":58A:HDSBKHPPXXX\n"
                + ":50K:SDFGSDFG SDFG\n"
                + ":52A:ICBCTWTP238\n"
                + ":57A:ASSRTHB1XXX\n"
                + ":59:ASDF ASDF\n"
                + ":33B:USD234234,\n"
                + "-";

        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(12, result.size());

        // Verify specific tags
        assertEquals("20", result.getTag(0).getName());
        assertEquals("ASDFASDF", result.getTag(0).getValue());

        assertEquals("32A", result.getTag(2).getName());
        assertEquals("180529USD22423,", result.getTag(2).getValue());

        // Verify multiline field (:57A with continuation)
        Tag tag57A = result.getTagByName("57A");
        assertEquals("//FFFF\nCTZNCA8V001", tag57A.getValue());

        // Verify EOB marker is stripped from last tag
        Tag lastTag = result.getTag(result.size() - 1);
        assertEquals("33B", lastTag.getName());
        assertEquals("USD234234,", lastTag.getValue()); // Should not contain "-"
    }

    @Test
    // "Test real SWIFT message format")
    void testWrongSwiftMessage() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4:\n" + "20:ASDFASDF\n"
                + "21:ASDFASDF2342\n"
                + "32A:180529USD22423,\n"
                + "52A:FOOYPLP1XXX\n"
                + "56A:FOOLZAJJXXX\n"
                + "57A://FFFF\nCXXNCA8V001\n"
                + "58A:HDSBKXXPXXX\n"
                + "50K:SDFGSDFG SDFG\n"
                + "52A:IXXCTWTP238\n"
                + "57A:ASSXXHB1XXX\n"
                + "59:ASDF ASDF\n"
                + "33B:USD234234,\n"
                + "-";

        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(1, result.size());

        // Verify specific tags
        assertEquals("ASDFASDF\n" + "21", result.getTag(0).getName());
        assertEquals(
                "ASDFASDF2342\n" + "32A:180529USD22423,\n"
                        + "52A:FOOYPLP1XXX\n"
                        + "56A:FOOLZAJJXXX\n"
                        + "57A://FFFF\n"
                        + "CXXNCA8V001\n"
                        + "58A:HDSBKXXPXXX\n"
                        + "50K:SDFGSDFG SDFG\n"
                        + "52A:IXXCTWTP238\n"
                        + "57A:ASSXXHB1XXX\n"
                        + "59:ASDF ASDF\n"
                        + "33B:USD234234,",
                result.getTag(0).getValue());
    }

    @Test
    // "Test field with double slash prefix")
    void testFieldWithDoubleSlashPrefix() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::57A://ACCOUNT123\n:20:REF";
        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("57A", result.getTag(0).getName());
        assertEquals("//ACCOUNT123", result.getTag(0).getValue());
    }

    @Test
    // "Test multiline field values")
    void testMultilineFieldValues() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::50K:LINE1\nLINE2\nLINE3\n:20:NEXT_TAG";
        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("50K", result.getTag(0).getName());
        assertEquals("LINE1\nLINE2\nLINE3", result.getTag(0).getValue());
        assertEquals("20", result.getTag(1).getName());
        assertEquals("NEXT_TAG", result.getTag(1).getValue());
    }

    @Test
    // "Test field with alphanumeric tag names")
    void testAlphanumericTagNames() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::32A:VALUE1\n:50K:VALUE2\n:52A:VALUE3\n:56A:VALUE4";
        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(4, result.size());

        // Test tags with letter suffixes
        assertEquals("32A", result.getTag(0).getName());
        assertEquals("50K", result.getTag(1).getName());
        assertEquals("52A", result.getTag(2).getName());
        assertEquals("56A", result.getTag(3).getName());
    }

    @Test
    // "Test field values with trailing commas")
    void testFieldValuesWithTrailingCommas() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::32A:180529USD22423,\n:33B:USD234234,";
        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("180529USD22423,", result.getTag(0).getValue());
        assertEquals("USD234234,", result.getTag(1).getValue());
    }

    @Test
    // "Test duplicate tag names")
    void testDuplicateTagNames() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::52A:FIRST_BANK\n:57A:CORRESPONDENT\n:52A:SECOND_BANK";
        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(3, result.size());

        // Both :52A tags should be preserved
        assertEquals("52A", result.getTag(0).getName());
        assertEquals("FIRST_BANK", result.getTag(0).getValue());
        assertEquals("52A", result.getTag(2).getName());
        assertEquals("SECOND_BANK", result.getTag(2).getValue());
    }

    @Test
    // "Test field with mixed case content")
    void testFieldWithMixedCaseContent() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::59:ASDF ASDF\n:50K:SDFGSDFG SDFG";
        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("ASDF ASDF", result.getTag(0).getValue());
        assertEquals("SDFGSDFG SDFG", result.getTag(1).getValue());
    }

    @Test
    // "Test BIC codes in field values")
    void testBICCodesInFieldValues() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::52A:SSTYPLP1XXX\n:56A:RRPLZAJJXXX\n:58A:HDSBKHPPXXX";
        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(3, result.size());

        // Verify BIC codes are preserved exactly
        assertEquals("SSTYPLP1XXX", result.getTag(0).getValue());
        assertEquals("RRPLZAJJXXX", result.getTag(1).getValue());
        assertEquals("HDSBKHPPXXX", result.getTag(2).getValue());
    }

    @Test
    // "Test field continuation without tag prefix")
    void testFieldContinuationWithoutTagPrefix() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::57A://FFFF\nCTZNCA8V001\n:58A:NEXTFIELD";
        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(2, result.size());

        // The continuation line should be part of the 57A field
        assertEquals("57A", result.getTag(0).getName());
        assertEquals("//FFFF\nCTZNCA8V001", result.getTag(0).getValue());
        assertEquals("58A", result.getTag(1).getName());
        assertEquals("NEXTFIELD", result.getTag(1).getValue());
    }

    @Test
    // "Test EOB with only dash (no closing brace)")
    void testEOBWithOnlyDash() {
        SwiftBlock4 block = new SwiftBlock4();
        String content = "4::20:REFERENCE\n:32A:VALUE\n-";
        SwiftBlock4 result = parser.consumeBlock4(block, content);

        assertNotNull(result);
        assertEquals(2, result.size());

        // Last tag should have dash stripped
        Tag lastTag = result.getTag(1);
        assertEquals("32A", lastTag.getName());
        assertEquals("VALUE", lastTag.getValue());
        assertFalse(lastTag.getValue().contains("-"));
    }
}

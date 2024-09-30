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
}

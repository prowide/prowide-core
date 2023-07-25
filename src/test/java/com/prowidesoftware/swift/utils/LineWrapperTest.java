/*
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
package com.prowidesoftware.swift.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineWrapperTest {

    @Test
    public void testWrapIntoList() {
        assertEquals(Collections.emptyList(), LineWrapper.wrapIntoList(null, -1));
        assertEquals(Collections.emptyList(), LineWrapper.wrapIntoList(null, 20));
        assertEquals(Arrays.asList(""), LineWrapper.wrapIntoList("", 20));
        assertEquals(Arrays.asList("abc"), LineWrapper.wrapIntoList("abc", 3));
        assertEquals(Arrays.asList("abc"), LineWrapper.wrapIntoList("     abc", 3));
    }

    @Test
    public void testWrapIntoListReadOnly() {
        assertThrows(
                RuntimeException.class, () -> LineWrapper.wrapIntoList("abc", 5).add("def"));
    }

    @Test
    public void testWrapNull() {
        assertNull(LineWrapper.wrap(null, -1, null));
        assertNull(LineWrapper.wrap(null, 20, System.lineSeparator()));
        assertNull(LineWrapper.wrap(null, 20, null));
        assertNull(LineWrapper.wrap(null, 20, "<br>"));
    }

    @Test
    public void testWrapEmpty() {
        assertEquals("", LineWrapper.wrap("", -1, null));
        assertEquals("", LineWrapper.wrap("", 20, System.lineSeparator()));
        assertEquals("", LineWrapper.wrap("", 20, null));
        assertEquals("", LineWrapper.wrap("", 20, "<br>"));
    }

    @Test
    public void testWrapSpaces1() {
        List<String> actual = LineWrapper.wrapIntoList("  012 34567890 01", 3);
        assertEquals("012", actual.get(0));
        assertEquals("345", actual.get(1));
        assertEquals("678", actual.get(2));
        assertEquals("90", actual.get(3));
        assertEquals("01", actual.get(4));
    }

    @Test
    public void testWrapSpaces2() {
        List<String> actual = LineWrapper.wrapIntoListStrict("  012 34567890 01  a ", 3);
        assertEquals(actual.size(), 6);
        assertEquals("012", actual.get(0));
        assertEquals(" 34", actual.get(1));
        assertEquals("567", actual.get(2));
        assertEquals("890", actual.get(3));
        assertEquals(" 01", actual.get(4));
        assertEquals("  a", actual.get(5));
    }

    @Test
    public void testWrapSpaces3() {
        List<String> actual = LineWrapper.wrapIntoListStrict(
                "  012345678900123456789001 23456789001234567890 0123456789001234567890", 35);
        assertEquals("012345678900123456789001 2345678900", actual.get(0));
        assertEquals("1234567890 0123456789001234567890", actual.get(1));
    }

    @Test
    void testWrapIntoListStrict() {
        // given
        List<String> strings;
        String input;
        String output;
        String delimiter = "";

        // when/ then
        input = "test";
        strings = LineWrapper.wrapIntoListStrict(input, 4);
        output = String.join(delimiter, strings);
        assertEquals(input, output);

        input = "test test";
        strings = LineWrapper.wrapIntoListStrict(input, 4);
        output = String.join(delimiter, strings);
        assertEquals(input, output);

        input = "test test te te tes  test esd sef ds a a a a  c c c  c";
        strings = LineWrapper.wrapIntoListStrict(input, 4);
        output = String.join(delimiter, strings);
        assertEquals(input, output);
    }

    @Test
    void testSampleBuilder() {
        String input = "test test";
        int lineLength = 4;
        List<String> lines = LineWrapper.wrapIntoListStrict(input, lineLength);
        assertEquals(3, lines.size());
    }

    @Test
    public void testWrapSpaces4() {
        List<String> actual =
                LineWrapper.wrapIntoList("  012345678900123456789001 23456789001234567890 0123456789001234567890", 35);
        assertEquals("012345678900123456789001", actual.get(0));
        assertEquals("23456789001234567890", actual.get(1));
        assertEquals("0123456789001234567890", actual.get(2));
    }

    @ParameterizedTest(name = "[{index}] {4}")
    @CsvSource(
            delimiterString = ";",
            useHeadersInDisplayName = false,
            ignoreLeadingAndTrailingWhitespace = false,
            value = {
                "20;'\n';Here is one line of text that is going to be wrapped after 20 columns;"
                        + "'Here is one line of\ntext that is going\nto be wrapped after\n20 columns';normal 1",
                "7;'\n';word1             word2                        word3;"
                        + "'word1  \nword2  \nword3';strip leading spaces on new line, do not strip trailing;",
                "20;<br>;Here is one line of text that is going to be wrapped after 20 columns;"
                        + "'Here is one line of<br>text that is going<br>to be wrapped after<br>20 columns';unusual newline char",
                "30;'\n';    Line with leading spaces;" + "'Line with leading spaces';line with leading spaces",
                "6;'\n';Here is one line;" + "'Here\nis one\nline';short wrap 1",
                "2;'\n';Here is one line;" + "'He\nre\nis\non\ne\nli\nne';short wrap 2",
                "20;'\n';' Here:  is  one  line  of  text  that  is  going  to  be  wrapped  after  20  columns';"
                        + "'Here:  is  one  line\nof  text  that  is \ngoing  to  be \nwrapped  after  20 \ncolumns';with extra spaces",
                "20;'\n';'Here is\tone line of text that is going to be wrapped after 20 columns';"
                        + "'Here is\tone line of\ntext that is going\nto be wrapped after\n20 columns';with tabs",
                "20;'\n';'Here is one line of\ttext that is going to be wrapped after 20 columns';"
                        + "'Here is one line\nof\ttext that is\ngoing to be wrapped\nafter 20 columns';with tab at wrapColumn",
                "30;'\n';flammable/inflammable;" + "flammable/inflammable;no changes",
                "9;'\n';flammable/inflammable;" + "'flammable\n/inflamma\nble';long word break",
                "15;'\n';                               ;" + "'';line of spaces",
            })
    public void testWrap(int wrapLen, String newLineStr, String input, String expected, String message) {
        assertEquals(expected, LineWrapper.wrap(input, wrapLen, newLineStr), message);
    }
}

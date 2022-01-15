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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(RuntimeException.class, () -> LineWrapper.wrapIntoList("abc", 5).add("def"));
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

    @ParameterizedTest(name = "[{index}] {4}")
    @CsvSource(delimiterString = ";", useHeadersInDisplayName = false, ignoreLeadingAndTrailingWhitespace = false, value = {
            "20;'\n';Here is one line of text that is going to be wrapped after 20 columns;"
                    + "'Here is one line of\ntext that is going\nto be wrapped after\n20 columns';normal 1",
            "7;'\n';word1             word2                        word3;"
                    + "'word1  \nword2  \nword3';strip leading spaces on new line, do not strip trailing;",
            "20;<br>;Here is one line of text that is going to be wrapped after 20 columns;"
                    + "'Here is one line of<br>text that is going<br>to be wrapped after<br>20 columns';unusual newline char",
            "30;'\n';    Line with leading spaces;"
                    + "'Line with leading spaces';line with leading spaces",
            "6;'\n';Here is one line;"
                    + "'Here\nis one\nline';short wrap 1",
            "2;'\n';Here is one line;"
                    + "'He\nre\nis\non\ne\nli\nne';short wrap 2",
            "20;'\n';' Here:  is  one  line  of  text  that  is  going  to  be  wrapped  after  20  columns';"
                    + "'Here:  is  one  line\nof  text  that  is \ngoing  to  be \nwrapped  after  20 \ncolumns';with extra spaces",
            "20;'\n';'Here is\tone line of text that is going to be wrapped after 20 columns';"
                    + "'Here is\tone line of\ntext that is going\nto be wrapped after\n20 columns';with tabs",
            "20;'\n';'Here is one line of\ttext that is going to be wrapped after 20 columns';"
                    + "'Here is one line\nof\ttext that is\ngoing to be wrapped\nafter 20 columns';with tab at wrapColumn",
            "30;'\n';flammable/inflammable;"
                    + "flammable/inflammable;no changes",
            "9;'\n';flammable/inflammable;"
                    + "'flammable\n/inflamma\nble';long word break",
            "15;'\n';                               ;"
                    + "'';line of spaces",
    })
    public void testWrap(int wrapLen, String newLineStr, String input, String expected, String message) {
        assertEquals(expected, LineWrapper.wrap(input, wrapLen, newLineStr), message);
    }

}

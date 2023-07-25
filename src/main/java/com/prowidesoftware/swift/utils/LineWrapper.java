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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * Static utility class to wrap character data into lines.
 *
 * @since 9.2.11
 * @author Markus Spann
 */
public final class LineWrapper {

    /**
     * Constructor hidden to prevent instantiation.
     */
    private LineWrapper() {}

    /**
     * Wraps the input sequence {@code _str} to the specified {@code _width} identifying words by space.<br>
     * Leading spaces on new lines are stripped, while trailing spaces are left unmodified.
     *
     * @param _str        the input sequence to be wrapped (may be null or empty)
     * @param _width      the width to wrap the words at (if less than 1 defaults to 1)
     * @param _newLineSeq the character sequence to insert for a new line,
     *                    {@code null} uses the system-dependent line separator string
     * @return a string wrapped into one or more lines, delimited by {@code _newLineSeq}, {@code null} if null input
     */
    public static String wrap(final CharSequence _str, final int _width, final CharSequence _newLineSeq) {
        List<String> wrapped = wrapIntoList(_str, _width);
        if (wrapped.isEmpty()) {
            return null;
        }
        CharSequence newLineSeq = _newLineSeq != null ? _newLineSeq : System.lineSeparator();
        return String.join(newLineSeq, wrapped);
    }

    /**
     * Wraps the input sequence {@code _str} into a list of lines of the specified {@code _width} identifying words by space.<br>
     * Leading spaces on new lines are stripped, while trailing spaces are left unmodified.
     *
     * @param _str      the input sequence to be wrapped (may be null or empty)
     * @param _width    the width to wrap the words at (if less than 1 defaults to 1)
     * @return an immutable list of lines, an empty list if input was {@code null}
     */
    public static List<String> wrapIntoList(final CharSequence _str, final int _width) {
        if (_str == null) {
            return Collections.emptyList();
        }

        final int width = Math.max(1, _width);
        final char wrapChar = ' ';
        final String str = lstripChar(_str, wrapChar);

        if (str.length() <= width) {
            return Collections.singletonList(str); // no wrapping required
        }

        final int strLen = str.length();
        final List<String> wrapped = new ArrayList<>(strLen / _width + 2);
        int offset = 0, idxSpace = -1, idxSpaceWrap = -1;

        while (offset < strLen) {
            String subStr = str.substring(offset, Math.min(offset + width + 1, strLen));
            idxSpace = subStr.indexOf(wrapChar);
            if (idxSpace > -1) {
                if (idxSpace == 0) {
                    offset += 1;
                    continue;
                }
                idxSpaceWrap = idxSpace + offset;
            }

            // only last line without leading spaces left
            if (strLen - offset <= width) {
                break;
            }

            while ((idxSpace = subStr.indexOf(wrapChar, idxSpace + 1)) > -1) {
                idxSpaceWrap = idxSpace + offset;
            }

            if (idxSpaceWrap >= offset) {
                wrapped.add(str.substring(offset, idxSpaceWrap));
                offset = idxSpaceWrap + 1;
            } else {
                // wrap long token
                wrapped.add(str.substring(offset, width + offset));
                offset += width;
            }
        }

        wrapped.add(str.substring(offset, strLen)); // add remainder
        return Collections.unmodifiableList(wrapped);
    }

    /**
     * Wraps the input sequence {@code _str} into a list of lines of the specified {@code _width}<br>
     * Leading spaces on first line are stripped, while the rest of the spaces are left unmodified.
     *
     * @param _str      the input sequence to be wrapped (may be null or empty)
     * @param _width    the width to wrap the words at (if less than 1 defaults to 1)
     * @return an immutable list of lines, an empty list if input was {@code null}
     */
    public static List<String> wrapIntoListStrict(final CharSequence _str, final int _width) {

        final char wrapChar = ' ';
        String leftStrippedString = lstripChar(_str, wrapChar);

        if (leftStrippedString == null) {
            return Collections.emptyList();
        }

        final int width = Math.max(1, _width);
        if (leftStrippedString.length() <= width) {
            return Collections.singletonList(leftStrippedString); // no wrapping required
        }

        final int strLen = leftStrippedString.length();
        final List<String> wrapped = new ArrayList<>(strLen / _width + 2);

        while (StringUtils.isNotBlank(leftStrippedString) && leftStrippedString.length() > width) {
            String subStr = leftStrippedString.substring(0, width);
            wrapped.add(subStr);
            leftStrippedString = leftStrippedString.substring(width);
        }

        if (StringUtils.isNotBlank(leftStrippedString)) {
            wrapped.add(leftStrippedString); // add remainder
        }
        return Collections.unmodifiableList(wrapped);
    }

    /**
     * Strips char {@code _c} off the left of input sequence {@code _str}.
     *
     * @param _str the input sequence to be stripped
     * @param _c   the char to strip
     * @return stripped input sequence, {@code null} if null input
     */
    private static String lstripChar(final CharSequence _str, final char _c) {
        if (_str == null) {
            return null;
        }
        int i = 0;
        while (i < _str.length() && _c == _str.charAt(i)) {
            i++;
        }
        return _str.toString().substring(i);
    }
}

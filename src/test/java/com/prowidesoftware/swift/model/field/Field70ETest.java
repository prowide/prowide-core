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
package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class Field70ETest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("70E", ":2134//goobar", "://goobar");
    }

    @Test
    public void testField70EString() {
        Field70E f = new Field70E();

        f = new Field70E(":2134//");
        assertEquals("2134", f.getComponent1());

        f = new Field70E(":2134//goobar");
        assertEquals("2134", f.getComponent1());
        assertEquals("goobar", f.getComponent2());

        f = new Field70E("://goobar");
        assertEquals("goobar", f.getComponent2());
    }

    @Test
    public void testField70EString2() {
        Field70E f = new Field70E("://goobar");
        assertEquals("goobar", f.getComponent2());
    }

    @Test
    public void testField70ELines() {
        Field70E f = new Field70E("://goobar");
        assertEquals("goobar", f.getComponent2());
        assertNull(f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());
        assertNull(f.getComponent7());
        assertNull(f.getComponent8());
        assertNull(f.getComponent9());
        assertNull(f.getComponent10());
        assertNull(f.getComponent11());

        f = new Field70E("://goobar\nAAAA");
        assertEquals("goobar", f.getComponent2());
        assertEquals("AAAA", f.getComponent3());
        assertNull(f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());
        assertNull(f.getComponent7());
        assertNull(f.getComponent8());
        assertNull(f.getComponent9());
        assertNull(f.getComponent10());
        assertNull(f.getComponent11());

        f = new Field70E("://goobar\nAAAA\nBBBB");
        assertEquals("goobar", f.getComponent2());
        assertEquals("AAAA", f.getComponent3());
        assertEquals("BBBB", f.getComponent4());
        assertNull(f.getComponent5());
        assertNull(f.getComponent6());
        assertNull(f.getComponent7());
        assertNull(f.getComponent8());
        assertNull(f.getComponent9());
        assertNull(f.getComponent10());
        assertNull(f.getComponent11());

        // remaining lines are ignored by parser
        f = new Field70E("://goobar\nAAAA\nBBBB\nCCCC\nDDDD\nEEEE\nFFFF\nGGGG\nHHHH\nIIII\nJJJJ\nKKKK");
        assertEquals("goobar", f.getComponent2());
        assertEquals("AAAA", f.getComponent3());
        assertEquals("BBBB", f.getComponent4());
        assertEquals("CCCC", f.getComponent5());
        assertEquals("DDDD", f.getComponent6());
        assertEquals("EEEE", f.getComponent7());
        assertEquals("FFFF", f.getComponent8());
        assertEquals("GGGG", f.getComponent9());
        assertEquals("HHHH", f.getComponent10());
        assertEquals("IIII", f.getComponent11());
    }

    /**
     * Test starting and trailing spaces are preserved when retrieving components
     */
    @Test
    public void testField70ELines_PreserveSpaces() {
        Field70E f = new Field70E(":PACO//The quick brown fox \n" + "jumps over the\n" + " the lazy dog");
        assertEquals("PACO", f.getQualifier());
        assertEquals("The quick brown fox ", f.getNarrativeLine1());
        assertEquals("jumps over the", f.getNarrativeLine2());
        assertEquals(" the lazy dog", f.getNarrativeLine3());
        assertNull(f.getNarrativeLine4());
        assertNull(f.getNarrativeLine5());
        assertNull(f.getNarrativeLine6());
        assertNull(f.getNarrativeLine7());
        assertNull(f.getNarrativeLine8());
        assertNull(f.getNarrativeLine9());
        assertNull(f.getNarrativeLine10());
    }

    @Test
    public void testJoinNarrative() {
        Field70E f = new Field70E(":TXNR//FOO\n BAR");

        assertEquals("FOO BAR", f.getNarrative());

        assertEquals(":TXNR//FOO BAR", String.join("", f.getLines()));

        assertEquals("FOO BAR", String.join("", f.getLines(2)));

        assertEquals("FOO\r\n BAR", StringUtils.substringAfter(f.getValue(), "//"));

        f.setComponent1(null);
        assertEquals("FOO\r\n BAR", StringUtils.substringAfter(f.getValue(), "://"));
    }
}

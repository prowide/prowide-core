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
package com.prowidesoftware.swift.model;

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.utils.SwiftMessageComparator;
import org.junit.jupiter.api.Test;

/**
 * test cases for block 4 API
 *
 * @author sebastian
 * @since 7.8.8
 */
public class SwiftBlock4Test {

    private final SwiftMessageComparator comp = new SwiftMessageComparator();

    /**
     * Null and Empty blocks
     */
    @Test
    public void testRemoveEmptySequencesNull() {
        assertNull(SwiftBlock4.removeEmptySequences(null));
        SwiftBlock4 b4 = SwiftBlock4.removeEmptySequences(new SwiftBlock4());
        assertTrue(b4.isEmpty());
    }

    /**
     * Nothing to remove
     */
    @Test
    public void testRemoveEmptySequencesNOP() {
        SwiftBlock4 b = new SwiftBlock4();
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("21", "FOO"));
        b.append(new Tag("16R", "FOO"));
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("16S", "FOO"));
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("15A", "FOO"));
        b.append(new Tag("20", "FOO"));
        SwiftBlock4 clean = SwiftBlock4.removeEmptySequences(b);
        assertTrue(comp.compareTagListBlock(b, clean));
    }

    /**
     * 16RS removed
     */
    @Test
    public void testRemoveEmptySequences16RS() {
        SwiftBlock4 b = new SwiftBlock4();
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("21", "FOO"));
        b.append(new Tag("16R", "FOO"));
        b.append(new Tag("16S", "FOO"));
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("15A", "FOO"));
        b.append(new Tag("20", "FOO"));
        SwiftBlock4 clean = SwiftBlock4.removeEmptySequences(b);
        assertFalse(comp.compareTagListBlock(b, clean));
        assertEquals(5, clean.size());
        assertEquals(b.getTag(0), clean.getTag(0));
        assertEquals(b.getTag(1), clean.getTag(1));
        assertEquals(b.getTag(4), clean.getTag(2));
        assertEquals(b.getTag(5), clean.getTag(3));
        assertEquals(b.getTag(6), clean.getTag(4));
    }

    /**
     * 15a removed
     */
    @Test
    public void testRemoveEmptySequences15a() {
        SwiftBlock4 b = new SwiftBlock4();
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("15A", ""));
        b.append(new Tag("15B", ""));
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("15C", ""));
        SwiftBlock4 clean = SwiftBlock4.removeEmptySequences(b);
        assertFalse(comp.compareTagListBlock(b, clean));
        assertEquals(3, clean.size());
        assertEquals(b.getTag(0), clean.getTag(0));
        assertEquals(b.getTag(2), clean.getTag(1));
        assertEquals(b.getTag(3), clean.getTag(2));
    }

    @Test
    public void testRemoveEmptySequences15a_2() {
        SwiftBlock4 b = new SwiftBlock4();
        b.append(new Tag("15A", ""));
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("15B", ""));
        b.append(new Tag("15C", ""));
        b.append(new Tag("15D", ""));
        b.append(new Tag("15E", ""));
        b.append(new Tag("17W", "Y"));
        SwiftBlock4 clean = SwiftBlock4.removeEmptySequences(b);
        assertFalse(comp.compareTagListBlock(b, clean));
        assertEquals("15A", clean.getTag(0).getName());
        assertEquals("20", clean.getTag(1).getName());
        assertEquals("15E", clean.getTag(2).getName());
        assertEquals("17W", clean.getTag(3).getName());
        assertEquals(4, clean.size());
    }

    /**
     * Null and Empty blocks
     */
    @Test
    public void testRepeatedBoundariesNull() {
        assertNull(SwiftBlock4.removeRepeatedBoundaries(null));
        SwiftBlock4 b4 = SwiftBlock4.removeRepeatedBoundaries(new SwiftBlock4());
        assertTrue(b4.isEmpty());
    }

    /**
     * Nothing to remove
     */
    @Test
    public void testRemoveRepeatedBoundariesNOP() {
        SwiftBlock4 b = new SwiftBlock4();
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("21", "FOO"));
        b.append(new Tag("16R", "FOO"));
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("16S", "FOO"));
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("15A", "FOO"));
        b.append(new Tag("20", "FOO"));
        SwiftBlock4 clean = SwiftBlock4.removeRepeatedBoundaries(b);
        assertTrue(comp.compareTagListBlock(b, clean));
    }

    /**
     * 16RS removed
     */
    @Test
    public void testRemoveRepeatedBoundaries16RS() {
        SwiftBlock4 b = new SwiftBlock4();
        b.append(new Tag("20", "AAA"));
        b.append(new Tag("16R", "FOO"));
        b.append(new Tag("16R", "FOO"));
        b.append(new Tag("16R", "FOO"));
        b.append(new Tag("21", "BBB"));
        b.append(new Tag("16R", "XXX"));
        b.append(new Tag("16S", "XXX"));
        b.append(new Tag("16S", "XXX"));
        b.append(new Tag("16R", "FOO"));
        b.append(new Tag("16R", "FEE"));
        b.append(new Tag("20", "FOO"));
        b.append(new Tag("16S", "AAA"));
        b.append(new Tag("16S", "XXX"));
        b.append(new Tag("20", "FOO"));
        assertEquals(14, b.size());
        SwiftBlock4 clean = SwiftBlock4.removeRepeatedBoundaries(b);
        assertFalse(comp.compareTagListBlock(b, clean));
        assertEquals(11, clean.size());
        assertEquals(b.getTag(0), clean.getTag(0));
        assertEquals(b.getTag(1), clean.getTag(1));
        // 2 entries of :16R:FOO" removed
        assertEquals(b.getTag(4), clean.getTag(2));
        assertEquals(b.getTag(5), clean.getTag(3));
        assertEquals(b.getTag(6), clean.getTag(4));
        // :16S:XXX" removed
        assertEquals(b.getTag(8), clean.getTag(5));
        assertEquals(b.getTag(9), clean.getTag(6));
        assertEquals(b.getTag(10), clean.getTag(7));
        assertEquals(b.getTag(11), clean.getTag(8));
        assertEquals(b.getTag(12), clean.getTag(9));
        assertEquals(b.getTag(13), clean.getTag(10));
    }
}

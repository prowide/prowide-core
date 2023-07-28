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

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetLineField70ETest {

    Field70E field70E;

    @BeforeEach
    public void setUp() {
        this.field70E = new Field70E(":PACO//The quick brown fox \n" + "jumps over the\n" + " the lazy dog");
    }

    @Test
    public void testGetLines() {
        List<String> lines = field70E.getLines();
        assertEquals(3, lines.size());
        assertEquals(":PACO//The quick brown fox ", lines.get(0));
        assertEquals("jumps over the", lines.get(1));
        assertEquals(" the lazy dog", lines.get(2));
    }

    @Test
    public void testGetLinesWithOffset() {
        List<String> lines = field70E.getLines(Field70E.NARRATIVE);
        assertEquals(3, lines.size());
        assertEquals("The quick brown fox ", lines.get(0));
        assertEquals("jumps over the", lines.get(1));
        assertEquals(" the lazy dog", lines.get(2));
    }

    @Test
    public void testGetLine() {
        assertEquals(":PACO//The quick brown fox ", field70E.getLine(1));
        assertEquals("jumps over the", field70E.getLine(2));
        assertEquals(" the lazy dog", field70E.getLine(3));
    }

    @Test
    public void testGetLineWithOffset() {
        assertEquals("The quick brown fox ", field70E.getLine(1, Field70E.NARRATIVE));
        assertEquals("jumps over the", field70E.getLine(2, Field70E.NARRATIVE));
        assertEquals(" the lazy dog", field70E.getLine(3, Field70E.NARRATIVE));
    }
}

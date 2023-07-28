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
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.prowidesoftware.swift.model.Tag;
import org.junit.jupiter.api.Test;

public class Field45BTest {

    @Test
    public void testAsTag() {
        Field45B field = new Field45B("/INSTR/Narrative text");
        Tag tag = field.asTag();
        assertEquals(Field45B.NAME, tag.getName());
        assertEquals("/INSTR/Narrative text", tag.getValue());
    }

    @Test
    public void testWithNull() {
        Field45B field = new Field45B((String) null);
        Narrative narrative = field.narrative();
        assertTrue(narrative.isEmpty());
    }
}

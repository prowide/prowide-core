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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class SwiftValueBlockTest {

    @Test
    public void getValuePart() {
        TestValueBlock b = new TestValueBlock();
        assertNull(b.getValuePart("", 0, 0));
        assertEquals("", b.getValuePart("Hello", 0, 0));
        assertEquals("H", b.getValuePart("Hello", 0, 1));
        assertEquals("Hello", b.getValuePart("Hello", 0, 10));
        assertEquals("ello", b.getValuePart("Hello", 1, 10));
        assertEquals("e", b.getValuePart("Hello", 1, 1));
        assertNull(b.getValuePart("Hello", 10, 1));
        assertEquals("EAKWAXXXU3003", b.getValuePart("O101AZADEAKWAXXXU3003", 8, 28));
    }

    static class TestValueBlock extends SwiftValueBlock {

        @Override
        protected void setBlockNumber(Integer blockNumber) {}

        @Override
        protected void setBlockName(String blockName) {}

        @Override
        public Integer getNumber() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }
    }
}

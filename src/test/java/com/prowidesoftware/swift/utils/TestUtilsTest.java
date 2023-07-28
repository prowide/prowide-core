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
package com.prowidesoftware.swift.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @since 8.0.2
 */
public class TestUtilsTest {

    @Test
    public void testPatchXpath() {
        assertEquals("/*[local-name()='Foo']", TestUtils.patch("/Foo"));
        assertEquals("/*[local-name()='Foo']/*[local-name()='Bar']", TestUtils.patch("/Foo/Bar"));
        assertEquals("/*[local-name()='Foo']/*[local-name()='Bar'][4]", TestUtils.patch("/Foo/Bar[4]"));
    }
}

/*
 * Copyright 2006-2026 Prowide
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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests for Field50R introduced in SRU2026 (Applicant in MT 700/705/707/710/720).
 * Pattern: &lt;CC&gt; (ISO country code, 2!a).
 */
public class Field50RTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("50R", "US", "GB", "AR");
    }

    @Test
    public void testParse() {
        Field50R f = new Field50R("US");
        assertEquals("US", f.getComponent1());
    }

    @Test
    public void testSetComponent() {
        Field50R f = new Field50R();
        f.setComponent1("FR");
        assertEquals("FR", f.getValue());
    }
}

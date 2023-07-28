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

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;
import org.junit.jupiter.api.Test;

public class Field95LTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("95L", ":ISSU//300300E1007142000089", ":ISSU//12345678AAAAAAAA99");
    }

    @Test
    public void testParser1() {
        Field95L f = new Field95L(":ISSU//300300E1007142000089");
        assertEquals("ISSU", f.getComponent1());
        assertEquals("300300E10071420000", f.getComponent2());
        assertEquals("89", f.getComponent3());
        assertEquals("300300E1007142000089", f.getLegalEntityIdentifier());
    }

    @Test
    public void testParser2() {
        Field95L f = new Field95L(":ISSU//300300E10071420000FOO");
        assertEquals("ISSU", f.getComponent1());
        assertEquals("300300E10071420000", f.getComponent2());
        assertEquals("FOO", f.getComponent3());
        assertEquals("300300E10071420000FOO", f.getLegalEntityIdentifier());
    }

    @Test
    public void testParser3() {
        Field95L f = new Field95L(":ISSU//ABCD1234");
        assertEquals("ISSU", f.getComponent1());
        assertEquals("ABCD1234", f.getComponent2());
        assertNull(f.getComponent3());
        assertEquals("ABCD1234", f.getLegalEntityIdentifier());
    }

    @Test
    public void testGetValueDisplay() {
        Field95L f = new Field95L(":ISSU//300300E1007142000089");
        assertNotNull(f.getValueDisplay(Locale.getDefault()));
        f = new Field95L(":ISSU//300300E100");
        assertNotNull(f.getValueDisplay(Locale.getDefault()));
        f = new Field95L(":ISSU//300300E1007142000089234234234");
        assertNotNull(f.getValueDisplay(Locale.getDefault()));
    }

    @Test
    public void test_setLegalEntityIdentifier() {

        Field95L f = new Field95L(":ISSU//ABCD1234");
        f.setLegalEntityIdentifier("300300E1007142000089");
        assertEquals("300300E1007142000089", f.getLegalEntityIdentifier());
        assertEquals("300300E10071420000", f.getComponent2());
        assertEquals("89", f.getComponent3());

        f = new Field95L(":ISSU//300300E1007142000089");
        f.setLegalEntityIdentifier("ABCD1234");
        assertEquals("ABCD1234", f.getComponent2());
        assertNull(f.getComponent3());
    }
}

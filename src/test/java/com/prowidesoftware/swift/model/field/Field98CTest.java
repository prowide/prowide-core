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

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class Field98CTest extends AbstractFieldTest {
    private static final transient java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(Field98CTest.class.getName());

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("98C", ":abc//12121212242424");
    }

    @Test
    public void testField98CString() {
        Field98C f;

        f = new Field98C("");
        assertTrue(StringUtils.isBlank(f.getComponent1()));
        assertTrue(StringUtils.isBlank(f.getComponent2()));
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C(":");
        assertTrue(StringUtils.isBlank(f.getComponent1()));
        assertTrue(StringUtils.isBlank(f.getComponent2()));
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C("/");
        log.fine("f:" + f);
        assertEquals("/", f.getComponent1());
        assertTrue(StringUtils.isBlank(f.getComponent2()));
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C("//");
        assertTrue(StringUtils.isBlank(f.getComponent1()));
        assertTrue(StringUtils.isBlank(f.getComponent2()));
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C("://");
        assertTrue(StringUtils.isBlank(f.getComponent1()));
        assertTrue(StringUtils.isBlank(f.getComponent2()));
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C(":/");
        assertEquals("/", f.getComponent1());
        assertTrue(StringUtils.isBlank(f.getComponent2()));
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C("///");
        assertTrue(StringUtils.isBlank(f.getComponent1()));
        assertEquals("/", f.getComponent2());
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C(":///");
        assertTrue(StringUtils.isBlank(f.getComponent1()));
        assertEquals("/", f.getComponent2());
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C(":abc//");
        assertEquals("abc", f.getComponent1());
        assertTrue(StringUtils.isBlank(f.getComponent2()));
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C(":abc//12");
        assertEquals("abc", f.getComponent1());
        assertEquals("12", f.getComponent2());
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C(":abc//1212121");
        assertEquals("abc", f.getComponent1());
        assertEquals("1212121", f.getComponent2());
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C(":abc//12121212");
        assertEquals("abc", f.getComponent1());
        assertEquals("12121212", f.getComponent2());
        assertTrue(StringUtils.isBlank(f.getComponent3()));

        f = new Field98C(":abc//12121212242424");
        assertEquals("abc", f.getComponent1());
        assertEquals("12121212", f.getComponent2());
        assertEquals("242424", f.getComponent3());
    }
}

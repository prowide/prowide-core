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

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * :4!c//35x[CRLF35x]0 -5
 */
public class Field70DTest {

    @Test
    public void testParse() {
        Field70D f = new Field70D(":REAS//INVALID FIELD 95P..DEAG//ABCDDEFFCU\n" + "S\n" + "/SETT/EUR145123");

        // get components API
        assertEquals("REAS", f.getComponent1());
        assertEquals("REAS", f.getQualifier());
        assertEquals("INVALID FIELD 95P..DEAG//ABCDDEFFCU", f.getComponent2());
        assertEquals("S", f.getComponent3());
        assertEquals("/SETT/EUR145123", f.getComponent4());

        // get Lines API
        assertEquals(":REAS//INVALID FIELD 95P..DEAG//ABCDDEFFCU", f.getLine(1));
        assertEquals("S", f.getLine(2));
        assertEquals("/SETT/EUR145123", f.getLine(3));

        assertEquals("ABCDDEFFCU", StringUtils.substringAfter(f.getComponent2(), "//"));
    }
}

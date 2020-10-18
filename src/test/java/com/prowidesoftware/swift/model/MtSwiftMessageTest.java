/*
 * Copyright 2006-2020 Prowide
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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtSwiftMessageTest {

    @Test
    public void testParseMt() {
        String fin = "{1:F01AGBLLT2XAXXX1012000002}{2:I399TESTARZZXXXXN}{3:{108:MYMUR123458}}{4:\n" +
                ":20:TEST\n" +
                ":79:AAAAA\n" +
                "-}";
        MtSwiftMessage mt = MtSwiftMessage.parse(fin);
        assertEquals("TEST", mt.getReference());
        assertEquals("MYMUR123458", mt.getMur());
    }

    @Test
    public void testParseAck() {
        String fin = "{1:F21AGBLLT2XAXXX0000000000}{4:{177:1903250612}{451:0}{108:MYMUR123458}}{1:F01AGBLLT2XAXXX1012000002}{2:I399TESTARZZXXXXN}{4:\n" +
                ":20:TEST\n" +
                ":79:AAAAA\n" +
                "-}";
        MtSwiftMessage mt = MtSwiftMessage.parse(fin);
        assertEquals("TEST", mt.getReference());
        assertEquals("MYMUR123458", mt.getMur());
    }

}

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
import static org.junit.jupiter.api.Assertions.assertNull;

import com.prowidesoftware.swift.model.field.OptionJPartyField.Codeword;
import org.junit.jupiter.api.Test;

/**
 * Test for API in the party field option J classes.
 */
public class OptionJPartyFieldTest {

    @Test
    public void testGetValueByCodeword() {
        TestPartyField f = new TestPartyField("/ABIC/CHASUS33\n" + "/NAME/12345xxxxx12345xxxxx12345+++++1234\n"
                + "/ACCT/12345xxxxx12345xxxxx12345/NETS/\n"
                + "/ADD1/12345xxxxx12345xxxxx12345+++++1234\n"
                + "5/ADD2/12345xxxxx12345xxxxx12345+++++123");
        assertNull(f.getValueByCodeword(Codeword.SVBY));
        assertNull(f.getValueByCodeword(Codeword.NETS));
        assertNull(f.getValueByCodeword(Codeword.SSIS));
        assertNull(f.getValueByCodeword(Codeword.LEIC));
        assertEquals("CHASUS33", f.getValueByCodeword(Codeword.ABIC));
        assertEquals("12345xxxxx12345xxxxx12345+++++1234", f.getValueByCodeword(Codeword.NAME));
        assertEquals("12345xxxxx12345xxxxx12345", f.getValueByCodeword(Codeword.ACCT));
        assertEquals("12345xxxxx12345xxxxx12345+++++12345", f.getValueByCodeword(Codeword.ADD1));
        assertEquals("12345xxxxx12345xxxxx12345+++++123", f.getValueByCodeword(Codeword.ADD2));
    }

    private static class TestPartyField extends OptionJPartyField {

        TestPartyField(String value) {
            super(value);
        }

        @Override
        public String validatorPattern() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }
    }
}

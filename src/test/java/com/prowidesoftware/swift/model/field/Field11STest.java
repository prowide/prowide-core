/*
 * Copyright 2006-2021 Prowide
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

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.prowidesoftware.swift.model.Tag;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class Field11STest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("11S",
                "195\n121212"
        );
    }

    @Test
    public void testSerialization2() {
        Field11S field11s = new Field11S();
        field11s.setComponent1("195");
        field11s.setComponent2(Calendar.getInstance());
        field11s.setComponent3(2);
        Tag tag = field11s.asTag();
        String val = tag.getValue();
        assertFalse(StringUtils.isBlank(val));
    }

}
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
package com.prowidesoftware.swift.model.mt.mt3xx;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prowidesoftware.swift.model.Tag;
import org.junit.jupiter.api.Test;

public class MT304Test {

    @Test
    public void test() {
        String msg = "{1:F01AAAAUS30AXXX0000123450}{2:O3041357180702BBBBGB44AXXX00000000001806281357N}{4:\n" + ":15A:\n"
                + ":20:REF11111\n"
                + ":22A:NEWT\n"
                + ":94A:ASET\n"
                + ":83J:/NAME/NA\n"
                + ":82J:/NAME/BBBBUS33XXX\n"
                + ":87A:CCCCUS33XXX\n"
                + ":15B:\n"
                + ":30T:20220415\n"
                + ":30V:20220415\n"
                + ":36:2,95\n"
                +
                // B1
                ":32B:HKD1947,\n"
                +
                // missing mandatory 53a
                ":57A:AAAAUS30XXX\n"
                +
                // B2
                ":33B:GYD46549,\n"
                + ":53A:EEEEUS33XXX\n"
                + ":56J:/ABIC/DDDDUS33XXX\n"
                + "/NAME/ksdjskjskf\n"
                + "/ADD1/ok\n"
                + "/CITY/lol\n"
                + ":57A:AAAAUS30XXX\n"
                + "-}";
        MT304 mt304 = new MT304(msg);
        MT304.SequenceB1 b1 = mt304.getSequenceB1();

        assertEquals(2, b1.size());
        assertEquals(new Tag("32B", "HKD1947,"), b1.getTags().get(0));
        assertEquals(new Tag("57A", "AAAAUS30XXX"), b1.getTags().get(1));

        MT304.SequenceB2 b2 = mt304.getSequenceB2();
        assertEquals(4, b2.size());
        assertEquals(new Tag("33B", "GYD46549,"), b2.getTags().get(0));
        assertEquals(new Tag("53A", "EEEEUS33XXX"), b2.getTags().get(1));
    }
}

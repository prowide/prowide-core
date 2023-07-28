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

import static org.junit.jupiter.api.Assertions.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SwiftBlock5Test {

    @Test
    public void testBlock5ToJson() {

        Tag t1 = new Tag();
        t1.setName("20");
        t1.setValue("REFERENCE");

        Tag t2 = new Tag();
        t2.setName("23B");
        t2.setValue("CRED");

        List<Tag> tagList = new ArrayList<>();
        tagList.add(t1);
        tagList.add(t2);

        SwiftBlock5 b5 = new SwiftBlock5(tagList);
        String s = b5.toJson();
        JsonObject o = JsonParser.parseString(s).getAsJsonObject();

        assertNotNull(o);
        assertEquals(2, o.get("tags").getAsJsonArray().size());
    }

    @Test
    public void testBlock5FromJson() {
        String json = "{\"tags\":[{\"name\":\"113\",\"value\":\"SEPA\"},{\"name\":\"108\",\"value\":\"ILOVESEPA\"}]}";
        SwiftBlock5 b5 = SwiftBlock5.fromJson(json);
        assertEquals(2, b5.getTags().size());
        assertEquals("SEPA", b5.getTagValue("113"));
        assertEquals("ILOVESEPA", b5.getTagValue("108"));
    }

    @Test
    public void testSetField() {
        SwiftBlock5 b5 = new SwiftBlock5();
        assertFalse(b5.getTag(SwiftBlock5Field.PDE).isPresent());
        b5.setTag(SwiftBlock5Field.PDE, null);
        assertTrue(b5.getTag(SwiftBlock5Field.PDE).isPresent());
        assertEquals("", b5.getTag(SwiftBlock5Field.PDE).get().getValue());
        b5.setTag(SwiftBlock5Field.PDE, "1234");
        assertEquals("1234", b5.getTag(SwiftBlock5Field.PDE).get().getValue());
        b5.setTag(SwiftBlock5Field.PDE, "2345");
        assertEquals("2345", b5.getTag(SwiftBlock5Field.PDE).get().getValue());
        assertEquals(1, b5.size());
    }

    @Test
    public void testSetPDE() {
        SwiftBlock5 b5 = new SwiftBlock5();
        assertFalse(b5.getTag(SwiftBlock5Field.PDE).isPresent());
        b5.setPDE();
        assertTrue(b5.getTag(SwiftBlock5Field.PDE).isPresent());
        assertEquals("", b5.getTag(SwiftBlock5Field.PDE).get().getValue());
    }
}

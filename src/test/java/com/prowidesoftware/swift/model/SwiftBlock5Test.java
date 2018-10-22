/*
 * Copyright 2006-2018 Prowide
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Test;

import com.prowidesoftware.swift.utils.SwiftMessageComparator;


public class SwiftBlock5Test {

    @Test
    public void testBlock5ToJson(){

        Tag t1 = new Tag();
        t1.setName("20");
        t1.setValue("REFERENCE");

        Tag t2 = new Tag();
        t2.setName("23B");
        t2.setValue("CRED");

        List<Tag> tagList = new ArrayList<Tag>();
        tagList.add(t1);
        tagList.add(t2);

        SwiftBlock4 b4 = new SwiftBlock4(tagList);
        String s = b4.toJson();
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(s).getAsJsonObject();

        assertNotNull(o);
        assertTrue(o.get("tags").getAsJsonArray().size()==2);
    }

    @Test
    public void testBlock5FromJson(){
        String json = "{\"tags\":[{\"name\":\"113\",\"value\":\"SEPA\"},{\"name\":\"108\",\"value\":\"ILOVESEPA\"}]}";
        SwiftBlock5 b5 = SwiftBlock5.fromJson(json);
        assertTrue(b5.getTags().size()==2);
        assertEquals("SEPA", b5.getTagValue("113"));
        assertEquals("ILOVESEPA", b5.getTagValue("108"));
    }
}

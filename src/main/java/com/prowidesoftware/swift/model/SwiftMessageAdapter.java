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

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SwiftMessageAdapter implements JsonDeserializer<SwiftMessage>, JsonSerializer<SwiftMessage> {

    @Override
    public JsonElement serialize(SwiftMessage src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String ts = dateFormat.format(Calendar.getInstance().getTime());
        object.addProperty("timestamp", ts);
        object.addProperty("version", SwiftMessage.JSON_VERSION);

        JsonObject objectBlocks = new JsonObject();
        objectBlocks.add("block1",context.serialize(src.getBlock1()));
        objectBlocks.add("block2",context.serialize(src.getBlock2(), SwiftBlock2.class));
        objectBlocks.add("block3",context.serialize(src.getBlock3()));
        objectBlocks.add("block4",context.serialize(src.getBlock4()));
        objectBlocks.add("block5",context.serialize(src.getBlock5()));
        //TODO agregar user blocks

        object.add("data", objectBlocks);

        return object;
    }

    @Override
    public SwiftMessage deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonArray = jsonElement.getAsJsonObject().get("data").getAsJsonObject();

        SwiftBlock1 block1 = jsonDeserializationContext.deserialize(jsonArray.get("block1"),SwiftBlock1.class);

        SwiftBlock2 block2 = jsonDeserializationContext.deserialize(jsonArray.get("block2"),SwiftBlock2.class);

        SwiftBlock3 block3 = jsonDeserializationContext.deserialize(jsonArray.get("block3"),SwiftBlock3.class);

        SwiftBlock4 block4 = jsonDeserializationContext.deserialize(jsonArray.get("block4"),SwiftBlock4.class);

        SwiftBlock5 block5 = jsonDeserializationContext.deserialize(jsonArray.get("block5"),SwiftBlock5.class);

        List<SwiftBlockUser> blockUsers = new ArrayList<>();

        if (jsonArray.get("userBlocks") != null){
            for (JsonElement blockUser : jsonArray.get("userBlocks").getAsJsonArray()) {
                blockUsers.add(jsonDeserializationContext.deserialize(blockUser,SwiftBlockUser.class));
            }
        }

        SwiftMessage sm = new SwiftMessage();

        if (block1 != null){
            sm.addBlock(block1);
        }

        if (block2 != null){
            sm.addBlock(block2);
        }

        if (block3 != null){
            sm.addBlock(block3);
        }

        if (block4 != null){
            sm.addBlock(block4);
        }

        if (block5 != null){
            sm.addBlock(block5);
        }

        if (blockUsers.size() > 0){
            sm.setUserBlocks(blockUsers);
        }

        return sm;
    }
}

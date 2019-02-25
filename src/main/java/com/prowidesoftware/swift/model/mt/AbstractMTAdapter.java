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

package com.prowidesoftware.swift.model.mt;

import com.google.gson.*;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.Field;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Json serialization for AbstractMT and subclasses using Gson.
 * @since 7.10.3
 */
public class AbstractMTAdapter implements JsonSerializer<AbstractMT>, JsonDeserializer<AbstractMT> {

    private static final String BLOCK1_FINAL_NAME = "basicHeaderBlock";
    private static final String BLOCK2_FINAL_NAME = "applicationHeaderBlock";
    private static final String BLOCK3_FINAL_NAME = "userHeaderBlock";
    private static final String BLOCK4_FINAL_NAME = "textBlock";
    private static final String BLOCK5_FINAL_NAME = "trailerBlock";

    @Override
    public JsonElement serialize(AbstractMT src, Type typeOfSrc, JsonSerializationContext context) {
        String json = src.m.toJson();
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(json).getAsJsonObject();
        JsonObject response = new JsonObject();

        response.addProperty("type","MT");

        if (src.m.getBlock1() != null) {
            // default serialization from SwiftMessage
            response.add(BLOCK1_FINAL_NAME, o.get("data").getAsJsonObject().get("block1"));
        }

        if (src.m.getBlock2() != null) {
            // default serialization from SwiftMessage
            response.add(BLOCK2_FINAL_NAME, o.get("data").getAsJsonObject().get("block2"));
        }

        if (src.m.getBlock3() != null && !src.m.getBlock3().getTags().isEmpty()) {
            setFinalBlockNameAndFields(response,"block3", src.m.getBlock3().getTags());
        }

        if (src.m.getBlock4() != null && !src.m.getBlock4().getTags().isEmpty()) {
            setFinalBlockNameAndFields(response,"block4", src.m.getBlock4().getTags());
        }

        if (src.m.getBlock5() != null && !src.m.getBlock5().getTags().isEmpty()) {
            // default serialization from SwiftMessage with tags renamed to fields
            JsonArray tags = o.get("data").getAsJsonObject().get("block5").getAsJsonObject().get("tags").getAsJsonArray();
            JsonObject trailer = new JsonObject();
            trailer.add("fields", tags);
            response.add(BLOCK5_FINAL_NAME, trailer);
        }

        return response;
    }

    @Override
    public AbstractMT deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        SwiftMessage swiftMessage = new SwiftMessage();

        SwiftBlock1 block1 = jsonDeserializationContext.deserialize(jsonObject.get(BLOCK1_FINAL_NAME), SwiftBlock1.class);
        if (block1 != null) {
            swiftMessage.addBlock(block1);
        }

        SwiftBlock2 block2 = jsonDeserializationContext.deserialize(jsonObject.get(BLOCK2_FINAL_NAME), SwiftBlock2.class);
        if (block2 != null) {
            swiftMessage.addBlock(block2);
        }

        JsonElement userHeaderBlock = jsonObject.get(BLOCK3_FINAL_NAME);
        if (userHeaderBlock != null) {
            JsonElement fields = userHeaderBlock.getAsJsonObject().get("fields");
            if (fields != null) {
                SwiftBlock3 block3 = new SwiftBlock3();
                block3 = (SwiftBlock3) setFieldsOnBlock(fields, block3);
                swiftMessage.addBlock(block3);
            }
        }

        JsonElement textBlock = jsonObject.get(BLOCK4_FINAL_NAME);
        if (textBlock != null) {
            JsonElement fields = textBlock.getAsJsonObject().get("fields");
            if (fields != null) {
                SwiftBlock4 block4 = new SwiftBlock4();
                block4 = (SwiftBlock4) setFieldsOnBlock(fields, block4);
                swiftMessage.addBlock(block4);
            }
        }

        JsonElement trailerBlock = jsonObject.get(BLOCK5_FINAL_NAME);
        if (trailerBlock != null) {
            JsonElement fields = trailerBlock.getAsJsonObject().get("fields");
            if (fields != null) {
                SwiftBlock5 block5 = new SwiftBlock5();
                for (JsonElement element : fields.getAsJsonArray()) {
                    Tag tag = new Tag();
                    tag.setName(element.getAsJsonObject().get("name").getAsString());
                    // trailer tags can have null value (for example PDE field)
                    JsonElement valueElement = element.getAsJsonObject().get("value");
                    if (valueElement != null) {
                        tag.setValue(valueElement.getAsString());
                    }
                    block5.append(tag);
                }
                swiftMessage.addBlock(block5);
            }
        }

        return swiftMessage.toMT();
    }

    private SwiftTagListBlock setFieldsOnBlock(JsonElement fields, SwiftTagListBlock block) {
        for (Field field : parseFields(fields)) {
            block.append(field);
        }
        return block;
    }

    /**
     * Parses the JSON array with fields into specific Field instances
     */
    private static List<Field> parseFields(JsonElement fieldsElement) {
        List<Field> fields = new ArrayList<Field>();
        for (JsonElement element : fieldsElement.getAsJsonArray()) {
            Field field = Field.fromJson(element.toString());
            if (field != null) {
                fields.add(field);
            }
        }
        return fields;
    }


    private void setFinalBlockNameAndFields(JsonObject response, String blockName, List<Tag> tags) {
        String finalBlockName = BLOCK4_FINAL_NAME;
        if (blockName.equals("block3")) {
            finalBlockName = BLOCK3_FINAL_NAME;
        } else if(blockName.equals("block5")){
            finalBlockName = BLOCK5_FINAL_NAME;
        }
        JsonArray fields = getFieldsFromTags(tags);
        JsonObject block = new JsonObject();
        block.add("fields", fields);
        response.add(finalBlockName,block);
    }

    /**
     * Converts the tag elements into fields, and the fields into json
     */
    private JsonArray getFieldsFromTags(List<Tag> tags){
        JsonArray fields = new JsonArray();
        JsonParser parser = new JsonParser();
        for (Tag tag : tags) {
            String json = tag.asField().toJson();
            JsonObject jsonObj = parser.parse(json).getAsJsonObject();
            fields.add(jsonObj);
        }
        return fields;
    }

}


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


public class SwiftBlock2Adapter implements JsonSerializer<SwiftBlock2>, JsonDeserializer<SwiftBlock2> {

    private static final String DIRECTION = "direction";

    @Override
    public JsonElement serialize(final SwiftBlock2 swiftBlock2, Type type, final JsonSerializationContext jsonSerializationContext) {

        JsonElement object = jsonSerializationContext.serialize(swiftBlock2);

        String direction = "";

        if (swiftBlock2.isInput()){
            direction = "I";
        } else {
            direction = "O";
        }

        object.getAsJsonObject().addProperty(DIRECTION,direction);

        return object;
    }

    @Override
    public SwiftBlock2 deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        if ((jsonObject.get(DIRECTION) != null && jsonObject.get(DIRECTION).getAsString().equals("O"))){
            return getSwiftBlock2OutputObject(jsonObject);
        } else {
            // defult to INPUT
            return getSwiftBlock2InputObject(jsonObject);
        }
    }

    private SwiftBlock2Output getSwiftBlock2OutputObject(JsonObject jsonObject) {
        SwiftBlock2Output swiftBlock2Output = new SwiftBlock2Output();

        setSwiftBlock2Properties(swiftBlock2Output,jsonObject);

        // specific data for OUTPUT

        if (jsonObject.get("senderInputTime") != null){
            swiftBlock2Output.setSenderInputTime(jsonObject.get("senderInputTime").getAsString());
        }

        if (jsonObject.get("MIRDate") != null){
            swiftBlock2Output.setMIRDate(jsonObject.get("MIRDate").getAsString());
        }

        if (jsonObject.get("MIRLogicalTerminal") != null){
            swiftBlock2Output.setMIRLogicalTerminal(jsonObject.get("MIRLogicalTerminal").getAsString());
        }

        if (jsonObject.get("MIRSessionNumber") != null){
            swiftBlock2Output.setMIRSessionNumber(jsonObject.get("MIRSessionNumber").getAsString());
        }

        if (jsonObject.get("MIRSequenceNumber") != null){
            swiftBlock2Output.setMIRSequenceNumber(jsonObject.get("MIRSequenceNumber").getAsString());
        }

        if (jsonObject.get("receiverOutputDate") != null){
            swiftBlock2Output.setReceiverOutputDate(jsonObject.get("receiverOutputDate").getAsString());
        }

        if (jsonObject.get("receiverOutputTime") != null){
            swiftBlock2Output.setReceiverOutputTime(jsonObject.get("receiverOutputTime").getAsString());
        }

        return swiftBlock2Output;
    }

    private SwiftBlock2Input getSwiftBlock2InputObject(JsonObject jsonObject) {
        SwiftBlock2Input swiftBlock2Input = new SwiftBlock2Input();

        setSwiftBlock2Properties(swiftBlock2Input,jsonObject);

        // specific data for INPUT

        if (jsonObject.get("receiverAddress") != null){
            swiftBlock2Input.setReceiverAddress(jsonObject.get("receiverAddress").getAsString());
        }

        if (jsonObject.get("deliveryMonitoring") != null){
            swiftBlock2Input.setDeliveryMonitoring(jsonObject.get("deliveryMonitoring").getAsString());
        }

        if (jsonObject.get("obsolescencePeriod") != null){
            swiftBlock2Input.setObsolescencePeriod(jsonObject.get("obsolescencePeriod").getAsString());
        }

        return swiftBlock2Input;
    }

    private static void setSwiftBlock2Properties(SwiftBlock2 sb,JsonObject jsonObject) {
        if (jsonObject.get("messageType") != null){
            sb.setMessageType(jsonObject.get("messageType").getAsString());
        }

        if (jsonObject.get("messagePriority") != null){
            sb.setMessagePriority(jsonObject.get("messagePriority").getAsString());
        }
    }

}

package com.prowidesoftware.swift.model.mx;

import com.google.gson.*;
import com.prowidesoftware.swift.model.MxId;

import java.lang.reflect.Type;



/**
 * {@link AbstractMX} JSON serialization and deserialization implementation based on Gson.
 * <p>
 * The implementation relieas on the default object serialization that will fill the JSON structure
 * with all content from the subclasses model (MX model in Integrator). On top of the default subclass
 * data, this serializer will add the namespace and identifier (needed to clearly identify the message
 * type in the generic deserialization)
 *
 * @since 7.10.2
 */
class AbstractMXAdapter implements JsonSerializer<AbstractMX>, JsonDeserializer<AbstractMX> {

    private static final String IDENTIFIER = "identifier";

    @Override
    public JsonElement serialize(final AbstractMX mx, Type type, final JsonSerializationContext context) {
        // default serialization
        // in Integrator this will fill the JSON structure with the complete MX message model
        JsonObject object = context.serialize(mx).getAsJsonObject();
        object.addProperty("@xmlns", mx.getNamespace());
        object.addProperty(IDENTIFIER, mx.getMxId().id());
        return object;
    }

    @Override
    public AbstractMX deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException  {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(IDENTIFIER);
        if (prim == null) {
            throw new JsonParseException("Missing "+ IDENTIFIER + " in JSON structure");
        }
        MxId id = new MxId(prim.getAsString());

        Class<?> klass = null;
        try {
            String className = "com.prowidesoftware.swift.model.mx.Mx" + id.camelized();
            klass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException("Cannot find MX implementation for "+e.getMessage());
        }
        return context.deserialize(json, klass);
    }

}

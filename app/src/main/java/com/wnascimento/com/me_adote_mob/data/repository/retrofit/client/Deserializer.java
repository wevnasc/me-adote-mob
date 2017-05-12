package com.wnascimento.com.me_adote_mob.data.repository.retrofit.client;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class Deserializer<T> implements JsonDeserializer<T> {
    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        if (jsonObject.has("_embedded")) {
            JsonElement content = jsonObject.getAsJsonObject("_embedded").get("pets");
            return new Gson().fromJson(content, typeOfT);
        }

        return new Gson().fromJson(jsonObject, typeOfT);
    }
}

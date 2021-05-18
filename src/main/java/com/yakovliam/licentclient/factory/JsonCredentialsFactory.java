package com.yakovliam.licentclient.factory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.yakovliam.licentclient.client.ClientCredentials;

public class JsonCredentialsFactory implements Factory<ClientCredentials, JsonElement> {

    @Override
    public JsonElement build(ClientCredentials clientCredentials) {
        // create json object
        JsonObject object = new JsonObject();

        object.addProperty("id", clientCredentials.getId());
        object.addProperty("token", clientCredentials.getToken());

        return object;
    }
}

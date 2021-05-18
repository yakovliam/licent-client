package com.yakovliam.licentclient.client.request;

import com.google.gson.JsonParser;
import com.yakovliam.licentclient.client.ClientCredentials;
import com.yakovliam.licentclient.client.request.function.AsyncRequestFunction;
import com.yakovliam.licentclient.client.request.function.SyncRequestFunction;
import com.yakovliam.licentclient.factory.JsonCredentialsFactory;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class LicentRequestService implements Service {

    /**
     * Do authentication
     *
     * @param url               url
     * @param clientCredentials credentials
     * @param function          function
     */
    public void async(AsyncRequestFunction function, String url, ClientCredentials clientCredentials) {
        // do request
        Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(new JsonCredentialsFactory().build(clientCredentials))
                .asJson().ifFailure((r) -> function.callError(new LicentResponseData(JsonParser.parseString(r.getBody().getObject().toString()).getAsJsonObject())))
                .ifSuccess((r) -> function.callSuccess(new LicentResponseData(JsonParser.parseString(r.getBody().getObject().toString()).getAsJsonObject())));
    }

    /**
     * Do authentication
     *
     * @param url               url
     * @param clientCredentials credentials
     * @param function          function
     * @return data
     */
    public LicentResponseData sync(SyncRequestFunction function, String url, ClientCredentials clientCredentials) {
        // do request
        JSONObject object = Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(new JsonCredentialsFactory().build(clientCredentials))
                .asJson().getBody().getObject();
        return new LicentResponseData(JsonParser.parseString(object.toString()).getAsJsonObject());
    }
}

package com.yakovliam.licentclient.client.request;

import com.google.gson.JsonObject;

public class LicentResponseData {

    /**
     * Raw request response data
     */
    private final JsonObject data;

    /**
     * Construct response data
     *
     * @param data data
     */
    public LicentResponseData(JsonObject data) {
        this.data = data;
    }

    /**
     * Returns reason
     *
     * @return reason
     */
    public String getReason() {
        return data.has("reason") ? data.get("reason").getAsString() : "None";
    }

    /**
     * Was the request successful?
     *
     * @return success
     */
    public boolean wasSuccessful() {
        return data.has("success") && data.get("success").getAsBoolean();
    }
}

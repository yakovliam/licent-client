package com.yakovliam.licentclient.client.request.function;

import com.yakovliam.licentclient.client.LicentClient;
import com.yakovliam.licentclient.client.request.LicentRequestService;
import com.yakovliam.licentclient.client.request.LicentResponseData;

public class SyncRequestFunction implements RequestFunction {

    /**
     * Client
     */
    public LicentClient client;

    /**
     * Construct function
     *
     * @param client client
     */
    public SyncRequestFunction(LicentClient client) {
        this.client = client;
    }

    /**
     * Actually runs the authentication process
     */
    public LicentResponseData authenticate() {
        return new LicentRequestService().sync(this, this.client.getStartUrl(), this.client.getClientCredentials());
    }
}

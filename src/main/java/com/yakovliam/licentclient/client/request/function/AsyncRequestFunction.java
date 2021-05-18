package com.yakovliam.licentclient.client.request.function;

import com.yakovliam.licentclient.client.LicentClient;
import com.yakovliam.licentclient.client.request.LicentRequestService;
import com.yakovliam.licentclient.client.request.LicentResponseData;

import java.util.function.Consumer;

public class AsyncRequestFunction extends RequestFunction {

    /**
     * Error consumer
     */
    private Consumer<LicentResponseData> errorConsumer;

    /**
     * Success consumer
     */
    private Consumer<LicentResponseData> successConsumer;

    /**
     * Client
     */
    public LicentClient client;

    /**
     * Construct function
     *
     * @param client client
     */
    public AsyncRequestFunction(LicentClient client) {
        this.client = client;
    }

    /**
     * On error
     *
     * @param errorConsumer error consumer
     * @return self
     */
    public AsyncRequestFunction error(Consumer<LicentResponseData> errorConsumer) {
        // if already initialized, throw error
        if (this.errorConsumer != null)
            throw new RuntimeException("OnError consumer is already initialized. Please don't initialize it again");

        this.errorConsumer = errorConsumer;

        return this;
    }

    /**
     * On success
     *
     * @param successConsumer success consumer
     * @return self
     */
    public AsyncRequestFunction success(Consumer<LicentResponseData> successConsumer) {
        // if already initialized, throw error
        if (this.successConsumer != null)
            throw new RuntimeException("OnSuccess consumer is already initialized. Please don't initialize it again");

        this.successConsumer = successConsumer;

        return this;
    }

    /**
     * Actually runs the authentication process
     */
    public void authenticate() {
        new LicentRequestService().async(this, this.client.getStartUrl(), this.client.getClientCredentials());
    }

    /**
     * Called when the error happens
     *
     * @param data data
     */
    public void callError(LicentResponseData data) {
        if (this.errorConsumer != null)
            this.errorConsumer.accept(data);
    }

    /**
     * Called when the success happens
     *
     * @param data data
     */
    public void callSuccess(LicentResponseData data) {
        if (this.successConsumer != null)
            this.successConsumer.accept(data);
    }
}

package com.yakovliam.licentclient.client;

import com.yakovliam.licentclient.client.request.function.AsyncRequestFunction;
import com.yakovliam.licentclient.client.request.function.SyncRequestFunction;

public final class LicentClient {

    /**
     * Start url
     */
    private final String startUrl;

    /**
     * Credentials
     */
    private final ClientCredentials clientCredentials;

    /**
     * Construct licent client
     *
     * @param startUrl          start url
     * @param clientCredentials credentials
     */
    public LicentClient(String startUrl, ClientCredentials clientCredentials) {
        this.startUrl = startUrl;
        this.clientCredentials = clientCredentials;
    }

    /**
     * Construct licent client
     *
     * @param startUrl start url
     * @param id       id
     * @param token    token
     */
    public LicentClient(String startUrl, String id, String token) {
        this.startUrl = startUrl;
        this.clientCredentials = new ClientCredentials(id, token);
    }

    /**
     * Start async authentication process
     * <p>
     * This builds a new request function, then executes when ready
     *
     * @return request function
     */
    public AsyncRequestFunction async() {
        return new AsyncRequestFunction(this);
    }

    /**
     * Start sync authentication process
     * <p>
     * This builds a new request function, then executes when ready
     *
     * @return request function
     */
    public SyncRequestFunction sync() {
        return new SyncRequestFunction(this);
    }

    /**
     * Returns url
     *
     * @return url
     */
    public String getStartUrl() {
        return startUrl;
    }

    /**
     * Returns credentials
     *
     * @return credentials
     */
    public ClientCredentials getClientCredentials() {
        return clientCredentials;
    }
}

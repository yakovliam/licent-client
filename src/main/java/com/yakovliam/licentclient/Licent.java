package com.yakovliam.licentclient;

import com.yakovliam.licentclient.client.ClientCredentials;
import com.yakovliam.licentclient.client.LicentClient;

public class Licent {

    /**
     * Default start url
     */
    private static final String DEFAULT_START_URL = "https://api.yakovliam.com/clients/start/";

    /**
     * Client
     */
    private final LicentClient client;

    /**
     * Construct client
     *
     * @param startUrl          start url
     * @param clientCredentials credentials
     */
    public Licent(String startUrl, ClientCredentials clientCredentials) {
        // instantiate client
        this.client = new LicentClient(startUrl, clientCredentials);
    }

    /**
     * Construct client
     *
     * @param clientCredentials credentials
     */
    public Licent(ClientCredentials clientCredentials) {
        // instantiate client
        this.client = new LicentClient(DEFAULT_START_URL, clientCredentials);
    }

    /**
     * Construct client
     *
     * @param client client
     */
    public Licent(LicentClient client) {
        // instantiate client
        this.client = client;
    }

    /**
     * Returns client
     *
     * @return client
     */
    public LicentClient client() {
        return this.client;
    }
}

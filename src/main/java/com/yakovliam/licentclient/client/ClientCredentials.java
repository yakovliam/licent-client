package com.yakovliam.licentclient.client;

public class ClientCredentials {

    /**
     * Id
     */
    private String id;

    /**
     * Token
     */
    private String token;

    /**
     * Construct credentials
     *
     * @param id    id
     * @param token token
     */
    public ClientCredentials(String id, String token) {
        this.id = id;
        this.token = token;
    }

    /**
     * Construct credentials
     */
    public ClientCredentials() {
    }

    /**
     * Returns id
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id
     *
     * @param id id
     * @return id
     */
    public ClientCredentials setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Gets token
     *
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token
     *
     * @param token token
     */
    public ClientCredentials setToken(String token) {
        this.token = token;
        return this;
    }
}

package com.yakovliam.licentclient;

import com.yakovliam.licentclient.client.ClientCredentials;
import com.yakovliam.licentclient.client.request.LicentResponseData;

public class ExampleImplementation {

    public void auth() {
        new Licent(new ClientCredentials("id", "token"))
                .client()
                .async()
                .success((data) -> {
                    System.out.println("You successfully logged into my program!");
                })
                .error((data) -> {
                    System.out.println("You failed to log into my program!");
                })
                .authenticate();

        LicentResponseData data = new Licent(new ClientCredentials("id", "token"))
                .client()
                .sync()
                .authenticate();

        if (!data.wasSuccessful()) {
            System.out.println("You failed to log into my program!");
        } else {
            System.out.println("You successfully logged into my program!");
        }
    }
}

package com.phillippko.analytics.client;

import com.phillippko.analytics.dto.MessageOutgoingDto;
import feign.Response;
import org.junit.Test;

import java.net.URI;

class MessageClientTest {
    private final FeignMessageClient feignMessageClient;

    MessageClientTest(FeignMessageClient feignMessageClient) {
        this.feignMessageClient = feignMessageClient;
    }

    @Test
    void sendTest() {
        URI uri = URI.create("https://httpbin.org/anything");
        MessageOutgoingDto message = new MessageOutgoingDto("test message");
        Response response = feignMessageClient.send(uri, message);
        System.out.println(response.body());
    }
}
package com.phillippko.analytics.client;

import com.phillippko.analytics.dto.MessageOutgoingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URI;


@FeignClient(name = "messages", url = "placeholder")
public interface MessageClient {

    @PostMapping("")
    void send(URI baseUrl, MessageOutgoingDto message);
}

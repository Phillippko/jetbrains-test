package com.phillippko.analytics.client;

import com.phillippko.analytics.dto.MessageOutgoingDto;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URI;


@FeignClient(name = "messages", url = "")
public interface FeignMessageClient {

    @PostMapping("")
    Response send(URI baseUrl, MessageOutgoingDto message);
}

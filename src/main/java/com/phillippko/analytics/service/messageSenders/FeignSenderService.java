package com.phillippko.analytics.service.messageSenders;

import com.phillippko.analytics.client.FeignMessageClient;
import com.phillippko.analytics.domain.Recipient;
import com.phillippko.analytics.dto.MessageOutgoingDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@Qualifier("rest-message-service")
@Service
public class FeignSenderService implements SenderService {
    private final FeignMessageClient feignMessageClient;

    public void sendMessage(MessageOutgoingDto message, List<Recipient> recipients) {
        recipients
                .forEach(recipient -> {
                    URI uri = URI.create(recipient.getUrl());
                    feignMessageClient.send(uri, message);
                });
    }


}

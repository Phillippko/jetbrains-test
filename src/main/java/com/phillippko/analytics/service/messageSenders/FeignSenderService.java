package com.phillippko.analytics.service.messageSenders;

import com.phillippko.analytics.client.FeignMessageClient;
import com.phillippko.analytics.dto.MessageOutgoingDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Qualifier("rest-message-service")
@Service
public class FeignSenderService implements SenderService {
    private final FeignMessageClient feignMessageClient;
    public List<String> sendMessage(MessageOutgoingDto message) {
        return message.getRecipients().stream()
                .map(recipient ->
                        feignMessageClient.send(
                                URI.create(recipient.getUrl()),
                                message))
                .collect(Collectors.toList());
    }


}

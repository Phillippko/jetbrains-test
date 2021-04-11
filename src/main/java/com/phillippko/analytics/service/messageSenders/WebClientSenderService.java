package com.phillippko.analytics.service.messageSenders;

import com.phillippko.analytics.dto.MessageOutgoingDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Qualifier("rest-message-service")
@Service
public class WebClientSenderService implements SenderService {
    private final WebClient client = WebClient.create();

    public List<String> sendMessage(MessageOutgoingDto message) {
        return message.getRecipients().stream()
                .map(recipient -> client.post()
                        .uri(recipient.getUrl())
                        .body(
                                Mono.just(message),
                                MessageOutgoingDto.class)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block())
                .collect(Collectors.toList());
    }


}

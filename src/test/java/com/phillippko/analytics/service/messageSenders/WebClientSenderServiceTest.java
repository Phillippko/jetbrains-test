package com.phillippko.analytics.service.messageSenders;

import com.phillippko.analytics.domain.Recipient;
import com.phillippko.analytics.dto.MessageOutgoingDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class WebClientSenderServiceTest {
    @Autowired
    private WebClientSenderService webClientSenderService;

    @Test
    void shouldReceiveEchoInResponse() {
        String messageText = "test message";
        List<Recipient> recipients = Collections.singletonList(new Recipient("https://httpbin.org/anything"));
        MessageOutgoingDto message = new MessageOutgoingDto(messageText, recipients);
        String response = webClientSenderService.sendMessage(message).get(0);
        assert (response.contains("test message"));
    }
}
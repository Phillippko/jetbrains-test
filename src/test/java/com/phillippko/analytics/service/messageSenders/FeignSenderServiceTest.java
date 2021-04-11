package com.phillippko.analytics.service.messageSenders;

import com.phillippko.analytics.domain.Recipient;
import com.phillippko.analytics.dto.MessageOutgoingDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class FeignSenderServiceTest {
    @Autowired
    private FeignSenderService feignSenderService;

    @Test
    void sendMessage() {
        String messageText = "test";
        List<Recipient> recipients = Collections.singletonList(new Recipient("httpbin.org/anything"));
        MessageOutgoingDto message = new MessageOutgoingDto(messageText, recipients);
        feignSenderService.sendMessage(message);
    }
}
package com.phillippko.analytics.controller;

import com.phillippko.analytics.dto.MessageIncomingDto;
import com.phillippko.analytics.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Setter
public class MessageController {
    private final MessageService messageService;

    @PostMapping("send-message")
    void sendMessage(@RequestBody MessageIncomingDto messageIncomingDto) {
        messageService.processMessage(messageIncomingDto);
    }
}

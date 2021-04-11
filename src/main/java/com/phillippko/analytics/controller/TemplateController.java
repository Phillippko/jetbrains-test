package com.phillippko.analytics.controller;

import com.phillippko.analytics.dto.MessageIncomingDto;
import com.phillippko.analytics.dto.TemplateDto;
import com.phillippko.analytics.service.TemplateService;
import com.phillippko.analytics.service.messageSenders.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TemplateController {
    private final TemplateService templateService;
    private List<MessageService> messageServices;


    @PostMapping("template")
    void postMapping(@RequestBody TemplateDto templateDto) {
        templateService.addTemplate(templateDto);
    }

    @PostMapping("send-message")
    void sendMessage(@RequestBody MessageIncomingDto messageIncomingDto) {
        messageServices.forEach(messageService -> messageService.sendMessage(messageIncomingDto));
    }
}

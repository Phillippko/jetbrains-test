package com.phillippko.analytics.controller;

import com.phillippko.analytics.dto.MessageIncomingDto;
import com.phillippko.analytics.dto.TemplateDto;
import com.phillippko.analytics.service.MessageService;
import com.phillippko.analytics.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TemplateController {
    private final TemplateService templateService;
    private MessageService messageService;

    @Value("${message-service:feign-message-service}")
    private String messageServiceType;

    @Autowired
    void setMessageService(ApplicationContext context) {
        messageService = (MessageService) context.getBean(messageServiceType);
    }

    @PostMapping("template")
    void postMapping(@RequestBody TemplateDto templateDto) {
        templateService.addTemplate(templateDto);
    }

    @PostMapping("send-message")
    void sendMessage(@RequestBody MessageIncomingDto messageIncomingDto) {
        messageService.sendMessage(messageIncomingDto);
    }
}

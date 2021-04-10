package com.phillippko.analytics.controllers;

import com.phillippko.analytics.dto.MessageIncomingDto;
import com.phillippko.analytics.dto.TemplateDto;
import com.phillippko.analytics.service.MessageService;
import com.phillippko.analytics.service.TemplateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TemplateController {
    private final TemplateService templateService;
    private final MessageService messageService;

    @PostMapping("template")
    void postMapping(@RequestBody TemplateDto templateDto) {

        templateService.addTemplate(templateDto);
    }

    @PostMapping("send-message")
    void sendMessage(@RequestBody MessageIncomingDto messageIncomingDto) {
        messageService.sendMessage(messageIncomingDto);
    }
}

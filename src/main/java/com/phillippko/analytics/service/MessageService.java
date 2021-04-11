package com.phillippko.analytics.service;

import com.phillippko.analytics.domain.Template;
import com.phillippko.analytics.dto.MessageIncomingDto;
import com.phillippko.analytics.dto.MessageOutgoingDto;
import com.phillippko.analytics.service.messageSenders.SenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MessageService {
    private final TemplateService templateService;
    private final List<SenderService> senderServices;

    public void processMessage(MessageIncomingDto messageIncomingDto) {
        Template template = templateService.getTemplateById(
                messageIncomingDto.getTemplateId());

        MessageOutgoingDto message = templateService.fillTemplate(
                template, messageIncomingDto.getVariables());

        senderServices
                .forEach(senderService ->
                        senderService.sendMessage(message, template.getRecipients()));
    }

}

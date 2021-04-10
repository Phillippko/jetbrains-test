package com.phillippko.analytics.service;

import com.phillippko.analytics.client.MessageClient;
import com.phillippko.analytics.domain.Template;
import com.phillippko.analytics.dto.MessageIncomingDto;
import com.phillippko.analytics.dto.MessageOutgoingDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;

@AllArgsConstructor
@Service("feign-message-service")
public class FeignMessageService implements MessageService {
    private final MessageClient messageClient;
    private final TemplateService templateService;

    public void sendMessage(MessageIncomingDto messageIncomingDto) {
        Template template = templateService.getTemplateById(
                messageIncomingDto.getTemplateId());
        String messageText = templateService.fillTemplate(
                template, messageIncomingDto.getVariables());
        MessageOutgoingDto message = new MessageOutgoingDto(messageText);
        template.getRecipients().forEach(recipient -> {
            URI uri = URI.create(recipient.getUrl());
            messageClient.send(uri, message);
        });
    }


}

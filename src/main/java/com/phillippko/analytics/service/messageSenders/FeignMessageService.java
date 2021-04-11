package com.phillippko.analytics.service.messageSenders;

import com.phillippko.analytics.client.FeignMessageClient;
import com.phillippko.analytics.domain.Template;
import com.phillippko.analytics.dto.MessageIncomingDto;
import com.phillippko.analytics.dto.MessageOutgoingDto;
import com.phillippko.analytics.service.TemplateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.URI;

@AllArgsConstructor
@Qualifier("rest-message-service")
@Service
public class FeignMessageService implements MessageService {
    private final FeignMessageClient feignMessageClient;
    private final TemplateService templateService;

    public void sendMessage(MessageIncomingDto messageIncomingDto) {
        Template template = templateService.getTemplateById(
                messageIncomingDto.getTemplateId());

        String messageText = templateService.fillTemplate(
                template, messageIncomingDto.getVariables());

        MessageOutgoingDto message = new MessageOutgoingDto(messageText);

        template.getRecipients()
                .forEach(recipient -> {
                    URI uri = URI.create(recipient.getUrl());
                    feignMessageClient.send(uri, message);
                });
    }


}

package com.phillippko.analytics.service;

import com.phillippko.analytics.domain.Recipient;
import com.phillippko.analytics.domain.Template;
import com.phillippko.analytics.dto.MessageOutgoingDto;
import com.phillippko.analytics.dto.TemplateDto;
import com.phillippko.analytics.repository.RecipientRepository;
import com.phillippko.analytics.repository.TemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TemplateService {
    private final TemplateRepository templateRepository;
    private final RecipientRepository recipientRepository;

    public void addTemplate(TemplateDto templateDto) {
        Template template = new Template();
        template.setTemplate(templateDto.template);
        template.setTemplateId(templateDto.templateId);
        template.setRecipients(new ArrayList<>());
        templateDto.recipients.forEach(recipientUrl -> {
            Recipient recipient = new Recipient();
            recipient.setUrl(recipientUrl);
            recipientRepository.save(recipient);
            template.getRecipients().add(recipient);

        });
        templateRepository.save(template);
    }

    public Template getTemplateById(String templateId) {
        return templateRepository.getOne(templateId);
    }

    public MessageOutgoingDto fillTemplate(Template template, List<Map<String, String>> variables) {
        String resultText = template.getTemplate();
        for (Map<String, String> variable : variables) {
            String variableName = variable.keySet().iterator().next();
            resultText = resultText.replaceAll(("\\$" + variableName + "\\$"), variable.get(variableName));
        }

        return new MessageOutgoingDto(resultText);
    }
}

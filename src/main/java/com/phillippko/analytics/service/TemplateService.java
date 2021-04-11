package com.phillippko.analytics.service;

import com.phillippko.analytics.domain.Recipient;
import com.phillippko.analytics.domain.Template;
import com.phillippko.analytics.dto.MessageOutgoingDto;
import com.phillippko.analytics.dto.TemplateDto;
import com.phillippko.analytics.repository.TemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TemplateService {
    private final TemplateRepository templateRepository;

    public void addTemplate(TemplateDto templateDto) {
        List<Recipient> recipients = templateDto.recipients
                .stream()
                .map(Recipient::new)
                .collect(Collectors.toList());

        templateRepository.save(
                Template.builder()
                        .templateId(templateDto.templateId)
                        .template(templateDto.template)
                        .recipients(recipients)
                        .build());
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

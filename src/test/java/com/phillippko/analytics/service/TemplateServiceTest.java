package com.phillippko.analytics.service;

import com.phillippko.analytics.domain.Template;
import com.phillippko.analytics.dto.TemplateDto;
import com.phillippko.analytics.repository.TemplateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TemplateServiceTest {
    @Autowired
    private TemplateService templateService;
    @Autowired
    TemplateRepository templateRepository;

    private final String dummyRecipient = "some.recipient.url/pshe";
    private final String dummyTemplateId = "Internship";
    private final String index = "1";
    private final String teamName = "Analytics";
    private final String dummyTemplate = "тест для $teamName$ номер $index$";

    @Test
    void fillTemplate() {
        Template template = new Template();
        template.setTemplate(dummyTemplate);
        List<Map<String, String>> variables = new ArrayList<>();
        Map<String, String> variable = new HashMap<>();
        variable.put("index", index);
        variables.add(variable);

        variable = new HashMap<>();
        variable.put("teamName", teamName);
        variables.add(variable);
        String result = templateService.fillTemplate(template, variables);
        assert (result.equals("тест для " + teamName + " номер " + index));
    }


    @Test
    @Transactional
    void addTemplate() {
        TemplateDto templateDto = new TemplateDto();
        templateDto.templateId = dummyTemplateId;
        templateDto.template = dummyTemplate;
        templateDto.recipients = new ArrayList<>();
        templateDto.recipients.add(dummyRecipient);
        templateService.addTemplate(templateDto);
        Template template = templateService.getTemplateById(dummyTemplateId);
        assert (template.getTemplate().equals(dummyTemplate));
        assert (template.getTemplateId().equals(dummyTemplateId));
        assert (template.getRecipients().get(0).getUrl().equals(dummyRecipient));
    }
}
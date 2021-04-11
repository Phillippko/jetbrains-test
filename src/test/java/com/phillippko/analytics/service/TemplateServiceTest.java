package com.phillippko.analytics.service;

import com.phillippko.analytics.domain.Template;
import com.phillippko.analytics.dto.MessageIncomingDto;
import com.phillippko.analytics.dto.TemplateDto;
import com.phillippko.analytics.repository.TemplateRepository;
import org.junit.jupiter.api.BeforeAll;
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

    private static final String dummyRecipient = "some.recipient.url/pshe";
    private static final String dummyTemplateId = "Internship";
    private static final String index = "1";
    private static final String teamName = "Analytics";
    private static final String dummyTemplate = "тест для $teamName$ номер $index$";
    private static TemplateDto templateDto;

    @BeforeAll
    static void createDummyTemplateDto() {
        templateDto = new TemplateDto();
        templateDto.templateId = dummyTemplateId;
        templateDto.template = dummyTemplate;
        templateDto.recipients = new ArrayList<>();
        templateDto.recipients.add(dummyRecipient);
    }

    @Test
    @Transactional
    void fillTemplate() {
        templateService.addTemplate(templateDto);

        List<Map<String, String>> variables = new ArrayList<>();
        Map<String, String> variable = new HashMap<>();
        variable.put("index", index);
        variables.add(variable);

        variable = new HashMap<>();
        variable.put("teamName", teamName);
        variables.add(variable);
        MessageIncomingDto message = new MessageIncomingDto(dummyTemplateId, variables);

        String result = templateService.fillTemplate(message).getMessage();


        assert (result.equals("тест для " + teamName + " номер " + index));
    }


    @Test
    @Transactional
    void addTemplate() {
        templateService.addTemplate(templateDto);
        Template template = templateService.getTemplateById(dummyTemplateId);
        assert (template.getTemplate().equals(dummyTemplate));
        assert (template.getTemplateId().equals(dummyTemplateId));
        assert (template.getRecipients().get(0).getUrl().equals(dummyRecipient));
    }
}
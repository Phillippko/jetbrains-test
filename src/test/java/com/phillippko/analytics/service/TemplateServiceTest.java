package com.phillippko.analytics.service;

import com.phillippko.analytics.domain.Template;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TemplateServiceTest {
    @Autowired
    private TemplateService templateService;


    @Test
    void fillTemplate() {
        Template template = new Template();
        template.setTemplate("тест для $teamName$ номер $index$");
        List<Map<String, String>> variables = new ArrayList<>();
        Map<String, String> variable = new HashMap<>();
        variable.put("index", "1");
        variables.add(variable);

        variable = new HashMap<>();
        variable.put("teamName", "Analytics");
        variables.add(variable);
        String result = templateService.fillTemplate(template, variables);
        assert (result.equals("тест для Analytics номер 1"));
    }
}
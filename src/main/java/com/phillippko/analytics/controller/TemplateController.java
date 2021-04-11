package com.phillippko.analytics.controller;

import com.phillippko.analytics.dto.TemplateDto;
import com.phillippko.analytics.service.TemplateService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Setter
public class TemplateController {
    private final TemplateService templateService;

    @PostMapping("template")
    void postMapping(@RequestBody TemplateDto templateDto) {
        templateService.addTemplate(templateDto);
    }

}
